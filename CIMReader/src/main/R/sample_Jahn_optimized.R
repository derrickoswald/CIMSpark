# assumes the file is on hdfs:
# bash-4.1# hdfs dfs -mkdir /data/
# bash-4.1# hdfs dfs -put /opt/data/CGMES_v2.4.15_RealGridTestConfiguration_EQ_v2.xml /data/

# assumes the user is created if necessary:
# bash-4.1# groupadd supergroup
# bash-4.1# useradd derrick
# bash-4.1# usermod --append --groups supergroup derrick

# record the load time
pre = proc.time ()

# set up the Spark system
Sys.setenv (YARN_CONF_DIR="/home/derrick/spark/spark-2.4.4-bin-hadoop2.7/conf")
Sys.setenv (SPARK_HOME="/home/derrick/spark/spark-2.4.4-bin-hadoop2.7")
library (SparkR, lib.loc = c (file.path (Sys.getenv("SPARK_HOME"), "R", "lib")))
sparkR.session ("spark://sandbox:7077", "Sample", sparkJars = c ("/home/derrick/code/CIMSpark/CIMReader/target/CIMReader-2.11-2.4.4-4.1.2.jar"), sparkEnvir = list (spark.driver.memory="1g", spark.executor.memory="4g", spark.serializer="org.apache.spark.serializer.KryoSerializer"))

begin = proc.time ()

# read the data file and process topologically and make the edge RDD
elements = sql ("create temporary view elements using ch.ninecode.cim options (path 'hdfs://sandbox:8020/data/CGMES_v2.4.15_RealGridTestConfiguration_EQ_v2.xml', StorageLevel 'MEMORY_AND_DISK_SER', ch.ninecode.cim.make_edges 'true', ch.ninecode.cim.do_topo 'false', ch.ninecode.cim.do_topo_islands 'false', 'ch.ninecode.cim.do_join' 'false')")
head (sql ("select * from elements")) # triggers evaluation

post = proc.time ()

# read the edges RDD as an R data frame
edges = sql ("select * from edges")
redges = SparkR::collect (edges, stringsAsFactors=FALSE)

finish = proc.time ()

# show timing
print (paste ("setup", as.numeric (pre[3] - begin[3])))
print (paste ("read", as.numeric (post[3] - pre[3])))
print (paste ("redges", as.numeric (finish[3] - post[3])))

# example to read an RDD directly
terminals = sql ("select * from Terminal")
rterminals = SparkR::collect (terminals, stringsAsFactors=FALSE)

# example to read a three-way join of RDD
switch = sql ("select s.sup.sup.sup.sup.mRID mRID, s.sup.sup.sup.sup.aliasName aliasName, s.sup.sup.sup.sup.name name, s.sup.sup.sup.sup.description description, open, normalOpen no, l.CoordinateSystem cs, p.xPosition, p.yPosition from Switch s, Location l, PositionPoint p where s.sup.sup.sup.Location = l.sup.mRID and s.sup.sup.sup.Location = p.Location and p.sequenceNumber = 0")
rswitch = SparkR::collect (switch, stringsAsFactors=FALSE)

library (igraph)

pre = proc.time ()

# keep only non-self connected and non-singly connected edges
r2edges = redges[redges$id_seq_1 != redges$id_seq_2 & !is.na (redges$id_seq_1) & !is.na (redges$id_seq_2), ]

# Generate the graph
graph = graph_from_data_frame (r2edges, directed = F)

# record the start of processing time
begin = proc.time ()

# Get all the busbars
kanten = as_data_frame (graph, what = "vertices")
sammelschienen = kanten[substr (kanten$name, 1, 3)=="SAM",]

# Alle Trafos
trafos = as_data_frame (graph, what = "edges")
trafos = trafos[substr (trafos$name, 1, 3)=="TRA",]

# data.frame for saving the results
allbusbars = data.frame (name = character(), distance = character (), stringsAsFactors = FALSE)

# for each busbar
for (sam in sammelschienen)
{
    # remember the starting time
    start = proc.time ()
    
    # convert the sam into a vector, so that the following function can be executed
    pruefungKnotenIDs = as.vector(sam)
    
    # find all vertices reachable from sam 
    pruefungKnotenliste = subcomponent(graph, pruefungKnotenIDs)
    
    # create a subgraph (teilnetzgraph) out of the idenified vertices
    teilnetzgraph= induced.subgraph(graph, pruefungKnotenliste, impl="auto")
#     plot(teilnetzgraph)

    # calculate the distance of all vertices to the busbar (this could be the busbar in the station 
    # or in the distribution box) in the subgraph
    distMatrix = shortest.paths (teilnetzgraph, v = sam, to = V (teilnetzgraph), weights = E (teilnetzgraph)$length)

    # connect the vertices with the distance-attribute
    V(teilnetzgraph)$distance = as.numeric (distMatrix[1,])
    
    # get a data.frame of all vertices of the subgraph
    vertices = as_data_frame (teilnetzgraph, what = "vertices")

    # get only the house connections
    haeuser = vertices[substr (vertices$name, 1, 3) == "HAS",]

    # calculate the mean of all house connections
    d = mean (haeuser$distance)
    
    # add it to the result data.frame
    busbar = data.frame (name = sam, distance = d, stringsAsFactors = FALSE)
    allbusbars = rbind (allbusbars, busbar)
    
    # show some activity
    finish = proc.time ()
    print (paste (sam, as.numeric (finish[3] - start[3])))
}

# output the summary
end = proc.time ()
print (paste ("setup", as.numeric (begin[3] - pre[3])))
print (paste ("total computation", as.numeric (end[3] - begin[3])))
print ("results in data.frame allbusbars")
sparkR.stop ()
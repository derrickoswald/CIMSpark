# record the load time
pre = proc.time ()

# set up the Spark system
Sys.setenv (HADOOP_HOME="/usr/lib/hadoop")
Sys.setenv (HADOOP_CONF_DIR="/etc/hadoop/conf")
Sys.setenv (YARN_CONF_DIR="/usr/local/spark-1.6.0-bin-hadoop2.6/conf")
Sys.setenv (SPARK_HOME="/usr/local/spark-1.6.0-bin-hadoop2.6")
library (SparkR, lib.loc = c(file.path(Sys.getenv("SPARK_HOME"), "R", "lib")))
sc = sparkR.init ("yarn-client", "CIM_Sample", sparkJars = c ("/hdfs/data-sources/NetIntel/CIMReader-2.10-1.4.1-0.6.0.jar"), sparkEnvir = list (spark.driver.memory="8g", spark.executor.memory="8g"))
sqlContext = sparkRSQL.init (sc)

# read the data file and make the edge graph
# file:///opt/data/dump_ews.xml
# hdfs://root@ec2-52-30-238-126.eu-west-1.compute.amazonaws.com:9000/data/dump_ews.xml
# hdfs:/user/root/dump_ews.xml
elements = sql (sqlContext, "create temporary table elements using ch.ninecode.cim options (path 'hdfs:/data-sources/NetIntel/dump_bkw.xml')")
head (sql (sqlContext, "select * from elements"))
edges = sql (sqlContext, "select * from edges")
redges = SparkR::collect (edges, stringsAsFactors=FALSE) # instead of redges = SparkR::as.data.frame (edges)

library (igraph)

# pre = proc.time ()

# keep only non-self connected and non-singly connected edges 
r2edges = redges[redges$id_seq_1 != redges$id_seq_2 & redges$id_seq_2 != "", ]

# Generate the graph
graph = graph_from_data_frame (r2edges, directed = F)

# record the start of processing time
begin = proc.time ()

# Get all the busbars
kanten = as_data_frame (graph, what = "vertices")
sammelschienen = kanten[substr (kanten$name, 1, 3)=="SAM",]

# Alle Trafos
trafos = kanten[substr (kanten$name, 1, 3)=="TRA",]

# data.frame for saving the results
allbusbars = data.frame (name = character(), distance = character (), stringsAsFactors = FALSE)


# for each busbar
for (sam in sammelschienen)
{
    # remember the starting time
#     start = proc.time ()
    
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
#     finish = proc.time ()
#     print (paste (sam, as.numeric (finish[3] - start[3])))
}

# output the summary
end = proc.time ()
print (paste ("setup", as.numeric (begin[3] - pre[3])))
print (paste ("total computation", as.numeric (end[3] - begin[3])))
print ("results in data.frame allbusbars")

# end

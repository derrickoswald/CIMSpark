# record the load time
pre = proc.time ()

# assumes the file is on hdfs:
# bash-4.1# hdfs dfs -mkdir /data/
# bash-4.1# hdfs dfs -put /opt/data/dump_ews.xml /data/

# assumes the user is created:
# bash-4.1# groupadd supergroup
# bash-4.1# useradd derrick
# bash-4.1# usermod --append --groups supergroup derrick

# set up the Spark system
Sys.setenv (YARN_CONF_DIR="/home/derrick/spark-1.6.0-bin-hadoop2.6/conf")
Sys.setenv (SPARK_HOME="/home/derrick/spark-1.6.0-bin-hadoop2.6")
library (SparkR, lib.loc = c(file.path(Sys.getenv("SPARK_HOME"), "R", "lib")))
sc = sparkR.init (sparkJars = c ("/home/derrick/code/CIMScala/target/CIMScala-2.10-1.6.0-1.7.1.jar"), sparkEnvir=list(spark.driver.memory="4g"))
sqlContext = sparkRSQL.init (sc)

# read the data file and make the edge graph
elements = sql (sqlContext, "create temporary table elements using ch.ninecode.cim options (path 'hdfs:/data/dump_ews.xml')")
head (sql (sqlContext, "select * from elements"))

# get the transformers - to get their container
transformers = sql (sqlContext, "select * from edges where id_equ like '_transformer%'")
rtransformers = SparkR::as.data.frame (transformers)

edges = sql (sqlContext, "select * from edges")
redges = SparkR::as.data.frame (edges)

library (igraph)

# for (container in rtransformers[, c("container")])
# {
#     print (container)
#     abgaenge = sql (sqlContext, paste0 ("select * from edges where container = '", container, "' and (id_seq_1 like 'ABG%' or id_seq_2 like 'ABG%')"))
#     rabgaenge = SparkR::as.data.frame (abgaenge)
#     for (equ in rabgaenge[, c ("id_equ")])
#         print (paste0 ("  ", equ))
# }
# 
# xx = sql (sqlContext, "select t.container, a.id_equ from (select * from edges where id_equ like '_transformer%')  t join (select * from edges where id_seq_1 like 'ABG%' or id_seq_2 like 'ABG%') a on t.container = a.container")
# rxx = SparkR::as.data.frame (xx)

# keep only non-self connected and non-singly connected edges 
r2edges = redges[redges$id_seq_1 != redges$id_seq_2 & redges$id_seq_2 != "", ]

# Generate the graph
graph = graph_from_data_frame (r2edges, directed = F)

# record the start of processing time
begin = proc.time ()

# Get all the busbars
sammelschienen = as_data_frame (graph, what = "vertices")
sammelschienen = sammelschienen[substr (sammelschienen$name, 1, 3)=="SAM",]

# data.frame for saving the results
allbusbars = data.frame (name = character(), distance = character (), stringsAsFactors = FALSE)

# for each busbar
for (sam in sammelschienen)
{
    # remember the starting time
    start = proc.time ()

    # calculate the distance of all vertices to the busbar in the station
    distMatrix = shortest.paths (graph, v = sam, to = V (graph), weights = E (graph)$length)

    # connect the vertices with the distance-attribute
    V(graph)$distance = as.numeric (distMatrix[1,])
    
    # get a data.frame of all vertices
    vertices = as_data_frame (graph, what = "vertices")
    
    # identify all "Abgaenge" in the station (distance < 10m)
    abgaenge = vertices[substr (vertices$name, 1, 3) == "ABG" & vertices$distance < 10,]
    
    # data.frame for saving the results
    alldirecthas = data.frame (name = character(), distance = character (), stringsAsFactors = FALSE)

    # calculate it in the other direction (things connected to the Abgaenge)
    abgaenge = abgaenge[, "name"]
    for (abgang in abgaenge)
    {
        # get all connected edges
        con_edges = E(graph)[adj (abgang)]

        # get all connected vertices
        con_vertices = as.data.frame (V(graph)[adj (con_edges)]$name, stringsAsFactors = FALSE)
        names (con_vertices) = c ("name")

        # get only the house connections
        haeuser = as.character (con_vertices[substr (con_vertices$name, 1, 3) == "HAS",])

        # process each house
        for (has in haeuser)
        {
            directhas = data.frame (name = has, distance = vertices[vertices$name == has, "distance"], stringsAsFactors = FALSE)
            alldirecthas = rbind (alldirecthas, directhas)
        }
    }

    # calculate the mean of all direct house connections
    d = mean (alldirecthas$distance)
    
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

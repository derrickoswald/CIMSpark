# record the load time
begin = proc.time ()

# set up the Spark system
Sys.setenv (YARN_CONF_DIR="/usr/local/spark-2.0.2/conf/")
Sys.setenv (SPARK_HOME="/usr/local/spark-2.0.2/")
Sys.setenv (LANG="en_US.utf8")
library (SparkR, lib.loc = c(file.path(Sys.getenv("SPARK_HOME"), "R", "lib")))
sparkR.session (sparkJars = c ("/opt/code/CIMScala-2.11-2.0.1-1.9.0.jar"), sparkEnvir = list (spark.driver.memory="2g", spark.executor.memory="4g", spark.driver.maxResultSize="1g", spark.ui.showConsoleProgress="false"))
sparkR.session.setLogLevel ("WARN")

# record the start time
pre = proc.time ()

# read the data file and process topologically and make the edge RDD
elements = sql ("create temporary view elements using ch.ninecode.cim options (path 'hdfs:/data/NIS_CIM_Export_sias_current_20161220_Brügg bei Biel_V11.rdf', StorageLevel 'MEMORY_AND_DISK_SER', ch.ninecode.cim.make_edges 'true', ch.ninecode.cim.do_topo 'false', ch.ninecode.cim.do_topo_islands 'false')")
head (sql ("select * from elements")) # triggers evaluation

# record the time spent creating the redges data frame
post = proc.time ()

# read the edges RDD as an R data frame
edges = sql ("select * from edges")
redges = SparkR::collect (edges, stringsAsFactors=FALSE)

# save the redges data frame
save ("redges", file="./NIS_CIM_Export_sias_current_20161220_Brügg bei Biel_V11.RData")

finish = proc.time ()

# show timing
print (paste ("setup", as.numeric (pre[3] - begin[3])))
print (paste ("read", as.numeric (post[3] - pre[3])))
print (paste ("redges", as.numeric (finish[3] - post[3])))


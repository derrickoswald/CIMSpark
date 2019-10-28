# record the load time
begin = proc.time ()

# set up the Spark system
Sys.setenv (YARN_CONF_DIR="/opt/hadoop/etc/hadoop")
Sys.setenv (SPARK_HOME="/opt/spark")
Sys.setenv (LANG="en_US.utf8")
library (SparkR, lib.loc = c(file.path(Sys.getenv("SPARK_HOME"), "R", "lib")))
sparkR.session (sparkJars = c ("/disktemp/transfer/CIMReader-2.11-2.4.4-4.1.0.jar"), sparkEnvir = list (spark.driver.memory="16g", spark.executor.memory="16g", spark.driver.maxResultSize="2g"))
sparkR.session.setLogLevel ("WARN")

# record the start time
pre = proc.time ()

# read the data file and process topologically and make the edge RDD
elements = sql ("create temporary view elements using ch.ninecode.cim options (path 'hdfs:/data/CGMES_v2.4.15_RealGridTestConfiguration_EQ_v2.xml', StorageLevel 'MEMORY_AND_DISK_SER', ch.ninecode.cim.make_edges 'true', ch.ninecode.cim.do_topo 'false', ch.ninecode.cim.do_topo_islands 'false', ch.ninecode.cim.split_maxsize '256000000')")
head (sql ("select * from elements")) # triggers evaluation

# record the time spent creating the redges data frame
post = proc.time ()

# read the edges RDD as an R data frame
edges = sql ("select * from edges")
redges = SparkR::collect (edges, stringsAsFactors=FALSE)

# save the redges data frame
save ("redges", file="./CGMES_v2.4.15_RealGridTestConfiguration_EQ_v2.RData")

finish = proc.time ()

# show timing
print (paste ("setup", as.numeric (pre[3] - begin[3])))
print (paste ("read", as.numeric (post[3] - pre[3])))
print (paste ("redges", as.numeric (finish[3] - post[3])))


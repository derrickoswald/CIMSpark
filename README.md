CIMReader
======

Spark access to Common Information Model (CIM) files as RDD and Hive SQL.

A good overview presentation is [Network Analysis and Simulation using Apache Spark on Compute Clusters](https://derrickoswald.github.io/CIMSparkPresentation/index.html?audio), or [without the audio tracks](https://derrickoswald.github.io/CIMSparkPresentation).

# Overview

This program reads in CIM files which are a 
standard interchange format based on IEC standards 61968 & 61970
(see [CIM users group](http://cimug.ucaiug.org/default.aspx) for additional details)
and produces a Spark Resilient Distributed Dataset (RDD) for each CIM class.

![CIMReader Overview](https://rawgit.com/derrickoswald/CIMReader/master/img/Overview.svg "Overview diagram")

These RDDs can be manipulated by native Spark programs written in
[Scala, Java or Python](http://spark.apache.org/docs/latest/programming-guide.html),
or can be accessed via [SparkR](http://spark.apache.org/docs/latest/sparkr.html) in R.

The RDDs are also exposed as Hive2 tables using Thrift for legacy JDBC access.

The CIM model as implemented in CIMReader is described in [CIM Model](Model.md)
and is described in detail in the [ScalaDoc](https://derrickoswald.github.io/CIMReader).

# Architecture

The architecture follows the sample code from [Databricks](https://databricks.com/blog/2015/01/09/spark-sql-data-sources-api-unified-data-access-for-the-spark-platform.html).

![CIMReader Architecture](https://rawgit.com/derrickoswald/CIMReader/master/img/Architecture.svg "High level architecture diagram")

# Building

Assuming the Scala Build Tool [sbt](http://www.scala-sbt.org/) or Maven [mvn](https://maven.apache.org/) is installed, to package CIMReader (make a jar file) follow these steps:

* Change to the top level CIMReader directory:
```
cd CIMReader
```
* Invoke the package command:
```
sbt package
```
or
```
mvn package
```

This should produce a jar file in the target/ directory.

**NOTE: If you use sbt, the jar file will be in a subdirectory of target/ based on the version of the Scala library used,
e.g. target/scala-2.11, and the name will not have upper/lowercase preserved, that is, the name will be cimscala_2.11-??.** 

## Jar Naming Scheme

The name of the jar file (e.g. CIMReader-2.11-2.0.2-2.0.1.jar) is comprised of a fixed name ("CIMReader") followed by three [semantic version numbers](http://semver.org/), each separated by a dash.

The first version number is the Scala library version. This follows [Scala libray naming semantics](https://github.com/scalacenter/scaladex).

The second version number is the [Spark version](https://spark.apache.org/downloads.html).

The third version number is the CIMReader version number, which is set (hardcoded) in the pom.xml and build.sbt files.

# Sample Interactive Usage

Normally the CIMReader jar file is used as a component in a larger application.
One can, however, perform some operations interactively using the Spark shell. 

We recommend using [Docker](https://www.docker.com/) and [Docker-Compose](https://docs.docker.com/compose/).
A sample [yaml](http://yaml.org/) file to be used with docker compose is src/test/resources/sandbox.yaml.

**NOTE: The sample relies on the environment variable "USER" being set to the username for the Spark owner/operator.**

Assuming, Docker Engine (version > 1.10.0) and Docker Compose (version >= 1.6.0) are installed, the following steps would launch the cluster and start a Spark shell (:quit to exit).

* Change to the top level CIMReader test resources directory:
```
cd CIMReader/src/test/resources/
```
* Initialize the cluster:
```
docker-compose up&
```
* To increase the number of worker nodes (default is two containers, "spark_master" and "spark_worker_1"):
```
docker-compose scale worker=2
```
* To shut down the cluster:
```
docker-compose down
```
* To run an interactive shell in the master container:
```
docker exec --interactive --tty spark_master bash
```
* From within the interactive shell, to copy data files to HDFS
```
hdfs dfs -fs hdfs://sandbox:8020 -mkdir /data
hdfs dfs -fs hdfs://sandbox:8020 -put /opt/data/* /data
hdfs dfs -fs hdfs://sandbox:8020 -ls /data
```
* Optionally, to install R so that the sparkR command works:
```
apt-get install r-base
```

From within the interactive shell in the master container, to start the Spark shell with the CIMReader jar file on the classpath
[Note: to avoid "java.io.IOException: No FileSystem for scheme: null" when executing spark in the root directory,
either change to any subdirectory (i.e. ```cd /opt```) or
add the warehouse.dir configuration as shown here] 
```
spark-shell --master spark://sandbox:7077 --executor-memory 4g --driver-memory 1g --conf spark.sql.warehouse.dir=file:/tmp/spark-warehouse --jars /opt/code/CIMReader-2.11-2.0.2-2.2.1.jar
```
This should print out the Scala shell welcome screen with cool ASCII art:
```
Setting default log level to "WARN".
To adjust logging level use sc.setLogLevel(newLevel).
16/12/04 13:25:09 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
16/12/04 13:25:10 WARN spark.SparkContext: Use an existing SparkContext, some configuration may not take effect.
Spark context Web UI available at http://172.18.0.4:4040
Spark context available as 'sc' (master = local[*], app id = local-1480857910650).
Spark session available as 'spark'.
Welcome to
      ____              __
     / __/__  ___ _____/ /__
    _\ \/ _ \/ _ `/ __/  '_/
   /___/ .__/\_,_/_/ /_/\_\   version 2.0.2
      /_/
         
Using Scala version 2.11.8 (OpenJDK 64-Bit Server VM, Java 1.8.0_111)
Type in expressions to have them evaluated.
Type :help for more information.

scala>
```
* At the scala prompt one can import the classes defined in the CIMReader jar:
```scala
import org.apache.spark.rdd.RDD
import ch.ninecode.cim._
import ch.ninecode.model._
```
* One can then read in a CIM file:
```scala
val elements = spark.read.cim ("hdfs://sandbox:8020/data/NIS_CIM_Export_NS_INITIAL_FILL_Oberiberg.rdf")
```

* Since transform evaluation is lazy, one needs to trigger the actual reading of the file by, for example, asking for the count:
```scala
val count = elements.count
```

The data is now available in a large number of cached RDD structures.
For example, all ACLineSegment objects are available in the cached RDD with the name "ACLineSegment". 

You can get a list of RDD using:
```scala
println (sc.getPersistentRDDs.map(_._2.name).toArray.sortWith(_ < _).mkString("\n"))
```

You can get a named RDD using the class name:
```scala
val lines = sc.getPersistentRDDs.filter(_._2.name == "ACLineSegment").head._2.asInstanceOf[RDD[ACLineSegment]]
```

# Reader API

The expression "spark.read.cim" in the above example is shorthand for the full DataFrameReader syntax:

```scala
val element = spark.read.format ("ch.ninecode.cim").options (opts).load (file1, file2, ...)
```

where:
* file1..n is a list of files to read, (note that load can take a variable number of arguments)
* opts is pairs of named options in a Map[String,String], where values are "true" or "false",
CIM reader specific option names and their meaning are:
  * ch.ninecode.cim.do_deduplication - eliminate duplicates based on CIM rdfID or not
  * ch.ninecode.cim.make_edges - generate the Edges RDD and table or not
  * ch.ninecode.cim.do_join - merge CIM files (by UserAttribute) or not
  * ch.ninecode.cim.do_topo - generate TopologicalNode elements
  * ch.ninecode.cim.do_topo_islands - generate topological islands (forces ch.ninecode.cim.do_topo true also)
  * ch.ninecode.cim.split_maxsize - sets the size of FileInputFormat splits (default 64M)
  
One further option is the [StorageLevel](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.storage.StorageLevel$)

For example, to enable edge creation, topological island formation and add disk serialization, use:

```scala
import scala.collection.mutable.HashMap
import org.apache.spark.rdd.RDD
import ch.ninecode.cim._
import ch.ninecode.model._
val opts = new HashMap[String,String]()
opts.put("ch.ninecode.cim.make_edges", "true")
opts.put("ch.ninecode.cim.do_topo_islands", "true")
opts.put("StorageLevel", "MEMORY_AND_DISK_SER")
val element = spark.read.format ("ch.ninecode.cim").options (opts).load ("hdfs://sandbox:8020/data/NIS_CIM_Export_NS_INITIAL_FILL_Oberiberg.rdf")
element.count
val edges = sc.getPersistentRDDs.filter(_._2.name == "Edges").head._2.asInstanceOf[RDD[TopoEdge]]
edges.first
```

All RDD are also exposed as temporary tables, so one can use SQL syntax to construct specific queries, such as this one that queries details from all switches and performs a join to location coordinates:

    scala> val switches = spark.sql ("select s.ConductingEquipment.Equipment.PowerSystemResource.IdentifiedObject.mRID, s.ConductingEquipment.Equipment.PowerSystemResource.IdentifiedObject.aliasName, s.ConductingEquipment.Equipment.PowerSystemResource.IdentifiedObject.name, s.ConductingEquipment.Equipment.PowerSystemResource.IdentifiedObject.description, open, normalOpen, l.CoordinateSystem, p.xPosition, p.yPosition from Switch s, Location l, PositionPoint p where s.ConductingEquipment.Equipment.PowerSystemResource.Location = l.IdentifiedObject.mRID and s.ConductingEquipment.Equipment.PowerSystemResource.Location = p.Location and p.sequenceNumber = 0")
    ...
    switches: org.apache.spark.sql.DataFrame = [mRID: string, aliasName: string ... 7 more fields]
    scala> switches.show (5)
    ...
    +--------------+--------------------+--------------------+--------------------+-----+----------+----------------+-------------+-------------+
    |          mRID|           aliasName|                name|         description| open|normalOpen|CoordinateSystem|    xPosition|    yPosition|
    +--------------+--------------------+--------------------+--------------------+-----+----------+----------------+-------------+-------------+
    |HAS138129_fuse|                null|           Unbekannt|      Fuse HAS138129|false|     false|           wgs84|7.85439304935|46.9372460270|
    |      SIG82182|256344575:nis_el_...|Gr00-DIN-WEB (NH-...|Fuse SIG82182 SIC...|false|     false|    pseudo_wgs84|7.86008298361|46.9309032530|
    |HAS138498_fuse|                null|           Unbekannt|      Fuse HAS138498|false|     false|           wgs84|7.86026218589|46.9398699773|
    |     SIG138698|287345674:nis_el_...|Gr00-DIN-HAG (NH-...|Fuse SIG138698 SI...|false|     false|    pseudo_wgs84|7.85995167290|46.9309037359|
    |     TEI114089|243193592:nis_el_...|              H27_EK|              Switch|false|     false|    pseudo_wgs84|7.85584690510|46.9363110892|
    +--------------+--------------------+--------------------+--------------------+-----+----------+----------------+-------------+-------------+
    only showing top 5 rows

To expose the RDD as Hive SQL tables that are available externally, via JDBC for instance,
there is a stand-alone application built in to the CIMReader called CIMServerJDBC.
The program can be executed usng spark-submit with the name of the CIMServerJDBC jar file
that includes all necessary dependencies and the CIM file:

    spark-submit /opt/code/CIMServerJDBC-2.11-2.0.2-2.2.1-jar-with-dependencies.jar "hdfs://sandbox:8020/data/NIS_CIM_Export_sias_current_20160816_V7_bruegg.rdf"
    ...
    Press [Return] to exit...

The program will serve on port 10004 until you press Return.
Incidentally, the Tracking UI for the Application Master (on the master node port 4040) is really good.
But it disappears when the program terminates.

There is a small amount of command line help if you specify --help instead of the CIM file name,
for example on how to change the port number.

There is a [sample Java JDBC program](https://github.com/derrickoswald/CIMReader/blob/master/src/test/java/ch/ninecode/CIMJava.java) provided in the src/main/java directory.

The Java [Hive JDBC driver](https://mvnrepository.com/artifact/org.apache.hive/hive-jdbc/2.0.1)
can be black-box included by adding this magic incantation in
the maven pom:

    <dependency>
        <groupId>org.spark-project.hive</groupId>
        <artifactId>hive-jdbc</artifactId>
        <version>1.2.1.spark</version>
    </dependency>

Then most of the code found in the [Hive2 JDBC client](https://cwiki.apache.org/confluence/display/Hive/HiveServer2+Clients#HiveServer2Clients-JDBC) will work, except for "show tables name" (although "show tables" works).


# Notes

good pictures:
http://blog.cloudera.com/blog/2014/05/apache-spark-resource-management-and-yarn-app-models/


/usr/local/spark/bin/spark-submit   "sparkr-shell" /tmp/RtmpSScO6S/backend_port1b6469f08b97

.combineByKey  -- coalesce chunks

[probably will cause a shuffle]
.join
.leftOuterJoin -- join operations
.rightOuterJoin
.fullOuterJoin

# EC2

Export the [necessary keys](https://spark.apache.org/docs/latest/ec2-scripts.html), then launch a hadoop cluster on AWS with:

    ./spark-ec2 --key-pair=FirstMicro --identity-file=/home/derrick/.ssh/FirstMicro.pem --region=eu-west-1 --ebs-vol-size=0 --master-instance-type=m3.medium --instance-type=m3.large --spot-price=0.025 --slaves=2 --spark-version=1.6.0 --hadoop-major-version=yarn --deploy-root-dir=/home/derrick/code/CIMReader/target/ launch playpen

# Notes

    options (width=255)
    elements = loadDF (sqlContext, "hdfs:/data/dump_bkw.xml", "ch.ninecode.cim")
    head (elements, n=25)
    edges = sql (sqlContext, "select * from edges")
    ee = collect (edges)
    head (ee, n=50)

# RStudio & R Remote Client

To be able to use the Spark cluster backend inside of RStudio or R running as a remote client:

Download the Spark tarball file from the [Spark download page](http://spark.apache.org/downloads.html).
Currently we are using Spark 1.6.0 on Hadoop 2.6 in the [sequenciq/spark Docker container](https://hub.docker.com/r/sequenceiq/spark/ "sequenceiq/spark"),
so to match that, use Spark release 1.6.0 (Jan 04 2016), Pre-built for Hadoop 2.6 and later,
hence the file is currently spark-1.6.0-bin-hadoop2.6.tgz.

Unpack the tarball into an appropriate directory on the remote client.
This will have a directory listing like:

    ~/spark-1.6.0-bin-hadoop2.6$ ll
    total 1384
    drwxr-xr-x 12 derrick derrick    4096 Dez 22 03:22 ./
    drwxr-xr-x 93 derrick derrick    4096 Mär 21 13:35 ../
    drwxr-xr-x  3 derrick derrick    4096 Mär 22 16:14 bin/
    -rw-r--r--  1 derrick derrick 1312258 Dez 22 03:22 CHANGES.txt
    drwxr-xr-x  3 derrick derrick    4096 Mär 22 16:13 conf/
    drwxr-xr-x  3 derrick derrick    4096 Dez 22 03:22 data/
    drwxr-xr-x  3 derrick derrick    4096 Dez 22 03:22 ec2/
    drwxr-xr-x  3 derrick derrick    4096 Dez 22 03:22 examples/
    drwxr-xr-x  2 derrick derrick    4096 Dez 22 03:22 lib/
    -rw-r--r--  1 derrick derrick   17352 Dez 22 03:22 LICENSE
    drwxr-xr-x  2 derrick derrick    4096 Dez 22 03:22 licenses/
    -rw-r--r--  1 derrick derrick   23529 Dez 22 03:22 NOTICE
    drwxr-xr-x  6 derrick derrick    4096 Dez 22 03:22 python/
    drwxr-xr-x  3 derrick derrick    4096 Dez 22 03:22 R/
    -rw-r--r--  1 derrick derrick    3359 Dez 22 03:22 README.md
    -rw-r--r--  1 derrick derrick     120 Dez 22 03:22 RELEASE
    drwxr-xr-x  2 derrick derrick    4096 Dez 22 03:22 sbin/

From within the running container, copy these files from the /usr/local/spark-1.6.0-bin-hadoop2.6/yarn-remote-client directory to an appropriate directory on the remote client.

    # ls -al /usr/local/spark-1.6.0-bin-hadoop2.6/yarn-remote-client
    total 16
    drwxr-xr-x  2 root root 4096 Jan  9 03:26 .
    drwxr-xr-x 15  500  500 4096 Mar 22 11:10 ..
    -rw-r--r--  1 root root  325 Jan  9 03:26 core-site.xml
    -rw-r--r--  1 root root 1097 Jan  9 03:26 yarn-site.xml

For this purpose I recommend the conf directory of the unpacked tarball (see above).
Proceed in two steps, one inside the container and one on the remote client (your host).

    # cp /usr/local/spark-1.6.0-bin-hadoop2.6/yarn-remote-client/* /opt/data
    $ cp /home/derrick/code/CIMReader/data/*-site.xml ~/spark-1.6.0-bin-hadoop2.6/conf

Set environment variables to tell RStudio or R where Spark and it's configuration are:

    export SPARK_HOME=/home/derrick/spark-1.6.0-bin-hadoop2.6
    export YARN_CONF_DIR=/home/derrick/spark-1.6.0-bin-hadoop2.6/conf

# R

Start RStudio or R.

Install the SparkR package.

    install.packages (pkgs = file.path(Sys.getenv("SPARK_HOME"), "R", "lib", "SparkR"), repos = NULL)

Follow the instructions in [Starting up from RStudio](https://spark.apache.org/docs/latest/sparkr.html#starting-up-from-rstudio), except do not specify a local master and include the CIMReader reader as a jar to be shipped to the worker nodes.

```
# set up the Spark system
Sys.setenv (YARN_CONF_DIR="/home/derrick/spark/spark-2.0.2-bin-hadoop2.7/conf")
Sys.setenv (SPARK_HOME="/home/derrick/spark/spark-2.0.2-bin-hadoop2.7")
library (SparkR, lib.loc = c (file.path (Sys.getenv("SPARK_HOME"), "R", "lib")))
sparkR.session ("spark://sandbox:7077", "Sample", sparkJars = c ("/home/derrick/code/CIMReader/target/CIMReader-2.11-2.0.2-2.0.1.jar"), sparkEnvir = list (spark.driver.memory="1g", spark.executor.memory="4g", spark.serializer="org.apache.spark.serializer.KryoSerializer"))
```

If you have a data file in HDFS (it cannot be local, it must be on the cluster):

```
# read the data file
elements = sql ("create temporary view elements using ch.ninecode.cim options (path 'hdfs://sandbox:8020/data/NIS_CIM_Export_sias_current_20160816_Kiental_V10.rdf', StorageLevel 'MEMORY_AND_DISK_SER', ch.ninecode.cim.make_edges 'true', ch.ninecode.cim.do_topo 'false', ch.ninecode.cim.do_topo_islands 'false')")
head (sql ("select * from elements")) # triggers evaluation

# read the edges RDD as an R data frame
edges = sql ("select * from edges")
redges = SparkR::collect (edges, stringsAsFactors=FALSE)

# example to read an RDD directly
terminals = sql ("select * from Terminal")
rterminals = SparkR::collect (terminals, stringsAsFactors=FALSE)

# example to read a three-way join of RDD
switch = sql (("select s.ConductingEquipment.Equipment.PowerSystemResource.IdentifiedObject.mRID, s.ConductingEquipment.Equipment.PowerSystemResource.IdentifiedObject.aliasName, s.ConductingEquipment.Equipment.PowerSystemResource.IdentifiedObject.name, s.ConductingEquipment.Equipment.PowerSystemResource.IdentifiedObject.description, open, normalOpen, l.CoordinateSystem, p.xPosition, p.yPosition from Switch s, Location l, PositionPoint p where s.ConductingEquipment.Equipment.PowerSystemResource.Location = l.IdentifiedObject.mRID and s.ConductingEquipment.Equipment.PowerSystemResource.Location = p.Location and p.sequenceNumber = 0")
rswitch = SparkR::collect (switch, stringsAsFactors=FALSE)
```

# Logging

To quiet down the tremendously verbose logging for Spark to just the minimum,
i.e. just warnings and errors, copy and edit the log4j configuration
and set the console logging to WARN instead of INFO:

    $ cd /usr/local/spark-1.6.0-bin-hadoop2.6/conf
    $ cp log4j.properties.template log4j.properties
    $ sed -i 's/log4j.rootCategory=INFO/log4j.rootCategory=WARN/g' log4j.properties


CIMReader
======

Spark access to Common Information Model (CIM) files as RDD and SQL. | [![Maven Central](https://img.shields.io/maven-central/v/ch.ninecode.cim/CIMReader.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22ch.ninecode.cim%22%20AND%20a:%22CIMReader%22)
:---         |          ---:

# Overview

This program reads in CIM files which are a 
standard interchange format based on IEC standards 61968 & 61970
(see [CIM users group](http://cimug.ucaiug.org/default.aspx) for additional details)
and produces a Spark Resilient Distributed Dataset (RDD) for each CIM class.

These RDDs can be manipulated by native Spark programs written in
[Scala, Java or Python](http://spark.apache.org/docs/latest/programming-guide.html),
or can be accessed via [SparkR](http://spark.apache.org/docs/latest/sparkr.html) in R.

These RDDs are also exposed as Spark Dataset tables, allowing SQL access.

# Architecture

The architecture follows the sample code from [Databricks](https://databricks.com/blog/2015/01/09/spark-sql-data-sources-api-unified-data-access-for-the-spark-platform.html).

![CIMReader Architecture](https://cdn.jsdelivr.net/gh/derrickoswald/CIMSpark@master/CIMReader/img/Architecture.svg "High level architecture diagram")

# Building

Assuming the Scala Build Tool [sbt](http://www.scala-sbt.org/) or Maven [mvn](https://maven.apache.org/) is installed, to package CIMReader (make a jar file) follow these steps:

* Change to the top level CIMReader directory:
```
cd CIMSpark/CIMReader
```
* Invoke the package command:
```
mvn package
```
or
```
sbt package
```

This should produce a jar file in the target/ directory.

**NOTE: The sbt project file uses the bintray plugin which can be installed by adding (or creating) to project/plugins.sbt the line: 
_addSbtPlugin("org.foundweekends" % "sbt-bintray" % "0.5.4")_.
If you use sbt, the jar file will be in a subdirectory of target/ based on the version of the Scala library used,
e.g. target/scala-2.12, and the name will not have upper/lowercase preserved, that is, the name will be cimreader_2.12-??.** 

**NOTE: The unit tests can be skipped if you add the magic incantation `mvn -DskipTests package`**

**NOTE: The artifact can also be installed into the local Maven repository if you skip the gpg signing step: `mvn -Dmaven.test.skip=true -DskipTests -DskipITs -Dgpg.skip install`**

## Jar Naming Scheme

The name of the jar file (e.g. CIMReader-<cimreader_version>.jar) is comprised of a fixed name ("CIMReader") followed by three [semantic version numbers](http://semver.org/), each separated by a dash.

The first version number is the Scala library version. This follows [Scala library naming semantics](https://github.com/scalacenter/scaladex).

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
docker-compose up --scale worker=2&
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
hdfs dfs -mkdir /data
hdfs dfs -put /opt/data/* /data
hdfs dfs -ls /data
```
From within the interactive shell in the master container, to start the Spark shell with the CIMReader jar file on the classpath
```
spark-shell --master spark://sandbox:7077 --executor-memory 4g --driver-memory 1g --packages ch.ninecode.cim:CIMReader:<cimspark_version>
```
This should print out the Scala shell welcome screen with cool ASCII art:
```
Ivy Default Cache set to: /root/.ivy2/cache
The jars for the packages stored in: /root/.ivy2/jars
:: loading settings :: url = jar:file:/root/spark/spark-3.0.1-bin-hadoop3.2/jars/ivy-2.4.0.jar!/org/apache/ivy/core/settings/ivysettings.xml
ch.ninecode.cim#CIMReader added as a dependency
:: resolving dependencies :: org.apache.spark#spark-submit-parent-69ac0dfd-a56d-46a5-9b45-b9754495a263;1.0
	confs: [default]
	found ch.ninecode.cim#CIMReader;<cimspark_version> in local-m2-cache
	found com.github.scopt#scopt_2.12;4.0.0-RC2 in spark-list
:: resolution report :: resolve 195ms :: artifacts dl 6ms
	:: modules in use:
	ch.ninecode.cim#CIMReader;<cimspark_version> from local-m2-cache in [default]
	com.github.scopt#scopt_2.12;4.0.0-RC2 from spark-list in [default]
	---------------------------------------------------------------------
	|                  |            modules            ||   artifacts   |
	|       conf       | number| search|dwnlded|evicted|| number|dwnlded|
	---------------------------------------------------------------------
	|      default     |   2   |   0   |   0   |   0   ||   2   |   0   |
	---------------------------------------------------------------------
:: retrieving :: org.apache.spark#spark-submit-parent-69ac0dfd-a56d-46a5-9b45-b9754495a263
	confs: [default]
	0 artifacts copied, 2 already retrieved (0kB/9ms)
Spark context Web UI available at http://192.168.10.221:4040
Spark context available as 'sc' (master = spark://sandbox:7077, app id = app-20200625140743-0003).
Spark session available as 'spark'.
Welcome to
      ____              __
     / __/__  ___ _____/ /__
    _\ \/ _ \/ _ `/ __/  '_/
   /___/ .__/\_,_/_/ /_/\_\   version 3.0.1
      /_/
         
Using Scala version 2.12.10 (OpenJDK 64-Bit Server VM, Java 11.0.7)
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
val elements = spark.read.cim ("hdfs://sandbox:8020/data/CGMES_v2.4.15_RealGridTestConfiguration_EQ_v2.xml")
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

# Serialization

The recommended serialization is [Kryo](https://github.com/EsotericSoftware/kryo).
Serialization options must be specified before the Spark context is created,
that is, Kryo must be enabled prior to the `SparkSession` being created.
Although Kryo works well when simply turned on,

 i.e. command line with `--conf spark.serializer=org.apache.spark.serializer.KryoSerializer`,
 
the best results are obtained if classes are registered with Kryo
via the `SparkConfiguration` used to create the `SparkSession`,

 i.e. programmatically `configuration.registerKryoClasses (CIMClasses.list)`.
 
The CIMreader includes custom Kryo serialization
with a Spark [Kryo Registrator](https://spark.apache.org/docs/0.7.0/api/core/spark/KryoRegistrator.html)
which provides additional optimization.
The table below shows the approximate serialized size for all Elements of the DemoData.rdf (720325 bytes, 44980 bytes zipped):

| Method | Serialized Size | Size Reduction |
| --- | --- | ---|
| JavaSerializer (default) | 2107629 bytes |  |
| Kryo | 352888 bytes | -83.3% |
| Kryo with registration | 248890 bytes | -29.5% |
| CIMSerializer | 178352 bytes | -18.3% |

To enable the custom registrator:

 command line `--conf spark.kryo.registrator=ch.ninecode.cim.CIMRegistrator`
 
 programmatically `configuration.set ("spark.kryo.registrator", "ch.ninecode.cim.CIMRegistrator")`

When running a program where a Spark context has already been created,
the only option if you would like to get the optimal Kryo serialization,
is to shut down the context and restart Spark after enabling Kryo:

```
import org.apache.spark.{SparkContext, SparkConf}
import ch.ninecode.cim._

val configuration = spark.sparkContext.getConf
sc.stop()
configuration.registerKryoClasses (CIMClasses.list)
configuration.set ("spark.kryo.registrator", "ch.ninecode.cim.CIMRegistrator")
val sc = new SparkContext (conf)
val spark = org.apache.spark.sql.SparkSession.builder ().getOrCreate ()
```

# Logging

To quiet down the tremendously verbose logging for Spark to just the minimum,
i.e. just warnings and errors, copy and edit the log4j configuration
and set the console logging to WARN instead of INFO:

    $ cd $SPARK_HOME/conf
    $ cp log4j.properties.template log4j.properties
    $ sed -i 's/log4j.rootCategory=INFO/log4j.rootCategory=WARN/g' log4j.properties

This has already been done in the Spark Docker container.

# Reader API

The expression "spark.read.cim" in the above example is shorthand for the full DataFrameReader syntax:

```scala
val element = spark.read.format ("ch.ninecode.cim").options (opts).load (file1, file2, ...)
or
val elements = spark.read.options (opts).cim (file1, file2, ...)
```

where:
* file1..n is a list of files to read, (note that load can take a variable number of arguments)
* opts is pairs of named options in a Map[String,String], where values are usually "true" or "false",
but for some topology options "ForceTrue", "ForceFalse" or "Unforced".
CIM reader specific option names and their meaning are:
  * ch.ninecode.cim.do_about - merge rdf:about elements into rdf:ID elements with the same mRID
  * ch.ninecode.cim.do_normalize - normalize 1:N relations which are denormalized
  * ch.ninecode.cim.do_deduplication - eliminate duplicates based on CIM mRID
  * ch.ninecode.cim.make_edges - generate the Edges RDD and table
  * ch.ninecode.cim.do_join - merge CIM files (by UserAttribute)
  * ch.ninecode.cim.do_topo - generate TopologicalNode elements
  * ch.ninecode.cim.do_topo_islands - generate TopologicalIsland elements (forces ch.ninecode.cim.do_topo true also)
  * ch.ninecode.cim.force_retain_switches - force switches to have two TopologicalNode irregardless of the retain value
  * ch.ninecode.cim.force_retain_fuses - force fuses to have two TopologicalNode irregardless of the retain value
  * ch.ninecode.cim.force_switch_separate_islands - force switches to have two TopologicalIsland irregardless of the retain value
  * ch.ninecode.cim.force_fuse_separate_islands - force fuses to have two TopologicalIsland irregardless of the retain value
  * ch.ninecode.cim.default_switch_open_state - default open value when normalOpen and open aren both not specified
  * ch.ninecode.cim.debug - add additional checks and messages for debugging purposes
  * ch.ninecode.cim.cache - save resulting RDD as an object file using this name, for subsequent reads use this as a cache
  
Other Spark specific options are the
[StorageLevel](https://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.storage.StorageLevel$)
(default MEMORY_AND_DISK_SER) to set the RDD caching strategy and 
[ch.ninecode.cim.split_maxsize](https://hadoop.apache.org/docs/current/api/org/apache/hadoop/mapreduce/lib/input/FileInputFormat.html#SPLIT_MAXSIZE)
to set the size of FileInputFormat splits (default 64M) which establishes the number of partitions for a large file.

For example, to enable edge creation and topological island formation, use:

```scala
import org.apache.spark.rdd.RDD
import ch.ninecode.cim._
import ch.ninecode.model._
val opts = Map[String,String]("ch.ninecode.cim.make_edges" -> "true", "ch.ninecode.cim.do_topo_islands" -> "true")
val element = spark.read.format ("ch.ninecode.cim").options (opts).load ("hdfs://sandbox:8020/data/CGMES_v2.4.15_RealGridTestConfiguration_EQ_v2.xml")
element.count
val edges = sc.getPersistentRDDs.filter(_._2.name == "Edges").head._2.asInstanceOf[RDD[TopoEdge]]
edges.first
```

The `ch.ninecode.cim.cache option` should only be used if you will be reusing the same file and options multiple times.
For example, a moderately large file (522711666 bytes) takes ~337 seconds to read in, but caching adds ~90 seconds
to create the object file (RDD.saveAsObjectFile).
Subsequent reads take ~74 seconds, so it only makes sense to cache the file if you will use it more than once.
You are responsible for erasing the cache when reading different files or using different topology options.

All RDD are also exposed as temporary tables, so one can use SQL syntax to construct specific queries, such as this one that queries details from all switches and performs a join to location coordinates:

    scala> val switches = spark.sql ("select s.ConductingEquipment.Equipment.PowerSystemResource.IdentifiedObject.mRID, s.ConductingEquipment.Equipment.PowerSystemResource.IdentifiedObject.aliasName, s.ConductingEquipment.Equipment.PowerSystemResource.IdentifiedObject.name, s.ConductingEquipment.Equipment.PowerSystemResource.IdentifiedObject.description, open, normalOpen, l.CoordinateSystem, p.xPosition, p.yPosition from Switch s, Location l, PositionPoint p where s.ConductingEquipment.Equipment.PowerSystemResource.Location = l.IdentifiedObject.mRID and s.ConductingEquipment.Equipment.PowerSystemResource.Location = p.Location and p.sequenceNumber = 1")
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

# RStudio & R Remote Client

To be able to use the Spark cluster backend inside of RStudio or R running as a remote client:

Download the Spark tarball file from the [Spark download page](http://spark.apache.org/downloads.html).
Currently we are using Spark 2.4.5 on Hadoop 2.7 in the [derrickoswald/spark-docker container](https://hub.docker.com/r/derrickoswald/spark-docker "derrickoswald/spark-docker"),
so to match that, use Spark release 2.4.5 (Feb 5 2020), Pre-built for Hadoop 2.7 and later,
hence the file is currently spark-2.4.5-bin-hadoop2.7.tgz.

Unpack the tarball into an appropriate directory on the remote client.
The name of this directory will be used to set the SPARK_HOME environment variable (e.g. /root/spark/spark-2.4.5-bin-hadoop2.7 shown below).

# R

Start RStudio or R.

Install the SparkR package.

    Sys.setenv (SPARK_HOME="/root/spark/spark-2.4.5-bin-hadoop2.7")
    install.packages (pkgs = file.path(Sys.getenv("SPARK_HOME"), "R", "lib", "SparkR"), repos = NULL)

Follow the instructions in [Starting up from RStudio](https://spark.apache.org/docs/latest/sparkr.html#starting-up-from-rstudio),
except do not specify a local master and include the CIMReader reader as a jar to be shipped to the worker nodes.

```
# set up the Spark system
Sys.setenv (SPARK_HOME="/root/spark/spark-2.4.5-bin-hadoop2.7")
library (SparkR, lib.loc = c (file.path (Sys.getenv("SPARK_HOME"), "R", "lib")))
sparkR.session ("spark://sandbox:7077", "Sample", sparkJars = c ("/root/code/CIMSpark/target/CIMReader-<cimreader_version>.jar"), sparkEnvir = list (spark.driver.memory="1g", spark.executor.memory="4g", spark.serializer="org.apache.spark.serializer.KryoSerializer"))
```

If you have a data file in HDFS (it cannot be local, it must be on the cluster):

```
# read the data file
elements = sql ("create temporary view elements using ch.ninecode.cim options (path 'hdfs://sandbox:8020/DemoData.rdf', StorageLevel 'MEMORY_AND_DISK_SER', ch.ninecode.cim.make_edges 'true', ch.ninecode.cim.do_topo 'false', ch.ninecode.cim.do_topo_islands 'false')")
head (sql ("select * from elements")) # triggers evaluation

# read the edges RDD as an R data frame
edges = sql ("select * from edges")
redges = SparkR::collect (edges, stringsAsFactors=FALSE)

# example to read an RDD directly
terminals = sql ("select * from Terminal")
rterminals = SparkR::collect (terminals, stringsAsFactors=FALSE)

# example to read a three-way join of RDD
switch = sql ("select s.ConductingEquipment.Equipment.PowerSystemResource.IdentifiedObject.mRID, s.ConductingEquipment.Equipment.PowerSystemResource.IdentifiedObject.aliasName, s.ConductingEquipment.Equipment.PowerSystemResource.IdentifiedObject.name, s.ConductingEquipment.Equipment.PowerSystemResource.IdentifiedObject.description, open, normalOpen, l.CoordinateSystem, p.xPosition, p.yPosition from Switch s, Location l, PositionPoint p where s.ConductingEquipment.Equipment.PowerSystemResource.Location = l.IdentifiedObject.mRID and s.ConductingEquipment.Equipment.PowerSystemResource.Location = p.Location and p.sequenceNumber = 1")
rswitch = SparkR::collect (switch, stringsAsFactors=FALSE)
```

# PySpark

Execute pyspark with either the --jar or --packages option referring to a CIMReader jar file.

```
pyspark --jars <path_to_jar>/CIMReader-<cimreader_version>.jar
```

__Note: The following works, but might not be optimal from a PySpark perspective.__

```
sql ("create temporary view elements using ch.ninecode.cim options (path 'hdfs://sandbox:8020/TRA10938_TRA10939.new.rdf', StorageLevel 'MEMORY_AND_DISK_SER', ch.ninecode.cim.do_topo_islands 'true')")
elements = spark.sql ("select * from elements")
elements.count ()
2887

lines = spark.sql ("select * from ACLineSegment")
lines.show (10)
+--------------------+----+---+----+---+---------+---------+--------------------------+-----+-----+-------------------+-----+----+----------+-------------------+-----------------+------------------+
|           Conductor|b0ch|bch|g0ch|gch|        r|       r0|shortCircuitEndTemperature|    x|   x0|ACLineSegmentPhases|Clamp| Cut|LineFaults|LineGroundingAction|LineJumpingAction|PerLengthImpedance|
+--------------------+----+---+----+---+---------+---------+--------------------------+-----+-----+-------------------+-----+----+----------+-------------------+-----------------+------------------+
|[[[[[[, KLE44242]...| 0.0|0.0| 0.0|0.0|0.4174182|1.6696728|                     200.0| 0.09| 0.36|               null| null|null|      null|               null|             null|              null|
|[[[[[[, VER4629],...| 0.0|0.0| 0.0|0.0|      0.0|      0.0|                       0.0|  0.0|  0.0|               null| null|null|      null|               null|             null|              null|
|[[[[[[, KLE43894]...| 0.0|0.0| 0.0|0.0|0.5651864|2.2607456|                     200.0| 0.09| 0.36|               null| null|null|      null|               null|             null|              null|
|[[[[[[, KLE44244]...| 0.0|0.0| 0.0|0.0|0.1337464|0.5349856|                     200.0|0.089|0.356|               null| null|null|      null|               null|             null|              null|
|[[[[[[, VER408759...| 0.0|0.0| 0.0|0.0|      0.0|      0.0|                       0.0|  0.0|  0.0|               null| null|null|      null|               null|             null|              null|
|[[[[[[, KLE44211]...| 0.0|0.0| 0.0|0.0|0.2081698|0.8326792|                     200.0|0.069|0.276|               null| null|null|      null|               null|             null|              null|
|[[[[[[, VER5086],...| 0.0|0.0| 0.0|0.0|      0.0|      0.0|                       0.0|  0.0|  0.0|               null| null|null|      null|               null|             null|              null|
|[[[[[[, KLE44213]...| 0.0|0.0| 0.0|0.0|0.7841422|3.1365688|                     200.0|0.092|0.368|               null| null|null|      null|               null|             null|              null|
|[[[[[[, KLE44215]...| 0.0|0.0| 0.0|0.0|0.2081698|0.8326792|                     200.0|0.069|0.276|               null| null|null|      null|               null|             null|              null|
|[[[[[[, VER4630],...| 0.0|0.0| 0.0|0.0|      0.0|      0.0|                       0.0|  0.0|  0.0|               null| null|null|      null|               null|             null|              null|
+--------------------+----+---+----+---+---------+---------+--------------------------+-----+-----+-------------------+-----+----+----------+-------------------+-----------------+------------------+
only showing top 10 rows

switches = spark.sql ("select s.ConductingEquipment.Equipment.PowerSystemResource.IdentifiedObject.mRID, s.ConductingEquipment.Equipment.PowerSystemResource.IdentifiedObject.aliasName, s.ConductingEquipment.Equipment.PowerSystemResource.IdentifiedObject.name, s.ConductingEquipment.Equipment.PowerSystemResource.IdentifiedObject.description, open, normalOpen, l.CoordinateSystem, p.xPosition, p.yPosition from Switch s, Location l, PositionPoint p where s.ConductingEquipment.Equipment.PowerSystemResource.Location = l.IdentifiedObject.mRID and s.ConductingEquipment.Equipment.PowerSystemResource.Location = p.Location and p.sequenceNumber = 0")
switches.show (10)
+-------------+--------------------+--------------------+--------------------+-----+----------+----------------+-------------+-------------+
|         mRID|           aliasName|                name|         description| open|normalOpen|CoordinateSystem|    xPosition|    yPosition|
+-------------+--------------------+--------------------+--------------------+-----+----------+----------------+-------------+-------------+
|HAS17324_fuse|                null|           Unbekannt|       Fuse HAS17324|false|     false|           wgs84|7.50320957170|46.9730419603|
|     SIG13911|240842629:nis_el_...|G4-SEV-FUC (NH-La...|                null|false|      true|    pseudo_wgs84|7.50112095282|46.9737210015|
|HAS17337_fuse|                null|           Unbekannt|       Fuse HAS17337|false|     false|           wgs84|7.50188816143|46.9728596359|
|    SIG129713|277921763:nis_el_...|Gr2-DIN-WEB (NH-L...|                null|false|      true|    pseudo_wgs84|7.50179274304|46.9744530167|
|HAS17201_fuse|                null|           Unbekannt|       Fuse HAS17201|false|     false|           wgs84|7.50197474612|46.9741915585|
|HAS91265_fuse|                null|           Unbekannt|       Fuse HAS91265|false|     false|           wgs84|7.50177084919|46.9750677768|
|     SIG65509|243117214:nis_el_...|Gr3-DIN-WEB (NH-L...|Fuse SIG65509 SIC...|false|     false|    pseudo_wgs84|7.50263992060|46.9731551678|
|     SIG13908|240842530:nis_el_...|G4-SEV-FUC (NH-La...|                null|false|      true|    pseudo_wgs84|7.50108809822|46.9737210192|
|       SIG574|240306320:nis_el_...|G4-SEV-FUC (NH-Si...|                null|false|      true|    pseudo_wgs84|7.50359791204|46.9719968679|
|HAS17220_fuse|                null|           Unbekannt|       Fuse HAS17220|false|     false|           wgs84|7.50135795842|46.9735427213|
+-------------+--------------------+--------------------+--------------------+-----+----------+----------------+-------------+-------------+
only showing top 10 rows

switchp = switches.toPandas ()
switchp.shape
(74, 9)
switchp
             mRID                        aliasName                                    name             description  ...  normalOpen  CoordinateSystem      xPosition      yPosition
0   HAS17324_fuse                             None                               Unbekannt           Fuse HAS17324  ...       False             wgs84  7.50320957170  46.9730419603
1        SIG13911  240842629:nis_el_int_fuse_group   G4-SEV-FUC (NH-Lastschaltleiste 400V)                    None  ...        True      pseudo_wgs84  7.50112095282  46.9737210015
2   HAS17337_fuse                             None                               Unbekannt           Fuse HAS17337  ...       False             wgs84  7.50188816143  46.9728596359
3       SIG129713  277921763:nis_el_int_fuse_group  Gr2-DIN-WEB (NH-Lastschaltleiste 400V)                    None  ...        True      pseudo_wgs84  7.50179274304  46.9744530167
4   HAS17201_fuse                             None                               Unbekannt           Fuse HAS17201  ...       False             wgs84  7.50197474612  46.9741915585
..            ...                              ...                                     ...                     ...  ...         ...               ...            ...            ...
69       SIG13909  240842563:nis_el_int_fuse_group   G4-SEV-FUC (NH-Lastschaltleiste 400V)                    None  ...        True      pseudo_wgs84  7.50115380742  46.9737209837
70  HAS17202_fuse                             None                               Unbekannt           Fuse HAS17202  ...       False             wgs84  7.50140680876  46.9741165233
71  HAS17222_fuse                             None                               Unbekannt           Fuse HAS17222  ...       False             wgs84  7.50127662603  46.9739572510
72         SIG468  240302822:nis_el_int_fuse_group   G4-SEV-FUC (NH-Sicherungsgruppe 400V)      Fuse SIG468 SIC468  ...       False      pseudo_wgs84  7.50288700735  46.9730627751
73       SIG48118  242396960:nis_el_int_fuse_group  Gr2-DIN-WEB (NH-Lastschaltleiste 400V)  Fuse SIG48118 SIC48118  ...       False      pseudo_wgs84  7.50295532143  46.9731549929
```

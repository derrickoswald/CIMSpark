CIMReader
======

Spark access to Common Information Model (CIM) files as RDD and Hive SQL.

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

The CIM model as implemented in CIMReader is described in [CIM Model](Model.md).

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

The name of the jar file (e.g. CIMReader-2.11-2.0.1-1.8.1.jar) is comprised of a fixed name ("CIMReader") followed by three [semantic version numbers](http://semver.org/), each separated by a dash.

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

* Change to the top level CIMReader directory:
```
cd CIMReader
```
* Initialize the cluster (default is two containers, "sandbox" and "worker"):
```
docker-compose --file src/test/resources/sandbox.yaml up&
```
* To increase the number of worker nodes:
```
docker-compose --file src/test/resources/sandbox.yaml scale worker=2
```
* To shut down the cluster:
```
docker-compose --file src/test/resources/sandbox.yaml down
```
* To run an interactive shell in the master container:
```
docker exec --interactive --tty resources_sandbox_1 bash
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
spark-shell --conf spark.sql.warehouse.dir=file:/tmp/spark-warehouse --jars /opt/code/CIMReader-2.11-2.0.1-1.8.1.jar
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
   /___/ .__/\_,_/_/ /_/\_\   version 2.0.1
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
println (sc.getPersistentRDDs.map(_._2.name).toArray.sortWith(_ < _).mkString("\n")
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

    scala> val switches = spark.sql ("select s.sup.sup.sup.sup.mRID mRID, s.sup.sup.sup.sup.aliasName aliasName, s.sup.sup.sup.sup.name name, s.sup.sup.sup.sup.description description, open, normalOpen no, l.CoordinateSystem cs, p.xPosition, p.yPosition from Switch s, Location l, PositionPoint p where s.sup.sup.sup.Location = l.sup.mRID and s.sup.sup.sup.Location = p.Location and p.sequenceNumber = 0")
    ...
    switches: org.apache.spark.sql.DataFrame = [mRID: string, aliasName: string, name: string, description: string, open: boolean, no: boolean, cs: string, xPosition: string, yPosition: string]
    scala> switches.show (5)
    ...
    +-----------+--------------------+--------------------+-----------+-----+-----+-------------+-------------+-------------+
    |       mRID|           aliasName|                name|description| open|   no|           cs|    xPosition|    yPosition|
    +-----------+--------------------+--------------------+-----------+-----+-----+-------------+-------------+-------------+
    |    TEI8271|8136705:nis_el_in...|unbekannt ausfahrbar|     Switch|false|false|pseudo_wgs_84|8.78279448906|47.0431707353|
    |  HAS6_fuse|                null|           unbekannt|  Fuse HAS6|false|false|       wgs_84|8.78362235047|47.0410546451|
    |    TEI6817|2070980:nis_el_in...|               DIN00|     Switch|false|false|pseudo_wgs_84|8.78023909003|47.0411507663|
    |HAS200_fuse|                null|           unbekannt|Fuse HAS200|false|false|       wgs_84|8.78427055434|47.0413288289|
    |    TEI2218|2005426:nis_el_in...|             Trenner|     Switch|false|false|pseudo_wgs_84|8.78806552763|47.0431092357|
    +-----------+--------------------+--------------------+-----------+-----+-----+-------------+-------------+-------------+
    only showing top 5 rows

To expose the RDD as Hive SQL tables that are available externally, via JDBC for instance, a utility main() function is provided in CIMRDD:

    spark-submit --class ch.ninecode.cim.CIMRDD --jars /opt/code/CIMReader-2.11-2.0.1-1.8.1.jar --master yarn --deploy-mode client --driver-memory 1g --executor-memory 4g --conf spark.sql.hive.thriftServer.singleSession=true /opt/code/CIMReader-2.11-2.0.1-1.8.1.jar "hdfs://sandbox:8020/data/NIS_CIM_Export_sias_current_20160816_V7_bruegg.rdf"
    ...
    Press [Return] to exit...

The program will serve on port 10000 until you press Return.

The java client code required can be black-box included by adding this magic incantation in
the maven pom:

    <dependency>
        <groupId>org.apache.hadoop</groupId>
        <artifactId>hadoop-core</artifactId>
        <version>1.2.1</version>
    </dependency>
    <dependency>
        <groupId>org.spark-project.hive</groupId>
        <artifactId>hive-jdbc</artifactId>
        <version>1.2.1.spark</version>
    </dependency>

Then most of the code found in the [Hive2 JDBC client](https://cwiki.apache.org/confluence/display/Hive/HiveServer2+Clients#HiveServer2Clients-JDBC) will work, except for "show tables name" (although "show tables" works).

    private static String driverName = "org.apache.hive.jdbc.HiveDriver";

    public static void main (String[] args) throws SQLException
    {
        try
        {
            Class.forName (driverName);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace ();
            System.exit (1);
        }
        // replace "hive" here with the name of the user the queries should run as
        Connection con = DriverManager.getConnection ("jdbc:hive2://localhost:10000/default", "hive", "");
        Statement stmt = con.createStatement ();

        // show tables
        String sql = "show tables";
        System.out.println ("Running: " + sql);
        ResultSet res = stmt.executeQuery (sql);
        while (res.next ())
            System.out.println ("    " + res.getString (1));
        res.close ();

        String tableName = "points";

        // describe table
        sql = "describe " + tableName;
        System.out.println ("Running: " + sql);
        res = stmt.executeQuery (sql);
        while (res.next ())
            System.out.println ("    " + res.getString (1) + "\t" + res.getString (2));
        res.close ();

        // select * query
        sql = "select * from " + tableName;
        System.out.println ("Running: " + sql);
        res = stmt.executeQuery (sql);
        int index = 0;
        while (res.next () && (index++ < 5))
            System.out.println (String.valueOf (res.getString (1)) + "\t" + res.getDouble (2)+ "\t" + res.getDouble (3));
        res.close ();

        // count query
        sql = "select count(1) from " + tableName;
        System.out.println ("Running: " + sql);
        res = stmt.executeQuery (sql);
        while (res.next ())
            System.out.println (res.getString (1));
        res.close ();

        System.out.println ("done");
        con.close ();
    }

yields output:

    16/01/26 15:40:32 INFO jdbc.Utils: Supplied authorities: localhost:10000
    16/01/26 15:40:32 INFO jdbc.Utils: Resolved authority: localhost:10000
    16/01/26 15:40:32 INFO jdbc.HiveConnection: Will try to open client transport with JDBC Uri: jdbc:hive2://localhost:10000/default
    Running: show tables
        points
        lines
    Running: describe points
        id  string
        x   double
        y   double
    Running: select * from points
    _location_1610744576_427087414_2073666  8.52831529608   46.9951049314
    _location_5773096_1152305167_985581 8.60289818799   46.995578585
    _location_5773116_972140366_615398  8.5110791419    46.9933251694
    _location_5773096_823727318_151097  8.6133386841    47.003597305
    _location_1610642176_427083559_1978331  8.58587930233   47.0543961057
    Running: select count(1) from points
    7540
    done

# Programmatic Usage

The jars to start the thrift server are not automatically added to the classpath for spark-submit,
so use the following to allow execution of a program that creates a Hive SQL context and thrift server instance
just like the spark-shell environment:

    --jars /usr/local/spark/lib/datanucleus-api-jdo-3.2.6.jar,/usr/local/spark/lib/datanucleus-core-3.2.10.jar,/usr/local/spark/lib/datanucleus-rdbms-3.2.9.jar 

The program runs out of memory at the `new HiveContext (spark)` call when the `--deploy-mode` is `cluster`.
The error:

    16/01/05 03:56:32 ERROR yarn.ApplicationMaster: User class threw exception: java.lang.OutOfMemoryError: PermGen space
    java.lang.OutOfMemoryError: PermGen space

seems to indicate (from search results) that the maxpermsize is too small.
The suggested fix was to set `spark.executor.extraJavaOptions=-XX:MaxPermSize=256M`,
but this didn't work because in this case it is the driver program that's failing.
Fortunately there's another setting for the driver, so this works:

    spark.driver.extraJavaOptions=-XX:MaxPermSize=256M

So the complete command for cluster deploy is:

    spark-submit --conf spark.driver.extraJavaOptions=-XX:MaxPermSize=256M --class ch.ninecode.CIMRDD --jars /usr/local/spark/lib/datanucleus-api-jdo-3.2.6.jar,/usr/local/spark/lib/datanucleus-core-3.2.10.jar,/usr/local/spark/lib/datanucleus-rdbms-3.2.9.jar --master yarn --deploy-mode cluster --driver-memory 2g --executor-memory 2g --executor-cores 1 --conf spark.sql.hive.thriftServer.singleSession=true /opt/code/CIMReader-2.11-2.0.1-1.8.1.jar "/opt/data/dump_all.xml"

To run the driver program on the client (only differs in `--deploy-mode` parameter):

    spark-submit --conf spark.driver.extraJavaOptions=-XX:MaxPermSize=256M --class ch.ninecode.CIMRDD --jars /usr/local/spark/lib/datanucleus-api-jdo-3.2.6.jar,/usr/local/spark/lib/datanucleus-core-3.2.10.jar,/usr/local/spark/lib/datanucleus-rdbms-3.2.9.jar --master yarn --deploy-mode client --driver-memory 2g --executor-memory 2g --executor-cores 1 --conf spark.sql.hive.thriftServer.singleSession=true /opt/code/CIMReader-2.11-2.0.1-1.8.1.jar "/opt/data/dump_all.xml"

but it's unclear how much is actually executing on the cluster vs. directly on the driver machine.

Using Java directly, you can run the sample program that creates a ThriftServer2 and fills a temporary table using the command line:

    /usr/java/default/bin/java -cp /usr/local/spark/conf/:/usr/local/spark/lib/spark-assembly-1.6.0-hadoop2.6.0.jar:/usr/local/spark/lib/datanucleus-rdbms-3.2.9.jar:/usr/local/spark/lib/datanucleus-api-jdo-3.2.6.jar:/usr/local/spark/lib/datanucleus-core-3.2.10.jar:/usr/local/hadoop/etc/hadoop/:/usr/local/hadoop/etc/hadoop/:/opt/code/CIMReader-2.11-2.0.1-1.8.1.jar -Dscala.usejavacp=true -Xms3g -Xmx3g -XX:MaxPermSize=256m org.apache.spark.deploy.SparkSubmit --master yarn --deploy-mode cluster --conf spark.driver.memory=2g --class ch.ninecode.CIMRDD --name "Dorkhead" --executor-memory 2g --executor-cores 1 --conf spark.sql.hive.thriftServer.singleSession=true --jars /opt/code/CIMReader-2.11-2.0.1-1.8.1.jar "/opt/data/dump_all.xml"

The program can also be executed using:

    export SPARK_SUBMIT_OPTS="$SPARK_SUBMIT_OPTS -Dscala.usejavacp=true"
    spark-submit --class ch.ninecode.CIMRDD --jars /usr/local/spark/lib/datanucleus-api-jdo-3.2.6.jar,/usr/local/spark/lib/datanucleus-core-3.2.10.jar,/usr/local/spark/lib/datanucleus-rdbms-3.2.9.jar --master yarn --deploy-mode client --driver-memory 2g --executor-memory 2g --executor-cores 1 --conf spark.sql.hive.thriftServer.singleSession=true /opt/code/CIMReader-2.11-2.0.1-1.8.1.jar "/opt/data/dump_all.xml"

Incidentally, the Tracking UI for the Application Master is really good.
But it disappears when the program terminates.

# Exposing RDD as Table

The RDD needs to be converted to a dataframe. Using a naive conversion supplying the class as a schema:

    sql_context.createDataFrame (rdd, classOf [ch.ninecode.Element])

it turns out that the dataframe is empty - it has rows, but no columns - indicating a lack of schema.
 
If the second argument is omitted (so it is supposed to do reflection to determine the schema),
it [blows up](https://github.com/apache/spark/blob/master/sql/catalyst/src/main/scala/org/apache/spark/sql/catalyst/ScalaReflection.scala) with:

    sqlContext.createDataFrame (rdd)
    java.lang.UnsupportedOperationException: Schema for type ch.ninecode.Element is not supported
        at org.apache.spark.sql.catalyst.ScalaReflection$class.schemaFor(ScalaReflection.scala:153)

There are at least three ways to supply the schema information:

* supply an explicit schema, e.g. 
    val schema =
      StructType(
        StructField("id", StringType, false) ::
        StructField("data", StructType(XXXXX), true) :: Nil)
as the second argument to sqlContext.createDataFrame (rdd, schema)
* annotate the classes (Element, Location etc.) with `SQLUserDefinedType` and 
define a [User Defined Type e.g. UserDefinedType[Element]](https://github.com/apache/spark/blob/master/sql/core/src/main/scala/org/apache/spark/sql/test/ExamplePointUDT.scala) helper class to perform the serialization
(see also [the test suite]( https://github.com/apache/spark/blob/master/sql/core/src/test/scala/org/apache/spark/sql/UserDefinedTypeSuite.scala))
* refactor the classes to [Scala case classes](http://docs.scala-lang.org/tutorials/tour/case-classes.html) which are similar to [PoJo](https://en.wikipedia.org/wiki/Plain_Old_Java_Object)s
* another way that wasn't explored might be to disguise the data as a `Product` (these are treated specially and look like they will unpack a Tuple)

I've selected to refactor the program into case classes.
This is why this code now works:

    val locations = sqlContext.createDataFrame (locations)

There are a number of base classes that are not case classes.
Specifically Element, IdentifiedElement, NamedElement, and LocatedElement.
Experimentation on what is and isn't possible is ongoing.

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
sparkR.session ("spark://sandbox:7077", "Sample", sparkJars = c ("/home/derrick/code/CIMReader/target/CIMReader-2.11-2.0.1-1.8.1.jar"), sparkEnvir = list (spark.driver.memory="1g", spark.executor.memory="4g", spark.serializer="org.apache.spark.serializer.KryoSerializer"))
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
switch = sql ("select s.sup.sup.sup.sup.mRID mRID, s.sup.sup.sup.sup.aliasName aliasName, s.sup.sup.sup.sup.name name, s.sup.sup.sup.sup.description description, open, normalOpen no, l.CoordinateSystem cs, p.xPosition, p.yPosition from Switch s, Location l, PositionPoint p where s.sup.sup.sup.Location = l.sup.mRID and s.sup.sup.sup.Location = p.Location and p.sequenceNumber = 0")
rswitch = SparkR::collect (switch, stringsAsFactors=FALSE)
```

# Logging

To quiet down the tremendously verbose logging for Spark to just the minimum,
i.e. just warnings and errors, copy and edit the log4j configuration
and set the console logging to WARN instead of INFO:

    $ cd /usr/local/spark-1.6.0-bin-hadoop2.6/conf
    $ cp log4j.properties.template log4j.properties
    $ sed -i 's/log4j.rootCategory=INFO/log4j.rootCategory=WARN/g' log4j.properties


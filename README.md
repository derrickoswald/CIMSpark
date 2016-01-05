CIMScala
======

Spark access to Common Information Model (CIM) files as an RDD.

#Overview

This program reads in a CIM file which is a 
standard interchange format based on IEC standards 61968 & 61970
(see [CIM users group](http://cimug.ucaiug.org/default.aspx) for additional details)
and produces a Spark Resilient Distributed Dataset (RDD).

#Sample Usage

Use sbt or maven to package the app (make a jar file):

    sbt package
or

    mvn package

Start docker (see [An easy way to try Spark](https://hub.docker.com/r/sequenceiq/spark/ "sequenceiq/spark"))
with volumes mounted for the jar file and data:

    docker run -it -p 8088:8088 -p 8042:8042 -v /home/derrick/code/CIMScala/target:/opt/code -v /home/derrick/code/CIMScala/data:/opt/data --rm -h sandbox sequenceiq/spark:1.5.1 bash

Within the docker container, start the spark shell (scala interpreter):

    spark-shell --master yarn-client --driver-memory 3g --executor-memory 1g --executor-cores 1 --jars /opt/code/scala-2.10/cimscala_2.10-0.1.jar,/opt/code/CIMScala-1.0-SNAPSHOT.jar

Execute the standalone program:

	scala> ch.ninecode.CIM.main (Array("/opt/data/dump_all.xml")) 
	available: 98990525 bytes
	reading 0.419546 seconds
	parsing 7.86332 seconds
	203046 PowerSystemResource elements parsed
	0 elements ignored

To generate an RDD use the CIMRDD class:

    scala> val myrdd = ch.ninecode.CIMRDD.rddFile (sc, "/opt/data/dump_all.xml")
    file size: 98990525 bytes
    myrdd: org.apache.spark.rdd.RDD[(String, ch.ninecode.Element)] = ParallelCollectionRDD[0] at parallelize at CIMRDD.scala:25

To get the Location objects:

    scala> val ff = myrdd.filter (x => x._2.getClass() == classOf[ch.ninecode.Location])

or to create an typed RDD of id and Location pairs i.e. (String, Location):

    scala> import ch.ninecode._
    import ch.ninecode._
    
    scala> val pf: PartialFunction[(String, ch.ninecode.Element), (String, ch.ninecode.Location)] =
         |   { case x: (String, Element) if x._2.getClass () == classOf[ch.ninecode.Location] => (x._1, x._2.asInstanceOf[ch.ninecode.Location]) }
    pf: PartialFunction[(String, ch.ninecode.Element),(String, ch.ninecode.Location)] = <function1>
    
    scala> val locations = myrdd.collect (pf)
    locations: org.apache.spark.rdd.RDD[(String, ch.ninecode.Location)] = MapPartitionsRDD[2] at collect at <console>:28
    
    scala> locations.count()
    res3: Long = 26165

    scala> locations.first()._1
    res4: String = _location_1610744576_427087414_2073666

    scala> locations.first()._2.coordinates
    res5: scala.collection.mutable.ArrayBuffer[Double] = ArrayBuffer(8.52831529608, 46.9951049314)

To run the sample program:

    spark-submit --class ch.ninecode.CIMRDD --master yarn-client --driver-memory 3g --executor-memory 1g --executor-cores 1 /opt/code/CIMScala-1.0-SNAPSHOT.jar "/opt/data/dump_all.xml"
or

    spark-submit --class ch.ninecode.CIMRDD --master yarn-cluster --driver-memory 3g --executor-memory 1g --executor-cores 1 /opt/code/CIMScala-1.0-SNAPSHOT.jar "/opt/data/dump_all.xml"

To expose the RDD as a Hive SQL table:

    scala> val mydataframe = sqlContext.createDataFrame (myrdd, classOf [ch.ninecode.Element])
    mydataframe: org.apache.spark.sql.DataFrame = []

    scala> mydataframe.registerTempTable ("myrdd")

    scala> val count = sqlContext.sql("select count(*) n from myrdd")
    15/12/31 02:56:39 INFO parse.ParseDriver: Parsing command: select count(*) n from myrdd
    15/12/31 02:56:39 INFO parse.ParseDriver: Parse Completed
    count: org.apache.spark.sql.DataFrame = [n: bigint]

    scala> count.show()
    +------+
    |     n|
    +------+
    |203046|
    +------+

To expose the RDD as a JDBC accessible table:

start Spark docker container with port 10000 also exposed:

    docker run -it -p 8088:8088 -p 8042:8042 -p 10000:10000 -v /home/derrick/code/CIMScala/target:/opt/code -v /home/derrick/code/CIMScala/data:/opt/data --rm -h sandbox sequenceiq/spark:1.5.1 bash

Start the thrift server:

    bash-4.1# cd /usr/local/spark-1.5.1-bin-hadoop2.6/
    bash-4.1# ./sbin/start-thriftserver.sh
    starting org.apache.spark.sql.hive.thriftserver.HiveThriftServer2, logging to /usr/local/spark-1.5.1-bin-hadoop2.6/sbin/../logs/spark--org.apache.spark.sql.hive.thriftserver.HiveThriftServer2-1-sandbox.out

The java client code requires a shit load of jar fails, which can be black-box included by adding this magic incantation to the maven (what a piece of shit that program is) pom:

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

Then most of the code found in the [Hive2 JDBC client](https://cwiki.apache.org/confluence/display/Hive/HiveServer2+Clients#HiveServer2Clients-JDBC) will work, except for "show tables name" (although "show tables" works) and the fact
that show tables doesn't show registered temporary tables (so like, what the fuck good is that?), but you can query them.
This whole JDBC server on Hive is about as flaky as Kellogs.

The jars to start the thrift server are not automatically added to the classpath,
so use the following to allow execution of a program that creates a Hive SQL context,
but it runs out of memory at the `new HiveContext (spark)` call _[to be investigated]_:

    sbin/start-thriftserver.sh --class ch.ninecode.CIMRDD --master yarn-cluster --driver-memory 3g --executor-memory 1g --executor-cores 1 --jars /opt/code/CIMScala-1.0-SNAPSHOT.jar,/usr/local/spark/lib/datanucleus-api-jdo-3.2.6.jar,/usr/local/spark/lib/datanucleus-core-3.2.10.jar,/usr/local/spark/lib/datanucleus-rdbms-3.2.9.jar "/opt/data/dump_all.xml"

However, the same steps can be performed in the park-shell, and it works. _[to be investigated]_
Then it turns out that the dataframe is empty (it has rows, but no columns) when using this constructor:

    sql_context.createDataFrame (rdd, classOf [ch.ninecode.Element])

If the second argument is omitted (so it is supposed to do reflection to determine the schema),
it [blows up](https://github.com/apache/spark/blob/master/sql/catalyst/src/main/scala/org/apache/spark/sql/catalyst/ScalaReflection.scala) with:

    sqlContext.createDataFrame (rdd)
    java.lang.UnsupportedOperationException: Schema for type ch.ninecode.Element is not supported
        at org.apache.spark.sql.catalyst.ScalaReflection$class.schemaFor(ScalaReflection.scala:153)

so it seems we either need to annotate the classes (Element, Location etc.) with `SQLUserDefinedType`
or somehow simplify the class even more than it is so the brain dead reflection code can understand it.

One way may be to supply the schema, i.e.

    val schema =
      StructType(
        StructField("id", StringType, false) ::
        StructField("data", StructType(XXXXX), true) :: Nil)
    sqlContext.createDataFrame (rdd, schema)

Another way might be to disguise the data as a `Product`. These are treated specially and look like they will unpack a Tuple.



CIMScala
======

Spark access to Common Information Model (CIM) files as RDD and Hive SQL.

#Overview

This program reads in a CIM file which is a 
standard interchange format based on IEC standards 61968 & 61970
(see [CIM users group](http://cimug.ucaiug.org/default.aspx) for additional details)
and produces a Spark Resilient Distributed Dataset (RDD).
The RDD is exposed as a Hive2 table using Thrift.

#Sample Usage

Use sbt or maven to package the app (make a jar file):

    sbt package
or

    mvn package

Start docker (see [An easy way to try Spark](https://hub.docker.com/r/sequenceiq/spark/ "sequenceiq/spark"))
with volumes mounted for the jar file and data, and ports proxied for the
cluster manager (8088), node manager (8042) and JDBC ThriftServer2 (10000):

    docker run -it -p 8088:8088 -p 8042:8042 -p 10000:10000 -v /home/derrick/code/CIMScala/target:/opt/code -v /home/derrick/code/CIMScala/data:/opt/data --rm -h sandbox sequenceiq/spark:1.5.1 bash

The spark shell (scala interpreter) provides interactive commands:

    spark-shell --master yarn --deploy-mode client --driver-memory 2g --executor-memory 2g --executor-cores 1 --jars /opt/code/CIMScala-1.0-SNAPSHOT.jar

Add the CIMScala jar to the classpath:

    scala> import ch.ninecode._
    import ch.ninecode._

To generate an RDD use the CIMRDD class:

    scala> var myrdd = CIMRDD.rddFile (sc, "/opt/data/dump_all.xml")
    file size: 98990525 bytes
    myrdd: org.apache.spark.rdd.RDD[ch.ninecode.Element] = ParallelCollectionRDD[0] at parallelize at CIMRDD.scala:38

To get the Location objects:

    scala> myrdd.filter (x => x.getClass() == classOf[Location]).count()
    ...
    res0: Long = 26165

or to create an typed RDD of Locations:

    scala> var pf: PartialFunction[Element, Location] = { case x: Element if x.getClass () == classOf[Location] => x.asInstanceOf[Location] }
    pf: PartialFunction[ch.ninecode.Element,ch.ninecode.Location] = <function1>

    scala> var subset = myrdd.collect (pf)
    subset: org.apache.spark.rdd.RDD[ch.ninecode.Location] = MapPartitionsRDD[3] at collect at <console>:28
    
    scala> subset.first().coordinates
    ...
    res1: scala.collection.mutable.ArrayBuffer[Double] = ArrayBuffer(8.52831529608, 46.9951049314)

To expose the RDD as a Hive SQL table that is available externally:

    scala> case class PointLocation (id: String,  x: Double, y: Double)
    defined class PointLocation

    scala> var point_pf: PartialFunction[Location, PointLocation] = { case x: Location if x.coordinates.length == 2 => PointLocation (x.id, x.coordinates(0), x.coordinates(1)) }
    point_pf: PartialFunction[ch.ninecode.Location,PointLocation] = <function1>

    scala> var points = subset.collect (point_pf)
    points: org.apache.spark.rdd.RDD[PointLocation] = MapPartitionsRDD[5] at collect at <console>:34

    scala> case class LineLocation (id: String,  x1: Double, y1: Double, x2: Double, y2: Double)
    defined class LineLocation

    scala> var line_pf: PartialFunction[Location, LineLocation] = { case x: Location if x.coordinates.length > 2 => val l = x.coordinates.length; LineLocation (x.id, x.coordinates(0), x.coordinates(1), x.coordinates(l - 2), x.coordinates(l - 1)) }
    line_pf: PartialFunction[ch.ninecode.Location,LineLocation] = <function1>
    
    scala> var points = sqlContext.createDataFrame (subset.collect (point_pf))
    points: org.apache.spark.sql.DataFrame = [id: string, x: double, y: double]
    
    scala> var lines = sqlContext.createDataFrame (subset.collect (line_pf))
    lines: org.apache.spark.sql.DataFrame = [id: string, x1: double, y1: double, x2: double, y2: double]

    scala> points.registerTempTable ("points")
    scala> lines.registerTempTable ("lines")
    
    scala> sqlContext.sql ("select * from points").show ()
    ...
    +--------------------+-------------+-------------+
    |                  id|            x|            y|
    +--------------------+-------------+-------------+
    |_location_1610744...|8.52831529608|46.9951049314|
    |_location_5773096...|8.60289818799| 46.995578585|
    ...
    |_location_1610697...|8.50875932142| 46.993371867|
    +--------------------+-------------+-------------+
    only showing top 20 rows


Starting the thrift server from the command line uses a different SparkContext/SQLContext
so the exposed tables will not be visible (don't do this):

    bash-4.1# cd /usr/local/spark-1.5.1-bin-hadoop2.6/
    bash-4.1# ./sbin/start-thriftserver.sh
    starting org.apache.spark.sql.hive.thriftserver.HiveThriftServer2, logging to /usr/local/spark-1.5.1-bin-hadoop2.6/sbin/../logs/spark--org.apache.spark.sql.hive.thriftserver.HiveThriftServer2-1-sandbox.out

Start the thrift server from within the spark shell:

    scala> import org.apache.spark.sql.hive.thriftserver.HiveThriftServer2
    import org.apache.spark.sql.hive.thriftserver.HiveThriftServer2
    
    scala> HiveThriftServer2.startWithContext (sqlContext.asInstanceOf[org.apache.spark.sql.hive.HiveContext])
    ...
    16/01/12 10:26:23 INFO service.AbstractService: Service:HiveServer2 is started.


The java client code requires a shit load of jar fails,
which can be black-box included by adding this magic incantation in
the maven (I hate Maven) pom:

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

The RDD or Dataframe can be saved as a text, json or parquet file.
A parquet file can be read in by SparkR:

    scala> points.saveAsParquetFile ("file:///opt/data/points")
    scala> lines.saveAsParquetFile ("file:///opt/data/lines")

and it can be read in again using the SqlContext:

    scala> var newpoints = sqlContext.parquetFile ("file:///opt/data/points")
    scala> var newlines = sqlContext.parquetFile ("file:///opt/data/lines")

Note that the DataFrame can be saved as a JSON file through a DataFrameWriter:

    scala> points.write.json ("file:///opt/data/points.json")

and loaded from the JSON file through the SQLContext and a DataFrameReader:

    scala> var newpoints = sqlContext.read.json ("file:///opt/data/points.json")

Note that these are not schema preserving,
since the schema is not included in the output,
and the schema must be inferred from the input.

#Programmatic Usage

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

    spark-submit --conf spark.driver.extraJavaOptions=-XX:MaxPermSize=256M --class ch.ninecode.CIMRDD --jars /usr/local/spark/lib/datanucleus-api-jdo-3.2.6.jar,/usr/local/spark/lib/datanucleus-core-3.2.10.jar,/usr/local/spark/lib/datanucleus-rdbms-3.2.9.jar --master yarn --deploy-mode cluster --driver-memory 2g --executor-memory 2g --executor-cores 1 /opt/code/CIMScala-1.0-SNAPSHOT.jar "/opt/data/dump_all.xml"

To run the driver program on the client (only differs in `--deploy-mode` parameter):

    spark-submit --conf spark.driver.extraJavaOptions=-XX:MaxPermSize=256M --class ch.ninecode.CIMRDD --jars /usr/local/spark/lib/datanucleus-api-jdo-3.2.6.jar,/usr/local/spark/lib/datanucleus-core-3.2.10.jar,/usr/local/spark/lib/datanucleus-rdbms-3.2.9.jar --master yarn --deploy-mode client --driver-memory 2g --executor-memory 2g --executor-cores 1 /opt/code/CIMScala-1.0-SNAPSHOT.jar "/opt/data/dump_all.xml"

but it's unclear how much is actually executing on the cluster vs. directly on the driver machine.

Using Java directly, you can run the sample program that creates a ThriftServer2 and fills a temporary table using the command line:

    /usr/java/default/bin/java -cp /usr/local/spark/conf/:/usr/local/spark/lib/spark-assembly-1.5.1-hadoop2.6.0.jar:/usr/local/spark/lib/datanucleus-rdbms-3.2.9.jar:/usr/local/spark/lib/datanucleus-api-jdo-3.2.6.jar:/usr/local/spark/lib/datanucleus-core-3.2.10.jar:/usr/local/hadoop/etc/hadoop/:/usr/local/hadoop/etc/hadoop/:/opt/code/CIMScala-1.0-SNAPSHOT.jar -Dscala.usejavacp=true -Xms3g -Xmx3g -XX:MaxPermSize=256m org.apache.spark.deploy.SparkSubmit --master yarn --deploy-mode cluster --conf spark.driver.memory=2g --class ch.ninecode.CIMRDD --name "Dorkhead" --executor-memory 2g --executor-cores 1 --jars /opt/code/CIMScala-1.0-SNAPSHOT.jar "/opt/data/dump_all.xml"

The program can also be executed using:

    export SPARK_SUBMIT_OPTS="$SPARK_SUBMIT_OPTS -Dscala.usejavacp=true"
    spark-submit --class ch.ninecode.CIMRDD --jars /usr/local/spark/lib/datanucleus-api-jdo-3.2.6.jar,/usr/local/spark/lib/datanucleus-core-3.2.10.jar,/usr/local/spark/lib/datanucleus-rdbms-3.2.9.jar --master yarn --deploy-mode client --driver-memory 2g --executor-memory 2g --executor-cores 1 /opt/code/CIMScala-1.0-SNAPSHOT.jar "/opt/data/dump_all.xml"

Incidently, the Tracking UI for the Application Master is really good.
But it dissappears when the program terminates.

#Exposing RDD as Table

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

#SparkR

Load the SparkR interpreter:

    sparkR

Read in the data from the DataFrame that was saved as a parquet file:

    > points = parquetFile (sqlContext, "file:///opt/data/points")
or

    > points = read.df (sqlContext, "file:///opt/data/points", "parquet")
    ...
    > nrow(points)
    ...
    [1] 7540

    > head (points)
    ...
                                          id        x        y
    1 _location_1610744576_427087414_2073666 8.528315 46.99510
    2    _location_5773096_1152305167_985581 8.602898 46.99558
    3     _location_5773116_972140366_615398 8.511079 46.99333
    4     _location_5773096_823727318_151097 8.613339 47.00360
    5 _location_1610642176_427083559_1978331 8.585879 47.05440
    6 _location_1610690304_427087038_1995349 8.660671 47.10959

Some exploration

    printSchema(points)
    root
     |-- id: string (nullable = true)
     |-- x: double (nullable = true)
     |-- y: double (nullable = true)

    showDF (points, numRows=3)
    ...
    +--------------------+-------------+-------------+
    |                  id|            x|            y|
    +--------------------+-------------+-------------+
    |_location_1610744...|8.52831529608|46.9951049314|
    |_location_5773096...|8.60289818799| 46.995578585|
    |_location_5773116...| 8.5110791419|46.9933251694|
    +--------------------+-------------+-------------+
    only showing top 3 rows

    points[1:5,]
    Error in points[1:5, ] : object of type 'S4' is not subsettable

#Notes

good pictures:
http://blog.cloudera.com/blog/2014/05/apache-spark-resource-management-and-yarn-app-models/


/usr/local/spark/bin/spark-submit   "sparkr-shell" /tmp/RtmpSScO6S/backend_port1b6469f08b97

.combineByKey  -- coalesce chunks

[probably will cause a shuffle]
.join
.leftOuterJoin -- join operations
.rightOuterJoin
.fullOuterJoin

#Magellan
Add to docker start command:
-v /home/derrick/code/magellan/target/scala-2.10:/opt/magellan 

Add to spark shell start -jars argument:
/opt/magellan/magellan_2.10-1.0.4-SNAPSHOT.jar,

#SAP (faked)

Load the two RDD:

    scala> var main = CIMRDD.rddFile (sc, "/opt/data/dump_all.xml")
    scala> var auxilliary = CIMRDD.rddFile (sc, "/opt/data/dump_all.xml.fake")

Get only the consumers in a correctly typed (Consumer) RDD:

    scala> var pfc: PartialFunction[Element, Consumer] = { case x: Any if x.getClass () == classOf[Consumer] => x.asInstanceOf[Consumer] }
    scala> var consumers = main.collect (pfc)

Get only the AO in a correctly typed (ServiceLocation) RDD:

    scala> var pfa: PartialFunction[Element, ServiceLocation] = { case x: Any if x.getClass () == classOf[ServiceLocation] => x.asInstanceOf[ServiceLocation] }
    scala> var ao = auxilliary.collect (pfa)

[This technique uses PairRDDFunctions.join after creating suitable RDDs of (key, value) pairs]
Join the AO to the consumers by the device (this fake data has the AO device property equal to the house connection id).

    scala> var ao_device = ao.keyBy (_.device)
    scala> var consumers_id = consumers.keyBy (_.id)
    scala> val test = consumers_id.join (ao_device)

    scala> test.first ()
    ...
    res0: (String, (ch.ninecode.Consumer, ch.ninecode.ServiceLocation)) = (_house_connection_1509015,(Consumer(Map(location -> _location_5773073_1158948293_592772, type -> PSRType_Unknown, voltage -> BaseVoltage_0.400000000000, container -> _subnetwork_611053, name -> HAS3478, phase -> http://iec.ch/TC57/2010/CIM-schema-cim15#PhaseShuntConnectionKind.Y, id -> _house_connection_1509015),_house_connection_1509015,HAS3478,_location_5773073_1158948293_592772,_subnetwork_611053,PSRType_Unknown,BaseVoltage_0.400000000000,http://iec.ch/TC57/2010/CIM-schema-cim15#PhaseShuntConnectionKind.Y),ServiceLocation(Map(name -> HAS3478, device -> _house_connection_1509015, id -> _ao_440003786),_ao_440003786,HAS3478,_house_connection_1509015,ArrayBuffer(_customer_1639388908, _customer_530169493, _customer_104...

To build a suitable sample data set (i.e. a couple of vanilla tables for use in SparkR and JDBC):

    scala> case class Sample (id: String, name: String, location: String, container: String, ao: String, x: Double, y: Double)
    defined class Sample
    // create RDD of tuples like: (ch.ninecode.Consumer, ch.ninecode.ServiceLocation, PointLocation)
    scala> var d = test.keyBy (_._2._1.location).join (points.keyBy (_.id)).values.map (x => (x._1._2._1, x._1._2._2, x._2))
    // create RDD of samples like: Sample(_house_connection_1510938,HAS3701,_location_5773108_868271124_1032203,_subnetwork_1040912,_ao_1731001367,8.47789355051,47.0412216907)
    scala> var e = d.map (x => Sample (x._1.id, x._1.name, x._1.location, x._1.container, x._2.id, x._3.x, x._3.y))
    scala> sqlContext.createDataFrame (e).saveAsParquetFile ("file:///opt/data/sample")
    scala> case class Custom (id: String, name: String, kind: String, locale: String, service: String)
    // create RDD of customers
    scala> var c = auxilliary.collect ({ case x: Any if x.getClass () == classOf[Customer] => var l = x.asInstanceOf[Customer]; Custom (l.id, l.name, l.kind, l.locale, l.service) })
    scala> sqlContext.createDataFrame (c).saveAsParquetFile ("file:///opt/data/custom")

From within SparkR:

    > sample = parquetFile (sqlContext, "file:///opt/data/sample")
    > customers = parquetFile (sqlContext, "file:///opt/data/custom")
    > registerTempTable (sample, "sample")
    > registerTempTable (customers, "customers")
    > listing = sql (sqlContext, "select s.id s_id, s.name s_name, s.ao, s.x, s.y, c.id c_id, c.name c_name, c.locale from sample s, customers c where s.ao = c.service")
    > head (listing)
    ...
                           s_id  s_name             ao        x        y                 c_id    c_name locale
    1 _house_connection_1510938 HAS3701 _ao_1731001367 8.477894 47.04122  _customer_789286136 HAS3701_3  de_CH
    2 _house_connection_1510938 HAS3701 _ao_1731001367 8.477894 47.04122 _customer_2089674969 HAS3701_2  fr_CH
    3 _house_connection_1510938 HAS3701 _ao_1731001367 8.477894 47.04122 _customer_2035382401 HAS3701_1  it_CH
    4 _house_connection_1490694 HAS1859  _ao_984540678 8.603125 46.99650 _customer_1258501587 HAS1859_2  de_CH
    5 _house_connection_1490694 HAS1859  _ao_984540678 8.603125 46.99650   _customer_53490086 HAS1859_3  fr_CH
    6 _house_connection_1490694 HAS1859  _ao_984540678 8.603125 46.99650  _customer_458726581 HAS1859_1  it_CH

A sample spatial query (items with a bounding box):

    > brunni = sql (sqlContext, "select s.id s_id, s.name s_name, s.ao, s.x, s.y, c.id c_id, c.name c_name, c.locale from sample s, customers c where s.ao = c.service and s.x between 8.69 and 8.70 and s.y between 47.04 and 47.05")
    > head (brunni)
    ...
                           s_id  s_name             ao        x        y                 c_id    c_name locale
    1 _general_consumer_1554977  APP384 _ao_1187016133 8.695828 47.04810  _customer_835839423  APP384_2  de_CH
    2 _general_consumer_1554977  APP384 _ao_1187016133 8.695828 47.04810   _customer_83892866  APP384_1  de_CH
    3 _house_connection_1501143 HAS2701  _ao_214109919 8.699420 47.04334  _customer_860051847 HAS2701_4  de_CH
    4 _house_connection_1501143 HAS2701  _ao_214109919 8.699420 47.04334  _customer_713218270 HAS2701_2  de_CH
    5 _house_connection_1501143 HAS2701  _ao_214109919 8.699420 47.04334 _customer_1687120939 HAS2701_1  de_CH
    6 _house_connection_1501143 HAS2701  _ao_214109919 8.699420 47.04334 _customer_1034307571 HAS2701_3  de_CH

#DataSource

Add the DataSource cloned from the Avro reference implementation to the sparkR (spark-submit) environment:

    sparkR --jars /opt/code/CIMScala-1.0-SNAPSHOT.jar

I had no success in restarting the SparkContext and SQLContext (don't do this):

    > sparkR.stop()
    > sc = sparkR.init ("yarn-client", "SparkR", sparkJars = "/opt/code/CIMScala-1.0-SNAPSHOT.jar")
    > sqlContext = sparkRSQL.init (sc)

For small files, you can read in the CIM directly:

    > elements = sql (sqlContext, "create temporary table elements using ch.ninecode.cim options (path 'file:///opt/data/dump_ekz.xml')")
    > head (sql (sqlContext, "select * from elements"))
    ...
                    key
    1  PSRType_Substation
    2 PSRType_Underground
    3    PSRType_Overhead
    4     PSRType_Unknown
    5              wgs_84
    6  _subnetwork_349554
    
    > nrow (sql (sqlContext, "show tables"))
    ...
    29
    > options(width=255)
    > head (sql (sqlContext, "select * from PositionPoint"))
    ...
                                            key                            location sequence        x        y
    1 _location_5773088_1107287243_317923_seq_0 _location_5773088_1107287243_317923        0 8.781847 47.04010
    2 _location_5773088_1107289232_293744_seq_0 _location_5773088_1107289232_293744        0 8.782368 47.04018
    3 _location_5773088_1107291573_305270_seq_0 _location_5773088_1107291573_305270        0 8.782220 47.04002
    4 _location_5773088_1107291666_293621_seq_0 _location_5773088_1107291666_293621        0 8.782189 47.03996
    5 _location_5773088_1107302236_320865_seq_0 _location_5773088_1107302236_320865        0 8.782694 47.04011
    6 _location_5773088_1106785491_294319_seq_0 _location_5773088_1106785491_294319        0 8.783009 47.04057
    > head (sql (sqlContext, "select * from Consumer"))
    ...
                             id  name                            location          container             typ                   voltage                                                               phase
    1 _house_connection_1469932  HAS1 _location_5773088_1107287243_317923 _subnetwork_350063 PSRType_Unknown BaseVoltage_0.400000000000 http://iec.ch/TC57/2010/CIM-schema-cim15#PhaseShuntConnectionKind.Y
    2 _house_connection_1469944 HAS10 _location_5773088_1107289232_293744 _subnetwork_349801 PSRType_Unknown BaseVoltage_0.400000000000 http://iec.ch/TC57/2010/CIM-schema-cim15#PhaseShuntConnectionKind.Y
    3 _house_connection_1469956 HAS11 _location_5773088_1107291573_305270 _subnetwork_349754 PSRType_Unknown BaseVoltage_0.400000000000 http://iec.ch/TC57/2010/CIM-schema-cim15#PhaseShuntConnectionKind.Y
    4 _house_connection_1469968 HAS12 _location_5773088_1107291666_293621 _subnetwork_349514 PSRType_Unknown BaseVoltage_0.400000000000 http://iec.ch/TC57/2010/CIM-schema-cim15#PhaseShuntConnectionKind.Y
    5 _house_connection_1469980 HAS13 _location_5773088_1107302236_320865 _subnetwork_349591 PSRType_Unknown BaseVoltage_0.400000000000 http://iec.ch/TC57/2010/CIM-schema-cim15#PhaseShuntConnectionKind.Y
    6 _house_connection_1469992 HAS14 _location_5773088_1106785491_294319 _subnetwork_349545 PSRType_Unknown BaseVoltage_0.400000000000 http://iec.ch/TC57/2010/CIM-schema-cim15#PhaseShuntConnectionKind.Y

You can also copy the CIM file to HDFS and read it from there:

    elements = sql (sqlContext, "create temporary table elements using ch.ninecode.cim options (path 'hdfs:/data/dump_ekz.xml')")

Note that saving the R workspace doesn't work. When you access the data.frames after reloading it says:

    Invalid jobj 4. If SparkR was restarted, Spark operations need to be re-executed.

For larger files, we're having some problems with speed and memory.

    options(width=255)
    elements = sql (sqlContext, "create temporary table elements using ch.ninecode.cim options (path 'file:///opt/data/dump_bkw.xml')")
    fred = sql (sqlContext, "select * from elements")
    nrow (fred)
    ...     takes over six minutes to read 3.8GB
    [0] 8117372

Subsequent accesses run out of heap space.


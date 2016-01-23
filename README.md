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

    spark-shell --master yarn --deploy-mode client --driver-memory 2g --executor-memory 2g --executor-cores 1 --jars /opt/code/scala-2.10/cimscala_2.10-0.1.jar,/opt/code/CIMScala-1.0-SNAPSHOT.jar

To generate an RDD use the CIMRDD class:

    scala> val myrdd = ch.ninecode.CIMRDD.rddFile (sc, "/opt/data/dump_all.xml")
    file size: 98990525 bytes
    myrdd: org.apache.spark.rdd.RDD[(String, ch.ninecode.Element)] = ParallelCollectionRDD[0] at parallelize at CIMRDD.scala:25

To get the Location objects:

    scala> val ff = myrdd.filter (x => x._2.getClass() == classOf[ch.ninecode.Location])

or to create an typed RDD of id and Location pairs i.e. (String, Location):

    scala> val pf: PartialFunction[(String, ch.ninecode.Element), (String, ch.ninecode.Location)] =
         { case x: (String, Any) if x._2.getClass () == classOf[ch.ninecode.Location] => (x._1, x._2.asInstanceOf[ch.ninecode.Location]) }
    pf: PartialFunction[(String, ch.ninecode.Element),(String, ch.ninecode.Location)] = <function1>
    scala> val subset = myrdd.collect (pf)
    subset: org.apache.spark.rdd.RDD[(String, ch.ninecode.Location)] = MapPartitionsRDD[2] at collect at <console>:28
    
    scala> subset.count()
    ...
    res3: Long = 26165
    scala> subset.first()._1
    ...
    res4: String = _location_1610744576_427087414_2073666
    scala> subset.first()._2.coordinates
    ...
    res5: scala.collection.mutable.ArrayBuffer[Double] = ArrayBuffer(8.52831529608, 46.9951049314)

To expose the RDD as a Hive SQL table that is available externally:

    scala> val locations = sqlContext.createDataFrame (subset)
    locations: org.apache.spark.sql.DataFrame = [_1: string, _2: struct<properties:map<string,string>,id:string,cs:string,typ:string,coordinates:array<double>>]
    
    scala> locations.registerTempTable ("locations")
    
    scala> val count = sqlContext.sql("select count(*) n from locations")
    val count = sqlContext.sql("select count(*) n from locations")
    ...
    count: org.apache.spark.sql.DataFrame = [n: bigint]
    
    scala> count.show()
    count.show()
    ...
    +-----+
    |    n|
    +-----+
    |26165|
    +-----+

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
the maven (what a piece of shit that program is) pom:

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

        String tableName = "locations";

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
        while (res.next () && (index++ < 10))
            System.out.println (String.valueOf (res.getString (1)) + "\t" + res.getString (2));
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

    16/01/13 08:22:29 INFO jdbc.Utils: Supplied authorities: localhost:10000
    16/01/13 08:22:29 INFO jdbc.Utils: Resolved authority: localhost:10000
    16/01/13 08:22:30 INFO jdbc.HiveConnection: Will try to open client transport with JDBC Uri: jdbc:hive2://localhost:10000/default
    Running: show tables
        locations
    Running: describe locations
        _1  string
        _2  struct<properties:map<string,string>,id:string,cs:string,typ:string,coordinates:array<double>>
    Running: select * from locations
    _location_1610744576_427087414_2073666  {"properties":{"cs":"wgs_84","id":"_location_1610744576_427087414_2073666","type":"geographic"},"id":"_location_1610744576_427087414_2073666","cs":"wgs_84","typ":"geographic","coordinates":[8.52831529608,46.9951049314]}
    _location_5773117_1164062500_815815 {"properties":{"cs":"wgs_84","id":"_location_5773117_1164062500_815815","type":"geographic"},"id":"_location_5773117_1164062500_815815","cs":"wgs_84","typ":"geographic","coordinates":[8.5512156031,46.9928390755,8.55107434111,46.9934015397,8.54938564426,46.9949313398]}
    _location_5773096_1152305167_985581 {"properties":{"cs":"wgs_84","id":"_location_5773096_1152305167_985581","type":"geographic"},"id":"_location_5773096_1152305167_985581","cs":"wgs_84","typ":"geographic","coordinates":[8.60289818799,46.995578585]}
    _location_5773113_699218750_908358  {"properties":{"cs":"wgs_84","id":"_location_5773113_699218750_908358","type":"geographic"},"id":"_location_5773113_699218750_908358","cs":"wgs_84","typ":"geographic","coordinates":[8.57411513961,47.0561388804,8.57404967284,47.0568799695]}
    _location_1610734848_427085841_1941588  {"properties":{"cs":"wgs_84","id":"_location_1610734848_427085841_1941588","type":"geographic"},"id":"_location_1610734848_427085841_1941588","cs":"wgs_84","typ":"geographic","coordinates":[8.62076427321,47.0015120663,8.62076457045,47.0015255575]}
    _location_5773116_972140366_615398  {"properties":{"cs":"wgs_84","id":"_location_5773116_972140366_615398","type":"geographic"},"id":"_location_5773116_972140366_615398","cs":"wgs_84","typ":"geographic","coordinates":[8.5110791419,46.9933251694]}
    _location_1610686720_427083469_1806704  {"properties":{"cs":"wgs_84","id":"_location_1610686720_427083469_1806704","type":"geographic"},"id":"_location_1610686720_427083469_1806704","cs":"wgs_84","typ":"geographic","coordinates":[8.52348118187,46.9948568184,8.52348145461,46.9948703098]}
    _location_1610724096_427082944_2132876  {"properties":{"cs":"wgs_84","id":"_location_1610724096_427082944_2132876","type":"geographic"},"id":"_location_1610724096_427082944_2132876","cs":"wgs_84","typ":"geographic","coordinates":[8.4742644357,47.0536329009,8.4741806096,47.053381774]}
    _location_1610744576_427087296_1957913  {"properties":{"cs":"wgs_84","id":"_location_1610744576_427087296_1957913","type":"geographic"},"id":"_location_1610744576_427087296_1957913","cs":"wgs_84","typ":"geographic","coordinates":[8.52844647917,46.9950901903,8.52844620518,46.9950766989]}
    _location_1610673920_427086875_1791812  {"properties":{"cs":"wgs_84","id":"_location_1610673920_427086875_1791812","type":"geographic"},"id":"_location_1610673920_427086875_1791812","cs":"wgs_84","typ":"geographic","coordinates":[8.67556778748,47.1042507684,8.67556903395,47.1043047314]}
    Running: select count(1) from locations
    26165
    done

The RDD or Dataframe can be saved as a text file:

    subset.saveAsTextFile ("file:///opt/data/output")
    locations.saveAsTextFile ("file:///opt/data/output")

and it can be read in again using the SparkContext:

    val newrdd = sc.textFile ("file:///opt/data/output")

The DataFrame can be saved as a JSON file through a DataFrameWriter:

    locations.write.json ("file:///opt/data/output")

and loaded from the JSON file through the SQLContext and a DataFrameReader:

    val df = sqlContext.read.json ("file:///opt/data/output")

Note that these are not schema preserving,
since the schema is not included in the output,
and the schem must be inferred from the input.

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

Read in the data from the DataFrame that was saved as a JSON file through a DataFrameWriter:

    locations = jsonFile (sqlContext, "file:///opt/data/output")
or

    locations = read.df (sqlContext, "file:///opt/data/output", "json")
    ...
    nrow(locations)
    ...
    [1] 26165

Some exploration

    locations[,c(1,2)]
    DataFrame[_1:string, _2:struct<coordinates:array<double>,cs:string,id:string,properties:struct<cs:string,id:string,type:string>,typ:string>]

    printSchema(locations)
    root
     |-- _1: string (nullable = true)
     |-- _2: struct (nullable = true)
     |    |-- coordinates: array (nullable = true)
     |    |    |-- element: double (containsNull = true)
     |    |-- cs: string (nullable = true)
     |    |-- id: string (nullable = true)
     |    |-- properties: struct (nullable = true)
     |    |    |-- cs: string (nullable = true)
     |    |    |-- id: string (nullable = true)
     |    |    |-- type: string (nullable = true)
     |    |-- typ: string (nullable = true)

    head (select (locations, locations$"_1"))
    ...
                                          _1
    1 _location_1610737664_427083470_1777780
    2     _location_5773073_827681199_583688
    3   _location_5773096_1150143750_1201312
    4 _location_1610680064_427087119_1803716
    5 _location_1610731520_427087064_2129924
    6     _location_5773116_960904171_604623

    head (select (locations, locations$"_2"))
    ...
    Error in as.data.frame.default(x[[i]], optional = TRUE) :
      cannot coerce class ""jobj"" to a data.frame

    showDF (locations, numRows=3)
    ...
    +--------------------+--------------------+
    |                  _1|                  _2|
    +--------------------+--------------------+
    |_location_1610737...|[WrappedArray(8.5...|
    |_location_5773073...|[WrappedArray(8.6...|
    |_location_5773096...|[WrappedArray(8.6...|
    +--------------------+--------------------+
    only showing top 3 rows

    locations[1:5,]
    Error in locations[1:5, ] : object of type 'S4' is not subsettable

Uh oh, this is why the dataframe conversion fails

    schema = structType (structField ("id", "string", TRUE), structField ("sc", "string", TRUE), structField ("typ", "string", TRUE), structField ("coordinates", "List(DoubleType)", TRUE))
    Error in structField.character("coordinates", "List(DoubleType)", TRUE) :
      Unsupported type for Dataframe: List(DoubleType)


#Notes

good pictures:
http://blog.cloudera.com/blog/2014/05/apache-spark-resource-management-and-yarn-app-models/


/usr/local/spark/bin/spark-submit   "sparkr-shell" /tmp/RtmpSScO6S/backend_port1b6469f08b97


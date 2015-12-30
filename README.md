CIMScala
======

Spark access to Common Information Model (CIM) files as an RDD.

#Overview

This program reads in a CIM file which is a 
standard interchange format based on IEC standards 61968 & 61970
(see [CIM users group](http://cimug.ucaiug.org/default.aspx) for additional details)
and produces a Spark Resilient Distributed Dataset (RDD).

#Sample Usage

_So far this is just a Scala app that happens to run inside a Spark instance._ 

Use sbt or maven to package the app (make a jar file):

    sbt package
or

   mvn package

Copy the jar to a directory visible within Docker:

    cp target/scala-2.10/cimscala_2.10-0.1.jar ../SimpleApp 
or

    cp target/CIMScala-1.0-SNAPSHOT.jar ../SimpleApp

Start docker (see [An easy way to try Spark](https://hub.docker.com/r/sequenceiq/spark/ "sequenceiq/spark")):

    docker run -it -p 8088:8088 -p 8042:8042 -v /home/derrick/code/SimpleApp:/opt/SimpleApp --rm -h sandbox sequenceiq/spark:1.5.1 bash

Within the docker container, start the spark shell (scala interpreter):

    spark-shell --master yarn-client --driver-memory 3g --executor-memory 1g --executor-cores 1

In the spark shell, add the jar to the classpath:

    scala> :cp /opt/SimpleApp/cimscala_2.10-0.1.jar
or

    scala> :cp /opt/SimpleApp/CIMScala-1.0-SNAPSHOT.jar

Execute the program:

	scala> ch.ninecode.CIM.main (Array("/opt/SimpleApp/dump_all.xml")) 
	available: 98990525 bytes
	reading 0.419546 seconds
	parsing 7.86332 seconds
	203046 PowerSystemResource elements parsed
	0 elements ignored

To generate an RDD use the CIMRDD class:

    scala> val myrdd = ch.ninecode.CIMRDD.rddFile (sc, "/opt/SimpleApp/dump_all.xml")
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

    spark-submit --class ch.ninecode.CIMRDD --master yarn-client --driver-memory 3g --executor-memory 1g --executor-cores 1 /opt/SimpleApp/CIMScala-1.0-SNAPSHOT.jar "/opt/SimpleApp/dump_all.xml"
or

    spark-submit --class ch.ninecode.CIMRDD --master yarn-cluster --driver-memory 3g --executor-memory 1g --executor-cores 1 /opt/SimpleApp/CIMScala-1.0-SNAPSHOT.jar "/opt/SimpleApp/dump_all.xml"

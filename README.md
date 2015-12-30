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

`sbt package`
or
`mvn package`

Copy the jar to a directory visible within Docker:

`cp target/scala-2.10/cimscala_2.10-0.1.jar ../SimpleApp` 
or
`cp target/CIMScala-1.0-SNAPSHOT.jar ../SimpleApp`

Start docker (see [An easy way to try Spark](https://hub.docker.com/r/sequenceiq/spark/ "sequenceiq/spark")):

`docker run -it -p 8088:8088 -p 8042:8042 -v /home/derrick/code/SimpleApp:/opt/SimpleApp --rm -h sandbox sequenceiq/spark:1.5.1 bash` 

Within the docker container, start the spark shell (scala interpreter):

`spark-shell --master yarn-client --driver-memory 1g --executor-memory 1g --executor-cores 1` 

In the spark shell, add the jar to the classpath:

`:cp /opt/SimpleApp/cimscala_2.10-0.1.jar`
or
`:cp /opt/SimpleApp/CIMScala-1.0-SNAPSHOT.jar`

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





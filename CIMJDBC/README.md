CIMJDBC
======

The CIM RDDs are also exposed as Hive2 tables using Thrift for legacy JDBC access.
This module comprises two submodules as an example for JDBC access to CIM data in Spark.

# CIMServerJDBC

Reads one or more CIM files and exposes them as a Hive Thrift server.

The program can be executed using spark-submit with the name of the CIMServerJDBC jar file
that includes all necessary dependencies and the CIM file:

    spark-submit /opt/code/CIMServerJDBC-<cim_server_version>-jar-with-dependencies.jar "hdfs://sandbox:8020/data/CGMES_v2.4.15_RealGridTestConfiguration_EQ_v2.xml"
    ...
    Press [Return] to exit...

The program will serve on port 10004 until you press Return.
Incidentally, the Tracking UI for the Application Master (on the master node port 4040) is really good.
But it disappears when the program terminates.

There is a small amount of command line help if you specify --help instead of the CIM file name,
for example on how to change the port number.

# CIMClientJDBC

Sample Java access via JDBC to CIMServerJDBC.

The Java [Hive JDBC driver](https://mvnrepository.com/artifact/org.apache.hive/hive-jdbc/2.0.1)
can be black-box included by adding this magic incantation in
the maven pom:

    <dependency>
        <groupId>org.spark-project.hive</groupId>
        <artifactId>hive-jdbc</artifactId>
        <version>1.2.1.spark2</version>
    </dependency>

Then most of the code found in the [Hive2 JDBC client](https://cwiki.apache.org/confluence/display/Hive/HiveServer2+Clients#HiveServer2Clients-JDBC) will work,
except for "show tables name" (although "show tables" works).



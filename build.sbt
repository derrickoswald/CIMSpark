lazy val root = (project in file(".")).
  settings(
    name := "CIMScala",
    version := "1.6.0-1.7.2",
    scalaVersion := "2.10.5"
  )

libraryDependencies += "org.apache.spark" % "spark-core_2.10" % "1.6.0"
libraryDependencies += "org.apache.spark" % "spark-sql_2.10" % "1.6.0"
libraryDependencies += "org.apache.spark" % "spark-hive-thriftserver_2.10" % "1.6.0"
libraryDependencies += "org.apache.spark" % "spark-graphx_2.10" % "1.6.0"

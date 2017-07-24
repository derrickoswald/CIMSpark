lazy val root = (project in file(".")).
  settings(
    name := "CIMReader",
    version := "2.0.2-2.0.1",
    scalaVersion := "2.11.8"
  )

libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "2.0.2"
libraryDependencies += "org.apache.spark" % "spark-sql_2.11" % "2.0.2"
libraryDependencies += "org.apache.spark" % "spark-hive-thriftserver_2.11" % "2.0.2"
libraryDependencies += "org.apache.spark" % "spark-graphx_2.11" % "2.0.2"

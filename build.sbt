lazy val root = (project in file(".")).
  settings(
    name := "CIMReader",
    version := "2.1.1-2.1.0",
    scalaVersion := "2.11.8"
  )

libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "2.1.1"
libraryDependencies += "org.apache.spark" % "spark-sql_2.11" % "2.1.1"
libraryDependencies += "org.apache.spark" % "spark-hive-thriftserver_2.11" % "2.1.1"
libraryDependencies += "org.apache.spark" % "spark-graphx_2.11" % "2.1.1"
libraryDependencies += "com.github.scopt" % "scopt_2.11" % "3.5.0"
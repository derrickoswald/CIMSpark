lazy val root = (project in file(".")).
  settings(
    name := "CIMReader",
    version := "2.3.1-3.0.1",
    scalaVersion := "2.11.8",
    javaOptions += "-Xss4m"
  )

libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "2.3.1"
libraryDependencies += "org.apache.spark" % "spark-sql_2.11" % "2.3.1"
libraryDependencies += "org.apache.spark" % "spark-hive-thriftserver_2.11" % "2.3.1"
libraryDependencies += "org.apache.spark" % "spark-graphx_2.11" % "2.3.1"
libraryDependencies += "com.github.scopt" % "scopt_2.11" % "3.6.0"
libraryDependencies += "org.scalatest" % "scalatest_2.11" % "3.0.3" % "test"

lazy val cimreader = (project in file(".")).
  settings(
    organization := "ch.ninecode.cim",
    name := "CIMReader",
    version := "2.3.2-3.5.0",
    scalaVersion := "2.11.8",
    licenses += ("MIT", url("http://opensource.org/licenses/MIT")),
    javaOptions += "-Xss4m",
    bintrayPackageLabels := Seq("CIM", "9code")
  )

libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "2.3.2"
libraryDependencies += "org.apache.spark" % "spark-sql_2.11" % "2.3.2"
libraryDependencies += "org.apache.spark" % "spark-hive-thriftserver_2.11" % "2.3.2"
libraryDependencies += "org.apache.spark" % "spark-graphx_2.11" % "2.3.2"
libraryDependencies += "com.github.scopt" % "scopt_2.11" % "3.7.0"
libraryDependencies += "org.scalatest" % "scalatest_2.11" % "3.0.3" % "test"

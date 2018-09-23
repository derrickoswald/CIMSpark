lazy val root = (project in file(".")).
  settings(
    name := "CIMReader",
    version := "2.3.1-3.1.0",
    scalaVersion := "2.11.8",
    licenses += ("MIT", url("http://opensource.org/licenses/MIT")),
    javaOptions += "-Xss4m",
    bintrayPackageLabels := Seq("CIM", "9code")
  )

libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "2.3.1"
libraryDependencies += "org.apache.spark" % "spark-sql_2.11" % "2.3.1"
libraryDependencies += "org.apache.spark" % "spark-hive-thriftserver_2.11" % "2.3.1"
libraryDependencies += "org.apache.spark" % "spark-graphx_2.11" % "2.3.1"
libraryDependencies += "com.github.scopt" % "scopt_2.11" % "3.7.0"
libraryDependencies += "org.scalatest" % "scalatest_2.11" % "3.0.3" % "test"

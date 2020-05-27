lazy val cimreader = (project in file(".")).
  settings(
    organization := "ch.ninecode.cim",
    name := "CIMReader",
    version := "2.4.5-4.2.0",
    scalaVersion := "2.11.12",
    licenses += ("MIT", url("http://opensource.org/licenses/MIT")),
    javaOptions += "-Xss4m",
    bintrayPackageLabels := Seq("CIM", "9code")
  )

resolvers ++= Seq (
    "releases" at "http://oss.sonatype.org/content/repositories/releases"
)
libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "2.4.3"
libraryDependencies += "org.apache.spark" % "spark-sql_2.11" % "2.4.3"
libraryDependencies += "org.apache.spark" % "spark-hive-thriftserver_2.11" % "2.4.3"
libraryDependencies += "org.apache.spark" % "spark-graphx_2.11" % "2.4.3"
libraryDependencies += "com.github.scopt" % "scopt_2.11" % "4.0.0-RC2"
libraryDependencies += "org.scalatest" % "scalatest_2.11" % "3.0.8" % "test"

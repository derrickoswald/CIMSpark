lazy val cimreader = (project in file(".")).
  settings(
    organization := "ch.ninecode.cim",
    name := "CIMReader",
    version := "3.0.0-5.0.1",
    scalaVersion := "2.12.10",
    licenses += ("MIT", url("http://opensource.org/licenses/MIT")),
    javaOptions += "-Xss4m",
    bintrayPackageLabels := Seq("CIM", "9code")
  )

resolvers ++= Seq (
    "releases" at "http://oss.sonatype.org/content/repositories/releases"
)
libraryDependencies += "org.apache.spark" % "spark-core_2.12" % "3.0.0"
libraryDependencies += "org.apache.spark" % "spark-sql_2.12" % "3.0.0"
libraryDependencies += "org.apache.spark" % "spark-hive-thriftserver_2.12" % "3.0.0"
libraryDependencies += "org.apache.spark" % "spark-graphx_2.12" % "3.0.0"
libraryDependencies += "com.github.scopt" % "scopt_2.12" % "4.0.0-RC2"
libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.8" % "test"

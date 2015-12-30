lazy val root = (project in file(".")).
  settings(
    name := "CIMScala",
    version := "0.1",
    scalaVersion := "2.10.4"
  )

libraryDependencies += "org.apache.spark" % "spark-core_2.10" % "1.5.2"

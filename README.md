CIMSpark
======
[![Build Status](http://jenkins.zoephos.com/job/CIMSpark/job/ci-getting-started/badge/icon)](http://jenkins.zoephos.com/job/CIMSpark/job/ci-getting-started/)

Spark access to Common Information Model (CIM) files. | [![Maven Central](https://img.shields.io/maven-central/v/ch.ninecode.cim/CIMSpark.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22ch.ninecode.cim%22%20AND%20a:%22CIMSpark%22)
:---         |          ---:

# Overview

This project joins the two worlds of the
[Apache Spark](https://en.wikipedia.org/wiki/Apache_Spark) computation model and the
Common Information Model ([CIM](https://en.wikipedia.org/wiki/Common_Information_Model_(electricity))) data model.


A good overview presentation is [Network Analysis and Simulation using Apache Spark on Compute Clusters](https://derrickoswald.github.io/CIMSparkPresentation/index.html?audio), or [without the audio tracks](https://derrickoswald.github.io/CIMSparkPresentation).

![Overview](https://cdn.jsdelivr.net/gh/derrickoswald/CIMSpark@master/img/Overview.svg "Overview diagram")


# Model

The CIM model as implemented by this software is described in [CIM Model](Model.md)
and is described in detail in the [ScalaDoc](https://derrickoswald.github.io/CIMSpark).

# Functionality

This project has four components covering the following topics:

- __CIMTool__ to generate Scala and Javascript classes from the *Enterprise Architect* UML files
- __CIMReader__ the main component that reads CIM files into Apache Spark RDD data structures
- __CIMExport__ to generate RDF files from Apache Spark RDD data structures
- __CIMJDBC__ example server and client JDBC access to CIM files loaded into Apache Spark RDD data structures

Each of these is described more fully in its module README.


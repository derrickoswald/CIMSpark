CIMSpark
======

Spark access to Common Information Model (CIM) files.

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

# Getting Started

The easiest way to get your own instance of CIMSpark up and running is to use Docker. This repo comes with a docker-compose file to help you get started. 

```
clone CIMSpark repo
cd CIMSpark/CIMReader/src/test/resources; ./start-docker
``


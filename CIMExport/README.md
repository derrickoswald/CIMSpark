CIMExport
======

Generate Common Information Model (CIM) RDF files from Spark data structures.| [![Maven Central](https://img.shields.io/maven-central/v/ch.ninecode.cim/CIMExport.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22ch.ninecode.cim%22%20AND%20a:%22CIMExport%22)
:---         |          ---:

# Overview

This comprises four functions for export:

- export() to export an arbitrary RDD of CIM Element objects
- exportIsland() to export a named topological island and related elements into a CIM file
- exportAllIslands() to export all topological islands and related elements each in a separate CIM file
- exportAllTransformers() to export all transformer service areas and related elements each in a separate CIM file

# Building

Assuming Maven [mvn](https://maven.apache.org/) is installed, to package CIMExport (make a jar file) follow these steps:

* Change to the top level CIMExport directory:
```
cd CIMSpark/CIMExport
```
* Invoke the package or install command:
```
mvn -Dmaven.test.skip=true -DskipTests -DskipITs install
```

This should produce a jar file in the target/ directory.

**NOTE: The unit tests and integration tests can be skipped if you add the magic incantation `mvn -DskipTests -DskipITs install`**


CIMExport
======

Generate Common Information Model (CIM) RDF files from Spark data structures.

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
mvn package
```

This should produce a jar file in the target/ directory.

**NOTE: The unit tests and integration tests can be skipped if you add the magic incantation `mvn -DskipTests -DskipITs install`**


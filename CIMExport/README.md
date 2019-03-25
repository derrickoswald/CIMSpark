CIMExport
======

Generate Common Information Model (CIM) RDF files from Spark data structures.

# Overview

This comprises four functions for export:

- export() to export an arbitrary RDD of CIM Element objects
- exportIsland() to export a named topological island and related elements into a CIM file
- exportAllIslands() to export all topological islands and related elements each in a separate CIM file
- exportAllTransformers() to export all transformer service areas and related elements each in a separate CIM file



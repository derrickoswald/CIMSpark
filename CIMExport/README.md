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

# Stand-alone Operation

The normal build process also generates a stand-alone program in the `target/` directory.
This is executed using the `spark-submit` command. It can provide help text with the --help option: 

``` bash
$ spark-submit --master spark://sandbox:7077 --executor-memory 4g --driver-memory 1g target/CIMExport-2.11-2.4.4-4.1.2-jar-with-dependencies.jar --help
CIMExportMain 2.11-2.4.4-4.1.2
Usage: CIMExportMain [options] <CIM> <CIM> ...

Extracts subsets of CIM files based on topology.

  --help                   prints this usage text
  --version                Scala: 2.11, Spark: 2.4.4, CIMExportMain: 4.1.2
  --quiet                  suppress informational messages [false]
  --logging <value>        log level, one of ALL,DEBUG,ERROR,FATAL,INFO,OFF,TRACE,WARN [OFF]
  --sparkopts k1=v1,k2=v2  Spark options [spark.graphx.pregel.checkpointInterval=8,spark.serializer=org.apache.spark.serializer.KryoSerializer,spark.ui.showConsoleProgress=false]
  --cimopts k1=v1,k2=v2    CIMReader options [ch.ninecode.cim.do_topo_islands=true]
  --all                    export entire processed file [false]
  --islands                export topological islands [false]
  --transformers           export transformer service areas [false]
  --outputfile <file>      output file name [export.rdf]
  --outputdir <dir>        output directory name [simulation/]
  --cassandra              output transformer metadata to cassandra [false]
  --host <cassandra>       Cassandra connection host (listen_address or seed in cassandra.yaml) [localhost]
  --keyspace <name>        keyspace to use if cassandra specified [cimexport]
  <CIM> <CIM> ...          CIM rdf files to process
```

In general, files are generated, unless the `--cassandra` option is specified.
In this case the results are written to the `--keyspace` specified, in tables:
- **export** the execution description
- **transformers** the transformer service areas
- **transformer_service_area** the metadata about the transformer service areas
- **boundary_switches** descriptions of open switches joining transformer service areas

The various operation modes are described below.

## All
Using the `--all` option, the processed file(s) are exported as a single CIM file specified by the `--outputfile` option.
This satisfies the use-case of applying various CIMReader `--cimopts`, e.g. deduplication or topological analysis,
and saving the resulting data as a new CIM composite.

## Islands
All `TopologicalIsland` subsets in the CIM file are exported to the `--outputdir` specified.
This has limited use, but you can build subsets of the input CIM file(s) based on topological islands.

## Transformers
Individual transformer service areas can be exported with the `--transformers` option.
Transformer low voltage winding islands in the CIM file are exported to the `--outputdir` specified
with names corresponding to the controlling transformer(s).
This can be used to isolate problems to small, easily consumed, bite-size chunks for testing or detailed analysis.


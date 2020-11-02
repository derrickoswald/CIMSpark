CIMDifference
======

Comare Common Information Model (CIM) RDF files.| [![Maven Central](https://img.shields.io/maven-central/v/ch.ninecode.cim/CIMDifference.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22ch.ninecode.cim%22%20AND%20a:%22CIMDifference%22)
:---         |          ---:

# Overview

Compares two CIM files for differences and outputs in three formats:

1) **Summary**: a simple numerical summary of added, deleted and changed elements.
2) **HumanReadable**: A listing of differences for added, deleted and changed elements, in a (sort-of) readable output.
3) **ChangeSet**: An XML formatted difference compatible with the CIM difference model.

The latter two formats require you to specify an output file.

# Operation

First it reads the two (could actually be a comma separated list for each) CIM files into separate RDD[Element].
Then it performs a full outer join using mRID (primary key) between the two RDD
to determine elements in one but not the other or pairs of matching elements.

It then outputs one of the two formats based on this join.

CIMTool
======

This package reads and extracts the packages, classes, attributes and relations from the
CIM model distribution format (Enterprise Architect) .eap files.
It generates Scla and Javascript class definitions used in parsing, manipulation and export.

# Getting CIM Distribution UML Models

CIM is an open standard. The model is available from [CIMUG](https://cimug.ucaiug.org/).
The IEC standards body sells standards based on it.

Step by step:

- Join CIMUG.
- Log into their website.
- Under CIM Documents, go to Current CIM Model Drafts (or Past CIM Model Releases).
- Download your choice of model file, e.g. iec61970cim17…
- Unzip.
- Open the [Enterprise Architect](https://sparxsystems.us/home/software/sparxea/) file (.eap extension).

These .eap files need to be placed in the private_data/ directory in order for CIMTool to work.
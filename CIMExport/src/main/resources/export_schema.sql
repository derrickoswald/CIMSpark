create keyspace if not exists cimexport with replication = {'class': 'SimpleStrategy', 'replication_factor': 2 };

create type if not exists cimexport.polygon_data (type text, coordinates list<frozen <list<frozen <list<double>>>>>);

create table if not exists cimexport.export (
    id text,
    runtime timestamp,
    filename text,
    filetime timestamp,
    filesize bigint,
    primary key (id)
) with comment = '
Export metadata.
    id        - the export run identifier, UUID
    runtime   - the execution time of the export
    filename  - the origin CIM RDF file name
    filetime  - the timestamp of the source file
    filesize  - the size of the source file
';

create table if not exists cimexport.transformers (
    id text,
    name text,
    elements frozen <map<text,text>>,
    filesize bigint,
    zipsize bigint,
    cim blob,
    primary key (id, name)
) with comment = '
Export transformer service area.
These are descriptions of exported transformer service areas.
    id         - the export run identifier, UUID
    name       - the unique name for the transformer, for unganged transformers the mRID of the transformer
    elements   - the map of mRIDs of the contained elements and their class
    filesize   - the size of the file before zip compression
    zipsize    - the size of the zip blob after compression
    cim        - the zipped CIM elements
';

create table if not exists cimexport.transformer_service_area (
    id text,
    name text,
    type text,
    geometry frozen<cimexport.polygon_data>,
    properties map<text,text>,
    primary key (id, name)
) with comment = '
Export metadata.
These are descriptions of exported transformer service areas.
    id         - the export run identifier, UUID
    name       - the unique name for the transformer, for unganged transformers the mRID of the transformer
    type       - the type of GeoJSON ("Feature")
    geometry   - the type of object ("Polygon") and coordinates
    properties - associated properties of the transformer service area
';

create table if not exists cimexport.boundary_switches (
    id text,
    mrid text,
    island1 text,
    island2 text,
    primary key (id, mrid)
    ) with comment = '
Connections between transformer service areas.
    id         - the export run identifier, UUID
    mrid       - the mRID of the switch
    island1    - the island label on one side of the switch
    island2    - the island label on the other side of the switch
';

package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship
import ch.ninecode.cim.CIMSerializer

/**
 * A named list of alert types.
 *
 * Note:  the name of the list is reflected in the .name attribute (inherited from IdentifiedObject).
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param version The version of the named list of alert types.
 * @param EnvironmentalAlert [[ch.ninecode.model.EnvironmentalAlert EnvironmentalAlert]] An alert whose type is drawn from this alert type list.
 * @param EnvironmentalDataAuthority [[ch.ninecode.model.EnvironmentalDataAuthority EnvironmentalDataAuthority]] The environmental data authority responsible for publishing this list of alert types.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class AlertTypeList
(
    IdentifiedObject: IdentifiedObject = null,
    version: String = null,
    EnvironmentalAlert: List[String] = null,
    EnvironmentalDataAuthority: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AlertTypeList.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AlertTypeList.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AlertTypeList.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (AlertTypeList.fields (position), x))
        emitelem (0, version)
        emitattrs (1, EnvironmentalAlert)
        emitattr (2, EnvironmentalDataAuthority)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AlertTypeList rdf:ID=\"%s\">\n%s\t</cim:AlertTypeList>".format (id, export_fields)
    }
}

object AlertTypeList
extends
    CIMParseable[AlertTypeList]
{
    override val fields: Array[String] = Array[String] (
        "version",
        "EnvironmentalAlert",
        "EnvironmentalDataAuthority"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("EnvironmentalAlert", "EnvironmentalAlert", "0..*", "1"),
        CIMRelationship ("EnvironmentalDataAuthority", "EnvironmentalDataAuthority", "0..1", "0..*")
    )
    val version: Fielder = parse_element (element (cls, fields(0)))
    val EnvironmentalAlert: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val EnvironmentalDataAuthority: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): AlertTypeList =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AlertTypeList (
            IdentifiedObject.parse (context),
            mask (version (), 0),
            masks (EnvironmentalAlert (), 1),
            mask (EnvironmentalDataAuthority (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

object AlertTypeListSerializer extends CIMSerializer[AlertTypeList]
{
    def write (kryo: Kryo, output: Output, obj: AlertTypeList): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.version),
            () => writeList (obj.EnvironmentalAlert, output),
            () => output.writeString (obj.EnvironmentalDataAuthority)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AlertTypeList]): AlertTypeList =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AlertTypeList (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Analog (float) measuring an atmospheric condition.
 *
 * @param EnvironmentalAnalog [[ch.ninecode.model.EnvironmentalAnalog EnvironmentalAnalog]] Reference to the superclass object.
 * @param kind Kind of atmospheric analog.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class AtmosphericAnalog
(
    EnvironmentalAnalog: EnvironmentalAnalog = null,
    kind: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: EnvironmentalAnalog = EnvironmentalAnalog

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AtmosphericAnalog.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AtmosphericAnalog.fields (position), value)
        emitattr (0, kind)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AtmosphericAnalog rdf:ID=\"%s\">\n%s\t</cim:AtmosphericAnalog>".format (id, export_fields)
    }
}

object AtmosphericAnalog
extends
    CIMParseable[AtmosphericAnalog]
{
    override val fields: Array[String] = Array[String] (
        "kind"
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): AtmosphericAnalog =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AtmosphericAnalog (
            EnvironmentalAnalog.parse (context),
            mask (kind (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object AtmosphericAnalogSerializer extends CIMSerializer[AtmosphericAnalog]
{
    def write (kryo: Kryo, output: Output, obj: AtmosphericAnalog): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.kind)
        )
        EnvironmentalAnalogSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AtmosphericAnalog]): AtmosphericAnalog =
    {
        val parent = EnvironmentalAnalogSerializer.read (kryo, input, classOf[EnvironmentalAnalog])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AtmosphericAnalog (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An atmospheric phenomenon with a base and altitude providing the vertical coverage (combined with the Location to provide three dimensional space).
 *
 * @param EnvironmentalPhenomenon [[ch.ninecode.model.EnvironmentalPhenomenon EnvironmentalPhenomenon]] Reference to the superclass object.
 * @param altitude The maximum altitude of the phenomenon.
 * @param base The base altitude of the phenomenon.
 * @param direction The direction the phenomenon is moving.
 * @param maxCoverage The maximum percentage coverage
 * @param minCoverage The minimum percentage coverage
 * @param speed The speed of the phenomenon
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class AtmosphericPhenomenon
(
    EnvironmentalPhenomenon: EnvironmentalPhenomenon = null,
    altitude: String = null,
    base: String = null,
    direction: Double = 0.0,
    maxCoverage: Double = 0.0,
    minCoverage: Double = 0.0,
    speed: Double = 0.0
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: EnvironmentalPhenomenon = EnvironmentalPhenomenon

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AtmosphericPhenomenon.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AtmosphericPhenomenon.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AtmosphericPhenomenon.fields (position), value)
        emitattr (0, altitude)
        emitattr (1, base)
        emitelem (2, direction)
        emitelem (3, maxCoverage)
        emitelem (4, minCoverage)
        emitelem (5, speed)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AtmosphericPhenomenon rdf:ID=\"%s\">\n%s\t</cim:AtmosphericPhenomenon>".format (id, export_fields)
    }
}

object AtmosphericPhenomenon
extends
    CIMParseable[AtmosphericPhenomenon]
{
    override val fields: Array[String] = Array[String] (
        "altitude",
        "base",
        "direction",
        "maxCoverage",
        "minCoverage",
        "speed"
    )
    val altitude: Fielder = parse_attribute (attribute (cls, fields(0)))
    val base: Fielder = parse_attribute (attribute (cls, fields(1)))
    val direction: Fielder = parse_element (element (cls, fields(2)))
    val maxCoverage: Fielder = parse_element (element (cls, fields(3)))
    val minCoverage: Fielder = parse_element (element (cls, fields(4)))
    val speed: Fielder = parse_element (element (cls, fields(5)))

    def parse (context: CIMContext): AtmosphericPhenomenon =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AtmosphericPhenomenon (
            EnvironmentalPhenomenon.parse (context),
            mask (altitude (), 0),
            mask (base (), 1),
            toDouble (mask (direction (), 2)),
            toDouble (mask (maxCoverage (), 3)),
            toDouble (mask (minCoverage (), 4)),
            toDouble (mask (speed (), 5))
        )
        ret.bitfields = bitfields
        ret
    }
}

object AtmosphericPhenomenonSerializer extends CIMSerializer[AtmosphericPhenomenon]
{
    def write (kryo: Kryo, output: Output, obj: AtmosphericPhenomenon): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.altitude),
            () => output.writeString (obj.base),
            () => output.writeDouble (obj.direction),
            () => output.writeDouble (obj.maxCoverage),
            () => output.writeDouble (obj.minCoverage),
            () => output.writeDouble (obj.speed)
        )
        EnvironmentalPhenomenonSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AtmosphericPhenomenon]): AtmosphericPhenomenon =
    {
        val parent = EnvironmentalPhenomenonSerializer.read (kryo, input, classOf[EnvironmentalPhenomenon])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AtmosphericPhenomenon (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A classification condition used to define preconditions that must be met by a phenomena classification.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param duration The duration of the of the condition in seconds
 * @param test The test applied to the value.
 * @param EnvironmentalAnalog [[ch.ninecode.model.EnvironmentalAnalog EnvironmentalAnalog]] Analog which contributes to the definition of this classification condition.
 * @param EnvironmentalStringMeasurement [[ch.ninecode.model.EnvironmentalStringMeasurement EnvironmentalStringMeasurement]] String measurement which contributes to the definition of this classification condition.
 * @param PhenomenonClassification [[ch.ninecode.model.PhenomenonClassification PhenomenonClassification]] Phenomenon classification to which this condition relates.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class ClassificationCondition
(
    IdentifiedObject: IdentifiedObject = null,
    duration: Double = 0.0,
    test: String = null,
    EnvironmentalAnalog: List[String] = null,
    EnvironmentalStringMeasurement: List[String] = null,
    PhenomenonClassification: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ClassificationCondition.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ClassificationCondition.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ClassificationCondition.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ClassificationCondition.fields (position), x))
        emitelem (0, duration)
        emitattr (1, test)
        emitattrs (2, EnvironmentalAnalog)
        emitattrs (3, EnvironmentalStringMeasurement)
        emitattr (4, PhenomenonClassification)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ClassificationCondition rdf:ID=\"%s\">\n%s\t</cim:ClassificationCondition>".format (id, export_fields)
    }
}

object ClassificationCondition
extends
    CIMParseable[ClassificationCondition]
{
    override val fields: Array[String] = Array[String] (
        "duration",
        "test",
        "EnvironmentalAnalog",
        "EnvironmentalStringMeasurement",
        "PhenomenonClassification"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("EnvironmentalAnalog", "EnvironmentalAnalog", "0..*", "0..1"),
        CIMRelationship ("EnvironmentalStringMeasurement", "EnvironmentalStringMeasurement", "0..*", "0..1"),
        CIMRelationship ("PhenomenonClassification", "PhenomenonClassification", "0..1", "0..*")
    )
    val duration: Fielder = parse_element (element (cls, fields(0)))
    val test: Fielder = parse_attribute (attribute (cls, fields(1)))
    val EnvironmentalAnalog: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val EnvironmentalStringMeasurement: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val PhenomenonClassification: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: CIMContext): ClassificationCondition =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ClassificationCondition (
            IdentifiedObject.parse (context),
            toDouble (mask (duration (), 0)),
            mask (test (), 1),
            masks (EnvironmentalAnalog (), 2),
            masks (EnvironmentalStringMeasurement (), 3),
            mask (PhenomenonClassification (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

object ClassificationConditionSerializer extends CIMSerializer[ClassificationCondition]
{
    def write (kryo: Kryo, output: Output, obj: ClassificationCondition): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.duration),
            () => output.writeString (obj.test),
            () => writeList (obj.EnvironmentalAnalog, output),
            () => writeList (obj.EnvironmentalStringMeasurement, output),
            () => output.writeString (obj.PhenomenonClassification)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ClassificationCondition]): ClassificationCondition =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ClassificationCondition (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A classified cloud phenomenon with a type.
 *
 * @param AtmosphericPhenomenon [[ch.ninecode.model.AtmosphericPhenomenon AtmosphericPhenomenon]] Reference to the superclass object.
 * @param kind The type of the cloud as defined by the CloudKind enumeration.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class CloudCondition
(
    AtmosphericPhenomenon: AtmosphericPhenomenon = null,
    kind: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: AtmosphericPhenomenon = AtmosphericPhenomenon

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CloudCondition.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CloudCondition.fields (position), value)
        emitattr (0, kind)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CloudCondition rdf:ID=\"%s\">\n%s\t</cim:CloudCondition>".format (id, export_fields)
    }
}

object CloudCondition
extends
    CIMParseable[CloudCondition]
{
    override val fields: Array[String] = Array[String] (
        "kind"
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): CloudCondition =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CloudCondition (
            AtmosphericPhenomenon.parse (context),
            mask (kind (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object CloudConditionSerializer extends CIMSerializer[CloudCondition]
{
    def write (kryo: Kryo, output: Output, obj: CloudCondition): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.kind)
        )
        AtmosphericPhenomenonSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CloudCondition]): CloudCondition =
    {
        val parent = AtmosphericPhenomenonSerializer.read (kryo, input, classOf[AtmosphericPhenomenon])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CloudCondition (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A cyclone (or tropical cyclone), a rapidly-rotating storm system characterized by a low-pressure center, strong winds, and a spiral arrangement of thunderstorms that produce heavy rain.
 *
 * @param AtmosphericPhenomenon [[ch.ninecode.model.AtmosphericPhenomenon AtmosphericPhenomenon]] Reference to the superclass object.
 * @param centralPressure The central pressure of the cyclone during the time interval.
 * @param maxSurfaceWindSpeed The maximum surface wind speed of the cyclone during the time interval.
 * @param windForce Wind Force as classified on the Beaufort Scale (0-12) during the time interval.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class Cyclone
(
    AtmosphericPhenomenon: AtmosphericPhenomenon = null,
    centralPressure: Double = 0.0,
    maxSurfaceWindSpeed: Double = 0.0,
    windForce: Int = 0
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: AtmosphericPhenomenon = AtmosphericPhenomenon

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Cyclone.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Cyclone.fields (position), value)
        emitelem (0, centralPressure)
        emitelem (1, maxSurfaceWindSpeed)
        emitelem (2, windForce)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Cyclone rdf:ID=\"%s\">\n%s\t</cim:Cyclone>".format (id, export_fields)
    }
}

object Cyclone
extends
    CIMParseable[Cyclone]
{
    override val fields: Array[String] = Array[String] (
        "centralPressure",
        "maxSurfaceWindSpeed",
        "windForce"
    )
    val centralPressure: Fielder = parse_element (element (cls, fields(0)))
    val maxSurfaceWindSpeed: Fielder = parse_element (element (cls, fields(1)))
    val windForce: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: CIMContext): Cyclone =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Cyclone (
            AtmosphericPhenomenon.parse (context),
            toDouble (mask (centralPressure (), 0)),
            toDouble (mask (maxSurfaceWindSpeed (), 1)),
            toInteger (mask (windForce (), 2))
        )
        ret.bitfields = bitfields
        ret
    }
}

object CycloneSerializer extends CIMSerializer[Cyclone]
{
    def write (kryo: Kryo, output: Output, obj: Cyclone): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.centralPressure),
            () => output.writeDouble (obj.maxSurfaceWindSpeed),
            () => output.writeInt (obj.windForce)
        )
        AtmosphericPhenomenonSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Cyclone]): Cyclone =
    {
        val parent = AtmosphericPhenomenonSerializer.read (kryo, input, classOf[AtmosphericPhenomenon])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Cyclone (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readInt else 0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An earthquake.
 *
 * @param GeosphericPhenomenon [[ch.ninecode.model.GeosphericPhenomenon GeosphericPhenomenon]] Reference to the superclass object.
 * @param focalDepth The depth below the earth's surface of the earthquake's focal point.
 * @param intensity The intensity of the earthquake as defined by the Modified Mercalli Intensity (MMI) scale.
 *        Possible values are 1-12, corresponding to I-XII.
 * @param magnitude The magnitude of the earthquake as defined on the Moment Magnitude (M<sub>w</sub>) scale, which measures the size of earthquakes in terms of the energy released.
 *        Must be greater than zero.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class Earthquake
(
    GeosphericPhenomenon: GeosphericPhenomenon = null,
    focalDepth: String = null,
    intensity: Int = 0,
    magnitude: Double = 0.0
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: GeosphericPhenomenon = GeosphericPhenomenon

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Earthquake.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Earthquake.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Earthquake.fields (position), value)
        emitattr (0, focalDepth)
        emitelem (1, intensity)
        emitelem (2, magnitude)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Earthquake rdf:ID=\"%s\">\n%s\t</cim:Earthquake>".format (id, export_fields)
    }
}

object Earthquake
extends
    CIMParseable[Earthquake]
{
    override val fields: Array[String] = Array[String] (
        "focalDepth",
        "intensity",
        "magnitude"
    )
    val focalDepth: Fielder = parse_attribute (attribute (cls, fields(0)))
    val intensity: Fielder = parse_element (element (cls, fields(1)))
    val magnitude: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: CIMContext): Earthquake =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Earthquake (
            GeosphericPhenomenon.parse (context),
            mask (focalDepth (), 0),
            toInteger (mask (intensity (), 1)),
            toDouble (mask (magnitude (), 2))
        )
        ret.bitfields = bitfields
        ret
    }
}

object EarthquakeSerializer extends CIMSerializer[Earthquake]
{
    def write (kryo: Kryo, output: Output, obj: Earthquake): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.focalDepth),
            () => output.writeInt (obj.intensity),
            () => output.writeDouble (obj.magnitude)
        )
        GeosphericPhenomenonSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Earthquake]): Earthquake =
    {
        val parent = GeosphericPhenomenonSerializer.read (kryo, input, classOf[GeosphericPhenomenon])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Earthquake (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readInt else 0,
            if (isSet (2)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An environmental alert issued by a provider or system.
 *
 * @param ActivityRecord [[ch.ninecode.model.ActivityRecord ActivityRecord]] Reference to the superclass object.
 * @param alertType The type of the issued alert which is drawn from the specified alert type list.
 * @param cancelledDateTime Time and date alert cancelled.
 *        Used only if alert is cancelled before it expires.
 * @param headline An abbreviated textual description of the alert issued.
 *        Note: the full text of the alert appears in the .description attribute (inherited from IdentifiedObject).
 * @param inEffect The interval for which this weather alert is in effect.
 * @param AlertTypeList [[ch.ninecode.model.AlertTypeList AlertTypeList]] The list of alert types from which the type of this alert is drawn.
 * @param EnvironmentalDataProvider [[ch.ninecode.model.EnvironmentalDataProvider EnvironmentalDataProvider]] Environmental data provider for this alert.
 * @param EnvironmentalLocationKind [[ch.ninecode.model.EnvironmentalLocationType EnvironmentalLocationType]] Type of location to which this environmental alert applies.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class EnvironmentalAlert
(
    ActivityRecord: ActivityRecord = null,
    alertType: String = null,
    cancelledDateTime: String = null,
    headline: String = null,
    inEffect: String = null,
    AlertTypeList: String = null,
    EnvironmentalDataProvider: String = null,
    EnvironmentalLocationKind: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: ActivityRecord = ActivityRecord

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EnvironmentalAlert.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EnvironmentalAlert.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnvironmentalAlert.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (EnvironmentalAlert.fields (position), x))
        emitelem (0, alertType)
        emitelem (1, cancelledDateTime)
        emitelem (2, headline)
        emitattr (3, inEffect)
        emitattr (4, AlertTypeList)
        emitattr (5, EnvironmentalDataProvider)
        emitattrs (6, EnvironmentalLocationKind)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnvironmentalAlert rdf:ID=\"%s\">\n%s\t</cim:EnvironmentalAlert>".format (id, export_fields)
    }
}

object EnvironmentalAlert
extends
    CIMParseable[EnvironmentalAlert]
{
    override val fields: Array[String] = Array[String] (
        "alertType",
        "cancelledDateTime",
        "headline",
        "inEffect",
        "AlertTypeList",
        "EnvironmentalDataProvider",
        "EnvironmentalLocationKind"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AlertTypeList", "AlertTypeList", "1", "0..*"),
        CIMRelationship ("EnvironmentalDataProvider", "EnvironmentalDataProvider", "0..1", "0..*"),
        CIMRelationship ("EnvironmentalLocationKind", "EnvironmentalLocationType", "1..*", "0..*")
    )
    val alertType: Fielder = parse_element (element (cls, fields(0)))
    val cancelledDateTime: Fielder = parse_element (element (cls, fields(1)))
    val headline: Fielder = parse_element (element (cls, fields(2)))
    val inEffect: Fielder = parse_attribute (attribute (cls, fields(3)))
    val AlertTypeList: Fielder = parse_attribute (attribute (cls, fields(4)))
    val EnvironmentalDataProvider: Fielder = parse_attribute (attribute (cls, fields(5)))
    val EnvironmentalLocationKind: FielderMultiple = parse_attributes (attribute (cls, fields(6)))

    def parse (context: CIMContext): EnvironmentalAlert =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EnvironmentalAlert (
            ActivityRecord.parse (context),
            mask (alertType (), 0),
            mask (cancelledDateTime (), 1),
            mask (headline (), 2),
            mask (inEffect (), 3),
            mask (AlertTypeList (), 4),
            mask (EnvironmentalDataProvider (), 5),
            masks (EnvironmentalLocationKind (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

object EnvironmentalAlertSerializer extends CIMSerializer[EnvironmentalAlert]
{
    def write (kryo: Kryo, output: Output, obj: EnvironmentalAlert): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.alertType),
            () => output.writeString (obj.cancelledDateTime),
            () => output.writeString (obj.headline),
            () => output.writeString (obj.inEffect),
            () => output.writeString (obj.AlertTypeList),
            () => output.writeString (obj.EnvironmentalDataProvider),
            () => writeList (obj.EnvironmentalLocationKind, output)
        )
        ActivityRecordSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EnvironmentalAlert]): EnvironmentalAlert =
    {
        val parent = ActivityRecordSerializer.read (kryo, input, classOf[ActivityRecord])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = EnvironmentalAlert (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Analog (float) measurement of relevance in the environmental domain.
 *
 * @param Analog [[ch.ninecode.model.Analog Analog]] Reference to the superclass object.
 * @param ClassificationCondition [[ch.ninecode.model.ClassificationCondition ClassificationCondition]] Classification condition which this analog helps define.
 * @param EnvironmentalInformation [[ch.ninecode.model.EnvironmentalInformation EnvironmentalInformation]] Observation or forecast with which this environmental analog measurement is associated.
 * @param EnvironmentalMonitoringStation [[ch.ninecode.model.EnvironmentalMonitoringStation EnvironmentalMonitoringStation]] Monitoring station which provides this environmental analog measurement.
 * @param ReportingCapability [[ch.ninecode.model.ReportingCapability ReportingCapability]] The reporting capability this environmental value set helps define.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class EnvironmentalAnalog
(
    Analog: Analog = null,
    ClassificationCondition: String = null,
    EnvironmentalInformation: String = null,
    EnvironmentalMonitoringStation: String = null,
    ReportingCapability: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Analog = Analog

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EnvironmentalAnalog.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnvironmentalAnalog.fields (position), value)
        emitattr (0, ClassificationCondition)
        emitattr (1, EnvironmentalInformation)
        emitattr (2, EnvironmentalMonitoringStation)
        emitattr (3, ReportingCapability)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnvironmentalAnalog rdf:ID=\"%s\">\n%s\t</cim:EnvironmentalAnalog>".format (id, export_fields)
    }
}

object EnvironmentalAnalog
extends
    CIMParseable[EnvironmentalAnalog]
{
    override val fields: Array[String] = Array[String] (
        "ClassificationCondition",
        "EnvironmentalInformation",
        "EnvironmentalMonitoringStation",
        "ReportingCapability"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ClassificationCondition", "ClassificationCondition", "0..1", "0..*"),
        CIMRelationship ("EnvironmentalInformation", "EnvironmentalInformation", "0..1", "0..*"),
        CIMRelationship ("EnvironmentalMonitoringStation", "EnvironmentalMonitoringStation", "0..1", "0..*"),
        CIMRelationship ("ReportingCapability", "ReportingCapability", "0..1", "0..*")
    )
    val ClassificationCondition: Fielder = parse_attribute (attribute (cls, fields(0)))
    val EnvironmentalInformation: Fielder = parse_attribute (attribute (cls, fields(1)))
    val EnvironmentalMonitoringStation: Fielder = parse_attribute (attribute (cls, fields(2)))
    val ReportingCapability: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): EnvironmentalAnalog =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EnvironmentalAnalog (
            Analog.parse (context),
            mask (ClassificationCondition (), 0),
            mask (EnvironmentalInformation (), 1),
            mask (EnvironmentalMonitoringStation (), 2),
            mask (ReportingCapability (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

object EnvironmentalAnalogSerializer extends CIMSerializer[EnvironmentalAnalog]
{
    def write (kryo: Kryo, output: Output, obj: EnvironmentalAnalog): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.ClassificationCondition),
            () => output.writeString (obj.EnvironmentalInformation),
            () => output.writeString (obj.EnvironmentalMonitoringStation),
            () => output.writeString (obj.ReportingCapability)
        )
        AnalogSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EnvironmentalAnalog]): EnvironmentalAnalog =
    {
        val parent = AnalogSerializer.read (kryo, input, classOf[Analog])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = EnvironmentalAnalog (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An environmental value described using a coded value.
 *
 * A triplicate of enumerated values representing intensity, coverage, type of weather is used. These may be concatenated into the string value.
 *
 * @param StringMeasurementValue [[ch.ninecode.model.StringMeasurementValue StringMeasurementValue]] Reference to the superclass object.
 * @param coverageKind Code representing the coverage of the weather condition.
 * @param intensityKind Code representing the intensity of the weather condition.
 * @param probabilityPercent Probability of weather condition occurring during the time interval expressed as a percentage.
 *        Applicable only when weather condition is related to a forecast (not an observation).
 * @param weatherKind Code representing the type of weather condition.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class EnvironmentalCodedValue
(
    StringMeasurementValue: StringMeasurementValue = null,
    coverageKind: String = null,
    intensityKind: String = null,
    probabilityPercent: Double = 0.0,
    weatherKind: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: StringMeasurementValue = StringMeasurementValue

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EnvironmentalCodedValue.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EnvironmentalCodedValue.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnvironmentalCodedValue.fields (position), value)
        emitattr (0, coverageKind)
        emitattr (1, intensityKind)
        emitelem (2, probabilityPercent)
        emitattr (3, weatherKind)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnvironmentalCodedValue rdf:ID=\"%s\">\n%s\t</cim:EnvironmentalCodedValue>".format (id, export_fields)
    }
}

object EnvironmentalCodedValue
extends
    CIMParseable[EnvironmentalCodedValue]
{
    override val fields: Array[String] = Array[String] (
        "coverageKind",
        "intensityKind",
        "probabilityPercent",
        "weatherKind"
    )
    val coverageKind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val intensityKind: Fielder = parse_attribute (attribute (cls, fields(1)))
    val probabilityPercent: Fielder = parse_element (element (cls, fields(2)))
    val weatherKind: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): EnvironmentalCodedValue =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EnvironmentalCodedValue (
            StringMeasurementValue.parse (context),
            mask (coverageKind (), 0),
            mask (intensityKind (), 1),
            toDouble (mask (probabilityPercent (), 2)),
            mask (weatherKind (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

object EnvironmentalCodedValueSerializer extends CIMSerializer[EnvironmentalCodedValue]
{
    def write (kryo: Kryo, output: Output, obj: EnvironmentalCodedValue): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.coverageKind),
            () => output.writeString (obj.intensityKind),
            () => output.writeDouble (obj.probabilityPercent),
            () => output.writeString (obj.weatherKind)
        )
        StringMeasurementValueSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EnvironmentalCodedValue]): EnvironmentalCodedValue =
    {
        val parent = StringMeasurementValueSerializer.read (kryo, input, classOf[StringMeasurementValue])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = EnvironmentalCodedValue (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An entity defining classifications or categories of environmental information, like phenomena or alerts.
 *
 * @param OrganisationRole [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @param AlertTypeList [[ch.ninecode.model.AlertTypeList AlertTypeList]] A specific version of a list of alerts published by this environmental data authority.
 * @param PhenomenonClassification [[ch.ninecode.model.PhenomenonClassification PhenomenonClassification]] Phenomenon classification defined by this environmental data authority.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class EnvironmentalDataAuthority
(
    OrganisationRole: OrganisationRole = null,
    AlertTypeList: List[String] = null,
    PhenomenonClassification: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: OrganisationRole = OrganisationRole

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EnvironmentalDataAuthority.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (EnvironmentalDataAuthority.fields (position), x))
        emitattrs (0, AlertTypeList)
        emitattrs (1, PhenomenonClassification)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnvironmentalDataAuthority rdf:ID=\"%s\">\n%s\t</cim:EnvironmentalDataAuthority>".format (id, export_fields)
    }
}

object EnvironmentalDataAuthority
extends
    CIMParseable[EnvironmentalDataAuthority]
{
    override val fields: Array[String] = Array[String] (
        "AlertTypeList",
        "PhenomenonClassification"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AlertTypeList", "AlertTypeList", "0..*", "0..1"),
        CIMRelationship ("PhenomenonClassification", "PhenomenonClassification", "0..*", "0..1")
    )
    val AlertTypeList: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val PhenomenonClassification: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): EnvironmentalDataAuthority =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EnvironmentalDataAuthority (
            OrganisationRole.parse (context),
            masks (AlertTypeList (), 0),
            masks (PhenomenonClassification (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object EnvironmentalDataAuthoritySerializer extends CIMSerializer[EnvironmentalDataAuthority]
{
    def write (kryo: Kryo, output: Output, obj: EnvironmentalDataAuthority): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.AlertTypeList, output),
            () => writeList (obj.PhenomenonClassification, output)
        )
        OrganisationRoleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EnvironmentalDataAuthority]): EnvironmentalDataAuthority =
    {
        val parent = OrganisationRoleSerializer.read (kryo, input, classOf[OrganisationRole])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = EnvironmentalDataAuthority (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Entity providing environmental data.
 *
 * Could be an observed weather data provider, an entity providing forecasts, an authority providing alerts, etc.
 *
 * @param OrganisationRole [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @param EnvironmentalAlert [[ch.ninecode.model.EnvironmentalAlert EnvironmentalAlert]] Alert issued by this environmental data provider.
 * @param EnvironmentalInformation [[ch.ninecode.model.EnvironmentalInformation EnvironmentalInformation]] Environmental information provided by this environmental data provider.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class EnvironmentalDataProvider
(
    OrganisationRole: OrganisationRole = null,
    EnvironmentalAlert: List[String] = null,
    EnvironmentalInformation: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: OrganisationRole = OrganisationRole

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EnvironmentalDataProvider.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (EnvironmentalDataProvider.fields (position), x))
        emitattrs (0, EnvironmentalAlert)
        emitattrs (1, EnvironmentalInformation)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnvironmentalDataProvider rdf:ID=\"%s\">\n%s\t</cim:EnvironmentalDataProvider>".format (id, export_fields)
    }
}

object EnvironmentalDataProvider
extends
    CIMParseable[EnvironmentalDataProvider]
{
    override val fields: Array[String] = Array[String] (
        "EnvironmentalAlert",
        "EnvironmentalInformation"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("EnvironmentalAlert", "EnvironmentalAlert", "0..*", "0..1"),
        CIMRelationship ("EnvironmentalInformation", "EnvironmentalInformation", "0..*", "0..1")
    )
    val EnvironmentalAlert: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val EnvironmentalInformation: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): EnvironmentalDataProvider =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EnvironmentalDataProvider (
            OrganisationRole.parse (context),
            masks (EnvironmentalAlert (), 0),
            masks (EnvironmentalInformation (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object EnvironmentalDataProviderSerializer extends CIMSerializer[EnvironmentalDataProvider]
{
    def write (kryo: Kryo, output: Output, obj: EnvironmentalDataProvider): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.EnvironmentalAlert, output),
            () => writeList (obj.EnvironmentalInformation, output)
        )
        OrganisationRoleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EnvironmentalDataProvider]): EnvironmentalDataProvider =
    {
        val parent = OrganisationRoleSerializer.read (kryo, input, classOf[OrganisationRole])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = EnvironmentalDataProvider (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Discrete (integer) measurement of relevance in the environmental domain.
 *
 * @param Discrete [[ch.ninecode.model.Discrete Discrete]] Reference to the superclass object.
 * @param kind Kind of environmental discrete (integer).
 * @param EnvironmentalInformation [[ch.ninecode.model.EnvironmentalInformation EnvironmentalInformation]] Observation or forecast with which this environmental discrete (integer) is associated.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class EnvironmentalDiscrete
(
    Discrete: Discrete = null,
    kind: String = null,
    EnvironmentalInformation: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Discrete = Discrete

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EnvironmentalDiscrete.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnvironmentalDiscrete.fields (position), value)
        emitattr (0, kind)
        emitattr (1, EnvironmentalInformation)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnvironmentalDiscrete rdf:ID=\"%s\">\n%s\t</cim:EnvironmentalDiscrete>".format (id, export_fields)
    }
}

object EnvironmentalDiscrete
extends
    CIMParseable[EnvironmentalDiscrete]
{
    override val fields: Array[String] = Array[String] (
        "kind",
        "EnvironmentalInformation"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("EnvironmentalInformation", "EnvironmentalInformation", "0..1", "0..*")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val EnvironmentalInformation: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): EnvironmentalDiscrete =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EnvironmentalDiscrete (
            Discrete.parse (context),
            mask (kind (), 0),
            mask (EnvironmentalInformation (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object EnvironmentalDiscreteSerializer extends CIMSerializer[EnvironmentalDiscrete]
{
    def write (kryo: Kryo, output: Output, obj: EnvironmentalDiscrete): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.kind),
            () => output.writeString (obj.EnvironmentalInformation)
        )
        DiscreteSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EnvironmentalDiscrete]): EnvironmentalDiscrete =
    {
        val parent = DiscreteSerializer.read (kryo, input, classOf[Discrete])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = EnvironmentalDiscrete (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An environmental event to which one or more forecasts or observations may be tied and which may relate to or affect one or more assets.
 *
 * This class is intended to be used as a means of grouping forecasts and/or observations and could be used for a variety of purposes, including:
 * <ul>
 * <li>to define a 'named' event like Hurricane Katrina and allow the historic (or forecast) values for phenomena and measurements (precipitation, temperature) across time to be  associated with it</li>
 * <li>to identify assets that were (or are forecast to be) affected by a phenomenon or set of measurements</li>
 * </ul>
 *
 * @param ActivityRecord [[ch.ninecode.model.ActivityRecord ActivityRecord]] Reference to the superclass object.
 * @param EnvironmentalInformation [[ch.ninecode.model.EnvironmentalInformation EnvironmentalInformation]] Forecast or observation related to this environmental event.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class EnvironmentalEvent
(
    ActivityRecord: ActivityRecord = null,
    EnvironmentalInformation: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: ActivityRecord = ActivityRecord

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EnvironmentalEvent.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (EnvironmentalEvent.fields (position), x))
        emitattrs (0, EnvironmentalInformation)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnvironmentalEvent rdf:ID=\"%s\">\n%s\t</cim:EnvironmentalEvent>".format (id, export_fields)
    }
}

object EnvironmentalEvent
extends
    CIMParseable[EnvironmentalEvent]
{
    override val fields: Array[String] = Array[String] (
        "EnvironmentalInformation"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("EnvironmentalInformation", "EnvironmentalInformation", "0..*", "0..*")
    )
    val EnvironmentalInformation: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): EnvironmentalEvent =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EnvironmentalEvent (
            ActivityRecord.parse (context),
            masks (EnvironmentalInformation (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object EnvironmentalEventSerializer extends CIMSerializer[EnvironmentalEvent]
{
    def write (kryo: Kryo, output: Output, obj: EnvironmentalEvent): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.EnvironmentalInformation, output)
        )
        ActivityRecordSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EnvironmentalEvent]): EnvironmentalEvent =
    {
        val parent = ActivityRecordSerializer.read (kryo, input, classOf[ActivityRecord])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = EnvironmentalEvent (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Abstract class (with concrete child classes of Observation and Forecast) that groups phenomenon and/or environmental value sets.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param created The timestamp of when the forecast was created
 * @param EnvironmentalAnalog [[ch.ninecode.model.EnvironmentalAnalog EnvironmentalAnalog]] Environmental analog associated with this observation or forecast.
 * @param EnvironmentalDataProvider [[ch.ninecode.model.EnvironmentalDataProvider EnvironmentalDataProvider]] Environmental data provider supplying this environmental information.
 * @param EnvironmentalDiscrete [[ch.ninecode.model.EnvironmentalDiscrete EnvironmentalDiscrete]] Environmental discrete (integer) associated with this observation or forecast.
 * @param EnvironmentalEvent [[ch.ninecode.model.EnvironmentalEvent EnvironmentalEvent]] Environmental event to which this forecast or observation relates.
 * @param EnvironmentalPhenomenon [[ch.ninecode.model.EnvironmentalPhenomenon EnvironmentalPhenomenon]] <em>undocumented</em>
 * @param EnvironmentalStringMeasurement [[ch.ninecode.model.EnvironmentalStringMeasurement EnvironmentalStringMeasurement]] Environmental string measurement associated with this forecast or observation.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class EnvironmentalInformation
(
    IdentifiedObject: IdentifiedObject = null,
    created: String = null,
    EnvironmentalAnalog: List[String] = null,
    EnvironmentalDataProvider: String = null,
    EnvironmentalDiscrete: List[String] = null,
    EnvironmentalEvent: List[String] = null,
    EnvironmentalPhenomenon: List[String] = null,
    EnvironmentalStringMeasurement: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EnvironmentalInformation.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EnvironmentalInformation.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnvironmentalInformation.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (EnvironmentalInformation.fields (position), x))
        emitelem (0, created)
        emitattrs (1, EnvironmentalAnalog)
        emitattr (2, EnvironmentalDataProvider)
        emitattrs (3, EnvironmentalDiscrete)
        emitattrs (4, EnvironmentalEvent)
        emitattrs (5, EnvironmentalPhenomenon)
        emitattrs (6, EnvironmentalStringMeasurement)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnvironmentalInformation rdf:ID=\"%s\">\n%s\t</cim:EnvironmentalInformation>".format (id, export_fields)
    }
}

object EnvironmentalInformation
extends
    CIMParseable[EnvironmentalInformation]
{
    override val fields: Array[String] = Array[String] (
        "created",
        "EnvironmentalAnalog",
        "EnvironmentalDataProvider",
        "EnvironmentalDiscrete",
        "EnvironmentalEvent",
        "EnvironmentalPhenomenon",
        "EnvironmentalStringMeasurement"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("EnvironmentalAnalog", "EnvironmentalAnalog", "0..*", "0..1"),
        CIMRelationship ("EnvironmentalDataProvider", "EnvironmentalDataProvider", "0..1", "0..*"),
        CIMRelationship ("EnvironmentalDiscrete", "EnvironmentalDiscrete", "0..*", "0..1"),
        CIMRelationship ("EnvironmentalEvent", "EnvironmentalEvent", "0..*", "0..*"),
        CIMRelationship ("EnvironmentalPhenomenon", "EnvironmentalPhenomenon", "0..*", "0..1"),
        CIMRelationship ("EnvironmentalStringMeasurement", "EnvironmentalStringMeasurement", "0..*", "0..1")
    )
    val created: Fielder = parse_element (element (cls, fields(0)))
    val EnvironmentalAnalog: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val EnvironmentalDataProvider: Fielder = parse_attribute (attribute (cls, fields(2)))
    val EnvironmentalDiscrete: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val EnvironmentalEvent: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val EnvironmentalPhenomenon: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val EnvironmentalStringMeasurement: FielderMultiple = parse_attributes (attribute (cls, fields(6)))

    def parse (context: CIMContext): EnvironmentalInformation =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EnvironmentalInformation (
            IdentifiedObject.parse (context),
            mask (created (), 0),
            masks (EnvironmentalAnalog (), 1),
            mask (EnvironmentalDataProvider (), 2),
            masks (EnvironmentalDiscrete (), 3),
            masks (EnvironmentalEvent (), 4),
            masks (EnvironmentalPhenomenon (), 5),
            masks (EnvironmentalStringMeasurement (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

object EnvironmentalInformationSerializer extends CIMSerializer[EnvironmentalInformation]
{
    def write (kryo: Kryo, output: Output, obj: EnvironmentalInformation): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.created),
            () => writeList (obj.EnvironmentalAnalog, output),
            () => output.writeString (obj.EnvironmentalDataProvider),
            () => writeList (obj.EnvironmentalDiscrete, output),
            () => writeList (obj.EnvironmentalEvent, output),
            () => writeList (obj.EnvironmentalPhenomenon, output),
            () => writeList (obj.EnvironmentalStringMeasurement, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EnvironmentalInformation]): EnvironmentalInformation =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = EnvironmentalInformation (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Type of environmental location.
 *
 * Used when an environmental alert or phenomenon has multiple locations associated with it.
 *
 * @param Element Reference to the superclass object.
 * @param kind The kind of location.
 *        Typical values might be center, extent, primary, secondary, etc.
 * @param EnvironmentalAlert [[ch.ninecode.model.EnvironmentalAlert EnvironmentalAlert]] Environmental alert applying to location of this type.
 * @param EnvironmentalPhenomenon [[ch.ninecode.model.EnvironmentalPhenomenon EnvironmentalPhenomenon]] Environmental phenomenon for which this location is of relevance.
 * @param Location [[ch.ninecode.model.Location Location]] Location of this instance of ths kind of environmental location.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class EnvironmentalLocationType
(
    Element: BasicElement = null,
    kind: String = null,
    EnvironmentalAlert: List[String] = null,
    EnvironmentalPhenomenon: List[String] = null,
    Location: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EnvironmentalLocationType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnvironmentalLocationType.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (EnvironmentalLocationType.fields (position), x))
        emitattr (0, kind)
        emitattrs (1, EnvironmentalAlert)
        emitattrs (2, EnvironmentalPhenomenon)
        emitattr (3, Location)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnvironmentalLocationType rdf:ID=\"%s\">\n%s\t</cim:EnvironmentalLocationType>".format (id, export_fields)
    }
}

object EnvironmentalLocationType
extends
    CIMParseable[EnvironmentalLocationType]
{
    override val fields: Array[String] = Array[String] (
        "kind",
        "EnvironmentalAlert",
        "EnvironmentalPhenomenon",
        "Location"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("EnvironmentalAlert", "EnvironmentalAlert", "0..*", "1..*"),
        CIMRelationship ("EnvironmentalPhenomenon", "EnvironmentalPhenomenon", "0..*", "0..*"),
        CIMRelationship ("Location", "Location", "0..1", "0..*")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val EnvironmentalAlert: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val EnvironmentalPhenomenon: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Location: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): EnvironmentalLocationType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EnvironmentalLocationType (
            BasicElement.parse (context),
            mask (kind (), 0),
            masks (EnvironmentalAlert (), 1),
            masks (EnvironmentalPhenomenon (), 2),
            mask (Location (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

object EnvironmentalLocationTypeSerializer extends CIMSerializer[EnvironmentalLocationType]
{
    def write (kryo: Kryo, output: Output, obj: EnvironmentalLocationType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.kind),
            () => writeList (obj.EnvironmentalAlert, output),
            () => writeList (obj.EnvironmentalPhenomenon, output),
            () => output.writeString (obj.Location)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EnvironmentalLocationType]): EnvironmentalLocationType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = EnvironmentalLocationType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The actual or forecast characteristics of an environmental phenomenon at a specific point in time (or during a specific time interval) that may have both a center and area/line location.
 *
 * @param Element Reference to the superclass object.
 * @param timeInterval The timestamp of the phenomenon as a single point or time interval.
 * @param EnvironmentalInformation [[ch.ninecode.model.EnvironmentalInformation EnvironmentalInformation]] The forecast or observation of which this phenomenon description is a part.
 * @param EnvironmentalLocationKind [[ch.ninecode.model.EnvironmentalLocationType EnvironmentalLocationType]] Location of relevance to this environmental phenomenon.
 * @param PhenomenonClassification [[ch.ninecode.model.PhenomenonClassification PhenomenonClassification]] The classification of this phenomenon.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class EnvironmentalPhenomenon
(
    Element: BasicElement = null,
    timeInterval: String = null,
    EnvironmentalInformation: String = null,
    EnvironmentalLocationKind: List[String] = null,
    PhenomenonClassification: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EnvironmentalPhenomenon.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnvironmentalPhenomenon.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (EnvironmentalPhenomenon.fields (position), x))
        emitattr (0, timeInterval)
        emitattr (1, EnvironmentalInformation)
        emitattrs (2, EnvironmentalLocationKind)
        emitattr (3, PhenomenonClassification)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnvironmentalPhenomenon rdf:ID=\"%s\">\n%s\t</cim:EnvironmentalPhenomenon>".format (id, export_fields)
    }
}

object EnvironmentalPhenomenon
extends
    CIMParseable[EnvironmentalPhenomenon]
{
    override val fields: Array[String] = Array[String] (
        "timeInterval",
        "EnvironmentalInformation",
        "EnvironmentalLocationKind",
        "PhenomenonClassification"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("EnvironmentalInformation", "EnvironmentalInformation", "0..1", "0..*"),
        CIMRelationship ("EnvironmentalLocationKind", "EnvironmentalLocationType", "0..*", "0..*"),
        CIMRelationship ("PhenomenonClassification", "PhenomenonClassification", "0..1", "0..*")
    )
    val timeInterval: Fielder = parse_attribute (attribute (cls, fields(0)))
    val EnvironmentalInformation: Fielder = parse_attribute (attribute (cls, fields(1)))
    val EnvironmentalLocationKind: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val PhenomenonClassification: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): EnvironmentalPhenomenon =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EnvironmentalPhenomenon (
            BasicElement.parse (context),
            mask (timeInterval (), 0),
            mask (EnvironmentalInformation (), 1),
            masks (EnvironmentalLocationKind (), 2),
            mask (PhenomenonClassification (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

object EnvironmentalPhenomenonSerializer extends CIMSerializer[EnvironmentalPhenomenon]
{
    def write (kryo: Kryo, output: Output, obj: EnvironmentalPhenomenon): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.timeInterval),
            () => output.writeString (obj.EnvironmentalInformation),
            () => writeList (obj.EnvironmentalLocationKind, output),
            () => output.writeString (obj.PhenomenonClassification)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EnvironmentalPhenomenon]): EnvironmentalPhenomenon =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = EnvironmentalPhenomenon (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * String measurement of relevance in the environmental domain.
 *
 * @param StringMeasurement [[ch.ninecode.model.StringMeasurement StringMeasurement]] Reference to the superclass object.
 * @param ClassificationCondition [[ch.ninecode.model.ClassificationCondition ClassificationCondition]] Classification condition which this string measurement helps define.
 * @param EnvironmentalInformation [[ch.ninecode.model.EnvironmentalInformation EnvironmentalInformation]] Observation or forecast with which this environmental string is associated.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class EnvironmentalStringMeasurement
(
    StringMeasurement: StringMeasurement = null,
    ClassificationCondition: String = null,
    EnvironmentalInformation: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: StringMeasurement = StringMeasurement

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EnvironmentalStringMeasurement.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnvironmentalStringMeasurement.fields (position), value)
        emitattr (0, ClassificationCondition)
        emitattr (1, EnvironmentalInformation)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnvironmentalStringMeasurement rdf:ID=\"%s\">\n%s\t</cim:EnvironmentalStringMeasurement>".format (id, export_fields)
    }
}

object EnvironmentalStringMeasurement
extends
    CIMParseable[EnvironmentalStringMeasurement]
{
    override val fields: Array[String] = Array[String] (
        "ClassificationCondition",
        "EnvironmentalInformation"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ClassificationCondition", "ClassificationCondition", "0..1", "0..*"),
        CIMRelationship ("EnvironmentalInformation", "EnvironmentalInformation", "0..1", "0..*")
    )
    val ClassificationCondition: Fielder = parse_attribute (attribute (cls, fields(0)))
    val EnvironmentalInformation: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): EnvironmentalStringMeasurement =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EnvironmentalStringMeasurement (
            StringMeasurement.parse (context),
            mask (ClassificationCondition (), 0),
            mask (EnvironmentalInformation (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object EnvironmentalStringMeasurementSerializer extends CIMSerializer[EnvironmentalStringMeasurement]
{
    def write (kryo: Kryo, output: Output, obj: EnvironmentalStringMeasurement): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.ClassificationCondition),
            () => output.writeString (obj.EnvironmentalInformation)
        )
        StringMeasurementSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EnvironmentalStringMeasurement]): EnvironmentalStringMeasurement =
    {
        val parent = StringMeasurementSerializer.read (kryo, input, classOf[StringMeasurement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = EnvironmentalStringMeasurement (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A fire, often uncontrolled, covering an area of land which typically contains combustible vegetation.
 *
 * Associated location information is assumed to describe the total area burned as of a specified time.
 *
 * @param GeosphericPhenomenon [[ch.ninecode.model.GeosphericPhenomenon GeosphericPhenomenon]] Reference to the superclass object.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class Fire
(
    GeosphericPhenomenon: GeosphericPhenomenon = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: GeosphericPhenomenon = GeosphericPhenomenon

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:Fire rdf:ID=\"%s\">\n%s\t</cim:Fire>".format (id, export_fields)
    }
}

object Fire
extends
    CIMParseable[Fire]
{

    def parse (context: CIMContext): Fire =
    {
        val ret = Fire (
            GeosphericPhenomenon.parse (context)
        )
        ret
    }
}

object FireSerializer extends CIMSerializer[Fire]
{
    def write (kryo: Kryo, output: Output, obj: Fire): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        GeosphericPhenomenonSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Fire]): Fire =
    {
        val parent = GeosphericPhenomenonSerializer.read (kryo, input, classOf[GeosphericPhenomenon])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Fire (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A flood, an overflowing of a large amount of water beyond its normal confines, esp. over what is normally dry land.
 *
 * @param HydrosphericPhenomenon [[ch.ninecode.model.HydrosphericPhenomenon HydrosphericPhenomenon]] Reference to the superclass object.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class Flood
(
    HydrosphericPhenomenon: HydrosphericPhenomenon = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: HydrosphericPhenomenon = HydrosphericPhenomenon

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:Flood rdf:ID=\"%s\">\n%s\t</cim:Flood>".format (id, export_fields)
    }
}

object Flood
extends
    CIMParseable[Flood]
{

    def parse (context: CIMContext): Flood =
    {
        val ret = Flood (
            HydrosphericPhenomenon.parse (context)
        )
        ret
    }
}

object FloodSerializer extends CIMSerializer[Flood]
{
    def write (kryo: Kryo, output: Output, obj: Flood): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        HydrosphericPhenomenonSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Flood]): Flood =
    {
        val parent = HydrosphericPhenomenonSerializer.read (kryo, input, classOf[HydrosphericPhenomenon])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Flood (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A forecast group of value sets and/or phenomena characteristics.
 *
 * @param EnvironmentalInformation [[ch.ninecode.model.EnvironmentalInformation EnvironmentalInformation]] Reference to the superclass object.
 * @param validFor The interval for which the forecast is valid.
 *        For example, a forecast issued now for tomorrow might be valid for the next 2 hours.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class Forecast
(
    EnvironmentalInformation: EnvironmentalInformation = null,
    validFor: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: EnvironmentalInformation = EnvironmentalInformation

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Forecast.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Forecast.fields (position), value)
        emitattr (0, validFor)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Forecast rdf:ID=\"%s\">\n%s\t</cim:Forecast>".format (id, export_fields)
    }
}

object Forecast
extends
    CIMParseable[Forecast]
{
    override val fields: Array[String] = Array[String] (
        "validFor"
    )
    val validFor: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): Forecast =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Forecast (
            EnvironmentalInformation.parse (context),
            mask (validFor (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object ForecastSerializer extends CIMSerializer[Forecast]
{
    def write (kryo: Kryo, output: Output, obj: Forecast): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.validFor)
        )
        EnvironmentalInformationSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Forecast]): Forecast =
    {
        val parent = EnvironmentalInformationSerializer.read (kryo, input, classOf[EnvironmentalInformation])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Forecast (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Analog (float) measuring a geospheric condition.
 *
 * @param EnvironmentalAnalog [[ch.ninecode.model.EnvironmentalAnalog EnvironmentalAnalog]] Reference to the superclass object.
 * @param kind Kind of geospheric analog.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class GeosphericAnalog
(
    EnvironmentalAnalog: EnvironmentalAnalog = null,
    kind: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: EnvironmentalAnalog = EnvironmentalAnalog

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GeosphericAnalog.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (GeosphericAnalog.fields (position), value)
        emitattr (0, kind)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GeosphericAnalog rdf:ID=\"%s\">\n%s\t</cim:GeosphericAnalog>".format (id, export_fields)
    }
}

object GeosphericAnalog
extends
    CIMParseable[GeosphericAnalog]
{
    override val fields: Array[String] = Array[String] (
        "kind"
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): GeosphericAnalog =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GeosphericAnalog (
            EnvironmentalAnalog.parse (context),
            mask (kind (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object GeosphericAnalogSerializer extends CIMSerializer[GeosphericAnalog]
{
    def write (kryo: Kryo, output: Output, obj: GeosphericAnalog): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.kind)
        )
        EnvironmentalAnalogSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[GeosphericAnalog]): GeosphericAnalog =
    {
        val parent = EnvironmentalAnalogSerializer.read (kryo, input, classOf[EnvironmentalAnalog])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = GeosphericAnalog (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A geospheric phenomenon.
 *
 * @param EnvironmentalPhenomenon [[ch.ninecode.model.EnvironmentalPhenomenon EnvironmentalPhenomenon]] Reference to the superclass object.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class GeosphericPhenomenon
(
    EnvironmentalPhenomenon: EnvironmentalPhenomenon = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: EnvironmentalPhenomenon = EnvironmentalPhenomenon

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:GeosphericPhenomenon rdf:ID=\"%s\">\n%s\t</cim:GeosphericPhenomenon>".format (id, export_fields)
    }
}

object GeosphericPhenomenon
extends
    CIMParseable[GeosphericPhenomenon]
{

    def parse (context: CIMContext): GeosphericPhenomenon =
    {
        val ret = GeosphericPhenomenon (
            EnvironmentalPhenomenon.parse (context)
        )
        ret
    }
}

object GeosphericPhenomenonSerializer extends CIMSerializer[GeosphericPhenomenon]
{
    def write (kryo: Kryo, output: Output, obj: GeosphericPhenomenon): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        EnvironmentalPhenomenonSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[GeosphericPhenomenon]): GeosphericPhenomenon =
    {
        val parent = EnvironmentalPhenomenonSerializer.read (kryo, input, classOf[EnvironmentalPhenomenon])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = GeosphericPhenomenon (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A hurricane, a subtype of cyclone occurring in the North Atlantic Ocean or North-eastern Pacific Ocean whose intensity is measured using the Saffir-Simpson Hurricane Scale.
 *
 * @param Cyclone [[ch.ninecode.model.Cyclone Cyclone]] Reference to the superclass object.
 * @param category The hurricane's category during the time interval, using Saffir-Simpson Hurricane Wind Scale, a 1 to 5 rating based on a hurricane's sustained wind speed.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class Hurricane
(
    Cyclone: Cyclone = null,
    category: Int = 0
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Cyclone = Cyclone

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Hurricane.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Hurricane.fields (position), value)
        emitelem (0, category)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Hurricane rdf:ID=\"%s\">\n%s\t</cim:Hurricane>".format (id, export_fields)
    }
}

object Hurricane
extends
    CIMParseable[Hurricane]
{
    override val fields: Array[String] = Array[String] (
        "category"
    )
    val category: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: CIMContext): Hurricane =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Hurricane (
            Cyclone.parse (context),
            toInteger (mask (category (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
}

object HurricaneSerializer extends CIMSerializer[Hurricane]
{
    def write (kryo: Kryo, output: Output, obj: Hurricane): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeInt (obj.category)
        )
        CycloneSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Hurricane]): Hurricane =
    {
        val parent = CycloneSerializer.read (kryo, input, classOf[Cyclone])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Hurricane (
            parent,
            if (isSet (0)) input.readInt else 0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Analog (float) measuring a hydrospheric condition.
 *
 * @param EnvironmentalAnalog [[ch.ninecode.model.EnvironmentalAnalog EnvironmentalAnalog]] Reference to the superclass object.
 * @param kind Kind of hydrospheric analog.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class HydrosphericAnalog
(
    EnvironmentalAnalog: EnvironmentalAnalog = null,
    kind: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: EnvironmentalAnalog = EnvironmentalAnalog

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = HydrosphericAnalog.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (HydrosphericAnalog.fields (position), value)
        emitattr (0, kind)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:HydrosphericAnalog rdf:ID=\"%s\">\n%s\t</cim:HydrosphericAnalog>".format (id, export_fields)
    }
}

object HydrosphericAnalog
extends
    CIMParseable[HydrosphericAnalog]
{
    override val fields: Array[String] = Array[String] (
        "kind"
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): HydrosphericAnalog =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = HydrosphericAnalog (
            EnvironmentalAnalog.parse (context),
            mask (kind (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object HydrosphericAnalogSerializer extends CIMSerializer[HydrosphericAnalog]
{
    def write (kryo: Kryo, output: Output, obj: HydrosphericAnalog): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.kind)
        )
        EnvironmentalAnalogSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[HydrosphericAnalog]): HydrosphericAnalog =
    {
        val parent = EnvironmentalAnalogSerializer.read (kryo, input, classOf[EnvironmentalAnalog])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = HydrosphericAnalog (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A hydrospheric phenomenon.
 *
 * @param EnvironmentalPhenomenon [[ch.ninecode.model.EnvironmentalPhenomenon EnvironmentalPhenomenon]] Reference to the superclass object.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class HydrosphericPhenomenon
(
    EnvironmentalPhenomenon: EnvironmentalPhenomenon = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: EnvironmentalPhenomenon = EnvironmentalPhenomenon

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:HydrosphericPhenomenon rdf:ID=\"%s\">\n%s\t</cim:HydrosphericPhenomenon>".format (id, export_fields)
    }
}

object HydrosphericPhenomenon
extends
    CIMParseable[HydrosphericPhenomenon]
{

    def parse (context: CIMContext): HydrosphericPhenomenon =
    {
        val ret = HydrosphericPhenomenon (
            EnvironmentalPhenomenon.parse (context)
        )
        ret
    }
}

object HydrosphericPhenomenonSerializer extends CIMSerializer[HydrosphericPhenomenon]
{
    def write (kryo: Kryo, output: Output, obj: HydrosphericPhenomenon): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        EnvironmentalPhenomenonSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[HydrosphericPhenomenon]): HydrosphericPhenomenon =
    {
        val parent = EnvironmentalPhenomenonSerializer.read (kryo, input, classOf[EnvironmentalPhenomenon])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = HydrosphericPhenomenon (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A landslide, a large mass of rocks and earth that suddenly and quickly moves down the side of a mountain or hill.
 *
 * @param GeosphericPhenomenon [[ch.ninecode.model.GeosphericPhenomenon GeosphericPhenomenon]] Reference to the superclass object.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class Landslide
(
    GeosphericPhenomenon: GeosphericPhenomenon = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: GeosphericPhenomenon = GeosphericPhenomenon

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:Landslide rdf:ID=\"%s\">\n%s\t</cim:Landslide>".format (id, export_fields)
    }
}

object Landslide
extends
    CIMParseable[Landslide]
{

    def parse (context: CIMContext): Landslide =
    {
        val ret = Landslide (
            GeosphericPhenomenon.parse (context)
        )
        ret
    }
}

object LandslideSerializer extends CIMSerializer[Landslide]
{
    def write (kryo: Kryo, output: Output, obj: Landslide): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        GeosphericPhenomenonSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Landslide]): Landslide =
    {
        val parent = GeosphericPhenomenonSerializer.read (kryo, input, classOf[GeosphericPhenomenon])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Landslide (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A cloud-to-ground lightning strike at a particular location.
 *
 * @param GeosphericPhenomenon [[ch.ninecode.model.GeosphericPhenomenon GeosphericPhenomenon]] Reference to the superclass object.
 * @param errorEllipseConfidence Likelihood that strike fell within errorEllipse.
 * @param errorEllipseMajorSemiAxis Length of major semi-axis (longest radius) of the error ellipse.
 * @param errorEllipseMinorSemiAxis Length of minor semi-axis (shortest radius) of the error ellipse.
 * @param errorEllipseOrientation The orientation of the major semi- axis in degrees from True North.
 * @param negativePolarity The polarity of the strike, with T meaning negative.
 *        About 90% of all lightning strokes are negative strokes, meaning that they were initiated by a large concentration of negative charge in the cloud-base; this tends to induce an area of positive charge on the ground.
 * @param peakAmplitude Peak current of strike.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class LightningStrike
(
    GeosphericPhenomenon: GeosphericPhenomenon = null,
    errorEllipseConfidence: Double = 0.0,
    errorEllipseMajorSemiAxis: Double = 0.0,
    errorEllipseMinorSemiAxis: Double = 0.0,
    errorEllipseOrientation: Double = 0.0,
    negativePolarity: Boolean = false,
    peakAmplitude: Double = 0.0
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: GeosphericPhenomenon = GeosphericPhenomenon

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = LightningStrike.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LightningStrike.fields (position), value)
        emitelem (0, errorEllipseConfidence)
        emitelem (1, errorEllipseMajorSemiAxis)
        emitelem (2, errorEllipseMinorSemiAxis)
        emitelem (3, errorEllipseOrientation)
        emitelem (4, negativePolarity)
        emitelem (5, peakAmplitude)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LightningStrike rdf:ID=\"%s\">\n%s\t</cim:LightningStrike>".format (id, export_fields)
    }
}

object LightningStrike
extends
    CIMParseable[LightningStrike]
{
    override val fields: Array[String] = Array[String] (
        "errorEllipseConfidence",
        "errorEllipseMajorSemiAxis",
        "errorEllipseMinorSemiAxis",
        "errorEllipseOrientation",
        "negativePolarity",
        "peakAmplitude"
    )
    val errorEllipseConfidence: Fielder = parse_element (element (cls, fields(0)))
    val errorEllipseMajorSemiAxis: Fielder = parse_element (element (cls, fields(1)))
    val errorEllipseMinorSemiAxis: Fielder = parse_element (element (cls, fields(2)))
    val errorEllipseOrientation: Fielder = parse_element (element (cls, fields(3)))
    val negativePolarity: Fielder = parse_element (element (cls, fields(4)))
    val peakAmplitude: Fielder = parse_element (element (cls, fields(5)))

    def parse (context: CIMContext): LightningStrike =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = LightningStrike (
            GeosphericPhenomenon.parse (context),
            toDouble (mask (errorEllipseConfidence (), 0)),
            toDouble (mask (errorEllipseMajorSemiAxis (), 1)),
            toDouble (mask (errorEllipseMinorSemiAxis (), 2)),
            toDouble (mask (errorEllipseOrientation (), 3)),
            toBoolean (mask (negativePolarity (), 4)),
            toDouble (mask (peakAmplitude (), 5))
        )
        ret.bitfields = bitfields
        ret
    }
}

object LightningStrikeSerializer extends CIMSerializer[LightningStrike]
{
    def write (kryo: Kryo, output: Output, obj: LightningStrike): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.errorEllipseConfidence),
            () => output.writeDouble (obj.errorEllipseMajorSemiAxis),
            () => output.writeDouble (obj.errorEllipseMinorSemiAxis),
            () => output.writeDouble (obj.errorEllipseOrientation),
            () => output.writeBoolean (obj.negativePolarity),
            () => output.writeDouble (obj.peakAmplitude)
        )
        GeosphericPhenomenonSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[LightningStrike]): LightningStrike =
    {
        val parent = GeosphericPhenomenonSerializer.read (kryo, input, classOf[GeosphericPhenomenon])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = LightningStrike (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readBoolean else false,
            if (isSet (5)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A magnetic storm, a temporary disturbance of the earth's magnetic field, induced by radiation and streams of charged particles from the sun.
 *
 * @param SpacePhenomenon [[ch.ninecode.model.SpacePhenomenon SpacePhenomenon]] Reference to the superclass object.
 * @param changeDst Change in the disturbance  - storm time (Dst) index.
 *        The size of a geomagnetic storm is classified as:
 *        - moderate ( -50 nT &gt;minimum of Dst &gt; -100 nT)
 *        - intense (-100 nT &gt; minimum Dst &gt; -250 nT) or
 *        - super-storm ( minimum of Dst &lt; -250 nT).
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class MagneticStorm
(
    SpacePhenomenon: SpacePhenomenon = null,
    changeDst: Double = 0.0
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: SpacePhenomenon = SpacePhenomenon

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MagneticStorm.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MagneticStorm.fields (position), value)
        emitelem (0, changeDst)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MagneticStorm rdf:ID=\"%s\">\n%s\t</cim:MagneticStorm>".format (id, export_fields)
    }
}

object MagneticStorm
extends
    CIMParseable[MagneticStorm]
{
    override val fields: Array[String] = Array[String] (
        "changeDst"
    )
    val changeDst: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: CIMContext): MagneticStorm =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MagneticStorm (
            SpacePhenomenon.parse (context),
            toDouble (mask (changeDst (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
}

object MagneticStormSerializer extends CIMSerializer[MagneticStorm]
{
    def write (kryo: Kryo, output: Output, obj: MagneticStorm): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.changeDst)
        )
        SpacePhenomenonSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MagneticStorm]): MagneticStorm =
    {
        val parent = SpacePhenomenonSerializer.read (kryo, input, classOf[SpacePhenomenon])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MagneticStorm (
            parent,
            if (isSet (0)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Observed (actual non-forecast) values sets and/or phenomena characteristics.
 *
 * @param EnvironmentalInformation [[ch.ninecode.model.EnvironmentalInformation EnvironmentalInformation]] Reference to the superclass object.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class Observation
(
    EnvironmentalInformation: EnvironmentalInformation = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: EnvironmentalInformation = EnvironmentalInformation

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:Observation rdf:ID=\"%s\">\n%s\t</cim:Observation>".format (id, export_fields)
    }
}

object Observation
extends
    CIMParseable[Observation]
{

    def parse (context: CIMContext): Observation =
    {
        val ret = Observation (
            EnvironmentalInformation.parse (context)
        )
        ret
    }
}

object ObservationSerializer extends CIMSerializer[Observation]
{
    def write (kryo: Kryo, output: Output, obj: Observation): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        EnvironmentalInformationSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Observation]): Observation =
    {
        val parent = EnvironmentalInformationSerializer.read (kryo, input, classOf[EnvironmentalInformation])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Observation (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A pre-defined phenomenon classification as defined by a particular authority.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ClassificationCondition [[ch.ninecode.model.ClassificationCondition ClassificationCondition]] Condition contributing to the classification of this phenomenon.
 * @param EnvironmentalDataAuthority [[ch.ninecode.model.EnvironmentalDataAuthority EnvironmentalDataAuthority]] Authority defining this environmental phenomenon.
 * @param EnvironmentalPhenomenon [[ch.ninecode.model.EnvironmentalPhenomenon EnvironmentalPhenomenon]] <em>undocumented</em>
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class PhenomenonClassification
(
    IdentifiedObject: IdentifiedObject = null,
    ClassificationCondition: List[String] = null,
    EnvironmentalDataAuthority: String = null,
    EnvironmentalPhenomenon: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PhenomenonClassification.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PhenomenonClassification.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (PhenomenonClassification.fields (position), x))
        emitattrs (0, ClassificationCondition)
        emitattr (1, EnvironmentalDataAuthority)
        emitattrs (2, EnvironmentalPhenomenon)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PhenomenonClassification rdf:ID=\"%s\">\n%s\t</cim:PhenomenonClassification>".format (id, export_fields)
    }
}

object PhenomenonClassification
extends
    CIMParseable[PhenomenonClassification]
{
    override val fields: Array[String] = Array[String] (
        "ClassificationCondition",
        "EnvironmentalDataAuthority",
        "EnvironmentalPhenomenon"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ClassificationCondition", "ClassificationCondition", "0..*", "0..1"),
        CIMRelationship ("EnvironmentalDataAuthority", "EnvironmentalDataAuthority", "0..1", "0..*"),
        CIMRelationship ("EnvironmentalPhenomenon", "EnvironmentalPhenomenon", "0..*", "0..1")
    )
    val ClassificationCondition: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val EnvironmentalDataAuthority: Fielder = parse_attribute (attribute (cls, fields(1)))
    val EnvironmentalPhenomenon: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: CIMContext): PhenomenonClassification =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PhenomenonClassification (
            IdentifiedObject.parse (context),
            masks (ClassificationCondition (), 0),
            mask (EnvironmentalDataAuthority (), 1),
            masks (EnvironmentalPhenomenon (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

object PhenomenonClassificationSerializer extends CIMSerializer[PhenomenonClassification]
{
    def write (kryo: Kryo, output: Output, obj: PhenomenonClassification): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.ClassificationCondition, output),
            () => output.writeString (obj.EnvironmentalDataAuthority),
            () => writeList (obj.EnvironmentalPhenomenon, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PhenomenonClassification]): PhenomenonClassification =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PhenomenonClassification (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * <font color="#0f0f0f">Definition of one set of reporting capabilities for this monitoring station.
 *
 * The associated EnvironmentalValueSets describe the maximum range of possible environmental values the station is capable of returning.  This attribute is intended primarily to assist a utility in managing its stations. </font>
 *
 * @param Element Reference to the superclass object.
 * @param reportingIntervalPeriod Number of units of time making up reporting period.
 * @param reportingIntervalType Unit of time in which reporting period is expressed.
 * @param reportingMethod Indicates how the weather station reports observations.
 * @param EnvironmentalAnalog [[ch.ninecode.model.EnvironmentalAnalog EnvironmentalAnalog]] One of the environmental value sets expressing one of the reporting capabilities.
 * @param EnvironmentalMonitoringStation [[ch.ninecode.model.EnvironmentalMonitoringStation EnvironmentalMonitoringStation]] The environmental monitoring station to which this set of reporting capabilities belong.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class ReportingCapability
(
    Element: BasicElement = null,
    reportingIntervalPeriod: Int = 0,
    reportingIntervalType: String = null,
    reportingMethod: String = null,
    EnvironmentalAnalog: List[String] = null,
    EnvironmentalMonitoringStation: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ReportingCapability.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ReportingCapability.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ReportingCapability.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ReportingCapability.fields (position), x))
        emitelem (0, reportingIntervalPeriod)
        emitattr (1, reportingIntervalType)
        emitattr (2, reportingMethod)
        emitattrs (3, EnvironmentalAnalog)
        emitattr (4, EnvironmentalMonitoringStation)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ReportingCapability rdf:ID=\"%s\">\n%s\t</cim:ReportingCapability>".format (id, export_fields)
    }
}

object ReportingCapability
extends
    CIMParseable[ReportingCapability]
{
    override val fields: Array[String] = Array[String] (
        "reportingIntervalPeriod",
        "reportingIntervalType",
        "reportingMethod",
        "EnvironmentalAnalog",
        "EnvironmentalMonitoringStation"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("EnvironmentalAnalog", "EnvironmentalAnalog", "0..*", "0..1"),
        CIMRelationship ("EnvironmentalMonitoringStation", "EnvironmentalMonitoringStation", "1", "0..*")
    )
    val reportingIntervalPeriod: Fielder = parse_element (element (cls, fields(0)))
    val reportingIntervalType: Fielder = parse_attribute (attribute (cls, fields(1)))
    val reportingMethod: Fielder = parse_attribute (attribute (cls, fields(2)))
    val EnvironmentalAnalog: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val EnvironmentalMonitoringStation: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: CIMContext): ReportingCapability =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ReportingCapability (
            BasicElement.parse (context),
            toInteger (mask (reportingIntervalPeriod (), 0)),
            mask (reportingIntervalType (), 1),
            mask (reportingMethod (), 2),
            masks (EnvironmentalAnalog (), 3),
            mask (EnvironmentalMonitoringStation (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

object ReportingCapabilitySerializer extends CIMSerializer[ReportingCapability]
{
    def write (kryo: Kryo, output: Output, obj: ReportingCapability): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeInt (obj.reportingIntervalPeriod),
            () => output.writeString (obj.reportingIntervalType),
            () => output.writeString (obj.reportingMethod),
            () => writeList (obj.EnvironmentalAnalog, output),
            () => output.writeString (obj.EnvironmentalMonitoringStation)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ReportingCapability]): ReportingCapability =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ReportingCapability (
            parent,
            if (isSet (0)) input.readInt else 0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Analog (float) measuring a space (extra-terrestrial) condition.
 *
 * @param EnvironmentalAnalog [[ch.ninecode.model.EnvironmentalAnalog EnvironmentalAnalog]] Reference to the superclass object.
 * @param kind Kind of space analog.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class SpaceAnalog
(
    EnvironmentalAnalog: EnvironmentalAnalog = null,
    kind: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: EnvironmentalAnalog = EnvironmentalAnalog

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SpaceAnalog.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SpaceAnalog.fields (position), value)
        emitattr (0, kind)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SpaceAnalog rdf:ID=\"%s\">\n%s\t</cim:SpaceAnalog>".format (id, export_fields)
    }
}

object SpaceAnalog
extends
    CIMParseable[SpaceAnalog]
{
    override val fields: Array[String] = Array[String] (
        "kind"
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): SpaceAnalog =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SpaceAnalog (
            EnvironmentalAnalog.parse (context),
            mask (kind (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object SpaceAnalogSerializer extends CIMSerializer[SpaceAnalog]
{
    def write (kryo: Kryo, output: Output, obj: SpaceAnalog): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.kind)
        )
        EnvironmentalAnalogSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SpaceAnalog]): SpaceAnalog =
    {
        val parent = EnvironmentalAnalogSerializer.read (kryo, input, classOf[EnvironmentalAnalog])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SpaceAnalog (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An extra-terrestrial phenomenon.
 *
 * @param EnvironmentalPhenomenon [[ch.ninecode.model.EnvironmentalPhenomenon EnvironmentalPhenomenon]] Reference to the superclass object.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class SpacePhenomenon
(
    EnvironmentalPhenomenon: EnvironmentalPhenomenon = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: EnvironmentalPhenomenon = EnvironmentalPhenomenon

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:SpacePhenomenon rdf:ID=\"%s\">\n%s\t</cim:SpacePhenomenon>".format (id, export_fields)
    }
}

object SpacePhenomenon
extends
    CIMParseable[SpacePhenomenon]
{

    def parse (context: CIMContext): SpacePhenomenon =
    {
        val ret = SpacePhenomenon (
            EnvironmentalPhenomenon.parse (context)
        )
        ret
    }
}

object SpacePhenomenonSerializer extends CIMSerializer[SpacePhenomenon]
{
    def write (kryo: Kryo, output: Output, obj: SpacePhenomenon): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        EnvironmentalPhenomenonSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SpacePhenomenon]): SpacePhenomenon =
    {
        val parent = EnvironmentalPhenomenonSerializer.read (kryo, input, classOf[EnvironmentalPhenomenon])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SpacePhenomenon (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A tornado, a violent destructive whirling wind accompanied by a funnel-shaped cloud that progresses in a narrow path over the land.
 *
 * @param AtmosphericPhenomenon [[ch.ninecode.model.AtmosphericPhenomenon AtmosphericPhenomenon]] Reference to the superclass object.
 * @param fScale Fujita scale (referred to as EF-scale starting in 2007) for the tornado.
 * @param width Width of the tornado during the time interval.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class Tornado
(
    AtmosphericPhenomenon: AtmosphericPhenomenon = null,
    fScale: String = null,
    width: Double = 0.0
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: AtmosphericPhenomenon = AtmosphericPhenomenon

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Tornado.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Tornado.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Tornado.fields (position), value)
        emitattr (0, fScale)
        emitelem (1, width)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Tornado rdf:ID=\"%s\">\n%s\t</cim:Tornado>".format (id, export_fields)
    }
}

object Tornado
extends
    CIMParseable[Tornado]
{
    override val fields: Array[String] = Array[String] (
        "fScale",
        "width"
    )
    val fScale: Fielder = parse_attribute (attribute (cls, fields(0)))
    val width: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: CIMContext): Tornado =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Tornado (
            AtmosphericPhenomenon.parse (context),
            mask (fScale (), 0),
            toDouble (mask (width (), 1))
        )
        ret.bitfields = bitfields
        ret
    }
}

object TornadoSerializer extends CIMSerializer[Tornado]
{
    def write (kryo: Kryo, output: Output, obj: Tornado): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.fScale),
            () => output.writeDouble (obj.width)
        )
        AtmosphericPhenomenonSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Tornado]): Tornado =
    {
        val parent = AtmosphericPhenomenonSerializer.read (kryo, input, classOf[AtmosphericPhenomenon])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Tornado (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A tropical cyclone, a subtype of cyclone that forms to the east of 90°E in the Southern Hemisphere whose intensity is measured by the Australian tropical cyclone intensity scale.
 *
 * @param Cyclone [[ch.ninecode.model.Cyclone Cyclone]] Reference to the superclass object.
 * @param category Strength of tropical cyclone during the time interval, based on Australian Bureau of Meteorology Category System where:
 *        1 - tropical cyclone, with typical gusts over flat land 90-125 km/h
 *        2 - tropical cyclone, with typical gusts over flat land 125-164 km/h
 *        3 - severe tropical cyclone, with typical gusts over flat land 165-224 km/h
 *        4 - severe tropical cyclone, with typical gusts over flat land 225-279 km/h
 *        5 - severe tropical cyclone, with typical gusts over flat land greater  than 280 km/h.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class TropicalCycloneAustralia
(
    Cyclone: Cyclone = null,
    category: Int = 0
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Cyclone = Cyclone

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TropicalCycloneAustralia.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TropicalCycloneAustralia.fields (position), value)
        emitelem (0, category)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TropicalCycloneAustralia rdf:ID=\"%s\">\n%s\t</cim:TropicalCycloneAustralia>".format (id, export_fields)
    }
}

object TropicalCycloneAustralia
extends
    CIMParseable[TropicalCycloneAustralia]
{
    override val fields: Array[String] = Array[String] (
        "category"
    )
    val category: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: CIMContext): TropicalCycloneAustralia =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TropicalCycloneAustralia (
            Cyclone.parse (context),
            toInteger (mask (category (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
}

object TropicalCycloneAustraliaSerializer extends CIMSerializer[TropicalCycloneAustralia]
{
    def write (kryo: Kryo, output: Output, obj: TropicalCycloneAustralia): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeInt (obj.category)
        )
        CycloneSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TropicalCycloneAustralia]): TropicalCycloneAustralia =
    {
        val parent = CycloneSerializer.read (kryo, input, classOf[Cyclone])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TropicalCycloneAustralia (
            parent,
            if (isSet (0)) input.readInt else 0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A tsunami (tidal wave), a long high sea wave caused by an earthquake, submarine landslide, or other disturbance.
 *
 * @param HydrosphericPhenomenon [[ch.ninecode.model.HydrosphericPhenomenon HydrosphericPhenomenon]] Reference to the superclass object.
 * @param intensity Tsunami intensity on the Papadopoulos-Imamura tsunami intensity scale.
 *        Possible values are 1-12, corresponding to I-XII.
 * @param magnitude Tsunami magnitude in the Tsunami Magnitude Scale (Mt).
 *        Is greater than zero.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class Tsunami
(
    HydrosphericPhenomenon: HydrosphericPhenomenon = null,
    intensity: Int = 0,
    magnitude: Double = 0.0
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: HydrosphericPhenomenon = HydrosphericPhenomenon

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Tsunami.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Tsunami.fields (position), value)
        emitelem (0, intensity)
        emitelem (1, magnitude)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Tsunami rdf:ID=\"%s\">\n%s\t</cim:Tsunami>".format (id, export_fields)
    }
}

object Tsunami
extends
    CIMParseable[Tsunami]
{
    override val fields: Array[String] = Array[String] (
        "intensity",
        "magnitude"
    )
    val intensity: Fielder = parse_element (element (cls, fields(0)))
    val magnitude: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: CIMContext): Tsunami =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Tsunami (
            HydrosphericPhenomenon.parse (context),
            toInteger (mask (intensity (), 0)),
            toDouble (mask (magnitude (), 1))
        )
        ret.bitfields = bitfields
        ret
    }
}

object TsunamiSerializer extends CIMSerializer[Tsunami]
{
    def write (kryo: Kryo, output: Output, obj: Tsunami): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeInt (obj.intensity),
            () => output.writeDouble (obj.magnitude)
        )
        HydrosphericPhenomenonSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Tsunami]): Tsunami =
    {
        val parent = HydrosphericPhenomenonSerializer.read (kryo, input, classOf[HydrosphericPhenomenon])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Tsunami (
            parent,
            if (isSet (0)) input.readInt else 0,
            if (isSet (1)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An ash cloud formed as a result of a volcanic eruption.
 *
 * @param AtmosphericPhenomenon [[ch.ninecode.model.AtmosphericPhenomenon AtmosphericPhenomenon]] Reference to the superclass object.
 * @param density Particulate density of the ash cloud during the time interval.
 * @param particleSize The diameter of the particles during the time interval.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class VolcanicAshCloud
(
    AtmosphericPhenomenon: AtmosphericPhenomenon = null,
    density: Double = 0.0,
    particleSize: Double = 0.0
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: AtmosphericPhenomenon = AtmosphericPhenomenon

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = VolcanicAshCloud.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (VolcanicAshCloud.fields (position), value)
        emitelem (0, density)
        emitelem (1, particleSize)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:VolcanicAshCloud rdf:ID=\"%s\">\n%s\t</cim:VolcanicAshCloud>".format (id, export_fields)
    }
}

object VolcanicAshCloud
extends
    CIMParseable[VolcanicAshCloud]
{
    override val fields: Array[String] = Array[String] (
        "density",
        "particleSize"
    )
    val density: Fielder = parse_element (element (cls, fields(0)))
    val particleSize: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: CIMContext): VolcanicAshCloud =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = VolcanicAshCloud (
            AtmosphericPhenomenon.parse (context),
            toDouble (mask (density (), 0)),
            toDouble (mask (particleSize (), 1))
        )
        ret.bitfields = bitfields
        ret
    }
}

object VolcanicAshCloudSerializer extends CIMSerializer[VolcanicAshCloud]
{
    def write (kryo: Kryo, output: Output, obj: VolcanicAshCloud): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.density),
            () => output.writeDouble (obj.particleSize)
        )
        AtmosphericPhenomenonSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[VolcanicAshCloud]): VolcanicAshCloud =
    {
        val parent = AtmosphericPhenomenonSerializer.read (kryo, input, classOf[AtmosphericPhenomenon])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = VolcanicAshCloud (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A whirlpool, a rapidly rotating mass of water in a river or sea into which objects may be drawn, typically caused by the meeting of conflicting currents.
 *
 * @param HydrosphericPhenomenon [[ch.ninecode.model.HydrosphericPhenomenon HydrosphericPhenomenon]] Reference to the superclass object.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class Whirlpool
(
    HydrosphericPhenomenon: HydrosphericPhenomenon = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: HydrosphericPhenomenon = HydrosphericPhenomenon

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:Whirlpool rdf:ID=\"%s\">\n%s\t</cim:Whirlpool>".format (id, export_fields)
    }
}

object Whirlpool
extends
    CIMParseable[Whirlpool]
{

    def parse (context: CIMContext): Whirlpool =
    {
        val ret = Whirlpool (
            HydrosphericPhenomenon.parse (context)
        )
        ret
    }
}

object WhirlpoolSerializer extends CIMSerializer[Whirlpool]
{
    def write (kryo: Kryo, output: Output, obj: Whirlpool): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        HydrosphericPhenomenonSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Whirlpool]): Whirlpool =
    {
        val parent = HydrosphericPhenomenonSerializer.read (kryo, input, classOf[HydrosphericPhenomenon])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Whirlpool (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _Environmental
{
    def register: List[CIMClassInfo] =
    {
        List (
            AlertTypeList.register,
            AtmosphericAnalog.register,
            AtmosphericPhenomenon.register,
            ClassificationCondition.register,
            CloudCondition.register,
            Cyclone.register,
            Earthquake.register,
            EnvironmentalAlert.register,
            EnvironmentalAnalog.register,
            EnvironmentalCodedValue.register,
            EnvironmentalDataAuthority.register,
            EnvironmentalDataProvider.register,
            EnvironmentalDiscrete.register,
            EnvironmentalEvent.register,
            EnvironmentalInformation.register,
            EnvironmentalLocationType.register,
            EnvironmentalPhenomenon.register,
            EnvironmentalStringMeasurement.register,
            Fire.register,
            Flood.register,
            Forecast.register,
            GeosphericAnalog.register,
            GeosphericPhenomenon.register,
            Hurricane.register,
            HydrosphericAnalog.register,
            HydrosphericPhenomenon.register,
            Landslide.register,
            LightningStrike.register,
            MagneticStorm.register,
            Observation.register,
            PhenomenonClassification.register,
            ReportingCapability.register,
            SpaceAnalog.register,
            SpacePhenomenon.register,
            Tornado.register,
            TropicalCycloneAustralia.register,
            Tsunami.register,
            VolcanicAshCloud.register,
            Whirlpool.register
        )
    }
}
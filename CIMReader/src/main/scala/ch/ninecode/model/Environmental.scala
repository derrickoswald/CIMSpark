package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * A named list of alert types.
 *
 * Note:  the name of the list is reflected in the .name attribute (inherited from IdentifiedObject).
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param version The version of the named list of alert types.
 * @param EnvironmentalAlert [[ch.ninecode.model.EnvironmentalAlert EnvironmentalAlert]] An alert whose type is drawn from this alert type list.
 * @param EnvironmentalDataAuthority [[ch.ninecode.model.EnvironmentalDataAuthority EnvironmentalDataAuthority]] The environmental data authority responsible for publishing this list of alert types.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class AlertTypeList
(
    override val sup: IdentifiedObject = null,
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[AlertTypeList] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[AlertTypeList]
{
    override val fields: Array[String] = Array[String] (
        "version",
        "EnvironmentalAlert",
        "EnvironmentalDataAuthority"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EnvironmentalAlert", "EnvironmentalAlert", "0..*", "1"),
        Relationship ("EnvironmentalDataAuthority", "EnvironmentalDataAuthority", "0..1", "0..*")
    )
    val version: Fielder = parse_element (element (cls, fields(0)))
    val EnvironmentalAlert: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val EnvironmentalDataAuthority: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): AlertTypeList =
    {
        implicit val ctx: Context = context
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

/**
 * Analog (float) measuring an atmospheric condition.
 *
 * @param sup [[ch.ninecode.model.EnvironmentalAnalog EnvironmentalAnalog]] Reference to the superclass object.
 * @param kind Kind of atmospheric analog.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class AtmosphericAnalog
(
    override val sup: EnvironmentalAnalog = null,
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
    def EnvironmentalAnalog: EnvironmentalAnalog = sup.asInstanceOf[EnvironmentalAnalog]
    override def copy (): Row = { clone ().asInstanceOf[AtmosphericAnalog] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[AtmosphericAnalog]
{
    override val fields: Array[String] = Array[String] (
        "kind"
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): AtmosphericAnalog =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AtmosphericAnalog (
            EnvironmentalAnalog.parse (context),
            mask (kind (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An atmospheric phenomenon with a base and altitude providing the vertical coverage (combined with the Location to provide three dimensional space).
 *
 * @param sup [[ch.ninecode.model.EnvironmentalPhenomenon EnvironmentalPhenomenon]] Reference to the superclass object.
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
    override val sup: EnvironmentalPhenomenon = null,
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
    def EnvironmentalPhenomenon: EnvironmentalPhenomenon = sup.asInstanceOf[EnvironmentalPhenomenon]
    override def copy (): Row = { clone ().asInstanceOf[AtmosphericPhenomenon] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[AtmosphericPhenomenon]
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

    def parse (context: Context): AtmosphericPhenomenon =
    {
        implicit val ctx: Context = context
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

/**
 * A classification condition used to define preconditions that must be met by a phenomena classification.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
    override val sup: IdentifiedObject = null,
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[ClassificationCondition] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[ClassificationCondition]
{
    override val fields: Array[String] = Array[String] (
        "duration",
        "test",
        "EnvironmentalAnalog",
        "EnvironmentalStringMeasurement",
        "PhenomenonClassification"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EnvironmentalAnalog", "EnvironmentalAnalog", "0..*", "0..1"),
        Relationship ("EnvironmentalStringMeasurement", "EnvironmentalStringMeasurement", "0..*", "0..1"),
        Relationship ("PhenomenonClassification", "PhenomenonClassification", "0..1", "0..*")
    )
    val duration: Fielder = parse_element (element (cls, fields(0)))
    val test: Fielder = parse_attribute (attribute (cls, fields(1)))
    val EnvironmentalAnalog: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val EnvironmentalStringMeasurement: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val PhenomenonClassification: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): ClassificationCondition =
    {
        implicit val ctx: Context = context
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

/**
 * A classified cloud phenomenon with a type.
 *
 * @param sup [[ch.ninecode.model.AtmosphericPhenomenon AtmosphericPhenomenon]] Reference to the superclass object.
 * @param kind The type of the cloud as defined by the CloudKind enumeration.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class CloudCondition
(
    override val sup: AtmosphericPhenomenon = null,
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
    def AtmosphericPhenomenon: AtmosphericPhenomenon = sup.asInstanceOf[AtmosphericPhenomenon]
    override def copy (): Row = { clone ().asInstanceOf[CloudCondition] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[CloudCondition]
{
    override val fields: Array[String] = Array[String] (
        "kind"
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): CloudCondition =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CloudCondition (
            AtmosphericPhenomenon.parse (context),
            mask (kind (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A cyclone (or tropical cyclone), a rapidly-rotating storm system characterized by a low-pressure center, strong winds, and a spiral arrangement of thunderstorms that produce heavy rain.
 *
 * @param sup [[ch.ninecode.model.AtmosphericPhenomenon AtmosphericPhenomenon]] Reference to the superclass object.
 * @param centralPressure The central pressure of the cyclone during the time interval.
 * @param maxSurfaceWindSpeed The maximum surface wind speed of the cyclone during the time interval.
 * @param windForce Wind Force as classified on the Beaufort Scale (0-12) during the time interval.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class Cyclone
(
    override val sup: AtmosphericPhenomenon = null,
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
    def AtmosphericPhenomenon: AtmosphericPhenomenon = sup.asInstanceOf[AtmosphericPhenomenon]
    override def copy (): Row = { clone ().asInstanceOf[Cyclone] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[Cyclone]
{
    override val fields: Array[String] = Array[String] (
        "centralPressure",
        "maxSurfaceWindSpeed",
        "windForce"
    )
    val centralPressure: Fielder = parse_element (element (cls, fields(0)))
    val maxSurfaceWindSpeed: Fielder = parse_element (element (cls, fields(1)))
    val windForce: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: Context): Cyclone =
    {
        implicit val ctx: Context = context
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

/**
 * An earthquake.
 *
 * @param sup [[ch.ninecode.model.GeosphericPhenomenon GeosphericPhenomenon]] Reference to the superclass object.
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
    override val sup: GeosphericPhenomenon = null,
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
    def GeosphericPhenomenon: GeosphericPhenomenon = sup.asInstanceOf[GeosphericPhenomenon]
    override def copy (): Row = { clone ().asInstanceOf[Earthquake] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[Earthquake]
{
    override val fields: Array[String] = Array[String] (
        "focalDepth",
        "intensity",
        "magnitude"
    )
    val focalDepth: Fielder = parse_attribute (attribute (cls, fields(0)))
    val intensity: Fielder = parse_element (element (cls, fields(1)))
    val magnitude: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: Context): Earthquake =
    {
        implicit val ctx: Context = context
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

/**
 * An environmental alert issued by a provider or system.
 *
 * @param sup [[ch.ninecode.model.ActivityRecord ActivityRecord]] Reference to the superclass object.
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
    override val sup: ActivityRecord = null,
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
    def ActivityRecord: ActivityRecord = sup.asInstanceOf[ActivityRecord]
    override def copy (): Row = { clone ().asInstanceOf[EnvironmentalAlert] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[EnvironmentalAlert]
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
    override val relations: List[Relationship] = List (
        Relationship ("AlertTypeList", "AlertTypeList", "1", "0..*"),
        Relationship ("EnvironmentalDataProvider", "EnvironmentalDataProvider", "0..1", "0..*"),
        Relationship ("EnvironmentalLocationKind", "EnvironmentalLocationType", "1..*", "0..*")
    )
    val alertType: Fielder = parse_element (element (cls, fields(0)))
    val cancelledDateTime: Fielder = parse_element (element (cls, fields(1)))
    val headline: Fielder = parse_element (element (cls, fields(2)))
    val inEffect: Fielder = parse_attribute (attribute (cls, fields(3)))
    val AlertTypeList: Fielder = parse_attribute (attribute (cls, fields(4)))
    val EnvironmentalDataProvider: Fielder = parse_attribute (attribute (cls, fields(5)))
    val EnvironmentalLocationKind: FielderMultiple = parse_attributes (attribute (cls, fields(6)))

    def parse (context: Context): EnvironmentalAlert =
    {
        implicit val ctx: Context = context
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

/**
 * Analog (float) measurement of relevance in the environmental domain.
 *
 * @param sup [[ch.ninecode.model.Analog Analog]] Reference to the superclass object.
 * @param ClassificationCondition [[ch.ninecode.model.ClassificationCondition ClassificationCondition]] Classification condition which this analog helps define.
 * @param EnvironmentalInformation [[ch.ninecode.model.EnvironmentalInformation EnvironmentalInformation]] Observation or forecast with which this environmental analog measurement is associated.
 * @param EnvironmentalMonitoringStation [[ch.ninecode.model.EnvironmentalMonitoringStation EnvironmentalMonitoringStation]] Monitoring station which provides this environmental analog measurement.
 * @param ReportingCapability [[ch.ninecode.model.ReportingCapability ReportingCapability]] The reporting capability this environmental value set helps define.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class EnvironmentalAnalog
(
    override val sup: Analog = null,
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
    def Analog: Analog = sup.asInstanceOf[Analog]
    override def copy (): Row = { clone ().asInstanceOf[EnvironmentalAnalog] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[EnvironmentalAnalog]
{
    override val fields: Array[String] = Array[String] (
        "ClassificationCondition",
        "EnvironmentalInformation",
        "EnvironmentalMonitoringStation",
        "ReportingCapability"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ClassificationCondition", "ClassificationCondition", "0..1", "0..*"),
        Relationship ("EnvironmentalInformation", "EnvironmentalInformation", "0..1", "0..*"),
        Relationship ("EnvironmentalMonitoringStation", "EnvironmentalMonitoringStation", "0..1", "0..*"),
        Relationship ("ReportingCapability", "ReportingCapability", "0..1", "0..*")
    )
    val ClassificationCondition: Fielder = parse_attribute (attribute (cls, fields(0)))
    val EnvironmentalInformation: Fielder = parse_attribute (attribute (cls, fields(1)))
    val EnvironmentalMonitoringStation: Fielder = parse_attribute (attribute (cls, fields(2)))
    val ReportingCapability: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): EnvironmentalAnalog =
    {
        implicit val ctx: Context = context
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

/**
 * An environmental value described using a coded value.
 *
 * A triplicate of enumerated values representing intensity, coverage, type of weather is used. These may be concatenated into the string value.
 *
 * @param sup [[ch.ninecode.model.StringMeasurementValue StringMeasurementValue]] Reference to the superclass object.
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
    override val sup: StringMeasurementValue = null,
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
    def StringMeasurementValue: StringMeasurementValue = sup.asInstanceOf[StringMeasurementValue]
    override def copy (): Row = { clone ().asInstanceOf[EnvironmentalCodedValue] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[EnvironmentalCodedValue]
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

    def parse (context: Context): EnvironmentalCodedValue =
    {
        implicit val ctx: Context = context
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

/**
 * An entity defining classifications or categories of environmental information, like phenomena or alerts.
 *
 * @param sup [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @param AlertTypeList [[ch.ninecode.model.AlertTypeList AlertTypeList]] A specific version of a list of alerts published by this environmental data authority.
 * @param PhenomenonClassification [[ch.ninecode.model.PhenomenonClassification PhenomenonClassification]] Phenomenon classification defined by this environmental data authority.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class EnvironmentalDataAuthority
(
    override val sup: OrganisationRole = null,
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
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { clone ().asInstanceOf[EnvironmentalDataAuthority] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[EnvironmentalDataAuthority]
{
    override val fields: Array[String] = Array[String] (
        "AlertTypeList",
        "PhenomenonClassification"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AlertTypeList", "AlertTypeList", "0..*", "0..1"),
        Relationship ("PhenomenonClassification", "PhenomenonClassification", "0..*", "0..1")
    )
    val AlertTypeList: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val PhenomenonClassification: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): EnvironmentalDataAuthority =
    {
        implicit val ctx: Context = context
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

/**
 * Entity providing environmental data.
 *
 * Could be an observed weather data provider, an entity providing forecasts, an authority providing alerts, etc.
 *
 * @param sup [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @param EnvironmentalAlert [[ch.ninecode.model.EnvironmentalAlert EnvironmentalAlert]] Alert issued by this environmental data provider.
 * @param EnvironmentalInformation [[ch.ninecode.model.EnvironmentalInformation EnvironmentalInformation]] Environmental information provided by this environmental data provider.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class EnvironmentalDataProvider
(
    override val sup: OrganisationRole = null,
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
    def OrganisationRole: OrganisationRole = sup.asInstanceOf[OrganisationRole]
    override def copy (): Row = { clone ().asInstanceOf[EnvironmentalDataProvider] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[EnvironmentalDataProvider]
{
    override val fields: Array[String] = Array[String] (
        "EnvironmentalAlert",
        "EnvironmentalInformation"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EnvironmentalAlert", "EnvironmentalAlert", "0..*", "0..1"),
        Relationship ("EnvironmentalInformation", "EnvironmentalInformation", "0..*", "0..1")
    )
    val EnvironmentalAlert: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val EnvironmentalInformation: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): EnvironmentalDataProvider =
    {
        implicit val ctx: Context = context
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

/**
 * Discrete (integer) measurement of relevance in the environmental domain.
 *
 * @param sup [[ch.ninecode.model.Discrete Discrete]] Reference to the superclass object.
 * @param kind Kind of environmental discrete (integer).
 * @param EnvironmentalInformation [[ch.ninecode.model.EnvironmentalInformation EnvironmentalInformation]] Observation or forecast with which this environmental discrete (integer) is associated.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class EnvironmentalDiscrete
(
    override val sup: Discrete = null,
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
    def Discrete: Discrete = sup.asInstanceOf[Discrete]
    override def copy (): Row = { clone ().asInstanceOf[EnvironmentalDiscrete] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[EnvironmentalDiscrete]
{
    override val fields: Array[String] = Array[String] (
        "kind",
        "EnvironmentalInformation"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EnvironmentalInformation", "EnvironmentalInformation", "0..1", "0..*")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val EnvironmentalInformation: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): EnvironmentalDiscrete =
    {
        implicit val ctx: Context = context
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

/**
 * An environmental event to which one or more forecasts or observations may be tied and which may relate to or affect one or more assets.
 *
 * This class is intended to be used as a means of grouping forecasts and/or observations and could be used for a variety of purposes, including:
 * <ul>
 * <li>to define a 'named' event like Hurricane Katrina and allow the historic (or forecast) values for phenomena and measurements (precipitation, temperature) across time to be  associated with it</li>
 * <li>to identify assets that were (or are forecast to be) affected by a phenomenon or set of measurements</li>
 * </ul>
 *
 * @param sup [[ch.ninecode.model.ActivityRecord ActivityRecord]] Reference to the superclass object.
 * @param EnvironmentalInformation [[ch.ninecode.model.EnvironmentalInformation EnvironmentalInformation]] Forecast or observation related to this environmental event.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class EnvironmentalEvent
(
    override val sup: ActivityRecord = null,
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
    def ActivityRecord: ActivityRecord = sup.asInstanceOf[ActivityRecord]
    override def copy (): Row = { clone ().asInstanceOf[EnvironmentalEvent] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[EnvironmentalEvent]
{
    override val fields: Array[String] = Array[String] (
        "EnvironmentalInformation"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EnvironmentalInformation", "EnvironmentalInformation", "0..*", "0..*")
    )
    val EnvironmentalInformation: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): EnvironmentalEvent =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EnvironmentalEvent (
            ActivityRecord.parse (context),
            masks (EnvironmentalInformation (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Abstract class (with concrete child classes of Observation and Forecast) that groups phenomenon and/or environmental value sets.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
    override val sup: IdentifiedObject = null,
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[EnvironmentalInformation] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[EnvironmentalInformation]
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
    override val relations: List[Relationship] = List (
        Relationship ("EnvironmentalAnalog", "EnvironmentalAnalog", "0..*", "0..1"),
        Relationship ("EnvironmentalDataProvider", "EnvironmentalDataProvider", "0..1", "0..*"),
        Relationship ("EnvironmentalDiscrete", "EnvironmentalDiscrete", "0..*", "0..1"),
        Relationship ("EnvironmentalEvent", "EnvironmentalEvent", "0..*", "0..*"),
        Relationship ("EnvironmentalPhenomenon", "EnvironmentalPhenomenon", "0..*", "0..1"),
        Relationship ("EnvironmentalStringMeasurement", "EnvironmentalStringMeasurement", "0..*", "0..1")
    )
    val created: Fielder = parse_element (element (cls, fields(0)))
    val EnvironmentalAnalog: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val EnvironmentalDataProvider: Fielder = parse_attribute (attribute (cls, fields(2)))
    val EnvironmentalDiscrete: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val EnvironmentalEvent: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val EnvironmentalPhenomenon: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val EnvironmentalStringMeasurement: FielderMultiple = parse_attributes (attribute (cls, fields(6)))

    def parse (context: Context): EnvironmentalInformation =
    {
        implicit val ctx: Context = context
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

/**
 * Type of environmental location.
 *
 * Used when an environmental alert or phenomenon has multiple locations associated with it.
 *
 * @param sup Reference to the superclass object.
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
    override val sup: BasicElement = null,
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[EnvironmentalLocationType] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[EnvironmentalLocationType]
{
    override val fields: Array[String] = Array[String] (
        "kind",
        "EnvironmentalAlert",
        "EnvironmentalPhenomenon",
        "Location"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EnvironmentalAlert", "EnvironmentalAlert", "0..*", "1..*"),
        Relationship ("EnvironmentalPhenomenon", "EnvironmentalPhenomenon", "0..*", "0..*"),
        Relationship ("Location", "Location", "0..1", "0..*")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val EnvironmentalAlert: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val EnvironmentalPhenomenon: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Location: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): EnvironmentalLocationType =
    {
        implicit val ctx: Context = context
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

/**
 * The actual or forecast characteristics of an environmental phenomenon at a specific point in time (or during a specific time interval) that may have both a center and area/line location.
 *
 * @param sup Reference to the superclass object.
 * @param timeInterval The timestamp of the phenomenon as a single point or time interval.
 * @param EnvironmentalInformation [[ch.ninecode.model.EnvironmentalInformation EnvironmentalInformation]] The forecast or observation of which this phenomenon description is a part.
 * @param EnvironmentalLocationKind [[ch.ninecode.model.EnvironmentalLocationType EnvironmentalLocationType]] Location of relevance to this environmental phenomenon.
 * @param PhenomenonClassification [[ch.ninecode.model.PhenomenonClassification PhenomenonClassification]] The classification of this phenomenon.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class EnvironmentalPhenomenon
(
    override val sup: BasicElement = null,
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[EnvironmentalPhenomenon] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[EnvironmentalPhenomenon]
{
    override val fields: Array[String] = Array[String] (
        "timeInterval",
        "EnvironmentalInformation",
        "EnvironmentalLocationKind",
        "PhenomenonClassification"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EnvironmentalInformation", "EnvironmentalInformation", "0..1", "0..*"),
        Relationship ("EnvironmentalLocationKind", "EnvironmentalLocationType", "0..*", "0..*"),
        Relationship ("PhenomenonClassification", "PhenomenonClassification", "0..1", "0..*")
    )
    val timeInterval: Fielder = parse_attribute (attribute (cls, fields(0)))
    val EnvironmentalInformation: Fielder = parse_attribute (attribute (cls, fields(1)))
    val EnvironmentalLocationKind: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val PhenomenonClassification: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): EnvironmentalPhenomenon =
    {
        implicit val ctx: Context = context
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

/**
 * String measurement of relevance in the environmental domain.
 *
 * @param sup [[ch.ninecode.model.StringMeasurement StringMeasurement]] Reference to the superclass object.
 * @param ClassificationCondition [[ch.ninecode.model.ClassificationCondition ClassificationCondition]] Classification condition which this string measurement helps define.
 * @param EnvironmentalInformation [[ch.ninecode.model.EnvironmentalInformation EnvironmentalInformation]] Observation or forecast with which this environmental string is associated.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class EnvironmentalStringMeasurement
(
    override val sup: StringMeasurement = null,
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
    def StringMeasurement: StringMeasurement = sup.asInstanceOf[StringMeasurement]
    override def copy (): Row = { clone ().asInstanceOf[EnvironmentalStringMeasurement] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[EnvironmentalStringMeasurement]
{
    override val fields: Array[String] = Array[String] (
        "ClassificationCondition",
        "EnvironmentalInformation"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ClassificationCondition", "ClassificationCondition", "0..1", "0..*"),
        Relationship ("EnvironmentalInformation", "EnvironmentalInformation", "0..1", "0..*")
    )
    val ClassificationCondition: Fielder = parse_attribute (attribute (cls, fields(0)))
    val EnvironmentalInformation: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): EnvironmentalStringMeasurement =
    {
        implicit val ctx: Context = context
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

/**
 * A fire, often uncontrolled, covering an area of land which typically contains combustible vegetation.
 *
 * Associated location information is assumed to describe the total area burned as of a specified time.
 *
 * @param sup [[ch.ninecode.model.GeosphericPhenomenon GeosphericPhenomenon]] Reference to the superclass object.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class Fire
(
    override val sup: GeosphericPhenomenon = null
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
    def GeosphericPhenomenon: GeosphericPhenomenon = sup.asInstanceOf[GeosphericPhenomenon]
    override def copy (): Row = { clone ().asInstanceOf[Fire] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[Fire]
{

    def parse (context: Context): Fire =
    {
        implicit val ctx: Context = context
        val ret = Fire (
            GeosphericPhenomenon.parse (context)
        )
        ret
    }
}

/**
 * A flood, an overflowing of a large amount of water beyond its normal confines, esp. over what is normally dry land.
 *
 * @param sup [[ch.ninecode.model.HydrosphericPhenomenon HydrosphericPhenomenon]] Reference to the superclass object.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class Flood
(
    override val sup: HydrosphericPhenomenon = null
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
    def HydrosphericPhenomenon: HydrosphericPhenomenon = sup.asInstanceOf[HydrosphericPhenomenon]
    override def copy (): Row = { clone ().asInstanceOf[Flood] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[Flood]
{

    def parse (context: Context): Flood =
    {
        implicit val ctx: Context = context
        val ret = Flood (
            HydrosphericPhenomenon.parse (context)
        )
        ret
    }
}

/**
 * A forecast group of value sets and/or phenomena characteristics.
 *
 * @param sup [[ch.ninecode.model.EnvironmentalInformation EnvironmentalInformation]] Reference to the superclass object.
 * @param validFor The interval for which the forecast is valid.
 *        For example, a forecast issued now for tomorrow might be valid for the next 2 hours.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class Forecast
(
    override val sup: EnvironmentalInformation = null,
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
    def EnvironmentalInformation: EnvironmentalInformation = sup.asInstanceOf[EnvironmentalInformation]
    override def copy (): Row = { clone ().asInstanceOf[Forecast] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[Forecast]
{
    override val fields: Array[String] = Array[String] (
        "validFor"
    )
    val validFor: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): Forecast =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Forecast (
            EnvironmentalInformation.parse (context),
            mask (validFor (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Analog (float) measuring a geospheric condition.
 *
 * @param sup [[ch.ninecode.model.EnvironmentalAnalog EnvironmentalAnalog]] Reference to the superclass object.
 * @param kind Kind of geospheric analog.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class GeosphericAnalog
(
    override val sup: EnvironmentalAnalog = null,
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
    def EnvironmentalAnalog: EnvironmentalAnalog = sup.asInstanceOf[EnvironmentalAnalog]
    override def copy (): Row = { clone ().asInstanceOf[GeosphericAnalog] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[GeosphericAnalog]
{
    override val fields: Array[String] = Array[String] (
        "kind"
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): GeosphericAnalog =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GeosphericAnalog (
            EnvironmentalAnalog.parse (context),
            mask (kind (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A geospheric phenomenon.
 *
 * @param sup [[ch.ninecode.model.EnvironmentalPhenomenon EnvironmentalPhenomenon]] Reference to the superclass object.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class GeosphericPhenomenon
(
    override val sup: EnvironmentalPhenomenon = null
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
    def EnvironmentalPhenomenon: EnvironmentalPhenomenon = sup.asInstanceOf[EnvironmentalPhenomenon]
    override def copy (): Row = { clone ().asInstanceOf[GeosphericPhenomenon] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[GeosphericPhenomenon]
{

    def parse (context: Context): GeosphericPhenomenon =
    {
        implicit val ctx: Context = context
        val ret = GeosphericPhenomenon (
            EnvironmentalPhenomenon.parse (context)
        )
        ret
    }
}

/**
 * A hurricane, a subtype of cyclone occurring in the North Atlantic Ocean or North-eastern Pacific Ocean whose intensity is measured using the Saffir-Simpson Hurricane Scale.
 *
 * @param sup [[ch.ninecode.model.Cyclone Cyclone]] Reference to the superclass object.
 * @param category The hurricane's category during the time interval, using Saffir-Simpson Hurricane Wind Scale, a 1 to 5 rating based on a hurricane's sustained wind speed.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class Hurricane
(
    override val sup: Cyclone = null,
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
    def Cyclone: Cyclone = sup.asInstanceOf[Cyclone]
    override def copy (): Row = { clone ().asInstanceOf[Hurricane] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[Hurricane]
{
    override val fields: Array[String] = Array[String] (
        "category"
    )
    val category: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): Hurricane =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Hurricane (
            Cyclone.parse (context),
            toInteger (mask (category (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Analog (float) measuring a hydrospheric condition.
 *
 * @param sup [[ch.ninecode.model.EnvironmentalAnalog EnvironmentalAnalog]] Reference to the superclass object.
 * @param kind Kind of hydrospheric analog.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class HydrosphericAnalog
(
    override val sup: EnvironmentalAnalog = null,
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
    def EnvironmentalAnalog: EnvironmentalAnalog = sup.asInstanceOf[EnvironmentalAnalog]
    override def copy (): Row = { clone ().asInstanceOf[HydrosphericAnalog] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[HydrosphericAnalog]
{
    override val fields: Array[String] = Array[String] (
        "kind"
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): HydrosphericAnalog =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = HydrosphericAnalog (
            EnvironmentalAnalog.parse (context),
            mask (kind (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A hydrospheric phenomenon.
 *
 * @param sup [[ch.ninecode.model.EnvironmentalPhenomenon EnvironmentalPhenomenon]] Reference to the superclass object.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class HydrosphericPhenomenon
(
    override val sup: EnvironmentalPhenomenon = null
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
    def EnvironmentalPhenomenon: EnvironmentalPhenomenon = sup.asInstanceOf[EnvironmentalPhenomenon]
    override def copy (): Row = { clone ().asInstanceOf[HydrosphericPhenomenon] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[HydrosphericPhenomenon]
{

    def parse (context: Context): HydrosphericPhenomenon =
    {
        implicit val ctx: Context = context
        val ret = HydrosphericPhenomenon (
            EnvironmentalPhenomenon.parse (context)
        )
        ret
    }
}

/**
 * A landslide, a large mass of rocks and earth that suddenly and quickly moves down the side of a mountain or hill.
 *
 * @param sup [[ch.ninecode.model.GeosphericPhenomenon GeosphericPhenomenon]] Reference to the superclass object.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class Landslide
(
    override val sup: GeosphericPhenomenon = null
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
    def GeosphericPhenomenon: GeosphericPhenomenon = sup.asInstanceOf[GeosphericPhenomenon]
    override def copy (): Row = { clone ().asInstanceOf[Landslide] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[Landslide]
{

    def parse (context: Context): Landslide =
    {
        implicit val ctx: Context = context
        val ret = Landslide (
            GeosphericPhenomenon.parse (context)
        )
        ret
    }
}

/**
 * A cloud-to-ground lightning strike at a particular location.
 *
 * @param sup [[ch.ninecode.model.GeosphericPhenomenon GeosphericPhenomenon]] Reference to the superclass object.
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
    override val sup: GeosphericPhenomenon = null,
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
    def GeosphericPhenomenon: GeosphericPhenomenon = sup.asInstanceOf[GeosphericPhenomenon]
    override def copy (): Row = { clone ().asInstanceOf[LightningStrike] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[LightningStrike]
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

    def parse (context: Context): LightningStrike =
    {
        implicit val ctx: Context = context
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

/**
 * A magnetic storm, a temporary disturbance of the earth's magnetic field, induced by radiation and streams of charged particles from the sun.
 *
 * @param sup [[ch.ninecode.model.SpacePhenomenon SpacePhenomenon]] Reference to the superclass object.
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
    override val sup: SpacePhenomenon = null,
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
    def SpacePhenomenon: SpacePhenomenon = sup.asInstanceOf[SpacePhenomenon]
    override def copy (): Row = { clone ().asInstanceOf[MagneticStorm] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[MagneticStorm]
{
    override val fields: Array[String] = Array[String] (
        "changeDst"
    )
    val changeDst: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): MagneticStorm =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MagneticStorm (
            SpacePhenomenon.parse (context),
            toDouble (mask (changeDst (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Observed (actual non-forecast) values sets and/or phenomena characteristics.
 *
 * @param sup [[ch.ninecode.model.EnvironmentalInformation EnvironmentalInformation]] Reference to the superclass object.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class Observation
(
    override val sup: EnvironmentalInformation = null
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
    def EnvironmentalInformation: EnvironmentalInformation = sup.asInstanceOf[EnvironmentalInformation]
    override def copy (): Row = { clone ().asInstanceOf[Observation] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[Observation]
{

    def parse (context: Context): Observation =
    {
        implicit val ctx: Context = context
        val ret = Observation (
            EnvironmentalInformation.parse (context)
        )
        ret
    }
}

/**
 * A pre-defined phenomenon classification as defined by a particular authority.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ClassificationCondition [[ch.ninecode.model.ClassificationCondition ClassificationCondition]] Condition contributing to the classification of this phenomenon.
 * @param EnvironmentalDataAuthority [[ch.ninecode.model.EnvironmentalDataAuthority EnvironmentalDataAuthority]] Authority defining this environmental phenomenon.
 * @param EnvironmentalPhenomenon [[ch.ninecode.model.EnvironmentalPhenomenon EnvironmentalPhenomenon]] <em>undocumented</em>
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class PhenomenonClassification
(
    override val sup: IdentifiedObject = null,
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[PhenomenonClassification] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[PhenomenonClassification]
{
    override val fields: Array[String] = Array[String] (
        "ClassificationCondition",
        "EnvironmentalDataAuthority",
        "EnvironmentalPhenomenon"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ClassificationCondition", "ClassificationCondition", "0..*", "0..1"),
        Relationship ("EnvironmentalDataAuthority", "EnvironmentalDataAuthority", "0..1", "0..*"),
        Relationship ("EnvironmentalPhenomenon", "EnvironmentalPhenomenon", "0..*", "0..1")
    )
    val ClassificationCondition: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val EnvironmentalDataAuthority: Fielder = parse_attribute (attribute (cls, fields(1)))
    val EnvironmentalPhenomenon: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): PhenomenonClassification =
    {
        implicit val ctx: Context = context
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

/**
 * <font color="#0f0f0f">Definition of one set of reporting capabilities for this monitoring station.
 *
 * The associated EnvironmentalValueSets describe the maximum range of possible environmental values the station is capable of returning.  This attribute is intended primarily to assist a utility in managing its stations. </font>
 *
 * @param sup Reference to the superclass object.
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
    override val sup: BasicElement = null,
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
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ReportingCapability] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[ReportingCapability]
{
    override val fields: Array[String] = Array[String] (
        "reportingIntervalPeriod",
        "reportingIntervalType",
        "reportingMethod",
        "EnvironmentalAnalog",
        "EnvironmentalMonitoringStation"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EnvironmentalAnalog", "EnvironmentalAnalog", "0..*", "0..1"),
        Relationship ("EnvironmentalMonitoringStation", "EnvironmentalMonitoringStation", "1", "0..*")
    )
    val reportingIntervalPeriod: Fielder = parse_element (element (cls, fields(0)))
    val reportingIntervalType: Fielder = parse_attribute (attribute (cls, fields(1)))
    val reportingMethod: Fielder = parse_attribute (attribute (cls, fields(2)))
    val EnvironmentalAnalog: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val EnvironmentalMonitoringStation: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): ReportingCapability =
    {
        implicit val ctx: Context = context
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

/**
 * Analog (float) measuring a space (extra-terrestrial) condition.
 *
 * @param sup [[ch.ninecode.model.EnvironmentalAnalog EnvironmentalAnalog]] Reference to the superclass object.
 * @param kind Kind of space analog.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class SpaceAnalog
(
    override val sup: EnvironmentalAnalog = null,
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
    def EnvironmentalAnalog: EnvironmentalAnalog = sup.asInstanceOf[EnvironmentalAnalog]
    override def copy (): Row = { clone ().asInstanceOf[SpaceAnalog] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[SpaceAnalog]
{
    override val fields: Array[String] = Array[String] (
        "kind"
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): SpaceAnalog =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SpaceAnalog (
            EnvironmentalAnalog.parse (context),
            mask (kind (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An extra-terrestrial phenomenon.
 *
 * @param sup [[ch.ninecode.model.EnvironmentalPhenomenon EnvironmentalPhenomenon]] Reference to the superclass object.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class SpacePhenomenon
(
    override val sup: EnvironmentalPhenomenon = null
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
    def EnvironmentalPhenomenon: EnvironmentalPhenomenon = sup.asInstanceOf[EnvironmentalPhenomenon]
    override def copy (): Row = { clone ().asInstanceOf[SpacePhenomenon] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[SpacePhenomenon]
{

    def parse (context: Context): SpacePhenomenon =
    {
        implicit val ctx: Context = context
        val ret = SpacePhenomenon (
            EnvironmentalPhenomenon.parse (context)
        )
        ret
    }
}

/**
 * A tornado, a violent destructive whirling wind accompanied by a funnel-shaped cloud that progresses in a narrow path over the land.
 *
 * @param sup [[ch.ninecode.model.AtmosphericPhenomenon AtmosphericPhenomenon]] Reference to the superclass object.
 * @param fScale Fujita scale (referred to as EF-scale starting in 2007) for the tornado.
 * @param width Width of the tornado during the time interval.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class Tornado
(
    override val sup: AtmosphericPhenomenon = null,
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
    def AtmosphericPhenomenon: AtmosphericPhenomenon = sup.asInstanceOf[AtmosphericPhenomenon]
    override def copy (): Row = { clone ().asInstanceOf[Tornado] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[Tornado]
{
    override val fields: Array[String] = Array[String] (
        "fScale",
        "width"
    )
    val fScale: Fielder = parse_attribute (attribute (cls, fields(0)))
    val width: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): Tornado =
    {
        implicit val ctx: Context = context
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

/**
 * A tropical cyclone, a subtype of cyclone that forms to the east of 90°E in the Southern Hemisphere whose intensity is measured by the Australian tropical cyclone intensity scale.
 *
 * @param sup [[ch.ninecode.model.Cyclone Cyclone]] Reference to the superclass object.
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
    override val sup: Cyclone = null,
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
    def Cyclone: Cyclone = sup.asInstanceOf[Cyclone]
    override def copy (): Row = { clone ().asInstanceOf[TropicalCycloneAustralia] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[TropicalCycloneAustralia]
{
    override val fields: Array[String] = Array[String] (
        "category"
    )
    val category: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): TropicalCycloneAustralia =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TropicalCycloneAustralia (
            Cyclone.parse (context),
            toInteger (mask (category (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A tsunami (tidal wave), a long high sea wave caused by an earthquake, submarine landslide, or other disturbance.
 *
 * @param sup [[ch.ninecode.model.HydrosphericPhenomenon HydrosphericPhenomenon]] Reference to the superclass object.
 * @param intensity Tsunami intensity on the Papadopoulos-Imamura tsunami intensity scale.
 *        Possible values are 1-12, corresponding to I-XII.
 * @param magnitude Tsunami magnitude in the Tsunami Magnitude Scale (Mt).
 *        Is greater than zero.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class Tsunami
(
    override val sup: HydrosphericPhenomenon = null,
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
    def HydrosphericPhenomenon: HydrosphericPhenomenon = sup.asInstanceOf[HydrosphericPhenomenon]
    override def copy (): Row = { clone ().asInstanceOf[Tsunami] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[Tsunami]
{
    override val fields: Array[String] = Array[String] (
        "intensity",
        "magnitude"
    )
    val intensity: Fielder = parse_element (element (cls, fields(0)))
    val magnitude: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): Tsunami =
    {
        implicit val ctx: Context = context
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

/**
 * An ash cloud formed as a result of a volcanic eruption.
 *
 * @param sup [[ch.ninecode.model.AtmosphericPhenomenon AtmosphericPhenomenon]] Reference to the superclass object.
 * @param density Particulate density of the ash cloud during the time interval.
 * @param particleSize The diameter of the particles during the time interval.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class VolcanicAshCloud
(
    override val sup: AtmosphericPhenomenon = null,
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
    def AtmosphericPhenomenon: AtmosphericPhenomenon = sup.asInstanceOf[AtmosphericPhenomenon]
    override def copy (): Row = { clone ().asInstanceOf[VolcanicAshCloud] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[VolcanicAshCloud]
{
    override val fields: Array[String] = Array[String] (
        "density",
        "particleSize"
    )
    val density: Fielder = parse_element (element (cls, fields(0)))
    val particleSize: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): VolcanicAshCloud =
    {
        implicit val ctx: Context = context
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

/**
 * A whirlpool, a rapidly rotating mass of water in a river or sea into which objects may be drawn, typically caused by the meeting of conflicting currents.
 *
 * @param sup [[ch.ninecode.model.HydrosphericPhenomenon HydrosphericPhenomenon]] Reference to the superclass object.
 * @group Environmental
 * @groupname Environmental Package Environmental
 */
final case class Whirlpool
(
    override val sup: HydrosphericPhenomenon = null
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
    def HydrosphericPhenomenon: HydrosphericPhenomenon = sup.asInstanceOf[HydrosphericPhenomenon]
    override def copy (): Row = { clone ().asInstanceOf[Whirlpool] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
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
    Parseable[Whirlpool]
{

    def parse (context: Context): Whirlpool =
    {
        implicit val ctx: Context = context
        val ret = Whirlpool (
            HydrosphericPhenomenon.parse (context)
        )
        ret
    }
}

private[ninecode] object _Environmental
{
    def register: List[ClassInfo] =
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
package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.Serializer
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship
import ch.ninecode.cim.CIMSerializer

/**
 * Standard published by ASTM (ASTM International).
 *
 * @param Element Reference to the superclass object.
 * @param standardEdition Edition of ASTM standard.
 * @param standardNumber ASTM standard number.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class ASTMStandard
(
    Element: BasicElement = null,
    standardEdition: String = null,
    standardNumber: String = null
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
        implicit val clz: String = ASTMStandard.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ASTMStandard.fields (position), value)
        emitattr (0, standardEdition)
        emitattr (1, standardNumber)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ASTMStandard rdf:ID=\"%s\">\n%s\t</cim:ASTMStandard>".format (id, export_fields)
    }
}

object ASTMStandard
extends
    CIMParseable[ASTMStandard]
{
    override val fields: Array[String] = Array[String] (
        "standardEdition",
        "standardNumber"
    )
    val standardEdition: Fielder = parse_attribute (attribute (cls, fields(0)))
    val standardNumber: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): ASTMStandard =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ASTMStandard (
            BasicElement.parse (context),
            mask (standardEdition (), 0),
            mask (standardNumber (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ASTMStandard] = ASTMStandardSerializer
}

object ASTMStandardSerializer extends CIMSerializer[ASTMStandard]
{
    def write (kryo: Kryo, output: Output, obj: ASTMStandard): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.standardEdition),
            () => output.writeString (obj.standardNumber)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ASTMStandard]): ASTMStandard =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ASTMStandard (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Acceptance test for assets.
 *
 * @param Element Reference to the superclass object.
 * @param dateTime Date and time the asset was last tested using the 'type' of test and yielding the current status in 'success' attribute.
 * @param success True if asset has passed acceptance test and may be placed in or is in service.
 *        It is set to false if asset is removed from service and is required to be tested again before being placed back in service, possibly in a new location. Since asset may go through multiple tests during its lifecycle, the date of each acceptance test may be recorded in 'Asset.ActivityRecord.status.dateTime'.
 * @param type Type of test or group of tests that was conducted on 'dateTime'.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class AcceptanceTest
(
    Element: BasicElement = null,
    dateTime: String = null,
    success: Boolean = false,
    `type`: String = null
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
        implicit val clz: String = AcceptanceTest.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AcceptanceTest.fields (position), value)
        emitelem (0, dateTime)
        emitelem (1, success)
        emitelem (2, `type`)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AcceptanceTest rdf:ID=\"%s\">\n%s\t</cim:AcceptanceTest>".format (id, export_fields)
    }
}

object AcceptanceTest
extends
    CIMParseable[AcceptanceTest]
{
    override val fields: Array[String] = Array[String] (
        "dateTime",
        "success",
        "type"
    )
    val dateTime: Fielder = parse_element (element (cls, fields(0)))
    val success: Fielder = parse_element (element (cls, fields(1)))
    val `type`: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: CIMContext): AcceptanceTest =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AcceptanceTest (
            BasicElement.parse (context),
            mask (dateTime (), 0),
            toBoolean (mask (success (), 1)),
            mask (`type` (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AcceptanceTest] = AcceptanceTestSerializer
}

object AcceptanceTestSerializer extends CIMSerializer[AcceptanceTest]
{
    def write (kryo: Kryo, output: Output, obj: AcceptanceTest): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.dateTime),
            () => output.writeBoolean (obj.success),
            () => output.writeString (obj.`type`)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AcceptanceTest]): AcceptanceTest =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AcceptanceTest (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readBoolean else false,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An aggregated indicative scoring by an analytic, which is based on other analytic scores, that can be used to characterize the health of or the risk associated with one or more assets.
 *
 * @param AnalyticScore [[ch.ninecode.model.AnalyticScore AnalyticScore]] Reference to the superclass object.
 * @param AnalyticScore_attr [[ch.ninecode.model.AnalyticScore AnalyticScore]] Analytic score contributing to this aggregate score.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class AggregateScore
(
    AnalyticScore: AnalyticScore = null,
    AnalyticScore_attr: List[String] = null
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
    override def sup: AnalyticScore = AnalyticScore

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
        implicit val clz: String = AggregateScore.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (AggregateScore.fields (position), x))
        emitattrs (0, AnalyticScore_attr)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AggregateScore rdf:ID=\"%s\">\n%s\t</cim:AggregateScore>".format (id, export_fields)
    }
}

object AggregateScore
extends
    CIMParseable[AggregateScore]
{
    override val fields: Array[String] = Array[String] (
        "AnalyticScore"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AnalyticScore_attr", "AnalyticScore", "1..*", "0..1")
    )
    val AnalyticScore_attr: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): AggregateScore =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AggregateScore (
            AnalyticScore.parse (context),
            masks (AnalyticScore_attr (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AggregateScore] = AggregateScoreSerializer
}

object AggregateScoreSerializer extends CIMSerializer[AggregateScore]
{
    def write (kryo: Kryo, output: Output, obj: AggregateScore): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.AnalyticScore_attr, output)
        )
        AnalyticScoreSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AggregateScore]): AggregateScore =
    {
        val parent = AnalyticScoreSerializer.read (kryo, input, classOf[AnalyticScore])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AggregateScore (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An algorithm or calculation for making an assessment about an asset or asset grouping for lifecycle decision making.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param bestValue Value that indicates best possible numeric value.
 * @param kind Kind of analytic this analytic is.
 * @param scaleKind The scoring scale kind.
 * @param worstValue Value that indicates worst possible numeric value.
 * @param AnalyticScore [[ch.ninecode.model.AnalyticScore AnalyticScore]] Analytic score produced by this analytic.
 * @param Asset [[ch.ninecode.model.Asset Asset]] Asset on which this analytic can be performed.
 * @param AssetGroup [[ch.ninecode.model.AssetGroup AssetGroup]] Asset group on which this analytic can be performed.
 * @param AssetHealthEvent [[ch.ninecode.model.AssetHealthEvent AssetHealthEvent]] Asset health event which can be generated by this analytic.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class Analytic
(
    Document: Document = null,
    bestValue: Double = 0.0,
    kind: String = null,
    scaleKind: String = null,
    worstValue: Double = 0.0,
    AnalyticScore: List[String] = null,
    Asset: List[String] = null,
    AssetGroup: List[String] = null,
    AssetHealthEvent: List[String] = null
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
    override def sup: Document = Document

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
        implicit val clz: String = Analytic.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Analytic.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Analytic.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Analytic.fields (position), x))
        emitelem (0, bestValue)
        emitattr (1, kind)
        emitattr (2, scaleKind)
        emitelem (3, worstValue)
        emitattrs (4, AnalyticScore)
        emitattrs (5, Asset)
        emitattrs (6, AssetGroup)
        emitattrs (7, AssetHealthEvent)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Analytic rdf:ID=\"%s\">\n%s\t</cim:Analytic>".format (id, export_fields)
    }
}

object Analytic
extends
    CIMParseable[Analytic]
{
    override val fields: Array[String] = Array[String] (
        "bestValue",
        "kind",
        "scaleKind",
        "worstValue",
        "AnalyticScore",
        "Asset",
        "AssetGroup",
        "AssetHealthEvent"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AnalyticScore", "AnalyticScore", "0..*", "0..1"),
        CIMRelationship ("Asset", "Asset", "0..*", "0..*"),
        CIMRelationship ("AssetGroup", "AssetGroup", "0..*", "0..*"),
        CIMRelationship ("AssetHealthEvent", "AssetHealthEvent", "0..*", "1")
    )
    val bestValue: Fielder = parse_element (element (cls, fields(0)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(1)))
    val scaleKind: Fielder = parse_attribute (attribute (cls, fields(2)))
    val worstValue: Fielder = parse_element (element (cls, fields(3)))
    val AnalyticScore: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val Asset: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val AssetGroup: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val AssetHealthEvent: FielderMultiple = parse_attributes (attribute (cls, fields(7)))

    def parse (context: CIMContext): Analytic =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Analytic (
            Document.parse (context),
            toDouble (mask (bestValue (), 0)),
            mask (kind (), 1),
            mask (scaleKind (), 2),
            toDouble (mask (worstValue (), 3)),
            masks (AnalyticScore (), 4),
            masks (Asset (), 5),
            masks (AssetGroup (), 6),
            masks (AssetHealthEvent (), 7)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Analytic] = AnalyticSerializer
}

object AnalyticSerializer extends CIMSerializer[Analytic]
{
    def write (kryo: Kryo, output: Output, obj: Analytic): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.bestValue),
            () => output.writeString (obj.kind),
            () => output.writeString (obj.scaleKind),
            () => output.writeDouble (obj.worstValue),
            () => writeList (obj.AnalyticScore, output),
            () => writeList (obj.Asset, output),
            () => writeList (obj.AssetGroup, output),
            () => writeList (obj.AssetHealthEvent, output)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Analytic]): Analytic =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Analytic (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) readList (input) else null,
            if (isSet (7)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An indicative scoring by an analytic that can be used to characterize the health of or the risk associated with one or more assets.
 *
 * The analytic score reflects the results of an execution of an analytic against an asset or group of assets.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param calculationDateTime Timestamp of when the score was calculated.
 * @param effectiveDateTime Date-time for when the score applies.
 * @param value Asset health score value.
 * @param Analytic [[ch.ninecode.model.Analytic Analytic]] Analytic which was executed to arrive at this analytic score..
 * @param Asset [[ch.ninecode.model.Asset Asset]] Asset to which this analytic score applies.
 * @param AssetAggregateScore [[ch.ninecode.model.AggregateScore AggregateScore]] Aggregate score to which this analytic score contributed.
 * @param AssetGroup [[ch.ninecode.model.AssetGroup AssetGroup]] Asset group to which this analytic score applies..
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class AnalyticScore
(
    IdentifiedObject: IdentifiedObject = null,
    calculationDateTime: String = null,
    effectiveDateTime: String = null,
    value: Double = 0.0,
    Analytic: String = null,
    Asset: String = null,
    AssetAggregateScore: String = null,
    AssetGroup: String = null
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
        implicit val clz: String = AnalyticScore.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AnalyticScore.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AnalyticScore.fields (position), value)
        emitelem (0, calculationDateTime)
        emitelem (1, effectiveDateTime)
        emitelem (2, value)
        emitattr (3, Analytic)
        emitattr (4, Asset)
        emitattr (5, AssetAggregateScore)
        emitattr (6, AssetGroup)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AnalyticScore rdf:ID=\"%s\">\n%s\t</cim:AnalyticScore>".format (id, export_fields)
    }
}

object AnalyticScore
extends
    CIMParseable[AnalyticScore]
{
    override val fields: Array[String] = Array[String] (
        "calculationDateTime",
        "effectiveDateTime",
        "value",
        "Analytic",
        "Asset",
        "AssetAggregateScore",
        "AssetGroup"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Analytic", "Analytic", "0..1", "0..*"),
        CIMRelationship ("Asset", "Asset", "0..1", "0..*"),
        CIMRelationship ("AssetAggregateScore", "AggregateScore", "0..1", "1..*"),
        CIMRelationship ("AssetGroup", "AssetGroup", "0..1", "0..*")
    )
    val calculationDateTime: Fielder = parse_element (element (cls, fields(0)))
    val effectiveDateTime: Fielder = parse_element (element (cls, fields(1)))
    val value: Fielder = parse_element (element (cls, fields(2)))
    val Analytic: Fielder = parse_attribute (attribute (cls, fields(3)))
    val Asset: Fielder = parse_attribute (attribute (cls, fields(4)))
    val AssetAggregateScore: Fielder = parse_attribute (attribute (cls, fields(5)))
    val AssetGroup: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: CIMContext): AnalyticScore =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AnalyticScore (
            IdentifiedObject.parse (context),
            mask (calculationDateTime (), 0),
            mask (effectiveDateTime (), 1),
            toDouble (mask (value (), 2)),
            mask (Analytic (), 3),
            mask (Asset (), 4),
            mask (AssetAggregateScore (), 5),
            mask (AssetGroup (), 6)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AnalyticScore] = AnalyticScoreSerializer
}

object AnalyticScoreSerializer extends CIMSerializer[AnalyticScore]
{
    def write (kryo: Kryo, output: Output, obj: AnalyticScore): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.calculationDateTime),
            () => output.writeString (obj.effectiveDateTime),
            () => output.writeDouble (obj.value),
            () => output.writeString (obj.Analytic),
            () => output.writeString (obj.Asset),
            () => output.writeString (obj.AssetAggregateScore),
            () => output.writeString (obj.AssetGroup)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AnalyticScore]): AnalyticScore =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AnalyticScore (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Tangible resource of the utility, including power system equipment, various end devices, cabinets, buildings, etc.
 *
 * For electrical network equipment, the role of the asset is defined through PowerSystemResource and its subclasses, defined mainly in the Wires model (refer to IEC61970-301 and model package IEC61970::Wires). Asset description places emphasis on the physical characteristics of the equipment fulfilling that role.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param acceptanceTest [[ch.ninecode.model.AcceptanceTest AcceptanceTest]] Information on acceptance test.
 * @param baselineCondition Condition of asset at last baseline.
 *        Examples include new, rebuilt, overhaul required, other. Refer to inspection data for information on the most current condition of the asset.
 * @param baselineLossOfLife Percentage of initial life expectancy that has been lost as of the last life expectancy baseline.
 *        Represents
 *        (initial life expectancy - current life expectancy) / initial life expectancy.
 * @param critical True if asset is considered critical for some reason (for example, a pole with critical attachments).
 * @param electronicAddress Electronic address.
 * @param inUseDate [[ch.ninecode.model.InUseDate InUseDate]] In use dates for this asset.
 * @param inUseState Indication of whether asset is currently deployed (in use), ready to be put into use or not available for use.
 * @param kind Kind of asset.
 *        Used in description of asset components in asset instance templates.
 * @param lifecycleDate [[ch.ninecode.model.LifecycleDate LifecycleDate]] <was lifecycle>
 *        Lifecycle dates for this asset.
 * @param lifecycleState Current lifecycle state of asset.
 * @param lotNumber Lot number for this asset.
 *        Even for the same model and version number, many assets are manufactured in lots.
 * @param position Position of asset or asset component.
 *        May often be in relation to other assets or components.
 * @param purchasePrice Purchase price of asset.
 * @param retiredReason Reason asset retired.
 * @param serialNumber Serial number of this asset.
 * @param status Status of this asset.
 * @param type Utility-specific classification of Asset and its subtypes, according to their corporate standards, practices, and existing IT systems (e.g., for management of assets, maintenance, work, outage, customers, etc.).
 * @param utcNumber Uniquely tracked commodity (UTC) number.
 * @param ActivityRecords [[ch.ninecode.model.ActivityRecord ActivityRecord]] All activity records created for this asset.
 * @param Analytic [[ch.ninecode.model.Analytic Analytic]] Analytic performed on this asset.
 * @param AnalyticScore [[ch.ninecode.model.AnalyticScore AnalyticScore]] Analytic result related to this asset.
 * @param AssetContainer [[ch.ninecode.model.AssetContainer AssetContainer]] Container of this asset.
 * @param AssetDeployment [[ch.ninecode.model.AssetDeployment AssetDeployment]] This asset's deployment.
 * @param AssetFunction [[ch.ninecode.model.AssetFunction AssetFunction]] <em>undocumented</em>
 * @param AssetGroup [[ch.ninecode.model.AssetGroup AssetGroup]] Asset group of which this asset is a part.
 * @param AssetInfo [[ch.ninecode.model.AssetInfo AssetInfo]] Data applicable to this asset.
 * @param AssetPropertyCurves [[ch.ninecode.model.AssetPropertyCurve AssetPropertyCurve]] <em>undocumented</em>
 * @param BreakerOperation [[ch.ninecode.model.SwitchOperationSummary SwitchOperationSummary]] Breaker operation information for this breaker.
 * @param ConfigurationEvents [[ch.ninecode.model.ConfigurationEvent ConfigurationEvent]] All configuration events created for this asset.
 * @param ErpInventory [[ch.ninecode.model.ErpInventory ErpInventory]] <em>undocumented</em>
 * @param ErpItemMaster [[ch.ninecode.model.ErpItemMaster ErpItemMaster]] <em>undocumented</em>
 * @param ErpRecDeliveryItems [[ch.ninecode.model.ErpRecDelvLineItem ErpRecDelvLineItem]] <em>undocumented</em>
 * @param FinancialInfo [[ch.ninecode.model.FinancialInfo FinancialInfo]] Financial information related to this asset.
 * @param Location [[ch.ninecode.model.Location Location]] Location of this asset.
 * @param Measurements [[ch.ninecode.model.Measurement Measurement]] Measurement related to this asset.
 * @param Medium [[ch.ninecode.model.Medium Medium]] Medium with which this asset is filled.
 * @param OperationalTags [[ch.ninecode.model.OperationalTag OperationalTag]] All operational tags placed on this asset.
 * @param OrganisationRoles [[ch.ninecode.model.AssetOrganisationRole AssetOrganisationRole]] All roles an organisation plays for this asset.
 * @param Ownerships [[ch.ninecode.model.Ownership Ownership]] All ownerships of this asset.
 * @param PowerSystemResources [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] All power system resources used to electrically model this asset.
 *        For example, transformer asset is electrically modelled with a transformer and its windings and tap changer.
 * @param ProcedureDataSet [[ch.ninecode.model.ProcedureDataSet ProcedureDataSet]] Procedure data set that applies to this asset.
 * @param Procedures [[ch.ninecode.model.Procedure Procedure]] All procedures applicable to this asset.
 * @param ProductAssetModel [[ch.ninecode.model.ProductAssetModel ProductAssetModel]] The model of this asset.
 * @param Reconditionings [[ch.ninecode.model.Reconditioning Reconditioning]] <em>undocumented</em>
 * @param ReliabilityInfos [[ch.ninecode.model.ReliabilityInfo ReliabilityInfo]] <em>undocumented</em>
 * @param ReplacementWorkTasks [[ch.ninecode.model.WorkTask WorkTask]] All work tasks on replacement of this old asset.
 * @param ScheduledEvents [[ch.ninecode.model.ScheduledEvent ScheduledEvent]] Scheduled event related to this asset.
 * @param WorkTasks [[ch.ninecode.model.WorkTask WorkTask]] All non-replacement work tasks performed on this asset.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class Asset
(
    IdentifiedObject: IdentifiedObject = null,
    acceptanceTest: String = null,
    baselineCondition: String = null,
    baselineLossOfLife: Double = 0.0,
    critical: Boolean = false,
    electronicAddress: String = null,
    inUseDate: String = null,
    inUseState: String = null,
    kind: String = null,
    lifecycleDate: String = null,
    lifecycleState: String = null,
    lotNumber: String = null,
    position: String = null,
    purchasePrice: Double = 0.0,
    retiredReason: String = null,
    serialNumber: String = null,
    status: String = null,
    `type`: String = null,
    utcNumber: String = null,
    ActivityRecords: List[String] = null,
    Analytic: List[String] = null,
    AnalyticScore: List[String] = null,
    AssetContainer: String = null,
    AssetDeployment: String = null,
    AssetFunction: List[String] = null,
    AssetGroup: List[String] = null,
    AssetInfo: String = null,
    AssetPropertyCurves: List[String] = null,
    BreakerOperation: String = null,
    ConfigurationEvents: List[String] = null,
    ErpInventory: String = null,
    ErpItemMaster: String = null,
    ErpRecDeliveryItems: List[String] = null,
    FinancialInfo: String = null,
    Location: String = null,
    Measurements: List[String] = null,
    Medium: List[String] = null,
    OperationalTags: List[String] = null,
    OrganisationRoles: List[String] = null,
    Ownerships: List[String] = null,
    PowerSystemResources: List[String] = null,
    ProcedureDataSet: List[String] = null,
    Procedures: List[String] = null,
    ProductAssetModel: String = null,
    Reconditionings: List[String] = null,
    ReliabilityInfos: List[String] = null,
    ReplacementWorkTasks: List[String] = null,
    ScheduledEvents: List[String] = null,
    WorkTasks: List[String] = null
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
        implicit val clz: String = Asset.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Asset.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Asset.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Asset.fields (position), x))
        emitattr (0, acceptanceTest)
        emitelem (1, baselineCondition)
        emitelem (2, baselineLossOfLife)
        emitelem (3, critical)
        emitattr (4, electronicAddress)
        emitattr (5, inUseDate)
        emitattr (6, inUseState)
        emitattr (7, kind)
        emitattr (8, lifecycleDate)
        emitattr (9, lifecycleState)
        emitelem (10, lotNumber)
        emitelem (11, position)
        emitelem (12, purchasePrice)
        emitattr (13, retiredReason)
        emitelem (14, serialNumber)
        emitattr (15, status)
        emitelem (16, `type`)
        emitelem (17, utcNumber)
        emitattrs (18, ActivityRecords)
        emitattrs (19, Analytic)
        emitattrs (20, AnalyticScore)
        emitattr (21, AssetContainer)
        emitattr (22, AssetDeployment)
        emitattrs (23, AssetFunction)
        emitattrs (24, AssetGroup)
        emitattr (25, AssetInfo)
        emitattrs (26, AssetPropertyCurves)
        emitattr (27, BreakerOperation)
        emitattrs (28, ConfigurationEvents)
        emitattr (29, ErpInventory)
        emitattr (30, ErpItemMaster)
        emitattrs (31, ErpRecDeliveryItems)
        emitattr (32, FinancialInfo)
        emitattr (33, Location)
        emitattrs (34, Measurements)
        emitattrs (35, Medium)
        emitattrs (36, OperationalTags)
        emitattrs (37, OrganisationRoles)
        emitattrs (38, Ownerships)
        emitattrs (39, PowerSystemResources)
        emitattrs (40, ProcedureDataSet)
        emitattrs (41, Procedures)
        emitattr (42, ProductAssetModel)
        emitattrs (43, Reconditionings)
        emitattrs (44, ReliabilityInfos)
        emitattrs (45, ReplacementWorkTasks)
        emitattrs (46, ScheduledEvents)
        emitattrs (47, WorkTasks)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Asset rdf:ID=\"%s\">\n%s\t</cim:Asset>".format (id, export_fields)
    }
}

object Asset
extends
    CIMParseable[Asset]
{
    override val fields: Array[String] = Array[String] (
        "acceptanceTest",
        "baselineCondition",
        "baselineLossOfLife",
        "critical",
        "electronicAddress",
        "inUseDate",
        "inUseState",
        "kind",
        "lifecycleDate",
        "lifecycleState",
        "lotNumber",
        "position",
        "purchasePrice",
        "retiredReason",
        "serialNumber",
        "status",
        "type",
        "utcNumber",
        "ActivityRecords",
        "Analytic",
        "AnalyticScore",
        "AssetContainer",
        "AssetDeployment",
        "AssetFunction",
        "AssetGroup",
        "AssetInfo",
        "AssetPropertyCurves",
        "BreakerOperation",
        "ConfigurationEvents",
        "ErpInventory",
        "ErpItemMaster",
        "ErpRecDeliveryItems",
        "FinancialInfo",
        "Location",
        "Measurements",
        "Medium",
        "OperationalTags",
        "OrganisationRoles",
        "Ownerships",
        "PowerSystemResources",
        "ProcedureDataSet",
        "Procedures",
        "ProductAssetModel",
        "Reconditionings",
        "ReliabilityInfos",
        "ReplacementWorkTasks",
        "ScheduledEvents",
        "WorkTasks"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("acceptanceTest", "AcceptanceTest", "0..1", "0..*"),
        CIMRelationship ("inUseDate", "InUseDate", "0..1", "0..*"),
        CIMRelationship ("lifecycleDate", "LifecycleDate", "0..1", "0..*"),
        CIMRelationship ("ActivityRecords", "ActivityRecord", "0..*", "0..*"),
        CIMRelationship ("Analytic", "Analytic", "0..*", "0..*"),
        CIMRelationship ("AnalyticScore", "AnalyticScore", "0..*", "0..1"),
        CIMRelationship ("AssetContainer", "AssetContainer", "0..1", "0..*"),
        CIMRelationship ("AssetDeployment", "AssetDeployment", "0..1", "0..1"),
        CIMRelationship ("AssetFunction", "AssetFunction", "0..*", "0..1"),
        CIMRelationship ("AssetGroup", "AssetGroup", "0..*", "0..*"),
        CIMRelationship ("AssetInfo", "AssetInfo", "0..1", "0..*"),
        CIMRelationship ("AssetPropertyCurves", "AssetPropertyCurve", "0..*", "0..*"),
        CIMRelationship ("BreakerOperation", "SwitchOperationSummary", "0..1", "1"),
        CIMRelationship ("ConfigurationEvents", "ConfigurationEvent", "0..*", "0..1"),
        CIMRelationship ("ErpInventory", "ErpInventory", "0..1", "0..1"),
        CIMRelationship ("ErpItemMaster", "ErpItemMaster", "0..1", "0..1"),
        CIMRelationship ("ErpRecDeliveryItems", "ErpRecDelvLineItem", "0..*", "0..*"),
        CIMRelationship ("FinancialInfo", "FinancialInfo", "0..1", "0..1"),
        CIMRelationship ("Location", "Location", "0..1", "0..*"),
        CIMRelationship ("Measurements", "Measurement", "0..*", "0..1"),
        CIMRelationship ("Medium", "Medium", "0..*", "0..*"),
        CIMRelationship ("OperationalTags", "OperationalTag", "0..*", "0..1"),
        CIMRelationship ("OrganisationRoles", "AssetOrganisationRole", "0..*", "0..*"),
        CIMRelationship ("Ownerships", "Ownership", "0..*", "0..1"),
        CIMRelationship ("PowerSystemResources", "PowerSystemResource", "0..*", "0..*"),
        CIMRelationship ("ProcedureDataSet", "ProcedureDataSet", "0..*", "0..1"),
        CIMRelationship ("Procedures", "Procedure", "0..*", "0..*"),
        CIMRelationship ("ProductAssetModel", "ProductAssetModel", "0..1", "0..*"),
        CIMRelationship ("Reconditionings", "Reconditioning", "0..*", "0..1"),
        CIMRelationship ("ReliabilityInfos", "ReliabilityInfo", "0..*", "0..*"),
        CIMRelationship ("ReplacementWorkTasks", "WorkTask", "0..*", "0..1"),
        CIMRelationship ("ScheduledEvents", "ScheduledEvent", "0..*", "0..*"),
        CIMRelationship ("WorkTasks", "WorkTask", "0..*", "0..*")
    )
    val acceptanceTest: Fielder = parse_attribute (attribute (cls, fields(0)))
    val baselineCondition: Fielder = parse_element (element (cls, fields(1)))
    val baselineLossOfLife: Fielder = parse_element (element (cls, fields(2)))
    val critical: Fielder = parse_element (element (cls, fields(3)))
    val electronicAddress: Fielder = parse_attribute (attribute (cls, fields(4)))
    val inUseDate: Fielder = parse_attribute (attribute (cls, fields(5)))
    val inUseState: Fielder = parse_attribute (attribute (cls, fields(6)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(7)))
    val lifecycleDate: Fielder = parse_attribute (attribute (cls, fields(8)))
    val lifecycleState: Fielder = parse_attribute (attribute (cls, fields(9)))
    val lotNumber: Fielder = parse_element (element (cls, fields(10)))
    val position: Fielder = parse_element (element (cls, fields(11)))
    val purchasePrice: Fielder = parse_element (element (cls, fields(12)))
    val retiredReason: Fielder = parse_attribute (attribute (cls, fields(13)))
    val serialNumber: Fielder = parse_element (element (cls, fields(14)))
    val status: Fielder = parse_attribute (attribute (cls, fields(15)))
    val `type`: Fielder = parse_element (element (cls, fields(16)))
    val utcNumber: Fielder = parse_element (element (cls, fields(17)))
    val ActivityRecords: FielderMultiple = parse_attributes (attribute (cls, fields(18)))
    val Analytic: FielderMultiple = parse_attributes (attribute (cls, fields(19)))
    val AnalyticScore: FielderMultiple = parse_attributes (attribute (cls, fields(20)))
    val AssetContainer: Fielder = parse_attribute (attribute (cls, fields(21)))
    val AssetDeployment: Fielder = parse_attribute (attribute (cls, fields(22)))
    val AssetFunction: FielderMultiple = parse_attributes (attribute (cls, fields(23)))
    val AssetGroup: FielderMultiple = parse_attributes (attribute (cls, fields(24)))
    val AssetInfo: Fielder = parse_attribute (attribute (cls, fields(25)))
    val AssetPropertyCurves: FielderMultiple = parse_attributes (attribute (cls, fields(26)))
    val BreakerOperation: Fielder = parse_attribute (attribute (cls, fields(27)))
    val ConfigurationEvents: FielderMultiple = parse_attributes (attribute (cls, fields(28)))
    val ErpInventory: Fielder = parse_attribute (attribute (cls, fields(29)))
    val ErpItemMaster: Fielder = parse_attribute (attribute (cls, fields(30)))
    val ErpRecDeliveryItems: FielderMultiple = parse_attributes (attribute (cls, fields(31)))
    val FinancialInfo: Fielder = parse_attribute (attribute (cls, fields(32)))
    val Location: Fielder = parse_attribute (attribute (cls, fields(33)))
    val Measurements: FielderMultiple = parse_attributes (attribute (cls, fields(34)))
    val Medium: FielderMultiple = parse_attributes (attribute (cls, fields(35)))
    val OperationalTags: FielderMultiple = parse_attributes (attribute (cls, fields(36)))
    val OrganisationRoles: FielderMultiple = parse_attributes (attribute (cls, fields(37)))
    val Ownerships: FielderMultiple = parse_attributes (attribute (cls, fields(38)))
    val PowerSystemResources: FielderMultiple = parse_attributes (attribute (cls, fields(39)))
    val ProcedureDataSet: FielderMultiple = parse_attributes (attribute (cls, fields(40)))
    val Procedures: FielderMultiple = parse_attributes (attribute (cls, fields(41)))
    val ProductAssetModel: Fielder = parse_attribute (attribute (cls, fields(42)))
    val Reconditionings: FielderMultiple = parse_attributes (attribute (cls, fields(43)))
    val ReliabilityInfos: FielderMultiple = parse_attributes (attribute (cls, fields(44)))
    val ReplacementWorkTasks: FielderMultiple = parse_attributes (attribute (cls, fields(45)))
    val ScheduledEvents: FielderMultiple = parse_attributes (attribute (cls, fields(46)))
    val WorkTasks: FielderMultiple = parse_attributes (attribute (cls, fields(47)))

    def parse (context: CIMContext): Asset =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0,0)
        val ret = Asset (
            IdentifiedObject.parse (context),
            mask (acceptanceTest (), 0),
            mask (baselineCondition (), 1),
            toDouble (mask (baselineLossOfLife (), 2)),
            toBoolean (mask (critical (), 3)),
            mask (electronicAddress (), 4),
            mask (inUseDate (), 5),
            mask (inUseState (), 6),
            mask (kind (), 7),
            mask (lifecycleDate (), 8),
            mask (lifecycleState (), 9),
            mask (lotNumber (), 10),
            mask (position (), 11),
            toDouble (mask (purchasePrice (), 12)),
            mask (retiredReason (), 13),
            mask (serialNumber (), 14),
            mask (status (), 15),
            mask (`type` (), 16),
            mask (utcNumber (), 17),
            masks (ActivityRecords (), 18),
            masks (Analytic (), 19),
            masks (AnalyticScore (), 20),
            mask (AssetContainer (), 21),
            mask (AssetDeployment (), 22),
            masks (AssetFunction (), 23),
            masks (AssetGroup (), 24),
            mask (AssetInfo (), 25),
            masks (AssetPropertyCurves (), 26),
            mask (BreakerOperation (), 27),
            masks (ConfigurationEvents (), 28),
            mask (ErpInventory (), 29),
            mask (ErpItemMaster (), 30),
            masks (ErpRecDeliveryItems (), 31),
            mask (FinancialInfo (), 32),
            mask (Location (), 33),
            masks (Measurements (), 34),
            masks (Medium (), 35),
            masks (OperationalTags (), 36),
            masks (OrganisationRoles (), 37),
            masks (Ownerships (), 38),
            masks (PowerSystemResources (), 39),
            masks (ProcedureDataSet (), 40),
            masks (Procedures (), 41),
            mask (ProductAssetModel (), 42),
            masks (Reconditionings (), 43),
            masks (ReliabilityInfos (), 44),
            masks (ReplacementWorkTasks (), 45),
            masks (ScheduledEvents (), 46),
            masks (WorkTasks (), 47)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Asset] = AssetSerializer
}

object AssetSerializer extends CIMSerializer[Asset]
{
    def write (kryo: Kryo, output: Output, obj: Asset): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.acceptanceTest),
            () => output.writeString (obj.baselineCondition),
            () => output.writeDouble (obj.baselineLossOfLife),
            () => output.writeBoolean (obj.critical),
            () => output.writeString (obj.electronicAddress),
            () => output.writeString (obj.inUseDate),
            () => output.writeString (obj.inUseState),
            () => output.writeString (obj.kind),
            () => output.writeString (obj.lifecycleDate),
            () => output.writeString (obj.lifecycleState),
            () => output.writeString (obj.lotNumber),
            () => output.writeString (obj.position),
            () => output.writeDouble (obj.purchasePrice),
            () => output.writeString (obj.retiredReason),
            () => output.writeString (obj.serialNumber),
            () => output.writeString (obj.status),
            () => output.writeString (obj.`type`),
            () => output.writeString (obj.utcNumber),
            () => writeList (obj.ActivityRecords, output),
            () => writeList (obj.Analytic, output),
            () => writeList (obj.AnalyticScore, output),
            () => output.writeString (obj.AssetContainer),
            () => output.writeString (obj.AssetDeployment),
            () => writeList (obj.AssetFunction, output),
            () => writeList (obj.AssetGroup, output),
            () => output.writeString (obj.AssetInfo),
            () => writeList (obj.AssetPropertyCurves, output),
            () => output.writeString (obj.BreakerOperation),
            () => writeList (obj.ConfigurationEvents, output),
            () => output.writeString (obj.ErpInventory),
            () => output.writeString (obj.ErpItemMaster),
            () => writeList (obj.ErpRecDeliveryItems, output),
            () => output.writeString (obj.FinancialInfo),
            () => output.writeString (obj.Location),
            () => writeList (obj.Measurements, output),
            () => writeList (obj.Medium, output),
            () => writeList (obj.OperationalTags, output),
            () => writeList (obj.OrganisationRoles, output),
            () => writeList (obj.Ownerships, output),
            () => writeList (obj.PowerSystemResources, output),
            () => writeList (obj.ProcedureDataSet, output),
            () => writeList (obj.Procedures, output),
            () => output.writeString (obj.ProductAssetModel),
            () => writeList (obj.Reconditionings, output),
            () => writeList (obj.ReliabilityInfos, output),
            () => writeList (obj.ReplacementWorkTasks, output),
            () => writeList (obj.ScheduledEvents, output),
            () => writeList (obj.WorkTasks, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Asset]): Asset =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Asset (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readBoolean else false,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) input.readString else null,
            if (isSet (11)) input.readString else null,
            if (isSet (12)) input.readDouble else 0.0,
            if (isSet (13)) input.readString else null,
            if (isSet (14)) input.readString else null,
            if (isSet (15)) input.readString else null,
            if (isSet (16)) input.readString else null,
            if (isSet (17)) input.readString else null,
            if (isSet (18)) readList (input) else null,
            if (isSet (19)) readList (input) else null,
            if (isSet (20)) readList (input) else null,
            if (isSet (21)) input.readString else null,
            if (isSet (22)) input.readString else null,
            if (isSet (23)) readList (input) else null,
            if (isSet (24)) readList (input) else null,
            if (isSet (25)) input.readString else null,
            if (isSet (26)) readList (input) else null,
            if (isSet (27)) input.readString else null,
            if (isSet (28)) readList (input) else null,
            if (isSet (29)) input.readString else null,
            if (isSet (30)) input.readString else null,
            if (isSet (31)) readList (input) else null,
            if (isSet (32)) input.readString else null,
            if (isSet (33)) input.readString else null,
            if (isSet (34)) readList (input) else null,
            if (isSet (35)) readList (input) else null,
            if (isSet (36)) readList (input) else null,
            if (isSet (37)) readList (input) else null,
            if (isSet (38)) readList (input) else null,
            if (isSet (39)) readList (input) else null,
            if (isSet (40)) readList (input) else null,
            if (isSet (41)) readList (input) else null,
            if (isSet (42)) input.readString else null,
            if (isSet (43)) readList (input) else null,
            if (isSet (44)) readList (input) else null,
            if (isSet (45)) readList (input) else null,
            if (isSet (46)) readList (input) else null,
            if (isSet (47)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Asset that is aggregation of other assets such as conductors, transformers, switchgear, land, fences, buildings, equipment, vehicles, etc.
 *
 * @param Asset [[ch.ninecode.model.Asset Asset]] Reference to the superclass object.
 * @param Assets [[ch.ninecode.model.Asset Asset]] All assets within this container asset.
 * @param LandProperties [[ch.ninecode.model.LandProperty LandProperty]] <em>undocumented</em>
 * @param Seals [[ch.ninecode.model.Seal Seal]] All seals applied to this asset container.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class AssetContainer
(
    Asset: Asset = null,
    Assets: List[String] = null,
    LandProperties: List[String] = null,
    Seals: List[String] = null
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
    override def sup: Asset = Asset

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
        implicit val clz: String = AssetContainer.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (AssetContainer.fields (position), x))
        emitattrs (0, Assets)
        emitattrs (1, LandProperties)
        emitattrs (2, Seals)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AssetContainer rdf:ID=\"%s\">\n%s\t</cim:AssetContainer>".format (id, export_fields)
    }
}

object AssetContainer
extends
    CIMParseable[AssetContainer]
{
    override val fields: Array[String] = Array[String] (
        "Assets",
        "LandProperties",
        "Seals"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Assets", "Asset", "0..*", "0..1"),
        CIMRelationship ("LandProperties", "LandProperty", "0..*", "0..*"),
        CIMRelationship ("Seals", "Seal", "0..*", "0..1")
    )
    val Assets: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val LandProperties: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val Seals: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: CIMContext): AssetContainer =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AssetContainer (
            Asset.parse (context),
            masks (Assets (), 0),
            masks (LandProperties (), 1),
            masks (Seals (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AssetContainer] = AssetContainerSerializer
}

object AssetContainerSerializer extends CIMSerializer[AssetContainer]
{
    def write (kryo: Kryo, output: Output, obj: AssetContainer): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.Assets, output),
            () => writeList (obj.LandProperties, output),
            () => writeList (obj.Seals, output)
        )
        AssetSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AssetContainer]): AssetContainer =
    {
        val parent = AssetSerializer.read (kryo, input, classOf[Asset])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AssetContainer (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Deployment of asset deployment in a power system resource role.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param breakerApplication Type of network role breaker is playing in this deployment (applies to breaker assets only).
 * @param deploymentDate [[ch.ninecode.model.DeploymentDate DeploymentDate]] Dates of asset deployment.
 * @param deploymentState Current deployment state of asset.
 * @param facilityKind Kind of facility (like substation or pole or building or plant or service center) at which asset deployed.
 * @param likelihoodOfFailure Likelihood of asset failure on a scale of 1(low) to 100 (high).
 * @param transformerApplication Type of network role transformer is playing in this deployment (applies to transformer assets only).
 * @param Asset [[ch.ninecode.model.Asset Asset]] Asset in this deployment.
 * @param BaseVoltage [[ch.ninecode.model.BaseVoltage BaseVoltage]] Base voltage of this network asset deployment.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class AssetDeployment
(
    IdentifiedObject: IdentifiedObject = null,
    breakerApplication: String = null,
    deploymentDate: String = null,
    deploymentState: String = null,
    facilityKind: String = null,
    likelihoodOfFailure: Int = 0,
    transformerApplication: String = null,
    Asset: String = null,
    BaseVoltage: String = null
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
        implicit val clz: String = AssetDeployment.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AssetDeployment.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AssetDeployment.fields (position), value)
        emitattr (0, breakerApplication)
        emitattr (1, deploymentDate)
        emitattr (2, deploymentState)
        emitattr (3, facilityKind)
        emitelem (4, likelihoodOfFailure)
        emitattr (5, transformerApplication)
        emitattr (6, Asset)
        emitattr (7, BaseVoltage)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AssetDeployment rdf:ID=\"%s\">\n%s\t</cim:AssetDeployment>".format (id, export_fields)
    }
}

object AssetDeployment
extends
    CIMParseable[AssetDeployment]
{
    override val fields: Array[String] = Array[String] (
        "breakerApplication",
        "deploymentDate",
        "deploymentState",
        "facilityKind",
        "likelihoodOfFailure",
        "transformerApplication",
        "Asset",
        "BaseVoltage"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("deploymentDate", "DeploymentDate", "0..1", "0..*"),
        CIMRelationship ("Asset", "Asset", "0..1", "0..1"),
        CIMRelationship ("BaseVoltage", "BaseVoltage", "1", "0..*")
    )
    val breakerApplication: Fielder = parse_attribute (attribute (cls, fields(0)))
    val deploymentDate: Fielder = parse_attribute (attribute (cls, fields(1)))
    val deploymentState: Fielder = parse_attribute (attribute (cls, fields(2)))
    val facilityKind: Fielder = parse_attribute (attribute (cls, fields(3)))
    val likelihoodOfFailure: Fielder = parse_element (element (cls, fields(4)))
    val transformerApplication: Fielder = parse_attribute (attribute (cls, fields(5)))
    val Asset: Fielder = parse_attribute (attribute (cls, fields(6)))
    val BaseVoltage: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: CIMContext): AssetDeployment =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AssetDeployment (
            IdentifiedObject.parse (context),
            mask (breakerApplication (), 0),
            mask (deploymentDate (), 1),
            mask (deploymentState (), 2),
            mask (facilityKind (), 3),
            toInteger (mask (likelihoodOfFailure (), 4)),
            mask (transformerApplication (), 5),
            mask (Asset (), 6),
            mask (BaseVoltage (), 7)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AssetDeployment] = AssetDeploymentSerializer
}

object AssetDeploymentSerializer extends CIMSerializer[AssetDeployment]
{
    def write (kryo: Kryo, output: Output, obj: AssetDeployment): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.breakerApplication),
            () => output.writeString (obj.deploymentDate),
            () => output.writeString (obj.deploymentState),
            () => output.writeString (obj.facilityKind),
            () => output.writeInt (obj.likelihoodOfFailure),
            () => output.writeString (obj.transformerApplication),
            () => output.writeString (obj.Asset),
            () => output.writeString (obj.BaseVoltage)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AssetDeployment]): AssetDeployment =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AssetDeployment (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readInt else 0,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Function performed by an asset.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param configID Configuration specified for this function.
 * @param firmwareID Firmware version.
 * @param hardwareID Hardware version.
 * @param password Password needed to access this function.
 * @param programID Name of program.
 * @param Asset [[ch.ninecode.model.Asset Asset]] <em>undocumented</em>
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class AssetFunction
(
    IdentifiedObject: IdentifiedObject = null,
    configID: String = null,
    firmwareID: String = null,
    hardwareID: String = null,
    password: String = null,
    programID: String = null,
    Asset: String = null
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
        implicit val clz: String = AssetFunction.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AssetFunction.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AssetFunction.fields (position), value)
        emitelem (0, configID)
        emitelem (1, firmwareID)
        emitelem (2, hardwareID)
        emitelem (3, password)
        emitelem (4, programID)
        emitattr (5, Asset)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AssetFunction rdf:ID=\"%s\">\n%s\t</cim:AssetFunction>".format (id, export_fields)
    }
}

object AssetFunction
extends
    CIMParseable[AssetFunction]
{
    override val fields: Array[String] = Array[String] (
        "configID",
        "firmwareID",
        "hardwareID",
        "password",
        "programID",
        "Asset"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Asset", "Asset", "0..1", "0..*")
    )
    val configID: Fielder = parse_element (element (cls, fields(0)))
    val firmwareID: Fielder = parse_element (element (cls, fields(1)))
    val hardwareID: Fielder = parse_element (element (cls, fields(2)))
    val password: Fielder = parse_element (element (cls, fields(3)))
    val programID: Fielder = parse_element (element (cls, fields(4)))
    val Asset: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: CIMContext): AssetFunction =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AssetFunction (
            IdentifiedObject.parse (context),
            mask (configID (), 0),
            mask (firmwareID (), 1),
            mask (hardwareID (), 2),
            mask (password (), 3),
            mask (programID (), 4),
            mask (Asset (), 5)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AssetFunction] = AssetFunctionSerializer
}

object AssetFunctionSerializer extends CIMSerializer[AssetFunction]
{
    def write (kryo: Kryo, output: Output, obj: AssetFunction): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.configID),
            () => output.writeString (obj.firmwareID),
            () => output.writeString (obj.hardwareID),
            () => output.writeString (obj.password),
            () => output.writeString (obj.programID),
            () => output.writeString (obj.Asset)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AssetFunction]): AssetFunction =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AssetFunction (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A grouping of assets created for a purpose such as fleet analytics, inventory or compliance management.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param kind Kind of asset group this asset group is.
 * @param Analytic [[ch.ninecode.model.Analytic Analytic]] Analytic which can be performed on this asset group.
 * @param AnalyticScore [[ch.ninecode.model.AnalyticScore AnalyticScore]] Analytic score for this asset group.
 * @param Asset [[ch.ninecode.model.Asset Asset]] Asset which is a part of this asset group.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class AssetGroup
(
    Document: Document = null,
    kind: String = null,
    Analytic: List[String] = null,
    AnalyticScore: List[String] = null,
    Asset: List[String] = null
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
    override def sup: Document = Document

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
        implicit val clz: String = AssetGroup.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AssetGroup.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (AssetGroup.fields (position), x))
        emitattr (0, kind)
        emitattrs (1, Analytic)
        emitattrs (2, AnalyticScore)
        emitattrs (3, Asset)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AssetGroup rdf:ID=\"%s\">\n%s\t</cim:AssetGroup>".format (id, export_fields)
    }
}

object AssetGroup
extends
    CIMParseable[AssetGroup]
{
    override val fields: Array[String] = Array[String] (
        "kind",
        "Analytic",
        "AnalyticScore",
        "Asset"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Analytic", "Analytic", "0..*", "0..*"),
        CIMRelationship ("AnalyticScore", "AnalyticScore", "0..*", "0..1"),
        CIMRelationship ("Asset", "Asset", "0..*", "0..*")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Analytic: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val AnalyticScore: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Asset: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: CIMContext): AssetGroup =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AssetGroup (
            Document.parse (context),
            mask (kind (), 0),
            masks (Analytic (), 1),
            masks (AnalyticScore (), 2),
            masks (Asset (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AssetGroup] = AssetGroupSerializer
}

object AssetGroupSerializer extends CIMSerializer[AssetGroup]
{
    def write (kryo: Kryo, output: Output, obj: AssetGroup): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.kind),
            () => writeList (obj.Analytic, output),
            () => writeList (obj.AnalyticScore, output),
            () => writeList (obj.Asset, output)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AssetGroup]): AssetGroup =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AssetGroup (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An asset health-related event that is created by an analytic.
 *
 * The event is a record of a change in asset health.
 *
 * @param ActivityRecord [[ch.ninecode.model.ActivityRecord ActivityRecord]] Reference to the superclass object.
 * @param actionRecommendation Recommendation for action.
 * @param actionTimeline Time horizon for action.
 * @param effectiveDateTime The date and time when the event is effective.
 * @param Analytic [[ch.ninecode.model.Analytic Analytic]] Analytic that initiated this asset health event.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class AssetHealthEvent
(
    ActivityRecord: ActivityRecord = null,
    actionRecommendation: String = null,
    actionTimeline: String = null,
    effectiveDateTime: String = null,
    Analytic: String = null
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
        implicit val clz: String = AssetHealthEvent.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AssetHealthEvent.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AssetHealthEvent.fields (position), value)
        emitelem (0, actionRecommendation)
        emitelem (1, actionTimeline)
        emitelem (2, effectiveDateTime)
        emitattr (3, Analytic)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AssetHealthEvent rdf:ID=\"%s\">\n%s\t</cim:AssetHealthEvent>".format (id, export_fields)
    }
}

object AssetHealthEvent
extends
    CIMParseable[AssetHealthEvent]
{
    override val fields: Array[String] = Array[String] (
        "actionRecommendation",
        "actionTimeline",
        "effectiveDateTime",
        "Analytic"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Analytic", "Analytic", "1", "0..*")
    )
    val actionRecommendation: Fielder = parse_element (element (cls, fields(0)))
    val actionTimeline: Fielder = parse_element (element (cls, fields(1)))
    val effectiveDateTime: Fielder = parse_element (element (cls, fields(2)))
    val Analytic: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): AssetHealthEvent =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AssetHealthEvent (
            ActivityRecord.parse (context),
            mask (actionRecommendation (), 0),
            mask (actionTimeline (), 1),
            mask (effectiveDateTime (), 2),
            mask (Analytic (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AssetHealthEvent] = AssetHealthEventSerializer
}

object AssetHealthEventSerializer extends CIMSerializer[AssetHealthEvent]
{
    def write (kryo: Kryo, output: Output, obj: AssetHealthEvent): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.actionRecommendation),
            () => output.writeString (obj.actionTimeline),
            () => output.writeString (obj.effectiveDateTime),
            () => output.writeString (obj.Analytic)
        )
        ActivityRecordSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AssetHealthEvent]): AssetHealthEvent =
    {
        val parent = ActivityRecordSerializer.read (kryo, input, classOf[ActivityRecord])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AssetHealthEvent (
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
 * Set of attributes of an asset, representing typical datasheet information of a physical device that can be instantiated and shared in different data exchange contexts:
 * - as attributes of an asset instance (installed or in stock)
 * - as attributes of an asset model (product by a manufacturer)
 *
 * - as attributes of a type asset (generic type of an asset as used in designs/extension planning).
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Assets [[ch.ninecode.model.Asset Asset]] All assets described by this data.
 * @param CatalogAssetType [[ch.ninecode.model.CatalogAssetType CatalogAssetType]] Asset information (nameplate) for this catalog asset type.
 * @param PowerSystemResources [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] All power system resources with this datasheet information.
 * @param ProductAssetModel [[ch.ninecode.model.ProductAssetModel ProductAssetModel]] Product asset model which conforms to this catalog asset type.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class AssetInfo
(
    IdentifiedObject: IdentifiedObject = null,
    Assets: List[String] = null,
    CatalogAssetType: String = null,
    PowerSystemResources: List[String] = null,
    ProductAssetModel: String = null
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
        implicit val clz: String = AssetInfo.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AssetInfo.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (AssetInfo.fields (position), x))
        emitattrs (0, Assets)
        emitattr (1, CatalogAssetType)
        emitattrs (2, PowerSystemResources)
        emitattr (3, ProductAssetModel)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AssetInfo rdf:ID=\"%s\">\n%s\t</cim:AssetInfo>".format (id, export_fields)
    }
}

object AssetInfo
extends
    CIMParseable[AssetInfo]
{
    override val fields: Array[String] = Array[String] (
        "Assets",
        "CatalogAssetType",
        "PowerSystemResources",
        "ProductAssetModel"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Assets", "Asset", "0..*", "0..1"),
        CIMRelationship ("CatalogAssetType", "CatalogAssetType", "0..1", "0..1"),
        CIMRelationship ("PowerSystemResources", "PowerSystemResource", "0..*", "0..1"),
        CIMRelationship ("ProductAssetModel", "ProductAssetModel", "0..1", "0..1")
    )
    val Assets: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val CatalogAssetType: Fielder = parse_attribute (attribute (cls, fields(1)))
    val PowerSystemResources: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val ProductAssetModel: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): AssetInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AssetInfo (
            IdentifiedObject.parse (context),
            masks (Assets (), 0),
            mask (CatalogAssetType (), 1),
            masks (PowerSystemResources (), 2),
            mask (ProductAssetModel (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AssetInfo] = AssetInfoSerializer
}

object AssetInfoSerializer extends CIMSerializer[AssetInfo]
{
    def write (kryo: Kryo, output: Output, obj: AssetInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.Assets, output),
            () => output.writeString (obj.CatalogAssetType),
            () => writeList (obj.PowerSystemResources, output),
            () => output.writeString (obj.ProductAssetModel)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AssetInfo]): AssetInfo =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AssetInfo (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Potential hazard related to the location of an asset.
 *
 * Examples are trees growing under overhead power lines, a park being located by a substation (i.e., children climb fence to recover a ball), a lake near an overhead distribution line (fishing pole/line contacting power lines), dangerous neighbour, etc.
 *
 * @param Hazard [[ch.ninecode.model.Hazard Hazard]] Reference to the superclass object.
 * @param kind Kind of hazard.
 * @param Locations [[ch.ninecode.model.Location Location]] The location of this hazard.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class AssetLocationHazard
(
    Hazard: Hazard = null,
    kind: String = null,
    Locations: List[String] = null
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
    override def sup: Hazard = Hazard

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
        implicit val clz: String = AssetLocationHazard.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AssetLocationHazard.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (AssetLocationHazard.fields (position), x))
        emitattr (0, kind)
        emitattrs (1, Locations)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AssetLocationHazard rdf:ID=\"%s\">\n%s\t</cim:AssetLocationHazard>".format (id, export_fields)
    }
}

object AssetLocationHazard
extends
    CIMParseable[AssetLocationHazard]
{
    override val fields: Array[String] = Array[String] (
        "kind",
        "Locations"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Locations", "Location", "0..*", "0..*")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Locations: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): AssetLocationHazard =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AssetLocationHazard (
            Hazard.parse (context),
            mask (kind (), 0),
            masks (Locations (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AssetLocationHazard] = AssetLocationHazardSerializer
}

object AssetLocationHazardSerializer extends CIMSerializer[AssetLocationHazard]
{
    def write (kryo: Kryo, output: Output, obj: AssetLocationHazard): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.kind),
            () => writeList (obj.Locations, output)
        )
        HazardSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AssetLocationHazard]): AssetLocationHazard =
    {
        val parent = HazardSerializer.read (kryo, input, classOf[Hazard])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AssetLocationHazard (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Role an organisation plays with respect to asset.
 *
 * @param OrganisationRole [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @param Assets [[ch.ninecode.model.Asset Asset]] All assets for this organisation role.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class AssetOrganisationRole
(
    OrganisationRole: OrganisationRole = null,
    Assets: List[String] = null
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
        implicit val clz: String = AssetOrganisationRole.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (AssetOrganisationRole.fields (position), x))
        emitattrs (0, Assets)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AssetOrganisationRole rdf:ID=\"%s\">\n%s\t</cim:AssetOrganisationRole>".format (id, export_fields)
    }
}

object AssetOrganisationRole
extends
    CIMParseable[AssetOrganisationRole]
{
    override val fields: Array[String] = Array[String] (
        "Assets"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Assets", "Asset", "0..*", "0..*")
    )
    val Assets: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): AssetOrganisationRole =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AssetOrganisationRole (
            OrganisationRole.parse (context),
            masks (Assets (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AssetOrganisationRole] = AssetOrganisationRoleSerializer
}

object AssetOrganisationRoleSerializer extends CIMSerializer[AssetOrganisationRole]
{
    def write (kryo: Kryo, output: Output, obj: AssetOrganisationRole): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.Assets, output)
        )
        OrganisationRoleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AssetOrganisationRole]): AssetOrganisationRole =
    {
        val parent = OrganisationRoleSerializer.read (kryo, input, classOf[OrganisationRole])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AssetOrganisationRole (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Owner of the asset.
 *
 * @param AssetOrganisationRole [[ch.ninecode.model.AssetOrganisationRole AssetOrganisationRole]] Reference to the superclass object.
 * @param Ownerships [[ch.ninecode.model.Ownership Ownership]] All ownerships of this owner.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class AssetOwner
(
    AssetOrganisationRole: AssetOrganisationRole = null,
    Ownerships: List[String] = null
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
    override def sup: AssetOrganisationRole = AssetOrganisationRole

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
        implicit val clz: String = AssetOwner.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (AssetOwner.fields (position), x))
        emitattrs (0, Ownerships)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AssetOwner rdf:ID=\"%s\">\n%s\t</cim:AssetOwner>".format (id, export_fields)
    }
}

object AssetOwner
extends
    CIMParseable[AssetOwner]
{
    override val fields: Array[String] = Array[String] (
        "Ownerships"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Ownerships", "Ownership", "0..*", "0..1")
    )
    val Ownerships: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): AssetOwner =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AssetOwner (
            AssetOrganisationRole.parse (context),
            masks (Ownerships (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AssetOwner] = AssetOwnerSerializer
}

object AssetOwnerSerializer extends CIMSerializer[AssetOwner]
{
    def write (kryo: Kryo, output: Output, obj: AssetOwner): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.Ownerships, output)
        )
        AssetOrganisationRoleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AssetOwner]): AssetOwner =
    {
        val parent = AssetOrganisationRoleSerializer.read (kryo, input, classOf[AssetOrganisationRole])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AssetOwner (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Test lab that performs various types of testing related to assets.
 *
 * @param AssetOrganisationRole [[ch.ninecode.model.AssetOrganisationRole AssetOrganisationRole]] Reference to the superclass object.
 * @param LabTestDataSet [[ch.ninecode.model.LabTestDataSet LabTestDataSet]] A set of lab test results produced by this test lab.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class AssetTestLab
(
    AssetOrganisationRole: AssetOrganisationRole = null,
    LabTestDataSet: List[String] = null
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
    override def sup: AssetOrganisationRole = AssetOrganisationRole

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
        implicit val clz: String = AssetTestLab.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (AssetTestLab.fields (position), x))
        emitattrs (0, LabTestDataSet)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AssetTestLab rdf:ID=\"%s\">\n%s\t</cim:AssetTestLab>".format (id, export_fields)
    }
}

object AssetTestLab
extends
    CIMParseable[AssetTestLab]
{
    override val fields: Array[String] = Array[String] (
        "LabTestDataSet"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("LabTestDataSet", "LabTestDataSet", "0..*", "0..1")
    )
    val LabTestDataSet: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): AssetTestLab =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AssetTestLab (
            AssetOrganisationRole.parse (context),
            masks (LabTestDataSet (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AssetTestLab] = AssetTestLabSerializer
}

object AssetTestLabSerializer extends CIMSerializer[AssetTestLab]
{
    def write (kryo: Kryo, output: Output, obj: AssetTestLab): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.LabTestDataSet, output)
        )
        AssetOrganisationRoleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AssetTestLab]): AssetTestLab =
    {
        val parent = AssetOrganisationRoleSerializer.read (kryo, input, classOf[AssetOrganisationRole])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AssetTestLab (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Identity of person/organization that took sample.
 *
 * @param AssetOrganisationRole [[ch.ninecode.model.AssetOrganisationRole AssetOrganisationRole]] Reference to the superclass object.
 * @param Specimen [[ch.ninecode.model.Specimen Specimen]] Specimen taken by this sample taker.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class AssetTestSampleTaker
(
    AssetOrganisationRole: AssetOrganisationRole = null,
    Specimen: List[String] = null
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
    override def sup: AssetOrganisationRole = AssetOrganisationRole

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
        implicit val clz: String = AssetTestSampleTaker.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (AssetTestSampleTaker.fields (position), x))
        emitattrs (0, Specimen)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AssetTestSampleTaker rdf:ID=\"%s\">\n%s\t</cim:AssetTestSampleTaker>".format (id, export_fields)
    }
}

object AssetTestSampleTaker
extends
    CIMParseable[AssetTestSampleTaker]
{
    override val fields: Array[String] = Array[String] (
        "Specimen"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Specimen", "Specimen", "0..*", "0..1")
    )
    val Specimen: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): AssetTestSampleTaker =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AssetTestSampleTaker (
            AssetOrganisationRole.parse (context),
            masks (Specimen (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AssetTestSampleTaker] = AssetTestSampleTakerSerializer
}

object AssetTestSampleTakerSerializer extends CIMSerializer[AssetTestSampleTaker]
{
    def write (kryo: Kryo, output: Output, obj: AssetTestSampleTaker): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.Specimen, output)
        )
        AssetOrganisationRoleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AssetTestSampleTaker]): AssetTestSampleTaker =
    {
        val parent = AssetOrganisationRoleSerializer.read (kryo, input, classOf[AssetOrganisationRole])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AssetTestSampleTaker (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Organisation that is a user of the asset.
 *
 * @param AssetOrganisationRole [[ch.ninecode.model.AssetOrganisationRole AssetOrganisationRole]] Reference to the superclass object.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class AssetUser
(
    AssetOrganisationRole: AssetOrganisationRole = null
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
    override def sup: AssetOrganisationRole = AssetOrganisationRole

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
        "\t<cim:AssetUser rdf:ID=\"%s\">\n%s\t</cim:AssetUser>".format (id, export_fields)
    }
}

object AssetUser
extends
    CIMParseable[AssetUser]
{

    def parse (context: CIMContext): AssetUser =
    {
        val ret = AssetUser (
            AssetOrganisationRole.parse (context)
        )
        ret
    }

    def serializer: Serializer[AssetUser] = AssetUserSerializer
}

object AssetUserSerializer extends CIMSerializer[AssetUser]
{
    def write (kryo: Kryo, output: Output, obj: AssetUser): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        AssetOrganisationRoleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AssetUser]): AssetUser =
    {
        val parent = AssetOrganisationRoleSerializer.read (kryo, input, classOf[AssetOrganisationRole])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AssetUser (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Bushing asset.
 *
 * @param Asset [[ch.ninecode.model.Asset Asset]] Reference to the superclass object.
 * @param BushingInsulationPFs [[ch.ninecode.model.BushingInsulationPF BushingInsulationPF]] <em>undocumented</em>
 * @param FixedContact [[ch.ninecode.model.InterrupterUnit InterrupterUnit]] Fixed contact of interrupter to which this bushing is attached.
 * @param MovingContact [[ch.ninecode.model.InterrupterUnit InterrupterUnit]] Moving contact of interrupter to which this bushing is attached.
 * @param Terminal [[ch.ninecode.model.Terminal Terminal]] Terminal to which this bushing is attached.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class Bushing
(
    Asset: Asset = null,
    BushingInsulationPFs: List[String] = null,
    FixedContact: String = null,
    MovingContact: String = null,
    Terminal: String = null
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
    override def sup: Asset = Asset

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
        implicit val clz: String = Bushing.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Bushing.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Bushing.fields (position), x))
        emitattrs (0, BushingInsulationPFs)
        emitattr (1, FixedContact)
        emitattr (2, MovingContact)
        emitattr (3, Terminal)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Bushing rdf:ID=\"%s\">\n%s\t</cim:Bushing>".format (id, export_fields)
    }
}

object Bushing
extends
    CIMParseable[Bushing]
{
    override val fields: Array[String] = Array[String] (
        "BushingInsulationPFs",
        "FixedContact",
        "MovingContact",
        "Terminal"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("BushingInsulationPFs", "BushingInsulationPF", "0..*", "0..1"),
        CIMRelationship ("FixedContact", "InterrupterUnit", "0..1", "0..*"),
        CIMRelationship ("MovingContact", "InterrupterUnit", "0..1", "0..*"),
        CIMRelationship ("Terminal", "Terminal", "0..1", "0..1")
    )
    val BushingInsulationPFs: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val FixedContact: Fielder = parse_attribute (attribute (cls, fields(1)))
    val MovingContact: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Terminal: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): Bushing =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Bushing (
            Asset.parse (context),
            masks (BushingInsulationPFs (), 0),
            mask (FixedContact (), 1),
            mask (MovingContact (), 2),
            mask (Terminal (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Bushing] = BushingSerializer
}

object BushingSerializer extends CIMSerializer[Bushing]
{
    def write (kryo: Kryo, output: Output, obj: Bushing): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.BushingInsulationPFs, output),
            () => output.writeString (obj.FixedContact),
            () => output.writeString (obj.MovingContact),
            () => output.writeString (obj.Terminal)
        )
        AssetSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Bushing]): Bushing =
    {
        val parent = AssetSerializer.read (kryo, input, classOf[Asset])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Bushing (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Standard published by CIGRE (Council on Large Electric Systems).
 *
 * @param Element Reference to the superclass object.
 * @param standardEdition Edition of CIGRE standard.
 * @param standardNumber CIGRE standard number.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class CIGREStandard
(
    Element: BasicElement = null,
    standardEdition: String = null,
    standardNumber: String = null
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
        implicit val clz: String = CIGREStandard.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CIGREStandard.fields (position), value)
        emitattr (0, standardEdition)
        emitattr (1, standardNumber)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CIGREStandard rdf:ID=\"%s\">\n%s\t</cim:CIGREStandard>".format (id, export_fields)
    }
}

object CIGREStandard
extends
    CIMParseable[CIGREStandard]
{
    override val fields: Array[String] = Array[String] (
        "standardEdition",
        "standardNumber"
    )
    val standardEdition: Fielder = parse_attribute (attribute (cls, fields(0)))
    val standardNumber: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): CIGREStandard =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CIGREStandard (
            BasicElement.parse (context),
            mask (standardEdition (), 0),
            mask (standardNumber (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CIGREStandard] = CIGREStandardSerializer
}

object CIGREStandardSerializer extends CIMSerializer[CIGREStandard]
{
    def write (kryo: Kryo, output: Output, obj: CIGREStandard): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.standardEdition),
            () => output.writeString (obj.standardNumber)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CIGREStandard]): CIGREStandard =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CIGREStandard (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Enclosure that offers protection to the equipment it contains and/or safety to people/animals outside it.
 *
 * @param AssetContainer [[ch.ninecode.model.AssetContainer AssetContainer]] Reference to the superclass object.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class Cabinet
(
    AssetContainer: AssetContainer = null
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
    override def sup: AssetContainer = AssetContainer

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
        "\t<cim:Cabinet rdf:ID=\"%s\">\n%s\t</cim:Cabinet>".format (id, export_fields)
    }
}

object Cabinet
extends
    CIMParseable[Cabinet]
{

    def parse (context: CIMContext): Cabinet =
    {
        val ret = Cabinet (
            AssetContainer.parse (context)
        )
        ret
    }

    def serializer: Serializer[Cabinet] = CabinetSerializer
}

object CabinetSerializer extends CIMSerializer[Cabinet]
{
    def write (kryo: Kryo, output: Output, obj: Cabinet): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        AssetContainerSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Cabinet]): Cabinet =
    {
        val parent = AssetContainerSerializer.read (kryo, input, classOf[AssetContainer])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Cabinet (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * a Assets that may be used for planning, work or design purposes.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param estimatedUnitCost Estimated unit cost (or cost per unit length) of this type of asset.
 *        It does not include labor to install, construct or configure it.
 * @param kind Kind of asset (from enumerated list).
 * @param quantity The value, unit of measure, and multiplier for the quantity.
 * @param stockItem True if item is a stock item (default).
 * @param type Description of type of asset.
 * @param AssetInfo [[ch.ninecode.model.AssetInfo AssetInfo]] Generic nameplate information associated with this catalog asset type.
 * @param CompatibleUnits [[ch.ninecode.model.CompatibleUnit CompatibleUnit]] <em>undocumented</em>
 * @param ErpBomItemDatas [[ch.ninecode.model.ErpBomItemData ErpBomItemData]] <em>undocumented</em>
 * @param ErpInventoryIssues [[ch.ninecode.model.ErpIssueInventory ErpIssueInventory]] <em>undocumented</em>
 * @param ErpReqLineItems [[ch.ninecode.model.ErpReqLineItem ErpReqLineItem]] <em>undocumented</em>
 * @param ProductAssetModel [[ch.ninecode.model.ProductAssetModel ProductAssetModel]] Product asset model conforming to this catalog asset type.
 * @param TypeAssetCatalogue [[ch.ninecode.model.TypeAssetCatalogue TypeAssetCatalogue]] <em>undocumented</em>
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class CatalogAssetType
(
    IdentifiedObject: IdentifiedObject = null,
    estimatedUnitCost: Double = 0.0,
    kind: String = null,
    quantity: String = null,
    stockItem: Boolean = false,
    `type`: String = null,
    AssetInfo: String = null,
    CompatibleUnits: List[String] = null,
    ErpBomItemDatas: List[String] = null,
    ErpInventoryIssues: List[String] = null,
    ErpReqLineItems: List[String] = null,
    ProductAssetModel: List[String] = null,
    TypeAssetCatalogue: String = null
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
        implicit val clz: String = CatalogAssetType.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CatalogAssetType.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CatalogAssetType.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (CatalogAssetType.fields (position), x))
        emitelem (0, estimatedUnitCost)
        emitattr (1, kind)
        emitattr (2, quantity)
        emitelem (3, stockItem)
        emitelem (4, `type`)
        emitattr (5, AssetInfo)
        emitattrs (6, CompatibleUnits)
        emitattrs (7, ErpBomItemDatas)
        emitattrs (8, ErpInventoryIssues)
        emitattrs (9, ErpReqLineItems)
        emitattrs (10, ProductAssetModel)
        emitattr (11, TypeAssetCatalogue)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CatalogAssetType rdf:ID=\"%s\">\n%s\t</cim:CatalogAssetType>".format (id, export_fields)
    }
}

object CatalogAssetType
extends
    CIMParseable[CatalogAssetType]
{
    override val fields: Array[String] = Array[String] (
        "estimatedUnitCost",
        "kind",
        "quantity",
        "stockItem",
        "type",
        "AssetInfo",
        "CompatibleUnits",
        "ErpBomItemDatas",
        "ErpInventoryIssues",
        "ErpReqLineItems",
        "ProductAssetModel",
        "TypeAssetCatalogue"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AssetInfo", "AssetInfo", "0..1", "0..1"),
        CIMRelationship ("CompatibleUnits", "CompatibleUnit", "0..*", "0..1"),
        CIMRelationship ("ErpBomItemDatas", "ErpBomItemData", "0..*", "0..1"),
        CIMRelationship ("ErpInventoryIssues", "ErpIssueInventory", "0..*", "0..1"),
        CIMRelationship ("ErpReqLineItems", "ErpReqLineItem", "0..*", "0..1"),
        CIMRelationship ("ProductAssetModel", "ProductAssetModel", "0..*", "0..1"),
        CIMRelationship ("TypeAssetCatalogue", "TypeAssetCatalogue", "0..1", "0..*")
    )
    val estimatedUnitCost: Fielder = parse_element (element (cls, fields(0)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(1)))
    val quantity: Fielder = parse_attribute (attribute (cls, fields(2)))
    val stockItem: Fielder = parse_element (element (cls, fields(3)))
    val `type`: Fielder = parse_element (element (cls, fields(4)))
    val AssetInfo: Fielder = parse_attribute (attribute (cls, fields(5)))
    val CompatibleUnits: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val ErpBomItemDatas: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val ErpInventoryIssues: FielderMultiple = parse_attributes (attribute (cls, fields(8)))
    val ErpReqLineItems: FielderMultiple = parse_attributes (attribute (cls, fields(9)))
    val ProductAssetModel: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val TypeAssetCatalogue: Fielder = parse_attribute (attribute (cls, fields(11)))

    def parse (context: CIMContext): CatalogAssetType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CatalogAssetType (
            IdentifiedObject.parse (context),
            toDouble (mask (estimatedUnitCost (), 0)),
            mask (kind (), 1),
            mask (quantity (), 2),
            toBoolean (mask (stockItem (), 3)),
            mask (`type` (), 4),
            mask (AssetInfo (), 5),
            masks (CompatibleUnits (), 6),
            masks (ErpBomItemDatas (), 7),
            masks (ErpInventoryIssues (), 8),
            masks (ErpReqLineItems (), 9),
            masks (ProductAssetModel (), 10),
            mask (TypeAssetCatalogue (), 11)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CatalogAssetType] = CatalogAssetTypeSerializer
}

object CatalogAssetTypeSerializer extends CIMSerializer[CatalogAssetType]
{
    def write (kryo: Kryo, output: Output, obj: CatalogAssetType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.estimatedUnitCost),
            () => output.writeString (obj.kind),
            () => output.writeString (obj.quantity),
            () => output.writeBoolean (obj.stockItem),
            () => output.writeString (obj.`type`),
            () => output.writeString (obj.AssetInfo),
            () => writeList (obj.CompatibleUnits, output),
            () => writeList (obj.ErpBomItemDatas, output),
            () => writeList (obj.ErpInventoryIssues, output),
            () => writeList (obj.ErpReqLineItems, output),
            () => writeList (obj.ProductAssetModel, output),
            () => output.writeString (obj.TypeAssetCatalogue)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CatalogAssetType]): CatalogAssetType =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CatalogAssetType (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readBoolean else false,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) readList (input) else null,
            if (isSet (7)) readList (input) else null,
            if (isSet (8)) readList (input) else null,
            if (isSet (9)) readList (input) else null,
            if (isSet (10)) readList (input) else null,
            if (isSet (11)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Communication media such as fibre optic cable, power-line, telephone, etc.
 *
 * @param Asset [[ch.ninecode.model.Asset Asset]] Reference to the superclass object.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class ComMedia
(
    Asset: Asset = null
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
    override def sup: Asset = Asset

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
        "\t<cim:ComMedia rdf:ID=\"%s\">\n%s\t</cim:ComMedia>".format (id, export_fields)
    }
}

object ComMedia
extends
    CIMParseable[ComMedia]
{

    def parse (context: CIMContext): ComMedia =
    {
        val ret = ComMedia (
            Asset.parse (context)
        )
        ret
    }

    def serializer: Serializer[ComMedia] = ComMediaSerializer
}

object ComMediaSerializer extends CIMSerializer[ComMedia]
{
    def write (kryo: Kryo, output: Output, obj: ComMedia): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        AssetSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ComMedia]): ComMedia =
    {
        val parent = AssetSerializer.read (kryo, input, classOf[Asset])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ComMedia (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Standard published by DIN (German Institute of Standards).
 *
 * @param Element Reference to the superclass object.
 * @param standardEdition Edition of DIN standard.
 * @param standardNumber DIN standard number.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class DINStandard
(
    Element: BasicElement = null,
    standardEdition: String = null,
    standardNumber: String = null
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
        implicit val clz: String = DINStandard.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DINStandard.fields (position), value)
        emitattr (0, standardEdition)
        emitattr (1, standardNumber)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DINStandard rdf:ID=\"%s\">\n%s\t</cim:DINStandard>".format (id, export_fields)
    }
}

object DINStandard
extends
    CIMParseable[DINStandard]
{
    override val fields: Array[String] = Array[String] (
        "standardEdition",
        "standardNumber"
    )
    val standardEdition: Fielder = parse_attribute (attribute (cls, fields(0)))
    val standardNumber: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): DINStandard =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DINStandard (
            BasicElement.parse (context),
            mask (standardEdition (), 0),
            mask (standardNumber (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DINStandard] = DINStandardSerializer
}

object DINStandardSerializer extends CIMSerializer[DINStandard]
{
    def write (kryo: Kryo, output: Output, obj: DINStandard): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.standardEdition),
            () => output.writeString (obj.standardNumber)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DINStandard]): DINStandard =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = DINStandard (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Dates for deployment events of an asset.
 *
 * May have multiple deployment type dates for this device and a compound type allows a query to return multiple dates.
 *
 * @param Element Reference to the superclass object.
 * @param inServiceDate Date and time asset most recently put in service.
 * @param installedDate Date and time asset most recently installed.
 * @param notYetInstalledDate Date and time of asset deployment transition to not yet installed.
 * @param outOfServiceDate Date and time asset most recently taken out of service.
 * @param removedDate Date and time asset most recently removed.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class DeploymentDate
(
    Element: BasicElement = null,
    inServiceDate: String = null,
    installedDate: String = null,
    notYetInstalledDate: String = null,
    outOfServiceDate: String = null,
    removedDate: String = null
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
        implicit val clz: String = DeploymentDate.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DeploymentDate.fields (position), value)
        emitelem (0, inServiceDate)
        emitelem (1, installedDate)
        emitelem (2, notYetInstalledDate)
        emitelem (3, outOfServiceDate)
        emitelem (4, removedDate)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DeploymentDate rdf:ID=\"%s\">\n%s\t</cim:DeploymentDate>".format (id, export_fields)
    }
}

object DeploymentDate
extends
    CIMParseable[DeploymentDate]
{
    override val fields: Array[String] = Array[String] (
        "inServiceDate",
        "installedDate",
        "notYetInstalledDate",
        "outOfServiceDate",
        "removedDate"
    )
    val inServiceDate: Fielder = parse_element (element (cls, fields(0)))
    val installedDate: Fielder = parse_element (element (cls, fields(1)))
    val notYetInstalledDate: Fielder = parse_element (element (cls, fields(2)))
    val outOfServiceDate: Fielder = parse_element (element (cls, fields(3)))
    val removedDate: Fielder = parse_element (element (cls, fields(4)))

    def parse (context: CIMContext): DeploymentDate =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DeploymentDate (
            BasicElement.parse (context),
            mask (inServiceDate (), 0),
            mask (installedDate (), 1),
            mask (notYetInstalledDate (), 2),
            mask (outOfServiceDate (), 3),
            mask (removedDate (), 4)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DeploymentDate] = DeploymentDateSerializer
}

object DeploymentDateSerializer extends CIMSerializer[DeploymentDate]
{
    def write (kryo: Kryo, output: Output, obj: DeploymentDate): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.inServiceDate),
            () => output.writeString (obj.installedDate),
            () => output.writeString (obj.notYetInstalledDate),
            () => output.writeString (obj.outOfServiceDate),
            () => output.writeString (obj.removedDate)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DeploymentDate]): DeploymentDate =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = DeploymentDate (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The result of a problem (typically an asset failure) diagnosis.
 *
 * Contains complete information like what might be received from a lab doing forensic analysis of a failed asset.
 *
 * @param ProcedureDataSet [[ch.ninecode.model.ProcedureDataSet ProcedureDataSet]] Reference to the superclass object.
 * @param effect Effect of problem.
 * @param failureMode Failuer mode, for example: Failure to Insulate; Failure to conduct; Failure to contain oil; Failure to provide ground plane; Other.
 * @param finalCause Cause of problem determined during diagnosis.
 * @param finalCode Code for diagnosed probem type.
 * @param finalOrigin Origin of problem determined during diagnosis.
 * @param finalRemark Remarks pertaining to findings during problem diagnosis.
 * @param phaseCode Phase(s) diagnosed.
 * @param preliminaryCode Code for problem type determined during preliminary assessment.
 * @param preliminaryDateTime Date and time preliminary assessment of problem was performed.
 * @param preliminaryRemark Remarks pertaining to preliminary assessment of problem.
 * @param rootCause Root cause of problem determined during diagnosis.
 * @param rootOrigin Root origin of problem determined during diagnosis.
 * @param rootRemark Remarks pertaining to root cause findings during problem diagnosis.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class DiagnosisDataSet
(
    ProcedureDataSet: ProcedureDataSet = null,
    effect: String = null,
    failureMode: String = null,
    finalCause: String = null,
    finalCode: String = null,
    finalOrigin: String = null,
    finalRemark: String = null,
    phaseCode: String = null,
    preliminaryCode: String = null,
    preliminaryDateTime: String = null,
    preliminaryRemark: String = null,
    rootCause: String = null,
    rootOrigin: String = null,
    rootRemark: String = null
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
    override def sup: ProcedureDataSet = ProcedureDataSet

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
        implicit val clz: String = DiagnosisDataSet.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DiagnosisDataSet.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DiagnosisDataSet.fields (position), value)
        emitelem (0, effect)
        emitelem (1, failureMode)
        emitelem (2, finalCause)
        emitelem (3, finalCode)
        emitelem (4, finalOrigin)
        emitelem (5, finalRemark)
        emitattr (6, phaseCode)
        emitelem (7, preliminaryCode)
        emitelem (8, preliminaryDateTime)
        emitelem (9, preliminaryRemark)
        emitelem (10, rootCause)
        emitelem (11, rootOrigin)
        emitelem (12, rootRemark)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DiagnosisDataSet rdf:ID=\"%s\">\n%s\t</cim:DiagnosisDataSet>".format (id, export_fields)
    }
}

object DiagnosisDataSet
extends
    CIMParseable[DiagnosisDataSet]
{
    override val fields: Array[String] = Array[String] (
        "effect",
        "failureMode",
        "finalCause",
        "finalCode",
        "finalOrigin",
        "finalRemark",
        "phaseCode",
        "preliminaryCode",
        "preliminaryDateTime",
        "preliminaryRemark",
        "rootCause",
        "rootOrigin",
        "rootRemark"
    )
    val effect: Fielder = parse_element (element (cls, fields(0)))
    val failureMode: Fielder = parse_element (element (cls, fields(1)))
    val finalCause: Fielder = parse_element (element (cls, fields(2)))
    val finalCode: Fielder = parse_element (element (cls, fields(3)))
    val finalOrigin: Fielder = parse_element (element (cls, fields(4)))
    val finalRemark: Fielder = parse_element (element (cls, fields(5)))
    val phaseCode: Fielder = parse_attribute (attribute (cls, fields(6)))
    val preliminaryCode: Fielder = parse_element (element (cls, fields(7)))
    val preliminaryDateTime: Fielder = parse_element (element (cls, fields(8)))
    val preliminaryRemark: Fielder = parse_element (element (cls, fields(9)))
    val rootCause: Fielder = parse_element (element (cls, fields(10)))
    val rootOrigin: Fielder = parse_element (element (cls, fields(11)))
    val rootRemark: Fielder = parse_element (element (cls, fields(12)))

    def parse (context: CIMContext): DiagnosisDataSet =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DiagnosisDataSet (
            ProcedureDataSet.parse (context),
            mask (effect (), 0),
            mask (failureMode (), 1),
            mask (finalCause (), 2),
            mask (finalCode (), 3),
            mask (finalOrigin (), 4),
            mask (finalRemark (), 5),
            mask (phaseCode (), 6),
            mask (preliminaryCode (), 7),
            mask (preliminaryDateTime (), 8),
            mask (preliminaryRemark (), 9),
            mask (rootCause (), 10),
            mask (rootOrigin (), 11),
            mask (rootRemark (), 12)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DiagnosisDataSet] = DiagnosisDataSetSerializer
}

object DiagnosisDataSetSerializer extends CIMSerializer[DiagnosisDataSet]
{
    def write (kryo: Kryo, output: Output, obj: DiagnosisDataSet): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.effect),
            () => output.writeString (obj.failureMode),
            () => output.writeString (obj.finalCause),
            () => output.writeString (obj.finalCode),
            () => output.writeString (obj.finalOrigin),
            () => output.writeString (obj.finalRemark),
            () => output.writeString (obj.phaseCode),
            () => output.writeString (obj.preliminaryCode),
            () => output.writeString (obj.preliminaryDateTime),
            () => output.writeString (obj.preliminaryRemark),
            () => output.writeString (obj.rootCause),
            () => output.writeString (obj.rootOrigin),
            () => output.writeString (obj.rootRemark)
        )
        ProcedureDataSetSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DiagnosisDataSet]): DiagnosisDataSet =
    {
        val parent = ProcedureDataSetSerializer.read (kryo, input, classOf[ProcedureDataSet])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = DiagnosisDataSet (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) input.readString else null,
            if (isSet (11)) input.readString else null,
            if (isSet (12)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Standard published by Doble.
 *
 * @param Element Reference to the superclass object.
 * @param standardEdition Edition of Doble standard.
 * @param standardNumber Doble standard number.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class DobleStandard
(
    Element: BasicElement = null,
    standardEdition: String = null,
    standardNumber: String = null
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
        implicit val clz: String = DobleStandard.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DobleStandard.fields (position), value)
        emitattr (0, standardEdition)
        emitattr (1, standardNumber)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DobleStandard rdf:ID=\"%s\">\n%s\t</cim:DobleStandard>".format (id, export_fields)
    }
}

object DobleStandard
extends
    CIMParseable[DobleStandard]
{
    override val fields: Array[String] = Array[String] (
        "standardEdition",
        "standardNumber"
    )
    val standardEdition: Fielder = parse_attribute (attribute (cls, fields(0)))
    val standardNumber: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): DobleStandard =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DobleStandard (
            BasicElement.parse (context),
            mask (standardEdition (), 0),
            mask (standardNumber (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DobleStandard] = DobleStandardSerializer
}

object DobleStandardSerializer extends CIMSerializer[DobleStandard]
{
    def write (kryo: Kryo, output: Output, obj: DobleStandard): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.standardEdition),
            () => output.writeString (obj.standardNumber)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DobleStandard]): DobleStandard =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = DobleStandard (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A duct contains individual wires in the layout as specified with associated wire spacing instances; number of them gives the number of conductors in this duct.
 *
 * @param AssetContainer [[ch.ninecode.model.AssetContainer AssetContainer]] Reference to the superclass object.
 * @param circuitCount Number of circuits in duct bank.
 *        Refer to associations between a duct (ConductorAsset) and an ACLineSegment to understand which circuits are in which ducts.
 * @param WireSpacingInfos [[ch.ninecode.model.WireSpacing WireSpacing]] <em>undocumented</em>
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class DuctBank
(
    AssetContainer: AssetContainer = null,
    circuitCount: Int = 0,
    WireSpacingInfos: List[String] = null
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
    override def sup: AssetContainer = AssetContainer

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
        implicit val clz: String = DuctBank.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DuctBank.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (DuctBank.fields (position), x))
        emitelem (0, circuitCount)
        emitattrs (1, WireSpacingInfos)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DuctBank rdf:ID=\"%s\">\n%s\t</cim:DuctBank>".format (id, export_fields)
    }
}

object DuctBank
extends
    CIMParseable[DuctBank]
{
    override val fields: Array[String] = Array[String] (
        "circuitCount",
        "WireSpacingInfos"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("WireSpacingInfos", "WireSpacing", "0..*", "0..1")
    )
    val circuitCount: Fielder = parse_element (element (cls, fields(0)))
    val WireSpacingInfos: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): DuctBank =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DuctBank (
            AssetContainer.parse (context),
            toInteger (mask (circuitCount (), 0)),
            masks (WireSpacingInfos (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DuctBank] = DuctBankSerializer
}

object DuctBankSerializer extends CIMSerializer[DuctBank]
{
    def write (kryo: Kryo, output: Output, obj: DuctBank): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeInt (obj.circuitCount),
            () => writeList (obj.WireSpacingInfos, output)
        )
        AssetContainerSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DuctBank]): DuctBank =
    {
        val parent = AssetContainerSerializer.read (kryo, input, classOf[AssetContainer])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = DuctBank (
            parent,
            if (isSet (0)) input.readInt else 0,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Standard published by EPA (United States Environmental Protection Agency).
 *
 * @param Element Reference to the superclass object.
 * @param standardEdition Edition of EPA standard.
 * @param standardNumber EPA standard number.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class EPAStandard
(
    Element: BasicElement = null,
    standardEdition: String = null,
    standardNumber: String = null
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
        implicit val clz: String = EPAStandard.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EPAStandard.fields (position), value)
        emitattr (0, standardEdition)
        emitattr (1, standardNumber)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EPAStandard rdf:ID=\"%s\">\n%s\t</cim:EPAStandard>".format (id, export_fields)
    }
}

object EPAStandard
extends
    CIMParseable[EPAStandard]
{
    override val fields: Array[String] = Array[String] (
        "standardEdition",
        "standardNumber"
    )
    val standardEdition: Fielder = parse_attribute (attribute (cls, fields(0)))
    val standardNumber: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): EPAStandard =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EPAStandard (
            BasicElement.parse (context),
            mask (standardEdition (), 0),
            mask (standardNumber (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[EPAStandard] = EPAStandardSerializer
}

object EPAStandardSerializer extends CIMSerializer[EPAStandard]
{
    def write (kryo: Kryo, output: Output, obj: EPAStandard): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.standardEdition),
            () => output.writeString (obj.standardNumber)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EPAStandard]): EPAStandard =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = EPAStandard (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * FACTS device asset.
 *
 * @param Asset [[ch.ninecode.model.Asset Asset]] Reference to the superclass object.
 * @param kind Kind of FACTS device.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class FACTSDevice
(
    Asset: Asset = null,
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
    override def sup: Asset = Asset

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
        implicit val clz: String = FACTSDevice.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (FACTSDevice.fields (position), value)
        emitattr (0, kind)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FACTSDevice rdf:ID=\"%s\">\n%s\t</cim:FACTSDevice>".format (id, export_fields)
    }
}

object FACTSDevice
extends
    CIMParseable[FACTSDevice]
{
    override val fields: Array[String] = Array[String] (
        "kind"
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): FACTSDevice =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = FACTSDevice (
            Asset.parse (context),
            mask (kind (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[FACTSDevice] = FACTSDeviceSerializer
}

object FACTSDeviceSerializer extends CIMSerializer[FACTSDevice]
{
    def write (kryo: Kryo, output: Output, obj: FACTSDevice): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.kind)
        )
        AssetSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[FACTSDevice]): FACTSDevice =
    {
        val parent = AssetSerializer.read (kryo, input, classOf[Asset])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = FACTSDevice (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A facility may contain buildings, storage facilities, switching facilities, power generation, manufacturing facilities, maintenance facilities, etc.
 *
 * @param AssetContainer [[ch.ninecode.model.AssetContainer AssetContainer]] Reference to the superclass object.
 * @param kind Kind of this facility.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class Facility
(
    AssetContainer: AssetContainer = null,
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
    override def sup: AssetContainer = AssetContainer

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
        implicit val clz: String = Facility.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Facility.fields (position), value)
        emitelem (0, kind)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Facility rdf:ID=\"%s\">\n%s\t</cim:Facility>".format (id, export_fields)
    }
}

object Facility
extends
    CIMParseable[Facility]
{
    override val fields: Array[String] = Array[String] (
        "kind"
    )
    val kind: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: CIMContext): Facility =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Facility (
            AssetContainer.parse (context),
            mask (kind (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Facility] = FacilitySerializer
}

object FacilitySerializer extends CIMSerializer[Facility]
{
    def write (kryo: Kryo, output: Output, obj: Facility): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.kind)
        )
        AssetContainerSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Facility]): Facility =
    {
        val parent = AssetContainerSerializer.read (kryo, input, classOf[AssetContainer])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Facility (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An event where an asset has failed to perform its functions within specified parameters.
 *
 * This class is intended to reflect the failure itself. Additional information resulting from forensic analysis could be captured by a diagnosis data set.
 *
 * @param ActivityRecord [[ch.ninecode.model.ActivityRecord ActivityRecord]] Reference to the superclass object.
 * @param breakerFailureReason Reason for breaker failure.
 * @param corporateCode Code for asset failure.
 * @param failureClassification Classification of failure.
 * @param failureDateTime Time and date of asset failure.
 * @param failureIsolationMethod How the asset failure was isolated from the system.
 * @param failureMode What asset failed to be able to do.
 * @param faultLocatingMethod The method used for locating the faulted part of the asset.
 *        For example, cable options include: Cap Discharge-Thumping, Bridge Method, Visual Inspection, Other.
 * @param location Failure location on an object.
 * @param rootCause Root cause of asset failure.
 * @param transformerFailureReason Reason for transformer failure.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class FailureEvent
(
    ActivityRecord: ActivityRecord = null,
    breakerFailureReason: String = null,
    corporateCode: String = null,
    failureClassification: String = null,
    failureDateTime: String = null,
    failureIsolationMethod: String = null,
    failureMode: String = null,
    faultLocatingMethod: String = null,
    location: String = null,
    rootCause: String = null,
    transformerFailureReason: String = null
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
        implicit val clz: String = FailureEvent.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (FailureEvent.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (FailureEvent.fields (position), value)
        emitattr (0, breakerFailureReason)
        emitelem (1, corporateCode)
        emitattr (2, failureClassification)
        emitelem (3, failureDateTime)
        emitattr (4, failureIsolationMethod)
        emitattr (5, failureMode)
        emitelem (6, faultLocatingMethod)
        emitelem (7, location)
        emitelem (8, rootCause)
        emitattr (9, transformerFailureReason)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FailureEvent rdf:ID=\"%s\">\n%s\t</cim:FailureEvent>".format (id, export_fields)
    }
}

object FailureEvent
extends
    CIMParseable[FailureEvent]
{
    override val fields: Array[String] = Array[String] (
        "breakerFailureReason",
        "corporateCode",
        "failureClassification",
        "failureDateTime",
        "failureIsolationMethod",
        "failureMode",
        "faultLocatingMethod",
        "location",
        "rootCause",
        "transformerFailureReason"
    )
    val breakerFailureReason: Fielder = parse_attribute (attribute (cls, fields(0)))
    val corporateCode: Fielder = parse_element (element (cls, fields(1)))
    val failureClassification: Fielder = parse_attribute (attribute (cls, fields(2)))
    val failureDateTime: Fielder = parse_element (element (cls, fields(3)))
    val failureIsolationMethod: Fielder = parse_attribute (attribute (cls, fields(4)))
    val failureMode: Fielder = parse_attribute (attribute (cls, fields(5)))
    val faultLocatingMethod: Fielder = parse_element (element (cls, fields(6)))
    val location: Fielder = parse_element (element (cls, fields(7)))
    val rootCause: Fielder = parse_element (element (cls, fields(8)))
    val transformerFailureReason: Fielder = parse_attribute (attribute (cls, fields(9)))

    def parse (context: CIMContext): FailureEvent =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = FailureEvent (
            ActivityRecord.parse (context),
            mask (breakerFailureReason (), 0),
            mask (corporateCode (), 1),
            mask (failureClassification (), 2),
            mask (failureDateTime (), 3),
            mask (failureIsolationMethod (), 4),
            mask (failureMode (), 5),
            mask (faultLocatingMethod (), 6),
            mask (location (), 7),
            mask (rootCause (), 8),
            mask (transformerFailureReason (), 9)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[FailureEvent] = FailureEventSerializer
}

object FailureEventSerializer extends CIMSerializer[FailureEvent]
{
    def write (kryo: Kryo, output: Output, obj: FailureEvent): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.breakerFailureReason),
            () => output.writeString (obj.corporateCode),
            () => output.writeString (obj.failureClassification),
            () => output.writeString (obj.failureDateTime),
            () => output.writeString (obj.failureIsolationMethod),
            () => output.writeString (obj.failureMode),
            () => output.writeString (obj.faultLocatingMethod),
            () => output.writeString (obj.location),
            () => output.writeString (obj.rootCause),
            () => output.writeString (obj.transformerFailureReason)
        )
        ActivityRecordSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[FailureEvent]): FailureEvent =
    {
        val parent = ActivityRecordSerializer.read (kryo, input, classOf[ActivityRecord])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = FailureEvent (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Various current financial properties associated with a particular asset.
 *
 * Historical properties may be determined by ActivityRecords associated with the asset.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param account The account to which this actual material item is charged.
 * @param actualPurchaseCost The actual purchase cost of this particular asset.
 * @param costDescription Description of the cost.
 * @param costType Type of cost to which this Material Item belongs.
 * @param financialValue Value of asset as of 'valueDateTime'.
 * @param plantTransferDateTime Date and time asset's financial value was put in plant for regulatory accounting purposes (e.g., for rate base calculations).
 *        This is sometime referred to as the "in-service date".
 * @param purchaseDateTime Date and time asset was purchased.
 * @param purchaseOrderNumber Purchase order identifier.
 * @param quantity The quantity of the asset if per unit length, for example conductor.
 * @param valueDateTime Date and time at which the financial value was last established.
 * @param warrantyEndDateTime Date and time warranty on asset expires.
 * @param Asset [[ch.ninecode.model.Asset Asset]] The asset to which this financial information relates.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class FinancialInfo
(
    IdentifiedObject: IdentifiedObject = null,
    account: String = null,
    actualPurchaseCost: Double = 0.0,
    costDescription: String = null,
    costType: String = null,
    financialValue: Double = 0.0,
    plantTransferDateTime: String = null,
    purchaseDateTime: String = null,
    purchaseOrderNumber: String = null,
    quantity: String = null,
    valueDateTime: String = null,
    warrantyEndDateTime: String = null,
    Asset: String = null
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
        implicit val clz: String = FinancialInfo.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (FinancialInfo.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (FinancialInfo.fields (position), value)
        emitelem (0, account)
        emitelem (1, actualPurchaseCost)
        emitelem (2, costDescription)
        emitelem (3, costType)
        emitelem (4, financialValue)
        emitelem (5, plantTransferDateTime)
        emitelem (6, purchaseDateTime)
        emitelem (7, purchaseOrderNumber)
        emitattr (8, quantity)
        emitelem (9, valueDateTime)
        emitelem (10, warrantyEndDateTime)
        emitattr (11, Asset)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FinancialInfo rdf:ID=\"%s\">\n%s\t</cim:FinancialInfo>".format (id, export_fields)
    }
}

object FinancialInfo
extends
    CIMParseable[FinancialInfo]
{
    override val fields: Array[String] = Array[String] (
        "account",
        "actualPurchaseCost",
        "costDescription",
        "costType",
        "financialValue",
        "plantTransferDateTime",
        "purchaseDateTime",
        "purchaseOrderNumber",
        "quantity",
        "valueDateTime",
        "warrantyEndDateTime",
        "Asset"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Asset", "Asset", "0..1", "0..1")
    )
    val account: Fielder = parse_element (element (cls, fields(0)))
    val actualPurchaseCost: Fielder = parse_element (element (cls, fields(1)))
    val costDescription: Fielder = parse_element (element (cls, fields(2)))
    val costType: Fielder = parse_element (element (cls, fields(3)))
    val financialValue: Fielder = parse_element (element (cls, fields(4)))
    val plantTransferDateTime: Fielder = parse_element (element (cls, fields(5)))
    val purchaseDateTime: Fielder = parse_element (element (cls, fields(6)))
    val purchaseOrderNumber: Fielder = parse_element (element (cls, fields(7)))
    val quantity: Fielder = parse_attribute (attribute (cls, fields(8)))
    val valueDateTime: Fielder = parse_element (element (cls, fields(9)))
    val warrantyEndDateTime: Fielder = parse_element (element (cls, fields(10)))
    val Asset: Fielder = parse_attribute (attribute (cls, fields(11)))

    def parse (context: CIMContext): FinancialInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = FinancialInfo (
            IdentifiedObject.parse (context),
            mask (account (), 0),
            toDouble (mask (actualPurchaseCost (), 1)),
            mask (costDescription (), 2),
            mask (costType (), 3),
            toDouble (mask (financialValue (), 4)),
            mask (plantTransferDateTime (), 5),
            mask (purchaseDateTime (), 6),
            mask (purchaseOrderNumber (), 7),
            mask (quantity (), 8),
            mask (valueDateTime (), 9),
            mask (warrantyEndDateTime (), 10),
            mask (Asset (), 11)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[FinancialInfo] = FinancialInfoSerializer
}

object FinancialInfoSerializer extends CIMSerializer[FinancialInfo]
{
    def write (kryo: Kryo, output: Output, obj: FinancialInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.account),
            () => output.writeDouble (obj.actualPurchaseCost),
            () => output.writeString (obj.costDescription),
            () => output.writeString (obj.costType),
            () => output.writeDouble (obj.financialValue),
            () => output.writeString (obj.plantTransferDateTime),
            () => output.writeString (obj.purchaseDateTime),
            () => output.writeString (obj.purchaseOrderNumber),
            () => output.writeString (obj.quantity),
            () => output.writeString (obj.valueDateTime),
            () => output.writeString (obj.warrantyEndDateTime),
            () => output.writeString (obj.Asset)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[FinancialInfo]): FinancialInfo =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = FinancialInfo (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) input.readString else null,
            if (isSet (11)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Score that is indicative of the health of one or more assets.
 *
 * @param AggregateScore [[ch.ninecode.model.AggregateScore AggregateScore]] Reference to the superclass object.
 * @param AssetRiskScore [[ch.ninecode.model.RiskScore RiskScore]] Risk score with which this health score is associated.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class HealthScore
(
    AggregateScore: AggregateScore = null,
    AssetRiskScore: String = null
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
    override def sup: AggregateScore = AggregateScore

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
        implicit val clz: String = HealthScore.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (HealthScore.fields (position), value)
        emitattr (0, AssetRiskScore)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:HealthScore rdf:ID=\"%s\">\n%s\t</cim:HealthScore>".format (id, export_fields)
    }
}

object HealthScore
extends
    CIMParseable[HealthScore]
{
    override val fields: Array[String] = Array[String] (
        "AssetRiskScore"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AssetRiskScore", "RiskScore", "0..1", "0..*")
    )
    val AssetRiskScore: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): HealthScore =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = HealthScore (
            AggregateScore.parse (context),
            mask (AssetRiskScore (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[HealthScore] = HealthScoreSerializer
}

object HealthScoreSerializer extends CIMSerializer[HealthScore]
{
    def write (kryo: Kryo, output: Output, obj: HealthScore): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.AssetRiskScore)
        )
        AggregateScoreSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[HealthScore]): HealthScore =
    {
        val parent = AggregateScoreSerializer.read (kryo, input, classOf[AggregateScore])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = HealthScore (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Standard published by IEC (International Electrotechnical Commission).
 *
 * @param Element Reference to the superclass object.
 * @param standardEdition Edition of IEC standard.
 * @param standardNumber IEC standard number.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class IECStandard
(
    Element: BasicElement = null,
    standardEdition: String = null,
    standardNumber: String = null
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
        implicit val clz: String = IECStandard.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (IECStandard.fields (position), value)
        emitattr (0, standardEdition)
        emitattr (1, standardNumber)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:IECStandard rdf:ID=\"%s\">\n%s\t</cim:IECStandard>".format (id, export_fields)
    }
}

object IECStandard
extends
    CIMParseable[IECStandard]
{
    override val fields: Array[String] = Array[String] (
        "standardEdition",
        "standardNumber"
    )
    val standardEdition: Fielder = parse_attribute (attribute (cls, fields(0)))
    val standardNumber: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): IECStandard =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = IECStandard (
            BasicElement.parse (context),
            mask (standardEdition (), 0),
            mask (standardNumber (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[IECStandard] = IECStandardSerializer
}

object IECStandardSerializer extends CIMSerializer[IECStandard]
{
    def write (kryo: Kryo, output: Output, obj: IECStandard): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.standardEdition),
            () => output.writeString (obj.standardNumber)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[IECStandard]): IECStandard =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = IECStandard (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Standard published by IEEE (Institute of Electrical and Electronics Engineers).
 *
 * @param Element Reference to the superclass object.
 * @param standardEdition Edition of IEEE standard.
 * @param standardNumber IEEE standard number.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class IEEEStandard
(
    Element: BasicElement = null,
    standardEdition: String = null,
    standardNumber: String = null
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
        implicit val clz: String = IEEEStandard.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (IEEEStandard.fields (position), value)
        emitattr (0, standardEdition)
        emitattr (1, standardNumber)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:IEEEStandard rdf:ID=\"%s\">\n%s\t</cim:IEEEStandard>".format (id, export_fields)
    }
}

object IEEEStandard
extends
    CIMParseable[IEEEStandard]
{
    override val fields: Array[String] = Array[String] (
        "standardEdition",
        "standardNumber"
    )
    val standardEdition: Fielder = parse_attribute (attribute (cls, fields(0)))
    val standardNumber: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): IEEEStandard =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = IEEEStandard (
            BasicElement.parse (context),
            mask (standardEdition (), 0),
            mask (standardNumber (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[IEEEStandard] = IEEEStandardSerializer
}

object IEEEStandardSerializer extends CIMSerializer[IEEEStandard]
{
    def write (kryo: Kryo, output: Output, obj: IEEEStandard): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.standardEdition),
            () => output.writeString (obj.standardNumber)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[IEEEStandard]): IEEEStandard =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = IEEEStandard (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Standard published by ISO (International Organization for Standardization).
 *
 * @param Element Reference to the superclass object.
 * @param standardEdition Edition of ISO standard.
 * @param standardNumber ISO standard number.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class ISOStandard
(
    Element: BasicElement = null,
    standardEdition: String = null,
    standardNumber: String = null
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
        implicit val clz: String = ISOStandard.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ISOStandard.fields (position), value)
        emitattr (0, standardEdition)
        emitattr (1, standardNumber)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ISOStandard rdf:ID=\"%s\">\n%s\t</cim:ISOStandard>".format (id, export_fields)
    }
}

object ISOStandard
extends
    CIMParseable[ISOStandard]
{
    override val fields: Array[String] = Array[String] (
        "standardEdition",
        "standardNumber"
    )
    val standardEdition: Fielder = parse_attribute (attribute (cls, fields(0)))
    val standardNumber: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): ISOStandard =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ISOStandard (
            BasicElement.parse (context),
            mask (standardEdition (), 0),
            mask (standardNumber (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ISOStandard] = ISOStandardSerializer
}

object ISOStandardSerializer extends CIMSerializer[ISOStandard]
{
    def write (kryo: Kryo, output: Output, obj: ISOStandard): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.standardEdition),
            () => output.writeString (obj.standardNumber)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ISOStandard]): ISOStandard =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ISOStandard (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Dates associated with asset 'in use' status.
 *
 * May have multiple in use dates for this device and a compound type allows a query to return multiple dates.
 *
 * @param Element Reference to the superclass object.
 * @param inUseDate Date asset was most recently put in use.
 * @param notReadyForUseDate Date of most recent asset transition to not ready for use state.
 * @param readyForUseDate Date of most recent asset transition to ready for use state.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class InUseDate
(
    Element: BasicElement = null,
    inUseDate: String = null,
    notReadyForUseDate: String = null,
    readyForUseDate: String = null
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
        implicit val clz: String = InUseDate.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (InUseDate.fields (position), value)
        emitelem (0, inUseDate)
        emitelem (1, notReadyForUseDate)
        emitelem (2, readyForUseDate)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:InUseDate rdf:ID=\"%s\">\n%s\t</cim:InUseDate>".format (id, export_fields)
    }
}

object InUseDate
extends
    CIMParseable[InUseDate]
{
    override val fields: Array[String] = Array[String] (
        "inUseDate",
        "notReadyForUseDate",
        "readyForUseDate"
    )
    val inUseDate: Fielder = parse_element (element (cls, fields(0)))
    val notReadyForUseDate: Fielder = parse_element (element (cls, fields(1)))
    val readyForUseDate: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: CIMContext): InUseDate =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = InUseDate (
            BasicElement.parse (context),
            mask (inUseDate (), 0),
            mask (notReadyForUseDate (), 1),
            mask (readyForUseDate (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[InUseDate] = InUseDateSerializer
}

object InUseDateSerializer extends CIMSerializer[InUseDate]
{
    def write (kryo: Kryo, output: Output, obj: InUseDate): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.inUseDate),
            () => output.writeString (obj.notReadyForUseDate),
            () => output.writeString (obj.readyForUseDate)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[InUseDate]): InUseDate =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = InUseDate (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Documents the result of one inspection, for a given attribute of an asset.
 *
 * @param ProcedureDataSet [[ch.ninecode.model.ProcedureDataSet ProcedureDataSet]] Reference to the superclass object.
 * @param locationCondition Description of the conditions of the location where the asset resides.
 * @param AccordingToSchedules [[ch.ninecode.model.ScheduledEventData ScheduledEventData]] <em>undocumented</em>
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class InspectionDataSet
(
    ProcedureDataSet: ProcedureDataSet = null,
    locationCondition: String = null,
    AccordingToSchedules: List[String] = null
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
    override def sup: ProcedureDataSet = ProcedureDataSet

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
        implicit val clz: String = InspectionDataSet.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (InspectionDataSet.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (InspectionDataSet.fields (position), x))
        emitelem (0, locationCondition)
        emitattrs (1, AccordingToSchedules)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:InspectionDataSet rdf:ID=\"%s\">\n%s\t</cim:InspectionDataSet>".format (id, export_fields)
    }
}

object InspectionDataSet
extends
    CIMParseable[InspectionDataSet]
{
    override val fields: Array[String] = Array[String] (
        "locationCondition",
        "AccordingToSchedules"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AccordingToSchedules", "ScheduledEventData", "0..*", "1")
    )
    val locationCondition: Fielder = parse_element (element (cls, fields(0)))
    val AccordingToSchedules: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): InspectionDataSet =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = InspectionDataSet (
            ProcedureDataSet.parse (context),
            mask (locationCondition (), 0),
            masks (AccordingToSchedules (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[InspectionDataSet] = InspectionDataSetSerializer
}

object InspectionDataSetSerializer extends CIMSerializer[InspectionDataSet]
{
    def write (kryo: Kryo, output: Output, obj: InspectionDataSet): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.locationCondition),
            () => writeList (obj.AccordingToSchedules, output)
        )
        ProcedureDataSetSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[InspectionDataSet]): InspectionDataSet =
    {
        val parent = ProcedureDataSetSerializer.read (kryo, input, classOf[ProcedureDataSet])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = InspectionDataSet (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Breaker interrupter.
 *
 * Some interrupters have one fixed and one moving contact, some have 2 fixed contacts, some 2 moving contacts. An interrupter will have relationships with 2 bushings and those relationships may be any combination of the FixedContact and MovingContact associations.
 *
 * @param Asset [[ch.ninecode.model.Asset Asset]] Reference to the superclass object.
 * @param Bushing [[ch.ninecode.model.Bushing Bushing]] Bushing(s) to which the fixed contact(s) of this interrupter is(are) attached.
 *        Some interrupters have one fixed and one moving contact, some have 2 fixed contacts, some 2 moving contacts. An interrupter will have relationships with 2 bushings and those relationships may be any combination of the FixedContact and MovingContact associations.
 * @param OperatingMechanism [[ch.ninecode.model.OperatingMechanism OperatingMechanism]] Breaker mechanism controlling this interrupter.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class InterrupterUnit
(
    Asset: Asset = null,
    Bushing: List[String] = null,
    OperatingMechanism: String = null
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
    override def sup: Asset = Asset

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
        implicit val clz: String = InterrupterUnit.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (InterrupterUnit.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (InterrupterUnit.fields (position), x))
        emitattrs (0, Bushing)
        emitattr (1, OperatingMechanism)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:InterrupterUnit rdf:ID=\"%s\">\n%s\t</cim:InterrupterUnit>".format (id, export_fields)
    }
}

object InterrupterUnit
extends
    CIMParseable[InterrupterUnit]
{
    override val fields: Array[String] = Array[String] (
        "Bushing",
        "OperatingMechanism"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Bushing", "Bushing", "0..*", "0..1"),
        CIMRelationship ("OperatingMechanism", "OperatingMechanism", "0..1", "0..*")
    )
    val Bushing: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val OperatingMechanism: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): InterrupterUnit =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = InterrupterUnit (
            Asset.parse (context),
            masks (Bushing (), 0),
            mask (OperatingMechanism (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[InterrupterUnit] = InterrupterUnitSerializer
}

object InterrupterUnitSerializer extends CIMSerializer[InterrupterUnit]
{
    def write (kryo: Kryo, output: Output, obj: InterrupterUnit): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.Bushing, output),
            () => output.writeString (obj.OperatingMechanism)
        )
        AssetSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[InterrupterUnit]): InterrupterUnit =
    {
        val parent = AssetSerializer.read (kryo, input, classOf[Asset])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = InterrupterUnit (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Joint connects two or more cables.
 *
 * It includes the portion of cable under wipes, welds, or other seals.
 *
 * @param Asset [[ch.ninecode.model.Asset Asset]] Reference to the superclass object.
 * @param configurationKind Configuration of joint.
 * @param fillKind Material used to fill the joint.
 * @param insulation The type of insulation around the joint, classified according to the utility's asset management standards and practices.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class Joint
(
    Asset: Asset = null,
    configurationKind: String = null,
    fillKind: String = null,
    insulation: String = null
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
    override def sup: Asset = Asset

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
        implicit val clz: String = Joint.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Joint.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Joint.fields (position), value)
        emitattr (0, configurationKind)
        emitattr (1, fillKind)
        emitelem (2, insulation)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Joint rdf:ID=\"%s\">\n%s\t</cim:Joint>".format (id, export_fields)
    }
}

object Joint
extends
    CIMParseable[Joint]
{
    override val fields: Array[String] = Array[String] (
        "configurationKind",
        "fillKind",
        "insulation"
    )
    val configurationKind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val fillKind: Fielder = parse_attribute (attribute (cls, fields(1)))
    val insulation: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: CIMContext): Joint =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Joint (
            Asset.parse (context),
            mask (configurationKind (), 0),
            mask (fillKind (), 1),
            mask (insulation (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Joint] = JointSerializer
}

object JointSerializer extends CIMSerializer[Joint]
{
    def write (kryo: Kryo, output: Output, obj: Joint): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.configurationKind),
            () => output.writeString (obj.fillKind),
            () => output.writeString (obj.insulation)
        )
        AssetSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Joint]): Joint =
    {
        val parent = AssetSerializer.read (kryo, input, classOf[Asset])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Joint (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Results of testing done by a lab.
 *
 * @param ProcedureDataSet [[ch.ninecode.model.ProcedureDataSet ProcedureDataSet]] Reference to the superclass object.
 * @param conclusion Conclusion drawn from test results.
 * @param conclusionConfidence Description of confidence in conclusion.
 * @param reasonForTest Reason for performing test.
 * @param testEquipmentID Identity of lab equipment used to perform test.
 * @param AssetTestLab [[ch.ninecode.model.AssetTestLab AssetTestLab]] Test lab which produced this set of lab test results.
 * @param Specimen [[ch.ninecode.model.Specimen Specimen]] Specimen on which lab testing done in determining results.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class LabTestDataSet
(
    ProcedureDataSet: ProcedureDataSet = null,
    conclusion: String = null,
    conclusionConfidence: String = null,
    reasonForTest: String = null,
    testEquipmentID: String = null,
    AssetTestLab: String = null,
    Specimen: String = null
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
    override def sup: ProcedureDataSet = ProcedureDataSet

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
        implicit val clz: String = LabTestDataSet.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LabTestDataSet.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LabTestDataSet.fields (position), value)
        emitelem (0, conclusion)
        emitelem (1, conclusionConfidence)
        emitattr (2, reasonForTest)
        emitelem (3, testEquipmentID)
        emitattr (4, AssetTestLab)
        emitattr (5, Specimen)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LabTestDataSet rdf:ID=\"%s\">\n%s\t</cim:LabTestDataSet>".format (id, export_fields)
    }
}

object LabTestDataSet
extends
    CIMParseable[LabTestDataSet]
{
    override val fields: Array[String] = Array[String] (
        "conclusion",
        "conclusionConfidence",
        "reasonForTest",
        "testEquipmentID",
        "AssetTestLab",
        "Specimen"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AssetTestLab", "AssetTestLab", "0..1", "0..*"),
        CIMRelationship ("Specimen", "Specimen", "0..1", "0..*")
    )
    val conclusion: Fielder = parse_element (element (cls, fields(0)))
    val conclusionConfidence: Fielder = parse_element (element (cls, fields(1)))
    val reasonForTest: Fielder = parse_attribute (attribute (cls, fields(2)))
    val testEquipmentID: Fielder = parse_element (element (cls, fields(3)))
    val AssetTestLab: Fielder = parse_attribute (attribute (cls, fields(4)))
    val Specimen: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: CIMContext): LabTestDataSet =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = LabTestDataSet (
            ProcedureDataSet.parse (context),
            mask (conclusion (), 0),
            mask (conclusionConfidence (), 1),
            mask (reasonForTest (), 2),
            mask (testEquipmentID (), 3),
            mask (AssetTestLab (), 4),
            mask (Specimen (), 5)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[LabTestDataSet] = LabTestDataSetSerializer
}

object LabTestDataSetSerializer extends CIMSerializer[LabTestDataSet]
{
    def write (kryo: Kryo, output: Output, obj: LabTestDataSet): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.conclusion),
            () => output.writeString (obj.conclusionConfidence),
            () => output.writeString (obj.reasonForTest),
            () => output.writeString (obj.testEquipmentID),
            () => output.writeString (obj.AssetTestLab),
            () => output.writeString (obj.Specimen)
        )
        ProcedureDataSetSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[LabTestDataSet]): LabTestDataSet =
    {
        val parent = ProcedureDataSetSerializer.read (kryo, input, classOf[ProcedureDataSet])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = LabTestDataSet (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Standard published by Laborelec.
 *
 * @param Element Reference to the superclass object.
 * @param standardEdition Edition of Laborelec standard.
 * @param standardNumber Laborelec standard number.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class LaborelecStandard
(
    Element: BasicElement = null,
    standardEdition: String = null,
    standardNumber: String = null
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
        implicit val clz: String = LaborelecStandard.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LaborelecStandard.fields (position), value)
        emitattr (0, standardEdition)
        emitattr (1, standardNumber)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LaborelecStandard rdf:ID=\"%s\">\n%s\t</cim:LaborelecStandard>".format (id, export_fields)
    }
}

object LaborelecStandard
extends
    CIMParseable[LaborelecStandard]
{
    override val fields: Array[String] = Array[String] (
        "standardEdition",
        "standardNumber"
    )
    val standardEdition: Fielder = parse_attribute (attribute (cls, fields(0)))
    val standardNumber: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): LaborelecStandard =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = LaborelecStandard (
            BasicElement.parse (context),
            mask (standardEdition (), 0),
            mask (standardNumber (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[LaborelecStandard] = LaborelecStandardSerializer
}

object LaborelecStandardSerializer extends CIMSerializer[LaborelecStandard]
{
    def write (kryo: Kryo, output: Output, obj: LaborelecStandard): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.standardEdition),
            () => output.writeString (obj.standardNumber)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[LaborelecStandard]): LaborelecStandard =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = LaborelecStandard (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Dates for asset lifecycle state changes.
 *
 * May have multiple lifecycle dates for this device and a compound type allows a query to return multiple dates.
 *
 * @param Element Reference to the superclass object.
 * @param installationDate Date current installation was completed, which may not be the same as the in-service date.
 *        Asset may have been installed at other locations previously. Ignored if asset is (1) not currently installed (e.g., stored in a depot) or (2) not intended to be installed (e.g., vehicle, tool).
 * @param manufacturedDate Date the asset was manufactured.
 * @param purchaseDate Date the asset was purchased.
 *        Note that even though an asset may have been purchased, it may not have been received into inventory at the time of purchase.
 * @param receivedDate Date the asset was received and first placed into inventory.
 * @param removalDate Date when the asset was last removed from service.
 *        Ignored if (1) not intended to be in service, or (2) currently in service.
 * @param retiredDate Date the asset is permanently retired from service and may be scheduled for disposal.
 *        Ignored if asset is (1) currently in service, or (2) permanently removed from service.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class LifecycleDate
(
    Element: BasicElement = null,
    installationDate: String = null,
    manufacturedDate: String = null,
    purchaseDate: String = null,
    receivedDate: String = null,
    removalDate: String = null,
    retiredDate: String = null
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
        implicit val clz: String = LifecycleDate.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LifecycleDate.fields (position), value)
        emitelem (0, installationDate)
        emitelem (1, manufacturedDate)
        emitelem (2, purchaseDate)
        emitelem (3, receivedDate)
        emitelem (4, removalDate)
        emitelem (5, retiredDate)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LifecycleDate rdf:ID=\"%s\">\n%s\t</cim:LifecycleDate>".format (id, export_fields)
    }
}

object LifecycleDate
extends
    CIMParseable[LifecycleDate]
{
    override val fields: Array[String] = Array[String] (
        "installationDate",
        "manufacturedDate",
        "purchaseDate",
        "receivedDate",
        "removalDate",
        "retiredDate"
    )
    val installationDate: Fielder = parse_element (element (cls, fields(0)))
    val manufacturedDate: Fielder = parse_element (element (cls, fields(1)))
    val purchaseDate: Fielder = parse_element (element (cls, fields(2)))
    val receivedDate: Fielder = parse_element (element (cls, fields(3)))
    val removalDate: Fielder = parse_element (element (cls, fields(4)))
    val retiredDate: Fielder = parse_element (element (cls, fields(5)))

    def parse (context: CIMContext): LifecycleDate =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = LifecycleDate (
            BasicElement.parse (context),
            mask (installationDate (), 0),
            mask (manufacturedDate (), 1),
            mask (purchaseDate (), 2),
            mask (receivedDate (), 3),
            mask (removalDate (), 4),
            mask (retiredDate (), 5)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[LifecycleDate] = LifecycleDateSerializer
}

object LifecycleDateSerializer extends CIMSerializer[LifecycleDate]
{
    def write (kryo: Kryo, output: Output, obj: LifecycleDate): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.installationDate),
            () => output.writeString (obj.manufacturedDate),
            () => output.writeString (obj.purchaseDate),
            () => output.writeString (obj.receivedDate),
            () => output.writeString (obj.removalDate),
            () => output.writeString (obj.retiredDate)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[LifecycleDate]): LifecycleDate =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = LifecycleDate (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Organisation that maintains assets.
 *
 * @param AssetOrganisationRole [[ch.ninecode.model.AssetOrganisationRole AssetOrganisationRole]] Reference to the superclass object.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class Maintainer
(
    AssetOrganisationRole: AssetOrganisationRole = null
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
    override def sup: AssetOrganisationRole = AssetOrganisationRole

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
        "\t<cim:Maintainer rdf:ID=\"%s\">\n%s\t</cim:Maintainer>".format (id, export_fields)
    }
}

object Maintainer
extends
    CIMParseable[Maintainer]
{

    def parse (context: CIMContext): Maintainer =
    {
        val ret = Maintainer (
            AssetOrganisationRole.parse (context)
        )
        ret
    }

    def serializer: Serializer[Maintainer] = MaintainerSerializer
}

object MaintainerSerializer extends CIMSerializer[Maintainer]
{
    def write (kryo: Kryo, output: Output, obj: Maintainer): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        AssetOrganisationRoleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Maintainer]): Maintainer =
    {
        val parent = AssetOrganisationRoleSerializer.read (kryo, input, classOf[AssetOrganisationRole])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Maintainer (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The result of a maintenance activity, a type of Procedure, for a given attribute of an asset.
 *
 * @param ProcedureDataSet [[ch.ninecode.model.ProcedureDataSet ProcedureDataSet]] Reference to the superclass object.
 * @param conditionAfter Condition of asset just following maintenance procedure.
 * @param conditionBefore Description of the condition of the asset just prior to maintenance being performed.
 * @param maintCode Code for the type of maintenance performed.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class MaintenanceDataSet
(
    ProcedureDataSet: ProcedureDataSet = null,
    conditionAfter: String = null,
    conditionBefore: String = null,
    maintCode: String = null
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
    override def sup: ProcedureDataSet = ProcedureDataSet

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
        implicit val clz: String = MaintenanceDataSet.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MaintenanceDataSet.fields (position), value)
        emitelem (0, conditionAfter)
        emitelem (1, conditionBefore)
        emitelem (2, maintCode)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MaintenanceDataSet rdf:ID=\"%s\">\n%s\t</cim:MaintenanceDataSet>".format (id, export_fields)
    }
}

object MaintenanceDataSet
extends
    CIMParseable[MaintenanceDataSet]
{
    override val fields: Array[String] = Array[String] (
        "conditionAfter",
        "conditionBefore",
        "maintCode"
    )
    val conditionAfter: Fielder = parse_element (element (cls, fields(0)))
    val conditionBefore: Fielder = parse_element (element (cls, fields(1)))
    val maintCode: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: CIMContext): MaintenanceDataSet =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MaintenanceDataSet (
            ProcedureDataSet.parse (context),
            mask (conditionAfter (), 0),
            mask (conditionBefore (), 1),
            mask (maintCode (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MaintenanceDataSet] = MaintenanceDataSetSerializer
}

object MaintenanceDataSetSerializer extends CIMSerializer[MaintenanceDataSet]
{
    def write (kryo: Kryo, output: Output, obj: MaintenanceDataSet): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.conditionAfter),
            () => output.writeString (obj.conditionBefore),
            () => output.writeString (obj.maintCode)
        )
        ProcedureDataSetSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MaintenanceDataSet]): MaintenanceDataSet =
    {
        val parent = ProcedureDataSetSerializer.read (kryo, input, classOf[ProcedureDataSet])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MaintenanceDataSet (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Organisation that manufactures asset products.
 *
 * @param OrganisationRole [[ch.ninecode.model.OrganisationRole OrganisationRole]] Reference to the superclass object.
 * @param ProductAssetModels [[ch.ninecode.model.ProductAssetModel ProductAssetModel]] All asset models by this manufacturer.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class Manufacturer
(
    OrganisationRole: OrganisationRole = null,
    ProductAssetModels: List[String] = null
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
        implicit val clz: String = Manufacturer.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Manufacturer.fields (position), x))
        emitattrs (0, ProductAssetModels)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Manufacturer rdf:ID=\"%s\">\n%s\t</cim:Manufacturer>".format (id, export_fields)
    }
}

object Manufacturer
extends
    CIMParseable[Manufacturer]
{
    override val fields: Array[String] = Array[String] (
        "ProductAssetModels"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ProductAssetModels", "ProductAssetModel", "0..*", "0..1")
    )
    val ProductAssetModels: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): Manufacturer =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Manufacturer (
            OrganisationRole.parse (context),
            masks (ProductAssetModels (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Manufacturer] = ManufacturerSerializer
}

object ManufacturerSerializer extends CIMSerializer[Manufacturer]
{
    def write (kryo: Kryo, output: Output, obj: Manufacturer): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.ProductAssetModels, output)
        )
        OrganisationRoleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Manufacturer]): Manufacturer =
    {
        val parent = OrganisationRoleSerializer.read (kryo, input, classOf[OrganisationRole])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Manufacturer (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A substance that either (1) provides the means of transmission of a force or effect, such as hydraulic fluid, or (2) is used for a surrounding or enveloping substance, such as oil in a transformer or circuit breaker.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param kind Kind of this medium.
 * @param volumeSpec The volume of the medium specified for this application.
 *        Note that the actual volume is a type of measurement associated witht the asset.
 * @param Asset [[ch.ninecode.model.Asset Asset]] Medium with which this asset is filled.
 * @param Specification [[ch.ninecode.model.Specification Specification]] <em>undocumented</em>
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class Medium
(
    IdentifiedObject: IdentifiedObject = null,
    kind: String = null,
    volumeSpec: Double = 0.0,
    Asset: List[String] = null,
    Specification: String = null
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
        implicit val clz: String = Medium.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Medium.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Medium.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Medium.fields (position), x))
        emitattr (0, kind)
        emitelem (1, volumeSpec)
        emitattrs (2, Asset)
        emitattr (3, Specification)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Medium rdf:ID=\"%s\">\n%s\t</cim:Medium>".format (id, export_fields)
    }
}

object Medium
extends
    CIMParseable[Medium]
{
    override val fields: Array[String] = Array[String] (
        "kind",
        "volumeSpec",
        "Asset",
        "Specification"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Asset", "Asset", "0..*", "0..*"),
        CIMRelationship ("Specification", "Specification", "0..1", "0..*")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val volumeSpec: Fielder = parse_element (element (cls, fields(1)))
    val Asset: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Specification: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): Medium =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Medium (
            IdentifiedObject.parse (context),
            mask (kind (), 0),
            toDouble (mask (volumeSpec (), 1)),
            masks (Asset (), 2),
            mask (Specification (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Medium] = MediumSerializer
}

object MediumSerializer extends CIMSerializer[Medium]
{
    def write (kryo: Kryo, output: Output, obj: Medium): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.kind),
            () => output.writeDouble (obj.volumeSpec),
            () => writeList (obj.Asset, output),
            () => output.writeString (obj.Specification)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Medium]): Medium =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Medium (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class OilSpecimen
(
    Specimen: Specimen = null,
    oilSampleTakenFrom: String = null,
    oilSampleTemperature: Double = 0.0,
    oilTemperatureSource: String = null,
    sampleContainer: String = null
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
    override def sup: Specimen = Specimen

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
        implicit val clz: String = OilSpecimen.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OilSpecimen.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OilSpecimen.fields (position), value)
        emitattr (0, oilSampleTakenFrom)
        emitelem (1, oilSampleTemperature)
        emitattr (2, oilTemperatureSource)
        emitattr (3, sampleContainer)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OilSpecimen rdf:ID=\"%s\">\n%s\t</cim:OilSpecimen>".format (id, export_fields)
    }
}

object OilSpecimen
extends
    CIMParseable[OilSpecimen]
{
    override val fields: Array[String] = Array[String] (
        "oilSampleTakenFrom",
        "oilSampleTemperature",
        "oilTemperatureSource",
        "sampleContainer"
    )
    val oilSampleTakenFrom: Fielder = parse_attribute (attribute (cls, fields(0)))
    val oilSampleTemperature: Fielder = parse_element (element (cls, fields(1)))
    val oilTemperatureSource: Fielder = parse_attribute (attribute (cls, fields(2)))
    val sampleContainer: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): OilSpecimen =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OilSpecimen (
            Specimen.parse (context),
            mask (oilSampleTakenFrom (), 0),
            toDouble (mask (oilSampleTemperature (), 1)),
            mask (oilTemperatureSource (), 2),
            mask (sampleContainer (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OilSpecimen] = OilSpecimenSerializer
}

object OilSpecimenSerializer extends CIMSerializer[OilSpecimen]
{
    def write (kryo: Kryo, output: Output, obj: OilSpecimen): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.oilSampleTakenFrom),
            () => output.writeDouble (obj.oilSampleTemperature),
            () => output.writeString (obj.oilTemperatureSource),
            () => output.writeString (obj.sampleContainer)
        )
        SpecimenSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OilSpecimen]): OilSpecimen =
    {
        val parent = SpecimenSerializer.read (kryo, input, classOf[Specimen])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OilSpecimen (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Breaker mechanism.
 *
 * @param Asset [[ch.ninecode.model.Asset Asset]] Reference to the superclass object.
 * @param InterrupterUnit [[ch.ninecode.model.InterrupterUnit InterrupterUnit]] Interrupter controlled by this mechanism.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class OperatingMechanism
(
    Asset: Asset = null,
    InterrupterUnit: List[String] = null
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
    override def sup: Asset = Asset

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
        implicit val clz: String = OperatingMechanism.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (OperatingMechanism.fields (position), x))
        emitattrs (0, InterrupterUnit)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OperatingMechanism rdf:ID=\"%s\">\n%s\t</cim:OperatingMechanism>".format (id, export_fields)
    }
}

object OperatingMechanism
extends
    CIMParseable[OperatingMechanism]
{
    override val fields: Array[String] = Array[String] (
        "InterrupterUnit"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("InterrupterUnit", "InterrupterUnit", "0..*", "0..1")
    )
    val InterrupterUnit: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): OperatingMechanism =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OperatingMechanism (
            Asset.parse (context),
            masks (InterrupterUnit (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OperatingMechanism] = OperatingMechanismSerializer
}

object OperatingMechanismSerializer extends CIMSerializer[OperatingMechanism]
{
    def write (kryo: Kryo, output: Output, obj: OperatingMechanism): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.InterrupterUnit, output)
        )
        AssetSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OperatingMechanism]): OperatingMechanism =
    {
        val parent = AssetSerializer.read (kryo, input, classOf[Asset])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OperatingMechanism (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Documented procedure for various types of work or work tasks on assets.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param instruction Textual description of this procedure.
 * @param kind Kind of procedure.
 * @param sequenceNumber Sequence number in a sequence of procedures being performed.
 * @param Assets [[ch.ninecode.model.Asset Asset]] All assets to which this procedure applies.
 * @param CompatibleUnits [[ch.ninecode.model.CompatibleUnit CompatibleUnit]] <em>undocumented</em>
 * @param Limits [[ch.ninecode.model.Limit Limit]] <em>undocumented</em>
 * @param Measurements [[ch.ninecode.model.Measurement Measurement]] Document containing this measurement.
 * @param ProcedureDataSets [[ch.ninecode.model.ProcedureDataSet ProcedureDataSet]] All data sets captured by this procedure.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class Procedure
(
    Document: Document = null,
    instruction: String = null,
    kind: String = null,
    sequenceNumber: String = null,
    Assets: List[String] = null,
    CompatibleUnits: List[String] = null,
    Limits: List[String] = null,
    Measurements: List[String] = null,
    ProcedureDataSets: List[String] = null
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
    override def sup: Document = Document

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
        implicit val clz: String = Procedure.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Procedure.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Procedure.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Procedure.fields (position), x))
        emitelem (0, instruction)
        emitattr (1, kind)
        emitelem (2, sequenceNumber)
        emitattrs (3, Assets)
        emitattrs (4, CompatibleUnits)
        emitattrs (5, Limits)
        emitattrs (6, Measurements)
        emitattrs (7, ProcedureDataSets)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Procedure rdf:ID=\"%s\">\n%s\t</cim:Procedure>".format (id, export_fields)
    }
}

object Procedure
extends
    CIMParseable[Procedure]
{
    override val fields: Array[String] = Array[String] (
        "instruction",
        "kind",
        "sequenceNumber",
        "Assets",
        "CompatibleUnits",
        "Limits",
        "Measurements",
        "ProcedureDataSets"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Assets", "Asset", "0..*", "0..*"),
        CIMRelationship ("CompatibleUnits", "CompatibleUnit", "0..*", "0..*"),
        CIMRelationship ("Limits", "Limit", "0..*", "0..*"),
        CIMRelationship ("Measurements", "Measurement", "0..*", "0..*"),
        CIMRelationship ("ProcedureDataSets", "ProcedureDataSet", "0..*", "0..1")
    )
    val instruction: Fielder = parse_element (element (cls, fields(0)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(1)))
    val sequenceNumber: Fielder = parse_element (element (cls, fields(2)))
    val Assets: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val CompatibleUnits: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val Limits: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val Measurements: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val ProcedureDataSets: FielderMultiple = parse_attributes (attribute (cls, fields(7)))

    def parse (context: CIMContext): Procedure =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Procedure (
            Document.parse (context),
            mask (instruction (), 0),
            mask (kind (), 1),
            mask (sequenceNumber (), 2),
            masks (Assets (), 3),
            masks (CompatibleUnits (), 4),
            masks (Limits (), 5),
            masks (Measurements (), 6),
            masks (ProcedureDataSets (), 7)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Procedure] = ProcedureSerializer
}

object ProcedureSerializer extends CIMSerializer[Procedure]
{
    def write (kryo: Kryo, output: Output, obj: Procedure): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.instruction),
            () => output.writeString (obj.kind),
            () => output.writeString (obj.sequenceNumber),
            () => writeList (obj.Assets, output),
            () => writeList (obj.CompatibleUnits, output),
            () => writeList (obj.Limits, output),
            () => writeList (obj.Measurements, output),
            () => writeList (obj.ProcedureDataSets, output)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Procedure]): Procedure =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Procedure (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) readList (input) else null,
            if (isSet (7)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A data set recorded each time a procedure is executed.
 *
 * Observed results are captured in associated measurement values and/or values for properties relevant to the type of procedure performed.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param completedDateTime Date and time procedure was completed.
 * @param Asset [[ch.ninecode.model.Asset Asset]] Asset to which this procedure data set applies.
 * @param MeasurementValue [[ch.ninecode.model.MeasurementValue MeasurementValue]] <em>undocumented</em>
 * @param Procedure [[ch.ninecode.model.Procedure Procedure]] Procedure capturing this data set.
 * @param Properties [[ch.ninecode.model.UserAttribute UserAttribute]] UserAttributes used to specify further properties of this procedure data set.
 *        Use 'name' to specify what kind of property it is, and 'value.value' attribute for the actual value.
 * @param TransformerObservations [[ch.ninecode.model.TransformerObservation TransformerObservation]] <em>undocumented</em>
 * @param WorkTask [[ch.ninecode.model.WorkTask WorkTask]] Work task that created this procedure data set.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class ProcedureDataSet
(
    Document: Document = null,
    completedDateTime: String = null,
    Asset: String = null,
    MeasurementValue: List[String] = null,
    Procedure: String = null,
    Properties: List[String] = null,
    TransformerObservations: List[String] = null,
    WorkTask: String = null
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
    override def sup: Document = Document

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
        implicit val clz: String = ProcedureDataSet.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ProcedureDataSet.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ProcedureDataSet.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ProcedureDataSet.fields (position), x))
        emitelem (0, completedDateTime)
        emitattr (1, Asset)
        emitattrs (2, MeasurementValue)
        emitattr (3, Procedure)
        emitattrs (4, Properties)
        emitattrs (5, TransformerObservations)
        emitattr (6, WorkTask)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ProcedureDataSet rdf:ID=\"%s\">\n%s\t</cim:ProcedureDataSet>".format (id, export_fields)
    }
}

object ProcedureDataSet
extends
    CIMParseable[ProcedureDataSet]
{
    override val fields: Array[String] = Array[String] (
        "completedDateTime",
        "Asset",
        "MeasurementValue",
        "Procedure",
        "Properties",
        "TransformerObservations",
        "WorkTask"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Asset", "Asset", "0..1", "0..*"),
        CIMRelationship ("MeasurementValue", "MeasurementValue", "0..*", "0..*"),
        CIMRelationship ("Procedure", "Procedure", "0..1", "0..*"),
        CIMRelationship ("Properties", "UserAttribute", "0..*", "0..*"),
        CIMRelationship ("TransformerObservations", "TransformerObservation", "0..*", "0..*"),
        CIMRelationship ("WorkTask", "WorkTask", "0..1", "0..*")
    )
    val completedDateTime: Fielder = parse_element (element (cls, fields(0)))
    val Asset: Fielder = parse_attribute (attribute (cls, fields(1)))
    val MeasurementValue: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Procedure: Fielder = parse_attribute (attribute (cls, fields(3)))
    val Properties: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val TransformerObservations: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val WorkTask: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: CIMContext): ProcedureDataSet =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ProcedureDataSet (
            Document.parse (context),
            mask (completedDateTime (), 0),
            mask (Asset (), 1),
            masks (MeasurementValue (), 2),
            mask (Procedure (), 3),
            masks (Properties (), 4),
            masks (TransformerObservations (), 5),
            mask (WorkTask (), 6)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ProcedureDataSet] = ProcedureDataSetSerializer
}

object ProcedureDataSetSerializer extends CIMSerializer[ProcedureDataSet]
{
    def write (kryo: Kryo, output: Output, obj: ProcedureDataSet): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.completedDateTime),
            () => output.writeString (obj.Asset),
            () => writeList (obj.MeasurementValue, output),
            () => output.writeString (obj.Procedure),
            () => writeList (obj.Properties, output),
            () => writeList (obj.TransformerObservations, output),
            () => output.writeString (obj.WorkTask)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ProcedureDataSet]): ProcedureDataSet =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ProcedureDataSet (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Asset model by a specific manufacturer.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param catalogueNumber Catalogue number for asset model.
 * @param corporateStandardKind Kind of corporate standard for this asset model.
 * @param drawingNumber Drawing number for asset model.
 * @param instructionManual Reference manual or instruction book for this asset model.
 * @param modelNumber Manufacturer's model number.
 * @param modelVersion Version number for product model, which indicates vintage of the product.
 * @param overallLength Overall length of this asset model.
 * @param styleNumber Style number of asset model.
 * @param usageKind Intended usage for this asset model.
 * @param weightTotal Total manufactured weight of asset.
 * @param Asset [[ch.ninecode.model.Asset Asset]] An asset of this model.
 * @param AssetInfo [[ch.ninecode.model.AssetInfo AssetInfo]] Asset information (nameplate) for this product asset model.
 * @param AssetModelCatalogueItems [[ch.ninecode.model.AssetModelCatalogueItem AssetModelCatalogueItem]] <em>undocumented</em>
 * @param CatalogAssetType [[ch.ninecode.model.CatalogAssetType CatalogAssetType]] Catalog asset type to which this product asset model conforms.
 * @param Manufacturer [[ch.ninecode.model.Manufacturer Manufacturer]] Manufacturer of this asset model.
 * @param OperationalRestrictions [[ch.ninecode.model.OperationalRestriction OperationalRestriction]] All operational restrictions applying to this asset model.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class ProductAssetModel
(
    IdentifiedObject: IdentifiedObject = null,
    catalogueNumber: String = null,
    corporateStandardKind: String = null,
    drawingNumber: String = null,
    instructionManual: String = null,
    modelNumber: String = null,
    modelVersion: String = null,
    overallLength: Double = 0.0,
    styleNumber: String = null,
    usageKind: String = null,
    weightTotal: Double = 0.0,
    Asset: List[String] = null,
    AssetInfo: String = null,
    AssetModelCatalogueItems: List[String] = null,
    CatalogAssetType: String = null,
    Manufacturer: String = null,
    OperationalRestrictions: List[String] = null
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
        implicit val clz: String = ProductAssetModel.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ProductAssetModel.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ProductAssetModel.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ProductAssetModel.fields (position), x))
        emitelem (0, catalogueNumber)
        emitattr (1, corporateStandardKind)
        emitelem (2, drawingNumber)
        emitelem (3, instructionManual)
        emitelem (4, modelNumber)
        emitelem (5, modelVersion)
        emitelem (6, overallLength)
        emitelem (7, styleNumber)
        emitattr (8, usageKind)
        emitelem (9, weightTotal)
        emitattrs (10, Asset)
        emitattr (11, AssetInfo)
        emitattrs (12, AssetModelCatalogueItems)
        emitattr (13, CatalogAssetType)
        emitattr (14, Manufacturer)
        emitattrs (15, OperationalRestrictions)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ProductAssetModel rdf:ID=\"%s\">\n%s\t</cim:ProductAssetModel>".format (id, export_fields)
    }
}

object ProductAssetModel
extends
    CIMParseable[ProductAssetModel]
{
    override val fields: Array[String] = Array[String] (
        "catalogueNumber",
        "corporateStandardKind",
        "drawingNumber",
        "instructionManual",
        "modelNumber",
        "modelVersion",
        "overallLength",
        "styleNumber",
        "usageKind",
        "weightTotal",
        "Asset",
        "AssetInfo",
        "AssetModelCatalogueItems",
        "CatalogAssetType",
        "Manufacturer",
        "OperationalRestrictions"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Asset", "Asset", "0..*", "0..1"),
        CIMRelationship ("AssetInfo", "AssetInfo", "0..1", "0..1"),
        CIMRelationship ("AssetModelCatalogueItems", "AssetModelCatalogueItem", "0..*", "0..1"),
        CIMRelationship ("CatalogAssetType", "CatalogAssetType", "0..1", "0..*"),
        CIMRelationship ("Manufacturer", "Manufacturer", "0..1", "0..*"),
        CIMRelationship ("OperationalRestrictions", "OperationalRestriction", "0..*", "0..1")
    )
    val catalogueNumber: Fielder = parse_element (element (cls, fields(0)))
    val corporateStandardKind: Fielder = parse_attribute (attribute (cls, fields(1)))
    val drawingNumber: Fielder = parse_element (element (cls, fields(2)))
    val instructionManual: Fielder = parse_element (element (cls, fields(3)))
    val modelNumber: Fielder = parse_element (element (cls, fields(4)))
    val modelVersion: Fielder = parse_element (element (cls, fields(5)))
    val overallLength: Fielder = parse_element (element (cls, fields(6)))
    val styleNumber: Fielder = parse_element (element (cls, fields(7)))
    val usageKind: Fielder = parse_attribute (attribute (cls, fields(8)))
    val weightTotal: Fielder = parse_element (element (cls, fields(9)))
    val Asset: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val AssetInfo: Fielder = parse_attribute (attribute (cls, fields(11)))
    val AssetModelCatalogueItems: FielderMultiple = parse_attributes (attribute (cls, fields(12)))
    val CatalogAssetType: Fielder = parse_attribute (attribute (cls, fields(13)))
    val Manufacturer: Fielder = parse_attribute (attribute (cls, fields(14)))
    val OperationalRestrictions: FielderMultiple = parse_attributes (attribute (cls, fields(15)))

    def parse (context: CIMContext): ProductAssetModel =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ProductAssetModel (
            IdentifiedObject.parse (context),
            mask (catalogueNumber (), 0),
            mask (corporateStandardKind (), 1),
            mask (drawingNumber (), 2),
            mask (instructionManual (), 3),
            mask (modelNumber (), 4),
            mask (modelVersion (), 5),
            toDouble (mask (overallLength (), 6)),
            mask (styleNumber (), 7),
            mask (usageKind (), 8),
            toDouble (mask (weightTotal (), 9)),
            masks (Asset (), 10),
            mask (AssetInfo (), 11),
            masks (AssetModelCatalogueItems (), 12),
            mask (CatalogAssetType (), 13),
            mask (Manufacturer (), 14),
            masks (OperationalRestrictions (), 15)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ProductAssetModel] = ProductAssetModelSerializer
}

object ProductAssetModelSerializer extends CIMSerializer[ProductAssetModel]
{
    def write (kryo: Kryo, output: Output, obj: ProductAssetModel): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.catalogueNumber),
            () => output.writeString (obj.corporateStandardKind),
            () => output.writeString (obj.drawingNumber),
            () => output.writeString (obj.instructionManual),
            () => output.writeString (obj.modelNumber),
            () => output.writeString (obj.modelVersion),
            () => output.writeDouble (obj.overallLength),
            () => output.writeString (obj.styleNumber),
            () => output.writeString (obj.usageKind),
            () => output.writeDouble (obj.weightTotal),
            () => writeList (obj.Asset, output),
            () => output.writeString (obj.AssetInfo),
            () => writeList (obj.AssetModelCatalogueItems, output),
            () => output.writeString (obj.CatalogAssetType),
            () => output.writeString (obj.Manufacturer),
            () => writeList (obj.OperationalRestrictions, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ProductAssetModel]): ProductAssetModel =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ProductAssetModel (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readDouble else 0.0,
            if (isSet (10)) readList (input) else null,
            if (isSet (11)) input.readString else null,
            if (isSet (12)) readList (input) else null,
            if (isSet (13)) input.readString else null,
            if (isSet (14)) input.readString else null,
            if (isSet (15)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Score that is indicative of the risk associated with one or more assets.
 *
 * @param AggregateScore [[ch.ninecode.model.AggregateScore AggregateScore]] Reference to the superclass object.
 * @param kind The risk kind, such as CustomerRisk, FinancialRisk, SafetyRisk, etc.
 * @param AssetHealthScore [[ch.ninecode.model.HealthScore HealthScore]] Individual health score associated with this risk score.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class RiskScore
(
    AggregateScore: AggregateScore = null,
    kind: String = null,
    AssetHealthScore: List[String] = null
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
    override def sup: AggregateScore = AggregateScore

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
        implicit val clz: String = RiskScore.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RiskScore.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (RiskScore.fields (position), x))
        emitattr (0, kind)
        emitattrs (1, AssetHealthScore)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RiskScore rdf:ID=\"%s\">\n%s\t</cim:RiskScore>".format (id, export_fields)
    }
}

object RiskScore
extends
    CIMParseable[RiskScore]
{
    override val fields: Array[String] = Array[String] (
        "kind",
        "AssetHealthScore"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AssetHealthScore", "HealthScore", "0..*", "0..1")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val AssetHealthScore: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): RiskScore =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RiskScore (
            AggregateScore.parse (context),
            mask (kind (), 0),
            masks (AssetHealthScore (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[RiskScore] = RiskScoreSerializer
}

object RiskScoreSerializer extends CIMSerializer[RiskScore]
{
    def write (kryo: Kryo, output: Output, obj: RiskScore): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.kind),
            () => writeList (obj.AssetHealthScore, output)
        )
        AggregateScoreSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RiskScore]): RiskScore =
    {
        val parent = AggregateScoreSerializer.read (kryo, input, classOf[AggregateScore])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = RiskScore (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Physically controls access to AssetContainers.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param appliedDateTime Date and time this seal has been applied.
 * @param condition Condition of seal.
 * @param kind Kind of seal.
 * @param sealNumber (reserved word) Seal number.
 * @param AssetContainer [[ch.ninecode.model.AssetContainer AssetContainer]] Asset container to which this seal is applied.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class Seal
(
    IdentifiedObject: IdentifiedObject = null,
    appliedDateTime: String = null,
    condition: String = null,
    kind: String = null,
    sealNumber: String = null,
    AssetContainer: String = null
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
        implicit val clz: String = Seal.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Seal.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Seal.fields (position), value)
        emitelem (0, appliedDateTime)
        emitattr (1, condition)
        emitattr (2, kind)
        emitelem (3, sealNumber)
        emitattr (4, AssetContainer)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Seal rdf:ID=\"%s\">\n%s\t</cim:Seal>".format (id, export_fields)
    }
}

object Seal
extends
    CIMParseable[Seal]
{
    override val fields: Array[String] = Array[String] (
        "appliedDateTime",
        "condition",
        "kind",
        "sealNumber",
        "AssetContainer"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AssetContainer", "AssetContainer", "0..1", "0..*")
    )
    val appliedDateTime: Fielder = parse_element (element (cls, fields(0)))
    val condition: Fielder = parse_attribute (attribute (cls, fields(1)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(2)))
    val sealNumber: Fielder = parse_element (element (cls, fields(3)))
    val AssetContainer: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: CIMContext): Seal =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Seal (
            IdentifiedObject.parse (context),
            mask (appliedDateTime (), 0),
            mask (condition (), 1),
            mask (kind (), 2),
            mask (sealNumber (), 3),
            mask (AssetContainer (), 4)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Seal] = SealSerializer
}

object SealSerializer extends CIMSerializer[Seal]
{
    def write (kryo: Kryo, output: Output, obj: Seal): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.appliedDateTime),
            () => output.writeString (obj.condition),
            () => output.writeString (obj.kind),
            () => output.writeString (obj.sealNumber),
            () => output.writeString (obj.AssetContainer)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Seal]): Seal =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Seal (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Sample or specimen of a material (fluid or solid).
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ambientTemperatureAtSampling Operating ambient temperature (in °C).
 * @param humidityAtSampling Operating ambient humidity (in percent).
 * @param specimenID Identifier of specimen used in inspection or test.
 * @param specimenSampleDateTime Date and time sample specimen taken.
 * @param specimenToLabDateTime Date and time the specimen was received by the lab.
 * @param AssetTestSampleTaker [[ch.ninecode.model.AssetTestSampleTaker AssetTestSampleTaker]] Test sampler taker who gathered this specimen.
 * @param LabTestDataSet [[ch.ninecode.model.LabTestDataSet LabTestDataSet]] Results from lab testing done on specimen.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class Specimen
(
    IdentifiedObject: IdentifiedObject = null,
    ambientTemperatureAtSampling: Double = 0.0,
    humidityAtSampling: Double = 0.0,
    specimenID: String = null,
    specimenSampleDateTime: String = null,
    specimenToLabDateTime: String = null,
    AssetTestSampleTaker: String = null,
    LabTestDataSet: List[String] = null
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
        implicit val clz: String = Specimen.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Specimen.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Specimen.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Specimen.fields (position), x))
        emitelem (0, ambientTemperatureAtSampling)
        emitelem (1, humidityAtSampling)
        emitelem (2, specimenID)
        emitelem (3, specimenSampleDateTime)
        emitelem (4, specimenToLabDateTime)
        emitattr (5, AssetTestSampleTaker)
        emitattrs (6, LabTestDataSet)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Specimen rdf:ID=\"%s\">\n%s\t</cim:Specimen>".format (id, export_fields)
    }
}

object Specimen
extends
    CIMParseable[Specimen]
{
    override val fields: Array[String] = Array[String] (
        "ambientTemperatureAtSampling",
        "humidityAtSampling",
        "specimenID",
        "specimenSampleDateTime",
        "specimenToLabDateTime",
        "AssetTestSampleTaker",
        "LabTestDataSet"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AssetTestSampleTaker", "AssetTestSampleTaker", "0..1", "0..*"),
        CIMRelationship ("LabTestDataSet", "LabTestDataSet", "0..*", "0..1")
    )
    val ambientTemperatureAtSampling: Fielder = parse_element (element (cls, fields(0)))
    val humidityAtSampling: Fielder = parse_element (element (cls, fields(1)))
    val specimenID: Fielder = parse_element (element (cls, fields(2)))
    val specimenSampleDateTime: Fielder = parse_element (element (cls, fields(3)))
    val specimenToLabDateTime: Fielder = parse_element (element (cls, fields(4)))
    val AssetTestSampleTaker: Fielder = parse_attribute (attribute (cls, fields(5)))
    val LabTestDataSet: FielderMultiple = parse_attributes (attribute (cls, fields(6)))

    def parse (context: CIMContext): Specimen =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Specimen (
            IdentifiedObject.parse (context),
            toDouble (mask (ambientTemperatureAtSampling (), 0)),
            toDouble (mask (humidityAtSampling (), 1)),
            mask (specimenID (), 2),
            mask (specimenSampleDateTime (), 3),
            mask (specimenToLabDateTime (), 4),
            mask (AssetTestSampleTaker (), 5),
            masks (LabTestDataSet (), 6)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Specimen] = SpecimenSerializer
}

object SpecimenSerializer extends CIMSerializer[Specimen]
{
    def write (kryo: Kryo, output: Output, obj: Specimen): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.ambientTemperatureAtSampling),
            () => output.writeDouble (obj.humidityAtSampling),
            () => output.writeString (obj.specimenID),
            () => output.writeString (obj.specimenSampleDateTime),
            () => output.writeString (obj.specimenToLabDateTime),
            () => output.writeString (obj.AssetTestSampleTaker),
            () => writeList (obj.LabTestDataSet, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Specimen]): Specimen =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Specimen (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
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
 * Streetlight asset.
 *
 * @param Asset [[ch.ninecode.model.Asset Asset]] Reference to the superclass object.
 * @param armLength Length of arm.
 *        Note that a new light may be placed on an existing arm.
 * @param lampKind Lamp kind.
 * @param lightRating Power rating of light.
 * @param Pole [[ch.ninecode.model.Pole Pole]] Pole to which thiss streetlight is attached.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class Streetlight
(
    Asset: Asset = null,
    armLength: Double = 0.0,
    lampKind: String = null,
    lightRating: Double = 0.0,
    Pole: String = null
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
    override def sup: Asset = Asset

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
        implicit val clz: String = Streetlight.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Streetlight.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Streetlight.fields (position), value)
        emitelem (0, armLength)
        emitattr (1, lampKind)
        emitelem (2, lightRating)
        emitattr (3, Pole)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Streetlight rdf:ID=\"%s\">\n%s\t</cim:Streetlight>".format (id, export_fields)
    }
}

object Streetlight
extends
    CIMParseable[Streetlight]
{
    override val fields: Array[String] = Array[String] (
        "armLength",
        "lampKind",
        "lightRating",
        "Pole"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Pole", "Pole", "0..1", "0..*")
    )
    val armLength: Fielder = parse_element (element (cls, fields(0)))
    val lampKind: Fielder = parse_attribute (attribute (cls, fields(1)))
    val lightRating: Fielder = parse_element (element (cls, fields(2)))
    val Pole: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): Streetlight =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Streetlight (
            Asset.parse (context),
            toDouble (mask (armLength (), 0)),
            mask (lampKind (), 1),
            toDouble (mask (lightRating (), 2)),
            mask (Pole (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Streetlight] = StreetlightSerializer
}

object StreetlightSerializer extends CIMSerializer[Streetlight]
{
    def write (kryo: Kryo, output: Output, obj: Streetlight): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.armLength),
            () => output.writeString (obj.lampKind),
            () => output.writeDouble (obj.lightRating),
            () => output.writeString (obj.Pole)
        )
        AssetSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Streetlight]): Streetlight =
    {
        val parent = AssetSerializer.read (kryo, input, classOf[Asset])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Streetlight (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Construction holding assets such as conductors, transformers, switchgear, etc.
 *
 * Where applicable, number of conductors can be derived from the number of associated wire spacing instances.
 *
 * @param AssetContainer [[ch.ninecode.model.AssetContainer AssetContainer]] Reference to the superclass object.
 * @param fumigantAppliedDate Date fumigant was last applied.
 * @param fumigantName Name of fumigant.
 * @param height Visible height of structure above ground level for overhead construction (e.g., Pole or Tower) or below ground level for an underground vault, manhole, etc.
 *        Refer to associated DimensionPropertiesInfo for other types of dimensions.
 * @param materialKind Material this structure is made of.
 * @param ratedVoltage Maximum rated voltage of the equipment that can be mounted on/contained within the structure.
 * @param removeWeed True if weeds are to be removed around asset.
 * @param weedRemovedDate Date weed were last removed.
 * @param StructureSupports [[ch.ninecode.model.StructureSupport StructureSupport]] Structure support for this structure.
 * @param WireSpacingInfos [[ch.ninecode.model.WireSpacing WireSpacing]] <em>undocumented</em>
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class Structure
(
    AssetContainer: AssetContainer = null,
    fumigantAppliedDate: String = null,
    fumigantName: String = null,
    height: Double = 0.0,
    materialKind: String = null,
    ratedVoltage: Double = 0.0,
    removeWeed: Boolean = false,
    weedRemovedDate: String = null,
    StructureSupports: List[String] = null,
    WireSpacingInfos: List[String] = null
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
    override def sup: AssetContainer = AssetContainer

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
        implicit val clz: String = Structure.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Structure.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Structure.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Structure.fields (position), x))
        emitelem (0, fumigantAppliedDate)
        emitelem (1, fumigantName)
        emitelem (2, height)
        emitattr (3, materialKind)
        emitelem (4, ratedVoltage)
        emitelem (5, removeWeed)
        emitelem (6, weedRemovedDate)
        emitattrs (7, StructureSupports)
        emitattrs (8, WireSpacingInfos)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Structure rdf:ID=\"%s\">\n%s\t</cim:Structure>".format (id, export_fields)
    }
}

object Structure
extends
    CIMParseable[Structure]
{
    override val fields: Array[String] = Array[String] (
        "fumigantAppliedDate",
        "fumigantName",
        "height",
        "materialKind",
        "ratedVoltage",
        "removeWeed",
        "weedRemovedDate",
        "StructureSupports",
        "WireSpacingInfos"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("StructureSupports", "StructureSupport", "0..*", "0..1"),
        CIMRelationship ("WireSpacingInfos", "WireSpacing", "0..*", "0..*")
    )
    val fumigantAppliedDate: Fielder = parse_element (element (cls, fields(0)))
    val fumigantName: Fielder = parse_element (element (cls, fields(1)))
    val height: Fielder = parse_element (element (cls, fields(2)))
    val materialKind: Fielder = parse_attribute (attribute (cls, fields(3)))
    val ratedVoltage: Fielder = parse_element (element (cls, fields(4)))
    val removeWeed: Fielder = parse_element (element (cls, fields(5)))
    val weedRemovedDate: Fielder = parse_element (element (cls, fields(6)))
    val StructureSupports: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val WireSpacingInfos: FielderMultiple = parse_attributes (attribute (cls, fields(8)))

    def parse (context: CIMContext): Structure =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Structure (
            AssetContainer.parse (context),
            mask (fumigantAppliedDate (), 0),
            mask (fumigantName (), 1),
            toDouble (mask (height (), 2)),
            mask (materialKind (), 3),
            toDouble (mask (ratedVoltage (), 4)),
            toBoolean (mask (removeWeed (), 5)),
            mask (weedRemovedDate (), 6),
            masks (StructureSupports (), 7),
            masks (WireSpacingInfos (), 8)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Structure] = StructureSerializer
}

object StructureSerializer extends CIMSerializer[Structure]
{
    def write (kryo: Kryo, output: Output, obj: Structure): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.fumigantAppliedDate),
            () => output.writeString (obj.fumigantName),
            () => output.writeDouble (obj.height),
            () => output.writeString (obj.materialKind),
            () => output.writeDouble (obj.ratedVoltage),
            () => output.writeBoolean (obj.removeWeed),
            () => output.writeString (obj.weedRemovedDate),
            () => writeList (obj.StructureSupports, output),
            () => writeList (obj.WireSpacingInfos, output)
        )
        AssetContainerSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Structure]): Structure =
    {
        val parent = AssetContainerSerializer.read (kryo, input, classOf[AssetContainer])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Structure (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readBoolean else false,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) readList (input) else null,
            if (isSet (8)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Support for structure assets.
 *
 * @param Asset [[ch.ninecode.model.Asset Asset]] Reference to the superclass object.
 * @param anchorKind (if anchor) Kind of anchor.
 * @param anchorRodCount (if anchor) Number of rods used.
 * @param anchorRodLength (if anchor) Length of rod used.
 * @param direction Direction of this support structure.
 * @param kind Kind of structure support.
 * @param len Length of this support structure.
 * @param size1 Size of this support structure.
 * @param SecuredStructure [[ch.ninecode.model.Structure Structure]] The secured structure supported by this structure support.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class StructureSupport
(
    Asset: Asset = null,
    anchorKind: String = null,
    anchorRodCount: Int = 0,
    anchorRodLength: Double = 0.0,
    direction: Double = 0.0,
    kind: String = null,
    len: Double = 0.0,
    size1: String = null,
    SecuredStructure: String = null
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
    override def sup: Asset = Asset

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
        implicit val clz: String = StructureSupport.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (StructureSupport.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (StructureSupport.fields (position), value)
        emitattr (0, anchorKind)
        emitelem (1, anchorRodCount)
        emitelem (2, anchorRodLength)
        emitelem (3, direction)
        emitattr (4, kind)
        emitelem (5, len)
        emitelem (6, size1)
        emitattr (7, SecuredStructure)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:StructureSupport rdf:ID=\"%s\">\n%s\t</cim:StructureSupport>".format (id, export_fields)
    }
}

object StructureSupport
extends
    CIMParseable[StructureSupport]
{
    override val fields: Array[String] = Array[String] (
        "anchorKind",
        "anchorRodCount",
        "anchorRodLength",
        "direction",
        "kind",
        "length",
        "size",
        "SecuredStructure"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("SecuredStructure", "Structure", "0..1", "0..*")
    )
    val anchorKind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val anchorRodCount: Fielder = parse_element (element (cls, fields(1)))
    val anchorRodLength: Fielder = parse_element (element (cls, fields(2)))
    val direction: Fielder = parse_element (element (cls, fields(3)))
    val kind: Fielder = parse_attribute (attribute (cls, fields(4)))
    val len: Fielder = parse_element (element (cls, fields(5)))
    val size1: Fielder = parse_element (element (cls, fields(6)))
    val SecuredStructure: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: CIMContext): StructureSupport =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = StructureSupport (
            Asset.parse (context),
            mask (anchorKind (), 0),
            toInteger (mask (anchorRodCount (), 1)),
            toDouble (mask (anchorRodLength (), 2)),
            toDouble (mask (direction (), 3)),
            mask (kind (), 4),
            toDouble (mask (len (), 5)),
            mask (size1 (), 6),
            mask (SecuredStructure (), 7)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[StructureSupport] = StructureSupportSerializer
}

object StructureSupportSerializer extends CIMSerializer[StructureSupport]
{
    def write (kryo: Kryo, output: Output, obj: StructureSupport): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.anchorKind),
            () => output.writeInt (obj.anchorRodCount),
            () => output.writeDouble (obj.anchorRodLength),
            () => output.writeDouble (obj.direction),
            () => output.writeString (obj.kind),
            () => output.writeDouble (obj.len),
            () => output.writeString (obj.size1),
            () => output.writeString (obj.SecuredStructure)
        )
        AssetSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[StructureSupport]): StructureSupport =
    {
        val parent = AssetSerializer.read (kryo, input, classOf[Asset])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = StructureSupport (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readInt else 0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Up-to-date, of-record summary of switch operation information, distilled from a variety of sources (real-time data or real-time data historian, field inspections, etc.) of use to asset health analytics.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param lifetimeFaultOperations Total breaker fault operations to date.
 * @param lifetimeMotorStarts Total motor starts to date.
 * @param lifetimeTotalOperations Total breaker operations to date (including fault and non-fault).
 * @param mostRecentFaultOperationDate Date of most recent breaker fault operation.
 * @param mostRecentMotorStartDate Date of most recent motor start.
 * @param mostRecentOperationDate Date of most recent breaker operation (fault or non-fault).
 * @param Breaker [[ch.ninecode.model.Asset Asset]] Breaker asset to which this operation information applies.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class SwitchOperationSummary
(
    IdentifiedObject: IdentifiedObject = null,
    lifetimeFaultOperations: Int = 0,
    lifetimeMotorStarts: Int = 0,
    lifetimeTotalOperations: Int = 0,
    mostRecentFaultOperationDate: String = null,
    mostRecentMotorStartDate: String = null,
    mostRecentOperationDate: String = null,
    Breaker: String = null
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
        implicit val clz: String = SwitchOperationSummary.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SwitchOperationSummary.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SwitchOperationSummary.fields (position), value)
        emitelem (0, lifetimeFaultOperations)
        emitelem (1, lifetimeMotorStarts)
        emitelem (2, lifetimeTotalOperations)
        emitelem (3, mostRecentFaultOperationDate)
        emitelem (4, mostRecentMotorStartDate)
        emitelem (5, mostRecentOperationDate)
        emitattr (6, Breaker)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SwitchOperationSummary rdf:ID=\"%s\">\n%s\t</cim:SwitchOperationSummary>".format (id, export_fields)
    }
}

object SwitchOperationSummary
extends
    CIMParseable[SwitchOperationSummary]
{
    override val fields: Array[String] = Array[String] (
        "lifetimeFaultOperations",
        "lifetimeMotorStarts",
        "lifetimeTotalOperations",
        "mostRecentFaultOperationDate",
        "mostRecentMotorStartDate",
        "mostRecentOperationDate",
        "Breaker"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Breaker", "Asset", "1", "0..1")
    )
    val lifetimeFaultOperations: Fielder = parse_element (element (cls, fields(0)))
    val lifetimeMotorStarts: Fielder = parse_element (element (cls, fields(1)))
    val lifetimeTotalOperations: Fielder = parse_element (element (cls, fields(2)))
    val mostRecentFaultOperationDate: Fielder = parse_element (element (cls, fields(3)))
    val mostRecentMotorStartDate: Fielder = parse_element (element (cls, fields(4)))
    val mostRecentOperationDate: Fielder = parse_element (element (cls, fields(5)))
    val Breaker: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: CIMContext): SwitchOperationSummary =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SwitchOperationSummary (
            IdentifiedObject.parse (context),
            toInteger (mask (lifetimeFaultOperations (), 0)),
            toInteger (mask (lifetimeMotorStarts (), 1)),
            toInteger (mask (lifetimeTotalOperations (), 2)),
            mask (mostRecentFaultOperationDate (), 3),
            mask (mostRecentMotorStartDate (), 4),
            mask (mostRecentOperationDate (), 5),
            mask (Breaker (), 6)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[SwitchOperationSummary] = SwitchOperationSummarySerializer
}

object SwitchOperationSummarySerializer extends CIMSerializer[SwitchOperationSummary]
{
    def write (kryo: Kryo, output: Output, obj: SwitchOperationSummary): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeInt (obj.lifetimeFaultOperations),
            () => output.writeInt (obj.lifetimeMotorStarts),
            () => output.writeInt (obj.lifetimeTotalOperations),
            () => output.writeString (obj.mostRecentFaultOperationDate),
            () => output.writeString (obj.mostRecentMotorStartDate),
            () => output.writeString (obj.mostRecentOperationDate),
            () => output.writeString (obj.Breaker)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SwitchOperationSummary]): SwitchOperationSummary =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SwitchOperationSummary (
            parent,
            if (isSet (0)) input.readInt else 0,
            if (isSet (1)) input.readInt else 0,
            if (isSet (2)) input.readInt else 0,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Standard published by TAPPI.
 *
 * @param Element Reference to the superclass object.
 * @param standardEdition Edition of TAPPI standard.
 * @param standardNumber TAPPI standard number.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class TAPPIStandard
(
    Element: BasicElement = null,
    standardEdition: String = null,
    standardNumber: String = null
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
        implicit val clz: String = TAPPIStandard.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TAPPIStandard.fields (position), value)
        emitattr (0, standardEdition)
        emitattr (1, standardNumber)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TAPPIStandard rdf:ID=\"%s\">\n%s\t</cim:TAPPIStandard>".format (id, export_fields)
    }
}

object TAPPIStandard
extends
    CIMParseable[TAPPIStandard]
{
    override val fields: Array[String] = Array[String] (
        "standardEdition",
        "standardNumber"
    )
    val standardEdition: Fielder = parse_attribute (attribute (cls, fields(0)))
    val standardNumber: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): TAPPIStandard =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TAPPIStandard (
            BasicElement.parse (context),
            mask (standardEdition (), 0),
            mask (standardNumber (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[TAPPIStandard] = TAPPIStandardSerializer
}

object TAPPIStandardSerializer extends CIMSerializer[TAPPIStandard]
{
    def write (kryo: Kryo, output: Output, obj: TAPPIStandard): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.standardEdition),
            () => output.writeString (obj.standardNumber)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TAPPIStandard]): TAPPIStandard =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TAPPIStandard (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Test results, usually obtained by a lab or other independent organisation.
 *
 * @param ProcedureDataSet [[ch.ninecode.model.ProcedureDataSet ProcedureDataSet]] Reference to the superclass object.
 * @param conclusion Conclusion drawn from test results.
 * @param specimenID Identifier of specimen used in inspection or test.
 * @param specimenToLabDateTime Date and time the specimen was received by the lab.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class TestDataSet
(
    ProcedureDataSet: ProcedureDataSet = null,
    conclusion: String = null,
    specimenID: String = null,
    specimenToLabDateTime: String = null
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
    override def sup: ProcedureDataSet = ProcedureDataSet

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
        implicit val clz: String = TestDataSet.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TestDataSet.fields (position), value)
        emitelem (0, conclusion)
        emitelem (1, specimenID)
        emitelem (2, specimenToLabDateTime)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TestDataSet rdf:ID=\"%s\">\n%s\t</cim:TestDataSet>".format (id, export_fields)
    }
}

object TestDataSet
extends
    CIMParseable[TestDataSet]
{
    override val fields: Array[String] = Array[String] (
        "conclusion",
        "specimenID",
        "specimenToLabDateTime"
    )
    val conclusion: Fielder = parse_element (element (cls, fields(0)))
    val specimenID: Fielder = parse_element (element (cls, fields(1)))
    val specimenToLabDateTime: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: CIMContext): TestDataSet =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TestDataSet (
            ProcedureDataSet.parse (context),
            mask (conclusion (), 0),
            mask (specimenID (), 1),
            mask (specimenToLabDateTime (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[TestDataSet] = TestDataSetSerializer
}

object TestDataSetSerializer extends CIMSerializer[TestDataSet]
{
    def write (kryo: Kryo, output: Output, obj: TestDataSet): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.conclusion),
            () => output.writeString (obj.specimenID),
            () => output.writeString (obj.specimenToLabDateTime)
        )
        ProcedureDataSetSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TestDataSet]): TestDataSet =
    {
        val parent = ProcedureDataSetSerializer.read (kryo, input, classOf[ProcedureDataSet])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TestDataSet (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The precise standard used in executing a lab test, including the standard, and standard version, test method and variant, if needed.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param testMethod Identification of test method used if multiple methods specified by test standard.
 * @param testStandardASTM [[ch.ninecode.model.ASTMStandard ASTMStandard]] Which ASTM standard used to determine analog value result.
 *        Applies only if ASTM standard used.
 * @param testStandardCIGRE [[ch.ninecode.model.CIGREStandard CIGREStandard]] Which CIGRE standard used to determine analog value result.
 *        Applies only if CIGRE standard used.
 * @param testStandardDIN [[ch.ninecode.model.DINStandard DINStandard]] Which DIN standard used to determine analog value result.
 *        Applies only if DIN standard used.
 * @param testStandardDoble [[ch.ninecode.model.DobleStandard DobleStandard]] Which Doble standard used to determine analog value result.
 *        Applies only if Doble standard used.
 * @param testStandardEPA [[ch.ninecode.model.EPAStandard EPAStandard]] Which EPA standard used to determine analog value result.
 *        Applies only if EPA standard used.
 * @param testStandardIEC [[ch.ninecode.model.IECStandard IECStandard]] Which IEC standard used to determine analog value result.
 *        Applies only if IEC standard used.
 * @param testStandardIEEE [[ch.ninecode.model.IEEEStandard IEEEStandard]] Which IEEE standard used to determine analog value result.
 *        Applies only if IEEE standard used.
 * @param testStandardISO [[ch.ninecode.model.ISOStandard ISOStandard]] Which ISO standard used to determine analog value result.
 *        Applies only if ISO standard used.
 * @param testStandardLaborelec [[ch.ninecode.model.LaborelecStandard LaborelecStandard]] Which Laborelec standard used to determine analog value result.
 *        Applies only if Laborelec standard used.
 * @param testStandardTAPPI [[ch.ninecode.model.TAPPIStandard TAPPIStandard]] Which TAPPI standard used to determine analog value result.
 *        Applies only if TAPPI standard used.
 * @param testStandardUKMinistryOfDefence [[ch.ninecode.model.UKMinistryOfDefenceStandard UKMinistryOfDefenceStandard]] Which UK Ministry of Defence standard used to determine analog value result.
 *        Applies only if UK Ministry of Defence standard used.
 * @param testStandardWEP [[ch.ninecode.model.WEPStandard WEPStandard]] Which WEP standard used to determine analog value result.
 *        Applies only if WEP standard used.
 * @param testVariant Identification of variant of test method or standard if one is specified by the standard.
 * @param AssetAnalog [[ch.ninecode.model.AssetAnalog AssetAnalog]] An asset health analog related to this lab test standard.
 * @param AssetDiscrete [[ch.ninecode.model.AssetDiscrete AssetDiscrete]] An asset health discrete related to this lab test standard.
 * @param AssetString [[ch.ninecode.model.AssetStringMeasurement AssetStringMeasurement]] An asset health string related to this lab test standard.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class TestStandard
(
    IdentifiedObject: IdentifiedObject = null,
    testMethod: String = null,
    testStandardASTM: String = null,
    testStandardCIGRE: String = null,
    testStandardDIN: String = null,
    testStandardDoble: String = null,
    testStandardEPA: String = null,
    testStandardIEC: String = null,
    testStandardIEEE: String = null,
    testStandardISO: String = null,
    testStandardLaborelec: String = null,
    testStandardTAPPI: String = null,
    testStandardUKMinistryOfDefence: String = null,
    testStandardWEP: String = null,
    testVariant: String = null,
    AssetAnalog: List[String] = null,
    AssetDiscrete: List[String] = null,
    AssetString: List[String] = null
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
        implicit val clz: String = TestStandard.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TestStandard.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TestStandard.fields (position), x))
        emitattr (0, testMethod)
        emitattr (1, testStandardASTM)
        emitattr (2, testStandardCIGRE)
        emitattr (3, testStandardDIN)
        emitattr (4, testStandardDoble)
        emitattr (5, testStandardEPA)
        emitattr (6, testStandardIEC)
        emitattr (7, testStandardIEEE)
        emitattr (8, testStandardISO)
        emitattr (9, testStandardLaborelec)
        emitattr (10, testStandardTAPPI)
        emitattr (11, testStandardUKMinistryOfDefence)
        emitattr (12, testStandardWEP)
        emitattr (13, testVariant)
        emitattrs (14, AssetAnalog)
        emitattrs (15, AssetDiscrete)
        emitattrs (16, AssetString)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TestStandard rdf:ID=\"%s\">\n%s\t</cim:TestStandard>".format (id, export_fields)
    }
}

object TestStandard
extends
    CIMParseable[TestStandard]
{
    override val fields: Array[String] = Array[String] (
        "testMethod",
        "testStandardASTM",
        "testStandardCIGRE",
        "testStandardDIN",
        "testStandardDoble",
        "testStandardEPA",
        "testStandardIEC",
        "testStandardIEEE",
        "testStandardISO",
        "testStandardLaborelec",
        "testStandardTAPPI",
        "testStandardUKMinistryOfDefence",
        "testStandardWEP",
        "testVariant",
        "AssetAnalog",
        "AssetDiscrete",
        "AssetString"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("testStandardASTM", "ASTMStandard", "0..1", "0..*"),
        CIMRelationship ("testStandardCIGRE", "CIGREStandard", "0..1", "0..*"),
        CIMRelationship ("testStandardDIN", "DINStandard", "0..1", "0..*"),
        CIMRelationship ("testStandardDoble", "DobleStandard", "0..1", "0..*"),
        CIMRelationship ("testStandardEPA", "EPAStandard", "0..1", "0..*"),
        CIMRelationship ("testStandardIEC", "IECStandard", "0..1", "0..*"),
        CIMRelationship ("testStandardIEEE", "IEEEStandard", "0..1", "0..*"),
        CIMRelationship ("testStandardISO", "ISOStandard", "0..1", "0..*"),
        CIMRelationship ("testStandardLaborelec", "LaborelecStandard", "0..1", "0..*"),
        CIMRelationship ("testStandardTAPPI", "TAPPIStandard", "0..1", "0..*"),
        CIMRelationship ("testStandardUKMinistryOfDefence", "UKMinistryOfDefenceStandard", "0..1", "0..*"),
        CIMRelationship ("testStandardWEP", "WEPStandard", "0..1", "0..*"),
        CIMRelationship ("AssetAnalog", "AssetAnalog", "0..*", "0..1"),
        CIMRelationship ("AssetDiscrete", "AssetDiscrete", "0..*", "0..1"),
        CIMRelationship ("AssetString", "AssetStringMeasurement", "0..*", "0..1")
    )
    val testMethod: Fielder = parse_attribute (attribute (cls, fields(0)))
    val testStandardASTM: Fielder = parse_attribute (attribute (cls, fields(1)))
    val testStandardCIGRE: Fielder = parse_attribute (attribute (cls, fields(2)))
    val testStandardDIN: Fielder = parse_attribute (attribute (cls, fields(3)))
    val testStandardDoble: Fielder = parse_attribute (attribute (cls, fields(4)))
    val testStandardEPA: Fielder = parse_attribute (attribute (cls, fields(5)))
    val testStandardIEC: Fielder = parse_attribute (attribute (cls, fields(6)))
    val testStandardIEEE: Fielder = parse_attribute (attribute (cls, fields(7)))
    val testStandardISO: Fielder = parse_attribute (attribute (cls, fields(8)))
    val testStandardLaborelec: Fielder = parse_attribute (attribute (cls, fields(9)))
    val testStandardTAPPI: Fielder = parse_attribute (attribute (cls, fields(10)))
    val testStandardUKMinistryOfDefence: Fielder = parse_attribute (attribute (cls, fields(11)))
    val testStandardWEP: Fielder = parse_attribute (attribute (cls, fields(12)))
    val testVariant: Fielder = parse_attribute (attribute (cls, fields(13)))
    val AssetAnalog: FielderMultiple = parse_attributes (attribute (cls, fields(14)))
    val AssetDiscrete: FielderMultiple = parse_attributes (attribute (cls, fields(15)))
    val AssetString: FielderMultiple = parse_attributes (attribute (cls, fields(16)))

    def parse (context: CIMContext): TestStandard =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TestStandard (
            IdentifiedObject.parse (context),
            mask (testMethod (), 0),
            mask (testStandardASTM (), 1),
            mask (testStandardCIGRE (), 2),
            mask (testStandardDIN (), 3),
            mask (testStandardDoble (), 4),
            mask (testStandardEPA (), 5),
            mask (testStandardIEC (), 6),
            mask (testStandardIEEE (), 7),
            mask (testStandardISO (), 8),
            mask (testStandardLaborelec (), 9),
            mask (testStandardTAPPI (), 10),
            mask (testStandardUKMinistryOfDefence (), 11),
            mask (testStandardWEP (), 12),
            mask (testVariant (), 13),
            masks (AssetAnalog (), 14),
            masks (AssetDiscrete (), 15),
            masks (AssetString (), 16)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[TestStandard] = TestStandardSerializer
}

object TestStandardSerializer extends CIMSerializer[TestStandard]
{
    def write (kryo: Kryo, output: Output, obj: TestStandard): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.testMethod),
            () => output.writeString (obj.testStandardASTM),
            () => output.writeString (obj.testStandardCIGRE),
            () => output.writeString (obj.testStandardDIN),
            () => output.writeString (obj.testStandardDoble),
            () => output.writeString (obj.testStandardEPA),
            () => output.writeString (obj.testStandardIEC),
            () => output.writeString (obj.testStandardIEEE),
            () => output.writeString (obj.testStandardISO),
            () => output.writeString (obj.testStandardLaborelec),
            () => output.writeString (obj.testStandardTAPPI),
            () => output.writeString (obj.testStandardUKMinistryOfDefence),
            () => output.writeString (obj.testStandardWEP),
            () => output.writeString (obj.testVariant),
            () => writeList (obj.AssetAnalog, output),
            () => writeList (obj.AssetDiscrete, output),
            () => writeList (obj.AssetString, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TestStandard]): TestStandard =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TestStandard (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) input.readString else null,
            if (isSet (11)) input.readString else null,
            if (isSet (12)) input.readString else null,
            if (isSet (13)) input.readString else null,
            if (isSet (14)) readList (input) else null,
            if (isSet (15)) readList (input) else null,
            if (isSet (16)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Standard published by United Kingdom Ministry of Defence.
 *
 * @param Element Reference to the superclass object.
 * @param standardEdition Edition of UK Ministry of Defence standard.
 * @param standardNumber UK Ministry of Defence standard number.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class UKMinistryOfDefenceStandard
(
    Element: BasicElement = null,
    standardEdition: String = null,
    standardNumber: String = null
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
        implicit val clz: String = UKMinistryOfDefenceStandard.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (UKMinistryOfDefenceStandard.fields (position), value)
        emitattr (0, standardEdition)
        emitattr (1, standardNumber)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:UKMinistryOfDefenceStandard rdf:ID=\"%s\">\n%s\t</cim:UKMinistryOfDefenceStandard>".format (id, export_fields)
    }
}

object UKMinistryOfDefenceStandard
extends
    CIMParseable[UKMinistryOfDefenceStandard]
{
    override val fields: Array[String] = Array[String] (
        "standardEdition",
        "standardNumber"
    )
    val standardEdition: Fielder = parse_attribute (attribute (cls, fields(0)))
    val standardNumber: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): UKMinistryOfDefenceStandard =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = UKMinistryOfDefenceStandard (
            BasicElement.parse (context),
            mask (standardEdition (), 0),
            mask (standardNumber (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[UKMinistryOfDefenceStandard] = UKMinistryOfDefenceStandardSerializer
}

object UKMinistryOfDefenceStandardSerializer extends CIMSerializer[UKMinistryOfDefenceStandard]
{
    def write (kryo: Kryo, output: Output, obj: UKMinistryOfDefenceStandard): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.standardEdition),
            () => output.writeString (obj.standardNumber)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[UKMinistryOfDefenceStandard]): UKMinistryOfDefenceStandard =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = UKMinistryOfDefenceStandard (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Standard published by Westinghouse - a WEP (Westinghouse Engineering Procedure).
 *
 * @param Element Reference to the superclass object.
 * @param standardEdition Edition of WEP standard.
 * @param standardNumber WEP standard number.
 * @group Assets
 * @groupname Assets Package Assets
 * @groupdesc Assets This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 */
final case class WEPStandard
(
    Element: BasicElement = null,
    standardEdition: String = null,
    standardNumber: String = null
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
        implicit val clz: String = WEPStandard.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WEPStandard.fields (position), value)
        emitattr (0, standardEdition)
        emitattr (1, standardNumber)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WEPStandard rdf:ID=\"%s\">\n%s\t</cim:WEPStandard>".format (id, export_fields)
    }
}

object WEPStandard
extends
    CIMParseable[WEPStandard]
{
    override val fields: Array[String] = Array[String] (
        "standardEdition",
        "standardNumber"
    )
    val standardEdition: Fielder = parse_attribute (attribute (cls, fields(0)))
    val standardNumber: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): WEPStandard =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WEPStandard (
            BasicElement.parse (context),
            mask (standardEdition (), 0),
            mask (standardNumber (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[WEPStandard] = WEPStandardSerializer
}

object WEPStandardSerializer extends CIMSerializer[WEPStandard]
{
    def write (kryo: Kryo, output: Output, obj: WEPStandard): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.standardEdition),
            () => output.writeString (obj.standardNumber)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[WEPStandard]): WEPStandard =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = WEPStandard (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _Assets
{
    def register: List[CIMClassInfo] =
    {
        List (
            ASTMStandard.register,
            AcceptanceTest.register,
            AggregateScore.register,
            Analytic.register,
            AnalyticScore.register,
            Asset.register,
            AssetContainer.register,
            AssetDeployment.register,
            AssetFunction.register,
            AssetGroup.register,
            AssetHealthEvent.register,
            AssetInfo.register,
            AssetLocationHazard.register,
            AssetOrganisationRole.register,
            AssetOwner.register,
            AssetTestLab.register,
            AssetTestSampleTaker.register,
            AssetUser.register,
            Bushing.register,
            CIGREStandard.register,
            Cabinet.register,
            CatalogAssetType.register,
            ComMedia.register,
            DINStandard.register,
            DeploymentDate.register,
            DiagnosisDataSet.register,
            DobleStandard.register,
            DuctBank.register,
            EPAStandard.register,
            FACTSDevice.register,
            Facility.register,
            FailureEvent.register,
            FinancialInfo.register,
            HealthScore.register,
            IECStandard.register,
            IEEEStandard.register,
            ISOStandard.register,
            InUseDate.register,
            InspectionDataSet.register,
            InterrupterUnit.register,
            Joint.register,
            LabTestDataSet.register,
            LaborelecStandard.register,
            LifecycleDate.register,
            Maintainer.register,
            MaintenanceDataSet.register,
            Manufacturer.register,
            Medium.register,
            OilSpecimen.register,
            OperatingMechanism.register,
            Procedure.register,
            ProcedureDataSet.register,
            ProductAssetModel.register,
            RiskScore.register,
            Seal.register,
            Specimen.register,
            Streetlight.register,
            Structure.register,
            StructureSupport.register,
            SwitchOperationSummary.register,
            TAPPIStandard.register,
            TestDataSet.register,
            TestStandard.register,
            UKMinistryOfDefenceStandard.register,
            WEPStandard.register
        )
    }
}
package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Busbar section data.
 *
 * @param sup [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param ratedCurrent Rated current.
 * @param ratedVoltage Rated voltage.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
case class BusbarSectionInfo
(
    override val sup: AssetInfo,
    ratedCurrent: Double,
    ratedVoltage: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { clone ().asInstanceOf[BusbarSectionInfo] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = BusbarSectionInfo.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BusbarSectionInfo.fields (position), value)
        emitelem (0, ratedCurrent)
        emitelem (1, ratedVoltage)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BusbarSectionInfo rdf:ID=\"%s\">\n%s\t</cim:BusbarSectionInfo>".format (id, export_fields)
    }
}

object BusbarSectionInfo
extends
    Parseable[BusbarSectionInfo]
{
    val fields: Array[String] = Array[String] (
        "ratedCurrent",
        "ratedVoltage"
    )
    val ratedCurrent: Fielder = parse_element (element (cls, fields(0)))
    val ratedVoltage: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): BusbarSectionInfo =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BusbarSectionInfo (
            AssetInfo.parse (context),
            toDouble (mask (ratedCurrent (), 0)),
            toDouble (mask (ratedVoltage (), 1))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Cable data.
 *
 * @param sup [[ch.ninecode.model.WireInfo WireInfo]] Reference to the superclass object.
 * @param constructionKind Kind of construction of this cable.
 * @param diameterOverCore Diameter over the core, including any semi-con screen; should be the insulating layer's inside diameter.
 * @param diameterOverInsulation Diameter over the insulating layer, excluding outer screen.
 * @param diameterOverJacket Diameter over the outermost jacketing layer.
 * @param diameterOverScreen Diameter over the outer screen; should be the shield's inside diameter.
 * @param isStrandFill True if wire strands are extruded in a way to fill the voids in the cable.
 * @param nominalTemperature Maximum nominal design operating temperature.
 * @param outerJacketKind Kind of outer jacket of this cable.
 * @param sheathAsNeutral True if sheath / shield is used as a neutral (i.e., bonded).
 * @param shieldMaterial Material of the shield.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
case class CableInfo
(
    override val sup: WireInfo,
    constructionKind: String,
    diameterOverCore: Double,
    diameterOverInsulation: Double,
    diameterOverJacket: Double,
    diameterOverScreen: Double,
    isStrandFill: Boolean,
    nominalTemperature: Double,
    outerJacketKind: String,
    sheathAsNeutral: Boolean,
    shieldMaterial: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, 0.0, 0.0, 0.0, false, 0.0, null, false, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def WireInfo: WireInfo = sup.asInstanceOf[WireInfo]
    override def copy (): Row = { clone ().asInstanceOf[CableInfo] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CableInfo.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CableInfo.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CableInfo.fields (position), value)
        emitattr (0, constructionKind)
        emitelem (1, diameterOverCore)
        emitelem (2, diameterOverInsulation)
        emitelem (3, diameterOverJacket)
        emitelem (4, diameterOverScreen)
        emitelem (5, isStrandFill)
        emitelem (6, nominalTemperature)
        emitattr (7, outerJacketKind)
        emitelem (8, sheathAsNeutral)
        emitattr (9, shieldMaterial)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CableInfo rdf:ID=\"%s\">\n%s\t</cim:CableInfo>".format (id, export_fields)
    }
}

object CableInfo
extends
    Parseable[CableInfo]
{
    val fields: Array[String] = Array[String] (
        "constructionKind",
        "diameterOverCore",
        "diameterOverInsulation",
        "diameterOverJacket",
        "diameterOverScreen",
        "isStrandFill",
        "nominalTemperature",
        "outerJacketKind",
        "sheathAsNeutral",
        "shieldMaterial"
    )
    val constructionKind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val diameterOverCore: Fielder = parse_element (element (cls, fields(1)))
    val diameterOverInsulation: Fielder = parse_element (element (cls, fields(2)))
    val diameterOverJacket: Fielder = parse_element (element (cls, fields(3)))
    val diameterOverScreen: Fielder = parse_element (element (cls, fields(4)))
    val isStrandFill: Fielder = parse_element (element (cls, fields(5)))
    val nominalTemperature: Fielder = parse_element (element (cls, fields(6)))
    val outerJacketKind: Fielder = parse_attribute (attribute (cls, fields(7)))
    val sheathAsNeutral: Fielder = parse_element (element (cls, fields(8)))
    val shieldMaterial: Fielder = parse_attribute (attribute (cls, fields(9)))

    def parse (context: Context): CableInfo =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CableInfo (
            WireInfo.parse (context),
            mask (constructionKind (), 0),
            toDouble (mask (diameterOverCore (), 1)),
            toDouble (mask (diameterOverInsulation (), 2)),
            toDouble (mask (diameterOverJacket (), 3)),
            toDouble (mask (diameterOverScreen (), 4)),
            toBoolean (mask (isStrandFill (), 5)),
            toDouble (mask (nominalTemperature (), 6)),
            mask (outerJacketKind (), 7),
            toBoolean (mask (sheathAsNeutral (), 8)),
            mask (shieldMaterial (), 9)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Concentric neutral cable data.
 *
 * @param sup [[ch.ninecode.model.CableInfo CableInfo]] Reference to the superclass object.
 * @param diameterOverNeutral Diameter over the concentric neutral strands.
 * @param neutralStrandCount Number of concentric neutral strands.
 * @param neutralStrandGmr Geometric mean radius of the neutral strand.
 * @param neutralStrandRDC20 DC resistance per unit length of the neutral strand at 20 �C.
 * @param neutralStrandRadius Outside radius of the neutral strand.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
case class ConcentricNeutralCableInfo
(
    override val sup: CableInfo,
    diameterOverNeutral: Double,
    neutralStrandCount: Int,
    neutralStrandGmr: Double,
    neutralStrandRDC20: Double,
    neutralStrandRadius: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def CableInfo: CableInfo = sup.asInstanceOf[CableInfo]
    override def copy (): Row = { clone ().asInstanceOf[ConcentricNeutralCableInfo] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ConcentricNeutralCableInfo.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ConcentricNeutralCableInfo.fields (position), value)
        emitelem (0, diameterOverNeutral)
        emitelem (1, neutralStrandCount)
        emitelem (2, neutralStrandGmr)
        emitelem (3, neutralStrandRDC20)
        emitelem (4, neutralStrandRadius)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ConcentricNeutralCableInfo rdf:ID=\"%s\">\n%s\t</cim:ConcentricNeutralCableInfo>".format (id, export_fields)
    }
}

object ConcentricNeutralCableInfo
extends
    Parseable[ConcentricNeutralCableInfo]
{
    val fields: Array[String] = Array[String] (
        "diameterOverNeutral",
        "neutralStrandCount",
        "neutralStrandGmr",
        "neutralStrandRDC20",
        "neutralStrandRadius"
    )
    val diameterOverNeutral: Fielder = parse_element (element (cls, fields(0)))
    val neutralStrandCount: Fielder = parse_element (element (cls, fields(1)))
    val neutralStrandGmr: Fielder = parse_element (element (cls, fields(2)))
    val neutralStrandRDC20: Fielder = parse_element (element (cls, fields(3)))
    val neutralStrandRadius: Fielder = parse_element (element (cls, fields(4)))

    def parse (context: Context): ConcentricNeutralCableInfo =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ConcentricNeutralCableInfo (
            CableInfo.parse (context),
            toDouble (mask (diameterOverNeutral (), 0)),
            toInteger (mask (neutralStrandCount (), 1)),
            toDouble (mask (neutralStrandGmr (), 2)),
            toDouble (mask (neutralStrandRDC20 (), 3)),
            toDouble (mask (neutralStrandRadius (), 4))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * No-load test results determine core admittance parameters.
 *
 * They include exciting current and core loss measurements from applying voltage to one winding. The excitation may be positive sequence or zero sequence. The test may be repeated at different voltages to measure saturation.
 *
 * @param sup [[ch.ninecode.model.TransformerTest TransformerTest]] Reference to the superclass object.
 * @param energisedEndVoltage Voltage applied to the winding (end) during test.
 * @param excitingCurrent Exciting current measured from a positive-sequence or single-phase excitation test.
 * @param excitingCurrentZero Exciting current measured from a zero-sequence open-circuit excitation test.
 * @param loss Losses measured from a positive-sequence or single-phase excitation test.
 * @param lossZero Losses measured from a zero-sequence excitation test.
 * @param EnergisedEnd [[ch.ninecode.model.TransformerEndInfo TransformerEndInfo]] Transformer end that current is applied to in this no-load test.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
case class NoLoadTest
(
    override val sup: TransformerTest,
    energisedEndVoltage: Double,
    excitingCurrent: Double,
    excitingCurrentZero: Double,
    loss: Double,
    lossZero: Double,
    EnergisedEnd: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def TransformerTest: TransformerTest = sup.asInstanceOf[TransformerTest]
    override def copy (): Row = { clone ().asInstanceOf[NoLoadTest] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = NoLoadTest.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (NoLoadTest.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (NoLoadTest.fields (position), value)
        emitelem (0, energisedEndVoltage)
        emitelem (1, excitingCurrent)
        emitelem (2, excitingCurrentZero)
        emitelem (3, loss)
        emitelem (4, lossZero)
        emitattr (5, EnergisedEnd)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:NoLoadTest rdf:ID=\"%s\">\n%s\t</cim:NoLoadTest>".format (id, export_fields)
    }
}

object NoLoadTest
extends
    Parseable[NoLoadTest]
{
    val fields: Array[String] = Array[String] (
        "energisedEndVoltage",
        "excitingCurrent",
        "excitingCurrentZero",
        "loss",
        "lossZero",
        "EnergisedEnd"
    )
    val energisedEndVoltage: Fielder = parse_element (element (cls, fields(0)))
    val excitingCurrent: Fielder = parse_element (element (cls, fields(1)))
    val excitingCurrentZero: Fielder = parse_element (element (cls, fields(2)))
    val loss: Fielder = parse_element (element (cls, fields(3)))
    val lossZero: Fielder = parse_element (element (cls, fields(4)))
    val EnergisedEnd: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): NoLoadTest =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = NoLoadTest (
            TransformerTest.parse (context),
            toDouble (mask (energisedEndVoltage (), 0)),
            toDouble (mask (excitingCurrent (), 1)),
            toDouble (mask (excitingCurrentZero (), 2)),
            toDouble (mask (loss (), 3)),
            toDouble (mask (lossZero (), 4)),
            mask (EnergisedEnd (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("EnergisedEnd", "TransformerEndInfo", false)
    )
}

/**
 * Open-circuit test results verify winding turn ratios and phase shifts.
 *
 * They include induced voltage and phase shift measurements on open-circuit windings, with voltage applied to the energised end. For three-phase windings, the excitation can be a positive sequence (the default) or a zero sequence.
 *
 * @param sup [[ch.ninecode.model.TransformerTest TransformerTest]] Reference to the superclass object.
 * @param energisedEndStep Tap step number for the energised end of the test pair.
 * @param energisedEndVoltage Voltage applied to the winding (end) during test.
 * @param openEndStep Tap step number for the open end of the test pair.
 * @param openEndVoltage Voltage measured at the open-circuited end, with the energised end set to rated voltage and all other ends open.
 * @param phaseShift Phase shift measured at the open end with the energised end set to rated voltage and all other ends open.
 * @param EnergisedEnd [[ch.ninecode.model.TransformerEndInfo TransformerEndInfo]] Transformer end that current is applied to in this open-circuit test.
 * @param OpenEnd [[ch.ninecode.model.TransformerEndInfo TransformerEndInfo]] Transformer end measured for induced voltage and angle in this open-circuit test.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
case class OpenCircuitTest
(
    override val sup: TransformerTest,
    energisedEndStep: Int,
    energisedEndVoltage: Double,
    openEndStep: Int,
    openEndVoltage: Double,
    phaseShift: Double,
    EnergisedEnd: String,
    OpenEnd: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, 0.0, 0, 0.0, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def TransformerTest: TransformerTest = sup.asInstanceOf[TransformerTest]
    override def copy (): Row = { clone ().asInstanceOf[OpenCircuitTest] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OpenCircuitTest.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OpenCircuitTest.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OpenCircuitTest.fields (position), value)
        emitelem (0, energisedEndStep)
        emitelem (1, energisedEndVoltage)
        emitelem (2, openEndStep)
        emitelem (3, openEndVoltage)
        emitelem (4, phaseShift)
        emitattr (5, EnergisedEnd)
        emitattr (6, OpenEnd)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OpenCircuitTest rdf:ID=\"%s\">\n%s\t</cim:OpenCircuitTest>".format (id, export_fields)
    }
}

object OpenCircuitTest
extends
    Parseable[OpenCircuitTest]
{
    val fields: Array[String] = Array[String] (
        "energisedEndStep",
        "energisedEndVoltage",
        "openEndStep",
        "openEndVoltage",
        "phaseShift",
        "EnergisedEnd",
        "OpenEnd"
    )
    val energisedEndStep: Fielder = parse_element (element (cls, fields(0)))
    val energisedEndVoltage: Fielder = parse_element (element (cls, fields(1)))
    val openEndStep: Fielder = parse_element (element (cls, fields(2)))
    val openEndVoltage: Fielder = parse_element (element (cls, fields(3)))
    val phaseShift: Fielder = parse_element (element (cls, fields(4)))
    val EnergisedEnd: Fielder = parse_attribute (attribute (cls, fields(5)))
    val OpenEnd: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: Context): OpenCircuitTest =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = OpenCircuitTest (
            TransformerTest.parse (context),
            toInteger (mask (energisedEndStep (), 0)),
            toDouble (mask (energisedEndVoltage (), 1)),
            toInteger (mask (openEndStep (), 2)),
            toDouble (mask (openEndVoltage (), 3)),
            toDouble (mask (phaseShift (), 4)),
            mask (EnergisedEnd (), 5),
            mask (OpenEnd (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("EnergisedEnd", "TransformerEndInfo", false),
        Relationship ("OpenEnd", "TransformerEndInfo", false)
    )
}

/**
 * Overhead wire data.
 *
 * @param sup [[ch.ninecode.model.WireInfo WireInfo]] Reference to the superclass object.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
case class OverheadWireInfo
(
    override val sup: WireInfo
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def WireInfo: WireInfo = sup.asInstanceOf[WireInfo]
    override def copy (): Row = { clone ().asInstanceOf[OverheadWireInfo] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:OverheadWireInfo rdf:ID=\"%s\">\n%s\t</cim:OverheadWireInfo>".format (id, export_fields)
    }
}

object OverheadWireInfo
extends
    Parseable[OverheadWireInfo]
{

    def parse (context: Context): OverheadWireInfo =
    {
        implicit val ctx: Context = context
        val ret = OverheadWireInfo (
            WireInfo.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Set of power transformer data, from an equipment library.
 *
 * @param sup [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
case class PowerTransformerInfo
(
    override val sup: AssetInfo
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { clone ().asInstanceOf[PowerTransformerInfo] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:PowerTransformerInfo rdf:ID=\"%s\">\n%s\t</cim:PowerTransformerInfo>".format (id, export_fields)
    }
}

object PowerTransformerInfo
extends
    Parseable[PowerTransformerInfo]
{

    def parse (context: Context): PowerTransformerInfo =
    {
        implicit val ctx: Context = context
        val ret = PowerTransformerInfo (
            AssetInfo.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Short-circuit test results determine mesh impedance parameters.
 *
 * They include load losses and leakage impedances. For three-phase windings, the excitation can be a positive sequence (the default) or a zero sequence. There shall be at least one grounded winding.
 *
 * @param sup [[ch.ninecode.model.TransformerTest TransformerTest]] Reference to the superclass object.
 * @param energisedEndStep Tap step number for the energised end of the test pair.
 * @param groundedEndStep Tap step number for the grounded end of the test pair.
 * @param leakageImpedance Leakage impedance measured from a positive-sequence or single-phase short-circuit test.
 * @param leakageImpedanceZero Leakage impedance measured from a zero-sequence short-circuit test.
 * @param loss Load losses from a positive-sequence or single-phase short-circuit test.
 * @param lossZero Load losses from a zero-sequence short-circuit test.
 * @param EnergisedEnd [[ch.ninecode.model.TransformerEndInfo TransformerEndInfo]] Transformer end that voltage is applied to in this short-circuit test.
 *        The test voltage is chosen to induce rated current in the energised end.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
case class ShortCircuitTest
(
    override val sup: TransformerTest,
    energisedEndStep: Int,
    groundedEndStep: Int,
    leakageImpedance: Double,
    leakageImpedanceZero: Double,
    loss: Double,
    lossZero: Double,
    EnergisedEnd: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, 0, 0.0, 0.0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def TransformerTest: TransformerTest = sup.asInstanceOf[TransformerTest]
    override def copy (): Row = { clone ().asInstanceOf[ShortCircuitTest] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ShortCircuitTest.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ShortCircuitTest.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ShortCircuitTest.fields (position), value)
        emitelem (0, energisedEndStep)
        emitelem (1, groundedEndStep)
        emitelem (2, leakageImpedance)
        emitelem (3, leakageImpedanceZero)
        emitelem (4, loss)
        emitelem (5, lossZero)
        emitattr (6, EnergisedEnd)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ShortCircuitTest rdf:ID=\"%s\">\n%s\t</cim:ShortCircuitTest>".format (id, export_fields)
    }
}

object ShortCircuitTest
extends
    Parseable[ShortCircuitTest]
{
    val fields: Array[String] = Array[String] (
        "energisedEndStep",
        "groundedEndStep",
        "leakageImpedance",
        "leakageImpedanceZero",
        "loss",
        "lossZero",
        "EnergisedEnd"
    )
    val energisedEndStep: Fielder = parse_element (element (cls, fields(0)))
    val groundedEndStep: Fielder = parse_element (element (cls, fields(1)))
    val leakageImpedance: Fielder = parse_element (element (cls, fields(2)))
    val leakageImpedanceZero: Fielder = parse_element (element (cls, fields(3)))
    val loss: Fielder = parse_element (element (cls, fields(4)))
    val lossZero: Fielder = parse_element (element (cls, fields(5)))
    val EnergisedEnd: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: Context): ShortCircuitTest =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ShortCircuitTest (
            TransformerTest.parse (context),
            toInteger (mask (energisedEndStep (), 0)),
            toInteger (mask (groundedEndStep (), 1)),
            toDouble (mask (leakageImpedance (), 2)),
            toDouble (mask (leakageImpedanceZero (), 3)),
            toDouble (mask (loss (), 4)),
            toDouble (mask (lossZero (), 5)),
            mask (EnergisedEnd (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("EnergisedEnd", "TransformerEndInfo", false)
    )
}

/**
 * Properties of shunt capacitor, shunt reactor or switchable bank of shunt capacitor or reactor assets.
 *
 * @param sup [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param maxPowerLoss Maximum allowed apparent power loss.
 * @param ratedCurrent Rated current.
 * @param ratedReactivePower Rated reactive power.
 * @param ratedVoltage Rated voltage.
 * @param ShuntCompensatorControl [[ch.ninecode.model.ShuntCompensatorControl ShuntCompensatorControl]] <em>undocumented</em>
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
case class ShuntCompensatorInfo
(
    override val sup: AssetInfo,
    maxPowerLoss: Double,
    ratedCurrent: Double,
    ratedReactivePower: Double,
    ratedVoltage: Double,
    ShuntCompensatorControl: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { clone ().asInstanceOf[ShuntCompensatorInfo] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ShuntCompensatorInfo.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ShuntCompensatorInfo.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ShuntCompensatorInfo.fields (position), value)
        emitelem (0, maxPowerLoss)
        emitelem (1, ratedCurrent)
        emitelem (2, ratedReactivePower)
        emitelem (3, ratedVoltage)
        emitattr (4, ShuntCompensatorControl)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ShuntCompensatorInfo rdf:ID=\"%s\">\n%s\t</cim:ShuntCompensatorInfo>".format (id, export_fields)
    }
}

object ShuntCompensatorInfo
extends
    Parseable[ShuntCompensatorInfo]
{
    val fields: Array[String] = Array[String] (
        "maxPowerLoss",
        "ratedCurrent",
        "ratedReactivePower",
        "ratedVoltage",
        "ShuntCompensatorControl"
    )
    val maxPowerLoss: Fielder = parse_element (element (cls, fields(0)))
    val ratedCurrent: Fielder = parse_element (element (cls, fields(1)))
    val ratedReactivePower: Fielder = parse_element (element (cls, fields(2)))
    val ratedVoltage: Fielder = parse_element (element (cls, fields(3)))
    val ShuntCompensatorControl: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): ShuntCompensatorInfo =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ShuntCompensatorInfo (
            AssetInfo.parse (context),
            toDouble (mask (maxPowerLoss (), 0)),
            toDouble (mask (ratedCurrent (), 1)),
            toDouble (mask (ratedReactivePower (), 2)),
            toDouble (mask (ratedVoltage (), 3)),
            mask (ShuntCompensatorControl (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ShuntCompensatorControl", "ShuntCompensatorControl", false)
    )
}

/**
 * Switch data.
 *
 * @param sup [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param breakingCapacity The maximum fault current a breaking device can break safely under prescribed conditions of use.
 * @param isSinglePhase If true, it is a single phase switch.
 * @param isUnganged If true, the switch is not ganged (i.e., a switch phase may be operated separately from other phases).
 * @param ratedCurrent Rated current.
 * @param ratedVoltage Rated voltage.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
case class SwitchInfo
(
    override val sup: AssetInfo,
    breakingCapacity: Double,
    isSinglePhase: Boolean,
    isUnganged: Boolean,
    ratedCurrent: Double,
    ratedVoltage: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, false, false, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { clone ().asInstanceOf[SwitchInfo] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SwitchInfo.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SwitchInfo.fields (position), value)
        emitelem (0, breakingCapacity)
        emitelem (1, isSinglePhase)
        emitelem (2, isUnganged)
        emitelem (3, ratedCurrent)
        emitelem (4, ratedVoltage)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SwitchInfo rdf:ID=\"%s\">\n%s\t</cim:SwitchInfo>".format (id, export_fields)
    }
}

object SwitchInfo
extends
    Parseable[SwitchInfo]
{
    val fields: Array[String] = Array[String] (
        "breakingCapacity",
        "isSinglePhase",
        "isUnganged",
        "ratedCurrent",
        "ratedVoltage"
    )
    val breakingCapacity: Fielder = parse_element (element (cls, fields(0)))
    val isSinglePhase: Fielder = parse_element (element (cls, fields(1)))
    val isUnganged: Fielder = parse_element (element (cls, fields(2)))
    val ratedCurrent: Fielder = parse_element (element (cls, fields(3)))
    val ratedVoltage: Fielder = parse_element (element (cls, fields(4)))

    def parse (context: Context): SwitchInfo =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = SwitchInfo (
            AssetInfo.parse (context),
            toDouble (mask (breakingCapacity (), 0)),
            toBoolean (mask (isSinglePhase (), 1)),
            toBoolean (mask (isUnganged (), 2)),
            toDouble (mask (ratedCurrent (), 3)),
            toDouble (mask (ratedVoltage (), 4))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Tap changer data.
 *
 * @param sup [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param bil Basic Insulation Level (BIL) expressed as the impulse crest voltage of a nominal wave, typically 1.2 X 50 microsecond.
 *        This is a measure of the ability of the insulation to withstand very high voltage surges.
 * @param ctRating Built-in current transformer primary rating.
 * @param ctRatio Built-in current transducer ratio.
 * @param frequency Frequency at which the ratings apply.
 * @param highStep Highest possible tap step position, advance from neutral.
 * @param isTcul Whether this tap changer has under load tap changing capabilities.
 * @param lowStep Lowest possible tap step position, retard from neutral.
 * @param neutralStep The neutral tap step position for the winding.
 * @param neutralU Voltage at which the winding operates at the neutral tap setting.
 * @param ptRatio Built-in voltage transducer ratio.
 * @param ratedApparentPower Rated apparent power.
 * @param ratedCurrent Rated current.
 * @param ratedVoltage Rated voltage.
 * @param stepPhaseIncrement Phase shift per step position.
 * @param stepVoltageIncrement Tap step increment, in per cent of rated voltage, per step position.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
case class TapChangerInfo
(
    override val sup: AssetInfo,
    bil: Double,
    ctRating: Double,
    ctRatio: Double,
    frequency: Double,
    highStep: Int,
    isTcul: Boolean,
    lowStep: Int,
    neutralStep: Int,
    neutralU: Double,
    ptRatio: Double,
    ratedApparentPower: Double,
    ratedCurrent: Double,
    ratedVoltage: Double,
    stepPhaseIncrement: Double,
    stepVoltageIncrement: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0, false, 0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { clone ().asInstanceOf[TapChangerInfo] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TapChangerInfo.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TapChangerInfo.fields (position), value)
        emitelem (0, bil)
        emitelem (1, ctRating)
        emitelem (2, ctRatio)
        emitelem (3, frequency)
        emitelem (4, highStep)
        emitelem (5, isTcul)
        emitelem (6, lowStep)
        emitelem (7, neutralStep)
        emitelem (8, neutralU)
        emitelem (9, ptRatio)
        emitelem (10, ratedApparentPower)
        emitelem (11, ratedCurrent)
        emitelem (12, ratedVoltage)
        emitelem (13, stepPhaseIncrement)
        emitelem (14, stepVoltageIncrement)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TapChangerInfo rdf:ID=\"%s\">\n%s\t</cim:TapChangerInfo>".format (id, export_fields)
    }
}

object TapChangerInfo
extends
    Parseable[TapChangerInfo]
{
    val fields: Array[String] = Array[String] (
        "bil",
        "ctRating",
        "ctRatio",
        "frequency",
        "highStep",
        "isTcul",
        "lowStep",
        "neutralStep",
        "neutralU",
        "ptRatio",
        "ratedApparentPower",
        "ratedCurrent",
        "ratedVoltage",
        "stepPhaseIncrement",
        "stepVoltageIncrement"
    )
    val bil: Fielder = parse_element (element (cls, fields(0)))
    val ctRating: Fielder = parse_element (element (cls, fields(1)))
    val ctRatio: Fielder = parse_element (element (cls, fields(2)))
    val frequency: Fielder = parse_element (element (cls, fields(3)))
    val highStep: Fielder = parse_element (element (cls, fields(4)))
    val isTcul: Fielder = parse_element (element (cls, fields(5)))
    val lowStep: Fielder = parse_element (element (cls, fields(6)))
    val neutralStep: Fielder = parse_element (element (cls, fields(7)))
    val neutralU: Fielder = parse_element (element (cls, fields(8)))
    val ptRatio: Fielder = parse_element (element (cls, fields(9)))
    val ratedApparentPower: Fielder = parse_element (element (cls, fields(10)))
    val ratedCurrent: Fielder = parse_element (element (cls, fields(11)))
    val ratedVoltage: Fielder = parse_element (element (cls, fields(12)))
    val stepPhaseIncrement: Fielder = parse_element (element (cls, fields(13)))
    val stepVoltageIncrement: Fielder = parse_element (element (cls, fields(14)))

    def parse (context: Context): TapChangerInfo =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TapChangerInfo (
            AssetInfo.parse (context),
            toDouble (mask (bil (), 0)),
            toDouble (mask (ctRating (), 1)),
            toDouble (mask (ctRatio (), 2)),
            toDouble (mask (frequency (), 3)),
            toInteger (mask (highStep (), 4)),
            toBoolean (mask (isTcul (), 5)),
            toInteger (mask (lowStep (), 6)),
            toInteger (mask (neutralStep (), 7)),
            toDouble (mask (neutralU (), 8)),
            toDouble (mask (ptRatio (), 9)),
            toDouble (mask (ratedApparentPower (), 10)),
            toDouble (mask (ratedCurrent (), 11)),
            toDouble (mask (ratedVoltage (), 12)),
            toDouble (mask (stepPhaseIncrement (), 13)),
            toDouble (mask (stepVoltageIncrement (), 14))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Tape shield cable data.
 *
 * @param sup [[ch.ninecode.model.CableInfo CableInfo]] Reference to the superclass object.
 * @param tapeLap Percentage of the tape shield width that overlaps in each wrap, typically 10% to 25%.
 * @param tapeThickness Thickness of the tape shield, before wrapping.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
case class TapeShieldCableInfo
(
    override val sup: CableInfo,
    tapeLap: Double,
    tapeThickness: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def CableInfo: CableInfo = sup.asInstanceOf[CableInfo]
    override def copy (): Row = { clone ().asInstanceOf[TapeShieldCableInfo] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TapeShieldCableInfo.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TapeShieldCableInfo.fields (position), value)
        emitelem (0, tapeLap)
        emitelem (1, tapeThickness)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TapeShieldCableInfo rdf:ID=\"%s\">\n%s\t</cim:TapeShieldCableInfo>".format (id, export_fields)
    }
}

object TapeShieldCableInfo
extends
    Parseable[TapeShieldCableInfo]
{
    val fields: Array[String] = Array[String] (
        "tapeLap",
        "tapeThickness"
    )
    val tapeLap: Fielder = parse_element (element (cls, fields(0)))
    val tapeThickness: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): TapeShieldCableInfo =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TapeShieldCableInfo (
            CableInfo.parse (context),
            toDouble (mask (tapeLap (), 0)),
            toDouble (mask (tapeThickness (), 1))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Transformer end data.
 *
 * @param sup [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param connectionKind Kind of connection.
 * @param emergencyS Apparent power that the winding can carry under emergency conditions (also called long-term emergency power).
 * @param endNumber Number for this transformer end, corresponding to the end's order in the PowerTransformer.vectorGroup attribute.
 *        Highest voltage winding should be 1.
 * @param insulationU Basic insulation level voltage rating.
 * @param phaseAngleClock Winding phase angle where 360 degrees are represented with clock hours, so the valid values are {0, ..., 11}.
 *        For example, to express the second winding in code 'Dyn11', set attributes as follows: 'endNumber'=2, 'connectionKind' = Yn and 'phaseAngleClock' = 11.
 * @param r DC resistance.
 * @param ratedS Normal apparent power rating.
 * @param ratedU Rated voltage: phase-phase for three-phase windings, and either phase-phase or phase-neutral for single-phase windings.
 * @param shortTermS Apparent power that this winding can carry for a short period of time (in emergency).
 * @param CoreAdmittance [[ch.ninecode.model.TransformerCoreAdmittance TransformerCoreAdmittance]] Core admittance calculated from this transformer end datasheet, representing magnetising current and core losses.
 *        The full values of the transformer should be supplied for one transformer end info only.
 * @param ToMeshImpedances [[ch.ninecode.model.TransformerMeshImpedance TransformerMeshImpedance]] All mesh impedances between this 'from' and other 'to' transformer ends.
 * @param TransformerStarImpedance [[ch.ninecode.model.TransformerStarImpedance TransformerStarImpedance]] Transformer star impedance calculated from this transformer end datasheet.
 * @param TransformerTankInfo [[ch.ninecode.model.TransformerTankInfo TransformerTankInfo]] Transformer tank data that this end description is part of.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
case class TransformerEndInfo
(
    override val sup: AssetInfo,
    connectionKind: String,
    emergencyS: Double,
    endNumber: Int,
    insulationU: Double,
    phaseAngleClock: Int,
    r: Double,
    ratedS: Double,
    ratedU: Double,
    shortTermS: Double,
    CoreAdmittance: String,
    ToMeshImpedances: List[String],
    TransformerStarImpedance: String,
    TransformerTankInfo: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, 0, 0.0, 0, 0.0, 0.0, 0.0, 0.0, null, List(), null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { clone ().asInstanceOf[TransformerEndInfo] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TransformerEndInfo.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TransformerEndInfo.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TransformerEndInfo.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (TransformerEndInfo.fields (position), x))
        emitattr (0, connectionKind)
        emitelem (1, emergencyS)
        emitelem (2, endNumber)
        emitelem (3, insulationU)
        emitelem (4, phaseAngleClock)
        emitelem (5, r)
        emitelem (6, ratedS)
        emitelem (7, ratedU)
        emitelem (8, shortTermS)
        emitattr (9, CoreAdmittance)
        emitattrs (10, ToMeshImpedances)
        emitattr (11, TransformerStarImpedance)
        emitattr (12, TransformerTankInfo)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TransformerEndInfo rdf:ID=\"%s\">\n%s\t</cim:TransformerEndInfo>".format (id, export_fields)
    }
}

object TransformerEndInfo
extends
    Parseable[TransformerEndInfo]
{
    val fields: Array[String] = Array[String] (
        "connectionKind",
        "emergencyS",
        "endNumber",
        "insulationU",
        "phaseAngleClock",
        "r",
        "ratedS",
        "ratedU",
        "shortTermS",
        "CoreAdmittance",
        "ToMeshImpedances",
        "TransformerStarImpedance",
        "TransformerTankInfo"
    )
    val connectionKind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val emergencyS: Fielder = parse_element (element (cls, fields(1)))
    val endNumber: Fielder = parse_element (element (cls, fields(2)))
    val insulationU: Fielder = parse_element (element (cls, fields(3)))
    val phaseAngleClock: Fielder = parse_element (element (cls, fields(4)))
    val r: Fielder = parse_element (element (cls, fields(5)))
    val ratedS: Fielder = parse_element (element (cls, fields(6)))
    val ratedU: Fielder = parse_element (element (cls, fields(7)))
    val shortTermS: Fielder = parse_element (element (cls, fields(8)))
    val CoreAdmittance: Fielder = parse_attribute (attribute (cls, fields(9)))
    val ToMeshImpedances: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val TransformerStarImpedance: Fielder = parse_attribute (attribute (cls, fields(11)))
    val TransformerTankInfo: Fielder = parse_attribute (attribute (cls, fields(12)))

    def parse (context: Context): TransformerEndInfo =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TransformerEndInfo (
            AssetInfo.parse (context),
            mask (connectionKind (), 0),
            toDouble (mask (emergencyS (), 1)),
            toInteger (mask (endNumber (), 2)),
            toDouble (mask (insulationU (), 3)),
            toInteger (mask (phaseAngleClock (), 4)),
            toDouble (mask (r (), 5)),
            toDouble (mask (ratedS (), 6)),
            toDouble (mask (ratedU (), 7)),
            toDouble (mask (shortTermS (), 8)),
            mask (CoreAdmittance (), 9),
            masks (ToMeshImpedances (), 10),
            mask (TransformerStarImpedance (), 11),
            mask (TransformerTankInfo (), 12)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("CoreAdmittance", "TransformerCoreAdmittance", false),
        Relationship ("ToMeshImpedances", "TransformerMeshImpedance", true),
        Relationship ("TransformerStarImpedance", "TransformerStarImpedance", false),
        Relationship ("TransformerTankInfo", "TransformerTankInfo", false)
    )
}

/**
 * Set of transformer tank data, from an equipment library.
 *
 * @param sup [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param PowerTransformerInfo [[ch.ninecode.model.PowerTransformerInfo PowerTransformerInfo]] Power transformer data that this tank description is part of.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
case class TransformerTankInfo
(
    override val sup: AssetInfo,
    PowerTransformerInfo: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { clone ().asInstanceOf[TransformerTankInfo] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TransformerTankInfo.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TransformerTankInfo.fields (position), value)
        emitattr (0, PowerTransformerInfo)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TransformerTankInfo rdf:ID=\"%s\">\n%s\t</cim:TransformerTankInfo>".format (id, export_fields)
    }
}

object TransformerTankInfo
extends
    Parseable[TransformerTankInfo]
{
    val fields: Array[String] = Array[String] (
        "PowerTransformerInfo"
    )
    val PowerTransformerInfo: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): TransformerTankInfo =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TransformerTankInfo (
            AssetInfo.parse (context),
            mask (PowerTransformerInfo (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("PowerTransformerInfo", "PowerTransformerInfo", false)
    )
}

/**
 * Test result for transformer ends, such as short-circuit, open-circuit (excitation) or no-load test.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param basePower Base power at which the tests are conducted, usually equal to the rateds of one of the involved transformer ends.
 * @param temperature Temperature at which the test is conducted.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
case class TransformerTest
(
    override val sup: IdentifiedObject,
    basePower: Double,
    temperature: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[TransformerTest] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TransformerTest.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TransformerTest.fields (position), value)
        emitelem (0, basePower)
        emitelem (1, temperature)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TransformerTest rdf:ID=\"%s\">\n%s\t</cim:TransformerTest>".format (id, export_fields)
    }
}

object TransformerTest
extends
    Parseable[TransformerTest]
{
    val fields: Array[String] = Array[String] (
        "basePower",
        "temperature"
    )
    val basePower: Fielder = parse_element (element (cls, fields(0)))
    val temperature: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): TransformerTest =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TransformerTest (
            IdentifiedObject.parse (context),
            toDouble (mask (basePower (), 0)),
            toDouble (mask (temperature (), 1))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Wire data that can be specified per line segment phase, or for the line segment as a whole in case its phases all have the same wire characteristics.
 *
 * @param sup [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param coreRadius (if there is a different core material) Radius of the central core.
 * @param coreStrandCount (if used) Number of strands in the steel core.
 * @param gmr Geometric mean radius.
 *        If we replace the conductor by a thin walled tube of radius GMR, then its reactance is identical to the reactance of the actual conductor.
 * @param insulated True if conductor is insulated.
 * @param insulationMaterial (if insulated conductor) Material used for insulation.
 * @param insulationThickness (if insulated conductor) Thickness of the insulation.
 * @param material Conductor material.
 * @param rAC25 AC resistance per unit length of the conductor at 25 �C.
 * @param rAC50 AC resistance per unit length of the conductor at 50 �C.
 * @param rAC75 AC resistance per unit length of the conductor at 75 �C.
 * @param rDC20 DC resistance per unit length of the conductor at 20 �C.
 * @param radius Outside radius of the wire.
 * @param ratedCurrent Current carrying capacity of the wire under stated thermal conditions.
 * @param sizeDescription Describes the wire gauge or cross section (e.g., 4/0, #2, 336.5).
 * @param strandCount Number of strands in the conductor.
 * @param PerLengthParameters [[ch.ninecode.model.PerLengthLineParameter PerLengthLineParameter]] All per-length parameters calculated from this wire datasheet.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
case class WireInfo
(
    override val sup: AssetInfo,
    coreRadius: Double,
    coreStrandCount: Int,
    gmr: Double,
    insulated: Boolean,
    insulationMaterial: String,
    insulationThickness: Double,
    material: String,
    rAC25: Double,
    rAC50: Double,
    rAC75: Double,
    rDC20: Double,
    radius: Double,
    ratedCurrent: Double,
    sizeDescription: String,
    strandCount: Int,
    PerLengthParameters: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0, 0.0, false, null, 0.0, null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { clone ().asInstanceOf[WireInfo] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = WireInfo.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WireInfo.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WireInfo.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (WireInfo.fields (position), x))
        emitelem (0, coreRadius)
        emitelem (1, coreStrandCount)
        emitelem (2, gmr)
        emitelem (3, insulated)
        emitattr (4, insulationMaterial)
        emitelem (5, insulationThickness)
        emitattr (6, material)
        emitelem (7, rAC25)
        emitelem (8, rAC50)
        emitelem (9, rAC75)
        emitelem (10, rDC20)
        emitelem (11, radius)
        emitelem (12, ratedCurrent)
        emitelem (13, sizeDescription)
        emitelem (14, strandCount)
        emitattrs (15, PerLengthParameters)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WireInfo rdf:ID=\"%s\">\n%s\t</cim:WireInfo>".format (id, export_fields)
    }
}

object WireInfo
extends
    Parseable[WireInfo]
{
    val fields: Array[String] = Array[String] (
        "coreRadius",
        "coreStrandCount",
        "gmr",
        "insulated",
        "insulationMaterial",
        "insulationThickness",
        "material",
        "rAC25",
        "rAC50",
        "rAC75",
        "rDC20",
        "radius",
        "ratedCurrent",
        "sizeDescription",
        "strandCount",
        "PerLengthParameters"
    )
    val coreRadius: Fielder = parse_element (element (cls, fields(0)))
    val coreStrandCount: Fielder = parse_element (element (cls, fields(1)))
    val gmr: Fielder = parse_element (element (cls, fields(2)))
    val insulated: Fielder = parse_element (element (cls, fields(3)))
    val insulationMaterial: Fielder = parse_attribute (attribute (cls, fields(4)))
    val insulationThickness: Fielder = parse_element (element (cls, fields(5)))
    val material: Fielder = parse_attribute (attribute (cls, fields(6)))
    val rAC25: Fielder = parse_element (element (cls, fields(7)))
    val rAC50: Fielder = parse_element (element (cls, fields(8)))
    val rAC75: Fielder = parse_element (element (cls, fields(9)))
    val rDC20: Fielder = parse_element (element (cls, fields(10)))
    val radius: Fielder = parse_element (element (cls, fields(11)))
    val ratedCurrent: Fielder = parse_element (element (cls, fields(12)))
    val sizeDescription: Fielder = parse_element (element (cls, fields(13)))
    val strandCount: Fielder = parse_element (element (cls, fields(14)))
    val PerLengthParameters: FielderMultiple = parse_attributes (attribute (cls, fields(15)))

    def parse (context: Context): WireInfo =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = WireInfo (
            AssetInfo.parse (context),
            toDouble (mask (coreRadius (), 0)),
            toInteger (mask (coreStrandCount (), 1)),
            toDouble (mask (gmr (), 2)),
            toBoolean (mask (insulated (), 3)),
            mask (insulationMaterial (), 4),
            toDouble (mask (insulationThickness (), 5)),
            mask (material (), 6),
            toDouble (mask (rAC25 (), 7)),
            toDouble (mask (rAC50 (), 8)),
            toDouble (mask (rAC75 (), 9)),
            toDouble (mask (rDC20 (), 10)),
            toDouble (mask (radius (), 11)),
            toDouble (mask (ratedCurrent (), 12)),
            mask (sizeDescription (), 13),
            toInteger (mask (strandCount (), 14)),
            masks (PerLengthParameters (), 15)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("PerLengthParameters", "PerLengthLineParameter", true)
    )
}

/**
 * Identification, spacing and configuration of the wires of a conductor with respect to a structure.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param phase Single phase or neutral designation for the wire with this position.
 * @param xCoord Signed horizontal distance from the wire at this position to a common reference point.
 * @param yCoord Signed vertical distance from the wire at this position: above ground (positive value) or burial depth below ground (negative value).
 * @param WireSpacingInfo [[ch.ninecode.model.WireSpacingInfo WireSpacingInfo]] Wire spacing data this wire position belongs to.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
case class WirePosition
(
    override val sup: IdentifiedObject,
    phase: String,
    xCoord: Double,
    yCoord: Double,
    WireSpacingInfo: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[WirePosition] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = WirePosition.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WirePosition.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WirePosition.fields (position), value)
        emitattr (0, phase)
        emitelem (1, xCoord)
        emitelem (2, yCoord)
        emitattr (3, WireSpacingInfo)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WirePosition rdf:ID=\"%s\">\n%s\t</cim:WirePosition>".format (id, export_fields)
    }
}

object WirePosition
extends
    Parseable[WirePosition]
{
    val fields: Array[String] = Array[String] (
        "phase",
        "xCoord",
        "yCoord",
        "WireSpacingInfo"
    )
    val phase: Fielder = parse_attribute (attribute (cls, fields(0)))
    val xCoord: Fielder = parse_element (element (cls, fields(1)))
    val yCoord: Fielder = parse_element (element (cls, fields(2)))
    val WireSpacingInfo: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): WirePosition =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = WirePosition (
            IdentifiedObject.parse (context),
            mask (phase (), 0),
            toDouble (mask (xCoord (), 1)),
            toDouble (mask (yCoord (), 2)),
            mask (WireSpacingInfo (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("WireSpacingInfo", "WireSpacingInfo", false)
    )
}

/**
 * Wire spacing data that associates multiple wire positions with the line segment, and allows to calculate line segment impedances.
 *
 * Number of phases can be derived from the number of associated wire positions whose phase is not neutral.
 *
 * @param sup [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param isCable If true, this spacing data describes a cable.
 * @param phaseWireCount Number of wire sub-conductors in the symmetrical bundle (typically between 1 and 4).
 * @param phaseWireSpacing Distance between wire sub-conductors in a symmetrical bundle.
 * @param usage Usage of the associated wires.
 * @param DuctBank [[ch.ninecode.model.DuctBank DuctBank]] <em>undocumented</em>
 * @param Structures [[ch.ninecode.model.Structure Structure]] <em>undocumented</em>
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
case class WireSpacingInfo
(
    override val sup: AssetInfo,
    isCable: Boolean,
    phaseWireCount: Int,
    phaseWireSpacing: Double,
    usage: String,
    DuctBank: String,
    Structures: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, 0, 0.0, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def AssetInfo: AssetInfo = sup.asInstanceOf[AssetInfo]
    override def copy (): Row = { clone ().asInstanceOf[WireSpacingInfo] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = WireSpacingInfo.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (WireSpacingInfo.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (WireSpacingInfo.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (WireSpacingInfo.fields (position), x))
        emitelem (0, isCable)
        emitelem (1, phaseWireCount)
        emitelem (2, phaseWireSpacing)
        emitattr (3, usage)
        emitattr (4, DuctBank)
        emitattrs (5, Structures)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:WireSpacingInfo rdf:ID=\"%s\">\n%s\t</cim:WireSpacingInfo>".format (id, export_fields)
    }
}

object WireSpacingInfo
extends
    Parseable[WireSpacingInfo]
{
    val fields: Array[String] = Array[String] (
        "isCable",
        "phaseWireCount",
        "phaseWireSpacing",
        "usage",
        "DuctBank",
        "Structures"
    )
    val isCable: Fielder = parse_element (element (cls, fields(0)))
    val phaseWireCount: Fielder = parse_element (element (cls, fields(1)))
    val phaseWireSpacing: Fielder = parse_element (element (cls, fields(2)))
    val usage: Fielder = parse_attribute (attribute (cls, fields(3)))
    val DuctBank: Fielder = parse_attribute (attribute (cls, fields(4)))
    val Structures: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: Context): WireSpacingInfo =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = WireSpacingInfo (
            AssetInfo.parse (context),
            toBoolean (mask (isCable (), 0)),
            toInteger (mask (phaseWireCount (), 1)),
            toDouble (mask (phaseWireSpacing (), 2)),
            mask (usage (), 3),
            mask (DuctBank (), 4),
            masks (Structures (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("DuctBank", "DuctBank", false),
        Relationship ("Structures", "Structure", true)
    )
}

private[ninecode] object _AssetInfo
{
    def register: List[ClassInfo] =
    {
        List (
            BusbarSectionInfo.register,
            CableInfo.register,
            ConcentricNeutralCableInfo.register,
            NoLoadTest.register,
            OpenCircuitTest.register,
            OverheadWireInfo.register,
            PowerTransformerInfo.register,
            ShortCircuitTest.register,
            ShuntCompensatorInfo.register,
            SwitchInfo.register,
            TapChangerInfo.register,
            TapeShieldCableInfo.register,
            TransformerEndInfo.register,
            TransformerTankInfo.register,
            TransformerTest.register,
            WireInfo.register,
            WirePosition.register,
            WireSpacingInfo.register
        )
    }
}
package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * Busbar section data.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        "\t\t<cim:BusbarSectionInfo.ratedCurrent>" + ratedCurrent + "</cim:BusbarSectionInfo.ratedCurrent>\n" +
        "\t\t<cim:BusbarSectionInfo.ratedVoltage>" + ratedVoltage + "</cim:BusbarSectionInfo.ratedVoltage>\n"
    }
    override def export: String =
    {
        "\t<cim:BusbarSectionInfo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BusbarSectionInfo>"
    }
}

object BusbarSectionInfo
extends
    Parseable[BusbarSectionInfo]
{
    val ratedCurrent = parse_element (element ("""BusbarSectionInfo.ratedCurrent"""))
    val ratedVoltage = parse_element (element ("""BusbarSectionInfo.ratedVoltage"""))
    def parse (context: Context): BusbarSectionInfo =
    {
        BusbarSectionInfo(
            AssetInfo.parse (context),
            toDouble (ratedCurrent (context), context),
            toDouble (ratedVoltage (context), context)
        )
    }
}

/**
 * Cable data.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        (if (null != constructionKind) "\t\t<cim:CableInfo.constructionKind rdf:resource=\"#" + constructionKind + "\"/>\n" else "") +
        "\t\t<cim:CableInfo.diameterOverCore>" + diameterOverCore + "</cim:CableInfo.diameterOverCore>\n" +
        "\t\t<cim:CableInfo.diameterOverInsulation>" + diameterOverInsulation + "</cim:CableInfo.diameterOverInsulation>\n" +
        "\t\t<cim:CableInfo.diameterOverJacket>" + diameterOverJacket + "</cim:CableInfo.diameterOverJacket>\n" +
        "\t\t<cim:CableInfo.diameterOverScreen>" + diameterOverScreen + "</cim:CableInfo.diameterOverScreen>\n" +
        "\t\t<cim:CableInfo.isStrandFill>" + isStrandFill + "</cim:CableInfo.isStrandFill>\n" +
        "\t\t<cim:CableInfo.nominalTemperature>" + nominalTemperature + "</cim:CableInfo.nominalTemperature>\n" +
        (if (null != outerJacketKind) "\t\t<cim:CableInfo.outerJacketKind rdf:resource=\"#" + outerJacketKind + "\"/>\n" else "") +
        "\t\t<cim:CableInfo.sheathAsNeutral>" + sheathAsNeutral + "</cim:CableInfo.sheathAsNeutral>\n" +
        (if (null != shieldMaterial) "\t\t<cim:CableInfo.shieldMaterial rdf:resource=\"#" + shieldMaterial + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CableInfo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CableInfo>"
    }
}

object CableInfo
extends
    Parseable[CableInfo]
{
    val constructionKind = parse_attribute (attribute ("""CableInfo.constructionKind"""))
    val diameterOverCore = parse_element (element ("""CableInfo.diameterOverCore"""))
    val diameterOverInsulation = parse_element (element ("""CableInfo.diameterOverInsulation"""))
    val diameterOverJacket = parse_element (element ("""CableInfo.diameterOverJacket"""))
    val diameterOverScreen = parse_element (element ("""CableInfo.diameterOverScreen"""))
    val isStrandFill = parse_element (element ("""CableInfo.isStrandFill"""))
    val nominalTemperature = parse_element (element ("""CableInfo.nominalTemperature"""))
    val outerJacketKind = parse_attribute (attribute ("""CableInfo.outerJacketKind"""))
    val sheathAsNeutral = parse_element (element ("""CableInfo.sheathAsNeutral"""))
    val shieldMaterial = parse_attribute (attribute ("""CableInfo.shieldMaterial"""))
    def parse (context: Context): CableInfo =
    {
        CableInfo(
            WireInfo.parse (context),
            constructionKind (context),
            toDouble (diameterOverCore (context), context),
            toDouble (diameterOverInsulation (context), context),
            toDouble (diameterOverJacket (context), context),
            toDouble (diameterOverScreen (context), context),
            toBoolean (isStrandFill (context), context),
            toDouble (nominalTemperature (context), context),
            outerJacketKind (context),
            toBoolean (sheathAsNeutral (context), context),
            shieldMaterial (context)
        )
    }
}

/**
 * Concentric neutral cable data.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        "\t\t<cim:ConcentricNeutralCableInfo.diameterOverNeutral>" + diameterOverNeutral + "</cim:ConcentricNeutralCableInfo.diameterOverNeutral>\n" +
        "\t\t<cim:ConcentricNeutralCableInfo.neutralStrandCount>" + neutralStrandCount + "</cim:ConcentricNeutralCableInfo.neutralStrandCount>\n" +
        "\t\t<cim:ConcentricNeutralCableInfo.neutralStrandGmr>" + neutralStrandGmr + "</cim:ConcentricNeutralCableInfo.neutralStrandGmr>\n" +
        "\t\t<cim:ConcentricNeutralCableInfo.neutralStrandRDC20>" + neutralStrandRDC20 + "</cim:ConcentricNeutralCableInfo.neutralStrandRDC20>\n" +
        "\t\t<cim:ConcentricNeutralCableInfo.neutralStrandRadius>" + neutralStrandRadius + "</cim:ConcentricNeutralCableInfo.neutralStrandRadius>\n"
    }
    override def export: String =
    {
        "\t<cim:ConcentricNeutralCableInfo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ConcentricNeutralCableInfo>"
    }
}

object ConcentricNeutralCableInfo
extends
    Parseable[ConcentricNeutralCableInfo]
{
    val diameterOverNeutral = parse_element (element ("""ConcentricNeutralCableInfo.diameterOverNeutral"""))
    val neutralStrandCount = parse_element (element ("""ConcentricNeutralCableInfo.neutralStrandCount"""))
    val neutralStrandGmr = parse_element (element ("""ConcentricNeutralCableInfo.neutralStrandGmr"""))
    val neutralStrandRDC20 = parse_element (element ("""ConcentricNeutralCableInfo.neutralStrandRDC20"""))
    val neutralStrandRadius = parse_element (element ("""ConcentricNeutralCableInfo.neutralStrandRadius"""))
    def parse (context: Context): ConcentricNeutralCableInfo =
    {
        ConcentricNeutralCableInfo(
            CableInfo.parse (context),
            toDouble (diameterOverNeutral (context), context),
            toInteger (neutralStrandCount (context), context),
            toDouble (neutralStrandGmr (context), context),
            toDouble (neutralStrandRDC20 (context), context),
            toDouble (neutralStrandRadius (context), context)
        )
    }
}

/**
 * No-load test results determine core admittance parameters.
 * They include exciting current and core loss measurements from applying voltage to one winding. The excitation may be positive sequence or zero sequence. The test may be repeated at different voltages to measure saturation.
 *
 * @param sup Reference to the superclass object.
 * @param energisedEndVoltage Voltage applied to the winding (end) during test.
 * @param excitingCurrent Exciting current measured from a positive-sequence or single-phase excitation test.
 * @param excitingCurrentZero Exciting current measured from a zero-sequence open-circuit excitation test.
 * @param loss Losses measured from a positive-sequence or single-phase excitation test.
 * @param lossZero Losses measured from a zero-sequence excitation test.
 * @param EnergisedEnd Transformer end that current is applied to in this no-load test.
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
        sup.export_fields +
        "\t\t<cim:NoLoadTest.energisedEndVoltage>" + energisedEndVoltage + "</cim:NoLoadTest.energisedEndVoltage>\n" +
        "\t\t<cim:NoLoadTest.excitingCurrent>" + excitingCurrent + "</cim:NoLoadTest.excitingCurrent>\n" +
        "\t\t<cim:NoLoadTest.excitingCurrentZero>" + excitingCurrentZero + "</cim:NoLoadTest.excitingCurrentZero>\n" +
        "\t\t<cim:NoLoadTest.loss>" + loss + "</cim:NoLoadTest.loss>\n" +
        "\t\t<cim:NoLoadTest.lossZero>" + lossZero + "</cim:NoLoadTest.lossZero>\n" +
        (if (null != EnergisedEnd) "\t\t<cim:NoLoadTest.EnergisedEnd rdf:resource=\"#" + EnergisedEnd + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:NoLoadTest rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:NoLoadTest>"
    }
}

object NoLoadTest
extends
    Parseable[NoLoadTest]
{
    val energisedEndVoltage = parse_element (element ("""NoLoadTest.energisedEndVoltage"""))
    val excitingCurrent = parse_element (element ("""NoLoadTest.excitingCurrent"""))
    val excitingCurrentZero = parse_element (element ("""NoLoadTest.excitingCurrentZero"""))
    val loss = parse_element (element ("""NoLoadTest.loss"""))
    val lossZero = parse_element (element ("""NoLoadTest.lossZero"""))
    val EnergisedEnd = parse_attribute (attribute ("""NoLoadTest.EnergisedEnd"""))
    def parse (context: Context): NoLoadTest =
    {
        NoLoadTest(
            TransformerTest.parse (context),
            toDouble (energisedEndVoltage (context), context),
            toDouble (excitingCurrent (context), context),
            toDouble (excitingCurrentZero (context), context),
            toDouble (loss (context), context),
            toDouble (lossZero (context), context),
            EnergisedEnd (context)
        )
    }
}

/**
 * Open-circuit test results verify winding turn ratios and phase shifts.
 * They include induced voltage and phase shift measurements on open-circuit windings, with voltage applied to the energised end. For three-phase windings, the excitation can be a positive sequence (the default) or a zero sequence.
 *
 * @param sup Reference to the superclass object.
 * @param energisedEndStep Tap step number for the energised end of the test pair.
 * @param energisedEndVoltage Voltage applied to the winding (end) during test.
 * @param openEndStep Tap step number for the open end of the test pair.
 * @param openEndVoltage Voltage measured at the open-circuited end, with the energised end set to rated voltage and all other ends open.
 * @param phaseShift Phase shift measured at the open end with the energised end set to rated voltage and all other ends open.
 * @param EnergisedEnd Transformer end that current is applied to in this open-circuit test.
 * @param OpenEnd Transformer end measured for induced voltage and angle in this open-circuit test.
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
        sup.export_fields +
        "\t\t<cim:OpenCircuitTest.energisedEndStep>" + energisedEndStep + "</cim:OpenCircuitTest.energisedEndStep>\n" +
        "\t\t<cim:OpenCircuitTest.energisedEndVoltage>" + energisedEndVoltage + "</cim:OpenCircuitTest.energisedEndVoltage>\n" +
        "\t\t<cim:OpenCircuitTest.openEndStep>" + openEndStep + "</cim:OpenCircuitTest.openEndStep>\n" +
        "\t\t<cim:OpenCircuitTest.openEndVoltage>" + openEndVoltage + "</cim:OpenCircuitTest.openEndVoltage>\n" +
        "\t\t<cim:OpenCircuitTest.phaseShift>" + phaseShift + "</cim:OpenCircuitTest.phaseShift>\n" +
        (if (null != EnergisedEnd) "\t\t<cim:OpenCircuitTest.EnergisedEnd rdf:resource=\"#" + EnergisedEnd + "\"/>\n" else "") +
        (if (null != OpenEnd) "\t\t<cim:OpenCircuitTest.OpenEnd rdf:resource=\"#" + OpenEnd + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OpenCircuitTest rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OpenCircuitTest>"
    }
}

object OpenCircuitTest
extends
    Parseable[OpenCircuitTest]
{
    val energisedEndStep = parse_element (element ("""OpenCircuitTest.energisedEndStep"""))
    val energisedEndVoltage = parse_element (element ("""OpenCircuitTest.energisedEndVoltage"""))
    val openEndStep = parse_element (element ("""OpenCircuitTest.openEndStep"""))
    val openEndVoltage = parse_element (element ("""OpenCircuitTest.openEndVoltage"""))
    val phaseShift = parse_element (element ("""OpenCircuitTest.phaseShift"""))
    val EnergisedEnd = parse_attribute (attribute ("""OpenCircuitTest.EnergisedEnd"""))
    val OpenEnd = parse_attribute (attribute ("""OpenCircuitTest.OpenEnd"""))
    def parse (context: Context): OpenCircuitTest =
    {
        OpenCircuitTest(
            TransformerTest.parse (context),
            toInteger (energisedEndStep (context), context),
            toDouble (energisedEndVoltage (context), context),
            toInteger (openEndStep (context), context),
            toDouble (openEndVoltage (context), context),
            toDouble (phaseShift (context), context),
            EnergisedEnd (context),
            OpenEnd (context)
        )
    }
}

/**
 * Overhead wire data.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:OverheadWireInfo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OverheadWireInfo>"
    }
}

object OverheadWireInfo
extends
    Parseable[OverheadWireInfo]
{
    def parse (context: Context): OverheadWireInfo =
    {
        OverheadWireInfo(
            WireInfo.parse (context)
        )
    }
}

/**
 * Set of power transformer data, from an equipment library.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:PowerTransformerInfo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PowerTransformerInfo>"
    }
}

object PowerTransformerInfo
extends
    Parseable[PowerTransformerInfo]
{
    def parse (context: Context): PowerTransformerInfo =
    {
        PowerTransformerInfo(
            AssetInfo.parse (context)
        )
    }
}

/**
 * Short-circuit test results determine mesh impedance parameters.
 * They include load losses and leakage impedances. For three-phase windings, the excitation can be a positive sequence (the default) or a zero sequence. There shall be at least one grounded winding.
 *
 * @param sup Reference to the superclass object.
 * @param energisedEndStep Tap step number for the energised end of the test pair.
 * @param groundedEndStep Tap step number for the grounded end of the test pair.
 * @param leakageImpedance Leakage impedance measured from a positive-sequence or single-phase short-circuit test.
 * @param leakageImpedanceZero Leakage impedance measured from a zero-sequence short-circuit test.
 * @param loss Load losses from a positive-sequence or single-phase short-circuit test.
 * @param lossZero Load losses from a zero-sequence short-circuit test.
 * @param EnergisedEnd Transformer end that voltage is applied to in this short-circuit test.
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
        sup.export_fields +
        "\t\t<cim:ShortCircuitTest.energisedEndStep>" + energisedEndStep + "</cim:ShortCircuitTest.energisedEndStep>\n" +
        "\t\t<cim:ShortCircuitTest.groundedEndStep>" + groundedEndStep + "</cim:ShortCircuitTest.groundedEndStep>\n" +
        "\t\t<cim:ShortCircuitTest.leakageImpedance>" + leakageImpedance + "</cim:ShortCircuitTest.leakageImpedance>\n" +
        "\t\t<cim:ShortCircuitTest.leakageImpedanceZero>" + leakageImpedanceZero + "</cim:ShortCircuitTest.leakageImpedanceZero>\n" +
        "\t\t<cim:ShortCircuitTest.loss>" + loss + "</cim:ShortCircuitTest.loss>\n" +
        "\t\t<cim:ShortCircuitTest.lossZero>" + lossZero + "</cim:ShortCircuitTest.lossZero>\n" +
        (if (null != EnergisedEnd) "\t\t<cim:ShortCircuitTest.EnergisedEnd rdf:resource=\"#" + EnergisedEnd + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ShortCircuitTest rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ShortCircuitTest>"
    }
}

object ShortCircuitTest
extends
    Parseable[ShortCircuitTest]
{
    val energisedEndStep = parse_element (element ("""ShortCircuitTest.energisedEndStep"""))
    val groundedEndStep = parse_element (element ("""ShortCircuitTest.groundedEndStep"""))
    val leakageImpedance = parse_element (element ("""ShortCircuitTest.leakageImpedance"""))
    val leakageImpedanceZero = parse_element (element ("""ShortCircuitTest.leakageImpedanceZero"""))
    val loss = parse_element (element ("""ShortCircuitTest.loss"""))
    val lossZero = parse_element (element ("""ShortCircuitTest.lossZero"""))
    val EnergisedEnd = parse_attribute (attribute ("""ShortCircuitTest.EnergisedEnd"""))
    def parse (context: Context): ShortCircuitTest =
    {
        ShortCircuitTest(
            TransformerTest.parse (context),
            toInteger (energisedEndStep (context), context),
            toInteger (groundedEndStep (context), context),
            toDouble (leakageImpedance (context), context),
            toDouble (leakageImpedanceZero (context), context),
            toDouble (loss (context), context),
            toDouble (lossZero (context), context),
            EnergisedEnd (context)
        )
    }
}

/**
 * Properties of shunt capacitor, shunt reactor or switchable bank of shunt capacitor or reactor assets.
 *
 * @param sup Reference to the superclass object.
 * @param maxPowerLoss Maximum allowed apparent power loss.
 * @param ratedCurrent Rated current.
 * @param ratedReactivePower Rated reactive power.
 * @param ratedVoltage Rated voltage.
 * @param ShuntCompensatorControl <em>undocumented</em>
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
        sup.export_fields +
        "\t\t<cim:ShuntCompensatorInfo.maxPowerLoss>" + maxPowerLoss + "</cim:ShuntCompensatorInfo.maxPowerLoss>\n" +
        "\t\t<cim:ShuntCompensatorInfo.ratedCurrent>" + ratedCurrent + "</cim:ShuntCompensatorInfo.ratedCurrent>\n" +
        "\t\t<cim:ShuntCompensatorInfo.ratedReactivePower>" + ratedReactivePower + "</cim:ShuntCompensatorInfo.ratedReactivePower>\n" +
        "\t\t<cim:ShuntCompensatorInfo.ratedVoltage>" + ratedVoltage + "</cim:ShuntCompensatorInfo.ratedVoltage>\n" +
        (if (null != ShuntCompensatorControl) "\t\t<cim:ShuntCompensatorInfo.ShuntCompensatorControl rdf:resource=\"#" + ShuntCompensatorControl + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ShuntCompensatorInfo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ShuntCompensatorInfo>"
    }
}

object ShuntCompensatorInfo
extends
    Parseable[ShuntCompensatorInfo]
{
    val maxPowerLoss = parse_element (element ("""ShuntCompensatorInfo.maxPowerLoss"""))
    val ratedCurrent = parse_element (element ("""ShuntCompensatorInfo.ratedCurrent"""))
    val ratedReactivePower = parse_element (element ("""ShuntCompensatorInfo.ratedReactivePower"""))
    val ratedVoltage = parse_element (element ("""ShuntCompensatorInfo.ratedVoltage"""))
    val ShuntCompensatorControl = parse_attribute (attribute ("""ShuntCompensatorInfo.ShuntCompensatorControl"""))
    def parse (context: Context): ShuntCompensatorInfo =
    {
        ShuntCompensatorInfo(
            AssetInfo.parse (context),
            toDouble (maxPowerLoss (context), context),
            toDouble (ratedCurrent (context), context),
            toDouble (ratedReactivePower (context), context),
            toDouble (ratedVoltage (context), context),
            ShuntCompensatorControl (context)
        )
    }
}

/**
 * Switch data.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        "\t\t<cim:SwitchInfo.breakingCapacity>" + breakingCapacity + "</cim:SwitchInfo.breakingCapacity>\n" +
        "\t\t<cim:SwitchInfo.isSinglePhase>" + isSinglePhase + "</cim:SwitchInfo.isSinglePhase>\n" +
        "\t\t<cim:SwitchInfo.isUnganged>" + isUnganged + "</cim:SwitchInfo.isUnganged>\n" +
        "\t\t<cim:SwitchInfo.ratedCurrent>" + ratedCurrent + "</cim:SwitchInfo.ratedCurrent>\n" +
        "\t\t<cim:SwitchInfo.ratedVoltage>" + ratedVoltage + "</cim:SwitchInfo.ratedVoltage>\n"
    }
    override def export: String =
    {
        "\t<cim:SwitchInfo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SwitchInfo>"
    }
}

object SwitchInfo
extends
    Parseable[SwitchInfo]
{
    val breakingCapacity = parse_element (element ("""SwitchInfo.breakingCapacity"""))
    val isSinglePhase = parse_element (element ("""SwitchInfo.isSinglePhase"""))
    val isUnganged = parse_element (element ("""SwitchInfo.isUnganged"""))
    val ratedCurrent = parse_element (element ("""SwitchInfo.ratedCurrent"""))
    val ratedVoltage = parse_element (element ("""SwitchInfo.ratedVoltage"""))
    def parse (context: Context): SwitchInfo =
    {
        SwitchInfo(
            AssetInfo.parse (context),
            toDouble (breakingCapacity (context), context),
            toBoolean (isSinglePhase (context), context),
            toBoolean (isUnganged (context), context),
            toDouble (ratedCurrent (context), context),
            toDouble (ratedVoltage (context), context)
        )
    }
}

/**
 * Tap changer data.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        "\t\t<cim:TapChangerInfo.bil>" + bil + "</cim:TapChangerInfo.bil>\n" +
        "\t\t<cim:TapChangerInfo.ctRating>" + ctRating + "</cim:TapChangerInfo.ctRating>\n" +
        "\t\t<cim:TapChangerInfo.ctRatio>" + ctRatio + "</cim:TapChangerInfo.ctRatio>\n" +
        "\t\t<cim:TapChangerInfo.frequency>" + frequency + "</cim:TapChangerInfo.frequency>\n" +
        "\t\t<cim:TapChangerInfo.highStep>" + highStep + "</cim:TapChangerInfo.highStep>\n" +
        "\t\t<cim:TapChangerInfo.isTcul>" + isTcul + "</cim:TapChangerInfo.isTcul>\n" +
        "\t\t<cim:TapChangerInfo.lowStep>" + lowStep + "</cim:TapChangerInfo.lowStep>\n" +
        "\t\t<cim:TapChangerInfo.neutralStep>" + neutralStep + "</cim:TapChangerInfo.neutralStep>\n" +
        "\t\t<cim:TapChangerInfo.neutralU>" + neutralU + "</cim:TapChangerInfo.neutralU>\n" +
        "\t\t<cim:TapChangerInfo.ptRatio>" + ptRatio + "</cim:TapChangerInfo.ptRatio>\n" +
        "\t\t<cim:TapChangerInfo.ratedApparentPower>" + ratedApparentPower + "</cim:TapChangerInfo.ratedApparentPower>\n" +
        "\t\t<cim:TapChangerInfo.ratedCurrent>" + ratedCurrent + "</cim:TapChangerInfo.ratedCurrent>\n" +
        "\t\t<cim:TapChangerInfo.ratedVoltage>" + ratedVoltage + "</cim:TapChangerInfo.ratedVoltage>\n" +
        "\t\t<cim:TapChangerInfo.stepPhaseIncrement>" + stepPhaseIncrement + "</cim:TapChangerInfo.stepPhaseIncrement>\n" +
        "\t\t<cim:TapChangerInfo.stepVoltageIncrement>" + stepVoltageIncrement + "</cim:TapChangerInfo.stepVoltageIncrement>\n"
    }
    override def export: String =
    {
        "\t<cim:TapChangerInfo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TapChangerInfo>"
    }
}

object TapChangerInfo
extends
    Parseable[TapChangerInfo]
{
    val bil = parse_element (element ("""TapChangerInfo.bil"""))
    val ctRating = parse_element (element ("""TapChangerInfo.ctRating"""))
    val ctRatio = parse_element (element ("""TapChangerInfo.ctRatio"""))
    val frequency = parse_element (element ("""TapChangerInfo.frequency"""))
    val highStep = parse_element (element ("""TapChangerInfo.highStep"""))
    val isTcul = parse_element (element ("""TapChangerInfo.isTcul"""))
    val lowStep = parse_element (element ("""TapChangerInfo.lowStep"""))
    val neutralStep = parse_element (element ("""TapChangerInfo.neutralStep"""))
    val neutralU = parse_element (element ("""TapChangerInfo.neutralU"""))
    val ptRatio = parse_element (element ("""TapChangerInfo.ptRatio"""))
    val ratedApparentPower = parse_element (element ("""TapChangerInfo.ratedApparentPower"""))
    val ratedCurrent = parse_element (element ("""TapChangerInfo.ratedCurrent"""))
    val ratedVoltage = parse_element (element ("""TapChangerInfo.ratedVoltage"""))
    val stepPhaseIncrement = parse_element (element ("""TapChangerInfo.stepPhaseIncrement"""))
    val stepVoltageIncrement = parse_element (element ("""TapChangerInfo.stepVoltageIncrement"""))
    def parse (context: Context): TapChangerInfo =
    {
        TapChangerInfo(
            AssetInfo.parse (context),
            toDouble (bil (context), context),
            toDouble (ctRating (context), context),
            toDouble (ctRatio (context), context),
            toDouble (frequency (context), context),
            toInteger (highStep (context), context),
            toBoolean (isTcul (context), context),
            toInteger (lowStep (context), context),
            toInteger (neutralStep (context), context),
            toDouble (neutralU (context), context),
            toDouble (ptRatio (context), context),
            toDouble (ratedApparentPower (context), context),
            toDouble (ratedCurrent (context), context),
            toDouble (ratedVoltage (context), context),
            toDouble (stepPhaseIncrement (context), context),
            toDouble (stepVoltageIncrement (context), context)
        )
    }
}

/**
 * Tape shield cable data.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        "\t\t<cim:TapeShieldCableInfo.tapeLap>" + tapeLap + "</cim:TapeShieldCableInfo.tapeLap>\n" +
        "\t\t<cim:TapeShieldCableInfo.tapeThickness>" + tapeThickness + "</cim:TapeShieldCableInfo.tapeThickness>\n"
    }
    override def export: String =
    {
        "\t<cim:TapeShieldCableInfo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TapeShieldCableInfo>"
    }
}

object TapeShieldCableInfo
extends
    Parseable[TapeShieldCableInfo]
{
    val tapeLap = parse_element (element ("""TapeShieldCableInfo.tapeLap"""))
    val tapeThickness = parse_element (element ("""TapeShieldCableInfo.tapeThickness"""))
    def parse (context: Context): TapeShieldCableInfo =
    {
        TapeShieldCableInfo(
            CableInfo.parse (context),
            toDouble (tapeLap (context), context),
            toDouble (tapeThickness (context), context)
        )
    }
}

/**
 * Transformer end data.
 *
 * @param sup Reference to the superclass object.
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
 * @param CoreAdmittance Core admittance calculated from this transformer end datasheet, representing magnetising current and core losses.
 *        The full values of the transformer should be supplied for one transformer end info only.
 * @param ToMeshImpedances All mesh impedances between this 'from' and other 'to' transformer ends.
 * @param TransformerStarImpedance Transformer star impedance calculated from this transformer end datasheet.
 * @param TransformerTankInfo Transformer tank data that this end description is part of.
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
        sup.export_fields +
        (if (null != connectionKind) "\t\t<cim:TransformerEndInfo.connectionKind rdf:resource=\"#" + connectionKind + "\"/>\n" else "") +
        "\t\t<cim:TransformerEndInfo.emergencyS>" + emergencyS + "</cim:TransformerEndInfo.emergencyS>\n" +
        "\t\t<cim:TransformerEndInfo.endNumber>" + endNumber + "</cim:TransformerEndInfo.endNumber>\n" +
        "\t\t<cim:TransformerEndInfo.insulationU>" + insulationU + "</cim:TransformerEndInfo.insulationU>\n" +
        "\t\t<cim:TransformerEndInfo.phaseAngleClock>" + phaseAngleClock + "</cim:TransformerEndInfo.phaseAngleClock>\n" +
        "\t\t<cim:TransformerEndInfo.r>" + r + "</cim:TransformerEndInfo.r>\n" +
        "\t\t<cim:TransformerEndInfo.ratedS>" + ratedS + "</cim:TransformerEndInfo.ratedS>\n" +
        "\t\t<cim:TransformerEndInfo.ratedU>" + ratedU + "</cim:TransformerEndInfo.ratedU>\n" +
        "\t\t<cim:TransformerEndInfo.shortTermS>" + shortTermS + "</cim:TransformerEndInfo.shortTermS>\n" +
        (if (null != CoreAdmittance) "\t\t<cim:TransformerEndInfo.CoreAdmittance rdf:resource=\"#" + CoreAdmittance + "\"/>\n" else "") +
        (if (null != ToMeshImpedances) ToMeshImpedances.map (x => "\t\t<cim:TransformerEndInfo.ToMeshImpedances rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != TransformerStarImpedance) "\t\t<cim:TransformerEndInfo.TransformerStarImpedance rdf:resource=\"#" + TransformerStarImpedance + "\"/>\n" else "") +
        (if (null != TransformerTankInfo) "\t\t<cim:TransformerEndInfo.TransformerTankInfo rdf:resource=\"#" + TransformerTankInfo + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TransformerEndInfo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TransformerEndInfo>"
    }
}

object TransformerEndInfo
extends
    Parseable[TransformerEndInfo]
{
    val connectionKind = parse_attribute (attribute ("""TransformerEndInfo.connectionKind"""))
    val emergencyS = parse_element (element ("""TransformerEndInfo.emergencyS"""))
    val endNumber = parse_element (element ("""TransformerEndInfo.endNumber"""))
    val insulationU = parse_element (element ("""TransformerEndInfo.insulationU"""))
    val phaseAngleClock = parse_element (element ("""TransformerEndInfo.phaseAngleClock"""))
    val r = parse_element (element ("""TransformerEndInfo.r"""))
    val ratedS = parse_element (element ("""TransformerEndInfo.ratedS"""))
    val ratedU = parse_element (element ("""TransformerEndInfo.ratedU"""))
    val shortTermS = parse_element (element ("""TransformerEndInfo.shortTermS"""))
    val CoreAdmittance = parse_attribute (attribute ("""TransformerEndInfo.CoreAdmittance"""))
    val ToMeshImpedances = parse_attributes (attribute ("""TransformerEndInfo.ToMeshImpedances"""))
    val TransformerStarImpedance = parse_attribute (attribute ("""TransformerEndInfo.TransformerStarImpedance"""))
    val TransformerTankInfo = parse_attribute (attribute ("""TransformerEndInfo.TransformerTankInfo"""))
    def parse (context: Context): TransformerEndInfo =
    {
        TransformerEndInfo(
            AssetInfo.parse (context),
            connectionKind (context),
            toDouble (emergencyS (context), context),
            toInteger (endNumber (context), context),
            toDouble (insulationU (context), context),
            toInteger (phaseAngleClock (context), context),
            toDouble (r (context), context),
            toDouble (ratedS (context), context),
            toDouble (ratedU (context), context),
            toDouble (shortTermS (context), context),
            CoreAdmittance (context),
            ToMeshImpedances (context),
            TransformerStarImpedance (context),
            TransformerTankInfo (context)
        )
    }
}

/**
 * Set of transformer tank data, from an equipment library.
 *
 * @param sup Reference to the superclass object.
 * @param PowerTransformerInfo Power transformer data that this tank description is part of.
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
        sup.export_fields +
        (if (null != PowerTransformerInfo) "\t\t<cim:TransformerTankInfo.PowerTransformerInfo rdf:resource=\"#" + PowerTransformerInfo + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TransformerTankInfo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TransformerTankInfo>"
    }
}

object TransformerTankInfo
extends
    Parseable[TransformerTankInfo]
{
    val PowerTransformerInfo = parse_attribute (attribute ("""TransformerTankInfo.PowerTransformerInfo"""))
    def parse (context: Context): TransformerTankInfo =
    {
        TransformerTankInfo(
            AssetInfo.parse (context),
            PowerTransformerInfo (context)
        )
    }
}

/**
 * Test result for transformer ends, such as short-circuit, open-circuit (excitation) or no-load test.
 *
 * @param sup Reference to the superclass object.
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
        sup.export_fields +
        "\t\t<cim:TransformerTest.basePower>" + basePower + "</cim:TransformerTest.basePower>\n" +
        "\t\t<cim:TransformerTest.temperature>" + temperature + "</cim:TransformerTest.temperature>\n"
    }
    override def export: String =
    {
        "\t<cim:TransformerTest rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TransformerTest>"
    }
}

object TransformerTest
extends
    Parseable[TransformerTest]
{
    val basePower = parse_element (element ("""TransformerTest.basePower"""))
    val temperature = parse_element (element ("""TransformerTest.temperature"""))
    def parse (context: Context): TransformerTest =
    {
        TransformerTest(
            IdentifiedObject.parse (context),
            toDouble (basePower (context), context),
            toDouble (temperature (context), context)
        )
    }
}

/**
 * Wire data that can be specified per line segment phase, or for the line segment as a whole in case its phases all have the same wire characteristics.
 *
 * @param sup Reference to the superclass object.
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
 * @param PerLengthParameters All per-length parameters calculated from this wire datasheet.
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
        sup.export_fields +
        "\t\t<cim:WireInfo.coreRadius>" + coreRadius + "</cim:WireInfo.coreRadius>\n" +
        "\t\t<cim:WireInfo.coreStrandCount>" + coreStrandCount + "</cim:WireInfo.coreStrandCount>\n" +
        "\t\t<cim:WireInfo.gmr>" + gmr + "</cim:WireInfo.gmr>\n" +
        "\t\t<cim:WireInfo.insulated>" + insulated + "</cim:WireInfo.insulated>\n" +
        (if (null != insulationMaterial) "\t\t<cim:WireInfo.insulationMaterial rdf:resource=\"#" + insulationMaterial + "\"/>\n" else "") +
        "\t\t<cim:WireInfo.insulationThickness>" + insulationThickness + "</cim:WireInfo.insulationThickness>\n" +
        (if (null != material) "\t\t<cim:WireInfo.material rdf:resource=\"#" + material + "\"/>\n" else "") +
        "\t\t<cim:WireInfo.rAC25>" + rAC25 + "</cim:WireInfo.rAC25>\n" +
        "\t\t<cim:WireInfo.rAC50>" + rAC50 + "</cim:WireInfo.rAC50>\n" +
        "\t\t<cim:WireInfo.rAC75>" + rAC75 + "</cim:WireInfo.rAC75>\n" +
        "\t\t<cim:WireInfo.rDC20>" + rDC20 + "</cim:WireInfo.rDC20>\n" +
        "\t\t<cim:WireInfo.radius>" + radius + "</cim:WireInfo.radius>\n" +
        "\t\t<cim:WireInfo.ratedCurrent>" + ratedCurrent + "</cim:WireInfo.ratedCurrent>\n" +
        (if (null != sizeDescription) "\t\t<cim:WireInfo.sizeDescription>" + sizeDescription + "</cim:WireInfo.sizeDescription>\n" else "") +
        "\t\t<cim:WireInfo.strandCount>" + strandCount + "</cim:WireInfo.strandCount>\n" +
        (if (null != PerLengthParameters) PerLengthParameters.map (x => "\t\t<cim:WireInfo.PerLengthParameters rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:WireInfo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WireInfo>"
    }
}

object WireInfo
extends
    Parseable[WireInfo]
{
    val coreRadius = parse_element (element ("""WireInfo.coreRadius"""))
    val coreStrandCount = parse_element (element ("""WireInfo.coreStrandCount"""))
    val gmr = parse_element (element ("""WireInfo.gmr"""))
    val insulated = parse_element (element ("""WireInfo.insulated"""))
    val insulationMaterial = parse_attribute (attribute ("""WireInfo.insulationMaterial"""))
    val insulationThickness = parse_element (element ("""WireInfo.insulationThickness"""))
    val material = parse_attribute (attribute ("""WireInfo.material"""))
    val rAC25 = parse_element (element ("""WireInfo.rAC25"""))
    val rAC50 = parse_element (element ("""WireInfo.rAC50"""))
    val rAC75 = parse_element (element ("""WireInfo.rAC75"""))
    val rDC20 = parse_element (element ("""WireInfo.rDC20"""))
    val radius = parse_element (element ("""WireInfo.radius"""))
    val ratedCurrent = parse_element (element ("""WireInfo.ratedCurrent"""))
    val sizeDescription = parse_element (element ("""WireInfo.sizeDescription"""))
    val strandCount = parse_element (element ("""WireInfo.strandCount"""))
    val PerLengthParameters = parse_attributes (attribute ("""WireInfo.PerLengthParameters"""))
    def parse (context: Context): WireInfo =
    {
        WireInfo(
            AssetInfo.parse (context),
            toDouble (coreRadius (context), context),
            toInteger (coreStrandCount (context), context),
            toDouble (gmr (context), context),
            toBoolean (insulated (context), context),
            insulationMaterial (context),
            toDouble (insulationThickness (context), context),
            material (context),
            toDouble (rAC25 (context), context),
            toDouble (rAC50 (context), context),
            toDouble (rAC75 (context), context),
            toDouble (rDC20 (context), context),
            toDouble (radius (context), context),
            toDouble (ratedCurrent (context), context),
            sizeDescription (context),
            toInteger (strandCount (context), context),
            PerLengthParameters (context)
        )
    }
}

/**
 * Identification, spacing and configuration of the wires of a conductor with respect to a structure.
 *
 * @param sup Reference to the superclass object.
 * @param phase Single phase or neutral designation for the wire with this position.
 * @param xCoord Signed horizontal distance from the wire at this position to a common reference point.
 * @param yCoord Signed vertical distance from the wire at this position: above ground (positive value) or burial depth below ground (negative value).
 * @param WireSpacingInfo Wire spacing data this wire position belongs to.
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
        sup.export_fields +
        (if (null != phase) "\t\t<cim:WirePosition.phase rdf:resource=\"#" + phase + "\"/>\n" else "") +
        "\t\t<cim:WirePosition.xCoord>" + xCoord + "</cim:WirePosition.xCoord>\n" +
        "\t\t<cim:WirePosition.yCoord>" + yCoord + "</cim:WirePosition.yCoord>\n" +
        (if (null != WireSpacingInfo) "\t\t<cim:WirePosition.WireSpacingInfo rdf:resource=\"#" + WireSpacingInfo + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:WirePosition rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WirePosition>"
    }
}

object WirePosition
extends
    Parseable[WirePosition]
{
    val phase = parse_attribute (attribute ("""WirePosition.phase"""))
    val xCoord = parse_element (element ("""WirePosition.xCoord"""))
    val yCoord = parse_element (element ("""WirePosition.yCoord"""))
    val WireSpacingInfo = parse_attribute (attribute ("""WirePosition.WireSpacingInfo"""))
    def parse (context: Context): WirePosition =
    {
        WirePosition(
            IdentifiedObject.parse (context),
            phase (context),
            toDouble (xCoord (context), context),
            toDouble (yCoord (context), context),
            WireSpacingInfo (context)
        )
    }
}

/**
 * Wire spacing data that associates multiple wire positions with the line segment, and allows to calculate line segment impedances.
 * Number of phases can be derived from the number of associated wire positions whose phase is not neutral.
 *
 * @param sup Reference to the superclass object.
 * @param isCable If true, this spacing data describes a cable.
 * @param phaseWireCount Number of wire sub-conductors in the symmetrical bundle (typically between 1 and 4).
 * @param phaseWireSpacing Distance between wire sub-conductors in a symmetrical bundle.
 * @param usage Usage of the associated wires.
 * @param DuctBank <em>undocumented</em>
 * @param Structures <em>undocumented</em>
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
        sup.export_fields +
        "\t\t<cim:WireSpacingInfo.isCable>" + isCable + "</cim:WireSpacingInfo.isCable>\n" +
        "\t\t<cim:WireSpacingInfo.phaseWireCount>" + phaseWireCount + "</cim:WireSpacingInfo.phaseWireCount>\n" +
        "\t\t<cim:WireSpacingInfo.phaseWireSpacing>" + phaseWireSpacing + "</cim:WireSpacingInfo.phaseWireSpacing>\n" +
        (if (null != usage) "\t\t<cim:WireSpacingInfo.usage rdf:resource=\"#" + usage + "\"/>\n" else "") +
        (if (null != DuctBank) "\t\t<cim:WireSpacingInfo.DuctBank rdf:resource=\"#" + DuctBank + "\"/>\n" else "") +
        (if (null != Structures) Structures.map (x => "\t\t<cim:WireSpacingInfo.Structures rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:WireSpacingInfo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:WireSpacingInfo>"
    }
}

object WireSpacingInfo
extends
    Parseable[WireSpacingInfo]
{
    val isCable = parse_element (element ("""WireSpacingInfo.isCable"""))
    val phaseWireCount = parse_element (element ("""WireSpacingInfo.phaseWireCount"""))
    val phaseWireSpacing = parse_element (element ("""WireSpacingInfo.phaseWireSpacing"""))
    val usage = parse_attribute (attribute ("""WireSpacingInfo.usage"""))
    val DuctBank = parse_attribute (attribute ("""WireSpacingInfo.DuctBank"""))
    val Structures = parse_attributes (attribute ("""WireSpacingInfo.Structures"""))
    def parse (context: Context): WireSpacingInfo =
    {
        WireSpacingInfo(
            AssetInfo.parse (context),
            toBoolean (isCable (context), context),
            toInteger (phaseWireCount (context), context),
            toDouble (phaseWireSpacing (context), context),
            usage (context),
            DuctBank (context),
            Structures (context)
        )
    }
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
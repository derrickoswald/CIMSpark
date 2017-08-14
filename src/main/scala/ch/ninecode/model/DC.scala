package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * A unit with valves for three phases, together with unit control equipment, essential protective and switching devices, DC storage capacitors, phase reactors and auxiliaries, if any, used for conversion.
 * @param sup Reference to the superclass object.
 * @param baseS Base apparent power of the converter pole.
 * @param idc Converter DC current, also called Id.
 *        Converter state variable, result from power flow.
 * @param idleLoss Active power loss in pole at no power transfer.
 *        Converter configuration data used in power flow.
 * @param maxUdc The maximum voltage on the DC side at which the converter should operate.
 *        Converter configuration data used in power flow.
 * @param minUdc Min allowed converter DC voltage.
 *        Converter configuration data used in power flow.
 * @param numberOfValves Number of valves in the converter.
 *        Used in loss calculations.
 * @param p Active power at the point of common coupling.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param poleLossP The active power loss at a DC Pole
 *        &equals; idleLoss + switchingLoss*|Idc| + resitiveLoss*Idc<sup>2</sup>
 *        For lossless operation Pdc=Pac
 *        For rectifier operation with losses Pdc=Pac-lossP
 *        For inverter operation with losses Pdc=Pac+lossP
 *        Converter state variable used in power flow.
 * @param q Reactive power at the point of common coupling.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param ratedUdc Rated converter DC voltage, also called UdN.
 *        Converter configuration data used in power flow.
 * @param resistiveLoss Converter configuration data used in power flow.
 *        Refer to poleLossP.
 * @param switchingLoss Switching losses, relative to the base apparent power 'baseS'.
 *        Refer to poleLossP.
 * @param targetPpcc Real power injection target in AC grid, at point of common coupling.
 * @param targetUdc Target value for DC voltage magnitude.
 * @param uc Line-to-line converter voltage, the voltage at the AC side of the valve.
 *        Converter state variable, result from power flow.
 * @param udc Converter voltage at the DC side, also called Ud.
 *        Converter state variable, result from power flow.
 * @param valveU0 Valve threshold voltage, also called Uvalve.
 *        Forward voltage drop when the valve is conducting. Used in loss calculations, i.e. the switchLoss depends on numberOfValves * valveU0.
 * @param PccTerminal Point of common coupling terminal for this converter DC side.
 *        It is typically the terminal on the power transformer (or switch) closest to the AC network. The power flow measurement must be the sum of all flows into the transformer.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class ACDCConverter
(
    override val sup: ConductingEquipment,
    baseS: Double,
    idc: Double,
    idleLoss: Double,
    maxUdc: Double,
    minUdc: Double,
    numberOfValves: Int,
    p: Double,
    poleLossP: Double,
    q: Double,
    ratedUdc: Double,
    resistiveLoss: Double,
    switchingLoss: Double,
    targetPpcc: Double,
    targetUdc: Double,
    uc: Double,
    udc: Double,
    valveU0: Double,
    PccTerminal: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { clone ().asInstanceOf[ACDCConverter] }
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
        "\t\t<cim:ACDCConverter.baseS>" + baseS + "</cim:ACDCConverter.baseS>\n" +
        "\t\t<cim:ACDCConverter.idc>" + idc + "</cim:ACDCConverter.idc>\n" +
        "\t\t<cim:ACDCConverter.idleLoss>" + idleLoss + "</cim:ACDCConverter.idleLoss>\n" +
        "\t\t<cim:ACDCConverter.maxUdc>" + maxUdc + "</cim:ACDCConverter.maxUdc>\n" +
        "\t\t<cim:ACDCConverter.minUdc>" + minUdc + "</cim:ACDCConverter.minUdc>\n" +
        "\t\t<cim:ACDCConverter.numberOfValves>" + numberOfValves + "</cim:ACDCConverter.numberOfValves>\n" +
        "\t\t<cim:ACDCConverter.p>" + p + "</cim:ACDCConverter.p>\n" +
        "\t\t<cim:ACDCConverter.poleLossP>" + poleLossP + "</cim:ACDCConverter.poleLossP>\n" +
        "\t\t<cim:ACDCConverter.q>" + q + "</cim:ACDCConverter.q>\n" +
        "\t\t<cim:ACDCConverter.ratedUdc>" + ratedUdc + "</cim:ACDCConverter.ratedUdc>\n" +
        "\t\t<cim:ACDCConverter.resistiveLoss>" + resistiveLoss + "</cim:ACDCConverter.resistiveLoss>\n" +
        "\t\t<cim:ACDCConverter.switchingLoss>" + switchingLoss + "</cim:ACDCConverter.switchingLoss>\n" +
        "\t\t<cim:ACDCConverter.targetPpcc>" + targetPpcc + "</cim:ACDCConverter.targetPpcc>\n" +
        "\t\t<cim:ACDCConverter.targetUdc>" + targetUdc + "</cim:ACDCConverter.targetUdc>\n" +
        "\t\t<cim:ACDCConverter.uc>" + uc + "</cim:ACDCConverter.uc>\n" +
        "\t\t<cim:ACDCConverter.udc>" + udc + "</cim:ACDCConverter.udc>\n" +
        "\t\t<cim:ACDCConverter.valveU0>" + valveU0 + "</cim:ACDCConverter.valveU0>\n" +
        (if (null != PccTerminal) "\t\t<cim:ACDCConverter.PccTerminal rdf:resource=\"#" + PccTerminal + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ACDCConverter rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ACDCConverter>"
    }
}

object ACDCConverter
extends
    Parseable[ACDCConverter]
{
    val baseS = parse_element (element ("""ACDCConverter.baseS"""))
    val idc = parse_element (element ("""ACDCConverter.idc"""))
    val idleLoss = parse_element (element ("""ACDCConverter.idleLoss"""))
    val maxUdc = parse_element (element ("""ACDCConverter.maxUdc"""))
    val minUdc = parse_element (element ("""ACDCConverter.minUdc"""))
    val numberOfValves = parse_element (element ("""ACDCConverter.numberOfValves"""))
    val p = parse_element (element ("""ACDCConverter.p"""))
    val poleLossP = parse_element (element ("""ACDCConverter.poleLossP"""))
    val q = parse_element (element ("""ACDCConverter.q"""))
    val ratedUdc = parse_element (element ("""ACDCConverter.ratedUdc"""))
    val resistiveLoss = parse_element (element ("""ACDCConverter.resistiveLoss"""))
    val switchingLoss = parse_element (element ("""ACDCConverter.switchingLoss"""))
    val targetPpcc = parse_element (element ("""ACDCConverter.targetPpcc"""))
    val targetUdc = parse_element (element ("""ACDCConverter.targetUdc"""))
    val uc = parse_element (element ("""ACDCConverter.uc"""))
    val udc = parse_element (element ("""ACDCConverter.udc"""))
    val valveU0 = parse_element (element ("""ACDCConverter.valveU0"""))
    val PccTerminal = parse_attribute (attribute ("""ACDCConverter.PccTerminal"""))
    def parse (context: Context): ACDCConverter =
    {
        ACDCConverter(
            ConductingEquipment.parse (context),
            toDouble (baseS (context), context),
            toDouble (idc (context), context),
            toDouble (idleLoss (context), context),
            toDouble (maxUdc (context), context),
            toDouble (minUdc (context), context),
            toInteger (numberOfValves (context), context),
            toDouble (p (context), context),
            toDouble (poleLossP (context), context),
            toDouble (q (context), context),
            toDouble (ratedUdc (context), context),
            toDouble (resistiveLoss (context), context),
            toDouble (switchingLoss (context), context),
            toDouble (targetPpcc (context), context),
            toDouble (targetUdc (context), context),
            toDouble (uc (context), context),
            toDouble (udc (context), context),
            toDouble (valveU0 (context), context),
            PccTerminal (context)
        )
    }
}

/**
 * A DC electrical connection point at the AC/DC converter.
 * The AC/DC converter is electrically connected also to the AC side. The AC connection is inherited from the AC conducting equipment in the same way as any other AC equipment. The AC/DC converter DC terminal is separate from generic DC terminal to restrict the connection with the AC side to AC/DC converter and so that no other DC conducting equipment can be connected to the AC side.
 * @param sup Reference to the superclass object.
 * @param polarity Represents the normal network polarity condition.
 * @param DCConductingEquipment <em>undocumented</em>
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class ACDCConverterDCTerminal
(
    override val sup: DCBaseTerminal,
    polarity: String,
    DCConductingEquipment: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def DCBaseTerminal: DCBaseTerminal = sup.asInstanceOf[DCBaseTerminal]
    override def copy (): Row = { clone ().asInstanceOf[ACDCConverterDCTerminal] }
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
        (if (null != polarity) "\t\t<cim:ACDCConverterDCTerminal.polarity rdf:resource=\"#" + polarity + "\"/>\n" else "") +
        (if (null != DCConductingEquipment) "\t\t<cim:ACDCConverterDCTerminal.DCConductingEquipment rdf:resource=\"#" + DCConductingEquipment + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ACDCConverterDCTerminal rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ACDCConverterDCTerminal>"
    }
}

object ACDCConverterDCTerminal
extends
    Parseable[ACDCConverterDCTerminal]
{
    val polarity = parse_attribute (attribute ("""ACDCConverterDCTerminal.polarity"""))
    val DCConductingEquipment = parse_attribute (attribute ("""ACDCConverterDCTerminal.DCConductingEquipment"""))
    def parse (context: Context): ACDCConverterDCTerminal =
    {
        ACDCConverterDCTerminal(
            DCBaseTerminal.parse (context),
            polarity (context),
            DCConductingEquipment (context)
        )
    }
}

/**
 * DC side of the current source converter (CSC).
 * @param sup Reference to the superclass object.
 * @param alpha Firing angle, typical value between 10 and 18 degrees for a rectifier.
 *        CSC state variable, result from power flow.
 * @param gamma Extinction angle.
 *        CSC state variable, result from power flow.
 * @param maxAlpha Maximum firing angle.
 *        CSC configuration data used in power flow.
 * @param maxGamma Maximum extinction angle.
 *        CSC configuration data used in power flow.
 * @param maxIdc The maximum direct current (Id) on the DC side at which the converter should operate.
 *        Converter configuration data use in power flow.
 * @param minAlpha Minimum firing angle.
 *        CSC configuration data used in power flow.
 * @param minGamma Minimum extinction angle.
 *        CSC configuration data used in power flow.
 * @param minIdc The minimum direct current (Id) on the DC side at which the converter should operate.
 *        CSC configuration data used in power flow.
 * @param operatingMode Indicates whether the DC pole is operating as an inverter or as a rectifier.
 *        CSC control variable used in power flow.
 * @param pPccControl <em>undocumented</em>
 * @param ratedIdc Rated converter DC current, also called IdN.
 *        Converter configuration data used in power flow.
 * @param targetAlpha Target firing angle.
 *        CSC control variable used in power flow.
 * @param targetGamma Target extinction angle.
 *        CSC  control variable used in power flow.
 * @param targetIdc DC current target value.
 *        CSC control variable used in power flow.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class CsConverter
(
    override val sup: ACDCConverter,
    alpha: Double,
    gamma: Double,
    maxAlpha: Double,
    maxGamma: Double,
    maxIdc: Double,
    minAlpha: Double,
    minGamma: Double,
    minIdc: Double,
    operatingMode: String,
    pPccControl: String,
    ratedIdc: Double,
    targetAlpha: Double,
    targetGamma: Double,
    targetIdc: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ACDCConverter: ACDCConverter = sup.asInstanceOf[ACDCConverter]
    override def copy (): Row = { clone ().asInstanceOf[CsConverter] }
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
        "\t\t<cim:CsConverter.alpha>" + alpha + "</cim:CsConverter.alpha>\n" +
        "\t\t<cim:CsConverter.gamma>" + gamma + "</cim:CsConverter.gamma>\n" +
        "\t\t<cim:CsConverter.maxAlpha>" + maxAlpha + "</cim:CsConverter.maxAlpha>\n" +
        "\t\t<cim:CsConverter.maxGamma>" + maxGamma + "</cim:CsConverter.maxGamma>\n" +
        "\t\t<cim:CsConverter.maxIdc>" + maxIdc + "</cim:CsConverter.maxIdc>\n" +
        "\t\t<cim:CsConverter.minAlpha>" + minAlpha + "</cim:CsConverter.minAlpha>\n" +
        "\t\t<cim:CsConverter.minGamma>" + minGamma + "</cim:CsConverter.minGamma>\n" +
        "\t\t<cim:CsConverter.minIdc>" + minIdc + "</cim:CsConverter.minIdc>\n" +
        (if (null != operatingMode) "\t\t<cim:CsConverter.operatingMode rdf:resource=\"#" + operatingMode + "\"/>\n" else "") +
        (if (null != pPccControl) "\t\t<cim:CsConverter.pPccControl rdf:resource=\"#" + pPccControl + "\"/>\n" else "") +
        "\t\t<cim:CsConverter.ratedIdc>" + ratedIdc + "</cim:CsConverter.ratedIdc>\n" +
        "\t\t<cim:CsConverter.targetAlpha>" + targetAlpha + "</cim:CsConverter.targetAlpha>\n" +
        "\t\t<cim:CsConverter.targetGamma>" + targetGamma + "</cim:CsConverter.targetGamma>\n" +
        "\t\t<cim:CsConverter.targetIdc>" + targetIdc + "</cim:CsConverter.targetIdc>\n"
    }
    override def export: String =
    {
        "\t<cim:CsConverter rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CsConverter>"
    }
}

object CsConverter
extends
    Parseable[CsConverter]
{
    val alpha = parse_element (element ("""CsConverter.alpha"""))
    val gamma = parse_element (element ("""CsConverter.gamma"""))
    val maxAlpha = parse_element (element ("""CsConverter.maxAlpha"""))
    val maxGamma = parse_element (element ("""CsConverter.maxGamma"""))
    val maxIdc = parse_element (element ("""CsConverter.maxIdc"""))
    val minAlpha = parse_element (element ("""CsConverter.minAlpha"""))
    val minGamma = parse_element (element ("""CsConverter.minGamma"""))
    val minIdc = parse_element (element ("""CsConverter.minIdc"""))
    val operatingMode = parse_attribute (attribute ("""CsConverter.operatingMode"""))
    val pPccControl = parse_attribute (attribute ("""CsConverter.pPccControl"""))
    val ratedIdc = parse_element (element ("""CsConverter.ratedIdc"""))
    val targetAlpha = parse_element (element ("""CsConverter.targetAlpha"""))
    val targetGamma = parse_element (element ("""CsConverter.targetGamma"""))
    val targetIdc = parse_element (element ("""CsConverter.targetIdc"""))
    def parse (context: Context): CsConverter =
    {
        CsConverter(
            ACDCConverter.parse (context),
            toDouble (alpha (context), context),
            toDouble (gamma (context), context),
            toDouble (maxAlpha (context), context),
            toDouble (maxGamma (context), context),
            toDouble (maxIdc (context), context),
            toDouble (minAlpha (context), context),
            toDouble (minGamma (context), context),
            toDouble (minIdc (context), context),
            operatingMode (context),
            pPccControl (context),
            toDouble (ratedIdc (context), context),
            toDouble (targetAlpha (context), context),
            toDouble (targetGamma (context), context),
            toDouble (targetIdc (context), context)
        )
    }
}

/**
 * An electrical connection point at a piece of DC conducting equipment.
 * DC terminals are connected at one physical DC node that may have multiple DC terminals connected. A DC node is similar to an AC connectivity node. The model enforces that DC connections are distinct from AC connections.
 * @param sup Reference to the superclass object.
 * @param DCNode <em>undocumented</em>
 * @param DCTopologicalNode See association end Terminal.
 *        TopologicalNode.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCBaseTerminal
(
    override val sup: ACDCTerminal,
    DCNode: String,
    DCTopologicalNode: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ACDCTerminal: ACDCTerminal = sup.asInstanceOf[ACDCTerminal]
    override def copy (): Row = { clone ().asInstanceOf[DCBaseTerminal] }
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
        (if (null != DCNode) "\t\t<cim:DCBaseTerminal.DCNode rdf:resource=\"#" + DCNode + "\"/>\n" else "") +
        (if (null != DCTopologicalNode) "\t\t<cim:DCBaseTerminal.DCTopologicalNode rdf:resource=\"#" + DCTopologicalNode + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:DCBaseTerminal rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DCBaseTerminal>"
    }
}

object DCBaseTerminal
extends
    Parseable[DCBaseTerminal]
{
    val DCNode = parse_attribute (attribute ("""DCBaseTerminal.DCNode"""))
    val DCTopologicalNode = parse_attribute (attribute ("""DCBaseTerminal.DCTopologicalNode"""))
    def parse (context: Context): DCBaseTerminal =
    {
        DCBaseTerminal(
            ACDCTerminal.parse (context),
            DCNode (context),
            DCTopologicalNode (context)
        )
    }
}

/**
 * A breaker within a DC system.
 * @param sup Reference to the superclass object.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCBreaker
(
    override val sup: DCSwitch
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
    def DCSwitch: DCSwitch = sup.asInstanceOf[DCSwitch]
    override def copy (): Row = { clone ().asInstanceOf[DCBreaker] }
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
        "\t<cim:DCBreaker rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DCBreaker>"
    }
}

object DCBreaker
extends
    Parseable[DCBreaker]
{
    def parse (context: Context): DCBreaker =
    {
        DCBreaker(
            DCSwitch.parse (context)
        )
    }
}

/**
 * A busbar within a DC system.
 * @param sup Reference to the superclass object.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCBusbar
(
    override val sup: DCConductingEquipment
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
    def DCConductingEquipment: DCConductingEquipment = sup.asInstanceOf[DCConductingEquipment]
    override def copy (): Row = { clone ().asInstanceOf[DCBusbar] }
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
        "\t<cim:DCBusbar rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DCBusbar>"
    }
}

object DCBusbar
extends
    Parseable[DCBusbar]
{
    def parse (context: Context): DCBusbar =
    {
        DCBusbar(
            DCConductingEquipment.parse (context)
        )
    }
}

/**
 * Low resistance equipment used in the internal DC circuit to balance voltages.
 * It has typically positive and negative pole terminals and a ground.
 * @param sup Reference to the superclass object.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCChopper
(
    override val sup: DCConductingEquipment
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
    def DCConductingEquipment: DCConductingEquipment = sup.asInstanceOf[DCConductingEquipment]
    override def copy (): Row = { clone ().asInstanceOf[DCChopper] }
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
        "\t<cim:DCChopper rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DCChopper>"
    }
}

object DCChopper
extends
    Parseable[DCChopper]
{
    def parse (context: Context): DCChopper =
    {
        DCChopper(
            DCConductingEquipment.parse (context)
        )
    }
}

/**
 * The parts of the DC power system that are designed to carry current or that are conductively connected through DC terminals.
 * @param sup Reference to the superclass object.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCConductingEquipment
(
    override val sup: Equipment
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
    def Equipment: Equipment = sup.asInstanceOf[Equipment]
    override def copy (): Row = { clone ().asInstanceOf[DCConductingEquipment] }
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
        "\t<cim:DCConductingEquipment rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DCConductingEquipment>"
    }
}

object DCConductingEquipment
extends
    Parseable[DCConductingEquipment]
{
    def parse (context: Context): DCConductingEquipment =
    {
        DCConductingEquipment(
            Equipment.parse (context)
        )
    }
}

/**
 * Indivisible operative unit comprising all equipment between the point of common coupling on the AC side and the point of common coupling � DC side, essentially one or more converters, together with one or more converter transformers, converter control equipment, essential protective and switching devices and auxiliaries, if any, used for conversion.
 * @param sup Reference to the superclass object.
 * @param operationMode <em>undocumented</em>
 * @param Substation <em>undocumented</em>
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCConverterUnit
(
    override val sup: DCEquipmentContainer,
    operationMode: String,
    Substation: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def DCEquipmentContainer: DCEquipmentContainer = sup.asInstanceOf[DCEquipmentContainer]
    override def copy (): Row = { clone ().asInstanceOf[DCConverterUnit] }
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
        (if (null != operationMode) "\t\t<cim:DCConverterUnit.operationMode rdf:resource=\"#" + operationMode + "\"/>\n" else "") +
        (if (null != Substation) "\t\t<cim:DCConverterUnit.Substation rdf:resource=\"#" + Substation + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:DCConverterUnit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DCConverterUnit>"
    }
}

object DCConverterUnit
extends
    Parseable[DCConverterUnit]
{
    val operationMode = parse_attribute (attribute ("""DCConverterUnit.operationMode"""))
    val Substation = parse_attribute (attribute ("""DCConverterUnit.Substation"""))
    def parse (context: Context): DCConverterUnit =
    {
        DCConverterUnit(
            DCEquipmentContainer.parse (context),
            operationMode (context),
            Substation (context)
        )
    }
}

/**
 * A disconnector within a DC system.
 * @param sup Reference to the superclass object.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCDisconnector
(
    override val sup: DCSwitch
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
    def DCSwitch: DCSwitch = sup.asInstanceOf[DCSwitch]
    override def copy (): Row = { clone ().asInstanceOf[DCDisconnector] }
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
        "\t<cim:DCDisconnector rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DCDisconnector>"
    }
}

object DCDisconnector
extends
    Parseable[DCDisconnector]
{
    def parse (context: Context): DCDisconnector =
    {
        DCDisconnector(
            DCSwitch.parse (context)
        )
    }
}

/**
 * A modeling construct to provide a root class for containment of DC as well as AC equipment.
 * The class differ from the EquipmentContaner for AC in that it may also contain DCNodes. Hence it can contain both AC and DC equipment.
 * @param sup Reference to the superclass object.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCEquipmentContainer
(
    override val sup: EquipmentContainer
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
    def EquipmentContainer: EquipmentContainer = sup.asInstanceOf[EquipmentContainer]
    override def copy (): Row = { clone ().asInstanceOf[DCEquipmentContainer] }
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
        "\t<cim:DCEquipmentContainer rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DCEquipmentContainer>"
    }
}

object DCEquipmentContainer
extends
    Parseable[DCEquipmentContainer]
{
    def parse (context: Context): DCEquipmentContainer =
    {
        DCEquipmentContainer(
            EquipmentContainer.parse (context)
        )
    }
}

/**
 * A ground within a DC system.
 * @param sup Reference to the superclass object.
 * @param inductance Inductance to ground.
 * @param r Resistance to ground.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCGround
(
    override val sup: DCConductingEquipment,
    inductance: Double,
    r: Double
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
    def DCConductingEquipment: DCConductingEquipment = sup.asInstanceOf[DCConductingEquipment]
    override def copy (): Row = { clone ().asInstanceOf[DCGround] }
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
        "\t\t<cim:DCGround.inductance>" + inductance + "</cim:DCGround.inductance>\n" +
        "\t\t<cim:DCGround.r>" + r + "</cim:DCGround.r>\n"
    }
    override def export: String =
    {
        "\t<cim:DCGround rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DCGround>"
    }
}

object DCGround
extends
    Parseable[DCGround]
{
    val inductance = parse_element (element ("""DCGround.inductance"""))
    val r = parse_element (element ("""DCGround.r"""))
    def parse (context: Context): DCGround =
    {
        DCGround(
            DCConductingEquipment.parse (context),
            toDouble (inductance (context), context),
            toDouble (r (context), context)
        )
    }
}

/**
 * Overhead lines and/or cables connecting two or more HVDC substations.
 * @param sup Reference to the superclass object.
 * @param Region <em>undocumented</em>
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCLine
(
    override val sup: DCEquipmentContainer,
    Region: String
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
    def DCEquipmentContainer: DCEquipmentContainer = sup.asInstanceOf[DCEquipmentContainer]
    override def copy (): Row = { clone ().asInstanceOf[DCLine] }
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
        (if (null != Region) "\t\t<cim:DCLine.Region rdf:resource=\"#" + Region + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:DCLine rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DCLine>"
    }
}

object DCLine
extends
    Parseable[DCLine]
{
    val Region = parse_attribute (attribute ("""DCLine.Region"""))
    def parse (context: Context): DCLine =
    {
        DCLine(
            DCEquipmentContainer.parse (context),
            Region (context)
        )
    }
}

/**
 * A wire or combination of wires not insulated from one another, with consistent electrical characteristics, used to carry direct current between points in the DC region of the power system.
 * @param sup Reference to the superclass object.
 * @param capacitance Capacitance of the DC line segment.
 *        Significant for cables only.
 * @param inductance Inductance of the DC line segment.
 *        Neglectable compared with DCSeriesDevice used for smoothing.
 * @param len Segment length for calculating line section capabilities.
 * @param resistance Resistance of the DC line segment.
 * @param PerLengthParameter Set of per-length parameters for this line segment.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCLineSegment
(
    override val sup: DCConductingEquipment,
    capacitance: Double,
    inductance: Double,
    len: Double,
    resistance: Double,
    PerLengthParameter: String
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
    def DCConductingEquipment: DCConductingEquipment = sup.asInstanceOf[DCConductingEquipment]
    override def copy (): Row = { clone ().asInstanceOf[DCLineSegment] }
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
        "\t\t<cim:DCLineSegment.capacitance>" + capacitance + "</cim:DCLineSegment.capacitance>\n" +
        "\t\t<cim:DCLineSegment.inductance>" + inductance + "</cim:DCLineSegment.inductance>\n" +
        "\t\t<cim:DCLineSegment.length>" + len + "</cim:DCLineSegment.length>\n" +
        "\t\t<cim:DCLineSegment.resistance>" + resistance + "</cim:DCLineSegment.resistance>\n" +
        (if (null != PerLengthParameter) "\t\t<cim:DCLineSegment.PerLengthParameter rdf:resource=\"#" + PerLengthParameter + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:DCLineSegment rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DCLineSegment>"
    }
}

object DCLineSegment
extends
    Parseable[DCLineSegment]
{
    val capacitance = parse_element (element ("""DCLineSegment.capacitance"""))
    val inductance = parse_element (element ("""DCLineSegment.inductance"""))
    val len = parse_element (element ("""DCLineSegment.length"""))
    val resistance = parse_element (element ("""DCLineSegment.resistance"""))
    val PerLengthParameter = parse_attribute (attribute ("""DCLineSegment.PerLengthParameter"""))
    def parse (context: Context): DCLineSegment =
    {
        DCLineSegment(
            DCConductingEquipment.parse (context),
            toDouble (capacitance (context), context),
            toDouble (inductance (context), context),
            toDouble (len (context), context),
            toDouble (resistance (context), context),
            PerLengthParameter (context)
        )
    }
}

/**
 * DC nodes are points where terminals of DC conducting equipment are connected together with zero impedance.
 * @param sup Reference to the superclass object.
 * @param DCEquipmentContainer <em>undocumented</em>
 * @param DCTopologicalNode See association end ConnectivityNode.
 *        TopologicalNode.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCNode
(
    override val sup: IdentifiedObject,
    DCEquipmentContainer: String,
    DCTopologicalNode: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[DCNode] }
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
        (if (null != DCEquipmentContainer) "\t\t<cim:DCNode.DCEquipmentContainer rdf:resource=\"#" + DCEquipmentContainer + "\"/>\n" else "") +
        (if (null != DCTopologicalNode) "\t\t<cim:DCNode.DCTopologicalNode rdf:resource=\"#" + DCTopologicalNode + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:DCNode rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DCNode>"
    }
}

object DCNode
extends
    Parseable[DCNode]
{
    val DCEquipmentContainer = parse_attribute (attribute ("""DCNode.DCEquipmentContainer"""))
    val DCTopologicalNode = parse_attribute (attribute ("""DCNode.DCTopologicalNode"""))
    def parse (context: Context): DCNode =
    {
        DCNode(
            IdentifiedObject.parse (context),
            DCEquipmentContainer (context),
            DCTopologicalNode (context)
        )
    }
}

/**
 * A series device within the DC system, typically a reactor used for filtering or smoothing.
 * Needed for transient and short circuit studies.
 * @param sup Reference to the superclass object.
 * @param inductance Inductance of the device.
 * @param ratedUdc Rated DC device voltage.
 *        Converter configuration data used in power flow.
 * @param resistance Resistance of the DC device.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCSeriesDevice
(
    override val sup: DCConductingEquipment,
    inductance: Double,
    ratedUdc: Double,
    resistance: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def DCConductingEquipment: DCConductingEquipment = sup.asInstanceOf[DCConductingEquipment]
    override def copy (): Row = { clone ().asInstanceOf[DCSeriesDevice] }
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
        "\t\t<cim:DCSeriesDevice.inductance>" + inductance + "</cim:DCSeriesDevice.inductance>\n" +
        "\t\t<cim:DCSeriesDevice.ratedUdc>" + ratedUdc + "</cim:DCSeriesDevice.ratedUdc>\n" +
        "\t\t<cim:DCSeriesDevice.resistance>" + resistance + "</cim:DCSeriesDevice.resistance>\n"
    }
    override def export: String =
    {
        "\t<cim:DCSeriesDevice rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DCSeriesDevice>"
    }
}

object DCSeriesDevice
extends
    Parseable[DCSeriesDevice]
{
    val inductance = parse_element (element ("""DCSeriesDevice.inductance"""))
    val ratedUdc = parse_element (element ("""DCSeriesDevice.ratedUdc"""))
    val resistance = parse_element (element ("""DCSeriesDevice.resistance"""))
    def parse (context: Context): DCSeriesDevice =
    {
        DCSeriesDevice(
            DCConductingEquipment.parse (context),
            toDouble (inductance (context), context),
            toDouble (ratedUdc (context), context),
            toDouble (resistance (context), context)
        )
    }
}

/**
 * A shunt device within the DC system, typically used for filtering.
 * Needed for transient and short circuit studies.
 * @param sup Reference to the superclass object.
 * @param capacitance Capacitance of the DC shunt.
 * @param ratedUdc Rated DC device voltage.
 *        Converter configuration data used in power flow.
 * @param resistance Resistance of the DC device.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCShunt
(
    override val sup: DCConductingEquipment,
    capacitance: Double,
    ratedUdc: Double,
    resistance: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def DCConductingEquipment: DCConductingEquipment = sup.asInstanceOf[DCConductingEquipment]
    override def copy (): Row = { clone ().asInstanceOf[DCShunt] }
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
        "\t\t<cim:DCShunt.capacitance>" + capacitance + "</cim:DCShunt.capacitance>\n" +
        "\t\t<cim:DCShunt.ratedUdc>" + ratedUdc + "</cim:DCShunt.ratedUdc>\n" +
        "\t\t<cim:DCShunt.resistance>" + resistance + "</cim:DCShunt.resistance>\n"
    }
    override def export: String =
    {
        "\t<cim:DCShunt rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DCShunt>"
    }
}

object DCShunt
extends
    Parseable[DCShunt]
{
    val capacitance = parse_element (element ("""DCShunt.capacitance"""))
    val ratedUdc = parse_element (element ("""DCShunt.ratedUdc"""))
    val resistance = parse_element (element ("""DCShunt.resistance"""))
    def parse (context: Context): DCShunt =
    {
        DCShunt(
            DCConductingEquipment.parse (context),
            toDouble (capacitance (context), context),
            toDouble (ratedUdc (context), context),
            toDouble (resistance (context), context)
        )
    }
}

/**
 * A switch within the DC system.
 * @param sup Reference to the superclass object.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCSwitch
(
    override val sup: DCConductingEquipment
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
    def DCConductingEquipment: DCConductingEquipment = sup.asInstanceOf[DCConductingEquipment]
    override def copy (): Row = { clone ().asInstanceOf[DCSwitch] }
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
        "\t<cim:DCSwitch rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DCSwitch>"
    }
}

object DCSwitch
extends
    Parseable[DCSwitch]
{
    def parse (context: Context): DCSwitch =
    {
        DCSwitch(
            DCConductingEquipment.parse (context)
        )
    }
}

/**
 * An electrical connection point to generic DC conducting equipment.
 * @param sup Reference to the superclass object.
 * @param DCConductingEquipment <em>undocumented</em>
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCTerminal
(
    override val sup: DCBaseTerminal,
    DCConductingEquipment: String
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
    def DCBaseTerminal: DCBaseTerminal = sup.asInstanceOf[DCBaseTerminal]
    override def copy (): Row = { clone ().asInstanceOf[DCTerminal] }
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
        (if (null != DCConductingEquipment) "\t\t<cim:DCTerminal.DCConductingEquipment rdf:resource=\"#" + DCConductingEquipment + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:DCTerminal rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DCTerminal>"
    }
}

object DCTerminal
extends
    Parseable[DCTerminal]
{
    val DCConductingEquipment = parse_attribute (attribute ("""DCTerminal.DCConductingEquipment"""))
    def parse (context: Context): DCTerminal =
    {
        DCTerminal(
            DCBaseTerminal.parse (context),
            DCConductingEquipment (context)
        )
    }
}

/**
 * An electrically connected subset of the network.
 * DC topological islands can change as the current network state changes: e.g. due to
 * @param sup Reference to the superclass object.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class DCTopologicalIsland
(
    override val sup: IdentifiedObject
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
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[DCTopologicalIsland] }
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
        "\t<cim:DCTopologicalIsland rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DCTopologicalIsland>"
    }
}

object DCTopologicalIsland
extends
    Parseable[DCTopologicalIsland]
{
    def parse (context: Context): DCTopologicalIsland =
    {
        DCTopologicalIsland(
            IdentifiedObject.parse (context)
        )
    }
}

/**
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class PerLengthDCLineParameter
(
    override val sup: PerLengthLineParameter,
    capacitance: Double,
    inductance: Double,
    resistance: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PerLengthLineParameter: PerLengthLineParameter = sup.asInstanceOf[PerLengthLineParameter]
    override def copy (): Row = { clone ().asInstanceOf[PerLengthDCLineParameter] }
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
        "\t\t<cim:PerLengthDCLineParameter.capacitance>" + capacitance + "</cim:PerLengthDCLineParameter.capacitance>\n" +
        "\t\t<cim:PerLengthDCLineParameter.inductance>" + inductance + "</cim:PerLengthDCLineParameter.inductance>\n" +
        "\t\t<cim:PerLengthDCLineParameter.resistance>" + resistance + "</cim:PerLengthDCLineParameter.resistance>\n"
    }
    override def export: String =
    {
        "\t<cim:PerLengthDCLineParameter rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PerLengthDCLineParameter>"
    }
}

object PerLengthDCLineParameter
extends
    Parseable[PerLengthDCLineParameter]
{
    val capacitance = parse_element (element ("""PerLengthDCLineParameter.capacitance"""))
    val inductance = parse_element (element ("""PerLengthDCLineParameter.inductance"""))
    val resistance = parse_element (element ("""PerLengthDCLineParameter.resistance"""))
    def parse (context: Context): PerLengthDCLineParameter =
    {
        PerLengthDCLineParameter(
            PerLengthLineParameter.parse (context),
            toDouble (capacitance (context), context),
            toDouble (inductance (context), context),
            toDouble (resistance (context), context)
        )
    }
}

/**
 * The P-Q capability curve for a voltage source converter, with P on x-axis and Qmin and Qmax on y1-axis and y2-axis.
 * @param sup Reference to the superclass object.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class VsCapabilityCurve
(
    override val sup: Curve
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
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { clone ().asInstanceOf[VsCapabilityCurve] }
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
        "\t<cim:VsCapabilityCurve rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:VsCapabilityCurve>"
    }
}

object VsCapabilityCurve
extends
    Parseable[VsCapabilityCurve]
{
    def parse (context: Context): VsCapabilityCurve =
    {
        VsCapabilityCurve(
            Curve.parse (context)
        )
    }
}

/**
 * DC side of the voltage source converter (VSC).
 * @param sup Reference to the superclass object.
 * @param delta Angle between uf and uc.
 *        Converter state variable used in power flow.
 * @param droop Droop constant; pu value is obtained as D [kV/MW] x Sb / Ubdc.
 * @param droopCompensation Compensation constant.
 *        Used to compensate for voltage drop when controlling voltage at a distant bus.
 * @param maxModulationIndex The max quotient between the AC converter voltage (Uc) and DC voltage (Ud).
 *        A factor typically less than 1. VSC configuration data used in power flow.
 * @param maxValveCurrent The maximum current through a valve.
 *        This current limit is the basis for calculating the capability diagram. VSC  configuration data.
 * @param pPccControl Kind of control of real power and/or DC voltage.
 * @param qPccControl <em>undocumented</em>
 * @param qShare Reactive power sharing factor among parallel converters on Uac control.
 * @param targetQpcc Reactive power injection target in AC grid, at point of common coupling.
 * @param targetUpcc Voltage target in AC grid, at point of common coupling.
 * @param uf Line-to-line voltage on the valve side of the converter transformer.
 *        Converter state variable, result from power flow.
 * @param CapabilityCurve Capability curve of this converter.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
case class VsConverter
(
    override val sup: ACDCConverter,
    delta: Double,
    droop: Double,
    droopCompensation: Double,
    maxModulationIndex: Double,
    maxValveCurrent: Double,
    pPccControl: String,
    qPccControl: String,
    qShare: Double,
    targetQpcc: Double,
    targetUpcc: Double,
    uf: Double,
    CapabilityCurve: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, 0.0, 0.0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ACDCConverter: ACDCConverter = sup.asInstanceOf[ACDCConverter]
    override def copy (): Row = { clone ().asInstanceOf[VsConverter] }
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
        "\t\t<cim:VsConverter.delta>" + delta + "</cim:VsConverter.delta>\n" +
        "\t\t<cim:VsConverter.droop>" + droop + "</cim:VsConverter.droop>\n" +
        "\t\t<cim:VsConverter.droopCompensation>" + droopCompensation + "</cim:VsConverter.droopCompensation>\n" +
        "\t\t<cim:VsConverter.maxModulationIndex>" + maxModulationIndex + "</cim:VsConverter.maxModulationIndex>\n" +
        "\t\t<cim:VsConverter.maxValveCurrent>" + maxValveCurrent + "</cim:VsConverter.maxValveCurrent>\n" +
        (if (null != pPccControl) "\t\t<cim:VsConverter.pPccControl rdf:resource=\"#" + pPccControl + "\"/>\n" else "") +
        (if (null != qPccControl) "\t\t<cim:VsConverter.qPccControl rdf:resource=\"#" + qPccControl + "\"/>\n" else "") +
        "\t\t<cim:VsConverter.qShare>" + qShare + "</cim:VsConverter.qShare>\n" +
        "\t\t<cim:VsConverter.targetQpcc>" + targetQpcc + "</cim:VsConverter.targetQpcc>\n" +
        "\t\t<cim:VsConverter.targetUpcc>" + targetUpcc + "</cim:VsConverter.targetUpcc>\n" +
        "\t\t<cim:VsConverter.uf>" + uf + "</cim:VsConverter.uf>\n" +
        (if (null != CapabilityCurve) "\t\t<cim:VsConverter.CapabilityCurve rdf:resource=\"#" + CapabilityCurve + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:VsConverter rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:VsConverter>"
    }
}

object VsConverter
extends
    Parseable[VsConverter]
{
    val delta = parse_element (element ("""VsConverter.delta"""))
    val droop = parse_element (element ("""VsConverter.droop"""))
    val droopCompensation = parse_element (element ("""VsConverter.droopCompensation"""))
    val maxModulationIndex = parse_element (element ("""VsConverter.maxModulationIndex"""))
    val maxValveCurrent = parse_element (element ("""VsConverter.maxValveCurrent"""))
    val pPccControl = parse_attribute (attribute ("""VsConverter.pPccControl"""))
    val qPccControl = parse_attribute (attribute ("""VsConverter.qPccControl"""))
    val qShare = parse_element (element ("""VsConverter.qShare"""))
    val targetQpcc = parse_element (element ("""VsConverter.targetQpcc"""))
    val targetUpcc = parse_element (element ("""VsConverter.targetUpcc"""))
    val uf = parse_element (element ("""VsConverter.uf"""))
    val CapabilityCurve = parse_attribute (attribute ("""VsConverter.CapabilityCurve"""))
    def parse (context: Context): VsConverter =
    {
        VsConverter(
            ACDCConverter.parse (context),
            toDouble (delta (context), context),
            toDouble (droop (context), context),
            toDouble (droopCompensation (context), context),
            toDouble (maxModulationIndex (context), context),
            toDouble (maxValveCurrent (context), context),
            pPccControl (context),
            qPccControl (context),
            toDouble (qShare (context), context),
            toDouble (targetQpcc (context), context),
            toDouble (targetUpcc (context), context),
            toDouble (uf (context), context),
            CapabilityCurve (context)
        )
    }
}

private[ninecode] object _DC
{
    def register: List[ClassInfo] =
    {
        List (
            ACDCConverter.register,
            ACDCConverterDCTerminal.register,
            CsConverter.register,
            DCBaseTerminal.register,
            DCBreaker.register,
            DCBusbar.register,
            DCChopper.register,
            DCConductingEquipment.register,
            DCConverterUnit.register,
            DCDisconnector.register,
            DCEquipmentContainer.register,
            DCGround.register,
            DCLine.register,
            DCLineSegment.register,
            DCNode.register,
            DCSeriesDevice.register,
            DCShunt.register,
            DCSwitch.register,
            DCTerminal.register,
            DCTopologicalIsland.register,
            PerLengthDCLineParameter.register,
            VsCapabilityCurve.register,
            VsConverter.register
        )
    }
}
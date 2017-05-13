package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This package contains model for direct current equipment and controls.
 */

/**
 * A unit with valves for three phases, together with unit control equipment, essential protective and switching devices, DC storage capacitors, phase reactors and auxiliaries, if any, used for conversion.
 */
case class ACDCConverter
(

    override val sup: ConductingEquipment,

    /**
     * Base apparent power of the converter pole.
     */
    val baseS: Double,

    /**
     * Converter DC current, also called Id.
     * Converter state variable, result from power flow.
     */
    val idc: Double,

    /**
     * Active power loss in pole at no power transfer.
     * Converter configuration data used in power flow.
     */
    val idleLoss: Double,

    /**
     * The maximum voltage on the DC side at which the converter should operate.
     * Converter configuration data used in power flow.
     */
    val maxUdc: Double,

    /**
     * Min allowed converter DC voltage.
     * Converter configuration data used in power flow.
     */
    val minUdc: Double,

    /**
     * Number of valves in the converter.
     * Used in loss calculations.
     */
    val numberOfValves: Int,

    /**
     * Active power at the point of common coupling.
     * Load sign convention is used, i.e. positive sign means flow out from a node.
     */
    val p: Double,

    /**
     * The active power loss at a DC Pole 
    = idleLoss + switchingLoss*|Idc| + resitiveLoss*Idc^2
    For lossless operation Pdc=Pac
    For rectifier operation with losses Pdc=Pac-lossP
    For inverter operation with losses Pdc=Pac+lossP
     * Converter state variable used in power flow.
     */
    val poleLossP: Double,

    /**
     * Reactive power at the point of common coupling.
     * Load sign convention is used, i.e. positive sign means flow out from a node.
     */
    val q: Double,

    /**
     * Rated converter DC voltage, also called UdN.
     * Converter configuration data used in power flow.
     */
    val ratedUdc: Double,

    /**
     * Converter configuration data used in power flow.
     * Refer to poleLossP.
     */
    val resistiveLoss: Double,

    /**
     * Switching losses, relative to the base apparent power 'baseS'.
     * Refer to poleLossP.
     */
    val switchingLoss: Double,

    /**
     * Real power injection target in AC grid, at point of common coupling.
     */
    val targetPpcc: Double,

    /**
     * Target value for DC voltage magnitude.
     */
    val targetUdc: Double,

    /**
     * Line-to-line converter voltage, the voltage at the AC side of the valve.
     * Converter state variable, result from power flow.
     */
    val uc: Double,

    /**
     * Converter voltage at the DC side, also called Ud.
     * Converter state variable, result from power flow.
     */
    val udc: Double,

    /**
     * Valve threshold voltage, also called Uvalve.
     * Forward voltage drop when the valve is conducting. Used in loss calculations, i.e. the switchLoss depends on numberOfValves * valveU0.
     */
    val valveU0: Double,

    /**
     * Point of common coupling terminal for this converter DC side.
     * It is typically the terminal on the power transformer (or switch) closest to the AC network. The power flow measurement must be the sum of all flows into the transformer.
     */
    val PccTerminal: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[ACDCConverter]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ACDCConverter
extends
    Parseable[ACDCConverter]
{
    val sup = ConductingEquipment.parse _
    val baseS = parse_element (element ("""ACDCConverter.baseS"""))_
    val idc = parse_element (element ("""ACDCConverter.idc"""))_
    val idleLoss = parse_element (element ("""ACDCConverter.idleLoss"""))_
    val maxUdc = parse_element (element ("""ACDCConverter.maxUdc"""))_
    val minUdc = parse_element (element ("""ACDCConverter.minUdc"""))_
    val numberOfValves = parse_element (element ("""ACDCConverter.numberOfValves"""))_
    val p = parse_element (element ("""ACDCConverter.p"""))_
    val poleLossP = parse_element (element ("""ACDCConverter.poleLossP"""))_
    val q = parse_element (element ("""ACDCConverter.q"""))_
    val ratedUdc = parse_element (element ("""ACDCConverter.ratedUdc"""))_
    val resistiveLoss = parse_element (element ("""ACDCConverter.resistiveLoss"""))_
    val switchingLoss = parse_element (element ("""ACDCConverter.switchingLoss"""))_
    val targetPpcc = parse_element (element ("""ACDCConverter.targetPpcc"""))_
    val targetUdc = parse_element (element ("""ACDCConverter.targetUdc"""))_
    val uc = parse_element (element ("""ACDCConverter.uc"""))_
    val udc = parse_element (element ("""ACDCConverter.udc"""))_
    val valveU0 = parse_element (element ("""ACDCConverter.valveU0"""))_
    val PccTerminal = parse_attribute (attribute ("""ACDCConverter.PccTerminal"""))_
    def parse (context: Context): ACDCConverter =
    {
        ACDCConverter(
            sup (context),
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
 */
case class ACDCConverterDCTerminal
(

    override val sup: DCBaseTerminal,

    /**
     * Represents the normal network polarity condition.
     */
    val polarity: String,

    val DCConductingEquipment: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def DCBaseTerminal: DCBaseTerminal = sup.asInstanceOf[DCBaseTerminal]
    override def copy (): Row = { return (clone ().asInstanceOf[ACDCConverterDCTerminal]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ACDCConverterDCTerminal
extends
    Parseable[ACDCConverterDCTerminal]
{
    val sup = DCBaseTerminal.parse _
    val polarity = parse_attribute (attribute ("""ACDCConverterDCTerminal.polarity"""))_
    val DCConductingEquipment = parse_attribute (attribute ("""ACDCConverterDCTerminal.DCConductingEquipment"""))_
    def parse (context: Context): ACDCConverterDCTerminal =
    {
        ACDCConverterDCTerminal(
            sup (context),
            polarity (context),
            DCConductingEquipment (context)
        )
    }
}

/**
 * DC side of the current source converter (CSC).
 */
case class CsConverter
(

    override val sup: ACDCConverter,

    /**
     * Firing angle, typical value between 10 and 18 degrees for a rectifier.
     * CSC state variable, result from power flow.
     */
    val alpha: Double,

    /**
     * Extinction angle.
     * CSC state variable, result from power flow.
     */
    val gamma: Double,

    /**
     * Maximum firing angle.
     * CSC configuration data used in power flow.
     */
    val maxAlpha: Double,

    /**
     * Maximum extinction angle.
     * CSC configuration data used in power flow.
     */
    val maxGamma: Double,

    /**
     * The maximum direct current (Id) on the DC side at which the converter should operate.
     * Converter configuration data use in power flow.
     */
    val maxIdc: Double,

    /**
     * Minimum firing angle.
     * CSC configuration data used in power flow.
     */
    val minAlpha: Double,

    /**
     * Minimum extinction angle.
     * CSC configuration data used in power flow.
     */
    val minGamma: Double,

    /**
     * The minimum direct current (Id) on the DC side at which the converter should operate.
     * CSC configuration data used in power flow.
     */
    val minIdc: Double,

    /**
     * Indicates whether the DC pole is operating as an inverter or as a rectifier.
     * CSC control variable used in power flow.
     */
    val operatingMode: String,

    val pPccControl: String,

    /**
     * Rated converter DC current, also called IdN.
     * Converter configuration data used in power flow.
     */
    val ratedIdc: Double,

    /**
     * Target firing angle.
     * CSC control variable used in power flow.
     */
    val targetAlpha: Double,

    /**
     * Target extinction angle.
     * CSC  control variable used in power flow.
     */
    val targetGamma: Double,

    /**
     * DC current target value.
     * CSC control variable used in power flow.
     */
    val targetIdc: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, 0.0, 0.0, 0.0, 0.0) }
    def ACDCConverter: ACDCConverter = sup.asInstanceOf[ACDCConverter]
    override def copy (): Row = { return (clone ().asInstanceOf[CsConverter]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CsConverter
extends
    Parseable[CsConverter]
{
    val sup = ACDCConverter.parse _
    val alpha = parse_element (element ("""CsConverter.alpha"""))_
    val gamma = parse_element (element ("""CsConverter.gamma"""))_
    val maxAlpha = parse_element (element ("""CsConverter.maxAlpha"""))_
    val maxGamma = parse_element (element ("""CsConverter.maxGamma"""))_
    val maxIdc = parse_element (element ("""CsConverter.maxIdc"""))_
    val minAlpha = parse_element (element ("""CsConverter.minAlpha"""))_
    val minGamma = parse_element (element ("""CsConverter.minGamma"""))_
    val minIdc = parse_element (element ("""CsConverter.minIdc"""))_
    val operatingMode = parse_attribute (attribute ("""CsConverter.operatingMode"""))_
    val pPccControl = parse_attribute (attribute ("""CsConverter.pPccControl"""))_
    val ratedIdc = parse_element (element ("""CsConverter.ratedIdc"""))_
    val targetAlpha = parse_element (element ("""CsConverter.targetAlpha"""))_
    val targetGamma = parse_element (element ("""CsConverter.targetGamma"""))_
    val targetIdc = parse_element (element ("""CsConverter.targetIdc"""))_
    def parse (context: Context): CsConverter =
    {
        CsConverter(
            sup (context),
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
 * Operating mode for HVDC line operating as Current Source Converter.
 */
case class CsOperatingModeKind
(

    override val sup: BasicElement,

    /**
     * Operating as inverter
     */
    val inverter: String,

    /**
     * Operating as rectifier.
     */
    val rectifier: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[CsOperatingModeKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CsOperatingModeKind
extends
    Parseable[CsOperatingModeKind]
{
    val sup = BasicElement.parse _
    val inverter = parse_attribute (attribute ("""CsOperatingModeKind.inverter"""))_
    val rectifier = parse_attribute (attribute ("""CsOperatingModeKind.rectifier"""))_
    def parse (context: Context): CsOperatingModeKind =
    {
        CsOperatingModeKind(
            sup (context),
            inverter (context),
            rectifier (context)
        )
    }
}

/**
 * Active power control modes for HVDC line operating as Current Source Converter.
 */
case class CsPpccControlKind
(

    override val sup: BasicElement,

    /**
     * Active power control at AC side.
     */
    val activePower: String,

    /**
     * DC current control
     */
    val dcCurrent: String,

    /**
     * DC voltage control.
     */
    val dcVoltage: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[CsPpccControlKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CsPpccControlKind
extends
    Parseable[CsPpccControlKind]
{
    val sup = BasicElement.parse _
    val activePower = parse_attribute (attribute ("""CsPpccControlKind.activePower"""))_
    val dcCurrent = parse_attribute (attribute ("""CsPpccControlKind.dcCurrent"""))_
    val dcVoltage = parse_attribute (attribute ("""CsPpccControlKind.dcVoltage"""))_
    def parse (context: Context): CsPpccControlKind =
    {
        CsPpccControlKind(
            sup (context),
            activePower (context),
            dcCurrent (context),
            dcVoltage (context)
        )
    }
}

/**
 * An electrical connection point at a piece of DC conducting equipment.
 * DC terminals are connected at one physical DC node that may have multiple DC terminals connected. A DC node is similar to an AC connectivity node. The model enforces that DC connections are distinct from AC connections.
 */
case class DCBaseTerminal
(

    override val sup: ACDCTerminal,

    val DCNode: String,

    /**
     * See association end Terminal.
     * TopologicalNode.
     */
    val DCTopologicalNode: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def ACDCTerminal: ACDCTerminal = sup.asInstanceOf[ACDCTerminal]
    override def copy (): Row = { return (clone ().asInstanceOf[DCBaseTerminal]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DCBaseTerminal
extends
    Parseable[DCBaseTerminal]
{
    val sup = ACDCTerminal.parse _
    val DCNode = parse_attribute (attribute ("""DCBaseTerminal.DCNode"""))_
    val DCTopologicalNode = parse_attribute (attribute ("""DCBaseTerminal.DCTopologicalNode"""))_
    def parse (context: Context): DCBaseTerminal =
    {
        DCBaseTerminal(
            sup (context),
            DCNode (context),
            DCTopologicalNode (context)
        )
    }
}

/**
 * A breaker within a DC system.
 */
case class DCBreaker
(

    override val sup: DCSwitch
)
extends
    Element
{
    def this () = { this (null) }
    def DCSwitch: DCSwitch = sup.asInstanceOf[DCSwitch]
    override def copy (): Row = { return (clone ().asInstanceOf[DCBreaker]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DCBreaker
extends
    Parseable[DCBreaker]
{
    val sup = DCSwitch.parse _
    def parse (context: Context): DCBreaker =
    {
        DCBreaker(
            sup (context)
        )
    }
}

/**
 * A busbar within a DC system.
 */
case class DCBusbar
(

    override val sup: DCConductingEquipment
)
extends
    Element
{
    def this () = { this (null) }
    def DCConductingEquipment: DCConductingEquipment = sup.asInstanceOf[DCConductingEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[DCBusbar]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DCBusbar
extends
    Parseable[DCBusbar]
{
    val sup = DCConductingEquipment.parse _
    def parse (context: Context): DCBusbar =
    {
        DCBusbar(
            sup (context)
        )
    }
}

/**
 * Low resistance equipment used in the internal DC circuit to balance voltages.
 * It has typically positive and negative pole terminals and a ground.
 */
case class DCChopper
(

    override val sup: DCConductingEquipment
)
extends
    Element
{
    def this () = { this (null) }
    def DCConductingEquipment: DCConductingEquipment = sup.asInstanceOf[DCConductingEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[DCChopper]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DCChopper
extends
    Parseable[DCChopper]
{
    val sup = DCConductingEquipment.parse _
    def parse (context: Context): DCChopper =
    {
        DCChopper(
            sup (context)
        )
    }
}

/**
 * The parts of the DC power system that are designed to carry current or that are conductively connected through DC terminals.
 */
case class DCConductingEquipment
(

    override val sup: Equipment
)
extends
    Element
{
    def this () = { this (null) }
    def Equipment: Equipment = sup.asInstanceOf[Equipment]
    override def copy (): Row = { return (clone ().asInstanceOf[DCConductingEquipment]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DCConductingEquipment
extends
    Parseable[DCConductingEquipment]
{
    val sup = Equipment.parse _
    def parse (context: Context): DCConductingEquipment =
    {
        DCConductingEquipment(
            sup (context)
        )
    }
}

/**
 * The operating mode of an HVDC bipole.
 */
case class DCConverterOperatingModeKind
(

    override val sup: BasicElement,

    /**
     * Bipolar operation.
     */
    val bipolar: String,

    /**
     * Monopolar operation with ground return
     */
    val monopolarGroundReturn: String,

    /**
     * Monopolar operation with metallic return
     */
    val monopolarMetallicReturn: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[DCConverterOperatingModeKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DCConverterOperatingModeKind
extends
    Parseable[DCConverterOperatingModeKind]
{
    val sup = BasicElement.parse _
    val bipolar = parse_attribute (attribute ("""DCConverterOperatingModeKind.bipolar"""))_
    val monopolarGroundReturn = parse_attribute (attribute ("""DCConverterOperatingModeKind.monopolarGroundReturn"""))_
    val monopolarMetallicReturn = parse_attribute (attribute ("""DCConverterOperatingModeKind.monopolarMetallicReturn"""))_
    def parse (context: Context): DCConverterOperatingModeKind =
    {
        DCConverterOperatingModeKind(
            sup (context),
            bipolar (context),
            monopolarGroundReturn (context),
            monopolarMetallicReturn (context)
        )
    }
}

/**
 * Indivisible operative unit comprising all equipment between the point of common coupling on the AC side and the point of common coupling � DC side, essentially one or more converters, together with one or more converter transformers, converter control equipment, essential protective and switching devices and auxiliaries, if any, used for conversion.
 */
case class DCConverterUnit
(

    override val sup: DCEquipmentContainer,

    val operationMode: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def DCEquipmentContainer: DCEquipmentContainer = sup.asInstanceOf[DCEquipmentContainer]
    override def copy (): Row = { return (clone ().asInstanceOf[DCConverterUnit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DCConverterUnit
extends
    Parseable[DCConverterUnit]
{
    val sup = DCEquipmentContainer.parse _
    val operationMode = parse_attribute (attribute ("""DCConverterUnit.operationMode"""))_
    def parse (context: Context): DCConverterUnit =
    {
        DCConverterUnit(
            sup (context),
            operationMode (context)
        )
    }
}

/**
 * A disconnector within a DC system.
 */
case class DCDisconnector
(

    override val sup: DCSwitch
)
extends
    Element
{
    def this () = { this (null) }
    def DCSwitch: DCSwitch = sup.asInstanceOf[DCSwitch]
    override def copy (): Row = { return (clone ().asInstanceOf[DCDisconnector]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DCDisconnector
extends
    Parseable[DCDisconnector]
{
    val sup = DCSwitch.parse _
    def parse (context: Context): DCDisconnector =
    {
        DCDisconnector(
            sup (context)
        )
    }
}

/**
 * A modeling construct to provide a root class for containment of DC as well as AC equipment.
 * The class differ from the EquipmentContaner for AC in that it may also contain DCNodes. Hence it can contain both AC and DC equipment.
 */
case class DCEquipmentContainer
(

    override val sup: EquipmentContainer
)
extends
    Element
{
    def this () = { this (null) }
    def EquipmentContainer: EquipmentContainer = sup.asInstanceOf[EquipmentContainer]
    override def copy (): Row = { return (clone ().asInstanceOf[DCEquipmentContainer]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DCEquipmentContainer
extends
    Parseable[DCEquipmentContainer]
{
    val sup = EquipmentContainer.parse _
    def parse (context: Context): DCEquipmentContainer =
    {
        DCEquipmentContainer(
            sup (context)
        )
    }
}

/**
 * A ground within a DC system.
 */
case class DCGround
(

    override val sup: DCConductingEquipment,

    /**
     * Inductance to ground.
     */
    val inductance: Double,

    /**
     * Resistance to ground.
     */
    val r: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0) }
    def DCConductingEquipment: DCConductingEquipment = sup.asInstanceOf[DCConductingEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[DCGround]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DCGround
extends
    Parseable[DCGround]
{
    val sup = DCConductingEquipment.parse _
    val inductance = parse_element (element ("""DCGround.inductance"""))_
    val r = parse_element (element ("""DCGround.r"""))_
    def parse (context: Context): DCGround =
    {
        DCGround(
            sup (context),
            toDouble (inductance (context), context),
            toDouble (r (context), context)
        )
    }
}

/**
 * Overhead lines and/or cables connecting two or more HVDC substations.
 */
case class DCLine
(

    override val sup: DCEquipmentContainer,

    val Region: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def DCEquipmentContainer: DCEquipmentContainer = sup.asInstanceOf[DCEquipmentContainer]
    override def copy (): Row = { return (clone ().asInstanceOf[DCLine]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DCLine
extends
    Parseable[DCLine]
{
    val sup = DCEquipmentContainer.parse _
    val Region = parse_attribute (attribute ("""DCLine.Region"""))_
    def parse (context: Context): DCLine =
    {
        DCLine(
            sup (context),
            Region (context)
        )
    }
}

/**
 * A wire or combination of wires not insulated from one another, with consistent electrical characteristics, used to carry direct current between points in the DC region of the power system.
 */
case class DCLineSegment
(

    override val sup: DCConductingEquipment,

    /**
     * Capacitance of the DC line segment.
     * Significant for cables only.
     */
    val capacitance: Double,

    /**
     * Inductance of the DC line segment.
     * Neglectable compared with DCSeriesDevice used for smoothing.
     */
    val inductance: Double,

    /**
     * Segment length for calculating line section capabilities.
     */
    val len: Double,

    /**
     * Resistance of the DC line segment.
     */
    val resistance: Double,

    /**
     * Set of per-length parameters for this line segment.
     */
    val PerLengthParameter: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, null) }
    def DCConductingEquipment: DCConductingEquipment = sup.asInstanceOf[DCConductingEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[DCLineSegment]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DCLineSegment
extends
    Parseable[DCLineSegment]
{
    val sup = DCConductingEquipment.parse _
    val capacitance = parse_element (element ("""DCLineSegment.capacitance"""))_
    val inductance = parse_element (element ("""DCLineSegment.inductance"""))_
    val len = parse_element (element ("""DCLineSegment.length"""))_
    val resistance = parse_element (element ("""DCLineSegment.resistance"""))_
    val PerLengthParameter = parse_attribute (attribute ("""DCLineSegment.PerLengthParameter"""))_
    def parse (context: Context): DCLineSegment =
    {
        DCLineSegment(
            sup (context),
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
 */
case class DCNode
(

    override val sup: IdentifiedObject,

    val DCEquipmentContainer: String,

    /**
     * See association end ConnectivityNode.
     * TopologicalNode.
     */
    val DCTopologicalNode: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[DCNode]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DCNode
extends
    Parseable[DCNode]
{
    val sup = IdentifiedObject.parse _
    val DCEquipmentContainer = parse_attribute (attribute ("""DCNode.DCEquipmentContainer"""))_
    val DCTopologicalNode = parse_attribute (attribute ("""DCNode.DCTopologicalNode"""))_
    def parse (context: Context): DCNode =
    {
        DCNode(
            sup (context),
            DCEquipmentContainer (context),
            DCTopologicalNode (context)
        )
    }
}

/**
 * Polarity for DC circuits.
 */
case class DCPolarityKind
(

    override val sup: BasicElement,

    /**
     * Middle pole, potentially grounded.
     */
    val middle: String,

    /**
     * Negative pole.
     */
    val negative: String,

    /**
     * Positive pole.
     */
    val positive: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[DCPolarityKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DCPolarityKind
extends
    Parseable[DCPolarityKind]
{
    val sup = BasicElement.parse _
    val middle = parse_attribute (attribute ("""DCPolarityKind.middle"""))_
    val negative = parse_attribute (attribute ("""DCPolarityKind.negative"""))_
    val positive = parse_attribute (attribute ("""DCPolarityKind.positive"""))_
    def parse (context: Context): DCPolarityKind =
    {
        DCPolarityKind(
            sup (context),
            middle (context),
            negative (context),
            positive (context)
        )
    }
}

/**
 * A series device within the DC system, typically a reactor used for filtering or smoothing.
 * Needed for transient and short circuit studies.
 */
case class DCSeriesDevice
(

    override val sup: DCConductingEquipment,

    /**
     * Inductance of the device.
     */
    val inductance: Double,

    /**
     * Rated DC device voltage.
     * Converter configuration data used in power flow.
     */
    val ratedUdc: Double,

    /**
     * Resistance of the DC device.
     */
    val resistance: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0) }
    def DCConductingEquipment: DCConductingEquipment = sup.asInstanceOf[DCConductingEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[DCSeriesDevice]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DCSeriesDevice
extends
    Parseable[DCSeriesDevice]
{
    val sup = DCConductingEquipment.parse _
    val inductance = parse_element (element ("""DCSeriesDevice.inductance"""))_
    val ratedUdc = parse_element (element ("""DCSeriesDevice.ratedUdc"""))_
    val resistance = parse_element (element ("""DCSeriesDevice.resistance"""))_
    def parse (context: Context): DCSeriesDevice =
    {
        DCSeriesDevice(
            sup (context),
            toDouble (inductance (context), context),
            toDouble (ratedUdc (context), context),
            toDouble (resistance (context), context)
        )
    }
}

/**
 * A shunt device within the DC system, typically used for filtering.
 * Needed for transient and short circuit studies.
 */
case class DCShunt
(

    override val sup: DCConductingEquipment,

    /**
     * Capacitance of the DC shunt.
     */
    val capacitance: Double,

    /**
     * Rated DC device voltage.
     * Converter configuration data used in power flow.
     */
    val ratedUdc: Double,

    /**
     * Resistance of the DC device.
     */
    val resistance: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0) }
    def DCConductingEquipment: DCConductingEquipment = sup.asInstanceOf[DCConductingEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[DCShunt]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DCShunt
extends
    Parseable[DCShunt]
{
    val sup = DCConductingEquipment.parse _
    val capacitance = parse_element (element ("""DCShunt.capacitance"""))_
    val ratedUdc = parse_element (element ("""DCShunt.ratedUdc"""))_
    val resistance = parse_element (element ("""DCShunt.resistance"""))_
    def parse (context: Context): DCShunt =
    {
        DCShunt(
            sup (context),
            toDouble (capacitance (context), context),
            toDouble (ratedUdc (context), context),
            toDouble (resistance (context), context)
        )
    }
}

/**
 * A switch within the DC system.
 */
case class DCSwitch
(

    override val sup: DCConductingEquipment
)
extends
    Element
{
    def this () = { this (null) }
    def DCConductingEquipment: DCConductingEquipment = sup.asInstanceOf[DCConductingEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[DCSwitch]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DCSwitch
extends
    Parseable[DCSwitch]
{
    val sup = DCConductingEquipment.parse _
    def parse (context: Context): DCSwitch =
    {
        DCSwitch(
            sup (context)
        )
    }
}

/**
 * An electrical connection point to generic DC conducting equipment.
 */
case class DCTerminal
(

    override val sup: DCBaseTerminal,

    val DCConductingEquipment: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def DCBaseTerminal: DCBaseTerminal = sup.asInstanceOf[DCBaseTerminal]
    override def copy (): Row = { return (clone ().asInstanceOf[DCTerminal]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DCTerminal
extends
    Parseable[DCTerminal]
{
    val sup = DCBaseTerminal.parse _
    val DCConductingEquipment = parse_attribute (attribute ("""DCTerminal.DCConductingEquipment"""))_
    def parse (context: Context): DCTerminal =
    {
        DCTerminal(
            sup (context),
            DCConductingEquipment (context)
        )
    }
}

/**
 * An electrically connected subset of the network.
 * DC topological islands can change as the current network state changes: e.g. due to
 */
case class DCTopologicalIsland
(

    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[DCTopologicalIsland]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DCTopologicalIsland
extends
    Parseable[DCTopologicalIsland]
{
    val sup = IdentifiedObject.parse _
    def parse (context: Context): DCTopologicalIsland =
    {
        DCTopologicalIsland(
            sup (context)
        )
    }
}

case class PerLengthDCLineParameter
(

    override val sup: PerLengthLineParameter,

    /**
     * Capacitance per unit of length of the DC line segment; significant for cables only.
     */
    val capacitance: Double,

    /**
     * Inductance per unit of length of the DC line segment.
     */
    val inductance: Double,

    /**
     * Resistance per length of the DC line segment.
     */
    val resistance: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0) }
    def PerLengthLineParameter: PerLengthLineParameter = sup.asInstanceOf[PerLengthLineParameter]
    override def copy (): Row = { return (clone ().asInstanceOf[PerLengthDCLineParameter]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PerLengthDCLineParameter
extends
    Parseable[PerLengthDCLineParameter]
{
    val sup = PerLengthLineParameter.parse _
    val capacitance = parse_element (element ("""PerLengthDCLineParameter.capacitance"""))_
    val inductance = parse_element (element ("""PerLengthDCLineParameter.inductance"""))_
    val resistance = parse_element (element ("""PerLengthDCLineParameter.resistance"""))_
    def parse (context: Context): PerLengthDCLineParameter =
    {
        PerLengthDCLineParameter(
            sup (context),
            toDouble (capacitance (context), context),
            toDouble (inductance (context), context),
            toDouble (resistance (context), context)
        )
    }
}

/**
 * The P-Q capability curve for a voltage source converter, with P on x-axis and Qmin and Qmax on y1-axis and y2-axis.
 */
case class VsCapabilityCurve
(

    override val sup: Curve
)
extends
    Element
{
    def this () = { this (null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[VsCapabilityCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object VsCapabilityCurve
extends
    Parseable[VsCapabilityCurve]
{
    val sup = Curve.parse _
    def parse (context: Context): VsCapabilityCurve =
    {
        VsCapabilityCurve(
            sup (context)
        )
    }
}

/**
 * DC side of the voltage source converter (VSC).
 */
case class VsConverter
(

    override val sup: ACDCConverter,

    /**
     * Angle between uf and uc.
     * Converter state variable used in power flow.
     */
    val delta: Double,

    /**
     * Droop constant; pu value is obtained as D [kV/MW] x Sb / Ubdc.
     */
    val droop: Double,

    /**
     * Compensation constant.
     * Used to compensate for voltage drop when controlling voltage at a distant bus.
     */
    val droopCompensation: Double,

    /**
     * The max quotient between the AC converter voltage (Uc) and DC voltage (Ud).
     * A factor typically less than 1. VSC configuration data used in power flow.
     */
    val maxModulationIndex: Double,

    /**
     * The maximum current through a valve.
     * This current limit is the basis for calculating the capability diagram. VSC  configuration data.
     */
    val maxValveCurrent: Double,

    /**
     * Kind of control of real power and/or DC voltage.
     */
    val pPccControl: String,

    val qPccControl: String,

    /**
     * Reactive power sharing factor among parallel converters on Uac control.
     */
    val qShare: Double,

    /**
     * Reactive power injection target in AC grid, at point of common coupling.
     */
    val targetQpcc: Double,

    /**
     * Voltage target in AC grid, at point of common coupling.
     */
    val targetUpcc: Double,

    /**
     * Line-to-line voltage on the valve side of the converter transformer.
     * Converter state variable, result from power flow.
     */
    val uf: Double,

    /**
     * Capability curve of this converter.
     */
    val CapabilityCurve: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, 0.0, 0.0, 0.0, 0.0, null) }
    def ACDCConverter: ACDCConverter = sup.asInstanceOf[ACDCConverter]
    override def copy (): Row = { return (clone ().asInstanceOf[VsConverter]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object VsConverter
extends
    Parseable[VsConverter]
{
    val sup = ACDCConverter.parse _
    val delta = parse_element (element ("""VsConverter.delta"""))_
    val droop = parse_element (element ("""VsConverter.droop"""))_
    val droopCompensation = parse_element (element ("""VsConverter.droopCompensation"""))_
    val maxModulationIndex = parse_element (element ("""VsConverter.maxModulationIndex"""))_
    val maxValveCurrent = parse_element (element ("""VsConverter.maxValveCurrent"""))_
    val pPccControl = parse_attribute (attribute ("""VsConverter.pPccControl"""))_
    val qPccControl = parse_attribute (attribute ("""VsConverter.qPccControl"""))_
    val qShare = parse_element (element ("""VsConverter.qShare"""))_
    val targetQpcc = parse_element (element ("""VsConverter.targetQpcc"""))_
    val targetUpcc = parse_element (element ("""VsConverter.targetUpcc"""))_
    val uf = parse_element (element ("""VsConverter.uf"""))_
    val CapabilityCurve = parse_attribute (attribute ("""VsConverter.CapabilityCurve"""))_
    def parse (context: Context): VsConverter =
    {
        VsConverter(
            sup (context),
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

/**
 * Types applicable to the control of real power and/or DC voltage by voltage source converter.
 */
case class VsPpccControlKind
(

    override val sup: BasicElement,

    /**
     * Control variable (target) is real power at PCC bus.
     */
    val pPcc: String,

    /**
     * Control variables (targets) are both active power at point of common coupling and local DC voltage, with the droop.
     */
    val pPccAndUdcDroop: String,

    /**
     * Control variables (targets) are both active power at point of common coupling and the pilot DC voltage, with the droop.
     */
    val pPccAndUdcDroopPilot: String,

    /**
     * Control variables (targets) are both active power at point of common coupling and compensated DC voltage, with the droop; compensation factor is the resistance, as an approximation of the DC voltage of a common (real or virtual) node in the DC network.
     */
    val pPccAndUdcDroopWithCompensation: String,

    /**
     * Control variable (target) is DC voltage and real power at PCC bus is derived.
     */
    val udc: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[VsPpccControlKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object VsPpccControlKind
extends
    Parseable[VsPpccControlKind]
{
    val sup = BasicElement.parse _
    val pPcc = parse_attribute (attribute ("""VsPpccControlKind.pPcc"""))_
    val pPccAndUdcDroop = parse_attribute (attribute ("""VsPpccControlKind.pPccAndUdcDroop"""))_
    val pPccAndUdcDroopPilot = parse_attribute (attribute ("""VsPpccControlKind.pPccAndUdcDroopPilot"""))_
    val pPccAndUdcDroopWithCompensation = parse_attribute (attribute ("""VsPpccControlKind.pPccAndUdcDroopWithCompensation"""))_
    val udc = parse_attribute (attribute ("""VsPpccControlKind.udc"""))_
    def parse (context: Context): VsPpccControlKind =
    {
        VsPpccControlKind(
            sup (context),
            pPcc (context),
            pPccAndUdcDroop (context),
            pPccAndUdcDroopPilot (context),
            pPccAndUdcDroopWithCompensation (context),
            udc (context)
        )
    }
}

case class VsQpccControlKind
(

    override val sup: BasicElement,

    val powerFactorPcc: String,

    val reactivePcc: String,

    val voltagePcc: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[VsQpccControlKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object VsQpccControlKind
extends
    Parseable[VsQpccControlKind]
{
    val sup = BasicElement.parse _
    val powerFactorPcc = parse_attribute (attribute ("""VsQpccControlKind.powerFactorPcc"""))_
    val reactivePcc = parse_attribute (attribute ("""VsQpccControlKind.reactivePcc"""))_
    val voltagePcc = parse_attribute (attribute ("""VsQpccControlKind.voltagePcc"""))_
    def parse (context: Context): VsQpccControlKind =
    {
        VsQpccControlKind(
            sup (context),
            powerFactorPcc (context),
            reactivePcc (context),
            voltagePcc (context)
        )
    }
}

object _DC
{
    def register: Unit =
    {
        ACDCConverter.register
        ACDCConverterDCTerminal.register
        CsConverter.register
        CsOperatingModeKind.register
        CsPpccControlKind.register
        DCBaseTerminal.register
        DCBreaker.register
        DCBusbar.register
        DCChopper.register
        DCConductingEquipment.register
        DCConverterOperatingModeKind.register
        DCConverterUnit.register
        DCDisconnector.register
        DCEquipmentContainer.register
        DCGround.register
        DCLine.register
        DCLineSegment.register
        DCNode.register
        DCPolarityKind.register
        DCSeriesDevice.register
        DCShunt.register
        DCSwitch.register
        DCTerminal.register
        DCTopologicalIsland.register
        PerLengthDCLineParameter.register
        VsCapabilityCurve.register
        VsConverter.register
        VsPpccControlKind.register
        VsQpccControlKind.register
    }
}
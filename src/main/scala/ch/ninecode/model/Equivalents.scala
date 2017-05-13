package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * The equivalents package models equivalent networks.
 */

/**
 * The class represents equivalent branches.
 */
case class EquivalentBranch
(

    override val sup: EquivalentEquipment,

    /**
     * Negative sequence series resistance from terminal sequence  1 to terminal sequence 2.
     * Used for short circuit data exchange according to IEC 60909
     */
    val negativeR12: Double,

    /**
     * Negative sequence series resistance from terminal sequence 2 to terminal sequence 1.
     * Used for short circuit data exchange according to IEC 60909
     */
    val negativeR21: Double,

    /**
     * Negative sequence series reactance from terminal sequence  1 to terminal sequence 2.
     * Used for short circuit data exchange according to IEC 60909
     */
    val negativeX12: Double,

    /**
     * Negative sequence series reactance from terminal sequence 2 to terminal sequence 1.
     * Used for short circuit data exchange according to IEC 60909.
     */
    val negativeX21: Double,

    /**
     * Positive sequence series resistance from terminal sequence  1 to terminal sequence 2 .
     * Used for short circuit data exchange according to IEC 60909.
     */
    val positiveR12: Double,

    /**
     * Positive sequence series resistance from terminal sequence 2 to terminal sequence 1.
     * Used for short circuit data exchange according to IEC 60909
     */
    val positiveR21: Double,

    /**
     * Positive sequence series reactance from terminal sequence  1 to terminal sequence 2.
     * Used for short circuit data exchange according to IEC 60909
     */
    val positiveX12: Double,

    /**
     * Positive sequence series reactance from terminal sequence 2 to terminal sequence 1.
     * Used for short circuit data exchange according to IEC 60909
     */
    val positiveX21: Double,

    /**
     * Positive sequence series resistance of the reduced branch.
     */
    val r: Double,

    /**
     * Resistance from terminal sequence 2 to terminal sequence 1 .
     * Used for steady state power flow. This attribute is optional and represent unbalanced network such as off-nominal phase shifter. If only EquivalentBranch.r is given, then EquivalentBranch.r21 is assumed equal to EquivalentBranch.r.
     */
    val r21: Double,

    /**
     * Positive sequence series reactance of the reduced branch.
     */
    val x: Double,

    /**
     * Reactance from terminal sequence 2 to terminal sequence 1 .
     * Used for steady state power flow. This attribute is optional and represent unbalanced network such as off-nominal phase shifter. If only EquivalentBranch.x is given, then EquivalentBranch.x21 is assumed equal to EquivalentBranch.x.
     */
    val x21: Double,

    /**
     * Zero sequence series resistance from terminal sequence  1 to terminal sequence 2.
     * Used for short circuit data exchange according to IEC 60909
     */
    val zeroR12: Double,

    /**
     * Zero sequence series resistance from terminal sequence  2 to terminal sequence 1.
     * Used for short circuit data exchange according to IEC 60909
     */
    val zeroR21: Double,

    /**
     * Zero sequence series reactance from terminal sequence  1 to terminal sequence 2.
     * Used for short circuit data exchange according to IEC 60909
     */
    val zeroX12: Double,

    /**
     * Zero sequence series reactance from terminal sequence 2 to terminal sequence 1.
     * Used for short circuit data exchange according to IEC 60909
     */
    val zeroX21: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def EquivalentEquipment: EquivalentEquipment = sup.asInstanceOf[EquivalentEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[EquivalentBranch]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EquivalentBranch
extends
    Parseable[EquivalentBranch]
{
    val sup = EquivalentEquipment.parse _
    val negativeR12 = parse_element (element ("""EquivalentBranch.negativeR12"""))_
    val negativeR21 = parse_element (element ("""EquivalentBranch.negativeR21"""))_
    val negativeX12 = parse_element (element ("""EquivalentBranch.negativeX12"""))_
    val negativeX21 = parse_element (element ("""EquivalentBranch.negativeX21"""))_
    val positiveR12 = parse_element (element ("""EquivalentBranch.positiveR12"""))_
    val positiveR21 = parse_element (element ("""EquivalentBranch.positiveR21"""))_
    val positiveX12 = parse_element (element ("""EquivalentBranch.positiveX12"""))_
    val positiveX21 = parse_element (element ("""EquivalentBranch.positiveX21"""))_
    val r = parse_element (element ("""EquivalentBranch.r"""))_
    val r21 = parse_element (element ("""EquivalentBranch.r21"""))_
    val x = parse_element (element ("""EquivalentBranch.x"""))_
    val x21 = parse_element (element ("""EquivalentBranch.x21"""))_
    val zeroR12 = parse_element (element ("""EquivalentBranch.zeroR12"""))_
    val zeroR21 = parse_element (element ("""EquivalentBranch.zeroR21"""))_
    val zeroX12 = parse_element (element ("""EquivalentBranch.zeroX12"""))_
    val zeroX21 = parse_element (element ("""EquivalentBranch.zeroX21"""))_
    def parse (context: Context): EquivalentBranch =
    {
        EquivalentBranch(
            sup (context),
            toDouble (negativeR12 (context), context),
            toDouble (negativeR21 (context), context),
            toDouble (negativeX12 (context), context),
            toDouble (negativeX21 (context), context),
            toDouble (positiveR12 (context), context),
            toDouble (positiveR21 (context), context),
            toDouble (positiveX12 (context), context),
            toDouble (positiveX21 (context), context),
            toDouble (r (context), context),
            toDouble (r21 (context), context),
            toDouble (x (context), context),
            toDouble (x21 (context), context),
            toDouble (zeroR12 (context), context),
            toDouble (zeroR21 (context), context),
            toDouble (zeroX12 (context), context),
            toDouble (zeroX21 (context), context)
        )
    }
}

/**
 * The class represents equivalent objects that are the result of a network reduction.
 * The class is the base for equivalent objects of different types.
 */
case class EquivalentEquipment
(

    override val sup: ConductingEquipment,

    /**
     * The equivalent where the reduced model belongs.
     */
    val EquivalentNetwork: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[EquivalentEquipment]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EquivalentEquipment
extends
    Parseable[EquivalentEquipment]
{
    val sup = ConductingEquipment.parse _
    val EquivalentNetwork = parse_attribute (attribute ("""EquivalentEquipment.EquivalentNetwork"""))_
    def parse (context: Context): EquivalentEquipment =
    {
        EquivalentEquipment(
            sup (context),
            EquivalentNetwork (context)
        )
    }
}

/**
 * This class represents equivalent injections (generation or load).
 * Voltage regulation is allowed only at the point of connection.
 */
case class EquivalentInjection
(

    override val sup: EquivalentEquipment,

    /**
     * Maximum active power of the injection.
     */
    val maxP: Double,

    /**
     * Used for modeling of infeed for load flow exchange.
     * Not used for short circuit modeling.  If maxQ and minQ are not used ReactiveCapabilityCurve can be used.
     */
    val maxQ: Double,

    /**
     * Minimum active power of the injection.
     */
    val minP: Double,

    /**
     * Used for modeling of infeed for load flow exchange.
     * Not used for short circuit modeling.  If maxQ and minQ are not used ReactiveCapabilityCurve can be used.
     */
    val minQ: Double,

    /**
     * Equivalent active power injection.
     * Load sign convention is used, i.e. positive sign means flow out from a node.
     */
    val p: Double,

    /**
     * Equivalent reactive power injection.
     * Load sign convention is used, i.e. positive sign means flow out from a node.
     */
    val q: Double,

    /**
     * Positive sequence resistance.
     * Used to represent Extended-Ward (IEC 60909).
     */
    val r: Double,

    /**
     * Zero sequence resistance.
     * Used to represent Extended-Ward (IEC 60909).
     */
    val r0: Double,

    /**
     * Negative sequence resistance.
     * Used to represent Extended-Ward (IEC 60909).
     */
    val r2: Double,

    /**
     * Specifies whether or not the EquivalentInjection has the capability to regulate the local voltage.
     */
    val regulationCapability: Boolean,

    /**
     * Specifies the default regulation status of the EquivalentInjection.
     * True is regulating.  False is not regulating.
     */
    val regulationStatus: Boolean,

    /**
     * The target voltage for voltage regulation.
     */
    val regulationTarget: Double,

    /**
     * Positive sequence reactance.
     * Used to represent Extended-Ward (IEC 60909).
     */
    val x: Double,

    /**
     * Zero sequence reactance.
     * Used to represent Extended-Ward (IEC 60909).
     */
    val x0: Double,

    /**
     * Negative sequence reactance.
     * Used to represent Extended-Ward (IEC 60909).
     */
    val x2: Double,

    /**
     * The reactive capability curve used by this equivalent injection.
     */
    val ReactiveCapabilityCurve: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, false, 0.0, 0.0, 0.0, 0.0, null) }
    def EquivalentEquipment: EquivalentEquipment = sup.asInstanceOf[EquivalentEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[EquivalentInjection]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EquivalentInjection
extends
    Parseable[EquivalentInjection]
{
    val sup = EquivalentEquipment.parse _
    val maxP = parse_element (element ("""EquivalentInjection.maxP"""))_
    val maxQ = parse_element (element ("""EquivalentInjection.maxQ"""))_
    val minP = parse_element (element ("""EquivalentInjection.minP"""))_
    val minQ = parse_element (element ("""EquivalentInjection.minQ"""))_
    val p = parse_element (element ("""EquivalentInjection.p"""))_
    val q = parse_element (element ("""EquivalentInjection.q"""))_
    val r = parse_element (element ("""EquivalentInjection.r"""))_
    val r0 = parse_element (element ("""EquivalentInjection.r0"""))_
    val r2 = parse_element (element ("""EquivalentInjection.r2"""))_
    val regulationCapability = parse_element (element ("""EquivalentInjection.regulationCapability"""))_
    val regulationStatus = parse_element (element ("""EquivalentInjection.regulationStatus"""))_
    val regulationTarget = parse_element (element ("""EquivalentInjection.regulationTarget"""))_
    val x = parse_element (element ("""EquivalentInjection.x"""))_
    val x0 = parse_element (element ("""EquivalentInjection.x0"""))_
    val x2 = parse_element (element ("""EquivalentInjection.x2"""))_
    val ReactiveCapabilityCurve = parse_attribute (attribute ("""EquivalentInjection.ReactiveCapabilityCurve"""))_
    def parse (context: Context): EquivalentInjection =
    {
        EquivalentInjection(
            sup (context),
            toDouble (maxP (context), context),
            toDouble (maxQ (context), context),
            toDouble (minP (context), context),
            toDouble (minQ (context), context),
            toDouble (p (context), context),
            toDouble (q (context), context),
            toDouble (r (context), context),
            toDouble (r0 (context), context),
            toDouble (r2 (context), context),
            toBoolean (regulationCapability (context), context),
            toBoolean (regulationStatus (context), context),
            toDouble (regulationTarget (context), context),
            toDouble (x (context), context),
            toDouble (x0 (context), context),
            toDouble (x2 (context), context),
            ReactiveCapabilityCurve (context)
        )
    }
}

/**
 * A class that represents an external meshed network that has been reduced to an electrically equivalent model.
 * The ConnectivityNodes contained in the equivalent are intended to reflect internal nodes of the equivalent. The boundary Connectivity nodes where the equivalent connects outside itself are NOT contained by the equivalent.
 */
case class EquivalentNetwork
(

    override val sup: ConnectivityNodeContainer
)
extends
    Element
{
    def this () = { this (null) }
    def ConnectivityNodeContainer: ConnectivityNodeContainer = sup.asInstanceOf[ConnectivityNodeContainer]
    override def copy (): Row = { return (clone ().asInstanceOf[EquivalentNetwork]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EquivalentNetwork
extends
    Parseable[EquivalentNetwork]
{
    val sup = ConnectivityNodeContainer.parse _
    def parse (context: Context): EquivalentNetwork =
    {
        EquivalentNetwork(
            sup (context)
        )
    }
}

/**
 * The class represents equivalent shunts.
 */
case class EquivalentShunt
(

    override val sup: EquivalentEquipment,

    /**
     * Positive sequence shunt susceptance.
     */
    val b: Double,

    /**
     * Positive sequence shunt conductance.
     */
    val g: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0) }
    def EquivalentEquipment: EquivalentEquipment = sup.asInstanceOf[EquivalentEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[EquivalentShunt]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EquivalentShunt
extends
    Parseable[EquivalentShunt]
{
    val sup = EquivalentEquipment.parse _
    val b = parse_element (element ("""EquivalentShunt.b"""))_
    val g = parse_element (element ("""EquivalentShunt.g"""))_
    def parse (context: Context): EquivalentShunt =
    {
        EquivalentShunt(
            sup (context),
            toDouble (b (context), context),
            toDouble (g (context), context)
        )
    }
}

object _Equivalents
{
    def register: Unit =
    {
        EquivalentBranch.register
        EquivalentEquipment.register
        EquivalentInjection.register
        EquivalentNetwork.register
        EquivalentShunt.register
    }
}
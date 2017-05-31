package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * The equivalents package models equivalent networks.
 */

/**
 * The class represents equivalent branches.
 * @param sup Reference to the superclass object.
 * @param negativeR12 Negative sequence series resistance from terminal sequence  1 to terminal sequence 2.
 *        Used for short circuit data exchange according to IEC 60909
 * @param negativeR21 Negative sequence series resistance from terminal sequence 2 to terminal sequence 1.
 *        Used for short circuit data exchange according to IEC 60909
 * @param negativeX12 Negative sequence series reactance from terminal sequence  1 to terminal sequence 2.
 *        Used for short circuit data exchange according to IEC 60909
 * @param negativeX21 Negative sequence series reactance from terminal sequence 2 to terminal sequence 1.
 *        Used for short circuit data exchange according to IEC 60909.
 * @param positiveR12 Positive sequence series resistance from terminal sequence  1 to terminal sequence 2 .
 *        Used for short circuit data exchange according to IEC 60909.
 * @param positiveR21 Positive sequence series resistance from terminal sequence 2 to terminal sequence 1.
 *        Used for short circuit data exchange according to IEC 60909
 * @param positiveX12 Positive sequence series reactance from terminal sequence  1 to terminal sequence 2.
 *        Used for short circuit data exchange according to IEC 60909
 * @param positiveX21 Positive sequence series reactance from terminal sequence 2 to terminal sequence 1.
 *        Used for short circuit data exchange according to IEC 60909
 * @param r Positive sequence series resistance of the reduced branch.
 * @param r21 Resistance from terminal sequence 2 to terminal sequence 1 .
 *        Used for steady state power flow. This attribute is optional and represent unbalanced network such as off-nominal phase shifter. If only EquivalentBranch.r is given, then EquivalentBranch.r21 is assumed equal to EquivalentBranch.r.
 * @param x Positive sequence series reactance of the reduced branch.
 * @param x21 Reactance from terminal sequence 2 to terminal sequence 1 .
 *        Used for steady state power flow. This attribute is optional and represent unbalanced network such as off-nominal phase shifter. If only EquivalentBranch.x is given, then EquivalentBranch.x21 is assumed equal to EquivalentBranch.x.
 * @param zeroR12 Zero sequence series resistance from terminal sequence  1 to terminal sequence 2.
 *        Used for short circuit data exchange according to IEC 60909
 * @param zeroR21 Zero sequence series resistance from terminal sequence  2 to terminal sequence 1.
 *        Used for short circuit data exchange according to IEC 60909
 * @param zeroX12 Zero sequence series reactance from terminal sequence  1 to terminal sequence 2.
 *        Used for short circuit data exchange according to IEC 60909
 * @param zeroX21 Zero sequence series reactance from terminal sequence 2 to terminal sequence 1.
 *        Used for short circuit data exchange according to IEC 60909
 */
case class EquivalentBranch
(
    override val sup: EquivalentEquipment,
    val negativeR12: Double,
    val negativeR21: Double,
    val negativeX12: Double,
    val negativeX21: Double,
    val positiveR12: Double,
    val positiveR21: Double,
    val positiveX12: Double,
    val positiveX21: Double,
    val r: Double,
    val r21: Double,
    val x: Double,
    val x21: Double,
    val zeroR12: Double,
    val zeroR21: Double,
    val zeroX12: Double,
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
    val negativeR12 = parse_element (element ("""EquivalentBranch.negativeR12"""))
    val negativeR21 = parse_element (element ("""EquivalentBranch.negativeR21"""))
    val negativeX12 = parse_element (element ("""EquivalentBranch.negativeX12"""))
    val negativeX21 = parse_element (element ("""EquivalentBranch.negativeX21"""))
    val positiveR12 = parse_element (element ("""EquivalentBranch.positiveR12"""))
    val positiveR21 = parse_element (element ("""EquivalentBranch.positiveR21"""))
    val positiveX12 = parse_element (element ("""EquivalentBranch.positiveX12"""))
    val positiveX21 = parse_element (element ("""EquivalentBranch.positiveX21"""))
    val r = parse_element (element ("""EquivalentBranch.r"""))
    val r21 = parse_element (element ("""EquivalentBranch.r21"""))
    val x = parse_element (element ("""EquivalentBranch.x"""))
    val x21 = parse_element (element ("""EquivalentBranch.x21"""))
    val zeroR12 = parse_element (element ("""EquivalentBranch.zeroR12"""))
    val zeroR21 = parse_element (element ("""EquivalentBranch.zeroR21"""))
    val zeroX12 = parse_element (element ("""EquivalentBranch.zeroX12"""))
    val zeroX21 = parse_element (element ("""EquivalentBranch.zeroX21"""))
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
 * @param sup Reference to the superclass object.
 * @param EquivalentNetwork The equivalent where the reduced model belongs.
 */
case class EquivalentEquipment
(
    override val sup: ConductingEquipment,
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
    val EquivalentNetwork = parse_attribute (attribute ("""EquivalentEquipment.EquivalentNetwork"""))
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
 * @param sup Reference to the superclass object.
 * @param maxP Maximum active power of the injection.
 * @param maxQ Used for modeling of infeed for load flow exchange.
 *        Not used for short circuit modeling.  If maxQ and minQ are not used ReactiveCapabilityCurve can be used.
 * @param minP Minimum active power of the injection.
 * @param minQ Used for modeling of infeed for load flow exchange.
 *        Not used for short circuit modeling.  If maxQ and minQ are not used ReactiveCapabilityCurve can be used.
 * @param p Equivalent active power injection.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param q Equivalent reactive power injection.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param r Positive sequence resistance.
 *        Used to represent Extended-Ward (IEC 60909).
 * @param r0 Zero sequence resistance.
 *        Used to represent Extended-Ward (IEC 60909).
 * @param r2 Negative sequence resistance.
 *        Used to represent Extended-Ward (IEC 60909).
 * @param regulationCapability Specifies whether or not the EquivalentInjection has the capability to regulate the local voltage.
 * @param regulationStatus Specifies the default regulation status of the EquivalentInjection.
 *        True is regulating.  False is not regulating.
 * @param regulationTarget The target voltage for voltage regulation.
 * @param x Positive sequence reactance.
 *        Used to represent Extended-Ward (IEC 60909).
 * @param x0 Zero sequence reactance.
 *        Used to represent Extended-Ward (IEC 60909).
 * @param x2 Negative sequence reactance.
 *        Used to represent Extended-Ward (IEC 60909).
 * @param ReactiveCapabilityCurve The reactive capability curve used by this equivalent injection.
 */
case class EquivalentInjection
(
    override val sup: EquivalentEquipment,
    val maxP: Double,
    val maxQ: Double,
    val minP: Double,
    val minQ: Double,
    val p: Double,
    val q: Double,
    val r: Double,
    val r0: Double,
    val r2: Double,
    val regulationCapability: Boolean,
    val regulationStatus: Boolean,
    val regulationTarget: Double,
    val x: Double,
    val x0: Double,
    val x2: Double,
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
    val maxP = parse_element (element ("""EquivalentInjection.maxP"""))
    val maxQ = parse_element (element ("""EquivalentInjection.maxQ"""))
    val minP = parse_element (element ("""EquivalentInjection.minP"""))
    val minQ = parse_element (element ("""EquivalentInjection.minQ"""))
    val p = parse_element (element ("""EquivalentInjection.p"""))
    val q = parse_element (element ("""EquivalentInjection.q"""))
    val r = parse_element (element ("""EquivalentInjection.r"""))
    val r0 = parse_element (element ("""EquivalentInjection.r0"""))
    val r2 = parse_element (element ("""EquivalentInjection.r2"""))
    val regulationCapability = parse_element (element ("""EquivalentInjection.regulationCapability"""))
    val regulationStatus = parse_element (element ("""EquivalentInjection.regulationStatus"""))
    val regulationTarget = parse_element (element ("""EquivalentInjection.regulationTarget"""))
    val x = parse_element (element ("""EquivalentInjection.x"""))
    val x0 = parse_element (element ("""EquivalentInjection.x0"""))
    val x2 = parse_element (element ("""EquivalentInjection.x2"""))
    val ReactiveCapabilityCurve = parse_attribute (attribute ("""EquivalentInjection.ReactiveCapabilityCurve"""))
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
 * @param sup Reference to the superclass object.
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
 * @param sup Reference to the superclass object.
 * @param b Positive sequence shunt susceptance.
 * @param g Positive sequence shunt conductance.
 */
case class EquivalentShunt
(
    override val sup: EquivalentEquipment,
    val b: Double,
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
    val b = parse_element (element ("""EquivalentShunt.b"""))
    val g = parse_element (element ("""EquivalentShunt.g"""))
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
package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

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
    negativeR12: Double,
    negativeR21: Double,
    negativeX12: Double,
    negativeX21: Double,
    positiveR12: Double,
    positiveR21: Double,
    positiveX12: Double,
    positiveX21: Double,
    r: Double,
    r21: Double,
    x: Double,
    x21: Double,
    zeroR12: Double,
    zeroR21: Double,
    zeroX12: Double,
    zeroX21: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    def EquivalentEquipment: EquivalentEquipment = sup.asInstanceOf[EquivalentEquipment]
    override def copy (): Row = { clone ().asInstanceOf[EquivalentBranch] }
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
        "\t\t<cim:EquivalentBranch.negativeR12>" + negativeR12 + "</cim:EquivalentBranch.negativeR12>\n" +
        "\t\t<cim:EquivalentBranch.negativeR21>" + negativeR21 + "</cim:EquivalentBranch.negativeR21>\n" +
        "\t\t<cim:EquivalentBranch.negativeX12>" + negativeX12 + "</cim:EquivalentBranch.negativeX12>\n" +
        "\t\t<cim:EquivalentBranch.negativeX21>" + negativeX21 + "</cim:EquivalentBranch.negativeX21>\n" +
        "\t\t<cim:EquivalentBranch.positiveR12>" + positiveR12 + "</cim:EquivalentBranch.positiveR12>\n" +
        "\t\t<cim:EquivalentBranch.positiveR21>" + positiveR21 + "</cim:EquivalentBranch.positiveR21>\n" +
        "\t\t<cim:EquivalentBranch.positiveX12>" + positiveX12 + "</cim:EquivalentBranch.positiveX12>\n" +
        "\t\t<cim:EquivalentBranch.positiveX21>" + positiveX21 + "</cim:EquivalentBranch.positiveX21>\n" +
        "\t\t<cim:EquivalentBranch.r>" + r + "</cim:EquivalentBranch.r>\n" +
        "\t\t<cim:EquivalentBranch.r21>" + r21 + "</cim:EquivalentBranch.r21>\n" +
        "\t\t<cim:EquivalentBranch.x>" + x + "</cim:EquivalentBranch.x>\n" +
        "\t\t<cim:EquivalentBranch.x21>" + x21 + "</cim:EquivalentBranch.x21>\n" +
        "\t\t<cim:EquivalentBranch.zeroR12>" + zeroR12 + "</cim:EquivalentBranch.zeroR12>\n" +
        "\t\t<cim:EquivalentBranch.zeroR21>" + zeroR21 + "</cim:EquivalentBranch.zeroR21>\n" +
        "\t\t<cim:EquivalentBranch.zeroX12>" + zeroX12 + "</cim:EquivalentBranch.zeroX12>\n" +
        "\t\t<cim:EquivalentBranch.zeroX21>" + zeroX21 + "</cim:EquivalentBranch.zeroX21>\n"
    }
    override def export: String =
    {
        "\t<cim:EquivalentBranch rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EquivalentBranch>"
    }
}

object EquivalentBranch
extends
    Parseable[EquivalentBranch]
{
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
            EquivalentEquipment.parse (context),
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
    EquivalentNetwork: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def ConductingEquipment: ConductingEquipment = sup.asInstanceOf[ConductingEquipment]
    override def copy (): Row = { clone ().asInstanceOf[EquivalentEquipment] }
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
        (if (null != EquivalentNetwork) "\t\t<cim:EquivalentEquipment.EquivalentNetwork rdf:resource=\"#" + EquivalentNetwork + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EquivalentEquipment rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EquivalentEquipment>"
    }
}

object EquivalentEquipment
extends
    Parseable[EquivalentEquipment]
{
    val EquivalentNetwork = parse_attribute (attribute ("""EquivalentEquipment.EquivalentNetwork"""))
    def parse (context: Context): EquivalentEquipment =
    {
        EquivalentEquipment(
            ConductingEquipment.parse (context),
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
    maxP: Double,
    maxQ: Double,
    minP: Double,
    minQ: Double,
    p: Double,
    q: Double,
    r: Double,
    r0: Double,
    r2: Double,
    regulationCapability: Boolean,
    regulationStatus: Boolean,
    regulationTarget: Double,
    x: Double,
    x0: Double,
    x2: Double,
    ReactiveCapabilityCurve: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, false, false, 0.0, 0.0, 0.0, 0.0, null) }
    def EquivalentEquipment: EquivalentEquipment = sup.asInstanceOf[EquivalentEquipment]
    override def copy (): Row = { clone ().asInstanceOf[EquivalentInjection] }
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
        "\t\t<cim:EquivalentInjection.maxP>" + maxP + "</cim:EquivalentInjection.maxP>\n" +
        "\t\t<cim:EquivalentInjection.maxQ>" + maxQ + "</cim:EquivalentInjection.maxQ>\n" +
        "\t\t<cim:EquivalentInjection.minP>" + minP + "</cim:EquivalentInjection.minP>\n" +
        "\t\t<cim:EquivalentInjection.minQ>" + minQ + "</cim:EquivalentInjection.minQ>\n" +
        "\t\t<cim:EquivalentInjection.p>" + p + "</cim:EquivalentInjection.p>\n" +
        "\t\t<cim:EquivalentInjection.q>" + q + "</cim:EquivalentInjection.q>\n" +
        "\t\t<cim:EquivalentInjection.r>" + r + "</cim:EquivalentInjection.r>\n" +
        "\t\t<cim:EquivalentInjection.r0>" + r0 + "</cim:EquivalentInjection.r0>\n" +
        "\t\t<cim:EquivalentInjection.r2>" + r2 + "</cim:EquivalentInjection.r2>\n" +
        "\t\t<cim:EquivalentInjection.regulationCapability>" + regulationCapability + "</cim:EquivalentInjection.regulationCapability>\n" +
        "\t\t<cim:EquivalentInjection.regulationStatus>" + regulationStatus + "</cim:EquivalentInjection.regulationStatus>\n" +
        "\t\t<cim:EquivalentInjection.regulationTarget>" + regulationTarget + "</cim:EquivalentInjection.regulationTarget>\n" +
        "\t\t<cim:EquivalentInjection.x>" + x + "</cim:EquivalentInjection.x>\n" +
        "\t\t<cim:EquivalentInjection.x0>" + x0 + "</cim:EquivalentInjection.x0>\n" +
        "\t\t<cim:EquivalentInjection.x2>" + x2 + "</cim:EquivalentInjection.x2>\n" +
        (if (null != ReactiveCapabilityCurve) "\t\t<cim:EquivalentInjection.ReactiveCapabilityCurve rdf:resource=\"#" + ReactiveCapabilityCurve + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EquivalentInjection rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EquivalentInjection>"
    }
}

object EquivalentInjection
extends
    Parseable[EquivalentInjection]
{
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
            EquivalentEquipment.parse (context),
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
    override def copy (): Row = { clone ().asInstanceOf[EquivalentNetwork] }
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
        "\t<cim:EquivalentNetwork rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EquivalentNetwork>"
    }
}

object EquivalentNetwork
extends
    Parseable[EquivalentNetwork]
{
    def parse (context: Context): EquivalentNetwork =
    {
        EquivalentNetwork(
            ConnectivityNodeContainer.parse (context)
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
    b: Double,
    g: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0) }
    def EquivalentEquipment: EquivalentEquipment = sup.asInstanceOf[EquivalentEquipment]
    override def copy (): Row = { clone ().asInstanceOf[EquivalentShunt] }
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
        "\t\t<cim:EquivalentShunt.b>" + b + "</cim:EquivalentShunt.b>\n" +
        "\t\t<cim:EquivalentShunt.g>" + g + "</cim:EquivalentShunt.g>\n"
    }
    override def export: String =
    {
        "\t<cim:EquivalentShunt rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EquivalentShunt>"
    }
}

object EquivalentShunt
extends
    Parseable[EquivalentShunt]
{
    val b = parse_element (element ("""EquivalentShunt.b"""))
    val g = parse_element (element ("""EquivalentShunt.g"""))
    def parse (context: Context): EquivalentShunt =
    {
        EquivalentShunt(
            EquivalentEquipment.parse (context),
            toDouble (b (context), context),
            toDouble (g (context), context)
        )
    }
}

private[ninecode] object _Equivalents
{
    def register: List[ClassInfo] =
    {
        List (
            EquivalentBranch.register,
            EquivalentEquipment.register,
            EquivalentInjection.register,
            EquivalentNetwork.register,
            EquivalentShunt.register
        )
    }
}
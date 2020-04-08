package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * The class represents equivalent branches.
 *
 * @param sup [[ch.ninecode.model.EquivalentEquipment EquivalentEquipment]] Reference to the superclass object.
 * @param negativeR12 Negative sequence series resistance from terminal sequence  1 to terminal sequence 2.
 *        Used for short circuit data exchange according to IEC 60909.
 *        EquivalentBranch is a result of network reduction prior to the data exchange.
 * @param negativeR21 Negative sequence series resistance from terminal sequence 2 to terminal sequence 1.
 *        Used for short circuit data exchange according to IEC 60909.
 *        EquivalentBranch is a result of network reduction prior to the data exchange.
 * @param negativeX12 Negative sequence series reactance from terminal sequence  1 to terminal sequence 2.
 *        Used for short circuit data exchange according to IEC 60909.
 *        Usage : EquivalentBranch is a result of network reduction prior to the data exchange.
 * @param negativeX21 Negative sequence series reactance from terminal sequence 2 to terminal sequence 1.
 *        Used for short circuit data exchange according to IEC 60909.
 *        Usage: EquivalentBranch is a result of network reduction prior to the data exchange.
 * @param positiveR12 Positive sequence series resistance from terminal sequence  1 to terminal sequence 2 .
 *        Used for short circuit data exchange according to IEC 60909.
 *        EquivalentBranch is a result of network reduction prior to the data exchange.
 * @param positiveR21 Positive sequence series resistance from terminal sequence 2 to terminal sequence 1.
 *        Used for short circuit data exchange according to IEC 60909.
 *        EquivalentBranch is a result of network reduction prior to the data exchange.
 * @param positiveX12 Positive sequence series reactance from terminal sequence  1 to terminal sequence 2.
 *        Used for short circuit data exchange according to IEC 60909.
 *        Usage : EquivalentBranch is a result of network reduction prior to the data exchange.
 * @param positiveX21 Positive sequence series reactance from terminal sequence 2 to terminal sequence 1.
 *        Used for short circuit data exchange according to IEC 60909.
 *        Usage : EquivalentBranch is a result of network reduction prior to the data exchange.
 * @param r Positive sequence series resistance of the reduced branch.
 * @param r21 Resistance from terminal sequence 2 to terminal sequence 1 .
 *        Used for steady state power flow. This attribute is optional and represent unbalanced network such as off-nominal phase shifter. If only EquivalentBranch.r is given, then EquivalentBranch.r21 is assumed equal to EquivalentBranch.r.
 *        Usage rule : EquivalentBranch is a result of network reduction prior to the data exchange.
 * @param x Positive sequence series reactance of the reduced branch.
 * @param x21 Reactance from terminal sequence 2 to terminal sequence 1.
 *        Used for steady state power flow. This attribute is optional and represents an unbalanced network such as off-nominal phase shifter. If only EquivalentBranch.x is given, then EquivalentBranch.x21 is assumed equal to EquivalentBranch.x.
 *        Usage rule: EquivalentBranch is a result of network reduction prior to the data exchange.
 * @param zeroR12 Zero sequence series resistance from terminal sequence  1 to terminal sequence 2.
 *        Used for short circuit data exchange according to IEC 60909.
 *        EquivalentBranch is a result of network reduction prior to the data exchange.
 * @param zeroR21 Zero sequence series resistance from terminal sequence  2 to terminal sequence 1.
 *        Used for short circuit data exchange according to IEC 60909.
 *        Usage : EquivalentBranch is a result of network reduction prior to the data exchange.
 * @param zeroX12 Zero sequence series reactance from terminal sequence  1 to terminal sequence 2.
 *        Used for short circuit data exchange according to IEC 60909.
 *        Usage : EquivalentBranch is a result of network reduction prior to the data exchange.
 * @param zeroX21 Zero sequence series reactance from terminal sequence 2 to terminal sequence 1.
 *        Used for short circuit data exchange according to IEC 60909.
 *        Usage : EquivalentBranch is a result of network reduction prior to the data exchange.
 * @group Equivalents
 * @groupname Equivalents Package Equivalents
 * @groupdesc Equivalents The equivalents package models equivalent networks.
 */
final case class EquivalentBranch
(
    override val sup: EquivalentEquipment = null,
    negativeR12: Double = 0.0,
    negativeR21: Double = 0.0,
    negativeX12: Double = 0.0,
    negativeX21: Double = 0.0,
    positiveR12: Double = 0.0,
    positiveR21: Double = 0.0,
    positiveX12: Double = 0.0,
    positiveX21: Double = 0.0,
    r: Double = 0.0,
    r21: Double = 0.0,
    x: Double = 0.0,
    x21: Double = 0.0,
    zeroR12: Double = 0.0,
    zeroR21: Double = 0.0,
    zeroX12: Double = 0.0,
    zeroX21: Double = 0.0
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
    def EquivalentEquipment: EquivalentEquipment = sup
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
        implicit val clz: String = EquivalentBranch.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EquivalentBranch.fields (position), value)
        emitelem (0, negativeR12)
        emitelem (1, negativeR21)
        emitelem (2, negativeX12)
        emitelem (3, negativeX21)
        emitelem (4, positiveR12)
        emitelem (5, positiveR21)
        emitelem (6, positiveX12)
        emitelem (7, positiveX21)
        emitelem (8, r)
        emitelem (9, r21)
        emitelem (10, x)
        emitelem (11, x21)
        emitelem (12, zeroR12)
        emitelem (13, zeroR21)
        emitelem (14, zeroX12)
        emitelem (15, zeroX21)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EquivalentBranch rdf:ID=\"%s\">\n%s\t</cim:EquivalentBranch>".format (id, export_fields)
    }
}

object EquivalentBranch
extends
    Parseable[EquivalentBranch]
{
    override val fields: Array[String] = Array[String] (
        "negativeR12",
        "negativeR21",
        "negativeX12",
        "negativeX21",
        "positiveR12",
        "positiveR21",
        "positiveX12",
        "positiveX21",
        "r",
        "r21",
        "x",
        "x21",
        "zeroR12",
        "zeroR21",
        "zeroX12",
        "zeroX21"
    )
    val negativeR12: Fielder = parse_element (element (cls, fields(0)))
    val negativeR21: Fielder = parse_element (element (cls, fields(1)))
    val negativeX12: Fielder = parse_element (element (cls, fields(2)))
    val negativeX21: Fielder = parse_element (element (cls, fields(3)))
    val positiveR12: Fielder = parse_element (element (cls, fields(4)))
    val positiveR21: Fielder = parse_element (element (cls, fields(5)))
    val positiveX12: Fielder = parse_element (element (cls, fields(6)))
    val positiveX21: Fielder = parse_element (element (cls, fields(7)))
    val r: Fielder = parse_element (element (cls, fields(8)))
    val r21: Fielder = parse_element (element (cls, fields(9)))
    val x: Fielder = parse_element (element (cls, fields(10)))
    val x21: Fielder = parse_element (element (cls, fields(11)))
    val zeroR12: Fielder = parse_element (element (cls, fields(12)))
    val zeroR21: Fielder = parse_element (element (cls, fields(13)))
    val zeroX12: Fielder = parse_element (element (cls, fields(14)))
    val zeroX21: Fielder = parse_element (element (cls, fields(15)))

    def parse (context: Context): EquivalentBranch =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EquivalentBranch (
            EquivalentEquipment.parse (context),
            toDouble (mask (negativeR12 (), 0)),
            toDouble (mask (negativeR21 (), 1)),
            toDouble (mask (negativeX12 (), 2)),
            toDouble (mask (negativeX21 (), 3)),
            toDouble (mask (positiveR12 (), 4)),
            toDouble (mask (positiveR21 (), 5)),
            toDouble (mask (positiveX12 (), 6)),
            toDouble (mask (positiveX21 (), 7)),
            toDouble (mask (r (), 8)),
            toDouble (mask (r21 (), 9)),
            toDouble (mask (x (), 10)),
            toDouble (mask (x21 (), 11)),
            toDouble (mask (zeroR12 (), 12)),
            toDouble (mask (zeroR21 (), 13)),
            toDouble (mask (zeroX12 (), 14)),
            toDouble (mask (zeroX21 (), 15))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The class represents equivalent objects that are the result of a network reduction.
 *
 * The class is the base for equivalent objects of different types.
 *
 * @param sup [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] Reference to the superclass object.
 * @param EquivalentNetwork [[ch.ninecode.model.EquivalentNetwork EquivalentNetwork]] The equivalent where the reduced model belongs.
 * @group Equivalents
 * @groupname Equivalents Package Equivalents
 * @groupdesc Equivalents The equivalents package models equivalent networks.
 */
final case class EquivalentEquipment
(
    override val sup: ConductingEquipment = null,
    EquivalentNetwork: String = null
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
    def ConductingEquipment: ConductingEquipment = sup
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
        implicit val clz: String = EquivalentEquipment.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EquivalentEquipment.fields (position), value)
        emitattr (0, EquivalentNetwork)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EquivalentEquipment rdf:ID=\"%s\">\n%s\t</cim:EquivalentEquipment>".format (id, export_fields)
    }
}

object EquivalentEquipment
extends
    Parseable[EquivalentEquipment]
{
    override val fields: Array[String] = Array[String] (
        "EquivalentNetwork"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EquivalentNetwork", "EquivalentNetwork", "0..1", "0..*")
    )
    val EquivalentNetwork: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): EquivalentEquipment =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EquivalentEquipment (
            ConductingEquipment.parse (context),
            mask (EquivalentNetwork (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This class represents equivalent injections (generation or load).
 *
 * Voltage regulation is allowed only at the point of connection.
 *
 * @param sup [[ch.ninecode.model.EquivalentEquipment EquivalentEquipment]] Reference to the superclass object.
 * @param maxP Maximum active power of the injection.
 * @param maxQ Maximum reactive power of the injection.
 *        Used for modelling of infeed for load flow exchange. Not used for short circuit modelling.  If maxQ and minQ are not used ReactiveCapabilityCurve can be used.
 * @param minP Minimum active power of the injection.
 * @param minQ Minimum reactive power of the injection.
 *        Used for modelling of infeed for load flow exchange. Not used for short circuit modelling.  If maxQ and minQ are not used ReactiveCapabilityCurve can be used.
 * @param p Equivalent active power injection.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 *        Starting value for steady state solutions.
 * @param q Equivalent reactive power injection.
 *        Load sign convention is used, i.e. positive sign means flow out from a node.
 *        Starting value for steady state solutions.
 * @param r Positive sequence resistance.
 *        Used to represent Extended-Ward (IEC 60909).
 *        Usage : Extended-Ward is a result of network reduction prior to the data exchange.
 * @param r0 Zero sequence resistance.
 *        Used to represent Extended-Ward (IEC 60909).
 *        Usage : Extended-Ward is a result of network reduction prior to the data exchange.
 * @param r2 Negative sequence resistance.
 *        Used to represent Extended-Ward (IEC 60909).
 *        Usage : Extended-Ward is a result of network reduction prior to the data exchange.
 * @param regulationCapability Specifies whether or not the EquivalentInjection has the capability to regulate the local voltage.
 * @param regulationStatus Specifies the default regulation status of the EquivalentInjection.
 *        True is regulating.  False is not regulating.
 * @param regulationTarget The target voltage for voltage regulation.
 * @param x Positive sequence reactance.
 *        Used to represent Extended-Ward (IEC 60909).
 *        Usage : Extended-Ward is a result of network reduction prior to the data exchange.
 * @param x0 Zero sequence reactance.
 *        Used to represent Extended-Ward (IEC 60909).
 *        Usage : Extended-Ward is a result of network reduction prior to the data exchange.
 * @param x2 Negative sequence reactance.
 *        Used to represent Extended-Ward (IEC 60909).
 *        Usage : Extended-Ward is a result of network reduction prior to the data exchange.
 * @param ReactiveCapabilityCurve [[ch.ninecode.model.ReactiveCapabilityCurve ReactiveCapabilityCurve]] The reactive capability curve used by this equivalent injection.
 * @group Equivalents
 * @groupname Equivalents Package Equivalents
 * @groupdesc Equivalents The equivalents package models equivalent networks.
 */
final case class EquivalentInjection
(
    override val sup: EquivalentEquipment = null,
    maxP: Double = 0.0,
    maxQ: Double = 0.0,
    minP: Double = 0.0,
    minQ: Double = 0.0,
    p: Double = 0.0,
    q: Double = 0.0,
    r: Double = 0.0,
    r0: Double = 0.0,
    r2: Double = 0.0,
    regulationCapability: Boolean = false,
    regulationStatus: Boolean = false,
    regulationTarget: Double = 0.0,
    x: Double = 0.0,
    x0: Double = 0.0,
    x2: Double = 0.0,
    ReactiveCapabilityCurve: String = null
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
    def EquivalentEquipment: EquivalentEquipment = sup
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
        implicit val clz: String = EquivalentInjection.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EquivalentInjection.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EquivalentInjection.fields (position), value)
        emitelem (0, maxP)
        emitelem (1, maxQ)
        emitelem (2, minP)
        emitelem (3, minQ)
        emitelem (4, p)
        emitelem (5, q)
        emitelem (6, r)
        emitelem (7, r0)
        emitelem (8, r2)
        emitelem (9, regulationCapability)
        emitelem (10, regulationStatus)
        emitelem (11, regulationTarget)
        emitelem (12, x)
        emitelem (13, x0)
        emitelem (14, x2)
        emitattr (15, ReactiveCapabilityCurve)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EquivalentInjection rdf:ID=\"%s\">\n%s\t</cim:EquivalentInjection>".format (id, export_fields)
    }
}

object EquivalentInjection
extends
    Parseable[EquivalentInjection]
{
    override val fields: Array[String] = Array[String] (
        "maxP",
        "maxQ",
        "minP",
        "minQ",
        "p",
        "q",
        "r",
        "r0",
        "r2",
        "regulationCapability",
        "regulationStatus",
        "regulationTarget",
        "x",
        "x0",
        "x2",
        "ReactiveCapabilityCurve"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ReactiveCapabilityCurve", "ReactiveCapabilityCurve", "0..1", "0..*")
    )
    val maxP: Fielder = parse_element (element (cls, fields(0)))
    val maxQ: Fielder = parse_element (element (cls, fields(1)))
    val minP: Fielder = parse_element (element (cls, fields(2)))
    val minQ: Fielder = parse_element (element (cls, fields(3)))
    val p: Fielder = parse_element (element (cls, fields(4)))
    val q: Fielder = parse_element (element (cls, fields(5)))
    val r: Fielder = parse_element (element (cls, fields(6)))
    val r0: Fielder = parse_element (element (cls, fields(7)))
    val r2: Fielder = parse_element (element (cls, fields(8)))
    val regulationCapability: Fielder = parse_element (element (cls, fields(9)))
    val regulationStatus: Fielder = parse_element (element (cls, fields(10)))
    val regulationTarget: Fielder = parse_element (element (cls, fields(11)))
    val x: Fielder = parse_element (element (cls, fields(12)))
    val x0: Fielder = parse_element (element (cls, fields(13)))
    val x2: Fielder = parse_element (element (cls, fields(14)))
    val ReactiveCapabilityCurve: Fielder = parse_attribute (attribute (cls, fields(15)))

    def parse (context: Context): EquivalentInjection =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EquivalentInjection (
            EquivalentEquipment.parse (context),
            toDouble (mask (maxP (), 0)),
            toDouble (mask (maxQ (), 1)),
            toDouble (mask (minP (), 2)),
            toDouble (mask (minQ (), 3)),
            toDouble (mask (p (), 4)),
            toDouble (mask (q (), 5)),
            toDouble (mask (r (), 6)),
            toDouble (mask (r0 (), 7)),
            toDouble (mask (r2 (), 8)),
            toBoolean (mask (regulationCapability (), 9)),
            toBoolean (mask (regulationStatus (), 10)),
            toDouble (mask (regulationTarget (), 11)),
            toDouble (mask (x (), 12)),
            toDouble (mask (x0 (), 13)),
            toDouble (mask (x2 (), 14)),
            mask (ReactiveCapabilityCurve (), 15)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A class that represents an external meshed network that has been reduced to an electrically equivalent model.
 *
 * The ConnectivityNodes contained in the equivalent are intended to reflect internal nodes of the equivalent. The boundary Connectivity nodes where the equivalent connects outside itself are NOT contained by the equivalent.
 *
 * @param sup [[ch.ninecode.model.ConnectivityNodeContainer ConnectivityNodeContainer]] Reference to the superclass object.
 * @param EquivalentEquipments [[ch.ninecode.model.EquivalentEquipment EquivalentEquipment]] The associated reduced equivalents.
 * @group Equivalents
 * @groupname Equivalents Package Equivalents
 * @groupdesc Equivalents The equivalents package models equivalent networks.
 */
final case class EquivalentNetwork
(
    override val sup: ConnectivityNodeContainer = null,
    EquivalentEquipments: List[String] = null
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
    def ConnectivityNodeContainer: ConnectivityNodeContainer = sup
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
        implicit val clz: String = EquivalentNetwork.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (EquivalentNetwork.fields (position), x))
        emitattrs (0, EquivalentEquipments)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EquivalentNetwork rdf:ID=\"%s\">\n%s\t</cim:EquivalentNetwork>".format (id, export_fields)
    }
}

object EquivalentNetwork
extends
    Parseable[EquivalentNetwork]
{
    override val fields: Array[String] = Array[String] (
        "EquivalentEquipments"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EquivalentEquipments", "EquivalentEquipment", "0..*", "0..1")
    )
    val EquivalentEquipments: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): EquivalentNetwork =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EquivalentNetwork (
            ConnectivityNodeContainer.parse (context),
            masks (EquivalentEquipments (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The class represents equivalent shunts.
 *
 * @param sup [[ch.ninecode.model.EquivalentEquipment EquivalentEquipment]] Reference to the superclass object.
 * @param b Positive sequence shunt susceptance.
 * @param g Positive sequence shunt conductance.
 * @group Equivalents
 * @groupname Equivalents Package Equivalents
 * @groupdesc Equivalents The equivalents package models equivalent networks.
 */
final case class EquivalentShunt
(
    override val sup: EquivalentEquipment = null,
    b: Double = 0.0,
    g: Double = 0.0
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
    def EquivalentEquipment: EquivalentEquipment = sup
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
        implicit val clz: String = EquivalentShunt.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EquivalentShunt.fields (position), value)
        emitelem (0, b)
        emitelem (1, g)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EquivalentShunt rdf:ID=\"%s\">\n%s\t</cim:EquivalentShunt>".format (id, export_fields)
    }
}

object EquivalentShunt
extends
    Parseable[EquivalentShunt]
{
    override val fields: Array[String] = Array[String] (
        "b",
        "g"
    )
    val b: Fielder = parse_element (element (cls, fields(0)))
    val g: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): EquivalentShunt =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EquivalentShunt (
            EquivalentEquipment.parse (context),
            toDouble (mask (b (), 0)),
            toDouble (mask (g (), 1))
        )
        ret.bitfields = bitfields
        ret
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
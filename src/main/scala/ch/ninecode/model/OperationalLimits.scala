package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Limit on active power flow.
 *
 * @param sup [[ch.ninecode.model.OperationalLimit OperationalLimit]] Reference to the superclass object.
 * @param value Value of active power limit.
 * @group OperationalLimits
 * @groupname OperationalLimits Package OperationalLimits
 * @groupdesc OperationalLimits This package models a specification of limits associated with equipment and other operational entities.
 */
case class ActivePowerLimit
(
    override val sup: OperationalLimit,
    value: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def OperationalLimit: OperationalLimit = sup.asInstanceOf[OperationalLimit]
    override def copy (): Row = { clone ().asInstanceOf[ActivePowerLimit] }
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
        implicit val clz: String = ActivePowerLimit.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ActivePowerLimit.fields (position), value)
        emitelem (0, value)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ActivePowerLimit rdf:ID=\"%s\">\n%s\t</cim:ActivePowerLimit>".format (id, export_fields)
    }
}

object ActivePowerLimit
extends
    Parseable[ActivePowerLimit]
{
    val fields: Array[String] = Array[String] (
        "value"
    )
    val value: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): ActivePowerLimit =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ActivePowerLimit (
            OperationalLimit.parse (context),
            toDouble (mask (value (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Apparent power limit.
 *
 * @param sup [[ch.ninecode.model.OperationalLimit OperationalLimit]] Reference to the superclass object.
 * @param value The apparent power limit.
 * @group OperationalLimits
 * @groupname OperationalLimits Package OperationalLimits
 * @groupdesc OperationalLimits This package models a specification of limits associated with equipment and other operational entities.
 */
case class ApparentPowerLimit
(
    override val sup: OperationalLimit,
    value: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def OperationalLimit: OperationalLimit = sup.asInstanceOf[OperationalLimit]
    override def copy (): Row = { clone ().asInstanceOf[ApparentPowerLimit] }
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
        implicit val clz: String = ApparentPowerLimit.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ApparentPowerLimit.fields (position), value)
        emitelem (0, value)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ApparentPowerLimit rdf:ID=\"%s\">\n%s\t</cim:ApparentPowerLimit>".format (id, export_fields)
    }
}

object ApparentPowerLimit
extends
    Parseable[ApparentPowerLimit]
{
    val fields: Array[String] = Array[String] (
        "value"
    )
    val value: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): ApparentPowerLimit =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ApparentPowerLimit (
            OperationalLimit.parse (context),
            toDouble (mask (value (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * A group of branch terminals whose directed flow summation is to be monitored.
 *
 * A branch group need not form a cutset of the network.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param maximumActivePower The maximum active power flow.
 * @param maximumReactivePower The maximum reactive power flow.
 * @param minimumActivePower The minimum active power flow.
 * @param minimumReactivePower The minimum reactive power flow.
 * @param monitorActivePower Monitor the active power flow.
 * @param monitorReactivePower Monitor the reactive power flow.
 * @group OperationalLimits
 * @groupname OperationalLimits Package OperationalLimits
 * @groupdesc OperationalLimits This package models a specification of limits associated with equipment and other operational entities.
 */
case class BranchGroup
(
    override val sup: IdentifiedObject,
    maximumActivePower: Double,
    maximumReactivePower: Double,
    minimumActivePower: Double,
    minimumReactivePower: Double,
    monitorActivePower: Boolean,
    monitorReactivePower: Boolean
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, false, false) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[BranchGroup] }
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
        implicit val clz: String = BranchGroup.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BranchGroup.fields (position), value)
        emitelem (0, maximumActivePower)
        emitelem (1, maximumReactivePower)
        emitelem (2, minimumActivePower)
        emitelem (3, minimumReactivePower)
        emitelem (4, monitorActivePower)
        emitelem (5, monitorReactivePower)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BranchGroup rdf:ID=\"%s\">\n%s\t</cim:BranchGroup>".format (id, export_fields)
    }
}

object BranchGroup
extends
    Parseable[BranchGroup]
{
    val fields: Array[String] = Array[String] (
        "maximumActivePower",
        "maximumReactivePower",
        "minimumActivePower",
        "minimumReactivePower",
        "monitorActivePower",
        "monitorReactivePower"
    )
    val maximumActivePower: Fielder = parse_element (element (cls, fields(0)))
    val maximumReactivePower: Fielder = parse_element (element (cls, fields(1)))
    val minimumActivePower: Fielder = parse_element (element (cls, fields(2)))
    val minimumReactivePower: Fielder = parse_element (element (cls, fields(3)))
    val monitorActivePower: Fielder = parse_element (element (cls, fields(4)))
    val monitorReactivePower: Fielder = parse_element (element (cls, fields(5)))

    def parse (context: Context): BranchGroup =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BranchGroup (
            IdentifiedObject.parse (context),
            toDouble (mask (maximumActivePower (), 0)),
            toDouble (mask (maximumReactivePower (), 1)),
            toDouble (mask (minimumActivePower (), 2)),
            toDouble (mask (minimumReactivePower (), 3)),
            toBoolean (mask (monitorActivePower (), 4)),
            toBoolean (mask (monitorReactivePower (), 5))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * A specific directed terminal flow for a branch group.
 *
 * @param sup Reference to the superclass object.
 * @param positiveFlowIn The flow into the terminal is summed if set true.
 *        The flow out of the terminanl is summed if set false.
 * @param BranchGroup [[ch.ninecode.model.BranchGroup BranchGroup]] The branch group to which the directed branch group terminals belong.
 * @param Terminal [[ch.ninecode.model.Terminal Terminal]] The terminal to be summed.
 * @group OperationalLimits
 * @groupname OperationalLimits Package OperationalLimits
 * @groupdesc OperationalLimits This package models a specification of limits associated with equipment and other operational entities.
 */
case class BranchGroupTerminal
(
    override val sup: BasicElement,
    positiveFlowIn: Boolean,
    BranchGroup: String,
    Terminal: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[BranchGroupTerminal] }
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
        implicit val clz: String = BranchGroupTerminal.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BranchGroupTerminal.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (BranchGroupTerminal.fields (position), value)
        emitelem (0, positiveFlowIn)
        emitattr (1, BranchGroup)
        emitattr (2, Terminal)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BranchGroupTerminal rdf:ID=\"%s\">\n%s\t</cim:BranchGroupTerminal>".format (id, export_fields)
    }
}

object BranchGroupTerminal
extends
    Parseable[BranchGroupTerminal]
{
    val fields: Array[String] = Array[String] (
        "positiveFlowIn",
        "BranchGroup",
        "Terminal"
    )
    val positiveFlowIn: Fielder = parse_element (element (cls, fields(0)))
    val BranchGroup: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Terminal: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): BranchGroupTerminal =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = BranchGroupTerminal (
            BasicElement.parse (context),
            toBoolean (mask (positiveFlowIn (), 0)),
            mask (BranchGroup (), 1),
            mask (Terminal (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("BranchGroup", "BranchGroup", false),
        Relationship ("Terminal", "Terminal", false)
    )
}

/**
 * Operational limit on current.
 *
 * @param sup [[ch.ninecode.model.OperationalLimit OperationalLimit]] Reference to the superclass object.
 * @param value Limit on current flow.
 * @group OperationalLimits
 * @groupname OperationalLimits Package OperationalLimits
 * @groupdesc OperationalLimits This package models a specification of limits associated with equipment and other operational entities.
 */
case class CurrentLimit
(
    override val sup: OperationalLimit,
    value: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def OperationalLimit: OperationalLimit = sup.asInstanceOf[OperationalLimit]
    override def copy (): Row = { clone ().asInstanceOf[CurrentLimit] }
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
        implicit val clz: String = CurrentLimit.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CurrentLimit.fields (position), value)
        emitelem (0, value)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CurrentLimit rdf:ID=\"%s\">\n%s\t</cim:CurrentLimit>".format (id, export_fields)
    }
}

object CurrentLimit
extends
    Parseable[CurrentLimit]
{
    val fields: Array[String] = Array[String] (
        "value"
    )
    val value: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): CurrentLimit =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CurrentLimit (
            OperationalLimit.parse (context),
            toDouble (mask (value (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * A value associated with a specific kind of limit.
 *
 * The sub class value attribute shall be positive.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param LimitDependencyModel [[ch.ninecode.model.LimitDependency LimitDependency]] The limit dependency models which are used to calculate this limit.
 *        If no limit dependencies are specified then the native limit value is used.
 * @param OperationalLimitSet [[ch.ninecode.model.OperationalLimitSet OperationalLimitSet]] The limit set to which the limit values belong.
 * @param OperationalLimitType [[ch.ninecode.model.OperationalLimitType OperationalLimitType]] The limit type associated with this limit.
 * @group OperationalLimits
 * @groupname OperationalLimits Package OperationalLimits
 * @groupdesc OperationalLimits This package models a specification of limits associated with equipment and other operational entities.
 */
case class OperationalLimit
(
    override val sup: IdentifiedObject,
    LimitDependencyModel: List[String],
    OperationalLimitSet: String,
    OperationalLimitType: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List(), null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[OperationalLimit] }
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
        implicit val clz: String = OperationalLimit.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OperationalLimit.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (OperationalLimit.fields (position), x))
        emitattrs (0, LimitDependencyModel)
        emitattr (1, OperationalLimitSet)
        emitattr (2, OperationalLimitType)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OperationalLimit rdf:ID=\"%s\">\n%s\t</cim:OperationalLimit>".format (id, export_fields)
    }
}

object OperationalLimit
extends
    Parseable[OperationalLimit]
{
    val fields: Array[String] = Array[String] (
        "LimitDependencyModel",
        "OperationalLimitSet",
        "OperationalLimitType"
    )
    val LimitDependencyModel: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val OperationalLimitSet: Fielder = parse_attribute (attribute (cls, fields(1)))
    val OperationalLimitType: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): OperationalLimit =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = OperationalLimit (
            IdentifiedObject.parse (context),
            masks (LimitDependencyModel (), 0),
            mask (OperationalLimitSet (), 1),
            mask (OperationalLimitType (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("LimitDependencyModel", "LimitDependency", true),
        Relationship ("OperationalLimitSet", "OperationalLimitSet", false),
        Relationship ("OperationalLimitType", "OperationalLimitType", false)
    )
}

/**
 * A set of limits associated with equipment.
 *
 * Sets of limits might apply to a specific temperature, or season for example. A set of limits may contain different severities of limit levels that would apply to the same equipment. The set may contain limits of different types such as apparent power and current limits or high and low voltage limits  that are logically applied together as a set.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Equipment [[ch.ninecode.model.Equipment Equipment]] The equipment to which the limit set applies.
 * @param Terminal [[ch.ninecode.model.ACDCTerminal ACDCTerminal]] <em>undocumented</em>
 * @group OperationalLimits
 * @groupname OperationalLimits Package OperationalLimits
 * @groupdesc OperationalLimits This package models a specification of limits associated with equipment and other operational entities.
 */
case class OperationalLimitSet
(
    override val sup: IdentifiedObject,
    Equipment: String,
    Terminal: String
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
    override def copy (): Row = { clone ().asInstanceOf[OperationalLimitSet] }
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
        implicit val clz: String = OperationalLimitSet.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OperationalLimitSet.fields (position), value)
        emitattr (0, Equipment)
        emitattr (1, Terminal)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OperationalLimitSet rdf:ID=\"%s\">\n%s\t</cim:OperationalLimitSet>".format (id, export_fields)
    }
}

object OperationalLimitSet
extends
    Parseable[OperationalLimitSet]
{
    val fields: Array[String] = Array[String] (
        "Equipment",
        "Terminal"
    )
    val Equipment: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Terminal: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): OperationalLimitSet =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = OperationalLimitSet (
            IdentifiedObject.parse (context),
            mask (Equipment (), 0),
            mask (Terminal (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Equipment", "Equipment", false),
        Relationship ("Terminal", "ACDCTerminal", false)
    )
}

/**
 * The operational meaning of a category of limits.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param acceptableDuration The nominal acceptable duration of the limit.
 *        Limits are commonly expressed in terms of the a time limit for which the limit is normally acceptable.   The actual acceptable duration of a specific limit may depend on other local factors such as temperature or wind speed.
 * @param direction The direction of the limit.
 * @param TargetOperationalLimitmTypeScaling [[ch.ninecode.model.OperatonalLimitTypeScaling OperatonalLimitTypeScaling]] <em>undocumented</em>
 * @group OperationalLimits
 * @groupname OperationalLimits Package OperationalLimits
 * @groupdesc OperationalLimits This package models a specification of limits associated with equipment and other operational entities.
 */
case class OperationalLimitType
(
    override val sup: IdentifiedObject,
    acceptableDuration: Double,
    direction: String,
    TargetOperationalLimitmTypeScaling: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[OperationalLimitType] }
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
        implicit val clz: String = OperationalLimitType.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OperationalLimitType.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OperationalLimitType.fields (position), value)
        emitelem (0, acceptableDuration)
        emitattr (1, direction)
        emitattr (2, TargetOperationalLimitmTypeScaling)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OperationalLimitType rdf:ID=\"%s\">\n%s\t</cim:OperationalLimitType>".format (id, export_fields)
    }
}

object OperationalLimitType
extends
    Parseable[OperationalLimitType]
{
    val fields: Array[String] = Array[String] (
        "acceptableDuration",
        "direction",
        "TargetOperationalLimitmTypeScaling"
    )
    val acceptableDuration: Fielder = parse_element (element (cls, fields(0)))
    val direction: Fielder = parse_attribute (attribute (cls, fields(1)))
    val TargetOperationalLimitmTypeScaling: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): OperationalLimitType =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = OperationalLimitType (
            IdentifiedObject.parse (context),
            toDouble (mask (acceptableDuration (), 0)),
            mask (direction (), 1),
            mask (TargetOperationalLimitmTypeScaling (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("TargetOperationalLimitmTypeScaling", "OperatonalLimitTypeScaling", false)
    )
}

/**
 * Operational limit applied to voltage.
 *
 * @param sup [[ch.ninecode.model.OperationalLimit OperationalLimit]] Reference to the superclass object.
 * @param value Limit on voltage.
 *        High or low limit nature of the limit depends upon the properties of the operational limit type.
 * @group OperationalLimits
 * @groupname OperationalLimits Package OperationalLimits
 * @groupdesc OperationalLimits This package models a specification of limits associated with equipment and other operational entities.
 */
case class VoltageLimit
(
    override val sup: OperationalLimit,
    value: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def OperationalLimit: OperationalLimit = sup.asInstanceOf[OperationalLimit]
    override def copy (): Row = { clone ().asInstanceOf[VoltageLimit] }
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
        implicit val clz: String = VoltageLimit.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (VoltageLimit.fields (position), value)
        emitelem (0, value)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:VoltageLimit rdf:ID=\"%s\">\n%s\t</cim:VoltageLimit>".format (id, export_fields)
    }
}

object VoltageLimit
extends
    Parseable[VoltageLimit]
{
    val fields: Array[String] = Array[String] (
        "value"
    )
    val value: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): VoltageLimit =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = VoltageLimit (
            OperationalLimit.parse (context),
            toDouble (mask (value (), 0))
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

private[ninecode] object _OperationalLimits
{
    def register: List[ClassInfo] =
    {
        List (
            ActivePowerLimit.register,
            ApparentPowerLimit.register,
            BranchGroup.register,
            BranchGroupTerminal.register,
            CurrentLimit.register,
            OperationalLimit.register,
            OperationalLimitSet.register,
            OperationalLimitType.register,
            VoltageLimit.register
        )
    }
}
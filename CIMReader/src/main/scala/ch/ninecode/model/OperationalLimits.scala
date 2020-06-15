package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship
import ch.ninecode.cim.CIMSerializer

/**
 * Limit on active power flow.
 *
 * @param OperationalLimit [[ch.ninecode.model.OperationalLimit OperationalLimit]] Reference to the superclass object.
 * @param normalValue The normal value of active power limit.
 * @param value Value of active power limit.
 * @group OperationalLimits
 * @groupname OperationalLimits Package OperationalLimits
 * @groupdesc OperationalLimits This package models a specification of limits associated with equipment and other operational entities.
 */
final case class ActivePowerLimit
(
    OperationalLimit: OperationalLimit = null,
    normalValue: Double = 0.0,
    value: Double = 0.0
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
    override def sup: OperationalLimit = OperationalLimit

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
        implicit val clz: String = ActivePowerLimit.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ActivePowerLimit.fields (position), value)
        emitelem (0, normalValue)
        emitelem (1, value)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ActivePowerLimit rdf:ID=\"%s\">\n%s\t</cim:ActivePowerLimit>".format (id, export_fields)
    }
}

object ActivePowerLimit
extends
    CIMParseable[ActivePowerLimit]
{
    override val fields: Array[String] = Array[String] (
        "normalValue",
        "value"
    )
    val normalValue: Fielder = parse_element (element (cls, fields(0)))
    val value: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: CIMContext): ActivePowerLimit =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ActivePowerLimit (
            OperationalLimit.parse (context),
            toDouble (mask (normalValue (), 0)),
            toDouble (mask (value (), 1))
        )
        ret.bitfields = bitfields
        ret
    }
}

object ActivePowerLimitSerializer extends CIMSerializer[ActivePowerLimit]
{
    def write (kryo: Kryo, output: Output, obj: ActivePowerLimit): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.normalValue),
            () => output.writeDouble (obj.value)
        )
        OperationalLimitSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ActivePowerLimit]): ActivePowerLimit =
    {
        val parent = OperationalLimitSerializer.read (kryo, input, classOf[OperationalLimit])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ActivePowerLimit (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Apparent power limit.
 *
 * @param OperationalLimit [[ch.ninecode.model.OperationalLimit OperationalLimit]] Reference to the superclass object.
 * @param normalValue The normal apparent power limit.
 * @param value The apparent power limit.
 * @group OperationalLimits
 * @groupname OperationalLimits Package OperationalLimits
 * @groupdesc OperationalLimits This package models a specification of limits associated with equipment and other operational entities.
 */
final case class ApparentPowerLimit
(
    OperationalLimit: OperationalLimit = null,
    normalValue: Double = 0.0,
    value: Double = 0.0
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
    override def sup: OperationalLimit = OperationalLimit

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
        implicit val clz: String = ApparentPowerLimit.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ApparentPowerLimit.fields (position), value)
        emitelem (0, normalValue)
        emitelem (1, value)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ApparentPowerLimit rdf:ID=\"%s\">\n%s\t</cim:ApparentPowerLimit>".format (id, export_fields)
    }
}

object ApparentPowerLimit
extends
    CIMParseable[ApparentPowerLimit]
{
    override val fields: Array[String] = Array[String] (
        "normalValue",
        "value"
    )
    val normalValue: Fielder = parse_element (element (cls, fields(0)))
    val value: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: CIMContext): ApparentPowerLimit =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ApparentPowerLimit (
            OperationalLimit.parse (context),
            toDouble (mask (normalValue (), 0)),
            toDouble (mask (value (), 1))
        )
        ret.bitfields = bitfields
        ret
    }
}

object ApparentPowerLimitSerializer extends CIMSerializer[ApparentPowerLimit]
{
    def write (kryo: Kryo, output: Output, obj: ApparentPowerLimit): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.normalValue),
            () => output.writeDouble (obj.value)
        )
        OperationalLimitSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ApparentPowerLimit]): ApparentPowerLimit =
    {
        val parent = OperationalLimitSerializer.read (kryo, input, classOf[OperationalLimit])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ApparentPowerLimit (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A group of branch terminals whose directed flow summation is to be monitored.
 *
 * A branch group need not form a cutset of the network.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param maximumActivePower The maximum active power flow.
 * @param maximumReactivePower The maximum reactive power flow.
 * @param minimumActivePower The minimum active power flow.
 * @param minimumReactivePower The minimum reactive power flow.
 * @param monitorActivePower Monitor the active power flow.
 * @param monitorReactivePower Monitor the reactive power flow.
 * @param BranchGroupTerminal [[ch.ninecode.model.BranchGroupTerminal BranchGroupTerminal]] The directed branch group terminals to be summed.
 * @param PinBranchGroup [[ch.ninecode.model.PinBranchGroup PinBranchGroup]] <em>undocumented</em>
 * @group OperationalLimits
 * @groupname OperationalLimits Package OperationalLimits
 * @groupdesc OperationalLimits This package models a specification of limits associated with equipment and other operational entities.
 */
final case class BranchGroup
(
    IdentifiedObject: IdentifiedObject = null,
    maximumActivePower: Double = 0.0,
    maximumReactivePower: Double = 0.0,
    minimumActivePower: Double = 0.0,
    minimumReactivePower: Double = 0.0,
    monitorActivePower: Boolean = false,
    monitorReactivePower: Boolean = false,
    BranchGroupTerminal: List[String] = null,
    PinBranchGroup: List[String] = null
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
        implicit val clz: String = BranchGroup.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (BranchGroup.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (BranchGroup.fields (position), x))
        emitelem (0, maximumActivePower)
        emitelem (1, maximumReactivePower)
        emitelem (2, minimumActivePower)
        emitelem (3, minimumReactivePower)
        emitelem (4, monitorActivePower)
        emitelem (5, monitorReactivePower)
        emitattrs (6, BranchGroupTerminal)
        emitattrs (7, PinBranchGroup)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BranchGroup rdf:ID=\"%s\">\n%s\t</cim:BranchGroup>".format (id, export_fields)
    }
}

object BranchGroup
extends
    CIMParseable[BranchGroup]
{
    override val fields: Array[String] = Array[String] (
        "maximumActivePower",
        "maximumReactivePower",
        "minimumActivePower",
        "minimumReactivePower",
        "monitorActivePower",
        "monitorReactivePower",
        "BranchGroupTerminal",
        "PinBranchGroup"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("BranchGroupTerminal", "BranchGroupTerminal", "0..*", "1"),
        CIMRelationship ("PinBranchGroup", "PinBranchGroup", "0..*", "1")
    )
    val maximumActivePower: Fielder = parse_element (element (cls, fields(0)))
    val maximumReactivePower: Fielder = parse_element (element (cls, fields(1)))
    val minimumActivePower: Fielder = parse_element (element (cls, fields(2)))
    val minimumReactivePower: Fielder = parse_element (element (cls, fields(3)))
    val monitorActivePower: Fielder = parse_element (element (cls, fields(4)))
    val monitorReactivePower: Fielder = parse_element (element (cls, fields(5)))
    val BranchGroupTerminal: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val PinBranchGroup: FielderMultiple = parse_attributes (attribute (cls, fields(7)))

    def parse (context: CIMContext): BranchGroup =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = BranchGroup (
            IdentifiedObject.parse (context),
            toDouble (mask (maximumActivePower (), 0)),
            toDouble (mask (maximumReactivePower (), 1)),
            toDouble (mask (minimumActivePower (), 2)),
            toDouble (mask (minimumReactivePower (), 3)),
            toBoolean (mask (monitorActivePower (), 4)),
            toBoolean (mask (monitorReactivePower (), 5)),
            masks (BranchGroupTerminal (), 6),
            masks (PinBranchGroup (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

object BranchGroupSerializer extends CIMSerializer[BranchGroup]
{
    def write (kryo: Kryo, output: Output, obj: BranchGroup): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.maximumActivePower),
            () => output.writeDouble (obj.maximumReactivePower),
            () => output.writeDouble (obj.minimumActivePower),
            () => output.writeDouble (obj.minimumReactivePower),
            () => output.writeBoolean (obj.monitorActivePower),
            () => output.writeBoolean (obj.monitorReactivePower),
            () => writeList (obj.BranchGroupTerminal, output),
            () => writeList (obj.PinBranchGroup, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[BranchGroup]): BranchGroup =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = BranchGroup (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readBoolean else false,
            if (isSet (5)) input.readBoolean else false,
            if (isSet (6)) readList (input) else null,
            if (isSet (7)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A specific directed terminal flow for a branch group.
 *
 * @param Element Reference to the superclass object.
 * @param positiveFlowIn The flow into the terminal is summed if set true.
 *        The flow out of the terminal is summed if set false.
 * @param BranchGroup [[ch.ninecode.model.BranchGroup BranchGroup]] The branch group to which the directed branch group terminals belong.
 * @param Terminal [[ch.ninecode.model.Terminal Terminal]] The terminal to be summed.
 * @group OperationalLimits
 * @groupname OperationalLimits Package OperationalLimits
 * @groupdesc OperationalLimits This package models a specification of limits associated with equipment and other operational entities.
 */
final case class BranchGroupTerminal
(
    Element: BasicElement = null,
    positiveFlowIn: Boolean = false,
    BranchGroup: String = null,
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
    CIMParseable[BranchGroupTerminal]
{
    override val fields: Array[String] = Array[String] (
        "positiveFlowIn",
        "BranchGroup",
        "Terminal"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("BranchGroup", "BranchGroup", "1", "0..*"),
        CIMRelationship ("Terminal", "Terminal", "1", "0..*")
    )
    val positiveFlowIn: Fielder = parse_element (element (cls, fields(0)))
    val BranchGroup: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Terminal: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): BranchGroupTerminal =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = BranchGroupTerminal (
            BasicElement.parse (context),
            toBoolean (mask (positiveFlowIn (), 0)),
            mask (BranchGroup (), 1),
            mask (Terminal (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

object BranchGroupTerminalSerializer extends CIMSerializer[BranchGroupTerminal]
{
    def write (kryo: Kryo, output: Output, obj: BranchGroupTerminal): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeBoolean (obj.positiveFlowIn),
            () => output.writeString (obj.BranchGroup),
            () => output.writeString (obj.Terminal)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[BranchGroupTerminal]): BranchGroupTerminal =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = BranchGroupTerminal (
            parent,
            if (isSet (0)) input.readBoolean else false,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Operational limit on current.
 *
 * @param OperationalLimit [[ch.ninecode.model.OperationalLimit OperationalLimit]] Reference to the superclass object.
 * @param normalValue The normal value for limit on current flow.
 * @param value Limit on current flow.
 * @group OperationalLimits
 * @groupname OperationalLimits Package OperationalLimits
 * @groupdesc OperationalLimits This package models a specification of limits associated with equipment and other operational entities.
 */
final case class CurrentLimit
(
    OperationalLimit: OperationalLimit = null,
    normalValue: Double = 0.0,
    value: Double = 0.0
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
    override def sup: OperationalLimit = OperationalLimit

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
        implicit val clz: String = CurrentLimit.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CurrentLimit.fields (position), value)
        emitelem (0, normalValue)
        emitelem (1, value)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CurrentLimit rdf:ID=\"%s\">\n%s\t</cim:CurrentLimit>".format (id, export_fields)
    }
}

object CurrentLimit
extends
    CIMParseable[CurrentLimit]
{
    override val fields: Array[String] = Array[String] (
        "normalValue",
        "value"
    )
    val normalValue: Fielder = parse_element (element (cls, fields(0)))
    val value: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: CIMContext): CurrentLimit =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CurrentLimit (
            OperationalLimit.parse (context),
            toDouble (mask (normalValue (), 0)),
            toDouble (mask (value (), 1))
        )
        ret.bitfields = bitfields
        ret
    }
}

object CurrentLimitSerializer extends CIMSerializer[CurrentLimit]
{
    def write (kryo: Kryo, output: Output, obj: CurrentLimit): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.normalValue),
            () => output.writeDouble (obj.value)
        )
        OperationalLimitSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CurrentLimit]): CurrentLimit =
    {
        val parent = OperationalLimitSerializer.read (kryo, input, classOf[OperationalLimit])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CurrentLimit (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A value associated with a specific kind of limit.
 *
 * The sub class value attribute shall be positive.
 * The sub class value attribute is inversely proportional to OperationalLimitType.acceptableDuration (acceptableDuration for short). A pair of value_x and acceptableDuration_x are related to each other as follows:
 * if value_1 &gt; value_2 &gt; value_3 &gt;... then
 * acceptableDuration_1 &lt; acceptableDuration_2 &lt; acceptableDuration_3 &lt; ...
 * A value_x with direction="high" shall be greater than a value_y with direction="low".
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param LimitDependencyModel [[ch.ninecode.model.LimitDependency LimitDependency]] The limit dependency models which are used to calculate this limit.
 *        If no limit dependencies are specified then the native limit value is used.
 * @param LimitScalingLimit [[ch.ninecode.model.LimitScalingLimit LimitScalingLimit]] <em>undocumented</em>
 * @param OperationalLimitSet [[ch.ninecode.model.OperationalLimitSet OperationalLimitSet]] The limit set to which the limit values belong.
 * @param OperationalLimitType [[ch.ninecode.model.OperationalLimitType OperationalLimitType]] The limit type associated with this limit.
 * @group OperationalLimits
 * @groupname OperationalLimits Package OperationalLimits
 * @groupdesc OperationalLimits This package models a specification of limits associated with equipment and other operational entities.
 */
final case class OperationalLimit
(
    IdentifiedObject: IdentifiedObject = null,
    LimitDependencyModel: List[String] = null,
    LimitScalingLimit: List[String] = null,
    OperationalLimitSet: String = null,
    OperationalLimitType: String = null
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
        implicit val clz: String = OperationalLimit.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OperationalLimit.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (OperationalLimit.fields (position), x))
        emitattrs (0, LimitDependencyModel)
        emitattrs (1, LimitScalingLimit)
        emitattr (2, OperationalLimitSet)
        emitattr (3, OperationalLimitType)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OperationalLimit rdf:ID=\"%s\">\n%s\t</cim:OperationalLimit>".format (id, export_fields)
    }
}

object OperationalLimit
extends
    CIMParseable[OperationalLimit]
{
    override val fields: Array[String] = Array[String] (
        "LimitDependencyModel",
        "LimitScalingLimit",
        "OperationalLimitSet",
        "OperationalLimitType"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("LimitDependencyModel", "LimitDependency", "0..*", "0..*"),
        CIMRelationship ("LimitScalingLimit", "LimitScalingLimit", "0..*", "1"),
        CIMRelationship ("OperationalLimitSet", "OperationalLimitSet", "1", "0..*"),
        CIMRelationship ("OperationalLimitType", "OperationalLimitType", "0..1", "0..*")
    )
    val LimitDependencyModel: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val LimitScalingLimit: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val OperationalLimitSet: Fielder = parse_attribute (attribute (cls, fields(2)))
    val OperationalLimitType: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): OperationalLimit =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OperationalLimit (
            IdentifiedObject.parse (context),
            masks (LimitDependencyModel (), 0),
            masks (LimitScalingLimit (), 1),
            mask (OperationalLimitSet (), 2),
            mask (OperationalLimitType (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

object OperationalLimitSerializer extends CIMSerializer[OperationalLimit]
{
    def write (kryo: Kryo, output: Output, obj: OperationalLimit): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.LimitDependencyModel, output),
            () => writeList (obj.LimitScalingLimit, output),
            () => output.writeString (obj.OperationalLimitSet),
            () => output.writeString (obj.OperationalLimitType)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OperationalLimit]): OperationalLimit =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OperationalLimit (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A set of limits associated with equipment.
 *
 * Sets of limits might apply to a specific temperature, or season for example. A set of limits may contain different severities of limit levels that would apply to the same equipment. The set may contain limits of different types such as apparent power and current limits or high and low voltage limits  that are logically applied together as a set.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Equipment [[ch.ninecode.model.Equipment Equipment]] The equipment to which the limit set applies.
 * @param OperationalLimitValue [[ch.ninecode.model.OperationalLimit OperationalLimit]] Values of equipment limits.
 * @param Terminal [[ch.ninecode.model.ACDCTerminal ACDCTerminal]] The terminal where the operational limit set apply.
 * @group OperationalLimits
 * @groupname OperationalLimits Package OperationalLimits
 * @groupdesc OperationalLimits This package models a specification of limits associated with equipment and other operational entities.
 */
final case class OperationalLimitSet
(
    IdentifiedObject: IdentifiedObject = null,
    Equipment: String = null,
    OperationalLimitValue: List[String] = null,
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
        implicit val clz: String = OperationalLimitSet.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OperationalLimitSet.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (OperationalLimitSet.fields (position), x))
        emitattr (0, Equipment)
        emitattrs (1, OperationalLimitValue)
        emitattr (2, Terminal)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OperationalLimitSet rdf:ID=\"%s\">\n%s\t</cim:OperationalLimitSet>".format (id, export_fields)
    }
}

object OperationalLimitSet
extends
    CIMParseable[OperationalLimitSet]
{
    override val fields: Array[String] = Array[String] (
        "Equipment",
        "OperationalLimitValue",
        "Terminal"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Equipment", "Equipment", "0..1", "0..*"),
        CIMRelationship ("OperationalLimitValue", "OperationalLimit", "0..*", "1"),
        CIMRelationship ("Terminal", "ACDCTerminal", "0..1", "0..*")
    )
    val Equipment: Fielder = parse_attribute (attribute (cls, fields(0)))
    val OperationalLimitValue: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val Terminal: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): OperationalLimitSet =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OperationalLimitSet (
            IdentifiedObject.parse (context),
            mask (Equipment (), 0),
            masks (OperationalLimitValue (), 1),
            mask (Terminal (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

object OperationalLimitSetSerializer extends CIMSerializer[OperationalLimitSet]
{
    def write (kryo: Kryo, output: Output, obj: OperationalLimitSet): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.Equipment),
            () => writeList (obj.OperationalLimitValue, output),
            () => output.writeString (obj.Terminal)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OperationalLimitSet]): OperationalLimitSet =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OperationalLimitSet (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The operational meaning of a category of limits.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param acceptableDuration The nominal acceptable duration of the limit.
 *        Limits are commonly expressed in terms of the time limit for which the limit is normally acceptable. The actual acceptable duration of a specific limit may depend on other local factors such as temperature or wind speed.
 * @param direction The direction of the limit.
 * @param OperationalLimit [[ch.ninecode.model.OperationalLimit OperationalLimit]] The operational limits associated with this type of limit.
 * @param SourceOperationalLimitTypeScaling [[ch.ninecode.model.OperatonalLimitTypeScaling OperatonalLimitTypeScaling]] <em>undocumented</em>
 * @param TargetOperationalLimitmTypeScaling [[ch.ninecode.model.OperatonalLimitTypeScaling OperatonalLimitTypeScaling]] <em>undocumented</em>
 * @group OperationalLimits
 * @groupname OperationalLimits Package OperationalLimits
 * @groupdesc OperationalLimits This package models a specification of limits associated with equipment and other operational entities.
 */
final case class OperationalLimitType
(
    IdentifiedObject: IdentifiedObject = null,
    acceptableDuration: Double = 0.0,
    direction: String = null,
    OperationalLimit: List[String] = null,
    SourceOperationalLimitTypeScaling: List[String] = null,
    TargetOperationalLimitmTypeScaling: String = null
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
        implicit val clz: String = OperationalLimitType.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OperationalLimitType.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OperationalLimitType.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (OperationalLimitType.fields (position), x))
        emitelem (0, acceptableDuration)
        emitattr (1, direction)
        emitattrs (2, OperationalLimit)
        emitattrs (3, SourceOperationalLimitTypeScaling)
        emitattr (4, TargetOperationalLimitmTypeScaling)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OperationalLimitType rdf:ID=\"%s\">\n%s\t</cim:OperationalLimitType>".format (id, export_fields)
    }
}

object OperationalLimitType
extends
    CIMParseable[OperationalLimitType]
{
    override val fields: Array[String] = Array[String] (
        "acceptableDuration",
        "direction",
        "OperationalLimit",
        "SourceOperationalLimitTypeScaling",
        "TargetOperationalLimitmTypeScaling"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("OperationalLimit", "OperationalLimit", "0..*", "0..1"),
        CIMRelationship ("SourceOperationalLimitTypeScaling", "OperatonalLimitTypeScaling", "0..*", "0..1"),
        CIMRelationship ("TargetOperationalLimitmTypeScaling", "OperatonalLimitTypeScaling", "0..1", "1")
    )
    val acceptableDuration: Fielder = parse_element (element (cls, fields(0)))
    val direction: Fielder = parse_attribute (attribute (cls, fields(1)))
    val OperationalLimit: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val SourceOperationalLimitTypeScaling: FielderMultiple = parse_attributes (attribute (cls, fields(3)))
    val TargetOperationalLimitmTypeScaling: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: CIMContext): OperationalLimitType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OperationalLimitType (
            IdentifiedObject.parse (context),
            toDouble (mask (acceptableDuration (), 0)),
            mask (direction (), 1),
            masks (OperationalLimit (), 2),
            masks (SourceOperationalLimitTypeScaling (), 3),
            mask (TargetOperationalLimitmTypeScaling (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

object OperationalLimitTypeSerializer extends CIMSerializer[OperationalLimitType]
{
    def write (kryo: Kryo, output: Output, obj: OperationalLimitType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.acceptableDuration),
            () => output.writeString (obj.direction),
            () => writeList (obj.OperationalLimit, output),
            () => writeList (obj.SourceOperationalLimitTypeScaling, output),
            () => output.writeString (obj.TargetOperationalLimitmTypeScaling)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OperationalLimitType]): OperationalLimitType =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OperationalLimitType (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) readList (input) else null,
            if (isSet (4)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Operational limit applied to voltage.
 *
 * @param OperationalLimit [[ch.ninecode.model.OperationalLimit OperationalLimit]] Reference to the superclass object.
 * @param normalValue The normal limit on voltage.
 *        High or low limit nature of the limit depends upon the properties of the operational limit type.
 * @param value Limit on voltage.
 *        High or low limit nature of the limit depends upon the properties of the operational limit type.
 * @group OperationalLimits
 * @groupname OperationalLimits Package OperationalLimits
 * @groupdesc OperationalLimits This package models a specification of limits associated with equipment and other operational entities.
 */
final case class VoltageLimit
(
    OperationalLimit: OperationalLimit = null,
    normalValue: Double = 0.0,
    value: Double = 0.0
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
    override def sup: OperationalLimit = OperationalLimit

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
        implicit val clz: String = VoltageLimit.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (VoltageLimit.fields (position), value)
        emitelem (0, normalValue)
        emitelem (1, value)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:VoltageLimit rdf:ID=\"%s\">\n%s\t</cim:VoltageLimit>".format (id, export_fields)
    }
}

object VoltageLimit
extends
    CIMParseable[VoltageLimit]
{
    override val fields: Array[String] = Array[String] (
        "normalValue",
        "value"
    )
    val normalValue: Fielder = parse_element (element (cls, fields(0)))
    val value: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: CIMContext): VoltageLimit =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = VoltageLimit (
            OperationalLimit.parse (context),
            toDouble (mask (normalValue (), 0)),
            toDouble (mask (value (), 1))
        )
        ret.bitfields = bitfields
        ret
    }
}

object VoltageLimitSerializer extends CIMSerializer[VoltageLimit]
{
    def write (kryo: Kryo, output: Output, obj: VoltageLimit): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.normalValue),
            () => output.writeDouble (obj.value)
        )
        OperationalLimitSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[VoltageLimit]): VoltageLimit =
    {
        val parent = OperationalLimitSerializer.read (kryo, input, classOf[OperationalLimit])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = VoltageLimit (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _OperationalLimits
{
    def register: List[CIMClassInfo] =
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
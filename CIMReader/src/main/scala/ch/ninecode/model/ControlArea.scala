package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.Serializer
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship
import ch.ninecode.cim.CIMSerializer

/**
 * A prioritized measurement to be used for the generating unit in the control area specification.
 *
 * @param IdentifiedObject          [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param priority                  Priority of a measurement usage.
 *                                  Lower numbers have first priority.
 * @param AnalogValue               [[ch.ninecode.model.AnalogValue AnalogValue]] The specific analog value used as a source.
 * @param ControlAreaGeneratingUnit [[ch.ninecode.model.ControlAreaGeneratingUnit ControlAreaGeneratingUnit]] The control area generating unit to which the prioritized measurement assignment is applied.
 * @group ControlArea
 * @groupname ControlArea Package ControlArea
 * @groupdesc ControlArea The ControlArea package models area specifications which can be used for a variety of purposes.  The package as a whole models potentially overlapping control area specifications for the purpose of actual generation control, load forecast area load capture, or powerflow based analysis.
 */
final case class AltGeneratingUnitMeas
(
    IdentifiedObject: IdentifiedObject = null,
    priority: Int = 0,
    AnalogValue: String = null,
    ControlAreaGeneratingUnit: String = null
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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = AltGeneratingUnitMeas.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(AltGeneratingUnitMeas.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(AltGeneratingUnitMeas.fields(position), value)

        emitelem(0, priority)
        emitattr(1, AnalogValue)
        emitattr(2, ControlAreaGeneratingUnit)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:AltGeneratingUnitMeas rdf:%s=\"%s\">\n%s\t</cim:AltGeneratingUnitMeas>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object AltGeneratingUnitMeas
    extends
        CIMParseable[AltGeneratingUnitMeas]
{
    override val fields: Array[String] = Array[String](
        "priority",
        "AnalogValue",
        "ControlAreaGeneratingUnit"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("AnalogValue", "AnalogValue", "1", "0..*"),
        CIMRelationship("ControlAreaGeneratingUnit", "ControlAreaGeneratingUnit", "1", "0..*")
    )
    val priority: Fielder = parse_element(element(cls, fields(0)))
    val AnalogValue: Fielder = parse_attribute(attribute(cls, fields(1)))
    val ControlAreaGeneratingUnit: Fielder = parse_attribute(attribute(cls, fields(2)))

    def parse (context: CIMContext): AltGeneratingUnitMeas =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AltGeneratingUnitMeas(
            IdentifiedObject.parse(context),
            toInteger(mask(priority(), 0)),
            mask(AnalogValue(), 1),
            mask(ControlAreaGeneratingUnit(), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AltGeneratingUnitMeas] = AltGeneratingUnitMeasSerializer
}

object AltGeneratingUnitMeasSerializer extends CIMSerializer[AltGeneratingUnitMeas]
{
    def write (kryo: Kryo, output: Output, obj: AltGeneratingUnitMeas): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeInt(obj.priority),
            () => output.writeString(obj.AnalogValue),
            () => output.writeString(obj.ControlAreaGeneratingUnit)
        )
        IdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AltGeneratingUnitMeas]): AltGeneratingUnitMeas =
    {
        val parent = IdentifiedObjectSerializer.read(kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = AltGeneratingUnitMeas(
            parent,
            if (isSet(0)) input.readInt else 0,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A prioritized measurement to be used for the tie flow as part of the control area specification.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param priority         Priority of a measurement usage.
 *                         Lower numbers have first priority.
 * @param AnalogValue      [[ch.ninecode.model.AnalogValue AnalogValue]] The specific analog value used as a source.
 * @param TieFlow          [[ch.ninecode.model.TieFlow TieFlow]] The tie flow of the alternate measurements.
 * @group ControlArea
 * @groupname ControlArea Package ControlArea
 * @groupdesc ControlArea The ControlArea package models area specifications which can be used for a variety of purposes.  The package as a whole models potentially overlapping control area specifications for the purpose of actual generation control, load forecast area load capture, or powerflow based analysis.
 */
final case class AltTieMeas
(
    IdentifiedObject: IdentifiedObject = null,
    priority: Int = 0,
    AnalogValue: String = null,
    TieFlow: String = null
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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = AltTieMeas.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(AltTieMeas.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(AltTieMeas.fields(position), value)

        emitelem(0, priority)
        emitattr(1, AnalogValue)
        emitattr(2, TieFlow)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:AltTieMeas rdf:%s=\"%s\">\n%s\t</cim:AltTieMeas>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object AltTieMeas
    extends
        CIMParseable[AltTieMeas]
{
    override val fields: Array[String] = Array[String](
        "priority",
        "AnalogValue",
        "TieFlow"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("AnalogValue", "AnalogValue", "1", "0..*"),
        CIMRelationship("TieFlow", "TieFlow", "1", "0..*")
    )
    val priority: Fielder = parse_element(element(cls, fields(0)))
    val AnalogValue: Fielder = parse_attribute(attribute(cls, fields(1)))
    val TieFlow: Fielder = parse_attribute(attribute(cls, fields(2)))

    def parse (context: CIMContext): AltTieMeas =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AltTieMeas(
            IdentifiedObject.parse(context),
            toInteger(mask(priority(), 0)),
            mask(AnalogValue(), 1),
            mask(TieFlow(), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AltTieMeas] = AltTieMeasSerializer
}

object AltTieMeasSerializer extends CIMSerializer[AltTieMeas]
{
    def write (kryo: Kryo, output: Output, obj: AltTieMeas): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeInt(obj.priority),
            () => output.writeString(obj.AnalogValue),
            () => output.writeString(obj.TieFlow)
        )
        IdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AltTieMeas]): AltTieMeas =
    {
        val parent = IdentifiedObjectSerializer.read(kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = AltTieMeas(
            parent,
            if (isSet(0)) input.readInt else 0,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A control area is a grouping of generating units and/or loads and a cutset of tie lines (as terminals) which may be used for a variety of purposes including automatic generation control, power flow solution area interchange control specification, and input to load forecasting.
 *
 * All generation and load within the area defined by the terminals on the border are considered in the area interchange control. Note that any number of overlapping control area specifications can be superimposed on the physical model. The following general principles apply to ControlArea:
 * 1.  The control area orientation for net interchange is positive for an import, negative for an export.
 * 2.  The control area net interchange is determined by summing flows in Terminals. The Terminals are identified by creating a set of TieFlow objects associated with a ControlArea object. Each TieFlow object identifies one Terminal.
 * 3.  In a single network model, a tie between two control areas must be modelled in both control area specifications, such that the two representations of the tie flow sum to zero.
 * 4.  The normal orientation of Terminal flow is positive for flow into the conducting equipment that owns the Terminal. (i.e. flow from a bus into a device is positive.) However, the orientation of each flow in the control area specification must align with the control area convention, i.e. import is positive. If the orientation of the Terminal flow referenced by a TieFlow is positive into the control area, then this is confirmed by setting TieFlow.positiveFlowIn flag TRUE. If not, the orientation must be reversed by setting the TieFlow.positiveFlowIn flag FALSE.
 *
 * @param PowerSystemResource       [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param netInterchange            The specified positive net interchange into the control area, i.e. positive sign means flow into the area.
 * @param pTolerance                Active power net interchange tolerance.
 *                                  The attribute shall be a positive value or zero.
 * @param type                      The primary type of control area definition used to determine if this is used for automatic generation control, for planning interchange control, or other purposes.
 *                                  A control area specified with primary type of automatic generation control could still be forecast and used as an interchange area in power flow analysis.
 * @param ControlAreaGeneratingUnit [[ch.ninecode.model.ControlAreaGeneratingUnit ControlAreaGeneratingUnit]] The generating unit specifications for the control area.
 * @param EnergyArea                [[ch.ninecode.model.EnergyArea EnergyArea]] The energy area that is forecast from this control area specification.
 * @param TieFlow                   [[ch.ninecode.model.TieFlow TieFlow]] The tie flows associated with the control area.
 * @group ControlArea
 * @groupname ControlArea Package ControlArea
 * @groupdesc ControlArea The ControlArea package models area specifications which can be used for a variety of purposes.  The package as a whole models potentially overlapping control area specifications for the purpose of actual generation control, load forecast area load capture, or powerflow based analysis.
 */
final case class ControlArea
(
    PowerSystemResource: PowerSystemResource = null,
    netInterchange: Double = 0.0,
    pTolerance: Double = 0.0,
    `type`: String = null,
    ControlAreaGeneratingUnit: List[String] = null,
    EnergyArea: String = null,
    TieFlow: List[String] = null
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
    override def sup: PowerSystemResource = PowerSystemResource

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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ControlArea.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(ControlArea.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(ControlArea.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(ControlArea.fields(position), x))

        emitelem(0, netInterchange)
        emitelem(1, pTolerance)
        emitattr(2, `type`)
        emitattrs(3, ControlAreaGeneratingUnit)
        emitattr(4, EnergyArea)
        emitattrs(5, TieFlow)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ControlArea rdf:%s=\"%s\">\n%s\t</cim:ControlArea>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ControlArea
    extends
        CIMParseable[ControlArea]
{
    override val fields: Array[String] = Array[String](
        "netInterchange",
        "pTolerance",
        "type",
        "ControlAreaGeneratingUnit",
        "EnergyArea",
        "TieFlow"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("ControlAreaGeneratingUnit", "ControlAreaGeneratingUnit", "0..*", "1"),
        CIMRelationship("EnergyArea", "EnergyArea", "0..1", "0..1"),
        CIMRelationship("TieFlow", "TieFlow", "0..*", "1")
    )
    val netInterchange: Fielder = parse_element(element(cls, fields(0)))
    val pTolerance: Fielder = parse_element(element(cls, fields(1)))
    val `type`: Fielder = parse_attribute(attribute(cls, fields(2)))
    val ControlAreaGeneratingUnit: FielderMultiple = parse_attributes(attribute(cls, fields(3)))
    val EnergyArea: Fielder = parse_attribute(attribute(cls, fields(4)))
    val TieFlow: FielderMultiple = parse_attributes(attribute(cls, fields(5)))

    def parse (context: CIMContext): ControlArea =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ControlArea(
            PowerSystemResource.parse(context),
            toDouble(mask(netInterchange(), 0)),
            toDouble(mask(pTolerance(), 1)),
            mask(`type`(), 2),
            masks(ControlAreaGeneratingUnit(), 3),
            mask(EnergyArea(), 4),
            masks(TieFlow(), 5)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ControlArea] = ControlAreaSerializer
}

object ControlAreaSerializer extends CIMSerializer[ControlArea]
{
    def write (kryo: Kryo, output: Output, obj: ControlArea): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.netInterchange),
            () => output.writeDouble(obj.pTolerance),
            () => output.writeString(obj.`type`),
            () => writeList(obj.ControlAreaGeneratingUnit, output),
            () => output.writeString(obj.EnergyArea),
            () => writeList(obj.TieFlow, output)
        )
        PowerSystemResourceSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ControlArea]): ControlArea =
    {
        val parent = PowerSystemResourceSerializer.read(kryo, input, classOf[PowerSystemResource])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ControlArea(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readString else null,
            if (isSet(3)) readList(input) else null,
            if (isSet(4)) input.readString else null,
            if (isSet(5)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A control area generating unit.
 *
 * This class is needed so that alternate control area definitions may include the same generating unit.   It should be noted that only one instance within a control area should reference a specific generating unit.
 *
 * @param IdentifiedObject      [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param AltGeneratingUnitMeas [[ch.ninecode.model.AltGeneratingUnitMeas AltGeneratingUnitMeas]] The link to prioritized measurements for this GeneratingUnit.
 * @param ControlArea           [[ch.ninecode.model.ControlArea ControlArea]] The parent control area for the generating unit specifications.
 * @param GeneratingUnit        [[ch.ninecode.model.GeneratingUnit GeneratingUnit]] The generating unit specified for this control area.
 *                              Note that a control area should include a GeneratingUnit only once.
 * @group ControlArea
 * @groupname ControlArea Package ControlArea
 * @groupdesc ControlArea The ControlArea package models area specifications which can be used for a variety of purposes.  The package as a whole models potentially overlapping control area specifications for the purpose of actual generation control, load forecast area load capture, or powerflow based analysis.
 */
final case class ControlAreaGeneratingUnit
(
    IdentifiedObject: IdentifiedObject = null,
    AltGeneratingUnitMeas: List[String] = null,
    ControlArea: String = null,
    GeneratingUnit: String = null
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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = ControlAreaGeneratingUnit.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(ControlAreaGeneratingUnit.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(ControlAreaGeneratingUnit.fields(position), x))

        emitattrs(0, AltGeneratingUnitMeas)
        emitattr(1, ControlArea)
        emitattr(2, GeneratingUnit)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ControlAreaGeneratingUnit rdf:%s=\"%s\">\n%s\t</cim:ControlAreaGeneratingUnit>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ControlAreaGeneratingUnit
    extends
        CIMParseable[ControlAreaGeneratingUnit]
{
    override val fields: Array[String] = Array[String](
        "AltGeneratingUnitMeas",
        "ControlArea",
        "GeneratingUnit"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("AltGeneratingUnitMeas", "AltGeneratingUnitMeas", "0..*", "1"),
        CIMRelationship("ControlArea", "ControlArea", "1", "0..*"),
        CIMRelationship("GeneratingUnit", "GeneratingUnit", "1", "0..*")
    )
    val AltGeneratingUnitMeas: FielderMultiple = parse_attributes(attribute(cls, fields(0)))
    val ControlArea: Fielder = parse_attribute(attribute(cls, fields(1)))
    val GeneratingUnit: Fielder = parse_attribute(attribute(cls, fields(2)))

    def parse (context: CIMContext): ControlAreaGeneratingUnit =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ControlAreaGeneratingUnit(
            IdentifiedObject.parse(context),
            masks(AltGeneratingUnitMeas(), 0),
            mask(ControlArea(), 1),
            mask(GeneratingUnit(), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ControlAreaGeneratingUnit] = ControlAreaGeneratingUnitSerializer
}

object ControlAreaGeneratingUnitSerializer extends CIMSerializer[ControlAreaGeneratingUnit]
{
    def write (kryo: Kryo, output: Output, obj: ControlAreaGeneratingUnit): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => writeList(obj.AltGeneratingUnitMeas, output),
            () => output.writeString(obj.ControlArea),
            () => output.writeString(obj.GeneratingUnit)
        )
        IdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ControlAreaGeneratingUnit]): ControlAreaGeneratingUnit =
    {
        val parent = IdentifiedObjectSerializer.read(kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ControlAreaGeneratingUnit(
            parent,
            if (isSet(0)) readList(input) else null,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Defines the structure (in terms of location and direction) of the net interchange constraint for a control area.
 *
 * This constraint may be used by either AGC or power flow.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param positiveFlowIn   Specifies the sign of the tie flow associated with a control area.
 *                         True if positive flow into the terminal (load convention) is also positive flow into the control area.  See the description of ControlArea for further explanation of how TieFlow.positiveFlowIn is used.
 * @param AltTieMeas       [[ch.ninecode.model.AltTieMeas AltTieMeas]] The primary and alternate tie flow measurements associated with the tie flow.
 * @param ControlArea      [[ch.ninecode.model.ControlArea ControlArea]] The control area of the tie flows.
 * @param Terminal         [[ch.ninecode.model.Terminal Terminal]] The terminal to which this tie flow belongs.
 * @group ControlArea
 * @groupname ControlArea Package ControlArea
 * @groupdesc ControlArea The ControlArea package models area specifications which can be used for a variety of purposes.  The package as a whole models potentially overlapping control area specifications for the purpose of actual generation control, load forecast area load capture, or powerflow based analysis.
 */
final case class TieFlow
(
    IdentifiedObject: IdentifiedObject = null,
    positiveFlowIn: Boolean = false,
    AltTieMeas: List[String] = null,
    ControlArea: String = null,
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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = TieFlow.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(TieFlow.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(TieFlow.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(TieFlow.fields(position), x))

        emitelem(0, positiveFlowIn)
        emitattrs(1, AltTieMeas)
        emitattr(2, ControlArea)
        emitattr(3, Terminal)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:TieFlow rdf:%s=\"%s\">\n%s\t</cim:TieFlow>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object TieFlow
    extends
        CIMParseable[TieFlow]
{
    override val fields: Array[String] = Array[String](
        "positiveFlowIn",
        "AltTieMeas",
        "ControlArea",
        "Terminal"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("AltTieMeas", "AltTieMeas", "0..*", "1"),
        CIMRelationship("ControlArea", "ControlArea", "1", "0..*"),
        CIMRelationship("Terminal", "Terminal", "1", "0..2")
    )
    val positiveFlowIn: Fielder = parse_element(element(cls, fields(0)))
    val AltTieMeas: FielderMultiple = parse_attributes(attribute(cls, fields(1)))
    val ControlArea: Fielder = parse_attribute(attribute(cls, fields(2)))
    val Terminal: Fielder = parse_attribute(attribute(cls, fields(3)))

    def parse (context: CIMContext): TieFlow =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TieFlow(
            IdentifiedObject.parse(context),
            toBoolean(mask(positiveFlowIn(), 0)),
            masks(AltTieMeas(), 1),
            mask(ControlArea(), 2),
            mask(Terminal(), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[TieFlow] = TieFlowSerializer
}

object TieFlowSerializer extends CIMSerializer[TieFlow]
{
    def write (kryo: Kryo, output: Output, obj: TieFlow): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeBoolean(obj.positiveFlowIn),
            () => writeList(obj.AltTieMeas, output),
            () => output.writeString(obj.ControlArea),
            () => output.writeString(obj.Terminal)
        )
        IdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TieFlow]): TieFlow =
    {
        val parent = IdentifiedObjectSerializer.read(kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = TieFlow(
            parent,
            if (isSet(0)) input.readBoolean else false,
            if (isSet(1)) readList(input) else null,
            if (isSet(2)) input.readString else null,
            if (isSet(3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _ControlArea
{
    def register: List[CIMClassInfo] =
    {
        List(
            AltGeneratingUnitMeas.register,
            AltTieMeas.register,
            ControlArea.register,
            ControlAreaGeneratingUnit.register,
            TieFlow.register
        )
    }
}
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
 * Action on clearance document as a switching step.
 *
 * @param SwitchingAction [[ch.ninecode.model.SwitchingAction SwitchingAction]] Reference to the superclass object.
 * @param kind Clearance action to perform.
 * @param Clearance [[ch.ninecode.model.ClearanceDocument ClearanceDocument]] Clearance associated with this clearance action.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class ClearanceAction
(
    SwitchingAction: SwitchingAction = null,
    kind: String = null,
    Clearance: String = null
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
    override def sup: SwitchingAction = SwitchingAction

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
        implicit val clz: String = ClearanceAction.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ClearanceAction.fields (position), value)
        emitattr (0, kind)
        emitattr (1, Clearance)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ClearanceAction rdf:ID=\"%s\">\n%s\t</cim:ClearanceAction>".format (id, export_fields)
    }
}

object ClearanceAction
extends
    CIMParseable[ClearanceAction]
{
    override val fields: Array[String] = Array[String] (
        "kind",
        "Clearance"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Clearance", "ClearanceDocument", "0..1", "0..1")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Clearance: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): ClearanceAction =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ClearanceAction (
            SwitchingAction.parse (context),
            mask (kind (), 0),
            mask (Clearance (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ClearanceAction] = ClearanceActionSerializer
}

object ClearanceActionSerializer extends CIMSerializer[ClearanceAction]
{
    def write (kryo: Kryo, output: Output, obj: ClearanceAction): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.kind),
            () => output.writeString (obj.Clearance)
        )
        SwitchingActionSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ClearanceAction]): ClearanceAction =
    {
        val parent = SwitchingActionSerializer.read (kryo, input, classOf[SwitchingAction])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ClearanceAction (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Safety document used to authorise work on conducting equipment in the field.
 *
 * Tagged equipment is not allowed to be operated.
 *
 * @param SafetyDocument [[ch.ninecode.model.SafetyDocument SafetyDocument]] Reference to the superclass object.
 * @param mustBeDeenergised If true, the equipment must be deenergised.
 * @param mustBeGrounded If true, the equipment must be grounded.
 * @param ClearanceAction [[ch.ninecode.model.ClearanceAction ClearanceAction]] Clearance action associated with this clearance.
 * @param TaggedPSRs [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] All power system resources tagged through this clearance.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class ClearanceDocument
(
    SafetyDocument: SafetyDocument = null,
    mustBeDeenergised: Boolean = false,
    mustBeGrounded: Boolean = false,
    ClearanceAction: String = null,
    TaggedPSRs: List[String] = null
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
    override def sup: SafetyDocument = SafetyDocument

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
        implicit val clz: String = ClearanceDocument.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ClearanceDocument.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ClearanceDocument.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ClearanceDocument.fields (position), x))
        emitelem (0, mustBeDeenergised)
        emitelem (1, mustBeGrounded)
        emitattr (2, ClearanceAction)
        emitattrs (3, TaggedPSRs)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ClearanceDocument rdf:ID=\"%s\">\n%s\t</cim:ClearanceDocument>".format (id, export_fields)
    }
}

object ClearanceDocument
extends
    CIMParseable[ClearanceDocument]
{
    override val fields: Array[String] = Array[String] (
        "mustBeDeenergised",
        "mustBeGrounded",
        "ClearanceAction",
        "TaggedPSRs"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ClearanceAction", "ClearanceAction", "0..1", "0..1"),
        CIMRelationship ("TaggedPSRs", "PowerSystemResource", "0..*", "0..*")
    )
    val mustBeDeenergised: Fielder = parse_element (element (cls, fields(0)))
    val mustBeGrounded: Fielder = parse_element (element (cls, fields(1)))
    val ClearanceAction: Fielder = parse_attribute (attribute (cls, fields(2)))
    val TaggedPSRs: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: CIMContext): ClearanceDocument =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ClearanceDocument (
            SafetyDocument.parse (context),
            toBoolean (mask (mustBeDeenergised (), 0)),
            toBoolean (mask (mustBeGrounded (), 1)),
            mask (ClearanceAction (), 2),
            masks (TaggedPSRs (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ClearanceDocument] = ClearanceDocumentSerializer
}

object ClearanceDocumentSerializer extends CIMSerializer[ClearanceDocument]
{
    def write (kryo: Kryo, output: Output, obj: ClearanceDocument): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeBoolean (obj.mustBeDeenergised),
            () => output.writeBoolean (obj.mustBeGrounded),
            () => output.writeString (obj.ClearanceAction),
            () => writeList (obj.TaggedPSRs, output)
        )
        SafetyDocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ClearanceDocument]): ClearanceDocument =
    {
        val parent = SafetyDocumentSerializer.read (kryo, input, classOf[SafetyDocument])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ClearanceDocument (
            parent,
            if (isSet (0)) input.readBoolean else false,
            if (isSet (1)) input.readBoolean else false,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Control executed as a switching step.
 *
 * @param SwitchingAction [[ch.ninecode.model.SwitchingAction SwitchingAction]] Reference to the superclass object.
 * @param analogValue The analog value used for the analog control, the raise/lower control and the set point control
 * @param discreteValue The integer value used for the command or the accumulator reset.
 * @param Control [[ch.ninecode.model.Control Control]] <em>undocumented</em>
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class ControlAction
(
    SwitchingAction: SwitchingAction = null,
    analogValue: Double = 0.0,
    discreteValue: Int = 0,
    Control: String = null
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
    override def sup: SwitchingAction = SwitchingAction

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
        implicit val clz: String = ControlAction.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ControlAction.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ControlAction.fields (position), value)
        emitelem (0, analogValue)
        emitelem (1, discreteValue)
        emitattr (2, Control)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ControlAction rdf:ID=\"%s\">\n%s\t</cim:ControlAction>".format (id, export_fields)
    }
}

object ControlAction
extends
    CIMParseable[ControlAction]
{
    override val fields: Array[String] = Array[String] (
        "analogValue",
        "discreteValue",
        "Control"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Control", "Control", "0..1", "0..1")
    )
    val analogValue: Fielder = parse_element (element (cls, fields(0)))
    val discreteValue: Fielder = parse_element (element (cls, fields(1)))
    val Control: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): ControlAction =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ControlAction (
            SwitchingAction.parse (context),
            toDouble (mask (analogValue (), 0)),
            toInteger (mask (discreteValue (), 1)),
            mask (Control (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ControlAction] = ControlActionSerializer
}

object ControlActionSerializer extends CIMSerializer[ControlAction]
{
    def write (kryo: Kryo, output: Output, obj: ControlAction): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.analogValue),
            () => output.writeInt (obj.discreteValue),
            () => output.writeString (obj.Control)
        )
        SwitchingActionSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ControlAction]): ControlAction =
    {
        val parent = SwitchingActionSerializer.read (kryo, input, classOf[SwitchingAction])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ControlAction (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readInt else 0,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Action on cut as a switching step.
 *
 * @param SwitchingAction [[ch.ninecode.model.SwitchingAction SwitchingAction]] Reference to the superclass object.
 * @param kind Switching action to perform.
 * @param Cut [[ch.ninecode.model.Cut Cut]] Cut on which this action is taken.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class CutAction
(
    SwitchingAction: SwitchingAction = null,
    kind: String = null,
    Cut: String = null
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
    override def sup: SwitchingAction = SwitchingAction

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
        implicit val clz: String = CutAction.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CutAction.fields (position), value)
        emitattr (0, kind)
        emitattr (1, Cut)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CutAction rdf:ID=\"%s\">\n%s\t</cim:CutAction>".format (id, export_fields)
    }
}

object CutAction
extends
    CIMParseable[CutAction]
{
    override val fields: Array[String] = Array[String] (
        "kind",
        "Cut"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Cut", "Cut", "0..1", "0..1")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Cut: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): CutAction =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CutAction (
            SwitchingAction.parse (context),
            mask (kind (), 0),
            mask (Cut (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CutAction] = CutActionSerializer
}

object CutActionSerializer extends CIMSerializer[CutAction]
{
    def write (kryo: Kryo, output: Output, obj: CutAction): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.kind),
            () => output.writeString (obj.Cut)
        )
        SwitchingActionSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CutAction]): CutAction =
    {
        val parent = SwitchingActionSerializer.read (kryo, input, classOf[SwitchingAction])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CutAction (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Action on energy source as a switching step.
 *
 * @param SwitchingAction [[ch.ninecode.model.SwitchingAction SwitchingAction]] Reference to the superclass object.
 * @param kind Switching action to perform.
 * @param EnergySource [[ch.ninecode.model.EnergySource EnergySource]] Energy source on which this action is taken.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class EnergySourceAction
(
    SwitchingAction: SwitchingAction = null,
    kind: String = null,
    EnergySource: String = null
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
    override def sup: SwitchingAction = SwitchingAction

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
        implicit val clz: String = EnergySourceAction.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnergySourceAction.fields (position), value)
        emitattr (0, kind)
        emitattr (1, EnergySource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnergySourceAction rdf:ID=\"%s\">\n%s\t</cim:EnergySourceAction>".format (id, export_fields)
    }
}

object EnergySourceAction
extends
    CIMParseable[EnergySourceAction]
{
    override val fields: Array[String] = Array[String] (
        "kind",
        "EnergySource"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("EnergySource", "EnergySource", "0..1", "0..1")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val EnergySource: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): EnergySourceAction =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EnergySourceAction (
            SwitchingAction.parse (context),
            mask (kind (), 0),
            mask (EnergySource (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[EnergySourceAction] = EnergySourceActionSerializer
}

object EnergySourceActionSerializer extends CIMSerializer[EnergySourceAction]
{
    def write (kryo: Kryo, output: Output, obj: EnergySourceAction): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.kind),
            () => output.writeString (obj.EnergySource)
        )
        SwitchingActionSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EnergySourceAction]): EnergySourceAction =
    {
        val parent = SwitchingActionSerializer.read (kryo, input, classOf[SwitchingAction])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = EnergySourceAction (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The Estimated Restoration Time for a single outage
 *
 * @param Element Reference to the superclass object.
 * @param confidenceKind provides the confidence level that this ERT can be accomplished.
 *        This may be changed/updated as needed.
 * @param ert estimated time the outage will be restored
 * @param ertSource defines the source that provided the ERT value.
 * @param Outage [[ch.ninecode.model.Outage Outage]] <em>undocumented</em>
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class EstimatedRestorationTime
(
    Element: BasicElement = null,
    confidenceKind: String = null,
    ert: String = null,
    ertSource: String = null,
    Outage: List[String] = null
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
        implicit val clz: String = EstimatedRestorationTime.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (EstimatedRestorationTime.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EstimatedRestorationTime.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (EstimatedRestorationTime.fields (position), x))
        emitattr (0, confidenceKind)
        emitelem (1, ert)
        emitelem (2, ertSource)
        emitattrs (3, Outage)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EstimatedRestorationTime rdf:ID=\"%s\">\n%s\t</cim:EstimatedRestorationTime>".format (id, export_fields)
    }
}

object EstimatedRestorationTime
extends
    CIMParseable[EstimatedRestorationTime]
{
    override val fields: Array[String] = Array[String] (
        "confidenceKind",
        "ert",
        "ertSource",
        "Outage"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Outage", "Outage", "0..*", "0..1")
    )
    val confidenceKind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ert: Fielder = parse_element (element (cls, fields(1)))
    val ertSource: Fielder = parse_element (element (cls, fields(2)))
    val Outage: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: CIMContext): EstimatedRestorationTime =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EstimatedRestorationTime (
            BasicElement.parse (context),
            mask (confidenceKind (), 0),
            mask (ert (), 1),
            mask (ertSource (), 2),
            masks (Outage (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[EstimatedRestorationTime] = EstimatedRestorationTimeSerializer
}

object EstimatedRestorationTimeSerializer extends CIMSerializer[EstimatedRestorationTime]
{
    def write (kryo: Kryo, output: Output, obj: EstimatedRestorationTime): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.confidenceKind),
            () => output.writeString (obj.ert),
            () => output.writeString (obj.ertSource),
            () => writeList (obj.Outage, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EstimatedRestorationTime]): EstimatedRestorationTime =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = EstimatedRestorationTime (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Crew member on work site responsible for all local safety measures for the work crew doing maintenance, construction and repair in a substation or on a power line/cable.
 *
 * @param CrewMember [[ch.ninecode.model.CrewMember CrewMember]] Reference to the superclass object.
 * @param IssuedSafetyDocuments [[ch.ninecode.model.SafetyDocument SafetyDocument]] All safety documents issued to this supervisor.
 * @param ReleasedSafetyDocuments [[ch.ninecode.model.SafetyDocument SafetyDocument]] All safety documents released by this supervisor.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class FieldSafetySupervisor
(
    CrewMember: CrewMember = null,
    IssuedSafetyDocuments: List[String] = null,
    ReleasedSafetyDocuments: List[String] = null
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
    override def sup: CrewMember = CrewMember

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
        implicit val clz: String = FieldSafetySupervisor.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (FieldSafetySupervisor.fields (position), x))
        emitattrs (0, IssuedSafetyDocuments)
        emitattrs (1, ReleasedSafetyDocuments)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:FieldSafetySupervisor rdf:ID=\"%s\">\n%s\t</cim:FieldSafetySupervisor>".format (id, export_fields)
    }
}

object FieldSafetySupervisor
extends
    CIMParseable[FieldSafetySupervisor]
{
    override val fields: Array[String] = Array[String] (
        "IssuedSafetyDocuments",
        "ReleasedSafetyDocuments"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("IssuedSafetyDocuments", "SafetyDocument", "0..*", "0..1"),
        CIMRelationship ("ReleasedSafetyDocuments", "SafetyDocument", "0..*", "0..1")
    )
    val IssuedSafetyDocuments: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val ReleasedSafetyDocuments: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): FieldSafetySupervisor =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = FieldSafetySupervisor (
            CrewMember.parse (context),
            masks (IssuedSafetyDocuments (), 0),
            masks (ReleasedSafetyDocuments (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[FieldSafetySupervisor] = FieldSafetySupervisorSerializer
}

object FieldSafetySupervisorSerializer extends CIMSerializer[FieldSafetySupervisor]
{
    def write (kryo: Kryo, output: Output, obj: FieldSafetySupervisor): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.IssuedSafetyDocuments, output),
            () => writeList (obj.ReleasedSafetyDocuments, output)
        )
        CrewMemberSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[FieldSafetySupervisor]): FieldSafetySupervisor =
    {
        val parent = CrewMemberSerializer.read (kryo, input, classOf[CrewMember])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = FieldSafetySupervisor (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An arbitrary switching step.
 *
 * @param SwitchingAction [[ch.ninecode.model.SwitchingAction SwitchingAction]] Reference to the superclass object.
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] <em>undocumented</em>
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class GenericAction
(
    SwitchingAction: SwitchingAction = null,
    PowerSystemResource: String = null
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
    override def sup: SwitchingAction = SwitchingAction

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
        implicit val clz: String = GenericAction.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (GenericAction.fields (position), value)
        emitattr (0, PowerSystemResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GenericAction rdf:ID=\"%s\">\n%s\t</cim:GenericAction>".format (id, export_fields)
    }
}

object GenericAction
extends
    CIMParseable[GenericAction]
{
    override val fields: Array[String] = Array[String] (
        "PowerSystemResource"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("PowerSystemResource", "PowerSystemResource", "0..1", "0..*")
    )
    val PowerSystemResource: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): GenericAction =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GenericAction (
            SwitchingAction.parse (context),
            mask (PowerSystemResource (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[GenericAction] = GenericActionSerializer
}

object GenericActionSerializer extends CIMSerializer[GenericAction]
{
    def write (kryo: Kryo, output: Output, obj: GenericAction): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.PowerSystemResource)
        )
        SwitchingActionSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[GenericAction]): GenericAction =
    {
        val parent = SwitchingActionSerializer.read (kryo, input, classOf[SwitchingAction])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = GenericAction (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Action on ground as a switching step.
 *
 * @param SwitchingAction [[ch.ninecode.model.SwitchingAction SwitchingAction]] Reference to the superclass object.
 * @param kind Switching action to perform.
 * @param AlongACLineSegment [[ch.ninecode.model.ACLineSegment ACLineSegment]] The line segment that this ground action will affect.
 *        This is the only way to access relationship to clamp in case the ground needs to be placed along the line segment.
 * @param Ground [[ch.ninecode.model.Ground Ground]] Ground on which this action is taken.
 * @param GroundedEquipment [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] Equipment being grounded with this operation.
 *        In case of placing a ground anywhere along a line segment, you must use the clamp (to get the distance from one terminal), so use the explicit relation with line segment. In all other cases (including placing the ground at a line segment terminal), reference to one or more conducting equipment is sufficient.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class GroundAction
(
    SwitchingAction: SwitchingAction = null,
    kind: String = null,
    AlongACLineSegment: String = null,
    Ground: String = null,
    GroundedEquipment: String = null
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
    override def sup: SwitchingAction = SwitchingAction

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
        implicit val clz: String = GroundAction.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (GroundAction.fields (position), value)
        emitattr (0, kind)
        emitattr (1, AlongACLineSegment)
        emitattr (2, Ground)
        emitattr (3, GroundedEquipment)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GroundAction rdf:ID=\"%s\">\n%s\t</cim:GroundAction>".format (id, export_fields)
    }
}

object GroundAction
extends
    CIMParseable[GroundAction]
{
    override val fields: Array[String] = Array[String] (
        "kind",
        "AlongACLineSegment",
        "Ground",
        "GroundedEquipment"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AlongACLineSegment", "ACLineSegment", "0..1", "0..1"),
        CIMRelationship ("Ground", "Ground", "0..1", "0..1"),
        CIMRelationship ("GroundedEquipment", "ConductingEquipment", "0..1", "0..1")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val AlongACLineSegment: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Ground: Fielder = parse_attribute (attribute (cls, fields(2)))
    val GroundedEquipment: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): GroundAction =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GroundAction (
            SwitchingAction.parse (context),
            mask (kind (), 0),
            mask (AlongACLineSegment (), 1),
            mask (Ground (), 2),
            mask (GroundedEquipment (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[GroundAction] = GroundActionSerializer
}

object GroundActionSerializer extends CIMSerializer[GroundAction]
{
    def write (kryo: Kryo, output: Output, obj: GroundAction): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.kind),
            () => output.writeString (obj.AlongACLineSegment),
            () => output.writeString (obj.Ground),
            () => output.writeString (obj.GroundedEquipment)
        )
        SwitchingActionSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[GroundAction]): GroundAction =
    {
        val parent = SwitchingActionSerializer.read (kryo, input, classOf[SwitchingAction])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = GroundAction (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Description of a problem in the field that may be reported in a trouble ticket or come from another source.
 *
 * It may have to do with an outage.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param cause Cause of this incident.
 * @param CustomerNotifications [[ch.ninecode.model.CustomerNotification CustomerNotification]] All notifications for a customer related to the status change of this incident.
 * @param IncidentHazard [[ch.ninecode.model.IncidentHazard IncidentHazard]] All hazards associated with this incident.
 * @param Location [[ch.ninecode.model.Location Location]] Location of this incident.
 * @param Outage [[ch.ninecode.model.Outage Outage]] Outage for this incident.
 * @param Owner [[ch.ninecode.model.Operator Operator]] Operator who owns this incident.
 * @param TroubleOrder [[ch.ninecode.model.TroubleOrder TroubleOrder]] <em>undocumented</em>
 * @param TroubleTickets [[ch.ninecode.model.TroubleTicket TroubleTicket]] All trouble tickets reporting this incident.
 * @param Works [[ch.ninecode.model.Work Work]] All works addressing this incident.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class Incident
(
    Document: Document = null,
    cause: String = null,
    CustomerNotifications: List[String] = null,
    IncidentHazard: List[String] = null,
    Location: String = null,
    Outage: String = null,
    Owner: String = null,
    TroubleOrder: String = null,
    TroubleTickets: List[String] = null,
    Works: List[String] = null
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
    override def sup: Document = Document

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
        implicit val clz: String = Incident.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Incident.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Incident.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Incident.fields (position), x))
        emitelem (0, cause)
        emitattrs (1, CustomerNotifications)
        emitattrs (2, IncidentHazard)
        emitattr (3, Location)
        emitattr (4, Outage)
        emitattr (5, Owner)
        emitattr (6, TroubleOrder)
        emitattrs (7, TroubleTickets)
        emitattrs (8, Works)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Incident rdf:ID=\"%s\">\n%s\t</cim:Incident>".format (id, export_fields)
    }
}

object Incident
extends
    CIMParseable[Incident]
{
    override val fields: Array[String] = Array[String] (
        "cause",
        "CustomerNotifications",
        "IncidentHazard",
        "Location",
        "Outage",
        "Owner",
        "TroubleOrder",
        "TroubleTickets",
        "Works"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CustomerNotifications", "CustomerNotification", "0..*", "0..1"),
        CIMRelationship ("IncidentHazard", "IncidentHazard", "0..*", "0..1"),
        CIMRelationship ("Location", "Location", "0..1", "0..1"),
        CIMRelationship ("Outage", "Outage", "0..1", "0..*"),
        CIMRelationship ("Owner", "Operator", "0..1", "0..*"),
        CIMRelationship ("TroubleOrder", "TroubleOrder", "0..1", "0..1"),
        CIMRelationship ("TroubleTickets", "TroubleTicket", "0..*", "0..1"),
        CIMRelationship ("Works", "Work", "0..*", "0..*")
    )
    val cause: Fielder = parse_element (element (cls, fields(0)))
    val CustomerNotifications: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val IncidentHazard: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Location: Fielder = parse_attribute (attribute (cls, fields(3)))
    val Outage: Fielder = parse_attribute (attribute (cls, fields(4)))
    val Owner: Fielder = parse_attribute (attribute (cls, fields(5)))
    val TroubleOrder: Fielder = parse_attribute (attribute (cls, fields(6)))
    val TroubleTickets: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val Works: FielderMultiple = parse_attributes (attribute (cls, fields(8)))

    def parse (context: CIMContext): Incident =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Incident (
            Document.parse (context),
            mask (cause (), 0),
            masks (CustomerNotifications (), 1),
            masks (IncidentHazard (), 2),
            mask (Location (), 3),
            mask (Outage (), 4),
            mask (Owner (), 5),
            mask (TroubleOrder (), 6),
            masks (TroubleTickets (), 7),
            masks (Works (), 8)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Incident] = IncidentSerializer
}

object IncidentSerializer extends CIMSerializer[Incident]
{
    def write (kryo: Kryo, output: Output, obj: Incident): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.cause),
            () => writeList (obj.CustomerNotifications, output),
            () => writeList (obj.IncidentHazard, output),
            () => output.writeString (obj.Location),
            () => output.writeString (obj.Outage),
            () => output.writeString (obj.Owner),
            () => output.writeString (obj.TroubleOrder),
            () => writeList (obj.TroubleTickets, output),
            () => writeList (obj.Works, output)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Incident]): Incident =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Incident (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) readList (input) else null,
            if (isSet (8)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Action on jumper as a switching step.
 *
 * @param SwitchingAction [[ch.ninecode.model.SwitchingAction SwitchingAction]] Reference to the superclass object.
 * @param kind Switching action to perform.
 * @param AlongACLineSegments [[ch.ninecode.model.ACLineSegment ACLineSegment]] The line segment that this jumper action will affect.
 *        This is the only way to access relationship to clamp in case the jumper needs to connect along the line segment.
 * @param JumpedEquipments [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] The conducting equipment that this jumper action will affect.
 *        In case of placing a jumper anywhere along a line segment, you must use the clamp (to get the distance from one terminal), so use the explicit relation with line segment. In all other cases (including placing the jumper at a line segment terminal), reference to one or more conducting equipment is sufficient.
 * @param Jumper [[ch.ninecode.model.Jumper Jumper]] Jumper on which this action is taken.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class JumperAction
(
    SwitchingAction: SwitchingAction = null,
    kind: String = null,
    AlongACLineSegments: List[String] = null,
    JumpedEquipments: List[String] = null,
    Jumper: String = null
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
    override def sup: SwitchingAction = SwitchingAction

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
        implicit val clz: String = JumperAction.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (JumperAction.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (JumperAction.fields (position), x))
        emitattr (0, kind)
        emitattrs (1, AlongACLineSegments)
        emitattrs (2, JumpedEquipments)
        emitattr (3, Jumper)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:JumperAction rdf:ID=\"%s\">\n%s\t</cim:JumperAction>".format (id, export_fields)
    }
}

object JumperAction
extends
    CIMParseable[JumperAction]
{
    override val fields: Array[String] = Array[String] (
        "kind",
        "AlongACLineSegments",
        "JumpedEquipments",
        "Jumper"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("AlongACLineSegments", "ACLineSegment", "0..*", "0..1"),
        CIMRelationship ("JumpedEquipments", "ConductingEquipment", "0..*", "0..1"),
        CIMRelationship ("Jumper", "Jumper", "0..1", "0..1")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val AlongACLineSegments: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val JumpedEquipments: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val Jumper: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): JumperAction =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = JumperAction (
            SwitchingAction.parse (context),
            mask (kind (), 0),
            masks (AlongACLineSegments (), 1),
            masks (JumpedEquipments (), 2),
            mask (Jumper (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[JumperAction] = JumperActionSerializer
}

object JumperActionSerializer extends CIMSerializer[JumperAction]
{
    def write (kryo: Kryo, output: Output, obj: JumperAction): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.kind),
            () => writeList (obj.AlongACLineSegments, output),
            () => writeList (obj.JumpedEquipments, output),
            () => output.writeString (obj.Jumper)
        )
        SwitchingActionSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[JumperAction]): JumperAction =
    {
        val parent = SwitchingActionSerializer.read (kryo, input, classOf[SwitchingAction])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = JumperAction (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Measurement taken as a switching step.
 *
 * @param SwitchingAction [[ch.ninecode.model.SwitchingAction SwitchingAction]] Reference to the superclass object.
 * @param Measurement [[ch.ninecode.model.Measurement Measurement]] <em>undocumented</em>
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class MeasurementAction
(
    SwitchingAction: SwitchingAction = null,
    Measurement: String = null
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
    override def sup: SwitchingAction = SwitchingAction

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
        implicit val clz: String = MeasurementAction.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MeasurementAction.fields (position), value)
        emitattr (0, Measurement)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MeasurementAction rdf:ID=\"%s\">\n%s\t</cim:MeasurementAction>".format (id, export_fields)
    }
}

object MeasurementAction
extends
    CIMParseable[MeasurementAction]
{
    override val fields: Array[String] = Array[String] (
        "Measurement"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Measurement", "Measurement", "0..1", "0..1")
    )
    val Measurement: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): MeasurementAction =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MeasurementAction (
            SwitchingAction.parse (context),
            mask (Measurement (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MeasurementAction] = MeasurementActionSerializer
}

object MeasurementActionSerializer extends CIMSerializer[MeasurementAction]
{
    def write (kryo: Kryo, output: Output, obj: MeasurementAction): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.Measurement)
        )
        SwitchingActionSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MeasurementAction]): MeasurementAction =
    {
        val parent = SwitchingActionSerializer.read (kryo, input, classOf[SwitchingAction])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MeasurementAction (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A document that can be associated with equipment to describe any sort of restrictions compared with the original manufacturer's specification or with the usual operational practice e.g. temporary maximum loadings, maximum switching current, do not operate if bus couplers are open, etc.
 *
 * In the UK, for example, if a breaker or switch ever mal-operates, this is reported centrally and utilities use their asset systems to identify all the installed devices of the same manufacturer's type. They then apply operational restrictions in the operational systems to warn operators of potential problems. After appropriate inspection and maintenance, the operational restrictions may be removed.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param activePeriod Interval during which this restriction is applied.
 * @param restrictedValue Restricted (new) value; includes unit of measure and potentially multiplier.
 * @param Equipments [[ch.ninecode.model.Equipment Equipment]] All equipments to which this restriction applies.
 * @param ProductAssetModel [[ch.ninecode.model.ProductAssetModel ProductAssetModel]] Asset model to which this restriction applies.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class OperationalRestriction
(
    Document: Document = null,
    activePeriod: String = null,
    restrictedValue: String = null,
    Equipments: List[String] = null,
    ProductAssetModel: String = null
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
    override def sup: Document = Document

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
        implicit val clz: String = OperationalRestriction.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OperationalRestriction.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (OperationalRestriction.fields (position), x))
        emitattr (0, activePeriod)
        emitattr (1, restrictedValue)
        emitattrs (2, Equipments)
        emitattr (3, ProductAssetModel)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OperationalRestriction rdf:ID=\"%s\">\n%s\t</cim:OperationalRestriction>".format (id, export_fields)
    }
}

object OperationalRestriction
extends
    CIMParseable[OperationalRestriction]
{
    override val fields: Array[String] = Array[String] (
        "activePeriod",
        "restrictedValue",
        "Equipments",
        "ProductAssetModel"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Equipments", "Equipment", "0..*", "0..*"),
        CIMRelationship ("ProductAssetModel", "ProductAssetModel", "0..1", "0..*")
    )
    val activePeriod: Fielder = parse_attribute (attribute (cls, fields(0)))
    val restrictedValue: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Equipments: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val ProductAssetModel: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): OperationalRestriction =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OperationalRestriction (
            Document.parse (context),
            mask (activePeriod (), 0),
            mask (restrictedValue (), 1),
            masks (Equipments (), 2),
            mask (ProductAssetModel (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OperationalRestriction] = OperationalRestrictionSerializer
}

object OperationalRestrictionSerializer extends CIMSerializer[OperationalRestriction]
{
    def write (kryo: Kryo, output: Output, obj: OperationalRestriction): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.activePeriod),
            () => output.writeString (obj.restrictedValue),
            () => writeList (obj.Equipments, output),
            () => output.writeString (obj.ProductAssetModel)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OperationalRestriction]): OperationalRestriction =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OperationalRestriction (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Operational tag placed on a power system resource or asset in the context of switching plan execution or other work in the field.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param Asset [[ch.ninecode.model.Asset Asset]] Asset on which this tag has been placed.
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Power system resource on which this tag has been placed.
 * @param TagAction [[ch.ninecode.model.TagAction TagAction]] Tag action associated with this tag.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class OperationalTag
(
    Document: Document = null,
    Asset: String = null,
    PowerSystemResource: String = null,
    TagAction: String = null
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
    override def sup: Document = Document

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
        implicit val clz: String = OperationalTag.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OperationalTag.fields (position), value)
        emitattr (0, Asset)
        emitattr (1, PowerSystemResource)
        emitattr (2, TagAction)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OperationalTag rdf:ID=\"%s\">\n%s\t</cim:OperationalTag>".format (id, export_fields)
    }
}

object OperationalTag
extends
    CIMParseable[OperationalTag]
{
    override val fields: Array[String] = Array[String] (
        "Asset",
        "PowerSystemResource",
        "TagAction"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Asset", "Asset", "0..1", "0..*"),
        CIMRelationship ("PowerSystemResource", "PowerSystemResource", "0..1", "0..*"),
        CIMRelationship ("TagAction", "TagAction", "0..1", "0..1")
    )
    val Asset: Fielder = parse_attribute (attribute (cls, fields(0)))
    val PowerSystemResource: Fielder = parse_attribute (attribute (cls, fields(1)))
    val TagAction: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): OperationalTag =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OperationalTag (
            Document.parse (context),
            mask (Asset (), 0),
            mask (PowerSystemResource (), 1),
            mask (TagAction (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OperationalTag] = OperationalTagSerializer
}

object OperationalTagSerializer extends CIMSerializer[OperationalTag]
{
    def write (kryo: Kryo, output: Output, obj: OperationalTag): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.Asset),
            () => output.writeString (obj.PowerSystemResource),
            () => output.writeString (obj.TagAction)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OperationalTag]): OperationalTag =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OperationalTag (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Lowered capability because of deterioration or inadequacy (sometimes referred to as derating or partial outage) or other kind of operational rating change.
 *
 * @param OperationalRestriction [[ch.ninecode.model.OperationalRestriction OperationalRestriction]] Reference to the superclass object.
 * @param changeType Type of operational updated rating, e.g. a derate, a rerate or a return to normal.
 * @param PlannedOutage [[ch.ninecode.model.PlannedOutage PlannedOutage]] Planned equipment outage with this updated rating.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class OperationalUpdatedRating
(
    OperationalRestriction: OperationalRestriction = null,
    changeType: String = null,
    PlannedOutage: String = null
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
    override def sup: OperationalRestriction = OperationalRestriction

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
        implicit val clz: String = OperationalUpdatedRating.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OperationalUpdatedRating.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OperationalUpdatedRating.fields (position), value)
        emitelem (0, changeType)
        emitattr (1, PlannedOutage)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OperationalUpdatedRating rdf:ID=\"%s\">\n%s\t</cim:OperationalUpdatedRating>".format (id, export_fields)
    }
}

object OperationalUpdatedRating
extends
    CIMParseable[OperationalUpdatedRating]
{
    override val fields: Array[String] = Array[String] (
        "changeType",
        "PlannedOutage"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("PlannedOutage", "PlannedOutage", "1", "0..*")
    )
    val changeType: Fielder = parse_element (element (cls, fields(0)))
    val PlannedOutage: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): OperationalUpdatedRating =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OperationalUpdatedRating (
            OperationalRestriction.parse (context),
            mask (changeType (), 0),
            mask (PlannedOutage (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OperationalUpdatedRating] = OperationalUpdatedRatingSerializer
}

object OperationalUpdatedRatingSerializer extends CIMSerializer[OperationalUpdatedRating]
{
    def write (kryo: Kryo, output: Output, obj: OperationalUpdatedRating): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.changeType),
            () => output.writeString (obj.PlannedOutage)
        )
        OperationalRestrictionSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OperationalUpdatedRating]): OperationalUpdatedRating =
    {
        val parent = OperationalRestrictionSerializer.read (kryo, input, classOf[OperationalRestriction])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OperationalUpdatedRating (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Operator with responsibility that the work in high voltage installation is executed in a safe manner and according to safety regulation.
 *
 * @param Operator [[ch.ninecode.model.Operator Operator]] Reference to the superclass object.
 * @param IssuedSafetyDocuments [[ch.ninecode.model.SafetyDocument SafetyDocument]] All safety documents issued by this supervisor.
 * @param ReleasedSafetyDocuments [[ch.ninecode.model.SafetyDocument SafetyDocument]] All safety documents released to this supervisor.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class OperationsSafetySupervisor
(
    Operator: Operator = null,
    IssuedSafetyDocuments: List[String] = null,
    ReleasedSafetyDocuments: List[String] = null
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
    override def sup: Operator = Operator

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
        implicit val clz: String = OperationsSafetySupervisor.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (OperationsSafetySupervisor.fields (position), x))
        emitattrs (0, IssuedSafetyDocuments)
        emitattrs (1, ReleasedSafetyDocuments)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OperationsSafetySupervisor rdf:ID=\"%s\">\n%s\t</cim:OperationsSafetySupervisor>".format (id, export_fields)
    }
}

object OperationsSafetySupervisor
extends
    CIMParseable[OperationsSafetySupervisor]
{
    override val fields: Array[String] = Array[String] (
        "IssuedSafetyDocuments",
        "ReleasedSafetyDocuments"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("IssuedSafetyDocuments", "SafetyDocument", "0..*", "0..1"),
        CIMRelationship ("ReleasedSafetyDocuments", "SafetyDocument", "0..*", "0..1")
    )
    val IssuedSafetyDocuments: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val ReleasedSafetyDocuments: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): OperationsSafetySupervisor =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OperationsSafetySupervisor (
            Operator.parse (context),
            masks (IssuedSafetyDocuments (), 0),
            masks (ReleasedSafetyDocuments (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OperationsSafetySupervisor] = OperationsSafetySupervisorSerializer
}

object OperationsSafetySupervisorSerializer extends CIMSerializer[OperationsSafetySupervisor]
{
    def write (kryo: Kryo, output: Output, obj: OperationsSafetySupervisor): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.IssuedSafetyDocuments, output),
            () => writeList (obj.ReleasedSafetyDocuments, output)
        )
        OperatorSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OperationsSafetySupervisor]): OperationsSafetySupervisor =
    {
        val parent = OperatorSerializer.read (kryo, input, classOf[Operator])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OperationsSafetySupervisor (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Document describing details of an active or planned outage in a part of the electrical network.
 *
 * A non-planned outage may be created upon:
 * - a breaker trip,
 * - a fault indicator status change,
 * - a meter event indicating customer outage,
 * - a reception of one or more customer trouble calls, or
 * - an operator command, reflecting information obtained from the field crew.
 * Outage restoration may be performed using a switching plan which complements the outage information with detailed switching activities, including the relationship to the crew and work.
 * A planned outage may be created upon:
 * - a request for service, maintenance or construction work in the field, or
 * - an operator-defined outage for what-if/contingency network analysis.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param actualPeriod Actual outage period; end of the period corresponds to the actual restoration time.
 * @param communityDescriptor a name to denote the community - this could be a name or a code of some kind.
 * @param customersRestored number of customers that have been restored in the area.
 * @param estimatedPeriod Estimated outage period for a planned outage.
 *        The start of the period is the start of the planned outage and the end of the period corresponds to the end of the planned outage.
 * @param metersAffected The updated number of meters affected by the outage as reported by the OMS within the utility.
 *        It is assumed this number will be updated repeatedly until the full outage is resolved.
 * @param originalCustomersServed the total number of customers that are served in the area (both outaged and not outaged).
 * @param originalMetersAffected The original number of meters that were affected as reported by the OMS within the utility.
 *        That is, this is the total number of meters that were out at the beginning of the outage.
 * @param outageKind Defines if the outage has been verified or is only estimated
 * @param statusKind defines the status of the crew as in dispatched or arrived, etc.
 * @param summary [[ch.ninecode.model.ServicePointOutageSummary ServicePointOutageSummary]] Summary counts of service points (customers) affected by this outage.
 * @param utilityDisclaimer This contains an disclaimers the utility would like to place on the data provided to any stakeholder.
 *        This may be different for different stakeholders.  This should possibly be an attribute under the Organization class but it is placed here for now.
 * @param Crew [[ch.ninecode.model.Crew Crew]] <em>undocumented</em>
 * @param DeEnergizedUsagePoint [[ch.ninecode.model.UsagePoint UsagePoint]] all deenergized useage points associated with the outage.
 * @param EnergizedUsagePoint [[ch.ninecode.model.UsagePoint UsagePoint]] All energized usage points associated with this outage.
 * @param Equipments [[ch.ninecode.model.Equipment Equipment]] All equipments associated with this outage.
 * @param EstimatedRestorationTime [[ch.ninecode.model.EstimatedRestorationTime EstimatedRestorationTime]] <em>undocumented</em>
 * @param Faults [[ch.ninecode.model.Fault Fault]] All faults involved in this outage.
 * @param Incident [[ch.ninecode.model.Incident Incident]] Incident reported in trouble call that results in this outage.
 * @param OpenedSwitches [[ch.ninecode.model.Switch Switch]] All potentially open switches causing this outage.
 *        This realationship is meant to be used as "indication" for initiation of outage-related business processes, whereas for actual actions of switches, SwitchAction-Switch relationship should be used.
 * @param OutageArea [[ch.ninecode.model.OutageArea OutageArea]] <em>undocumented</em>
 * @param PlannedSwitchActions [[ch.ninecode.model.SwitchAction SwitchAction]] All switch actions to apply within the scope of this planned outage.
 *        Each such action groups switches to which the action is to apply in order to produce the desired network state considered as outage.
 * @param SwitchingPlans [[ch.ninecode.model.SwitchingPlan SwitchingPlan]] All switching plans that lead to supply restoration due to this outage.
 *        Only one will be retained for execution.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class Outage
(
    Document: Document = null,
    actualPeriod: String = null,
    communityDescriptor: String = null,
    customersRestored: Int = 0,
    estimatedPeriod: String = null,
    metersAffected: Int = 0,
    originalCustomersServed: Int = 0,
    originalMetersAffected: Int = 0,
    outageKind: String = null,
    statusKind: String = null,
    summary: String = null,
    utilityDisclaimer: String = null,
    Crew: List[String] = null,
    DeEnergizedUsagePoint: List[String] = null,
    EnergizedUsagePoint: List[String] = null,
    Equipments: List[String] = null,
    EstimatedRestorationTime: String = null,
    Faults: List[String] = null,
    Incident: List[String] = null,
    OpenedSwitches: List[String] = null,
    OutageArea: List[String] = null,
    PlannedSwitchActions: List[String] = null,
    SwitchingPlans: List[String] = null
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
    override def sup: Document = Document

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
        implicit val clz: String = Outage.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Outage.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Outage.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Outage.fields (position), x))
        emitattr (0, actualPeriod)
        emitelem (1, communityDescriptor)
        emitelem (2, customersRestored)
        emitattr (3, estimatedPeriod)
        emitelem (4, metersAffected)
        emitelem (5, originalCustomersServed)
        emitelem (6, originalMetersAffected)
        emitattr (7, outageKind)
        emitattr (8, statusKind)
        emitattr (9, summary)
        emitelem (10, utilityDisclaimer)
        emitattrs (11, Crew)
        emitattrs (12, DeEnergizedUsagePoint)
        emitattrs (13, EnergizedUsagePoint)
        emitattrs (14, Equipments)
        emitattr (15, EstimatedRestorationTime)
        emitattrs (16, Faults)
        emitattrs (17, Incident)
        emitattrs (18, OpenedSwitches)
        emitattrs (19, OutageArea)
        emitattrs (20, PlannedSwitchActions)
        emitattrs (21, SwitchingPlans)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Outage rdf:ID=\"%s\">\n%s\t</cim:Outage>".format (id, export_fields)
    }
}

object Outage
extends
    CIMParseable[Outage]
{
    override val fields: Array[String] = Array[String] (
        "actualPeriod",
        "communityDescriptor",
        "customersRestored",
        "estimatedPeriod",
        "metersAffected",
        "originalCustomersServed",
        "originalMetersAffected",
        "outageKind",
        "statusKind",
        "summary",
        "utilityDisclaimer",
        "Crew",
        "DeEnergizedUsagePoint",
        "EnergizedUsagePoint",
        "Equipments",
        "EstimatedRestorationTime",
        "Faults",
        "Incident",
        "OpenedSwitches",
        "OutageArea",
        "PlannedSwitchActions",
        "SwitchingPlans"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("summary", "ServicePointOutageSummary", "0..1", "0..*"),
        CIMRelationship ("Crew", "Crew", "0..*", "0..*"),
        CIMRelationship ("DeEnergizedUsagePoint", "UsagePoint", "0..*", "0..*"),
        CIMRelationship ("EnergizedUsagePoint", "UsagePoint", "0..*", "0..*"),
        CIMRelationship ("Equipments", "Equipment", "0..*", "0..*"),
        CIMRelationship ("EstimatedRestorationTime", "EstimatedRestorationTime", "0..1", "0..*"),
        CIMRelationship ("Faults", "Fault", "0..*", "0..1"),
        CIMRelationship ("Incident", "Incident", "0..*", "0..1"),
        CIMRelationship ("OpenedSwitches", "Switch", "0..*", "0..1"),
        CIMRelationship ("OutageArea", "OutageArea", "0..*", "0..*"),
        CIMRelationship ("PlannedSwitchActions", "SwitchAction", "0..*", "0..1"),
        CIMRelationship ("SwitchingPlans", "SwitchingPlan", "0..*", "0..1")
    )
    val actualPeriod: Fielder = parse_attribute (attribute (cls, fields(0)))
    val communityDescriptor: Fielder = parse_element (element (cls, fields(1)))
    val customersRestored: Fielder = parse_element (element (cls, fields(2)))
    val estimatedPeriod: Fielder = parse_attribute (attribute (cls, fields(3)))
    val metersAffected: Fielder = parse_element (element (cls, fields(4)))
    val originalCustomersServed: Fielder = parse_element (element (cls, fields(5)))
    val originalMetersAffected: Fielder = parse_element (element (cls, fields(6)))
    val outageKind: Fielder = parse_attribute (attribute (cls, fields(7)))
    val statusKind: Fielder = parse_attribute (attribute (cls, fields(8)))
    val summary: Fielder = parse_attribute (attribute (cls, fields(9)))
    val utilityDisclaimer: Fielder = parse_element (element (cls, fields(10)))
    val Crew: FielderMultiple = parse_attributes (attribute (cls, fields(11)))
    val DeEnergizedUsagePoint: FielderMultiple = parse_attributes (attribute (cls, fields(12)))
    val EnergizedUsagePoint: FielderMultiple = parse_attributes (attribute (cls, fields(13)))
    val Equipments: FielderMultiple = parse_attributes (attribute (cls, fields(14)))
    val EstimatedRestorationTime: Fielder = parse_attribute (attribute (cls, fields(15)))
    val Faults: FielderMultiple = parse_attributes (attribute (cls, fields(16)))
    val Incident: FielderMultiple = parse_attributes (attribute (cls, fields(17)))
    val OpenedSwitches: FielderMultiple = parse_attributes (attribute (cls, fields(18)))
    val OutageArea: FielderMultiple = parse_attributes (attribute (cls, fields(19)))
    val PlannedSwitchActions: FielderMultiple = parse_attributes (attribute (cls, fields(20)))
    val SwitchingPlans: FielderMultiple = parse_attributes (attribute (cls, fields(21)))

    def parse (context: CIMContext): Outage =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = Outage (
            Document.parse (context),
            mask (actualPeriod (), 0),
            mask (communityDescriptor (), 1),
            toInteger (mask (customersRestored (), 2)),
            mask (estimatedPeriod (), 3),
            toInteger (mask (metersAffected (), 4)),
            toInteger (mask (originalCustomersServed (), 5)),
            toInteger (mask (originalMetersAffected (), 6)),
            mask (outageKind (), 7),
            mask (statusKind (), 8),
            mask (summary (), 9),
            mask (utilityDisclaimer (), 10),
            masks (Crew (), 11),
            masks (DeEnergizedUsagePoint (), 12),
            masks (EnergizedUsagePoint (), 13),
            masks (Equipments (), 14),
            mask (EstimatedRestorationTime (), 15),
            masks (Faults (), 16),
            masks (Incident (), 17),
            masks (OpenedSwitches (), 18),
            masks (OutageArea (), 19),
            masks (PlannedSwitchActions (), 20),
            masks (SwitchingPlans (), 21)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Outage] = OutageSerializer
}

object OutageSerializer extends CIMSerializer[Outage]
{
    def write (kryo: Kryo, output: Output, obj: Outage): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.actualPeriod),
            () => output.writeString (obj.communityDescriptor),
            () => output.writeInt (obj.customersRestored),
            () => output.writeString (obj.estimatedPeriod),
            () => output.writeInt (obj.metersAffected),
            () => output.writeInt (obj.originalCustomersServed),
            () => output.writeInt (obj.originalMetersAffected),
            () => output.writeString (obj.outageKind),
            () => output.writeString (obj.statusKind),
            () => output.writeString (obj.summary),
            () => output.writeString (obj.utilityDisclaimer),
            () => writeList (obj.Crew, output),
            () => writeList (obj.DeEnergizedUsagePoint, output),
            () => writeList (obj.EnergizedUsagePoint, output),
            () => writeList (obj.Equipments, output),
            () => output.writeString (obj.EstimatedRestorationTime),
            () => writeList (obj.Faults, output),
            () => writeList (obj.Incident, output),
            () => writeList (obj.OpenedSwitches, output),
            () => writeList (obj.OutageArea, output),
            () => writeList (obj.PlannedSwitchActions, output),
            () => writeList (obj.SwitchingPlans, output)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Outage]): Outage =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Outage (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readInt else 0,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readInt else 0,
            if (isSet (5)) input.readInt else 0,
            if (isSet (6)) input.readInt else 0,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) input.readString else null,
            if (isSet (11)) readList (input) else null,
            if (isSet (12)) readList (input) else null,
            if (isSet (13)) readList (input) else null,
            if (isSet (14)) readList (input) else null,
            if (isSet (15)) input.readString else null,
            if (isSet (16)) readList (input) else null,
            if (isSet (17)) readList (input) else null,
            if (isSet (18)) readList (input) else null,
            if (isSet (19)) readList (input) else null,
            if (isSet (20)) readList (input) else null,
            if (isSet (21)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * This defines the area covered by the Outage.
 *
 * @param Element Reference to the superclass object.
 * @param earliestReportedTime This is the reported time of the first outage report
 * @param metersServed defines the number of meters served in the defined area.
 * @param outageAreaKind defines the type of area that has the outage - county, state, zipcode, etc.
 * @param Outage [[ch.ninecode.model.Outage Outage]] <em>undocumented</em>
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class OutageArea
(
    Element: BasicElement = null,
    earliestReportedTime: String = null,
    metersServed: Int = 0,
    outageAreaKind: String = null,
    Outage: List[String] = null
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
        implicit val clz: String = OutageArea.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OutageArea.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OutageArea.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (OutageArea.fields (position), x))
        emitelem (0, earliestReportedTime)
        emitelem (1, metersServed)
        emitattr (2, outageAreaKind)
        emitattrs (3, Outage)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OutageArea rdf:ID=\"%s\">\n%s\t</cim:OutageArea>".format (id, export_fields)
    }
}

object OutageArea
extends
    CIMParseable[OutageArea]
{
    override val fields: Array[String] = Array[String] (
        "earliestReportedTime",
        "metersServed",
        "outageAreaKind",
        "Outage"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Outage", "Outage", "0..*", "0..*")
    )
    val earliestReportedTime: Fielder = parse_element (element (cls, fields(0)))
    val metersServed: Fielder = parse_element (element (cls, fields(1)))
    val outageAreaKind: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Outage: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: CIMContext): OutageArea =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OutageArea (
            BasicElement.parse (context),
            mask (earliestReportedTime (), 0),
            toInteger (mask (metersServed (), 1)),
            mask (outageAreaKind (), 2),
            masks (Outage (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OutageArea] = OutageAreaSerializer
}

object OutageAreaSerializer extends CIMSerializer[OutageArea]
{
    def write (kryo: Kryo, output: Output, obj: OutageArea): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.earliestReportedTime),
            () => output.writeInt (obj.metersServed),
            () => output.writeString (obj.outageAreaKind),
            () => writeList (obj.Outage, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OutageArea]): OutageArea =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OutageArea (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readInt else 0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Transmits an outage plan to a crew in order for the planned outage to be executed.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param comment Free-form comment associated with the outage order
 * @param Location [[ch.ninecode.model.Location Location]] <em>undocumented</em>
 * @param OutagePlan [[ch.ninecode.model.OutagePlan OutagePlan]] <em>undocumented</em>
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class OutageOrder
(
    Document: Document = null,
    comment: String = null,
    Location: List[String] = null,
    OutagePlan: String = null
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
    override def sup: Document = Document

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
        implicit val clz: String = OutageOrder.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OutageOrder.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OutageOrder.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (OutageOrder.fields (position), x))
        emitelem (0, comment)
        emitattrs (1, Location)
        emitattr (2, OutagePlan)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OutageOrder rdf:ID=\"%s\">\n%s\t</cim:OutageOrder>".format (id, export_fields)
    }
}

object OutageOrder
extends
    CIMParseable[OutageOrder]
{
    override val fields: Array[String] = Array[String] (
        "comment",
        "Location",
        "OutagePlan"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Location", "Location", "0..*", "0..1"),
        CIMRelationship ("OutagePlan", "OutagePlan", "0..1", "0..1")
    )
    val comment: Fielder = parse_element (element (cls, fields(0)))
    val Location: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val OutagePlan: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): OutageOrder =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OutageOrder (
            Document.parse (context),
            mask (comment (), 0),
            masks (Location (), 1),
            mask (OutagePlan (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OutageOrder] = OutageOrderSerializer
}

object OutageOrderSerializer extends CIMSerializer[OutageOrder]
{
    def write (kryo: Kryo, output: Output, obj: OutageOrder): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.comment),
            () => writeList (obj.Location, output),
            () => output.writeString (obj.OutagePlan)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OutageOrder]): OutageOrder =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OutageOrder (
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
 * Document containing the definition of planned outages of equipment and/or usage points.
 *
 * It will reference switching plans that are used to execute the planned outage.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param approvedDateTime The date and time the outage plan was approved
 * @param cancelledDateTime Date and Time the planned outage was canceled.
 * @param plannedPeriod planned start and end time of the planned outage.
 * @param purpose Purpose of  this outage plan, such as whether it is to replace equipment or perform maintenance or repairs or to reconfigure network topology.
 * @param Customer [[ch.ninecode.model.Customer Customer]] The customers that are affected by this planned outage.
 * @param OutageOrder [[ch.ninecode.model.OutageOrder OutageOrder]] <em>undocumented</em>
 * @param PlannedOutage [[ch.ninecode.model.PlannedOutage PlannedOutage]] The outage resulting from the execution of the outage plan.
 * @param SwitchingPlan [[ch.ninecode.model.SwitchingPlan SwitchingPlan]] The swiching plan that is associated with the outage plan.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class OutagePlan
(
    Document: Document = null,
    approvedDateTime: String = null,
    cancelledDateTime: String = null,
    plannedPeriod: String = null,
    purpose: String = null,
    Customer: List[String] = null,
    OutageOrder: String = null,
    PlannedOutage: String = null,
    SwitchingPlan: String = null
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
    override def sup: Document = Document

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
        implicit val clz: String = OutagePlan.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (OutagePlan.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OutagePlan.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (OutagePlan.fields (position), x))
        emitelem (0, approvedDateTime)
        emitelem (1, cancelledDateTime)
        emitattr (2, plannedPeriod)
        emitelem (3, purpose)
        emitattrs (4, Customer)
        emitattr (5, OutageOrder)
        emitattr (6, PlannedOutage)
        emitattr (7, SwitchingPlan)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OutagePlan rdf:ID=\"%s\">\n%s\t</cim:OutagePlan>".format (id, export_fields)
    }
}

object OutagePlan
extends
    CIMParseable[OutagePlan]
{
    override val fields: Array[String] = Array[String] (
        "approvedDateTime",
        "cancelledDateTime",
        "plannedPeriod",
        "purpose",
        "Customer",
        "OutageOrder",
        "PlannedOutage",
        "SwitchingPlan"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Customer", "Customer", "0..*", "0..1"),
        CIMRelationship ("OutageOrder", "OutageOrder", "0..1", "0..1"),
        CIMRelationship ("PlannedOutage", "PlannedOutage", "0..1", "0..1"),
        CIMRelationship ("SwitchingPlan", "SwitchingPlan", "0..1", "0..1")
    )
    val approvedDateTime: Fielder = parse_element (element (cls, fields(0)))
    val cancelledDateTime: Fielder = parse_element (element (cls, fields(1)))
    val plannedPeriod: Fielder = parse_attribute (attribute (cls, fields(2)))
    val purpose: Fielder = parse_element (element (cls, fields(3)))
    val Customer: FielderMultiple = parse_attributes (attribute (cls, fields(4)))
    val OutageOrder: Fielder = parse_attribute (attribute (cls, fields(5)))
    val PlannedOutage: Fielder = parse_attribute (attribute (cls, fields(6)))
    val SwitchingPlan: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: CIMContext): OutagePlan =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OutagePlan (
            Document.parse (context),
            mask (approvedDateTime (), 0),
            mask (cancelledDateTime (), 1),
            mask (plannedPeriod (), 2),
            mask (purpose (), 3),
            masks (Customer (), 4),
            mask (OutageOrder (), 5),
            mask (PlannedOutage (), 6),
            mask (SwitchingPlan (), 7)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OutagePlan] = OutagePlanSerializer
}

object OutagePlanSerializer extends CIMSerializer[OutagePlan]
{
    def write (kryo: Kryo, output: Output, obj: OutagePlan): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.approvedDateTime),
            () => output.writeString (obj.cancelledDateTime),
            () => output.writeString (obj.plannedPeriod),
            () => output.writeString (obj.purpose),
            () => writeList (obj.Customer, output),
            () => output.writeString (obj.OutageOrder),
            () => output.writeString (obj.PlannedOutage),
            () => output.writeString (obj.SwitchingPlan)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OutagePlan]): OutagePlan =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OutagePlan (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) readList (input) else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Event recording the change in operational status of a power system resource; may be for an event that has already occurred or for a planned activity.
 *
 * @param ActivityRecord [[ch.ninecode.model.ActivityRecord ActivityRecord]] Reference to the superclass object.
 * @param kind Kind of event.
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Power system resource that generated this event.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class PSREvent
(
    ActivityRecord: ActivityRecord = null,
    kind: String = null,
    PowerSystemResource: String = null
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
    override def sup: ActivityRecord = ActivityRecord

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
        implicit val clz: String = PSREvent.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PSREvent.fields (position), value)
        emitattr (0, kind)
        emitattr (1, PowerSystemResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PSREvent rdf:ID=\"%s\">\n%s\t</cim:PSREvent>".format (id, export_fields)
    }
}

object PSREvent
extends
    CIMParseable[PSREvent]
{
    override val fields: Array[String] = Array[String] (
        "kind",
        "PowerSystemResource"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("PowerSystemResource", "PowerSystemResource", "0..1", "0..*")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val PowerSystemResource: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): PSREvent =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PSREvent (
            ActivityRecord.parse (context),
            mask (kind (), 0),
            mask (PowerSystemResource (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[PSREvent] = PSREventSerializer
}

object PSREventSerializer extends CIMSerializer[PSREvent]
{
    def write (kryo: Kryo, output: Output, obj: PSREvent): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.kind),
            () => output.writeString (obj.PowerSystemResource)
        )
        ActivityRecordSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PSREvent]): PSREvent =
    {
        val parent = ActivityRecordSerializer.read (kryo, input, classOf[ActivityRecord])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PSREvent (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class PlannedOutage
(
    Outage: Outage = null,
    reason: String = null,
    FieldDispatchHistory: String = null,
    OutagePlan: String = null,
    UpdatedRatings: List[String] = null
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
    override def sup: Outage = Outage

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
        implicit val clz: String = PlannedOutage.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PlannedOutage.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PlannedOutage.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (PlannedOutage.fields (position), x))
        emitelem (0, reason)
        emitattr (1, FieldDispatchHistory)
        emitattr (2, OutagePlan)
        emitattrs (3, UpdatedRatings)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PlannedOutage rdf:ID=\"%s\">\n%s\t</cim:PlannedOutage>".format (id, export_fields)
    }
}

object PlannedOutage
extends
    CIMParseable[PlannedOutage]
{
    override val fields: Array[String] = Array[String] (
        "reason",
        "FieldDispatchHistory",
        "OutagePlan",
        "UpdatedRatings"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("FieldDispatchHistory", "FieldDispatchHistory", "0..1", "0..1"),
        CIMRelationship ("OutagePlan", "OutagePlan", "0..1", "0..1"),
        CIMRelationship ("UpdatedRatings", "OperationalUpdatedRating", "0..*", "1")
    )
    val reason: Fielder = parse_element (element (cls, fields(0)))
    val FieldDispatchHistory: Fielder = parse_attribute (attribute (cls, fields(1)))
    val OutagePlan: Fielder = parse_attribute (attribute (cls, fields(2)))
    val UpdatedRatings: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: CIMContext): PlannedOutage =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PlannedOutage (
            Outage.parse (context),
            mask (reason (), 0),
            mask (FieldDispatchHistory (), 1),
            mask (OutagePlan (), 2),
            masks (UpdatedRatings (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[PlannedOutage] = PlannedOutageSerializer
}

object PlannedOutageSerializer extends CIMSerializer[PlannedOutage]
{
    def write (kryo: Kryo, output: Output, obj: PlannedOutage): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.reason),
            () => output.writeString (obj.FieldDispatchHistory),
            () => output.writeString (obj.OutagePlan),
            () => writeList (obj.UpdatedRatings, output)
        )
        OutageSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PlannedOutage]): PlannedOutage =
    {
        val parent = OutageSerializer.read (kryo, input, classOf[Outage])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PlannedOutage (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Document restricting or authorising works on electrical equipment (for example a permit to work, sanction for test, limitation of access, or certificate of isolation), defined based upon organisational practices.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param issuedDateTime Date and time this safety document has been issued.
 * @param releasedDateTime Date and time this safety document has been released.
 * @param IssuedBySupervisor [[ch.ninecode.model.OperationsSafetySupervisor OperationsSafetySupervisor]] Supervisor that issued this safety document.
 * @param IssuedToSupervisor [[ch.ninecode.model.FieldSafetySupervisor FieldSafetySupervisor]] Supervisor to whom this safety document is issued.
 * @param ReleasedBySupervisor [[ch.ninecode.model.FieldSafetySupervisor FieldSafetySupervisor]] Supervisor that released this safety document.
 * @param ReleasedToSupervisor [[ch.ninecode.model.OperationsSafetySupervisor OperationsSafetySupervisor]] Supervisor to which this safety document is released.
 * @param SwitchingPlan [[ch.ninecode.model.SwitchingPlan SwitchingPlan]] Switching plan to which this safety document applies.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class SafetyDocument
(
    Document: Document = null,
    issuedDateTime: String = null,
    releasedDateTime: String = null,
    IssuedBySupervisor: String = null,
    IssuedToSupervisor: String = null,
    ReleasedBySupervisor: String = null,
    ReleasedToSupervisor: String = null,
    SwitchingPlan: String = null
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
    override def sup: Document = Document

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
        implicit val clz: String = SafetyDocument.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SafetyDocument.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SafetyDocument.fields (position), value)
        emitelem (0, issuedDateTime)
        emitelem (1, releasedDateTime)
        emitattr (2, IssuedBySupervisor)
        emitattr (3, IssuedToSupervisor)
        emitattr (4, ReleasedBySupervisor)
        emitattr (5, ReleasedToSupervisor)
        emitattr (6, SwitchingPlan)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SafetyDocument rdf:ID=\"%s\">\n%s\t</cim:SafetyDocument>".format (id, export_fields)
    }
}

object SafetyDocument
extends
    CIMParseable[SafetyDocument]
{
    override val fields: Array[String] = Array[String] (
        "issuedDateTime",
        "releasedDateTime",
        "IssuedBySupervisor",
        "IssuedToSupervisor",
        "ReleasedBySupervisor",
        "ReleasedToSupervisor",
        "SwitchingPlan"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("IssuedBySupervisor", "OperationsSafetySupervisor", "0..1", "0..*"),
        CIMRelationship ("IssuedToSupervisor", "FieldSafetySupervisor", "0..1", "0..*"),
        CIMRelationship ("ReleasedBySupervisor", "FieldSafetySupervisor", "0..1", "0..*"),
        CIMRelationship ("ReleasedToSupervisor", "OperationsSafetySupervisor", "0..1", "0..*"),
        CIMRelationship ("SwitchingPlan", "SwitchingPlan", "0..1", "0..*")
    )
    val issuedDateTime: Fielder = parse_element (element (cls, fields(0)))
    val releasedDateTime: Fielder = parse_element (element (cls, fields(1)))
    val IssuedBySupervisor: Fielder = parse_attribute (attribute (cls, fields(2)))
    val IssuedToSupervisor: Fielder = parse_attribute (attribute (cls, fields(3)))
    val ReleasedBySupervisor: Fielder = parse_attribute (attribute (cls, fields(4)))
    val ReleasedToSupervisor: Fielder = parse_attribute (attribute (cls, fields(5)))
    val SwitchingPlan: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: CIMContext): SafetyDocument =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SafetyDocument (
            Document.parse (context),
            mask (issuedDateTime (), 0),
            mask (releasedDateTime (), 1),
            mask (IssuedBySupervisor (), 2),
            mask (IssuedToSupervisor (), 3),
            mask (ReleasedBySupervisor (), 4),
            mask (ReleasedToSupervisor (), 5),
            mask (SwitchingPlan (), 6)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[SafetyDocument] = SafetyDocumentSerializer
}

object SafetyDocumentSerializer extends CIMSerializer[SafetyDocument]
{
    def write (kryo: Kryo, output: Output, obj: SafetyDocument): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.issuedDateTime),
            () => output.writeString (obj.releasedDateTime),
            () => output.writeString (obj.IssuedBySupervisor),
            () => output.writeString (obj.IssuedToSupervisor),
            () => output.writeString (obj.ReleasedBySupervisor),
            () => output.writeString (obj.ReleasedToSupervisor),
            () => output.writeString (obj.SwitchingPlan)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SafetyDocument]): SafetyDocument =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SafetyDocument (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Summary counts of service points affected by an outage.
 *
 * These counts are sometimes referred to as total and critical customer count.
 *
 * @param Element Reference to the superclass object.
 * @param criticalCount Number of critical service (delivery) points affected by an outage.
 * @param totalCount Number of all service (delivery) points affected by an outage.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class ServicePointOutageSummary
(
    Element: BasicElement = null,
    criticalCount: Int = 0,
    totalCount: Int = 0
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
        implicit val clz: String = ServicePointOutageSummary.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ServicePointOutageSummary.fields (position), value)
        emitelem (0, criticalCount)
        emitelem (1, totalCount)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ServicePointOutageSummary rdf:ID=\"%s\">\n%s\t</cim:ServicePointOutageSummary>".format (id, export_fields)
    }
}

object ServicePointOutageSummary
extends
    CIMParseable[ServicePointOutageSummary]
{
    override val fields: Array[String] = Array[String] (
        "criticalCount",
        "totalCount"
    )
    val criticalCount: Fielder = parse_element (element (cls, fields(0)))
    val totalCount: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: CIMContext): ServicePointOutageSummary =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ServicePointOutageSummary (
            BasicElement.parse (context),
            toInteger (mask (criticalCount (), 0)),
            toInteger (mask (totalCount (), 1))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ServicePointOutageSummary] = ServicePointOutageSummarySerializer
}

object ServicePointOutageSummarySerializer extends CIMSerializer[ServicePointOutageSummary]
{
    def write (kryo: Kryo, output: Output, obj: ServicePointOutageSummary): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeInt (obj.criticalCount),
            () => output.writeInt (obj.totalCount)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ServicePointOutageSummary]): ServicePointOutageSummary =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ServicePointOutageSummary (
            parent,
            if (isSet (0)) input.readInt else 0,
            if (isSet (1)) input.readInt else 0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Action on switch as a switching step.
 *
 * @param SwitchingAction [[ch.ninecode.model.SwitchingAction SwitchingAction]] Reference to the superclass object.
 * @param kind Switching action to perform.
 * @param OperatedSwitch [[ch.ninecode.model.Switch Switch]] Switch that is the object of this switch action.
 * @param PlannedOutage [[ch.ninecode.model.Outage Outage]] Planned outage for whose scope this switch action applies.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class SwitchAction
(
    SwitchingAction: SwitchingAction = null,
    kind: String = null,
    OperatedSwitch: String = null,
    PlannedOutage: String = null
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
    override def sup: SwitchingAction = SwitchingAction

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
        implicit val clz: String = SwitchAction.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SwitchAction.fields (position), value)
        emitattr (0, kind)
        emitattr (1, OperatedSwitch)
        emitattr (2, PlannedOutage)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SwitchAction rdf:ID=\"%s\">\n%s\t</cim:SwitchAction>".format (id, export_fields)
    }
}

object SwitchAction
extends
    CIMParseable[SwitchAction]
{
    override val fields: Array[String] = Array[String] (
        "kind",
        "OperatedSwitch",
        "PlannedOutage"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("OperatedSwitch", "Switch", "0..1", "0..1"),
        CIMRelationship ("PlannedOutage", "Outage", "0..1", "0..*")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val OperatedSwitch: Fielder = parse_attribute (attribute (cls, fields(1)))
    val PlannedOutage: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): SwitchAction =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SwitchAction (
            SwitchingAction.parse (context),
            mask (kind (), 0),
            mask (OperatedSwitch (), 1),
            mask (PlannedOutage (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[SwitchAction] = SwitchActionSerializer
}

object SwitchActionSerializer extends CIMSerializer[SwitchAction]
{
    def write (kryo: Kryo, output: Output, obj: SwitchAction): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.kind),
            () => output.writeString (obj.OperatedSwitch),
            () => output.writeString (obj.PlannedOutage)
        )
        SwitchingActionSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SwitchAction]): SwitchAction =
    {
        val parent = SwitchingActionSerializer.read (kryo, input, classOf[SwitchingAction])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SwitchAction (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Atomic switching action.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param description Free text description of this activity.
 * @param executedDateTime Actual date and time of this switching step.
 * @param isFreeSequence If true, the sequence number serves for presentation purposes only, and the activity itself may be executed at any time.
 * @param issuedDateTime Date and time when the crew was given the instruction to execute the action; not applicable if the action is performed by operator remote control.
 * @param plannedDateTime Planned date and time of this switching step.
 * @param Crew [[ch.ninecode.model.Crew Crew]] <em>undocumented</em>
 * @param Operator [[ch.ninecode.model.Operator Operator]] Operator responsible for this switching step.
 * @param SwitchingEvent [[ch.ninecode.model.SwitchingEvent SwitchingEvent]] <em>undocumented</em>
 * @param SwitchingStep [[ch.ninecode.model.SwitchingStep SwitchingStep]] <em>undocumented</em>
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class SwitchingAction
(
    IdentifiedObject: IdentifiedObject = null,
    description: String = null,
    executedDateTime: String = null,
    isFreeSequence: Boolean = false,
    issuedDateTime: String = null,
    plannedDateTime: String = null,
    Crew: List[String] = null,
    Operator: String = null,
    SwitchingEvent: String = null,
    SwitchingStep: String = null
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
        implicit val clz: String = SwitchingAction.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SwitchingAction.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SwitchingAction.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (SwitchingAction.fields (position), x))
        emitelem (0, description)
        emitelem (1, executedDateTime)
        emitelem (2, isFreeSequence)
        emitelem (3, issuedDateTime)
        emitelem (4, plannedDateTime)
        emitattrs (5, Crew)
        emitattr (6, Operator)
        emitattr (7, SwitchingEvent)
        emitattr (8, SwitchingStep)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SwitchingAction rdf:ID=\"%s\">\n%s\t</cim:SwitchingAction>".format (id, export_fields)
    }
}

object SwitchingAction
extends
    CIMParseable[SwitchingAction]
{
    override val fields: Array[String] = Array[String] (
        "description",
        "executedDateTime",
        "isFreeSequence",
        "issuedDateTime",
        "plannedDateTime",
        "Crew",
        "Operator",
        "SwitchingEvent",
        "SwitchingStep"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Crew", "Crew", "0..*", "1"),
        CIMRelationship ("Operator", "Operator", "0..1", "0..*"),
        CIMRelationship ("SwitchingEvent", "SwitchingEvent", "0..1", "1"),
        CIMRelationship ("SwitchingStep", "SwitchingStep", "0..1", "1")
    )
    val description: Fielder = parse_element (element (cls, fields(0)))
    val executedDateTime: Fielder = parse_element (element (cls, fields(1)))
    val isFreeSequence: Fielder = parse_element (element (cls, fields(2)))
    val issuedDateTime: Fielder = parse_element (element (cls, fields(3)))
    val plannedDateTime: Fielder = parse_element (element (cls, fields(4)))
    val Crew: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val Operator: Fielder = parse_attribute (attribute (cls, fields(6)))
    val SwitchingEvent: Fielder = parse_attribute (attribute (cls, fields(7)))
    val SwitchingStep: Fielder = parse_attribute (attribute (cls, fields(8)))

    def parse (context: CIMContext): SwitchingAction =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SwitchingAction (
            IdentifiedObject.parse (context),
            mask (description (), 0),
            mask (executedDateTime (), 1),
            toBoolean (mask (isFreeSequence (), 2)),
            mask (issuedDateTime (), 3),
            mask (plannedDateTime (), 4),
            masks (Crew (), 5),
            mask (Operator (), 6),
            mask (SwitchingEvent (), 7),
            mask (SwitchingStep (), 8)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[SwitchingAction] = SwitchingActionSerializer
}

object SwitchingActionSerializer extends CIMSerializer[SwitchingAction]
{
    def write (kryo: Kryo, output: Output, obj: SwitchingAction): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.description),
            () => output.writeString (obj.executedDateTime),
            () => output.writeBoolean (obj.isFreeSequence),
            () => output.writeString (obj.issuedDateTime),
            () => output.writeString (obj.plannedDateTime),
            () => writeList (obj.Crew, output),
            () => output.writeString (obj.Operator),
            () => output.writeString (obj.SwitchingEvent),
            () => output.writeString (obj.SwitchingStep)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SwitchingAction]): SwitchingAction =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SwitchingAction (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readBoolean else false,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Event indicating the completion (success or fail) of any switching action (jumper action, cut action, tag action, etc).
 *
 * The switching action may or may not be a consequential event in response to a request to complete the action.
 *
 * @param ActivityRecord [[ch.ninecode.model.ActivityRecord ActivityRecord]] Reference to the superclass object.
 * @param SwitchingAction [[ch.ninecode.model.SwitchingAction SwitchingAction]] <em>undocumented</em>
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class SwitchingEvent
(
    ActivityRecord: ActivityRecord = null,
    SwitchingAction: String = null
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
    override def sup: ActivityRecord = ActivityRecord

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
        implicit val clz: String = SwitchingEvent.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SwitchingEvent.fields (position), value)
        emitattr (0, SwitchingAction)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SwitchingEvent rdf:ID=\"%s\">\n%s\t</cim:SwitchingEvent>".format (id, export_fields)
    }
}

object SwitchingEvent
extends
    CIMParseable[SwitchingEvent]
{
    override val fields: Array[String] = Array[String] (
        "SwitchingAction"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("SwitchingAction", "SwitchingAction", "1", "0..1")
    )
    val SwitchingAction: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): SwitchingEvent =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SwitchingEvent (
            ActivityRecord.parse (context),
            mask (SwitchingAction (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[SwitchingEvent] = SwitchingEventSerializer
}

object SwitchingEventSerializer extends CIMSerializer[SwitchingEvent]
{
    def write (kryo: Kryo, output: Output, obj: SwitchingEvent): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.SwitchingAction)
        )
        ActivityRecordSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SwitchingEvent]): SwitchingEvent =
    {
        val parent = ActivityRecordSerializer.read (kryo, input, classOf[ActivityRecord])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SwitchingEvent (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Transmits a switching plan to a crew in order for the plan to be executed.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param comment Free-form comment associated with the switching order.
 * @param plannedExecutionInterval The planned start and end time for the switching order.
 * @param Location [[ch.ninecode.model.Location Location]] <em>undocumented</em>
 * @param SwitchingPlan [[ch.ninecode.model.SwitchingPlan SwitchingPlan]] <em>undocumented</em>
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class SwitchingOrder
(
    Document: Document = null,
    comment: String = null,
    plannedExecutionInterval: String = null,
    Location: List[String] = null,
    SwitchingPlan: String = null
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
    override def sup: Document = Document

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
        implicit val clz: String = SwitchingOrder.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SwitchingOrder.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SwitchingOrder.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (SwitchingOrder.fields (position), x))
        emitelem (0, comment)
        emitattr (1, plannedExecutionInterval)
        emitattrs (2, Location)
        emitattr (3, SwitchingPlan)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SwitchingOrder rdf:ID=\"%s\">\n%s\t</cim:SwitchingOrder>".format (id, export_fields)
    }
}

object SwitchingOrder
extends
    CIMParseable[SwitchingOrder]
{
    override val fields: Array[String] = Array[String] (
        "comment",
        "plannedExecutionInterval",
        "Location",
        "SwitchingPlan"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Location", "Location", "0..*", "0..1"),
        CIMRelationship ("SwitchingPlan", "SwitchingPlan", "0..1", "0..1")
    )
    val comment: Fielder = parse_element (element (cls, fields(0)))
    val plannedExecutionInterval: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Location: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val SwitchingPlan: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): SwitchingOrder =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SwitchingOrder (
            Document.parse (context),
            mask (comment (), 0),
            mask (plannedExecutionInterval (), 1),
            masks (Location (), 2),
            mask (SwitchingPlan (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[SwitchingOrder] = SwitchingOrderSerializer
}

object SwitchingOrderSerializer extends CIMSerializer[SwitchingOrder]
{
    def write (kryo: Kryo, output: Output, obj: SwitchingOrder): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.comment),
            () => output.writeString (obj.plannedExecutionInterval),
            () => writeList (obj.Location, output),
            () => output.writeString (obj.SwitchingPlan)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SwitchingOrder]): SwitchingOrder =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SwitchingOrder (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A sequence of grouped or atomic steps intended to:
 * - de-energise equipment or part of the network for safe work, and/or
 *
 * - bring back in service previously de-energised equipment or part of the network.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param approvedDateTime The date and time the switching plan was approved
 * @param cancelledDateTime Date and Time the switching plan was cancelled.
 * @param plannedPeriod the planned start and end times for the switching plan.
 * @param purpose Purpose of  this plan, such as whether it is to move the state from normal to some abnormal condition, or to restore the normal state after an abnormal condition, or to perform some kind of optimisation such as correction of overload, voltage control, etc.
 * @param rank Ranking in comparison to other switching plans.
 * @param Outage [[ch.ninecode.model.Outage Outage]] Outage that will be activated or eliminated when this switching plan gets executed.
 * @param OutagePlan [[ch.ninecode.model.OutagePlan OutagePlan]] The outage plan for which the switching plan is defined.
 * @param SafetyDocuments [[ch.ninecode.model.SafetyDocument SafetyDocument]] All safety documents applicable to this swtiching plan.
 * @param SwitchingOrder [[ch.ninecode.model.SwitchingOrder SwitchingOrder]] <em>undocumented</em>
 * @param SwitchingPlanRequest [[ch.ninecode.model.SwitchingPlanRequest SwitchingPlanRequest]] <em>undocumented</em>
 * @param SwitchingStepGroups [[ch.ninecode.model.SwitchingStepGroup SwitchingStepGroup]] All groups of switching steps within this switching plan.
 * @param WorkTasks [[ch.ninecode.model.WorkTask WorkTask]] All work tasks to execute this switching plan.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class SwitchingPlan
(
    Document: Document = null,
    approvedDateTime: String = null,
    cancelledDateTime: String = null,
    plannedPeriod: String = null,
    purpose: String = null,
    rank: Int = 0,
    Outage: String = null,
    OutagePlan: String = null,
    SafetyDocuments: List[String] = null,
    SwitchingOrder: String = null,
    SwitchingPlanRequest: String = null,
    SwitchingStepGroups: List[String] = null,
    WorkTasks: List[String] = null
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
    override def sup: Document = Document

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
        implicit val clz: String = SwitchingPlan.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SwitchingPlan.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SwitchingPlan.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (SwitchingPlan.fields (position), x))
        emitelem (0, approvedDateTime)
        emitelem (1, cancelledDateTime)
        emitattr (2, plannedPeriod)
        emitelem (3, purpose)
        emitelem (4, rank)
        emitattr (5, Outage)
        emitattr (6, OutagePlan)
        emitattrs (7, SafetyDocuments)
        emitattr (8, SwitchingOrder)
        emitattr (9, SwitchingPlanRequest)
        emitattrs (10, SwitchingStepGroups)
        emitattrs (11, WorkTasks)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SwitchingPlan rdf:ID=\"%s\">\n%s\t</cim:SwitchingPlan>".format (id, export_fields)
    }
}

object SwitchingPlan
extends
    CIMParseable[SwitchingPlan]
{
    override val fields: Array[String] = Array[String] (
        "approvedDateTime",
        "cancelledDateTime",
        "plannedPeriod",
        "purpose",
        "rank",
        "Outage",
        "OutagePlan",
        "SafetyDocuments",
        "SwitchingOrder",
        "SwitchingPlanRequest",
        "SwitchingStepGroups",
        "WorkTasks"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Outage", "Outage", "0..1", "0..*"),
        CIMRelationship ("OutagePlan", "OutagePlan", "0..1", "0..1"),
        CIMRelationship ("SafetyDocuments", "SafetyDocument", "0..*", "0..1"),
        CIMRelationship ("SwitchingOrder", "SwitchingOrder", "0..1", "0..1"),
        CIMRelationship ("SwitchingPlanRequest", "SwitchingPlanRequest", "0..1", "0..*"),
        CIMRelationship ("SwitchingStepGroups", "SwitchingStepGroup", "0..*", "0..1"),
        CIMRelationship ("WorkTasks", "WorkTask", "0..*", "0..1")
    )
    val approvedDateTime: Fielder = parse_element (element (cls, fields(0)))
    val cancelledDateTime: Fielder = parse_element (element (cls, fields(1)))
    val plannedPeriod: Fielder = parse_attribute (attribute (cls, fields(2)))
    val purpose: Fielder = parse_element (element (cls, fields(3)))
    val rank: Fielder = parse_element (element (cls, fields(4)))
    val Outage: Fielder = parse_attribute (attribute (cls, fields(5)))
    val OutagePlan: Fielder = parse_attribute (attribute (cls, fields(6)))
    val SafetyDocuments: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val SwitchingOrder: Fielder = parse_attribute (attribute (cls, fields(8)))
    val SwitchingPlanRequest: Fielder = parse_attribute (attribute (cls, fields(9)))
    val SwitchingStepGroups: FielderMultiple = parse_attributes (attribute (cls, fields(10)))
    val WorkTasks: FielderMultiple = parse_attributes (attribute (cls, fields(11)))

    def parse (context: CIMContext): SwitchingPlan =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SwitchingPlan (
            Document.parse (context),
            mask (approvedDateTime (), 0),
            mask (cancelledDateTime (), 1),
            mask (plannedPeriod (), 2),
            mask (purpose (), 3),
            toInteger (mask (rank (), 4)),
            mask (Outage (), 5),
            mask (OutagePlan (), 6),
            masks (SafetyDocuments (), 7),
            mask (SwitchingOrder (), 8),
            mask (SwitchingPlanRequest (), 9),
            masks (SwitchingStepGroups (), 10),
            masks (WorkTasks (), 11)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[SwitchingPlan] = SwitchingPlanSerializer
}

object SwitchingPlanSerializer extends CIMSerializer[SwitchingPlan]
{
    def write (kryo: Kryo, output: Output, obj: SwitchingPlan): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.approvedDateTime),
            () => output.writeString (obj.cancelledDateTime),
            () => output.writeString (obj.plannedPeriod),
            () => output.writeString (obj.purpose),
            () => output.writeInt (obj.rank),
            () => output.writeString (obj.Outage),
            () => output.writeString (obj.OutagePlan),
            () => writeList (obj.SafetyDocuments, output),
            () => output.writeString (obj.SwitchingOrder),
            () => output.writeString (obj.SwitchingPlanRequest),
            () => writeList (obj.SwitchingStepGroups, output),
            () => writeList (obj.WorkTasks, output)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SwitchingPlan]): SwitchingPlan =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SwitchingPlan (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readInt else 0,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) readList (input) else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) readList (input) else null,
            if (isSet (11)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A document used to request that a switching plan be created for a particular purpose.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param comment Free-form text to describe the request
 * @param equipmentToBeIsolated free-form list of the equipment to be isolated by the switching
 * @param forwardSwitchingDateTimeInterval <em>undocumented</em>
 * @param groundingPoints free-form list of equipment to be grounded or other actions to be taken in order to accomplish the required grounding.
 * @param isolationArea free-form description of the area to be isolated by the switching
 * @param isolationPoints free-form list of equipment to be operated or other actions to be taken in order to accomplish the required isolation.
 * @param outageDateTimeInterval The window of time during which one or more customers will be de-energized during execution of the switching plan.
 * @param purpose <em>undocumented</em>
 * @param reverseSwitchingDateTimeInterval <em>undocumented</em>
 * @param switchingRequestDetails <em>undocumented</em>
 * @param RequestingOrganization [[ch.ninecode.model.Organisation Organisation]] <em>undocumented</em>
 * @param SwitchingPlan [[ch.ninecode.model.SwitchingPlan SwitchingPlan]] <em>undocumented</em>
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class SwitchingPlanRequest
(
    Document: Document = null,
    comment: String = null,
    equipmentToBeIsolated: String = null,
    forwardSwitchingDateTimeInterval: String = null,
    groundingPoints: String = null,
    isolationArea: String = null,
    isolationPoints: String = null,
    outageDateTimeInterval: String = null,
    purpose: String = null,
    reverseSwitchingDateTimeInterval: String = null,
    switchingRequestDetails: String = null,
    RequestingOrganization: String = null,
    SwitchingPlan: List[String] = null
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
    override def sup: Document = Document

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
        implicit val clz: String = SwitchingPlanRequest.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SwitchingPlanRequest.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SwitchingPlanRequest.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (SwitchingPlanRequest.fields (position), x))
        emitelem (0, comment)
        emitelem (1, equipmentToBeIsolated)
        emitattr (2, forwardSwitchingDateTimeInterval)
        emitelem (3, groundingPoints)
        emitelem (4, isolationArea)
        emitelem (5, isolationPoints)
        emitattr (6, outageDateTimeInterval)
        emitelem (7, purpose)
        emitattr (8, reverseSwitchingDateTimeInterval)
        emitelem (9, switchingRequestDetails)
        emitattr (10, RequestingOrganization)
        emitattrs (11, SwitchingPlan)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SwitchingPlanRequest rdf:ID=\"%s\">\n%s\t</cim:SwitchingPlanRequest>".format (id, export_fields)
    }
}

object SwitchingPlanRequest
extends
    CIMParseable[SwitchingPlanRequest]
{
    override val fields: Array[String] = Array[String] (
        "comment",
        "equipmentToBeIsolated",
        "forwardSwitchingDateTimeInterval",
        "groundingPoints",
        "isolationArea",
        "isolationPoints",
        "outageDateTimeInterval",
        "purpose",
        "reverseSwitchingDateTimeInterval",
        "switchingRequestDetails",
        "RequestingOrganization",
        "SwitchingPlan"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("RequestingOrganization", "Organisation", "0..1", "0..*"),
        CIMRelationship ("SwitchingPlan", "SwitchingPlan", "0..*", "0..1")
    )
    val comment: Fielder = parse_element (element (cls, fields(0)))
    val equipmentToBeIsolated: Fielder = parse_element (element (cls, fields(1)))
    val forwardSwitchingDateTimeInterval: Fielder = parse_attribute (attribute (cls, fields(2)))
    val groundingPoints: Fielder = parse_element (element (cls, fields(3)))
    val isolationArea: Fielder = parse_element (element (cls, fields(4)))
    val isolationPoints: Fielder = parse_element (element (cls, fields(5)))
    val outageDateTimeInterval: Fielder = parse_attribute (attribute (cls, fields(6)))
    val purpose: Fielder = parse_element (element (cls, fields(7)))
    val reverseSwitchingDateTimeInterval: Fielder = parse_attribute (attribute (cls, fields(8)))
    val switchingRequestDetails: Fielder = parse_element (element (cls, fields(9)))
    val RequestingOrganization: Fielder = parse_attribute (attribute (cls, fields(10)))
    val SwitchingPlan: FielderMultiple = parse_attributes (attribute (cls, fields(11)))

    def parse (context: CIMContext): SwitchingPlanRequest =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SwitchingPlanRequest (
            Document.parse (context),
            mask (comment (), 0),
            mask (equipmentToBeIsolated (), 1),
            mask (forwardSwitchingDateTimeInterval (), 2),
            mask (groundingPoints (), 3),
            mask (isolationArea (), 4),
            mask (isolationPoints (), 5),
            mask (outageDateTimeInterval (), 6),
            mask (purpose (), 7),
            mask (reverseSwitchingDateTimeInterval (), 8),
            mask (switchingRequestDetails (), 9),
            mask (RequestingOrganization (), 10),
            masks (SwitchingPlan (), 11)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[SwitchingPlanRequest] = SwitchingPlanRequestSerializer
}

object SwitchingPlanRequestSerializer extends CIMSerializer[SwitchingPlanRequest]
{
    def write (kryo: Kryo, output: Output, obj: SwitchingPlanRequest): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.comment),
            () => output.writeString (obj.equipmentToBeIsolated),
            () => output.writeString (obj.forwardSwitchingDateTimeInterval),
            () => output.writeString (obj.groundingPoints),
            () => output.writeString (obj.isolationArea),
            () => output.writeString (obj.isolationPoints),
            () => output.writeString (obj.outageDateTimeInterval),
            () => output.writeString (obj.purpose),
            () => output.writeString (obj.reverseSwitchingDateTimeInterval),
            () => output.writeString (obj.switchingRequestDetails),
            () => output.writeString (obj.RequestingOrganization),
            () => writeList (obj.SwitchingPlan, output)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SwitchingPlanRequest]): SwitchingPlanRequest =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SwitchingPlanRequest (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) input.readString else null,
            if (isSet (11)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Atomic switching step; can be part of a switching step group, or part of a switching plan.
 *
 * @param Element Reference to the superclass object.
 * @param sequenceNumber Order of this activity in the sequence of activities within the switching plan.
 * @param SwitchingAction [[ch.ninecode.model.SwitchingAction SwitchingAction]] <em>undocumented</em>
 * @param SwitchingStepGroup [[ch.ninecode.model.SwitchingStepGroup SwitchingStepGroup]] <em>undocumented</em>
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class SwitchingStep
(
    Element: BasicElement = null,
    sequenceNumber: Int = 0,
    SwitchingAction: String = null,
    SwitchingStepGroup: String = null
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
        implicit val clz: String = SwitchingStep.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SwitchingStep.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SwitchingStep.fields (position), value)
        emitelem (0, sequenceNumber)
        emitattr (1, SwitchingAction)
        emitattr (2, SwitchingStepGroup)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SwitchingStep rdf:ID=\"%s\">\n%s\t</cim:SwitchingStep>".format (id, export_fields)
    }
}

object SwitchingStep
extends
    CIMParseable[SwitchingStep]
{
    override val fields: Array[String] = Array[String] (
        "sequenceNumber",
        "SwitchingAction",
        "SwitchingStepGroup"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("SwitchingAction", "SwitchingAction", "1", "0..1"),
        CIMRelationship ("SwitchingStepGroup", "SwitchingStepGroup", "0..1", "0..*")
    )
    val sequenceNumber: Fielder = parse_element (element (cls, fields(0)))
    val SwitchingAction: Fielder = parse_attribute (attribute (cls, fields(1)))
    val SwitchingStepGroup: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): SwitchingStep =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SwitchingStep (
            BasicElement.parse (context),
            toInteger (mask (sequenceNumber (), 0)),
            mask (SwitchingAction (), 1),
            mask (SwitchingStepGroup (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[SwitchingStep] = SwitchingStepSerializer
}

object SwitchingStepSerializer extends CIMSerializer[SwitchingStep]
{
    def write (kryo: Kryo, output: Output, obj: SwitchingStep): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeInt (obj.sequenceNumber),
            () => output.writeString (obj.SwitchingAction),
            () => output.writeString (obj.SwitchingStepGroup)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SwitchingStep]): SwitchingStep =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SwitchingStep (
            parent,
            if (isSet (0)) input.readInt else 0,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A logical step, grouping atomic switching steps that are important to distinguish when they may change topology (e.g. placing a jumper between two cuts).
 *
 * @param Element Reference to the superclass object.
 * @param description Descriptive information concerning the switching step group.
 * @param isFreeSequence If true, the sequence number serves for presentation purposes only, and the activity itself may be executed at any time.
 * @param purpose Describes the overall purpose of the steps in this switching step group.
 * @param sequenceNumber Order of this activity in the sequence of activities within the switching plan.
 * @param SwitchingPlan [[ch.ninecode.model.SwitchingPlan SwitchingPlan]] Switching plan to which this group belongs.
 * @param SwitchingStep [[ch.ninecode.model.SwitchingStep SwitchingStep]] <em>undocumented</em>
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class SwitchingStepGroup
(
    Element: BasicElement = null,
    description: String = null,
    isFreeSequence: Boolean = false,
    purpose: String = null,
    sequenceNumber: Int = 0,
    SwitchingPlan: String = null,
    SwitchingStep: List[String] = null
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
        implicit val clz: String = SwitchingStepGroup.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SwitchingStepGroup.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SwitchingStepGroup.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (SwitchingStepGroup.fields (position), x))
        emitelem (0, description)
        emitelem (1, isFreeSequence)
        emitelem (2, purpose)
        emitelem (3, sequenceNumber)
        emitattr (4, SwitchingPlan)
        emitattrs (5, SwitchingStep)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SwitchingStepGroup rdf:ID=\"%s\">\n%s\t</cim:SwitchingStepGroup>".format (id, export_fields)
    }
}

object SwitchingStepGroup
extends
    CIMParseable[SwitchingStepGroup]
{
    override val fields: Array[String] = Array[String] (
        "description",
        "isFreeSequence",
        "purpose",
        "sequenceNumber",
        "SwitchingPlan",
        "SwitchingStep"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("SwitchingPlan", "SwitchingPlan", "0..1", "0..*"),
        CIMRelationship ("SwitchingStep", "SwitchingStep", "0..*", "0..1")
    )
    val description: Fielder = parse_element (element (cls, fields(0)))
    val isFreeSequence: Fielder = parse_element (element (cls, fields(1)))
    val purpose: Fielder = parse_element (element (cls, fields(2)))
    val sequenceNumber: Fielder = parse_element (element (cls, fields(3)))
    val SwitchingPlan: Fielder = parse_attribute (attribute (cls, fields(4)))
    val SwitchingStep: FielderMultiple = parse_attributes (attribute (cls, fields(5)))

    def parse (context: CIMContext): SwitchingStepGroup =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SwitchingStepGroup (
            BasicElement.parse (context),
            mask (description (), 0),
            toBoolean (mask (isFreeSequence (), 1)),
            mask (purpose (), 2),
            toInteger (mask (sequenceNumber (), 3)),
            mask (SwitchingPlan (), 4),
            masks (SwitchingStep (), 5)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[SwitchingStepGroup] = SwitchingStepGroupSerializer
}

object SwitchingStepGroupSerializer extends CIMSerializer[SwitchingStepGroup]
{
    def write (kryo: Kryo, output: Output, obj: SwitchingStepGroup): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.description),
            () => output.writeBoolean (obj.isFreeSequence),
            () => output.writeString (obj.purpose),
            () => output.writeInt (obj.sequenceNumber),
            () => output.writeString (obj.SwitchingPlan),
            () => writeList (obj.SwitchingStep, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SwitchingStepGroup]): SwitchingStepGroup =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SwitchingStepGroup (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readBoolean else false,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readInt else 0,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Action on operation tag as a switching step.
 *
 * @param SwitchingAction [[ch.ninecode.model.SwitchingAction SwitchingAction]] Reference to the superclass object.
 * @param kind Kind of tag action.
 * @param OperationalTag [[ch.ninecode.model.OperationalTag OperationalTag]] Tag associated with this tag action.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class TagAction
(
    SwitchingAction: SwitchingAction = null,
    kind: String = null,
    OperationalTag: String = null
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
    override def sup: SwitchingAction = SwitchingAction

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
        implicit val clz: String = TagAction.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TagAction.fields (position), value)
        emitattr (0, kind)
        emitattr (1, OperationalTag)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TagAction rdf:ID=\"%s\">\n%s\t</cim:TagAction>".format (id, export_fields)
    }
}

object TagAction
extends
    CIMParseable[TagAction]
{
    override val fields: Array[String] = Array[String] (
        "kind",
        "OperationalTag"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("OperationalTag", "OperationalTag", "0..1", "0..1")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields(0)))
    val OperationalTag: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): TagAction =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TagAction (
            SwitchingAction.parse (context),
            mask (kind (), 0),
            mask (OperationalTag (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[TagAction] = TagActionSerializer
}

object TagActionSerializer extends CIMSerializer[TagAction]
{
    def write (kryo: Kryo, output: Output, obj: TagAction): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.kind),
            () => output.writeString (obj.OperationalTag)
        )
        SwitchingActionSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TagAction]): TagAction =
    {
        val parent = SwitchingActionSerializer.read (kryo, input, classOf[SwitchingAction])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TagAction (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Trouble order sends an incident to a crew to initiate a response to an unplanned outage.
 *
 * @param Document [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param comment Free-form comment associated with the trouble order.
 * @param plannedExecutionInterval The planned start and end time for the trouble order.
 * @param Incident [[ch.ninecode.model.Incident Incident]] <em>undocumented</em>
 * @param Location [[ch.ninecode.model.Location Location]] <em>undocumented</em>
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class TroubleOrder
(
    Document: Document = null,
    comment: String = null,
    plannedExecutionInterval: String = null,
    Incident: String = null,
    Location: String = null
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
    override def sup: Document = Document

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
        implicit val clz: String = TroubleOrder.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TroubleOrder.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TroubleOrder.fields (position), value)
        emitelem (0, comment)
        emitattr (1, plannedExecutionInterval)
        emitattr (2, Incident)
        emitattr (3, Location)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TroubleOrder rdf:ID=\"%s\">\n%s\t</cim:TroubleOrder>".format (id, export_fields)
    }
}

object TroubleOrder
extends
    CIMParseable[TroubleOrder]
{
    override val fields: Array[String] = Array[String] (
        "comment",
        "plannedExecutionInterval",
        "Incident",
        "Location"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Incident", "Incident", "0..1", "0..1"),
        CIMRelationship ("Location", "Location", "0..1", "0..1")
    )
    val comment: Fielder = parse_element (element (cls, fields(0)))
    val plannedExecutionInterval: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Incident: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Location: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): TroubleOrder =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TroubleOrder (
            Document.parse (context),
            mask (comment (), 0),
            mask (plannedExecutionInterval (), 1),
            mask (Incident (), 2),
            mask (Location (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[TroubleOrder] = TroubleOrderSerializer
}

object TroubleOrderSerializer extends CIMSerializer[TroubleOrder]
{
    def write (kryo: Kryo, output: Output, obj: TroubleOrder): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.comment),
            () => output.writeString (obj.plannedExecutionInterval),
            () => output.writeString (obj.Incident),
            () => output.writeString (obj.Location)
        )
        DocumentSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TroubleOrder]): TroubleOrder =
    {
        val parent = DocumentSerializer.read (kryo, input, classOf[Document])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TroubleOrder (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Document describing the consequence of an unplanned outage in a part of the electrical network.
 *
 * For the purposes of this model, an unplanned outage refers to a state where energy is not delivered; such as, customers out of service, a street light is not served, etc.
 * A unplanned outage may be created upon:
 * - impacts the SAIDI calculation
 * - a breaker trip,
 * - a fault indicator status change,
 * - a meter event indicating customer outage,
 * - a reception of one or more customer trouble calls, or
 * - an operator command, reflecting information obtained from the field crew.
 * Outage restoration may be performed using a switching plan which complements the outage information with detailed switching activities, including the relationship to the crew and work.
 *
 * @param Outage [[ch.ninecode.model.Outage Outage]] Reference to the superclass object.
 * @param cause The cause of this outage.
 *        This is the cause that is used to present to external entities.  That is, the cause is weather, equipment failure, etc.
 *        
 *        Note: At present, this is a free text; could be replaced with a separate associated class in case we have multiple causes (e.g. OutageCauseType, inheriting from IdentifiedObject).
 * @param causeKind <em>undocumented</em>
 * @param reportedStartTime The earliest start time of the Outage - as reported by some system or individual
 * @param FieldDispatchHistory [[ch.ninecode.model.FieldDispatchHistory FieldDispatchHistory]] <em>undocumented</em>
 * @param TroubleTicket [[ch.ninecode.model.TroubleTicket TroubleTicket]] <em>undocumented</em>
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class UnplannedOutage
(
    Outage: Outage = null,
    cause: String = null,
    causeKind: String = null,
    reportedStartTime: String = null,
    FieldDispatchHistory: String = null,
    TroubleTicket: List[String] = null
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
    override def sup: Outage = Outage

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
        implicit val clz: String = UnplannedOutage.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (UnplannedOutage.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (UnplannedOutage.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (UnplannedOutage.fields (position), x))
        emitelem (0, cause)
        emitattr (1, causeKind)
        emitelem (2, reportedStartTime)
        emitattr (3, FieldDispatchHistory)
        emitattrs (4, TroubleTicket)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:UnplannedOutage rdf:ID=\"%s\">\n%s\t</cim:UnplannedOutage>".format (id, export_fields)
    }
}

object UnplannedOutage
extends
    CIMParseable[UnplannedOutage]
{
    override val fields: Array[String] = Array[String] (
        "cause",
        "causeKind",
        "reportedStartTime",
        "FieldDispatchHistory",
        "TroubleTicket"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("FieldDispatchHistory", "FieldDispatchHistory", "0..1", "0..1"),
        CIMRelationship ("TroubleTicket", "TroubleTicket", "0..*", "0..1")
    )
    val cause: Fielder = parse_element (element (cls, fields(0)))
    val causeKind: Fielder = parse_attribute (attribute (cls, fields(1)))
    val reportedStartTime: Fielder = parse_element (element (cls, fields(2)))
    val FieldDispatchHistory: Fielder = parse_attribute (attribute (cls, fields(3)))
    val TroubleTicket: FielderMultiple = parse_attributes (attribute (cls, fields(4)))

    def parse (context: CIMContext): UnplannedOutage =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = UnplannedOutage (
            Outage.parse (context),
            mask (cause (), 0),
            mask (causeKind (), 1),
            mask (reportedStartTime (), 2),
            mask (FieldDispatchHistory (), 3),
            masks (TroubleTicket (), 4)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[UnplannedOutage] = UnplannedOutageSerializer
}

object UnplannedOutageSerializer extends CIMSerializer[UnplannedOutage]
{
    def write (kryo: Kryo, output: Output, obj: UnplannedOutage): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.cause),
            () => output.writeString (obj.causeKind),
            () => output.writeString (obj.reportedStartTime),
            () => output.writeString (obj.FieldDispatchHistory),
            () => writeList (obj.TroubleTicket, output)
        )
        OutageSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[UnplannedOutage]): UnplannedOutage =
    {
        val parent = OutageSerializer.read (kryo, input, classOf[Outage])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = UnplannedOutage (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Verification of a switch position or other condition as a switching step
 *
 * @param SwitchingAction [[ch.ninecode.model.SwitchingAction SwitchingAction]] Reference to the superclass object.
 * @param verificationCondition freeform description of the condition to be verified
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] <em>undocumented</em>
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
final case class VerificationAction
(
    SwitchingAction: SwitchingAction = null,
    verificationCondition: String = null,
    PowerSystemResource: String = null
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
    override def sup: SwitchingAction = SwitchingAction

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
        implicit val clz: String = VerificationAction.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (VerificationAction.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (VerificationAction.fields (position), value)
        emitelem (0, verificationCondition)
        emitattr (1, PowerSystemResource)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:VerificationAction rdf:ID=\"%s\">\n%s\t</cim:VerificationAction>".format (id, export_fields)
    }
}

object VerificationAction
extends
    CIMParseable[VerificationAction]
{
    override val fields: Array[String] = Array[String] (
        "verificationCondition",
        "PowerSystemResource"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("PowerSystemResource", "PowerSystemResource", "0..1", "0..*")
    )
    val verificationCondition: Fielder = parse_element (element (cls, fields(0)))
    val PowerSystemResource: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): VerificationAction =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = VerificationAction (
            SwitchingAction.parse (context),
            mask (verificationCondition (), 0),
            mask (PowerSystemResource (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[VerificationAction] = VerificationActionSerializer
}

object VerificationActionSerializer extends CIMSerializer[VerificationAction]
{
    def write (kryo: Kryo, output: Output, obj: VerificationAction): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.verificationCondition),
            () => output.writeString (obj.PowerSystemResource)
        )
        SwitchingActionSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[VerificationAction]): VerificationAction =
    {
        val parent = SwitchingActionSerializer.read (kryo, input, classOf[SwitchingAction])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = VerificationAction (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _Operations
{
    def register: List[CIMClassInfo] =
    {
        List (
            ClearanceAction.register,
            ClearanceDocument.register,
            ControlAction.register,
            CutAction.register,
            EnergySourceAction.register,
            EstimatedRestorationTime.register,
            FieldSafetySupervisor.register,
            GenericAction.register,
            GroundAction.register,
            Incident.register,
            JumperAction.register,
            MeasurementAction.register,
            OperationalRestriction.register,
            OperationalTag.register,
            OperationalUpdatedRating.register,
            OperationsSafetySupervisor.register,
            Outage.register,
            OutageArea.register,
            OutageOrder.register,
            OutagePlan.register,
            PSREvent.register,
            PlannedOutage.register,
            SafetyDocument.register,
            ServicePointOutageSummary.register,
            SwitchAction.register,
            SwitchingAction.register,
            SwitchingEvent.register,
            SwitchingOrder.register,
            SwitchingPlan.register,
            SwitchingPlanRequest.register,
            SwitchingStep.register,
            SwitchingStepGroup.register,
            TagAction.register,
            TroubleOrder.register,
            UnplannedOutage.register,
            VerificationAction.register
        )
    }
}
package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * Action on clearance document as a switching step.
 *
 * @param sup                [[ch.ninecode.model.SwitchingStep SwitchingStep]] Reference to the superclass object.
 * @param kind               Clearance action to perform.
 * @param Clearance          [[ch.ninecode.model.ClearanceDocument ClearanceDocument]] Clearance associated with this clearance action.
 * @param SwitchingStepGroup [[ch.ninecode.model.SwitchingStepGroup SwitchingStepGroup]] Group to which this step belongs.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
case class ClearanceAction
(
    override val sup: SwitchingStep,
    kind: String,
    Clearance: String,
    SwitchingStepGroup: String
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def SwitchingStep: SwitchingStep = sup.asInstanceOf [SwitchingStep]

    override def copy (): Row =
    {
        clone ().asInstanceOf [ClearanceAction]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ClearanceAction.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ClearanceAction.fields (position), value)

        emitattr (0, kind)
        emitattr (1, Clearance)
        emitattr (2, SwitchingStepGroup)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ClearanceAction rdf:ID=\"%s\">\n%s\t</cim:ClearanceAction>".format (id, export_fields)
    }
}

object ClearanceAction
    extends
        Parseable[ClearanceAction]
{
    override val fields: Array[String] = Array [String](
        "kind",
        "Clearance",
        "SwitchingStepGroup"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Clearance", "ClearanceDocument", "0..1", "0..1"),
        Relationship ("SwitchingStepGroup", "SwitchingStepGroup", "0..1", "0..*")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields (0)))
    val Clearance: Fielder = parse_attribute (attribute (cls, fields (1)))
    val SwitchingStepGroup: Fielder = parse_attribute (attribute (cls, fields (2)))

    def parse (context: Context): ClearanceAction =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = ClearanceAction (
            SwitchingStep.parse (context),
            mask (kind (), 0),
            mask (Clearance (), 1),
            mask (SwitchingStepGroup (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Safety document used to authorise work on conducting equipment in the field.
 *
 * Tagged equipment is not allowed to be operated.
 *
 * @param sup               [[ch.ninecode.model.SafetyDocument SafetyDocument]] Reference to the superclass object.
 * @param mustBeDeenergised If true, the equipment must be deenergised.
 * @param mustBeGrounded    If true, the equipment must be grounded.
 * @param ClearanceAction   [[ch.ninecode.model.ClearanceAction ClearanceAction]] Clearance action associated with this clearance.
 * @param TaggedPSRs        [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] All power system resources tagged through this clearance.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
case class ClearanceDocument
(
    override val sup: SafetyDocument,
    mustBeDeenergised: Boolean,
    mustBeGrounded: Boolean,
    ClearanceAction: String,
    TaggedPSRs: List[String]
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, false, false, null, List ())
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def SafetyDocument: SafetyDocument = sup.asInstanceOf [SafetyDocument]

    override def copy (): Row =
    {
        clone ().asInstanceOf [ClearanceDocument]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ClearanceDocument.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ClearanceDocument.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ClearanceDocument.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (ClearanceDocument.fields (position), x))

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
        Parseable[ClearanceDocument]
{
    override val fields: Array[String] = Array [String](
        "mustBeDeenergised",
        "mustBeGrounded",
        "ClearanceAction",
        "TaggedPSRs"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ClearanceAction", "ClearanceAction", "0..1", "0..1"),
        Relationship ("TaggedPSRs", "PowerSystemResource", "0..*", "0..*")
    )
    val mustBeDeenergised: Fielder = parse_element (element (cls, fields (0)))
    val mustBeGrounded: Fielder = parse_element (element (cls, fields (1)))
    val ClearanceAction: Fielder = parse_attribute (attribute (cls, fields (2)))
    val TaggedPSRs: FielderMultiple = parse_attributes (attribute (cls, fields (3)))

    def parse (context: Context): ClearanceDocument =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
}

/**
 * Action on cut as a switching step.
 *
 * @param sup                [[ch.ninecode.model.SwitchingStep SwitchingStep]] Reference to the superclass object.
 * @param kind               Switching action to perform.
 * @param Cut                [[ch.ninecode.model.Cut Cut]] Cut on which this action is taken.
 * @param SwitchingStepGroup [[ch.ninecode.model.SwitchingStepGroup SwitchingStepGroup]] Group to which this step belongs.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
case class CutAction
(
    override val sup: SwitchingStep,
    kind: String,
    Cut: String,
    SwitchingStepGroup: String
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def SwitchingStep: SwitchingStep = sup.asInstanceOf [SwitchingStep]

    override def copy (): Row =
    {
        clone ().asInstanceOf [CutAction]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CutAction.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CutAction.fields (position), value)

        emitattr (0, kind)
        emitattr (1, Cut)
        emitattr (2, SwitchingStepGroup)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:CutAction rdf:ID=\"%s\">\n%s\t</cim:CutAction>".format (id, export_fields)
    }
}

object CutAction
    extends
        Parseable[CutAction]
{
    override val fields: Array[String] = Array [String](
        "kind",
        "Cut",
        "SwitchingStepGroup"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Cut", "Cut", "0..1", "0..1"),
        Relationship ("SwitchingStepGroup", "SwitchingStepGroup", "0..1", "0..*")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields (0)))
    val Cut: Fielder = parse_attribute (attribute (cls, fields (1)))
    val SwitchingStepGroup: Fielder = parse_attribute (attribute (cls, fields (2)))

    def parse (context: Context): CutAction =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = CutAction (
            SwitchingStep.parse (context),
            mask (kind (), 0),
            mask (Cut (), 1),
            mask (SwitchingStepGroup (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Action on energy source as a switching step.
 *
 * @param sup                [[ch.ninecode.model.SwitchingStep SwitchingStep]] Reference to the superclass object.
 * @param kind               Switching action to perform.
 * @param EnergySource       [[ch.ninecode.model.EnergySource EnergySource]] Energy source on which this action is taken.
 * @param SwitchingStepGroup [[ch.ninecode.model.SwitchingStepGroup SwitchingStepGroup]] Group to which this step belongs.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
case class EnergySourceAction
(
    override val sup: SwitchingStep,
    kind: String,
    EnergySource: String,
    SwitchingStepGroup: String
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def SwitchingStep: SwitchingStep = sup.asInstanceOf [SwitchingStep]

    override def copy (): Row =
    {
        clone ().asInstanceOf [EnergySourceAction]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EnergySourceAction.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnergySourceAction.fields (position), value)

        emitattr (0, kind)
        emitattr (1, EnergySource)
        emitattr (2, SwitchingStepGroup)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:EnergySourceAction rdf:ID=\"%s\">\n%s\t</cim:EnergySourceAction>".format (id, export_fields)
    }
}

object EnergySourceAction
    extends
        Parseable[EnergySourceAction]
{
    override val fields: Array[String] = Array [String](
        "kind",
        "EnergySource",
        "SwitchingStepGroup"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EnergySource", "EnergySource", "0..1", "0..1"),
        Relationship ("SwitchingStepGroup", "SwitchingStepGroup", "0..1", "0..*")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields (0)))
    val EnergySource: Fielder = parse_attribute (attribute (cls, fields (1)))
    val SwitchingStepGroup: Fielder = parse_attribute (attribute (cls, fields (2)))

    def parse (context: Context): EnergySourceAction =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = EnergySourceAction (
            SwitchingStep.parse (context),
            mask (kind (), 0),
            mask (EnergySource (), 1),
            mask (SwitchingStepGroup (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * An arbitrary switching step.
 *
 * @param sup                [[ch.ninecode.model.SwitchingStep SwitchingStep]] Reference to the superclass object.
 * @param SwitchingStepGroup [[ch.ninecode.model.SwitchingStepGroup SwitchingStepGroup]] Group to which this step belongs.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
case class GenericAction
(
    override val sup: SwitchingStep,
    SwitchingStepGroup: String
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def SwitchingStep: SwitchingStep = sup.asInstanceOf [SwitchingStep]

    override def copy (): Row =
    {
        clone ().asInstanceOf [GenericAction]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GenericAction.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (GenericAction.fields (position), value)

        emitattr (0, SwitchingStepGroup)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:GenericAction rdf:ID=\"%s\">\n%s\t</cim:GenericAction>".format (id, export_fields)
    }
}

object GenericAction
    extends
        Parseable[GenericAction]
{
    override val fields: Array[String] = Array [String](
        "SwitchingStepGroup"
    )
    override val relations: List[Relationship] = List (
        Relationship ("SwitchingStepGroup", "SwitchingStepGroup", "0..1", "0..*")
    )
    val SwitchingStepGroup: Fielder = parse_attribute (attribute (cls, fields (0)))

    def parse (context: Context): GenericAction =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = GenericAction (
            SwitchingStep.parse (context),
            mask (SwitchingStepGroup (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Action on ground as a switching step.
 *
 * @param sup                [[ch.ninecode.model.SwitchingStep SwitchingStep]] Reference to the superclass object.
 * @param kind               Switching action to perform.
 * @param AlongACLineSegment [[ch.ninecode.model.ACLineSegment ACLineSegment]] The line segment that this ground action will affect.
 *                           This is the only way to access relationship to clamp in case the ground needs to be placed along the line segment.
 * @param Ground             [[ch.ninecode.model.Ground Ground]] Ground on which this action is taken.
 * @param GroundedEquipment  [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] Equipment being grounded with this operation.
 *                           In case of placing a ground anywhere along a line segment, you must use the clamp (to get the distance from one terminal), so use the explicit relation with line segment. In all other cases (including placing the ground at a line segment terminal), reference to one or more conducting equipment is sufficient.
 * @param SwitchingStepGroup [[ch.ninecode.model.SwitchingStepGroup SwitchingStepGroup]] Group to which this step belongs.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
case class GroundAction
(
    override val sup: SwitchingStep,
    kind: String,
    AlongACLineSegment: String,
    Ground: String,
    GroundedEquipment: String,
    SwitchingStepGroup: String
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, null, null, null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def SwitchingStep: SwitchingStep = sup.asInstanceOf [SwitchingStep]

    override def copy (): Row =
    {
        clone ().asInstanceOf [GroundAction]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GroundAction.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (GroundAction.fields (position), value)

        emitattr (0, kind)
        emitattr (1, AlongACLineSegment)
        emitattr (2, Ground)
        emitattr (3, GroundedEquipment)
        emitattr (4, SwitchingStepGroup)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:GroundAction rdf:ID=\"%s\">\n%s\t</cim:GroundAction>".format (id, export_fields)
    }
}

object GroundAction
    extends
        Parseable[GroundAction]
{
    override val fields: Array[String] = Array [String](
        "kind",
        "AlongACLineSegment",
        "Ground",
        "GroundedEquipment",
        "SwitchingStepGroup"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AlongACLineSegment", "ACLineSegment", "0..1", "0..1"),
        Relationship ("Ground", "Ground", "0..1", "0..1"),
        Relationship ("GroundedEquipment", "ConductingEquipment", "0..1", "0..1"),
        Relationship ("SwitchingStepGroup", "SwitchingStepGroup", "0..1", "0..*")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields (0)))
    val AlongACLineSegment: Fielder = parse_attribute (attribute (cls, fields (1)))
    val Ground: Fielder = parse_attribute (attribute (cls, fields (2)))
    val GroundedEquipment: Fielder = parse_attribute (attribute (cls, fields (3)))
    val SwitchingStepGroup: Fielder = parse_attribute (attribute (cls, fields (4)))

    def parse (context: Context): GroundAction =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = GroundAction (
            SwitchingStep.parse (context),
            mask (kind (), 0),
            mask (AlongACLineSegment (), 1),
            mask (Ground (), 2),
            mask (GroundedEquipment (), 3),
            mask (SwitchingStepGroup (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Description of a problem in the field that may be reported in a trouble ticket or come from another source.
 *
 * It may have to do with an outage.
 *
 * @param sup                   [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param cause                 Cause of this incident.
 * @param CustomerNotifications [[ch.ninecode.model.CustomerNotification CustomerNotification]] All notifications for a customer related to the status change of this incident.
 * @param Hazards               [[ch.ninecode.model.IncidentHazard IncidentHazard]] All hazards associated with this incident.
 * @param Outage                [[ch.ninecode.model.Outage Outage]] Outage for this incident.
 * @param Owner                 [[ch.ninecode.model.Operator Operator]] Operator who owns this incident.
 * @param TroubleTickets        [[ch.ninecode.model.TroubleTicket TroubleTicket]] All trouble tickets reporting this incident.
 * @param Works                 [[ch.ninecode.model.Work Work]] All works addressing this incident.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
case class Incident
(
    override val sup: Document,
    cause: String,
    CustomerNotifications: List[String],
    Hazards: List[String],
    Outage: String,
    Owner: String,
    TroubleTickets: List[String],
    Works: List[String]
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, List (), List (), null, null, List (), List ())
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Document: Document = sup.asInstanceOf [Document]

    override def copy (): Row =
    {
        clone ().asInstanceOf [Incident]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Incident.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Incident.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Incident.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (Incident.fields (position), x))

        emitelem (0, cause)
        emitattrs (1, CustomerNotifications)
        emitattrs (2, Hazards)
        emitattr (3, Outage)
        emitattr (4, Owner)
        emitattrs (5, TroubleTickets)
        emitattrs (6, Works)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Incident rdf:ID=\"%s\">\n%s\t</cim:Incident>".format (id, export_fields)
    }
}

object Incident
    extends
        Parseable[Incident]
{
    override val fields: Array[String] = Array [String](
        "cause",
        "CustomerNotifications",
        "Hazards",
        "Outage",
        "Owner",
        "TroubleTickets",
        "Works"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CustomerNotifications", "CustomerNotification", "0..*", "0..1"),
        Relationship ("Hazards", "IncidentHazard", "0..*", "0..1"),
        Relationship ("Outage", "Outage", "0..1", "0..1"),
        Relationship ("Owner", "Operator", "0..1", "0..*"),
        Relationship ("TroubleTickets", "TroubleTicket", "0..*", "0..1"),
        Relationship ("Works", "Work", "0..*", "0..*")
    )
    val cause: Fielder = parse_element (element (cls, fields (0)))
    val CustomerNotifications: FielderMultiple = parse_attributes (attribute (cls, fields (1)))
    val Hazards: FielderMultiple = parse_attributes (attribute (cls, fields (2)))
    val Outage: Fielder = parse_attribute (attribute (cls, fields (3)))
    val Owner: Fielder = parse_attribute (attribute (cls, fields (4)))
    val TroubleTickets: FielderMultiple = parse_attributes (attribute (cls, fields (5)))
    val Works: FielderMultiple = parse_attributes (attribute (cls, fields (6)))

    def parse (context: Context): Incident =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = Incident (
            Document.parse (context),
            mask (cause (), 0),
            masks (CustomerNotifications (), 1),
            masks (Hazards (), 2),
            mask (Outage (), 3),
            mask (Owner (), 4),
            masks (TroubleTickets (), 5),
            masks (Works (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Action on jumper as a switching step.
 *
 * @param sup                 [[ch.ninecode.model.SwitchingStep SwitchingStep]] Reference to the superclass object.
 * @param kind                Switching action to perform.
 * @param AlongACLineSegments [[ch.ninecode.model.ACLineSegment ACLineSegment]] The line segment that this jumper action will affect.
 *                            This is the only way to access relationship to clamp in case the jumper needs to connect along the line segment.
 * @param JumpedEquipments    [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] The conducting equipment that this jumper action will affect.
 *                            In case of placing a jumper anywhere along a line segment, you must use the clamp (to get the distance from one terminal), so use the explicit relation with line segment. In all other cases (including placing the jumper at a line segment terminal), reference to one or more conducting equipment is sufficient.
 * @param Jumper              [[ch.ninecode.model.Jumper Jumper]] Jumper on which this action is taken.
 * @param SwitchingStepGroup  [[ch.ninecode.model.SwitchingStepGroup SwitchingStepGroup]] Group to which this step belongs.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
case class JumperAction
(
    override val sup: SwitchingStep,
    kind: String,
    AlongACLineSegments: List[String],
    JumpedEquipments: List[String],
    Jumper: String,
    SwitchingStepGroup: String
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, List (), List (), null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def SwitchingStep: SwitchingStep = sup.asInstanceOf [SwitchingStep]

    override def copy (): Row =
    {
        clone ().asInstanceOf [JumperAction]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = JumperAction.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (JumperAction.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (JumperAction.fields (position), x))

        emitattr (0, kind)
        emitattrs (1, AlongACLineSegments)
        emitattrs (2, JumpedEquipments)
        emitattr (3, Jumper)
        emitattr (4, SwitchingStepGroup)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:JumperAction rdf:ID=\"%s\">\n%s\t</cim:JumperAction>".format (id, export_fields)
    }
}

object JumperAction
    extends
        Parseable[JumperAction]
{
    override val fields: Array[String] = Array [String](
        "kind",
        "AlongACLineSegments",
        "JumpedEquipments",
        "Jumper",
        "SwitchingStepGroup"
    )
    override val relations: List[Relationship] = List (
        Relationship ("AlongACLineSegments", "ACLineSegment", "0..*", "0..1"),
        Relationship ("JumpedEquipments", "ConductingEquipment", "0..*", "0..1"),
        Relationship ("Jumper", "Jumper", "0..1", "0..1"),
        Relationship ("SwitchingStepGroup", "SwitchingStepGroup", "0..1", "0..*")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields (0)))
    val AlongACLineSegments: FielderMultiple = parse_attributes (attribute (cls, fields (1)))
    val JumpedEquipments: FielderMultiple = parse_attributes (attribute (cls, fields (2)))
    val Jumper: Fielder = parse_attribute (attribute (cls, fields (3)))
    val SwitchingStepGroup: Fielder = parse_attribute (attribute (cls, fields (4)))

    def parse (context: Context): JumperAction =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = JumperAction (
            SwitchingStep.parse (context),
            mask (kind (), 0),
            masks (AlongACLineSegments (), 1),
            masks (JumpedEquipments (), 2),
            mask (Jumper (), 3),
            mask (SwitchingStepGroup (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 *
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
case class OperationTag
(
    override val sup: Document,
    Asset: String,
    PowerSystemResource: String,
    TagAction: String
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Document: Document = sup.asInstanceOf [Document]

    override def copy (): Row =
    {
        clone ().asInstanceOf [OperationTag]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OperationTag.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OperationTag.fields (position), value)

        emitattr (0, Asset)
        emitattr (1, PowerSystemResource)
        emitattr (2, TagAction)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:OperationTag rdf:ID=\"%s\">\n%s\t</cim:OperationTag>".format (id, export_fields)
    }
}

object OperationTag
    extends
        Parseable[OperationTag]
{
    override val fields: Array[String] = Array [String](
        "Asset",
        "PowerSystemResource",
        "TagAction"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Asset", "Asset", "0..1", "0..*"),
        Relationship ("PowerSystemResource", "PowerSystemResource", "0..1", "0..*"),
        Relationship ("TagAction", "TagAction", "0..1", "0..1")
    )
    val Asset: Fielder = parse_attribute (attribute (cls, fields (0)))
    val PowerSystemResource: Fielder = parse_attribute (attribute (cls, fields (1)))
    val TagAction: Fielder = parse_attribute (attribute (cls, fields (2)))

    def parse (context: Context): OperationTag =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = OperationTag (
            Document.parse (context),
            mask (Asset (), 0),
            mask (PowerSystemResource (), 1),
            mask (TagAction (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A document that can be associated with equipment to describe any sort of restrictions compared with the original manufacturer's specification or with the usual operational practice e.g. temporary maximum loadings, maximum switching current, do not operate if bus couplers are open, etc.
 *
 * In the UK, for example, if a breaker or switch ever mal-operates, this is reported centrally and utilities use their asset systems to identify all the installed devices of the same manufacturer's type. They then apply operational restrictions in the operational systems to warn operators of potential problems. After appropriate inspection and maintenance, the operational restrictions may be removed.
 *
 * @param sup               [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param activePeriod      Interval during which this restriction is applied.
 * @param restrictedValue   Restricted (new) value; includes unit of measure and potentially multiplier.
 * @param Equipments        [[ch.ninecode.model.Equipment Equipment]] All equipments to which this restriction applies.
 * @param ProductAssetModel [[ch.ninecode.model.ProductAssetModel ProductAssetModel]] Asset model to which this restriction applies.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
case class OperationalRestriction
(
    override val sup: Document,
    activePeriod: String,
    restrictedValue: String,
    Equipments: List[String],
    ProductAssetModel: String
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, null, List (), null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Document: Document = sup.asInstanceOf [Document]

    override def copy (): Row =
    {
        clone ().asInstanceOf [OperationalRestriction]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OperationalRestriction.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OperationalRestriction.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (OperationalRestriction.fields (position), x))

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
        Parseable[OperationalRestriction]
{
    override val fields: Array[String] = Array [String](
        "activePeriod",
        "restrictedValue",
        "Equipments",
        "ProductAssetModel"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Equipments", "Equipment", "0..*", "0..*"),
        Relationship ("ProductAssetModel", "ProductAssetModel", "0..1", "0..*")
    )
    val activePeriod: Fielder = parse_attribute (attribute (cls, fields (0)))
    val restrictedValue: Fielder = parse_attribute (attribute (cls, fields (1)))
    val Equipments: FielderMultiple = parse_attributes (attribute (cls, fields (2)))
    val ProductAssetModel: Fielder = parse_attribute (attribute (cls, fields (3)))

    def parse (context: Context): OperationalRestriction =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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
}

/**
 * Lowered capability because of deterioration or inadequacy (sometimes referred to as derating or partial outage) or other kind of operational rating change.
 *
 * @param sup           [[ch.ninecode.model.OperationalRestriction OperationalRestriction]] Reference to the superclass object.
 * @param changeType    Type of operational updated rating, e.g. a derate, a rerate or a return to normal.
 * @param PlannedOutage [[ch.ninecode.model.Outage Outage]] Planned equipment outage with this updated rating.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
case class OperationalUpdatedRating
(
    override val sup: OperationalRestriction,
    changeType: String,
    PlannedOutage: String
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def OperationalRestriction: OperationalRestriction = sup.asInstanceOf [OperationalRestriction]

    override def copy (): Row =
    {
        clone ().asInstanceOf [OperationalUpdatedRating]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

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
        Parseable[OperationalUpdatedRating]
{
    override val fields: Array[String] = Array [String](
        "changeType",
        "PlannedOutage"
    )
    override val relations: List[Relationship] = List (
        Relationship ("PlannedOutage", "Outage", "1", "0..*")
    )
    val changeType: Fielder = parse_element (element (cls, fields (0)))
    val PlannedOutage: Fielder = parse_attribute (attribute (cls, fields (1)))

    def parse (context: Context): OperationalUpdatedRating =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = OperationalUpdatedRating (
            OperationalRestriction.parse (context),
            mask (changeType (), 0),
            mask (PlannedOutage (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Document describing details of an active or planned outage in a part of the electrical network.
 *
 * A non-planned outage may be created upon:
 *
 * @param sup                  [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param actualPeriod         Actual outage period; end of the period corresponds to the actual restoration time.
 * @param cancelledDateTime    Date and time planned outage has been cancelled.
 * @param cause                One or more causes of this outage.
 *                             Note: At present, this is a free text; could be replaced with a separate associated class in case we have multiple causes (e.g. OutageCauseType, inheriting from IdentifiedObject).
 * @param estimatedPeriod      Estimated outage period.
 *                             The start of the period makes sense in case of a planned outage only, whereas the end of the period corresponds to the estimated restoration time in general.
 * @param isPlanned            True if planned, false otherwise (for example due to a breaker trip).
 * @param summary              [[ch.ninecode.model.ServicePointOutageSummary ServicePointOutageSummary]] Summary counts of service points (customers) affected by this outage.
 * @param Equipments           [[ch.ninecode.model.Equipment Equipment]] All equipments associated with this outage.
 * @param Faults               [[ch.ninecode.model.Fault Fault]] All faults involved in this outage.
 * @param Incident             [[ch.ninecode.model.Incident Incident]] Incident reported in trouble call that results in this outage.
 * @param OpenedSwitches       [[ch.ninecode.model.Switch Switch]] All potentially open switches causing this outage.
 *                             This realationship is meant to be used as "indication" for initiation of outage-related business processes, whereas for actual actions of switches, SwitchAction-Switch relationship should be used.
 * @param OutageSchedule       [[ch.ninecode.model.OutageSchedule OutageSchedule]] Outage schedule whose execution will result in this outage.
 * @param PlannedSwitchActions [[ch.ninecode.model.SwitchAction SwitchAction]] All switch actions to apply within the scope of this planned outage.
 *                             Each such action groups switches to which the action is to apply in order to produce the desired network state considered as outage.
 * @param SwitchingPlans       [[ch.ninecode.model.SwitchingPlan SwitchingPlan]] All switching plans that lead to supply restoration due to this outage.
 *                             Only one will be retained for execution.
 * @param UpdatedRatings       [[ch.ninecode.model.OperationalUpdatedRating OperationalUpdatedRating]] All updated ratings for this planned equipment outage.
 * @param UsagePoints          [[ch.ninecode.model.UsagePoint UsagePoint]] All usage points associated with this outage.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
case class Outage
(
    override val sup: Document,
    actualPeriod: String,
    cancelledDateTime: String,
    cause: String,
    estimatedPeriod: String,
    isPlanned: Boolean,
    summary: String,
    Equipments: List[String],
    Faults: List[String],
    Incident: String,
    OpenedSwitches: List[String],
    OutageSchedule: String,
    PlannedSwitchActions: List[String],
    SwitchingPlans: List[String],
    UpdatedRatings: List[String],
    UsagePoints: List[String]
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, null, null, null, false, null, List (), List (), null, List (), null, List (), List (), List (), List ())
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Document: Document = sup.asInstanceOf [Document]

    override def copy (): Row =
    {
        clone ().asInstanceOf [Outage]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Outage.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Outage.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Outage.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (Outage.fields (position), x))

        emitattr (0, actualPeriod)
        emitelem (1, cancelledDateTime)
        emitelem (2, cause)
        emitattr (3, estimatedPeriod)
        emitelem (4, isPlanned)
        emitattr (5, summary)
        emitattrs (6, Equipments)
        emitattrs (7, Faults)
        emitattr (8, Incident)
        emitattrs (9, OpenedSwitches)
        emitattr (10, OutageSchedule)
        emitattrs (11, PlannedSwitchActions)
        emitattrs (12, SwitchingPlans)
        emitattrs (13, UpdatedRatings)
        emitattrs (14, UsagePoints)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Outage rdf:ID=\"%s\">\n%s\t</cim:Outage>".format (id, export_fields)
    }
}

object Outage
    extends
        Parseable[Outage]
{
    override val fields: Array[String] = Array [String](
        "actualPeriod",
        "cancelledDateTime",
        "cause",
        "estimatedPeriod",
        "isPlanned",
        "summary",
        "Equipments",
        "Faults",
        "Incident",
        "OpenedSwitches",
        "OutageSchedule",
        "PlannedSwitchActions",
        "SwitchingPlans",
        "UpdatedRatings",
        "UsagePoints"
    )
    override val relations: List[Relationship] = List (
        Relationship ("summary", "ServicePointOutageSummary", "0..1", "0..*"),
        Relationship ("Equipments", "Equipment", "0..*", "0..*"),
        Relationship ("Faults", "Fault", "0..*", "0..1"),
        Relationship ("Incident", "Incident", "0..1", "0..1"),
        Relationship ("OpenedSwitches", "Switch", "0..*", "0..1"),
        Relationship ("OutageSchedule", "OutageSchedule", "0..1", "0..*"),
        Relationship ("PlannedSwitchActions", "SwitchAction", "0..*", "0..1"),
        Relationship ("SwitchingPlans", "SwitchingPlan", "0..*", "0..1"),
        Relationship ("UpdatedRatings", "OperationalUpdatedRating", "0..*", "1"),
        Relationship ("UsagePoints", "UsagePoint", "0..*", "0..*")
    )
    val actualPeriod: Fielder = parse_attribute (attribute (cls, fields (0)))
    val cancelledDateTime: Fielder = parse_element (element (cls, fields (1)))
    val cause: Fielder = parse_element (element (cls, fields (2)))
    val estimatedPeriod: Fielder = parse_attribute (attribute (cls, fields (3)))
    val isPlanned: Fielder = parse_element (element (cls, fields (4)))
    val summary: Fielder = parse_attribute (attribute (cls, fields (5)))
    val Equipments: FielderMultiple = parse_attributes (attribute (cls, fields (6)))
    val Faults: FielderMultiple = parse_attributes (attribute (cls, fields (7)))
    val Incident: Fielder = parse_attribute (attribute (cls, fields (8)))
    val OpenedSwitches: FielderMultiple = parse_attributes (attribute (cls, fields (9)))
    val OutageSchedule: Fielder = parse_attribute (attribute (cls, fields (10)))
    val PlannedSwitchActions: FielderMultiple = parse_attributes (attribute (cls, fields (11)))
    val SwitchingPlans: FielderMultiple = parse_attributes (attribute (cls, fields (12)))
    val UpdatedRatings: FielderMultiple = parse_attributes (attribute (cls, fields (13)))
    val UsagePoints: FielderMultiple = parse_attributes (attribute (cls, fields (14)))

    def parse (context: Context): Outage =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = Outage (
            Document.parse (context),
            mask (actualPeriod (), 0),
            mask (cancelledDateTime (), 1),
            mask (cause (), 2),
            mask (estimatedPeriod (), 3),
            toBoolean (mask (isPlanned (), 4)),
            mask (summary (), 5),
            masks (Equipments (), 6),
            masks (Faults (), 7),
            mask (Incident (), 8),
            masks (OpenedSwitches (), 9),
            mask (OutageSchedule (), 10),
            masks (PlannedSwitchActions (), 11),
            masks (SwitchingPlans (), 12),
            masks (UpdatedRatings (), 13),
            masks (UsagePoints (), 14)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Document containing the definition of planned outages of equipment and/or service (delivery) points (sometimes referred to as customers).
 *
 * It is used as specification for producing switching plans.
 *
 * @param sup            [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param PlannedOutages [[ch.ninecode.model.Outage Outage]] All outages resulting from the execution of this outage schedule.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
case class OutageSchedule
(
    override val sup: Document,
    PlannedOutages: List[String]
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, List ())
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Document: Document = sup.asInstanceOf [Document]

    override def copy (): Row =
    {
        clone ().asInstanceOf [OutageSchedule]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OutageSchedule.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (OutageSchedule.fields (position), x))

        emitattrs (0, PlannedOutages)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:OutageSchedule rdf:ID=\"%s\">\n%s\t</cim:OutageSchedule>".format (id, export_fields)
    }
}

object OutageSchedule
    extends
        Parseable[OutageSchedule]
{
    override val fields: Array[String] = Array [String](
        "PlannedOutages"
    )
    override val relations: List[Relationship] = List (
        Relationship ("PlannedOutages", "Outage", "0..*", "0..1")
    )
    val PlannedOutages: FielderMultiple = parse_attributes (attribute (cls, fields (0)))

    def parse (context: Context): OutageSchedule =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = OutageSchedule (
            Document.parse (context),
            masks (PlannedOutages (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Event recording the change in operational status of a power system resource; may be for an event that has already occurred or for a planned activity.
 *
 * @param sup                 [[ch.ninecode.model.ActivityRecord ActivityRecord]] Reference to the superclass object.
 * @param kind                Kind of event.
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Power system resource that generated this event.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
case class PSREvent
(
    override val sup: ActivityRecord,
    kind: String,
    PowerSystemResource: String
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def ActivityRecord: ActivityRecord = sup.asInstanceOf [ActivityRecord]

    override def copy (): Row =
    {
        clone ().asInstanceOf [PSREvent]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

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
        Parseable[PSREvent]
{
    override val fields: Array[String] = Array [String](
        "kind",
        "PowerSystemResource"
    )
    override val relations: List[Relationship] = List (
        Relationship ("PowerSystemResource", "PowerSystemResource", "0..1", "0..*")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields (0)))
    val PowerSystemResource: Fielder = parse_attribute (attribute (cls, fields (1)))

    def parse (context: Context): PSREvent =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = PSREvent (
            ActivityRecord.parse (context),
            mask (kind (), 0),
            mask (PowerSystemResource (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Document restricting or authorising works on electrical equipment (for example a permit to work, sanction for test, limitation of access, or certificate of isolation), defined based upon organisational practices.
 *
 * @param sup           [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param SwitchingPlan [[ch.ninecode.model.SwitchingPlan SwitchingPlan]] Switching plan to which this safety document applies.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
case class SafetyDocument
(
    override val sup: Document,
    SwitchingPlan: String
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Document: Document = sup.asInstanceOf [Document]

    override def copy (): Row =
    {
        clone ().asInstanceOf [SafetyDocument]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SafetyDocument.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SafetyDocument.fields (position), value)

        emitattr (0, SwitchingPlan)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:SafetyDocument rdf:ID=\"%s\">\n%s\t</cim:SafetyDocument>".format (id, export_fields)
    }
}

object SafetyDocument
    extends
        Parseable[SafetyDocument]
{
    override val fields: Array[String] = Array [String](
        "SwitchingPlan"
    )
    override val relations: List[Relationship] = List (
        Relationship ("SwitchingPlan", "SwitchingPlan", "0..1", "0..*")
    )
    val SwitchingPlan: Fielder = parse_attribute (attribute (cls, fields (0)))

    def parse (context: Context): SafetyDocument =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = SafetyDocument (
            Document.parse (context),
            mask (SwitchingPlan (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Summary counts of service points affected by an outage.
 *
 * These counts are sometimes referred to as total and critical customer count.
 *
 * @param sup           Reference to the superclass object.
 * @param criticalCount Number of critical service (delivery) points affected by an outage.
 * @param totalCount    Number of all service (delivery) points affected by an outage.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
case class ServicePointOutageSummary
(
    override val sup: BasicElement,
    criticalCount: Int,
    totalCount: Int
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, 0, 0)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Element: Element = sup.asInstanceOf [Element]

    override def copy (): Row =
    {
        clone ().asInstanceOf [ServicePointOutageSummary]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

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
        Parseable[ServicePointOutageSummary]
{
    override val fields: Array[String] = Array [String](
        "criticalCount",
        "totalCount"
    )
    val criticalCount: Fielder = parse_element (element (cls, fields (0)))
    val totalCount: Fielder = parse_element (element (cls, fields (1)))

    def parse (context: Context): ServicePointOutageSummary =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = ServicePointOutageSummary (
            BasicElement.parse (context),
            toInteger (mask (criticalCount (), 0)),
            toInteger (mask (totalCount (), 1))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Action on switch as a switching step.
 *
 * @param sup                [[ch.ninecode.model.SwitchingStep SwitchingStep]] Reference to the superclass object.
 * @param kind               Switching action to perform.
 * @param OperatedSwitch     [[ch.ninecode.model.Switch Switch]] Switch that is the object of this switch action.
 * @param PlannedOutage      [[ch.ninecode.model.Outage Outage]] Planned outage for whose scope this switch action applies.
 * @param SwitchingStepGroup [[ch.ninecode.model.SwitchingStepGroup SwitchingStepGroup]] Group to which this step belongs.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
case class SwitchAction
(
    override val sup: SwitchingStep,
    kind: String,
    OperatedSwitch: String,
    PlannedOutage: String,
    SwitchingStepGroup: String
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, null, null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def SwitchingStep: SwitchingStep = sup.asInstanceOf [SwitchingStep]

    override def copy (): Row =
    {
        clone ().asInstanceOf [SwitchAction]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SwitchAction.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SwitchAction.fields (position), value)

        emitattr (0, kind)
        emitattr (1, OperatedSwitch)
        emitattr (2, PlannedOutage)
        emitattr (3, SwitchingStepGroup)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:SwitchAction rdf:ID=\"%s\">\n%s\t</cim:SwitchAction>".format (id, export_fields)
    }
}

object SwitchAction
    extends
        Parseable[SwitchAction]
{
    override val fields: Array[String] = Array [String](
        "kind",
        "OperatedSwitch",
        "PlannedOutage",
        "SwitchingStepGroup"
    )
    override val relations: List[Relationship] = List (
        Relationship ("OperatedSwitch", "Switch", "0..1", "0..1"),
        Relationship ("PlannedOutage", "Outage", "0..1", "0..*"),
        Relationship ("SwitchingStepGroup", "SwitchingStepGroup", "0..1", "0..*")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields (0)))
    val OperatedSwitch: Fielder = parse_attribute (attribute (cls, fields (1)))
    val PlannedOutage: Fielder = parse_attribute (attribute (cls, fields (2)))
    val SwitchingStepGroup: Fielder = parse_attribute (attribute (cls, fields (3)))

    def parse (context: Context): SwitchAction =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = SwitchAction (
            SwitchingStep.parse (context),
            mask (kind (), 0),
            mask (OperatedSwitch (), 1),
            mask (PlannedOutage (), 2),
            mask (SwitchingStepGroup (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A sequence of grouped or atomic steps intended to:
 * - de-energise equipment or part of the network for safe work, and/or
 *
 * - bring back in service previously de-energised equipment or part of the network.
 *
 * @param sup                 [[ch.ninecode.model.SwitchingStepGroup SwitchingStepGroup]] Reference to the superclass object.
 * @param purpose             Purpose of  this plan, such as whether it is to move the state from normal to some abnormal condition, or to restore the normal state after an abnormal condition, or to perform some kind of optimisation such as correction of overload, voltage control, etc.
 * @param rank                Ranking in comparison to other switching plans.
 * @param Outage              [[ch.ninecode.model.Outage Outage]] Outage that will be eliminated when this switching plan gets executed.
 * @param SafetyDocuments     [[ch.ninecode.model.SafetyDocument SafetyDocument]] All safety documents applicable to this swtiching plan.
 * @param SwitchingStepGroups [[ch.ninecode.model.SwitchingStepGroup SwitchingStepGroup]] All groups of switching steps within this switching plan.
 * @param WorkTasks           [[ch.ninecode.model.WorkTask WorkTask]] All work tasks to execute this switching plan.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
case class SwitchingPlan
(
    override val sup: SwitchingStepGroup,
    purpose: String,
    rank: Int,
    Outage: String,
    SafetyDocuments: List[String],
    SwitchingStepGroups: List[String],
    WorkTasks: List[String]
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, 0, null, List (), List (), List ())
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def SwitchingStepGroup: SwitchingStepGroup = sup.asInstanceOf [SwitchingStepGroup]

    override def copy (): Row =
    {
        clone ().asInstanceOf [SwitchingPlan]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SwitchingPlan.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SwitchingPlan.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SwitchingPlan.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (SwitchingPlan.fields (position), x))

        emitelem (0, purpose)
        emitelem (1, rank)
        emitattr (2, Outage)
        emitattrs (3, SafetyDocuments)
        emitattrs (4, SwitchingStepGroups)
        emitattrs (5, WorkTasks)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:SwitchingPlan rdf:ID=\"%s\">\n%s\t</cim:SwitchingPlan>".format (id, export_fields)
    }
}

object SwitchingPlan
    extends
        Parseable[SwitchingPlan]
{
    override val fields: Array[String] = Array [String](
        "purpose",
        "rank",
        "Outage",
        "SafetyDocuments",
        "SwitchingStepGroups",
        "WorkTasks"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Outage", "Outage", "0..1", "0..*"),
        Relationship ("SafetyDocuments", "SafetyDocument", "0..*", "0..1"),
        Relationship ("SwitchingStepGroups", "SwitchingStepGroup", "0..*", "0..1"),
        Relationship ("WorkTasks", "WorkTask", "0..*", "0..1")
    )
    val purpose: Fielder = parse_element (element (cls, fields (0)))
    val rank: Fielder = parse_element (element (cls, fields (1)))
    val Outage: Fielder = parse_attribute (attribute (cls, fields (2)))
    val SafetyDocuments: FielderMultiple = parse_attributes (attribute (cls, fields (3)))
    val SwitchingStepGroups: FielderMultiple = parse_attributes (attribute (cls, fields (4)))
    val WorkTasks: FielderMultiple = parse_attributes (attribute (cls, fields (5)))

    def parse (context: Context): SwitchingPlan =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = SwitchingPlan (
            SwitchingStepGroup.parse (context),
            mask (purpose (), 0),
            toInteger (mask (rank (), 1)),
            mask (Outage (), 2),
            masks (SafetyDocuments (), 3),
            masks (SwitchingStepGroups (), 4),
            masks (WorkTasks (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Atomic switching step; can be part of a switching step group, or of the switching plan.
 *
 * @param sup              Reference to the superclass object.
 * @param description      Free text description of this activity.
 * @param executedDateTime Actual date and time of this switching step.
 * @param isFreeSequence   If true, the sequence number serves for presentation purposes only, and the activity itself may be executed at any time.
 * @param plannedDateTime  Planned date and time of this switching step.
 * @param sequenceNumber   Order of this activity in the sequence of activities within the switching plan.
 * @param CrewMember       [[ch.ninecode.model.CrewMember CrewMember]] Crew member responsible for this switching step.
 * @param Operator         [[ch.ninecode.model.Operator Operator]] Operator responsible for this switching step.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
case class SwitchingStep
(
    override val sup: BasicElement,
    description: String,
    executedDateTime: String,
    isFreeSequence: Boolean,
    plannedDateTime: String,
    sequenceNumber: Int,
    CrewMember: String,
    Operator: String
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, null, false, null, 0, null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Element: Element = sup.asInstanceOf [Element]

    override def copy (): Row =
    {
        clone ().asInstanceOf [SwitchingStep]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SwitchingStep.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SwitchingStep.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SwitchingStep.fields (position), value)

        emitelem (0, description)
        emitelem (1, executedDateTime)
        emitelem (2, isFreeSequence)
        emitelem (3, plannedDateTime)
        emitelem (4, sequenceNumber)
        emitattr (5, CrewMember)
        emitattr (6, Operator)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:SwitchingStep rdf:ID=\"%s\">\n%s\t</cim:SwitchingStep>".format (id, export_fields)
    }
}

object SwitchingStep
    extends
        Parseable[SwitchingStep]
{
    override val fields: Array[String] = Array [String](
        "description",
        "executedDateTime",
        "isFreeSequence",
        "plannedDateTime",
        "sequenceNumber",
        "CrewMember",
        "Operator"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CrewMember", "CrewMember", "0..1", "0..*"),
        Relationship ("Operator", "Operator", "0..1", "0..*")
    )
    val description: Fielder = parse_element (element (cls, fields (0)))
    val executedDateTime: Fielder = parse_element (element (cls, fields (1)))
    val isFreeSequence: Fielder = parse_element (element (cls, fields (2)))
    val plannedDateTime: Fielder = parse_element (element (cls, fields (3)))
    val sequenceNumber: Fielder = parse_element (element (cls, fields (4)))
    val CrewMember: Fielder = parse_attribute (attribute (cls, fields (5)))
    val Operator: Fielder = parse_attribute (attribute (cls, fields (6)))

    def parse (context: Context): SwitchingStep =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = SwitchingStep (
            BasicElement.parse (context),
            mask (description (), 0),
            mask (executedDateTime (), 1),
            toBoolean (mask (isFreeSequence (), 2)),
            mask (plannedDateTime (), 3),
            toInteger (mask (sequenceNumber (), 4)),
            mask (CrewMember (), 5),
            mask (Operator (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A logical step, grouping atomic switching steps that are important to distinguish when they may change topology (e.g. placing a jumper between two cuts).
 *
 * @param sup                 [[ch.ninecode.model.Document Document]] Reference to the superclass object.
 * @param isFreeSequence      If true, the sequence number serves for presentation purposes only, and the activity itself may be executed at any time.
 * @param sequenceNumber      Order of this activity in the sequence of activities within the switching plan.
 * @param ClearanceActions    [[ch.ninecode.model.ClearanceAction ClearanceAction]] All clearance action steps in this group.
 * @param CutActions          [[ch.ninecode.model.CutAction CutAction]] All cut action steps in this group.
 * @param EnergySourceActions [[ch.ninecode.model.EnergySourceAction EnergySourceAction]] All energy source action steps in this group.
 * @param GenericActions      [[ch.ninecode.model.GenericAction GenericAction]] All generic action steps in this group.
 * @param GroundActions       [[ch.ninecode.model.GroundAction GroundAction]] All ground action steps in this group.
 * @param JumperActions       [[ch.ninecode.model.JumperAction JumperAction]] All jumper action steps in this group.
 * @param SwitchActions       [[ch.ninecode.model.SwitchAction SwitchAction]] All switch action steps in this group.
 * @param SwitchingPlan       [[ch.ninecode.model.SwitchingPlan SwitchingPlan]] Switching plan to which this group belongs.
 * @param TagActions          [[ch.ninecode.model.TagAction TagAction]] All tag action steps in this group.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
case class SwitchingStepGroup
(
    override val sup: Document,
    isFreeSequence: Boolean,
    sequenceNumber: Int,
    ClearanceActions: List[String],
    CutActions: List[String],
    EnergySourceActions: List[String],
    GenericActions: List[String],
    GroundActions: List[String],
    JumperActions: List[String],
    SwitchActions: List[String],
    SwitchingPlan: String,
    TagActions: List[String]
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, false, 0, List (), List (), List (), List (), List (), List (), List (), null, List ())
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Document: Document = sup.asInstanceOf [Document]

    override def copy (): Row =
    {
        clone ().asInstanceOf [SwitchingStepGroup]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SwitchingStepGroup.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (SwitchingStepGroup.fields (position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SwitchingStepGroup.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (SwitchingStepGroup.fields (position), x))

        emitelem (0, isFreeSequence)
        emitelem (1, sequenceNumber)
        emitattrs (2, ClearanceActions)
        emitattrs (3, CutActions)
        emitattrs (4, EnergySourceActions)
        emitattrs (5, GenericActions)
        emitattrs (6, GroundActions)
        emitattrs (7, JumperActions)
        emitattrs (8, SwitchActions)
        emitattr (9, SwitchingPlan)
        emitattrs (10, TagActions)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:SwitchingStepGroup rdf:ID=\"%s\">\n%s\t</cim:SwitchingStepGroup>".format (id, export_fields)
    }
}

object SwitchingStepGroup
    extends
        Parseable[SwitchingStepGroup]
{
    override val fields: Array[String] = Array [String](
        "isFreeSequence",
        "sequenceNumber",
        "ClearanceActions",
        "CutActions",
        "EnergySourceActions",
        "GenericActions",
        "GroundActions",
        "JumperActions",
        "SwitchActions",
        "SwitchingPlan",
        "TagActions"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ClearanceActions", "ClearanceAction", "0..*", "0..1"),
        Relationship ("CutActions", "CutAction", "0..*", "0..1"),
        Relationship ("EnergySourceActions", "EnergySourceAction", "0..*", "0..1"),
        Relationship ("GenericActions", "GenericAction", "0..*", "0..1"),
        Relationship ("GroundActions", "GroundAction", "0..*", "0..1"),
        Relationship ("JumperActions", "JumperAction", "0..*", "0..1"),
        Relationship ("SwitchActions", "SwitchAction", "0..*", "0..1"),
        Relationship ("SwitchingPlan", "SwitchingPlan", "0..1", "0..*"),
        Relationship ("TagActions", "TagAction", "0..*", "0..1")
    )
    val isFreeSequence: Fielder = parse_element (element (cls, fields (0)))
    val sequenceNumber: Fielder = parse_element (element (cls, fields (1)))
    val ClearanceActions: FielderMultiple = parse_attributes (attribute (cls, fields (2)))
    val CutActions: FielderMultiple = parse_attributes (attribute (cls, fields (3)))
    val EnergySourceActions: FielderMultiple = parse_attributes (attribute (cls, fields (4)))
    val GenericActions: FielderMultiple = parse_attributes (attribute (cls, fields (5)))
    val GroundActions: FielderMultiple = parse_attributes (attribute (cls, fields (6)))
    val JumperActions: FielderMultiple = parse_attributes (attribute (cls, fields (7)))
    val SwitchActions: FielderMultiple = parse_attributes (attribute (cls, fields (8)))
    val SwitchingPlan: Fielder = parse_attribute (attribute (cls, fields (9)))
    val TagActions: FielderMultiple = parse_attributes (attribute (cls, fields (10)))

    def parse (context: Context): SwitchingStepGroup =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = SwitchingStepGroup (
            Document.parse (context),
            toBoolean (mask (isFreeSequence (), 0)),
            toInteger (mask (sequenceNumber (), 1)),
            masks (ClearanceActions (), 2),
            masks (CutActions (), 3),
            masks (EnergySourceActions (), 4),
            masks (GenericActions (), 5),
            masks (GroundActions (), 6),
            masks (JumperActions (), 7),
            masks (SwitchActions (), 8),
            mask (SwitchingPlan (), 9),
            masks (TagActions (), 10)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Action on operation tag as a switching step.
 *
 * @param sup                [[ch.ninecode.model.SwitchingStep SwitchingStep]] Reference to the superclass object.
 * @param kind               Kind of tag action.
 * @param OperationTag       [[ch.ninecode.model.OperationTag OperationTag]] Tag associated with this tag action.
 * @param SwitchingStepGroup [[ch.ninecode.model.SwitchingStepGroup SwitchingStepGroup]] Group to which this step belongs.
 * @group Operations
 * @groupname Operations Package Operations
 * @groupdesc Operations This package contains the core information classes that support operations and outage management applications.
 */
case class TagAction
(
    override val sup: SwitchingStep,
    kind: String,
    OperationTag: String,
    SwitchingStepGroup: String
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, null, null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def SwitchingStep: SwitchingStep = sup.asInstanceOf [SwitchingStep]

    override def copy (): Row =
    {
        clone ().asInstanceOf [TagAction]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TagAction.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TagAction.fields (position), value)

        emitattr (0, kind)
        emitattr (1, OperationTag)
        emitattr (2, SwitchingStepGroup)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:TagAction rdf:ID=\"%s\">\n%s\t</cim:TagAction>".format (id, export_fields)
    }
}

object TagAction
    extends
        Parseable[TagAction]
{
    override val fields: Array[String] = Array [String](
        "kind",
        "OperationTag",
        "SwitchingStepGroup"
    )
    override val relations: List[Relationship] = List (
        Relationship ("OperationTag", "OperationTag", "0..1", "0..1"),
        Relationship ("SwitchingStepGroup", "SwitchingStepGroup", "0..1", "0..*")
    )
    val kind: Fielder = parse_attribute (attribute (cls, fields (0)))
    val OperationTag: Fielder = parse_attribute (attribute (cls, fields (1)))
    val SwitchingStepGroup: Fielder = parse_attribute (attribute (cls, fields (2)))

    def parse (context: Context): TagAction =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = TagAction (
            SwitchingStep.parse (context),
            mask (kind (), 0),
            mask (OperationTag (), 1),
            mask (SwitchingStepGroup (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _Operations
{
    def register: List[ClassInfo] =
    {
        List (
            ClearanceAction.register,
            ClearanceDocument.register,
            CutAction.register,
            EnergySourceAction.register,
            GenericAction.register,
            GroundAction.register,
            Incident.register,
            JumperAction.register,
            OperationTag.register,
            OperationalRestriction.register,
            OperationalUpdatedRating.register,
            Outage.register,
            OutageSchedule.register,
            PSREvent.register,
            SafetyDocument.register,
            ServicePointOutageSummary.register,
            SwitchAction.register,
            SwitchingPlan.register,
            SwitchingStep.register,
            SwitchingStepGroup.register,
            TagAction.register
        )
    }
}
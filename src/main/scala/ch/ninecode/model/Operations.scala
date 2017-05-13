package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This package contains the core information classes that support operations and outage management applications.
 */

/**
 * Action on clearance document as a switching step.
 */
case class ClearanceAction
(

    override val sup: SwitchingStep,

    /**
     * Clearance action to perform.
     */
    val kind: String,

    /**
     * Clearance associated with this clearance action.
     */
    val Clearance: String,

    /**
     * Group to which this step belongs.
     */
    val SwitchingStepGroup: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def SwitchingStep: SwitchingStep = sup.asInstanceOf[SwitchingStep]
    override def copy (): Row = { return (clone ().asInstanceOf[ClearanceAction]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ClearanceAction
extends
    Parseable[ClearanceAction]
{
    val sup = SwitchingStep.parse _
    val kind = parse_attribute (attribute ("""ClearanceAction.kind"""))_
    val Clearance = parse_attribute (attribute ("""ClearanceAction.Clearance"""))_
    val SwitchingStepGroup = parse_attribute (attribute ("""ClearanceAction.SwitchingStepGroup"""))_
    def parse (context: Context): ClearanceAction =
    {
        ClearanceAction(
            sup (context),
            kind (context),
            Clearance (context),
            SwitchingStepGroup (context)
        )
    }
}

/**
 * Type of clearance action.
 */
case class ClearanceActionKind
(

    override val sup: BasicElement,

    /**
     * Issue clearance.
     */
    val issue: String,

    /**
     * Release clearance.
     */
    val release: String,

    /**
     * Update clearance.
     */
    val update: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ClearanceActionKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ClearanceActionKind
extends
    Parseable[ClearanceActionKind]
{
    val sup = BasicElement.parse _
    val issue = parse_attribute (attribute ("""ClearanceActionKind.issue"""))_
    val release = parse_attribute (attribute ("""ClearanceActionKind.release"""))_
    val update = parse_attribute (attribute ("""ClearanceActionKind.update"""))_
    def parse (context: Context): ClearanceActionKind =
    {
        ClearanceActionKind(
            sup (context),
            issue (context),
            release (context),
            update (context)
        )
    }
}

/**
 * Safety document used to authorise work on conducting equipment in the field.
 * Tagged equipment is not allowed to be operated.
 */
case class ClearanceDocument
(

    override val sup: SafetyDocument,

    /**
     * If true, the equipment must be deenergised.
     */
    val mustBeDeenergised: Boolean,

    /**
     * If true, the equipment must be grounded.
     */
    val mustBeGrounded: Boolean,

    /**
     * Clearance action associated with this clearance.
     */
    val ClearanceAction: String,

    /**
     * All power system resources tagged through this clearance.
     */
    val TaggedPSRs: List[String]
)
extends
    Element
{
    def this () = { this (null, false, false, null, List()) }
    def SafetyDocument: SafetyDocument = sup.asInstanceOf[SafetyDocument]
    override def copy (): Row = { return (clone ().asInstanceOf[ClearanceDocument]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ClearanceDocument
extends
    Parseable[ClearanceDocument]
{
    val sup = SafetyDocument.parse _
    val mustBeDeenergised = parse_element (element ("""ClearanceDocument.mustBeDeenergised"""))_
    val mustBeGrounded = parse_element (element ("""ClearanceDocument.mustBeGrounded"""))_
    val ClearanceAction = parse_attribute (attribute ("""ClearanceDocument.ClearanceAction"""))_
    val TaggedPSRs = parse_attributes (attribute ("""ClearanceDocument.TaggedPSRs"""))_
    def parse (context: Context): ClearanceDocument =
    {
        ClearanceDocument(
            sup (context),
            toBoolean (mustBeDeenergised (context), context),
            toBoolean (mustBeGrounded (context), context),
            ClearanceAction (context),
            TaggedPSRs (context)
        )
    }
}

/**
 * Action on cut as a switching step.
 */
case class CutAction
(

    override val sup: SwitchingStep,

    /**
     * Switching action to perform.
     */
    val kind: String,

    /**
     * Cut on which this action is taken.
     */
    val Cut: String,

    /**
     * Group to which this step belongs.
     */
    val SwitchingStepGroup: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def SwitchingStep: SwitchingStep = sup.asInstanceOf[SwitchingStep]
    override def copy (): Row = { return (clone ().asInstanceOf[CutAction]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CutAction
extends
    Parseable[CutAction]
{
    val sup = SwitchingStep.parse _
    val kind = parse_attribute (attribute ("""CutAction.kind"""))_
    val Cut = parse_attribute (attribute ("""CutAction.Cut"""))_
    val SwitchingStepGroup = parse_attribute (attribute ("""CutAction.SwitchingStepGroup"""))_
    def parse (context: Context): CutAction =
    {
        CutAction(
            sup (context),
            kind (context),
            Cut (context),
            SwitchingStepGroup (context)
        )
    }
}

/**
 * Action on energy source as a switching step.
 */
case class EnergySourceAction
(

    override val sup: SwitchingStep,

    /**
     * Switching action to perform.
     */
    val kind: String,

    /**
     * Energy source on which this action is taken.
     */
    val EnergySource: String,

    /**
     * Group to which this step belongs.
     */
    val SwitchingStepGroup: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def SwitchingStep: SwitchingStep = sup.asInstanceOf[SwitchingStep]
    override def copy (): Row = { return (clone ().asInstanceOf[EnergySourceAction]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EnergySourceAction
extends
    Parseable[EnergySourceAction]
{
    val sup = SwitchingStep.parse _
    val kind = parse_attribute (attribute ("""EnergySourceAction.kind"""))_
    val EnergySource = parse_attribute (attribute ("""EnergySourceAction.EnergySource"""))_
    val SwitchingStepGroup = parse_attribute (attribute ("""EnergySourceAction.SwitchingStepGroup"""))_
    def parse (context: Context): EnergySourceAction =
    {
        EnergySourceAction(
            sup (context),
            kind (context),
            EnergySource (context),
            SwitchingStepGroup (context)
        )
    }
}

/**
 * An arbitrary switching step.
 */
case class GenericAction
(

    override val sup: SwitchingStep,

    /**
     * Group to which this step belongs.
     */
    val SwitchingStepGroup: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def SwitchingStep: SwitchingStep = sup.asInstanceOf[SwitchingStep]
    override def copy (): Row = { return (clone ().asInstanceOf[GenericAction]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GenericAction
extends
    Parseable[GenericAction]
{
    val sup = SwitchingStep.parse _
    val SwitchingStepGroup = parse_attribute (attribute ("""GenericAction.SwitchingStepGroup"""))_
    def parse (context: Context): GenericAction =
    {
        GenericAction(
            sup (context),
            SwitchingStepGroup (context)
        )
    }
}

/**
 * Action on ground as a switching step.
 */
case class GroundAction
(

    override val sup: SwitchingStep,

    /**
     * Switching action to perform.
     */
    val kind: String,

    /**
     * The line segment that this ground action will affect.
     * This is the only way to access relationship to clamp in case the ground needs to be placed along the line segment.
     */
    val AlongACLineSegment: String,

    /**
     * Ground on which this action is taken.
     */
    val Ground: String,

    /**
     * Equipment being grounded with this operation.
     * In case of placing a ground anywhere along a line segment, you must use the clamp (to get the distance from one terminal), so use the explicit relation with line segment. In all other cases (including placing the ground at a line segment terminal), reference to one or more conducting equipment is sufficient.
     */
    val GroundedEquipment: String,

    /**
     * Group to which this step belongs.
     */
    val SwitchingStepGroup: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def SwitchingStep: SwitchingStep = sup.asInstanceOf[SwitchingStep]
    override def copy (): Row = { return (clone ().asInstanceOf[GroundAction]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GroundAction
extends
    Parseable[GroundAction]
{
    val sup = SwitchingStep.parse _
    val kind = parse_attribute (attribute ("""GroundAction.kind"""))_
    val AlongACLineSegment = parse_attribute (attribute ("""GroundAction.AlongACLineSegment"""))_
    val Ground = parse_attribute (attribute ("""GroundAction.Ground"""))_
    val GroundedEquipment = parse_attribute (attribute ("""GroundAction.GroundedEquipment"""))_
    val SwitchingStepGroup = parse_attribute (attribute ("""GroundAction.SwitchingStepGroup"""))_
    def parse (context: Context): GroundAction =
    {
        GroundAction(
            sup (context),
            kind (context),
            AlongACLineSegment (context),
            Ground (context),
            GroundedEquipment (context),
            SwitchingStepGroup (context)
        )
    }
}

/**
 * Description of a problem in the field that may be reported in a trouble ticket or come from another source.
 * It may have to do with an outage.
 */
case class Incident
(

    override val sup: Document,

    /**
     * Cause of this incident.
     */
    val cause: String,

    /**
     * Outage for this incident.
     */
    val Outage: String,

    /**
     * Operator who owns this incident.
     */
    val Owner: String,

    /**
     * All works addressing this incident.
     */
    val Works: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, List()) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[Incident]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Incident
extends
    Parseable[Incident]
{
    val sup = Document.parse _
    val cause = parse_element (element ("""Incident.cause"""))_
    val Outage = parse_attribute (attribute ("""Incident.Outage"""))_
    val Owner = parse_attribute (attribute ("""Incident.Owner"""))_
    val Works = parse_attributes (attribute ("""Incident.Works"""))_
    def parse (context: Context): Incident =
    {
        Incident(
            sup (context),
            cause (context),
            Outage (context),
            Owner (context),
            Works (context)
        )
    }
}

/**
 * Action on jumper as a switching step.
 */
case class JumperAction
(

    override val sup: SwitchingStep,

    /**
     * Switching action to perform.
     */
    val kind: String,

    /**
     * Jumper on which this action is taken.
     */
    val Jumper: String,

    /**
     * Group to which this step belongs.
     */
    val SwitchingStepGroup: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def SwitchingStep: SwitchingStep = sup.asInstanceOf[SwitchingStep]
    override def copy (): Row = { return (clone ().asInstanceOf[JumperAction]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object JumperAction
extends
    Parseable[JumperAction]
{
    val sup = SwitchingStep.parse _
    val kind = parse_attribute (attribute ("""JumperAction.kind"""))_
    val Jumper = parse_attribute (attribute ("""JumperAction.Jumper"""))_
    val SwitchingStepGroup = parse_attribute (attribute ("""JumperAction.SwitchingStepGroup"""))_
    def parse (context: Context): JumperAction =
    {
        JumperAction(
            sup (context),
            kind (context),
            Jumper (context),
            SwitchingStepGroup (context)
        )
    }
}

case class OperationTag
(

    override val sup: Document,

    /**
     * Asset on which this operation tag has been placed.
     */
    val Asset: String,

    /**
     * Power system resource on which this tag has been placed.
     */
    val PowerSystemResource: String,

    /**
     * Tag action associated with this tag.
     */
    val TagAction: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[OperationTag]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OperationTag
extends
    Parseable[OperationTag]
{
    val sup = Document.parse _
    val Asset = parse_attribute (attribute ("""OperationTag.Asset"""))_
    val PowerSystemResource = parse_attribute (attribute ("""OperationTag.PowerSystemResource"""))_
    val TagAction = parse_attribute (attribute ("""OperationTag.TagAction"""))_
    def parse (context: Context): OperationTag =
    {
        OperationTag(
            sup (context),
            Asset (context),
            PowerSystemResource (context),
            TagAction (context)
        )
    }
}

/**
 * A document that can be associated with equipment to describe any sort of restrictions compared with the original manufacturer's specification or with the usual operational practice e.g. temporary maximum loadings, maximum switching current, do not operate if bus couplers are open, etc.
 * In the UK, for example, if a breaker or switch ever mal-operates, this is reported centrally and utilities use their asset systems to identify all the installed devices of the same manufacturer's type. They then apply operational restrictions in the operational systems to warn operators of potential problems. After appropriate inspection and maintenance, the operational restrictions may be removed.
 */
case class OperationalRestriction
(

    override val sup: Document,

    /**
     * Interval during which this restriction is applied.
     */
    val activePeriod: String,

    /**
     * Restricted (new) value; includes unit of measure and potentially multiplier.
     */
    val restrictedValue: String,

    /**
     * All equipments to which this restriction applies.
     */
    val Equipments: List[String],

    /**
     * Asset model to which this restriction applies.
     */
    val ProductAssetModel: String
)
extends
    Element
{
    def this () = { this (null, null, null, List(), null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[OperationalRestriction]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OperationalRestriction
extends
    Parseable[OperationalRestriction]
{
    val sup = Document.parse _
    val activePeriod = parse_attribute (attribute ("""OperationalRestriction.activePeriod"""))_
    val restrictedValue = parse_attribute (attribute ("""OperationalRestriction.restrictedValue"""))_
    val Equipments = parse_attributes (attribute ("""OperationalRestriction.Equipments"""))_
    val ProductAssetModel = parse_attribute (attribute ("""OperationalRestriction.ProductAssetModel"""))_
    def parse (context: Context): OperationalRestriction =
    {
        OperationalRestriction(
            sup (context),
            activePeriod (context),
            restrictedValue (context),
            Equipments (context),
            ProductAssetModel (context)
        )
    }
}

/**
 * Lowered capability because of deterioration or inadequacy (sometimes referred to as derating or partial outage) or other kind of operational rating change.
 */
case class OperationalUpdatedRating
(

    override val sup: OperationalRestriction,

    /**
     * Type of operational updated rating, e.g. a derate, a rerate or a return to normal.
     */
    val changeType: String,

    /**
     * Planned equipment outage with this updated rating.
     */
    val PlannedOutage: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def OperationalRestriction: OperationalRestriction = sup.asInstanceOf[OperationalRestriction]
    override def copy (): Row = { return (clone ().asInstanceOf[OperationalUpdatedRating]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OperationalUpdatedRating
extends
    Parseable[OperationalUpdatedRating]
{
    val sup = OperationalRestriction.parse _
    val changeType = parse_element (element ("""OperationalUpdatedRating.changeType"""))_
    val PlannedOutage = parse_attribute (attribute ("""OperationalUpdatedRating.PlannedOutage"""))_
    def parse (context: Context): OperationalUpdatedRating =
    {
        OperationalUpdatedRating(
            sup (context),
            changeType (context),
            PlannedOutage (context)
        )
    }
}

/**
 * Document describing details of an active or planned outage in a part of the electrical network.
 * A non-planned outage may be created upon:
 */
case class Outage
(

    override val sup: Document,

    /**
     * Actual outage period; end of the period corresponds to the actual restoration time.
     */
    val actualPeriod: String,

    /**
     * Date and time planned outage has been cancelled.
     */
    val cancelledDateTime: String,

    /**
     * One or more causes of this outage.
     * Note: At present, this is a free text; could be replaced with a separate associated class in case we have multiple causes (e.g. OutageCauseType, inheriting from IdentifiedObject).
     */
    val cause: String,

    /**
     * Estimated outage period.
     * The start of the period makes sense in case of a planned outage only, whereas the end of the period corresponds to the estimated restoration time in general.
     */
    val estimatedPeriod: String,

    /**
     * True if planned, false otherwise (for example due to a breaker trip).
     */
    val isPlanned: Boolean,

    /**
     * Summary counts of service points (customers) affected by this outage.
     */
    val summary: String,

    /**
     * All equipments associated with this outage.
     */
    val Equipments: List[String],

    /**
     * Incident reported in trouble call that results in this outage.
     */
    val Incident: String,

    /**
     * Outage schedule whose execution will result in this outage.
     */
    val OutageSchedule: String,

    /**
     * All usage points associated with this outage.
     */
    val UsagePoints: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, false, null, List(), null, null, List()) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[Outage]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Outage
extends
    Parseable[Outage]
{
    val sup = Document.parse _
    val actualPeriod = parse_attribute (attribute ("""Outage.actualPeriod"""))_
    val cancelledDateTime = parse_element (element ("""Outage.cancelledDateTime"""))_
    val cause = parse_element (element ("""Outage.cause"""))_
    val estimatedPeriod = parse_attribute (attribute ("""Outage.estimatedPeriod"""))_
    val isPlanned = parse_element (element ("""Outage.isPlanned"""))_
    val summary = parse_attribute (attribute ("""Outage.summary"""))_
    val Equipments = parse_attributes (attribute ("""Outage.Equipments"""))_
    val Incident = parse_attribute (attribute ("""Outage.Incident"""))_
    val OutageSchedule = parse_attribute (attribute ("""Outage.OutageSchedule"""))_
    val UsagePoints = parse_attributes (attribute ("""Outage.UsagePoints"""))_
    def parse (context: Context): Outage =
    {
        Outage(
            sup (context),
            actualPeriod (context),
            cancelledDateTime (context),
            cause (context),
            estimatedPeriod (context),
            toBoolean (isPlanned (context), context),
            summary (context),
            Equipments (context),
            Incident (context),
            OutageSchedule (context),
            UsagePoints (context)
        )
    }
}

/**
 * Document containing the definition of planned outages of equipment and/or service (delivery) points (sometimes referred to as customers).
 * It is used as specification for producing switching plans.
 */
case class OutageSchedule
(

    override val sup: Document
)
extends
    Element
{
    def this () = { this (null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[OutageSchedule]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OutageSchedule
extends
    Parseable[OutageSchedule]
{
    val sup = Document.parse _
    def parse (context: Context): OutageSchedule =
    {
        OutageSchedule(
            sup (context)
        )
    }
}

/**
 * Event recording the change in operational status of a power system resource; may be for an event that has already occurred or for a planned activity.
 */
case class PSREvent
(

    override val sup: ActivityRecord,

    /**
     * Kind of event.
     */
    val kind: String,

    /**
     * Power system resource that generated this event.
     */
    val PowerSystemResource: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def ActivityRecord: ActivityRecord = sup.asInstanceOf[ActivityRecord]
    override def copy (): Row = { return (clone ().asInstanceOf[PSREvent]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PSREvent
extends
    Parseable[PSREvent]
{
    val sup = ActivityRecord.parse _
    val kind = parse_attribute (attribute ("""PSREvent.kind"""))_
    val PowerSystemResource = parse_attribute (attribute ("""PSREvent.PowerSystemResource"""))_
    def parse (context: Context): PSREvent =
    {
        PSREvent(
            sup (context),
            kind (context),
            PowerSystemResource (context)
        )
    }
}

/**
 * Kind of power system resource event.
 */
case class PSREventKind
(

    override val sup: BasicElement,

    /**
     * Power system resource state change to in service.
     */
    val inService: String,

    /**
     * Other power system resource state change.
     */
    val other: String,

    /**
     * Power system resource state change to out of service.
     */
    val outOfService: String,

    /**
     * Power system resource state change to pending add.
     */
    val pendingAdd: String,

    /**
     * Power system resource state change to pending remove.
     */
    val pendingRemove: String,

    /**
     * Power system resource state change to pending replace.
     */
    val pendingReplace: String,

    /**
     * Unknown power system resource state change.
     */
    val unknown: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[PSREventKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PSREventKind
extends
    Parseable[PSREventKind]
{
    val sup = BasicElement.parse _
    val inService = parse_attribute (attribute ("""PSREventKind.inService"""))_
    val other = parse_attribute (attribute ("""PSREventKind.other"""))_
    val outOfService = parse_attribute (attribute ("""PSREventKind.outOfService"""))_
    val pendingAdd = parse_attribute (attribute ("""PSREventKind.pendingAdd"""))_
    val pendingRemove = parse_attribute (attribute ("""PSREventKind.pendingRemove"""))_
    val pendingReplace = parse_attribute (attribute ("""PSREventKind.pendingReplace"""))_
    val unknown = parse_attribute (attribute ("""PSREventKind.unknown"""))_
    def parse (context: Context): PSREventKind =
    {
        PSREventKind(
            sup (context),
            inService (context),
            other (context),
            outOfService (context),
            pendingAdd (context),
            pendingRemove (context),
            pendingReplace (context),
            unknown (context)
        )
    }
}

/**
 * Document restricting or authorising works on electrical equipment (for example a permit to work, sanction for test, limitation of access, or certificate of isolation), defined based upon organisational practices.
 */
case class SafetyDocument
(

    override val sup: Document,

    /**
     * Switching plan to which this safety document applies.
     */
    val SwitchingPlan: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[SafetyDocument]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SafetyDocument
extends
    Parseable[SafetyDocument]
{
    val sup = Document.parse _
    val SwitchingPlan = parse_attribute (attribute ("""SafetyDocument.SwitchingPlan"""))_
    def parse (context: Context): SafetyDocument =
    {
        SafetyDocument(
            sup (context),
            SwitchingPlan (context)
        )
    }
}

/**
 * Summary counts of service points affected by an outage.
 * These counts are sometimes referred to as total and critical customer count.
 */
case class ServicePointOutageSummary
(

    override val sup: BasicElement,

    /**
     * Number of critical service (delivery) points affected by an outage.
     */
    val criticalCount: Int,

    /**
     * Number of all service (delivery) points affected by an outage.
     */
    val totalCount: Int
)
extends
    Element
{
    def this () = { this (null, 0, 0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ServicePointOutageSummary]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ServicePointOutageSummary
extends
    Parseable[ServicePointOutageSummary]
{
    val sup = BasicElement.parse _
    val criticalCount = parse_element (element ("""ServicePointOutageSummary.criticalCount"""))_
    val totalCount = parse_element (element ("""ServicePointOutageSummary.totalCount"""))_
    def parse (context: Context): ServicePointOutageSummary =
    {
        ServicePointOutageSummary(
            sup (context),
            toInteger (criticalCount (context), context),
            toInteger (totalCount (context), context)
        )
    }
}

/**
 * Action on switch as a switching step.
 */
case class SwitchAction
(

    override val sup: SwitchingStep,

    /**
     * Switching action to perform.
     */
    val kind: String,

    /**
     * Switch that is the object of this switch action.
     */
    val OperatedSwitch: String,

    /**
     * Planned outage for whose scope this switch action applies.
     */
    val PlannedOutage: String,

    /**
     * Group to which this step belongs.
     */
    val SwitchingStepGroup: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def SwitchingStep: SwitchingStep = sup.asInstanceOf[SwitchingStep]
    override def copy (): Row = { return (clone ().asInstanceOf[SwitchAction]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SwitchAction
extends
    Parseable[SwitchAction]
{
    val sup = SwitchingStep.parse _
    val kind = parse_attribute (attribute ("""SwitchAction.kind"""))_
    val OperatedSwitch = parse_attribute (attribute ("""SwitchAction.OperatedSwitch"""))_
    val PlannedOutage = parse_attribute (attribute ("""SwitchAction.PlannedOutage"""))_
    val SwitchingStepGroup = parse_attribute (attribute ("""SwitchAction.SwitchingStepGroup"""))_
    def parse (context: Context): SwitchAction =
    {
        SwitchAction(
            sup (context),
            kind (context),
            OperatedSwitch (context),
            PlannedOutage (context),
            SwitchingStepGroup (context)
        )
    }
}

/**
 * Kind of action on switch.
 */
case class SwitchActionKind
(

    override val sup: BasicElement,

    /**
     * Close the switch.
     */
    val close: String,

    /**
     * Disable (automatic) switch reclosing.
     */
    val disableReclosing: String,

    /**
     * Enable (automatic) switch reclosing.
     */
    val enableReclosing: String,

    /**
     * Open the switch.
     */
    val open: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[SwitchActionKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SwitchActionKind
extends
    Parseable[SwitchActionKind]
{
    val sup = BasicElement.parse _
    val close = parse_attribute (attribute ("""SwitchActionKind.close"""))_
    val disableReclosing = parse_attribute (attribute ("""SwitchActionKind.disableReclosing"""))_
    val enableReclosing = parse_attribute (attribute ("""SwitchActionKind.enableReclosing"""))_
    val open = parse_attribute (attribute ("""SwitchActionKind.open"""))_
    def parse (context: Context): SwitchActionKind =
    {
        SwitchActionKind(
            sup (context),
            close (context),
            disableReclosing (context),
            enableReclosing (context),
            open (context)
        )
    }
}

/**
 * A sequence of grouped or atomic steps intended to:
- de-energise equipment or part of the network for safe work, and/or
 * - bring back in service previously de-energised equipment or part of the network.
 */
case class SwitchingPlan
(

    override val sup: SwitchingStepGroup,

    /**
     * Purpose of  this plan, such as whether it is to move the state from normal to some abnormal condition, or to restore the normal state after an abnormal condition, or to perform some kind of optimisation such as correction of overload, voltage control, etc.
     */
    val purpose: String,

    /**
     * Ranking in comparison to other switching plans.
     */
    val rank: Int,

    /**
     * Outage that will be eliminated when this switching plan gets executed.
     */
    val Outage: String
)
extends
    Element
{
    def this () = { this (null, null, 0, null) }
    def SwitchingStepGroup: SwitchingStepGroup = sup.asInstanceOf[SwitchingStepGroup]
    override def copy (): Row = { return (clone ().asInstanceOf[SwitchingPlan]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SwitchingPlan
extends
    Parseable[SwitchingPlan]
{
    val sup = SwitchingStepGroup.parse _
    val purpose = parse_element (element ("""SwitchingPlan.purpose"""))_
    val rank = parse_element (element ("""SwitchingPlan.rank"""))_
    val Outage = parse_attribute (attribute ("""SwitchingPlan.Outage"""))_
    def parse (context: Context): SwitchingPlan =
    {
        SwitchingPlan(
            sup (context),
            purpose (context),
            toInteger (rank (context), context),
            Outage (context)
        )
    }
}

/**
 * Atomic switching step; can be part of a switching step group, or of the switching plan.
 */
case class SwitchingStep
(

    override val sup: BasicElement,

    /**
     * Free text description of this activity.
     */
    val description: String,

    /**
     * Actual date and time of this switching step.
     */
    val executedDateTime: String,

    /**
     * If true, the sequence number serves for presentation purposes only, and the activity itself may be executed at any time.
     */
    val isFreeSequence: Boolean,

    /**
     * Planned date and time of this switching step.
     */
    val plannedDateTime: String,

    /**
     * Order of this activity in the sequence of activities within the switching plan.
     */
    val sequenceNumber: Int,

    /**
     * Crew member responsible for this switching step.
     */
    val CrewMember: String,

    /**
     * Operator responsible for this switching step.
     */
    val Operator: String
)
extends
    Element
{
    def this () = { this (null, null, null, false, null, 0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[SwitchingStep]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SwitchingStep
extends
    Parseable[SwitchingStep]
{
    val sup = BasicElement.parse _
    val description = parse_element (element ("""SwitchingStep.description"""))_
    val executedDateTime = parse_element (element ("""SwitchingStep.executedDateTime"""))_
    val isFreeSequence = parse_element (element ("""SwitchingStep.isFreeSequence"""))_
    val plannedDateTime = parse_element (element ("""SwitchingStep.plannedDateTime"""))_
    val sequenceNumber = parse_element (element ("""SwitchingStep.sequenceNumber"""))_
    val CrewMember = parse_attribute (attribute ("""SwitchingStep.CrewMember"""))_
    val Operator = parse_attribute (attribute ("""SwitchingStep.Operator"""))_
    def parse (context: Context): SwitchingStep =
    {
        SwitchingStep(
            sup (context),
            description (context),
            executedDateTime (context),
            toBoolean (isFreeSequence (context), context),
            plannedDateTime (context),
            toInteger (sequenceNumber (context), context),
            CrewMember (context),
            Operator (context)
        )
    }
}

/**
 * A logical step, grouping atomic switching steps that are important to distinguish when they may change topology (e.g. placing a jumper between two cuts).
 */
case class SwitchingStepGroup
(

    override val sup: Document,

    /**
     * If true, the sequence number serves for presentation purposes only, and the activity itself may be executed at any time.
     */
    val isFreeSequence: Boolean,

    /**
     * Order of this activity in the sequence of activities within the switching plan.
     */
    val sequenceNumber: Int,

    /**
     * Switching plan to which this group belongs.
     */
    val SwitchingPlan: String
)
extends
    Element
{
    def this () = { this (null, false, 0, null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[SwitchingStepGroup]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SwitchingStepGroup
extends
    Parseable[SwitchingStepGroup]
{
    val sup = Document.parse _
    val isFreeSequence = parse_element (element ("""SwitchingStepGroup.isFreeSequence"""))_
    val sequenceNumber = parse_element (element ("""SwitchingStepGroup.sequenceNumber"""))_
    val SwitchingPlan = parse_attribute (attribute ("""SwitchingStepGroup.SwitchingPlan"""))_
    def parse (context: Context): SwitchingStepGroup =
    {
        SwitchingStepGroup(
            sup (context),
            toBoolean (isFreeSequence (context), context),
            toInteger (sequenceNumber (context), context),
            SwitchingPlan (context)
        )
    }
}

/**
 * Action on operation tag as a switching step.
 */
case class TagAction
(

    override val sup: SwitchingStep,

    /**
     * Kind of tag action.
     */
    val kind: String,

    /**
     * Tag associated with this tag action.
     */
    val OperationTag: String,

    /**
     * Group to which this step belongs.
     */
    val SwitchingStepGroup: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def SwitchingStep: SwitchingStep = sup.asInstanceOf[SwitchingStep]
    override def copy (): Row = { return (clone ().asInstanceOf[TagAction]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TagAction
extends
    Parseable[TagAction]
{
    val sup = SwitchingStep.parse _
    val kind = parse_attribute (attribute ("""TagAction.kind"""))_
    val OperationTag = parse_attribute (attribute ("""TagAction.OperationTag"""))_
    val SwitchingStepGroup = parse_attribute (attribute ("""TagAction.SwitchingStepGroup"""))_
    def parse (context: Context): TagAction =
    {
        TagAction(
            sup (context),
            kind (context),
            OperationTag (context),
            SwitchingStepGroup (context)
        )
    }
}

/**
 * Kind of action on tag.
 */
case class TagActionKind
(

    override val sup: BasicElement,

    /**
     * Place the tag.
     */
    val place: String,

    /**
     * Remove the tag.
     */
    val remove: String,

    /**
     * Verify the tag.
     */
    val verify: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TagActionKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TagActionKind
extends
    Parseable[TagActionKind]
{
    val sup = BasicElement.parse _
    val place = parse_attribute (attribute ("""TagActionKind.place"""))_
    val remove = parse_attribute (attribute ("""TagActionKind.remove"""))_
    val verify = parse_attribute (attribute ("""TagActionKind.verify"""))_
    def parse (context: Context): TagActionKind =
    {
        TagActionKind(
            sup (context),
            place (context),
            remove (context),
            verify (context)
        )
    }
}

/**
 * Kind of action on temporary equipment (such as cut, jumper, ground, energy source).
 */
case class TempEquipActionKind
(

    override val sup: BasicElement,

    /**
     * Place the jumper (close) or the cut (open).
     */
    val place: String,

    /**
     * Remove the jumper (open) or the cut (close).
     */
    val remove: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TempEquipActionKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TempEquipActionKind
extends
    Parseable[TempEquipActionKind]
{
    val sup = BasicElement.parse _
    val place = parse_attribute (attribute ("""TempEquipActionKind.place"""))_
    val remove = parse_attribute (attribute ("""TempEquipActionKind.remove"""))_
    def parse (context: Context): TempEquipActionKind =
    {
        TempEquipActionKind(
            sup (context),
            place (context),
            remove (context)
        )
    }
}

object _Operations
{
    def register: Unit =
    {
        ClearanceAction.register
        ClearanceActionKind.register
        ClearanceDocument.register
        CutAction.register
        EnergySourceAction.register
        GenericAction.register
        GroundAction.register
        Incident.register
        JumperAction.register
        OperationTag.register
        OperationalRestriction.register
        OperationalUpdatedRating.register
        Outage.register
        OutageSchedule.register
        PSREvent.register
        PSREventKind.register
        SafetyDocument.register
        ServicePointOutageSummary.register
        SwitchAction.register
        SwitchActionKind.register
        SwitchingPlan.register
        SwitchingStep.register
        SwitchingStepGroup.register
        TagAction.register
        TagActionKind.register
        TempEquipActionKind.register
    }
}
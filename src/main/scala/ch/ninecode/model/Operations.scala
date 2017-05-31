package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This package contains the core information classes that support operations and outage management applications.
 */

/**
 * Action on clearance document as a switching step.
 * @param sup Reference to the superclass object.
 * @param kind Clearance action to perform.
 * @param Clearance Clearance associated with this clearance action.
 * @param SwitchingStepGroup Group to which this step belongs.
 */
case class ClearanceAction
(
    override val sup: SwitchingStep,
    val kind: String,
    val Clearance: String,
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
    val kind = parse_attribute (attribute ("""ClearanceAction.kind"""))
    val Clearance = parse_attribute (attribute ("""ClearanceAction.Clearance"""))
    val SwitchingStepGroup = parse_attribute (attribute ("""ClearanceAction.SwitchingStepGroup"""))
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
 * @param sup Reference to the superclass object.
 * @param issue Issue clearance.
 * @param release Release clearance.
 * @param update Update clearance.
 */
case class ClearanceActionKind
(
    override val sup: BasicElement,
    val issue: String,
    val release: String,
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
    val issue = parse_attribute (attribute ("""ClearanceActionKind.issue"""))
    val release = parse_attribute (attribute ("""ClearanceActionKind.release"""))
    val update = parse_attribute (attribute ("""ClearanceActionKind.update"""))
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
 * @param sup Reference to the superclass object.
 * @param mustBeDeenergised If true, the equipment must be deenergised.
 * @param mustBeGrounded If true, the equipment must be grounded.
 * @param ClearanceAction Clearance action associated with this clearance.
 * @param TaggedPSRs All power system resources tagged through this clearance.
 */
case class ClearanceDocument
(
    override val sup: SafetyDocument,
    val mustBeDeenergised: Boolean,
    val mustBeGrounded: Boolean,
    val ClearanceAction: String,
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
    val mustBeDeenergised = parse_element (element ("""ClearanceDocument.mustBeDeenergised"""))
    val mustBeGrounded = parse_element (element ("""ClearanceDocument.mustBeGrounded"""))
    val ClearanceAction = parse_attribute (attribute ("""ClearanceDocument.ClearanceAction"""))
    val TaggedPSRs = parse_attributes (attribute ("""ClearanceDocument.TaggedPSRs"""))
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
 * @param sup Reference to the superclass object.
 * @param kind Switching action to perform.
 * @param Cut Cut on which this action is taken.
 * @param SwitchingStepGroup Group to which this step belongs.
 */
case class CutAction
(
    override val sup: SwitchingStep,
    val kind: String,
    val Cut: String,
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
    val kind = parse_attribute (attribute ("""CutAction.kind"""))
    val Cut = parse_attribute (attribute ("""CutAction.Cut"""))
    val SwitchingStepGroup = parse_attribute (attribute ("""CutAction.SwitchingStepGroup"""))
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
 * @param sup Reference to the superclass object.
 * @param kind Switching action to perform.
 * @param EnergySource Energy source on which this action is taken.
 * @param SwitchingStepGroup Group to which this step belongs.
 */
case class EnergySourceAction
(
    override val sup: SwitchingStep,
    val kind: String,
    val EnergySource: String,
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
    val kind = parse_attribute (attribute ("""EnergySourceAction.kind"""))
    val EnergySource = parse_attribute (attribute ("""EnergySourceAction.EnergySource"""))
    val SwitchingStepGroup = parse_attribute (attribute ("""EnergySourceAction.SwitchingStepGroup"""))
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
 * @param sup Reference to the superclass object.
 * @param SwitchingStepGroup Group to which this step belongs.
 */
case class GenericAction
(
    override val sup: SwitchingStep,
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
    val SwitchingStepGroup = parse_attribute (attribute ("""GenericAction.SwitchingStepGroup"""))
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
 * @param sup Reference to the superclass object.
 * @param kind Switching action to perform.
 * @param AlongACLineSegment The line segment that this ground action will affect.
 *        This is the only way to access relationship to clamp in case the ground needs to be placed along the line segment.
 * @param Ground Ground on which this action is taken.
 * @param GroundedEquipment Equipment being grounded with this operation.
 *        In case of placing a ground anywhere along a line segment, you must use the clamp (to get the distance from one terminal), so use the explicit relation with line segment. In all other cases (including placing the ground at a line segment terminal), reference to one or more conducting equipment is sufficient.
 * @param SwitchingStepGroup Group to which this step belongs.
 */
case class GroundAction
(
    override val sup: SwitchingStep,
    val kind: String,
    val AlongACLineSegment: String,
    val Ground: String,
    val GroundedEquipment: String,
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
    val kind = parse_attribute (attribute ("""GroundAction.kind"""))
    val AlongACLineSegment = parse_attribute (attribute ("""GroundAction.AlongACLineSegment"""))
    val Ground = parse_attribute (attribute ("""GroundAction.Ground"""))
    val GroundedEquipment = parse_attribute (attribute ("""GroundAction.GroundedEquipment"""))
    val SwitchingStepGroup = parse_attribute (attribute ("""GroundAction.SwitchingStepGroup"""))
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
 * @param sup Reference to the superclass object.
 * @param cause Cause of this incident.
 * @param Outage Outage for this incident.
 * @param Owner Operator who owns this incident.
 * @param Works All works addressing this incident.
 */
case class Incident
(
    override val sup: Document,
    val cause: String,
    val Outage: String,
    val Owner: String,
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
    val cause = parse_element (element ("""Incident.cause"""))
    val Outage = parse_attribute (attribute ("""Incident.Outage"""))
    val Owner = parse_attribute (attribute ("""Incident.Owner"""))
    val Works = parse_attributes (attribute ("""Incident.Works"""))
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
 * @param sup Reference to the superclass object.
 * @param kind Switching action to perform.
 * @param Jumper Jumper on which this action is taken.
 * @param SwitchingStepGroup Group to which this step belongs.
 */
case class JumperAction
(
    override val sup: SwitchingStep,
    val kind: String,
    val Jumper: String,
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
    val kind = parse_attribute (attribute ("""JumperAction.kind"""))
    val Jumper = parse_attribute (attribute ("""JumperAction.Jumper"""))
    val SwitchingStepGroup = parse_attribute (attribute ("""JumperAction.SwitchingStepGroup"""))
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
    val Asset: String,
    val PowerSystemResource: String,
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
    val Asset = parse_attribute (attribute ("""OperationTag.Asset"""))
    val PowerSystemResource = parse_attribute (attribute ("""OperationTag.PowerSystemResource"""))
    val TagAction = parse_attribute (attribute ("""OperationTag.TagAction"""))
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
 * @param sup Reference to the superclass object.
 * @param activePeriod Interval during which this restriction is applied.
 * @param restrictedValue Restricted (new) value; includes unit of measure and potentially multiplier.
 * @param Equipments All equipments to which this restriction applies.
 * @param ProductAssetModel Asset model to which this restriction applies.
 */
case class OperationalRestriction
(
    override val sup: Document,
    val activePeriod: String,
    val restrictedValue: String,
    val Equipments: List[String],
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
    val activePeriod = parse_attribute (attribute ("""OperationalRestriction.activePeriod"""))
    val restrictedValue = parse_attribute (attribute ("""OperationalRestriction.restrictedValue"""))
    val Equipments = parse_attributes (attribute ("""OperationalRestriction.Equipments"""))
    val ProductAssetModel = parse_attribute (attribute ("""OperationalRestriction.ProductAssetModel"""))
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
 * @param sup Reference to the superclass object.
 * @param changeType Type of operational updated rating, e.g. a derate, a rerate or a return to normal.
 * @param PlannedOutage Planned equipment outage with this updated rating.
 */
case class OperationalUpdatedRating
(
    override val sup: OperationalRestriction,
    val changeType: String,
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
    val changeType = parse_element (element ("""OperationalUpdatedRating.changeType"""))
    val PlannedOutage = parse_attribute (attribute ("""OperationalUpdatedRating.PlannedOutage"""))
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
 * @param sup Reference to the superclass object.
 * @param actualPeriod Actual outage period; end of the period corresponds to the actual restoration time.
 * @param cancelledDateTime Date and time planned outage has been cancelled.
 * @param cause One or more causes of this outage.
 *        Note: At present, this is a free text; could be replaced with a separate associated class in case we have multiple causes (e.g. OutageCauseType, inheriting from IdentifiedObject).
 * @param estimatedPeriod Estimated outage period.
 *        The start of the period makes sense in case of a planned outage only, whereas the end of the period corresponds to the estimated restoration time in general.
 * @param isPlanned True if planned, false otherwise (for example due to a breaker trip).
 * @param summary Summary counts of service points (customers) affected by this outage.
 * @param Equipments All equipments associated with this outage.
 * @param Incident Incident reported in trouble call that results in this outage.
 * @param OutageSchedule Outage schedule whose execution will result in this outage.
 * @param UsagePoints All usage points associated with this outage.
 */
case class Outage
(
    override val sup: Document,
    val actualPeriod: String,
    val cancelledDateTime: String,
    val cause: String,
    val estimatedPeriod: String,
    val isPlanned: Boolean,
    val summary: String,
    val Equipments: List[String],
    val Incident: String,
    val OutageSchedule: String,
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
    val actualPeriod = parse_attribute (attribute ("""Outage.actualPeriod"""))
    val cancelledDateTime = parse_element (element ("""Outage.cancelledDateTime"""))
    val cause = parse_element (element ("""Outage.cause"""))
    val estimatedPeriod = parse_attribute (attribute ("""Outage.estimatedPeriod"""))
    val isPlanned = parse_element (element ("""Outage.isPlanned"""))
    val summary = parse_attribute (attribute ("""Outage.summary"""))
    val Equipments = parse_attributes (attribute ("""Outage.Equipments"""))
    val Incident = parse_attribute (attribute ("""Outage.Incident"""))
    val OutageSchedule = parse_attribute (attribute ("""Outage.OutageSchedule"""))
    val UsagePoints = parse_attributes (attribute ("""Outage.UsagePoints"""))
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
 * @param sup Reference to the superclass object.
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
 * @param sup Reference to the superclass object.
 * @param kind Kind of event.
 * @param PowerSystemResource Power system resource that generated this event.
 */
case class PSREvent
(
    override val sup: ActivityRecord,
    val kind: String,
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
    val kind = parse_attribute (attribute ("""PSREvent.kind"""))
    val PowerSystemResource = parse_attribute (attribute ("""PSREvent.PowerSystemResource"""))
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
 * @param sup Reference to the superclass object.
 * @param inService Power system resource state change to in service.
 * @param other Other power system resource state change.
 * @param outOfService Power system resource state change to out of service.
 * @param pendingAdd Power system resource state change to pending add.
 * @param pendingRemove Power system resource state change to pending remove.
 * @param pendingReplace Power system resource state change to pending replace.
 * @param unknown Unknown power system resource state change.
 */
case class PSREventKind
(
    override val sup: BasicElement,
    val inService: String,
    val other: String,
    val outOfService: String,
    val pendingAdd: String,
    val pendingRemove: String,
    val pendingReplace: String,
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
    val inService = parse_attribute (attribute ("""PSREventKind.inService"""))
    val other = parse_attribute (attribute ("""PSREventKind.other"""))
    val outOfService = parse_attribute (attribute ("""PSREventKind.outOfService"""))
    val pendingAdd = parse_attribute (attribute ("""PSREventKind.pendingAdd"""))
    val pendingRemove = parse_attribute (attribute ("""PSREventKind.pendingRemove"""))
    val pendingReplace = parse_attribute (attribute ("""PSREventKind.pendingReplace"""))
    val unknown = parse_attribute (attribute ("""PSREventKind.unknown"""))
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
 * @param sup Reference to the superclass object.
 * @param SwitchingPlan Switching plan to which this safety document applies.
 */
case class SafetyDocument
(
    override val sup: Document,
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
    val SwitchingPlan = parse_attribute (attribute ("""SafetyDocument.SwitchingPlan"""))
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
 * @param sup Reference to the superclass object.
 * @param criticalCount Number of critical service (delivery) points affected by an outage.
 * @param totalCount Number of all service (delivery) points affected by an outage.
 */
case class ServicePointOutageSummary
(
    override val sup: BasicElement,
    val criticalCount: Int,
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
    val criticalCount = parse_element (element ("""ServicePointOutageSummary.criticalCount"""))
    val totalCount = parse_element (element ("""ServicePointOutageSummary.totalCount"""))
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
 * @param sup Reference to the superclass object.
 * @param kind Switching action to perform.
 * @param OperatedSwitch Switch that is the object of this switch action.
 * @param PlannedOutage Planned outage for whose scope this switch action applies.
 * @param SwitchingStepGroup Group to which this step belongs.
 */
case class SwitchAction
(
    override val sup: SwitchingStep,
    val kind: String,
    val OperatedSwitch: String,
    val PlannedOutage: String,
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
    val kind = parse_attribute (attribute ("""SwitchAction.kind"""))
    val OperatedSwitch = parse_attribute (attribute ("""SwitchAction.OperatedSwitch"""))
    val PlannedOutage = parse_attribute (attribute ("""SwitchAction.PlannedOutage"""))
    val SwitchingStepGroup = parse_attribute (attribute ("""SwitchAction.SwitchingStepGroup"""))
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
 * @param sup Reference to the superclass object.
 * @param close Close the switch.
 * @param disableReclosing Disable (automatic) switch reclosing.
 * @param enableReclosing Enable (automatic) switch reclosing.
 * @param open Open the switch.
 */
case class SwitchActionKind
(
    override val sup: BasicElement,
    val close: String,
    val disableReclosing: String,
    val enableReclosing: String,
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
    val close = parse_attribute (attribute ("""SwitchActionKind.close"""))
    val disableReclosing = parse_attribute (attribute ("""SwitchActionKind.disableReclosing"""))
    val enableReclosing = parse_attribute (attribute ("""SwitchActionKind.enableReclosing"""))
    val open = parse_attribute (attribute ("""SwitchActionKind.open"""))
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
 * @param sup Reference to the superclass object.
 * @param purpose Purpose of  this plan, such as whether it is to move the state from normal to some abnormal condition, or to restore the normal state after an abnormal condition, or to perform some kind of optimisation such as correction of overload, voltage control, etc.
 * @param rank Ranking in comparison to other switching plans.
 * @param Outage Outage that will be eliminated when this switching plan gets executed.
 */
case class SwitchingPlan
(
    override val sup: SwitchingStepGroup,
    val purpose: String,
    val rank: Int,
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
    val purpose = parse_element (element ("""SwitchingPlan.purpose"""))
    val rank = parse_element (element ("""SwitchingPlan.rank"""))
    val Outage = parse_attribute (attribute ("""SwitchingPlan.Outage"""))
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
 * @param sup Reference to the superclass object.
 * @param description Free text description of this activity.
 * @param executedDateTime Actual date and time of this switching step.
 * @param isFreeSequence If true, the sequence number serves for presentation purposes only, and the activity itself may be executed at any time.
 * @param plannedDateTime Planned date and time of this switching step.
 * @param sequenceNumber Order of this activity in the sequence of activities within the switching plan.
 * @param CrewMember Crew member responsible for this switching step.
 * @param Operator Operator responsible for this switching step.
 */
case class SwitchingStep
(
    override val sup: BasicElement,
    val description: String,
    val executedDateTime: String,
    val isFreeSequence: Boolean,
    val plannedDateTime: String,
    val sequenceNumber: Int,
    val CrewMember: String,
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
    val description = parse_element (element ("""SwitchingStep.description"""))
    val executedDateTime = parse_element (element ("""SwitchingStep.executedDateTime"""))
    val isFreeSequence = parse_element (element ("""SwitchingStep.isFreeSequence"""))
    val plannedDateTime = parse_element (element ("""SwitchingStep.plannedDateTime"""))
    val sequenceNumber = parse_element (element ("""SwitchingStep.sequenceNumber"""))
    val CrewMember = parse_attribute (attribute ("""SwitchingStep.CrewMember"""))
    val Operator = parse_attribute (attribute ("""SwitchingStep.Operator"""))
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
 * @param sup Reference to the superclass object.
 * @param isFreeSequence If true, the sequence number serves for presentation purposes only, and the activity itself may be executed at any time.
 * @param sequenceNumber Order of this activity in the sequence of activities within the switching plan.
 * @param SwitchingPlan Switching plan to which this group belongs.
 */
case class SwitchingStepGroup
(
    override val sup: Document,
    val isFreeSequence: Boolean,
    val sequenceNumber: Int,
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
    val isFreeSequence = parse_element (element ("""SwitchingStepGroup.isFreeSequence"""))
    val sequenceNumber = parse_element (element ("""SwitchingStepGroup.sequenceNumber"""))
    val SwitchingPlan = parse_attribute (attribute ("""SwitchingStepGroup.SwitchingPlan"""))
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
 * @param sup Reference to the superclass object.
 * @param kind Kind of tag action.
 * @param OperationTag Tag associated with this tag action.
 * @param SwitchingStepGroup Group to which this step belongs.
 */
case class TagAction
(
    override val sup: SwitchingStep,
    val kind: String,
    val OperationTag: String,
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
    val kind = parse_attribute (attribute ("""TagAction.kind"""))
    val OperationTag = parse_attribute (attribute ("""TagAction.OperationTag"""))
    val SwitchingStepGroup = parse_attribute (attribute ("""TagAction.SwitchingStepGroup"""))
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
 * @param sup Reference to the superclass object.
 * @param place Place the tag.
 * @param remove Remove the tag.
 * @param verify Verify the tag.
 */
case class TagActionKind
(
    override val sup: BasicElement,
    val place: String,
    val remove: String,
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
    val place = parse_attribute (attribute ("""TagActionKind.place"""))
    val remove = parse_attribute (attribute ("""TagActionKind.remove"""))
    val verify = parse_attribute (attribute ("""TagActionKind.verify"""))
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
 * @param sup Reference to the superclass object.
 * @param place Place the jumper (close) or the cut (open).
 * @param remove Remove the jumper (open) or the cut (close).
 */
case class TempEquipActionKind
(
    override val sup: BasicElement,
    val place: String,
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
    val place = parse_attribute (attribute ("""TempEquipActionKind.place"""))
    val remove = parse_attribute (attribute ("""TempEquipActionKind.remove"""))
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
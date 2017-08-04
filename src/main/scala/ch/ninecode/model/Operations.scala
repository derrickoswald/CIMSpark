package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

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
    kind: String,
    Clearance: String,
    SwitchingStepGroup: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def SwitchingStep: SwitchingStep = sup.asInstanceOf[SwitchingStep]
    override def copy (): Row = { clone ().asInstanceOf[ClearanceAction] }
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
        (if (null != kind) "\t\t<cim:ClearanceAction.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        (if (null != Clearance) "\t\t<cim:ClearanceAction.Clearance rdf:resource=\"#" + Clearance + "\"/>\n" else "") +
        (if (null != SwitchingStepGroup) "\t\t<cim:ClearanceAction.SwitchingStepGroup rdf:resource=\"#" + SwitchingStepGroup + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ClearanceAction rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ClearanceAction>\n"
    }
}

object ClearanceAction
extends
    Parseable[ClearanceAction]
{
    val kind: (Context) => String = parse_attribute (attribute ("""ClearanceAction.kind"""))
    val Clearance: (Context) => String = parse_attribute (attribute ("""ClearanceAction.Clearance"""))
    val SwitchingStepGroup: (Context) => String = parse_attribute (attribute ("""ClearanceAction.SwitchingStepGroup"""))
    def parse (context: Context): ClearanceAction =
    {
        ClearanceAction(
            SwitchingStep.parse (context),
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
    issue: String,
    release: String,
    update: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ClearanceActionKind] }
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
        (if (null != issue) "\t\t<cim:ClearanceActionKind.issue rdf:resource=\"#" + issue + "\"/>\n" else "") +
        (if (null != release) "\t\t<cim:ClearanceActionKind.release rdf:resource=\"#" + release + "\"/>\n" else "") +
        (if (null != update) "\t\t<cim:ClearanceActionKind.update rdf:resource=\"#" + update + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ClearanceActionKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ClearanceActionKind>\n"
    }
}

object ClearanceActionKind
extends
    Parseable[ClearanceActionKind]
{
    val issue: (Context) => String = parse_attribute (attribute ("""ClearanceActionKind.issue"""))
    val release: (Context) => String = parse_attribute (attribute ("""ClearanceActionKind.release"""))
    val update: (Context) => String = parse_attribute (attribute ("""ClearanceActionKind.update"""))
    def parse (context: Context): ClearanceActionKind =
    {
        ClearanceActionKind(
            BasicElement.parse (context),
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
    mustBeDeenergised: Boolean,
    mustBeGrounded: Boolean,
    ClearanceAction: String,
    TaggedPSRs: List[String]
)
extends
    Element
{
    def this () = { this (null, false, false, null, List()) }
    def SafetyDocument: SafetyDocument = sup.asInstanceOf[SafetyDocument]
    override def copy (): Row = { clone ().asInstanceOf[ClearanceDocument] }
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
        "\t\t<cim:ClearanceDocument.mustBeDeenergised>" + mustBeDeenergised + "</cim:ClearanceDocument.mustBeDeenergised>\n" +
        "\t\t<cim:ClearanceDocument.mustBeGrounded>" + mustBeGrounded + "</cim:ClearanceDocument.mustBeGrounded>\n" +
        (if (null != ClearanceAction) "\t\t<cim:ClearanceDocument.ClearanceAction rdf:resource=\"#" + ClearanceAction + "\"/>\n" else "") +
        (if (null != TaggedPSRs) TaggedPSRs.map (x => "\t\t<cim:ClearanceDocument.TaggedPSRs rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:ClearanceDocument rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ClearanceDocument>\n"
    }
}

object ClearanceDocument
extends
    Parseable[ClearanceDocument]
{
    val mustBeDeenergised: (Context) => String = parse_element (element ("""ClearanceDocument.mustBeDeenergised"""))
    val mustBeGrounded: (Context) => String = parse_element (element ("""ClearanceDocument.mustBeGrounded"""))
    val ClearanceAction: (Context) => String = parse_attribute (attribute ("""ClearanceDocument.ClearanceAction"""))
    val TaggedPSRs: (Context) => List[String] = parse_attributes (attribute ("""ClearanceDocument.TaggedPSRs"""))
    def parse (context: Context): ClearanceDocument =
    {
        ClearanceDocument(
            SafetyDocument.parse (context),
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
    kind: String,
    Cut: String,
    SwitchingStepGroup: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def SwitchingStep: SwitchingStep = sup.asInstanceOf[SwitchingStep]
    override def copy (): Row = { clone ().asInstanceOf[CutAction] }
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
        (if (null != kind) "\t\t<cim:CutAction.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        (if (null != Cut) "\t\t<cim:CutAction.Cut rdf:resource=\"#" + Cut + "\"/>\n" else "") +
        (if (null != SwitchingStepGroup) "\t\t<cim:CutAction.SwitchingStepGroup rdf:resource=\"#" + SwitchingStepGroup + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CutAction rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CutAction>\n"
    }
}

object CutAction
extends
    Parseable[CutAction]
{
    val kind: (Context) => String = parse_attribute (attribute ("""CutAction.kind"""))
    val Cut: (Context) => String = parse_attribute (attribute ("""CutAction.Cut"""))
    val SwitchingStepGroup: (Context) => String = parse_attribute (attribute ("""CutAction.SwitchingStepGroup"""))
    def parse (context: Context): CutAction =
    {
        CutAction(
            SwitchingStep.parse (context),
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
    kind: String,
    EnergySource: String,
    SwitchingStepGroup: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def SwitchingStep: SwitchingStep = sup.asInstanceOf[SwitchingStep]
    override def copy (): Row = { clone ().asInstanceOf[EnergySourceAction] }
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
        (if (null != kind) "\t\t<cim:EnergySourceAction.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        (if (null != EnergySource) "\t\t<cim:EnergySourceAction.EnergySource rdf:resource=\"#" + EnergySource + "\"/>\n" else "") +
        (if (null != SwitchingStepGroup) "\t\t<cim:EnergySourceAction.SwitchingStepGroup rdf:resource=\"#" + SwitchingStepGroup + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EnergySourceAction rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EnergySourceAction>\n"
    }
}

object EnergySourceAction
extends
    Parseable[EnergySourceAction]
{
    val kind: (Context) => String = parse_attribute (attribute ("""EnergySourceAction.kind"""))
    val EnergySource: (Context) => String = parse_attribute (attribute ("""EnergySourceAction.EnergySource"""))
    val SwitchingStepGroup: (Context) => String = parse_attribute (attribute ("""EnergySourceAction.SwitchingStepGroup"""))
    def parse (context: Context): EnergySourceAction =
    {
        EnergySourceAction(
            SwitchingStep.parse (context),
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
    SwitchingStepGroup: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def SwitchingStep: SwitchingStep = sup.asInstanceOf[SwitchingStep]
    override def copy (): Row = { clone ().asInstanceOf[GenericAction] }
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
        (if (null != SwitchingStepGroup) "\t\t<cim:GenericAction.SwitchingStepGroup rdf:resource=\"#" + SwitchingStepGroup + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:GenericAction rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GenericAction>\n"
    }
}

object GenericAction
extends
    Parseable[GenericAction]
{
    val SwitchingStepGroup: (Context) => String = parse_attribute (attribute ("""GenericAction.SwitchingStepGroup"""))
    def parse (context: Context): GenericAction =
    {
        GenericAction(
            SwitchingStep.parse (context),
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
    kind: String,
    AlongACLineSegment: String,
    Ground: String,
    GroundedEquipment: String,
    SwitchingStepGroup: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def SwitchingStep: SwitchingStep = sup.asInstanceOf[SwitchingStep]
    override def copy (): Row = { clone ().asInstanceOf[GroundAction] }
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
        (if (null != kind) "\t\t<cim:GroundAction.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        (if (null != AlongACLineSegment) "\t\t<cim:GroundAction.AlongACLineSegment rdf:resource=\"#" + AlongACLineSegment + "\"/>\n" else "") +
        (if (null != Ground) "\t\t<cim:GroundAction.Ground rdf:resource=\"#" + Ground + "\"/>\n" else "") +
        (if (null != GroundedEquipment) "\t\t<cim:GroundAction.GroundedEquipment rdf:resource=\"#" + GroundedEquipment + "\"/>\n" else "") +
        (if (null != SwitchingStepGroup) "\t\t<cim:GroundAction.SwitchingStepGroup rdf:resource=\"#" + SwitchingStepGroup + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:GroundAction rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:GroundAction>\n"
    }
}

object GroundAction
extends
    Parseable[GroundAction]
{
    val kind: (Context) => String = parse_attribute (attribute ("""GroundAction.kind"""))
    val AlongACLineSegment: (Context) => String = parse_attribute (attribute ("""GroundAction.AlongACLineSegment"""))
    val Ground: (Context) => String = parse_attribute (attribute ("""GroundAction.Ground"""))
    val GroundedEquipment: (Context) => String = parse_attribute (attribute ("""GroundAction.GroundedEquipment"""))
    val SwitchingStepGroup: (Context) => String = parse_attribute (attribute ("""GroundAction.SwitchingStepGroup"""))
    def parse (context: Context): GroundAction =
    {
        GroundAction(
            SwitchingStep.parse (context),
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
    cause: String,
    Outage: String,
    Owner: String,
    Works: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, List()) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[Incident] }
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
        (if (null != cause) "\t\t<cim:Incident.cause>" + cause + "</cim:Incident.cause>\n" else "") +
        (if (null != Outage) "\t\t<cim:Incident.Outage rdf:resource=\"#" + Outage + "\"/>\n" else "") +
        (if (null != Owner) "\t\t<cim:Incident.Owner rdf:resource=\"#" + Owner + "\"/>\n" else "") +
        (if (null != Works) Works.map (x => "\t\t<cim:Incident.Works rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:Incident rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Incident>\n"
    }
}

object Incident
extends
    Parseable[Incident]
{
    val cause: (Context) => String = parse_element (element ("""Incident.cause"""))
    val Outage: (Context) => String = parse_attribute (attribute ("""Incident.Outage"""))
    val Owner: (Context) => String = parse_attribute (attribute ("""Incident.Owner"""))
    val Works: (Context) => List[String] = parse_attributes (attribute ("""Incident.Works"""))
    def parse (context: Context): Incident =
    {
        Incident(
            Document.parse (context),
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
    kind: String,
    Jumper: String,
    SwitchingStepGroup: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def SwitchingStep: SwitchingStep = sup.asInstanceOf[SwitchingStep]
    override def copy (): Row = { clone ().asInstanceOf[JumperAction] }
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
        (if (null != kind) "\t\t<cim:JumperAction.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        (if (null != Jumper) "\t\t<cim:JumperAction.Jumper rdf:resource=\"#" + Jumper + "\"/>\n" else "") +
        (if (null != SwitchingStepGroup) "\t\t<cim:JumperAction.SwitchingStepGroup rdf:resource=\"#" + SwitchingStepGroup + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:JumperAction rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:JumperAction>\n"
    }
}

object JumperAction
extends
    Parseable[JumperAction]
{
    val kind: (Context) => String = parse_attribute (attribute ("""JumperAction.kind"""))
    val Jumper: (Context) => String = parse_attribute (attribute ("""JumperAction.Jumper"""))
    val SwitchingStepGroup: (Context) => String = parse_attribute (attribute ("""JumperAction.SwitchingStepGroup"""))
    def parse (context: Context): JumperAction =
    {
        JumperAction(
            SwitchingStep.parse (context),
            kind (context),
            Jumper (context),
            SwitchingStepGroup (context)
        )
    }
}

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
    def this () = { this (null, null, null, null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[OperationTag] }
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
        (if (null != Asset) "\t\t<cim:OperationTag.Asset rdf:resource=\"#" + Asset + "\"/>\n" else "") +
        (if (null != PowerSystemResource) "\t\t<cim:OperationTag.PowerSystemResource rdf:resource=\"#" + PowerSystemResource + "\"/>\n" else "") +
        (if (null != TagAction) "\t\t<cim:OperationTag.TagAction rdf:resource=\"#" + TagAction + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OperationTag rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OperationTag>\n"
    }
}

object OperationTag
extends
    Parseable[OperationTag]
{
    val Asset: (Context) => String = parse_attribute (attribute ("""OperationTag.Asset"""))
    val PowerSystemResource: (Context) => String = parse_attribute (attribute ("""OperationTag.PowerSystemResource"""))
    val TagAction: (Context) => String = parse_attribute (attribute ("""OperationTag.TagAction"""))
    def parse (context: Context): OperationTag =
    {
        OperationTag(
            Document.parse (context),
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
    activePeriod: String,
    restrictedValue: String,
    Equipments: List[String],
    ProductAssetModel: String
)
extends
    Element
{
    def this () = { this (null, null, null, List(), null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[OperationalRestriction] }
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
        (if (null != activePeriod) "\t\t<cim:OperationalRestriction.activePeriod rdf:resource=\"#" + activePeriod + "\"/>\n" else "") +
        (if (null != restrictedValue) "\t\t<cim:OperationalRestriction.restrictedValue rdf:resource=\"#" + restrictedValue + "\"/>\n" else "") +
        (if (null != Equipments) Equipments.map (x => "\t\t<cim:OperationalRestriction.Equipments rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != ProductAssetModel) "\t\t<cim:OperationalRestriction.ProductAssetModel rdf:resource=\"#" + ProductAssetModel + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OperationalRestriction rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OperationalRestriction>\n"
    }
}

object OperationalRestriction
extends
    Parseable[OperationalRestriction]
{
    val activePeriod: (Context) => String = parse_attribute (attribute ("""OperationalRestriction.activePeriod"""))
    val restrictedValue: (Context) => String = parse_attribute (attribute ("""OperationalRestriction.restrictedValue"""))
    val Equipments: (Context) => List[String] = parse_attributes (attribute ("""OperationalRestriction.Equipments"""))
    val ProductAssetModel: (Context) => String = parse_attribute (attribute ("""OperationalRestriction.ProductAssetModel"""))
    def parse (context: Context): OperationalRestriction =
    {
        OperationalRestriction(
            Document.parse (context),
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
    changeType: String,
    PlannedOutage: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def OperationalRestriction: OperationalRestriction = sup.asInstanceOf[OperationalRestriction]
    override def copy (): Row = { clone ().asInstanceOf[OperationalUpdatedRating] }
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
        (if (null != changeType) "\t\t<cim:OperationalUpdatedRating.changeType>" + changeType + "</cim:OperationalUpdatedRating.changeType>\n" else "") +
        (if (null != PlannedOutage) "\t\t<cim:OperationalUpdatedRating.PlannedOutage rdf:resource=\"#" + PlannedOutage + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OperationalUpdatedRating rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OperationalUpdatedRating>\n"
    }
}

object OperationalUpdatedRating
extends
    Parseable[OperationalUpdatedRating]
{
    val changeType: (Context) => String = parse_element (element ("""OperationalUpdatedRating.changeType"""))
    val PlannedOutage: (Context) => String = parse_attribute (attribute ("""OperationalUpdatedRating.PlannedOutage"""))
    def parse (context: Context): OperationalUpdatedRating =
    {
        OperationalUpdatedRating(
            OperationalRestriction.parse (context),
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
    actualPeriod: String,
    cancelledDateTime: String,
    cause: String,
    estimatedPeriod: String,
    isPlanned: Boolean,
    summary: String,
    Equipments: List[String],
    Incident: String,
    OutageSchedule: String,
    UsagePoints: List[String]
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, false, null, List(), null, null, List()) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[Outage] }
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
        (if (null != actualPeriod) "\t\t<cim:Outage.actualPeriod rdf:resource=\"#" + actualPeriod + "\"/>\n" else "") +
        (if (null != cancelledDateTime) "\t\t<cim:Outage.cancelledDateTime>" + cancelledDateTime + "</cim:Outage.cancelledDateTime>\n" else "") +
        (if (null != cause) "\t\t<cim:Outage.cause>" + cause + "</cim:Outage.cause>\n" else "") +
        (if (null != estimatedPeriod) "\t\t<cim:Outage.estimatedPeriod rdf:resource=\"#" + estimatedPeriod + "\"/>\n" else "") +
        "\t\t<cim:Outage.isPlanned>" + isPlanned + "</cim:Outage.isPlanned>\n" +
        (if (null != summary) "\t\t<cim:Outage.summary rdf:resource=\"#" + summary + "\"/>\n" else "") +
        (if (null != Equipments) Equipments.map (x => "\t\t<cim:Outage.Equipments rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != Incident) "\t\t<cim:Outage.Incident rdf:resource=\"#" + Incident + "\"/>\n" else "") +
        (if (null != OutageSchedule) "\t\t<cim:Outage.OutageSchedule rdf:resource=\"#" + OutageSchedule + "\"/>\n" else "") +
        (if (null != UsagePoints) UsagePoints.map (x => "\t\t<cim:Outage.UsagePoints rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:Outage rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Outage>\n"
    }
}

object Outage
extends
    Parseable[Outage]
{
    val actualPeriod: (Context) => String = parse_attribute (attribute ("""Outage.actualPeriod"""))
    val cancelledDateTime: (Context) => String = parse_element (element ("""Outage.cancelledDateTime"""))
    val cause: (Context) => String = parse_element (element ("""Outage.cause"""))
    val estimatedPeriod: (Context) => String = parse_attribute (attribute ("""Outage.estimatedPeriod"""))
    val isPlanned: (Context) => String = parse_element (element ("""Outage.isPlanned"""))
    val summary: (Context) => String = parse_attribute (attribute ("""Outage.summary"""))
    val Equipments: (Context) => List[String] = parse_attributes (attribute ("""Outage.Equipments"""))
    val Incident: (Context) => String = parse_attribute (attribute ("""Outage.Incident"""))
    val OutageSchedule: (Context) => String = parse_attribute (attribute ("""Outage.OutageSchedule"""))
    val UsagePoints: (Context) => List[String] = parse_attributes (attribute ("""Outage.UsagePoints"""))
    def parse (context: Context): Outage =
    {
        Outage(
            Document.parse (context),
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
    override def copy (): Row = { clone ().asInstanceOf[OutageSchedule] }
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
        "\t<cim:OutageSchedule rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OutageSchedule>\n"
    }
}

object OutageSchedule
extends
    Parseable[OutageSchedule]
{
    def parse (context: Context): OutageSchedule =
    {
        OutageSchedule(
            Document.parse (context)
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
    kind: String,
    PowerSystemResource: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def ActivityRecord: ActivityRecord = sup.asInstanceOf[ActivityRecord]
    override def copy (): Row = { clone ().asInstanceOf[PSREvent] }
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
        (if (null != kind) "\t\t<cim:PSREvent.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        (if (null != PowerSystemResource) "\t\t<cim:PSREvent.PowerSystemResource rdf:resource=\"#" + PowerSystemResource + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PSREvent rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PSREvent>\n"
    }
}

object PSREvent
extends
    Parseable[PSREvent]
{
    val kind: (Context) => String = parse_attribute (attribute ("""PSREvent.kind"""))
    val PowerSystemResource: (Context) => String = parse_attribute (attribute ("""PSREvent.PowerSystemResource"""))
    def parse (context: Context): PSREvent =
    {
        PSREvent(
            ActivityRecord.parse (context),
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
    inService: String,
    other: String,
    outOfService: String,
    pendingAdd: String,
    pendingRemove: String,
    pendingReplace: String,
    unknown: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[PSREventKind] }
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
        (if (null != inService) "\t\t<cim:PSREventKind.inService rdf:resource=\"#" + inService + "\"/>\n" else "") +
        (if (null != other) "\t\t<cim:PSREventKind.other rdf:resource=\"#" + other + "\"/>\n" else "") +
        (if (null != outOfService) "\t\t<cim:PSREventKind.outOfService rdf:resource=\"#" + outOfService + "\"/>\n" else "") +
        (if (null != pendingAdd) "\t\t<cim:PSREventKind.pendingAdd rdf:resource=\"#" + pendingAdd + "\"/>\n" else "") +
        (if (null != pendingRemove) "\t\t<cim:PSREventKind.pendingRemove rdf:resource=\"#" + pendingRemove + "\"/>\n" else "") +
        (if (null != pendingReplace) "\t\t<cim:PSREventKind.pendingReplace rdf:resource=\"#" + pendingReplace + "\"/>\n" else "") +
        (if (null != unknown) "\t\t<cim:PSREventKind.unknown rdf:resource=\"#" + unknown + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PSREventKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PSREventKind>\n"
    }
}

object PSREventKind
extends
    Parseable[PSREventKind]
{
    val inService: (Context) => String = parse_attribute (attribute ("""PSREventKind.inService"""))
    val other: (Context) => String = parse_attribute (attribute ("""PSREventKind.other"""))
    val outOfService: (Context) => String = parse_attribute (attribute ("""PSREventKind.outOfService"""))
    val pendingAdd: (Context) => String = parse_attribute (attribute ("""PSREventKind.pendingAdd"""))
    val pendingRemove: (Context) => String = parse_attribute (attribute ("""PSREventKind.pendingRemove"""))
    val pendingReplace: (Context) => String = parse_attribute (attribute ("""PSREventKind.pendingReplace"""))
    val unknown: (Context) => String = parse_attribute (attribute ("""PSREventKind.unknown"""))
    def parse (context: Context): PSREventKind =
    {
        PSREventKind(
            BasicElement.parse (context),
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
    SwitchingPlan: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[SafetyDocument] }
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
        (if (null != SwitchingPlan) "\t\t<cim:SafetyDocument.SwitchingPlan rdf:resource=\"#" + SwitchingPlan + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SafetyDocument rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SafetyDocument>\n"
    }
}

object SafetyDocument
extends
    Parseable[SafetyDocument]
{
    val SwitchingPlan: (Context) => String = parse_attribute (attribute ("""SafetyDocument.SwitchingPlan"""))
    def parse (context: Context): SafetyDocument =
    {
        SafetyDocument(
            Document.parse (context),
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
    criticalCount: Int,
    totalCount: Int
)
extends
    Element
{
    def this () = { this (null, 0, 0) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ServicePointOutageSummary] }
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
        "\t\t<cim:ServicePointOutageSummary.criticalCount>" + criticalCount + "</cim:ServicePointOutageSummary.criticalCount>\n" +
        "\t\t<cim:ServicePointOutageSummary.totalCount>" + totalCount + "</cim:ServicePointOutageSummary.totalCount>\n"
    }
    override def export: String =
    {
        "\t<cim:ServicePointOutageSummary rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ServicePointOutageSummary>\n"
    }
}

object ServicePointOutageSummary
extends
    Parseable[ServicePointOutageSummary]
{
    val criticalCount: (Context) => String = parse_element (element ("""ServicePointOutageSummary.criticalCount"""))
    val totalCount: (Context) => String = parse_element (element ("""ServicePointOutageSummary.totalCount"""))
    def parse (context: Context): ServicePointOutageSummary =
    {
        ServicePointOutageSummary(
            BasicElement.parse (context),
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
    kind: String,
    OperatedSwitch: String,
    PlannedOutage: String,
    SwitchingStepGroup: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def SwitchingStep: SwitchingStep = sup.asInstanceOf[SwitchingStep]
    override def copy (): Row = { clone ().asInstanceOf[SwitchAction] }
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
        (if (null != kind) "\t\t<cim:SwitchAction.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        (if (null != OperatedSwitch) "\t\t<cim:SwitchAction.OperatedSwitch rdf:resource=\"#" + OperatedSwitch + "\"/>\n" else "") +
        (if (null != PlannedOutage) "\t\t<cim:SwitchAction.PlannedOutage rdf:resource=\"#" + PlannedOutage + "\"/>\n" else "") +
        (if (null != SwitchingStepGroup) "\t\t<cim:SwitchAction.SwitchingStepGroup rdf:resource=\"#" + SwitchingStepGroup + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SwitchAction rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SwitchAction>\n"
    }
}

object SwitchAction
extends
    Parseable[SwitchAction]
{
    val kind: (Context) => String = parse_attribute (attribute ("""SwitchAction.kind"""))
    val OperatedSwitch: (Context) => String = parse_attribute (attribute ("""SwitchAction.OperatedSwitch"""))
    val PlannedOutage: (Context) => String = parse_attribute (attribute ("""SwitchAction.PlannedOutage"""))
    val SwitchingStepGroup: (Context) => String = parse_attribute (attribute ("""SwitchAction.SwitchingStepGroup"""))
    def parse (context: Context): SwitchAction =
    {
        SwitchAction(
            SwitchingStep.parse (context),
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
    close: String,
    disableReclosing: String,
    enableReclosing: String,
    open: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[SwitchActionKind] }
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
        (if (null != close) "\t\t<cim:SwitchActionKind.close rdf:resource=\"#" + close + "\"/>\n" else "") +
        (if (null != disableReclosing) "\t\t<cim:SwitchActionKind.disableReclosing rdf:resource=\"#" + disableReclosing + "\"/>\n" else "") +
        (if (null != enableReclosing) "\t\t<cim:SwitchActionKind.enableReclosing rdf:resource=\"#" + enableReclosing + "\"/>\n" else "") +
        (if (null != open) "\t\t<cim:SwitchActionKind.open rdf:resource=\"#" + open + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SwitchActionKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SwitchActionKind>\n"
    }
}

object SwitchActionKind
extends
    Parseable[SwitchActionKind]
{
    val close: (Context) => String = parse_attribute (attribute ("""SwitchActionKind.close"""))
    val disableReclosing: (Context) => String = parse_attribute (attribute ("""SwitchActionKind.disableReclosing"""))
    val enableReclosing: (Context) => String = parse_attribute (attribute ("""SwitchActionKind.enableReclosing"""))
    val open: (Context) => String = parse_attribute (attribute ("""SwitchActionKind.open"""))
    def parse (context: Context): SwitchActionKind =
    {
        SwitchActionKind(
            BasicElement.parse (context),
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
    purpose: String,
    rank: Int,
    Outage: String
)
extends
    Element
{
    def this () = { this (null, null, 0, null) }
    def SwitchingStepGroup: SwitchingStepGroup = sup.asInstanceOf[SwitchingStepGroup]
    override def copy (): Row = { clone ().asInstanceOf[SwitchingPlan] }
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
        (if (null != purpose) "\t\t<cim:SwitchingPlan.purpose>" + purpose + "</cim:SwitchingPlan.purpose>\n" else "") +
        "\t\t<cim:SwitchingPlan.rank>" + rank + "</cim:SwitchingPlan.rank>\n" +
        (if (null != Outage) "\t\t<cim:SwitchingPlan.Outage rdf:resource=\"#" + Outage + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SwitchingPlan rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SwitchingPlan>\n"
    }
}

object SwitchingPlan
extends
    Parseable[SwitchingPlan]
{
    val purpose: (Context) => String = parse_element (element ("""SwitchingPlan.purpose"""))
    val rank: (Context) => String = parse_element (element ("""SwitchingPlan.rank"""))
    val Outage: (Context) => String = parse_attribute (attribute ("""SwitchingPlan.Outage"""))
    def parse (context: Context): SwitchingPlan =
    {
        SwitchingPlan(
            SwitchingStepGroup.parse (context),
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
    def this () = { this (null, null, null, false, null, 0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[SwitchingStep] }
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
        (if (null != description) "\t\t<cim:SwitchingStep.description>" + description + "</cim:SwitchingStep.description>\n" else "") +
        (if (null != executedDateTime) "\t\t<cim:SwitchingStep.executedDateTime>" + executedDateTime + "</cim:SwitchingStep.executedDateTime>\n" else "") +
        "\t\t<cim:SwitchingStep.isFreeSequence>" + isFreeSequence + "</cim:SwitchingStep.isFreeSequence>\n" +
        (if (null != plannedDateTime) "\t\t<cim:SwitchingStep.plannedDateTime>" + plannedDateTime + "</cim:SwitchingStep.plannedDateTime>\n" else "") +
        "\t\t<cim:SwitchingStep.sequenceNumber>" + sequenceNumber + "</cim:SwitchingStep.sequenceNumber>\n" +
        (if (null != CrewMember) "\t\t<cim:SwitchingStep.CrewMember rdf:resource=\"#" + CrewMember + "\"/>\n" else "") +
        (if (null != Operator) "\t\t<cim:SwitchingStep.Operator rdf:resource=\"#" + Operator + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SwitchingStep rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SwitchingStep>\n"
    }
}

object SwitchingStep
extends
    Parseable[SwitchingStep]
{
    val description: (Context) => String = parse_element (element ("""SwitchingStep.description"""))
    val executedDateTime: (Context) => String = parse_element (element ("""SwitchingStep.executedDateTime"""))
    val isFreeSequence: (Context) => String = parse_element (element ("""SwitchingStep.isFreeSequence"""))
    val plannedDateTime: (Context) => String = parse_element (element ("""SwitchingStep.plannedDateTime"""))
    val sequenceNumber: (Context) => String = parse_element (element ("""SwitchingStep.sequenceNumber"""))
    val CrewMember: (Context) => String = parse_attribute (attribute ("""SwitchingStep.CrewMember"""))
    val Operator: (Context) => String = parse_attribute (attribute ("""SwitchingStep.Operator"""))
    def parse (context: Context): SwitchingStep =
    {
        SwitchingStep(
            BasicElement.parse (context),
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
    isFreeSequence: Boolean,
    sequenceNumber: Int,
    SwitchingPlan: String
)
extends
    Element
{
    def this () = { this (null, false, 0, null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { clone ().asInstanceOf[SwitchingStepGroup] }
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
        "\t\t<cim:SwitchingStepGroup.isFreeSequence>" + isFreeSequence + "</cim:SwitchingStepGroup.isFreeSequence>\n" +
        "\t\t<cim:SwitchingStepGroup.sequenceNumber>" + sequenceNumber + "</cim:SwitchingStepGroup.sequenceNumber>\n" +
        (if (null != SwitchingPlan) "\t\t<cim:SwitchingStepGroup.SwitchingPlan rdf:resource=\"#" + SwitchingPlan + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SwitchingStepGroup rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SwitchingStepGroup>\n"
    }
}

object SwitchingStepGroup
extends
    Parseable[SwitchingStepGroup]
{
    val isFreeSequence: (Context) => String = parse_element (element ("""SwitchingStepGroup.isFreeSequence"""))
    val sequenceNumber: (Context) => String = parse_element (element ("""SwitchingStepGroup.sequenceNumber"""))
    val SwitchingPlan: (Context) => String = parse_attribute (attribute ("""SwitchingStepGroup.SwitchingPlan"""))
    def parse (context: Context): SwitchingStepGroup =
    {
        SwitchingStepGroup(
            Document.parse (context),
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
    kind: String,
    OperationTag: String,
    SwitchingStepGroup: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def SwitchingStep: SwitchingStep = sup.asInstanceOf[SwitchingStep]
    override def copy (): Row = { clone ().asInstanceOf[TagAction] }
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
        (if (null != kind) "\t\t<cim:TagAction.kind rdf:resource=\"#" + kind + "\"/>\n" else "") +
        (if (null != OperationTag) "\t\t<cim:TagAction.OperationTag rdf:resource=\"#" + OperationTag + "\"/>\n" else "") +
        (if (null != SwitchingStepGroup) "\t\t<cim:TagAction.SwitchingStepGroup rdf:resource=\"#" + SwitchingStepGroup + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TagAction rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TagAction>\n"
    }
}

object TagAction
extends
    Parseable[TagAction]
{
    val kind: (Context) => String = parse_attribute (attribute ("""TagAction.kind"""))
    val OperationTag: (Context) => String = parse_attribute (attribute ("""TagAction.OperationTag"""))
    val SwitchingStepGroup: (Context) => String = parse_attribute (attribute ("""TagAction.SwitchingStepGroup"""))
    def parse (context: Context): TagAction =
    {
        TagAction(
            SwitchingStep.parse (context),
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
    place: String,
    remove: String,
    verify: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TagActionKind] }
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
        (if (null != place) "\t\t<cim:TagActionKind.place rdf:resource=\"#" + place + "\"/>\n" else "") +
        (if (null != remove) "\t\t<cim:TagActionKind.remove rdf:resource=\"#" + remove + "\"/>\n" else "") +
        (if (null != verify) "\t\t<cim:TagActionKind.verify rdf:resource=\"#" + verify + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TagActionKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TagActionKind>\n"
    }
}

object TagActionKind
extends
    Parseable[TagActionKind]
{
    val place: (Context) => String = parse_attribute (attribute ("""TagActionKind.place"""))
    val remove: (Context) => String = parse_attribute (attribute ("""TagActionKind.remove"""))
    val verify: (Context) => String = parse_attribute (attribute ("""TagActionKind.verify"""))
    def parse (context: Context): TagActionKind =
    {
        TagActionKind(
            BasicElement.parse (context),
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
    place: String,
    remove: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TempEquipActionKind] }
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
        (if (null != place) "\t\t<cim:TempEquipActionKind.place rdf:resource=\"#" + place + "\"/>\n" else "") +
        (if (null != remove) "\t\t<cim:TempEquipActionKind.remove rdf:resource=\"#" + remove + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TempEquipActionKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TempEquipActionKind>\n"
    }
}

object TempEquipActionKind
extends
    Parseable[TempEquipActionKind]
{
    val place: (Context) => String = parse_attribute (attribute ("""TempEquipActionKind.place"""))
    val remove: (Context) => String = parse_attribute (attribute ("""TempEquipActionKind.remove"""))
    def parse (context: Context): TempEquipActionKind =
    {
        TempEquipActionKind(
            BasicElement.parse (context),
            place (context),
            remove (context)
        )
    }
}

private[ninecode] object _Operations
{
    def register: List[ClassInfo] =
    {
        List (
            ClearanceAction.register,
            ClearanceActionKind.register,
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
            PSREventKind.register,
            SafetyDocument.register,
            ServicePointOutageSummary.register,
            SwitchAction.register,
            SwitchActionKind.register,
            SwitchingPlan.register,
            SwitchingStep.register,
            SwitchingStepGroup.register,
            TagAction.register,
            TagActionKind.register,
            TempEquipActionKind.register
        )
    }
}
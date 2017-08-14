package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * The control area's reserve specification.
 * @param sup Reference to the superclass object.
 * @param lowerRegMarginReqt Lower regulating margin requirement in MW, the amount of generation that can be dropped by control in 10 minutes
 * @param opReserveReqt Operating reserve requirement in MW, where operating reserve is the generating capability that is fully available within 30 minutes.
 *        Operating reserve is composed of primary reserve (t less than 10 min) and secondary reserve (10 less than t less than 30 min).
 * @param primaryReserveReqt Primary reserve requirement in MW, where primary reserve is generating capability that is fully available within 10 minutes.
 *        Primary reserve is composed of spinning reserve and quick-start reserve.
 * @param raiseRegMarginReqt Raise regulating margin requirement in MW, the amount of generation that can be picked up by control in 10 minutes
 * @param spinningReserveReqt Spinning reserve requirement in MW, spinning reserve is generating capability that is presently synchronized to the network and is fully available within 10 minutes
 * @param Description Description of the object or instance.
 * @group InfEnergyScheduling
 * @groupname InfEnergyScheduling Package InfEnergyScheduling
 * @groupdesc InfEnergyScheduling This package provides the capability to schedule and account for transactions for the exchange of electric power between companies. It includes transations for megawatts which are generated, consumed, lost, passed through, sold and purchased. These classes are used by Accounting and Billing for Energy, Generation Capacity, Transmission, and Ancillary Services.
 */
case class AreaReserveSpec
(
    override val sup: BasicElement,
    lowerRegMarginReqt: Double,
    opReserveReqt: Double,
    primaryReserveReqt: Double,
    raiseRegMarginReqt: Double,
    spinningReserveReqt: Double,
    Description: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AreaReserveSpec] }
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
        "\t\t<cim:AreaReserveSpec.lowerRegMarginReqt>" + lowerRegMarginReqt + "</cim:AreaReserveSpec.lowerRegMarginReqt>\n" +
        "\t\t<cim:AreaReserveSpec.opReserveReqt>" + opReserveReqt + "</cim:AreaReserveSpec.opReserveReqt>\n" +
        "\t\t<cim:AreaReserveSpec.primaryReserveReqt>" + primaryReserveReqt + "</cim:AreaReserveSpec.primaryReserveReqt>\n" +
        "\t\t<cim:AreaReserveSpec.raiseRegMarginReqt>" + raiseRegMarginReqt + "</cim:AreaReserveSpec.raiseRegMarginReqt>\n" +
        "\t\t<cim:AreaReserveSpec.spinningReserveReqt>" + spinningReserveReqt + "</cim:AreaReserveSpec.spinningReserveReqt>\n" +
        (if (null != Description) "\t\t<cim:AreaReserveSpec.Description>" + Description + "</cim:AreaReserveSpec.Description>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AreaReserveSpec rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AreaReserveSpec>"
    }
}

object AreaReserveSpec
extends
    Parseable[AreaReserveSpec]
{
    val lowerRegMarginReqt = parse_element (element ("""AreaReserveSpec.lowerRegMarginReqt"""))
    val opReserveReqt = parse_element (element ("""AreaReserveSpec.opReserveReqt"""))
    val primaryReserveReqt = parse_element (element ("""AreaReserveSpec.primaryReserveReqt"""))
    val raiseRegMarginReqt = parse_element (element ("""AreaReserveSpec.raiseRegMarginReqt"""))
    val spinningReserveReqt = parse_element (element ("""AreaReserveSpec.spinningReserveReqt"""))
    val Description = parse_element (element ("""AreaReserveSpec.Description"""))
    def parse (context: Context): AreaReserveSpec =
    {
        AreaReserveSpec(
            BasicElement.parse (context),
            toDouble (lowerRegMarginReqt (context), context),
            toDouble (opReserveReqt (context), context),
            toDouble (primaryReserveReqt (context), context),
            toDouble (raiseRegMarginReqt (context), context),
            toDouble (spinningReserveReqt (context), context),
            Description (context)
        )
    }
}

/**
 * Control area emergency schedules
 * @param sup Reference to the superclass object.
 * @param emergencyScheduleMW Net tie MW.
 *        These are three entries, the current emergency schedule interchange and the two future schedules if they exist.
 * @param emergencyScheduleRampTime Ramp time, the ramping time for a schedule.
 *        This is calculated as the remaining time to ramp if a schedule is ramping. Measured in seconds, but can be negattive.
 * @param emergencyScheduleStartTime Net tie time,  the start time for a schedule.
 *        This is calculated as the current time if a schedule is ramping.
 * @param InternalControlArea <em>undocumented</em>
 * @group InfEnergyScheduling
 * @groupname InfEnergyScheduling Package InfEnergyScheduling
 * @groupdesc InfEnergyScheduling This package provides the capability to schedule and account for transactions for the exchange of electric power between companies. It includes transations for megawatts which are generated, consumed, lost, passed through, sold and purchased. These classes are used by Accounting and Billing for Energy, Generation Capacity, Transmission, and Ancillary Services.
 */
case class CurrentEmergencyScheduledInterchange
(
    override val sup: IdentifiedObject,
    emergencyScheduleMW: Double,
    emergencyScheduleRampTime: Int,
    emergencyScheduleStartTime: String,
    InternalControlArea: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[CurrentEmergencyScheduledInterchange] }
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
        "\t\t<cim:CurrentEmergencyScheduledInterchange.emergencyScheduleMW>" + emergencyScheduleMW + "</cim:CurrentEmergencyScheduledInterchange.emergencyScheduleMW>\n" +
        "\t\t<cim:CurrentEmergencyScheduledInterchange.emergencyScheduleRampTime>" + emergencyScheduleRampTime + "</cim:CurrentEmergencyScheduledInterchange.emergencyScheduleRampTime>\n" +
        (if (null != emergencyScheduleStartTime) "\t\t<cim:CurrentEmergencyScheduledInterchange.emergencyScheduleStartTime>" + emergencyScheduleStartTime + "</cim:CurrentEmergencyScheduledInterchange.emergencyScheduleStartTime>\n" else "") +
        (if (null != InternalControlArea) "\t\t<cim:CurrentEmergencyScheduledInterchange.InternalControlArea rdf:resource=\"#" + InternalControlArea + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CurrentEmergencyScheduledInterchange rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CurrentEmergencyScheduledInterchange>"
    }
}

object CurrentEmergencyScheduledInterchange
extends
    Parseable[CurrentEmergencyScheduledInterchange]
{
    val emergencyScheduleMW = parse_element (element ("""CurrentEmergencyScheduledInterchange.emergencyScheduleMW"""))
    val emergencyScheduleRampTime = parse_element (element ("""CurrentEmergencyScheduledInterchange.emergencyScheduleRampTime"""))
    val emergencyScheduleStartTime = parse_element (element ("""CurrentEmergencyScheduledInterchange.emergencyScheduleStartTime"""))
    val InternalControlArea = parse_attribute (attribute ("""CurrentEmergencyScheduledInterchange.InternalControlArea"""))
    def parse (context: Context): CurrentEmergencyScheduledInterchange =
    {
        CurrentEmergencyScheduledInterchange(
            IdentifiedObject.parse (context),
            toDouble (emergencyScheduleMW (context), context),
            toInteger (emergencyScheduleRampTime (context), context),
            emergencyScheduleStartTime (context),
            InternalControlArea (context)
        )
    }
}

/**
 * Control area current net tie (scheduled interchange) sent to real time dispatch.
 * @param sup Reference to the superclass object.
 * @param currentNetTieMW Current control area net tie MW (the sum of the tie line flows, i.e the sum of flows into and out of the control area), the current instantaneous scheduled interchange.
 * @param useEmergencySchedule Use Emergency Schedule
 *        Attribute Usage: Emergency use indicator, false = Emergency Schedular OFF, true = Emergency Schedular ON.
 * @param InternalControlArea <em>undocumented</em>
 * @group InfEnergyScheduling
 * @groupname InfEnergyScheduling Package InfEnergyScheduling
 * @groupdesc InfEnergyScheduling This package provides the capability to schedule and account for transactions for the exchange of electric power between companies. It includes transations for megawatts which are generated, consumed, lost, passed through, sold and purchased. These classes are used by Accounting and Billing for Energy, Generation Capacity, Transmission, and Ancillary Services.
 */
case class CurrentScheduledInterchange
(
    override val sup: BasicElement,
    currentNetTieMW: Double,
    useEmergencySchedule: Boolean,
    InternalControlArea: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, false, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[CurrentScheduledInterchange] }
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
        "\t\t<cim:CurrentScheduledInterchange.currentNetTieMW>" + currentNetTieMW + "</cim:CurrentScheduledInterchange.currentNetTieMW>\n" +
        "\t\t<cim:CurrentScheduledInterchange.useEmergencySchedule>" + useEmergencySchedule + "</cim:CurrentScheduledInterchange.useEmergencySchedule>\n" +
        (if (null != InternalControlArea) "\t\t<cim:CurrentScheduledInterchange.InternalControlArea rdf:resource=\"#" + InternalControlArea + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CurrentScheduledInterchange rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CurrentScheduledInterchange>"
    }
}

object CurrentScheduledInterchange
extends
    Parseable[CurrentScheduledInterchange]
{
    val currentNetTieMW = parse_element (element ("""CurrentScheduledInterchange.currentNetTieMW"""))
    val useEmergencySchedule = parse_element (element ("""CurrentScheduledInterchange.useEmergencySchedule"""))
    val InternalControlArea = parse_attribute (attribute ("""CurrentScheduledInterchange.InternalControlArea"""))
    def parse (context: Context): CurrentScheduledInterchange =
    {
        CurrentScheduledInterchange(
            BasicElement.parse (context),
            toDouble (currentNetTieMW (context), context),
            toBoolean (useEmergencySchedule (context), context),
            InternalControlArea (context)
        )
    }
}

/**
 * Curtailing entity must be providing at least one service to the EnergyTransaction.
 * The CurtailmentProfile must be completely contained within the EnergyProfile timeframe for this EnergyTransaction.
 * @param sup Reference to the superclass object.
 * @param EnergyTransaction An EnergyTransaction may be curtailed by any of the participating entities.
 * @group InfEnergyScheduling
 * @groupname InfEnergyScheduling Package InfEnergyScheduling
 * @groupdesc InfEnergyScheduling This package provides the capability to schedule and account for transactions for the exchange of electric power between companies. It includes transations for megawatts which are generated, consumed, lost, passed through, sold and purchased. These classes are used by Accounting and Billing for Energy, Generation Capacity, Transmission, and Ancillary Services.
 */
case class CurtailmentProfile
(
    override val sup: Profile,
    EnergyTransaction: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Profile: Profile = sup.asInstanceOf[Profile]
    override def copy (): Row = { clone ().asInstanceOf[CurtailmentProfile] }
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
        (if (null != EnergyTransaction) "\t\t<cim:CurtailmentProfile.EnergyTransaction rdf:resource=\"#" + EnergyTransaction + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CurtailmentProfile rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CurtailmentProfile>"
    }
}

object CurtailmentProfile
extends
    Parseable[CurtailmentProfile]
{
    val EnergyTransaction = parse_attribute (attribute ("""CurtailmentProfile.EnergyTransaction"""))
    def parse (context: Context): CurtailmentProfile =
    {
        CurtailmentProfile(
            Profile.parse (context),
            EnergyTransaction (context)
        )
    }
}

/**
 * A continuously variable component of a control area's MW net interchange schedule.
 * Dynamic schedules are sent and received by control areas.
 * @param sup Reference to the superclass object.
 * @param dynSchedSignRev Dynamic schedule sign reversal required (true/false)
 * @param dynSchedStatus The "active" or "inactive" status of the dynamic schedule
 * @param MktMeasurement <em>undocumented</em>
 * @param Receive_SubControlArea A control area can receive dynamic schedules from other control areas
 * @param Send_SubControlArea A control area can send dynamic schedules to other control areas
 * @group InfEnergyScheduling
 * @groupname InfEnergyScheduling Package InfEnergyScheduling
 * @groupdesc InfEnergyScheduling This package provides the capability to schedule and account for transactions for the exchange of electric power between companies. It includes transations for megawatts which are generated, consumed, lost, passed through, sold and purchased. These classes are used by Accounting and Billing for Energy, Generation Capacity, Transmission, and Ancillary Services.
 */
case class DynamicSchedule
(
    override val sup: BasicIntervalSchedule,
    dynSchedSignRev: Boolean,
    dynSchedStatus: String,
    MktMeasurement: String,
    Receive_SubControlArea: String,
    Send_SubControlArea: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def BasicIntervalSchedule: BasicIntervalSchedule = sup.asInstanceOf[BasicIntervalSchedule]
    override def copy (): Row = { clone ().asInstanceOf[DynamicSchedule] }
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
        "\t\t<cim:DynamicSchedule.dynSchedSignRev>" + dynSchedSignRev + "</cim:DynamicSchedule.dynSchedSignRev>\n" +
        (if (null != dynSchedStatus) "\t\t<cim:DynamicSchedule.dynSchedStatus>" + dynSchedStatus + "</cim:DynamicSchedule.dynSchedStatus>\n" else "") +
        (if (null != MktMeasurement) "\t\t<cim:DynamicSchedule.MktMeasurement rdf:resource=\"#" + MktMeasurement + "\"/>\n" else "") +
        (if (null != Receive_SubControlArea) "\t\t<cim:DynamicSchedule.Receive_SubControlArea rdf:resource=\"#" + Receive_SubControlArea + "\"/>\n" else "") +
        (if (null != Send_SubControlArea) "\t\t<cim:DynamicSchedule.Send_SubControlArea rdf:resource=\"#" + Send_SubControlArea + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:DynamicSchedule rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DynamicSchedule>"
    }
}

object DynamicSchedule
extends
    Parseable[DynamicSchedule]
{
    val dynSchedSignRev = parse_element (element ("""DynamicSchedule.dynSchedSignRev"""))
    val dynSchedStatus = parse_element (element ("""DynamicSchedule.dynSchedStatus"""))
    val MktMeasurement = parse_attribute (attribute ("""DynamicSchedule.MktMeasurement"""))
    val Receive_SubControlArea = parse_attribute (attribute ("""DynamicSchedule.Receive_SubControlArea"""))
    val Send_SubControlArea = parse_attribute (attribute ("""DynamicSchedule.Send_SubControlArea"""))
    def parse (context: Context): DynamicSchedule =
    {
        DynamicSchedule(
            BasicIntervalSchedule.parse (context),
            toBoolean (dynSchedSignRev (context), context),
            dynSchedStatus (context),
            MktMeasurement (context),
            Receive_SubControlArea (context),
            Send_SubControlArea (context)
        )
    }
}

/**
 * An EnergyProduct is offered commercially as a ContractOrTariff.
 * @param sup Reference to the superclass object.
 * @param GenerationProvider <em>undocumented</em>
 * @param ResoldBy_Marketer A Marketer may resell an EnergyProduct.
 * @param TitleHeldBy_Marketer A Marketer holds title to an EnergyProduct.
 * @group InfEnergyScheduling
 * @groupname InfEnergyScheduling Package InfEnergyScheduling
 * @groupdesc InfEnergyScheduling This package provides the capability to schedule and account for transactions for the exchange of electric power between companies. It includes transations for megawatts which are generated, consumed, lost, passed through, sold and purchased. These classes are used by Accounting and Billing for Energy, Generation Capacity, Transmission, and Ancillary Services.
 */
case class EnergyProduct
(
    override val sup: Agreement,
    GenerationProvider: String,
    ResoldBy_Marketer: List[String],
    TitleHeldBy_Marketer: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Agreement: Agreement = sup.asInstanceOf[Agreement]
    override def copy (): Row = { clone ().asInstanceOf[EnergyProduct] }
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
        (if (null != GenerationProvider) "\t\t<cim:EnergyProduct.GenerationProvider rdf:resource=\"#" + GenerationProvider + "\"/>\n" else "") +
        (if (null != ResoldBy_Marketer) ResoldBy_Marketer.map (x => "\t\t<cim:EnergyProduct.ResoldBy_Marketer rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != TitleHeldBy_Marketer) "\t\t<cim:EnergyProduct.TitleHeldBy_Marketer rdf:resource=\"#" + TitleHeldBy_Marketer + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EnergyProduct rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EnergyProduct>"
    }
}

object EnergyProduct
extends
    Parseable[EnergyProduct]
{
    val GenerationProvider = parse_attribute (attribute ("""EnergyProduct.GenerationProvider"""))
    val ResoldBy_Marketer = parse_attributes (attribute ("""EnergyProduct.ResoldBy_Marketer"""))
    val TitleHeldBy_Marketer = parse_attribute (attribute ("""EnergyProduct.TitleHeldBy_Marketer"""))
    def parse (context: Context): EnergyProduct =
    {
        EnergyProduct(
            Agreement.parse (context),
            GenerationProvider (context),
            ResoldBy_Marketer (context),
            TitleHeldBy_Marketer (context)
        )
    }
}

/**
 * An account for tracking inadvertent interchange versus time for each control area.
 * A control area may have more than one inadvertent account in order to track inadvertent over one or more specific tie points in addition to the usual overall net inadvertent. Separate accounts would also be used to track designated time periods, such as on-peak and off-peak.
 * @param sup Reference to the superclass object.
 * @param SubControlArea A control area can have one or more net inadvertent interchange accounts
 * @group InfEnergyScheduling
 * @groupname InfEnergyScheduling Package InfEnergyScheduling
 * @groupdesc InfEnergyScheduling This package provides the capability to schedule and account for transactions for the exchange of electric power between companies. It includes transations for megawatts which are generated, consumed, lost, passed through, sold and purchased. These classes are used by Accounting and Billing for Energy, Generation Capacity, Transmission, and Ancillary Services.
 */
case class InadvertentAccount
(
    override val sup: BasicElement,
    SubControlArea: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[InadvertentAccount] }
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
        (if (null != SubControlArea) "\t\t<cim:InadvertentAccount.SubControlArea rdf:resource=\"#" + SubControlArea + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:InadvertentAccount rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:InadvertentAccount>"
    }
}

object InadvertentAccount
extends
    Parseable[InadvertentAccount]
{
    val SubControlArea = parse_attribute (attribute ("""InadvertentAccount.SubControlArea"""))
    def parse (context: Context): InadvertentAccount =
    {
        InadvertentAccount(
            BasicElement.parse (context),
            SubControlArea (context)
        )
    }
}

/**
 * There is one internal control area in the system, which is the single control area in the primary network company.
 * Real time generation control affects only the internal control area.
 * @param sup Reference to the superclass object.
 * @param CurrentScheduledInterchange <em>undocumented</em>
 * @group InfEnergyScheduling
 * @groupname InfEnergyScheduling Package InfEnergyScheduling
 * @groupdesc InfEnergyScheduling This package provides the capability to schedule and account for transactions for the exchange of electric power between companies. It includes transations for megawatts which are generated, consumed, lost, passed through, sold and purchased. These classes are used by Accounting and Billing for Energy, Generation Capacity, Transmission, and Ancillary Services.
 */
case class InternalControlArea
(
    override val sup: IdentifiedObject,
    CurrentScheduledInterchange: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[InternalControlArea] }
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
        (if (null != CurrentScheduledInterchange) "\t\t<cim:InternalControlArea.CurrentScheduledInterchange rdf:resource=\"#" + CurrentScheduledInterchange + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:InternalControlArea rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:InternalControlArea>"
    }
}

object InternalControlArea
extends
    Parseable[InternalControlArea]
{
    val CurrentScheduledInterchange = parse_attribute (attribute ("""InternalControlArea.CurrentScheduledInterchange"""))
    def parse (context: Context): InternalControlArea =
    {
        InternalControlArea(
            IdentifiedObject.parse (context),
            CurrentScheduledInterchange (context)
        )
    }
}

/**
 * LossProfile is associated with an EnerrgyTransaction and must be completely contained within the time frame of the EnergyProfile associated with this EnergyTransaction.
 * @param sup Reference to the superclass object.
 * @param EnergyTransaction An EnergyTransaction may have a LossProfile.
 * @param HasLoss_1 Part of the LossProfile for an EnergyTransaction may be a loss for a TransmissionProvider.
 *        If so, the TransmissionProvider must be one of the participating entities in the EnergyTransaction.
 * @group InfEnergyScheduling
 * @groupname InfEnergyScheduling Package InfEnergyScheduling
 * @groupdesc InfEnergyScheduling This package provides the capability to schedule and account for transactions for the exchange of electric power between companies. It includes transations for megawatts which are generated, consumed, lost, passed through, sold and purchased. These classes are used by Accounting and Billing for Energy, Generation Capacity, Transmission, and Ancillary Services.
 */
case class LossProfile
(
    override val sup: Profile,
    EnergyTransaction: String,
    HasLoss_1: String
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
    def Profile: Profile = sup.asInstanceOf[Profile]
    override def copy (): Row = { clone ().asInstanceOf[LossProfile] }
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
        (if (null != EnergyTransaction) "\t\t<cim:LossProfile.EnergyTransaction rdf:resource=\"#" + EnergyTransaction + "\"/>\n" else "") +
        (if (null != HasLoss_1) "\t\t<cim:LossProfile.HasLoss_ rdf:resource=\"#" + HasLoss_1 + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:LossProfile rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LossProfile>"
    }
}

object LossProfile
extends
    Parseable[LossProfile]
{
    val EnergyTransaction = parse_attribute (attribute ("""LossProfile.EnergyTransaction"""))
    val HasLoss_1 = parse_attribute (attribute ("""LossProfile.HasLoss_"""))
    def parse (context: Context): LossProfile =
    {
        LossProfile(
            Profile.parse (context),
            EnergyTransaction (context),
            HasLoss_1 (context)
        )
    }
}

/**
 * @group InfEnergyScheduling
 * @groupname InfEnergyScheduling Package InfEnergyScheduling
 * @groupdesc InfEnergyScheduling This package provides the capability to schedule and account for transactions for the exchange of electric power between companies. It includes transations for megawatts which are generated, consumed, lost, passed through, sold and purchased. These classes are used by Accounting and Billing for Energy, Generation Capacity, Transmission, and Ancillary Services.
 */
case class TieLine
(
    override val sup: IdentifiedObject,
    EnergyTransaction: String,
    ParentOfB: String,
    SideA_SubControlArea: String,
    SideB_SubControlArea: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[TieLine] }
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
        (if (null != EnergyTransaction) "\t\t<cim:TieLine.EnergyTransaction rdf:resource=\"#" + EnergyTransaction + "\"/>\n" else "") +
        (if (null != ParentOfB) "\t\t<cim:TieLine.ParentOfB rdf:resource=\"#" + ParentOfB + "\"/>\n" else "") +
        (if (null != SideA_SubControlArea) "\t\t<cim:TieLine.SideA_SubControlArea rdf:resource=\"#" + SideA_SubControlArea + "\"/>\n" else "") +
        (if (null != SideB_SubControlArea) "\t\t<cim:TieLine.SideB_SubControlArea rdf:resource=\"#" + SideB_SubControlArea + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TieLine rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TieLine>"
    }
}

object TieLine
extends
    Parseable[TieLine]
{
    val EnergyTransaction = parse_attribute (attribute ("""TieLine.EnergyTransaction"""))
    val ParentOfB = parse_attribute (attribute ("""TieLine.ParentOfB"""))
    val SideA_SubControlArea = parse_attribute (attribute ("""TieLine.SideA_SubControlArea"""))
    val SideB_SubControlArea = parse_attribute (attribute ("""TieLine.SideB_SubControlArea"""))
    def parse (context: Context): TieLine =
    {
        TieLine(
            IdentifiedObject.parse (context),
            EnergyTransaction (context),
            ParentOfB (context),
            SideA_SubControlArea (context),
            SideB_SubControlArea (context)
        )
    }
}

/**
 * A corridor containing one or more rights of way
 * @param sup Reference to the superclass object.
 * @group InfEnergyScheduling
 * @groupname InfEnergyScheduling Package InfEnergyScheduling
 * @groupdesc InfEnergyScheduling This package provides the capability to schedule and account for transactions for the exchange of electric power between companies. It includes transations for megawatts which are generated, consumed, lost, passed through, sold and purchased. These classes are used by Accounting and Billing for Energy, Generation Capacity, Transmission, and Ancillary Services.
 */
case class TransmissionCorridor
(
    override val sup: PowerSystemResource
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[TransmissionCorridor] }
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
        "\t<cim:TransmissionCorridor rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TransmissionCorridor>"
    }
}

object TransmissionCorridor
extends
    Parseable[TransmissionCorridor]
{
    def parse (context: Context): TransmissionCorridor =
    {
        TransmissionCorridor(
            PowerSystemResource.parse (context)
        )
    }
}

/**
 * A collection of transmission lines that are close proximity to each other.
 * @param sup Reference to the superclass object.
 * @param TransmissionCorridor A transmission right-of-way is a member of a transmission corridor
 * @group InfEnergyScheduling
 * @groupname InfEnergyScheduling Package InfEnergyScheduling
 * @groupdesc InfEnergyScheduling This package provides the capability to schedule and account for transactions for the exchange of electric power between companies. It includes transations for megawatts which are generated, consumed, lost, passed through, sold and purchased. These classes are used by Accounting and Billing for Energy, Generation Capacity, Transmission, and Ancillary Services.
 */
case class TransmissionRightOfWay
(
    override val sup: PowerSystemResource,
    TransmissionCorridor: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[TransmissionRightOfWay] }
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
        (if (null != TransmissionCorridor) "\t\t<cim:TransmissionRightOfWay.TransmissionCorridor rdf:resource=\"#" + TransmissionCorridor + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TransmissionRightOfWay rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TransmissionRightOfWay>"
    }
}

object TransmissionRightOfWay
extends
    Parseable[TransmissionRightOfWay]
{
    val TransmissionCorridor = parse_attribute (attribute ("""TransmissionRightOfWay.TransmissionCorridor"""))
    def parse (context: Context): TransmissionRightOfWay =
    {
        TransmissionRightOfWay(
            PowerSystemResource.parse (context),
            TransmissionCorridor (context)
        )
    }
}

private[ninecode] object _InfEnergyScheduling
{
    def register: List[ClassInfo] =
    {
        List (
            AreaReserveSpec.register,
            CurrentEmergencyScheduledInterchange.register,
            CurrentScheduledInterchange.register,
            CurtailmentProfile.register,
            DynamicSchedule.register,
            EnergyProduct.register,
            InadvertentAccount.register,
            InternalControlArea.register,
            LossProfile.register,
            TieLine.register,
            TransmissionCorridor.register,
            TransmissionRightOfWay.register
        )
    }
}
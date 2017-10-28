package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * The control area's reserve specification.
 *
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AreaReserveSpec.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AreaReserveSpec.fields (position), value)
        emitelem (0, lowerRegMarginReqt)
        emitelem (1, opReserveReqt)
        emitelem (2, primaryReserveReqt)
        emitelem (3, raiseRegMarginReqt)
        emitelem (4, spinningReserveReqt)
        emitelem (5, Description)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AreaReserveSpec rdf:ID=\"%s\">\n%s\t</cim:AreaReserveSpec>".format (id, export_fields)
    }
}

object AreaReserveSpec
extends
    Parseable[AreaReserveSpec]
{
    val fields: Array[String] = Array[String] (
        "lowerRegMarginReqt",
        "opReserveReqt",
        "primaryReserveReqt",
        "raiseRegMarginReqt",
        "spinningReserveReqt",
        "Description"
    )
    val lowerRegMarginReqt: Fielder = parse_element (element (cls, fields(0)))
    val opReserveReqt: Fielder = parse_element (element (cls, fields(1)))
    val primaryReserveReqt: Fielder = parse_element (element (cls, fields(2)))
    val raiseRegMarginReqt: Fielder = parse_element (element (cls, fields(3)))
    val spinningReserveReqt: Fielder = parse_element (element (cls, fields(4)))
    val Description: Fielder = parse_element (element (cls, fields(5)))

    def parse (context: Context): AreaReserveSpec =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = AreaReserveSpec (
            BasicElement.parse (context),
            toDouble (mask (lowerRegMarginReqt (), 0)),
            toDouble (mask (opReserveReqt (), 1)),
            toDouble (mask (primaryReserveReqt (), 2)),
            toDouble (mask (raiseRegMarginReqt (), 3)),
            toDouble (mask (spinningReserveReqt (), 4)),
            mask (Description (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Control area emergency schedules
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param emergencyScheduleMW Net tie MW.
 *        These are three entries, the current emergency schedule interchange and the two future schedules if they exist.
 * @param emergencyScheduleRampTime Ramp time, the ramping time for a schedule.
 *        This is calculated as the remaining time to ramp if a schedule is ramping. Measured in seconds, but can be negattive.
 * @param emergencyScheduleStartTime Net tie time,  the start time for a schedule.
 *        This is calculated as the current time if a schedule is ramping.
 * @param InternalControlArea [[ch.ninecode.model.InternalControlArea InternalControlArea]] <em>undocumented</em>
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CurrentEmergencyScheduledInterchange.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CurrentEmergencyScheduledInterchange.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CurrentEmergencyScheduledInterchange.fields (position), value)
        emitelem (0, emergencyScheduleMW)
        emitelem (1, emergencyScheduleRampTime)
        emitelem (2, emergencyScheduleStartTime)
        emitattr (3, InternalControlArea)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CurrentEmergencyScheduledInterchange rdf:ID=\"%s\">\n%s\t</cim:CurrentEmergencyScheduledInterchange>".format (id, export_fields)
    }
}

object CurrentEmergencyScheduledInterchange
extends
    Parseable[CurrentEmergencyScheduledInterchange]
{
    val fields: Array[String] = Array[String] (
        "emergencyScheduleMW",
        "emergencyScheduleRampTime",
        "emergencyScheduleStartTime",
        "InternalControlArea"
    )
    val emergencyScheduleMW: Fielder = parse_element (element (cls, fields(0)))
    val emergencyScheduleRampTime: Fielder = parse_element (element (cls, fields(1)))
    val emergencyScheduleStartTime: Fielder = parse_element (element (cls, fields(2)))
    val InternalControlArea: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): CurrentEmergencyScheduledInterchange =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CurrentEmergencyScheduledInterchange (
            IdentifiedObject.parse (context),
            toDouble (mask (emergencyScheduleMW (), 0)),
            toInteger (mask (emergencyScheduleRampTime (), 1)),
            mask (emergencyScheduleStartTime (), 2),
            mask (InternalControlArea (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("InternalControlArea", "InternalControlArea", false)
    )
}

/**
 * Control area current net tie (scheduled interchange) sent to real time dispatch.
 *
 * @param sup Reference to the superclass object.
 * @param currentNetTieMW Current control area net tie MW (the sum of the tie line flows, i.e the sum of flows into and out of the control area), the current instantaneous scheduled interchange.
 * @param useEmergencySchedule Use Emergency Schedule
 *        Attribute Usage: Emergency use indicator, false = Emergency Schedular OFF, true = Emergency Schedular ON.
 * @param InternalControlArea [[ch.ninecode.model.InternalControlArea InternalControlArea]] <em>undocumented</em>
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CurrentScheduledInterchange.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (CurrentScheduledInterchange.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CurrentScheduledInterchange.fields (position), value)
        emitelem (0, currentNetTieMW)
        emitelem (1, useEmergencySchedule)
        emitattr (2, InternalControlArea)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CurrentScheduledInterchange rdf:ID=\"%s\">\n%s\t</cim:CurrentScheduledInterchange>".format (id, export_fields)
    }
}

object CurrentScheduledInterchange
extends
    Parseable[CurrentScheduledInterchange]
{
    val fields: Array[String] = Array[String] (
        "currentNetTieMW",
        "useEmergencySchedule",
        "InternalControlArea"
    )
    val currentNetTieMW: Fielder = parse_element (element (cls, fields(0)))
    val useEmergencySchedule: Fielder = parse_element (element (cls, fields(1)))
    val InternalControlArea: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): CurrentScheduledInterchange =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CurrentScheduledInterchange (
            BasicElement.parse (context),
            toDouble (mask (currentNetTieMW (), 0)),
            toBoolean (mask (useEmergencySchedule (), 1)),
            mask (InternalControlArea (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("InternalControlArea", "InternalControlArea", false)
    )
}

/**
 * Curtailing entity must be providing at least one service to the EnergyTransaction.
 *
 * The CurtailmentProfile must be completely contained within the EnergyProfile timeframe for this EnergyTransaction.
 *
 * @param sup [[ch.ninecode.model.Profile Profile]] Reference to the superclass object.
 * @param EnergyTransaction [[ch.ninecode.model.EnergyTransaction EnergyTransaction]] An EnergyTransaction may be curtailed by any of the participating entities.
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CurtailmentProfile.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CurtailmentProfile.fields (position), value)
        emitattr (0, EnergyTransaction)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CurtailmentProfile rdf:ID=\"%s\">\n%s\t</cim:CurtailmentProfile>".format (id, export_fields)
    }
}

object CurtailmentProfile
extends
    Parseable[CurtailmentProfile]
{
    val fields: Array[String] = Array[String] (
        "EnergyTransaction"
    )
    val EnergyTransaction: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): CurtailmentProfile =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CurtailmentProfile (
            Profile.parse (context),
            mask (EnergyTransaction (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("EnergyTransaction", "EnergyTransaction", false)
    )
}

/**
 * A continuously variable component of a control area's MW net interchange schedule.
 *
 * Dynamic schedules are sent and received by control areas.
 *
 * @param sup [[ch.ninecode.model.BasicIntervalSchedule BasicIntervalSchedule]] Reference to the superclass object.
 * @param dynSchedSignRev Dynamic schedule sign reversal required (true/false)
 * @param dynSchedStatus The "active" or "inactive" status of the dynamic schedule
 * @param MktMeasurement [[ch.ninecode.model.MktMeasurement MktMeasurement]] <em>undocumented</em>
 * @param Receive_SubControlArea [[ch.ninecode.model.SubControlArea SubControlArea]] A control area can receive dynamic schedules from other control areas
 * @param Send_SubControlArea [[ch.ninecode.model.SubControlArea SubControlArea]] A control area can send dynamic schedules to other control areas
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DynamicSchedule.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DynamicSchedule.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DynamicSchedule.fields (position), value)
        emitelem (0, dynSchedSignRev)
        emitelem (1, dynSchedStatus)
        emitattr (2, MktMeasurement)
        emitattr (3, Receive_SubControlArea)
        emitattr (4, Send_SubControlArea)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DynamicSchedule rdf:ID=\"%s\">\n%s\t</cim:DynamicSchedule>".format (id, export_fields)
    }
}

object DynamicSchedule
extends
    Parseable[DynamicSchedule]
{
    val fields: Array[String] = Array[String] (
        "dynSchedSignRev",
        "dynSchedStatus",
        "MktMeasurement",
        "Receive_SubControlArea",
        "Send_SubControlArea"
    )
    val dynSchedSignRev: Fielder = parse_element (element (cls, fields(0)))
    val dynSchedStatus: Fielder = parse_element (element (cls, fields(1)))
    val MktMeasurement: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Receive_SubControlArea: Fielder = parse_attribute (attribute (cls, fields(3)))
    val Send_SubControlArea: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): DynamicSchedule =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DynamicSchedule (
            BasicIntervalSchedule.parse (context),
            toBoolean (mask (dynSchedSignRev (), 0)),
            mask (dynSchedStatus (), 1),
            mask (MktMeasurement (), 2),
            mask (Receive_SubControlArea (), 3),
            mask (Send_SubControlArea (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("MktMeasurement", "MktMeasurement", false),
        Relationship ("Receive_SubControlArea", "SubControlArea", false),
        Relationship ("Send_SubControlArea", "SubControlArea", false)
    )
}

/**
 * An EnergyProduct is offered commercially as a ContractOrTariff.
 *
 * @param sup [[ch.ninecode.model.Agreement Agreement]] Reference to the superclass object.
 * @param GenerationProvider [[ch.ninecode.model.GenerationProvider GenerationProvider]] <em>undocumented</em>
 * @param ResoldBy_Marketer [[ch.ninecode.model.Marketer Marketer]] A Marketer may resell an EnergyProduct.
 * @param TitleHeldBy_Marketer [[ch.ninecode.model.Marketer Marketer]] A Marketer holds title to an EnergyProduct.
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EnergyProduct.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnergyProduct.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (EnergyProduct.fields (position), x))
        emitattr (0, GenerationProvider)
        emitattrs (1, ResoldBy_Marketer)
        emitattr (2, TitleHeldBy_Marketer)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnergyProduct rdf:ID=\"%s\">\n%s\t</cim:EnergyProduct>".format (id, export_fields)
    }
}

object EnergyProduct
extends
    Parseable[EnergyProduct]
{
    val fields: Array[String] = Array[String] (
        "GenerationProvider",
        "ResoldBy_Marketer",
        "TitleHeldBy_Marketer"
    )
    val GenerationProvider: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ResoldBy_Marketer: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val TitleHeldBy_Marketer: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: Context): EnergyProduct =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = EnergyProduct (
            Agreement.parse (context),
            mask (GenerationProvider (), 0),
            masks (ResoldBy_Marketer (), 1),
            mask (TitleHeldBy_Marketer (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("GenerationProvider", "GenerationProvider", false),
        Relationship ("ResoldBy_Marketer", "Marketer", true),
        Relationship ("TitleHeldBy_Marketer", "Marketer", false)
    )
}

/**
 * An account for tracking inadvertent interchange versus time for each control area.
 *
 * A control area may have more than one inadvertent account in order to track inadvertent over one or more specific tie points in addition to the usual overall net inadvertent. Separate accounts would also be used to track designated time periods, such as on-peak and off-peak.
 *
 * @param sup Reference to the superclass object.
 * @param SubControlArea [[ch.ninecode.model.SubControlArea SubControlArea]] A control area can have one or more net inadvertent interchange accounts
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = InadvertentAccount.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (InadvertentAccount.fields (position), value)
        emitattr (0, SubControlArea)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:InadvertentAccount rdf:ID=\"%s\">\n%s\t</cim:InadvertentAccount>".format (id, export_fields)
    }
}

object InadvertentAccount
extends
    Parseable[InadvertentAccount]
{
    val fields: Array[String] = Array[String] (
        "SubControlArea"
    )
    val SubControlArea: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): InadvertentAccount =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = InadvertentAccount (
            BasicElement.parse (context),
            mask (SubControlArea (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("SubControlArea", "SubControlArea", false)
    )
}

/**
 * There is one internal control area in the system, which is the single control area in the primary network company.
 *
 * Real time generation control affects only the internal control area.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param CurrentScheduledInterchange [[ch.ninecode.model.CurrentScheduledInterchange CurrentScheduledInterchange]] <em>undocumented</em>
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = InternalControlArea.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (InternalControlArea.fields (position), value)
        emitattr (0, CurrentScheduledInterchange)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:InternalControlArea rdf:ID=\"%s\">\n%s\t</cim:InternalControlArea>".format (id, export_fields)
    }
}

object InternalControlArea
extends
    Parseable[InternalControlArea]
{
    val fields: Array[String] = Array[String] (
        "CurrentScheduledInterchange"
    )
    val CurrentScheduledInterchange: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): InternalControlArea =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = InternalControlArea (
            IdentifiedObject.parse (context),
            mask (CurrentScheduledInterchange (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("CurrentScheduledInterchange", "CurrentScheduledInterchange", false)
    )
}

/**
 * LossProfile is associated with an EnerrgyTransaction and must be completely contained within the time frame of the EnergyProfile associated with this EnergyTransaction.
 *
 * @param sup [[ch.ninecode.model.Profile Profile]] Reference to the superclass object.
 * @param EnergyTransaction [[ch.ninecode.model.EnergyTransaction EnergyTransaction]] An EnergyTransaction may have a LossProfile.
 * @param HasLoss_1 [[ch.ninecode.model.TransmissionProvider TransmissionProvider]] Part of the LossProfile for an EnergyTransaction may be a loss for a TransmissionProvider.
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = LossProfile.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LossProfile.fields (position), value)
        emitattr (0, EnergyTransaction)
        emitattr (1, HasLoss_1)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LossProfile rdf:ID=\"%s\">\n%s\t</cim:LossProfile>".format (id, export_fields)
    }
}

object LossProfile
extends
    Parseable[LossProfile]
{
    val fields: Array[String] = Array[String] (
        "EnergyTransaction",
        "HasLoss_"
    )
    val EnergyTransaction: Fielder = parse_attribute (attribute (cls, fields(0)))
    val HasLoss_1: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): LossProfile =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = LossProfile (
            Profile.parse (context),
            mask (EnergyTransaction (), 0),
            mask (HasLoss_1 (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("EnergyTransaction", "EnergyTransaction", false),
        Relationship ("HasLoss_1", "TransmissionProvider", false)
    )
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
    ParentOfA: List[String],
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
    def this () = { this (null, null, List(), null, null, null) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TieLine.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TieLine.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (TieLine.fields (position), x))
        emitattr (0, EnergyTransaction)
        emitattrs (1, ParentOfA)
        emitattr (2, ParentOfB)
        emitattr (3, SideA_SubControlArea)
        emitattr (4, SideB_SubControlArea)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TieLine rdf:ID=\"%s\">\n%s\t</cim:TieLine>".format (id, export_fields)
    }
}

object TieLine
extends
    Parseable[TieLine]
{
    val fields: Array[String] = Array[String] (
        "EnergyTransaction",
        "ParentOfA",
        "ParentOfB",
        "SideA_SubControlArea",
        "SideB_SubControlArea"
    )
    val EnergyTransaction: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ParentOfA: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val ParentOfB: Fielder = parse_attribute (attribute (cls, fields(2)))
    val SideA_SubControlArea: Fielder = parse_attribute (attribute (cls, fields(3)))
    val SideB_SubControlArea: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: Context): TieLine =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TieLine (
            IdentifiedObject.parse (context),
            mask (EnergyTransaction (), 0),
            masks (ParentOfA (), 1),
            mask (ParentOfB (), 2),
            mask (SideA_SubControlArea (), 3),
            mask (SideB_SubControlArea (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("EnergyTransaction", "EnergyTransaction", false),
        Relationship ("ParentOfA", "ControlAreaOperator", true),
        Relationship ("ParentOfB", "CustomerConsumer", false),
        Relationship ("SideA_SubControlArea", "SubControlArea", false),
        Relationship ("SideB_SubControlArea", "SubControlArea", false)
    )
}

/**
 * A corridor containing one or more rights of way
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:TransmissionCorridor rdf:ID=\"%s\">\n%s\t</cim:TransmissionCorridor>".format (id, export_fields)
    }
}

object TransmissionCorridor
extends
    Parseable[TransmissionCorridor]
{

    def parse (context: Context): TransmissionCorridor =
    {
        implicit val ctx: Context = context
        val ret = TransmissionCorridor (
            PowerSystemResource.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * A collection of transmission lines that are close proximity to each other.
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param TransmissionCorridor [[ch.ninecode.model.TransmissionCorridor TransmissionCorridor]] A transmission right-of-way is a member of a transmission corridor
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TransmissionRightOfWay.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TransmissionRightOfWay.fields (position), value)
        emitattr (0, TransmissionCorridor)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TransmissionRightOfWay rdf:ID=\"%s\">\n%s\t</cim:TransmissionRightOfWay>".format (id, export_fields)
    }
}

object TransmissionRightOfWay
extends
    Parseable[TransmissionRightOfWay]
{
    val fields: Array[String] = Array[String] (
        "TransmissionCorridor"
    )
    val TransmissionCorridor: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): TransmissionRightOfWay =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TransmissionRightOfWay (
            PowerSystemResource.parse (context),
            mask (TransmissionCorridor (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("TransmissionCorridor", "TransmissionCorridor", false)
    )
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
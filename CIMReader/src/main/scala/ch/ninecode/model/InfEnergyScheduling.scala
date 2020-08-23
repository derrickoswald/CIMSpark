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
 * The control area's reserve specification.
 *
 * @param Element             Reference to the superclass object.
 * @param lowerRegMarginReqt  Lower regulating margin requirement in MW, the amount of generation that can be dropped by control in 10 minutes
 * @param opReserveReqt       Operating reserve requirement in MW, where operating reserve is the generating capability that is fully available within 30 minutes.
 *                            Operating reserve is composed of primary reserve (t less than 10 min) and secondary reserve (10 less than t less than 30 min).
 * @param primaryReserveReqt  Primary reserve requirement in MW, where primary reserve is generating capability that is fully available within 10 minutes.
 *                            Primary reserve is composed of spinning reserve and quick-start reserve.
 * @param raiseRegMarginReqt  Raise regulating margin requirement in MW, the amount of generation that can be picked up by control in 10 minutes
 * @param spinningReserveReqt Spinning reserve requirement in MW, spinning reserve is generating capability that is presently synchronized to the network and is fully available within 10 minutes
 * @param Description         Description of the object or instance.
 * @param SubControlArea      [[ch.ninecode.model.SubControlArea SubControlArea]] <em>undocumented</em>
 * @group InfEnergyScheduling
 * @groupname InfEnergyScheduling Package InfEnergyScheduling
 * @groupdesc InfEnergyScheduling This package provides the capability to schedule and account for transactions for the exchange of electric power between companies. It includes transations for megawatts which are generated, consumed, lost, passed through, sold and purchased. These classes are used by Accounting and Billing for Energy, Generation Capacity, Transmission, and Ancillary Services.
 */
final case class AreaReserveSpec
(
    Element: BasicElement = null,
    lowerRegMarginReqt: Double = 0.0,
    opReserveReqt: Double = 0.0,
    primaryReserveReqt: Double = 0.0,
    raiseRegMarginReqt: Double = 0.0,
    spinningReserveReqt: Double = 0.0,
    Description: String = null,
    SubControlArea: List[String] = null
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AreaReserveSpec.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (AreaReserveSpec.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (AreaReserveSpec.fields (position), x))

        emitelem (0, lowerRegMarginReqt)
        emitelem (1, opReserveReqt)
        emitelem (2, primaryReserveReqt)
        emitelem (3, raiseRegMarginReqt)
        emitelem (4, spinningReserveReqt)
        emitelem (5, Description)
        emitattrs (6, SubControlArea)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:AreaReserveSpec rdf:ID=\"%s\">\n%s\t</cim:AreaReserveSpec>".format (id, export_fields)
    }
}

object AreaReserveSpec
    extends
        CIMParseable[AreaReserveSpec]
{
    override val fields: Array[String] = Array [String](
        "lowerRegMarginReqt",
        "opReserveReqt",
        "primaryReserveReqt",
        "raiseRegMarginReqt",
        "spinningReserveReqt",
        "Description",
        "SubControlArea"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("SubControlArea", "SubControlArea", "0..*", "1")
    )
    val lowerRegMarginReqt: Fielder = parse_element (element (cls, fields (0)))
    val opReserveReqt: Fielder = parse_element (element (cls, fields (1)))
    val primaryReserveReqt: Fielder = parse_element (element (cls, fields (2)))
    val raiseRegMarginReqt: Fielder = parse_element (element (cls, fields (3)))
    val spinningReserveReqt: Fielder = parse_element (element (cls, fields (4)))
    val Description: Fielder = parse_element (element (cls, fields (5)))
    val SubControlArea: FielderMultiple = parse_attributes (attribute (cls, fields (6)))

    def parse (context: CIMContext): AreaReserveSpec =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = AreaReserveSpec (
            BasicElement.parse (context),
            toDouble (mask (lowerRegMarginReqt (), 0)),
            toDouble (mask (opReserveReqt (), 1)),
            toDouble (mask (primaryReserveReqt (), 2)),
            toDouble (mask (raiseRegMarginReqt (), 3)),
            toDouble (mask (spinningReserveReqt (), 4)),
            mask (Description (), 5),
            masks (SubControlArea (), 6)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AreaReserveSpec] = AreaReserveSpecSerializer
}

object AreaReserveSpecSerializer extends CIMSerializer[AreaReserveSpec]
{
    def write (kryo: Kryo, output: Output, obj: AreaReserveSpec): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.lowerRegMarginReqt),
            () => output.writeDouble (obj.opReserveReqt),
            () => output.writeDouble (obj.primaryReserveReqt),
            () => output.writeDouble (obj.raiseRegMarginReqt),
            () => output.writeDouble (obj.spinningReserveReqt),
            () => output.writeString (obj.Description),
            () => writeList (obj.SubControlArea, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf [BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AreaReserveSpec]): AreaReserveSpec =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf [BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AreaReserveSpec (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Control area emergency schedules
 *
 * @param IdentifiedObject           [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param emergencyScheduleMW        Net tie MW.
 *                                   These are three entries, the current emergency schedule interchange and the two future schedules if they exist.
 * @param emergencyScheduleRampTime  Ramp time, the ramping time for a schedule.
 *                                   This is calculated as the remaining time to ramp if a schedule is ramping. Measured in seconds, but can be negattive.
 * @param emergencyScheduleStartTime Net tie time,  the start time for a schedule.
 *                                   This is calculated as the current time if a schedule is ramping.
 * @param InternalControlArea        [[ch.ninecode.model.InternalControlArea InternalControlArea]] <em>undocumented</em>
 * @group InfEnergyScheduling
 * @groupname InfEnergyScheduling Package InfEnergyScheduling
 * @groupdesc InfEnergyScheduling This package provides the capability to schedule and account for transactions for the exchange of electric power between companies. It includes transations for megawatts which are generated, consumed, lost, passed through, sold and purchased. These classes are used by Accounting and Billing for Energy, Generation Capacity, Transmission, and Ancillary Services.
 */
final case class CurrentEmergencyScheduledInterchange
(
    IdentifiedObject: IdentifiedObject = null,
    emergencyScheduleMW: Double = 0.0,
    emergencyScheduleRampTime: Int = 0,
    emergencyScheduleStartTime: String = null,
    InternalControlArea: String = null
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
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[CurrentEmergencyScheduledInterchange]
{
    override val fields: Array[String] = Array [String](
        "emergencyScheduleMW",
        "emergencyScheduleRampTime",
        "emergencyScheduleStartTime",
        "InternalControlArea"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("InternalControlArea", "InternalControlArea", "1", "0..*")
    )
    val emergencyScheduleMW: Fielder = parse_element (element (cls, fields (0)))
    val emergencyScheduleRampTime: Fielder = parse_element (element (cls, fields (1)))
    val emergencyScheduleStartTime: Fielder = parse_element (element (cls, fields (2)))
    val InternalControlArea: Fielder = parse_attribute (attribute (cls, fields (3)))

    def parse (context: CIMContext): CurrentEmergencyScheduledInterchange =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
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

    def serializer: Serializer[CurrentEmergencyScheduledInterchange] = CurrentEmergencyScheduledInterchangeSerializer
}

object CurrentEmergencyScheduledInterchangeSerializer extends CIMSerializer[CurrentEmergencyScheduledInterchange]
{
    def write (kryo: Kryo, output: Output, obj: CurrentEmergencyScheduledInterchange): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.emergencyScheduleMW),
            () => output.writeInt (obj.emergencyScheduleRampTime),
            () => output.writeString (obj.emergencyScheduleStartTime),
            () => output.writeString (obj.InternalControlArea)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CurrentEmergencyScheduledInterchange]): CurrentEmergencyScheduledInterchange =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CurrentEmergencyScheduledInterchange (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readInt else 0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Control area current net tie (scheduled interchange) sent to real time dispatch.
 *
 * @param Element              Reference to the superclass object.
 * @param currentNetTieMW      Current control area net tie MW (the sum of the tie line flows, i.e the sum of flows into and out of the control area), the current instantaneous scheduled interchange.
 * @param useEmergencySchedule Use Emergency Schedule
 *                             Attribute Usage: Emergency use indicator, false = Emergency Schedular OFF, true = Emergency Schedular ON.
 * @param InternalControlArea  [[ch.ninecode.model.InternalControlArea InternalControlArea]] <em>undocumented</em>
 * @group InfEnergyScheduling
 * @groupname InfEnergyScheduling Package InfEnergyScheduling
 * @groupdesc InfEnergyScheduling This package provides the capability to schedule and account for transactions for the exchange of electric power between companies. It includes transations for megawatts which are generated, consumed, lost, passed through, sold and purchased. These classes are used by Accounting and Billing for Energy, Generation Capacity, Transmission, and Ancillary Services.
 */
final case class CurrentScheduledInterchange
(
    Element: BasicElement = null,
    currentNetTieMW: Double = 0.0,
    useEmergencySchedule: Boolean = false,
    InternalControlArea: String = null
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[CurrentScheduledInterchange]
{
    override val fields: Array[String] = Array [String](
        "currentNetTieMW",
        "useEmergencySchedule",
        "InternalControlArea"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("InternalControlArea", "InternalControlArea", "1", "0..1")
    )
    val currentNetTieMW: Fielder = parse_element (element (cls, fields (0)))
    val useEmergencySchedule: Fielder = parse_element (element (cls, fields (1)))
    val InternalControlArea: Fielder = parse_attribute (attribute (cls, fields (2)))

    def parse (context: CIMContext): CurrentScheduledInterchange =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = CurrentScheduledInterchange (
            BasicElement.parse (context),
            toDouble (mask (currentNetTieMW (), 0)),
            toBoolean (mask (useEmergencySchedule (), 1)),
            mask (InternalControlArea (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CurrentScheduledInterchange] = CurrentScheduledInterchangeSerializer
}

object CurrentScheduledInterchangeSerializer extends CIMSerializer[CurrentScheduledInterchange]
{
    def write (kryo: Kryo, output: Output, obj: CurrentScheduledInterchange): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.currentNetTieMW),
            () => output.writeBoolean (obj.useEmergencySchedule),
            () => output.writeString (obj.InternalControlArea)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf [BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CurrentScheduledInterchange]): CurrentScheduledInterchange =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf [BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CurrentScheduledInterchange (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readBoolean else false,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Curtailing entity must be providing at least one service to the EnergyTransaction.
 *
 * The CurtailmentProfile must be completely contained within the EnergyProfile timeframe for this EnergyTransaction.
 *
 * @param Profile           [[ch.ninecode.model.Profile Profile]] Reference to the superclass object.
 * @param EnergyTransaction [[ch.ninecode.model.EnergyTransaction EnergyTransaction]] An EnergyTransaction may be curtailed by any of the participating entities.
 * @group InfEnergyScheduling
 * @groupname InfEnergyScheduling Package InfEnergyScheduling
 * @groupdesc InfEnergyScheduling This package provides the capability to schedule and account for transactions for the exchange of electric power between companies. It includes transations for megawatts which are generated, consumed, lost, passed through, sold and purchased. These classes are used by Accounting and Billing for Energy, Generation Capacity, Transmission, and Ancillary Services.
 */
final case class CurtailmentProfile
(
    Profile: Profile = null,
    EnergyTransaction: String = null
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
    override def sup: Profile = Profile

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
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[CurtailmentProfile]
{
    override val fields: Array[String] = Array [String](
        "EnergyTransaction"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("EnergyTransaction", "EnergyTransaction", "1", "0..*")
    )
    val EnergyTransaction: Fielder = parse_attribute (attribute (cls, fields (0)))

    def parse (context: CIMContext): CurtailmentProfile =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = CurtailmentProfile (
            Profile.parse (context),
            mask (EnergyTransaction (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CurtailmentProfile] = CurtailmentProfileSerializer
}

object CurtailmentProfileSerializer extends CIMSerializer[CurtailmentProfile]
{
    def write (kryo: Kryo, output: Output, obj: CurtailmentProfile): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.EnergyTransaction)
        )
        ProfileSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CurtailmentProfile]): CurtailmentProfile =
    {
        val parent = ProfileSerializer.read (kryo, input, classOf [Profile])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CurtailmentProfile (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A continuously variable component of a control area's MW net interchange schedule.
 *
 * Dynamic schedules are sent and received by control areas.
 *
 * @param BasicIntervalSchedule  [[ch.ninecode.model.BasicIntervalSchedule BasicIntervalSchedule]] Reference to the superclass object.
 * @param dynSchedSignRev        Dynamic schedule sign reversal required (true/false)
 * @param dynSchedStatus         The "active" or "inactive" status of the dynamic schedule
 * @param MktMeasurement         [[ch.ninecode.model.MktMeasurement MktMeasurement]] <em>undocumented</em>
 * @param Receive_SubControlArea [[ch.ninecode.model.SubControlArea SubControlArea]] A control area can receive dynamic schedules from other control areas
 * @param Send_SubControlArea    [[ch.ninecode.model.SubControlArea SubControlArea]] A control area can send dynamic schedules to other control areas
 * @group InfEnergyScheduling
 * @groupname InfEnergyScheduling Package InfEnergyScheduling
 * @groupdesc InfEnergyScheduling This package provides the capability to schedule and account for transactions for the exchange of electric power between companies. It includes transations for megawatts which are generated, consumed, lost, passed through, sold and purchased. These classes are used by Accounting and Billing for Energy, Generation Capacity, Transmission, and Ancillary Services.
 */
final case class DynamicSchedule
(
    BasicIntervalSchedule: BasicIntervalSchedule = null,
    dynSchedSignRev: Boolean = false,
    dynSchedStatus: String = null,
    MktMeasurement: String = null,
    Receive_SubControlArea: String = null,
    Send_SubControlArea: String = null
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
    override def sup: BasicIntervalSchedule = BasicIntervalSchedule

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
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[DynamicSchedule]
{
    override val fields: Array[String] = Array [String](
        "dynSchedSignRev",
        "dynSchedStatus",
        "MktMeasurement",
        "Receive_SubControlArea",
        "Send_SubControlArea"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MktMeasurement", "MktMeasurement", "1", "0..*"),
        CIMRelationship ("Receive_SubControlArea", "SubControlArea", "1", "0..*"),
        CIMRelationship ("Send_SubControlArea", "SubControlArea", "1", "0..*")
    )
    val dynSchedSignRev: Fielder = parse_element (element (cls, fields (0)))
    val dynSchedStatus: Fielder = parse_element (element (cls, fields (1)))
    val MktMeasurement: Fielder = parse_attribute (attribute (cls, fields (2)))
    val Receive_SubControlArea: Fielder = parse_attribute (attribute (cls, fields (3)))
    val Send_SubControlArea: Fielder = parse_attribute (attribute (cls, fields (4)))

    def parse (context: CIMContext): DynamicSchedule =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
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

    def serializer: Serializer[DynamicSchedule] = DynamicScheduleSerializer
}

object DynamicScheduleSerializer extends CIMSerializer[DynamicSchedule]
{
    def write (kryo: Kryo, output: Output, obj: DynamicSchedule): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeBoolean (obj.dynSchedSignRev),
            () => output.writeString (obj.dynSchedStatus),
            () => output.writeString (obj.MktMeasurement),
            () => output.writeString (obj.Receive_SubControlArea),
            () => output.writeString (obj.Send_SubControlArea)
        )
        BasicIntervalScheduleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DynamicSchedule]): DynamicSchedule =
    {
        val parent = BasicIntervalScheduleSerializer.read (kryo, input, classOf [BasicIntervalSchedule])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = DynamicSchedule (
            parent,
            if (isSet (0)) input.readBoolean else false,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An EnergyProduct is offered commercially as a ContractOrTariff.
 *
 * @param Agreement            [[ch.ninecode.model.Agreement Agreement]] Reference to the superclass object.
 * @param EnergyTransactions   [[ch.ninecode.model.EnergyTransaction EnergyTransaction]] The "Source" for an EnergyTransaction is an EnergyProduct which is injected into a ControlArea.
 *                             Typically this is a ServicePoint.
 * @param GenerationProvider   [[ch.ninecode.model.GenerationProvider GenerationProvider]] <em>undocumented</em>
 * @param ResoldBy_Marketer    [[ch.ninecode.model.Marketer Marketer]] A Marketer may resell an EnergyProduct.
 * @param TitleHeldBy_Marketer [[ch.ninecode.model.Marketer Marketer]] A Marketer holds title to an EnergyProduct.
 * @group InfEnergyScheduling
 * @groupname InfEnergyScheduling Package InfEnergyScheduling
 * @groupdesc InfEnergyScheduling This package provides the capability to schedule and account for transactions for the exchange of electric power between companies. It includes transations for megawatts which are generated, consumed, lost, passed through, sold and purchased. These classes are used by Accounting and Billing for Energy, Generation Capacity, Transmission, and Ancillary Services.
 */
final case class EnergyProduct
(
    Agreement: Agreement = null,
    EnergyTransactions: List[String] = null,
    GenerationProvider: String = null,
    ResoldBy_Marketer: List[String] = null,
    TitleHeldBy_Marketer: String = null
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
    override def sup: Agreement = Agreement

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
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EnergyProduct.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnergyProduct.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (EnergyProduct.fields (position), x))

        emitattrs (0, EnergyTransactions)
        emitattr (1, GenerationProvider)
        emitattrs (2, ResoldBy_Marketer)
        emitattr (3, TitleHeldBy_Marketer)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:EnergyProduct rdf:ID=\"%s\">\n%s\t</cim:EnergyProduct>".format (id, export_fields)
    }
}

object EnergyProduct
    extends
        CIMParseable[EnergyProduct]
{
    override val fields: Array[String] = Array [String](
        "EnergyTransactions",
        "GenerationProvider",
        "ResoldBy_Marketer",
        "TitleHeldBy_Marketer"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("EnergyTransactions", "EnergyTransaction", "1..*", "1"),
        CIMRelationship ("GenerationProvider", "GenerationProvider", "1", "1..*"),
        CIMRelationship ("ResoldBy_Marketer", "Marketer", "0..*", "0..*"),
        CIMRelationship ("TitleHeldBy_Marketer", "Marketer", "0..1", "0..*")
    )
    val EnergyTransactions: FielderMultiple = parse_attributes (attribute (cls, fields (0)))
    val GenerationProvider: Fielder = parse_attribute (attribute (cls, fields (1)))
    val ResoldBy_Marketer: FielderMultiple = parse_attributes (attribute (cls, fields (2)))
    val TitleHeldBy_Marketer: Fielder = parse_attribute (attribute (cls, fields (3)))

    def parse (context: CIMContext): EnergyProduct =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = EnergyProduct (
            Agreement.parse (context),
            masks (EnergyTransactions (), 0),
            mask (GenerationProvider (), 1),
            masks (ResoldBy_Marketer (), 2),
            mask (TitleHeldBy_Marketer (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[EnergyProduct] = EnergyProductSerializer
}

object EnergyProductSerializer extends CIMSerializer[EnergyProduct]
{
    def write (kryo: Kryo, output: Output, obj: EnergyProduct): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.EnergyTransactions, output),
            () => output.writeString (obj.GenerationProvider),
            () => writeList (obj.ResoldBy_Marketer, output),
            () => output.writeString (obj.TitleHeldBy_Marketer)
        )
        AgreementSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EnergyProduct]): EnergyProduct =
    {
        val parent = AgreementSerializer.read (kryo, input, classOf [Agreement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = EnergyProduct (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An account for tracking inadvertent interchange versus time for each control area.
 *
 * A control area may have more than one inadvertent account in order to track inadvertent over one or more specific tie points in addition to the usual overall net inadvertent. Separate accounts would also be used to track designated time periods, such as on-peak and off-peak.
 *
 * @param Element        Reference to the superclass object.
 * @param SubControlArea [[ch.ninecode.model.SubControlArea SubControlArea]] A control area can have one or more net inadvertent interchange accounts
 * @group InfEnergyScheduling
 * @groupname InfEnergyScheduling Package InfEnergyScheduling
 * @groupdesc InfEnergyScheduling This package provides the capability to schedule and account for transactions for the exchange of electric power between companies. It includes transations for megawatts which are generated, consumed, lost, passed through, sold and purchased. These classes are used by Accounting and Billing for Energy, Generation Capacity, Transmission, and Ancillary Services.
 */
final case class InadvertentAccount
(
    Element: BasicElement = null,
    SubControlArea: String = null
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
    override def copy (): Row =
    {
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[InadvertentAccount]
{
    override val fields: Array[String] = Array [String](
        "SubControlArea"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("SubControlArea", "SubControlArea", "1", "0..*")
    )
    val SubControlArea: Fielder = parse_attribute (attribute (cls, fields (0)))

    def parse (context: CIMContext): InadvertentAccount =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = InadvertentAccount (
            BasicElement.parse (context),
            mask (SubControlArea (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[InadvertentAccount] = InadvertentAccountSerializer
}

object InadvertentAccountSerializer extends CIMSerializer[InadvertentAccount]
{
    def write (kryo: Kryo, output: Output, obj: InadvertentAccount): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.SubControlArea)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf [BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[InadvertentAccount]): InadvertentAccount =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf [BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = InadvertentAccount (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * There is one internal control area in the system, which is the single control area in the primary network company.
 *
 * Real time generation control affects only the internal control area.
 *
 * @param IdentifiedObject            [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param CurrentEmergencySI          [[ch.ninecode.model.CurrentEmergencyScheduledInterchange CurrentEmergencyScheduledInterchange]] <em>undocumented</em>
 * @param CurrentScheduledInterchange [[ch.ninecode.model.CurrentScheduledInterchange CurrentScheduledInterchange]] <em>undocumented</em>
 * @group InfEnergyScheduling
 * @groupname InfEnergyScheduling Package InfEnergyScheduling
 * @groupdesc InfEnergyScheduling This package provides the capability to schedule and account for transactions for the exchange of electric power between companies. It includes transations for megawatts which are generated, consumed, lost, passed through, sold and purchased. These classes are used by Accounting and Billing for Energy, Generation Capacity, Transmission, and Ancillary Services.
 */
final case class InternalControlArea
(
    IdentifiedObject: IdentifiedObject = null,
    CurrentEmergencySI: List[String] = null,
    CurrentScheduledInterchange: String = null
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
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = InternalControlArea.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (InternalControlArea.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (InternalControlArea.fields (position), x))

        emitattrs (0, CurrentEmergencySI)
        emitattr (1, CurrentScheduledInterchange)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:InternalControlArea rdf:ID=\"%s\">\n%s\t</cim:InternalControlArea>".format (id, export_fields)
    }
}

object InternalControlArea
    extends
        CIMParseable[InternalControlArea]
{
    override val fields: Array[String] = Array [String](
        "CurrentEmergencySI",
        "CurrentScheduledInterchange"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CurrentEmergencySI", "CurrentEmergencyScheduledInterchange", "0..*", "1"),
        CIMRelationship ("CurrentScheduledInterchange", "CurrentScheduledInterchange", "0..1", "1")
    )
    val CurrentEmergencySI: FielderMultiple = parse_attributes (attribute (cls, fields (0)))
    val CurrentScheduledInterchange: Fielder = parse_attribute (attribute (cls, fields (1)))

    def parse (context: CIMContext): InternalControlArea =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = InternalControlArea (
            IdentifiedObject.parse (context),
            masks (CurrentEmergencySI (), 0),
            mask (CurrentScheduledInterchange (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[InternalControlArea] = InternalControlAreaSerializer
}

object InternalControlAreaSerializer extends CIMSerializer[InternalControlArea]
{
    def write (kryo: Kryo, output: Output, obj: InternalControlArea): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.CurrentEmergencySI, output),
            () => output.writeString (obj.CurrentScheduledInterchange)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[InternalControlArea]): InternalControlArea =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = InternalControlArea (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * LossProfile is associated with an EnerrgyTransaction and must be completely contained within the time frame of the EnergyProfile associated with this EnergyTransaction.
 *
 * @param Profile           [[ch.ninecode.model.Profile Profile]] Reference to the superclass object.
 * @param EnergyTransaction [[ch.ninecode.model.EnergyTransaction EnergyTransaction]] An EnergyTransaction may have a LossProfile.
 * @param HasLoss_1         [[ch.ninecode.model.TransmissionProvider TransmissionProvider]] Part of the LossProfile for an EnergyTransaction may be a loss for a TransmissionProvider.
 *                          If so, the TransmissionProvider must be one of the participating entities in the EnergyTransaction.
 * @group InfEnergyScheduling
 * @groupname InfEnergyScheduling Package InfEnergyScheduling
 * @groupdesc InfEnergyScheduling This package provides the capability to schedule and account for transactions for the exchange of electric power between companies. It includes transations for megawatts which are generated, consumed, lost, passed through, sold and purchased. These classes are used by Accounting and Billing for Energy, Generation Capacity, Transmission, and Ancillary Services.
 */
final case class LossProfile
(
    Profile: Profile = null,
    EnergyTransaction: String = null,
    HasLoss_1: String = null
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
    override def sup: Profile = Profile

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
        clone ().asInstanceOf [Row]
    }

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
        CIMParseable[LossProfile]
{
    override val fields: Array[String] = Array [String](
        "EnergyTransaction",
        "HasLoss_"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("EnergyTransaction", "EnergyTransaction", "1", "0..*"),
        CIMRelationship ("HasLoss_1", "TransmissionProvider", "0..1", "0..*")
    )
    val EnergyTransaction: Fielder = parse_attribute (attribute (cls, fields (0)))
    val HasLoss_1: Fielder = parse_attribute (attribute (cls, fields (1)))

    def parse (context: CIMContext): LossProfile =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = LossProfile (
            Profile.parse (context),
            mask (EnergyTransaction (), 0),
            mask (HasLoss_1 (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[LossProfile] = LossProfileSerializer
}

object LossProfileSerializer extends CIMSerializer[LossProfile]
{
    def write (kryo: Kryo, output: Output, obj: LossProfile): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.EnergyTransaction),
            () => output.writeString (obj.HasLoss_1)
        )
        ProfileSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[LossProfile]): LossProfile =
    {
        val parent = ProfileSerializer.read (kryo, input, classOf [Profile])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = LossProfile (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfEnergyScheduling
 * @groupname InfEnergyScheduling Package InfEnergyScheduling
 * @groupdesc InfEnergyScheduling This package provides the capability to schedule and account for transactions for the exchange of electric power between companies. It includes transations for megawatts which are generated, consumed, lost, passed through, sold and purchased. These classes are used by Accounting and Billing for Energy, Generation Capacity, Transmission, and Ancillary Services.
 */
final case class TieLine
(
    IdentifiedObject: IdentifiedObject = null,
    EnergyTransaction: String = null,
    ParentOfA: List[String] = null,
    ParentOfB: String = null,
    SideA_SubControlArea: String = null,
    SideB_SubControlArea: String = null
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
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TieLine.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TieLine.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TieLine.fields (position), x))

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
        CIMParseable[TieLine]
{
    override val fields: Array[String] = Array [String](
        "EnergyTransaction",
        "ParentOfA",
        "ParentOfB",
        "SideA_SubControlArea",
        "SideB_SubControlArea"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("EnergyTransaction", "EnergyTransaction", "0..1", "0..*"),
        CIMRelationship ("ParentOfA", "ControlAreaOperator", "0..*", "0..*"),
        CIMRelationship ("ParentOfB", "CustomerConsumer", "0..1", "0..*"),
        CIMRelationship ("SideA_SubControlArea", "SubControlArea", "1", "0..*"),
        CIMRelationship ("SideB_SubControlArea", "SubControlArea", "1", "0..*")
    )
    val EnergyTransaction: Fielder = parse_attribute (attribute (cls, fields (0)))
    val ParentOfA: FielderMultiple = parse_attributes (attribute (cls, fields (1)))
    val ParentOfB: Fielder = parse_attribute (attribute (cls, fields (2)))
    val SideA_SubControlArea: Fielder = parse_attribute (attribute (cls, fields (3)))
    val SideB_SubControlArea: Fielder = parse_attribute (attribute (cls, fields (4)))

    def parse (context: CIMContext): TieLine =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
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

    def serializer: Serializer[TieLine] = TieLineSerializer
}

object TieLineSerializer extends CIMSerializer[TieLine]
{
    def write (kryo: Kryo, output: Output, obj: TieLine): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.EnergyTransaction),
            () => writeList (obj.ParentOfA, output),
            () => output.writeString (obj.ParentOfB),
            () => output.writeString (obj.SideA_SubControlArea),
            () => output.writeString (obj.SideB_SubControlArea)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TieLine]): TieLine =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TieLine (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A corridor containing one or more rights of way
 *
 * @param PowerSystemResource     [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param ContainedIn             [[ch.ninecode.model.TransmissionPath TransmissionPath]] A TransmissionPath is contained in a TransmissionCorridor.
 * @param TransmissionRightOfWays [[ch.ninecode.model.TransmissionRightOfWay TransmissionRightOfWay]] A transmission right-of-way is a member of a transmission corridor
 * @group InfEnergyScheduling
 * @groupname InfEnergyScheduling Package InfEnergyScheduling
 * @groupdesc InfEnergyScheduling This package provides the capability to schedule and account for transactions for the exchange of electric power between companies. It includes transations for megawatts which are generated, consumed, lost, passed through, sold and purchased. These classes are used by Accounting and Billing for Energy, Generation Capacity, Transmission, and Ancillary Services.
 */
final case class TransmissionCorridor
(
    PowerSystemResource: PowerSystemResource = null,
    ContainedIn: List[String] = null,
    TransmissionRightOfWays: List[String] = null
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
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TransmissionCorridor.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TransmissionCorridor.fields (position), x))

        emitattrs (0, ContainedIn)
        emitattrs (1, TransmissionRightOfWays)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:TransmissionCorridor rdf:ID=\"%s\">\n%s\t</cim:TransmissionCorridor>".format (id, export_fields)
    }
}

object TransmissionCorridor
    extends
        CIMParseable[TransmissionCorridor]
{
    override val fields: Array[String] = Array [String](
        "ContainedIn",
        "TransmissionRightOfWays"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ContainedIn", "TransmissionPath", "0..*", "1"),
        CIMRelationship ("TransmissionRightOfWays", "TransmissionRightOfWay", "1..*", "1")
    )
    val ContainedIn: FielderMultiple = parse_attributes (attribute (cls, fields (0)))
    val TransmissionRightOfWays: FielderMultiple = parse_attributes (attribute (cls, fields (1)))

    def parse (context: CIMContext): TransmissionCorridor =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = TransmissionCorridor (
            PowerSystemResource.parse (context),
            masks (ContainedIn (), 0),
            masks (TransmissionRightOfWays (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[TransmissionCorridor] = TransmissionCorridorSerializer
}

object TransmissionCorridorSerializer extends CIMSerializer[TransmissionCorridor]
{
    def write (kryo: Kryo, output: Output, obj: TransmissionCorridor): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.ContainedIn, output),
            () => writeList (obj.TransmissionRightOfWays, output)
        )
        PowerSystemResourceSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TransmissionCorridor]): TransmissionCorridor =
    {
        val parent = PowerSystemResourceSerializer.read (kryo, input, classOf [PowerSystemResource])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TransmissionCorridor (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A collection of transmission lines that are close proximity to each other.
 *
 * @param PowerSystemResource  [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param MktLine              [[ch.ninecode.model.MktLine MktLine]] <em>undocumented</em>
 * @param TransmissionCorridor [[ch.ninecode.model.TransmissionCorridor TransmissionCorridor]] A transmission right-of-way is a member of a transmission corridor
 * @group InfEnergyScheduling
 * @groupname InfEnergyScheduling Package InfEnergyScheduling
 * @groupdesc InfEnergyScheduling This package provides the capability to schedule and account for transactions for the exchange of electric power between companies. It includes transations for megawatts which are generated, consumed, lost, passed through, sold and purchased. These classes are used by Accounting and Billing for Energy, Generation Capacity, Transmission, and Ancillary Services.
 */
final case class TransmissionRightOfWay
(
    PowerSystemResource: PowerSystemResource = null,
    MktLine: List[String] = null,
    TransmissionCorridor: String = null
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
        clone ().asInstanceOf [Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TransmissionRightOfWay.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TransmissionRightOfWay.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TransmissionRightOfWay.fields (position), x))

        emitattrs (0, MktLine)
        emitattr (1, TransmissionCorridor)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:TransmissionRightOfWay rdf:ID=\"%s\">\n%s\t</cim:TransmissionRightOfWay>".format (id, export_fields)
    }
}

object TransmissionRightOfWay
    extends
        CIMParseable[TransmissionRightOfWay]
{
    override val fields: Array[String] = Array [String](
        "MktLine",
        "TransmissionCorridor"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("MktLine", "MktLine", "0..*", "0..1"),
        CIMRelationship ("TransmissionCorridor", "TransmissionCorridor", "1", "1..*")
    )
    val MktLine: FielderMultiple = parse_attributes (attribute (cls, fields (0)))
    val TransmissionCorridor: Fielder = parse_attribute (attribute (cls, fields (1)))

    def parse (context: CIMContext): TransmissionRightOfWay =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = TransmissionRightOfWay (
            PowerSystemResource.parse (context),
            masks (MktLine (), 0),
            mask (TransmissionCorridor (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[TransmissionRightOfWay] = TransmissionRightOfWaySerializer
}

object TransmissionRightOfWaySerializer extends CIMSerializer[TransmissionRightOfWay]
{
    def write (kryo: Kryo, output: Output, obj: TransmissionRightOfWay): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.MktLine, output),
            () => output.writeString (obj.TransmissionCorridor)
        )
        PowerSystemResourceSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TransmissionRightOfWay]): TransmissionRightOfWay =
    {
        val parent = PowerSystemResourceSerializer.read (kryo, input, classOf [PowerSystemResource])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TransmissionRightOfWay (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _InfEnergyScheduling
{
    def register: List[CIMClassInfo] =
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
package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**

 * @group DER
 * @groupname DER Package DER
 */
final case class DERCurveData
(
    override val sup: BasicElement,
    intervalNumber: Int,
    maxYValue: Double,
    minYValue: Double,
    nominalYValue: Double,
    timeStamp: String,
    DERMonitorableParameter: String,
    DispatchSchedule: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, 0.0, 0.0, 0.0, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[DERCurveData] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DERCurveData.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DERCurveData.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DERCurveData.fields (position), value)
        emitelem (0, intervalNumber)
        emitelem (1, maxYValue)
        emitelem (2, minYValue)
        emitelem (3, nominalYValue)
        emitelem (4, timeStamp)
        emitattr (5, DERMonitorableParameter)
        emitattr (6, DispatchSchedule)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DERCurveData rdf:ID=\"%s\">\n%s\t</cim:DERCurveData>".format (id, export_fields)
    }
}

object DERCurveData
extends
    Parseable[DERCurveData]
{
    override val fields: Array[String] = Array[String] (
        "intervalNumber",
        "maxYValue",
        "minYValue",
        "nominalYValue",
        "timeStamp",
        "DERMonitorableParameter",
        "DispatchSchedule"
    )
    override val relations: List[Relationship] = List (
        Relationship ("DERMonitorableParameter", "DERMonitorableParameter", "1", "0..1"),
        Relationship ("DispatchSchedule", "DispatchSchedule", "0..1", "0..*")
    )
    val intervalNumber: Fielder = parse_element (element (cls, fields(0)))
    val maxYValue: Fielder = parse_element (element (cls, fields(1)))
    val minYValue: Fielder = parse_element (element (cls, fields(2)))
    val nominalYValue: Fielder = parse_element (element (cls, fields(3)))
    val timeStamp: Fielder = parse_element (element (cls, fields(4)))
    val DERMonitorableParameter: Fielder = parse_attribute (attribute (cls, fields(5)))
    val DispatchSchedule: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: Context): DERCurveData =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DERCurveData (
            BasicElement.parse (context),
            toInteger (mask (intervalNumber (), 0)),
            toDouble (mask (maxYValue (), 1)),
            toDouble (mask (minYValue (), 2)),
            toDouble (mask (nominalYValue (), 3)),
            mask (timeStamp (), 4),
            mask (DERMonitorableParameter (), 5),
            mask (DispatchSchedule (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group DER
 * @groupname DER Package DER
 */
final case class DERFunction
(
    override val sup: BasicElement,
    connectDisconnect: Boolean,
    frequencyWattCurveFunction: Boolean,
    maxRealPowerLimiting: Boolean,
    rampRateControl: Boolean,
    reactivePowerDispatch: Boolean,
    realPowerDispatch: Boolean,
    voltVarCurveFunction: Boolean,
    voltWattCurveFunction: Boolean,
    voltageRegulation: Boolean,
    EndDeviceGroup: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, false, false, false, false, false, false, false, false, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[DERFunction] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DERFunction.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DERFunction.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (DERFunction.fields (position), x))
        emitelem (0, connectDisconnect)
        emitelem (1, frequencyWattCurveFunction)
        emitelem (2, maxRealPowerLimiting)
        emitelem (3, rampRateControl)
        emitelem (4, reactivePowerDispatch)
        emitelem (5, realPowerDispatch)
        emitelem (6, voltVarCurveFunction)
        emitelem (7, voltWattCurveFunction)
        emitelem (8, voltageRegulation)
        emitattrs (9, EndDeviceGroup)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DERFunction rdf:ID=\"%s\">\n%s\t</cim:DERFunction>".format (id, export_fields)
    }
}

object DERFunction
extends
    Parseable[DERFunction]
{
    override val fields: Array[String] = Array[String] (
        "connectDisconnect",
        "frequencyWattCurveFunction",
        "maxRealPowerLimiting",
        "rampRateControl",
        "reactivePowerDispatch",
        "realPowerDispatch",
        "voltVarCurveFunction",
        "voltWattCurveFunction",
        "voltageRegulation",
        "EndDeviceGroup"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EndDeviceGroup", "EndDeviceGroup", "0..*", "0..1")
    )
    val connectDisconnect: Fielder = parse_element (element (cls, fields(0)))
    val frequencyWattCurveFunction: Fielder = parse_element (element (cls, fields(1)))
    val maxRealPowerLimiting: Fielder = parse_element (element (cls, fields(2)))
    val rampRateControl: Fielder = parse_element (element (cls, fields(3)))
    val reactivePowerDispatch: Fielder = parse_element (element (cls, fields(4)))
    val realPowerDispatch: Fielder = parse_element (element (cls, fields(5)))
    val voltVarCurveFunction: Fielder = parse_element (element (cls, fields(6)))
    val voltWattCurveFunction: Fielder = parse_element (element (cls, fields(7)))
    val voltageRegulation: Fielder = parse_element (element (cls, fields(8)))
    val EndDeviceGroup: FielderMultiple = parse_attributes (attribute (cls, fields(9)))

    def parse (context: Context): DERFunction =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DERFunction (
            BasicElement.parse (context),
            toBoolean (mask (connectDisconnect (), 0)),
            toBoolean (mask (frequencyWattCurveFunction (), 1)),
            toBoolean (mask (maxRealPowerLimiting (), 2)),
            toBoolean (mask (rampRateControl (), 3)),
            toBoolean (mask (reactivePowerDispatch (), 4)),
            toBoolean (mask (realPowerDispatch (), 5)),
            toBoolean (mask (voltVarCurveFunction (), 6)),
            toBoolean (mask (voltWattCurveFunction (), 7)),
            toBoolean (mask (voltageRegulation (), 8)),
            masks (EndDeviceGroup (), 9)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group DER
 * @groupname DER Package DER
 */
final case class DERGroupDispatch
(
    override val sup: IdentifiedObject,
    EndDeviceGroup: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[DERGroupDispatch] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DERGroupDispatch.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (DERGroupDispatch.fields (position), x))
        emitattrs (0, EndDeviceGroup)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DERGroupDispatch rdf:ID=\"%s\">\n%s\t</cim:DERGroupDispatch>".format (id, export_fields)
    }
}

object DERGroupDispatch
extends
    Parseable[DERGroupDispatch]
{
    override val fields: Array[String] = Array[String] (
        "EndDeviceGroup"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EndDeviceGroup", "EndDeviceGroup", "0..*", "0..*")
    )
    val EndDeviceGroup: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): DERGroupDispatch =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DERGroupDispatch (
            IdentifiedObject.parse (context),
            masks (EndDeviceGroup (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group DER
 * @groupname DER Package DER
 */
final case class DERGroupForecast
(
    override val sup: IdentifiedObject,
    predictionCreationDate: String,
    EndDeviceGroup: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[DERGroupForecast] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DERGroupForecast.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DERGroupForecast.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (DERGroupForecast.fields (position), x))
        emitelem (0, predictionCreationDate)
        emitattrs (1, EndDeviceGroup)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DERGroupForecast rdf:ID=\"%s\">\n%s\t</cim:DERGroupForecast>".format (id, export_fields)
    }
}

object DERGroupForecast
extends
    Parseable[DERGroupForecast]
{
    override val fields: Array[String] = Array[String] (
        "predictionCreationDate",
        "EndDeviceGroup"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EndDeviceGroup", "EndDeviceGroup", "1..*", "1..*")
    )
    val predictionCreationDate: Fielder = parse_element (element (cls, fields(0)))
    val EndDeviceGroup: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): DERGroupForecast =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DERGroupForecast (
            IdentifiedObject.parse (context),
            mask (predictionCreationDate (), 0),
            masks (EndDeviceGroup (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group DER
 * @groupname DER Package DER
 */
final case class DERMonitorableParameter
(
    override val sup: BasicElement,
    flowDirection: String,
    yMultiplier: String,
    yUnit: String,
    yUnitInstalledMax: Double,
    yUnitInstalledMin: Double,
    DERCurveData: String,
    DERParameter: String,
    DispatchSchedule: List[String],
    EndDeviceGroup: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, 0.0, 0.0, null, null, List(), List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[DERMonitorableParameter] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DERMonitorableParameter.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DERMonitorableParameter.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DERMonitorableParameter.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (DERMonitorableParameter.fields (position), x))
        emitattr (0, flowDirection)
        emitattr (1, yMultiplier)
        emitattr (2, yUnit)
        emitelem (3, yUnitInstalledMax)
        emitelem (4, yUnitInstalledMin)
        emitattr (5, DERCurveData)
        emitattr (6, DERParameter)
        emitattrs (7, DispatchSchedule)
        emitattrs (8, EndDeviceGroup)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DERMonitorableParameter rdf:ID=\"%s\">\n%s\t</cim:DERMonitorableParameter>".format (id, export_fields)
    }
}

object DERMonitorableParameter
extends
    Parseable[DERMonitorableParameter]
{
    override val fields: Array[String] = Array[String] (
        "flowDirection",
        "yMultiplier",
        "yUnit",
        "yUnitInstalledMax",
        "yUnitInstalledMin",
        "DERCurveData",
        "DERParameter",
        "DispatchSchedule",
        "EndDeviceGroup"
    )
    override val relations: List[Relationship] = List (
        Relationship ("DERCurveData", "DERCurveData", "0..1", "1"),
        Relationship ("DispatchSchedule", "DispatchSchedule", "0..*", "1"),
        Relationship ("EndDeviceGroup", "EndDeviceGroup", "0..*", "0..*")
    )
    val flowDirection: Fielder = parse_attribute (attribute (cls, fields(0)))
    val yMultiplier: Fielder = parse_attribute (attribute (cls, fields(1)))
    val yUnit: Fielder = parse_attribute (attribute (cls, fields(2)))
    val yUnitInstalledMax: Fielder = parse_element (element (cls, fields(3)))
    val yUnitInstalledMin: Fielder = parse_element (element (cls, fields(4)))
    val DERCurveData: Fielder = parse_attribute (attribute (cls, fields(5)))
    val DERParameter: Fielder = parse_attribute (attribute (cls, fields(6)))
    val DispatchSchedule: FielderMultiple = parse_attributes (attribute (cls, fields(7)))
    val EndDeviceGroup: FielderMultiple = parse_attributes (attribute (cls, fields(8)))

    def parse (context: Context): DERMonitorableParameter =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DERMonitorableParameter (
            BasicElement.parse (context),
            mask (flowDirection (), 0),
            mask (yMultiplier (), 1),
            mask (yUnit (), 2),
            toDouble (mask (yUnitInstalledMax (), 3)),
            toDouble (mask (yUnitInstalledMin (), 4)),
            mask (DERCurveData (), 5),
            mask (DERParameter (), 6),
            masks (DispatchSchedule (), 7),
            masks (EndDeviceGroup (), 8)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group DER
 * @groupname DER Package DER
 */
final case class DispatchSchedule
(
    override val sup: BasicElement,
    confidence: Double,
    curveStyleKind: String,
    numberOfIntervals: Int,
    startTime: String,
    timeIntervalDuration: Int,
    timeIntervalUnit: String,
    DERCurveData: List[String],
    DERMonitorableParameter: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, null, 0, null, 0, null, List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[DispatchSchedule] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DispatchSchedule.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DispatchSchedule.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DispatchSchedule.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (DispatchSchedule.fields (position), x))
        emitelem (0, confidence)
        emitattr (1, curveStyleKind)
        emitelem (2, numberOfIntervals)
        emitelem (3, startTime)
        emitelem (4, timeIntervalDuration)
        emitattr (5, timeIntervalUnit)
        emitattrs (6, DERCurveData)
        emitattr (7, DERMonitorableParameter)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DispatchSchedule rdf:ID=\"%s\">\n%s\t</cim:DispatchSchedule>".format (id, export_fields)
    }
}

object DispatchSchedule
extends
    Parseable[DispatchSchedule]
{
    override val fields: Array[String] = Array[String] (
        "confidence",
        "curveStyleKind",
        "numberOfIntervals",
        "startTime",
        "timeIntervalDuration",
        "timeIntervalUnit",
        "DERCurveData",
        "DERMonitorableParameter"
    )
    override val relations: List[Relationship] = List (
        Relationship ("DERCurveData", "DERCurveData", "0..*", "0..1"),
        Relationship ("DERMonitorableParameter", "DERMonitorableParameter", "1", "0..*")
    )
    val confidence: Fielder = parse_element (element (cls, fields(0)))
    val curveStyleKind: Fielder = parse_attribute (attribute (cls, fields(1)))
    val numberOfIntervals: Fielder = parse_element (element (cls, fields(2)))
    val startTime: Fielder = parse_element (element (cls, fields(3)))
    val timeIntervalDuration: Fielder = parse_element (element (cls, fields(4)))
    val timeIntervalUnit: Fielder = parse_attribute (attribute (cls, fields(5)))
    val DERCurveData: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val DERMonitorableParameter: Fielder = parse_attribute (attribute (cls, fields(7)))

    def parse (context: Context): DispatchSchedule =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DispatchSchedule (
            BasicElement.parse (context),
            toDouble (mask (confidence (), 0)),
            mask (curveStyleKind (), 1),
            toInteger (mask (numberOfIntervals (), 2)),
            mask (startTime (), 3),
            toInteger (mask (timeIntervalDuration (), 4)),
            mask (timeIntervalUnit (), 5),
            masks (DERCurveData (), 6),
            mask (DERMonitorableParameter (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**

 * @group DER
 * @groupname DER Package DER
 */
final case class DispatchablePowerCapability
(
    override val sup: BasicElement,
    currentActivePower: Double,
    currentApparentPower: Double,
    currentReactivePower: Double,
    maxActivePower: Double,
    maxApparentPower: Double,
    maxReactivePower: Double,
    minActivePower: Double,
    minApparentPower: Double,
    minReactivePower: Double,
    EndDevice: String,
    EndDeviceGroup: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[DispatchablePowerCapability] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index $i")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DispatchablePowerCapability.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DispatchablePowerCapability.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DispatchablePowerCapability.fields (position), value)
        emitelem (0, currentActivePower)
        emitelem (1, currentApparentPower)
        emitelem (2, currentReactivePower)
        emitelem (3, maxActivePower)
        emitelem (4, maxApparentPower)
        emitelem (5, maxReactivePower)
        emitelem (6, minActivePower)
        emitelem (7, minApparentPower)
        emitelem (8, minReactivePower)
        emitattr (9, EndDevice)
        emitattr (10, EndDeviceGroup)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DispatchablePowerCapability rdf:ID=\"%s\">\n%s\t</cim:DispatchablePowerCapability>".format (id, export_fields)
    }
}

object DispatchablePowerCapability
extends
    Parseable[DispatchablePowerCapability]
{
    override val fields: Array[String] = Array[String] (
        "currentActivePower",
        "currentApparentPower",
        "currentReactivePower",
        "maxActivePower",
        "maxApparentPower",
        "maxReactivePower",
        "minActivePower",
        "minApparentPower",
        "minReactivePower",
        "EndDevice",
        "EndDeviceGroup"
    )
    override val relations: List[Relationship] = List (
        Relationship ("EndDevice", "EndDevice", "0..1", "0..*"),
        Relationship ("EndDeviceGroup", "EndDeviceGroup", "0..1", "0..1")
    )
    val currentActivePower: Fielder = parse_element (element (cls, fields(0)))
    val currentApparentPower: Fielder = parse_element (element (cls, fields(1)))
    val currentReactivePower: Fielder = parse_element (element (cls, fields(2)))
    val maxActivePower: Fielder = parse_element (element (cls, fields(3)))
    val maxApparentPower: Fielder = parse_element (element (cls, fields(4)))
    val maxReactivePower: Fielder = parse_element (element (cls, fields(5)))
    val minActivePower: Fielder = parse_element (element (cls, fields(6)))
    val minApparentPower: Fielder = parse_element (element (cls, fields(7)))
    val minReactivePower: Fielder = parse_element (element (cls, fields(8)))
    val EndDevice: Fielder = parse_attribute (attribute (cls, fields(9)))
    val EndDeviceGroup: Fielder = parse_attribute (attribute (cls, fields(10)))

    def parse (context: Context): DispatchablePowerCapability =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DispatchablePowerCapability (
            BasicElement.parse (context),
            toDouble (mask (currentActivePower (), 0)),
            toDouble (mask (currentApparentPower (), 1)),
            toDouble (mask (currentReactivePower (), 2)),
            toDouble (mask (maxActivePower (), 3)),
            toDouble (mask (maxApparentPower (), 4)),
            toDouble (mask (maxReactivePower (), 5)),
            toDouble (mask (minActivePower (), 6)),
            toDouble (mask (minApparentPower (), 7)),
            toDouble (mask (minReactivePower (), 8)),
            mask (EndDevice (), 9),
            mask (EndDeviceGroup (), 10)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _DER
{
    def register: List[ClassInfo] =
    {
        List (
            DERCurveData.register,
            DERFunction.register,
            DERGroupDispatch.register,
            DERGroupForecast.register,
            DERMonitorableParameter.register,
            DispatchSchedule.register,
            DispatchablePowerCapability.register
        )
    }
}
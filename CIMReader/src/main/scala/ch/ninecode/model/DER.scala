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
 * @group DER
 * @groupname DER Package DER
 */
final case class DERCurveData
(
    Element: BasicElement = null,
    intervalNumber: Int = 0,
    maxYValue: Double = 0.0,
    minYValue: Double = 0.0,
    nominalYValue: Double = 0.0,
    timeStamp: String = null,
    DERMonitorableParameter: String = null,
    DispatchSchedule: String = null
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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = DERCurveData.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(DERCurveData.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(DERCurveData.fields(position), value)

        emitelem(0, intervalNumber)
        emitelem(1, maxYValue)
        emitelem(2, minYValue)
        emitelem(3, nominalYValue)
        emitelem(4, timeStamp)
        emitattr(5, DERMonitorableParameter)
        emitattr(6, DispatchSchedule)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DERCurveData rdf:%s=\"%s\">\n%s\t</cim:DERCurveData>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DERCurveData
    extends
        CIMParseable[DERCurveData]
{
    override val fields: Array[String] = Array[String](
        "intervalNumber",
        "maxYValue",
        "minYValue",
        "nominalYValue",
        "timeStamp",
        "DERMonitorableParameter",
        "DispatchSchedule"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("DERMonitorableParameter", "DERMonitorableParameter", "1", "0..1"),
        CIMRelationship("DispatchSchedule", "DispatchSchedule", "0..1", "0..*")
    )
    val intervalNumber: Fielder = parse_element(element(cls, fields(0)))
    val maxYValue: Fielder = parse_element(element(cls, fields(1)))
    val minYValue: Fielder = parse_element(element(cls, fields(2)))
    val nominalYValue: Fielder = parse_element(element(cls, fields(3)))
    val timeStamp: Fielder = parse_element(element(cls, fields(4)))
    val DERMonitorableParameter: Fielder = parse_attribute(attribute(cls, fields(5)))
    val DispatchSchedule: Fielder = parse_attribute(attribute(cls, fields(6)))

    def parse (context: CIMContext): DERCurveData =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DERCurveData(
            BasicElement.parse(context),
            toInteger(mask(intervalNumber(), 0)),
            toDouble(mask(maxYValue(), 1)),
            toDouble(mask(minYValue(), 2)),
            toDouble(mask(nominalYValue(), 3)),
            mask(timeStamp(), 4),
            mask(DERMonitorableParameter(), 5),
            mask(DispatchSchedule(), 6)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DERCurveData] = DERCurveDataSerializer
}

object DERCurveDataSerializer extends CIMSerializer[DERCurveData]
{
    def write (kryo: Kryo, output: Output, obj: DERCurveData): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeInt(obj.intervalNumber),
            () => output.writeDouble(obj.maxYValue),
            () => output.writeDouble(obj.minYValue),
            () => output.writeDouble(obj.nominalYValue),
            () => output.writeString(obj.timeStamp),
            () => output.writeString(obj.DERMonitorableParameter),
            () => output.writeString(obj.DispatchSchedule)
        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DERCurveData]): DERCurveData =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DERCurveData(
            parent,
            if (isSet(0)) input.readInt else 0,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readDouble else 0.0,
            if (isSet(4)) input.readString else null,
            if (isSet(5)) input.readString else null,
            if (isSet(6)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group DER
 * @groupname DER Package DER
 */
final case class DERFunction
(
    Element: BasicElement = null,
    connectDisconnect: Boolean = false,
    frequencyWattCurveFunction: Boolean = false,
    maxRealPowerLimiting: Boolean = false,
    rampRateControl: Boolean = false,
    reactivePowerDispatch: Boolean = false,
    realPowerDispatch: Boolean = false,
    voltVarCurveFunction: Boolean = false,
    voltWattCurveFunction: Boolean = false,
    voltageRegulation: Boolean = false,
    EndDeviceGroup: List[String] = null
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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = DERFunction.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(DERFunction.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(DERFunction.fields(position), x))

        emitelem(0, connectDisconnect)
        emitelem(1, frequencyWattCurveFunction)
        emitelem(2, maxRealPowerLimiting)
        emitelem(3, rampRateControl)
        emitelem(4, reactivePowerDispatch)
        emitelem(5, realPowerDispatch)
        emitelem(6, voltVarCurveFunction)
        emitelem(7, voltWattCurveFunction)
        emitelem(8, voltageRegulation)
        emitattrs(9, EndDeviceGroup)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DERFunction rdf:%s=\"%s\">\n%s\t</cim:DERFunction>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DERFunction
    extends
        CIMParseable[DERFunction]
{
    override val fields: Array[String] = Array[String](
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
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("EndDeviceGroup", "EndDeviceGroup", "0..*", "0..1")
    )
    val connectDisconnect: Fielder = parse_element(element(cls, fields(0)))
    val frequencyWattCurveFunction: Fielder = parse_element(element(cls, fields(1)))
    val maxRealPowerLimiting: Fielder = parse_element(element(cls, fields(2)))
    val rampRateControl: Fielder = parse_element(element(cls, fields(3)))
    val reactivePowerDispatch: Fielder = parse_element(element(cls, fields(4)))
    val realPowerDispatch: Fielder = parse_element(element(cls, fields(5)))
    val voltVarCurveFunction: Fielder = parse_element(element(cls, fields(6)))
    val voltWattCurveFunction: Fielder = parse_element(element(cls, fields(7)))
    val voltageRegulation: Fielder = parse_element(element(cls, fields(8)))
    val EndDeviceGroup: FielderMultiple = parse_attributes(attribute(cls, fields(9)))

    def parse (context: CIMContext): DERFunction =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DERFunction(
            BasicElement.parse(context),
            toBoolean(mask(connectDisconnect(), 0)),
            toBoolean(mask(frequencyWattCurveFunction(), 1)),
            toBoolean(mask(maxRealPowerLimiting(), 2)),
            toBoolean(mask(rampRateControl(), 3)),
            toBoolean(mask(reactivePowerDispatch(), 4)),
            toBoolean(mask(realPowerDispatch(), 5)),
            toBoolean(mask(voltVarCurveFunction(), 6)),
            toBoolean(mask(voltWattCurveFunction(), 7)),
            toBoolean(mask(voltageRegulation(), 8)),
            masks(EndDeviceGroup(), 9)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DERFunction] = DERFunctionSerializer
}

object DERFunctionSerializer extends CIMSerializer[DERFunction]
{
    def write (kryo: Kryo, output: Output, obj: DERFunction): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeBoolean(obj.connectDisconnect),
            () => output.writeBoolean(obj.frequencyWattCurveFunction),
            () => output.writeBoolean(obj.maxRealPowerLimiting),
            () => output.writeBoolean(obj.rampRateControl),
            () => output.writeBoolean(obj.reactivePowerDispatch),
            () => output.writeBoolean(obj.realPowerDispatch),
            () => output.writeBoolean(obj.voltVarCurveFunction),
            () => output.writeBoolean(obj.voltWattCurveFunction),
            () => output.writeBoolean(obj.voltageRegulation),
            () => writeList(obj.EndDeviceGroup, output)
        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DERFunction]): DERFunction =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DERFunction(
            parent,
            if (isSet(0)) input.readBoolean else false,
            if (isSet(1)) input.readBoolean else false,
            if (isSet(2)) input.readBoolean else false,
            if (isSet(3)) input.readBoolean else false,
            if (isSet(4)) input.readBoolean else false,
            if (isSet(5)) input.readBoolean else false,
            if (isSet(6)) input.readBoolean else false,
            if (isSet(7)) input.readBoolean else false,
            if (isSet(8)) input.readBoolean else false,
            if (isSet(9)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group DER
 * @groupname DER Package DER
 */
final case class DERGroupDispatch
(
    IdentifiedObject: IdentifiedObject = null,
    EndDeviceGroup: List[String] = null
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
        implicit val clz: String = DERGroupDispatch.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(DERGroupDispatch.fields(position), x))

        emitattrs(0, EndDeviceGroup)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DERGroupDispatch rdf:%s=\"%s\">\n%s\t</cim:DERGroupDispatch>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DERGroupDispatch
    extends
        CIMParseable[DERGroupDispatch]
{
    override val fields: Array[String] = Array[String](
        "EndDeviceGroup"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("EndDeviceGroup", "EndDeviceGroup", "0..*", "0..*")
    )
    val EndDeviceGroup: FielderMultiple = parse_attributes(attribute(cls, fields(0)))

    def parse (context: CIMContext): DERGroupDispatch =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DERGroupDispatch(
            IdentifiedObject.parse(context),
            masks(EndDeviceGroup(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DERGroupDispatch] = DERGroupDispatchSerializer
}

object DERGroupDispatchSerializer extends CIMSerializer[DERGroupDispatch]
{
    def write (kryo: Kryo, output: Output, obj: DERGroupDispatch): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => writeList(obj.EndDeviceGroup, output)
        )
        IdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DERGroupDispatch]): DERGroupDispatch =
    {
        val parent = IdentifiedObjectSerializer.read(kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DERGroupDispatch(
            parent,
            if (isSet(0)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group DER
 * @groupname DER Package DER
 */
final case class DERGroupForecast
(
    IdentifiedObject: IdentifiedObject = null,
    predictionCreationDate: String = null,
    EndDeviceGroup: List[String] = null
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
        implicit val clz: String = DERGroupForecast.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(DERGroupForecast.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(DERGroupForecast.fields(position), x))

        emitelem(0, predictionCreationDate)
        emitattrs(1, EndDeviceGroup)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DERGroupForecast rdf:%s=\"%s\">\n%s\t</cim:DERGroupForecast>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DERGroupForecast
    extends
        CIMParseable[DERGroupForecast]
{
    override val fields: Array[String] = Array[String](
        "predictionCreationDate",
        "EndDeviceGroup"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("EndDeviceGroup", "EndDeviceGroup", "1..*", "1..*")
    )
    val predictionCreationDate: Fielder = parse_element(element(cls, fields(0)))
    val EndDeviceGroup: FielderMultiple = parse_attributes(attribute(cls, fields(1)))

    def parse (context: CIMContext): DERGroupForecast =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DERGroupForecast(
            IdentifiedObject.parse(context),
            mask(predictionCreationDate(), 0),
            masks(EndDeviceGroup(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DERGroupForecast] = DERGroupForecastSerializer
}

object DERGroupForecastSerializer extends CIMSerializer[DERGroupForecast]
{
    def write (kryo: Kryo, output: Output, obj: DERGroupForecast): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.predictionCreationDate),
            () => writeList(obj.EndDeviceGroup, output)
        )
        IdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DERGroupForecast]): DERGroupForecast =
    {
        val parent = IdentifiedObjectSerializer.read(kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DERGroupForecast(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group DER
 * @groupname DER Package DER
 */
final case class DERMonitorableParameter
(
    Element: BasicElement = null,
    flowDirection: String = null,
    yMultiplier: String = null,
    yUnit: String = null,
    yUnitInstalledMax: Double = 0.0,
    yUnitInstalledMin: Double = 0.0,
    DERCurveData: String = null,
    DERParameter: String = null,
    DispatchSchedule: List[String] = null,
    EndDeviceGroup: List[String] = null
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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = DERMonitorableParameter.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(DERMonitorableParameter.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(DERMonitorableParameter.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(DERMonitorableParameter.fields(position), x))

        emitattr(0, flowDirection)
        emitattr(1, yMultiplier)
        emitattr(2, yUnit)
        emitelem(3, yUnitInstalledMax)
        emitelem(4, yUnitInstalledMin)
        emitattr(5, DERCurveData)
        emitattr(6, DERParameter)
        emitattrs(7, DispatchSchedule)
        emitattrs(8, EndDeviceGroup)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DERMonitorableParameter rdf:%s=\"%s\">\n%s\t</cim:DERMonitorableParameter>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DERMonitorableParameter
    extends
        CIMParseable[DERMonitorableParameter]
{
    override val fields: Array[String] = Array[String](
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
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("DERCurveData", "DERCurveData", "0..1", "1"),
        CIMRelationship("DispatchSchedule", "DispatchSchedule", "0..*", "1"),
        CIMRelationship("EndDeviceGroup", "EndDeviceGroup", "0..*", "0..*")
    )
    val flowDirection: Fielder = parse_attribute(attribute(cls, fields(0)))
    val yMultiplier: Fielder = parse_attribute(attribute(cls, fields(1)))
    val yUnit: Fielder = parse_attribute(attribute(cls, fields(2)))
    val yUnitInstalledMax: Fielder = parse_element(element(cls, fields(3)))
    val yUnitInstalledMin: Fielder = parse_element(element(cls, fields(4)))
    val DERCurveData: Fielder = parse_attribute(attribute(cls, fields(5)))
    val DERParameter: Fielder = parse_attribute(attribute(cls, fields(6)))
    val DispatchSchedule: FielderMultiple = parse_attributes(attribute(cls, fields(7)))
    val EndDeviceGroup: FielderMultiple = parse_attributes(attribute(cls, fields(8)))

    def parse (context: CIMContext): DERMonitorableParameter =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DERMonitorableParameter(
            BasicElement.parse(context),
            mask(flowDirection(), 0),
            mask(yMultiplier(), 1),
            mask(yUnit(), 2),
            toDouble(mask(yUnitInstalledMax(), 3)),
            toDouble(mask(yUnitInstalledMin(), 4)),
            mask(DERCurveData(), 5),
            mask(DERParameter(), 6),
            masks(DispatchSchedule(), 7),
            masks(EndDeviceGroup(), 8)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DERMonitorableParameter] = DERMonitorableParameterSerializer
}

object DERMonitorableParameterSerializer extends CIMSerializer[DERMonitorableParameter]
{
    def write (kryo: Kryo, output: Output, obj: DERMonitorableParameter): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.flowDirection),
            () => output.writeString(obj.yMultiplier),
            () => output.writeString(obj.yUnit),
            () => output.writeDouble(obj.yUnitInstalledMax),
            () => output.writeDouble(obj.yUnitInstalledMin),
            () => output.writeString(obj.DERCurveData),
            () => output.writeString(obj.DERParameter),
            () => writeList(obj.DispatchSchedule, output),
            () => writeList(obj.EndDeviceGroup, output)
        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DERMonitorableParameter]): DERMonitorableParameter =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DERMonitorableParameter(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readString else null,
            if (isSet(3)) input.readDouble else 0.0,
            if (isSet(4)) input.readDouble else 0.0,
            if (isSet(5)) input.readString else null,
            if (isSet(6)) input.readString else null,
            if (isSet(7)) readList(input) else null,
            if (isSet(8)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group DER
 * @groupname DER Package DER
 */
final case class DispatchSchedule
(
    Element: BasicElement = null,
    confidence: Double = 0.0,
    curveStyleKind: String = null,
    numberOfIntervals: Int = 0,
    startTime: String = null,
    timeIntervalDuration: Int = 0,
    timeIntervalUnit: String = null,
    DERCurveData: List[String] = null,
    DERMonitorableParameter: String = null
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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = DispatchSchedule.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(DispatchSchedule.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(DispatchSchedule.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(DispatchSchedule.fields(position), x))

        emitelem(0, confidence)
        emitattr(1, curveStyleKind)
        emitelem(2, numberOfIntervals)
        emitelem(3, startTime)
        emitelem(4, timeIntervalDuration)
        emitattr(5, timeIntervalUnit)
        emitattrs(6, DERCurveData)
        emitattr(7, DERMonitorableParameter)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DispatchSchedule rdf:%s=\"%s\">\n%s\t</cim:DispatchSchedule>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DispatchSchedule
    extends
        CIMParseable[DispatchSchedule]
{
    override val fields: Array[String] = Array[String](
        "confidence",
        "curveStyleKind",
        "numberOfIntervals",
        "startTime",
        "timeIntervalDuration",
        "timeIntervalUnit",
        "DERCurveData",
        "DERMonitorableParameter"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("DERCurveData", "DERCurveData", "0..*", "0..1"),
        CIMRelationship("DERMonitorableParameter", "DERMonitorableParameter", "1", "0..*")
    )
    val confidence: Fielder = parse_element(element(cls, fields(0)))
    val curveStyleKind: Fielder = parse_attribute(attribute(cls, fields(1)))
    val numberOfIntervals: Fielder = parse_element(element(cls, fields(2)))
    val startTime: Fielder = parse_element(element(cls, fields(3)))
    val timeIntervalDuration: Fielder = parse_element(element(cls, fields(4)))
    val timeIntervalUnit: Fielder = parse_attribute(attribute(cls, fields(5)))
    val DERCurveData: FielderMultiple = parse_attributes(attribute(cls, fields(6)))
    val DERMonitorableParameter: Fielder = parse_attribute(attribute(cls, fields(7)))

    def parse (context: CIMContext): DispatchSchedule =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DispatchSchedule(
            BasicElement.parse(context),
            toDouble(mask(confidence(), 0)),
            mask(curveStyleKind(), 1),
            toInteger(mask(numberOfIntervals(), 2)),
            mask(startTime(), 3),
            toInteger(mask(timeIntervalDuration(), 4)),
            mask(timeIntervalUnit(), 5),
            masks(DERCurveData(), 6),
            mask(DERMonitorableParameter(), 7)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DispatchSchedule] = DispatchScheduleSerializer
}

object DispatchScheduleSerializer extends CIMSerializer[DispatchSchedule]
{
    def write (kryo: Kryo, output: Output, obj: DispatchSchedule): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.confidence),
            () => output.writeString(obj.curveStyleKind),
            () => output.writeInt(obj.numberOfIntervals),
            () => output.writeString(obj.startTime),
            () => output.writeInt(obj.timeIntervalDuration),
            () => output.writeString(obj.timeIntervalUnit),
            () => writeList(obj.DERCurveData, output),
            () => output.writeString(obj.DERMonitorableParameter)
        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DispatchSchedule]): DispatchSchedule =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DispatchSchedule(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readInt else 0,
            if (isSet(3)) input.readString else null,
            if (isSet(4)) input.readInt else 0,
            if (isSet(5)) input.readString else null,
            if (isSet(6)) readList(input) else null,
            if (isSet(7)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group DER
 * @groupname DER Package DER
 */
final case class DispatchablePowerCapability
(
    Element: BasicElement = null,
    currentActivePower: Double = 0.0,
    currentApparentPower: Double = 0.0,
    currentReactivePower: Double = 0.0,
    maxActivePower: Double = 0.0,
    maxApparentPower: Double = 0.0,
    maxReactivePower: Double = 0.0,
    minActivePower: Double = 0.0,
    minApparentPower: Double = 0.0,
    minReactivePower: Double = 0.0,
    EndDevice: String = null,
    EndDeviceGroup: String = null
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
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = DispatchablePowerCapability.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(DispatchablePowerCapability.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(DispatchablePowerCapability.fields(position), value)

        emitelem(0, currentActivePower)
        emitelem(1, currentApparentPower)
        emitelem(2, currentReactivePower)
        emitelem(3, maxActivePower)
        emitelem(4, maxApparentPower)
        emitelem(5, maxReactivePower)
        emitelem(6, minActivePower)
        emitelem(7, minApparentPower)
        emitelem(8, minReactivePower)
        emitattr(9, EndDevice)
        emitattr(10, EndDeviceGroup)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DispatchablePowerCapability rdf:%s=\"%s\">\n%s\t</cim:DispatchablePowerCapability>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DispatchablePowerCapability
    extends
        CIMParseable[DispatchablePowerCapability]
{
    override val fields: Array[String] = Array[String](
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
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("EndDevice", "EndDevice", "0..1", "0..*"),
        CIMRelationship("EndDeviceGroup", "EndDeviceGroup", "0..1", "0..1")
    )
    val currentActivePower: Fielder = parse_element(element(cls, fields(0)))
    val currentApparentPower: Fielder = parse_element(element(cls, fields(1)))
    val currentReactivePower: Fielder = parse_element(element(cls, fields(2)))
    val maxActivePower: Fielder = parse_element(element(cls, fields(3)))
    val maxApparentPower: Fielder = parse_element(element(cls, fields(4)))
    val maxReactivePower: Fielder = parse_element(element(cls, fields(5)))
    val minActivePower: Fielder = parse_element(element(cls, fields(6)))
    val minApparentPower: Fielder = parse_element(element(cls, fields(7)))
    val minReactivePower: Fielder = parse_element(element(cls, fields(8)))
    val EndDevice: Fielder = parse_attribute(attribute(cls, fields(9)))
    val EndDeviceGroup: Fielder = parse_attribute(attribute(cls, fields(10)))

    def parse (context: CIMContext): DispatchablePowerCapability =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DispatchablePowerCapability(
            BasicElement.parse(context),
            toDouble(mask(currentActivePower(), 0)),
            toDouble(mask(currentApparentPower(), 1)),
            toDouble(mask(currentReactivePower(), 2)),
            toDouble(mask(maxActivePower(), 3)),
            toDouble(mask(maxApparentPower(), 4)),
            toDouble(mask(maxReactivePower(), 5)),
            toDouble(mask(minActivePower(), 6)),
            toDouble(mask(minApparentPower(), 7)),
            toDouble(mask(minReactivePower(), 8)),
            mask(EndDevice(), 9),
            mask(EndDeviceGroup(), 10)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DispatchablePowerCapability] = DispatchablePowerCapabilitySerializer
}

object DispatchablePowerCapabilitySerializer extends CIMSerializer[DispatchablePowerCapability]
{
    def write (kryo: Kryo, output: Output, obj: DispatchablePowerCapability): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.currentActivePower),
            () => output.writeDouble(obj.currentApparentPower),
            () => output.writeDouble(obj.currentReactivePower),
            () => output.writeDouble(obj.maxActivePower),
            () => output.writeDouble(obj.maxApparentPower),
            () => output.writeDouble(obj.maxReactivePower),
            () => output.writeDouble(obj.minActivePower),
            () => output.writeDouble(obj.minApparentPower),
            () => output.writeDouble(obj.minReactivePower),
            () => output.writeString(obj.EndDevice),
            () => output.writeString(obj.EndDeviceGroup)
        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DispatchablePowerCapability]): DispatchablePowerCapability =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DispatchablePowerCapability(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readDouble else 0.0,
            if (isSet(4)) input.readDouble else 0.0,
            if (isSet(5)) input.readDouble else 0.0,
            if (isSet(6)) input.readDouble else 0.0,
            if (isSet(7)) input.readDouble else 0.0,
            if (isSet(8)) input.readDouble else 0.0,
            if (isSet(9)) input.readString else null,
            if (isSet(10)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _DER
{
    def register: List[CIMClassInfo] =
    {
        List(
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
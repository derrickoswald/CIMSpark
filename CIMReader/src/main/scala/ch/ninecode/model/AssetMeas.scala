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
 * Definition of type of analog useful in asset domain.
 *
 * @param Analog               [[ch.ninecode.model.Analog Analog]] Reference to the superclass object.
 * @param detectionLimit       Detection limit of related analog value if different from detection limit of test standard or if there is no test standard.
 *                             The detection limit (also known as lower limit of detection or limit of detection (LOD), is the lowest quantity of a substance that can be distinguished from the absence of that substance (a blank value) within a stated confidence limit (generally 1%).
 * @param precision            Precision of related analog value if different from precision of test standard or if there is no test standard.
 *                             Precision is a measure of how closely individual measurements agree with one another. Expressed as 'plus or minus' the value of this attribute.
 * @param reportingTemperature Reporting temperature of related analog value if different from reporting temperature of test standard or if there is no test standard.
 *                             Reporting temperature is what gas volumes are normalized to. Different reporting temperatures are used by different sources. For example, ASTM specifies 0°C, whereas IEC specifies 20°C. Online monitors often have their own unique reporting temperatures.
 * @param TestStandard         [[ch.ninecode.model.TestStandard TestStandard]] The lab test standard to which this asset health analog is related.
 * @group AssetMeas
 * @groupname AssetMeas Package AssetMeas
 */
final case class AssetAnalog
(
    Analog: Analog = null,
    detectionLimit: Double = 0.0,
    precision: Double = 0.0,
    reportingTemperature: Double = 0.0,
    TestStandard: String = null
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
    override def sup: Analog = Analog

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
        implicit val clz: String = AssetAnalog.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(AssetAnalog.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(AssetAnalog.fields(position), value)

        emitelem(0, detectionLimit)
        emitelem(1, precision)
        emitelem(2, reportingTemperature)
        emitattr(3, TestStandard)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:AssetAnalog rdf:%s=\"%s\">\n%s\t</cim:AssetAnalog>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object AssetAnalog
    extends
        CIMParseable[AssetAnalog]
{
    override val fields: Array[String] = Array[String](
        "detectionLimit",
        "precision",
        "reportingTemperature",
        "TestStandard"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("TestStandard", "TestStandard", "0..1", "0..*")
    )
    val detectionLimit: Fielder = parse_element(element(cls, fields(0)))
    val precision: Fielder = parse_element(element(cls, fields(1)))
    val reportingTemperature: Fielder = parse_element(element(cls, fields(2)))
    val TestStandard: Fielder = parse_attribute(attribute(cls, fields(3)))

    def parse (context: CIMContext): AssetAnalog =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AssetAnalog(
            Analog.parse(context),
            toDouble(mask(detectionLimit(), 0)),
            toDouble(mask(precision(), 1)),
            toDouble(mask(reportingTemperature(), 2)),
            mask(TestStandard(), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AssetAnalog] = AssetAnalogSerializer
}

object AssetAnalogSerializer extends CIMSerializer[AssetAnalog]
{
    def write (kryo: Kryo, output: Output, obj: AssetAnalog): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.detectionLimit),
            () => output.writeDouble(obj.precision),
            () => output.writeDouble(obj.reportingTemperature),
            () => output.writeString(obj.TestStandard)
        )
        AnalogSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AssetAnalog]): AssetAnalog =
    {
        val parent = AnalogSerializer.read(kryo, input, classOf[Analog])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = AssetAnalog(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Definition of type of discrete useful in asset domain.
 *
 * @param Discrete     [[ch.ninecode.model.Discrete Discrete]] Reference to the superclass object.
 * @param TestStandard [[ch.ninecode.model.TestStandard TestStandard]] The lab test standard to which this asset health discrete is related.
 * @group AssetMeas
 * @groupname AssetMeas Package AssetMeas
 */
final case class AssetDiscrete
(
    Discrete: Discrete = null,
    TestStandard: String = null
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
    override def sup: Discrete = Discrete

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
        implicit val clz: String = AssetDiscrete.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(AssetDiscrete.fields(position), value)

        emitattr(0, TestStandard)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:AssetDiscrete rdf:%s=\"%s\">\n%s\t</cim:AssetDiscrete>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object AssetDiscrete
    extends
        CIMParseable[AssetDiscrete]
{
    override val fields: Array[String] = Array[String](
        "TestStandard"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("TestStandard", "TestStandard", "0..1", "0..*")
    )
    val TestStandard: Fielder = parse_attribute(attribute(cls, fields(0)))

    def parse (context: CIMContext): AssetDiscrete =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AssetDiscrete(
            Discrete.parse(context),
            mask(TestStandard(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AssetDiscrete] = AssetDiscreteSerializer
}

object AssetDiscreteSerializer extends CIMSerializer[AssetDiscrete]
{
    def write (kryo: Kryo, output: Output, obj: AssetDiscrete): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.TestStandard)
        )
        DiscreteSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AssetDiscrete]): AssetDiscrete =
    {
        val parent = DiscreteSerializer.read(kryo, input, classOf[Discrete])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = AssetDiscrete(
            parent,
            if (isSet(0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Definition of type of string measurement useful in asset domain.
 *
 * @param StringMeasurement [[ch.ninecode.model.StringMeasurement StringMeasurement]] Reference to the superclass object.
 * @param kind              Kind of string useful in asset domain.
 * @param TestStandard      [[ch.ninecode.model.TestStandard TestStandard]] Test standard which describes this asset string measurement.
 * @group AssetMeas
 * @groupname AssetMeas Package AssetMeas
 */
final case class AssetStringMeasurement
(
    StringMeasurement: StringMeasurement = null,
    kind: String = null,
    TestStandard: String = null
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
    override def sup: StringMeasurement = StringMeasurement

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
        implicit val clz: String = AssetStringMeasurement.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(AssetStringMeasurement.fields(position), value)

        emitattr(0, kind)
        emitattr(1, TestStandard)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:AssetStringMeasurement rdf:%s=\"%s\">\n%s\t</cim:AssetStringMeasurement>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object AssetStringMeasurement
    extends
        CIMParseable[AssetStringMeasurement]
{
    override val fields: Array[String] = Array[String](
        "kind",
        "TestStandard"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("TestStandard", "TestStandard", "0..1", "0..*")
    )
    val kind: Fielder = parse_attribute(attribute(cls, fields(0)))
    val TestStandard: Fielder = parse_attribute(attribute(cls, fields(1)))

    def parse (context: CIMContext): AssetStringMeasurement =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AssetStringMeasurement(
            StringMeasurement.parse(context),
            mask(kind(), 0),
            mask(TestStandard(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AssetStringMeasurement] = AssetStringMeasurementSerializer
}

object AssetStringMeasurementSerializer extends CIMSerializer[AssetStringMeasurement]
{
    def write (kryo: Kryo, output: Output, obj: AssetStringMeasurement): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.kind),
            () => output.writeString(obj.TestStandard)
        )
        StringMeasurementSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AssetStringMeasurement]): AssetStringMeasurement =
    {
        val parent = StringMeasurementSerializer.read(kryo, input, classOf[StringMeasurement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = AssetStringMeasurement(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Temperature or pressure type of asset analog.
 *
 * @param AssetAnalog [[ch.ninecode.model.AssetAnalog AssetAnalog]] Reference to the superclass object.
 * @param kind        Kind of analog representing temperature or pressure related to an asset.
 * @group AssetMeas
 * @groupname AssetMeas Package AssetMeas
 */
final case class AssetTemperaturePressureAnalog
(
    AssetAnalog: AssetAnalog = null,
    kind: String = null
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
    override def sup: AssetAnalog = AssetAnalog

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
        implicit val clz: String = AssetTemperaturePressureAnalog.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(AssetTemperaturePressureAnalog.fields(position), value)

        emitattr(0, kind)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:AssetTemperaturePressureAnalog rdf:%s=\"%s\">\n%s\t</cim:AssetTemperaturePressureAnalog>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object AssetTemperaturePressureAnalog
    extends
        CIMParseable[AssetTemperaturePressureAnalog]
{
    override val fields: Array[String] = Array[String](
        "kind"
    )
    val kind: Fielder = parse_attribute(attribute(cls, fields(0)))

    def parse (context: CIMContext): AssetTemperaturePressureAnalog =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AssetTemperaturePressureAnalog(
            AssetAnalog.parse(context),
            mask(kind(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[AssetTemperaturePressureAnalog] = AssetTemperaturePressureAnalogSerializer
}

object AssetTemperaturePressureAnalogSerializer extends CIMSerializer[AssetTemperaturePressureAnalog]
{
    def write (kryo: Kryo, output: Output, obj: AssetTemperaturePressureAnalog): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.kind)
        )
        AssetAnalogSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AssetTemperaturePressureAnalog]): AssetTemperaturePressureAnalog =
    {
        val parent = AssetAnalogSerializer.read(kryo, input, classOf[AssetAnalog])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = AssetTemperaturePressureAnalog(
            parent,
            if (isSet(0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The hierarchy of calculation methods used to derive this measurement.
 *
 * @param IdentifiedObject       [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param CalculationMethodOrder [[ch.ninecode.model.CalculationMethodOrder CalculationMethodOrder]] Order of a statistical calculation associated with this calculation method hierarchy.
 * @param Measurement            [[ch.ninecode.model.Measurement Measurement]] Measurement to which this calculation method hierarchy applies.
 * @param MeasurementValue       [[ch.ninecode.model.MeasurementValue MeasurementValue]] Measurement value to which this calculation method hierarchy applies.
 * @group AssetMeas
 * @groupname AssetMeas Package AssetMeas
 */
final case class CalculationMethodHierarchy
(
    IdentifiedObject: IdentifiedObject = null,
    CalculationMethodOrder: List[String] = null,
    Measurement: List[String] = null,
    MeasurementValue: String = null
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
        implicit val clz: String = CalculationMethodHierarchy.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(CalculationMethodHierarchy.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(CalculationMethodHierarchy.fields(position), x))

        emitattrs(0, CalculationMethodOrder)
        emitattrs(1, Measurement)
        emitattr(2, MeasurementValue)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:CalculationMethodHierarchy rdf:%s=\"%s\">\n%s\t</cim:CalculationMethodHierarchy>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object CalculationMethodHierarchy
    extends
        CIMParseable[CalculationMethodHierarchy]
{
    override val fields: Array[String] = Array[String](
        "CalculationMethodOrder",
        "Measurement",
        "MeasurementValue"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("CalculationMethodOrder", "CalculationMethodOrder", "0..*", "1"),
        CIMRelationship("Measurement", "Measurement", "0..*", "0..1"),
        CIMRelationship("MeasurementValue", "MeasurementValue", "0..1", "0..1")
    )
    val CalculationMethodOrder: FielderMultiple = parse_attributes(attribute(cls, fields(0)))
    val Measurement: FielderMultiple = parse_attributes(attribute(cls, fields(1)))
    val MeasurementValue: Fielder = parse_attribute(attribute(cls, fields(2)))

    def parse (context: CIMContext): CalculationMethodHierarchy =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CalculationMethodHierarchy(
            IdentifiedObject.parse(context),
            masks(CalculationMethodOrder(), 0),
            masks(Measurement(), 1),
            mask(MeasurementValue(), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CalculationMethodHierarchy] = CalculationMethodHierarchySerializer
}

object CalculationMethodHierarchySerializer extends CIMSerializer[CalculationMethodHierarchy]
{
    def write (kryo: Kryo, output: Output, obj: CalculationMethodHierarchy): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => writeList(obj.CalculationMethodOrder, output),
            () => writeList(obj.Measurement, output),
            () => output.writeString(obj.MeasurementValue)
        )
        IdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CalculationMethodHierarchy]): CalculationMethodHierarchy =
    {
        val parent = IdentifiedObjectSerializer.read(kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = CalculationMethodHierarchy(
            parent,
            if (isSet(0)) readList(input) else null,
            if (isSet(1)) readList(input) else null,
            if (isSet(2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The order of this calculation method in a hierarchy of calculation methods.
 *
 * @param Element                    Reference to the superclass object.
 * @param order                      Order of the statistical calculation method within the calculation method hierarchy.
 * @param CalculationMethodHierarchy [[ch.ninecode.model.CalculationMethodHierarchy CalculationMethodHierarchy]] The calculation method hierarchy of which this order of statistical calculation is a member.
 * @param StatisicalCalculation      [[ch.ninecode.model.StatisticalCalculation StatisticalCalculation]] The statistical calculation done at this order.
 * @group AssetMeas
 * @groupname AssetMeas Package AssetMeas
 */
final case class CalculationMethodOrder
(
    Element: BasicElement = null,
    order: Int = 0,
    CalculationMethodHierarchy: String = null,
    StatisicalCalculation: String = null
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
        implicit val clz: String = CalculationMethodOrder.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(CalculationMethodOrder.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(CalculationMethodOrder.fields(position), value)

        emitelem(0, order)
        emitattr(1, CalculationMethodHierarchy)
        emitattr(2, StatisicalCalculation)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:CalculationMethodOrder rdf:%s=\"%s\">\n%s\t</cim:CalculationMethodOrder>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object CalculationMethodOrder
    extends
        CIMParseable[CalculationMethodOrder]
{
    override val fields: Array[String] = Array[String](
        "order",
        "CalculationMethodHierarchy",
        "StatisicalCalculation"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("CalculationMethodHierarchy", "CalculationMethodHierarchy", "1", "0..*"),
        CIMRelationship("StatisicalCalculation", "StatisticalCalculation", "1", "0..*")
    )
    val order: Fielder = parse_element(element(cls, fields(0)))
    val CalculationMethodHierarchy: Fielder = parse_attribute(attribute(cls, fields(1)))
    val StatisicalCalculation: Fielder = parse_attribute(attribute(cls, fields(2)))

    def parse (context: CIMContext): CalculationMethodOrder =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CalculationMethodOrder(
            BasicElement.parse(context),
            toInteger(mask(order(), 0)),
            mask(CalculationMethodHierarchy(), 1),
            mask(StatisicalCalculation(), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CalculationMethodOrder] = CalculationMethodOrderSerializer
}

object CalculationMethodOrderSerializer extends CIMSerializer[CalculationMethodOrder]
{
    def write (kryo: Kryo, output: Output, obj: CalculationMethodOrder): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeInt(obj.order),
            () => output.writeString(obj.CalculationMethodHierarchy),
            () => output.writeString(obj.StatisicalCalculation)
        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CalculationMethodOrder]): CalculationMethodOrder =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = CalculationMethodOrder(
            parent,
            if (isSet(0)) input.readInt else 0,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Asset inspection type of analog.
 *
 * @param AssetAnalog [[ch.ninecode.model.AssetAnalog AssetAnalog]] Reference to the superclass object.
 * @param kind        Kind of analog representing inspection result.
 * @group AssetMeas
 * @groupname AssetMeas Package AssetMeas
 */
final case class InspectionAnalog
(
    AssetAnalog: AssetAnalog = null,
    kind: String = null
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
    override def sup: AssetAnalog = AssetAnalog

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
        implicit val clz: String = InspectionAnalog.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(InspectionAnalog.fields(position), value)

        emitattr(0, kind)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:InspectionAnalog rdf:%s=\"%s\">\n%s\t</cim:InspectionAnalog>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object InspectionAnalog
    extends
        CIMParseable[InspectionAnalog]
{
    override val fields: Array[String] = Array[String](
        "kind"
    )
    val kind: Fielder = parse_attribute(attribute(cls, fields(0)))

    def parse (context: CIMContext): InspectionAnalog =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = InspectionAnalog(
            AssetAnalog.parse(context),
            mask(kind(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[InspectionAnalog] = InspectionAnalogSerializer
}

object InspectionAnalogSerializer extends CIMSerializer[InspectionAnalog]
{
    def write (kryo: Kryo, output: Output, obj: InspectionAnalog): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.kind)
        )
        AssetAnalogSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[InspectionAnalog]): InspectionAnalog =
    {
        val parent = AssetAnalogSerializer.read(kryo, input, classOf[AssetAnalog])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = InspectionAnalog(
            parent,
            if (isSet(0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Asset inspection type of discrete.
 *
 * @param AssetDiscrete [[ch.ninecode.model.AssetDiscrete AssetDiscrete]] Reference to the superclass object.
 * @param kind          Kind of discrete representing inspection result.
 * @group AssetMeas
 * @groupname AssetMeas Package AssetMeas
 */
final case class InspectionDiscrete
(
    AssetDiscrete: AssetDiscrete = null,
    kind: String = null
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
    override def sup: AssetDiscrete = AssetDiscrete

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
        implicit val clz: String = InspectionDiscrete.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(InspectionDiscrete.fields(position), value)

        emitattr(0, kind)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:InspectionDiscrete rdf:%s=\"%s\">\n%s\t</cim:InspectionDiscrete>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object InspectionDiscrete
    extends
        CIMParseable[InspectionDiscrete]
{
    override val fields: Array[String] = Array[String](
        "kind"
    )
    val kind: Fielder = parse_attribute(attribute(cls, fields(0)))

    def parse (context: CIMContext): InspectionDiscrete =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = InspectionDiscrete(
            AssetDiscrete.parse(context),
            mask(kind(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[InspectionDiscrete] = InspectionDiscreteSerializer
}

object InspectionDiscreteSerializer extends CIMSerializer[InspectionDiscrete]
{
    def write (kryo: Kryo, output: Output, obj: InspectionDiscrete): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.kind)
        )
        AssetDiscreteSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[InspectionDiscrete]): InspectionDiscrete =
    {
        val parent = AssetDiscreteSerializer.read(kryo, input, classOf[AssetDiscrete])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = InspectionDiscrete(
            parent,
            if (isSet(0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Asset oil analysis fluid test type of analog.
 *
 * @param AssetAnalog [[ch.ninecode.model.AssetAnalog AssetAnalog]] Reference to the superclass object.
 * @param kind        Kind of analog representing oil fluid test analysis result.
 * @group AssetMeas
 * @groupname AssetMeas Package AssetMeas
 */
final case class OilAnalysisFluidAnalog
(
    AssetAnalog: AssetAnalog = null,
    kind: String = null
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
    override def sup: AssetAnalog = AssetAnalog

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
        implicit val clz: String = OilAnalysisFluidAnalog.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(OilAnalysisFluidAnalog.fields(position), value)

        emitattr(0, kind)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:OilAnalysisFluidAnalog rdf:%s=\"%s\">\n%s\t</cim:OilAnalysisFluidAnalog>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object OilAnalysisFluidAnalog
    extends
        CIMParseable[OilAnalysisFluidAnalog]
{
    override val fields: Array[String] = Array[String](
        "kind"
    )
    val kind: Fielder = parse_attribute(attribute(cls, fields(0)))

    def parse (context: CIMContext): OilAnalysisFluidAnalog =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OilAnalysisFluidAnalog(
            AssetAnalog.parse(context),
            mask(kind(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OilAnalysisFluidAnalog] = OilAnalysisFluidAnalogSerializer
}

object OilAnalysisFluidAnalogSerializer extends CIMSerializer[OilAnalysisFluidAnalog]
{
    def write (kryo: Kryo, output: Output, obj: OilAnalysisFluidAnalog): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.kind)
        )
        AssetAnalogSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OilAnalysisFluidAnalog]): OilAnalysisFluidAnalog =
    {
        val parent = AssetAnalogSerializer.read(kryo, input, classOf[AssetAnalog])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = OilAnalysisFluidAnalog(
            parent,
            if (isSet(0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Asset oil analysis fluid type of discrete.
 *
 * @param AssetDiscrete [[ch.ninecode.model.AssetDiscrete AssetDiscrete]] Reference to the superclass object.
 * @param kind          Kind of discrete representing oil fluid test analysis result.
 * @group AssetMeas
 * @groupname AssetMeas Package AssetMeas
 */
final case class OilAnalysisFluidDiscrete
(
    AssetDiscrete: AssetDiscrete = null,
    kind: String = null
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
    override def sup: AssetDiscrete = AssetDiscrete

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
        implicit val clz: String = OilAnalysisFluidDiscrete.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(OilAnalysisFluidDiscrete.fields(position), value)

        emitattr(0, kind)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:OilAnalysisFluidDiscrete rdf:%s=\"%s\">\n%s\t</cim:OilAnalysisFluidDiscrete>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object OilAnalysisFluidDiscrete
    extends
        CIMParseable[OilAnalysisFluidDiscrete]
{
    override val fields: Array[String] = Array[String](
        "kind"
    )
    val kind: Fielder = parse_attribute(attribute(cls, fields(0)))

    def parse (context: CIMContext): OilAnalysisFluidDiscrete =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OilAnalysisFluidDiscrete(
            AssetDiscrete.parse(context),
            mask(kind(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OilAnalysisFluidDiscrete] = OilAnalysisFluidDiscreteSerializer
}

object OilAnalysisFluidDiscreteSerializer extends CIMSerializer[OilAnalysisFluidDiscrete]
{
    def write (kryo: Kryo, output: Output, obj: OilAnalysisFluidDiscrete): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.kind)
        )
        AssetDiscreteSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OilAnalysisFluidDiscrete]): OilAnalysisFluidDiscrete =
    {
        val parent = AssetDiscreteSerializer.read(kryo, input, classOf[AssetDiscrete])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = OilAnalysisFluidDiscrete(
            parent,
            if (isSet(0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Asset oil analysis gas type of analog.
 *
 * @param AssetAnalog [[ch.ninecode.model.AssetAnalog AssetAnalog]] Reference to the superclass object.
 * @param kind        Kind of analog representing oil dissolved gases analysis result.
 * @group AssetMeas
 * @groupname AssetMeas Package AssetMeas
 */
final case class OilAnalysisGasAnalog
(
    AssetAnalog: AssetAnalog = null,
    kind: String = null
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
    override def sup: AssetAnalog = AssetAnalog

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
        implicit val clz: String = OilAnalysisGasAnalog.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(OilAnalysisGasAnalog.fields(position), value)

        emitattr(0, kind)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:OilAnalysisGasAnalog rdf:%s=\"%s\">\n%s\t</cim:OilAnalysisGasAnalog>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object OilAnalysisGasAnalog
    extends
        CIMParseable[OilAnalysisGasAnalog]
{
    override val fields: Array[String] = Array[String](
        "kind"
    )
    val kind: Fielder = parse_attribute(attribute(cls, fields(0)))

    def parse (context: CIMContext): OilAnalysisGasAnalog =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OilAnalysisGasAnalog(
            AssetAnalog.parse(context),
            mask(kind(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OilAnalysisGasAnalog] = OilAnalysisGasAnalogSerializer
}

object OilAnalysisGasAnalogSerializer extends CIMSerializer[OilAnalysisGasAnalog]
{
    def write (kryo: Kryo, output: Output, obj: OilAnalysisGasAnalog): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.kind)
        )
        AssetAnalogSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OilAnalysisGasAnalog]): OilAnalysisGasAnalog =
    {
        val parent = AssetAnalogSerializer.read(kryo, input, classOf[AssetAnalog])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = OilAnalysisGasAnalog(
            parent,
            if (isSet(0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Asset oil analysis metals type of analog.
 *
 * @param AssetAnalog [[ch.ninecode.model.AssetAnalog AssetAnalog]] Reference to the superclass object.
 * @param kind        Kind of analog representing oil metals elements analysis result.
 * @group AssetMeas
 * @groupname AssetMeas Package AssetMeas
 */
final case class OilAnalysisMetalsAnalog
(
    AssetAnalog: AssetAnalog = null,
    kind: String = null
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
    override def sup: AssetAnalog = AssetAnalog

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
        implicit val clz: String = OilAnalysisMetalsAnalog.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(OilAnalysisMetalsAnalog.fields(position), value)

        emitattr(0, kind)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:OilAnalysisMetalsAnalog rdf:%s=\"%s\">\n%s\t</cim:OilAnalysisMetalsAnalog>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object OilAnalysisMetalsAnalog
    extends
        CIMParseable[OilAnalysisMetalsAnalog]
{
    override val fields: Array[String] = Array[String](
        "kind"
    )
    val kind: Fielder = parse_attribute(attribute(cls, fields(0)))

    def parse (context: CIMContext): OilAnalysisMetalsAnalog =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OilAnalysisMetalsAnalog(
            AssetAnalog.parse(context),
            mask(kind(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OilAnalysisMetalsAnalog] = OilAnalysisMetalsAnalogSerializer
}

object OilAnalysisMetalsAnalogSerializer extends CIMSerializer[OilAnalysisMetalsAnalog]
{
    def write (kryo: Kryo, output: Output, obj: OilAnalysisMetalsAnalog): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.kind)
        )
        AssetAnalogSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OilAnalysisMetalsAnalog]): OilAnalysisMetalsAnalog =
    {
        val parent = AssetAnalogSerializer.read(kryo, input, classOf[AssetAnalog])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = OilAnalysisMetalsAnalog(
            parent,
            if (isSet(0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Asset oil analysis moisture type of analog.
 *
 * @param AssetAnalog [[ch.ninecode.model.AssetAnalog AssetAnalog]] Reference to the superclass object.
 * @param kind        Kind of analog representing oil moisture analysis result.
 * @group AssetMeas
 * @groupname AssetMeas Package AssetMeas
 */
final case class OilAnalysisMoistureAnalog
(
    AssetAnalog: AssetAnalog = null,
    kind: String = null
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
    override def sup: AssetAnalog = AssetAnalog

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
        implicit val clz: String = OilAnalysisMoistureAnalog.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(OilAnalysisMoistureAnalog.fields(position), value)

        emitattr(0, kind)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:OilAnalysisMoistureAnalog rdf:%s=\"%s\">\n%s\t</cim:OilAnalysisMoistureAnalog>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object OilAnalysisMoistureAnalog
    extends
        CIMParseable[OilAnalysisMoistureAnalog]
{
    override val fields: Array[String] = Array[String](
        "kind"
    )
    val kind: Fielder = parse_attribute(attribute(cls, fields(0)))

    def parse (context: CIMContext): OilAnalysisMoistureAnalog =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OilAnalysisMoistureAnalog(
            AssetAnalog.parse(context),
            mask(kind(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OilAnalysisMoistureAnalog] = OilAnalysisMoistureAnalogSerializer
}

object OilAnalysisMoistureAnalogSerializer extends CIMSerializer[OilAnalysisMoistureAnalog]
{
    def write (kryo: Kryo, output: Output, obj: OilAnalysisMoistureAnalog): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.kind)
        )
        AssetAnalogSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OilAnalysisMoistureAnalog]): OilAnalysisMoistureAnalog =
    {
        val parent = AssetAnalogSerializer.read(kryo, input, classOf[AssetAnalog])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = OilAnalysisMoistureAnalog(
            parent,
            if (isSet(0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Asset oil analysis PCB type of analog.
 *
 * @param AssetAnalog [[ch.ninecode.model.AssetAnalog AssetAnalog]] Reference to the superclass object.
 * @param kind        Kind of analog representing oil PCB analysis result.
 * @group AssetMeas
 * @groupname AssetMeas Package AssetMeas
 */
final case class OilAnalysisPCBAnalog
(
    AssetAnalog: AssetAnalog = null,
    kind: String = null
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
    override def sup: AssetAnalog = AssetAnalog

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
        implicit val clz: String = OilAnalysisPCBAnalog.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(OilAnalysisPCBAnalog.fields(position), value)

        emitattr(0, kind)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:OilAnalysisPCBAnalog rdf:%s=\"%s\">\n%s\t</cim:OilAnalysisPCBAnalog>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object OilAnalysisPCBAnalog
    extends
        CIMParseable[OilAnalysisPCBAnalog]
{
    override val fields: Array[String] = Array[String](
        "kind"
    )
    val kind: Fielder = parse_attribute(attribute(cls, fields(0)))

    def parse (context: CIMContext): OilAnalysisPCBAnalog =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OilAnalysisPCBAnalog(
            AssetAnalog.parse(context),
            mask(kind(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OilAnalysisPCBAnalog] = OilAnalysisPCBAnalogSerializer
}

object OilAnalysisPCBAnalogSerializer extends CIMSerializer[OilAnalysisPCBAnalog]
{
    def write (kryo: Kryo, output: Output, obj: OilAnalysisPCBAnalog): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.kind)
        )
        AssetAnalogSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OilAnalysisPCBAnalog]): OilAnalysisPCBAnalog =
    {
        val parent = AssetAnalogSerializer.read(kryo, input, classOf[AssetAnalog])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = OilAnalysisPCBAnalog(
            parent,
            if (isSet(0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Asset oil analysis PCB type of discrete.
 *
 * @param AssetDiscrete [[ch.ninecode.model.AssetDiscrete AssetDiscrete]] Reference to the superclass object.
 * @param kind          Kind of discrete representing oil PCB test analysis result.
 * @group AssetMeas
 * @groupname AssetMeas Package AssetMeas
 */
final case class OilAnalysisPCBDiscrete
(
    AssetDiscrete: AssetDiscrete = null,
    kind: String = null
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
    override def sup: AssetDiscrete = AssetDiscrete

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
        implicit val clz: String = OilAnalysisPCBDiscrete.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(OilAnalysisPCBDiscrete.fields(position), value)

        emitattr(0, kind)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:OilAnalysisPCBDiscrete rdf:%s=\"%s\">\n%s\t</cim:OilAnalysisPCBDiscrete>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object OilAnalysisPCBDiscrete
    extends
        CIMParseable[OilAnalysisPCBDiscrete]
{
    override val fields: Array[String] = Array[String](
        "kind"
    )
    val kind: Fielder = parse_attribute(attribute(cls, fields(0)))

    def parse (context: CIMContext): OilAnalysisPCBDiscrete =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OilAnalysisPCBDiscrete(
            AssetDiscrete.parse(context),
            mask(kind(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OilAnalysisPCBDiscrete] = OilAnalysisPCBDiscreteSerializer
}

object OilAnalysisPCBDiscreteSerializer extends CIMSerializer[OilAnalysisPCBDiscrete]
{
    def write (kryo: Kryo, output: Output, obj: OilAnalysisPCBDiscrete): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.kind)
        )
        AssetDiscreteSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OilAnalysisPCBDiscrete]): OilAnalysisPCBDiscrete =
    {
        val parent = AssetDiscreteSerializer.read(kryo, input, classOf[AssetDiscrete])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = OilAnalysisPCBDiscrete(
            parent,
            if (isSet(0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Asset oil inspection paper type of analog.
 *
 * @param AssetAnalog [[ch.ninecode.model.AssetAnalog AssetAnalog]] Reference to the superclass object.
 * @param kind        Kind of analog representing oil paper degradation analysis result.
 * @group AssetMeas
 * @groupname AssetMeas Package AssetMeas
 */
final case class OilAnalysisPaperAnalog
(
    AssetAnalog: AssetAnalog = null,
    kind: String = null
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
    override def sup: AssetAnalog = AssetAnalog

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
        implicit val clz: String = OilAnalysisPaperAnalog.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(OilAnalysisPaperAnalog.fields(position), value)

        emitattr(0, kind)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:OilAnalysisPaperAnalog rdf:%s=\"%s\">\n%s\t</cim:OilAnalysisPaperAnalog>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object OilAnalysisPaperAnalog
    extends
        CIMParseable[OilAnalysisPaperAnalog]
{
    override val fields: Array[String] = Array[String](
        "kind"
    )
    val kind: Fielder = parse_attribute(attribute(cls, fields(0)))

    def parse (context: CIMContext): OilAnalysisPaperAnalog =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OilAnalysisPaperAnalog(
            AssetAnalog.parse(context),
            mask(kind(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OilAnalysisPaperAnalog] = OilAnalysisPaperAnalogSerializer
}

object OilAnalysisPaperAnalogSerializer extends CIMSerializer[OilAnalysisPaperAnalog]
{
    def write (kryo: Kryo, output: Output, obj: OilAnalysisPaperAnalog): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.kind)
        )
        AssetAnalogSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OilAnalysisPaperAnalog]): OilAnalysisPaperAnalog =
    {
        val parent = AssetAnalogSerializer.read(kryo, input, classOf[AssetAnalog])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = OilAnalysisPaperAnalog(
            parent,
            if (isSet(0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Asset oil analysis particle type of analog.
 *
 * @param AssetAnalog [[ch.ninecode.model.AssetAnalog AssetAnalog]] Reference to the superclass object.
 * @param kind        Kind of analog representing oil particulate analysis result.
 * @group AssetMeas
 * @groupname AssetMeas Package AssetMeas
 */
final case class OilAnalysisParticleAnalog
(
    AssetAnalog: AssetAnalog = null,
    kind: String = null
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
    override def sup: AssetAnalog = AssetAnalog

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
        implicit val clz: String = OilAnalysisParticleAnalog.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(OilAnalysisParticleAnalog.fields(position), value)

        emitattr(0, kind)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:OilAnalysisParticleAnalog rdf:%s=\"%s\">\n%s\t</cim:OilAnalysisParticleAnalog>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object OilAnalysisParticleAnalog
    extends
        CIMParseable[OilAnalysisParticleAnalog]
{
    override val fields: Array[String] = Array[String](
        "kind"
    )
    val kind: Fielder = parse_attribute(attribute(cls, fields(0)))

    def parse (context: CIMContext): OilAnalysisParticleAnalog =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OilAnalysisParticleAnalog(
            AssetAnalog.parse(context),
            mask(kind(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OilAnalysisParticleAnalog] = OilAnalysisParticleAnalogSerializer
}

object OilAnalysisParticleAnalogSerializer extends CIMSerializer[OilAnalysisParticleAnalog]
{
    def write (kryo: Kryo, output: Output, obj: OilAnalysisParticleAnalog): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.kind)
        )
        AssetAnalogSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OilAnalysisParticleAnalog]): OilAnalysisParticleAnalog =
    {
        val parent = AssetAnalogSerializer.read(kryo, input, classOf[AssetAnalog])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = OilAnalysisParticleAnalog(
            parent,
            if (isSet(0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Asset oil analysis particle type of discrete.
 *
 * @param AssetDiscrete [[ch.ninecode.model.AssetDiscrete AssetDiscrete]] Reference to the superclass object.
 * @param kind          Kind of discrete representing oil particulate analysis result.
 * @group AssetMeas
 * @groupname AssetMeas Package AssetMeas
 */
final case class OilAnalysisParticleDiscrete
(
    AssetDiscrete: AssetDiscrete = null,
    kind: String = null
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
    override def sup: AssetDiscrete = AssetDiscrete

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
        implicit val clz: String = OilAnalysisParticleDiscrete.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(OilAnalysisParticleDiscrete.fields(position), value)

        emitattr(0, kind)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:OilAnalysisParticleDiscrete rdf:%s=\"%s\">\n%s\t</cim:OilAnalysisParticleDiscrete>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object OilAnalysisParticleDiscrete
    extends
        CIMParseable[OilAnalysisParticleDiscrete]
{
    override val fields: Array[String] = Array[String](
        "kind"
    )
    val kind: Fielder = parse_attribute(attribute(cls, fields(0)))

    def parse (context: CIMContext): OilAnalysisParticleDiscrete =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OilAnalysisParticleDiscrete(
            AssetDiscrete.parse(context),
            mask(kind(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OilAnalysisParticleDiscrete] = OilAnalysisParticleDiscreteSerializer
}

object OilAnalysisParticleDiscreteSerializer extends CIMSerializer[OilAnalysisParticleDiscrete]
{
    def write (kryo: Kryo, output: Output, obj: OilAnalysisParticleDiscrete): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.kind)
        )
        AssetDiscreteSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OilAnalysisParticleDiscrete]): OilAnalysisParticleDiscrete =
    {
        val parent = AssetDiscreteSerializer.read(kryo, input, classOf[AssetDiscrete])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = OilAnalysisParticleDiscrete(
            parent,
            if (isSet(0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Description of period for which calculation is performed.
 *
 * Conditions:
 * F:
 * {Not sure where these came from… delete from UML?}
 *
 * @param StatisticalCalculation       [[ch.ninecode.model.StatisticalCalculation StatisticalCalculation]] Reference to the superclass object.
 * @param calculationIntervalMagnitude Number of units (of calculationIntervalUnit) in the calculation interval.
 * @param calculationIntervalUnit      Unit in which calculation interval is defined.
 * @group AssetMeas
 * @groupname AssetMeas Package AssetMeas
 */
final case class PeriodicStatisticalCalculation
(
    StatisticalCalculation: StatisticalCalculation = null,
    calculationIntervalMagnitude: Int = 0,
    calculationIntervalUnit: String = null
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
    override def sup: StatisticalCalculation = StatisticalCalculation

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
        implicit val clz: String = PeriodicStatisticalCalculation.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(PeriodicStatisticalCalculation.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(PeriodicStatisticalCalculation.fields(position), value)

        emitelem(0, calculationIntervalMagnitude)
        emitattr(1, calculationIntervalUnit)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:PeriodicStatisticalCalculation rdf:%s=\"%s\">\n%s\t</cim:PeriodicStatisticalCalculation>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object PeriodicStatisticalCalculation
    extends
        CIMParseable[PeriodicStatisticalCalculation]
{
    override val fields: Array[String] = Array[String](
        "calculationIntervalMagnitude",
        "calculationIntervalUnit"
    )
    val calculationIntervalMagnitude: Fielder = parse_element(element(cls, fields(0)))
    val calculationIntervalUnit: Fielder = parse_attribute(attribute(cls, fields(1)))

    def parse (context: CIMContext): PeriodicStatisticalCalculation =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PeriodicStatisticalCalculation(
            StatisticalCalculation.parse(context),
            toInteger(mask(calculationIntervalMagnitude(), 0)),
            mask(calculationIntervalUnit(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[PeriodicStatisticalCalculation] = PeriodicStatisticalCalculationSerializer
}

object PeriodicStatisticalCalculationSerializer extends CIMSerializer[PeriodicStatisticalCalculation]
{
    def write (kryo: Kryo, output: Output, obj: PeriodicStatisticalCalculation): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeInt(obj.calculationIntervalMagnitude),
            () => output.writeString(obj.calculationIntervalUnit)
        )
        StatisticalCalculationSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PeriodicStatisticalCalculation]): PeriodicStatisticalCalculation =
    {
        val parent = StatisticalCalculationSerializer.read(kryo, input, classOf[StatisticalCalculation])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = PeriodicStatisticalCalculation(
            parent,
            if (isSet(0)) input.readInt else 0,
            if (isSet(1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Description of statistical calculation performed.
 *
 * @param IdentifiedObject       [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param calculationMode        Calculation mode.
 * @param calculationTechnique   Kind of statistical calculation, specifying how the measurement value is calculated.
 * @param CalculationMethodOrder [[ch.ninecode.model.CalculationMethodOrder CalculationMethodOrder]] The order in which this statistical calculation is done.
 * @group AssetMeas
 * @groupname AssetMeas Package AssetMeas
 */
final case class StatisticalCalculation
(
    IdentifiedObject: IdentifiedObject = null,
    calculationMode: String = null,
    calculationTechnique: String = null,
    CalculationMethodOrder: List[String] = null
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
        implicit val clz: String = StatisticalCalculation.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(StatisticalCalculation.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(StatisticalCalculation.fields(position), x))

        emitattr(0, calculationMode)
        emitattr(1, calculationTechnique)
        emitattrs(2, CalculationMethodOrder)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:StatisticalCalculation rdf:%s=\"%s\">\n%s\t</cim:StatisticalCalculation>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object StatisticalCalculation
    extends
        CIMParseable[StatisticalCalculation]
{
    override val fields: Array[String] = Array[String](
        "calculationMode",
        "calculationTechnique",
        "CalculationMethodOrder"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("CalculationMethodOrder", "CalculationMethodOrder", "0..*", "1")
    )
    val calculationMode: Fielder = parse_attribute(attribute(cls, fields(0)))
    val calculationTechnique: Fielder = parse_attribute(attribute(cls, fields(1)))
    val CalculationMethodOrder: FielderMultiple = parse_attributes(attribute(cls, fields(2)))

    def parse (context: CIMContext): StatisticalCalculation =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = StatisticalCalculation(
            IdentifiedObject.parse(context),
            mask(calculationMode(), 0),
            mask(calculationTechnique(), 1),
            masks(CalculationMethodOrder(), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[StatisticalCalculation] = StatisticalCalculationSerializer
}

object StatisticalCalculationSerializer extends CIMSerializer[StatisticalCalculation]
{
    def write (kryo: Kryo, output: Output, obj: StatisticalCalculation): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.calculationMode),
            () => output.writeString(obj.calculationTechnique),
            () => writeList(obj.CalculationMethodOrder, output)
        )
        IdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[StatisticalCalculation]): StatisticalCalculation =
    {
        val parent = IdentifiedObjectSerializer.read(kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = StatisticalCalculation(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _AssetMeas
{
    def register: List[CIMClassInfo] =
    {
        List(
            AssetAnalog.register,
            AssetDiscrete.register,
            AssetStringMeasurement.register,
            AssetTemperaturePressureAnalog.register,
            CalculationMethodHierarchy.register,
            CalculationMethodOrder.register,
            InspectionAnalog.register,
            InspectionDiscrete.register,
            OilAnalysisFluidAnalog.register,
            OilAnalysisFluidDiscrete.register,
            OilAnalysisGasAnalog.register,
            OilAnalysisMetalsAnalog.register,
            OilAnalysisMoistureAnalog.register,
            OilAnalysisPCBAnalog.register,
            OilAnalysisPCBDiscrete.register,
            OilAnalysisPaperAnalog.register,
            OilAnalysisParticleAnalog.register,
            OilAnalysisParticleDiscrete.register,
            PeriodicStatisticalCalculation.register,
            StatisticalCalculation.register
        )
    }
}
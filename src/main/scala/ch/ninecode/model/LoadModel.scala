package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * ConformLoad represent loads that follow a daily load change pattern where the pattern can be used to scale the load with a system load.
 *
 * @param sup [[ch.ninecode.model.EnergyConsumer EnergyConsumer]] Reference to the superclass object.
 * @param LoadGroup [[ch.ninecode.model.ConformLoadGroup ConformLoadGroup]] Group of this ConformLoad.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modeling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and daytypes, are also included here.

This information is used by Load Forecasting and Load Management.
 */
case class ConformLoad
(
    override val sup: EnergyConsumer,
    LoadGroup: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def EnergyConsumer: EnergyConsumer = sup.asInstanceOf[EnergyConsumer]
    override def copy (): Row = { clone ().asInstanceOf[ConformLoad] }
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
        implicit val clz: String = ConformLoad.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ConformLoad.fields (position), value)
        emitattr (0, LoadGroup)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ConformLoad rdf:ID=\"%s\">\n%s\t</cim:ConformLoad>".format (id, export_fields)
    }
}

object ConformLoad
extends
    Parseable[ConformLoad]
{
    val fields: Array[String] = Array[String] (
        "LoadGroup"
    )
    val LoadGroup: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): ConformLoad =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = ConformLoad (
            EnergyConsumer.parse (context),
            mask (LoadGroup (), 0)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("LoadGroup", "ConformLoadGroup", false)
    )
}

/**
 * A group of loads conforming to an allocation pattern.
 *
 * @param sup [[ch.ninecode.model.LoadGroup LoadGroup]] Reference to the superclass object.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modeling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and daytypes, are also included here.

This information is used by Load Forecasting and Load Management.
 */
case class ConformLoadGroup
(
    override val sup: LoadGroup
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def LoadGroup: LoadGroup = sup.asInstanceOf[LoadGroup]
    override def copy (): Row = { clone ().asInstanceOf[ConformLoadGroup] }
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
        "\t<cim:ConformLoadGroup rdf:ID=\"%s\">\n%s\t</cim:ConformLoadGroup>".format (id, export_fields)
    }
}

object ConformLoadGroup
extends
    Parseable[ConformLoadGroup]
{

    def parse (context: Context): ConformLoadGroup =
    {
        implicit val ctx: Context = context
        val ret = ConformLoadGroup (
            LoadGroup.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * A curve of load  versus time (X-axis) showing the active power values (Y1-axis) and reactive power (Y2-axis) for each unit of the period covered.
 *
 * This curve represents a typical pattern of load over the time period for a given day type and season.
 *
 * @param sup [[ch.ninecode.model.SeasonDayTypeSchedule SeasonDayTypeSchedule]] Reference to the superclass object.
 * @param ConformLoadGroup [[ch.ninecode.model.ConformLoadGroup ConformLoadGroup]] The ConformLoadGroup where the ConformLoadSchedule belongs.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modeling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and daytypes, are also included here.

This information is used by Load Forecasting and Load Management.
 */
case class ConformLoadSchedule
(
    override val sup: SeasonDayTypeSchedule,
    ConformLoadGroup: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def SeasonDayTypeSchedule: SeasonDayTypeSchedule = sup.asInstanceOf[SeasonDayTypeSchedule]
    override def copy (): Row = { clone ().asInstanceOf[ConformLoadSchedule] }
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
        implicit val clz: String = ConformLoadSchedule.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ConformLoadSchedule.fields (position), value)
        emitattr (0, ConformLoadGroup)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ConformLoadSchedule rdf:ID=\"%s\">\n%s\t</cim:ConformLoadSchedule>".format (id, export_fields)
    }
}

object ConformLoadSchedule
extends
    Parseable[ConformLoadSchedule]
{
    val fields: Array[String] = Array[String] (
        "ConformLoadGroup"
    )
    val ConformLoadGroup: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): ConformLoadSchedule =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = ConformLoadSchedule (
            SeasonDayTypeSchedule.parse (context),
            mask (ConformLoadGroup (), 0)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ConformLoadGroup", "ConformLoadGroup", false)
    )
}

/**
 * Group of similar days.
 *
 * For example it could be used to represent weekdays, weekend, or holidays.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modeling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and daytypes, are also included here.

This information is used by Load Forecasting and Load Management.
 */
case class DayType
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[DayType] }
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
        "\t<cim:DayType rdf:ID=\"%s\">\n%s\t</cim:DayType>".format (id, export_fields)
    }
}

object DayType
extends
    Parseable[DayType]
{

    def parse (context: Context): DayType =
    {
        implicit val ctx: Context = context
        val ret = DayType (
            IdentifiedObject.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Describes an area having energy production or consumption.
 *
 * Specializations are intended to support the load allocation function as typically required in energy management systems or planning studies to allocate hypothesized load levels to individual load points for power flow analysis.  Often the energy area can be linked to both measured and forecast load levels.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ControlArea [[ch.ninecode.model.ControlArea ControlArea]] The control area specification that is used for the load forecast.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modeling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and daytypes, are also included here.

This information is used by Load Forecasting and Load Management.
 */
case class EnergyArea
(
    override val sup: IdentifiedObject,
    ControlArea: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[EnergyArea] }
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
        implicit val clz: String = EnergyArea.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnergyArea.fields (position), value)
        emitattr (0, ControlArea)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnergyArea rdf:ID=\"%s\">\n%s\t</cim:EnergyArea>".format (id, export_fields)
    }
}

object EnergyArea
extends
    Parseable[EnergyArea]
{
    val fields: Array[String] = Array[String] (
        "ControlArea"
    )
    val ControlArea: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): EnergyArea =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = EnergyArea (
            IdentifiedObject.parse (context),
            mask (ControlArea (), 0)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ControlArea", "ControlArea", false)
    )
}

/**
 * The class is the root or first level in a hierarchical structure for grouping of loads for the purpose of load flow load scaling.
 *
 * @param sup [[ch.ninecode.model.EnergyArea EnergyArea]] Reference to the superclass object.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modeling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and daytypes, are also included here.

This information is used by Load Forecasting and Load Management.
 */
case class LoadArea
(
    override val sup: EnergyArea
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def EnergyArea: EnergyArea = sup.asInstanceOf[EnergyArea]
    override def copy (): Row = { clone ().asInstanceOf[LoadArea] }
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
        "\t<cim:LoadArea rdf:ID=\"%s\">\n%s\t</cim:LoadArea>".format (id, export_fields)
    }
}

object LoadArea
extends
    Parseable[LoadArea]
{

    def parse (context: Context): LoadArea =
    {
        implicit val ctx: Context = context
        val ret = LoadArea (
            EnergyArea.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * The class is the third level in a hierarchical structure for grouping of loads for the purpose of load flow load scaling.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param SubLoadArea [[ch.ninecode.model.SubLoadArea SubLoadArea]] The SubLoadArea where the Loadgroup belongs.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modeling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and daytypes, are also included here.

This information is used by Load Forecasting and Load Management.
 */
case class LoadGroup
(
    override val sup: IdentifiedObject,
    SubLoadArea: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[LoadGroup] }
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
        implicit val clz: String = LoadGroup.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LoadGroup.fields (position), value)
        emitattr (0, SubLoadArea)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LoadGroup rdf:ID=\"%s\">\n%s\t</cim:LoadGroup>".format (id, export_fields)
    }
}

object LoadGroup
extends
    Parseable[LoadGroup]
{
    val fields: Array[String] = Array[String] (
        "SubLoadArea"
    )
    val SubLoadArea: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): LoadGroup =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = LoadGroup (
            IdentifiedObject.parse (context),
            mask (SubLoadArea (), 0)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("SubLoadArea", "SubLoadArea", false)
    )
}

/**
 * Models the characteristic response of the load demand due to changes in system conditions such as voltage and frequency.
 *
 * This is not related to demand response.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param exponentModel Indicates the exponential voltage dependency model is to be used.
 *        If false, the coefficient model is to be used.
 * @param pConstantCurrent Portion of active power load modeled as constant current.
 * @param pConstantImpedance Portion of active power load modeled as constant impedance.
 * @param pConstantPower Portion of active power load modeled as constant power.
 * @param pFrequencyExponent Exponent of per unit frequency effecting active power.
 * @param pVoltageExponent Exponent of per unit voltage effecting real power.
 * @param qConstantCurrent Portion of reactive power load modeled as constant current.
 * @param qConstantImpedance Portion of reactive power load modeled as constant impedance.
 * @param qConstantPower Portion of reactive power load modeled as constant power.
 * @param qFrequencyExponent Exponent of per unit frequency effecting reactive power.
 * @param qVoltageExponent Exponent of per unit voltage effecting reactive power.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modeling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and daytypes, are also included here.

This information is used by Load Forecasting and Load Management.
 */
case class LoadResponseCharacteristic
(
    override val sup: IdentifiedObject,
    exponentModel: Boolean,
    pConstantCurrent: Double,
    pConstantImpedance: Double,
    pConstantPower: Double,
    pFrequencyExponent: Double,
    pVoltageExponent: Double,
    qConstantCurrent: Double,
    qConstantImpedance: Double,
    qConstantPower: Double,
    qFrequencyExponent: Double,
    qVoltageExponent: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[LoadResponseCharacteristic] }
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
        implicit val clz: String = LoadResponseCharacteristic.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LoadResponseCharacteristic.fields (position), value)
        emitelem (0, exponentModel)
        emitelem (1, pConstantCurrent)
        emitelem (2, pConstantImpedance)
        emitelem (3, pConstantPower)
        emitelem (4, pFrequencyExponent)
        emitelem (5, pVoltageExponent)
        emitelem (6, qConstantCurrent)
        emitelem (7, qConstantImpedance)
        emitelem (8, qConstantPower)
        emitelem (9, qFrequencyExponent)
        emitelem (10, qVoltageExponent)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LoadResponseCharacteristic rdf:ID=\"%s\">\n%s\t</cim:LoadResponseCharacteristic>".format (id, export_fields)
    }
}

object LoadResponseCharacteristic
extends
    Parseable[LoadResponseCharacteristic]
{
    val fields: Array[String] = Array[String] (
        "exponentModel",
        "pConstantCurrent",
        "pConstantImpedance",
        "pConstantPower",
        "pFrequencyExponent",
        "pVoltageExponent",
        "qConstantCurrent",
        "qConstantImpedance",
        "qConstantPower",
        "qFrequencyExponent",
        "qVoltageExponent"
    )
    val exponentModel: Fielder = parse_element (element (cls, fields(0)))
    val pConstantCurrent: Fielder = parse_element (element (cls, fields(1)))
    val pConstantImpedance: Fielder = parse_element (element (cls, fields(2)))
    val pConstantPower: Fielder = parse_element (element (cls, fields(3)))
    val pFrequencyExponent: Fielder = parse_element (element (cls, fields(4)))
    val pVoltageExponent: Fielder = parse_element (element (cls, fields(5)))
    val qConstantCurrent: Fielder = parse_element (element (cls, fields(6)))
    val qConstantImpedance: Fielder = parse_element (element (cls, fields(7)))
    val qConstantPower: Fielder = parse_element (element (cls, fields(8)))
    val qFrequencyExponent: Fielder = parse_element (element (cls, fields(9)))
    val qVoltageExponent: Fielder = parse_element (element (cls, fields(10)))

    def parse (context: Context): LoadResponseCharacteristic =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = LoadResponseCharacteristic (
            IdentifiedObject.parse (context),
            toBoolean (mask (exponentModel (), 0)),
            toDouble (mask (pConstantCurrent (), 1)),
            toDouble (mask (pConstantImpedance (), 2)),
            toDouble (mask (pConstantPower (), 3)),
            toDouble (mask (pFrequencyExponent (), 4)),
            toDouble (mask (pVoltageExponent (), 5)),
            toDouble (mask (qConstantCurrent (), 6)),
            toDouble (mask (qConstantImpedance (), 7)),
            toDouble (mask (qConstantPower (), 8)),
            toDouble (mask (qFrequencyExponent (), 9)),
            toDouble (mask (qVoltageExponent (), 10))
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * NonConformLoad represent loads that do not follow a daily load change pattern and changes are not correlated with the daily load change pattern.
 *
 * @param sup [[ch.ninecode.model.EnergyConsumer EnergyConsumer]] Reference to the superclass object.
 * @param LoadGroup [[ch.ninecode.model.NonConformLoadGroup NonConformLoadGroup]] Group of this ConformLoad.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modeling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and daytypes, are also included here.

This information is used by Load Forecasting and Load Management.
 */
case class NonConformLoad
(
    override val sup: EnergyConsumer,
    LoadGroup: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def EnergyConsumer: EnergyConsumer = sup.asInstanceOf[EnergyConsumer]
    override def copy (): Row = { clone ().asInstanceOf[NonConformLoad] }
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
        implicit val clz: String = NonConformLoad.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (NonConformLoad.fields (position), value)
        emitattr (0, LoadGroup)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:NonConformLoad rdf:ID=\"%s\">\n%s\t</cim:NonConformLoad>".format (id, export_fields)
    }
}

object NonConformLoad
extends
    Parseable[NonConformLoad]
{
    val fields: Array[String] = Array[String] (
        "LoadGroup"
    )
    val LoadGroup: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): NonConformLoad =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = NonConformLoad (
            EnergyConsumer.parse (context),
            mask (LoadGroup (), 0)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("LoadGroup", "NonConformLoadGroup", false)
    )
}

/**
 * Loads that do not follow a daily and seasonal load variation pattern.
 *
 * @param sup [[ch.ninecode.model.LoadGroup LoadGroup]] Reference to the superclass object.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modeling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and daytypes, are also included here.

This information is used by Load Forecasting and Load Management.
 */
case class NonConformLoadGroup
(
    override val sup: LoadGroup
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def LoadGroup: LoadGroup = sup.asInstanceOf[LoadGroup]
    override def copy (): Row = { clone ().asInstanceOf[NonConformLoadGroup] }
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
        "\t<cim:NonConformLoadGroup rdf:ID=\"%s\">\n%s\t</cim:NonConformLoadGroup>".format (id, export_fields)
    }
}

object NonConformLoadGroup
extends
    Parseable[NonConformLoadGroup]
{

    def parse (context: Context): NonConformLoadGroup =
    {
        implicit val ctx: Context = context
        val ret = NonConformLoadGroup (
            LoadGroup.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * An active power (Y1-axis) and reactive power (Y2-axis) schedule (curves) versus time (X-axis) for non-conforming loads, e.g., large industrial load or power station service (where modeled).
 *
 * @param sup [[ch.ninecode.model.SeasonDayTypeSchedule SeasonDayTypeSchedule]] Reference to the superclass object.
 * @param NonConformLoadGroup [[ch.ninecode.model.NonConformLoadGroup NonConformLoadGroup]] The NonConformLoadGroup where the NonConformLoadSchedule belongs.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modeling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and daytypes, are also included here.

This information is used by Load Forecasting and Load Management.
 */
case class NonConformLoadSchedule
(
    override val sup: SeasonDayTypeSchedule,
    NonConformLoadGroup: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def SeasonDayTypeSchedule: SeasonDayTypeSchedule = sup.asInstanceOf[SeasonDayTypeSchedule]
    override def copy (): Row = { clone ().asInstanceOf[NonConformLoadSchedule] }
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
        implicit val clz: String = NonConformLoadSchedule.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (NonConformLoadSchedule.fields (position), value)
        emitattr (0, NonConformLoadGroup)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:NonConformLoadSchedule rdf:ID=\"%s\">\n%s\t</cim:NonConformLoadSchedule>".format (id, export_fields)
    }
}

object NonConformLoadSchedule
extends
    Parseable[NonConformLoadSchedule]
{
    val fields: Array[String] = Array[String] (
        "NonConformLoadGroup"
    )
    val NonConformLoadGroup: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): NonConformLoadSchedule =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = NonConformLoadSchedule (
            SeasonDayTypeSchedule.parse (context),
            mask (NonConformLoadGroup (), 0)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("NonConformLoadGroup", "NonConformLoadGroup", false)
    )
}

/**
 * An area or zone of the power system which is used for load shedding purposes.
 *
 * @param sup [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param cutLevel1 First level (amount) of load to cut as a percentage of total zone load.
 * @param cutLevel2 Second level (amount) of load to cut as a percentage of total zone load.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modeling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and daytypes, are also included here.

This information is used by Load Forecasting and Load Management.
 */
case class PowerCutZone
(
    override val sup: PowerSystemResource,
    cutLevel1: Double,
    cutLevel2: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def PowerSystemResource: PowerSystemResource = sup.asInstanceOf[PowerSystemResource]
    override def copy (): Row = { clone ().asInstanceOf[PowerCutZone] }
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
        implicit val clz: String = PowerCutZone.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PowerCutZone.fields (position), value)
        emitelem (0, cutLevel1)
        emitelem (1, cutLevel2)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PowerCutZone rdf:ID=\"%s\">\n%s\t</cim:PowerCutZone>".format (id, export_fields)
    }
}

object PowerCutZone
extends
    Parseable[PowerCutZone]
{
    val fields: Array[String] = Array[String] (
        "cutLevel1",
        "cutLevel2"
    )
    val cutLevel1: Fielder = parse_element (element (cls, fields(0)))
    val cutLevel2: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): PowerCutZone =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = PowerCutZone (
            PowerSystemResource.parse (context),
            toDouble (mask (cutLevel1 (), 0)),
            toDouble (mask (cutLevel2 (), 1))
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * A specified time period of the year.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param endDate Date season ends.
 * @param startDate Date season starts.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modeling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and daytypes, are also included here.

This information is used by Load Forecasting and Load Management.
 */
case class Season
(
    override val sup: IdentifiedObject,
    endDate: String,
    startDate: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Season] }
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
        implicit val clz: String = Season.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Season.fields (position), value)
        emitelem (0, endDate)
        emitelem (1, startDate)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Season rdf:ID=\"%s\">\n%s\t</cim:Season>".format (id, export_fields)
    }
}

object Season
extends
    Parseable[Season]
{
    val fields: Array[String] = Array[String] (
        "endDate",
        "startDate"
    )
    val endDate: Fielder = parse_element (element (cls, fields(0)))
    val startDate: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: Context): Season =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = Season (
            IdentifiedObject.parse (context),
            mask (endDate (), 0),
            mask (startDate (), 1)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * A time schedule covering a 24 hour period, with curve data for a specific type of season and day.
 *
 * @param sup [[ch.ninecode.model.RegularIntervalSchedule RegularIntervalSchedule]] Reference to the superclass object.
 * @param DayType [[ch.ninecode.model.DayType DayType]] DayType for the Schedule.
 * @param Season [[ch.ninecode.model.Season Season]] Season for the Schedule.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modeling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and daytypes, are also included here.

This information is used by Load Forecasting and Load Management.
 */
case class SeasonDayTypeSchedule
(
    override val sup: RegularIntervalSchedule,
    DayType: String,
    Season: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def RegularIntervalSchedule: RegularIntervalSchedule = sup.asInstanceOf[RegularIntervalSchedule]
    override def copy (): Row = { clone ().asInstanceOf[SeasonDayTypeSchedule] }
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
        implicit val clz: String = SeasonDayTypeSchedule.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SeasonDayTypeSchedule.fields (position), value)
        emitattr (0, DayType)
        emitattr (1, Season)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SeasonDayTypeSchedule rdf:ID=\"%s\">\n%s\t</cim:SeasonDayTypeSchedule>".format (id, export_fields)
    }
}

object SeasonDayTypeSchedule
extends
    Parseable[SeasonDayTypeSchedule]
{
    val fields: Array[String] = Array[String] (
        "DayType",
        "Season"
    )
    val DayType: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Season: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): SeasonDayTypeSchedule =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = SeasonDayTypeSchedule (
            RegularIntervalSchedule.parse (context),
            mask (DayType (), 0),
            mask (Season (), 1)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("DayType", "DayType", false),
        Relationship ("Season", "Season", false)
    )
}

/**
 * Station supply with load derived from the station output.
 *
 * @param sup [[ch.ninecode.model.EnergyConsumer EnergyConsumer]] Reference to the superclass object.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modeling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and daytypes, are also included here.

This information is used by Load Forecasting and Load Management.
 */
case class StationSupply
(
    override val sup: EnergyConsumer
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def EnergyConsumer: EnergyConsumer = sup.asInstanceOf[EnergyConsumer]
    override def copy (): Row = { clone ().asInstanceOf[StationSupply] }
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
        "\t<cim:StationSupply rdf:ID=\"%s\">\n%s\t</cim:StationSupply>".format (id, export_fields)
    }
}

object StationSupply
extends
    Parseable[StationSupply]
{

    def parse (context: Context): StationSupply =
    {
        implicit val ctx: Context = context
        val ret = StationSupply (
            EnergyConsumer.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * The class is the second level in a hierarchical structure for grouping of loads for the purpose of load flow load scaling.
 *
 * @param sup [[ch.ninecode.model.EnergyArea EnergyArea]] Reference to the superclass object.
 * @param LoadArea [[ch.ninecode.model.LoadArea LoadArea]] The LoadArea where the SubLoadArea belongs.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modeling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and daytypes, are also included here.

This information is used by Load Forecasting and Load Management.
 */
case class SubLoadArea
(
    override val sup: EnergyArea,
    LoadArea: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Valid fields bitmap.
     * One (1) in a bit position means that field was found in parsing, zero means it has an indeterminate value.
     * Field order is specified by the @see{#fields} array.
     */
    var bitfields: Int = -1
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def EnergyArea: EnergyArea = sup.asInstanceOf[EnergyArea]
    override def copy (): Row = { clone ().asInstanceOf[SubLoadArea] }
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
        implicit val clz: String = SubLoadArea.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SubLoadArea.fields (position), value)
        emitattr (0, LoadArea)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SubLoadArea rdf:ID=\"%s\">\n%s\t</cim:SubLoadArea>".format (id, export_fields)
    }
}

object SubLoadArea
extends
    Parseable[SubLoadArea]
{
    val fields: Array[String] = Array[String] (
        "LoadArea"
    )
    val LoadArea: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): SubLoadArea =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = SubLoadArea (
            EnergyArea.parse (context),
            mask (LoadArea (), 0)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("LoadArea", "LoadArea", false)
    )
}

private[ninecode] object _LoadModel
{
    def register: List[ClassInfo] =
    {
        List (
            ConformLoad.register,
            ConformLoadGroup.register,
            ConformLoadSchedule.register,
            DayType.register,
            EnergyArea.register,
            LoadArea.register,
            LoadGroup.register,
            LoadResponseCharacteristic.register,
            NonConformLoad.register,
            NonConformLoadGroup.register,
            NonConformLoadSchedule.register,
            PowerCutZone.register,
            Season.register,
            SeasonDayTypeSchedule.register,
            StationSupply.register,
            SubLoadArea.register
        )
    }
}
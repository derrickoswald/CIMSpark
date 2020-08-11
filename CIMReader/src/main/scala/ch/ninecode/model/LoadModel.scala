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
 * ConformLoad represent loads that follow a daily load change pattern where the pattern can be used to scale the load with a system load.
 *
 * @param EnergyConsumer [[ch.ninecode.model.EnergyConsumer EnergyConsumer]] Reference to the superclass object.
 * @param LoadGroup      [[ch.ninecode.model.ConformLoadGroup ConformLoadGroup]] Group of this ConformLoad.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modelling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and day types, are also included here.
 *
 *            This information is used by Load Forecasting and Load Management.
 */
final case class ConformLoad
(
    EnergyConsumer: EnergyConsumer = null,
    LoadGroup: String = null
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
    override def sup: EnergyConsumer = EnergyConsumer

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
        implicit val clz: String = ConformLoad.cls

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
        CIMParseable[ConformLoad]
{
    override val fields: Array[String] = Array [String](
        "LoadGroup"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("LoadGroup", "ConformLoadGroup", "0..1", "0..*")
    )
    val LoadGroup: Fielder = parse_attribute (attribute (cls, fields (0)))

    def parse (context: CIMContext): ConformLoad =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = ConformLoad (
            EnergyConsumer.parse (context),
            mask (LoadGroup (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ConformLoad] = ConformLoadSerializer
}

object ConformLoadSerializer extends CIMSerializer[ConformLoad]
{
    def write (kryo: Kryo, output: Output, obj: ConformLoad): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.LoadGroup)
        )
        EnergyConsumerSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ConformLoad]): ConformLoad =
    {
        val parent = EnergyConsumerSerializer.read (kryo, input, classOf [EnergyConsumer])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ConformLoad (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A group of loads conforming to an allocation pattern.
 *
 * @param LoadGroup            [[ch.ninecode.model.LoadGroup LoadGroup]] Reference to the superclass object.
 * @param ConformLoadSchedules [[ch.ninecode.model.ConformLoadSchedule ConformLoadSchedule]] The ConformLoadSchedules in the ConformLoadGroup.
 * @param EnergyConsumers      [[ch.ninecode.model.ConformLoad ConformLoad]] Conform loads assigned to this ConformLoadGroup.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modelling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and day types, are also included here.
 *
 *            This information is used by Load Forecasting and Load Management.
 */
final case class ConformLoadGroup
(
    LoadGroup: LoadGroup = null,
    ConformLoadSchedules: List[String] = null,
    EnergyConsumers: List[String] = null
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
    override def sup: LoadGroup = LoadGroup

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
        implicit val clz: String = ConformLoadGroup.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ConformLoadGroup.fields (position), x))

        emitattrs (0, ConformLoadSchedules)
        emitattrs (1, EnergyConsumers)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ConformLoadGroup rdf:ID=\"%s\">\n%s\t</cim:ConformLoadGroup>".format (id, export_fields)
    }
}

object ConformLoadGroup
    extends
        CIMParseable[ConformLoadGroup]
{
    override val fields: Array[String] = Array [String](
        "ConformLoadSchedules",
        "EnergyConsumers"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ConformLoadSchedules", "ConformLoadSchedule", "0..*", "1"),
        CIMRelationship ("EnergyConsumers", "ConformLoad", "0..*", "0..1")
    )
    val ConformLoadSchedules: FielderMultiple = parse_attributes (attribute (cls, fields (0)))
    val EnergyConsumers: FielderMultiple = parse_attributes (attribute (cls, fields (1)))

    def parse (context: CIMContext): ConformLoadGroup =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = ConformLoadGroup (
            LoadGroup.parse (context),
            masks (ConformLoadSchedules (), 0),
            masks (EnergyConsumers (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ConformLoadGroup] = ConformLoadGroupSerializer
}

object ConformLoadGroupSerializer extends CIMSerializer[ConformLoadGroup]
{
    def write (kryo: Kryo, output: Output, obj: ConformLoadGroup): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.ConformLoadSchedules, output),
            () => writeList (obj.EnergyConsumers, output)
        )
        LoadGroupSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ConformLoadGroup]): ConformLoadGroup =
    {
        val parent = LoadGroupSerializer.read (kryo, input, classOf [LoadGroup])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ConformLoadGroup (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A curve of load  versus time (X-axis) showing the active power values (Y1-axis) and reactive power (Y2-axis) for each unit of the period covered.
 *
 * This curve represents a typical pattern of load over the time period for a given day type and season.
 *
 * @param SeasonDayTypeSchedule [[ch.ninecode.model.SeasonDayTypeSchedule SeasonDayTypeSchedule]] Reference to the superclass object.
 * @param ConformLoadGroup      [[ch.ninecode.model.ConformLoadGroup ConformLoadGroup]] The ConformLoadGroup where the ConformLoadSchedule belongs.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modelling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and day types, are also included here.
 *
 *            This information is used by Load Forecasting and Load Management.
 */
final case class ConformLoadSchedule
(
    SeasonDayTypeSchedule: SeasonDayTypeSchedule = null,
    ConformLoadGroup: String = null
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
    override def sup: SeasonDayTypeSchedule = SeasonDayTypeSchedule

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
        implicit val clz: String = ConformLoadSchedule.cls

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
        CIMParseable[ConformLoadSchedule]
{
    override val fields: Array[String] = Array [String](
        "ConformLoadGroup"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ConformLoadGroup", "ConformLoadGroup", "1", "0..*")
    )
    val ConformLoadGroup: Fielder = parse_attribute (attribute (cls, fields (0)))

    def parse (context: CIMContext): ConformLoadSchedule =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = ConformLoadSchedule (
            SeasonDayTypeSchedule.parse (context),
            mask (ConformLoadGroup (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ConformLoadSchedule] = ConformLoadScheduleSerializer
}

object ConformLoadScheduleSerializer extends CIMSerializer[ConformLoadSchedule]
{
    def write (kryo: Kryo, output: Output, obj: ConformLoadSchedule): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.ConformLoadGroup)
        )
        SeasonDayTypeScheduleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ConformLoadSchedule]): ConformLoadSchedule =
    {
        val parent = SeasonDayTypeScheduleSerializer.read (kryo, input, classOf [SeasonDayTypeSchedule])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ConformLoadSchedule (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Group of similar days.
 *
 * For example it could be used to represent weekdays, weekend, or holidays.
 *
 * @param IdentifiedObject       [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param SeasonDayTypeSchedules [[ch.ninecode.model.SeasonDayTypeSchedule SeasonDayTypeSchedule]] Schedules that use this DayType.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modelling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and day types, are also included here.
 *
 *            This information is used by Load Forecasting and Load Management.
 */
final case class DayType
(
    IdentifiedObject: IdentifiedObject = null,
    SeasonDayTypeSchedules: List[String] = null
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
        implicit val clz: String = DayType.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (DayType.fields (position), x))

        emitattrs (0, SeasonDayTypeSchedules)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DayType rdf:ID=\"%s\">\n%s\t</cim:DayType>".format (id, export_fields)
    }
}

object DayType
    extends
        CIMParseable[DayType]
{
    override val fields: Array[String] = Array [String](
        "SeasonDayTypeSchedules"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("SeasonDayTypeSchedules", "SeasonDayTypeSchedule", "0..*", "0..1")
    )
    val SeasonDayTypeSchedules: FielderMultiple = parse_attributes (attribute (cls, fields (0)))

    def parse (context: CIMContext): DayType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = DayType (
            IdentifiedObject.parse (context),
            masks (SeasonDayTypeSchedules (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DayType] = DayTypeSerializer
}

object DayTypeSerializer extends CIMSerializer[DayType]
{
    def write (kryo: Kryo, output: Output, obj: DayType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.SeasonDayTypeSchedules, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DayType]): DayType =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = DayType (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Describes an area having energy production or consumption.
 *
 * Specializations are intended to support the load allocation function as typically required in energy management systems or planning studies to allocate hypothesized load levels to individual load points for power flow analysis.  Often the energy area can be linked to both measured and forecast load levels.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param ControlArea      [[ch.ninecode.model.ControlArea ControlArea]] The control area specification that is used for the load forecast.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modelling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and day types, are also included here.
 *
 *            This information is used by Load Forecasting and Load Management.
 */
final case class EnergyArea
(
    IdentifiedObject: IdentifiedObject = null,
    ControlArea: String = null
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
        implicit val clz: String = EnergyArea.cls

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
        CIMParseable[EnergyArea]
{
    override val fields: Array[String] = Array [String](
        "ControlArea"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ControlArea", "ControlArea", "0..1", "0..1")
    )
    val ControlArea: Fielder = parse_attribute (attribute (cls, fields (0)))

    def parse (context: CIMContext): EnergyArea =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = EnergyArea (
            IdentifiedObject.parse (context),
            mask (ControlArea (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[EnergyArea] = EnergyAreaSerializer
}

object EnergyAreaSerializer extends CIMSerializer[EnergyArea]
{
    def write (kryo: Kryo, output: Output, obj: EnergyArea): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.ControlArea)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EnergyArea]): EnergyArea =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = EnergyArea (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The class is the root or first level in a hierarchical structure for grouping of loads for the purpose of load flow load scaling.
 *
 * @param EnergyArea   [[ch.ninecode.model.EnergyArea EnergyArea]] Reference to the superclass object.
 * @param SubLoadAreas [[ch.ninecode.model.SubLoadArea SubLoadArea]] The SubLoadAreas in the LoadArea.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modelling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and day types, are also included here.
 *
 *            This information is used by Load Forecasting and Load Management.
 */
final case class LoadArea
(
    EnergyArea: EnergyArea = null,
    SubLoadAreas: List[String] = null
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
    override def sup: EnergyArea = EnergyArea

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
        implicit val clz: String = LoadArea.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (LoadArea.fields (position), x))

        emitattrs (0, SubLoadAreas)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:LoadArea rdf:ID=\"%s\">\n%s\t</cim:LoadArea>".format (id, export_fields)
    }
}

object LoadArea
    extends
        CIMParseable[LoadArea]
{
    override val fields: Array[String] = Array [String](
        "SubLoadAreas"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("SubLoadAreas", "SubLoadArea", "1..*", "1")
    )
    val SubLoadAreas: FielderMultiple = parse_attributes (attribute (cls, fields (0)))

    def parse (context: CIMContext): LoadArea =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = LoadArea (
            EnergyArea.parse (context),
            masks (SubLoadAreas (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[LoadArea] = LoadAreaSerializer
}

object LoadAreaSerializer extends CIMSerializer[LoadArea]
{
    def write (kryo: Kryo, output: Output, obj: LoadArea): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.SubLoadAreas, output)
        )
        EnergyAreaSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[LoadArea]): LoadArea =
    {
        val parent = EnergyAreaSerializer.read (kryo, input, classOf [EnergyArea])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = LoadArea (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The class is the third level in a hierarchical structure for grouping of loads for the purpose of load flow load scaling.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param SubLoadArea      [[ch.ninecode.model.SubLoadArea SubLoadArea]] The SubLoadArea where the Loadgroup belongs.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modelling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and day types, are also included here.
 *
 *            This information is used by Load Forecasting and Load Management.
 */
final case class LoadGroup
(
    IdentifiedObject: IdentifiedObject = null,
    SubLoadArea: String = null
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
        implicit val clz: String = LoadGroup.cls

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
        CIMParseable[LoadGroup]
{
    override val fields: Array[String] = Array [String](
        "SubLoadArea"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("SubLoadArea", "SubLoadArea", "1", "1..*")
    )
    val SubLoadArea: Fielder = parse_attribute (attribute (cls, fields (0)))

    def parse (context: CIMContext): LoadGroup =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = LoadGroup (
            IdentifiedObject.parse (context),
            mask (SubLoadArea (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[LoadGroup] = LoadGroupSerializer
}

object LoadGroupSerializer extends CIMSerializer[LoadGroup]
{
    def write (kryo: Kryo, output: Output, obj: LoadGroup): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.SubLoadArea)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[LoadGroup]): LoadGroup =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = LoadGroup (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Models the characteristic response of the load demand due to changes in system conditions such as voltage and frequency.
 *
 * It is not related to demand response.
 * If LoadResponseCharacteristic.exponentModel is True, the exponential voltage or frequency dependent models are specified and used as to calculate active and reactive power components of the load model.
 * The equations to calculate active and reactive power components of the load model are internal to the power flow calculation, hence they use different quantities depending on the use case of the data exchange.
 * The equations for exponential voltage dependent load model injected power are:
 * pInjection= Pnominal* (Voltage/cim:BaseVoltage.nominalVoltage) ** cim:LoadResponseCharacteristic.pVoltageExponent
 * qInjection= Qnominal* (Voltage/cim:BaseVoltage.nominalVoltage) ** cim:LoadResponseCharacteristic.qVoltageExponent
 * Where:
 * 1) * means "multiply" and ** is "raised to power of";
 * 2) Pnominal and Qnominal represent the active power and reactive power at nominal voltage as any load described by the voltage exponential model shall be given at nominal voltage.  This means that EnergyConsumer.p and EnergyConsumer.q  are at nominal voltage.
 * 3) After power flow is solved:
 * -pInjection and qInjection correspond to SvPowerflow.p and SvPowerflow.q respectively.
 * - Voltage corresponds to SvVoltage.v at the TopologicalNode where the load is connected.
 *
 * @param IdentifiedObject   [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param exponentModel      Indicates the exponential voltage dependency model is to be used.
 *                           If false, the coefficient model is to be used.
 *                           The exponential voltage dependency model consist of the attributes:
 *        - pVoltageExponent
 *        - qVoltageExponent
 *        - pFrequencyExponent
 *        - qFrequencyExponent.
 *          The coefficient model consist of the attributes:
 *        - pConstantImpedance
 *        - pConstantCurrent
 *        - pConstantPower
 *        - qConstantImpedance
 *        - qConstantCurrent
 *        - qConstantPower.
 *          The sum of pConstantImpedance, pConstantCurrent and pConstantPower shall equal 1.
 *          The sum of qConstantImpedance, qConstantCurrent and qConstantPower shall equal 1.
 * @param pConstantCurrent   Portion of active power load modelled as constant current.
 * @param pConstantImpedance Portion of active power load modelled as constant impedance.
 * @param pConstantPower     Portion of active power load modelled as constant power.
 * @param pFrequencyExponent Exponent of per unit frequency effecting active power.
 * @param pVoltageExponent   Exponent of per unit voltage effecting real power.
 * @param qConstantCurrent   Portion of reactive power load modelled as constant current.
 * @param qConstantImpedance Portion of reactive power load modelled as constant impedance.
 * @param qConstantPower     Portion of reactive power load modelled as constant power.
 * @param qFrequencyExponent Exponent of per unit frequency effecting reactive power.
 * @param qVoltageExponent   Exponent of per unit voltage effecting reactive power.
 * @param EnergyConsumer     [[ch.ninecode.model.EnergyConsumer EnergyConsumer]] The set of loads that have the response characteristics.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modelling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and day types, are also included here.
 *
 *            This information is used by Load Forecasting and Load Management.
 */
final case class LoadResponseCharacteristic
(
    IdentifiedObject: IdentifiedObject = null,
    exponentModel: Boolean = false,
    pConstantCurrent: Double = 0.0,
    pConstantImpedance: Double = 0.0,
    pConstantPower: Double = 0.0,
    pFrequencyExponent: Double = 0.0,
    pVoltageExponent: Double = 0.0,
    qConstantCurrent: Double = 0.0,
    qConstantImpedance: Double = 0.0,
    qConstantPower: Double = 0.0,
    qFrequencyExponent: Double = 0.0,
    qVoltageExponent: Double = 0.0,
    EnergyConsumer: List[String] = null
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
        implicit val clz: String = LoadResponseCharacteristic.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (LoadResponseCharacteristic.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (LoadResponseCharacteristic.fields (position), x))

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
        emitattrs (11, EnergyConsumer)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:LoadResponseCharacteristic rdf:ID=\"%s\">\n%s\t</cim:LoadResponseCharacteristic>".format (id, export_fields)
    }
}

object LoadResponseCharacteristic
    extends
        CIMParseable[LoadResponseCharacteristic]
{
    override val fields: Array[String] = Array [String](
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
        "qVoltageExponent",
        "EnergyConsumer"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("EnergyConsumer", "EnergyConsumer", "0..*", "0..1")
    )
    val exponentModel: Fielder = parse_element (element (cls, fields (0)))
    val pConstantCurrent: Fielder = parse_element (element (cls, fields (1)))
    val pConstantImpedance: Fielder = parse_element (element (cls, fields (2)))
    val pConstantPower: Fielder = parse_element (element (cls, fields (3)))
    val pFrequencyExponent: Fielder = parse_element (element (cls, fields (4)))
    val pVoltageExponent: Fielder = parse_element (element (cls, fields (5)))
    val qConstantCurrent: Fielder = parse_element (element (cls, fields (6)))
    val qConstantImpedance: Fielder = parse_element (element (cls, fields (7)))
    val qConstantPower: Fielder = parse_element (element (cls, fields (8)))
    val qFrequencyExponent: Fielder = parse_element (element (cls, fields (9)))
    val qVoltageExponent: Fielder = parse_element (element (cls, fields (10)))
    val EnergyConsumer: FielderMultiple = parse_attributes (attribute (cls, fields (11)))

    def parse (context: CIMContext): LoadResponseCharacteristic =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
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
            toDouble (mask (qVoltageExponent (), 10)),
            masks (EnergyConsumer (), 11)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[LoadResponseCharacteristic] = LoadResponseCharacteristicSerializer
}

object LoadResponseCharacteristicSerializer extends CIMSerializer[LoadResponseCharacteristic]
{
    def write (kryo: Kryo, output: Output, obj: LoadResponseCharacteristic): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeBoolean (obj.exponentModel),
            () => output.writeDouble (obj.pConstantCurrent),
            () => output.writeDouble (obj.pConstantImpedance),
            () => output.writeDouble (obj.pConstantPower),
            () => output.writeDouble (obj.pFrequencyExponent),
            () => output.writeDouble (obj.pVoltageExponent),
            () => output.writeDouble (obj.qConstantCurrent),
            () => output.writeDouble (obj.qConstantImpedance),
            () => output.writeDouble (obj.qConstantPower),
            () => output.writeDouble (obj.qFrequencyExponent),
            () => output.writeDouble (obj.qVoltageExponent),
            () => writeList (obj.EnergyConsumer, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[LoadResponseCharacteristic]): LoadResponseCharacteristic =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = LoadResponseCharacteristic (
            parent,
            if (isSet (0)) input.readBoolean else false,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readDouble else 0.0,
            if (isSet (6)) input.readDouble else 0.0,
            if (isSet (7)) input.readDouble else 0.0,
            if (isSet (8)) input.readDouble else 0.0,
            if (isSet (9)) input.readDouble else 0.0,
            if (isSet (10)) input.readDouble else 0.0,
            if (isSet (11)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * NonConformLoad represents loads that do not follow a daily load change pattern and whose changes are not correlated with the daily load change pattern.
 *
 * @param EnergyConsumer [[ch.ninecode.model.EnergyConsumer EnergyConsumer]] Reference to the superclass object.
 * @param LoadGroup      [[ch.ninecode.model.NonConformLoadGroup NonConformLoadGroup]] Group of this ConformLoad.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modelling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and day types, are also included here.
 *
 *            This information is used by Load Forecasting and Load Management.
 */
final case class NonConformLoad
(
    EnergyConsumer: EnergyConsumer = null,
    LoadGroup: String = null
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
    override def sup: EnergyConsumer = EnergyConsumer

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
        implicit val clz: String = NonConformLoad.cls

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
        CIMParseable[NonConformLoad]
{
    override val fields: Array[String] = Array [String](
        "LoadGroup"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("LoadGroup", "NonConformLoadGroup", "0..1", "0..*")
    )
    val LoadGroup: Fielder = parse_attribute (attribute (cls, fields (0)))

    def parse (context: CIMContext): NonConformLoad =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = NonConformLoad (
            EnergyConsumer.parse (context),
            mask (LoadGroup (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[NonConformLoad] = NonConformLoadSerializer
}

object NonConformLoadSerializer extends CIMSerializer[NonConformLoad]
{
    def write (kryo: Kryo, output: Output, obj: NonConformLoad): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.LoadGroup)
        )
        EnergyConsumerSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[NonConformLoad]): NonConformLoad =
    {
        val parent = EnergyConsumerSerializer.read (kryo, input, classOf [EnergyConsumer])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = NonConformLoad (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Loads that do not follow a daily and seasonal load variation pattern.
 *
 * @param LoadGroup               [[ch.ninecode.model.LoadGroup LoadGroup]] Reference to the superclass object.
 * @param EnergyConsumers         [[ch.ninecode.model.NonConformLoad NonConformLoad]] Conform loads assigned to this ConformLoadGroup.
 * @param NonConformLoadSchedules [[ch.ninecode.model.NonConformLoadSchedule NonConformLoadSchedule]] The NonConformLoadSchedules in the NonConformLoadGroup.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modelling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and day types, are also included here.
 *
 *            This information is used by Load Forecasting and Load Management.
 */
final case class NonConformLoadGroup
(
    LoadGroup: LoadGroup = null,
    EnergyConsumers: List[String] = null,
    NonConformLoadSchedules: List[String] = null
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
    override def sup: LoadGroup = LoadGroup

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
        implicit val clz: String = NonConformLoadGroup.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (NonConformLoadGroup.fields (position), x))

        emitattrs (0, EnergyConsumers)
        emitattrs (1, NonConformLoadSchedules)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:NonConformLoadGroup rdf:ID=\"%s\">\n%s\t</cim:NonConformLoadGroup>".format (id, export_fields)
    }
}

object NonConformLoadGroup
    extends
        CIMParseable[NonConformLoadGroup]
{
    override val fields: Array[String] = Array [String](
        "EnergyConsumers",
        "NonConformLoadSchedules"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("EnergyConsumers", "NonConformLoad", "0..*", "0..1"),
        CIMRelationship ("NonConformLoadSchedules", "NonConformLoadSchedule", "0..*", "1")
    )
    val EnergyConsumers: FielderMultiple = parse_attributes (attribute (cls, fields (0)))
    val NonConformLoadSchedules: FielderMultiple = parse_attributes (attribute (cls, fields (1)))

    def parse (context: CIMContext): NonConformLoadGroup =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = NonConformLoadGroup (
            LoadGroup.parse (context),
            masks (EnergyConsumers (), 0),
            masks (NonConformLoadSchedules (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[NonConformLoadGroup] = NonConformLoadGroupSerializer
}

object NonConformLoadGroupSerializer extends CIMSerializer[NonConformLoadGroup]
{
    def write (kryo: Kryo, output: Output, obj: NonConformLoadGroup): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.EnergyConsumers, output),
            () => writeList (obj.NonConformLoadSchedules, output)
        )
        LoadGroupSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[NonConformLoadGroup]): NonConformLoadGroup =
    {
        val parent = LoadGroupSerializer.read (kryo, input, classOf [LoadGroup])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = NonConformLoadGroup (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An active power (Y1-axis) and reactive power (Y2-axis) schedule (curves) versus time (X-axis) for non-conforming loads, e.g., large industrial load or power station service (where modelled).
 *
 * @param SeasonDayTypeSchedule [[ch.ninecode.model.SeasonDayTypeSchedule SeasonDayTypeSchedule]] Reference to the superclass object.
 * @param NonConformLoadGroup   [[ch.ninecode.model.NonConformLoadGroup NonConformLoadGroup]] The NonConformLoadGroup where the NonConformLoadSchedule belongs.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modelling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and day types, are also included here.
 *
 *            This information is used by Load Forecasting and Load Management.
 */
final case class NonConformLoadSchedule
(
    SeasonDayTypeSchedule: SeasonDayTypeSchedule = null,
    NonConformLoadGroup: String = null
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
    override def sup: SeasonDayTypeSchedule = SeasonDayTypeSchedule

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
        implicit val clz: String = NonConformLoadSchedule.cls

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
        CIMParseable[NonConformLoadSchedule]
{
    override val fields: Array[String] = Array [String](
        "NonConformLoadGroup"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("NonConformLoadGroup", "NonConformLoadGroup", "1", "0..*")
    )
    val NonConformLoadGroup: Fielder = parse_attribute (attribute (cls, fields (0)))

    def parse (context: CIMContext): NonConformLoadSchedule =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = NonConformLoadSchedule (
            SeasonDayTypeSchedule.parse (context),
            mask (NonConformLoadGroup (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[NonConformLoadSchedule] = NonConformLoadScheduleSerializer
}

object NonConformLoadScheduleSerializer extends CIMSerializer[NonConformLoadSchedule]
{
    def write (kryo: Kryo, output: Output, obj: NonConformLoadSchedule): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.NonConformLoadGroup)
        )
        SeasonDayTypeScheduleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[NonConformLoadSchedule]): NonConformLoadSchedule =
    {
        val parent = SeasonDayTypeScheduleSerializer.read (kryo, input, classOf [SeasonDayTypeSchedule])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = NonConformLoadSchedule (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An area or zone of the power system which is used for load shedding purposes.
 *
 * @param PowerSystemResource [[ch.ninecode.model.PowerSystemResource PowerSystemResource]] Reference to the superclass object.
 * @param cutLevel1           First level (amount) of load to cut as a percentage of total zone load.
 * @param cutLevel2           Second level (amount) of load to cut as a percentage of total zone load.
 * @param EnergyConsumers     [[ch.ninecode.model.EnergyConsumer EnergyConsumer]] Energy consumer is assigned to the power cut zone.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modelling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and day types, are also included here.
 *
 *            This information is used by Load Forecasting and Load Management.
 */
final case class PowerCutZone
(
    PowerSystemResource: PowerSystemResource = null,
    cutLevel1: Double = 0.0,
    cutLevel2: Double = 0.0,
    EnergyConsumers: List[String] = null
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
        implicit val clz: String = PowerCutZone.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PowerCutZone.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (PowerCutZone.fields (position), x))

        emitelem (0, cutLevel1)
        emitelem (1, cutLevel2)
        emitattrs (2, EnergyConsumers)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:PowerCutZone rdf:ID=\"%s\">\n%s\t</cim:PowerCutZone>".format (id, export_fields)
    }
}

object PowerCutZone
    extends
        CIMParseable[PowerCutZone]
{
    override val fields: Array[String] = Array [String](
        "cutLevel1",
        "cutLevel2",
        "EnergyConsumers"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("EnergyConsumers", "EnergyConsumer", "1..*", "0..1")
    )
    val cutLevel1: Fielder = parse_element (element (cls, fields (0)))
    val cutLevel2: Fielder = parse_element (element (cls, fields (1)))
    val EnergyConsumers: FielderMultiple = parse_attributes (attribute (cls, fields (2)))

    def parse (context: CIMContext): PowerCutZone =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = PowerCutZone (
            PowerSystemResource.parse (context),
            toDouble (mask (cutLevel1 (), 0)),
            toDouble (mask (cutLevel2 (), 1)),
            masks (EnergyConsumers (), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[PowerCutZone] = PowerCutZoneSerializer
}

object PowerCutZoneSerializer extends CIMSerializer[PowerCutZone]
{
    def write (kryo: Kryo, output: Output, obj: PowerCutZone): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.cutLevel1),
            () => output.writeDouble (obj.cutLevel2),
            () => writeList (obj.EnergyConsumers, output)
        )
        PowerSystemResourceSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PowerCutZone]): PowerCutZone =
    {
        val parent = PowerSystemResourceSerializer.read (kryo, input, classOf [PowerSystemResource])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PowerCutZone (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A specified time period of the year.
 *
 * @param IdentifiedObject       [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param endDate                Date season ends.
 * @param startDate              Date season starts.
 * @param ScheduledLimits        [[ch.ninecode.model.ScheduledLimitValue ScheduledLimitValue]] The scheduled limits associated with the season.
 * @param SeasonDayTypeSchedules [[ch.ninecode.model.SeasonDayTypeSchedule SeasonDayTypeSchedule]] Schedules that use this Season.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modelling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and day types, are also included here.
 *
 *            This information is used by Load Forecasting and Load Management.
 */
final case class Season
(
    IdentifiedObject: IdentifiedObject = null,
    endDate: String = null,
    startDate: String = null,
    ScheduledLimits: List[String] = null,
    SeasonDayTypeSchedules: List[String] = null
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
        implicit val clz: String = Season.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Season.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Season.fields (position), x))

        emitelem (0, endDate)
        emitelem (1, startDate)
        emitattrs (2, ScheduledLimits)
        emitattrs (3, SeasonDayTypeSchedules)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:Season rdf:ID=\"%s\">\n%s\t</cim:Season>".format (id, export_fields)
    }
}

object Season
    extends
        CIMParseable[Season]
{
    override val fields: Array[String] = Array [String](
        "endDate",
        "startDate",
        "ScheduledLimits",
        "SeasonDayTypeSchedules"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ScheduledLimits", "ScheduledLimitValue", "0..*", "0..1"),
        CIMRelationship ("SeasonDayTypeSchedules", "SeasonDayTypeSchedule", "0..*", "0..1")
    )
    val endDate: Fielder = parse_element (element (cls, fields (0)))
    val startDate: Fielder = parse_element (element (cls, fields (1)))
    val ScheduledLimits: FielderMultiple = parse_attributes (attribute (cls, fields (2)))
    val SeasonDayTypeSchedules: FielderMultiple = parse_attributes (attribute (cls, fields (3)))

    def parse (context: CIMContext): Season =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = Season (
            IdentifiedObject.parse (context),
            mask (endDate (), 0),
            mask (startDate (), 1),
            masks (ScheduledLimits (), 2),
            masks (SeasonDayTypeSchedules (), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[Season] = SeasonSerializer
}

object SeasonSerializer extends CIMSerializer[Season]
{
    def write (kryo: Kryo, output: Output, obj: Season): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.endDate),
            () => output.writeString (obj.startDate),
            () => writeList (obj.ScheduledLimits, output),
            () => writeList (obj.SeasonDayTypeSchedules, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Season]): Season =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf [IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Season (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A time schedule covering a 24 hour period, with curve data for a specific type of season and day.
 *
 * @param RegularIntervalSchedule [[ch.ninecode.model.RegularIntervalSchedule RegularIntervalSchedule]] Reference to the superclass object.
 * @param DayType                 [[ch.ninecode.model.DayType DayType]] DayType for the Schedule.
 * @param Season                  [[ch.ninecode.model.Season Season]] Season for the Schedule.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modelling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and day types, are also included here.
 *
 *            This information is used by Load Forecasting and Load Management.
 */
final case class SeasonDayTypeSchedule
(
    RegularIntervalSchedule: RegularIntervalSchedule = null,
    DayType: String = null,
    Season: String = null
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
    override def sup: RegularIntervalSchedule = RegularIntervalSchedule

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
        implicit val clz: String = SeasonDayTypeSchedule.cls

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
        CIMParseable[SeasonDayTypeSchedule]
{
    override val fields: Array[String] = Array [String](
        "DayType",
        "Season"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("DayType", "DayType", "0..1", "0..*"),
        CIMRelationship ("Season", "Season", "0..1", "0..*")
    )
    val DayType: Fielder = parse_attribute (attribute (cls, fields (0)))
    val Season: Fielder = parse_attribute (attribute (cls, fields (1)))

    def parse (context: CIMContext): SeasonDayTypeSchedule =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = SeasonDayTypeSchedule (
            RegularIntervalSchedule.parse (context),
            mask (DayType (), 0),
            mask (Season (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[SeasonDayTypeSchedule] = SeasonDayTypeScheduleSerializer
}

object SeasonDayTypeScheduleSerializer extends CIMSerializer[SeasonDayTypeSchedule]
{
    def write (kryo: Kryo, output: Output, obj: SeasonDayTypeSchedule): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.DayType),
            () => output.writeString (obj.Season)
        )
        RegularIntervalScheduleSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SeasonDayTypeSchedule]): SeasonDayTypeSchedule =
    {
        val parent = RegularIntervalScheduleSerializer.read (kryo, input, classOf [RegularIntervalSchedule])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SeasonDayTypeSchedule (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Station supply with load derived from the station output.
 *
 * @param EnergyConsumer [[ch.ninecode.model.EnergyConsumer EnergyConsumer]] Reference to the superclass object.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modelling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and day types, are also included here.
 *
 *            This information is used by Load Forecasting and Load Management.
 */
final case class StationSupply
(
    EnergyConsumer: EnergyConsumer = null
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
    override def sup: EnergyConsumer = EnergyConsumer

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
        sup.export_fields
    }

    override def export: String =
    {
        "\t<cim:StationSupply rdf:ID=\"%s\">\n%s\t</cim:StationSupply>".format (id, export_fields)
    }
}

object StationSupply
    extends
        CIMParseable[StationSupply]
{

    def parse (context: CIMContext): StationSupply =
    {
        val ret = StationSupply (
            EnergyConsumer.parse (context)
        )
        ret
    }

    def serializer: Serializer[StationSupply] = StationSupplySerializer
}

object StationSupplySerializer extends CIMSerializer[StationSupply]
{
    def write (kryo: Kryo, output: Output, obj: StationSupply): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        EnergyConsumerSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[StationSupply]): StationSupply =
    {
        val parent = EnergyConsumerSerializer.read (kryo, input, classOf [EnergyConsumer])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = StationSupply (
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The class is the second level in a hierarchical structure for grouping of loads for the purpose of load flow load scaling.
 *
 * @param EnergyArea [[ch.ninecode.model.EnergyArea EnergyArea]] Reference to the superclass object.
 * @param LoadArea   [[ch.ninecode.model.LoadArea LoadArea]] The LoadArea where the SubLoadArea belongs.
 * @param LoadGroups [[ch.ninecode.model.LoadGroup LoadGroup]] The Loadgroups in the SubLoadArea.
 * @group LoadModel
 * @groupname LoadModel Package LoadModel
 * @groupdesc LoadModel This package is responsible for modelling the energy consumers and the system load as curves and associated curve data. Special circumstances that may affect the load, such as seasons and day types, are also included here.
 *
 *            This information is used by Load Forecasting and Load Management.
 */
final case class SubLoadArea
(
    EnergyArea: EnergyArea = null,
    LoadArea: String = null,
    LoadGroups: List[String] = null
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
    override def sup: EnergyArea = EnergyArea

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
        implicit val clz: String = SubLoadArea.cls

        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SubLoadArea.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (SubLoadArea.fields (position), x))

        emitattr (0, LoadArea)
        emitattrs (1, LoadGroups)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:SubLoadArea rdf:ID=\"%s\">\n%s\t</cim:SubLoadArea>".format (id, export_fields)
    }
}

object SubLoadArea
    extends
        CIMParseable[SubLoadArea]
{
    override val fields: Array[String] = Array [String](
        "LoadArea",
        "LoadGroups"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("LoadArea", "LoadArea", "1", "1..*"),
        CIMRelationship ("LoadGroups", "LoadGroup", "1..*", "1")
    )
    val LoadArea: Fielder = parse_attribute (attribute (cls, fields (0)))
    val LoadGroups: FielderMultiple = parse_attributes (attribute (cls, fields (1)))

    def parse (context: CIMContext): SubLoadArea =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array (0)
        val ret = SubLoadArea (
            EnergyArea.parse (context),
            mask (LoadArea (), 0),
            masks (LoadGroups (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[SubLoadArea] = SubLoadAreaSerializer
}

object SubLoadAreaSerializer extends CIMSerializer[SubLoadArea]
{
    def write (kryo: Kryo, output: Output, obj: SubLoadArea): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.LoadArea),
            () => writeList (obj.LoadGroups, output)
        )
        EnergyAreaSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SubLoadArea]): SubLoadArea =
    {
        val parent = EnergyAreaSerializer.read (kryo, input, classOf [EnergyArea])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SubLoadArea (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _LoadModel
{
    def register: List[CIMClassInfo] =
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
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
 * Busbar section data.
 *
 * @param AssetInfo    [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param ratedCurrent Rated current.
 * @param ratedVoltage Rated voltage.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
final case class BusbarSectionInfo
(
    AssetInfo: AssetInfo = null,
    ratedCurrent: Double = 0.0,
    ratedVoltage: Double = 0.0
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
    override def sup: AssetInfo = AssetInfo

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
        implicit val clz: String = BusbarSectionInfo.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(BusbarSectionInfo.fields(position), value)

        emitelem(0, ratedCurrent)
        emitelem(1, ratedVoltage)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:BusbarSectionInfo rdf:%s=\"%s\">\n%s\t</cim:BusbarSectionInfo>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object BusbarSectionInfo
    extends
        CIMParseable[BusbarSectionInfo]
{
    override val fields: Array[String] = Array[String](
        "ratedCurrent",
        "ratedVoltage"
    )
    val ratedCurrent: Fielder = parse_element(element(cls, fields(0)))
    val ratedVoltage: Fielder = parse_element(element(cls, fields(1)))

    def parse (context: CIMContext): BusbarSectionInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = BusbarSectionInfo(
            AssetInfo.parse(context),
            toDouble(mask(ratedCurrent(), 0)),
            toDouble(mask(ratedVoltage(), 1))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[BusbarSectionInfo] = BusbarSectionInfoSerializer
}

object BusbarSectionInfoSerializer extends CIMSerializer[BusbarSectionInfo]
{
    def write (kryo: Kryo, output: Output, obj: BusbarSectionInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.ratedCurrent),
            () => output.writeDouble(obj.ratedVoltage)
        )
        AssetInfoSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[BusbarSectionInfo]): BusbarSectionInfo =
    {
        val parent = AssetInfoSerializer.read(kryo, input, classOf[AssetInfo])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = BusbarSectionInfo(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Bushing datasheet information.
 *
 * @param AssetInfo                    [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param c1Capacitance                Factory measured capacitance, measured between the power factor tap and the bushing conductor.
 * @param c1PowerFactor                Factory measured insulation power factor, measured between the power factor tap and the bushing conductor.
 * @param c2Capacitance                Factory measured capacitance measured between the power factor tap and ground.
 * @param c2PowerFactor                Factory measured insulation power factor, measured between the power factor tap and ground.
 * @param insulationKind               Kind of insulation.
 * @param ratedCurrent                 Rated current for bushing as installed.
 * @param ratedImpulseWithstandVoltage Rated impulse withstand voltage, also known as BIL (Basic Impulse Level).
 * @param ratedLineToGroundVoltage     Rated line-to-ground voltage.
 *                                     Also referred to as Uy on bushing nameplate.
 * @param ratedVoltage                 Rated voltage.
 *                                     Can be referred to as Um, system voltage or class on bushing nameplate.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
final case class BushingInfo
(
    AssetInfo: AssetInfo = null,
    c1Capacitance: Double = 0.0,
    c1PowerFactor: Double = 0.0,
    c2Capacitance: Double = 0.0,
    c2PowerFactor: Double = 0.0,
    insulationKind: String = null,
    ratedCurrent: Double = 0.0,
    ratedImpulseWithstandVoltage: Double = 0.0,
    ratedLineToGroundVoltage: Double = 0.0,
    ratedVoltage: Double = 0.0
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
    override def sup: AssetInfo = AssetInfo

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
        implicit val clz: String = BushingInfo.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(BushingInfo.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(BushingInfo.fields(position), value)

        emitelem(0, c1Capacitance)
        emitelem(1, c1PowerFactor)
        emitelem(2, c2Capacitance)
        emitelem(3, c2PowerFactor)
        emitattr(4, insulationKind)
        emitelem(5, ratedCurrent)
        emitelem(6, ratedImpulseWithstandVoltage)
        emitelem(7, ratedLineToGroundVoltage)
        emitelem(8, ratedVoltage)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:BushingInfo rdf:%s=\"%s\">\n%s\t</cim:BushingInfo>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object BushingInfo
    extends
        CIMParseable[BushingInfo]
{
    override val fields: Array[String] = Array[String](
        "c1Capacitance",
        "c1PowerFactor",
        "c2Capacitance",
        "c2PowerFactor",
        "insulationKind",
        "ratedCurrent",
        "ratedImpulseWithstandVoltage",
        "ratedLineToGroundVoltage",
        "ratedVoltage"
    )
    val c1Capacitance: Fielder = parse_element(element(cls, fields(0)))
    val c1PowerFactor: Fielder = parse_element(element(cls, fields(1)))
    val c2Capacitance: Fielder = parse_element(element(cls, fields(2)))
    val c2PowerFactor: Fielder = parse_element(element(cls, fields(3)))
    val insulationKind: Fielder = parse_attribute(attribute(cls, fields(4)))
    val ratedCurrent: Fielder = parse_element(element(cls, fields(5)))
    val ratedImpulseWithstandVoltage: Fielder = parse_element(element(cls, fields(6)))
    val ratedLineToGroundVoltage: Fielder = parse_element(element(cls, fields(7)))
    val ratedVoltage: Fielder = parse_element(element(cls, fields(8)))

    def parse (context: CIMContext): BushingInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = BushingInfo(
            AssetInfo.parse(context),
            toDouble(mask(c1Capacitance(), 0)),
            toDouble(mask(c1PowerFactor(), 1)),
            toDouble(mask(c2Capacitance(), 2)),
            toDouble(mask(c2PowerFactor(), 3)),
            mask(insulationKind(), 4),
            toDouble(mask(ratedCurrent(), 5)),
            toDouble(mask(ratedImpulseWithstandVoltage(), 6)),
            toDouble(mask(ratedLineToGroundVoltage(), 7)),
            toDouble(mask(ratedVoltage(), 8))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[BushingInfo] = BushingInfoSerializer
}

object BushingInfoSerializer extends CIMSerializer[BushingInfo]
{
    def write (kryo: Kryo, output: Output, obj: BushingInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.c1Capacitance),
            () => output.writeDouble(obj.c1PowerFactor),
            () => output.writeDouble(obj.c2Capacitance),
            () => output.writeDouble(obj.c2PowerFactor),
            () => output.writeString(obj.insulationKind),
            () => output.writeDouble(obj.ratedCurrent),
            () => output.writeDouble(obj.ratedImpulseWithstandVoltage),
            () => output.writeDouble(obj.ratedLineToGroundVoltage),
            () => output.writeDouble(obj.ratedVoltage)
        )
        AssetInfoSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[BushingInfo]): BushingInfo =
    {
        val parent = AssetInfoSerializer.read(kryo, input, classOf[AssetInfo])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = BushingInfo(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readDouble else 0.0,
            if (isSet(4)) input.readString else null,
            if (isSet(5)) input.readDouble else 0.0,
            if (isSet(6)) input.readDouble else 0.0,
            if (isSet(7)) input.readDouble else 0.0,
            if (isSet(8)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Cable data.
 *
 * @param WireInfo               [[ch.ninecode.model.WireInfo WireInfo]] Reference to the superclass object.
 * @param constructionKind       Kind of construction of this cable.
 * @param diameterOverCore       Diameter over the core, including any semi-con screen; should be the insulating layer's inside diameter.
 * @param diameterOverInsulation Diameter over the insulating layer, excluding outer screen.
 * @param diameterOverJacket     Diameter over the outermost jacketing layer.
 * @param diameterOverScreen     Diameter over the outer screen; should be the shield's inside diameter.
 * @param isStrandFill           True if wire strands are extruded in a way to fill the voids in the cable.
 * @param nominalTemperature     Maximum nominal design operating temperature.
 * @param outerJacketKind        Kind of outer jacket of this cable.
 * @param sheathAsNeutral        True if sheath / shield is used as a neutral (i.e., bonded).
 * @param shieldMaterial         Material of the shield.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
final case class CableInfo
(
    WireInfo: WireInfo = null,
    constructionKind: String = null,
    diameterOverCore: Double = 0.0,
    diameterOverInsulation: Double = 0.0,
    diameterOverJacket: Double = 0.0,
    diameterOverScreen: Double = 0.0,
    isStrandFill: Boolean = false,
    nominalTemperature: Double = 0.0,
    outerJacketKind: String = null,
    sheathAsNeutral: Boolean = false,
    shieldMaterial: String = null
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
    override def sup: WireInfo = WireInfo

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
        implicit val clz: String = CableInfo.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(CableInfo.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(CableInfo.fields(position), value)

        emitattr(0, constructionKind)
        emitelem(1, diameterOverCore)
        emitelem(2, diameterOverInsulation)
        emitelem(3, diameterOverJacket)
        emitelem(4, diameterOverScreen)
        emitelem(5, isStrandFill)
        emitelem(6, nominalTemperature)
        emitattr(7, outerJacketKind)
        emitelem(8, sheathAsNeutral)
        emitattr(9, shieldMaterial)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:CableInfo rdf:%s=\"%s\">\n%s\t</cim:CableInfo>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object CableInfo
    extends
        CIMParseable[CableInfo]
{
    override val fields: Array[String] = Array[String](
        "constructionKind",
        "diameterOverCore",
        "diameterOverInsulation",
        "diameterOverJacket",
        "diameterOverScreen",
        "isStrandFill",
        "nominalTemperature",
        "outerJacketKind",
        "sheathAsNeutral",
        "shieldMaterial"
    )
    val constructionKind: Fielder = parse_attribute(attribute(cls, fields(0)))
    val diameterOverCore: Fielder = parse_element(element(cls, fields(1)))
    val diameterOverInsulation: Fielder = parse_element(element(cls, fields(2)))
    val diameterOverJacket: Fielder = parse_element(element(cls, fields(3)))
    val diameterOverScreen: Fielder = parse_element(element(cls, fields(4)))
    val isStrandFill: Fielder = parse_element(element(cls, fields(5)))
    val nominalTemperature: Fielder = parse_element(element(cls, fields(6)))
    val outerJacketKind: Fielder = parse_attribute(attribute(cls, fields(7)))
    val sheathAsNeutral: Fielder = parse_element(element(cls, fields(8)))
    val shieldMaterial: Fielder = parse_attribute(attribute(cls, fields(9)))

    def parse (context: CIMContext): CableInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CableInfo(
            WireInfo.parse(context),
            mask(constructionKind(), 0),
            toDouble(mask(diameterOverCore(), 1)),
            toDouble(mask(diameterOverInsulation(), 2)),
            toDouble(mask(diameterOverJacket(), 3)),
            toDouble(mask(diameterOverScreen(), 4)),
            toBoolean(mask(isStrandFill(), 5)),
            toDouble(mask(nominalTemperature(), 6)),
            mask(outerJacketKind(), 7),
            toBoolean(mask(sheathAsNeutral(), 8)),
            mask(shieldMaterial(), 9)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CableInfo] = CableInfoSerializer
}

object CableInfoSerializer extends CIMSerializer[CableInfo]
{
    def write (kryo: Kryo, output: Output, obj: CableInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.constructionKind),
            () => output.writeDouble(obj.diameterOverCore),
            () => output.writeDouble(obj.diameterOverInsulation),
            () => output.writeDouble(obj.diameterOverJacket),
            () => output.writeDouble(obj.diameterOverScreen),
            () => output.writeBoolean(obj.isStrandFill),
            () => output.writeDouble(obj.nominalTemperature),
            () => output.writeString(obj.outerJacketKind),
            () => output.writeBoolean(obj.sheathAsNeutral),
            () => output.writeString(obj.shieldMaterial)
        )
        WireInfoSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CableInfo]): CableInfo =
    {
        val parent = WireInfoSerializer.read(kryo, input, classOf[WireInfo])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = CableInfo(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readDouble else 0.0,
            if (isSet(4)) input.readDouble else 0.0,
            if (isSet(5)) input.readBoolean else false,
            if (isSet(6)) input.readDouble else 0.0,
            if (isSet(7)) input.readString else null,
            if (isSet(8)) input.readBoolean else false,
            if (isSet(9)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Concentric neutral cable data.
 *
 * @param CableInfo           [[ch.ninecode.model.CableInfo CableInfo]] Reference to the superclass object.
 * @param diameterOverNeutral Diameter over the concentric neutral strands.
 * @param neutralStrandCount  Number of concentric neutral strands.
 * @param neutralStrandGmr    Geometric mean radius of the neutral strand.
 * @param neutralStrandRDC20  DC resistance per unit length of the neutral strand at 20 °C.
 * @param neutralStrandRadius Outside radius of the neutral strand.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
final case class ConcentricNeutralCableInfo
(
    CableInfo: CableInfo = null,
    diameterOverNeutral: Double = 0.0,
    neutralStrandCount: Int = 0,
    neutralStrandGmr: Double = 0.0,
    neutralStrandRDC20: Double = 0.0,
    neutralStrandRadius: Double = 0.0
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
    override def sup: CableInfo = CableInfo

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
        implicit val clz: String = ConcentricNeutralCableInfo.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(ConcentricNeutralCableInfo.fields(position), value)

        emitelem(0, diameterOverNeutral)
        emitelem(1, neutralStrandCount)
        emitelem(2, neutralStrandGmr)
        emitelem(3, neutralStrandRDC20)
        emitelem(4, neutralStrandRadius)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ConcentricNeutralCableInfo rdf:%s=\"%s\">\n%s\t</cim:ConcentricNeutralCableInfo>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ConcentricNeutralCableInfo
    extends
        CIMParseable[ConcentricNeutralCableInfo]
{
    override val fields: Array[String] = Array[String](
        "diameterOverNeutral",
        "neutralStrandCount",
        "neutralStrandGmr",
        "neutralStrandRDC20",
        "neutralStrandRadius"
    )
    val diameterOverNeutral: Fielder = parse_element(element(cls, fields(0)))
    val neutralStrandCount: Fielder = parse_element(element(cls, fields(1)))
    val neutralStrandGmr: Fielder = parse_element(element(cls, fields(2)))
    val neutralStrandRDC20: Fielder = parse_element(element(cls, fields(3)))
    val neutralStrandRadius: Fielder = parse_element(element(cls, fields(4)))

    def parse (context: CIMContext): ConcentricNeutralCableInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ConcentricNeutralCableInfo(
            CableInfo.parse(context),
            toDouble(mask(diameterOverNeutral(), 0)),
            toInteger(mask(neutralStrandCount(), 1)),
            toDouble(mask(neutralStrandGmr(), 2)),
            toDouble(mask(neutralStrandRDC20(), 3)),
            toDouble(mask(neutralStrandRadius(), 4))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ConcentricNeutralCableInfo] = ConcentricNeutralCableInfoSerializer
}

object ConcentricNeutralCableInfoSerializer extends CIMSerializer[ConcentricNeutralCableInfo]
{
    def write (kryo: Kryo, output: Output, obj: ConcentricNeutralCableInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.diameterOverNeutral),
            () => output.writeInt(obj.neutralStrandCount),
            () => output.writeDouble(obj.neutralStrandGmr),
            () => output.writeDouble(obj.neutralStrandRDC20),
            () => output.writeDouble(obj.neutralStrandRadius)
        )
        CableInfoSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ConcentricNeutralCableInfo]): ConcentricNeutralCableInfo =
    {
        val parent = CableInfoSerializer.read(kryo, input, classOf[CableInfo])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ConcentricNeutralCableInfo(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readInt else 0,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readDouble else 0.0,
            if (isSet(4)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Interrupter datasheet information.
 *
 * @param AssetInfo          [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param interruptingMedium Interrupting medium.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
final case class InterrupterUnitInfo
(
    AssetInfo: AssetInfo = null,
    interruptingMedium: String = null
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
    override def sup: AssetInfo = AssetInfo

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
        implicit val clz: String = InterrupterUnitInfo.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(InterrupterUnitInfo.fields(position), value)

        emitattr(0, interruptingMedium)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:InterrupterUnitInfo rdf:%s=\"%s\">\n%s\t</cim:InterrupterUnitInfo>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object InterrupterUnitInfo
    extends
        CIMParseable[InterrupterUnitInfo]
{
    override val fields: Array[String] = Array[String](
        "interruptingMedium"
    )
    val interruptingMedium: Fielder = parse_attribute(attribute(cls, fields(0)))

    def parse (context: CIMContext): InterrupterUnitInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = InterrupterUnitInfo(
            AssetInfo.parse(context),
            mask(interruptingMedium(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[InterrupterUnitInfo] = InterrupterUnitInfoSerializer
}

object InterrupterUnitInfoSerializer extends CIMSerializer[InterrupterUnitInfo]
{
    def write (kryo: Kryo, output: Output, obj: InterrupterUnitInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.interruptingMedium)
        )
        AssetInfoSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[InterrupterUnitInfo]): InterrupterUnitInfo =
    {
        val parent = AssetInfoSerializer.read(kryo, input, classOf[AssetInfo])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = InterrupterUnitInfo(
            parent,
            if (isSet(0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * No-load test results determine core admittance parameters.
 *
 * They include exciting current and core loss measurements from applying voltage to one winding. The excitation may be positive sequence or zero sequence. The test may be repeated at different voltages to measure saturation.
 *
 * @param TransformerTest     [[ch.ninecode.model.TransformerTest TransformerTest]] Reference to the superclass object.
 * @param energisedEndVoltage Voltage applied to the winding (end) during test.
 * @param excitingCurrent     Exciting current measured from a positive-sequence or single-phase excitation test.
 * @param excitingCurrentZero Exciting current measured from a zero-sequence open-circuit excitation test.
 * @param loss                Losses measured from a positive-sequence or single-phase excitation test.
 * @param lossZero            Losses measured from a zero-sequence excitation test.
 * @param EnergisedEnd        [[ch.ninecode.model.TransformerEndInfo TransformerEndInfo]] Transformer end that current is applied to in this no-load test.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
final case class NoLoadTest
(
    TransformerTest: TransformerTest = null,
    energisedEndVoltage: Double = 0.0,
    excitingCurrent: Double = 0.0,
    excitingCurrentZero: Double = 0.0,
    loss: Double = 0.0,
    lossZero: Double = 0.0,
    EnergisedEnd: String = null
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
    override def sup: TransformerTest = TransformerTest

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
        implicit val clz: String = NoLoadTest.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(NoLoadTest.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(NoLoadTest.fields(position), value)

        emitelem(0, energisedEndVoltage)
        emitelem(1, excitingCurrent)
        emitelem(2, excitingCurrentZero)
        emitelem(3, loss)
        emitelem(4, lossZero)
        emitattr(5, EnergisedEnd)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:NoLoadTest rdf:%s=\"%s\">\n%s\t</cim:NoLoadTest>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object NoLoadTest
    extends
        CIMParseable[NoLoadTest]
{
    override val fields: Array[String] = Array[String](
        "energisedEndVoltage",
        "excitingCurrent",
        "excitingCurrentZero",
        "loss",
        "lossZero",
        "EnergisedEnd"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("EnergisedEnd", "TransformerEndInfo", "0..1", "0..*")
    )
    val energisedEndVoltage: Fielder = parse_element(element(cls, fields(0)))
    val excitingCurrent: Fielder = parse_element(element(cls, fields(1)))
    val excitingCurrentZero: Fielder = parse_element(element(cls, fields(2)))
    val loss: Fielder = parse_element(element(cls, fields(3)))
    val lossZero: Fielder = parse_element(element(cls, fields(4)))
    val EnergisedEnd: Fielder = parse_attribute(attribute(cls, fields(5)))

    def parse (context: CIMContext): NoLoadTest =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = NoLoadTest(
            TransformerTest.parse(context),
            toDouble(mask(energisedEndVoltage(), 0)),
            toDouble(mask(excitingCurrent(), 1)),
            toDouble(mask(excitingCurrentZero(), 2)),
            toDouble(mask(loss(), 3)),
            toDouble(mask(lossZero(), 4)),
            mask(EnergisedEnd(), 5)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[NoLoadTest] = NoLoadTestSerializer
}

object NoLoadTestSerializer extends CIMSerializer[NoLoadTest]
{
    def write (kryo: Kryo, output: Output, obj: NoLoadTest): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.energisedEndVoltage),
            () => output.writeDouble(obj.excitingCurrent),
            () => output.writeDouble(obj.excitingCurrentZero),
            () => output.writeDouble(obj.loss),
            () => output.writeDouble(obj.lossZero),
            () => output.writeString(obj.EnergisedEnd)
        )
        TransformerTestSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[NoLoadTest]): NoLoadTest =
    {
        val parent = TransformerTestSerializer.read(kryo, input, classOf[TransformerTest])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = NoLoadTest(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readDouble else 0.0,
            if (isSet(4)) input.readDouble else 0.0,
            if (isSet(5)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Open-circuit test results verify winding turn ratios and phase shifts.
 *
 * They include induced voltage and phase shift measurements on open-circuit windings, with voltage applied to the energised end. For three-phase windings, the excitation can be a positive sequence (the default) or a zero sequence.
 *
 * @param TransformerTest     [[ch.ninecode.model.TransformerTest TransformerTest]] Reference to the superclass object.
 * @param energisedEndStep    Tap step number for the energised end of the test pair.
 * @param energisedEndVoltage Voltage applied to the winding (end) during test.
 * @param openEndStep         Tap step number for the open end of the test pair.
 * @param openEndVoltage      Voltage measured at the open-circuited end, with the energised end set to rated voltage and all other ends open.
 * @param phaseShift          Phase shift measured at the open end with the energised end set to rated voltage and all other ends open.
 * @param EnergisedEnd        [[ch.ninecode.model.TransformerEndInfo TransformerEndInfo]] Transformer end that current is applied to in this open-circuit test.
 * @param OpenEnd             [[ch.ninecode.model.TransformerEndInfo TransformerEndInfo]] Transformer end measured for induced voltage and angle in this open-circuit test.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
final case class OpenCircuitTest
(
    TransformerTest: TransformerTest = null,
    energisedEndStep: Int = 0,
    energisedEndVoltage: Double = 0.0,
    openEndStep: Int = 0,
    openEndVoltage: Double = 0.0,
    phaseShift: Double = 0.0,
    EnergisedEnd: String = null,
    OpenEnd: String = null
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
    override def sup: TransformerTest = TransformerTest

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
        implicit val clz: String = OpenCircuitTest.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(OpenCircuitTest.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(OpenCircuitTest.fields(position), value)

        emitelem(0, energisedEndStep)
        emitelem(1, energisedEndVoltage)
        emitelem(2, openEndStep)
        emitelem(3, openEndVoltage)
        emitelem(4, phaseShift)
        emitattr(5, EnergisedEnd)
        emitattr(6, OpenEnd)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:OpenCircuitTest rdf:%s=\"%s\">\n%s\t</cim:OpenCircuitTest>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object OpenCircuitTest
    extends
        CIMParseable[OpenCircuitTest]
{
    override val fields: Array[String] = Array[String](
        "energisedEndStep",
        "energisedEndVoltage",
        "openEndStep",
        "openEndVoltage",
        "phaseShift",
        "EnergisedEnd",
        "OpenEnd"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("EnergisedEnd", "TransformerEndInfo", "1", "0..*"),
        CIMRelationship("OpenEnd", "TransformerEndInfo", "1", "0..*")
    )
    val energisedEndStep: Fielder = parse_element(element(cls, fields(0)))
    val energisedEndVoltage: Fielder = parse_element(element(cls, fields(1)))
    val openEndStep: Fielder = parse_element(element(cls, fields(2)))
    val openEndVoltage: Fielder = parse_element(element(cls, fields(3)))
    val phaseShift: Fielder = parse_element(element(cls, fields(4)))
    val EnergisedEnd: Fielder = parse_attribute(attribute(cls, fields(5)))
    val OpenEnd: Fielder = parse_attribute(attribute(cls, fields(6)))

    def parse (context: CIMContext): OpenCircuitTest =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OpenCircuitTest(
            TransformerTest.parse(context),
            toInteger(mask(energisedEndStep(), 0)),
            toDouble(mask(energisedEndVoltage(), 1)),
            toInteger(mask(openEndStep(), 2)),
            toDouble(mask(openEndVoltage(), 3)),
            toDouble(mask(phaseShift(), 4)),
            mask(EnergisedEnd(), 5),
            mask(OpenEnd(), 6)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OpenCircuitTest] = OpenCircuitTestSerializer
}

object OpenCircuitTestSerializer extends CIMSerializer[OpenCircuitTest]
{
    def write (kryo: Kryo, output: Output, obj: OpenCircuitTest): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeInt(obj.energisedEndStep),
            () => output.writeDouble(obj.energisedEndVoltage),
            () => output.writeInt(obj.openEndStep),
            () => output.writeDouble(obj.openEndVoltage),
            () => output.writeDouble(obj.phaseShift),
            () => output.writeString(obj.EnergisedEnd),
            () => output.writeString(obj.OpenEnd)
        )
        TransformerTestSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OpenCircuitTest]): OpenCircuitTest =
    {
        val parent = TransformerTestSerializer.read(kryo, input, classOf[TransformerTest])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = OpenCircuitTest(
            parent,
            if (isSet(0)) input.readInt else 0,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readInt else 0,
            if (isSet(3)) input.readDouble else 0.0,
            if (isSet(4)) input.readDouble else 0.0,
            if (isSet(5)) input.readString else null,
            if (isSet(6)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Breaker operating mechanism datasheet information.
 *
 * @param AssetInfo         [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param closeAmps         Close current (nominal).
 * @param closeVoltage      Close voltage in volts DC.
 * @param mechanismKind     Kind of breaker operating mechanism.
 * @param motorRunCurrent   Rated motor run current in amps.
 * @param motorStartCurrent Rated motor start current in amps.
 * @param motorVoltage      Nominal motor voltage in volts DC.
 * @param tripAmps          Trip current (nominal).
 * @param tripVoltage       Trip voltage in volts DC.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
final case class OperatingMechanismInfo
(
    AssetInfo: AssetInfo = null,
    closeAmps: Double = 0.0,
    closeVoltage: Double = 0.0,
    mechanismKind: String = null,
    motorRunCurrent: Double = 0.0,
    motorStartCurrent: Double = 0.0,
    motorVoltage: Double = 0.0,
    tripAmps: Double = 0.0,
    tripVoltage: Double = 0.0
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
    override def sup: AssetInfo = AssetInfo

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
        implicit val clz: String = OperatingMechanismInfo.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(OperatingMechanismInfo.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(OperatingMechanismInfo.fields(position), value)

        emitelem(0, closeAmps)
        emitelem(1, closeVoltage)
        emitattr(2, mechanismKind)
        emitelem(3, motorRunCurrent)
        emitelem(4, motorStartCurrent)
        emitelem(5, motorVoltage)
        emitelem(6, tripAmps)
        emitelem(7, tripVoltage)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:OperatingMechanismInfo rdf:%s=\"%s\">\n%s\t</cim:OperatingMechanismInfo>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object OperatingMechanismInfo
    extends
        CIMParseable[OperatingMechanismInfo]
{
    override val fields: Array[String] = Array[String](
        "closeAmps",
        "closeVoltage",
        "mechanismKind",
        "motorRunCurrent",
        "motorStartCurrent",
        "motorVoltage",
        "tripAmps",
        "tripVoltage"
    )
    val closeAmps: Fielder = parse_element(element(cls, fields(0)))
    val closeVoltage: Fielder = parse_element(element(cls, fields(1)))
    val mechanismKind: Fielder = parse_attribute(attribute(cls, fields(2)))
    val motorRunCurrent: Fielder = parse_element(element(cls, fields(3)))
    val motorStartCurrent: Fielder = parse_element(element(cls, fields(4)))
    val motorVoltage: Fielder = parse_element(element(cls, fields(5)))
    val tripAmps: Fielder = parse_element(element(cls, fields(6)))
    val tripVoltage: Fielder = parse_element(element(cls, fields(7)))

    def parse (context: CIMContext): OperatingMechanismInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OperatingMechanismInfo(
            AssetInfo.parse(context),
            toDouble(mask(closeAmps(), 0)),
            toDouble(mask(closeVoltage(), 1)),
            mask(mechanismKind(), 2),
            toDouble(mask(motorRunCurrent(), 3)),
            toDouble(mask(motorStartCurrent(), 4)),
            toDouble(mask(motorVoltage(), 5)),
            toDouble(mask(tripAmps(), 6)),
            toDouble(mask(tripVoltage(), 7))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[OperatingMechanismInfo] = OperatingMechanismInfoSerializer
}

object OperatingMechanismInfoSerializer extends CIMSerializer[OperatingMechanismInfo]
{
    def write (kryo: Kryo, output: Output, obj: OperatingMechanismInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.closeAmps),
            () => output.writeDouble(obj.closeVoltage),
            () => output.writeString(obj.mechanismKind),
            () => output.writeDouble(obj.motorRunCurrent),
            () => output.writeDouble(obj.motorStartCurrent),
            () => output.writeDouble(obj.motorVoltage),
            () => output.writeDouble(obj.tripAmps),
            () => output.writeDouble(obj.tripVoltage)
        )
        AssetInfoSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OperatingMechanismInfo]): OperatingMechanismInfo =
    {
        val parent = AssetInfoSerializer.read(kryo, input, classOf[AssetInfo])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = OperatingMechanismInfo(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readString else null,
            if (isSet(3)) input.readDouble else 0.0,
            if (isSet(4)) input.readDouble else 0.0,
            if (isSet(5)) input.readDouble else 0.0,
            if (isSet(6)) input.readDouble else 0.0,
            if (isSet(7)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Overhead wire data.
 *
 * @param WireInfo [[ch.ninecode.model.WireInfo WireInfo]] Reference to the superclass object.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
final case class OverheadWireInfo
(
    WireInfo: WireInfo = null
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
    override def sup: WireInfo = WireInfo

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
        sup.export_fields
    }

    override def export: String =
    {
        "\t<cim:OverheadWireInfo rdf:%s=\"%s\">\n%s\t</cim:OverheadWireInfo>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object OverheadWireInfo
    extends
        CIMParseable[OverheadWireInfo]
{

    def parse (context: CIMContext): OverheadWireInfo =
    {
        val ret = OverheadWireInfo(
            WireInfo.parse(context)
        )
        ret
    }

    def serializer: Serializer[OverheadWireInfo] = OverheadWireInfoSerializer
}

object OverheadWireInfoSerializer extends CIMSerializer[OverheadWireInfo]
{
    def write (kryo: Kryo, output: Output, obj: OverheadWireInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(

        )
        WireInfoSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OverheadWireInfo]): OverheadWireInfo =
    {
        val parent = WireInfoSerializer.read(kryo, input, classOf[WireInfo])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = OverheadWireInfo(
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Set of power transformer data, from an equipment library.
 *
 * @param AssetInfo            [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param TransformerTankInfos [[ch.ninecode.model.TransformerTankInfo TransformerTankInfo]] Data for all the tanks described by this power transformer data.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
final case class PowerTransformerInfo
(
    AssetInfo: AssetInfo = null,
    TransformerTankInfos: List[String] = null
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
    override def sup: AssetInfo = AssetInfo

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
        implicit val clz: String = PowerTransformerInfo.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(PowerTransformerInfo.fields(position), x))

        emitattrs(0, TransformerTankInfos)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:PowerTransformerInfo rdf:%s=\"%s\">\n%s\t</cim:PowerTransformerInfo>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object PowerTransformerInfo
    extends
        CIMParseable[PowerTransformerInfo]
{
    override val fields: Array[String] = Array[String](
        "TransformerTankInfos"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("TransformerTankInfos", "TransformerTankInfo", "1..*", "1")
    )
    val TransformerTankInfos: FielderMultiple = parse_attributes(attribute(cls, fields(0)))

    def parse (context: CIMContext): PowerTransformerInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PowerTransformerInfo(
            AssetInfo.parse(context),
            masks(TransformerTankInfos(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[PowerTransformerInfo] = PowerTransformerInfoSerializer
}

object PowerTransformerInfoSerializer extends CIMSerializer[PowerTransformerInfo]
{
    def write (kryo: Kryo, output: Output, obj: PowerTransformerInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => writeList(obj.TransformerTankInfos, output)
        )
        AssetInfoSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PowerTransformerInfo]): PowerTransformerInfo =
    {
        val parent = AssetInfoSerializer.read(kryo, input, classOf[AssetInfo])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = PowerTransformerInfo(
            parent,
            if (isSet(0)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Short-circuit test results determine mesh impedance parameters.
 *
 * They include load losses and leakage impedances. For three-phase windings, the excitation can be a positive sequence (the default) or a zero sequence. There shall be at least one grounded winding.
 *
 * @param TransformerTest      [[ch.ninecode.model.TransformerTest TransformerTest]] Reference to the superclass object.
 * @param current              Short circuit current..
 * @param energisedEndStep     Tap step number for the energised end of the test pair.
 * @param groundedEndStep      Tap step number for the grounded end of the test pair.
 * @param leakageImpedance     Leakage impedance measured from a positive-sequence or single-phase short-circuit test.
 * @param leakageImpedanceZero Leakage impedance measured from a zero-sequence short-circuit test.
 * @param loss                 Load losses from a positive-sequence or single-phase short-circuit test.
 * @param lossZero             Load losses from a zero-sequence short-circuit test.
 * @param power                Short circuit apparent power.
 * @param voltage              Short circuit voltage..
 * @param EnergisedEnd         [[ch.ninecode.model.TransformerEndInfo TransformerEndInfo]] Transformer end that voltage is applied to in this short-circuit test.
 *                             The test voltage is chosen to induce rated current in the energised end.
 * @param GroundedEnds         [[ch.ninecode.model.TransformerEndInfo TransformerEndInfo]] All ends short-circuited in this short-circuit test.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
final case class ShortCircuitTest
(
    TransformerTest: TransformerTest = null,
    current: Double = 0.0,
    energisedEndStep: Int = 0,
    groundedEndStep: Int = 0,
    leakageImpedance: Double = 0.0,
    leakageImpedanceZero: Double = 0.0,
    loss: Double = 0.0,
    lossZero: Double = 0.0,
    power: Double = 0.0,
    voltage: Double = 0.0,
    EnergisedEnd: String = null,
    GroundedEnds: List[String] = null
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
    override def sup: TransformerTest = TransformerTest

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
        implicit val clz: String = ShortCircuitTest.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(ShortCircuitTest.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(ShortCircuitTest.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(ShortCircuitTest.fields(position), x))

        emitelem(0, current)
        emitelem(1, energisedEndStep)
        emitelem(2, groundedEndStep)
        emitelem(3, leakageImpedance)
        emitelem(4, leakageImpedanceZero)
        emitelem(5, loss)
        emitelem(6, lossZero)
        emitelem(7, power)
        emitelem(8, voltage)
        emitattr(9, EnergisedEnd)
        emitattrs(10, GroundedEnds)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ShortCircuitTest rdf:%s=\"%s\">\n%s\t</cim:ShortCircuitTest>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ShortCircuitTest
    extends
        CIMParseable[ShortCircuitTest]
{
    override val fields: Array[String] = Array[String](
        "current",
        "energisedEndStep",
        "groundedEndStep",
        "leakageImpedance",
        "leakageImpedanceZero",
        "loss",
        "lossZero",
        "power",
        "voltage",
        "EnergisedEnd",
        "GroundedEnds"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("EnergisedEnd", "TransformerEndInfo", "1", "0..*"),
        CIMRelationship("GroundedEnds", "TransformerEndInfo", "1..*", "0..*")
    )
    val current: Fielder = parse_element(element(cls, fields(0)))
    val energisedEndStep: Fielder = parse_element(element(cls, fields(1)))
    val groundedEndStep: Fielder = parse_element(element(cls, fields(2)))
    val leakageImpedance: Fielder = parse_element(element(cls, fields(3)))
    val leakageImpedanceZero: Fielder = parse_element(element(cls, fields(4)))
    val loss: Fielder = parse_element(element(cls, fields(5)))
    val lossZero: Fielder = parse_element(element(cls, fields(6)))
    val power: Fielder = parse_element(element(cls, fields(7)))
    val voltage: Fielder = parse_element(element(cls, fields(8)))
    val EnergisedEnd: Fielder = parse_attribute(attribute(cls, fields(9)))
    val GroundedEnds: FielderMultiple = parse_attributes(attribute(cls, fields(10)))

    def parse (context: CIMContext): ShortCircuitTest =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ShortCircuitTest(
            TransformerTest.parse(context),
            toDouble(mask(current(), 0)),
            toInteger(mask(energisedEndStep(), 1)),
            toInteger(mask(groundedEndStep(), 2)),
            toDouble(mask(leakageImpedance(), 3)),
            toDouble(mask(leakageImpedanceZero(), 4)),
            toDouble(mask(loss(), 5)),
            toDouble(mask(lossZero(), 6)),
            toDouble(mask(power(), 7)),
            toDouble(mask(voltage(), 8)),
            mask(EnergisedEnd(), 9),
            masks(GroundedEnds(), 10)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ShortCircuitTest] = ShortCircuitTestSerializer
}

object ShortCircuitTestSerializer extends CIMSerializer[ShortCircuitTest]
{
    def write (kryo: Kryo, output: Output, obj: ShortCircuitTest): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.current),
            () => output.writeInt(obj.energisedEndStep),
            () => output.writeInt(obj.groundedEndStep),
            () => output.writeDouble(obj.leakageImpedance),
            () => output.writeDouble(obj.leakageImpedanceZero),
            () => output.writeDouble(obj.loss),
            () => output.writeDouble(obj.lossZero),
            () => output.writeDouble(obj.power),
            () => output.writeDouble(obj.voltage),
            () => output.writeString(obj.EnergisedEnd),
            () => writeList(obj.GroundedEnds, output)
        )
        TransformerTestSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ShortCircuitTest]): ShortCircuitTest =
    {
        val parent = TransformerTestSerializer.read(kryo, input, classOf[TransformerTest])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ShortCircuitTest(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readInt else 0,
            if (isSet(2)) input.readInt else 0,
            if (isSet(3)) input.readDouble else 0.0,
            if (isSet(4)) input.readDouble else 0.0,
            if (isSet(5)) input.readDouble else 0.0,
            if (isSet(6)) input.readDouble else 0.0,
            if (isSet(7)) input.readDouble else 0.0,
            if (isSet(8)) input.readDouble else 0.0,
            if (isSet(9)) input.readString else null,
            if (isSet(10)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Properties of shunt capacitor, shunt reactor or switchable bank of shunt capacitor or reactor assets.
 *
 * @param AssetInfo               [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param maxPowerLoss            Maximum allowed apparent power loss.
 * @param ratedCurrent            Rated current.
 * @param ratedReactivePower      Rated reactive power.
 * @param ratedVoltage            Rated voltage.
 * @param ShuntCompensatorControl [[ch.ninecode.model.ShuntCompensatorControl ShuntCompensatorControl]] <em>undocumented</em>
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
final case class ShuntCompensatorInfo
(
    AssetInfo: AssetInfo = null,
    maxPowerLoss: Double = 0.0,
    ratedCurrent: Double = 0.0,
    ratedReactivePower: Double = 0.0,
    ratedVoltage: Double = 0.0,
    ShuntCompensatorControl: String = null
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
    override def sup: AssetInfo = AssetInfo

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
        implicit val clz: String = ShuntCompensatorInfo.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(ShuntCompensatorInfo.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(ShuntCompensatorInfo.fields(position), value)

        emitelem(0, maxPowerLoss)
        emitelem(1, ratedCurrent)
        emitelem(2, ratedReactivePower)
        emitelem(3, ratedVoltage)
        emitattr(4, ShuntCompensatorControl)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ShuntCompensatorInfo rdf:%s=\"%s\">\n%s\t</cim:ShuntCompensatorInfo>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ShuntCompensatorInfo
    extends
        CIMParseable[ShuntCompensatorInfo]
{
    override val fields: Array[String] = Array[String](
        "maxPowerLoss",
        "ratedCurrent",
        "ratedReactivePower",
        "ratedVoltage",
        "ShuntCompensatorControl"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("ShuntCompensatorControl", "ShuntCompensatorControl", "0..1", "0..1")
    )
    val maxPowerLoss: Fielder = parse_element(element(cls, fields(0)))
    val ratedCurrent: Fielder = parse_element(element(cls, fields(1)))
    val ratedReactivePower: Fielder = parse_element(element(cls, fields(2)))
    val ratedVoltage: Fielder = parse_element(element(cls, fields(3)))
    val ShuntCompensatorControl: Fielder = parse_attribute(attribute(cls, fields(4)))

    def parse (context: CIMContext): ShuntCompensatorInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ShuntCompensatorInfo(
            AssetInfo.parse(context),
            toDouble(mask(maxPowerLoss(), 0)),
            toDouble(mask(ratedCurrent(), 1)),
            toDouble(mask(ratedReactivePower(), 2)),
            toDouble(mask(ratedVoltage(), 3)),
            mask(ShuntCompensatorControl(), 4)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ShuntCompensatorInfo] = ShuntCompensatorInfoSerializer
}

object ShuntCompensatorInfoSerializer extends CIMSerializer[ShuntCompensatorInfo]
{
    def write (kryo: Kryo, output: Output, obj: ShuntCompensatorInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.maxPowerLoss),
            () => output.writeDouble(obj.ratedCurrent),
            () => output.writeDouble(obj.ratedReactivePower),
            () => output.writeDouble(obj.ratedVoltage),
            () => output.writeString(obj.ShuntCompensatorControl)
        )
        AssetInfoSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ShuntCompensatorInfo]): ShuntCompensatorInfo =
    {
        val parent = AssetInfoSerializer.read(kryo, input, classOf[AssetInfo])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ShuntCompensatorInfo(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readDouble else 0.0,
            if (isSet(4)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * <was Switch data.>
 *
 * Switch datasheet information.
 *
 * @param AssetInfo                    [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param breakingCapacity             The maximum fault current a breaking device can break safely under prescribed conditions of use.
 * @param gasWeightPerTank             Weight of gas in each tank of SF6 dead tank breaker.
 * @param isSinglePhase                If true, it is a single phase switch.
 * @param isUnganged                   If true, the switch is not ganged (i.e., a switch phase may be operated separately from other phases).
 * @param lowPressureAlarm             Gas or air pressure at or below which a low pressure alarm is generated.
 * @param lowPressureLockOut           Gas or air pressure below which the breaker will not open.
 * @param oilVolumePerTank             Volume of oil in each tank of bulk oil breaker.
 * @param ratedCurrent                 Rated current.
 * @param ratedFrequency               Frequency for which switch is rated.
 * @param ratedImpulseWithstandVoltage Rated impulse withstand voltage, also known as BIL (Basic Impulse Level).
 * @param ratedInterruptingTime        Switch rated interrupting time in seconds.
 * @param ratedVoltage                 Rated voltage.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
final case class SwitchInfo
(
    AssetInfo: AssetInfo = null,
    breakingCapacity: Double = 0.0,
    gasWeightPerTank: Double = 0.0,
    isSinglePhase: Boolean = false,
    isUnganged: Boolean = false,
    lowPressureAlarm: Double = 0.0,
    lowPressureLockOut: Double = 0.0,
    oilVolumePerTank: Double = 0.0,
    ratedCurrent: Double = 0.0,
    ratedFrequency: Double = 0.0,
    ratedImpulseWithstandVoltage: Double = 0.0,
    ratedInterruptingTime: Double = 0.0,
    ratedVoltage: Double = 0.0
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
    override def sup: AssetInfo = AssetInfo

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
        implicit val clz: String = SwitchInfo.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(SwitchInfo.fields(position), value)

        emitelem(0, breakingCapacity)
        emitelem(1, gasWeightPerTank)
        emitelem(2, isSinglePhase)
        emitelem(3, isUnganged)
        emitelem(4, lowPressureAlarm)
        emitelem(5, lowPressureLockOut)
        emitelem(6, oilVolumePerTank)
        emitelem(7, ratedCurrent)
        emitelem(8, ratedFrequency)
        emitelem(9, ratedImpulseWithstandVoltage)
        emitelem(10, ratedInterruptingTime)
        emitelem(11, ratedVoltage)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:SwitchInfo rdf:%s=\"%s\">\n%s\t</cim:SwitchInfo>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object SwitchInfo
    extends
        CIMParseable[SwitchInfo]
{
    override val fields: Array[String] = Array[String](
        "breakingCapacity",
        "gasWeightPerTank",
        "isSinglePhase",
        "isUnganged",
        "lowPressureAlarm",
        "lowPressureLockOut",
        "oilVolumePerTank",
        "ratedCurrent",
        "ratedFrequency",
        "ratedImpulseWithstandVoltage",
        "ratedInterruptingTime",
        "ratedVoltage"
    )
    val breakingCapacity: Fielder = parse_element(element(cls, fields(0)))
    val gasWeightPerTank: Fielder = parse_element(element(cls, fields(1)))
    val isSinglePhase: Fielder = parse_element(element(cls, fields(2)))
    val isUnganged: Fielder = parse_element(element(cls, fields(3)))
    val lowPressureAlarm: Fielder = parse_element(element(cls, fields(4)))
    val lowPressureLockOut: Fielder = parse_element(element(cls, fields(5)))
    val oilVolumePerTank: Fielder = parse_element(element(cls, fields(6)))
    val ratedCurrent: Fielder = parse_element(element(cls, fields(7)))
    val ratedFrequency: Fielder = parse_element(element(cls, fields(8)))
    val ratedImpulseWithstandVoltage: Fielder = parse_element(element(cls, fields(9)))
    val ratedInterruptingTime: Fielder = parse_element(element(cls, fields(10)))
    val ratedVoltage: Fielder = parse_element(element(cls, fields(11)))

    def parse (context: CIMContext): SwitchInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SwitchInfo(
            AssetInfo.parse(context),
            toDouble(mask(breakingCapacity(), 0)),
            toDouble(mask(gasWeightPerTank(), 1)),
            toBoolean(mask(isSinglePhase(), 2)),
            toBoolean(mask(isUnganged(), 3)),
            toDouble(mask(lowPressureAlarm(), 4)),
            toDouble(mask(lowPressureLockOut(), 5)),
            toDouble(mask(oilVolumePerTank(), 6)),
            toDouble(mask(ratedCurrent(), 7)),
            toDouble(mask(ratedFrequency(), 8)),
            toDouble(mask(ratedImpulseWithstandVoltage(), 9)),
            toDouble(mask(ratedInterruptingTime(), 10)),
            toDouble(mask(ratedVoltage(), 11))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[SwitchInfo] = SwitchInfoSerializer
}

object SwitchInfoSerializer extends CIMSerializer[SwitchInfo]
{
    def write (kryo: Kryo, output: Output, obj: SwitchInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.breakingCapacity),
            () => output.writeDouble(obj.gasWeightPerTank),
            () => output.writeBoolean(obj.isSinglePhase),
            () => output.writeBoolean(obj.isUnganged),
            () => output.writeDouble(obj.lowPressureAlarm),
            () => output.writeDouble(obj.lowPressureLockOut),
            () => output.writeDouble(obj.oilVolumePerTank),
            () => output.writeDouble(obj.ratedCurrent),
            () => output.writeDouble(obj.ratedFrequency),
            () => output.writeDouble(obj.ratedImpulseWithstandVoltage),
            () => output.writeDouble(obj.ratedInterruptingTime),
            () => output.writeDouble(obj.ratedVoltage)
        )
        AssetInfoSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SwitchInfo]): SwitchInfo =
    {
        val parent = AssetInfoSerializer.read(kryo, input, classOf[AssetInfo])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = SwitchInfo(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readBoolean else false,
            if (isSet(3)) input.readBoolean else false,
            if (isSet(4)) input.readDouble else 0.0,
            if (isSet(5)) input.readDouble else 0.0,
            if (isSet(6)) input.readDouble else 0.0,
            if (isSet(7)) input.readDouble else 0.0,
            if (isSet(8)) input.readDouble else 0.0,
            if (isSet(9)) input.readDouble else 0.0,
            if (isSet(10)) input.readDouble else 0.0,
            if (isSet(11)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Tap changer data.
 *
 * @param AssetInfo            [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param bil                  Basic Insulation Level (BIL) expressed as the impulse crest voltage of a nominal wave, typically 1.2 X 50 microsecond.
 *                             This is a measure of the ability of the insulation to withstand very high voltage surges.
 * @param ctRating             Built-in current transformer primary rating.
 * @param ctRatio              Built-in current transducer ratio.
 * @param frequency            Frequency at which the ratings apply.
 * @param highStep             Highest possible tap step position, advance from neutral.
 * @param isTcul               Whether this tap changer has under load tap changing capabilities.
 * @param lowStep              Lowest possible tap step position, retard from neutral.
 * @param neutralStep          The neutral tap step position for the winding.
 * @param neutralU             Voltage at which the winding operates at the neutral tap setting.
 * @param ptRatio              Built-in voltage transducer ratio.
 * @param ratedApparentPower   Rated apparent power.
 * @param ratedCurrent         Rated current.
 * @param ratedVoltage         Rated voltage.
 * @param stepPhaseIncrement   Phase shift per step position.
 * @param stepVoltageIncrement Tap step increment, in per cent of rated voltage, per step position.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
final case class TapChangerInfo
(
    AssetInfo: AssetInfo = null,
    bil: Double = 0.0,
    ctRating: Double = 0.0,
    ctRatio: Double = 0.0,
    frequency: Double = 0.0,
    highStep: Int = 0,
    isTcul: Boolean = false,
    lowStep: Int = 0,
    neutralStep: Int = 0,
    neutralU: Double = 0.0,
    ptRatio: Double = 0.0,
    ratedApparentPower: Double = 0.0,
    ratedCurrent: Double = 0.0,
    ratedVoltage: Double = 0.0,
    stepPhaseIncrement: Double = 0.0,
    stepVoltageIncrement: Double = 0.0
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
    override def sup: AssetInfo = AssetInfo

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
        implicit val clz: String = TapChangerInfo.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(TapChangerInfo.fields(position), value)

        emitelem(0, bil)
        emitelem(1, ctRating)
        emitelem(2, ctRatio)
        emitelem(3, frequency)
        emitelem(4, highStep)
        emitelem(5, isTcul)
        emitelem(6, lowStep)
        emitelem(7, neutralStep)
        emitelem(8, neutralU)
        emitelem(9, ptRatio)
        emitelem(10, ratedApparentPower)
        emitelem(11, ratedCurrent)
        emitelem(12, ratedVoltage)
        emitelem(13, stepPhaseIncrement)
        emitelem(14, stepVoltageIncrement)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:TapChangerInfo rdf:%s=\"%s\">\n%s\t</cim:TapChangerInfo>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object TapChangerInfo
    extends
        CIMParseable[TapChangerInfo]
{
    override val fields: Array[String] = Array[String](
        "bil",
        "ctRating",
        "ctRatio",
        "frequency",
        "highStep",
        "isTcul",
        "lowStep",
        "neutralStep",
        "neutralU",
        "ptRatio",
        "ratedApparentPower",
        "ratedCurrent",
        "ratedVoltage",
        "stepPhaseIncrement",
        "stepVoltageIncrement"
    )
    val bil: Fielder = parse_element(element(cls, fields(0)))
    val ctRating: Fielder = parse_element(element(cls, fields(1)))
    val ctRatio: Fielder = parse_element(element(cls, fields(2)))
    val frequency: Fielder = parse_element(element(cls, fields(3)))
    val highStep: Fielder = parse_element(element(cls, fields(4)))
    val isTcul: Fielder = parse_element(element(cls, fields(5)))
    val lowStep: Fielder = parse_element(element(cls, fields(6)))
    val neutralStep: Fielder = parse_element(element(cls, fields(7)))
    val neutralU: Fielder = parse_element(element(cls, fields(8)))
    val ptRatio: Fielder = parse_element(element(cls, fields(9)))
    val ratedApparentPower: Fielder = parse_element(element(cls, fields(10)))
    val ratedCurrent: Fielder = parse_element(element(cls, fields(11)))
    val ratedVoltage: Fielder = parse_element(element(cls, fields(12)))
    val stepPhaseIncrement: Fielder = parse_element(element(cls, fields(13)))
    val stepVoltageIncrement: Fielder = parse_element(element(cls, fields(14)))

    def parse (context: CIMContext): TapChangerInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TapChangerInfo(
            AssetInfo.parse(context),
            toDouble(mask(bil(), 0)),
            toDouble(mask(ctRating(), 1)),
            toDouble(mask(ctRatio(), 2)),
            toDouble(mask(frequency(), 3)),
            toInteger(mask(highStep(), 4)),
            toBoolean(mask(isTcul(), 5)),
            toInteger(mask(lowStep(), 6)),
            toInteger(mask(neutralStep(), 7)),
            toDouble(mask(neutralU(), 8)),
            toDouble(mask(ptRatio(), 9)),
            toDouble(mask(ratedApparentPower(), 10)),
            toDouble(mask(ratedCurrent(), 11)),
            toDouble(mask(ratedVoltage(), 12)),
            toDouble(mask(stepPhaseIncrement(), 13)),
            toDouble(mask(stepVoltageIncrement(), 14))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[TapChangerInfo] = TapChangerInfoSerializer
}

object TapChangerInfoSerializer extends CIMSerializer[TapChangerInfo]
{
    def write (kryo: Kryo, output: Output, obj: TapChangerInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.bil),
            () => output.writeDouble(obj.ctRating),
            () => output.writeDouble(obj.ctRatio),
            () => output.writeDouble(obj.frequency),
            () => output.writeInt(obj.highStep),
            () => output.writeBoolean(obj.isTcul),
            () => output.writeInt(obj.lowStep),
            () => output.writeInt(obj.neutralStep),
            () => output.writeDouble(obj.neutralU),
            () => output.writeDouble(obj.ptRatio),
            () => output.writeDouble(obj.ratedApparentPower),
            () => output.writeDouble(obj.ratedCurrent),
            () => output.writeDouble(obj.ratedVoltage),
            () => output.writeDouble(obj.stepPhaseIncrement),
            () => output.writeDouble(obj.stepVoltageIncrement)
        )
        AssetInfoSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TapChangerInfo]): TapChangerInfo =
    {
        val parent = AssetInfoSerializer.read(kryo, input, classOf[AssetInfo])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = TapChangerInfo(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readDouble else 0.0,
            if (isSet(4)) input.readInt else 0,
            if (isSet(5)) input.readBoolean else false,
            if (isSet(6)) input.readInt else 0,
            if (isSet(7)) input.readInt else 0,
            if (isSet(8)) input.readDouble else 0.0,
            if (isSet(9)) input.readDouble else 0.0,
            if (isSet(10)) input.readDouble else 0.0,
            if (isSet(11)) input.readDouble else 0.0,
            if (isSet(12)) input.readDouble else 0.0,
            if (isSet(13)) input.readDouble else 0.0,
            if (isSet(14)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Tape shield cable data.
 *
 * @param CableInfo     [[ch.ninecode.model.CableInfo CableInfo]] Reference to the superclass object.
 * @param tapeLap       Percentage of the tape shield width that overlaps in each wrap, typically 10% to 25%.
 * @param tapeThickness Thickness of the tape shield, before wrapping.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
final case class TapeShieldCableInfo
(
    CableInfo: CableInfo = null,
    tapeLap: Double = 0.0,
    tapeThickness: Double = 0.0
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
    override def sup: CableInfo = CableInfo

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
        implicit val clz: String = TapeShieldCableInfo.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(TapeShieldCableInfo.fields(position), value)

        emitelem(0, tapeLap)
        emitelem(1, tapeThickness)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:TapeShieldCableInfo rdf:%s=\"%s\">\n%s\t</cim:TapeShieldCableInfo>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object TapeShieldCableInfo
    extends
        CIMParseable[TapeShieldCableInfo]
{
    override val fields: Array[String] = Array[String](
        "tapeLap",
        "tapeThickness"
    )
    val tapeLap: Fielder = parse_element(element(cls, fields(0)))
    val tapeThickness: Fielder = parse_element(element(cls, fields(1)))

    def parse (context: CIMContext): TapeShieldCableInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TapeShieldCableInfo(
            CableInfo.parse(context),
            toDouble(mask(tapeLap(), 0)),
            toDouble(mask(tapeThickness(), 1))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[TapeShieldCableInfo] = TapeShieldCableInfoSerializer
}

object TapeShieldCableInfoSerializer extends CIMSerializer[TapeShieldCableInfo]
{
    def write (kryo: Kryo, output: Output, obj: TapeShieldCableInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.tapeLap),
            () => output.writeDouble(obj.tapeThickness)
        )
        CableInfoSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TapeShieldCableInfo]): TapeShieldCableInfo =
    {
        val parent = CableInfoSerializer.read(kryo, input, classOf[CableInfo])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = TapeShieldCableInfo(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Transformer end data.
 *
 * @param AssetInfo                     [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param connectionKind                Kind of connection.
 * @param emergencyS                    Apparent power that the winding can carry under emergency conditions (also called long-term emergency power).
 * @param endNumber                     Number for this transformer end, corresponding to the end's order in the PowerTransformer.vectorGroup attribute.
 *                                      Highest voltage winding should be 1.
 * @param insulationU                   Basic insulation level voltage rating.
 * @param phaseAngleClock               Winding phase angle where 360 degrees are represented with clock hours, so the valid values are {0, ..., 11}.
 *                                      For example, to express the second winding in code 'Dyn11', set attributes as follows: 'endNumber'=2, 'connectionKind' = Yn and 'phaseAngleClock' = 11.
 * @param r                             DC resistance.
 * @param ratedS                        Normal apparent power rating.
 * @param ratedU                        Rated voltage: phase-phase for three-phase windings, and either phase-phase or phase-neutral for single-phase windings.
 * @param shortTermS                    Apparent power that this winding can carry for a short period of time (in emergency).
 * @param CoreAdmittance                [[ch.ninecode.model.TransformerCoreAdmittance TransformerCoreAdmittance]] Core admittance calculated from this transformer end datasheet, representing magnetising current and core losses.
 *                                      The full values of the transformer should be supplied for one transformer end info only.
 * @param EnergisedEndNoLoadTests       [[ch.ninecode.model.NoLoadTest NoLoadTest]] All no-load test measurements in which this transformer end was energised.
 * @param EnergisedEndOpenCircuitTests  [[ch.ninecode.model.OpenCircuitTest OpenCircuitTest]] All open-circuit test measurements in which this transformer end was excited.
 * @param EnergisedEndShortCircuitTests [[ch.ninecode.model.ShortCircuitTest ShortCircuitTest]] All short-circuit test measurements in which this transformer end was energised.
 * @param FromMeshImpedances            [[ch.ninecode.model.TransformerMeshImpedance TransformerMeshImpedance]] All mesh impedances between this 'to' and other 'from' transformer ends.
 * @param GroundedEndShortCircuitTests  [[ch.ninecode.model.ShortCircuitTest ShortCircuitTest]] All short-circuit test measurements in which this transformer end was short-circuited.
 * @param OpenEndOpenCircuitTests       [[ch.ninecode.model.OpenCircuitTest OpenCircuitTest]] All open-circuit test measurements in which this transformer end was not excited.
 * @param ToMeshImpedances              [[ch.ninecode.model.TransformerMeshImpedance TransformerMeshImpedance]] All mesh impedances between this 'from' and other 'to' transformer ends.
 * @param TransformerStarImpedance      [[ch.ninecode.model.TransformerStarImpedance TransformerStarImpedance]] Transformer star impedance calculated from this transformer end datasheet.
 * @param TransformerTankInfo           [[ch.ninecode.model.TransformerTankInfo TransformerTankInfo]] Transformer tank data that this end description is part of.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
final case class TransformerEndInfo
(
    AssetInfo: AssetInfo = null,
    connectionKind: String = null,
    emergencyS: Double = 0.0,
    endNumber: Int = 0,
    insulationU: Double = 0.0,
    phaseAngleClock: Int = 0,
    r: Double = 0.0,
    ratedS: Double = 0.0,
    ratedU: Double = 0.0,
    shortTermS: Double = 0.0,
    CoreAdmittance: String = null,
    EnergisedEndNoLoadTests: List[String] = null,
    EnergisedEndOpenCircuitTests: List[String] = null,
    EnergisedEndShortCircuitTests: List[String] = null,
    FromMeshImpedances: List[String] = null,
    GroundedEndShortCircuitTests: List[String] = null,
    OpenEndOpenCircuitTests: List[String] = null,
    ToMeshImpedances: List[String] = null,
    TransformerStarImpedance: String = null,
    TransformerTankInfo: String = null
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
    override def sup: AssetInfo = AssetInfo

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
        implicit val clz: String = TransformerEndInfo.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(TransformerEndInfo.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(TransformerEndInfo.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(TransformerEndInfo.fields(position), x))

        emitattr(0, connectionKind)
        emitelem(1, emergencyS)
        emitelem(2, endNumber)
        emitelem(3, insulationU)
        emitelem(4, phaseAngleClock)
        emitelem(5, r)
        emitelem(6, ratedS)
        emitelem(7, ratedU)
        emitelem(8, shortTermS)
        emitattr(9, CoreAdmittance)
        emitattrs(10, EnergisedEndNoLoadTests)
        emitattrs(11, EnergisedEndOpenCircuitTests)
        emitattrs(12, EnergisedEndShortCircuitTests)
        emitattrs(13, FromMeshImpedances)
        emitattrs(14, GroundedEndShortCircuitTests)
        emitattrs(15, OpenEndOpenCircuitTests)
        emitattrs(16, ToMeshImpedances)
        emitattr(17, TransformerStarImpedance)
        emitattr(18, TransformerTankInfo)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:TransformerEndInfo rdf:%s=\"%s\">\n%s\t</cim:TransformerEndInfo>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object TransformerEndInfo
    extends
        CIMParseable[TransformerEndInfo]
{
    override val fields: Array[String] = Array[String](
        "connectionKind",
        "emergencyS",
        "endNumber",
        "insulationU",
        "phaseAngleClock",
        "r",
        "ratedS",
        "ratedU",
        "shortTermS",
        "CoreAdmittance",
        "EnergisedEndNoLoadTests",
        "EnergisedEndOpenCircuitTests",
        "EnergisedEndShortCircuitTests",
        "FromMeshImpedances",
        "GroundedEndShortCircuitTests",
        "OpenEndOpenCircuitTests",
        "ToMeshImpedances",
        "TransformerStarImpedance",
        "TransformerTankInfo"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("CoreAdmittance", "TransformerCoreAdmittance", "0..1", "0..1"),
        CIMRelationship("EnergisedEndNoLoadTests", "NoLoadTest", "0..*", "0..1"),
        CIMRelationship("EnergisedEndOpenCircuitTests", "OpenCircuitTest", "0..*", "1"),
        CIMRelationship("EnergisedEndShortCircuitTests", "ShortCircuitTest", "0..*", "1"),
        CIMRelationship("FromMeshImpedances", "TransformerMeshImpedance", "0..*", "0..1"),
        CIMRelationship("GroundedEndShortCircuitTests", "ShortCircuitTest", "0..*", "1..*"),
        CIMRelationship("OpenEndOpenCircuitTests", "OpenCircuitTest", "0..*", "1"),
        CIMRelationship("ToMeshImpedances", "TransformerMeshImpedance", "0..*", "0..*"),
        CIMRelationship("TransformerStarImpedance", "TransformerStarImpedance", "0..1", "0..1"),
        CIMRelationship("TransformerTankInfo", "TransformerTankInfo", "1", "1..*")
    )
    val connectionKind: Fielder = parse_attribute(attribute(cls, fields(0)))
    val emergencyS: Fielder = parse_element(element(cls, fields(1)))
    val endNumber: Fielder = parse_element(element(cls, fields(2)))
    val insulationU: Fielder = parse_element(element(cls, fields(3)))
    val phaseAngleClock: Fielder = parse_element(element(cls, fields(4)))
    val r: Fielder = parse_element(element(cls, fields(5)))
    val ratedS: Fielder = parse_element(element(cls, fields(6)))
    val ratedU: Fielder = parse_element(element(cls, fields(7)))
    val shortTermS: Fielder = parse_element(element(cls, fields(8)))
    val CoreAdmittance: Fielder = parse_attribute(attribute(cls, fields(9)))
    val EnergisedEndNoLoadTests: FielderMultiple = parse_attributes(attribute(cls, fields(10)))
    val EnergisedEndOpenCircuitTests: FielderMultiple = parse_attributes(attribute(cls, fields(11)))
    val EnergisedEndShortCircuitTests: FielderMultiple = parse_attributes(attribute(cls, fields(12)))
    val FromMeshImpedances: FielderMultiple = parse_attributes(attribute(cls, fields(13)))
    val GroundedEndShortCircuitTests: FielderMultiple = parse_attributes(attribute(cls, fields(14)))
    val OpenEndOpenCircuitTests: FielderMultiple = parse_attributes(attribute(cls, fields(15)))
    val ToMeshImpedances: FielderMultiple = parse_attributes(attribute(cls, fields(16)))
    val TransformerStarImpedance: Fielder = parse_attribute(attribute(cls, fields(17)))
    val TransformerTankInfo: Fielder = parse_attribute(attribute(cls, fields(18)))

    def parse (context: CIMContext): TransformerEndInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TransformerEndInfo(
            AssetInfo.parse(context),
            mask(connectionKind(), 0),
            toDouble(mask(emergencyS(), 1)),
            toInteger(mask(endNumber(), 2)),
            toDouble(mask(insulationU(), 3)),
            toInteger(mask(phaseAngleClock(), 4)),
            toDouble(mask(r(), 5)),
            toDouble(mask(ratedS(), 6)),
            toDouble(mask(ratedU(), 7)),
            toDouble(mask(shortTermS(), 8)),
            mask(CoreAdmittance(), 9),
            masks(EnergisedEndNoLoadTests(), 10),
            masks(EnergisedEndOpenCircuitTests(), 11),
            masks(EnergisedEndShortCircuitTests(), 12),
            masks(FromMeshImpedances(), 13),
            masks(GroundedEndShortCircuitTests(), 14),
            masks(OpenEndOpenCircuitTests(), 15),
            masks(ToMeshImpedances(), 16),
            mask(TransformerStarImpedance(), 17),
            mask(TransformerTankInfo(), 18)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[TransformerEndInfo] = TransformerEndInfoSerializer
}

object TransformerEndInfoSerializer extends CIMSerializer[TransformerEndInfo]
{
    def write (kryo: Kryo, output: Output, obj: TransformerEndInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.connectionKind),
            () => output.writeDouble(obj.emergencyS),
            () => output.writeInt(obj.endNumber),
            () => output.writeDouble(obj.insulationU),
            () => output.writeInt(obj.phaseAngleClock),
            () => output.writeDouble(obj.r),
            () => output.writeDouble(obj.ratedS),
            () => output.writeDouble(obj.ratedU),
            () => output.writeDouble(obj.shortTermS),
            () => output.writeString(obj.CoreAdmittance),
            () => writeList(obj.EnergisedEndNoLoadTests, output),
            () => writeList(obj.EnergisedEndOpenCircuitTests, output),
            () => writeList(obj.EnergisedEndShortCircuitTests, output),
            () => writeList(obj.FromMeshImpedances, output),
            () => writeList(obj.GroundedEndShortCircuitTests, output),
            () => writeList(obj.OpenEndOpenCircuitTests, output),
            () => writeList(obj.ToMeshImpedances, output),
            () => output.writeString(obj.TransformerStarImpedance),
            () => output.writeString(obj.TransformerTankInfo)
        )
        AssetInfoSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TransformerEndInfo]): TransformerEndInfo =
    {
        val parent = AssetInfoSerializer.read(kryo, input, classOf[AssetInfo])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = TransformerEndInfo(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readInt else 0,
            if (isSet(3)) input.readDouble else 0.0,
            if (isSet(4)) input.readInt else 0,
            if (isSet(5)) input.readDouble else 0.0,
            if (isSet(6)) input.readDouble else 0.0,
            if (isSet(7)) input.readDouble else 0.0,
            if (isSet(8)) input.readDouble else 0.0,
            if (isSet(9)) input.readString else null,
            if (isSet(10)) readList(input) else null,
            if (isSet(11)) readList(input) else null,
            if (isSet(12)) readList(input) else null,
            if (isSet(13)) readList(input) else null,
            if (isSet(14)) readList(input) else null,
            if (isSet(15)) readList(input) else null,
            if (isSet(16)) readList(input) else null,
            if (isSet(17)) input.readString else null,
            if (isSet(18)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Set of transformer tank data, from an equipment library.
 *
 * @param AssetInfo            [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param PowerTransformerInfo [[ch.ninecode.model.PowerTransformerInfo PowerTransformerInfo]] Power transformer data that this tank description is part of.
 * @param TransformerEndInfos  [[ch.ninecode.model.TransformerEndInfo TransformerEndInfo]] Data for all the ends described by this transformer tank data.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
final case class TransformerTankInfo
(
    AssetInfo: AssetInfo = null,
    PowerTransformerInfo: String = null,
    TransformerEndInfos: List[String] = null
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
    override def sup: AssetInfo = AssetInfo

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
        implicit val clz: String = TransformerTankInfo.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(TransformerTankInfo.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(TransformerTankInfo.fields(position), x))

        emitattr(0, PowerTransformerInfo)
        emitattrs(1, TransformerEndInfos)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:TransformerTankInfo rdf:%s=\"%s\">\n%s\t</cim:TransformerTankInfo>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object TransformerTankInfo
    extends
        CIMParseable[TransformerTankInfo]
{
    override val fields: Array[String] = Array[String](
        "PowerTransformerInfo",
        "TransformerEndInfos"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("PowerTransformerInfo", "PowerTransformerInfo", "1", "1..*"),
        CIMRelationship("TransformerEndInfos", "TransformerEndInfo", "1..*", "1")
    )
    val PowerTransformerInfo: Fielder = parse_attribute(attribute(cls, fields(0)))
    val TransformerEndInfos: FielderMultiple = parse_attributes(attribute(cls, fields(1)))

    def parse (context: CIMContext): TransformerTankInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TransformerTankInfo(
            AssetInfo.parse(context),
            mask(PowerTransformerInfo(), 0),
            masks(TransformerEndInfos(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[TransformerTankInfo] = TransformerTankInfoSerializer
}

object TransformerTankInfoSerializer extends CIMSerializer[TransformerTankInfo]
{
    def write (kryo: Kryo, output: Output, obj: TransformerTankInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.PowerTransformerInfo),
            () => writeList(obj.TransformerEndInfos, output)
        )
        AssetInfoSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TransformerTankInfo]): TransformerTankInfo =
    {
        val parent = AssetInfoSerializer.read(kryo, input, classOf[AssetInfo])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = TransformerTankInfo(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Test result for transformer ends, such as short-circuit, open-circuit (excitation) or no-load test.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param basePower        Base power at which the tests are conducted, usually equal to the rateds of one of the involved transformer ends.
 * @param temperature      Temperature at which the test is conducted.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
final case class TransformerTest
(
    IdentifiedObject: IdentifiedObject = null,
    basePower: Double = 0.0,
    temperature: Double = 0.0
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
        implicit val clz: String = TransformerTest.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(TransformerTest.fields(position), value)

        emitelem(0, basePower)
        emitelem(1, temperature)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:TransformerTest rdf:%s=\"%s\">\n%s\t</cim:TransformerTest>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object TransformerTest
    extends
        CIMParseable[TransformerTest]
{
    override val fields: Array[String] = Array[String](
        "basePower",
        "temperature"
    )
    val basePower: Fielder = parse_element(element(cls, fields(0)))
    val temperature: Fielder = parse_element(element(cls, fields(1)))

    def parse (context: CIMContext): TransformerTest =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TransformerTest(
            IdentifiedObject.parse(context),
            toDouble(mask(basePower(), 0)),
            toDouble(mask(temperature(), 1))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[TransformerTest] = TransformerTestSerializer
}

object TransformerTestSerializer extends CIMSerializer[TransformerTest]
{
    def write (kryo: Kryo, output: Output, obj: TransformerTest): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.basePower),
            () => output.writeDouble(obj.temperature)
        )
        IdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TransformerTest]): TransformerTest =
    {
        val parent = IdentifiedObjectSerializer.read(kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = TransformerTest(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Describes the construction of a multi-conductor wire.<-NOTE: period missing.
 *
 * @param AssetInfo              [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param PerLengthLineParameter [[ch.ninecode.model.PerLengthLineParameter PerLengthLineParameter]] Per length line parameter associated with this wire assembly.
 * @param WirePhaseInfo          [[ch.ninecode.model.WirePhaseInfo WirePhaseInfo]] Wire phase information associated with this wire assembly.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
final case class WireAssemblyInfo
(
    AssetInfo: AssetInfo = null,
    PerLengthLineParameter: List[String] = null,
    WirePhaseInfo: List[String] = null
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
    override def sup: AssetInfo = AssetInfo

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
        implicit val clz: String = WireAssemblyInfo.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(WireAssemblyInfo.fields(position), x))

        emitattrs(0, PerLengthLineParameter)
        emitattrs(1, WirePhaseInfo)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:WireAssemblyInfo rdf:%s=\"%s\">\n%s\t</cim:WireAssemblyInfo>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object WireAssemblyInfo
    extends
        CIMParseable[WireAssemblyInfo]
{
    override val fields: Array[String] = Array[String](
        "PerLengthLineParameter",
        "WirePhaseInfo"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("PerLengthLineParameter", "PerLengthLineParameter", "0..*", "0..1"),
        CIMRelationship("WirePhaseInfo", "WirePhaseInfo", "0..*", "1")
    )
    val PerLengthLineParameter: FielderMultiple = parse_attributes(attribute(cls, fields(0)))
    val WirePhaseInfo: FielderMultiple = parse_attributes(attribute(cls, fields(1)))

    def parse (context: CIMContext): WireAssemblyInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WireAssemblyInfo(
            AssetInfo.parse(context),
            masks(PerLengthLineParameter(), 0),
            masks(WirePhaseInfo(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[WireAssemblyInfo] = WireAssemblyInfoSerializer
}

object WireAssemblyInfoSerializer extends CIMSerializer[WireAssemblyInfo]
{
    def write (kryo: Kryo, output: Output, obj: WireAssemblyInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => writeList(obj.PerLengthLineParameter, output),
            () => writeList(obj.WirePhaseInfo, output)
        )
        AssetInfoSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[WireAssemblyInfo]): WireAssemblyInfo =
    {
        val parent = AssetInfoSerializer.read(kryo, input, classOf[AssetInfo])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = WireAssemblyInfo(
            parent,
            if (isSet(0)) readList(input) else null,
            if (isSet(1)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Wire data that can be specified per line segment phase, or for the line segment as a whole in case its phases all have the same wire characteristics.
 *
 * @param AssetInfo           [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param coreRadius          (if there is a different core material) Radius of the central core.
 * @param coreStrandCount     (if used) Number of strands in the steel core.
 * @param gmr                 Geometric mean radius.
 *                            If we replace the conductor by a thin walled tube of radius GMR, then its reactance is identical to the reactance of the actual conductor.
 * @param insulated           True if conductor is insulated.
 * @param insulationMaterial  (if insulated conductor) Material used for insulation.
 * @param insulationThickness (if insulated conductor) Thickness of the insulation.
 * @param material            Conductor material.
 * @param rAC25               AC resistance per unit length of the conductor at 25 °C.
 * @param rAC50               AC resistance per unit length of the conductor at 50 °C.
 * @param rAC75               AC resistance per unit length of the conductor at 75 °C.
 * @param rDC20               DC resistance per unit length of the conductor at 20 °C.
 * @param radius              Outside radius of the wire.
 * @param ratedCurrent        Current carrying capacity of the wire under stated thermal conditions.
 * @param sizeDescription     Describes the wire gauge or cross section (e.g., 4/0, #2, 336.5).
 * @param strandCount         Number of strands in the conductor.
 * @param ACLineSegmentPhase  [[ch.ninecode.model.ACLineSegmentPhase ACLineSegmentPhase]] <em>undocumented</em>
 * @param WirePhaseInfo       [[ch.ninecode.model.WirePhaseInfo WirePhaseInfo]] Wire phase information associated with this wire information.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
final case class WireInfo
(
    AssetInfo: AssetInfo = null,
    coreRadius: Double = 0.0,
    coreStrandCount: Int = 0,
    gmr: Double = 0.0,
    insulated: Boolean = false,
    insulationMaterial: String = null,
    insulationThickness: Double = 0.0,
    material: String = null,
    rAC25: Double = 0.0,
    rAC50: Double = 0.0,
    rAC75: Double = 0.0,
    rDC20: Double = 0.0,
    radius: Double = 0.0,
    ratedCurrent: Double = 0.0,
    sizeDescription: String = null,
    strandCount: Int = 0,
    ACLineSegmentPhase: List[String] = null,
    WirePhaseInfo: List[String] = null
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
    override def sup: AssetInfo = AssetInfo

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
        implicit val clz: String = WireInfo.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(WireInfo.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(WireInfo.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(WireInfo.fields(position), x))

        emitelem(0, coreRadius)
        emitelem(1, coreStrandCount)
        emitelem(2, gmr)
        emitelem(3, insulated)
        emitattr(4, insulationMaterial)
        emitelem(5, insulationThickness)
        emitattr(6, material)
        emitelem(7, rAC25)
        emitelem(8, rAC50)
        emitelem(9, rAC75)
        emitelem(10, rDC20)
        emitelem(11, radius)
        emitelem(12, ratedCurrent)
        emitelem(13, sizeDescription)
        emitelem(14, strandCount)
        emitattrs(15, ACLineSegmentPhase)
        emitattrs(16, WirePhaseInfo)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:WireInfo rdf:%s=\"%s\">\n%s\t</cim:WireInfo>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object WireInfo
    extends
        CIMParseable[WireInfo]
{
    override val fields: Array[String] = Array[String](
        "coreRadius",
        "coreStrandCount",
        "gmr",
        "insulated",
        "insulationMaterial",
        "insulationThickness",
        "material",
        "rAC25",
        "rAC50",
        "rAC75",
        "rDC20",
        "radius",
        "ratedCurrent",
        "sizeDescription",
        "strandCount",
        "ACLineSegmentPhase",
        "WirePhaseInfo"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("ACLineSegmentPhase", "ACLineSegmentPhase", "0..*", "0..1"),
        CIMRelationship("WirePhaseInfo", "WirePhaseInfo", "0..*", "0..1")
    )
    val coreRadius: Fielder = parse_element(element(cls, fields(0)))
    val coreStrandCount: Fielder = parse_element(element(cls, fields(1)))
    val gmr: Fielder = parse_element(element(cls, fields(2)))
    val insulated: Fielder = parse_element(element(cls, fields(3)))
    val insulationMaterial: Fielder = parse_attribute(attribute(cls, fields(4)))
    val insulationThickness: Fielder = parse_element(element(cls, fields(5)))
    val material: Fielder = parse_attribute(attribute(cls, fields(6)))
    val rAC25: Fielder = parse_element(element(cls, fields(7)))
    val rAC50: Fielder = parse_element(element(cls, fields(8)))
    val rAC75: Fielder = parse_element(element(cls, fields(9)))
    val rDC20: Fielder = parse_element(element(cls, fields(10)))
    val radius: Fielder = parse_element(element(cls, fields(11)))
    val ratedCurrent: Fielder = parse_element(element(cls, fields(12)))
    val sizeDescription: Fielder = parse_element(element(cls, fields(13)))
    val strandCount: Fielder = parse_element(element(cls, fields(14)))
    val ACLineSegmentPhase: FielderMultiple = parse_attributes(attribute(cls, fields(15)))
    val WirePhaseInfo: FielderMultiple = parse_attributes(attribute(cls, fields(16)))

    def parse (context: CIMContext): WireInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WireInfo(
            AssetInfo.parse(context),
            toDouble(mask(coreRadius(), 0)),
            toInteger(mask(coreStrandCount(), 1)),
            toDouble(mask(gmr(), 2)),
            toBoolean(mask(insulated(), 3)),
            mask(insulationMaterial(), 4),
            toDouble(mask(insulationThickness(), 5)),
            mask(material(), 6),
            toDouble(mask(rAC25(), 7)),
            toDouble(mask(rAC50(), 8)),
            toDouble(mask(rAC75(), 9)),
            toDouble(mask(rDC20(), 10)),
            toDouble(mask(radius(), 11)),
            toDouble(mask(ratedCurrent(), 12)),
            mask(sizeDescription(), 13),
            toInteger(mask(strandCount(), 14)),
            masks(ACLineSegmentPhase(), 15),
            masks(WirePhaseInfo(), 16)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[WireInfo] = WireInfoSerializer
}

object WireInfoSerializer extends CIMSerializer[WireInfo]
{
    def write (kryo: Kryo, output: Output, obj: WireInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.coreRadius),
            () => output.writeInt(obj.coreStrandCount),
            () => output.writeDouble(obj.gmr),
            () => output.writeBoolean(obj.insulated),
            () => output.writeString(obj.insulationMaterial),
            () => output.writeDouble(obj.insulationThickness),
            () => output.writeString(obj.material),
            () => output.writeDouble(obj.rAC25),
            () => output.writeDouble(obj.rAC50),
            () => output.writeDouble(obj.rAC75),
            () => output.writeDouble(obj.rDC20),
            () => output.writeDouble(obj.radius),
            () => output.writeDouble(obj.ratedCurrent),
            () => output.writeString(obj.sizeDescription),
            () => output.writeInt(obj.strandCount),
            () => writeList(obj.ACLineSegmentPhase, output),
            () => writeList(obj.WirePhaseInfo, output)
        )
        AssetInfoSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[WireInfo]): WireInfo =
    {
        val parent = AssetInfoSerializer.read(kryo, input, classOf[AssetInfo])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = WireInfo(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readInt else 0,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readBoolean else false,
            if (isSet(4)) input.readString else null,
            if (isSet(5)) input.readDouble else 0.0,
            if (isSet(6)) input.readString else null,
            if (isSet(7)) input.readDouble else 0.0,
            if (isSet(8)) input.readDouble else 0.0,
            if (isSet(9)) input.readDouble else 0.0,
            if (isSet(10)) input.readDouble else 0.0,
            if (isSet(11)) input.readDouble else 0.0,
            if (isSet(12)) input.readDouble else 0.0,
            if (isSet(13)) input.readString else null,
            if (isSet(14)) input.readInt else 0,
            if (isSet(15)) readList(input) else null,
            if (isSet(16)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Information on a wire carrying a single phase.
 *
 * @param Element          Reference to the superclass object.
 * @param phaseInfo        Phase information.
 * @param WireAssemblyInfo [[ch.ninecode.model.WireAssemblyInfo WireAssemblyInfo]] Wire assembly information using this wire phase information.
 * @param WireInfo         [[ch.ninecode.model.WireInfo WireInfo]] Wire information contributing to this wire phase information.
 * @param WirePosition     [[ch.ninecode.model.WirePosition WirePosition]] Wire position with this wire phase information.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
final case class WirePhaseInfo
(
    Element: BasicElement = null,
    phaseInfo: String = null,
    WireAssemblyInfo: String = null,
    WireInfo: String = null,
    WirePosition: String = null
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
        implicit val clz: String = WirePhaseInfo.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(WirePhaseInfo.fields(position), value)

        emitattr(0, phaseInfo)
        emitattr(1, WireAssemblyInfo)
        emitattr(2, WireInfo)
        emitattr(3, WirePosition)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:WirePhaseInfo rdf:%s=\"%s\">\n%s\t</cim:WirePhaseInfo>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object WirePhaseInfo
    extends
        CIMParseable[WirePhaseInfo]
{
    override val fields: Array[String] = Array[String](
        "phaseInfo",
        "WireAssemblyInfo",
        "WireInfo",
        "WirePosition"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("WireAssemblyInfo", "WireAssemblyInfo", "1", "0..*"),
        CIMRelationship("WireInfo", "WireInfo", "0..1", "0..*"),
        CIMRelationship("WirePosition", "WirePosition", "0..1", "0..*")
    )
    val phaseInfo: Fielder = parse_attribute(attribute(cls, fields(0)))
    val WireAssemblyInfo: Fielder = parse_attribute(attribute(cls, fields(1)))
    val WireInfo: Fielder = parse_attribute(attribute(cls, fields(2)))
    val WirePosition: Fielder = parse_attribute(attribute(cls, fields(3)))

    def parse (context: CIMContext): WirePhaseInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WirePhaseInfo(
            BasicElement.parse(context),
            mask(phaseInfo(), 0),
            mask(WireAssemblyInfo(), 1),
            mask(WireInfo(), 2),
            mask(WirePosition(), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[WirePhaseInfo] = WirePhaseInfoSerializer
}

object WirePhaseInfoSerializer extends CIMSerializer[WirePhaseInfo]
{
    def write (kryo: Kryo, output: Output, obj: WirePhaseInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.phaseInfo),
            () => output.writeString(obj.WireAssemblyInfo),
            () => output.writeString(obj.WireInfo),
            () => output.writeString(obj.WirePosition)
        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[WirePhaseInfo]): WirePhaseInfo =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = WirePhaseInfo(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readString else null,
            if (isSet(3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Identification, spacing and configuration of the wires of a conductor with respect to a structure.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param sequenceNumber   Numbering for wires on a WireSpacingInfo.
 *                         Neutrals should be numbered last.
 * @param xCoord           Signed horizontal distance from the wire at this position to a common reference point.
 * @param yCoord           Signed vertical distance from the wire at this position: above ground (positive value) or burial depth below ground (negative value).
 * @param WirePhaseInfo    [[ch.ninecode.model.WirePhaseInfo WirePhaseInfo]] Wire phase information for this wire position.
 * @param WireSpacingInfo  [[ch.ninecode.model.WireSpacingInfo WireSpacingInfo]] Wire spacing data this wire position belongs to.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
final case class WirePosition
(
    IdentifiedObject: IdentifiedObject = null,
    sequenceNumber: Int = 0,
    xCoord: Double = 0.0,
    yCoord: Double = 0.0,
    WirePhaseInfo: List[String] = null,
    WireSpacingInfo: String = null
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
        implicit val clz: String = WirePosition.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(WirePosition.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(WirePosition.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(WirePosition.fields(position), x))

        emitelem(0, sequenceNumber)
        emitelem(1, xCoord)
        emitelem(2, yCoord)
        emitattrs(3, WirePhaseInfo)
        emitattr(4, WireSpacingInfo)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:WirePosition rdf:%s=\"%s\">\n%s\t</cim:WirePosition>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object WirePosition
    extends
        CIMParseable[WirePosition]
{
    override val fields: Array[String] = Array[String](
        "sequenceNumber",
        "xCoord",
        "yCoord",
        "WirePhaseInfo",
        "WireSpacingInfo"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("WirePhaseInfo", "WirePhaseInfo", "0..*", "0..1"),
        CIMRelationship("WireSpacingInfo", "WireSpacingInfo", "0..1", "1..*")
    )
    val sequenceNumber: Fielder = parse_element(element(cls, fields(0)))
    val xCoord: Fielder = parse_element(element(cls, fields(1)))
    val yCoord: Fielder = parse_element(element(cls, fields(2)))
    val WirePhaseInfo: FielderMultiple = parse_attributes(attribute(cls, fields(3)))
    val WireSpacingInfo: Fielder = parse_attribute(attribute(cls, fields(4)))

    def parse (context: CIMContext): WirePosition =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WirePosition(
            IdentifiedObject.parse(context),
            toInteger(mask(sequenceNumber(), 0)),
            toDouble(mask(xCoord(), 1)),
            toDouble(mask(yCoord(), 2)),
            masks(WirePhaseInfo(), 3),
            mask(WireSpacingInfo(), 4)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[WirePosition] = WirePositionSerializer
}

object WirePositionSerializer extends CIMSerializer[WirePosition]
{
    def write (kryo: Kryo, output: Output, obj: WirePosition): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeInt(obj.sequenceNumber),
            () => output.writeDouble(obj.xCoord),
            () => output.writeDouble(obj.yCoord),
            () => writeList(obj.WirePhaseInfo, output),
            () => output.writeString(obj.WireSpacingInfo)
        )
        IdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[WirePosition]): WirePosition =
    {
        val parent = IdentifiedObjectSerializer.read(kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = WirePosition(
            parent,
            if (isSet(0)) input.readInt else 0,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) readList(input) else null,
            if (isSet(4)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Wire spacing data that associates multiple wire positions with the line segment, and allows to calculate line segment impedances.
 *
 * Number of phases can be derived from the number of associated wire positions whose phase is not neutral.
 *
 * @param AssetInfo        [[ch.ninecode.model.AssetInfo AssetInfo]] Reference to the superclass object.
 * @param isCable          If true, this spacing data describes a cable.
 * @param phaseWireCount   Number of wire sub-conductors in the symmetrical bundle (typically between 1 and 4).
 * @param phaseWireSpacing Distance between wire sub-conductors in a symmetrical bundle.
 * @param usage            Usage of the associated wires.
 * @param ACLineSegment    [[ch.ninecode.model.ACLineSegment ACLineSegment]] <em>undocumented</em>
 * @param DuctBank         [[ch.ninecode.model.DuctBank DuctBank]] <em>undocumented</em>
 * @param Structures       [[ch.ninecode.model.Structure Structure]] <em>undocumented</em>
 * @param WirePositions    [[ch.ninecode.model.WirePosition WirePosition]] All positions of single wires (phase or neutral) making the conductor.
 * @group AssetInfo
 * @groupname AssetInfo Package AssetInfo
 * @groupdesc AssetInfo This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses. They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 */
final case class WireSpacingInfo
(
    AssetInfo: AssetInfo = null,
    isCable: Boolean = false,
    phaseWireCount: Int = 0,
    phaseWireSpacing: Double = 0.0,
    usage: String = null,
    ACLineSegment: List[String] = null,
    DuctBank: String = null,
    Structures: List[String] = null,
    WirePositions: List[String] = null
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
    override def sup: AssetInfo = AssetInfo

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
        implicit val clz: String = WireSpacingInfo.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(WireSpacingInfo.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(WireSpacingInfo.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(WireSpacingInfo.fields(position), x))

        emitelem(0, isCable)
        emitelem(1, phaseWireCount)
        emitelem(2, phaseWireSpacing)
        emitattr(3, usage)
        emitattrs(4, ACLineSegment)
        emitattr(5, DuctBank)
        emitattrs(6, Structures)
        emitattrs(7, WirePositions)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:WireSpacingInfo rdf:%s=\"%s\">\n%s\t</cim:WireSpacingInfo>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object WireSpacingInfo
    extends
        CIMParseable[WireSpacingInfo]
{
    override val fields: Array[String] = Array[String](
        "isCable",
        "phaseWireCount",
        "phaseWireSpacing",
        "usage",
        "ACLineSegment",
        "DuctBank",
        "Structures",
        "WirePositions"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("ACLineSegment", "ACLineSegment", "0..*", "0..1"),
        CIMRelationship("DuctBank", "DuctBank", "0..1", "0..*"),
        CIMRelationship("Structures", "Structure", "0..*", "0..*"),
        CIMRelationship("WirePositions", "WirePosition", "1..*", "0..1")
    )
    val isCable: Fielder = parse_element(element(cls, fields(0)))
    val phaseWireCount: Fielder = parse_element(element(cls, fields(1)))
    val phaseWireSpacing: Fielder = parse_element(element(cls, fields(2)))
    val usage: Fielder = parse_attribute(attribute(cls, fields(3)))
    val ACLineSegment: FielderMultiple = parse_attributes(attribute(cls, fields(4)))
    val DuctBank: Fielder = parse_attribute(attribute(cls, fields(5)))
    val Structures: FielderMultiple = parse_attributes(attribute(cls, fields(6)))
    val WirePositions: FielderMultiple = parse_attributes(attribute(cls, fields(7)))

    def parse (context: CIMContext): WireSpacingInfo =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = WireSpacingInfo(
            AssetInfo.parse(context),
            toBoolean(mask(isCable(), 0)),
            toInteger(mask(phaseWireCount(), 1)),
            toDouble(mask(phaseWireSpacing(), 2)),
            mask(usage(), 3),
            masks(ACLineSegment(), 4),
            mask(DuctBank(), 5),
            masks(Structures(), 6),
            masks(WirePositions(), 7)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[WireSpacingInfo] = WireSpacingInfoSerializer
}

object WireSpacingInfoSerializer extends CIMSerializer[WireSpacingInfo]
{
    def write (kryo: Kryo, output: Output, obj: WireSpacingInfo): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeBoolean(obj.isCable),
            () => output.writeInt(obj.phaseWireCount),
            () => output.writeDouble(obj.phaseWireSpacing),
            () => output.writeString(obj.usage),
            () => writeList(obj.ACLineSegment, output),
            () => output.writeString(obj.DuctBank),
            () => writeList(obj.Structures, output),
            () => writeList(obj.WirePositions, output)
        )
        AssetInfoSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[WireSpacingInfo]): WireSpacingInfo =
    {
        val parent = AssetInfoSerializer.read(kryo, input, classOf[AssetInfo])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = WireSpacingInfo(
            parent,
            if (isSet(0)) input.readBoolean else false,
            if (isSet(1)) input.readInt else 0,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readString else null,
            if (isSet(4)) readList(input) else null,
            if (isSet(5)) input.readString else null,
            if (isSet(6)) readList(input) else null,
            if (isSet(7)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _AssetInfo
{
    def register: List[CIMClassInfo] =
    {
        List(
            BusbarSectionInfo.register,
            BushingInfo.register,
            CableInfo.register,
            ConcentricNeutralCableInfo.register,
            InterrupterUnitInfo.register,
            NoLoadTest.register,
            OpenCircuitTest.register,
            OperatingMechanismInfo.register,
            OverheadWireInfo.register,
            PowerTransformerInfo.register,
            ShortCircuitTest.register,
            ShuntCompensatorInfo.register,
            SwitchInfo.register,
            TapChangerInfo.register,
            TapeShieldCableInfo.register,
            TransformerEndInfo.register,
            TransformerTankInfo.register,
            TransformerTest.register,
            WireAssemblyInfo.register,
            WireInfo.register,
            WirePhaseInfo.register,
            WirePosition.register,
            WireSpacingInfo.register
        )
    }
}
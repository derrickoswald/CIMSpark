package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship
import ch.ninecode.cim.CIMSerializer

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class ADSInstructionTypeCommitment
(
    Element: BasicElement = null,
    SHUT_DOWN: String = null,
    START_UP: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ADSInstructionTypeCommitment.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ADSInstructionTypeCommitment.fields (position), value)
        emitattr (0, SHUT_DOWN)
        emitattr (1, START_UP)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ADSInstructionTypeCommitment rdf:ID=\"%s\">\n%s\t</cim:ADSInstructionTypeCommitment>".format (id, export_fields)
    }
}

object ADSInstructionTypeCommitment
extends
    CIMParseable[ADSInstructionTypeCommitment]
{
    override val fields: Array[String] = Array[String] (
        "SHUT_DOWN",
        "START_UP"
    )
    val SHUT_DOWN: Fielder = parse_attribute (attribute (cls, fields(0)))
    val START_UP: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): ADSInstructionTypeCommitment =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ADSInstructionTypeCommitment (
            BasicElement.parse (context),
            mask (SHUT_DOWN (), 0),
            mask (START_UP (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object ADSInstructionTypeCommitmentSerializer extends CIMSerializer[ADSInstructionTypeCommitment]
{
    def write (kryo: Kryo, output: Output, obj: ADSInstructionTypeCommitment): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.SHUT_DOWN),
            () => output.writeString (obj.START_UP)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ADSInstructionTypeCommitment]): ADSInstructionTypeCommitment =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ADSInstructionTypeCommitment (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * MIN_CONSTRAINT
 * MAX_CONSTRAINT
 *
 * FIXED_CONSTRAINT
 *
 * @param Element Reference to the superclass object.
 * @param FIXED_CONSTRAINT <em>undocumented</em>
 * @param MAX_CONSTRAINT <em>undocumented</em>
 * @param MIN_CONSTRAINT <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class ADSInstructionTypeOOS
(
    Element: BasicElement = null,
    FIXED_CONSTRAINT: String = null,
    MAX_CONSTRAINT: String = null,
    MIN_CONSTRAINT: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ADSInstructionTypeOOS.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ADSInstructionTypeOOS.fields (position), value)
        emitattr (0, FIXED_CONSTRAINT)
        emitattr (1, MAX_CONSTRAINT)
        emitattr (2, MIN_CONSTRAINT)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ADSInstructionTypeOOS rdf:ID=\"%s\">\n%s\t</cim:ADSInstructionTypeOOS>".format (id, export_fields)
    }
}

object ADSInstructionTypeOOS
extends
    CIMParseable[ADSInstructionTypeOOS]
{
    override val fields: Array[String] = Array[String] (
        "FIXED_CONSTRAINT",
        "MAX_CONSTRAINT",
        "MIN_CONSTRAINT"
    )
    val FIXED_CONSTRAINT: Fielder = parse_attribute (attribute (cls, fields(0)))
    val MAX_CONSTRAINT: Fielder = parse_attribute (attribute (cls, fields(1)))
    val MIN_CONSTRAINT: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): ADSInstructionTypeOOS =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ADSInstructionTypeOOS (
            BasicElement.parse (context),
            mask (FIXED_CONSTRAINT (), 0),
            mask (MAX_CONSTRAINT (), 1),
            mask (MIN_CONSTRAINT (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

object ADSInstructionTypeOOSSerializer extends CIMSerializer[ADSInstructionTypeOOS]
{
    def write (kryo: Kryo, output: Output, obj: ADSInstructionTypeOOS): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.FIXED_CONSTRAINT),
            () => output.writeString (obj.MAX_CONSTRAINT),
            () => output.writeString (obj.MIN_CONSTRAINT)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ADSInstructionTypeOOS]): ADSInstructionTypeOOS =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ADSInstructionTypeOOS (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * BASELI NE
 *
 * NEGOTIATED
 *
 * @param Element Reference to the superclass object.
 * @param BASELINE <em>undocumented</em>
 * @param NEGOTIATED <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class AdderType
(
    Element: BasicElement = null,
    BASELINE: String = null,
    NEGOTIATED: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AdderType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AdderType.fields (position), value)
        emitattr (0, BASELINE)
        emitattr (1, NEGOTIATED)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AdderType rdf:ID=\"%s\">\n%s\t</cim:AdderType>".format (id, export_fields)
    }
}

object AdderType
extends
    CIMParseable[AdderType]
{
    override val fields: Array[String] = Array[String] (
        "BASELINE",
        "NEGOTIATED"
    )
    val BASELINE: Fielder = parse_attribute (attribute (cls, fields(0)))
    val NEGOTIATED: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): AdderType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AdderType (
            BasicElement.parse (context),
            mask (BASELINE (), 0),
            mask (NEGOTIATED (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object AdderTypeSerializer extends CIMSerializer[AdderType]
{
    def write (kryo: Kryo, output: Output, obj: AdderType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.BASELINE),
            () => output.writeString (obj.NEGOTIATED)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AdderType]): AdderType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AdderType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class AlarmDisplayType
(
    Element: BasicElement = null,
    Appear: String = null,
    Disappear: String = null,
    Fleeting: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AlarmDisplayType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AlarmDisplayType.fields (position), value)
        emitattr (0, Appear)
        emitattr (1, Disappear)
        emitattr (2, Fleeting)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AlarmDisplayType rdf:ID=\"%s\">\n%s\t</cim:AlarmDisplayType>".format (id, export_fields)
    }
}

object AlarmDisplayType
extends
    CIMParseable[AlarmDisplayType]
{
    override val fields: Array[String] = Array[String] (
        "Appear",
        "Disappear",
        "Fleeting"
    )
    val Appear: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Disappear: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Fleeting: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): AlarmDisplayType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AlarmDisplayType (
            BasicElement.parse (context),
            mask (Appear (), 0),
            mask (Disappear (), 1),
            mask (Fleeting (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

object AlarmDisplayTypeSerializer extends CIMSerializer[AlarmDisplayType]
{
    def write (kryo: Kryo, output: Output, obj: AlarmDisplayType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.Appear),
            () => output.writeString (obj.Disappear),
            () => output.writeString (obj.Fleeting)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AlarmDisplayType]): AlarmDisplayType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AlarmDisplayType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class AllocationEnergyTypeCode
(
    Element: BasicElement = null,
    ACNG: String = null,
    BS: String = null,
    DAPE: String = null,
    DASE: String = null,
    ESRT: String = null,
    ESYS: String = null,
    ETC: String = null,
    HASE: String = null,
    LMPM: String = null,
    MINL: String = null,
    MLE: String = null,
    MSSLFE: String = null,
    OE: String = null,
    OTHER: String = null,
    OVGN: String = null,
    PE: String = null,
    RCNG: String = null,
    RE: String = null,
    RED: String = null,
    RMRD: String = null,
    RMRH: String = null,
    RMRR: String = null,
    RMRS: String = null,
    RMRT: String = null,
    RSYS: String = null,
    RTSSE: String = null,
    SDWN: String = null,
    SE: String = null,
    SLIC: String = null,
    SRE: String = null,
    STRT: String = null,
    SUMR: String = null,
    TCNG: String = null,
    TEST: String = null,
    TOR: String = null,
    VS: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AllocationEnergyTypeCode.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AllocationEnergyTypeCode.fields (position), value)
        emitattr (0, ACNG)
        emitattr (1, BS)
        emitattr (2, DAPE)
        emitattr (3, DASE)
        emitattr (4, ESRT)
        emitattr (5, ESYS)
        emitattr (6, ETC)
        emitattr (7, HASE)
        emitattr (8, LMPM)
        emitattr (9, MINL)
        emitattr (10, MLE)
        emitattr (11, MSSLFE)
        emitattr (12, OE)
        emitattr (13, OTHER)
        emitattr (14, OVGN)
        emitattr (15, PE)
        emitattr (16, RCNG)
        emitattr (17, RE)
        emitattr (18, RED)
        emitattr (19, RMRD)
        emitattr (20, RMRH)
        emitattr (21, RMRR)
        emitattr (22, RMRS)
        emitattr (23, RMRT)
        emitattr (24, RSYS)
        emitattr (25, RTSSE)
        emitattr (26, SDWN)
        emitattr (27, SE)
        emitattr (28, SLIC)
        emitattr (29, SRE)
        emitattr (30, STRT)
        emitattr (31, SUMR)
        emitattr (32, TCNG)
        emitattr (33, TEST)
        emitattr (34, TOR)
        emitattr (35, VS)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AllocationEnergyTypeCode rdf:ID=\"%s\">\n%s\t</cim:AllocationEnergyTypeCode>".format (id, export_fields)
    }
}

object AllocationEnergyTypeCode
extends
    CIMParseable[AllocationEnergyTypeCode]
{
    override val fields: Array[String] = Array[String] (
        "ACNG",
        "BS",
        "DAPE",
        "DASE",
        "ESRT",
        "ESYS",
        "ETC",
        "HASE",
        "LMPM",
        "MINL",
        "MLE",
        "MSSLFE",
        "OE",
        "OTHER",
        "OVGN",
        "PE",
        "RCNG",
        "RE",
        "RED",
        "RMRD",
        "RMRH",
        "RMRR",
        "RMRS",
        "RMRT",
        "RSYS",
        "RTSSE",
        "SDWN",
        "SE",
        "SLIC",
        "SRE",
        "STRT",
        "SUMR",
        "TCNG",
        "TEST",
        "TOR",
        "VS"
    )
    val ACNG: Fielder = parse_attribute (attribute (cls, fields(0)))
    val BS: Fielder = parse_attribute (attribute (cls, fields(1)))
    val DAPE: Fielder = parse_attribute (attribute (cls, fields(2)))
    val DASE: Fielder = parse_attribute (attribute (cls, fields(3)))
    val ESRT: Fielder = parse_attribute (attribute (cls, fields(4)))
    val ESYS: Fielder = parse_attribute (attribute (cls, fields(5)))
    val ETC: Fielder = parse_attribute (attribute (cls, fields(6)))
    val HASE: Fielder = parse_attribute (attribute (cls, fields(7)))
    val LMPM: Fielder = parse_attribute (attribute (cls, fields(8)))
    val MINL: Fielder = parse_attribute (attribute (cls, fields(9)))
    val MLE: Fielder = parse_attribute (attribute (cls, fields(10)))
    val MSSLFE: Fielder = parse_attribute (attribute (cls, fields(11)))
    val OE: Fielder = parse_attribute (attribute (cls, fields(12)))
    val OTHER: Fielder = parse_attribute (attribute (cls, fields(13)))
    val OVGN: Fielder = parse_attribute (attribute (cls, fields(14)))
    val PE: Fielder = parse_attribute (attribute (cls, fields(15)))
    val RCNG: Fielder = parse_attribute (attribute (cls, fields(16)))
    val RE: Fielder = parse_attribute (attribute (cls, fields(17)))
    val RED: Fielder = parse_attribute (attribute (cls, fields(18)))
    val RMRD: Fielder = parse_attribute (attribute (cls, fields(19)))
    val RMRH: Fielder = parse_attribute (attribute (cls, fields(20)))
    val RMRR: Fielder = parse_attribute (attribute (cls, fields(21)))
    val RMRS: Fielder = parse_attribute (attribute (cls, fields(22)))
    val RMRT: Fielder = parse_attribute (attribute (cls, fields(23)))
    val RSYS: Fielder = parse_attribute (attribute (cls, fields(24)))
    val RTSSE: Fielder = parse_attribute (attribute (cls, fields(25)))
    val SDWN: Fielder = parse_attribute (attribute (cls, fields(26)))
    val SE: Fielder = parse_attribute (attribute (cls, fields(27)))
    val SLIC: Fielder = parse_attribute (attribute (cls, fields(28)))
    val SRE: Fielder = parse_attribute (attribute (cls, fields(29)))
    val STRT: Fielder = parse_attribute (attribute (cls, fields(30)))
    val SUMR: Fielder = parse_attribute (attribute (cls, fields(31)))
    val TCNG: Fielder = parse_attribute (attribute (cls, fields(32)))
    val TEST: Fielder = parse_attribute (attribute (cls, fields(33)))
    val TOR: Fielder = parse_attribute (attribute (cls, fields(34)))
    val VS: Fielder = parse_attribute (attribute (cls, fields(35)))

    def parse (context: CIMContext): AllocationEnergyTypeCode =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0,0)
        val ret = AllocationEnergyTypeCode (
            BasicElement.parse (context),
            mask (ACNG (), 0),
            mask (BS (), 1),
            mask (DAPE (), 2),
            mask (DASE (), 3),
            mask (ESRT (), 4),
            mask (ESYS (), 5),
            mask (ETC (), 6),
            mask (HASE (), 7),
            mask (LMPM (), 8),
            mask (MINL (), 9),
            mask (MLE (), 10),
            mask (MSSLFE (), 11),
            mask (OE (), 12),
            mask (OTHER (), 13),
            mask (OVGN (), 14),
            mask (PE (), 15),
            mask (RCNG (), 16),
            mask (RE (), 17),
            mask (RED (), 18),
            mask (RMRD (), 19),
            mask (RMRH (), 20),
            mask (RMRR (), 21),
            mask (RMRS (), 22),
            mask (RMRT (), 23),
            mask (RSYS (), 24),
            mask (RTSSE (), 25),
            mask (SDWN (), 26),
            mask (SE (), 27),
            mask (SLIC (), 28),
            mask (SRE (), 29),
            mask (STRT (), 30),
            mask (SUMR (), 31),
            mask (TCNG (), 32),
            mask (TEST (), 33),
            mask (TOR (), 34),
            mask (VS (), 35)
        )
        ret.bitfields = bitfields
        ret
    }
}

object AllocationEnergyTypeCodeSerializer extends CIMSerializer[AllocationEnergyTypeCode]
{
    def write (kryo: Kryo, output: Output, obj: AllocationEnergyTypeCode): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.ACNG),
            () => output.writeString (obj.BS),
            () => output.writeString (obj.DAPE),
            () => output.writeString (obj.DASE),
            () => output.writeString (obj.ESRT),
            () => output.writeString (obj.ESYS),
            () => output.writeString (obj.ETC),
            () => output.writeString (obj.HASE),
            () => output.writeString (obj.LMPM),
            () => output.writeString (obj.MINL),
            () => output.writeString (obj.MLE),
            () => output.writeString (obj.MSSLFE),
            () => output.writeString (obj.OE),
            () => output.writeString (obj.OTHER),
            () => output.writeString (obj.OVGN),
            () => output.writeString (obj.PE),
            () => output.writeString (obj.RCNG),
            () => output.writeString (obj.RE),
            () => output.writeString (obj.RED),
            () => output.writeString (obj.RMRD),
            () => output.writeString (obj.RMRH),
            () => output.writeString (obj.RMRR),
            () => output.writeString (obj.RMRS),
            () => output.writeString (obj.RMRT),
            () => output.writeString (obj.RSYS),
            () => output.writeString (obj.RTSSE),
            () => output.writeString (obj.SDWN),
            () => output.writeString (obj.SE),
            () => output.writeString (obj.SLIC),
            () => output.writeString (obj.SRE),
            () => output.writeString (obj.STRT),
            () => output.writeString (obj.SUMR),
            () => output.writeString (obj.TCNG),
            () => output.writeString (obj.TEST),
            () => output.writeString (obj.TOR),
            () => output.writeString (obj.VS)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AllocationEnergyTypeCode]): AllocationEnergyTypeCode =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AllocationEnergyTypeCode (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) input.readString else null,
            if (isSet (11)) input.readString else null,
            if (isSet (12)) input.readString else null,
            if (isSet (13)) input.readString else null,
            if (isSet (14)) input.readString else null,
            if (isSet (15)) input.readString else null,
            if (isSet (16)) input.readString else null,
            if (isSet (17)) input.readString else null,
            if (isSet (18)) input.readString else null,
            if (isSet (19)) input.readString else null,
            if (isSet (20)) input.readString else null,
            if (isSet (21)) input.readString else null,
            if (isSet (22)) input.readString else null,
            if (isSet (23)) input.readString else null,
            if (isSet (24)) input.readString else null,
            if (isSet (25)) input.readString else null,
            if (isSet (26)) input.readString else null,
            if (isSet (27)) input.readString else null,
            if (isSet (28)) input.readString else null,
            if (isSet (29)) input.readString else null,
            if (isSet (30)) input.readString else null,
            if (isSet (31)) input.readString else null,
            if (isSet (32)) input.readString else null,
            if (isSet (33)) input.readString else null,
            if (isSet (34)) input.readString else null,
            if (isSet (35)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * ancillary serivce types
 *
 * @param Element Reference to the superclass object.
 * @param NONSPIN non spinning reserve
 * @param REGDN regulation down
 * @param REGUP regulation up
 * @param SPIN spinning reserve
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class AncillaryCommodityType
(
    Element: BasicElement = null,
    NONSPIN: String = null,
    REGDN: String = null,
    REGUP: String = null,
    SPIN: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = AncillaryCommodityType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (AncillaryCommodityType.fields (position), value)
        emitattr (0, NONSPIN)
        emitattr (1, REGDN)
        emitattr (2, REGUP)
        emitattr (3, SPIN)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:AncillaryCommodityType rdf:ID=\"%s\">\n%s\t</cim:AncillaryCommodityType>".format (id, export_fields)
    }
}

object AncillaryCommodityType
extends
    CIMParseable[AncillaryCommodityType]
{
    override val fields: Array[String] = Array[String] (
        "NONSPIN",
        "REGDN",
        "REGUP",
        "SPIN"
    )
    val NONSPIN: Fielder = parse_attribute (attribute (cls, fields(0)))
    val REGDN: Fielder = parse_attribute (attribute (cls, fields(1)))
    val REGUP: Fielder = parse_attribute (attribute (cls, fields(2)))
    val SPIN: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): AncillaryCommodityType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = AncillaryCommodityType (
            BasicElement.parse (context),
            mask (NONSPIN (), 0),
            mask (REGDN (), 1),
            mask (REGUP (), 2),
            mask (SPIN (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

object AncillaryCommodityTypeSerializer extends CIMSerializer[AncillaryCommodityType]
{
    def write (kryo: Kryo, output: Output, obj: AncillaryCommodityType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.NONSPIN),
            () => output.writeString (obj.REGDN),
            () => output.writeString (obj.REGUP),
            () => output.writeString (obj.SPIN)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[AncillaryCommodityType]): AncillaryCommodityType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = AncillaryCommodityType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class BidPriceCapType
(
    Element: BasicElement = null,
    AS: String = null,
    ENERGY: String = null,
    RUC: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = BidPriceCapType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (BidPriceCapType.fields (position), value)
        emitattr (0, AS)
        emitattr (1, ENERGY)
        emitattr (2, RUC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BidPriceCapType rdf:ID=\"%s\">\n%s\t</cim:BidPriceCapType>".format (id, export_fields)
    }
}

object BidPriceCapType
extends
    CIMParseable[BidPriceCapType]
{
    override val fields: Array[String] = Array[String] (
        "AS",
        "ENERGY",
        "RUC"
    )
    val AS: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ENERGY: Fielder = parse_attribute (attribute (cls, fields(1)))
    val RUC: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): BidPriceCapType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = BidPriceCapType (
            BasicElement.parse (context),
            mask (AS (), 0),
            mask (ENERGY (), 1),
            mask (RUC (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

object BidPriceCapTypeSerializer extends CIMSerializer[BidPriceCapType]
{
    def write (kryo: Kryo, output: Output, obj: BidPriceCapType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.AS),
            () => output.writeString (obj.ENERGY),
            () => output.writeString (obj.RUC)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[BidPriceCapType]): BidPriceCapType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = BidPriceCapType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class CleanTradeProductType
(
    Element: BasicElement = null,
    APN: String = null,
    CPT: String = null,
    NRT: String = null,
    PHY: String = null,
    RDT: String = null,
    RUT: String = null,
    SRT: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CleanTradeProductType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CleanTradeProductType.fields (position), value)
        emitattr (0, APN)
        emitattr (1, CPT)
        emitattr (2, NRT)
        emitattr (3, PHY)
        emitattr (4, RDT)
        emitattr (5, RUT)
        emitattr (6, SRT)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CleanTradeProductType rdf:ID=\"%s\">\n%s\t</cim:CleanTradeProductType>".format (id, export_fields)
    }
}

object CleanTradeProductType
extends
    CIMParseable[CleanTradeProductType]
{
    override val fields: Array[String] = Array[String] (
        "APN",
        "CPT",
        "NRT",
        "PHY",
        "RDT",
        "RUT",
        "SRT"
    )
    val APN: Fielder = parse_attribute (attribute (cls, fields(0)))
    val CPT: Fielder = parse_attribute (attribute (cls, fields(1)))
    val NRT: Fielder = parse_attribute (attribute (cls, fields(2)))
    val PHY: Fielder = parse_attribute (attribute (cls, fields(3)))
    val RDT: Fielder = parse_attribute (attribute (cls, fields(4)))
    val RUT: Fielder = parse_attribute (attribute (cls, fields(5)))
    val SRT: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: CIMContext): CleanTradeProductType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CleanTradeProductType (
            BasicElement.parse (context),
            mask (APN (), 0),
            mask (CPT (), 1),
            mask (NRT (), 2),
            mask (PHY (), 3),
            mask (RDT (), 4),
            mask (RUT (), 5),
            mask (SRT (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

object CleanTradeProductTypeSerializer extends CIMSerializer[CleanTradeProductType]
{
    def write (kryo: Kryo, output: Output, obj: CleanTradeProductType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.APN),
            () => output.writeString (obj.CPT),
            () => output.writeString (obj.NRT),
            () => output.writeString (obj.PHY),
            () => output.writeString (obj.RDT),
            () => output.writeString (obj.RUT),
            () => output.writeString (obj.SRT)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CleanTradeProductType]): CleanTradeProductType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CleanTradeProductType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * ACTIVE
 *
 * INACTIVE
 *
 * @param Element Reference to the superclass object.
 * @param ACTIVE <em>undocumented</em>
 * @param INACTIVE <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class CurrentStatusSC
(
    Element: BasicElement = null,
    ACTIVE: String = null,
    INACTIVE: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CurrentStatusSC.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CurrentStatusSC.fields (position), value)
        emitattr (0, ACTIVE)
        emitattr (1, INACTIVE)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CurrentStatusSC rdf:ID=\"%s\">\n%s\t</cim:CurrentStatusSC>".format (id, export_fields)
    }
}

object CurrentStatusSC
extends
    CIMParseable[CurrentStatusSC]
{
    override val fields: Array[String] = Array[String] (
        "ACTIVE",
        "INACTIVE"
    )
    val ACTIVE: Fielder = parse_attribute (attribute (cls, fields(0)))
    val INACTIVE: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): CurrentStatusSC =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CurrentStatusSC (
            BasicElement.parse (context),
            mask (ACTIVE (), 0),
            mask (INACTIVE (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object CurrentStatusSCSerializer extends CIMSerializer[CurrentStatusSC]
{
    def write (kryo: Kryo, output: Output, obj: CurrentStatusSC): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.ACTIVE),
            () => output.writeString (obj.INACTIVE)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CurrentStatusSC]): CurrentStatusSC =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = CurrentStatusSC (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class DAMMarketType
(
    Element: BasicElement = null,
    DAM: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DAMMarketType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DAMMarketType.fields (position), value)
        emitattr (0, DAM)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DAMMarketType rdf:ID=\"%s\">\n%s\t</cim:DAMMarketType>".format (id, export_fields)
    }
}

object DAMMarketType
extends
    CIMParseable[DAMMarketType]
{
    override val fields: Array[String] = Array[String] (
        "DAM"
    )
    val DAM: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): DAMMarketType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DAMMarketType (
            BasicElement.parse (context),
            mask (DAM (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object DAMMarketTypeSerializer extends CIMSerializer[DAMMarketType]
{
    def write (kryo: Kryo, output: Output, obj: DAMMarketType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.DAM)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DAMMarketType]): DAMMarketType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = DAMMarketType (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class DispatchAcceptStatus
(
    Element: BasicElement = null,
    ACCEPT: String = null,
    CANNOT: String = null,
    DECLINE: String = null,
    NON_RESPONSE: String = null,
    OK: String = null,
    PARTIAL: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DispatchAcceptStatus.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DispatchAcceptStatus.fields (position), value)
        emitattr (0, ACCEPT)
        emitattr (1, CANNOT)
        emitattr (2, DECLINE)
        emitattr (3, NON_RESPONSE)
        emitattr (4, OK)
        emitattr (5, PARTIAL)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DispatchAcceptStatus rdf:ID=\"%s\">\n%s\t</cim:DispatchAcceptStatus>".format (id, export_fields)
    }
}

object DispatchAcceptStatus
extends
    CIMParseable[DispatchAcceptStatus]
{
    override val fields: Array[String] = Array[String] (
        "ACCEPT",
        "CANNOT",
        "DECLINE",
        "NON_RESPONSE",
        "OK",
        "PARTIAL"
    )
    val ACCEPT: Fielder = parse_attribute (attribute (cls, fields(0)))
    val CANNOT: Fielder = parse_attribute (attribute (cls, fields(1)))
    val DECLINE: Fielder = parse_attribute (attribute (cls, fields(2)))
    val NON_RESPONSE: Fielder = parse_attribute (attribute (cls, fields(3)))
    val OK: Fielder = parse_attribute (attribute (cls, fields(4)))
    val PARTIAL: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: CIMContext): DispatchAcceptStatus =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DispatchAcceptStatus (
            BasicElement.parse (context),
            mask (ACCEPT (), 0),
            mask (CANNOT (), 1),
            mask (DECLINE (), 2),
            mask (NON_RESPONSE (), 3),
            mask (OK (), 4),
            mask (PARTIAL (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

object DispatchAcceptStatusSerializer extends CIMSerializer[DispatchAcceptStatus]
{
    def write (kryo: Kryo, output: Output, obj: DispatchAcceptStatus): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.ACCEPT),
            () => output.writeString (obj.CANNOT),
            () => output.writeString (obj.DECLINE),
            () => output.writeString (obj.NON_RESPONSE),
            () => output.writeString (obj.OK),
            () => output.writeString (obj.PARTIAL)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DispatchAcceptStatus]): DispatchAcceptStatus =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = DispatchAcceptStatus (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class DispatchTransactionType
(
    Element: BasicElement = null,
    Purchase: String = null,
    Sale: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DispatchTransactionType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DispatchTransactionType.fields (position), value)
        emitattr (0, Purchase)
        emitattr (1, Sale)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DispatchTransactionType rdf:ID=\"%s\">\n%s\t</cim:DispatchTransactionType>".format (id, export_fields)
    }
}

object DispatchTransactionType
extends
    CIMParseable[DispatchTransactionType]
{
    override val fields: Array[String] = Array[String] (
        "Purchase",
        "Sale"
    )
    val Purchase: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Sale: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): DispatchTransactionType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DispatchTransactionType (
            BasicElement.parse (context),
            mask (Purchase (), 0),
            mask (Sale (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object DispatchTransactionTypeSerializer extends CIMSerializer[DispatchTransactionType]
{
    def write (kryo: Kryo, output: Output, obj: DispatchTransactionType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.Purchase),
            () => output.writeString (obj.Sale)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DispatchTransactionType]): DispatchTransactionType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = DispatchTransactionType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Valid Enumerations:
 * 1) DASE Day Ahead Scheduled Energy;
 * 2) DSSE Day Ahead Incremental Self Schedule Energy;
 * 3) DABE Day Ahead Incremental Energy Bid Awarded Energy;
 * 4) OE Optimal Energy;
 * 5) HASE Hour ahead pre-dispatched schedule energy;
 * 6) SRE Standard Ramping Energy;
 * 7) RED Ramping Energy Deviation;
 * 8) EDE Exceptional Dispatch energy;
 * 9) RMRE RMR Energy;
 * 10) MSSLFE MSSLF Energy;
 * 11) RE Residual Energy;
 * 12) MLE Minimum Load Energy;
 * 13) SE SLIC Energy;
 * 14) RTSSE Real time self scheduled energy;
 * 15) DMLE Day ahead minimum load energy;
 * 16) PE Pumping Energy;
 * 17) TEE Total Expected Energy;
 *
 * 18) DAPE - Day-Ahead Pumping Energy;
 *
 * @param Element Reference to the superclass object.
 * @param DABE <em>undocumented</em>
 * @param DAPE <em>undocumented</em>
 * @param DASE <em>undocumented</em>
 * @param DMLE <em>undocumented</em>
 * @param DSSE <em>undocumented</em>
 * @param EDE <em>undocumented</em>
 * @param HASE <em>undocumented</em>
 * @param MLE <em>undocumented</em>
 * @param MSSLFE <em>undocumented</em>
 * @param OE <em>undocumented</em>
 * @param PE <em>undocumented</em>
 * @param RE <em>undocumented</em>
 * @param RED <em>undocumented</em>
 * @param RMRE <em>undocumented</em>
 * @param RTSSE <em>undocumented</em>
 * @param SE <em>undocumented</em>
 * @param SRE <em>undocumented</em>
 * @param TEE <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class EnergyTypeCode
(
    Element: BasicElement = null,
    DABE: String = null,
    DAPE: String = null,
    DASE: String = null,
    DMLE: String = null,
    DSSE: String = null,
    EDE: String = null,
    HASE: String = null,
    MLE: String = null,
    MSSLFE: String = null,
    OE: String = null,
    PE: String = null,
    RE: String = null,
    RED: String = null,
    RMRE: String = null,
    RTSSE: String = null,
    SE: String = null,
    SRE: String = null,
    TEE: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = EnergyTypeCode.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (EnergyTypeCode.fields (position), value)
        emitattr (0, DABE)
        emitattr (1, DAPE)
        emitattr (2, DASE)
        emitattr (3, DMLE)
        emitattr (4, DSSE)
        emitattr (5, EDE)
        emitattr (6, HASE)
        emitattr (7, MLE)
        emitattr (8, MSSLFE)
        emitattr (9, OE)
        emitattr (10, PE)
        emitattr (11, RE)
        emitattr (12, RED)
        emitattr (13, RMRE)
        emitattr (14, RTSSE)
        emitattr (15, SE)
        emitattr (16, SRE)
        emitattr (17, TEE)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:EnergyTypeCode rdf:ID=\"%s\">\n%s\t</cim:EnergyTypeCode>".format (id, export_fields)
    }
}

object EnergyTypeCode
extends
    CIMParseable[EnergyTypeCode]
{
    override val fields: Array[String] = Array[String] (
        "DABE",
        "DAPE",
        "DASE",
        "DMLE",
        "DSSE",
        "EDE",
        "HASE",
        "MLE",
        "MSSLFE",
        "OE",
        "PE",
        "RE",
        "RED",
        "RMRE",
        "RTSSE",
        "SE",
        "SRE",
        "TEE"
    )
    val DABE: Fielder = parse_attribute (attribute (cls, fields(0)))
    val DAPE: Fielder = parse_attribute (attribute (cls, fields(1)))
    val DASE: Fielder = parse_attribute (attribute (cls, fields(2)))
    val DMLE: Fielder = parse_attribute (attribute (cls, fields(3)))
    val DSSE: Fielder = parse_attribute (attribute (cls, fields(4)))
    val EDE: Fielder = parse_attribute (attribute (cls, fields(5)))
    val HASE: Fielder = parse_attribute (attribute (cls, fields(6)))
    val MLE: Fielder = parse_attribute (attribute (cls, fields(7)))
    val MSSLFE: Fielder = parse_attribute (attribute (cls, fields(8)))
    val OE: Fielder = parse_attribute (attribute (cls, fields(9)))
    val PE: Fielder = parse_attribute (attribute (cls, fields(10)))
    val RE: Fielder = parse_attribute (attribute (cls, fields(11)))
    val RED: Fielder = parse_attribute (attribute (cls, fields(12)))
    val RMRE: Fielder = parse_attribute (attribute (cls, fields(13)))
    val RTSSE: Fielder = parse_attribute (attribute (cls, fields(14)))
    val SE: Fielder = parse_attribute (attribute (cls, fields(15)))
    val SRE: Fielder = parse_attribute (attribute (cls, fields(16)))
    val TEE: Fielder = parse_attribute (attribute (cls, fields(17)))

    def parse (context: CIMContext): EnergyTypeCode =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = EnergyTypeCode (
            BasicElement.parse (context),
            mask (DABE (), 0),
            mask (DAPE (), 1),
            mask (DASE (), 2),
            mask (DMLE (), 3),
            mask (DSSE (), 4),
            mask (EDE (), 5),
            mask (HASE (), 6),
            mask (MLE (), 7),
            mask (MSSLFE (), 8),
            mask (OE (), 9),
            mask (PE (), 10),
            mask (RE (), 11),
            mask (RED (), 12),
            mask (RMRE (), 13),
            mask (RTSSE (), 14),
            mask (SE (), 15),
            mask (SRE (), 16),
            mask (TEE (), 17)
        )
        ret.bitfields = bitfields
        ret
    }
}

object EnergyTypeCodeSerializer extends CIMSerializer[EnergyTypeCode]
{
    def write (kryo: Kryo, output: Output, obj: EnergyTypeCode): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.DABE),
            () => output.writeString (obj.DAPE),
            () => output.writeString (obj.DASE),
            () => output.writeString (obj.DMLE),
            () => output.writeString (obj.DSSE),
            () => output.writeString (obj.EDE),
            () => output.writeString (obj.HASE),
            () => output.writeString (obj.MLE),
            () => output.writeString (obj.MSSLFE),
            () => output.writeString (obj.OE),
            () => output.writeString (obj.PE),
            () => output.writeString (obj.RE),
            () => output.writeString (obj.RED),
            () => output.writeString (obj.RMRE),
            () => output.writeString (obj.RTSSE),
            () => output.writeString (obj.SE),
            () => output.writeString (obj.SRE),
            () => output.writeString (obj.TEE)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[EnergyTypeCode]): EnergyTypeCode =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = EnergyTypeCode (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) input.readString else null,
            if (isSet (11)) input.readString else null,
            if (isSet (12)) input.readString else null,
            if (isSet (13)) input.readString else null,
            if (isSet (14)) input.readString else null,
            if (isSet (15)) input.readString else null,
            if (isSet (16)) input.readString else null,
            if (isSet (17)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class JobFlagType
(
    Element: BasicElement = null,
    CREATED: String = null,
    DELETED: String = null,
    MODIFIED: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = JobFlagType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (JobFlagType.fields (position), value)
        emitattr (0, CREATED)
        emitattr (1, DELETED)
        emitattr (2, MODIFIED)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:JobFlagType rdf:ID=\"%s\">\n%s\t</cim:JobFlagType>".format (id, export_fields)
    }
}

object JobFlagType
extends
    CIMParseable[JobFlagType]
{
    override val fields: Array[String] = Array[String] (
        "CREATED",
        "DELETED",
        "MODIFIED"
    )
    val CREATED: Fielder = parse_attribute (attribute (cls, fields(0)))
    val DELETED: Fielder = parse_attribute (attribute (cls, fields(1)))
    val MODIFIED: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): JobFlagType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = JobFlagType (
            BasicElement.parse (context),
            mask (CREATED (), 0),
            mask (DELETED (), 1),
            mask (MODIFIED (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

object JobFlagTypeSerializer extends CIMSerializer[JobFlagType]
{
    def write (kryo: Kryo, output: Output, obj: JobFlagType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.CREATED),
            () => output.writeString (obj.DELETED),
            () => output.writeString (obj.MODIFIED)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[JobFlagType]): JobFlagType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = JobFlagType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class JobScheduleType
(
    Element: BasicElement = null,
    CRITICAL: String = null,
    NONCRITICAL: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = JobScheduleType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (JobScheduleType.fields (position), value)
        emitattr (0, CRITICAL)
        emitattr (1, NONCRITICAL)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:JobScheduleType rdf:ID=\"%s\">\n%s\t</cim:JobScheduleType>".format (id, export_fields)
    }
}

object JobScheduleType
extends
    CIMParseable[JobScheduleType]
{
    override val fields: Array[String] = Array[String] (
        "CRITICAL",
        "NONCRITICAL"
    )
    val CRITICAL: Fielder = parse_attribute (attribute (cls, fields(0)))
    val NONCRITICAL: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): JobScheduleType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = JobScheduleType (
            BasicElement.parse (context),
            mask (CRITICAL (), 0),
            mask (NONCRITICAL (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object JobScheduleTypeSerializer extends CIMSerializer[JobScheduleType]
{
    def write (kryo: Kryo, output: Output, obj: JobScheduleType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.CRITICAL),
            () => output.writeString (obj.NONCRITICAL)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[JobScheduleType]): JobScheduleType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = JobScheduleType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class JobStartEndType
(
    Element: BasicElement = null,
    END: String = null,
    NA: String = null,
    START: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = JobStartEndType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (JobStartEndType.fields (position), value)
        emitattr (0, END)
        emitattr (1, NA)
        emitattr (2, START)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:JobStartEndType rdf:ID=\"%s\">\n%s\t</cim:JobStartEndType>".format (id, export_fields)
    }
}

object JobStartEndType
extends
    CIMParseable[JobStartEndType]
{
    override val fields: Array[String] = Array[String] (
        "END",
        "NA",
        "START"
    )
    val END: Fielder = parse_attribute (attribute (cls, fields(0)))
    val NA: Fielder = parse_attribute (attribute (cls, fields(1)))
    val START: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): JobStartEndType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = JobStartEndType (
            BasicElement.parse (context),
            mask (END (), 0),
            mask (NA (), 1),
            mask (START (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

object JobStartEndTypeSerializer extends CIMSerializer[JobStartEndType]
{
    def write (kryo: Kryo, output: Output, obj: JobStartEndType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.END),
            () => output.writeString (obj.NA),
            () => output.writeString (obj.START)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[JobStartEndType]): JobStartEndType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = JobStartEndType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class LFCResourceType
(
    Element: BasicElement = null,
    GEN: String = null,
    PUMP: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = LFCResourceType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LFCResourceType.fields (position), value)
        emitattr (0, GEN)
        emitattr (1, PUMP)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LFCResourceType rdf:ID=\"%s\">\n%s\t</cim:LFCResourceType>".format (id, export_fields)
    }
}

object LFCResourceType
extends
    CIMParseable[LFCResourceType]
{
    override val fields: Array[String] = Array[String] (
        "GEN",
        "PUMP"
    )
    val GEN: Fielder = parse_attribute (attribute (cls, fields(0)))
    val PUMP: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): LFCResourceType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = LFCResourceType (
            BasicElement.parse (context),
            mask (GEN (), 0),
            mask (PUMP (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object LFCResourceTypeSerializer extends CIMSerializer[LFCResourceType]
{
    def write (kryo: Kryo, output: Output, obj: LFCResourceType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.GEN),
            () => output.writeString (obj.PUMP)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[LFCResourceType]): LFCResourceType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = LFCResourceType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class LoadFollowingCapacityType
(
    Element: BasicElement = null,
    DOWN: String = null,
    UP: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = LoadFollowingCapacityType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (LoadFollowingCapacityType.fields (position), value)
        emitattr (0, DOWN)
        emitattr (1, UP)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:LoadFollowingCapacityType rdf:ID=\"%s\">\n%s\t</cim:LoadFollowingCapacityType>".format (id, export_fields)
    }
}

object LoadFollowingCapacityType
extends
    CIMParseable[LoadFollowingCapacityType]
{
    override val fields: Array[String] = Array[String] (
        "DOWN",
        "UP"
    )
    val DOWN: Fielder = parse_attribute (attribute (cls, fields(0)))
    val UP: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): LoadFollowingCapacityType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = LoadFollowingCapacityType (
            BasicElement.parse (context),
            mask (DOWN (), 0),
            mask (UP (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object LoadFollowingCapacityTypeSerializer extends CIMSerializer[LoadFollowingCapacityType]
{
    def write (kryo: Kryo, output: Output, obj: LoadFollowingCapacityType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.DOWN),
            () => output.writeString (obj.UP)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[LoadFollowingCapacityType]): LoadFollowingCapacityType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = LoadFollowingCapacityType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * ADD - add
 * DEL - delete
 *
 * CHG - change
 *
 * @param Element Reference to the superclass object.
 * @param ADD <em>undocumented</em>
 * @param CHG <em>undocumented</em>
 * @param DEL <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class MQSDELType
(
    Element: BasicElement = null,
    ADD: String = null,
    CHG: String = null,
    DEL: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MQSDELType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MQSDELType.fields (position), value)
        emitattr (0, ADD)
        emitattr (1, CHG)
        emitattr (2, DEL)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MQSDELType rdf:ID=\"%s\">\n%s\t</cim:MQSDELType>".format (id, export_fields)
    }
}

object MQSDELType
extends
    CIMParseable[MQSDELType]
{
    override val fields: Array[String] = Array[String] (
        "ADD",
        "CHG",
        "DEL"
    )
    val ADD: Fielder = parse_attribute (attribute (cls, fields(0)))
    val CHG: Fielder = parse_attribute (attribute (cls, fields(1)))
    val DEL: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): MQSDELType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MQSDELType (
            BasicElement.parse (context),
            mask (ADD (), 0),
            mask (CHG (), 1),
            mask (DEL (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

object MQSDELTypeSerializer extends CIMSerializer[MQSDELType]
{
    def write (kryo: Kryo, output: Output, obj: MQSDELType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.ADD),
            () => output.writeString (obj.CHG),
            () => output.writeString (obj.DEL)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MQSDELType]): MQSDELType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MQSDELType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * RU - Regulation Up
 * RD - Regulation Down
 * SR - Spin Reserve
 * NR - Nonspin Reserve
 *
 * AS - Upward Ancillary Service
 *
 * @param Element Reference to the superclass object.
 * @param AS <em>undocumented</em>
 * @param NR non spinning reserve
 * @param RD regulation down
 * @param RU regulation up
 * @param SR spinning reserve
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class MarketProductTypeAsReq
(
    Element: BasicElement = null,
    AS: String = null,
    NR: String = null,
    RD: String = null,
    RU: String = null,
    SR: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketProductTypeAsReq.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketProductTypeAsReq.fields (position), value)
        emitattr (0, AS)
        emitattr (1, NR)
        emitattr (2, RD)
        emitattr (3, RU)
        emitattr (4, SR)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketProductTypeAsReq rdf:ID=\"%s\">\n%s\t</cim:MarketProductTypeAsReq>".format (id, export_fields)
    }
}

object MarketProductTypeAsReq
extends
    CIMParseable[MarketProductTypeAsReq]
{
    override val fields: Array[String] = Array[String] (
        "AS",
        "NR",
        "RD",
        "RU",
        "SR"
    )
    val AS: Fielder = parse_attribute (attribute (cls, fields(0)))
    val NR: Fielder = parse_attribute (attribute (cls, fields(1)))
    val RD: Fielder = parse_attribute (attribute (cls, fields(2)))
    val RU: Fielder = parse_attribute (attribute (cls, fields(3)))
    val SR: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: CIMContext): MarketProductTypeAsReq =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MarketProductTypeAsReq (
            BasicElement.parse (context),
            mask (AS (), 0),
            mask (NR (), 1),
            mask (RD (), 2),
            mask (RU (), 3),
            mask (SR (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

object MarketProductTypeAsReqSerializer extends CIMSerializer[MarketProductTypeAsReq]
{
    def write (kryo: Kryo, output: Output, obj: MarketProductTypeAsReq): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.AS),
            () => output.writeString (obj.NR),
            () => output.writeString (obj.RD),
            () => output.writeString (obj.RU),
            () => output.writeString (obj.SR)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MarketProductTypeAsReq]): MarketProductTypeAsReq =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MarketProductTypeAsReq (
            parent,
            if (isSet (0)) input.readString else null,
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
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class MarketScheduleServices
(
    Element: BasicElement = null,
    retrieveDefaultBidCurves: String = null,
    retrieveMPMResults: String = null,
    retrieveMarketAwards: String = null,
    retrieveSchedulePrices: String = null,
    retrieveStartUpShutDownInstructions: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketScheduleServices.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketScheduleServices.fields (position), value)
        emitattr (0, retrieveDefaultBidCurves)
        emitattr (1, retrieveMPMResults)
        emitattr (2, retrieveMarketAwards)
        emitattr (3, retrieveSchedulePrices)
        emitattr (4, retrieveStartUpShutDownInstructions)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketScheduleServices rdf:ID=\"%s\">\n%s\t</cim:MarketScheduleServices>".format (id, export_fields)
    }
}

object MarketScheduleServices
extends
    CIMParseable[MarketScheduleServices]
{
    override val fields: Array[String] = Array[String] (
        "retrieveDefaultBidCurves",
        "retrieveMPMResults",
        "retrieveMarketAwards",
        "retrieveSchedulePrices",
        "retrieveStartUpShutDownInstructions"
    )
    val retrieveDefaultBidCurves: Fielder = parse_attribute (attribute (cls, fields(0)))
    val retrieveMPMResults: Fielder = parse_attribute (attribute (cls, fields(1)))
    val retrieveMarketAwards: Fielder = parse_attribute (attribute (cls, fields(2)))
    val retrieveSchedulePrices: Fielder = parse_attribute (attribute (cls, fields(3)))
    val retrieveStartUpShutDownInstructions: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: CIMContext): MarketScheduleServices =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MarketScheduleServices (
            BasicElement.parse (context),
            mask (retrieveDefaultBidCurves (), 0),
            mask (retrieveMPMResults (), 1),
            mask (retrieveMarketAwards (), 2),
            mask (retrieveSchedulePrices (), 3),
            mask (retrieveStartUpShutDownInstructions (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

object MarketScheduleServicesSerializer extends CIMSerializer[MarketScheduleServices]
{
    def write (kryo: Kryo, output: Output, obj: MarketScheduleServices): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.retrieveDefaultBidCurves),
            () => output.writeString (obj.retrieveMPMResults),
            () => output.writeString (obj.retrieveMarketAwards),
            () => output.writeString (obj.retrieveSchedulePrices),
            () => output.writeString (obj.retrieveStartUpShutDownInstructions)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MarketScheduleServices]): MarketScheduleServices =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MarketScheduleServices (
            parent,
            if (isSet (0)) input.readString else null,
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
 * Description of market statement
 *
 * @param Element Reference to the superclass object.
 * @param DAILY_INITIAL_CREDIT <em>undocumented</em>
 * @param DAILY_INITIAL_MARKET <em>undocumented</em>
 * @param DAILY_RECALC_MARKET <em>undocumented</em>
 * @param MONTHLY_INITIAL_MARKET <em>undocumented</em>
 * @param MONTHLY_RECALC_MARKET <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class MarketStatementDescription
(
    Element: BasicElement = null,
    DAILY_INITIAL_CREDIT: String = null,
    DAILY_INITIAL_MARKET: String = null,
    DAILY_RECALC_MARKET: String = null,
    MONTHLY_INITIAL_MARKET: String = null,
    MONTHLY_RECALC_MARKET: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketStatementDescription.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketStatementDescription.fields (position), value)
        emitattr (0, DAILY_INITIAL_CREDIT)
        emitattr (1, DAILY_INITIAL_MARKET)
        emitattr (2, DAILY_RECALC_MARKET)
        emitattr (3, MONTHLY_INITIAL_MARKET)
        emitattr (4, MONTHLY_RECALC_MARKET)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketStatementDescription rdf:ID=\"%s\">\n%s\t</cim:MarketStatementDescription>".format (id, export_fields)
    }
}

object MarketStatementDescription
extends
    CIMParseable[MarketStatementDescription]
{
    override val fields: Array[String] = Array[String] (
        "DAILY_INITIAL_CREDIT",
        "DAILY_INITIAL_MARKET",
        "DAILY_RECALC_MARKET",
        "MONTHLY_INITIAL_MARKET",
        "MONTHLY_RECALC_MARKET"
    )
    val DAILY_INITIAL_CREDIT: Fielder = parse_attribute (attribute (cls, fields(0)))
    val DAILY_INITIAL_MARKET: Fielder = parse_attribute (attribute (cls, fields(1)))
    val DAILY_RECALC_MARKET: Fielder = parse_attribute (attribute (cls, fields(2)))
    val MONTHLY_INITIAL_MARKET: Fielder = parse_attribute (attribute (cls, fields(3)))
    val MONTHLY_RECALC_MARKET: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: CIMContext): MarketStatementDescription =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MarketStatementDescription (
            BasicElement.parse (context),
            mask (DAILY_INITIAL_CREDIT (), 0),
            mask (DAILY_INITIAL_MARKET (), 1),
            mask (DAILY_RECALC_MARKET (), 2),
            mask (MONTHLY_INITIAL_MARKET (), 3),
            mask (MONTHLY_RECALC_MARKET (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

object MarketStatementDescriptionSerializer extends CIMSerializer[MarketStatementDescription]
{
    def write (kryo: Kryo, output: Output, obj: MarketStatementDescription): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.DAILY_INITIAL_CREDIT),
            () => output.writeString (obj.DAILY_INITIAL_MARKET),
            () => output.writeString (obj.DAILY_RECALC_MARKET),
            () => output.writeString (obj.MONTHLY_INITIAL_MARKET),
            () => output.writeString (obj.MONTHLY_RECALC_MARKET)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MarketStatementDescription]): MarketStatementDescription =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MarketStatementDescription (
            parent,
            if (isSet (0)) input.readString else null,
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
 * market statement document status
 *
 * @param Element Reference to the superclass object.
 * @param APPROVED <em>undocumented</em>
 * @param CANCELLED <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class MarketStatementDocStatus
(
    Element: BasicElement = null,
    APPROVED: String = null,
    CANCELLED: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketStatementDocStatus.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketStatementDocStatus.fields (position), value)
        emitattr (0, APPROVED)
        emitattr (1, CANCELLED)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketStatementDocStatus rdf:ID=\"%s\">\n%s\t</cim:MarketStatementDocStatus>".format (id, export_fields)
    }
}

object MarketStatementDocStatus
extends
    CIMParseable[MarketStatementDocStatus]
{
    override val fields: Array[String] = Array[String] (
        "APPROVED",
        "CANCELLED"
    )
    val APPROVED: Fielder = parse_attribute (attribute (cls, fields(0)))
    val CANCELLED: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): MarketStatementDocStatus =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MarketStatementDocStatus (
            BasicElement.parse (context),
            mask (APPROVED (), 0),
            mask (CANCELLED (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object MarketStatementDocStatusSerializer extends CIMSerializer[MarketStatementDocStatus]
{
    def write (kryo: Kryo, output: Output, obj: MarketStatementDocStatus): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.APPROVED),
            () => output.writeString (obj.CANCELLED)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MarketStatementDocStatus]): MarketStatementDocStatus =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MarketStatementDocStatus (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * market statement document type
 *
 * @param Element Reference to the superclass object.
 * @param CREDIT <em>undocumented</em>
 * @param MARKET_INITIAL <em>undocumented</em>
 * @param MARKET_RECALC <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class MarketStatementDocType
(
    Element: BasicElement = null,
    CREDIT: String = null,
    MARKET_INITIAL: String = null,
    MARKET_RECALC: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketStatementDocType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketStatementDocType.fields (position), value)
        emitattr (0, CREDIT)
        emitattr (1, MARKET_INITIAL)
        emitattr (2, MARKET_RECALC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketStatementDocType rdf:ID=\"%s\">\n%s\t</cim:MarketStatementDocType>".format (id, export_fields)
    }
}

object MarketStatementDocType
extends
    CIMParseable[MarketStatementDocType]
{
    override val fields: Array[String] = Array[String] (
        "CREDIT",
        "MARKET_INITIAL",
        "MARKET_RECALC"
    )
    val CREDIT: Fielder = parse_attribute (attribute (cls, fields(0)))
    val MARKET_INITIAL: Fielder = parse_attribute (attribute (cls, fields(1)))
    val MARKET_RECALC: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): MarketStatementDocType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MarketStatementDocType (
            BasicElement.parse (context),
            mask (CREDIT (), 0),
            mask (MARKET_INITIAL (), 1),
            mask (MARKET_RECALC (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

object MarketStatementDocTypeSerializer extends CIMSerializer[MarketStatementDocType]
{
    def write (kryo: Kryo, output: Output, obj: MarketStatementDocType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.CREDIT),
            () => output.writeString (obj.MARKET_INITIAL),
            () => output.writeString (obj.MARKET_RECALC)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MarketStatementDocType]): MarketStatementDocType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MarketStatementDocType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * market statement line item alias name
 *
 * @param Element Reference to the superclass object.
 * @param CHARGE_CODE_INTERVAL_DETAIL <em>undocumented</em>
 * @param CHARGE_CODE_INTERVAL_TOTAL <em>undocumented</em>
 * @param CHARGE_CODE_SUMMARY <em>undocumented</em>
 * @param CHARGE_GROUP <em>undocumented</em>
 * @param PARENT_CHARGE_GROUP <em>undocumented</em>
 * @param TRADE_DATE <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class MarketStatementLineItemAliasName
(
    Element: BasicElement = null,
    CHARGE_CODE_INTERVAL_DETAIL: String = null,
    CHARGE_CODE_INTERVAL_TOTAL: String = null,
    CHARGE_CODE_SUMMARY: String = null,
    CHARGE_GROUP: String = null,
    PARENT_CHARGE_GROUP: String = null,
    TRADE_DATE: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MarketStatementLineItemAliasName.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MarketStatementLineItemAliasName.fields (position), value)
        emitattr (0, CHARGE_CODE_INTERVAL_DETAIL)
        emitattr (1, CHARGE_CODE_INTERVAL_TOTAL)
        emitattr (2, CHARGE_CODE_SUMMARY)
        emitattr (3, CHARGE_GROUP)
        emitattr (4, PARENT_CHARGE_GROUP)
        emitattr (5, TRADE_DATE)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MarketStatementLineItemAliasName rdf:ID=\"%s\">\n%s\t</cim:MarketStatementLineItemAliasName>".format (id, export_fields)
    }
}

object MarketStatementLineItemAliasName
extends
    CIMParseable[MarketStatementLineItemAliasName]
{
    override val fields: Array[String] = Array[String] (
        "CHARGE_CODE_INTERVAL_DETAIL",
        "CHARGE_CODE_INTERVAL_TOTAL",
        "CHARGE_CODE_SUMMARY",
        "CHARGE_GROUP",
        "PARENT_CHARGE_GROUP",
        "TRADE_DATE"
    )
    val CHARGE_CODE_INTERVAL_DETAIL: Fielder = parse_attribute (attribute (cls, fields(0)))
    val CHARGE_CODE_INTERVAL_TOTAL: Fielder = parse_attribute (attribute (cls, fields(1)))
    val CHARGE_CODE_SUMMARY: Fielder = parse_attribute (attribute (cls, fields(2)))
    val CHARGE_GROUP: Fielder = parse_attribute (attribute (cls, fields(3)))
    val PARENT_CHARGE_GROUP: Fielder = parse_attribute (attribute (cls, fields(4)))
    val TRADE_DATE: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: CIMContext): MarketStatementLineItemAliasName =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MarketStatementLineItemAliasName (
            BasicElement.parse (context),
            mask (CHARGE_CODE_INTERVAL_DETAIL (), 0),
            mask (CHARGE_CODE_INTERVAL_TOTAL (), 1),
            mask (CHARGE_CODE_SUMMARY (), 2),
            mask (CHARGE_GROUP (), 3),
            mask (PARENT_CHARGE_GROUP (), 4),
            mask (TRADE_DATE (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

object MarketStatementLineItemAliasNameSerializer extends CIMSerializer[MarketStatementLineItemAliasName]
{
    def write (kryo: Kryo, output: Output, obj: MarketStatementLineItemAliasName): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.CHARGE_CODE_INTERVAL_DETAIL),
            () => output.writeString (obj.CHARGE_CODE_INTERVAL_TOTAL),
            () => output.writeString (obj.CHARGE_CODE_SUMMARY),
            () => output.writeString (obj.CHARGE_GROUP),
            () => output.writeString (obj.PARENT_CHARGE_GROUP),
            () => output.writeString (obj.TRADE_DATE)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MarketStatementLineItemAliasName]): MarketStatementLineItemAliasName =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MarketStatementLineItemAliasName (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Path Flow - PF
 * Path Inflow Limit - PIL
 * Path Inflow Available Limit - PIAL
 * Path Inflow Armed Limit - PIML
 * Path Outflow Limit - POL
 * Path Outflow Available Limit - POAL
 * Path Outflow Armed Limit - OARL
 * Generation Output - GO
 * Generation Max Operating Limit - GMOL
 * Generation Min Operating Limit - GNOL
 * Generation Regulation - GR
 * Generation Status - GS
 * Pump Production - PP
 * System Load - SL
 * System ACE - ACE
 *
 * System INADV - INADV
 *
 * @param Element Reference to the superclass object.
 * @param ACE <em>undocumented</em>
 * @param GMOL <em>undocumented</em>
 * @param GNOL <em>undocumented</em>
 * @param GO <em>undocumented</em>
 * @param GR <em>undocumented</em>
 * @param GS <em>undocumented</em>
 * @param INADV <em>undocumented</em>
 * @param OARL <em>undocumented</em>
 * @param PF <em>undocumented</em>
 * @param PIAL <em>undocumented</em>
 * @param PIL <em>undocumented</em>
 * @param PIML <em>undocumented</em>
 * @param POAL <em>undocumented</em>
 * @param POL <em>undocumented</em>
 * @param PP <em>undocumented</em>
 * @param SL <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class MeasurementTypeEMS
(
    Element: BasicElement = null,
    ACE: String = null,
    GMOL: String = null,
    GNOL: String = null,
    GO: String = null,
    GR: String = null,
    GS: String = null,
    INADV: String = null,
    OARL: String = null,
    PF: String = null,
    PIAL: String = null,
    PIL: String = null,
    PIML: String = null,
    POAL: String = null,
    POL: String = null,
    PP: String = null,
    SL: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MeasurementTypeEMS.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MeasurementTypeEMS.fields (position), value)
        emitattr (0, ACE)
        emitattr (1, GMOL)
        emitattr (2, GNOL)
        emitattr (3, GO)
        emitattr (4, GR)
        emitattr (5, GS)
        emitattr (6, INADV)
        emitattr (7, OARL)
        emitattr (8, PF)
        emitattr (9, PIAL)
        emitattr (10, PIL)
        emitattr (11, PIML)
        emitattr (12, POAL)
        emitattr (13, POL)
        emitattr (14, PP)
        emitattr (15, SL)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MeasurementTypeEMS rdf:ID=\"%s\">\n%s\t</cim:MeasurementTypeEMS>".format (id, export_fields)
    }
}

object MeasurementTypeEMS
extends
    CIMParseable[MeasurementTypeEMS]
{
    override val fields: Array[String] = Array[String] (
        "ACE",
        "GMOL",
        "GNOL",
        "GO",
        "GR",
        "GS",
        "INADV",
        "OARL",
        "PF",
        "PIAL",
        "PIL",
        "PIML",
        "POAL",
        "POL",
        "PP",
        "SL"
    )
    val ACE: Fielder = parse_attribute (attribute (cls, fields(0)))
    val GMOL: Fielder = parse_attribute (attribute (cls, fields(1)))
    val GNOL: Fielder = parse_attribute (attribute (cls, fields(2)))
    val GO: Fielder = parse_attribute (attribute (cls, fields(3)))
    val GR: Fielder = parse_attribute (attribute (cls, fields(4)))
    val GS: Fielder = parse_attribute (attribute (cls, fields(5)))
    val INADV: Fielder = parse_attribute (attribute (cls, fields(6)))
    val OARL: Fielder = parse_attribute (attribute (cls, fields(7)))
    val PF: Fielder = parse_attribute (attribute (cls, fields(8)))
    val PIAL: Fielder = parse_attribute (attribute (cls, fields(9)))
    val PIL: Fielder = parse_attribute (attribute (cls, fields(10)))
    val PIML: Fielder = parse_attribute (attribute (cls, fields(11)))
    val POAL: Fielder = parse_attribute (attribute (cls, fields(12)))
    val POL: Fielder = parse_attribute (attribute (cls, fields(13)))
    val PP: Fielder = parse_attribute (attribute (cls, fields(14)))
    val SL: Fielder = parse_attribute (attribute (cls, fields(15)))

    def parse (context: CIMContext): MeasurementTypeEMS =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MeasurementTypeEMS (
            BasicElement.parse (context),
            mask (ACE (), 0),
            mask (GMOL (), 1),
            mask (GNOL (), 2),
            mask (GO (), 3),
            mask (GR (), 4),
            mask (GS (), 5),
            mask (INADV (), 6),
            mask (OARL (), 7),
            mask (PF (), 8),
            mask (PIAL (), 9),
            mask (PIL (), 10),
            mask (PIML (), 11),
            mask (POAL (), 12),
            mask (POL (), 13),
            mask (PP (), 14),
            mask (SL (), 15)
        )
        ret.bitfields = bitfields
        ret
    }
}

object MeasurementTypeEMSSerializer extends CIMSerializer[MeasurementTypeEMS]
{
    def write (kryo: Kryo, output: Output, obj: MeasurementTypeEMS): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.ACE),
            () => output.writeString (obj.GMOL),
            () => output.writeString (obj.GNOL),
            () => output.writeString (obj.GO),
            () => output.writeString (obj.GR),
            () => output.writeString (obj.GS),
            () => output.writeString (obj.INADV),
            () => output.writeString (obj.OARL),
            () => output.writeString (obj.PF),
            () => output.writeString (obj.PIAL),
            () => output.writeString (obj.PIL),
            () => output.writeString (obj.PIML),
            () => output.writeString (obj.POAL),
            () => output.writeString (obj.POL),
            () => output.writeString (obj.PP),
            () => output.writeString (obj.SL)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MeasurementTypeEMS]): MeasurementTypeEMS =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MeasurementTypeEMS (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) input.readString else null,
            if (isSet (11)) input.readString else null,
            if (isSet (12)) input.readString else null,
            if (isSet (13)) input.readString else null,
            if (isSet (14)) input.readString else null,
            if (isSet (15)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class MktSubClassType
(
    Element: BasicElement = null,
    Branch_Group_Derates: String = null,
    Day_Ahead_Final_Market_Info: String = null,
    Day_Ahead_Forecast_Information: String = null,
    Day_Ahead_Interim_Market_Info: String = null,
    Day_Ahead_RMR: String = null,
    Forecasted_UDC_Direct_Access_Load: String = null,
    Hour_Ahead_Market_Info: String = null,
    Hourly_Expost_Market_Info: String = null,
    Public_Bid_Data: String = null,
    TTC_ATC_Forecast_Information: String = null,
    TTC_ATC_Hourly_Forecast: String = null,
    Ten_Min_Expost_Market_Info: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = MktSubClassType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (MktSubClassType.fields (position), value)
        emitattr (0, Branch_Group_Derates)
        emitattr (1, Day_Ahead_Final_Market_Info)
        emitattr (2, Day_Ahead_Forecast_Information)
        emitattr (3, Day_Ahead_Interim_Market_Info)
        emitattr (4, Day_Ahead_RMR)
        emitattr (5, Forecasted_UDC_Direct_Access_Load)
        emitattr (6, Hour_Ahead_Market_Info)
        emitattr (7, Hourly_Expost_Market_Info)
        emitattr (8, Public_Bid_Data)
        emitattr (9, TTC_ATC_Forecast_Information)
        emitattr (10, TTC_ATC_Hourly_Forecast)
        emitattr (11, Ten_Min_Expost_Market_Info)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MktSubClassType rdf:ID=\"%s\">\n%s\t</cim:MktSubClassType>".format (id, export_fields)
    }
}

object MktSubClassType
extends
    CIMParseable[MktSubClassType]
{
    override val fields: Array[String] = Array[String] (
        "Branch_Group_Derates",
        "Day_Ahead_Final_Market_Info",
        "Day_Ahead_Forecast_Information",
        "Day_Ahead_Interim_Market_Info",
        "Day_Ahead_RMR",
        "Forecasted_UDC_Direct_Access_Load",
        "Hour_Ahead_Market_Info",
        "Hourly_Expost_Market_Info",
        "Public_Bid_Data",
        "TTC/ATC_Forecast_Information",
        "TTC/ATC_Hourly_Forecast",
        "Ten_Min_Expost_Market_Info"
    )
    val Branch_Group_Derates: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Day_Ahead_Final_Market_Info: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Day_Ahead_Forecast_Information: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Day_Ahead_Interim_Market_Info: Fielder = parse_attribute (attribute (cls, fields(3)))
    val Day_Ahead_RMR: Fielder = parse_attribute (attribute (cls, fields(4)))
    val Forecasted_UDC_Direct_Access_Load: Fielder = parse_attribute (attribute (cls, fields(5)))
    val Hour_Ahead_Market_Info: Fielder = parse_attribute (attribute (cls, fields(6)))
    val Hourly_Expost_Market_Info: Fielder = parse_attribute (attribute (cls, fields(7)))
    val Public_Bid_Data: Fielder = parse_attribute (attribute (cls, fields(8)))
    val TTC_ATC_Forecast_Information: Fielder = parse_attribute (attribute (cls, fields(9)))
    val TTC_ATC_Hourly_Forecast: Fielder = parse_attribute (attribute (cls, fields(10)))
    val Ten_Min_Expost_Market_Info: Fielder = parse_attribute (attribute (cls, fields(11)))

    def parse (context: CIMContext): MktSubClassType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MktSubClassType (
            BasicElement.parse (context),
            mask (Branch_Group_Derates (), 0),
            mask (Day_Ahead_Final_Market_Info (), 1),
            mask (Day_Ahead_Forecast_Information (), 2),
            mask (Day_Ahead_Interim_Market_Info (), 3),
            mask (Day_Ahead_RMR (), 4),
            mask (Forecasted_UDC_Direct_Access_Load (), 5),
            mask (Hour_Ahead_Market_Info (), 6),
            mask (Hourly_Expost_Market_Info (), 7),
            mask (Public_Bid_Data (), 8),
            mask (TTC_ATC_Forecast_Information (), 9),
            mask (TTC_ATC_Hourly_Forecast (), 10),
            mask (Ten_Min_Expost_Market_Info (), 11)
        )
        ret.bitfields = bitfields
        ret
    }
}

object MktSubClassTypeSerializer extends CIMSerializer[MktSubClassType]
{
    def write (kryo: Kryo, output: Output, obj: MktSubClassType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.Branch_Group_Derates),
            () => output.writeString (obj.Day_Ahead_Final_Market_Info),
            () => output.writeString (obj.Day_Ahead_Forecast_Information),
            () => output.writeString (obj.Day_Ahead_Interim_Market_Info),
            () => output.writeString (obj.Day_Ahead_RMR),
            () => output.writeString (obj.Forecasted_UDC_Direct_Access_Load),
            () => output.writeString (obj.Hour_Ahead_Market_Info),
            () => output.writeString (obj.Hourly_Expost_Market_Info),
            () => output.writeString (obj.Public_Bid_Data),
            () => output.writeString (obj.TTC_ATC_Forecast_Information),
            () => output.writeString (obj.TTC_ATC_Hourly_Forecast),
            () => output.writeString (obj.Ten_Min_Expost_Market_Info)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MktSubClassType]): MktSubClassType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = MktSubClassType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) input.readString else null,
            if (isSet (11)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class OASISBidReportType
(
    Element: BasicElement = null,
    BIDS_PUBLIC: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OASISBidReportType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OASISBidReportType.fields (position), value)
        emitattr (0, BIDS_PUBLIC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OASISBidReportType rdf:ID=\"%s\">\n%s\t</cim:OASISBidReportType>".format (id, export_fields)
    }
}

object OASISBidReportType
extends
    CIMParseable[OASISBidReportType]
{
    override val fields: Array[String] = Array[String] (
        "BIDS_PUBLIC"
    )
    val BIDS_PUBLIC: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): OASISBidReportType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OASISBidReportType (
            BasicElement.parse (context),
            mask (BIDS_PUBLIC (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object OASISBidReportTypeSerializer extends CIMSerializer[OASISBidReportType]
{
    def write (kryo: Kryo, output: Output, obj: OASISBidReportType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.BIDS_PUBLIC)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OASISBidReportType]): OASISBidReportType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OASISBidReportType (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class OASISDataItems
(
    Element: BasicElement = null,
    AS_CLEAR_ASMP_IFM: String = null,
    AS_CLEAR_ASMP_RTM: String = null,
    AS_CLEAR_COST_IFM: String = null,
    AS_CLEAR_COST_RTM: String = null,
    AS_CLEAR_MW_IFM: String = null,
    AS_CLEAR_MW_RTM: String = null,
    AS_GEN_TOTAL_MW_IFM: String = null,
    AS_GEN_TOTAL_MW_RTM: String = null,
    AS_IMP_TOTAL_MW_IFM: String = null,
    AS_IMP_TOTAL_MW_RTM: String = null,
    AS_LOAD_TOTAL_MW_IFM: String = null,
    AS_LOAD_TOTAL_MW_RTM: String = null,
    AS_REGION_REQ_MAX: String = null,
    AS_REGION_REQ_MIN: String = null,
    AS_REGION_value: String = null,
    AS_SELF_MW_IFM: String = null,
    AS_SELF_MW_RTM: String = null,
    AS_TOTAL_MW: String = null,
    AS_TOTAL_MW_IFM: String = null,
    AS_TOTAL_MW_RTM: String = null,
    AS_TYPE: String = null,
    AS_USER_RATE: String = null,
    CA_value: String = null,
    CMMT_MINLOAD_MLC: String = null,
    CMMT_MINLOAD_MW: String = null,
    CMMT_RA_MLC: String = null,
    CMMT_RA_MW: String = null,
    CMMT_RA_START_COST: String = null,
    CMMT_RA_UNITS: String = null,
    CMMT_TOTAL_MW: String = null,
    CMMT_TOTAL_START_COST: String = null,
    CMMT_TOTAL_UNITS: String = null,
    CRR_CAT: String = null,
    CRR_MARKET_value: String = null,
    CRR_MW: String = null,
    CRR_NSR: String = null,
    CRR_OPTION: String = null,
    CRR_OWNER: String = null,
    CRR_SEGMENT: String = null,
    CRR_TERM: String = null,
    CRR_TOU: String = null,
    CRR_TYPE: String = null,
    ENE_EA_DA: String = null,
    ENE_EA_EXCEPT: String = null,
    ENE_EA_HASP: String = null,
    ENE_EA_MLE: String = null,
    ENE_EA_MSSLF: String = null,
    ENE_EA_OPTIMAL: String = null,
    ENE_EA_RAMP_DEV: String = null,
    ENE_EA_RAMP_STD: String = null,
    ENE_EA_RESIDUAL: String = null,
    ENE_EA_RMR: String = null,
    ENE_EA_SELF: String = null,
    ENE_EA_SLIC: String = null,
    ENE_EXP_CLEAR_HASP: String = null,
    ENE_EXP_CLEAR_IFM: String = null,
    ENE_EXP_CLEAR_RTM: String = null,
    ENE_GEN_CLEAR_HASP: String = null,
    ENE_GEN_CLEAR_IFM: String = null,
    ENE_GEN_CLEAR_RTM: String = null,
    ENE_IMP_CLEAR_HASP: String = null,
    ENE_IMP_CLEAR_IFM: String = null,
    ENE_IMP_CLEAR_RTM: String = null,
    ENE_LOAD_ACTUAL: String = null,
    ENE_LOAD_CLEAR_HASP: String = null,
    ENE_LOAD_CLEAR_IFM: String = null,
    ENE_LOAD_CLEAR_RTM: String = null,
    ENE_LOAD_FCST: String = null,
    ENE_PEAK_HOUR: String = null,
    ENE_PEAK_LOAD: String = null,
    FUEL_REGION_value: String = null,
    INVT_DATETIME: String = null,
    LOAD_ACTUAL: String = null,
    LOAD_CLEAR_RTM: String = null,
    LOSS_TOTAL_COST_HASP: String = null,
    LOSS_TOTAL_COST_RTM: String = null,
    LOSS_TOTAL_MW_HASP: String = null,
    LOSS_TOTAL_MW_RTM: String = null,
    MPM_FLAG: String = null,
    OP_RSRV_TOTAL: String = null,
    PRC_NG: String = null,
    PRC_SHADOW: String = null,
    RATING_ATC: String = null,
    RMR_DETER_DAM: String = null,
    RMR_DETER_HASP: String = null,
    RMR_DISPATCH_DAM: String = null,
    RMR_DISPATCH_HASP: String = null,
    RMR_TOTAL: String = null,
    RMR_TOTAL_AVAIL: String = null,
    RUC_GEN_CLEAR_RUC: String = null,
    RUC_IMP_CLEAR_RUC: String = null,
    RUC_LOAD_CLEAR_RUC: String = null,
    RUC_ZONE_value: String = null,
    TAC_AREA_value: String = null,
    TINTRFCE_value: String = null,
    TRNS_AS_IMPORT: String = null,
    TRNS_ENE_IMPORT: String = null,
    TRNS_EQUIP_value: String = null,
    TRNS_RATING_CBM: String = null,
    TRNS_RATING_DIRECTION: String = null,
    TRNS_RATING_OTC: String = null,
    TRNS_RATING_OTC_DERATE: String = null,
    TRNS_RATING_TTC: String = null,
    TRNS_TI_value: String = null,
    TRNS_TR_ENTMTS: String = null,
    TRNS_TR_USEAGE: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OASISDataItems.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OASISDataItems.fields (position), value)
        emitattr (0, AS_CLEAR_ASMP_IFM)
        emitattr (1, AS_CLEAR_ASMP_RTM)
        emitattr (2, AS_CLEAR_COST_IFM)
        emitattr (3, AS_CLEAR_COST_RTM)
        emitattr (4, AS_CLEAR_MW_IFM)
        emitattr (5, AS_CLEAR_MW_RTM)
        emitattr (6, AS_GEN_TOTAL_MW_IFM)
        emitattr (7, AS_GEN_TOTAL_MW_RTM)
        emitattr (8, AS_IMP_TOTAL_MW_IFM)
        emitattr (9, AS_IMP_TOTAL_MW_RTM)
        emitattr (10, AS_LOAD_TOTAL_MW_IFM)
        emitattr (11, AS_LOAD_TOTAL_MW_RTM)
        emitattr (12, AS_REGION_REQ_MAX)
        emitattr (13, AS_REGION_REQ_MIN)
        emitattr (14, AS_REGION_value)
        emitattr (15, AS_SELF_MW_IFM)
        emitattr (16, AS_SELF_MW_RTM)
        emitattr (17, AS_TOTAL_MW)
        emitattr (18, AS_TOTAL_MW_IFM)
        emitattr (19, AS_TOTAL_MW_RTM)
        emitattr (20, AS_TYPE)
        emitattr (21, AS_USER_RATE)
        emitattr (22, CA_value)
        emitattr (23, CMMT_MINLOAD_MLC)
        emitattr (24, CMMT_MINLOAD_MW)
        emitattr (25, CMMT_RA_MLC)
        emitattr (26, CMMT_RA_MW)
        emitattr (27, CMMT_RA_START_COST)
        emitattr (28, CMMT_RA_UNITS)
        emitattr (29, CMMT_TOTAL_MW)
        emitattr (30, CMMT_TOTAL_START_COST)
        emitattr (31, CMMT_TOTAL_UNITS)
        emitattr (32, CRR_CAT)
        emitattr (33, CRR_MARKET_value)
        emitattr (34, CRR_MW)
        emitattr (35, CRR_NSR)
        emitattr (36, CRR_OPTION)
        emitattr (37, CRR_OWNER)
        emitattr (38, CRR_SEGMENT)
        emitattr (39, CRR_TERM)
        emitattr (40, CRR_TOU)
        emitattr (41, CRR_TYPE)
        emitattr (42, ENE_EA_DA)
        emitattr (43, ENE_EA_EXCEPT)
        emitattr (44, ENE_EA_HASP)
        emitattr (45, ENE_EA_MLE)
        emitattr (46, ENE_EA_MSSLF)
        emitattr (47, ENE_EA_OPTIMAL)
        emitattr (48, ENE_EA_RAMP_DEV)
        emitattr (49, ENE_EA_RAMP_STD)
        emitattr (50, ENE_EA_RESIDUAL)
        emitattr (51, ENE_EA_RMR)
        emitattr (52, ENE_EA_SELF)
        emitattr (53, ENE_EA_SLIC)
        emitattr (54, ENE_EXP_CLEAR_HASP)
        emitattr (55, ENE_EXP_CLEAR_IFM)
        emitattr (56, ENE_EXP_CLEAR_RTM)
        emitattr (57, ENE_GEN_CLEAR_HASP)
        emitattr (58, ENE_GEN_CLEAR_IFM)
        emitattr (59, ENE_GEN_CLEAR_RTM)
        emitattr (60, ENE_IMP_CLEAR_HASP)
        emitattr (61, ENE_IMP_CLEAR_IFM)
        emitattr (62, ENE_IMP_CLEAR_RTM)
        emitattr (63, ENE_LOAD_ACTUAL)
        emitattr (64, ENE_LOAD_CLEAR_HASP)
        emitattr (65, ENE_LOAD_CLEAR_IFM)
        emitattr (66, ENE_LOAD_CLEAR_RTM)
        emitattr (67, ENE_LOAD_FCST)
        emitattr (68, ENE_PEAK_HOUR)
        emitattr (69, ENE_PEAK_LOAD)
        emitattr (70, FUEL_REGION_value)
        emitattr (71, INVT_DATETIME)
        emitattr (72, LOAD_ACTUAL)
        emitattr (73, LOAD_CLEAR_RTM)
        emitattr (74, LOSS_TOTAL_COST_HASP)
        emitattr (75, LOSS_TOTAL_COST_RTM)
        emitattr (76, LOSS_TOTAL_MW_HASP)
        emitattr (77, LOSS_TOTAL_MW_RTM)
        emitattr (78, MPM_FLAG)
        emitattr (79, OP_RSRV_TOTAL)
        emitattr (80, PRC_NG)
        emitattr (81, PRC_SHADOW)
        emitattr (82, RATING_ATC)
        emitattr (83, RMR_DETER_DAM)
        emitattr (84, RMR_DETER_HASP)
        emitattr (85, RMR_DISPATCH_DAM)
        emitattr (86, RMR_DISPATCH_HASP)
        emitattr (87, RMR_TOTAL)
        emitattr (88, RMR_TOTAL_AVAIL)
        emitattr (89, RUC_GEN_CLEAR_RUC)
        emitattr (90, RUC_IMP_CLEAR_RUC)
        emitattr (91, RUC_LOAD_CLEAR_RUC)
        emitattr (92, RUC_ZONE_value)
        emitattr (93, TAC_AREA_value)
        emitattr (94, TINTRFCE_value)
        emitattr (95, TRNS_AS_IMPORT)
        emitattr (96, TRNS_ENE_IMPORT)
        emitattr (97, TRNS_EQUIP_value)
        emitattr (98, TRNS_RATING_CBM)
        emitattr (99, TRNS_RATING_DIRECTION)
        emitattr (100, TRNS_RATING_OTC)
        emitattr (101, TRNS_RATING_OTC_DERATE)
        emitattr (102, TRNS_RATING_TTC)
        emitattr (103, TRNS_TI_value)
        emitattr (104, TRNS_TR_ENTMTS)
        emitattr (105, TRNS_TR_USEAGE)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OASISDataItems rdf:ID=\"%s\">\n%s\t</cim:OASISDataItems>".format (id, export_fields)
    }
}

object OASISDataItems
extends
    CIMParseable[OASISDataItems]
{
    override val fields: Array[String] = Array[String] (
        "AS_CLEAR_ASMP_IFM",
        "AS_CLEAR_ASMP_RTM",
        "AS_CLEAR_COST_IFM",
        "AS_CLEAR_COST_RTM",
        "AS_CLEAR_MW_IFM",
        "AS_CLEAR_MW_RTM",
        "AS_GEN_TOTAL_MW_IFM",
        "AS_GEN_TOTAL_MW_RTM",
        "AS_IMP_TOTAL_MW_IFM",
        "AS_IMP_TOTAL_MW_RTM",
        "AS_LOAD_TOTAL_MW_IFM",
        "AS_LOAD_TOTAL_MW_RTM",
        "AS_REGION_REQ_MAX",
        "AS_REGION_REQ_MIN",
        "AS_REGION_value",
        "AS_SELF_MW_IFM",
        "AS_SELF_MW_RTM",
        "AS_TOTAL_MW",
        "AS_TOTAL_MW_IFM",
        "AS_TOTAL_MW_RTM",
        "AS_TYPE",
        "AS_USER_RATE",
        "CA_value",
        "CMMT_MINLOAD_MLC",
        "CMMT_MINLOAD_MW",
        "CMMT_RA_MLC",
        "CMMT_RA_MW",
        "CMMT_RA_START_COST",
        "CMMT_RA_UNITS",
        "CMMT_TOTAL_MW",
        "CMMT_TOTAL_START_COST",
        "CMMT_TOTAL_UNITS",
        "CRR_CAT",
        "CRR_MARKET_value",
        "CRR_MW",
        "CRR_NSR",
        "CRR_OPTION",
        "CRR_OWNER",
        "CRR_SEGMENT",
        "CRR_TERM",
        "CRR_TOU",
        "CRR_TYPE",
        "ENE_EA_DA",
        "ENE_EA_EXCEPT",
        "ENE_EA_HASP",
        "ENE_EA_MLE",
        "ENE_EA_MSSLF",
        "ENE_EA_OPTIMAL",
        "ENE_EA_RAMP_DEV",
        "ENE_EA_RAMP_STD",
        "ENE_EA_RESIDUAL",
        "ENE_EA_RMR",
        "ENE_EA_SELF",
        "ENE_EA_SLIC",
        "ENE_EXP_CLEAR_HASP",
        "ENE_EXP_CLEAR_IFM",
        "ENE_EXP_CLEAR_RTM",
        "ENE_GEN_CLEAR_HASP",
        "ENE_GEN_CLEAR_IFM",
        "ENE_GEN_CLEAR_RTM",
        "ENE_IMP_CLEAR_HASP",
        "ENE_IMP_CLEAR_IFM",
        "ENE_IMP_CLEAR_RTM",
        "ENE_LOAD_ACTUAL",
        "ENE_LOAD_CLEAR_HASP",
        "ENE_LOAD_CLEAR_IFM",
        "ENE_LOAD_CLEAR_RTM",
        "ENE_LOAD_FCST",
        "ENE_PEAK_HOUR",
        "ENE_PEAK_LOAD",
        "FUEL_REGION_value",
        "INVT_DATETIME",
        "LOAD_ACTUAL",
        "LOAD_CLEAR_RTM",
        "LOSS_TOTAL_COST_HASP",
        "LOSS_TOTAL_COST_RTM",
        "LOSS_TOTAL_MW_HASP",
        "LOSS_TOTAL_MW_RTM",
        "MPM_FLAG",
        "OP_RSRV_TOTAL",
        "PRC_NG",
        "PRC_SHADOW",
        "RATING_ATC",
        "RMR_DETER_DAM",
        "RMR_DETER_HASP",
        "RMR_DISPATCH_DAM",
        "RMR_DISPATCH_HASP",
        "RMR_TOTAL",
        "RMR_TOTAL_AVAIL",
        "RUC_GEN_CLEAR_RUC",
        "RUC_IMP_CLEAR_RUC",
        "RUC_LOAD_CLEAR_RUC",
        "RUC_ZONE_value",
        "TAC_AREA_value",
        "TINTRFCE_value",
        "TRNS_AS_IMPORT",
        "TRNS_ENE_IMPORT",
        "TRNS_EQUIP_value",
        "TRNS_RATING_CBM",
        "TRNS_RATING_DIRECTION",
        "TRNS_RATING_OTC",
        "TRNS_RATING_OTC_DERATE",
        "TRNS_RATING_TTC",
        "TRNS_TI_value",
        "TRNS_TR_ENTMTS",
        "TRNS_TR_USEAGE"
    )
    val AS_CLEAR_ASMP_IFM: Fielder = parse_attribute (attribute (cls, fields(0)))
    val AS_CLEAR_ASMP_RTM: Fielder = parse_attribute (attribute (cls, fields(1)))
    val AS_CLEAR_COST_IFM: Fielder = parse_attribute (attribute (cls, fields(2)))
    val AS_CLEAR_COST_RTM: Fielder = parse_attribute (attribute (cls, fields(3)))
    val AS_CLEAR_MW_IFM: Fielder = parse_attribute (attribute (cls, fields(4)))
    val AS_CLEAR_MW_RTM: Fielder = parse_attribute (attribute (cls, fields(5)))
    val AS_GEN_TOTAL_MW_IFM: Fielder = parse_attribute (attribute (cls, fields(6)))
    val AS_GEN_TOTAL_MW_RTM: Fielder = parse_attribute (attribute (cls, fields(7)))
    val AS_IMP_TOTAL_MW_IFM: Fielder = parse_attribute (attribute (cls, fields(8)))
    val AS_IMP_TOTAL_MW_RTM: Fielder = parse_attribute (attribute (cls, fields(9)))
    val AS_LOAD_TOTAL_MW_IFM: Fielder = parse_attribute (attribute (cls, fields(10)))
    val AS_LOAD_TOTAL_MW_RTM: Fielder = parse_attribute (attribute (cls, fields(11)))
    val AS_REGION_REQ_MAX: Fielder = parse_attribute (attribute (cls, fields(12)))
    val AS_REGION_REQ_MIN: Fielder = parse_attribute (attribute (cls, fields(13)))
    val AS_REGION_value: Fielder = parse_attribute (attribute (cls, fields(14)))
    val AS_SELF_MW_IFM: Fielder = parse_attribute (attribute (cls, fields(15)))
    val AS_SELF_MW_RTM: Fielder = parse_attribute (attribute (cls, fields(16)))
    val AS_TOTAL_MW: Fielder = parse_attribute (attribute (cls, fields(17)))
    val AS_TOTAL_MW_IFM: Fielder = parse_attribute (attribute (cls, fields(18)))
    val AS_TOTAL_MW_RTM: Fielder = parse_attribute (attribute (cls, fields(19)))
    val AS_TYPE: Fielder = parse_attribute (attribute (cls, fields(20)))
    val AS_USER_RATE: Fielder = parse_attribute (attribute (cls, fields(21)))
    val CA_value: Fielder = parse_attribute (attribute (cls, fields(22)))
    val CMMT_MINLOAD_MLC: Fielder = parse_attribute (attribute (cls, fields(23)))
    val CMMT_MINLOAD_MW: Fielder = parse_attribute (attribute (cls, fields(24)))
    val CMMT_RA_MLC: Fielder = parse_attribute (attribute (cls, fields(25)))
    val CMMT_RA_MW: Fielder = parse_attribute (attribute (cls, fields(26)))
    val CMMT_RA_START_COST: Fielder = parse_attribute (attribute (cls, fields(27)))
    val CMMT_RA_UNITS: Fielder = parse_attribute (attribute (cls, fields(28)))
    val CMMT_TOTAL_MW: Fielder = parse_attribute (attribute (cls, fields(29)))
    val CMMT_TOTAL_START_COST: Fielder = parse_attribute (attribute (cls, fields(30)))
    val CMMT_TOTAL_UNITS: Fielder = parse_attribute (attribute (cls, fields(31)))
    val CRR_CAT: Fielder = parse_attribute (attribute (cls, fields(32)))
    val CRR_MARKET_value: Fielder = parse_attribute (attribute (cls, fields(33)))
    val CRR_MW: Fielder = parse_attribute (attribute (cls, fields(34)))
    val CRR_NSR: Fielder = parse_attribute (attribute (cls, fields(35)))
    val CRR_OPTION: Fielder = parse_attribute (attribute (cls, fields(36)))
    val CRR_OWNER: Fielder = parse_attribute (attribute (cls, fields(37)))
    val CRR_SEGMENT: Fielder = parse_attribute (attribute (cls, fields(38)))
    val CRR_TERM: Fielder = parse_attribute (attribute (cls, fields(39)))
    val CRR_TOU: Fielder = parse_attribute (attribute (cls, fields(40)))
    val CRR_TYPE: Fielder = parse_attribute (attribute (cls, fields(41)))
    val ENE_EA_DA: Fielder = parse_attribute (attribute (cls, fields(42)))
    val ENE_EA_EXCEPT: Fielder = parse_attribute (attribute (cls, fields(43)))
    val ENE_EA_HASP: Fielder = parse_attribute (attribute (cls, fields(44)))
    val ENE_EA_MLE: Fielder = parse_attribute (attribute (cls, fields(45)))
    val ENE_EA_MSSLF: Fielder = parse_attribute (attribute (cls, fields(46)))
    val ENE_EA_OPTIMAL: Fielder = parse_attribute (attribute (cls, fields(47)))
    val ENE_EA_RAMP_DEV: Fielder = parse_attribute (attribute (cls, fields(48)))
    val ENE_EA_RAMP_STD: Fielder = parse_attribute (attribute (cls, fields(49)))
    val ENE_EA_RESIDUAL: Fielder = parse_attribute (attribute (cls, fields(50)))
    val ENE_EA_RMR: Fielder = parse_attribute (attribute (cls, fields(51)))
    val ENE_EA_SELF: Fielder = parse_attribute (attribute (cls, fields(52)))
    val ENE_EA_SLIC: Fielder = parse_attribute (attribute (cls, fields(53)))
    val ENE_EXP_CLEAR_HASP: Fielder = parse_attribute (attribute (cls, fields(54)))
    val ENE_EXP_CLEAR_IFM: Fielder = parse_attribute (attribute (cls, fields(55)))
    val ENE_EXP_CLEAR_RTM: Fielder = parse_attribute (attribute (cls, fields(56)))
    val ENE_GEN_CLEAR_HASP: Fielder = parse_attribute (attribute (cls, fields(57)))
    val ENE_GEN_CLEAR_IFM: Fielder = parse_attribute (attribute (cls, fields(58)))
    val ENE_GEN_CLEAR_RTM: Fielder = parse_attribute (attribute (cls, fields(59)))
    val ENE_IMP_CLEAR_HASP: Fielder = parse_attribute (attribute (cls, fields(60)))
    val ENE_IMP_CLEAR_IFM: Fielder = parse_attribute (attribute (cls, fields(61)))
    val ENE_IMP_CLEAR_RTM: Fielder = parse_attribute (attribute (cls, fields(62)))
    val ENE_LOAD_ACTUAL: Fielder = parse_attribute (attribute (cls, fields(63)))
    val ENE_LOAD_CLEAR_HASP: Fielder = parse_attribute (attribute (cls, fields(64)))
    val ENE_LOAD_CLEAR_IFM: Fielder = parse_attribute (attribute (cls, fields(65)))
    val ENE_LOAD_CLEAR_RTM: Fielder = parse_attribute (attribute (cls, fields(66)))
    val ENE_LOAD_FCST: Fielder = parse_attribute (attribute (cls, fields(67)))
    val ENE_PEAK_HOUR: Fielder = parse_attribute (attribute (cls, fields(68)))
    val ENE_PEAK_LOAD: Fielder = parse_attribute (attribute (cls, fields(69)))
    val FUEL_REGION_value: Fielder = parse_attribute (attribute (cls, fields(70)))
    val INVT_DATETIME: Fielder = parse_attribute (attribute (cls, fields(71)))
    val LOAD_ACTUAL: Fielder = parse_attribute (attribute (cls, fields(72)))
    val LOAD_CLEAR_RTM: Fielder = parse_attribute (attribute (cls, fields(73)))
    val LOSS_TOTAL_COST_HASP: Fielder = parse_attribute (attribute (cls, fields(74)))
    val LOSS_TOTAL_COST_RTM: Fielder = parse_attribute (attribute (cls, fields(75)))
    val LOSS_TOTAL_MW_HASP: Fielder = parse_attribute (attribute (cls, fields(76)))
    val LOSS_TOTAL_MW_RTM: Fielder = parse_attribute (attribute (cls, fields(77)))
    val MPM_FLAG: Fielder = parse_attribute (attribute (cls, fields(78)))
    val OP_RSRV_TOTAL: Fielder = parse_attribute (attribute (cls, fields(79)))
    val PRC_NG: Fielder = parse_attribute (attribute (cls, fields(80)))
    val PRC_SHADOW: Fielder = parse_attribute (attribute (cls, fields(81)))
    val RATING_ATC: Fielder = parse_attribute (attribute (cls, fields(82)))
    val RMR_DETER_DAM: Fielder = parse_attribute (attribute (cls, fields(83)))
    val RMR_DETER_HASP: Fielder = parse_attribute (attribute (cls, fields(84)))
    val RMR_DISPATCH_DAM: Fielder = parse_attribute (attribute (cls, fields(85)))
    val RMR_DISPATCH_HASP: Fielder = parse_attribute (attribute (cls, fields(86)))
    val RMR_TOTAL: Fielder = parse_attribute (attribute (cls, fields(87)))
    val RMR_TOTAL_AVAIL: Fielder = parse_attribute (attribute (cls, fields(88)))
    val RUC_GEN_CLEAR_RUC: Fielder = parse_attribute (attribute (cls, fields(89)))
    val RUC_IMP_CLEAR_RUC: Fielder = parse_attribute (attribute (cls, fields(90)))
    val RUC_LOAD_CLEAR_RUC: Fielder = parse_attribute (attribute (cls, fields(91)))
    val RUC_ZONE_value: Fielder = parse_attribute (attribute (cls, fields(92)))
    val TAC_AREA_value: Fielder = parse_attribute (attribute (cls, fields(93)))
    val TINTRFCE_value: Fielder = parse_attribute (attribute (cls, fields(94)))
    val TRNS_AS_IMPORT: Fielder = parse_attribute (attribute (cls, fields(95)))
    val TRNS_ENE_IMPORT: Fielder = parse_attribute (attribute (cls, fields(96)))
    val TRNS_EQUIP_value: Fielder = parse_attribute (attribute (cls, fields(97)))
    val TRNS_RATING_CBM: Fielder = parse_attribute (attribute (cls, fields(98)))
    val TRNS_RATING_DIRECTION: Fielder = parse_attribute (attribute (cls, fields(99)))
    val TRNS_RATING_OTC: Fielder = parse_attribute (attribute (cls, fields(100)))
    val TRNS_RATING_OTC_DERATE: Fielder = parse_attribute (attribute (cls, fields(101)))
    val TRNS_RATING_TTC: Fielder = parse_attribute (attribute (cls, fields(102)))
    val TRNS_TI_value: Fielder = parse_attribute (attribute (cls, fields(103)))
    val TRNS_TR_ENTMTS: Fielder = parse_attribute (attribute (cls, fields(104)))
    val TRNS_TR_USEAGE: Fielder = parse_attribute (attribute (cls, fields(105)))

    def parse (context: CIMContext): OASISDataItems =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0,0,0,0)
        val ret = OASISDataItems (
            BasicElement.parse (context),
            mask (AS_CLEAR_ASMP_IFM (), 0),
            mask (AS_CLEAR_ASMP_RTM (), 1),
            mask (AS_CLEAR_COST_IFM (), 2),
            mask (AS_CLEAR_COST_RTM (), 3),
            mask (AS_CLEAR_MW_IFM (), 4),
            mask (AS_CLEAR_MW_RTM (), 5),
            mask (AS_GEN_TOTAL_MW_IFM (), 6),
            mask (AS_GEN_TOTAL_MW_RTM (), 7),
            mask (AS_IMP_TOTAL_MW_IFM (), 8),
            mask (AS_IMP_TOTAL_MW_RTM (), 9),
            mask (AS_LOAD_TOTAL_MW_IFM (), 10),
            mask (AS_LOAD_TOTAL_MW_RTM (), 11),
            mask (AS_REGION_REQ_MAX (), 12),
            mask (AS_REGION_REQ_MIN (), 13),
            mask (AS_REGION_value (), 14),
            mask (AS_SELF_MW_IFM (), 15),
            mask (AS_SELF_MW_RTM (), 16),
            mask (AS_TOTAL_MW (), 17),
            mask (AS_TOTAL_MW_IFM (), 18),
            mask (AS_TOTAL_MW_RTM (), 19),
            mask (AS_TYPE (), 20),
            mask (AS_USER_RATE (), 21),
            mask (CA_value (), 22),
            mask (CMMT_MINLOAD_MLC (), 23),
            mask (CMMT_MINLOAD_MW (), 24),
            mask (CMMT_RA_MLC (), 25),
            mask (CMMT_RA_MW (), 26),
            mask (CMMT_RA_START_COST (), 27),
            mask (CMMT_RA_UNITS (), 28),
            mask (CMMT_TOTAL_MW (), 29),
            mask (CMMT_TOTAL_START_COST (), 30),
            mask (CMMT_TOTAL_UNITS (), 31),
            mask (CRR_CAT (), 32),
            mask (CRR_MARKET_value (), 33),
            mask (CRR_MW (), 34),
            mask (CRR_NSR (), 35),
            mask (CRR_OPTION (), 36),
            mask (CRR_OWNER (), 37),
            mask (CRR_SEGMENT (), 38),
            mask (CRR_TERM (), 39),
            mask (CRR_TOU (), 40),
            mask (CRR_TYPE (), 41),
            mask (ENE_EA_DA (), 42),
            mask (ENE_EA_EXCEPT (), 43),
            mask (ENE_EA_HASP (), 44),
            mask (ENE_EA_MLE (), 45),
            mask (ENE_EA_MSSLF (), 46),
            mask (ENE_EA_OPTIMAL (), 47),
            mask (ENE_EA_RAMP_DEV (), 48),
            mask (ENE_EA_RAMP_STD (), 49),
            mask (ENE_EA_RESIDUAL (), 50),
            mask (ENE_EA_RMR (), 51),
            mask (ENE_EA_SELF (), 52),
            mask (ENE_EA_SLIC (), 53),
            mask (ENE_EXP_CLEAR_HASP (), 54),
            mask (ENE_EXP_CLEAR_IFM (), 55),
            mask (ENE_EXP_CLEAR_RTM (), 56),
            mask (ENE_GEN_CLEAR_HASP (), 57),
            mask (ENE_GEN_CLEAR_IFM (), 58),
            mask (ENE_GEN_CLEAR_RTM (), 59),
            mask (ENE_IMP_CLEAR_HASP (), 60),
            mask (ENE_IMP_CLEAR_IFM (), 61),
            mask (ENE_IMP_CLEAR_RTM (), 62),
            mask (ENE_LOAD_ACTUAL (), 63),
            mask (ENE_LOAD_CLEAR_HASP (), 64),
            mask (ENE_LOAD_CLEAR_IFM (), 65),
            mask (ENE_LOAD_CLEAR_RTM (), 66),
            mask (ENE_LOAD_FCST (), 67),
            mask (ENE_PEAK_HOUR (), 68),
            mask (ENE_PEAK_LOAD (), 69),
            mask (FUEL_REGION_value (), 70),
            mask (INVT_DATETIME (), 71),
            mask (LOAD_ACTUAL (), 72),
            mask (LOAD_CLEAR_RTM (), 73),
            mask (LOSS_TOTAL_COST_HASP (), 74),
            mask (LOSS_TOTAL_COST_RTM (), 75),
            mask (LOSS_TOTAL_MW_HASP (), 76),
            mask (LOSS_TOTAL_MW_RTM (), 77),
            mask (MPM_FLAG (), 78),
            mask (OP_RSRV_TOTAL (), 79),
            mask (PRC_NG (), 80),
            mask (PRC_SHADOW (), 81),
            mask (RATING_ATC (), 82),
            mask (RMR_DETER_DAM (), 83),
            mask (RMR_DETER_HASP (), 84),
            mask (RMR_DISPATCH_DAM (), 85),
            mask (RMR_DISPATCH_HASP (), 86),
            mask (RMR_TOTAL (), 87),
            mask (RMR_TOTAL_AVAIL (), 88),
            mask (RUC_GEN_CLEAR_RUC (), 89),
            mask (RUC_IMP_CLEAR_RUC (), 90),
            mask (RUC_LOAD_CLEAR_RUC (), 91),
            mask (RUC_ZONE_value (), 92),
            mask (TAC_AREA_value (), 93),
            mask (TINTRFCE_value (), 94),
            mask (TRNS_AS_IMPORT (), 95),
            mask (TRNS_ENE_IMPORT (), 96),
            mask (TRNS_EQUIP_value (), 97),
            mask (TRNS_RATING_CBM (), 98),
            mask (TRNS_RATING_DIRECTION (), 99),
            mask (TRNS_RATING_OTC (), 100),
            mask (TRNS_RATING_OTC_DERATE (), 101),
            mask (TRNS_RATING_TTC (), 102),
            mask (TRNS_TI_value (), 103),
            mask (TRNS_TR_ENTMTS (), 104),
            mask (TRNS_TR_USEAGE (), 105)
        )
        ret.bitfields = bitfields
        ret
    }
}

object OASISDataItemsSerializer extends CIMSerializer[OASISDataItems]
{
    def write (kryo: Kryo, output: Output, obj: OASISDataItems): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.AS_CLEAR_ASMP_IFM),
            () => output.writeString (obj.AS_CLEAR_ASMP_RTM),
            () => output.writeString (obj.AS_CLEAR_COST_IFM),
            () => output.writeString (obj.AS_CLEAR_COST_RTM),
            () => output.writeString (obj.AS_CLEAR_MW_IFM),
            () => output.writeString (obj.AS_CLEAR_MW_RTM),
            () => output.writeString (obj.AS_GEN_TOTAL_MW_IFM),
            () => output.writeString (obj.AS_GEN_TOTAL_MW_RTM),
            () => output.writeString (obj.AS_IMP_TOTAL_MW_IFM),
            () => output.writeString (obj.AS_IMP_TOTAL_MW_RTM),
            () => output.writeString (obj.AS_LOAD_TOTAL_MW_IFM),
            () => output.writeString (obj.AS_LOAD_TOTAL_MW_RTM),
            () => output.writeString (obj.AS_REGION_REQ_MAX),
            () => output.writeString (obj.AS_REGION_REQ_MIN),
            () => output.writeString (obj.AS_REGION_value),
            () => output.writeString (obj.AS_SELF_MW_IFM),
            () => output.writeString (obj.AS_SELF_MW_RTM),
            () => output.writeString (obj.AS_TOTAL_MW),
            () => output.writeString (obj.AS_TOTAL_MW_IFM),
            () => output.writeString (obj.AS_TOTAL_MW_RTM),
            () => output.writeString (obj.AS_TYPE),
            () => output.writeString (obj.AS_USER_RATE),
            () => output.writeString (obj.CA_value),
            () => output.writeString (obj.CMMT_MINLOAD_MLC),
            () => output.writeString (obj.CMMT_MINLOAD_MW),
            () => output.writeString (obj.CMMT_RA_MLC),
            () => output.writeString (obj.CMMT_RA_MW),
            () => output.writeString (obj.CMMT_RA_START_COST),
            () => output.writeString (obj.CMMT_RA_UNITS),
            () => output.writeString (obj.CMMT_TOTAL_MW),
            () => output.writeString (obj.CMMT_TOTAL_START_COST),
            () => output.writeString (obj.CMMT_TOTAL_UNITS),
            () => output.writeString (obj.CRR_CAT),
            () => output.writeString (obj.CRR_MARKET_value),
            () => output.writeString (obj.CRR_MW),
            () => output.writeString (obj.CRR_NSR),
            () => output.writeString (obj.CRR_OPTION),
            () => output.writeString (obj.CRR_OWNER),
            () => output.writeString (obj.CRR_SEGMENT),
            () => output.writeString (obj.CRR_TERM),
            () => output.writeString (obj.CRR_TOU),
            () => output.writeString (obj.CRR_TYPE),
            () => output.writeString (obj.ENE_EA_DA),
            () => output.writeString (obj.ENE_EA_EXCEPT),
            () => output.writeString (obj.ENE_EA_HASP),
            () => output.writeString (obj.ENE_EA_MLE),
            () => output.writeString (obj.ENE_EA_MSSLF),
            () => output.writeString (obj.ENE_EA_OPTIMAL),
            () => output.writeString (obj.ENE_EA_RAMP_DEV),
            () => output.writeString (obj.ENE_EA_RAMP_STD),
            () => output.writeString (obj.ENE_EA_RESIDUAL),
            () => output.writeString (obj.ENE_EA_RMR),
            () => output.writeString (obj.ENE_EA_SELF),
            () => output.writeString (obj.ENE_EA_SLIC),
            () => output.writeString (obj.ENE_EXP_CLEAR_HASP),
            () => output.writeString (obj.ENE_EXP_CLEAR_IFM),
            () => output.writeString (obj.ENE_EXP_CLEAR_RTM),
            () => output.writeString (obj.ENE_GEN_CLEAR_HASP),
            () => output.writeString (obj.ENE_GEN_CLEAR_IFM),
            () => output.writeString (obj.ENE_GEN_CLEAR_RTM),
            () => output.writeString (obj.ENE_IMP_CLEAR_HASP),
            () => output.writeString (obj.ENE_IMP_CLEAR_IFM),
            () => output.writeString (obj.ENE_IMP_CLEAR_RTM),
            () => output.writeString (obj.ENE_LOAD_ACTUAL),
            () => output.writeString (obj.ENE_LOAD_CLEAR_HASP),
            () => output.writeString (obj.ENE_LOAD_CLEAR_IFM),
            () => output.writeString (obj.ENE_LOAD_CLEAR_RTM),
            () => output.writeString (obj.ENE_LOAD_FCST),
            () => output.writeString (obj.ENE_PEAK_HOUR),
            () => output.writeString (obj.ENE_PEAK_LOAD),
            () => output.writeString (obj.FUEL_REGION_value),
            () => output.writeString (obj.INVT_DATETIME),
            () => output.writeString (obj.LOAD_ACTUAL),
            () => output.writeString (obj.LOAD_CLEAR_RTM),
            () => output.writeString (obj.LOSS_TOTAL_COST_HASP),
            () => output.writeString (obj.LOSS_TOTAL_COST_RTM),
            () => output.writeString (obj.LOSS_TOTAL_MW_HASP),
            () => output.writeString (obj.LOSS_TOTAL_MW_RTM),
            () => output.writeString (obj.MPM_FLAG),
            () => output.writeString (obj.OP_RSRV_TOTAL),
            () => output.writeString (obj.PRC_NG),
            () => output.writeString (obj.PRC_SHADOW),
            () => output.writeString (obj.RATING_ATC),
            () => output.writeString (obj.RMR_DETER_DAM),
            () => output.writeString (obj.RMR_DETER_HASP),
            () => output.writeString (obj.RMR_DISPATCH_DAM),
            () => output.writeString (obj.RMR_DISPATCH_HASP),
            () => output.writeString (obj.RMR_TOTAL),
            () => output.writeString (obj.RMR_TOTAL_AVAIL),
            () => output.writeString (obj.RUC_GEN_CLEAR_RUC),
            () => output.writeString (obj.RUC_IMP_CLEAR_RUC),
            () => output.writeString (obj.RUC_LOAD_CLEAR_RUC),
            () => output.writeString (obj.RUC_ZONE_value),
            () => output.writeString (obj.TAC_AREA_value),
            () => output.writeString (obj.TINTRFCE_value),
            () => output.writeString (obj.TRNS_AS_IMPORT),
            () => output.writeString (obj.TRNS_ENE_IMPORT),
            () => output.writeString (obj.TRNS_EQUIP_value),
            () => output.writeString (obj.TRNS_RATING_CBM),
            () => output.writeString (obj.TRNS_RATING_DIRECTION),
            () => output.writeString (obj.TRNS_RATING_OTC),
            () => output.writeString (obj.TRNS_RATING_OTC_DERATE),
            () => output.writeString (obj.TRNS_RATING_TTC),
            () => output.writeString (obj.TRNS_TI_value),
            () => output.writeString (obj.TRNS_TR_ENTMTS),
            () => output.writeString (obj.TRNS_TR_USEAGE)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OASISDataItems]): OASISDataItems =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OASISDataItems (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) input.readString else null,
            if (isSet (11)) input.readString else null,
            if (isSet (12)) input.readString else null,
            if (isSet (13)) input.readString else null,
            if (isSet (14)) input.readString else null,
            if (isSet (15)) input.readString else null,
            if (isSet (16)) input.readString else null,
            if (isSet (17)) input.readString else null,
            if (isSet (18)) input.readString else null,
            if (isSet (19)) input.readString else null,
            if (isSet (20)) input.readString else null,
            if (isSet (21)) input.readString else null,
            if (isSet (22)) input.readString else null,
            if (isSet (23)) input.readString else null,
            if (isSet (24)) input.readString else null,
            if (isSet (25)) input.readString else null,
            if (isSet (26)) input.readString else null,
            if (isSet (27)) input.readString else null,
            if (isSet (28)) input.readString else null,
            if (isSet (29)) input.readString else null,
            if (isSet (30)) input.readString else null,
            if (isSet (31)) input.readString else null,
            if (isSet (32)) input.readString else null,
            if (isSet (33)) input.readString else null,
            if (isSet (34)) input.readString else null,
            if (isSet (35)) input.readString else null,
            if (isSet (36)) input.readString else null,
            if (isSet (37)) input.readString else null,
            if (isSet (38)) input.readString else null,
            if (isSet (39)) input.readString else null,
            if (isSet (40)) input.readString else null,
            if (isSet (41)) input.readString else null,
            if (isSet (42)) input.readString else null,
            if (isSet (43)) input.readString else null,
            if (isSet (44)) input.readString else null,
            if (isSet (45)) input.readString else null,
            if (isSet (46)) input.readString else null,
            if (isSet (47)) input.readString else null,
            if (isSet (48)) input.readString else null,
            if (isSet (49)) input.readString else null,
            if (isSet (50)) input.readString else null,
            if (isSet (51)) input.readString else null,
            if (isSet (52)) input.readString else null,
            if (isSet (53)) input.readString else null,
            if (isSet (54)) input.readString else null,
            if (isSet (55)) input.readString else null,
            if (isSet (56)) input.readString else null,
            if (isSet (57)) input.readString else null,
            if (isSet (58)) input.readString else null,
            if (isSet (59)) input.readString else null,
            if (isSet (60)) input.readString else null,
            if (isSet (61)) input.readString else null,
            if (isSet (62)) input.readString else null,
            if (isSet (63)) input.readString else null,
            if (isSet (64)) input.readString else null,
            if (isSet (65)) input.readString else null,
            if (isSet (66)) input.readString else null,
            if (isSet (67)) input.readString else null,
            if (isSet (68)) input.readString else null,
            if (isSet (69)) input.readString else null,
            if (isSet (70)) input.readString else null,
            if (isSet (71)) input.readString else null,
            if (isSet (72)) input.readString else null,
            if (isSet (73)) input.readString else null,
            if (isSet (74)) input.readString else null,
            if (isSet (75)) input.readString else null,
            if (isSet (76)) input.readString else null,
            if (isSet (77)) input.readString else null,
            if (isSet (78)) input.readString else null,
            if (isSet (79)) input.readString else null,
            if (isSet (80)) input.readString else null,
            if (isSet (81)) input.readString else null,
            if (isSet (82)) input.readString else null,
            if (isSet (83)) input.readString else null,
            if (isSet (84)) input.readString else null,
            if (isSet (85)) input.readString else null,
            if (isSet (86)) input.readString else null,
            if (isSet (87)) input.readString else null,
            if (isSet (88)) input.readString else null,
            if (isSet (89)) input.readString else null,
            if (isSet (90)) input.readString else null,
            if (isSet (91)) input.readString else null,
            if (isSet (92)) input.readString else null,
            if (isSet (93)) input.readString else null,
            if (isSet (94)) input.readString else null,
            if (isSet (95)) input.readString else null,
            if (isSet (96)) input.readString else null,
            if (isSet (97)) input.readString else null,
            if (isSet (98)) input.readString else null,
            if (isSet (99)) input.readString else null,
            if (isSet (100)) input.readString else null,
            if (isSet (101)) input.readString else null,
            if (isSet (102)) input.readString else null,
            if (isSet (103)) input.readString else null,
            if (isSet (104)) input.readString else null,
            if (isSet (105)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class OASISErrCode
(
    Element: BasicElement = null,
    _1000: String = null,
    _1001: String = null,
    _1002: String = null,
    _1003: String = null,
    _1004: String = null,
    _1005: String = null,
    _1006: String = null,
    _1007: String = null,
    _1008: String = null,
    _1009: String = null,
    _1010: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OASISErrCode.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OASISErrCode.fields (position), value)
        emitattr (0, _1000)
        emitattr (1, _1001)
        emitattr (2, _1002)
        emitattr (3, _1003)
        emitattr (4, _1004)
        emitattr (5, _1005)
        emitattr (6, _1006)
        emitattr (7, _1007)
        emitattr (8, _1008)
        emitattr (9, _1009)
        emitattr (10, _1010)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OASISErrCode rdf:ID=\"%s\">\n%s\t</cim:OASISErrCode>".format (id, export_fields)
    }
}

object OASISErrCode
extends
    CIMParseable[OASISErrCode]
{
    override val fields: Array[String] = Array[String] (
        "1000",
        "1001",
        "1002",
        "1003",
        "1004",
        "1005",
        "1006",
        "1007",
        "1008",
        "1009",
        "1010"
    )
    val _1000: Fielder = parse_attribute (attribute (cls, fields(0)))
    val _1001: Fielder = parse_attribute (attribute (cls, fields(1)))
    val _1002: Fielder = parse_attribute (attribute (cls, fields(2)))
    val _1003: Fielder = parse_attribute (attribute (cls, fields(3)))
    val _1004: Fielder = parse_attribute (attribute (cls, fields(4)))
    val _1005: Fielder = parse_attribute (attribute (cls, fields(5)))
    val _1006: Fielder = parse_attribute (attribute (cls, fields(6)))
    val _1007: Fielder = parse_attribute (attribute (cls, fields(7)))
    val _1008: Fielder = parse_attribute (attribute (cls, fields(8)))
    val _1009: Fielder = parse_attribute (attribute (cls, fields(9)))
    val _1010: Fielder = parse_attribute (attribute (cls, fields(10)))

    def parse (context: CIMContext): OASISErrCode =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OASISErrCode (
            BasicElement.parse (context),
            mask (_1000 (), 0),
            mask (_1001 (), 1),
            mask (_1002 (), 2),
            mask (_1003 (), 3),
            mask (_1004 (), 4),
            mask (_1005 (), 5),
            mask (_1006 (), 6),
            mask (_1007 (), 7),
            mask (_1008 (), 8),
            mask (_1009 (), 9),
            mask (_1010 (), 10)
        )
        ret.bitfields = bitfields
        ret
    }
}

object OASISErrCodeSerializer extends CIMSerializer[OASISErrCode]
{
    def write (kryo: Kryo, output: Output, obj: OASISErrCode): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj._1000),
            () => output.writeString (obj._1001),
            () => output.writeString (obj._1002),
            () => output.writeString (obj._1003),
            () => output.writeString (obj._1004),
            () => output.writeString (obj._1005),
            () => output.writeString (obj._1006),
            () => output.writeString (obj._1007),
            () => output.writeString (obj._1008),
            () => output.writeString (obj._1009),
            () => output.writeString (obj._1010)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OASISErrCode]): OASISErrCode =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OASISErrCode (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class OASISErrDescription
(
    Element: BasicElement = null,
    Data_can_be_requested_for_period_of_31_days_only: String = null,
    Exceptions_in_reading_and_writing_of_XML_files: String = null,
    Invalid_date_format__please_use_valid_date_format: String = null,
    No_data_returned_for_the_specified_selection: String = null,
    Out_of_memory_exception: String = null,
    Report_name_does_not_exit__please_use_valid_report_name: String = null,
    Required_file_does_not_exist: String = null,
    System_Error: String = null,
    Timed_out_waiting_for_query_response: String = null,
    Validation_exception_during_transformation_of_XML: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OASISErrDescription.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OASISErrDescription.fields (position), value)
        emitattr (0, Data_can_be_requested_for_period_of_31_days_only)
        emitattr (1, Exceptions_in_reading_and_writing_of_XML_files)
        emitattr (2, Invalid_date_format__please_use_valid_date_format)
        emitattr (3, No_data_returned_for_the_specified_selection)
        emitattr (4, Out_of_memory_exception)
        emitattr (5, Report_name_does_not_exit__please_use_valid_report_name)
        emitattr (6, Required_file_does_not_exist)
        emitattr (7, System_Error)
        emitattr (8, Timed_out_waiting_for_query_response)
        emitattr (9, Validation_exception_during_transformation_of_XML)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OASISErrDescription rdf:ID=\"%s\">\n%s\t</cim:OASISErrDescription>".format (id, export_fields)
    }
}

object OASISErrDescription
extends
    CIMParseable[OASISErrDescription]
{
    override val fields: Array[String] = Array[String] (
        "Data can be requested for period of 31 days only",
        "Exceptions in reading and writing of XML files",
        "Invalid date format, please use valid date format",
        "No data returned for the specified selection",
        "Out of memory exception",
        "Report name does not exit, please use valid report name",
        "Required file does not exist",
        "System Error",
        "Timed out waiting for query response",
        "Validation exception during transformation of XML"
    )
    val Data_can_be_requested_for_period_of_31_days_only: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Exceptions_in_reading_and_writing_of_XML_files: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Invalid_date_format__please_use_valid_date_format: Fielder = parse_attribute (attribute (cls, fields(2)))
    val No_data_returned_for_the_specified_selection: Fielder = parse_attribute (attribute (cls, fields(3)))
    val Out_of_memory_exception: Fielder = parse_attribute (attribute (cls, fields(4)))
    val Report_name_does_not_exit__please_use_valid_report_name: Fielder = parse_attribute (attribute (cls, fields(5)))
    val Required_file_does_not_exist: Fielder = parse_attribute (attribute (cls, fields(6)))
    val System_Error: Fielder = parse_attribute (attribute (cls, fields(7)))
    val Timed_out_waiting_for_query_response: Fielder = parse_attribute (attribute (cls, fields(8)))
    val Validation_exception_during_transformation_of_XML: Fielder = parse_attribute (attribute (cls, fields(9)))

    def parse (context: CIMContext): OASISErrDescription =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OASISErrDescription (
            BasicElement.parse (context),
            mask (Data_can_be_requested_for_period_of_31_days_only (), 0),
            mask (Exceptions_in_reading_and_writing_of_XML_files (), 1),
            mask (Invalid_date_format__please_use_valid_date_format (), 2),
            mask (No_data_returned_for_the_specified_selection (), 3),
            mask (Out_of_memory_exception (), 4),
            mask (Report_name_does_not_exit__please_use_valid_report_name (), 5),
            mask (Required_file_does_not_exist (), 6),
            mask (System_Error (), 7),
            mask (Timed_out_waiting_for_query_response (), 8),
            mask (Validation_exception_during_transformation_of_XML (), 9)
        )
        ret.bitfields = bitfields
        ret
    }
}

object OASISErrDescriptionSerializer extends CIMSerializer[OASISErrDescription]
{
    def write (kryo: Kryo, output: Output, obj: OASISErrDescription): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.Data_can_be_requested_for_period_of_31_days_only),
            () => output.writeString (obj.Exceptions_in_reading_and_writing_of_XML_files),
            () => output.writeString (obj.Invalid_date_format__please_use_valid_date_format),
            () => output.writeString (obj.No_data_returned_for_the_specified_selection),
            () => output.writeString (obj.Out_of_memory_exception),
            () => output.writeString (obj.Report_name_does_not_exit__please_use_valid_report_name),
            () => output.writeString (obj.Required_file_does_not_exist),
            () => output.writeString (obj.System_Error),
            () => output.writeString (obj.Timed_out_waiting_for_query_response),
            () => output.writeString (obj.Validation_exception_during_transformation_of_XML)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OASISErrDescription]): OASISErrDescription =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OASISErrDescription (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class OASISIntervalType
(
    Element: BasicElement = null,
    BEGINNING: String = null,
    ENDING: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OASISIntervalType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OASISIntervalType.fields (position), value)
        emitattr (0, BEGINNING)
        emitattr (1, ENDING)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OASISIntervalType rdf:ID=\"%s\">\n%s\t</cim:OASISIntervalType>".format (id, export_fields)
    }
}

object OASISIntervalType
extends
    CIMParseable[OASISIntervalType]
{
    override val fields: Array[String] = Array[String] (
        "BEGINNING",
        "ENDING"
    )
    val BEGINNING: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ENDING: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): OASISIntervalType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OASISIntervalType (
            BasicElement.parse (context),
            mask (BEGINNING (), 0),
            mask (ENDING (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object OASISIntervalTypeSerializer extends CIMSerializer[OASISIntervalType]
{
    def write (kryo: Kryo, output: Output, obj: OASISIntervalType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.BEGINNING),
            () => output.writeString (obj.ENDING)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OASISIntervalType]): OASISIntervalType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OASISIntervalType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class OASISMarketType
(
    Element: BasicElement = null,
    All: String = null,
    HASP: String = null,
    IFM: String = null,
    N_A: String = null,
    RTM: String = null,
    RUC: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OASISMarketType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OASISMarketType.fields (position), value)
        emitattr (0, All)
        emitattr (1, HASP)
        emitattr (2, IFM)
        emitattr (3, N_A)
        emitattr (4, RTM)
        emitattr (5, RUC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OASISMarketType rdf:ID=\"%s\">\n%s\t</cim:OASISMarketType>".format (id, export_fields)
    }
}

object OASISMarketType
extends
    CIMParseable[OASISMarketType]
{
    override val fields: Array[String] = Array[String] (
        "All",
        "HASP",
        "IFM",
        "N/A",
        "RTM",
        "RUC"
    )
    val All: Fielder = parse_attribute (attribute (cls, fields(0)))
    val HASP: Fielder = parse_attribute (attribute (cls, fields(1)))
    val IFM: Fielder = parse_attribute (attribute (cls, fields(2)))
    val N_A: Fielder = parse_attribute (attribute (cls, fields(3)))
    val RTM: Fielder = parse_attribute (attribute (cls, fields(4)))
    val RUC: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: CIMContext): OASISMarketType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OASISMarketType (
            BasicElement.parse (context),
            mask (All (), 0),
            mask (HASP (), 1),
            mask (IFM (), 2),
            mask (N_A (), 3),
            mask (RTM (), 4),
            mask (RUC (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

object OASISMarketTypeSerializer extends CIMSerializer[OASISMarketType]
{
    def write (kryo: Kryo, output: Output, obj: OASISMarketType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.All),
            () => output.writeString (obj.HASP),
            () => output.writeString (obj.IFM),
            () => output.writeString (obj.N_A),
            () => output.writeString (obj.RTM),
            () => output.writeString (obj.RUC)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OASISMarketType]): OASISMarketType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OASISMarketType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class OASISMasterType
(
    Element: BasicElement = null,
    ATL_APNODE: String = null,
    ATL_AS_REGION: String = null,
    ATL_AS_REGION_MAP: String = null,
    ATL_HUB: String = null,
    ATL_LAP: String = null,
    ATL_LDF: String = null,
    ATL_PNODE: String = null,
    ATL_PNODE_MAP: String = null,
    ATL_PUB: String = null,
    ATL_PUB_SCHED: String = null,
    ATL_RESOURCE: String = null,
    ATL_RUC_ZONE: String = null,
    ATL_RUC_ZONE_MAP: String = null,
    ATL_STAT: String = null,
    ATL_TAC_AREA: String = null,
    ATL_TAC_AREA_MAP: String = null,
    ATL_TI: String = null,
    ATL_TIEPOINT: String = null,
    ATL_XREF: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OASISMasterType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OASISMasterType.fields (position), value)
        emitattr (0, ATL_APNODE)
        emitattr (1, ATL_AS_REGION)
        emitattr (2, ATL_AS_REGION_MAP)
        emitattr (3, ATL_HUB)
        emitattr (4, ATL_LAP)
        emitattr (5, ATL_LDF)
        emitattr (6, ATL_PNODE)
        emitattr (7, ATL_PNODE_MAP)
        emitattr (8, ATL_PUB)
        emitattr (9, ATL_PUB_SCHED)
        emitattr (10, ATL_RESOURCE)
        emitattr (11, ATL_RUC_ZONE)
        emitattr (12, ATL_RUC_ZONE_MAP)
        emitattr (13, ATL_STAT)
        emitattr (14, ATL_TAC_AREA)
        emitattr (15, ATL_TAC_AREA_MAP)
        emitattr (16, ATL_TI)
        emitattr (17, ATL_TIEPOINT)
        emitattr (18, ATL_XREF)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OASISMasterType rdf:ID=\"%s\">\n%s\t</cim:OASISMasterType>".format (id, export_fields)
    }
}

object OASISMasterType
extends
    CIMParseable[OASISMasterType]
{
    override val fields: Array[String] = Array[String] (
        "ATL_APNODE",
        "ATL_AS_REGION",
        "ATL_AS_REGION_MAP",
        "ATL_HUB",
        "ATL_LAP",
        "ATL_LDF",
        "ATL_PNODE",
        "ATL_PNODE_MAP",
        "ATL_PUB",
        "ATL_PUB_SCHED",
        "ATL_RESOURCE",
        "ATL_RUC_ZONE",
        "ATL_RUC_ZONE_MAP",
        "ATL_STAT",
        "ATL_TAC_AREA",
        "ATL_TAC_AREA_MAP",
        "ATL_TI",
        "ATL_TIEPOINT",
        "ATL_XREF"
    )
    val ATL_APNODE: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ATL_AS_REGION: Fielder = parse_attribute (attribute (cls, fields(1)))
    val ATL_AS_REGION_MAP: Fielder = parse_attribute (attribute (cls, fields(2)))
    val ATL_HUB: Fielder = parse_attribute (attribute (cls, fields(3)))
    val ATL_LAP: Fielder = parse_attribute (attribute (cls, fields(4)))
    val ATL_LDF: Fielder = parse_attribute (attribute (cls, fields(5)))
    val ATL_PNODE: Fielder = parse_attribute (attribute (cls, fields(6)))
    val ATL_PNODE_MAP: Fielder = parse_attribute (attribute (cls, fields(7)))
    val ATL_PUB: Fielder = parse_attribute (attribute (cls, fields(8)))
    val ATL_PUB_SCHED: Fielder = parse_attribute (attribute (cls, fields(9)))
    val ATL_RESOURCE: Fielder = parse_attribute (attribute (cls, fields(10)))
    val ATL_RUC_ZONE: Fielder = parse_attribute (attribute (cls, fields(11)))
    val ATL_RUC_ZONE_MAP: Fielder = parse_attribute (attribute (cls, fields(12)))
    val ATL_STAT: Fielder = parse_attribute (attribute (cls, fields(13)))
    val ATL_TAC_AREA: Fielder = parse_attribute (attribute (cls, fields(14)))
    val ATL_TAC_AREA_MAP: Fielder = parse_attribute (attribute (cls, fields(15)))
    val ATL_TI: Fielder = parse_attribute (attribute (cls, fields(16)))
    val ATL_TIEPOINT: Fielder = parse_attribute (attribute (cls, fields(17)))
    val ATL_XREF: Fielder = parse_attribute (attribute (cls, fields(18)))

    def parse (context: CIMContext): OASISMasterType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OASISMasterType (
            BasicElement.parse (context),
            mask (ATL_APNODE (), 0),
            mask (ATL_AS_REGION (), 1),
            mask (ATL_AS_REGION_MAP (), 2),
            mask (ATL_HUB (), 3),
            mask (ATL_LAP (), 4),
            mask (ATL_LDF (), 5),
            mask (ATL_PNODE (), 6),
            mask (ATL_PNODE_MAP (), 7),
            mask (ATL_PUB (), 8),
            mask (ATL_PUB_SCHED (), 9),
            mask (ATL_RESOURCE (), 10),
            mask (ATL_RUC_ZONE (), 11),
            mask (ATL_RUC_ZONE_MAP (), 12),
            mask (ATL_STAT (), 13),
            mask (ATL_TAC_AREA (), 14),
            mask (ATL_TAC_AREA_MAP (), 15),
            mask (ATL_TI (), 16),
            mask (ATL_TIEPOINT (), 17),
            mask (ATL_XREF (), 18)
        )
        ret.bitfields = bitfields
        ret
    }
}

object OASISMasterTypeSerializer extends CIMSerializer[OASISMasterType]
{
    def write (kryo: Kryo, output: Output, obj: OASISMasterType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.ATL_APNODE),
            () => output.writeString (obj.ATL_AS_REGION),
            () => output.writeString (obj.ATL_AS_REGION_MAP),
            () => output.writeString (obj.ATL_HUB),
            () => output.writeString (obj.ATL_LAP),
            () => output.writeString (obj.ATL_LDF),
            () => output.writeString (obj.ATL_PNODE),
            () => output.writeString (obj.ATL_PNODE_MAP),
            () => output.writeString (obj.ATL_PUB),
            () => output.writeString (obj.ATL_PUB_SCHED),
            () => output.writeString (obj.ATL_RESOURCE),
            () => output.writeString (obj.ATL_RUC_ZONE),
            () => output.writeString (obj.ATL_RUC_ZONE_MAP),
            () => output.writeString (obj.ATL_STAT),
            () => output.writeString (obj.ATL_TAC_AREA),
            () => output.writeString (obj.ATL_TAC_AREA_MAP),
            () => output.writeString (obj.ATL_TI),
            () => output.writeString (obj.ATL_TIEPOINT),
            () => output.writeString (obj.ATL_XREF)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OASISMasterType]): OASISMasterType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OASISMasterType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) input.readString else null,
            if (isSet (11)) input.readString else null,
            if (isSet (12)) input.readString else null,
            if (isSet (13)) input.readString else null,
            if (isSet (14)) input.readString else null,
            if (isSet (15)) input.readString else null,
            if (isSet (16)) input.readString else null,
            if (isSet (17)) input.readString else null,
            if (isSet (18)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class OASISMeasType
(
    Element: BasicElement = null,
    percent: String = null,
    FACTOR: String = null,
    FLAG: String = null,
    INTEGER: String = null,
    MW: String = null,
    MWh: String = null,
    US$: String = null,
    US$_MW: String = null,
    US$_MWh: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OASISMeasType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OASISMeasType.fields (position), value)
        emitattr (0, percent)
        emitattr (1, FACTOR)
        emitattr (2, FLAG)
        emitattr (3, INTEGER)
        emitattr (4, MW)
        emitattr (5, MWh)
        emitattr (6, US$)
        emitattr (7, US$_MW)
        emitattr (8, US$_MWh)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OASISMeasType rdf:ID=\"%s\">\n%s\t</cim:OASISMeasType>".format (id, export_fields)
    }
}

object OASISMeasType
extends
    CIMParseable[OASISMeasType]
{
    override val fields: Array[String] = Array[String] (
        "%",
        "FACTOR",
        "FLAG",
        "INTEGER",
        "MW",
        "MWh",
        "US$",
        "US$/MW",
        "US$/MWh"
    )
    val percent: Fielder = parse_attribute (attribute (cls, fields(0)))
    val FACTOR: Fielder = parse_attribute (attribute (cls, fields(1)))
    val FLAG: Fielder = parse_attribute (attribute (cls, fields(2)))
    val INTEGER: Fielder = parse_attribute (attribute (cls, fields(3)))
    val MW: Fielder = parse_attribute (attribute (cls, fields(4)))
    val MWh: Fielder = parse_attribute (attribute (cls, fields(5)))
    val US$: Fielder = parse_attribute (attribute (cls, fields(6)))
    val US$_MW: Fielder = parse_attribute (attribute (cls, fields(7)))
    val US$_MWh: Fielder = parse_attribute (attribute (cls, fields(8)))

    def parse (context: CIMContext): OASISMeasType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OASISMeasType (
            BasicElement.parse (context),
            mask (percent (), 0),
            mask (FACTOR (), 1),
            mask (FLAG (), 2),
            mask (INTEGER (), 3),
            mask (MW (), 4),
            mask (MWh (), 5),
            mask (US$ (), 6),
            mask (US$_MW (), 7),
            mask (US$_MWh (), 8)
        )
        ret.bitfields = bitfields
        ret
    }
}

object OASISMeasTypeSerializer extends CIMSerializer[OASISMeasType]
{
    def write (kryo: Kryo, output: Output, obj: OASISMeasType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.percent),
            () => output.writeString (obj.FACTOR),
            () => output.writeString (obj.FLAG),
            () => output.writeString (obj.INTEGER),
            () => output.writeString (obj.MW),
            () => output.writeString (obj.MWh),
            () => output.writeString (obj.US$),
            () => output.writeString (obj.US$_MW),
            () => output.writeString (obj.US$_MWh)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OASISMeasType]): OASISMeasType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OASISMeasType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class OASISReportType
(
    Element: BasicElement = null,
    AS_DA_RESULT: String = null,
    AS_OP_RSRV: String = null,
    AS_REQ: String = null,
    AS_RTM_RESULT: String = null,
    BIDS_PUBLIC: String = null,
    CMMT_RA_MLC: String = null,
    CMMT_RMR: String = null,
    CRR_CLEARING: String = null,
    CRR_INVENTORY: String = null,
    ENE_EA: String = null,
    ENE_HASP: String = null,
    ENE_IFM: String = null,
    ENE_MPM: String = null,
    ENE_RTM: String = null,
    ENE_RUC: String = null,
    LOSS_DA_HASP: String = null,
    LOSS_RTM: String = null,
    PRC_AS: String = null,
    PRC_CNSTR: String = null,
    PRC_FUEL: String = null,
    PRC_HRLY_LMP: String = null,
    PRC_INTVL_LMP: String = null,
    SLD_FCST: String = null,
    SLD_FCST_PEAK: String = null,
    SLD_MKTS: String = null,
    TRNS_ATC: String = null,
    TRNS_OUTAGE: String = null,
    TRNS_USAGE: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OASISReportType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OASISReportType.fields (position), value)
        emitattr (0, AS_DA_RESULT)
        emitattr (1, AS_OP_RSRV)
        emitattr (2, AS_REQ)
        emitattr (3, AS_RTM_RESULT)
        emitattr (4, BIDS_PUBLIC)
        emitattr (5, CMMT_RA_MLC)
        emitattr (6, CMMT_RMR)
        emitattr (7, CRR_CLEARING)
        emitattr (8, CRR_INVENTORY)
        emitattr (9, ENE_EA)
        emitattr (10, ENE_HASP)
        emitattr (11, ENE_IFM)
        emitattr (12, ENE_MPM)
        emitattr (13, ENE_RTM)
        emitattr (14, ENE_RUC)
        emitattr (15, LOSS_DA_HASP)
        emitattr (16, LOSS_RTM)
        emitattr (17, PRC_AS)
        emitattr (18, PRC_CNSTR)
        emitattr (19, PRC_FUEL)
        emitattr (20, PRC_HRLY_LMP)
        emitattr (21, PRC_INTVL_LMP)
        emitattr (22, SLD_FCST)
        emitattr (23, SLD_FCST_PEAK)
        emitattr (24, SLD_MKTS)
        emitattr (25, TRNS_ATC)
        emitattr (26, TRNS_OUTAGE)
        emitattr (27, TRNS_USAGE)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OASISReportType rdf:ID=\"%s\">\n%s\t</cim:OASISReportType>".format (id, export_fields)
    }
}

object OASISReportType
extends
    CIMParseable[OASISReportType]
{
    override val fields: Array[String] = Array[String] (
        "AS_DA_RESULT",
        "AS_OP_RSRV",
        "AS_REQ",
        "AS_RTM_RESULT",
        "BIDS_PUBLIC",
        "CMMT_RA_MLC",
        "CMMT_RMR",
        "CRR_CLEARING",
        "CRR_INVENTORY",
        "ENE_EA",
        "ENE_HASP",
        "ENE_IFM",
        "ENE_MPM",
        "ENE_RTM",
        "ENE_RUC",
        "LOSS_DA_HASP",
        "LOSS_RTM",
        "PRC_AS",
        "PRC_CNSTR",
        "PRC_FUEL",
        "PRC_HRLY_LMP",
        "PRC_INTVL_LMP",
        "SLD_FCST",
        "SLD_FCST_PEAK",
        "SLD_MKTS",
        "TRNS_ATC",
        "TRNS_OUTAGE",
        "TRNS_USAGE"
    )
    val AS_DA_RESULT: Fielder = parse_attribute (attribute (cls, fields(0)))
    val AS_OP_RSRV: Fielder = parse_attribute (attribute (cls, fields(1)))
    val AS_REQ: Fielder = parse_attribute (attribute (cls, fields(2)))
    val AS_RTM_RESULT: Fielder = parse_attribute (attribute (cls, fields(3)))
    val BIDS_PUBLIC: Fielder = parse_attribute (attribute (cls, fields(4)))
    val CMMT_RA_MLC: Fielder = parse_attribute (attribute (cls, fields(5)))
    val CMMT_RMR: Fielder = parse_attribute (attribute (cls, fields(6)))
    val CRR_CLEARING: Fielder = parse_attribute (attribute (cls, fields(7)))
    val CRR_INVENTORY: Fielder = parse_attribute (attribute (cls, fields(8)))
    val ENE_EA: Fielder = parse_attribute (attribute (cls, fields(9)))
    val ENE_HASP: Fielder = parse_attribute (attribute (cls, fields(10)))
    val ENE_IFM: Fielder = parse_attribute (attribute (cls, fields(11)))
    val ENE_MPM: Fielder = parse_attribute (attribute (cls, fields(12)))
    val ENE_RTM: Fielder = parse_attribute (attribute (cls, fields(13)))
    val ENE_RUC: Fielder = parse_attribute (attribute (cls, fields(14)))
    val LOSS_DA_HASP: Fielder = parse_attribute (attribute (cls, fields(15)))
    val LOSS_RTM: Fielder = parse_attribute (attribute (cls, fields(16)))
    val PRC_AS: Fielder = parse_attribute (attribute (cls, fields(17)))
    val PRC_CNSTR: Fielder = parse_attribute (attribute (cls, fields(18)))
    val PRC_FUEL: Fielder = parse_attribute (attribute (cls, fields(19)))
    val PRC_HRLY_LMP: Fielder = parse_attribute (attribute (cls, fields(20)))
    val PRC_INTVL_LMP: Fielder = parse_attribute (attribute (cls, fields(21)))
    val SLD_FCST: Fielder = parse_attribute (attribute (cls, fields(22)))
    val SLD_FCST_PEAK: Fielder = parse_attribute (attribute (cls, fields(23)))
    val SLD_MKTS: Fielder = parse_attribute (attribute (cls, fields(24)))
    val TRNS_ATC: Fielder = parse_attribute (attribute (cls, fields(25)))
    val TRNS_OUTAGE: Fielder = parse_attribute (attribute (cls, fields(26)))
    val TRNS_USAGE: Fielder = parse_attribute (attribute (cls, fields(27)))

    def parse (context: CIMContext): OASISReportType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OASISReportType (
            BasicElement.parse (context),
            mask (AS_DA_RESULT (), 0),
            mask (AS_OP_RSRV (), 1),
            mask (AS_REQ (), 2),
            mask (AS_RTM_RESULT (), 3),
            mask (BIDS_PUBLIC (), 4),
            mask (CMMT_RA_MLC (), 5),
            mask (CMMT_RMR (), 6),
            mask (CRR_CLEARING (), 7),
            mask (CRR_INVENTORY (), 8),
            mask (ENE_EA (), 9),
            mask (ENE_HASP (), 10),
            mask (ENE_IFM (), 11),
            mask (ENE_MPM (), 12),
            mask (ENE_RTM (), 13),
            mask (ENE_RUC (), 14),
            mask (LOSS_DA_HASP (), 15),
            mask (LOSS_RTM (), 16),
            mask (PRC_AS (), 17),
            mask (PRC_CNSTR (), 18),
            mask (PRC_FUEL (), 19),
            mask (PRC_HRLY_LMP (), 20),
            mask (PRC_INTVL_LMP (), 21),
            mask (SLD_FCST (), 22),
            mask (SLD_FCST_PEAK (), 23),
            mask (SLD_MKTS (), 24),
            mask (TRNS_ATC (), 25),
            mask (TRNS_OUTAGE (), 26),
            mask (TRNS_USAGE (), 27)
        )
        ret.bitfields = bitfields
        ret
    }
}

object OASISReportTypeSerializer extends CIMSerializer[OASISReportType]
{
    def write (kryo: Kryo, output: Output, obj: OASISReportType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.AS_DA_RESULT),
            () => output.writeString (obj.AS_OP_RSRV),
            () => output.writeString (obj.AS_REQ),
            () => output.writeString (obj.AS_RTM_RESULT),
            () => output.writeString (obj.BIDS_PUBLIC),
            () => output.writeString (obj.CMMT_RA_MLC),
            () => output.writeString (obj.CMMT_RMR),
            () => output.writeString (obj.CRR_CLEARING),
            () => output.writeString (obj.CRR_INVENTORY),
            () => output.writeString (obj.ENE_EA),
            () => output.writeString (obj.ENE_HASP),
            () => output.writeString (obj.ENE_IFM),
            () => output.writeString (obj.ENE_MPM),
            () => output.writeString (obj.ENE_RTM),
            () => output.writeString (obj.ENE_RUC),
            () => output.writeString (obj.LOSS_DA_HASP),
            () => output.writeString (obj.LOSS_RTM),
            () => output.writeString (obj.PRC_AS),
            () => output.writeString (obj.PRC_CNSTR),
            () => output.writeString (obj.PRC_FUEL),
            () => output.writeString (obj.PRC_HRLY_LMP),
            () => output.writeString (obj.PRC_INTVL_LMP),
            () => output.writeString (obj.SLD_FCST),
            () => output.writeString (obj.SLD_FCST_PEAK),
            () => output.writeString (obj.SLD_MKTS),
            () => output.writeString (obj.TRNS_ATC),
            () => output.writeString (obj.TRNS_OUTAGE),
            () => output.writeString (obj.TRNS_USAGE)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OASISReportType]): OASISReportType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OASISReportType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) input.readString else null,
            if (isSet (11)) input.readString else null,
            if (isSet (12)) input.readString else null,
            if (isSet (13)) input.readString else null,
            if (isSet (14)) input.readString else null,
            if (isSet (15)) input.readString else null,
            if (isSet (16)) input.readString else null,
            if (isSet (17)) input.readString else null,
            if (isSet (18)) input.readString else null,
            if (isSet (19)) input.readString else null,
            if (isSet (20)) input.readString else null,
            if (isSet (21)) input.readString else null,
            if (isSet (22)) input.readString else null,
            if (isSet (23)) input.readString else null,
            if (isSet (24)) input.readString else null,
            if (isSet (25)) input.readString else null,
            if (isSet (26)) input.readString else null,
            if (isSet (27)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class OASISStatusType
(
    Element: BasicElement = null,
    Data_Transfer_Procedure_Initiated: String = null,
    Data_Transfer_Succesful: String = null,
    Forced_Termination: String = null,
    Obsolete: String = null,
    Push_Failed: String = null,
    Valid: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OASISStatusType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OASISStatusType.fields (position), value)
        emitattr (0, Data_Transfer_Procedure_Initiated)
        emitattr (1, Data_Transfer_Succesful)
        emitattr (2, Forced_Termination)
        emitattr (3, Obsolete)
        emitattr (4, Push_Failed)
        emitattr (5, Valid)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OASISStatusType rdf:ID=\"%s\">\n%s\t</cim:OASISStatusType>".format (id, export_fields)
    }
}

object OASISStatusType
extends
    CIMParseable[OASISStatusType]
{
    override val fields: Array[String] = Array[String] (
        "Data_Transfer_Procedure_Initiated",
        "Data_Transfer_Succesful",
        "Forced_Termination",
        "Obsolete",
        "Push_Failed",
        "Valid"
    )
    val Data_Transfer_Procedure_Initiated: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Data_Transfer_Succesful: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Forced_Termination: Fielder = parse_attribute (attribute (cls, fields(2)))
    val Obsolete: Fielder = parse_attribute (attribute (cls, fields(3)))
    val Push_Failed: Fielder = parse_attribute (attribute (cls, fields(4)))
    val Valid: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: CIMContext): OASISStatusType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OASISStatusType (
            BasicElement.parse (context),
            mask (Data_Transfer_Procedure_Initiated (), 0),
            mask (Data_Transfer_Succesful (), 1),
            mask (Forced_Termination (), 2),
            mask (Obsolete (), 3),
            mask (Push_Failed (), 4),
            mask (Valid (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
}

object OASISStatusTypeSerializer extends CIMSerializer[OASISStatusType]
{
    def write (kryo: Kryo, output: Output, obj: OASISStatusType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.Data_Transfer_Procedure_Initiated),
            () => output.writeString (obj.Data_Transfer_Succesful),
            () => output.writeString (obj.Forced_Termination),
            () => output.writeString (obj.Obsolete),
            () => output.writeString (obj.Push_Failed),
            () => output.writeString (obj.Valid)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OASISStatusType]): OASISStatusType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OASISStatusType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * organization code
 *
 * @param Element Reference to the superclass object.
 * @param BILL_TO <em>undocumented</em>
 * @param PAY_TO <em>undocumented</em>
 * @param PROVIDED_BY <em>undocumented</em>
 * @param SOLD_TO <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class OrganisationCode
(
    Element: BasicElement = null,
    BILL_TO: String = null,
    PAY_TO: String = null,
    PROVIDED_BY: String = null,
    SOLD_TO: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OrganisationCode.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OrganisationCode.fields (position), value)
        emitattr (0, BILL_TO)
        emitattr (1, PAY_TO)
        emitattr (2, PROVIDED_BY)
        emitattr (3, SOLD_TO)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OrganisationCode rdf:ID=\"%s\">\n%s\t</cim:OrganisationCode>".format (id, export_fields)
    }
}

object OrganisationCode
extends
    CIMParseable[OrganisationCode]
{
    override val fields: Array[String] = Array[String] (
        "BILL_TO",
        "PAY_TO",
        "PROVIDED_BY",
        "SOLD_TO"
    )
    val BILL_TO: Fielder = parse_attribute (attribute (cls, fields(0)))
    val PAY_TO: Fielder = parse_attribute (attribute (cls, fields(1)))
    val PROVIDED_BY: Fielder = parse_attribute (attribute (cls, fields(2)))
    val SOLD_TO: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): OrganisationCode =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OrganisationCode (
            BasicElement.parse (context),
            mask (BILL_TO (), 0),
            mask (PAY_TO (), 1),
            mask (PROVIDED_BY (), 2),
            mask (SOLD_TO (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

object OrganisationCodeSerializer extends CIMSerializer[OrganisationCode]
{
    def write (kryo: Kryo, output: Output, obj: OrganisationCode): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.BILL_TO),
            () => output.writeString (obj.PAY_TO),
            () => output.writeString (obj.PROVIDED_BY),
            () => output.writeString (obj.SOLD_TO)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OrganisationCode]): OrganisationCode =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OrganisationCode (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * organization type
 *
 * @param Element Reference to the superclass object.
 * @param CUSTOMER <em>undocumented</em>
 * @param RTO <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class OrganisationType
(
    Element: BasicElement = null,
    CUSTOMER: String = null,
    RTO: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = OrganisationType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (OrganisationType.fields (position), value)
        emitattr (0, CUSTOMER)
        emitattr (1, RTO)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:OrganisationType rdf:ID=\"%s\">\n%s\t</cim:OrganisationType>".format (id, export_fields)
    }
}

object OrganisationType
extends
    CIMParseable[OrganisationType]
{
    override val fields: Array[String] = Array[String] (
        "CUSTOMER",
        "RTO"
    )
    val CUSTOMER: Fielder = parse_attribute (attribute (cls, fields(0)))
    val RTO: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): OrganisationType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = OrganisationType (
            BasicElement.parse (context),
            mask (CUSTOMER (), 0),
            mask (RTO (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object OrganisationTypeSerializer extends CIMSerializer[OrganisationType]
{
    def write (kryo: Kryo, output: Output, obj: OrganisationType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.CUSTOMER),
            () => output.writeString (obj.RTO)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[OrganisationType]): OrganisationType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = OrganisationType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Y - indicates a resource is capable of setting the Markte Clearing Price
 * S - indicates the resource must submit bids for energy at \$ 0
 *
 * N - indicates the resource does not have to submit bids for energy at \$ 0
 *
 * @param Element Reference to the superclass object.
 * @param N <em>undocumented</em>
 * @param S <em>undocumented</em>
 * @param Y <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class PriceSetFlag
(
    Element: BasicElement = null,
    N: String = null,
    S: String = null,
    Y: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PriceSetFlag.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PriceSetFlag.fields (position), value)
        emitattr (0, N)
        emitattr (1, S)
        emitattr (2, Y)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PriceSetFlag rdf:ID=\"%s\">\n%s\t</cim:PriceSetFlag>".format (id, export_fields)
    }
}

object PriceSetFlag
extends
    CIMParseable[PriceSetFlag]
{
    override val fields: Array[String] = Array[String] (
        "N",
        "S",
        "Y"
    )
    val N: Fielder = parse_attribute (attribute (cls, fields(0)))
    val S: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Y: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): PriceSetFlag =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PriceSetFlag (
            BasicElement.parse (context),
            mask (N (), 0),
            mask (S (), 1),
            mask (Y (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

object PriceSetFlagSerializer extends CIMSerializer[PriceSetFlag]
{
    def write (kryo: Kryo, output: Output, obj: PriceSetFlag): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.N),
            () => output.writeString (obj.S),
            () => output.writeString (obj.Y)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PriceSetFlag]): PriceSetFlag =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PriceSetFlag (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * MP
 *
 * ISO
 *
 * @param Element Reference to the superclass object.
 * @param ISO <em>undocumented</em>
 * @param MP <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class RequestorRmrTest
(
    Element: BasicElement = null,
    ISO: String = null,
    MP: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = RequestorRmrTest.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (RequestorRmrTest.fields (position), value)
        emitattr (0, ISO)
        emitattr (1, MP)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:RequestorRmrTest rdf:ID=\"%s\">\n%s\t</cim:RequestorRmrTest>".format (id, export_fields)
    }
}

object RequestorRmrTest
extends
    CIMParseable[RequestorRmrTest]
{
    override val fields: Array[String] = Array[String] (
        "ISO",
        "MP"
    )
    val ISO: Fielder = parse_attribute (attribute (cls, fields(0)))
    val MP: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): RequestorRmrTest =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = RequestorRmrTest (
            BasicElement.parse (context),
            mask (ISO (), 0),
            mask (MP (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object RequestorRmrTestSerializer extends CIMSerializer[RequestorRmrTest]
{
    def write (kryo: Kryo, output: Output, obj: RequestorRmrTest): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.ISO),
            () => output.writeString (obj.MP)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[RequestorRmrTest]): RequestorRmrTest =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = RequestorRmrTest (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class ResourceCertificationCategory
(
    Element: BasicElement = null,
    DAM: String = null,
    GT: String = null,
    RC: String = null,
    RTM: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ResourceCertificationCategory.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ResourceCertificationCategory.fields (position), value)
        emitattr (0, DAM)
        emitattr (1, GT)
        emitattr (2, RC)
        emitattr (3, RTM)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ResourceCertificationCategory rdf:ID=\"%s\">\n%s\t</cim:ResourceCertificationCategory>".format (id, export_fields)
    }
}

object ResourceCertificationCategory
extends
    CIMParseable[ResourceCertificationCategory]
{
    override val fields: Array[String] = Array[String] (
        "DAM",
        "GT",
        "RC",
        "RTM"
    )
    val DAM: Fielder = parse_attribute (attribute (cls, fields(0)))
    val GT: Fielder = parse_attribute (attribute (cls, fields(1)))
    val RC: Fielder = parse_attribute (attribute (cls, fields(2)))
    val RTM: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): ResourceCertificationCategory =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ResourceCertificationCategory (
            BasicElement.parse (context),
            mask (DAM (), 0),
            mask (GT (), 1),
            mask (RC (), 2),
            mask (RTM (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

object ResourceCertificationCategorySerializer extends CIMSerializer[ResourceCertificationCategory]
{
    def write (kryo: Kryo, output: Output, obj: ResourceCertificationCategory): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.DAM),
            () => output.writeString (obj.GT),
            () => output.writeString (obj.RC),
            () => output.writeString (obj.RTM)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ResourceCertificationCategory]): ResourceCertificationCategory =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ResourceCertificationCategory (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class ResourceCertificationType
(
    Element: BasicElement = null,
    GT: String = null,
    IR: String = null,
    NR: String = null,
    RG: String = null,
    SR: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ResourceCertificationType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ResourceCertificationType.fields (position), value)
        emitattr (0, GT)
        emitattr (1, IR)
        emitattr (2, NR)
        emitattr (3, RG)
        emitattr (4, SR)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ResourceCertificationType rdf:ID=\"%s\">\n%s\t</cim:ResourceCertificationType>".format (id, export_fields)
    }
}

object ResourceCertificationType
extends
    CIMParseable[ResourceCertificationType]
{
    override val fields: Array[String] = Array[String] (
        "GT",
        "IR",
        "NR",
        "RG",
        "SR"
    )
    val GT: Fielder = parse_attribute (attribute (cls, fields(0)))
    val IR: Fielder = parse_attribute (attribute (cls, fields(1)))
    val NR: Fielder = parse_attribute (attribute (cls, fields(2)))
    val RG: Fielder = parse_attribute (attribute (cls, fields(3)))
    val SR: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: CIMContext): ResourceCertificationType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ResourceCertificationType (
            BasicElement.parse (context),
            mask (GT (), 0),
            mask (IR (), 1),
            mask (NR (), 2),
            mask (RG (), 3),
            mask (SR (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

object ResourceCertificationTypeSerializer extends CIMSerializer[ResourceCertificationType]
{
    def write (kryo: Kryo, output: Output, obj: ResourceCertificationType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.GT),
            () => output.writeString (obj.IR),
            () => output.writeString (obj.NR),
            () => output.writeString (obj.RG),
            () => output.writeString (obj.SR)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ResourceCertificationType]): ResourceCertificationType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ResourceCertificationType (
            parent,
            if (isSet (0)) input.readString else null,
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
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class SchedClassType
(
    Element: BasicElement = null,
    F: String = null,
    P: String = null,
    R: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SchedClassType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SchedClassType.fields (position), value)
        emitattr (0, F)
        emitattr (1, P)
        emitattr (2, R)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SchedClassType rdf:ID=\"%s\">\n%s\t</cim:SchedClassType>".format (id, export_fields)
    }
}

object SchedClassType
extends
    CIMParseable[SchedClassType]
{
    override val fields: Array[String] = Array[String] (
        "F",
        "P",
        "R"
    )
    val F: Fielder = parse_attribute (attribute (cls, fields(0)))
    val P: Fielder = parse_attribute (attribute (cls, fields(1)))
    val R: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): SchedClassType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SchedClassType (
            BasicElement.parse (context),
            mask (F (), 0),
            mask (P (), 1),
            mask (R (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

object SchedClassTypeSerializer extends CIMSerializer[SchedClassType]
{
    def write (kryo: Kryo, output: Output, obj: SchedClassType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.F),
            () => output.writeString (obj.P),
            () => output.writeString (obj.R)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SchedClassType]): SchedClassType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SchedClassType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class SegmentCurveType
(
    Element: BasicElement = null,
    CONSULTATIVE: String = null,
    COST: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SegmentCurveType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SegmentCurveType.fields (position), value)
        emitattr (0, CONSULTATIVE)
        emitattr (1, COST)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SegmentCurveType rdf:ID=\"%s\">\n%s\t</cim:SegmentCurveType>".format (id, export_fields)
    }
}

object SegmentCurveType
extends
    CIMParseable[SegmentCurveType]
{
    override val fields: Array[String] = Array[String] (
        "CONSULTATIVE",
        "COST"
    )
    val CONSULTATIVE: Fielder = parse_attribute (attribute (cls, fields(0)))
    val COST: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): SegmentCurveType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SegmentCurveType (
            BasicElement.parse (context),
            mask (CONSULTATIVE (), 0),
            mask (COST (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object SegmentCurveTypeSerializer extends CIMSerializer[SegmentCurveType]
{
    def write (kryo: Kryo, output: Output, obj: SegmentCurveType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.CONSULTATIVE),
            () => output.writeString (obj.COST)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SegmentCurveType]): SegmentCurveType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SegmentCurveType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class SelfSchedTypeCleanBid
(
    Element: BasicElement = null,
    BAS: String = null,
    ETC: String = null,
    IFM: String = null,
    LOF: String = null,
    LPT: String = null,
    PT: String = null,
    RA: String = null,
    RMT: String = null,
    SP: String = null,
    TOR: String = null,
    WHL: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SelfSchedTypeCleanBid.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SelfSchedTypeCleanBid.fields (position), value)
        emitattr (0, BAS)
        emitattr (1, ETC)
        emitattr (2, IFM)
        emitattr (3, LOF)
        emitattr (4, LPT)
        emitattr (5, PT)
        emitattr (6, RA)
        emitattr (7, RMT)
        emitattr (8, SP)
        emitattr (9, TOR)
        emitattr (10, WHL)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SelfSchedTypeCleanBid rdf:ID=\"%s\">\n%s\t</cim:SelfSchedTypeCleanBid>".format (id, export_fields)
    }
}

object SelfSchedTypeCleanBid
extends
    CIMParseable[SelfSchedTypeCleanBid]
{
    override val fields: Array[String] = Array[String] (
        "BAS",
        "ETC",
        "IFM",
        "LOF",
        "LPT",
        "PT",
        "RA",
        "RMT",
        "SP",
        "TOR",
        "WHL"
    )
    val BAS: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ETC: Fielder = parse_attribute (attribute (cls, fields(1)))
    val IFM: Fielder = parse_attribute (attribute (cls, fields(2)))
    val LOF: Fielder = parse_attribute (attribute (cls, fields(3)))
    val LPT: Fielder = parse_attribute (attribute (cls, fields(4)))
    val PT: Fielder = parse_attribute (attribute (cls, fields(5)))
    val RA: Fielder = parse_attribute (attribute (cls, fields(6)))
    val RMT: Fielder = parse_attribute (attribute (cls, fields(7)))
    val SP: Fielder = parse_attribute (attribute (cls, fields(8)))
    val TOR: Fielder = parse_attribute (attribute (cls, fields(9)))
    val WHL: Fielder = parse_attribute (attribute (cls, fields(10)))

    def parse (context: CIMContext): SelfSchedTypeCleanBid =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SelfSchedTypeCleanBid (
            BasicElement.parse (context),
            mask (BAS (), 0),
            mask (ETC (), 1),
            mask (IFM (), 2),
            mask (LOF (), 3),
            mask (LPT (), 4),
            mask (PT (), 5),
            mask (RA (), 6),
            mask (RMT (), 7),
            mask (SP (), 8),
            mask (TOR (), 9),
            mask (WHL (), 10)
        )
        ret.bitfields = bitfields
        ret
    }
}

object SelfSchedTypeCleanBidSerializer extends CIMSerializer[SelfSchedTypeCleanBid]
{
    def write (kryo: Kryo, output: Output, obj: SelfSchedTypeCleanBid): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.BAS),
            () => output.writeString (obj.ETC),
            () => output.writeString (obj.IFM),
            () => output.writeString (obj.LOF),
            () => output.writeString (obj.LPT),
            () => output.writeString (obj.PT),
            () => output.writeString (obj.RA),
            () => output.writeString (obj.RMT),
            () => output.writeString (obj.SP),
            () => output.writeString (obj.TOR),
            () => output.writeString (obj.WHL)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SelfSchedTypeCleanBid]): SelfSchedTypeCleanBid =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SelfSchedTypeCleanBid (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class SelfSchedTypeRawBid
(
    Element: BasicElement = null,
    BAS: String = null,
    ETC: String = null,
    LOF: String = null,
    LPT: String = null,
    PT: String = null,
    RA: String = null,
    RMT: String = null,
    SP: String = null,
    TOR: String = null,
    WHL: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SelfSchedTypeRawBid.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SelfSchedTypeRawBid.fields (position), value)
        emitattr (0, BAS)
        emitattr (1, ETC)
        emitattr (2, LOF)
        emitattr (3, LPT)
        emitattr (4, PT)
        emitattr (5, RA)
        emitattr (6, RMT)
        emitattr (7, SP)
        emitattr (8, TOR)
        emitattr (9, WHL)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SelfSchedTypeRawBid rdf:ID=\"%s\">\n%s\t</cim:SelfSchedTypeRawBid>".format (id, export_fields)
    }
}

object SelfSchedTypeRawBid
extends
    CIMParseable[SelfSchedTypeRawBid]
{
    override val fields: Array[String] = Array[String] (
        "BAS",
        "ETC",
        "LOF",
        "LPT",
        "PT",
        "RA",
        "RMT",
        "SP",
        "TOR",
        "WHL"
    )
    val BAS: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ETC: Fielder = parse_attribute (attribute (cls, fields(1)))
    val LOF: Fielder = parse_attribute (attribute (cls, fields(2)))
    val LPT: Fielder = parse_attribute (attribute (cls, fields(3)))
    val PT: Fielder = parse_attribute (attribute (cls, fields(4)))
    val RA: Fielder = parse_attribute (attribute (cls, fields(5)))
    val RMT: Fielder = parse_attribute (attribute (cls, fields(6)))
    val SP: Fielder = parse_attribute (attribute (cls, fields(7)))
    val TOR: Fielder = parse_attribute (attribute (cls, fields(8)))
    val WHL: Fielder = parse_attribute (attribute (cls, fields(9)))

    def parse (context: CIMContext): SelfSchedTypeRawBid =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SelfSchedTypeRawBid (
            BasicElement.parse (context),
            mask (BAS (), 0),
            mask (ETC (), 1),
            mask (LOF (), 2),
            mask (LPT (), 3),
            mask (PT (), 4),
            mask (RA (), 5),
            mask (RMT (), 6),
            mask (SP (), 7),
            mask (TOR (), 8),
            mask (WHL (), 9)
        )
        ret.bitfields = bitfields
        ret
    }
}

object SelfSchedTypeRawBidSerializer extends CIMSerializer[SelfSchedTypeRawBid]
{
    def write (kryo: Kryo, output: Output, obj: SelfSchedTypeRawBid): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.BAS),
            () => output.writeString (obj.ETC),
            () => output.writeString (obj.LOF),
            () => output.writeString (obj.LPT),
            () => output.writeString (obj.PT),
            () => output.writeString (obj.RA),
            () => output.writeString (obj.RMT),
            () => output.writeString (obj.SP),
            () => output.writeString (obj.TOR),
            () => output.writeString (obj.WHL)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SelfSchedTypeRawBid]): SelfSchedTypeRawBid =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SelfSchedTypeRawBid (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * self schedule types
 *
 * PT
 * ETC
 * TOR
 * RMR
 * RMT
 * RGMR
 * ORFC
 *
 * SP
 *
 * @param Element Reference to the superclass object.
 * @param BAS Base Schedule
 * @param ETC <em>undocumented</em>
 * @param IFM <em>undocumented</em>
 * @param LOF Lay-off schedule
 * @param ORFC <em>undocumented</em>
 * @param PT <em>undocumented</em>
 * @param PUMP_ETC <em>undocumented</em>
 * @param PUMP_TOR <em>undocumented</em>
 * @param RA RA Obligations
 * @param RGMR <em>undocumented</em>
 * @param RMR <em>undocumented</em>
 * @param RMT <em>undocumented</em>
 * @param RUC <em>undocumented</em>
 * @param SP Self-Provision
 * @param TOR <em>undocumented</em>
 * @param WHL <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class SelfScheduleType
(
    Element: BasicElement = null,
    BAS: String = null,
    ETC: String = null,
    IFM: String = null,
    LOF: String = null,
    ORFC: String = null,
    PT: String = null,
    PUMP_ETC: String = null,
    PUMP_TOR: String = null,
    RA: String = null,
    RGMR: String = null,
    RMR: String = null,
    RMT: String = null,
    RUC: String = null,
    SP: String = null,
    TOR: String = null,
    WHL: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SelfScheduleType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SelfScheduleType.fields (position), value)
        emitattr (0, BAS)
        emitattr (1, ETC)
        emitattr (2, IFM)
        emitattr (3, LOF)
        emitattr (4, ORFC)
        emitattr (5, PT)
        emitattr (6, PUMP_ETC)
        emitattr (7, PUMP_TOR)
        emitattr (8, RA)
        emitattr (9, RGMR)
        emitattr (10, RMR)
        emitattr (11, RMT)
        emitattr (12, RUC)
        emitattr (13, SP)
        emitattr (14, TOR)
        emitattr (15, WHL)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SelfScheduleType rdf:ID=\"%s\">\n%s\t</cim:SelfScheduleType>".format (id, export_fields)
    }
}

object SelfScheduleType
extends
    CIMParseable[SelfScheduleType]
{
    override val fields: Array[String] = Array[String] (
        "BAS",
        "ETC",
        "IFM",
        "LOF",
        "ORFC",
        "PT",
        "PUMP_ETC",
        "PUMP_TOR",
        "RA",
        "RGMR",
        "RMR",
        "RMT",
        "RUC",
        "SP",
        "TOR",
        "WHL"
    )
    val BAS: Fielder = parse_attribute (attribute (cls, fields(0)))
    val ETC: Fielder = parse_attribute (attribute (cls, fields(1)))
    val IFM: Fielder = parse_attribute (attribute (cls, fields(2)))
    val LOF: Fielder = parse_attribute (attribute (cls, fields(3)))
    val ORFC: Fielder = parse_attribute (attribute (cls, fields(4)))
    val PT: Fielder = parse_attribute (attribute (cls, fields(5)))
    val PUMP_ETC: Fielder = parse_attribute (attribute (cls, fields(6)))
    val PUMP_TOR: Fielder = parse_attribute (attribute (cls, fields(7)))
    val RA: Fielder = parse_attribute (attribute (cls, fields(8)))
    val RGMR: Fielder = parse_attribute (attribute (cls, fields(9)))
    val RMR: Fielder = parse_attribute (attribute (cls, fields(10)))
    val RMT: Fielder = parse_attribute (attribute (cls, fields(11)))
    val RUC: Fielder = parse_attribute (attribute (cls, fields(12)))
    val SP: Fielder = parse_attribute (attribute (cls, fields(13)))
    val TOR: Fielder = parse_attribute (attribute (cls, fields(14)))
    val WHL: Fielder = parse_attribute (attribute (cls, fields(15)))

    def parse (context: CIMContext): SelfScheduleType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SelfScheduleType (
            BasicElement.parse (context),
            mask (BAS (), 0),
            mask (ETC (), 1),
            mask (IFM (), 2),
            mask (LOF (), 3),
            mask (ORFC (), 4),
            mask (PT (), 5),
            mask (PUMP_ETC (), 6),
            mask (PUMP_TOR (), 7),
            mask (RA (), 8),
            mask (RGMR (), 9),
            mask (RMR (), 10),
            mask (RMT (), 11),
            mask (RUC (), 12),
            mask (SP (), 13),
            mask (TOR (), 14),
            mask (WHL (), 15)
        )
        ret.bitfields = bitfields
        ret
    }
}

object SelfScheduleTypeSerializer extends CIMSerializer[SelfScheduleType]
{
    def write (kryo: Kryo, output: Output, obj: SelfScheduleType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.BAS),
            () => output.writeString (obj.ETC),
            () => output.writeString (obj.IFM),
            () => output.writeString (obj.LOF),
            () => output.writeString (obj.ORFC),
            () => output.writeString (obj.PT),
            () => output.writeString (obj.PUMP_ETC),
            () => output.writeString (obj.PUMP_TOR),
            () => output.writeString (obj.RA),
            () => output.writeString (obj.RGMR),
            () => output.writeString (obj.RMR),
            () => output.writeString (obj.RMT),
            () => output.writeString (obj.RUC),
            () => output.writeString (obj.SP),
            () => output.writeString (obj.TOR),
            () => output.writeString (obj.WHL)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SelfScheduleType]): SelfScheduleType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SelfScheduleType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) input.readString else null,
            if (isSet (11)) input.readString else null,
            if (isSet (12)) input.readString else null,
            if (isSet (13)) input.readString else null,
            if (isSet (14)) input.readString else null,
            if (isSet (15)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Self Schedule Types applicable to Mitigated Bid
 *
 * @param Element Reference to the superclass object.
 * @param RMR <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class SelfScheduleTypeMB
(
    Element: BasicElement = null,
    RMR: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SelfScheduleTypeMB.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SelfScheduleTypeMB.fields (position), value)
        emitattr (0, RMR)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SelfScheduleTypeMB rdf:ID=\"%s\">\n%s\t</cim:SelfScheduleTypeMB>".format (id, export_fields)
    }
}

object SelfScheduleTypeMB
extends
    CIMParseable[SelfScheduleTypeMB]
{
    override val fields: Array[String] = Array[String] (
        "RMR"
    )
    val RMR: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): SelfScheduleTypeMB =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SelfScheduleTypeMB (
            BasicElement.parse (context),
            mask (RMR (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object SelfScheduleTypeMBSerializer extends CIMSerializer[SelfScheduleTypeMB]
{
    def write (kryo: Kryo, output: Output, obj: SelfScheduleTypeMB): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.RMR)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SelfScheduleTypeMB]): SelfScheduleTypeMB =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SelfScheduleTypeMB (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class SourceSinkFlag
(
    Element: BasicElement = null,
    CSNK: String = null,
    CSRC: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SourceSinkFlag.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SourceSinkFlag.fields (position), value)
        emitattr (0, CSNK)
        emitattr (1, CSRC)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SourceSinkFlag rdf:ID=\"%s\">\n%s\t</cim:SourceSinkFlag>".format (id, export_fields)
    }
}

object SourceSinkFlag
extends
    CIMParseable[SourceSinkFlag]
{
    override val fields: Array[String] = Array[String] (
        "CSNK",
        "CSRC"
    )
    val CSNK: Fielder = parse_attribute (attribute (cls, fields(0)))
    val CSRC: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): SourceSinkFlag =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SourceSinkFlag (
            BasicElement.parse (context),
            mask (CSNK (), 0),
            mask (CSRC (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object SourceSinkFlagSerializer extends CIMSerializer[SourceSinkFlag]
{
    def write (kryo: Kryo, output: Output, obj: SourceSinkFlag): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.CSNK),
            () => output.writeString (obj.CSRC)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SourceSinkFlag]): SourceSinkFlag =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SourceSinkFlag (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class SourceSinkType
(
    Element: BasicElement = null,
    Neither: String = null,
    Sink: String = null,
    Source: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SourceSinkType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SourceSinkType.fields (position), value)
        emitattr (0, Neither)
        emitattr (1, Sink)
        emitattr (2, Source)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SourceSinkType rdf:ID=\"%s\">\n%s\t</cim:SourceSinkType>".format (id, export_fields)
    }
}

object SourceSinkType
extends
    CIMParseable[SourceSinkType]
{
    override val fields: Array[String] = Array[String] (
        "Neither",
        "Sink",
        "Source"
    )
    val Neither: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Sink: Fielder = parse_attribute (attribute (cls, fields(1)))
    val Source: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): SourceSinkType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SourceSinkType (
            BasicElement.parse (context),
            mask (Neither (), 0),
            mask (Sink (), 1),
            mask (Source (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

object SourceSinkTypeSerializer extends CIMSerializer[SourceSinkType]
{
    def write (kryo: Kryo, output: Output, obj: SourceSinkType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.Neither),
            () => output.writeString (obj.Sink),
            () => output.writeString (obj.Source)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SourceSinkType]): SourceSinkType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SourceSinkType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class SpinningEventNameType
(
    Element: BasicElement = null,
    EASTERN: String = null,
    PJM: String = null,
    RFC_SR: String = null,
    SOUTH_S: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SpinningEventNameType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SpinningEventNameType.fields (position), value)
        emitattr (0, EASTERN)
        emitattr (1, PJM)
        emitattr (2, RFC_SR)
        emitattr (3, SOUTH_S)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SpinningEventNameType rdf:ID=\"%s\">\n%s\t</cim:SpinningEventNameType>".format (id, export_fields)
    }
}

object SpinningEventNameType
extends
    CIMParseable[SpinningEventNameType]
{
    override val fields: Array[String] = Array[String] (
        "EASTERN",
        "PJM",
        "RFC-SR",
        "SOUTH-S"
    )
    val EASTERN: Fielder = parse_attribute (attribute (cls, fields(0)))
    val PJM: Fielder = parse_attribute (attribute (cls, fields(1)))
    val RFC_SR: Fielder = parse_attribute (attribute (cls, fields(2)))
    val SOUTH_S: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): SpinningEventNameType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SpinningEventNameType (
            BasicElement.parse (context),
            mask (EASTERN (), 0),
            mask (PJM (), 1),
            mask (RFC_SR (), 2),
            mask (SOUTH_S (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

object SpinningEventNameTypeSerializer extends CIMSerializer[SpinningEventNameType]
{
    def write (kryo: Kryo, output: Output, obj: SpinningEventNameType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.EASTERN),
            () => output.writeString (obj.PJM),
            () => output.writeString (obj.RFC_SR),
            () => output.writeString (obj.SOUTH_S)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SpinningEventNameType]): SpinningEventNameType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SpinningEventNameType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class SpinningEventType
(
    Element: BasicElement = null,
    AA: String = null,
    CA: String = null,
    RZ: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SpinningEventType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SpinningEventType.fields (position), value)
        emitattr (0, AA)
        emitattr (1, CA)
        emitattr (2, RZ)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SpinningEventType rdf:ID=\"%s\">\n%s\t</cim:SpinningEventType>".format (id, export_fields)
    }
}

object SpinningEventType
extends
    CIMParseable[SpinningEventType]
{
    override val fields: Array[String] = Array[String] (
        "AA",
        "CA",
        "RZ"
    )
    val AA: Fielder = parse_attribute (attribute (cls, fields(0)))
    val CA: Fielder = parse_attribute (attribute (cls, fields(1)))
    val RZ: Fielder = parse_attribute (attribute (cls, fields(2)))

    def parse (context: CIMContext): SpinningEventType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SpinningEventType (
            BasicElement.parse (context),
            mask (AA (), 0),
            mask (CA (), 1),
            mask (RZ (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

object SpinningEventTypeSerializer extends CIMSerializer[SpinningEventType]
{
    def write (kryo: Kryo, output: Output, obj: SpinningEventType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.AA),
            () => output.writeString (obj.CA),
            () => output.writeString (obj.RZ)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SpinningEventType]): SpinningEventType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SpinningEventType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class SystemType
(
    Element: BasicElement = null,
    OASIS: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = SystemType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (SystemType.fields (position), value)
        emitattr (0, OASIS)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:SystemType rdf:ID=\"%s\">\n%s\t</cim:SystemType>".format (id, export_fields)
    }
}

object SystemType
extends
    CIMParseable[SystemType]
{
    override val fields: Array[String] = Array[String] (
        "OASIS"
    )
    val OASIS: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): SystemType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SystemType (
            BasicElement.parse (context),
            mask (OASIS (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object SystemTypeSerializer extends CIMSerializer[SystemType]
{
    def write (kryo: Kryo, output: Output, obj: SystemType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.OASIS)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SystemType]): SystemType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = SystemType (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class TimeZoneType
(
    Element: BasicElement = null,
    PPT: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TimeZoneType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TimeZoneType.fields (position), value)
        emitattr (0, PPT)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TimeZoneType rdf:ID=\"%s\">\n%s\t</cim:TimeZoneType>".format (id, export_fields)
    }
}

object TimeZoneType
extends
    CIMParseable[TimeZoneType]
{
    override val fields: Array[String] = Array[String] (
        "PPT"
    )
    val PPT: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: CIMContext): TimeZoneType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TimeZoneType (
            BasicElement.parse (context),
            mask (PPT (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

object TimeZoneTypeSerializer extends CIMSerializer[TimeZoneType]
{
    def write (kryo: Kryo, output: Output, obj: TimeZoneType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.PPT)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TimeZoneType]): TimeZoneType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TimeZoneType (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class TradeProductType
(
    Element: BasicElement = null,
    APN: String = null,
    CAP: String = null,
    NRT: String = null,
    PHY: String = null,
    RDT: String = null,
    RUT: String = null,
    SRT: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TradeProductType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (TradeProductType.fields (position), value)
        emitattr (0, APN)
        emitattr (1, CAP)
        emitattr (2, NRT)
        emitattr (3, PHY)
        emitattr (4, RDT)
        emitattr (5, RUT)
        emitattr (6, SRT)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TradeProductType rdf:ID=\"%s\">\n%s\t</cim:TradeProductType>".format (id, export_fields)
    }
}

object TradeProductType
extends
    CIMParseable[TradeProductType]
{
    override val fields: Array[String] = Array[String] (
        "APN",
        "CAP",
        "NRT",
        "PHY",
        "RDT",
        "RUT",
        "SRT"
    )
    val APN: Fielder = parse_attribute (attribute (cls, fields(0)))
    val CAP: Fielder = parse_attribute (attribute (cls, fields(1)))
    val NRT: Fielder = parse_attribute (attribute (cls, fields(2)))
    val PHY: Fielder = parse_attribute (attribute (cls, fields(3)))
    val RDT: Fielder = parse_attribute (attribute (cls, fields(4)))
    val RUT: Fielder = parse_attribute (attribute (cls, fields(5)))
    val SRT: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: CIMContext): TradeProductType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TradeProductType (
            BasicElement.parse (context),
            mask (APN (), 0),
            mask (CAP (), 1),
            mask (NRT (), 2),
            mask (PHY (), 3),
            mask (RDT (), 4),
            mask (RUT (), 5),
            mask (SRT (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
}

object TradeProductTypeSerializer extends CIMSerializer[TradeProductType]
{
    def write (kryo: Kryo, output: Output, obj: TradeProductType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.APN),
            () => output.writeString (obj.CAP),
            () => output.writeString (obj.NRT),
            () => output.writeString (obj.PHY),
            () => output.writeString (obj.RDT),
            () => output.writeString (obj.RUT),
            () => output.writeString (obj.SRT)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TradeProductType]): TradeProductType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TradeProductType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class UOMType
(
    Element: BasicElement = null,
    percent: String = null,
    $_lb: String = null,
    $_mmBTU: String = null,
    FACTOR: String = null,
    FLAG: String = null,
    INTEGER: String = null,
    MW: String = null,
    MWh: String = null,
    US$: String = null,
    US$_MW: String = null,
    US$_MWh: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = UOMType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (UOMType.fields (position), value)
        emitattr (0, percent)
        emitattr (1, $_lb)
        emitattr (2, $_mmBTU)
        emitattr (3, FACTOR)
        emitattr (4, FLAG)
        emitattr (5, INTEGER)
        emitattr (6, MW)
        emitattr (7, MWh)
        emitattr (8, US$)
        emitattr (9, US$_MW)
        emitattr (10, US$_MWh)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:UOMType rdf:ID=\"%s\">\n%s\t</cim:UOMType>".format (id, export_fields)
    }
}

object UOMType
extends
    CIMParseable[UOMType]
{
    override val fields: Array[String] = Array[String] (
        "%",
        "$/lb",
        "$/mmBTU",
        "FACTOR",
        "FLAG",
        "INTEGER",
        "MW",
        "MWh",
        "US$",
        "US$/MW",
        "US$/MWh"
    )
    val percent: Fielder = parse_attribute (attribute (cls, fields(0)))
    val $_lb: Fielder = parse_attribute (attribute (cls, fields(1)))
    val $_mmBTU: Fielder = parse_attribute (attribute (cls, fields(2)))
    val FACTOR: Fielder = parse_attribute (attribute (cls, fields(3)))
    val FLAG: Fielder = parse_attribute (attribute (cls, fields(4)))
    val INTEGER: Fielder = parse_attribute (attribute (cls, fields(5)))
    val MW: Fielder = parse_attribute (attribute (cls, fields(6)))
    val MWh: Fielder = parse_attribute (attribute (cls, fields(7)))
    val US$: Fielder = parse_attribute (attribute (cls, fields(8)))
    val US$_MW: Fielder = parse_attribute (attribute (cls, fields(9)))
    val US$_MWh: Fielder = parse_attribute (attribute (cls, fields(10)))

    def parse (context: CIMContext): UOMType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = UOMType (
            BasicElement.parse (context),
            mask (percent (), 0),
            mask ($_lb (), 1),
            mask ($_mmBTU (), 2),
            mask (FACTOR (), 3),
            mask (FLAG (), 4),
            mask (INTEGER (), 5),
            mask (MW (), 6),
            mask (MWh (), 7),
            mask (US$ (), 8),
            mask (US$_MW (), 9),
            mask (US$_MWh (), 10)
        )
        ret.bitfields = bitfields
        ret
    }
}

object UOMTypeSerializer extends CIMSerializer[UOMType]
{
    def write (kryo: Kryo, output: Output, obj: UOMType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.percent),
            () => output.writeString (obj.$_lb),
            () => output.writeString (obj.$_mmBTU),
            () => output.writeString (obj.FACTOR),
            () => output.writeString (obj.FLAG),
            () => output.writeString (obj.INTEGER),
            () => output.writeString (obj.MW),
            () => output.writeString (obj.MWh),
            () => output.writeString (obj.US$),
            () => output.writeString (obj.US$_MW),
            () => output.writeString (obj.US$_MWh)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[UOMType]): UOMType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = UOMType (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) input.readString else null,
            if (isSet (10)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * MW
 *
 * FLAG
 *
 * @param Element Reference to the superclass object.
 * @param FLAG <em>undocumented</em>
 * @param MW <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class UnitTypeEMS
(
    Element: BasicElement = null,
    FLAG: String = null,
    MW: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = UnitTypeEMS.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (UnitTypeEMS.fields (position), value)
        emitattr (0, FLAG)
        emitattr (1, MW)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:UnitTypeEMS rdf:ID=\"%s\">\n%s\t</cim:UnitTypeEMS>".format (id, export_fields)
    }
}

object UnitTypeEMS
extends
    CIMParseable[UnitTypeEMS]
{
    override val fields: Array[String] = Array[String] (
        "FLAG",
        "MW"
    )
    val FLAG: Fielder = parse_attribute (attribute (cls, fields(0)))
    val MW: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): UnitTypeEMS =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = UnitTypeEMS (
            BasicElement.parse (context),
            mask (FLAG (), 0),
            mask (MW (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object UnitTypeEMSSerializer extends CIMSerializer[UnitTypeEMS]
{
    def write (kryo: Kryo, output: Output, obj: UnitTypeEMS): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.FLAG),
            () => output.writeString (obj.MW)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[UnitTypeEMS]): UnitTypeEMS =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = UnitTypeEMS (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * zone type
 *
 * @param Element Reference to the superclass object.
 * @param ASREGION ancillary service region
 * @param DCA designated congestion area
 * @param LOADZONE load zone
 * @param RUCZONE RUC zone
 * @param TRADINGHUB trading hub
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class ZoneType
(
    Element: BasicElement = null,
    ASREGION: String = null,
    DCA: String = null,
    LOADZONE: String = null,
    RUCZONE: String = null,
    TRADINGHUB: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ZoneType.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ZoneType.fields (position), value)
        emitattr (0, ASREGION)
        emitattr (1, DCA)
        emitattr (2, LOADZONE)
        emitattr (3, RUCZONE)
        emitattr (4, TRADINGHUB)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ZoneType rdf:ID=\"%s\">\n%s\t</cim:ZoneType>".format (id, export_fields)
    }
}

object ZoneType
extends
    CIMParseable[ZoneType]
{
    override val fields: Array[String] = Array[String] (
        "ASREGION",
        "DCA",
        "LOADZONE",
        "RUCZONE",
        "TRADINGHUB"
    )
    val ASREGION: Fielder = parse_attribute (attribute (cls, fields(0)))
    val DCA: Fielder = parse_attribute (attribute (cls, fields(1)))
    val LOADZONE: Fielder = parse_attribute (attribute (cls, fields(2)))
    val RUCZONE: Fielder = parse_attribute (attribute (cls, fields(3)))
    val TRADINGHUB: Fielder = parse_attribute (attribute (cls, fields(4)))

    def parse (context: CIMContext): ZoneType =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ZoneType (
            BasicElement.parse (context),
            mask (ASREGION (), 0),
            mask (DCA (), 1),
            mask (LOADZONE (), 2),
            mask (RUCZONE (), 3),
            mask (TRADINGHUB (), 4)
        )
        ret.bitfields = bitfields
        ret
    }
}

object ZoneTypeSerializer extends CIMSerializer[ZoneType]
{
    def write (kryo: Kryo, output: Output, obj: ZoneType): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.ASREGION),
            () => output.writeString (obj.DCA),
            () => output.writeString (obj.LOADZONE),
            () => output.writeString (obj.RUCZONE),
            () => output.writeString (obj.TRADINGHUB)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ZoneType]): ZoneType =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ZoneType (
            parent,
            if (isSet (0)) input.readString else null,
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
 * S - Scheduling
 *
 * P - Pricing
 *
 * @param Element Reference to the superclass object.
 * @param P <em>undocumented</em>
 * @param S <em>undocumented</em>
 * @group InfDomain
 * @groupname InfDomain Package InfDomain
 */
final case class runTypeCAISO
(
    Element: BasicElement = null,
    P: String = null,
    S: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = runTypeCAISO.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (runTypeCAISO.fields (position), value)
        emitattr (0, P)
        emitattr (1, S)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:runTypeCAISO rdf:ID=\"%s\">\n%s\t</cim:runTypeCAISO>".format (id, export_fields)
    }
}

object runTypeCAISO
extends
    CIMParseable[runTypeCAISO]
{
    override val fields: Array[String] = Array[String] (
        "P",
        "S"
    )
    val P: Fielder = parse_attribute (attribute (cls, fields(0)))
    val S: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): runTypeCAISO =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = runTypeCAISO (
            BasicElement.parse (context),
            mask (P (), 0),
            mask (S (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object runTypeCAISOSerializer extends CIMSerializer[runTypeCAISO]
{
    def write (kryo: Kryo, output: Output, obj: runTypeCAISO): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.P),
            () => output.writeString (obj.S)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[runTypeCAISO]): runTypeCAISO =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = runTypeCAISO (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _InfDomain
{
    def register: List[CIMClassInfo] =
    {
        List (
            ADSInstructionTypeCommitment.register,
            ADSInstructionTypeOOS.register,
            AdderType.register,
            AlarmDisplayType.register,
            AllocationEnergyTypeCode.register,
            AncillaryCommodityType.register,
            BidPriceCapType.register,
            CleanTradeProductType.register,
            CurrentStatusSC.register,
            DAMMarketType.register,
            DispatchAcceptStatus.register,
            DispatchTransactionType.register,
            EnergyTypeCode.register,
            JobFlagType.register,
            JobScheduleType.register,
            JobStartEndType.register,
            LFCResourceType.register,
            LoadFollowingCapacityType.register,
            MQSDELType.register,
            MarketProductTypeAsReq.register,
            MarketScheduleServices.register,
            MarketStatementDescription.register,
            MarketStatementDocStatus.register,
            MarketStatementDocType.register,
            MarketStatementLineItemAliasName.register,
            MeasurementTypeEMS.register,
            MktSubClassType.register,
            OASISBidReportType.register,
            OASISDataItems.register,
            OASISErrCode.register,
            OASISErrDescription.register,
            OASISIntervalType.register,
            OASISMarketType.register,
            OASISMasterType.register,
            OASISMeasType.register,
            OASISReportType.register,
            OASISStatusType.register,
            OrganisationCode.register,
            OrganisationType.register,
            PriceSetFlag.register,
            RequestorRmrTest.register,
            ResourceCertificationCategory.register,
            ResourceCertificationType.register,
            SchedClassType.register,
            SegmentCurveType.register,
            SelfSchedTypeCleanBid.register,
            SelfSchedTypeRawBid.register,
            SelfScheduleType.register,
            SelfScheduleTypeMB.register,
            SourceSinkFlag.register,
            SourceSinkType.register,
            SpinningEventNameType.register,
            SpinningEventType.register,
            SystemType.register,
            TimeZoneType.register,
            TradeProductType.register,
            UOMType.register,
            UnitTypeEMS.register,
            ZoneType.register,
            runTypeCAISO.register
        )
    }
}
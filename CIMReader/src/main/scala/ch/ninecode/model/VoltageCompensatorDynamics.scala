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
 * Resistive and reactive components of compensation for generator associated with IEEE type 2 voltage compensator for current flow out of another generator in the interconnection.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param rcij <font color="#0f0f0f">Resistive component of compensation of generator associated with this IEEE type 2 voltage compensator for current flow out of another generator (<i>Rcij</i>).</font>
 * @param xcij <font color="#0f0f0f">Reactive component of compensation of generator associated with this IEEE type 2 voltage compensator for current flow out of another generator (<i>Xcij</i>).</font>
 * @param SynchronousMachineDynamics [[ch.ninecode.model.SynchronousMachineDynamics SynchronousMachineDynamics]] Standard synchronous machine out of which current flow is being compensated for.
 * @param VcompIEEEType2 [[ch.ninecode.model.VCompIEEEType2 VCompIEEEType2]] The standard IEEE type 2 voltage compensator of this compensation.
 * @group VoltageCompensatorDynamics
 * @groupname VoltageCompensatorDynamics Package VoltageCompensatorDynamics
 * @groupdesc VoltageCompensatorDynamics <font color="#0f0f0f">Synchronous machine terminal voltage transducer and current compensator models</font> adjust the terminal voltage feedback to the excitation system by adding a quantity that is proportional to the terminal current of the generator.  It is linked to a specific generator (synchronous machine).
<font color="#0f0f0f">Several types of compensation are available on most excitation systems. Synchronous machine active and reactive current compensation are the most common. Either reactive droop compensation and/or line-drop compensation can be used, simulating an impedance drop and effectively regulating at some point other than the terminals of the machine. The impedance or range of adjustment and type of compensation should be specified for different types. </font>
<font color="#0f0f0f">Care shall be taken to ensure that a consistent PU system is utilized for the compensator parameters and the synchronous machine current base.</font>
<font color="#0f0f0f">For further information see IEEE 421.5-2005, 4.</font>


<font color="#0f0f0f">
</font>
 */
final case class GenICompensationForGenJ
(
    IdentifiedObject: IdentifiedObject = null,
    rcij: Double = 0.0,
    xcij: Double = 0.0,
    SynchronousMachineDynamics: String = null,
    VcompIEEEType2: String = null
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
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = GenICompensationForGenJ.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (GenICompensationForGenJ.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (GenICompensationForGenJ.fields (position), value)
        emitelem (0, rcij)
        emitelem (1, xcij)
        emitattr (2, SynchronousMachineDynamics)
        emitattr (3, VcompIEEEType2)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:GenICompensationForGenJ rdf:ID=\"%s\">\n%s\t</cim:GenICompensationForGenJ>".format (id, export_fields)
    }
}

object GenICompensationForGenJ
extends
    CIMParseable[GenICompensationForGenJ]
{
    override val fields: Array[String] = Array[String] (
        "rcij",
        "xcij",
        "SynchronousMachineDynamics",
        "VcompIEEEType2"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("SynchronousMachineDynamics", "SynchronousMachineDynamics", "1", "0..*"),
        CIMRelationship ("VcompIEEEType2", "VCompIEEEType2", "1", "2..*")
    )
    val rcij: Fielder = parse_element (element (cls, fields(0)))
    val xcij: Fielder = parse_element (element (cls, fields(1)))
    val SynchronousMachineDynamics: Fielder = parse_attribute (attribute (cls, fields(2)))
    val VcompIEEEType2: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): GenICompensationForGenJ =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = GenICompensationForGenJ (
            IdentifiedObject.parse (context),
            toDouble (mask (rcij (), 0)),
            toDouble (mask (xcij (), 1)),
            mask (SynchronousMachineDynamics (), 2),
            mask (VcompIEEEType2 (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

object GenICompensationForGenJSerializer extends CIMSerializer[GenICompensationForGenJ]
{
    def write (kryo: Kryo, output: Output, obj: GenICompensationForGenJ): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.rcij),
            () => output.writeDouble (obj.xcij),
            () => output.writeString (obj.SynchronousMachineDynamics),
            () => output.writeString (obj.VcompIEEEType2)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[GenICompensationForGenJ]): GenICompensationForGenJ =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = GenICompensationForGenJ (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * <font color="#0f0f0f">Terminal voltage transducer and load compensator as defined in IEEE 421.5-2005, 4.
 *
 * This model is common to all excitation system models described in the IEEE Standard. </font>
 * <font color="#0f0f0f">Parameter details:</font>
 * <ol>
 * <li><font color="#0f0f0f">If <i>Rc</i> and <i>Xc</i> are set to zero, the l</font>oad compensation is not employed and the behaviour is as a simple sensing circuit.</li>
 * </ol>
 * <ol>
 * <li>If all parameters (<i>Rc</i>, <i>Xc</i> and <i>Tr</i>) are set to zero, the standard model VCompIEEEType1 is bypassed.</li>
 * </ol>
 * Reference: IEEE 421.5-2005 4.
 *
 * @param VoltageCompensatorDynamics [[ch.ninecode.model.VoltageCompensatorDynamics VoltageCompensatorDynamics]] Reference to the superclass object.
 * @param rc <font color="#0f0f0f">Resistive component of compensation of a generator (<i>Rc</i>) (&gt;= 0).</font>
 * @param tr <font color="#0f0f0f">Time constant which is used for the combined voltage sensing and compensation signal (<i>Tr</i>) (&gt;= 0).</font>
 * @param xc <font color="#0f0f0f">Reactive component of compensation of a generator (<i>Xc</i>) (&gt;= 0).</font>
 * @group VoltageCompensatorDynamics
 * @groupname VoltageCompensatorDynamics Package VoltageCompensatorDynamics
 * @groupdesc VoltageCompensatorDynamics <font color="#0f0f0f">Synchronous machine terminal voltage transducer and current compensator models</font> adjust the terminal voltage feedback to the excitation system by adding a quantity that is proportional to the terminal current of the generator.  It is linked to a specific generator (synchronous machine).
<font color="#0f0f0f">Several types of compensation are available on most excitation systems. Synchronous machine active and reactive current compensation are the most common. Either reactive droop compensation and/or line-drop compensation can be used, simulating an impedance drop and effectively regulating at some point other than the terminals of the machine. The impedance or range of adjustment and type of compensation should be specified for different types. </font>
<font color="#0f0f0f">Care shall be taken to ensure that a consistent PU system is utilized for the compensator parameters and the synchronous machine current base.</font>
<font color="#0f0f0f">For further information see IEEE 421.5-2005, 4.</font>


<font color="#0f0f0f">
</font>
 */
final case class VCompIEEEType1
(
    VoltageCompensatorDynamics: VoltageCompensatorDynamics = null,
    rc: Double = 0.0,
    tr: Double = 0.0,
    xc: Double = 0.0
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
    override def sup: VoltageCompensatorDynamics = VoltageCompensatorDynamics

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
        implicit val clz: String = VCompIEEEType1.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (VCompIEEEType1.fields (position), value)
        emitelem (0, rc)
        emitelem (1, tr)
        emitelem (2, xc)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:VCompIEEEType1 rdf:ID=\"%s\">\n%s\t</cim:VCompIEEEType1>".format (id, export_fields)
    }
}

object VCompIEEEType1
extends
    CIMParseable[VCompIEEEType1]
{
    override val fields: Array[String] = Array[String] (
        "rc",
        "tr",
        "xc"
    )
    val rc: Fielder = parse_element (element (cls, fields(0)))
    val tr: Fielder = parse_element (element (cls, fields(1)))
    val xc: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: CIMContext): VCompIEEEType1 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = VCompIEEEType1 (
            VoltageCompensatorDynamics.parse (context),
            toDouble (mask (rc (), 0)),
            toDouble (mask (tr (), 1)),
            toDouble (mask (xc (), 2))
        )
        ret.bitfields = bitfields
        ret
    }
}

object VCompIEEEType1Serializer extends CIMSerializer[VCompIEEEType1]
{
    def write (kryo: Kryo, output: Output, obj: VCompIEEEType1): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.rc),
            () => output.writeDouble (obj.tr),
            () => output.writeDouble (obj.xc)
        )
        VoltageCompensatorDynamicsSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[VCompIEEEType1]): VCompIEEEType1 =
    {
        val parent = VoltageCompensatorDynamicsSerializer.read (kryo, input, classOf[VoltageCompensatorDynamics])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = VCompIEEEType1 (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * <font color="#0f0f0f">Terminal voltage transducer and load compensator as defined in IEEE 421.5-2005, 4.
 *
 * This model is designed to cover the following types of compensation: </font>
 * <ul>
 * <li><font color="#0f0f0f">reactive droop;</font></li>
 * <li><font color="#0f0f0f">transformer-drop or line-drop compensation;</font></li>
 * <li><font color="#0f0f0f">reactive differential compensation known also as cross-current compensation.</font></li>
 * </ul>
 * <font color="#0f0f0f">Reference: IEEE 421.5-2005, 4.</font>
 *
 * @param VoltageCompensatorDynamics [[ch.ninecode.model.VoltageCompensatorDynamics VoltageCompensatorDynamics]] Reference to the superclass object.
 * @param tr <font color="#0f0f0f">Time constant which is used for the combined voltage sensing and compensation signal (<i>Tr</i>) (&gt;= 0).</font>
 * @param GenICompensationForGenJ [[ch.ninecode.model.GenICompensationForGenJ GenICompensationForGenJ]] Compensation of this voltage compensator's generator for current flow out of another generator.
 * @group VoltageCompensatorDynamics
 * @groupname VoltageCompensatorDynamics Package VoltageCompensatorDynamics
 * @groupdesc VoltageCompensatorDynamics <font color="#0f0f0f">Synchronous machine terminal voltage transducer and current compensator models</font> adjust the terminal voltage feedback to the excitation system by adding a quantity that is proportional to the terminal current of the generator.  It is linked to a specific generator (synchronous machine).
<font color="#0f0f0f">Several types of compensation are available on most excitation systems. Synchronous machine active and reactive current compensation are the most common. Either reactive droop compensation and/or line-drop compensation can be used, simulating an impedance drop and effectively regulating at some point other than the terminals of the machine. The impedance or range of adjustment and type of compensation should be specified for different types. </font>
<font color="#0f0f0f">Care shall be taken to ensure that a consistent PU system is utilized for the compensator parameters and the synchronous machine current base.</font>
<font color="#0f0f0f">For further information see IEEE 421.5-2005, 4.</font>


<font color="#0f0f0f">
</font>
 */
final case class VCompIEEEType2
(
    VoltageCompensatorDynamics: VoltageCompensatorDynamics = null,
    tr: Double = 0.0,
    GenICompensationForGenJ: List[String] = null
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
    override def sup: VoltageCompensatorDynamics = VoltageCompensatorDynamics

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
        implicit val clz: String = VCompIEEEType2.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (VCompIEEEType2.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (VCompIEEEType2.fields (position), x))
        emitelem (0, tr)
        emitattrs (1, GenICompensationForGenJ)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:VCompIEEEType2 rdf:ID=\"%s\">\n%s\t</cim:VCompIEEEType2>".format (id, export_fields)
    }
}

object VCompIEEEType2
extends
    CIMParseable[VCompIEEEType2]
{
    override val fields: Array[String] = Array[String] (
        "tr",
        "GenICompensationForGenJ"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("GenICompensationForGenJ", "GenICompensationForGenJ", "2..*", "1")
    )
    val tr: Fielder = parse_element (element (cls, fields(0)))
    val GenICompensationForGenJ: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): VCompIEEEType2 =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = VCompIEEEType2 (
            VoltageCompensatorDynamics.parse (context),
            toDouble (mask (tr (), 0)),
            masks (GenICompensationForGenJ (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object VCompIEEEType2Serializer extends CIMSerializer[VCompIEEEType2]
{
    def write (kryo: Kryo, output: Output, obj: VCompIEEEType2): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeDouble (obj.tr),
            () => writeList (obj.GenICompensationForGenJ, output)
        )
        VoltageCompensatorDynamicsSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[VCompIEEEType2]): VCompIEEEType2 =
    {
        val parent = VoltageCompensatorDynamicsSerializer.read (kryo, input, classOf[VoltageCompensatorDynamics])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = VCompIEEEType2 (
            parent,
            if (isSet (0)) input.readDouble else 0.0,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Voltage compensator function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 *
 * @param DynamicsFunctionBlock [[ch.ninecode.model.DynamicsFunctionBlock DynamicsFunctionBlock]] Reference to the superclass object.
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Excitation system model with which this voltage compensator is associated.
 * @param RemoteInputSignal [[ch.ninecode.model.RemoteInputSignal RemoteInputSignal]] Remote input signal used by this voltage compensator model.
 * @group VoltageCompensatorDynamics
 * @groupname VoltageCompensatorDynamics Package VoltageCompensatorDynamics
 * @groupdesc VoltageCompensatorDynamics <font color="#0f0f0f">Synchronous machine terminal voltage transducer and current compensator models</font> adjust the terminal voltage feedback to the excitation system by adding a quantity that is proportional to the terminal current of the generator.  It is linked to a specific generator (synchronous machine).
<font color="#0f0f0f">Several types of compensation are available on most excitation systems. Synchronous machine active and reactive current compensation are the most common. Either reactive droop compensation and/or line-drop compensation can be used, simulating an impedance drop and effectively regulating at some point other than the terminals of the machine. The impedance or range of adjustment and type of compensation should be specified for different types. </font>
<font color="#0f0f0f">Care shall be taken to ensure that a consistent PU system is utilized for the compensator parameters and the synchronous machine current base.</font>
<font color="#0f0f0f">For further information see IEEE 421.5-2005, 4.</font>


<font color="#0f0f0f">
</font>
 */
final case class VoltageCompensatorDynamics
(
    DynamicsFunctionBlock: DynamicsFunctionBlock = null,
    ExcitationSystemDynamics: String = null,
    RemoteInputSignal: String = null
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
    override def sup: DynamicsFunctionBlock = DynamicsFunctionBlock

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
        implicit val clz: String = VoltageCompensatorDynamics.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (VoltageCompensatorDynamics.fields (position), value)
        emitattr (0, ExcitationSystemDynamics)
        emitattr (1, RemoteInputSignal)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:VoltageCompensatorDynamics rdf:ID=\"%s\">\n%s\t</cim:VoltageCompensatorDynamics>".format (id, export_fields)
    }
}

object VoltageCompensatorDynamics
extends
    CIMParseable[VoltageCompensatorDynamics]
{
    override val fields: Array[String] = Array[String] (
        "ExcitationSystemDynamics",
        "RemoteInputSignal"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ExcitationSystemDynamics", "ExcitationSystemDynamics", "1", "1"),
        CIMRelationship ("RemoteInputSignal", "RemoteInputSignal", "0..1", "0..1")
    )
    val ExcitationSystemDynamics: Fielder = parse_attribute (attribute (cls, fields(0)))
    val RemoteInputSignal: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): VoltageCompensatorDynamics =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = VoltageCompensatorDynamics (
            DynamicsFunctionBlock.parse (context),
            mask (ExcitationSystemDynamics (), 0),
            mask (RemoteInputSignal (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

object VoltageCompensatorDynamicsSerializer extends CIMSerializer[VoltageCompensatorDynamics]
{
    def write (kryo: Kryo, output: Output, obj: VoltageCompensatorDynamics): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.ExcitationSystemDynamics),
            () => output.writeString (obj.RemoteInputSignal)
        )
        DynamicsFunctionBlockSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[VoltageCompensatorDynamics]): VoltageCompensatorDynamics =
    {
        val parent = DynamicsFunctionBlockSerializer.read (kryo, input, classOf[DynamicsFunctionBlock])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = VoltageCompensatorDynamics (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _VoltageCompensatorDynamics
{
    def register: List[CIMClassInfo] =
    {
        List (
            GenICompensationForGenJ.register,
            VCompIEEEType1.register,
            VCompIEEEType2.register,
            VoltageCompensatorDynamics.register
        )
    }
}
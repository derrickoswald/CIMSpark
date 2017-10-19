package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * This class provides the resistive and reactive components of compensation for the generator associated with the IEEE Type 2 voltage compensator for current flow out of one of the other generators in the interconnection.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param rcij <font color="#0f0f0f">Resistive component of compensation of generator associated with this IEEE Type 2 voltage compensator for current flow out of another generator (Rcij).</font>
 * @param xcij <font color="#0f0f0f">Reactive component of compensation of generator associated with this IEEE Type 2 voltage compensator for current flow out of another generator (Xcij).</font>
 * @param SynchronousMachineDynamics [[ch.ninecode.model.SynchronousMachineDynamics SynchronousMachineDynamics]] Standard synchronous machine out of which current flow is being compensated for.
 * @param VcompIEEEType2 [[ch.ninecode.model.VCompIEEEType2 VCompIEEEType2]] The standard IEEE Type 2 voltage compensator of this compensation.
 * @group VoltageCompensatorDynamics
 * @groupname VoltageCompensatorDynamics Package VoltageCompensatorDynamics
 * @groupdesc VoltageCompensatorDynamics <font color="#0f0f0f">Synchronous machine terminal voltage transducer and current compensator models</font> adjust the terminal voltage feedback to the excitation system by adding a quantity that is proportional to the terminal current of the generator.  It is linked to a specific generator (synchronous machine).

<font color="#0f0f0f">Several types of compensation are available on most excitation systems. Synchronous machine active and reactive current compensation are the most common. Either reactive droop compensation and/or line-drop compensation may be used, simulating an impedance drop and effectively regulating at some point other than the terminals of the machine. The impedance or range of adjustment and type of compensation should be specified for different types. </font>

<font color="#0f0f0f">Care must be taken to ensure that a consistent pu system is utilized for the compensator parameters and the synchronous machine current base.</font>

<font color="#0f0f0f">For further information see IEEE Standard 421.5-2005, Section 4.</font>


<font color="#0f0f0f">
</font>
 */
case class GenICompensationForGenJ
(
    override val sup: IdentifiedObject,
    rcij: Double,
    xcij: Double,
    SynchronousMachineDynamics: String,
    VcompIEEEType2: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, null, null) }
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
    override def copy (): Row = { clone ().asInstanceOf[GenICompensationForGenJ] }
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
        implicit val clz: String = GenICompensationForGenJ.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
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
    Parseable[GenICompensationForGenJ]
{
    val fields: Array[String] = Array[String] (
        "rcij",
        "xcij",
        "SynchronousMachineDynamics",
        "VcompIEEEType2"
    )
    val rcij: Fielder = parse_element (element (cls, fields(0)))
    val xcij: Fielder = parse_element (element (cls, fields(1)))
    val SynchronousMachineDynamics: Fielder = parse_attribute (attribute (cls, fields(2)))
    val VcompIEEEType2: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): GenICompensationForGenJ =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = GenICompensationForGenJ (
            IdentifiedObject.parse (context),
            toDouble (mask (rcij (), 0)),
            toDouble (mask (xcij (), 1)),
            mask (SynchronousMachineDynamics (), 2),
            mask (VcompIEEEType2 (), 3)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("SynchronousMachineDynamics", "SynchronousMachineDynamics", false),
        Relationship ("VcompIEEEType2", "VCompIEEEType2", false)
    )
}

/**
 * <font color="#0f0f0f">The class represents the terminal voltage transducer and the load compensator as defined in the IEEE Std 421.5-2005, Section 4.
 *
 * This model is common to all excitation system models described in the IEEE Standard. </font>
 *
 * @param sup [[ch.ninecode.model.VoltageCompensatorDynamics VoltageCompensatorDynamics]] Reference to the superclass object.
 * @param rc <font color="#0f0f0f">Resistive component of compensation of a generator (Rc).</font>
 * @param tr <font color="#0f0f0f">Time constant which is used for the combined voltage sensing and compensation signal (Tr).</font>
 * @param xc <font color="#0f0f0f">Reactive component of compensation of a generator (Xc).</font>
 * @group VoltageCompensatorDynamics
 * @groupname VoltageCompensatorDynamics Package VoltageCompensatorDynamics
 * @groupdesc VoltageCompensatorDynamics <font color="#0f0f0f">Synchronous machine terminal voltage transducer and current compensator models</font> adjust the terminal voltage feedback to the excitation system by adding a quantity that is proportional to the terminal current of the generator.  It is linked to a specific generator (synchronous machine).

<font color="#0f0f0f">Several types of compensation are available on most excitation systems. Synchronous machine active and reactive current compensation are the most common. Either reactive droop compensation and/or line-drop compensation may be used, simulating an impedance drop and effectively regulating at some point other than the terminals of the machine. The impedance or range of adjustment and type of compensation should be specified for different types. </font>

<font color="#0f0f0f">Care must be taken to ensure that a consistent pu system is utilized for the compensator parameters and the synchronous machine current base.</font>

<font color="#0f0f0f">For further information see IEEE Standard 421.5-2005, Section 4.</font>


<font color="#0f0f0f">
</font>
 */
case class VCompIEEEType1
(
    override val sup: VoltageCompensatorDynamics,
    rc: Double,
    tr: Double,
    xc: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0) }
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
    def VoltageCompensatorDynamics: VoltageCompensatorDynamics = sup.asInstanceOf[VoltageCompensatorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[VCompIEEEType1] }
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
        implicit val clz: String = VCompIEEEType1.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
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
    Parseable[VCompIEEEType1]
{
    val fields: Array[String] = Array[String] (
        "rc",
        "tr",
        "xc"
    )
    val rc: Fielder = parse_element (element (cls, fields(0)))
    val tr: Fielder = parse_element (element (cls, fields(1)))
    val xc: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: Context): VCompIEEEType1 =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = VCompIEEEType1 (
            VoltageCompensatorDynamics.parse (context),
            toDouble (mask (rc (), 0)),
            toDouble (mask (tr (), 1)),
            toDouble (mask (xc (), 2))
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * <font color="#0f0f0f">The class represents the terminal voltage transducer and the load compensator as defined in the IEEE Std 421.5-2005, Section 4.
 *
 * This model is designed to cover the following types of compensation: </font>
 *
 * @param sup [[ch.ninecode.model.VoltageCompensatorDynamics VoltageCompensatorDynamics]] Reference to the superclass object.
 * @param tr <font color="#0f0f0f">Time constant which is used for the combined voltage sensing and compensation signal (Tr).</font>
 * @group VoltageCompensatorDynamics
 * @groupname VoltageCompensatorDynamics Package VoltageCompensatorDynamics
 * @groupdesc VoltageCompensatorDynamics <font color="#0f0f0f">Synchronous machine terminal voltage transducer and current compensator models</font> adjust the terminal voltage feedback to the excitation system by adding a quantity that is proportional to the terminal current of the generator.  It is linked to a specific generator (synchronous machine).

<font color="#0f0f0f">Several types of compensation are available on most excitation systems. Synchronous machine active and reactive current compensation are the most common. Either reactive droop compensation and/or line-drop compensation may be used, simulating an impedance drop and effectively regulating at some point other than the terminals of the machine. The impedance or range of adjustment and type of compensation should be specified for different types. </font>

<font color="#0f0f0f">Care must be taken to ensure that a consistent pu system is utilized for the compensator parameters and the synchronous machine current base.</font>

<font color="#0f0f0f">For further information see IEEE Standard 421.5-2005, Section 4.</font>


<font color="#0f0f0f">
</font>
 */
case class VCompIEEEType2
(
    override val sup: VoltageCompensatorDynamics,
    tr: Double
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0) }
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
    def VoltageCompensatorDynamics: VoltageCompensatorDynamics = sup.asInstanceOf[VoltageCompensatorDynamics]
    override def copy (): Row = { clone ().asInstanceOf[VCompIEEEType2] }
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
        implicit val clz: String = VCompIEEEType2.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (VCompIEEEType2.fields (position), value)
        emitelem (0, tr)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:VCompIEEEType2 rdf:ID=\"%s\">\n%s\t</cim:VCompIEEEType2>".format (id, export_fields)
    }
}

object VCompIEEEType2
extends
    Parseable[VCompIEEEType2]
{
    val fields: Array[String] = Array[String] (
        "tr"
    )
    val tr: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): VCompIEEEType2 =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = VCompIEEEType2 (
            VoltageCompensatorDynamics.parse (context),
            toDouble (mask (tr (), 0))
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Voltage compensator function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 *
 * @param sup [[ch.ninecode.model.DynamicsFunctionBlock DynamicsFunctionBlock]] Reference to the superclass object.
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Excitation system model with which this voltage compensator is associated.
 * @param RemoteInputSignal [[ch.ninecode.model.RemoteInputSignal RemoteInputSignal]] Remote input signal used by this voltage compensator model.
 * @group VoltageCompensatorDynamics
 * @groupname VoltageCompensatorDynamics Package VoltageCompensatorDynamics
 * @groupdesc VoltageCompensatorDynamics <font color="#0f0f0f">Synchronous machine terminal voltage transducer and current compensator models</font> adjust the terminal voltage feedback to the excitation system by adding a quantity that is proportional to the terminal current of the generator.  It is linked to a specific generator (synchronous machine).

<font color="#0f0f0f">Several types of compensation are available on most excitation systems. Synchronous machine active and reactive current compensation are the most common. Either reactive droop compensation and/or line-drop compensation may be used, simulating an impedance drop and effectively regulating at some point other than the terminals of the machine. The impedance or range of adjustment and type of compensation should be specified for different types. </font>

<font color="#0f0f0f">Care must be taken to ensure that a consistent pu system is utilized for the compensator parameters and the synchronous machine current base.</font>

<font color="#0f0f0f">For further information see IEEE Standard 421.5-2005, Section 4.</font>


<font color="#0f0f0f">
</font>
 */
case class VoltageCompensatorDynamics
(
    override val sup: DynamicsFunctionBlock,
    ExcitationSystemDynamics: String,
    RemoteInputSignal: String
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
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { clone ().asInstanceOf[VoltageCompensatorDynamics] }
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
        implicit val clz: String = VoltageCompensatorDynamics.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
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
    Parseable[VoltageCompensatorDynamics]
{
    val fields: Array[String] = Array[String] (
        "ExcitationSystemDynamics",
        "RemoteInputSignal"
    )
    val ExcitationSystemDynamics: Fielder = parse_attribute (attribute (cls, fields(0)))
    val RemoteInputSignal: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): VoltageCompensatorDynamics =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = VoltageCompensatorDynamics (
            DynamicsFunctionBlock.parse (context),
            mask (ExcitationSystemDynamics (), 0),
            mask (RemoteInputSignal (), 1)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("ExcitationSystemDynamics", "ExcitationSystemDynamics", false),
        Relationship ("RemoteInputSignal", "RemoteInputSignal", false)
    )
}

private[ninecode] object _VoltageCompensatorDynamics
{
    def register: List[ClassInfo] =
    {
        List (
            GenICompensationForGenJ.register,
            VCompIEEEType1.register,
            VCompIEEEType2.register,
            VoltageCompensatorDynamics.register
        )
    }
}
package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * This class provides the resistive and reactive components of compensation for the generator associated with the IEEE Type 2 voltage compensator for current flow out of one of the other generators in the interconnection.
 *
 * @param sup                        [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param rcij                       <font color="#0f0f0f">Resistive component of compensation of generator associated with this IEEE Type 2 voltage compensator for current flow out of another generator (Rcij).</font>
 * @param xcij                       <font color="#0f0f0f">Reactive component of compensation of generator associated with this IEEE Type 2 voltage compensator for current flow out of another generator (Xcij).</font>
 * @param SynchronousMachineDynamics [[ch.ninecode.model.SynchronousMachineDynamics SynchronousMachineDynamics]] Standard synchronous machine out of which current flow is being compensated for.
 * @param VcompIEEEType2             [[ch.ninecode.model.VCompIEEEType2 VCompIEEEType2]] The standard IEEE Type 2 voltage compensator of this compensation.
 * @group VoltageCompensatorDynamics
 * @groupname VoltageCompensatorDynamics Package VoltageCompensatorDynamics
 * @groupdesc VoltageCompensatorDynamics <font color="#0f0f0f">Synchronous machine terminal voltage transducer and current compensator models</font> adjust the terminal voltage feedback to the excitation system by adding a quantity that is proportional to the terminal current of the generator.  It is linked to a specific generator (synchronous machine).
 *
 *            <font color="#0f0f0f">Several types of compensation are available on most excitation systems. Synchronous machine active and reactive current compensation are the most common. Either reactive droop compensation and/or line-drop compensation may be used, simulating an impedance drop and effectively regulating at some point other than the terminals of the machine. The impedance or range of adjustment and type of compensation should be specified for different types. </font>
 *
 *            <font color="#0f0f0f">Care must be taken to ensure that a consistent pu system is utilized for the compensator parameters and the synchronous machine current base.</font>
 *
 *            <font color="#0f0f0f">For further information see IEEE Standard 421.5-2005, Section 4.</font>
 *
 *
 *            <font color="#0f0f0f">
 *            </font>
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
    def this () =
    {
        this (null, 0.0, 0.0, null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf [IdentifiedObject]

    override def copy (): Row =
    {
        clone ().asInstanceOf [GenICompensationForGenJ]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

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
        Parseable[GenICompensationForGenJ]
{
    override val fields: Array[String] = Array [String](
        "rcij",
        "xcij",
        "SynchronousMachineDynamics",
        "VcompIEEEType2"
    )
    override val relations: List[Relationship] = List (
        Relationship ("SynchronousMachineDynamics", "SynchronousMachineDynamics", "1", "0..*"),
        Relationship ("VcompIEEEType2", "VCompIEEEType2", "1", "2..*")
    )
    val rcij: Fielder = parse_element (element (cls, fields (0)))
    val xcij: Fielder = parse_element (element (cls, fields (1)))
    val SynchronousMachineDynamics: Fielder = parse_attribute (attribute (cls, fields (2)))
    val VcompIEEEType2: Fielder = parse_attribute (attribute (cls, fields (3)))

    def parse (context: Context): GenICompensationForGenJ =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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

/**
 * <font color="#0f0f0f">The class represents the terminal voltage transducer and the load compensator as defined in the IEEE Std 421.5-2005, Section 4.
 *
 * This model is common to all excitation system models described in the IEEE Standard. </font>
 *
 * @param sup [[ch.ninecode.model.VoltageCompensatorDynamics VoltageCompensatorDynamics]] Reference to the superclass object.
 * @param rc  <font color="#0f0f0f">Resistive component of compensation of a generator (Rc).</font>
 * @param tr  <font color="#0f0f0f">Time constant which is used for the combined voltage sensing and compensation signal (Tr).</font>
 * @param xc  <font color="#0f0f0f">Reactive component of compensation of a generator (Xc).</font>
 * @group VoltageCompensatorDynamics
 * @groupname VoltageCompensatorDynamics Package VoltageCompensatorDynamics
 * @groupdesc VoltageCompensatorDynamics <font color="#0f0f0f">Synchronous machine terminal voltage transducer and current compensator models</font> adjust the terminal voltage feedback to the excitation system by adding a quantity that is proportional to the terminal current of the generator.  It is linked to a specific generator (synchronous machine).
 *
 *            <font color="#0f0f0f">Several types of compensation are available on most excitation systems. Synchronous machine active and reactive current compensation are the most common. Either reactive droop compensation and/or line-drop compensation may be used, simulating an impedance drop and effectively regulating at some point other than the terminals of the machine. The impedance or range of adjustment and type of compensation should be specified for different types. </font>
 *
 *            <font color="#0f0f0f">Care must be taken to ensure that a consistent pu system is utilized for the compensator parameters and the synchronous machine current base.</font>
 *
 *            <font color="#0f0f0f">For further information see IEEE Standard 421.5-2005, Section 4.</font>
 *
 *
 *            <font color="#0f0f0f">
 *            </font>
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
    def this () =
    {
        this (null, 0.0, 0.0, 0.0)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def VoltageCompensatorDynamics: VoltageCompensatorDynamics = sup.asInstanceOf [VoltageCompensatorDynamics]

    override def copy (): Row =
    {
        clone ().asInstanceOf [VCompIEEEType1]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

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
        Parseable[VCompIEEEType1]
{
    override val fields: Array[String] = Array [String](
        "rc",
        "tr",
        "xc"
    )
    val rc: Fielder = parse_element (element (cls, fields (0)))
    val tr: Fielder = parse_element (element (cls, fields (1)))
    val xc: Fielder = parse_element (element (cls, fields (2)))

    def parse (context: Context): VCompIEEEType1 =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
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

/**
 * <font color="#0f0f0f">The class represents the terminal voltage transducer and the load compensator as defined in the IEEE Std 421.5-2005, Section 4.
 *
 * This model is designed to cover the following types of compensation: </font>
 *
 * @param sup                     [[ch.ninecode.model.VoltageCompensatorDynamics VoltageCompensatorDynamics]] Reference to the superclass object.
 * @param tr                      <font color="#0f0f0f">Time constant which is used for the combined voltage sensing and compensation signal (Tr).</font>
 * @param GenICompensationForGenJ [[ch.ninecode.model.GenICompensationForGenJ GenICompensationForGenJ]] Compensation of this voltage compensator's generator for current flow out of another generator.
 * @group VoltageCompensatorDynamics
 * @groupname VoltageCompensatorDynamics Package VoltageCompensatorDynamics
 * @groupdesc VoltageCompensatorDynamics <font color="#0f0f0f">Synchronous machine terminal voltage transducer and current compensator models</font> adjust the terminal voltage feedback to the excitation system by adding a quantity that is proportional to the terminal current of the generator.  It is linked to a specific generator (synchronous machine).
 *
 *            <font color="#0f0f0f">Several types of compensation are available on most excitation systems. Synchronous machine active and reactive current compensation are the most common. Either reactive droop compensation and/or line-drop compensation may be used, simulating an impedance drop and effectively regulating at some point other than the terminals of the machine. The impedance or range of adjustment and type of compensation should be specified for different types. </font>
 *
 *            <font color="#0f0f0f">Care must be taken to ensure that a consistent pu system is utilized for the compensator parameters and the synchronous machine current base.</font>
 *
 *            <font color="#0f0f0f">For further information see IEEE Standard 421.5-2005, Section 4.</font>
 *
 *
 *            <font color="#0f0f0f">
 *            </font>
 */
case class VCompIEEEType2
(
    override val sup: VoltageCompensatorDynamics,
    tr: Double,
    GenICompensationForGenJ: List[String]
)
    extends
        Element
{
    /**
     * Zero args constructor.
     */
    def this () =
    {
        this (null, 0.0, List ())
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def VoltageCompensatorDynamics: VoltageCompensatorDynamics = sup.asInstanceOf [VoltageCompensatorDynamics]

    override def copy (): Row =
    {
        clone ().asInstanceOf [VCompIEEEType2]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = VCompIEEEType2.cls

        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (VCompIEEEType2.fields (position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x ⇒ emit_attribute (VCompIEEEType2.fields (position), x))

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
        Parseable[VCompIEEEType2]
{
    override val fields: Array[String] = Array [String](
        "tr",
        "GenICompensationForGenJ"
    )
    override val relations: List[Relationship] = List (
        Relationship ("GenICompensationForGenJ", "GenICompensationForGenJ", "2..*", "1")
    )
    val tr: Fielder = parse_element (element (cls, fields (0)))
    val GenICompensationForGenJ: FielderMultiple = parse_attributes (attribute (cls, fields (1)))

    def parse (context: Context): VCompIEEEType2 =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = VCompIEEEType2 (
            VoltageCompensatorDynamics.parse (context),
            toDouble (mask (tr (), 0)),
            masks (GenICompensationForGenJ (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Voltage compensator function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 *
 * @param sup                      [[ch.ninecode.model.DynamicsFunctionBlock DynamicsFunctionBlock]] Reference to the superclass object.
 * @param ExcitationSystemDynamics [[ch.ninecode.model.ExcitationSystemDynamics ExcitationSystemDynamics]] Excitation system model with which this voltage compensator is associated.
 * @param RemoteInputSignal        [[ch.ninecode.model.RemoteInputSignal RemoteInputSignal]] Remote input signal used by this voltage compensator model.
 * @group VoltageCompensatorDynamics
 * @groupname VoltageCompensatorDynamics Package VoltageCompensatorDynamics
 * @groupdesc VoltageCompensatorDynamics <font color="#0f0f0f">Synchronous machine terminal voltage transducer and current compensator models</font> adjust the terminal voltage feedback to the excitation system by adding a quantity that is proportional to the terminal current of the generator.  It is linked to a specific generator (synchronous machine).
 *
 *            <font color="#0f0f0f">Several types of compensation are available on most excitation systems. Synchronous machine active and reactive current compensation are the most common. Either reactive droop compensation and/or line-drop compensation may be used, simulating an impedance drop and effectively regulating at some point other than the terminals of the machine. The impedance or range of adjustment and type of compensation should be specified for different types. </font>
 *
 *            <font color="#0f0f0f">Care must be taken to ensure that a consistent pu system is utilized for the compensator parameters and the synchronous machine current base.</font>
 *
 *            <font color="#0f0f0f">For further information see IEEE Standard 421.5-2005, Section 4.</font>
 *
 *
 *            <font color="#0f0f0f">
 *            </font>
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
    def this () =
    {
        this (null, null, null)
    }

    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf [DynamicsFunctionBlock]

    override def copy (): Row =
    {
        clone ().asInstanceOf [VoltageCompensatorDynamics]
    }

    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf [AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }

    override def length: Int = productArity

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
        Parseable[VoltageCompensatorDynamics]
{
    override val fields: Array[String] = Array [String](
        "ExcitationSystemDynamics",
        "RemoteInputSignal"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ExcitationSystemDynamics", "ExcitationSystemDynamics", "1", "0..1"),
        Relationship ("RemoteInputSignal", "RemoteInputSignal", "0..1", "0..1")
    )
    val ExcitationSystemDynamics: Fielder = parse_attribute (attribute (cls, fields (0)))
    val RemoteInputSignal: Fielder = parse_attribute (attribute (cls, fields (1)))

    def parse (context: Context): VoltageCompensatorDynamics =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array (0)
        val ret = VoltageCompensatorDynamics (
            DynamicsFunctionBlock.parse (context),
            mask (ExcitationSystemDynamics (), 0),
            mask (RemoteInputSignal (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
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
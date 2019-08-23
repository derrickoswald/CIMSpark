package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * CSC function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 *
 * @param sup [[ch.ninecode.model.HVDCDynamics HVDCDynamics]] Reference to the superclass object.
 * @param CSConverter [[ch.ninecode.model.CsConverter CsConverter]] Current source converter to which current source converter dynamics model applies.
 * @group HVDCDynamics
 * @groupname HVDCDynamics Package HVDCDynamics
 * @groupdesc HVDCDynamics High voltage direct current (HVDC) models.
 */
final case class CSCDynamics
(
    override val sup: HVDCDynamics,
    CSConverter: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def HVDCDynamics: HVDCDynamics = sup.asInstanceOf[HVDCDynamics]
    override def copy (): Row = { clone ().asInstanceOf[CSCDynamics] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = CSCDynamics.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (CSCDynamics.fields (position), value)
        emitattr (0, CSConverter)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:CSCDynamics rdf:ID=\"%s\">\n%s\t</cim:CSCDynamics>".format (id, export_fields)
    }
}

object CSCDynamics
extends
    Parseable[CSCDynamics]
{
    override val fields: Array[String] = Array[String] (
        "CSConverter"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CSConverter", "CsConverter", "1", "0..1")
    )
    val CSConverter: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): CSCDynamics =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = CSCDynamics (
            HVDCDynamics.parse (context),
            mask (CSConverter (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * HVDC whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 *
 * @param sup [[ch.ninecode.model.DynamicsFunctionBlock DynamicsFunctionBlock]] Reference to the superclass object.
 * @group HVDCDynamics
 * @groupname HVDCDynamics Package HVDCDynamics
 * @groupdesc HVDCDynamics High voltage direct current (HVDC) models.
 */
final case class HVDCDynamics
(
    override val sup: DynamicsFunctionBlock
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def DynamicsFunctionBlock: DynamicsFunctionBlock = sup.asInstanceOf[DynamicsFunctionBlock]
    override def copy (): Row = { clone ().asInstanceOf[HVDCDynamics] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:HVDCDynamics rdf:ID=\"%s\">\n%s\t</cim:HVDCDynamics>".format (id, export_fields)
    }
}

object HVDCDynamics
extends
    Parseable[HVDCDynamics]
{

    def parse (context: Context): HVDCDynamics =
    {
        implicit val ctx: Context = context
        val ret = HVDCDynamics (
            DynamicsFunctionBlock.parse (context)
        )
        ret
    }
}

/**
 * VSC function block whose behaviour is described by reference to a standard model <font color="#0f0f0f">or by definition of a user-defined model.</font>
 *
 * @param sup [[ch.ninecode.model.HVDCDynamics HVDCDynamics]] Reference to the superclass object.
 * @param VsConverter [[ch.ninecode.model.VsConverter VsConverter]] Voltage source converter to which voltage source converter dynamics model applies.
 * @group HVDCDynamics
 * @groupname HVDCDynamics Package HVDCDynamics
 * @groupdesc HVDCDynamics High voltage direct current (HVDC) models.
 */
final case class VSCDynamics
(
    override val sup: HVDCDynamics,
    VsConverter: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def HVDCDynamics: HVDCDynamics = sup.asInstanceOf[HVDCDynamics]
    override def copy (): Row = { clone ().asInstanceOf[VSCDynamics] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = VSCDynamics.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (VSCDynamics.fields (position), value)
        emitattr (0, VsConverter)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:VSCDynamics rdf:ID=\"%s\">\n%s\t</cim:VSCDynamics>".format (id, export_fields)
    }
}

object VSCDynamics
extends
    Parseable[VSCDynamics]
{
    override val fields: Array[String] = Array[String] (
        "VsConverter"
    )
    override val relations: List[Relationship] = List (
        Relationship ("VsConverter", "VsConverter", "1", "0..1")
    )
    val VsConverter: Fielder = parse_attribute (attribute (cls, fields(0)))

    def parse (context: Context): VSCDynamics =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = VSCDynamics (
            HVDCDynamics.parse (context),
            mask (VsConverter (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _HVDCDynamics
{
    def register: List[ClassInfo] =
    {
        List (
            CSCDynamics.register,
            HVDCDynamics.register,
            VSCDynamics.register
        )
    }
}
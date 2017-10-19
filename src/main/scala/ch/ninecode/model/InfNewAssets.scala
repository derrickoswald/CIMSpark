package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * The result of a problem (typically an asset failure) diagnosis.
 *
 * @param sup [[ch.ninecode.model.ProcedureDataSet ProcedureDataSet]] Reference to the superclass object.
 * @param effect Effect of problem.
 * @param failureMode Failuer mode, for example: Failure to Insulate; Failure to conduct; Failure to contain oil; Failure to provide ground plane; Other.
 * @param finalCause Cause of problem determined during diagnosis.
 * @param finalCode Code for diagnosed probem type.
 * @param finalOrigin Origin of problem determined during diagnosis.
 * @param finalRemark Remarks pertaining to findings during problem diagnosis.
 * @param phaseCode Phase(s) diagnosed.
 * @param preliminaryCode Code for problem type determined during preliminary assessment.
 * @param preliminaryDateTime Date and time preliminary assessment of problem was performed.
 * @param preliminaryRemark Remarks pertaining to preliminary assessment of problem.
 * @param rootCause Root cause of problem determined during diagnosis.
 * @param rootOrigin Root origin of problem determined during diagnosis.
 * @param rootRemark Remarks pertaining to root cause findings during problem diagnosis.
 * @group InfNewAssets
 * @groupname InfNewAssets Package InfNewAssets
 */
case class DiagnosisDataSet
(
    override val sup: ProcedureDataSet,
    effect: String,
    failureMode: String,
    finalCause: String,
    finalCode: String,
    finalOrigin: String,
    finalRemark: String,
    phaseCode: String,
    preliminaryCode: String,
    preliminaryDateTime: String,
    preliminaryRemark: String,
    rootCause: String,
    rootOrigin: String,
    rootRemark: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
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
    def ProcedureDataSet: ProcedureDataSet = sup.asInstanceOf[ProcedureDataSet]
    override def copy (): Row = { clone ().asInstanceOf[DiagnosisDataSet] }
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
        implicit val clz: String = DiagnosisDataSet.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DiagnosisDataSet.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DiagnosisDataSet.fields (position), value)
        emitelem (0, effect)
        emitelem (1, failureMode)
        emitelem (2, finalCause)
        emitelem (3, finalCode)
        emitelem (4, finalOrigin)
        emitelem (5, finalRemark)
        emitattr (6, phaseCode)
        emitelem (7, preliminaryCode)
        emitelem (8, preliminaryDateTime)
        emitelem (9, preliminaryRemark)
        emitelem (10, rootCause)
        emitelem (11, rootOrigin)
        emitelem (12, rootRemark)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DiagnosisDataSet rdf:ID=\"%s\">\n%s\t</cim:DiagnosisDataSet>".format (id, export_fields)
    }
}

object DiagnosisDataSet
extends
    Parseable[DiagnosisDataSet]
{
    val fields: Array[String] = Array[String] (
        "effect",
        "failureMode",
        "finalCause",
        "finalCode",
        "finalOrigin",
        "finalRemark",
        "phaseCode",
        "preliminaryCode",
        "preliminaryDateTime",
        "preliminaryRemark",
        "rootCause",
        "rootOrigin",
        "rootRemark"
    )
    val effect: Fielder = parse_element (element (cls, fields(0)))
    val failureMode: Fielder = parse_element (element (cls, fields(1)))
    val finalCause: Fielder = parse_element (element (cls, fields(2)))
    val finalCode: Fielder = parse_element (element (cls, fields(3)))
    val finalOrigin: Fielder = parse_element (element (cls, fields(4)))
    val finalRemark: Fielder = parse_element (element (cls, fields(5)))
    val phaseCode: Fielder = parse_attribute (attribute (cls, fields(6)))
    val preliminaryCode: Fielder = parse_element (element (cls, fields(7)))
    val preliminaryDateTime: Fielder = parse_element (element (cls, fields(8)))
    val preliminaryRemark: Fielder = parse_element (element (cls, fields(9)))
    val rootCause: Fielder = parse_element (element (cls, fields(10)))
    val rootOrigin: Fielder = parse_element (element (cls, fields(11)))
    val rootRemark: Fielder = parse_element (element (cls, fields(12)))

    def parse (context: Context): DiagnosisDataSet =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = DiagnosisDataSet (
            ProcedureDataSet.parse (context),
            mask (effect (), 0),
            mask (failureMode (), 1),
            mask (finalCause (), 2),
            mask (finalCode (), 3),
            mask (finalOrigin (), 4),
            mask (finalRemark (), 5),
            mask (phaseCode (), 6),
            mask (preliminaryCode (), 7),
            mask (preliminaryDateTime (), 8),
            mask (preliminaryRemark (), 9),
            mask (rootCause (), 10),
            mask (rootOrigin (), 11),
            mask (rootRemark (), 12)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Documents the result of one inspection, for a given attribute of an asset.
 *
 * @param sup [[ch.ninecode.model.ProcedureDataSet ProcedureDataSet]] Reference to the superclass object.
 * @param locationCondition Description of the conditions of the location where the asset resides.
 * @group InfNewAssets
 * @groupname InfNewAssets Package InfNewAssets
 */
case class InspectionDataSet
(
    override val sup: ProcedureDataSet,
    locationCondition: String
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
    def ProcedureDataSet: ProcedureDataSet = sup.asInstanceOf[ProcedureDataSet]
    override def copy (): Row = { clone ().asInstanceOf[InspectionDataSet] }
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
        implicit val clz: String = InspectionDataSet.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (InspectionDataSet.fields (position), value)
        emitelem (0, locationCondition)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:InspectionDataSet rdf:ID=\"%s\">\n%s\t</cim:InspectionDataSet>".format (id, export_fields)
    }
}

object InspectionDataSet
extends
    Parseable[InspectionDataSet]
{
    val fields: Array[String] = Array[String] (
        "locationCondition"
    )
    val locationCondition: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): InspectionDataSet =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = InspectionDataSet (
            ProcedureDataSet.parse (context),
            mask (locationCondition (), 0)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * The result of a maintenance activity, a type of Procedure, for a given attribute of an asset.
 *
 * @param sup [[ch.ninecode.model.ProcedureDataSet ProcedureDataSet]] Reference to the superclass object.
 * @param conditionAfter Condition of asset just following maintenance procedure.
 * @param conditionBefore Description of the condition of the asset just prior to maintenance being performed.
 * @param maintCode Code for the type of maintenance performed.
 * @group InfNewAssets
 * @groupname InfNewAssets Package InfNewAssets
 */
case class MaintenanceDataSet
(
    override val sup: ProcedureDataSet,
    conditionAfter: String,
    conditionBefore: String,
    maintCode: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null) }
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
    def ProcedureDataSet: ProcedureDataSet = sup.asInstanceOf[ProcedureDataSet]
    override def copy (): Row = { clone ().asInstanceOf[MaintenanceDataSet] }
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
        implicit val clz: String = MaintenanceDataSet.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (MaintenanceDataSet.fields (position), value)
        emitelem (0, conditionAfter)
        emitelem (1, conditionBefore)
        emitelem (2, maintCode)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:MaintenanceDataSet rdf:ID=\"%s\">\n%s\t</cim:MaintenanceDataSet>".format (id, export_fields)
    }
}

object MaintenanceDataSet
extends
    Parseable[MaintenanceDataSet]
{
    val fields: Array[String] = Array[String] (
        "conditionAfter",
        "conditionBefore",
        "maintCode"
    )
    val conditionAfter: Fielder = parse_element (element (cls, fields(0)))
    val conditionBefore: Fielder = parse_element (element (cls, fields(1)))
    val maintCode: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: Context): MaintenanceDataSet =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = MaintenanceDataSet (
            ProcedureDataSet.parse (context),
            mask (conditionAfter (), 0),
            mask (conditionBefore (), 1),
            mask (maintCode (), 2)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Test results, usually obtained by a lab or other independent organisation.
 *
 * @param sup [[ch.ninecode.model.ProcedureDataSet ProcedureDataSet]] Reference to the superclass object.
 * @param conclusion Conclusion drawn from test results.
 * @param specimenID Identifier of specimen used in inspection or test.
 * @param specimenToLabDateTime Date and time the specimen was received by the lab.
 * @group InfNewAssets
 * @groupname InfNewAssets Package InfNewAssets
 */
case class TestDataSet
(
    override val sup: ProcedureDataSet,
    conclusion: String,
    specimenID: String,
    specimenToLabDateTime: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, null, null) }
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
    def ProcedureDataSet: ProcedureDataSet = sup.asInstanceOf[ProcedureDataSet]
    override def copy (): Row = { clone ().asInstanceOf[TestDataSet] }
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
        implicit val clz: String = TestDataSet.cls
        def mask (position: Int): Boolean = 0 != (bitfields & (1 << position))
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TestDataSet.fields (position), value)
        emitelem (0, conclusion)
        emitelem (1, specimenID)
        emitelem (2, specimenToLabDateTime)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TestDataSet rdf:ID=\"%s\">\n%s\t</cim:TestDataSet>".format (id, export_fields)
    }
}

object TestDataSet
extends
    Parseable[TestDataSet]
{
    val fields: Array[String] = Array[String] (
        "conclusion",
        "specimenID",
        "specimenToLabDateTime"
    )
    val conclusion: Fielder = parse_element (element (cls, fields(0)))
    val specimenID: Fielder = parse_element (element (cls, fields(1)))
    val specimenToLabDateTime: Fielder = parse_element (element (cls, fields(2)))

    def parse (context: Context): TestDataSet =
    {
        implicit val ctx: Context = context
        var fields: Int = 0
        def mask (field: Field, position: Int): String = { if (field._2) fields |= 1 << position; field._1 }
        val ret = TestDataSet (
            ProcedureDataSet.parse (context),
            mask (conclusion (), 0),
            mask (specimenID (), 1),
            mask (specimenToLabDateTime (), 2)
        )
        ret.bitfields = fields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

private[ninecode] object _InfNewAssets
{
    def register: List[ClassInfo] =
    {
        List (
            DiagnosisDataSet.register,
            InspectionDataSet.register,
            MaintenanceDataSet.register,
            TestDataSet.register
        )
    }
}
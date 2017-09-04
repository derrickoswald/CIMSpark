package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

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
        sup.export_fields +
        (if (null != effect) "\t\t<cim:DiagnosisDataSet.effect>" + effect + "</cim:DiagnosisDataSet.effect>\n" else "") +
        (if (null != failureMode) "\t\t<cim:DiagnosisDataSet.failureMode>" + failureMode + "</cim:DiagnosisDataSet.failureMode>\n" else "") +
        (if (null != finalCause) "\t\t<cim:DiagnosisDataSet.finalCause>" + finalCause + "</cim:DiagnosisDataSet.finalCause>\n" else "") +
        (if (null != finalCode) "\t\t<cim:DiagnosisDataSet.finalCode>" + finalCode + "</cim:DiagnosisDataSet.finalCode>\n" else "") +
        (if (null != finalOrigin) "\t\t<cim:DiagnosisDataSet.finalOrigin>" + finalOrigin + "</cim:DiagnosisDataSet.finalOrigin>\n" else "") +
        (if (null != finalRemark) "\t\t<cim:DiagnosisDataSet.finalRemark>" + finalRemark + "</cim:DiagnosisDataSet.finalRemark>\n" else "") +
        (if (null != phaseCode) "\t\t<cim:DiagnosisDataSet.phaseCode rdf:resource=\"#" + phaseCode + "\"/>\n" else "") +
        (if (null != preliminaryCode) "\t\t<cim:DiagnosisDataSet.preliminaryCode>" + preliminaryCode + "</cim:DiagnosisDataSet.preliminaryCode>\n" else "") +
        (if (null != preliminaryDateTime) "\t\t<cim:DiagnosisDataSet.preliminaryDateTime>" + preliminaryDateTime + "</cim:DiagnosisDataSet.preliminaryDateTime>\n" else "") +
        (if (null != preliminaryRemark) "\t\t<cim:DiagnosisDataSet.preliminaryRemark>" + preliminaryRemark + "</cim:DiagnosisDataSet.preliminaryRemark>\n" else "") +
        (if (null != rootCause) "\t\t<cim:DiagnosisDataSet.rootCause>" + rootCause + "</cim:DiagnosisDataSet.rootCause>\n" else "") +
        (if (null != rootOrigin) "\t\t<cim:DiagnosisDataSet.rootOrigin>" + rootOrigin + "</cim:DiagnosisDataSet.rootOrigin>\n" else "") +
        (if (null != rootRemark) "\t\t<cim:DiagnosisDataSet.rootRemark>" + rootRemark + "</cim:DiagnosisDataSet.rootRemark>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:DiagnosisDataSet rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DiagnosisDataSet>"
    }
}

object DiagnosisDataSet
extends
    Parseable[DiagnosisDataSet]
{
    val effect = parse_element (element ("""DiagnosisDataSet.effect"""))
    val failureMode = parse_element (element ("""DiagnosisDataSet.failureMode"""))
    val finalCause = parse_element (element ("""DiagnosisDataSet.finalCause"""))
    val finalCode = parse_element (element ("""DiagnosisDataSet.finalCode"""))
    val finalOrigin = parse_element (element ("""DiagnosisDataSet.finalOrigin"""))
    val finalRemark = parse_element (element ("""DiagnosisDataSet.finalRemark"""))
    val phaseCode = parse_attribute (attribute ("""DiagnosisDataSet.phaseCode"""))
    val preliminaryCode = parse_element (element ("""DiagnosisDataSet.preliminaryCode"""))
    val preliminaryDateTime = parse_element (element ("""DiagnosisDataSet.preliminaryDateTime"""))
    val preliminaryRemark = parse_element (element ("""DiagnosisDataSet.preliminaryRemark"""))
    val rootCause = parse_element (element ("""DiagnosisDataSet.rootCause"""))
    val rootOrigin = parse_element (element ("""DiagnosisDataSet.rootOrigin"""))
    val rootRemark = parse_element (element ("""DiagnosisDataSet.rootRemark"""))
    def parse (context: Context): DiagnosisDataSet =
    {
        DiagnosisDataSet(
            ProcedureDataSet.parse (context),
            effect (context),
            failureMode (context),
            finalCause (context),
            finalCode (context),
            finalOrigin (context),
            finalRemark (context),
            phaseCode (context),
            preliminaryCode (context),
            preliminaryDateTime (context),
            preliminaryRemark (context),
            rootCause (context),
            rootOrigin (context),
            rootRemark (context)
        )
    }
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
        sup.export_fields +
        (if (null != locationCondition) "\t\t<cim:InspectionDataSet.locationCondition>" + locationCondition + "</cim:InspectionDataSet.locationCondition>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:InspectionDataSet rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:InspectionDataSet>"
    }
}

object InspectionDataSet
extends
    Parseable[InspectionDataSet]
{
    val locationCondition = parse_element (element ("""InspectionDataSet.locationCondition"""))
    def parse (context: Context): InspectionDataSet =
    {
        InspectionDataSet(
            ProcedureDataSet.parse (context),
            locationCondition (context)
        )
    }
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
        sup.export_fields +
        (if (null != conditionAfter) "\t\t<cim:MaintenanceDataSet.conditionAfter>" + conditionAfter + "</cim:MaintenanceDataSet.conditionAfter>\n" else "") +
        (if (null != conditionBefore) "\t\t<cim:MaintenanceDataSet.conditionBefore>" + conditionBefore + "</cim:MaintenanceDataSet.conditionBefore>\n" else "") +
        (if (null != maintCode) "\t\t<cim:MaintenanceDataSet.maintCode>" + maintCode + "</cim:MaintenanceDataSet.maintCode>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MaintenanceDataSet rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MaintenanceDataSet>"
    }
}

object MaintenanceDataSet
extends
    Parseable[MaintenanceDataSet]
{
    val conditionAfter = parse_element (element ("""MaintenanceDataSet.conditionAfter"""))
    val conditionBefore = parse_element (element ("""MaintenanceDataSet.conditionBefore"""))
    val maintCode = parse_element (element ("""MaintenanceDataSet.maintCode"""))
    def parse (context: Context): MaintenanceDataSet =
    {
        MaintenanceDataSet(
            ProcedureDataSet.parse (context),
            conditionAfter (context),
            conditionBefore (context),
            maintCode (context)
        )
    }
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
        sup.export_fields +
        (if (null != conclusion) "\t\t<cim:TestDataSet.conclusion>" + conclusion + "</cim:TestDataSet.conclusion>\n" else "") +
        (if (null != specimenID) "\t\t<cim:TestDataSet.specimenID>" + specimenID + "</cim:TestDataSet.specimenID>\n" else "") +
        (if (null != specimenToLabDateTime) "\t\t<cim:TestDataSet.specimenToLabDateTime>" + specimenToLabDateTime + "</cim:TestDataSet.specimenToLabDateTime>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TestDataSet rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TestDataSet>"
    }
}

object TestDataSet
extends
    Parseable[TestDataSet]
{
    val conclusion = parse_element (element ("""TestDataSet.conclusion"""))
    val specimenID = parse_element (element ("""TestDataSet.specimenID"""))
    val specimenToLabDateTime = parse_element (element ("""TestDataSet.specimenToLabDateTime"""))
    def parse (context: Context): TestDataSet =
    {
        TestDataSet(
            ProcedureDataSet.parse (context),
            conclusion (context),
            specimenID (context),
            specimenToLabDateTime (context)
        )
    }
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
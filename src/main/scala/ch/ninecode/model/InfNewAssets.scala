package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context


/**
 * The result of a problem (typically an asset failure) diagnosis.
 * @param sup Reference to the superclass object.
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
 */
case class DiagnosisDataSet
(
    override val sup: Element,
    val effect: String,
    val failureMode: String,
    val finalCause: String,
    val finalCode: String,
    val finalOrigin: String,
    val finalRemark: String,
    val phaseCode: String,
    val preliminaryCode: String,
    val preliminaryDateTime: String,
    val preliminaryRemark: String,
    val rootCause: String,
    val rootOrigin: String,
    val rootRemark: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def ProcedureDataSet: ProcedureDataSet = sup.asInstanceOf[ProcedureDataSet]
    override def copy (): Row = { return (clone ().asInstanceOf[DiagnosisDataSet]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DiagnosisDataSet
extends
    Parseable[DiagnosisDataSet]
{
    val sup = ProcedureDataSet.parse _
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
            sup (context),
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
 * @param sup Reference to the superclass object.
 * @param locationCondition Description of the conditions of the location where the asset resides.
 */
case class InspectionDataSet
(
    override val sup: Element,
    val locationCondition: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def ProcedureDataSet: ProcedureDataSet = sup.asInstanceOf[ProcedureDataSet]
    override def copy (): Row = { return (clone ().asInstanceOf[InspectionDataSet]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object InspectionDataSet
extends
    Parseable[InspectionDataSet]
{
    val sup = ProcedureDataSet.parse _
    val locationCondition = parse_element (element ("""InspectionDataSet.locationCondition"""))
    def parse (context: Context): InspectionDataSet =
    {
        InspectionDataSet(
            sup (context),
            locationCondition (context)
        )
    }
}

/**
 * The result of a maintenance activity, a type of Procedure, for a given attribute of an asset.
 * @param sup Reference to the superclass object.
 * @param conditionAfter Condition of asset just following maintenance procedure.
 * @param conditionBefore Description of the condition of the asset just prior to maintenance being performed.
 * @param maintCode Code for the type of maintenance performed.
 */
case class MaintenanceDataSet
(
    override val sup: Element,
    val conditionAfter: String,
    val conditionBefore: String,
    val maintCode: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def ProcedureDataSet: ProcedureDataSet = sup.asInstanceOf[ProcedureDataSet]
    override def copy (): Row = { return (clone ().asInstanceOf[MaintenanceDataSet]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MaintenanceDataSet
extends
    Parseable[MaintenanceDataSet]
{
    val sup = ProcedureDataSet.parse _
    val conditionAfter = parse_element (element ("""MaintenanceDataSet.conditionAfter"""))
    val conditionBefore = parse_element (element ("""MaintenanceDataSet.conditionBefore"""))
    val maintCode = parse_element (element ("""MaintenanceDataSet.maintCode"""))
    def parse (context: Context): MaintenanceDataSet =
    {
        MaintenanceDataSet(
            sup (context),
            conditionAfter (context),
            conditionBefore (context),
            maintCode (context)
        )
    }
}

/**
 * Test results, usually obtained by a lab or other independent organisation.
 * @param sup Reference to the superclass object.
 * @param conclusion Conclusion drawn from test results.
 * @param specimenID Identifier of specimen used in inspection or test.
 * @param specimenToLabDateTime Date and time the specimen was received by the lab.
 */
case class TestDataSet
(
    override val sup: Element,
    val conclusion: String,
    val specimenID: String,
    val specimenToLabDateTime: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def ProcedureDataSet: ProcedureDataSet = sup.asInstanceOf[ProcedureDataSet]
    override def copy (): Row = { return (clone ().asInstanceOf[TestDataSet]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TestDataSet
extends
    Parseable[TestDataSet]
{
    val sup = ProcedureDataSet.parse _
    val conclusion = parse_element (element ("""TestDataSet.conclusion"""))
    val specimenID = parse_element (element ("""TestDataSet.specimenID"""))
    val specimenToLabDateTime = parse_element (element ("""TestDataSet.specimenToLabDateTime"""))
    def parse (context: Context): TestDataSet =
    {
        TestDataSet(
            sup (context),
            conclusion (context),
            specimenID (context),
            specimenToLabDateTime (context)
        )
    }
}

object _InfNewAssets
{
    def register: Unit =
    {
        DiagnosisDataSet.register
        InspectionDataSet.register
        MaintenanceDataSet.register
        TestDataSet.register
    }
}
package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context


/**
 * The result of a problem (typically an asset failure) diagnosis.
 */
case class DiagnosisDataSet
(

    override val sup: ProcedureDataSet,

    /**
     * Effect of problem.
     */
    val effect: String,

    /**
     * Failuer mode, for example: Failure to Insulate; Failure to conduct; Failure to contain oil; Failure to provide ground plane; Other.
     */
    val failureMode: String,

    /**
     * Cause of problem determined during diagnosis.
     */
    val finalCause: String,

    /**
     * Code for diagnosed probem type.
     */
    val finalCode: String,

    /**
     * Origin of problem determined during diagnosis.
     */
    val finalOrigin: String,

    /**
     * Remarks pertaining to findings during problem diagnosis.
     */
    val finalRemark: String,

    /**
     * Phase(s) diagnosed.
     */
    val phaseCode: String,

    /**
     * Code for problem type determined during preliminary assessment.
     */
    val preliminaryCode: String,

    /**
     * Date and time preliminary assessment of problem was performed.
     */
    val preliminaryDateTime: String,

    /**
     * Remarks pertaining to preliminary assessment of problem.
     */
    val preliminaryRemark: String,

    /**
     * Root cause of problem determined during diagnosis.
     */
    val rootCause: String,

    /**
     * Root origin of problem determined during diagnosis.
     */
    val rootOrigin: String,

    /**
     * Remarks pertaining to root cause findings during problem diagnosis.
     */
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
    val effect = parse_element (element ("""DiagnosisDataSet.effect"""))_
    val failureMode = parse_element (element ("""DiagnosisDataSet.failureMode"""))_
    val finalCause = parse_element (element ("""DiagnosisDataSet.finalCause"""))_
    val finalCode = parse_element (element ("""DiagnosisDataSet.finalCode"""))_
    val finalOrigin = parse_element (element ("""DiagnosisDataSet.finalOrigin"""))_
    val finalRemark = parse_element (element ("""DiagnosisDataSet.finalRemark"""))_
    val phaseCode = parse_attribute (attribute ("""DiagnosisDataSet.phaseCode"""))_
    val preliminaryCode = parse_element (element ("""DiagnosisDataSet.preliminaryCode"""))_
    val preliminaryDateTime = parse_element (element ("""DiagnosisDataSet.preliminaryDateTime"""))_
    val preliminaryRemark = parse_element (element ("""DiagnosisDataSet.preliminaryRemark"""))_
    val rootCause = parse_element (element ("""DiagnosisDataSet.rootCause"""))_
    val rootOrigin = parse_element (element ("""DiagnosisDataSet.rootOrigin"""))_
    val rootRemark = parse_element (element ("""DiagnosisDataSet.rootRemark"""))_
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
 */
case class InspectionDataSet
(

    override val sup: ProcedureDataSet,

    /**
     * Description of the conditions of the location where the asset resides.
     */
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
    val locationCondition = parse_element (element ("""InspectionDataSet.locationCondition"""))_
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
 */
case class MaintenanceDataSet
(

    override val sup: ProcedureDataSet,

    /**
     * Condition of asset just following maintenance procedure.
     */
    val conditionAfter: String,

    /**
     * Description of the condition of the asset just prior to maintenance being performed.
     */
    val conditionBefore: String,

    /**
     * Code for the type of maintenance performed.
     */
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
    val conditionAfter = parse_element (element ("""MaintenanceDataSet.conditionAfter"""))_
    val conditionBefore = parse_element (element ("""MaintenanceDataSet.conditionBefore"""))_
    val maintCode = parse_element (element ("""MaintenanceDataSet.maintCode"""))_
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
 */
case class TestDataSet
(

    override val sup: ProcedureDataSet,

    /**
     * Conclusion drawn from test results.
     */
    val conclusion: String,

    /**
     * Identifier of specimen used in inspection or test.
     */
    val specimenID: String,

    /**
     * Date and time the specimen was received by the lab.
     */
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
    val conclusion = parse_element (element ("""TestDataSet.conclusion"""))_
    val specimenID = parse_element (element ("""TestDataSet.specimenID"""))_
    val specimenToLabDateTime = parse_element (element ("""TestDataSet.specimenToLabDateTime"""))_
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
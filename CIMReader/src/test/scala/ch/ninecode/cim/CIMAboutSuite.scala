package ch.ninecode.cim

import java.io.File
import java.util

import org.apache.spark.sql.SparkSession

import ch.ninecode.model._

class CIMAboutSuite extends ch.ninecode.SparkSuite
{
    val FILE_DEPOT = "data/"

    override def run (testName: Option[String], args: org.scalatest.Args): org.scalatest.Status =
    {
        // unpack the zip file
        new Unzip ().unzip (s"${FILE_DEPOT}CGMES_v2.4.15_TestConfigurations_v4.0.3.zip", FILE_DEPOT)
        new Unzip ().unzip (s"${FILE_DEPOT}MicroGrid/BaseCase_BC/CGMES_v2.4.15_MicroGridTestConfiguration_BC_BE_v2.zip", s"${FILE_DEPOT}MicroGrid/BaseCase_BC/")
        new Unzip ().unzip (s"${FILE_DEPOT}MicroGrid/BaseCase_BC/CGMES_v2.4.15_MicroGridTestConfiguration_BC_NL_v2.zip", s"${FILE_DEPOT}MicroGrid/BaseCase_BC/")
        new Unzip ().unzip (s"${FILE_DEPOT}MicroGrid/BaseCase_BC/CGMES_v2.4.15_MicroGridTestConfiguration_BD_v2.zip", s"${FILE_DEPOT}MicroGrid/BaseCase_BC/")
        // run the tests
        val ret  = super.run (testName, args)
        // erase the unpacked files
        deleteRecursive (new File (s"${FILE_DEPOT}MicroGrid/"))
        deleteRecursive (new File (s"${FILE_DEPOT}MicroGrid_Error/"))
        deleteRecursive (new File (s"${FILE_DEPOT}MiniGrid/"))
        deleteRecursive (new File (s"${FILE_DEPOT}SmallGrid/"))
        deleteRecursive (new File (s"${FILE_DEPOT}RealGrid/"))
        ret
    }

    // values from MicroGrid/Documentation/CGMES_v2.4.15_MicroGridTestConfiguration_v2.docx

    val BelgiumElementCount = Array (
        ("ACLineSegment", 7),
        ("BaseVoltage", 7),
        ("BusbarSection", 9),
        ("ConnectivityNode", 6),
        ("CoordinateSystem", 1),
        ("CurrentLimit", 100),
        ("CurveData", 3),
        ("Diagram", 2),
        ("DiagramObject", 108),
        ("DiagramObjectPoint", 183),
        ("EnergyConsumer", 3),
        ("EquivalentInjection", 5),
        ("ExcIEEEAC4A", 2),
        ("GeneratingUnit", 2),
        ("GeographicalRegion", 2),
        ("GovSteam0", 1),
        ("GovSteam1", 1),
        ("Junction", 1),
        ("Line", 13),
        ("LinearShuntCompensator", 2),
        ("LoadAggregate", 3),
        ("LoadResponseCharacteristic", 1),
        ("LoadStatic", 3),
        ("Location", 9),
        ("OperationalLimitSet", 23),
        ("OperationalLimitType", 8),
        ("PhaseTapChangerAsymmetrical", 1),
        ("PositionPoint", 29),
        ("PowerTransformer", 4),
        ("PowerTransformerEnd", 9),
        ("Pss2B", 2),
        ("RatioTapChanger", 3),
        ("ReactiveCapabilityCurve", 1),
        ("RegulatingControl", 8), // includes TapChangerControl (isA RegulatingControl)
        ("SubGeographicalRegion", 3),
        ("Substation", 2),
        ("SvPowerFlow", 12),
        ("SvShuntCompensatorSections", 2),
        ("SvTapStep", 4),
        ("SvVoltage", 11),
        ("SynchronousMachine", 2),
        ("SynchronousMachineTimeConstantReactance", 2),
        ("TapChangerControl", 4),
        ("Terminal", 45),
        ("TopologicalNode", 12),
        ("VCompIEEEType1", 2),
        ("VoltageLevel", 6)
    )

    val NetherlandsElementCount = Array (
        ("ACLineSegment", 5),
        ("BaseVoltage", 5),
        ("Breaker", 1),
        ("BusbarSection", 4),
        ("ConnectivityNode", 6),
        ("CoordinateSystem", 1),
        ("CurrentLimit", 68),
        ("Diagram", 2),
        ("DiagramObject", 104),
        ("DiagramObjectPoint", 173),
        ("EnergyConsumer", 3),
        ("EquivalentInjection", 5),
        ("ExcIEEEAC1A", 1),
        ("ExcIEEEST1A", 2),
        ("GeneratingUnit", 3),
        ("GeographicalRegion", 2),
        ("GovHydro1", 2),
        ("GovHydro2", 1),
        ("Junction", 1),
        ("Line", 11),
        ("LinearShuntCompensator", 1),
        ("LoadAggregate", 3),
        ("LoadResponseCharacteristic", 1),
        ("LoadStatic", 3),
        ("Location", 6),
        ("OperationalLimitSet", 16),
        ("OperationalLimitType", 6),
        ("PositionPoint", 20),
        ("PowerTransformer", 3),
        ("PowerTransformerEnd", 6),
        ("Pss2B", 3),
        ("RatioTapChanger", 3),
        ("RegulatingControl", 7), // includes TapChangerControl (isA RegulatingControl)
        ("SubGeographicalRegion", 2),
        ("Substation", 1),
        ("SvPowerFlow", 12),
        ("SvShuntCompensatorSections", 1),
        ("SvTapStep", 3),
        ("SvVoltage", 10),
        ("SynchronousMachine", 3),
        ("SynchronousMachineTimeConstantReactance", 3),
        ("TapChangerControl", 3),
        ("Terminal", 35),
        ("TopologicalIsland", 1),
        ("TopologicalNode", 11),
        ("VCompIEEEType1", 3),
        ("VoltageLevel", 4)
    )

    val BaseCaseElementCount = Array (
        ("ACLineSegment", 12),
        ("BaseVoltage", 8),
        ("Breaker", 1),
        ("BusbarSection", 13),
        ("ConnectivityNode", 6),
        ("CoordinateSystem", 2),
        ("CurrentLimit", 168),
        ("CurveData", 3),
        ("Diagram", 4), // two in Belgium and two in Netherlands, how does 2 + 2 add up to 3 ?
        ("DiagramObject", 212), // ditto: 108 + 104 != 207
        ("DiagramObjectPoint", 356), // ditto: 183 + 173 != 346
        ("EnergyConsumer", 6),
        ("EquivalentInjection", 10),
        ("ExcIEEEAC1A", 1),
        ("ExcIEEEAC4A", 2),
        ("ExcIEEEST1A", 2),
        ("GeneratingUnit", 5),
        ("GeographicalRegion", 3),
        ("GovHydro1", 2),
        ("GovHydro2", 1),
        ("GovSteam0", 1),
        ("GovSteam1", 1),
        ("Junction", 1),
        ("Line", 18),
        ("LinearShuntCompensator", 3),
        ("LoadAggregate", 6),
        ("LoadResponseCharacteristic", 2),
        ("LoadStatic", 6),
        ("Location", 15),
        ("OperationalLimitSet", 39),
        ("OperationalLimitType", 14),
        ("PhaseTapChangerAsymmetrical", 1),
        ("PositionPoint", 49),
        ("PowerTransformer", 7),
        ("PowerTransformerEnd", 15),
        ("Pss2B", 5),
        ("RatioTapChanger", 6),
        ("ReactiveCapabilityCurve", 1),
        ("RegulatingControl", 15), // includes TapChangerControl (isA RegulatingControl)
        ("SubGeographicalRegion", 4),
        ("Substation", 3),
        ("SvPowerFlow", 24),
        ("SvShuntCompensatorSections", 3),
        ("SvTapStep", 7),
        ("SvVoltage", 21), // ditto: 11 + 10 != 16
        ("SynchronousMachine", 5),
        ("SynchronousMachineTimeConstantReactance", 5),
        ("TapChangerControl", 7),
        ("Terminal", 79),
        ("TopologicalIsland", 1),
        ("TopologicalNode", 17),
        ("VCompIEEEType1", 5),
        ("VoltageLevel", 10)
    )

    test ("Belgium")
    {
        implicit spark: SparkSession =>

        val filenames = Array (
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_BE_EQ_V2.xml",
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_BE_TP_V2.xml",
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_BE_DL_V2.xml",
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_BE_SSH_V2.xml",
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_BE_DY_V2.xml",
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_BE_GL_V2.xml",
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_BE_SV_V2.xml",
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_EQ_BD.xml",
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_TP_BD.xml"
        )
        val options = new util.HashMap[String, String] ().asInstanceOf[util.Map[String,String]]
        options.put ("ch.ninecode.cim.do_about", "true")
        val elements = readFile (filenames.mkString (","), options)

        assert (elements.count === 665)
        for (pair <- BelgiumElementCount)
            assert (spark.sparkContext.getPersistentRDDs.exists (_._2.name == pair._1), pair._1)
        for (pair <- BelgiumElementCount)
            assert (spark.sparkContext.getPersistentRDDs.filter (_._2.name == pair._1).head._2.count === pair._2, pair._1)

        // test rdf:about added TopologicalNode values and connected to each Terminal that has a sequenceNumber (Terminals from the boundary do not)
        val terminals = get[Terminal]
        val tnodes = terminals.flatMap (terminal => if (0 != terminal.ACDCTerminal.sequenceNumber) List (terminal) else List ()).collect
        tnodes.foreach (terminal =>
            {
                assert (null != terminal.TopologicalNode, terminal.id)
                assert (terminal.ACDCTerminal.connected, terminal.id)
            }
        )

        // test rdf:about added p and q to energy consumers
        val consumers = get[EnergyConsumer]
        val enodes = consumers.collect
        enodes.foreach (consumer =>
            {
                assert (0.0 != consumer.p, consumer.id)
                assert (0.0 != consumer.q || consumer.id == "_b1480a00-b427-4001-a26c-51954d2bb7e9", consumer.id) // handle the special snowflake
            }
        )

        // test rdf:about added p and q to equivalent injections
        val injections = get[EquivalentInjection]
        val inodes = injections.collect
        inodes.foreach (injection =>
            {
                assert (0.0 != injection.p, injection.id)
                assert (0.0 != injection.q, injection.id)
            }
        )
    }

    test ("Netherlands")
    {
        implicit spark: SparkSession =>

        val filenames = Array (
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_NL_EQ_V2.xml",
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_NL_TP_V2.xml",
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_NL_DL_V2.xml",
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_NL_SSH_V2.xml",
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_NL_DY_V2.xml",
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_NL_GL_V2.xml",
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_NL_SV_V2.xml",
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_EQ_BD.xml",
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_TP_BD.xml"
        )
        val options = new util.HashMap[String, String] ().asInstanceOf[util.Map[String,String]]
        options.put ("ch.ninecode.cim.do_about", "true")
        val elements = readFile (filenames.mkString (","), options)

        assert (elements.count === 567)
        for (pair <- NetherlandsElementCount)
            assert (spark.sparkContext.getPersistentRDDs.exists (_._2.name == pair._1), pair._1)
        for (pair <- NetherlandsElementCount)
            assert (spark.sparkContext.getPersistentRDDs.filter (_._2.name == pair._1).head._2.count === pair._2, pair._1)

        // test rdf:about added TopologicalNode values and connected to each Terminal that has a sequenceNumber (Terminals from the boundary do not)
        val terminals = get[Terminal]
        val tnodes = terminals.flatMap (terminal => if (0 != terminal.ACDCTerminal.sequenceNumber) List (terminal) else List ()).collect
        tnodes.foreach (terminal =>
            {
                assert (null != terminal.TopologicalNode, terminal.id)
                assert (terminal.ACDCTerminal.connected, terminal.id)
            }
        )

        // test rdf:about added p and q to energy consumers
        val consumers = get[EnergyConsumer]
        val enodes = consumers.collect
        enodes.foreach (consumer =>
            {
                assert (0.0 != consumer.p, consumer.id)
                assert (0.0 != consumer.q, consumer.id)
            }
        )

        // test rdf:about added p and q to equivalent injections
        val injections = get[EquivalentInjection]
        val inodes = injections.collect
        inodes.foreach (injection =>
            {
                assert (0.0 != injection.p, injection.id)
                assert (0.0 != injection.q, injection.id)
            }
        )
    }

    test ("Base Case")
    {
        implicit spark: SparkSession =>

        val filenames = Array (
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_BE_EQ_V2.xml",
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_BE_TP_V2.xml",
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_BE_DL_V2.xml",
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_BE_SSH_V2.xml",
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_BE_DY_V2.xml",
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_BE_GL_V2.xml",
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_BE_SV_V2.xml",
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_NL_EQ_V2.xml",
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_NL_TP_V2.xml",
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_NL_DL_V2.xml",
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_NL_SSH_V2.xml",
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_NL_DY_V2.xml",
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_NL_GL_V2.xml",
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_NL_SV_V2.xml",
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_EQ_BD.xml",
            s"${FILE_DEPOT}MicroGrid/BaseCase_BC/MicroGridTestConfiguration_TP_BD.xml"
        )
        val options = new util.HashMap[String, String] ().asInstanceOf[util.Map[String,String]]
        options.put ("ch.ninecode.cim.do_about", "true")
        val elements = readFile (filenames.mkString (","), options)

        assert (elements.count === 1206) // BaseCaseElementCount.map (_._2).sum is off by 6 = TapChangerControl (isA RegulatingControl)
        for (pair <- BaseCaseElementCount)
            assert (spark.sparkContext.getPersistentRDDs.exists (_._2.name == pair._1), pair._1)
        for (pair <- BaseCaseElementCount)
            assert (spark.sparkContext.getPersistentRDDs.filter(_._2.name == pair._1).head._2.count === pair._2, pair._1)

        // test rdf:about added TopologicalNode values and connected to each Terminal that has a sequenceNumber (Terminals from the boundary do not)
        val terminals = get[Terminal]
        val tnodes = terminals.flatMap (terminal => if (0 != terminal.ACDCTerminal.sequenceNumber) List (terminal) else List ()).collect
        tnodes.foreach (terminal =>
            {
                assert (null != terminal.TopologicalNode, terminal.id)
                assert (terminal.ACDCTerminal.connected, terminal.id)
            }
        )

        // test rdf:about added p and q to energy consumers
        val consumers = get[EnergyConsumer]
        val enodes = consumers.collect
        enodes.foreach (consumer =>
            {
                assert (0.0 != consumer.p, consumer.id)
                assert (0.0 != consumer.q || consumer.id == "_b1480a00-b427-4001-a26c-51954d2bb7e9", consumer.id) // handle the special snowflake
            }
        )

        // test rdf:about added p and q to equivalent injections
        val injections = get[EquivalentInjection]
        val inodes = injections.collect
        inodes.foreach (injection =>
            {
                assert (0.0 != injection.p, injection.id)
                assert (0.0 != injection.q, injection.id)
            }
        )
    }
}

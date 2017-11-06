package ch.ninecode.cim

import java.io.File
import java.util.HashMap
import java.util.Map

import ch.ninecode.model._
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import org.scalatest.BeforeAndAfter

class CIMNormalizeSuite extends ch.ninecode.SparkSuite with BeforeAndAfter
{
    val FILE_DEPOT = "data/"

    before
    {
        // unpack the zip file
        if (!new File (FILE_DEPOT + "MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_NL_DL_V2.xml").exists)
        {
            new Unzip ().unzip (FILE_DEPOT + "CGMES_v2.4.15_TestConfigurations_v4.0.3.zip", FILE_DEPOT)
            new Unzip ().unzip (FILE_DEPOT + "MicroGrid/BaseCase_BC/CGMES_v2.4.15_MicroGridTestConfiguration_BC_BE_v2.zip", FILE_DEPOT + "MicroGrid/BaseCase_BC/")
            new Unzip ().unzip (FILE_DEPOT + "MicroGrid/BaseCase_BC/CGMES_v2.4.15_MicroGridTestConfiguration_BC_NL_v2.zip", FILE_DEPOT + "MicroGrid/BaseCase_BC/")
            new Unzip ().unzip (FILE_DEPOT + "MicroGrid/BaseCase_BC/CGMES_v2.4.15_MicroGridTestConfiguration_BD_v2.zip", FILE_DEPOT + "MicroGrid/BaseCase_BC/")
            new Unzip ().unzip (FILE_DEPOT + "RealGrid/CGMES_v2.4.15_RealGridTestConfiguration_v2.zip", FILE_DEPOT + "RealGrid/")
        }
    }

    test ("Locations")
    {
        implicit spark: SparkSession ⇒

            val filenames = Array (
                FILE_DEPOT + "MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_BE_EQ_V2.xml",
                FILE_DEPOT + "MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_BE_TP_V2.xml",
                FILE_DEPOT + "MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_BE_DL_V2.xml",
                FILE_DEPOT + "MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_BE_SSH_V2.xml",
                FILE_DEPOT + "MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_BE_DY_V2.xml",
                FILE_DEPOT + "MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_BE_GL_V2.xml",
                FILE_DEPOT + "MicroGrid/BaseCase_BC/MicroGridTestConfiguration_BC_BE_SV_V2.xml",
                FILE_DEPOT + "MicroGrid/BaseCase_BC/MicroGridTestConfiguration_EQ_BD.xml",
                FILE_DEPOT + "MicroGrid/BaseCase_BC/MicroGridTestConfiguration_TP_BD.xml"
            )
            val options = new HashMap[String, String] ().asInstanceOf[Map[String,String]]
            options.put ("ch.ninecode.cim.do_about", "true")
            options.put ("ch.ninecode.cim.do_normalize", "true") // apply normalization
            val elements = readFile (filenames.mkString (","), options)

            assert (elements.count === 665)

            val locations = get[Location]
            val refs = locations.map (location ⇒ (location.id, location.PowerSystemResources)).collect
            refs.foreach (ref ⇒
                {
                    assert (ref._2 == null, ref._1)
                }
            )

            val cables = get[ACLineSegment]
            val wires = cables.map (cable ⇒ (cable.id, cable.Conductor.ConductingEquipment.Equipment.PowerSystemResource.Location)).collect
            wires.foreach (location ⇒
                {
                    assert (location._2 != null, location._1)
                }
            )

            val substations = get[Substation]
            val stations = substations.map (station ⇒ (station.id, station.EquipmentContainer.ConnectivityNodeContainer.PowerSystemResource.Location)).collect
            stations.foreach (location ⇒
                {
                    assert (location._2 != null, location._1)
                }
            )
    }

    test ("TopologicalNodes")
    {
        implicit spark: SparkSession ⇒

            val filenames = Array (
                FILE_DEPOT + "RealGrid/CGMES_v2.4.15_RealGridTestConfiguration_EQ_v2.xml",
                FILE_DEPOT + "RealGrid/CGMES_v2.4.15_RealGridTestConfiguration_SSH_v2.xml",
                FILE_DEPOT + "RealGrid/CGMES_v2.4.15_RealGridTestConfiguration_SV_v2.xml",
                FILE_DEPOT + "RealGrid/CGMES_v2.4.15_RealGridTestConfiguration_TP_v2.xml"
            )
            val options = new HashMap[String, String] ().asInstanceOf[Map[String,String]]
            options.put ("ch.ninecode.cim.do_about", "true")
            options.put ("ch.ninecode.cim.do_normalize", "true") // apply normalization
            val elements = readFile (filenames.mkString (","), options)

            // grep "rdf:ID" *.xml | wc
            assert (elements.count === 152388)

            val nodes = get[TopologicalNode]
            val refs = nodes.map (node ⇒ (node.id, node.TopologicalIsland)).collect
            refs.foreach (ref ⇒
                {
                    assert (ref._2 != null, ref._1)
                }
            )
    }
}
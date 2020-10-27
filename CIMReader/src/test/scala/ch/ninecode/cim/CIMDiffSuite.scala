package ch.ninecode.cim

import java.io.File
import java.io.PrintWriter

import org.apache.spark.sql.SparkSession

import ch.ninecode.model.ACLineSegment
import ch.ninecode.model.EnergyConsumer
import ch.ninecode.model.EquivalentNetwork
import ch.ninecode.model.Fuse

case class CIMDiffSuite () extends ch.ninecode.SparkSuite
{
    val FILE_DEPOT = "data/"
    val CIMFILE = "DemoData"

    lazy val difftext =
        """<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<rdf:RDF xmlns:cim="http://iec.ch/TC57/2016/CIM-schema-cim17#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
	<cim:ChangeSet rdf:ID="_9e1273bf-c01b-431e-8cb6-6d871f1c0ad4">
		<cim:DataSet.mRID>_9e1273bf-c01b-431e-8cb6-6d871f1c0ad4</cim:DataSet.mRID>
		<cim:DataSet.name>test</cim:DataSet.name>
		<cim:DataSet.description>new difference model</cim:DataSet.description>
	</cim:ChangeSet>
	<cim:ObjectDeletion rdf:ID="_ae664bcd-8c01-4cc6-a7f0-687bd7b6d9ab">
		<cim:ChangeSetMember.Changeset rdf:resource="#_9e1273bf-c01b-431e-8cb6-6d871f1c0ad4"/>
		<cim:ChangeSetMember.TargetObject rdf:resource="#FUS0053"/>
	</cim:ObjectDeletion>
	<cim:ObjectDeletion rdf:ID="_cd31e89c-b0a6-4e60-847d-7cea3bc2844e">
		<cim:ChangeSetMember.Changeset rdf:resource="#_9e1273bf-c01b-431e-8cb6-6d871f1c0ad4"/>
		<cim:ChangeSetMember.TargetObject rdf:resource="#FUS0053_location"/>
	</cim:ObjectDeletion>
	<cim:ObjectDeletion rdf:ID="_6036c360-2e6e-40c7-936e-c770755251c2">
		<cim:ChangeSetMember.Changeset rdf:resource="#_9e1273bf-c01b-431e-8cb6-6d871f1c0ad4"/>
		<cim:ChangeSetMember.TargetObject rdf:resource="#FUS0053_node_2"/>
	</cim:ObjectDeletion>
	<cim:ObjectDeletion rdf:ID="_89c9068d-d5b4-4cb2-aafa-9d0e77e08289">
		<cim:ChangeSetMember.Changeset rdf:resource="#_9e1273bf-c01b-431e-8cb6-6d871f1c0ad4"/>
		<cim:ChangeSetMember.TargetObject rdf:resource="#FUS0053_terminal_1"/>
	</cim:ObjectDeletion>
	<cim:ObjectDeletion rdf:ID="_7045db48-3bf3-4635-a95a-76d169ce2783">
		<cim:ChangeSetMember.Changeset rdf:resource="#_9e1273bf-c01b-431e-8cb6-6d871f1c0ad4"/>
		<cim:ChangeSetMember.TargetObject rdf:resource="#FUS0053_terminal_2"/>
	</cim:ObjectDeletion>
	<cim:ObjectReverseModification rdf:ID="_7a5d9a93-26ea-4994-b44c-00c9299c37ab">
		<cim:ChangeSetMember.Changeset rdf:resource="#_9e1273bf-c01b-431e-8cb6-6d871f1c0ad4"/>
		<cim:ChangeSetMember.PropertiesObject rdf:resource="#_2f9046b8-e013-40a1-a9d8-175ecb6c238b"/>
		<cim:ChangeSetMember.TargetObject rdf:resource="#USR0019"/>
		<cim:ObjectReverseModification.ObjectModification rdf:resource="#_1e383324-3117-443c-8f40-40a51abe74ff"/>
	</cim:ObjectReverseModification>
	<cim:EnergyConsumer rdf:ID="_2f9046b8-e013-40a1-a9d8-175ecb6c238b">
	</cim:EnergyConsumer>
	<cim:ObjectModification rdf:ID="_1e383324-3117-443c-8f40-40a51abe74ff">
		<cim:ChangeSetMember.Changeset rdf:resource="#_9e1273bf-c01b-431e-8cb6-6d871f1c0ad4"/>
		<cim:ChangeSetMember.PropertiesObject rdf:resource="#_774e2e45-cf12-40fe-a642-e5b1d81c524a"/>
		<cim:ChangeSetMember.TargetObject rdf:resource="#USR0019"/>
		<cim:ObjectModification.ObjectReverseModification rdf:resource="#_7a5d9a93-26ea-4994-b44c-00c9299c37ab"/>
	</cim:ObjectModification>
	<cim:EnergyConsumer rdf:ID="_774e2e45-cf12-40fe-a642-e5b1d81c524a">
		<cim:EnergyConsumer.p>14000</cim:EnergyConsumer.p>
		<cim:EnergyConsumer.q>1200</cim:EnergyConsumer.q>
	</cim:EnergyConsumer>
	<cim:ObjectCreation rdf:ID="_cafce75c-8dd2-4cd7-997d-3da33e95a3cc">
		<cim:ChangeSetMember.Changeset rdf:resource="#_9e1273bf-c01b-431e-8cb6-6d871f1c0ad4"/>
		<cim:ChangeSetMember.PropertiesObject rdf:resource="#Network1"/>
	</cim:ObjectCreation>
	<cim:EquivalentNetwork rdf:ID="Network1">
		<cim:IdentifiedObject.name>a network</cim:IdentifiedObject.name>
		<cim:PowerSystemResource.PSRType rdf:resource="#PSRType_HouseService"/>
		<cim:PowerSystemResource.Location rdf:resource="#USR0019_location"/>
	</cim:EquivalentNetwork>
</rdf:RDF>
"""

    override def run (testName: Option[String], args: org.scalatest.Args): org.scalatest.Status =
    {
        // unpack the zip file
        new Unzip().unzip(s"$FILE_DEPOT$CIMFILE.zip", FILE_DEPOT)
        // make a diff file
        val diff = s"$FILE_DEPOT${CIMFILE}_diff.rdf"
        using(new PrintWriter(new File(diff), "UTF-8"))
        {
            writer => writer.write(difftext)
        }

        // run the tests
        val ret = super.run(testName, args)

        // erase the unpacked file and diff file
        deleteRecursive(new File(s"$FILE_DEPOT$CIMFILE.rdf"))
        deleteRecursive(new File(diff))

        ret
    }

    test("apply changeset")
    {
        implicit spark: SparkSession =>

            val filename = s"${FILE_DEPOT}DemoData.rdf,$FILE_DEPOT${CIMFILE}_diff.rdf"
            val elements = readFile(filename, Map[String, String](
                "ch.ninecode.cim.apply_changesets" -> "true"
            ))
            val count = elements.count
            val demo = 1742 // the _diff file has 12 which are added then removed
            val deletions = 5
            val additions = 1
            assert(demo - deletions + additions == count, "# elements after applying ChangeSet")

            val fuses = get[Fuse]
            assert(fuses.filter(_.id == "FUS0053").count() == 0, "FUS0053 is deleted")
            val networks = get[EquivalentNetwork]
            assert(networks.count == 1, "one network added")
            assert(networks.filter(_.id == "Network1").count() == 1, "Network1 is added")
            val consumers = get[EnergyConsumer]
            val user19 = consumers.filter(_.id == "USR0019").collect
            assert(user19.length == 1, "USR0019 is still present")
            assert(user19(0).p == 14000.0, "USR0019 p")
            assert(user19(0).q == 1200.0, "USR0019 q")
    }

    test("two RDD sets")
    {
        implicit spark: SparkSession =>

            val TEMPLATE1 = "%s_1"
            val TEMPLATE2 = "%s_2"

            val filename = s"${FILE_DEPOT}DemoData.rdf"
            val elements1 = readFile(filename, Map("ch.ninecode.cim.name_template" -> TEMPLATE1)).count
            val elements2 = readFile(filename, Map("ch.ninecode.cim.name_template" -> TEMPLATE2)).count
            assert(elements1 == elements2, "same contents")

            //            val names = spark
            //                .sparkContext
            //                .getPersistentRDDs
            //                .map (_._2.name)
            //                .take (2000)
            //                .toArray
            //                .sorted
            //            println (names.mkString ("\n"))

            val lines1 = get[ACLineSegment](TEMPLATE1.format("ACLineSegment"))
            val lines2 = get[ACLineSegment](TEMPLATE2.format("ACLineSegment"))
            assert(lines1.count == lines2.count, "same line count")
            val pairs1 = lines1.keyBy(_.id).leftOuterJoin(lines2.keyBy(_.id)).values
            assert(pairs1.flatMap({ case (_, Some(_)) => None case x => Some(x) }).isEmpty, "all right in left")
            val pairs2 = lines2.keyBy(_.id).leftOuterJoin(lines1.keyBy(_.id)).values
            assert(pairs2.flatMap({ case (_, Some(_)) => None case x => Some(x) }).isEmpty, "all left in right")

            // delete one of them
            lines2.name = null
            lines2.unpersist(true)

            assert(get[ACLineSegment](TEMPLATE2.format("ACLineSegment")) == null, "deleted")
            assert(get[ACLineSegment](TEMPLATE1.format("ACLineSegment")) != null, "not deleted")
    }

    test("append changeset")
    {
        implicit spark: SparkSession =>

            val elements1 = readFile(s"${FILE_DEPOT}DemoData.rdf")
            val count1 = elements1.count
            assert(count1 == 1742, "# elements before applying ChangeSet")
            val elements2 = readFile(s"$FILE_DEPOT${CIMFILE}_diff.rdf", Map[String, String](
                "ch.ninecode.cim.append" -> "true",
                "ch.ninecode.cim.apply_changesets" -> "true"
            ))
            val count2 = elements2.count
            val demo = 1742 // the _diff file has 12 which are added then removed
            val deletions = 5
            val additions = 1
            assert(demo - deletions + additions == count2, "# elements after applying ChangeSet")

            val fuses = get[Fuse]
            assert(fuses.filter(_.id == "FUS0053").count() == 0, "FUS0053 is deleted")
            val networks = get[EquivalentNetwork]
            assert(networks.count == 1, "one network added")
            assert(networks.filter(_.id == "Network1").count() == 1, "Network1 is added")
            val consumers = get[EnergyConsumer]
            val user19 = consumers.filter(_.id == "USR0019").collect
            assert(user19.length == 1, "USR0019 is still present")
            assert(user19(0).p == 14000.0, "USR0019 p")
            assert(user19(0).q == 1200.0, "USR0019 q")
    }
}

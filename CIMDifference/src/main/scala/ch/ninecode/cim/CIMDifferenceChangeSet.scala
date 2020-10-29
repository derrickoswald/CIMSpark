package ch.ninecode.cim

import java.util.UUID

import org.apache.spark.rdd.RDD

import ch.ninecode.model.BasicElement
import ch.ninecode.model.ChangeSet
import ch.ninecode.model.DataSet
import ch.ninecode.model.Element

case class CIMDifferenceChangeSet (options: CIMDifferenceOptions) extends CIMDifferenceProcessor
{
    def uuid: String = s"_${UUID.randomUUID().toString}"

    //    <cim:ChangeSet rdf:ID="_9e1273bf-c01b-431e-8cb6-6d871f1c0ad4">
    //        <cim:DataSet.mRID>_9e1273bf-c01b-431e-8cb6-6d871f1c0ad4</cim:DataSet.mRID>
    //        <cim:DataSet.name>test</cim:DataSet.name>
    //        <cim:DataSet.description>new difference model</cim:DataSet.description>
    //    </cim:ChangeSet>"""
    lazy val changeset: ChangeSet =
    {
        val mrid = uuid
        val description = if ("" != options.description) options.description else null
        val name = if ("" != options.name) options.name else null
        ChangeSet(DataSet(BasicElement(null, mrid), description, mrid, name))
    }

    /**
     * CIM file header.
     */
    lazy val header =
        """<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<rdf:RDF xmlns:cim="http://iec.ch/TC57/2016/CIM-schema-cim17#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
"""

    /**
     * CIM file tail.
     */
    lazy val tailer = """</rdf:RDF>"""

    def delete (id: String): Option[String] =
    {
        Some(
            s"""	<cim:ObjectDeletion rdf:ID="$uuid">
		<cim:ChangeSetMember.Changeset rdf:resource="#${changeset.id}"/>
		<cim:ChangeSetMember.TargetObject rdf:resource="#$id"/>
	</cim:ObjectDeletion>"""
        )
    }

    def add (id: String, newby: Element): Option[String] =
    {
        val obj = newby.export
        Some(
            s"""	<cim:ObjectCreation rdf:ID="$uuid">
		<cim:ChangeSetMember.Changeset rdf:resource="#${changeset.id}"/>
		<cim:ChangeSetMember.PropertiesObject rdf:resource="#$id"/>
	</cim:ObjectCreation>
$obj"""
        )
    }

    def diff (cls: String, id: String, left: String, right: String): Option[String] =
    {
        if (left == right)
            None
        else
        {
            val lefts = left.split("\n")
            val rights = right.split("\n")
            val l = for (left <- lefts; if !rights.contains(left))
                yield left
            val r = for (right <- rights; if !lefts.contains(right))
                yield right

            val rev = uuid
            val fwd = uuid
            val revobj = uuid
            val fwdobj = uuid
            Some(
                s"""	<cim:ObjectReverseModification rdf:ID="$rev">
		<cim:ChangeSetMember.Changeset rdf:resource="#${changeset.id}"/>
		<cim:ChangeSetMember.PropertiesObject rdf:resource="#$revobj"/>
		<cim:ChangeSetMember.TargetObject rdf:resource="#$id"/>
		<cim:ObjectReverseModification.ObjectModification rdf:resource="#$fwd"/>
	</cim:ObjectReverseModification>
	<cim:$cls rdf:ID="$revobj">${l.mkString("\n", "\n", "")}
	</cim:$cls>
	<cim:ObjectModification rdf:ID="$fwd">
		<cim:ChangeSetMember.Changeset rdf:resource="#${changeset.id}"/>
		<cim:ChangeSetMember.PropertiesObject rdf:resource="#$fwdobj"/>
		<cim:ChangeSetMember.TargetObject rdf:resource="#$id"/>
		<cim:ObjectModification.ObjectReverseModification rdf:resource="#$rev"/>
	</cim:ObjectModification>
	<cim:$cls rdf:ID="$fwdobj">${r.mkString("\n", "\n", "")}
	</cim:$cls>"""
            )
        }
    }

    def diff (id: String, left: Element, right: Element): Option[String] =
    {
        val cls = left.baseclass
        val ls = left.export
        val rs = right.export
        diff(cls, id, ls, rs)
    }

    def process (elements: (String, (Option[Element], Option[Element]))): Option[String] =
    {
        val (id, (left, right)) = elements
        left match
        {
            case Some(l) =>
                right match
                {
                    case Some(r) =>
                        diff(id, l, r)
                    case None =>
                        delete(id)
                }
            case None =>
                right match
                {
                    case Some(r) =>
                        add(id, r)
                    case None =>
                        None
                }
        }
    }

    def execute (join: RDD[(String, (Option[Element], Option[Element]))]): Unit =
    {
        val diff = join.flatMap(process)
        save(diff, options.output, s"$header${changeset.export}\n".getBytes("UTF-8"), tailer.getBytes("UTF-8"))
    }
}

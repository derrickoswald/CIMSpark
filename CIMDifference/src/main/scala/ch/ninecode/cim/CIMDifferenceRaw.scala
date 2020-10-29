package ch.ninecode.cim

import org.apache.spark.rdd.RDD

import ch.ninecode.model.Element

case class CIMDifferenceRaw (options: CIMDifferenceOptions) extends CIMDifferenceProcessor
{
    def delete (prefix: String, doomed: Element, suffix: String): Option[String] =
    {
        val strings = doomed.export.split("\n")
        Some(strings.mkString(prefix, "\n", suffix))
    }

    def add (prefix: String, newby: Element, suffix: String): Option[String] =
    {
        val strings = newby.export.split("\n")
        Some(strings.mkString(prefix, "\n", suffix))
    }

    def diff (prefix: String, left: Element, right: Element, suffix: String): Option[String] =
    {
        val ls = left.export
        val rs = right.export
        if (ls == rs)
            None
        else
        {
            val lefts = ls.split("\n")
            val rights = rs.split("\n")
            val l = for (left <- lefts; if !rights.contains(left))
                yield left
            val r = for (right <- rights; if !lefts.contains(right))
                yield right
            Some(Array.concat(l.map(x => s"-$x"), r.map(x => s"+$x")).mkString(prefix, "\n", suffix))
        }
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
                        diff(s"modify ${l.baseclass} $id:\n", l, r, "")
                    case None =>
                        delete(s"delete ${l.baseclass} $id:\n", l, "")
                }
            case None =>
                right match
                {
                    case Some(r) =>
                        add(s"add ${r.baseclass} $id:\n", r, "")
                    case None =>
                        None
                }
        }
    }

    def execute (join: RDD[(String, (Option[Element], Option[Element]))]): Unit =
    {
        val diff = join.flatMap(process)
        save(diff, options.output)
    }
}
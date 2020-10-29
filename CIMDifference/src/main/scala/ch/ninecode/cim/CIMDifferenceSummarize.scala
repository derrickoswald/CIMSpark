package ch.ninecode.cim

import org.apache.spark.rdd.RDD

import ch.ninecode.model.Element

case class CIMDifferenceSummarize (options: CIMDifferenceOptions) extends CIMDifferenceProcessor
{
    def seqOp (summary: CIMDifferenceSummary, elements: (String, (Option[Element], Option[Element]))): CIMDifferenceSummary =
    {
        val (_, (left, right)) = elements
        left match
        {
            case Some(l) =>
                right match
                {
                    case Some(r) =>
                        val ls = l.export
                        val rs = r.export
                        if (ls != rs)
                            summary.modifications += 1
                    case None =>
                        summary.deletions += 1
                }
            case None =>
                right match
                {
                    case Some(_) =>
                        summary.additions += 1
                    case None =>
                }
        }
        summary
    }

    def combOp (left: CIMDifferenceSummary, right: CIMDifferenceSummary): CIMDifferenceSummary = left + right

    def execute (join: RDD[(String, (Option[Element], Option[Element]))]): Unit =
    {
        val summary = join.aggregate(CIMDifferenceSummary())(seqOp, combOp)
        println(s"${summary.deletions} deletions, ${summary.additions} additions, and ${summary.modifications} modifications")
    }
}

package ch.ninecode.cim

case class CIMDifferenceSummary (
    var deletions: Int = 0,
    var additions: Int = 0,
    var modifications: Int = 0
)
{
    def + (other: CIMDifferenceSummary): CIMDifferenceSummary =
        CIMDifferenceSummary(deletions = deletions + other.deletions, additions = additions + other.additions, modifications = modifications + other.modifications)
}
package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.Context

/*
 * Package: Topology
 */

case class BusNameMarker
(
    override val sup: IdentifiedObject,
    val priority: Int,
    val ReportingGroup: String
)
extends
    Element
{
    def this () = { this (null, 0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[BusNameMarker]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BusNameMarker
extends
    Parseable[BusNameMarker]
{
    val priority = parse_element (element ("""BusNameMarker.priority"""))_
    val ReportingGroup = parse_attribute (attribute ("""BusNameMarker.ReportingGroup"""))_
    def parse (context: Context): BusNameMarker =
    {
        return (
            BusNameMarker
            (
                IdentifiedObject.parse (context),
                toInteger (priority (context), context),
                ReportingGroup (context)
            )
        )
    }
}

case class DCTopologicalNode
(
    override val sup: IdentifiedObject,
    val DCEquipmentContainer: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[DCTopologicalNode]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DCTopologicalNode
extends
    Parseable[DCTopologicalNode]
{
    val DCEquipmentContainer = parse_attribute (attribute ("""DCTopologicalNode.DCEquipmentContainer"""))_
    def parse (context: Context): DCTopologicalNode =
    {
        return (
            DCTopologicalNode
            (
                IdentifiedObject.parse (context),
                DCEquipmentContainer (context)
            )
        )
    }
}

case class TopologicalIsland
(
    override val sup: IdentifiedObject,
    val AngleRefTopologicalNode: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TopologicalIsland]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TopologicalIsland
extends
    Parseable[TopologicalIsland]
{
    val AngleRefTopologicalNode = parse_attribute (attribute ("""TopologicalIsland.AngleRefTopologicalNode"""))_
    def parse (context: Context): TopologicalIsland =
    {
        return (
            TopologicalIsland
            (
                IdentifiedObject.parse (context),
                AngleRefTopologicalNode (context)
            )
        )
    }
}

case class TopologicalNode
(
    override val sup: IdentifiedObject,
    val pInjection: Double,
    val qInjection: Double,
    val AngleRefTopologicalIsland: String,
    val BaseVoltage: String,
    val ConnectivityNodeContainer: String,
    val ReportingGroup: String,
    val SvInjection: String,
    val SvVoltage: String,
    val TopologicalIsland: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, null, null, null, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TopologicalNode]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TopologicalNode
extends
    Parseable[TopologicalNode]
{
    val pInjection = parse_element (element ("""TopologicalNode.pInjection"""))_
    val qInjection = parse_element (element ("""TopologicalNode.qInjection"""))_
    val AngleRefTopologicalIsland = parse_attribute (attribute ("""TopologicalNode.AngleRefTopologicalIsland"""))_
    val BaseVoltage = parse_attribute (attribute ("""TopologicalNode.BaseVoltage"""))_
    val ConnectivityNodeContainer = parse_attribute (attribute ("""TopologicalNode.ConnectivityNodeContainer"""))_
    val ReportingGroup = parse_attribute (attribute ("""TopologicalNode.ReportingGroup"""))_
    val SvInjection = parse_attribute (attribute ("""TopologicalNode.SvInjection"""))_
    val SvVoltage = parse_attribute (attribute ("""TopologicalNode.SvVoltage"""))_
    val TopologicalIsland = parse_attribute (attribute ("""TopologicalNode.TopologicalIsland"""))_
    def parse (context: Context): TopologicalNode =
    {
        return (
            TopologicalNode
            (
                IdentifiedObject.parse (context),
                toDouble (pInjection (context), context),
                toDouble (qInjection (context), context),
                AngleRefTopologicalIsland (context),
                BaseVoltage (context),
                ConnectivityNodeContainer (context),
                ReportingGroup (context),
                SvInjection (context),
                SvVoltage (context),
                TopologicalIsland (context)
            )
        )
    }
}

object Topology
{
    def register: Unit =
    {
        BusNameMarker.register
        DCTopologicalNode.register
        TopologicalIsland.register
        TopologicalNode.register
    }
}

package ch.ninecode.cim

import org.apache.spark.rdd.RDD
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.SQLUserDefinedType
import org.apache.spark.storage.StorageLevel
import org.slf4j.LoggerFactory

import ch.ninecode.model._

case class PreEdge (id_seq_1: String, cn_1: String, id_seq_2: String, cn_2: String, id_equ: String, clazz: String, name: String, aliasName: String, var container: String, length: Double, voltage: String, normalOpen: Boolean, ratedCurrent: Double, location: String, power: Double, commissioned: String, status: String) extends Serializable
class Extremum (val id_loc: String, var min_index: Int, var x1 : String, var y1 : String, var max_index: Int, var x2 : String, var y2 : String) extends Serializable
case class PostEdge (id_seq_1: String, id_seq_2: String, id_equ: String, clazz: String, name: String, aliasName: String, container: String, length: Double, voltage: String, normalOpen: Boolean, ratedCurrent: Double, power: Double, commissioned: String, status: String, x1: String, y1: String, x2: String, y2: String) extends Serializable
case class TopoEdge (id_seq_1: String, id_island_1: String, id_seq_2: String, id_island_2: String, id_equ: String, clazz: String, name: String, aliasName: String, container: String, length: Double, voltage: String, normalOpen: Boolean, ratedCurrent: Double, power: Double, commissioned: String, status: String, x1: String, y1: String, x2: String, y2: String) extends Serializable

class CIMEdges (session: SparkSession, storage: StorageLevel) extends Serializable
{
    private val log = LoggerFactory.getLogger(getClass)
    
    def get (name: String): RDD[Element] =
    {
        val rdds = session.sparkContext.getPersistentRDDs
        for (key <- rdds.keys)
        {
            val rdd = rdds (key)
            if (rdd.name == name)
                return (rdd.asInstanceOf[RDD[Element]])
        }
        return (null)
    }

    def get_extremum () =
    {
        val points = get ("PositionPoint").asInstanceOf[RDD[PositionPoint]]
        val point_seq_op = (x: Extremum, p: PositionPoint) ⇒
        {
            if (null == x)
                new Extremum (p.Location, p.sequenceNumber, p.xPosition, p.yPosition, p.sequenceNumber, p.xPosition, p.yPosition)
            else
            {
                if (p.sequenceNumber < x.min_index)
                {
                    x.min_index = p.sequenceNumber
                    x.x1 = p.xPosition
                    x.y1 = p.yPosition
                }
                else if (p.sequenceNumber > x.max_index)
                {
                    x.max_index = p.sequenceNumber
                    x.x2 = p.xPosition
                    x.y2 = p.yPosition
                }
                x
            }
        }
        val point_comb_op = (l: Extremum, r: Extremum) ⇒
        {
            if (r.min_index < l.min_index)
            {
                l.min_index = r.min_index
                l.x1 = r.x1
                l.y1 = r.y1
            }
            if (r.max_index > l.max_index)
            {
                l.max_index = r.max_index
                l.x2 = r.x2
                l.y2 = r.y2
            }
            l
        }
        points.keyBy (_.Location).aggregateByKey (null: Extremum) (point_seq_op, point_comb_op).values
    }

    def term_op (topological_nodes: Boolean) (arg: Tuple2[Element, Option[Iterable[Terminal]]]): List[PreEdge] =
    {
        arg match
        {
            case (e: Element, Some (it: Iterable[Terminal])) ⇒
            {
                var ret = List[PreEdge] ()

                // sort terminals by sequence number
                var terminals = it.toArray.sortWith (_.ACDCTerminal.sequenceNumber < _.ACDCTerminal.sequenceNumber)

                // extract pertinent information from the equipment
                case class Bucket (
                    var clazz: String = "",
                    var name: String = "",
                    var aliasName: String = "",
                    var container: String = "",
                    var length: Double = 0.0,
                    var voltage: String = "",
                    var normalOpen: Boolean = false,
                    var ratedCurrent: Double = 0.0,
                    var location: String = "",
                    var power: Double = 0.0,
                    var commissioned: String = "",
                    var status: String = "")

                val bucket = Bucket ()
                bucket.clazz = e.getClass ().getName ()
                bucket.clazz = bucket.clazz.substring (bucket.clazz.lastIndexOf (".") + 1)
                def do_identified (identified: IdentifiedObject)
                {
                    bucket.name = identified.name
                    bucket.aliasName = identified.aliasName
                }
                def do_resource (resource: PowerSystemResource)
                {
                    bucket.location = resource.Location
                    do_identified (resource.IdentifiedObject)
                }
                def do_equipment (equipment: Equipment)
                {
                    bucket.container = equipment.EquipmentContainer
                    do_resource (equipment.PowerSystemResource)
                }
                def do_conducting (conducting: ConductingEquipment)
                {
                    bucket.voltage = conducting.BaseVoltage
                    bucket.status = conducting.SvStatus
                    do_equipment (conducting.Equipment)
                }
                def do_switch (switch: Switch)
                {
                    bucket.normalOpen = switch.normalOpen
                    bucket.ratedCurrent = switch.ratedCurrent
                    do_conducting (switch.ConductingEquipment)
                }
                def do_conductor (conductor: Conductor)
                {
                    bucket.length = conductor.len
                    do_conducting (conductor.ConductingEquipment)
                }
                Some(e) match
                {
                    case Some(o) if o.getClass () == classOf[ConnectivityNode] => { }

                    case Some(o) if o.getClass () == classOf[ACLineSegment] =>
                        {
                            do_conductor (o.asInstanceOf[ACLineSegment].Conductor)
                        }
                    case Some(o) if o.getClass () == classOf[AsynchronousMachine] =>
                        {
                            do_conducting (o.asInstanceOf[AsynchronousMachine].RotatingMachine.RegulatingCondEq.ConductingEquipment)
                        }
                    case Some(o) if o.getClass () == classOf[Breaker] =>
                        {
                            do_switch (o.asInstanceOf[Breaker].ProtectedSwitch.Switch)
                        }
                    case Some(o) if o.getClass () == classOf[BusbarSection] =>
                        {
                            do_conducting (o.asInstanceOf[BusbarSection].Connector.ConductingEquipment)
                        }
                    case Some(o) if o.getClass () == classOf[Clamp] =>
                        {
                            do_conducting (o.asInstanceOf[Clamp].ConductingEquipment);
                        }
                    case Some(o) if o.getClass () == classOf[CompositeSwitch] =>
                        {
                            do_equipment (o.asInstanceOf[CompositeSwitch].Equipment)
                        }
                    case Some(o) if o.getClass () == classOf[Conductor] =>
                        {
                            do_conductor (o.asInstanceOf[Conductor])
                        }
                    case Some(o) if o.getClass () == classOf[Connector] =>
                        {
                            do_conducting (o.asInstanceOf[Connector].ConductingEquipment)
                        }
                    case Some(o) if o.getClass () == classOf[Cut] =>
                        {
                            do_switch (o.asInstanceOf[Cut].Switch)
                        }
                    case Some(o) if o.getClass () == classOf[Disconnector] =>
                        {
                            do_switch (o.asInstanceOf[Disconnector].Switch)
                        }
                    case Some(o) if o.getClass () == classOf[EarthFaultCompensator] =>
                        {
                            do_conducting (o.asInstanceOf[EarthFaultCompensator].ConductingEquipment);
                        }
                    case Some(o) if o.getClass () == classOf[EnergyConsumer] =>
                        {
                            do_conducting (o.asInstanceOf[EnergyConsumer].ConductingEquipment)
                        }
                    case Some(o) if o.getClass () == classOf[EnergySource] =>
                        {
                            do_conducting (o.asInstanceOf[EnergySource].ConductingEquipment)
                        }
                    case Some(o) if o.getClass () == classOf[ExternalNetworkInjection] =>
                        {
                            do_conducting (o.asInstanceOf[ExternalNetworkInjection].RegulatingCondEq.ConductingEquipment)
                        }
                    case Some(o) if o.getClass () == classOf[FrequencyConverter] =>
                        {
                            do_conducting (o.asInstanceOf[FrequencyConverter].RegulatingCondEq.ConductingEquipment)
                        }
                    case Some(o) if o.getClass () == classOf[Fuse] =>
                        {
                            do_switch (o.asInstanceOf[Fuse].Switch)
                        }
                    case Some(o) if o.getClass () == classOf[Ground] =>
                        {
                            do_conducting (o.asInstanceOf[Ground].ConductingEquipment)
                        }
                    case Some(o) if o.getClass () == classOf[GroundDisconnector] =>
                        {
                            do_switch (o.asInstanceOf[GroundDisconnector].Switch)
                        }
                    // GroundingImpedance
                    case Some(o) if o.getClass () == classOf[Jumper] =>
                        {
                            do_switch (o.asInstanceOf[Jumper].Switch)
                        }
                    case Some(o) if o.getClass () == classOf[Junction] => { }
                        {
                            do_conducting (o.asInstanceOf[Junction].Connector.ConductingEquipment)
                        }
                    // LinearShuntCompensator
                    // LoadBreakSwitch
                    // NonlinearShuntCompensator
                    // PetersenCoil
                    case Some(o) if o.getClass () == classOf[PowerTransformer] =>
                        {
                            do_conducting (o.asInstanceOf[PowerTransformer].ConductingEquipment)
                        }
                    case Some(o) if o.getClass () == classOf[ProtectedSwitch] =>
                        {
                            do_switch (o.asInstanceOf[ProtectedSwitch].Switch)
                        }
                    // Recloser
                    case Some(o) if o.getClass () == classOf[RegulatingCondEq] =>
                        {
                            do_conducting (o.asInstanceOf[RegulatingCondEq].ConductingEquipment)
                        }
                    case Some(o) if o.getClass () == classOf[RotatingMachine] =>
                        {
                            do_conducting (o.asInstanceOf[RotatingMachine].RegulatingCondEq.ConductingEquipment)
                        }
                    // Sectionalizer
                    // SeriesCompensator
                    // ShuntCompensator
                    // StaticVarCompensator
                    case Some(o) if o.getClass () == classOf[Switch] =>
                        {
                            do_switch (o.asInstanceOf[Switch])
                        }
                    // SynchronousMachine
                    case Some(o) if o.getClass () == classOf[TransformerEnd] =>
                        {
                            val te = o.asInstanceOf[TransformerEnd]
                            bucket.voltage = te.BaseVoltage
                            do_identified (te.IdentifiedObject)
                        }

                    // ToDo: this is not correct, ProtectionEquipment should have no Terminal elements pointing to it
                    // the others are also not ConductingEquipment
                    case Some(o) if o.getClass () == classOf[ProtectionEquipment] =>
                        {
                            do_equipment (o.asInstanceOf[ProtectionEquipment].Equipment)
                        }
                    case Some(o) if o.getClass () == classOf[CurrentRelay] =>
                        {
                            do_equipment (o.asInstanceOf[CurrentRelay].ProtectionEquipment.Equipment)
                        }
                    case Some(o) if o.getClass () == classOf[SolarGeneratingUnit] =>
                        {
                            val sgu = o.asInstanceOf[SolarGeneratingUnit]
                            bucket.power = sgu.GeneratingUnit.ratedNetMaxP
                            bucket.commissioned = sgu.commissioningDate
                            do_equipment (sgu.GeneratingUnit.Equipment)
                        }
                    case Some(o) if o.getClass () == classOf[UsagePoint] =>
                        {
                            val up = o.asInstanceOf[UsagePoint]
                            bucket.voltage = up.nominalServiceVoltage.toString ()
                            bucket.location = up.UsagePointLocation
                        }
                }

                // make a pre-edge for each pair of terminals
                ret = terminals.length match
                {
                    case 1 =>
                        List (
                            new PreEdge (
                                terminals(0).ACDCTerminal.IdentifiedObject.mRID,
                                if (topological_nodes) terminals(0).TopologicalNode else terminals(0).ConnectivityNode,
                                "",
                                "",
                                terminals(0).ConductingEquipment,
                                bucket.clazz,
                                bucket.name,
                                bucket.aliasName,
                                bucket.container,
                                bucket.length,
                                bucket.voltage,
                                bucket.normalOpen,
                                bucket.ratedCurrent,
                                bucket.location,
                                bucket.power,
                                bucket.commissioned,
                                bucket.status))
                    case 2 =>
                        List (
                            new PreEdge (
                                terminals(0).ACDCTerminal.IdentifiedObject.mRID,
                                if (topological_nodes) terminals(0).TopologicalNode else terminals(0).ConnectivityNode,
                                terminals(1).ACDCTerminal.IdentifiedObject.mRID,
                                if (topological_nodes) terminals(1).TopologicalNode else terminals(1).ConnectivityNode,
                                terminals(0).ConductingEquipment,
                                bucket.clazz,
                                bucket.name,
                                bucket.aliasName,
                                bucket.container,
                                bucket.length,
                                bucket.voltage,
                                bucket.normalOpen,
                                bucket.ratedCurrent,
                                bucket.location,
                                bucket.power,
                                bucket.commissioned,
                                bucket.status))
                    case _ =>
                        {
                            // three (or more terminal device - which we assume is a transformer
                            // sequence number 1 at index 0 is the high side of a transformer
                            // make edges to each of the secondaries
                            log.warn ("equipment with " + terminals.length + " terminals: " + terminals(0).ConductingEquipment)
                            var i = 0
                            var list = List[PreEdge] ()
                            while (i < terminals.length - 1)
                            {
                                list = list :+ new PreEdge (
                                        terminals(0).ACDCTerminal.IdentifiedObject.mRID,
                                        if (topological_nodes) terminals(0).TopologicalNode else terminals(0).ConnectivityNode,
                                        terminals(i + 1).ACDCTerminal.IdentifiedObject.mRID,
                                        if (topological_nodes) terminals(i + 1).TopologicalNode else terminals(i + 1).ConnectivityNode,
                                        terminals(0).ConductingEquipment,
                                        bucket.clazz,
                                        bucket.name,
                                        bucket.aliasName,
                                        bucket.container,
                                        bucket.length,
                                        bucket.voltage,
                                        bucket.normalOpen,
                                        bucket.ratedCurrent,
                                        bucket.location,
                                        bucket.power,
                                        bucket.commissioned,
                                        bucket.status)
                                i += 1
                            }
                            list
                        }
                }
                ret
            }
            case (e: Element, None) ⇒
            {
                List[PreEdge] ()
            }
        }
    }

    def edge_op (arg: Tuple2[PreEdge, Option[Extremum]]) =
    {
        val e = arg._1
        val x = arg._2
        x match
        {
            case Some (x:Extremum) =>
                PostEdge (e.cn_1, e.cn_2, e.id_equ, e.clazz, e.name, e.aliasName, e.container, e.length, e.voltage, e.normalOpen, e.ratedCurrent, e.power, e.commissioned, e.status, x.x1, x.y1, x.x2, x.y2)
            case None =>
                // shouldn't happen of course: if it does we have an equipment with a location reference to non-existant location
                PostEdge (e.cn_1, e.cn_2, e.id_equ, e.clazz, e.name, e.aliasName, e.container, e.length, e.voltage, e.normalOpen, e.ratedCurrent, e.power, e.commissioned, e.status, "0.0", "0.0", "0.0", "0.0")
        }
    }

    def topo_edge_op (arg: Tuple4[PreEdge, Option[Extremum], Option[TopologicalNode], Option[TopologicalNode]]) =
    {
        val e = arg._1
        val x = arg._2
        val i1 = arg._3 match { case Some (t) => t.TopologicalIsland case _ => "" }
        val i2 = arg._4 match { case Some (t) => t.TopologicalIsland case _ => "" }
        x match
        {
            case Some (x:Extremum) =>
                TopoEdge (e.cn_1, i1, e.cn_2, i2, e.id_equ, e.clazz, e.name, e.aliasName, e.container, e.length, e.voltage, e.normalOpen, e.ratedCurrent, e.power, e.commissioned, e.status, x.x1, x.y1, x.x2, x.y2)
            case None =>
                // shouldn't happen of course: if it does we have an equipment with a location reference to non-existant location
                TopoEdge (e.cn_1, i1, e.cn_2, i2, e.id_equ, e.clazz, e.name, e.aliasName, e.container, e.length, e.voltage, e.normalOpen, e.ratedCurrent, e.power, e.commissioned, e.status, "0.0", "0.0", "0.0", "0.0")
        }
    }

    def container (arg: Tuple2[PreEdge, Option[Element]]): PreEdge =
    {
        val edge = arg._1
        val node = arg._2
        node match
        {
            case Some (station: Substation) => edge.container = station.id
            case Some (bay: Bay) => edge.container = bay.Substation
            case Some (level: VoltageLevel) => edge.container = level.Substation
            case _ => // keep the same container
        }
        edge
    }

    def make_edges (topological_nodes: Boolean): Unit =
    {
        // get the elements RDD
        val elements = get ("Elements").asInstanceOf[RDD[Element]]

        // get the terminals
        val terminals = get ("Terminal").asInstanceOf[RDD[Terminal]]

        // first get the terminals keyed by equipment
        val terms = terminals.groupBy (_.ConductingEquipment)

        // next, map the terminal pairs to pre-edges, keep only edges with differing nodes on each end
        val preedges = elements.keyBy (_.id).leftOuterJoin (terms).flatMapValues (term_op (topological_nodes)).values.filter (x => x.cn_1 != x.cn_2)

        // use the top level container where possible
        val preedges2 = preedges.keyBy (_.container).leftOuterJoin (elements.keyBy (_.id)).values.map (container)

        // get start and end coordinates of each location
        val extremum = get_extremum ()

        // join coordinates with edges using location
        val located_edges = preedges2.keyBy (_.location).leftOuterJoin (extremum.keyBy (_.id_loc)).values

        // join with topological nodes if requested
        if (topological_nodes)
        {
            val topologicals = get ("TopologicalNode").asInstanceOf[RDD[TopologicalNode]].keyBy (_.id)
            val topo1 = located_edges.keyBy (_._1.cn_1).leftOuterJoin (topologicals).values.map ((x) => (x._1._1, x._1._2, x._2))
            val topo2 =         topo1.keyBy (_._1.cn_2).leftOuterJoin (topologicals).values.map ((x) => (x._1._1, x._1._2, x._1._3, x._2))
            val edges = topo2.map (topo_edge_op)

            // persist it
            edges.setName ("Edges")
            edges.persist (storage)

            // expose it
            session.createDataFrame (edges).createOrReplaceTempView ("edges")
        }
        else
        {
            val edges = located_edges.map ((x) => (x._1, x._2)).map (edge_op)

            // persist it
            edges.setName ("Edges")
            edges.persist (storage)

            // expose it
            session.createDataFrame (edges).createOrReplaceTempView ("edges")
        }
    }
}

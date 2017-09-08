package ch.ninecode.cim

import java.net.URI
import java.time.LocalDateTime

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.fs.FileUtil
import org.apache.hadoop.fs.Path
import org.apache.spark.rdd.RDD
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions
import org.apache.spark.sql.SparkSession
import org.slf4j.{Logger, LoggerFactory}
import ch.ninecode.model._

/**
 * Export a (subset) of CIM data.
 *
 * @example
 * {{{
 * // enter Spark shell environment
 * spark-shell --master spark://sandbox:7077 --executor-memory 4g --driver-memory 1g --conf spark.sql.warehouse.dir=file:/tmp/spark-warehouse --jars /opt/code/CIMReader-2.11-2.2.0-2.2.0.jar
 *
 * // read the large CIM file
 * import scala.collection.mutable.HashMap
 * import org.apache.spark.rdd.RDD
 * import ch.ninecode.cim._
 * import ch.ninecode.model._
 * val opts = new HashMap[String,String] ()
 * opts.put("StorageLevel", "MEMORY_AND_DISK_SER")
 * val element = spark.read.format ("ch.ninecode.cim").options (opts).load ("hdfs://sandbox:8020/data/bkw_cim_export_equipmentsstripe2.rdf")
 * element.count
 *
 * // process topology with islands
 * val ntp = new CIMNetworkTopologyProcessor (spark, org.apache.spark.storage.StorageLevel.MEMORY_AND_DISK_SER)
 * val elements2 = ntp.process (true)
 * elements2.count
 *
 * // get the name of the transformer's low voltage pin TopologicalNode
 * val terminals = sc.getPersistentRDDs.filter(_._2.name == "Terminal").head._2.asInstanceOf[RDD[Terminal]]
 * val NSpin = terminals.filter (x => x.ConductingEquipment == "TRA7872" && x.ACDCTerminal.sequenceNumber == 2)
 * println (NSpin.first.TopologicalNode)
 * MUI452395_topo
 *
 * // get the name of the trafokreis TopologicalIsland
 * val nodes = sc.getPersistentRDDs.filter(_._2.name == "TopologicalNode").head._2.asInstanceOf[RDD[TopologicalNode]]
 * val NSnode = nodes.filter (_.id == "MUI452395_topo")
 * println (NSnode.first.TopologicalIsland)
 * TRA7872_terminal_2_topo
 *
 * // export the reduced CIM file
 * val export = new CIMExport (spark)
 * export.exportIsland ("TRA7872_terminal_2_topo", "TRA7872.rdf")
 * }}}
 *
 */
class CIMExport (spark: SparkSession) extends CIMRDD with Serializable
{
    implicit val session: SparkSession = spark
    implicit val log: Logger = LoggerFactory.getLogger (getClass)
    val configuration: Configuration = spark.sparkContext.hadoopConfiguration
    val hdfs: FileSystem = FileSystem.get (configuration)

    def merge (source: String, destination: String): Unit =
    {
        FileUtil.copyMerge (hdfs, new Path (source), hdfs, new Path (destination), false, configuration, null)
    }

    /**
     * Export elements.
     *
     * @param elements The elements to export.
     * @param filename The name of the file to write.
     * @param about The about string for the CIM file header.
     */
    def export (elements: RDD[Element], filename: String, about: String = "", temp: String = "/tmp/export.rdf"):Unit =
    {
        val ldt = LocalDateTime.now.toString

        val header =
"""<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<rdf:RDF xmlns:cim="http://iec.ch/TC57/2013/CIM-schema-cim16#" xmlns:md="http://iec.ch/TC57/61970-552/ModelDescription/1#" xmlns:dm="http://iec.ch/2002/schema/CIM_difference_model#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
	<md:FullModel rdf:about="""" + about + """">
		<md:Model.created>""" + ldt + """</md:Model.created>
		<md:Model.description>CIMExport</md:Model.description>
		<md:Model.modelingAuthoritySet>http://9code.ch/</md:Model.modelingAuthoritySet>
		<md:Model.profile>https://github.com/derrickoswald/CIMReader</md:Model.profile>
	</md:FullModel>"""
        val tailer = """</rdf:RDF>"""
        val hdfs = FileSystem.get (URI.create (configuration.get ("fs.defaultFS")), configuration)
        val directory: Path = new Path (hdfs.getWorkingDirectory, temp)
        hdfs.delete (directory, true)
        val file = new Path (filename)
        hdfs.delete (file, false)
        val txt = directory.toUri.toString
        val head = spark.sparkContext.makeRDD (List[String] (header))
        val tail = spark.sparkContext.makeRDD (List[String] (tailer))
        val guts = elements.map (_.export)
        val ss = head.union (guts).union (tail)
        ss.saveAsTextFile (txt)
        merge (txt, file.toUri.toString)
    }

    /**
     * Export elements associated to the given topological island.
     * @param island The name of the topological island to export.
     * @param filename The name of the file to write.
     */
    def exportIsland (island: String, filename: String): Unit =
    {
        val islands = get[TopologicalIsland].filter (_.id == island)
        if (islands.isEmpty())
            log.error (island + " not found")
        else
        {
            // get the topological elements
            val topos = get[TopologicalNode].filter (_.TopologicalIsland == island)
            val some_nodes = get[ConnectivityNode].keyBy (_.TopologicalNode).join (topos.keyBy (_.id)).map (_._2._1)
            val some_terminals = get[Terminal].keyBy (_.ConnectivityNode).join (some_nodes.keyBy (_.id)).map (_._2._1)
            val equipment = get[ConductingEquipment].keyBy (_.id).join (some_terminals.keyBy (_.ConductingEquipment)).map (_._2._1).distinct
            val terminals = get[Terminal].keyBy (_.ConductingEquipment).join (equipment.keyBy (_.id)).map (_._2._1)
            val nodes = get[ConnectivityNode].keyBy (_.id).join (terminals.keyBy (_.ConnectivityNode)).map (_._2._1).distinct
            val ends = get[PowerTransformerEnd].keyBy (_.PowerTransformer).join (equipment.keyBy (_.id)).map (_._2._1)
            val status = get[SvStatus].keyBy (_.id).join (equipment.keyBy (_.SvStatus)).map (_._2._1).distinct

            // get other elements related to the equipment
            val voltages = get[BaseVoltage].keyBy (_.id).join (equipment.keyBy (_.BaseVoltage)).map (_._2._1)
                .union (get[BaseVoltage].keyBy (_.id).join (ends.keyBy (_.TransformerEnd.BaseVoltage)).map (_._2._1)).distinct
            val containers = get[EquipmentContainer].keyBy (_.id).join (equipment.keyBy (_.Equipment.EquipmentContainer)).map (_._2._1).distinct
            val infos = get[AssetInfo].keyBy (_.id).join (equipment.keyBy (_.Equipment.PowerSystemResource.AssetDatasheet)).map (_._2._1).distinct
            val locations = get[Location].keyBy (_.id).join (equipment.keyBy (_.Equipment.PowerSystemResource.Location)).map (_._2._1).distinct
            val coordinates = get[CoordinateSystem].keyBy (_.id).join (locations.keyBy (_.CoordinateSystem)).map (_._2._1).distinct
            val points = get[PositionPoint].keyBy (_.Location).join (locations.keyBy (_.id)).map (_._2._1)
            val psrtypes = get[PSRType].keyBy (_.id).join (equipment.keyBy (_.Equipment.PowerSystemResource.PSRType)).map (_._2._1).distinct
            val streets = get[StreetAddress].keyBy (_.id).join (locations.keyBy (_.mainAddress)).map (_._2._1).distinct
            val towns = get[TownDetail].keyBy (_.id).join (streets.keyBy (_.townDetail)).map (_._2._1).distinct
            val attributes = get[UserAttribute].keyBy (_.name).join (equipment.keyBy (_.id)).map (_._2._1)
            val strings = get[StringQuantity].keyBy (_.id).join (attributes.keyBy (_.value)).map (_._2._1)

            // get implementation specific related elements

            // ServiceLocations
            val mst_has_s = get[StringQuantity].keyBy (_.value).join (equipment.keyBy (_.id)).map (_._2._1)
            val mst_has = get[UserAttribute].keyBy (_.value).join (mst_has_s.keyBy (_.id)).map (_._2._1)
            val mst = get[ServiceLocation].keyBy (_.id).join (mst_has.keyBy (_.name)).map (_._2._1)
            val mst_nam = get[Name].keyBy (_.IdentifiedObject).join (mst.keyBy (_.id)).map (_._2._1)
            val name_type = get[NameType].keyBy (_.id).join (mst_nam.keyBy (_.NameType)).map (_._2._1).distinct
            val name_auth = get[NameTypeAuthority].keyBy (_.id).join (name_type.keyBy (_.NameTypeAuthority)).map (_._2._1).distinct
            val mst_addr = get[StreetAddress].keyBy (_.id).join (mst.keyBy (_.WorkLocation.Location.secondaryAddress)).map (_._2._1)
            val mst_town = get[TownDetail].keyBy (_.id).join (mst_addr.keyBy (_.townDetail)).map (_._2._1)
            val mst_street = get[StreetDetail].keyBy (_.id).join (mst_addr.keyBy (_.streetDetail)).map (_._2._1)
            val mst_status = get[Status].keyBy (_.id).join (mst_addr.keyBy (_.status)).map (_._2._1)
            val mst_point = get[PositionPoint].keyBy (_.Location).join (mst.keyBy (_.id)).map (_._2._1)

            // SolarGeneratingUnit
            val eea_s = get[StringQuantity].keyBy (_.value).join (mst.keyBy (_.id)).map (_._2._1)
            val eea_a = get[UserAttribute].keyBy (_.value).join (eea_s.keyBy (_.id)).map (_._2._1)
            val eea = get[SolarGeneratingUnit].keyBy (_.id).join (eea_a.keyBy (_.name)).map (_._2._1)
            val eea_n = get[Name].keyBy (_.IdentifiedObject).join (eea.keyBy (_.id)).map (_._2._1)
            val eea_l = get[Location].keyBy (_.id).join (eea.keyBy (_.GeneratingUnit.Equipment.PowerSystemResource.Location)).map (_._2._1)
            val eea_p = get[PositionPoint].keyBy (_.Location).join (eea_l.keyBy (_.id)).map (_._2._1)

            // get assets
            val eq = equipment.map (_.Equipment).union (eea.map (_.GeneratingUnit.Equipment))
            val assets = if (null != get[Asset])
                get[Asset].flatMap (x => x.PowerSystemResources.map (y => (y, x))).join (eq.keyBy (_.PowerSystemResource.id)).map (_._2._1)
            else
                spark.sparkContext.emptyRDD[Asset]
            val lifecycles = if (null != get[LifecycleDate])
                get[LifecycleDate].keyBy (_.id).join (assets.keyBy (_.lifecycle)).map (_._2._1)
            else
                spark.sparkContext.emptyRDD[LifecycleDate]
            val ownership: RDD[Ownership] = if (null != get[Ownership])
                get[Ownership].keyBy (_.Asset).join (assets.keyBy (_.id)).map (_._2._1)
            else
                spark.sparkContext.emptyRDD[Ownership]
            val owners = if (null != get[AssetOwner])
                get[AssetOwner].keyBy (_.id).join (ownership.keyBy (_.AssetOwner)).map (_._2._1).distinct
            else
                spark.sparkContext.emptyRDD[AssetOwner]

            // create an RDD of mRID
            val ids =
                islands.map (x => (x.id, x.id))
                .union (topos.map (x => (x.id, x.id)))
                .union (nodes.map (x => (x.id, x.id)))
                .union (equipment.map (x => (x.id, x.id)))
                .union (terminals.map (x => (x.id, x.id)))
                .union (ends.map (x => (x.id, x.id)))
                .union (status.map (x => (x.id, x.id)))
                .union (voltages.map (x => (x.id, x.id)))
                .union (containers.map (x => (x.id, x.id)))
                .union (infos.map (x => (x.id, x.id)))
                .union (locations.map (x => (x.id, x.id)))
                .union (coordinates.map (x => (x.id, x.id)))
                .union (points.map (x => (x.id, x.id)))
                .union (psrtypes.map (x => (x.id, x.id)))
                .union (streets.map (x => (x.id, x.id)))
                .union (towns.map (x => (x.id, x.id)))
                .union (attributes.map (x => (x.id, x.id)))
                .union (strings.map (x => (x.id, x.id)))
                .union (mst_has_s.map (x => (x.id, x.id)))
                .union (mst_has.map (x => (x.id, x.id)))
                .union (mst.map (x => (x.id, x.id)))
                .union (mst_nam.map (x => (x.id, x.id)))
                .union (name_type.map (x => (x.id, x.id)))
                .union (name_auth.map (x => (x.id, x.id)))
                .union (mst_addr.map (x => (x.id, x.id)))
                .union (mst_town.map (x => (x.id, x.id)))
                .union (mst_street.map (x => (x.id, x.id)))
                .union (mst_status.map (x => (x.id, x.id)))
                .union (mst_point.map (x => (x.id, x.id)))
                .union (eea_s.map (x => (x.id, x.id)))
                .union (eea_a.map (x => (x.id, x.id)))
                .union (eea.map (x => (x.id, x.id)))
                .union (eea_n.map (x => (x.id, x.id)))
                .union (eea_l.map (x => (x.id, x.id)))
                .union (eea_p.map (x => (x.id, x.id)))
                .union (assets.map (x => (x.id, x.id)))
                .union (lifecycles.map (x => (x.id, x.id)))
                .union (ownership.map (x => (x.id, x.id)))
                .union (owners.map (x => (x.id, x.id)))

            // get the elements
            val elements = get[Element]("Elements").keyBy (_.id).join (ids).map (_._2._1)
            export (elements, filename, island)
        }
    }

    /**
      * Export all CIM elements.
      *
      * Useful after doing some processing, such as stripe de-duplicating or topological processing,
      * to avoid having to redo that processing again.
      *
      * @param filename The name of the file to write.
      * @param about The about string for the CIM file header.
      */
    def exportAll (filename: String, about: String = ""):Unit =
    {
        val elements = get[Element]("Elements")
        export (elements, filename, about)
    }
}
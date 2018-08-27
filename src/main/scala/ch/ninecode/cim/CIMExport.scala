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
 * Export (a subset of) CIM data.
 *
 * @example Export entire deduplicated CIM file with it's topology
 * {{{
 * // enter Spark shell environment
 * spark-shell --master spark://sandbox:7077 --executor-memory 4g --driver-memory 1g --conf spark.sql.warehouse.dir=file:/tmp/spark-warehouse --jars /opt/code/CIMReader-2.11-2.2.0-2.2.1.jar
 *
 * // read the large CIM file
 * import scala.collection.mutable.HashMap
 * import org.apache.spark.rdd.RDD
 * import ch.ninecode.cim._
 * import ch.ninecode.model._
 * val opts = new HashMap[String,String] ()
 * opts.put("StorageLevel", "MEMORY_AND_DISK_SER")
 * opts.put("ch.ninecode.cim.do_deduplication", "true")
 * val element = spark.read.format ("ch.ninecode.cim").options (opts).load ("hdfs://sandbox:8020/data/bkw_cim_export_equipmentsstripe1.rdf,hdfs://sandbox:8020/data/bkw_cim_export_equipmentsstripe2.rdf, etc.")
 * element.count
 *
 * // process topology (your choice of with or without islands)
 * val ntp = new CIMNetworkTopologyProcessor (spark, org.apache.spark.storage.StorageLevel.MEMORY_AND_DISK_SER)
 * val elements2 = ntp.process (true)
 * elements2.count
 *
 * // export the complete CIM file
 * val export = new CIMExport (spark)
 * export.exportAll ("bkw_cim_export_equipment.rdf")
 * }}}
 *
 * @example Export one transformer area (trafokreis)
 * {{{
 * // enter Spark shell environment
 * spark-shell --master spark://sandbox:7077 --executor-memory 4g --driver-memory 1g --conf spark.sql.warehouse.dir=file:/tmp/spark-warehouse --jars /opt/code/CIMReader-2.11-2.2.0-2.2.1.jar
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
 * MUI452395_island
 *
 * // get the name of the trafokreis TopologicalIsland
 * val nodes = sc.getPersistentRDDs.filter(_._2.name == "TopologicalNode").head._2.asInstanceOf[RDD[TopologicalNode]]
 * val NSnode = nodes.filter (_.id == "MUI452395_island")
 * println (NSnode.first.TopologicalIsland)
 * TRA7872_terminal_2_island
 *
 * // export the reduced CIM file
 * val export = new CIMExport (spark)
 * export.exportIsland ("TRA7872_terminal_2_island", "TRA7872.rdf")
 * }}}
 *
 */
class CIMExport (spark: SparkSession) extends CIMRDD with Serializable
{
    implicit val session: SparkSession = spark
    implicit val log: Logger = LoggerFactory.getLogger (getClass)

    def merge (source: String, destination: String): Unit =
    {
        val configuration: Configuration = spark.sparkContext.hadoopConfiguration
        val hdfs: FileSystem = FileSystem.get (configuration)
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

        // setup
        val configuration: Configuration = spark.sparkContext.hadoopConfiguration
        val hdfs = FileSystem.get (URI.create (configuration.get ("fs.defaultFS")), configuration)
        val directory: Path = new Path (hdfs.getWorkingDirectory, temp)
        hdfs.delete (directory, true)
        val file = new Path (filename)
        hdfs.delete (file, false)
        // write the file
        val txt = directory.toUri.toString
        val head = spark.sparkContext.makeRDD (List[String] (header))
        val tail = spark.sparkContext.makeRDD (List[String] (tailer))
        val guts = elements.map (_.export)
        val ss = head.union (guts).union (tail)
        ss.saveAsTextFile (txt)
        merge (txt, file.toUri.toString)
        // clean up temporary directory
        hdfs.delete (directory, true)
        // delete the stupid .crc file
        val index = filename.lastIndexOf ("/")
        val crc = if (-1 != index) filename.substring (0, index + 1) + "." + filename.substring (index + 1) + ".crc" else "." + filename + ".crc"
        hdfs.delete (new Path (crc), false)
    }

    /**
     * Export elements associated to the given topological island.
     * @param island The name of the topological island to export.
     * @param filename The name of the file to write.
     */
    def exportIsland (island: String, filename: String): Unit =
    {
        val allislands = getOrElse[TopologicalIsland]
        val someislands = allislands.filter (_.id == island)
        if (someislands.isEmpty())
            log.error (island + " not found")
        else
        {
            // get the topological elements
            val some_topos = getOrElse[TopologicalNode].filter (_.TopologicalIsland == island)
            val some_nodes = if (null != getOrElse[ConnectivityNode]) getOrElse[ConnectivityNode].keyBy (_.TopologicalNode).join (some_topos.keyBy (_.id)).map (_._2._1) else spark.sparkContext.emptyRDD[ConnectivityNode]
            val some_terminals = getOrElse[Terminal].keyBy (_.TopologicalNode).join (some_topos.keyBy (_.id)).map (_._2._1)
            val equipment = getOrElse[ConductingEquipment].keyBy (_.id).join (some_terminals.keyBy (_.ConductingEquipment)).map (_._2._1).distinct
            val terminals = getOrElse[Terminal].keyBy (_.ConductingEquipment).join (equipment.keyBy (_.id)).map (_._2._1)
            val (nodes, topos) = if (null != getOrElse[ConnectivityNode])
            {
                val n = getOrElse[ConnectivityNode].keyBy (_.id).join (terminals.keyBy (_.ConnectivityNode)).map (_._2._1).distinct
                val t = getOrElse[TopologicalNode].keyBy (_.id).join (n.keyBy (_.TopologicalNode)).map (_._2._1).distinct
                (n, t)
            }
            else
                (some_nodes, some_topos)
            val islands = getOrElse[TopologicalIsland].keyBy (_.id).join (topos.keyBy (_.TopologicalIsland)).map (_._2._1).distinct
            val ends = getOrElse[PowerTransformerEnd].keyBy (_.PowerTransformer).join (equipment.keyBy (_.id)).map (_._2._1)
            val status = if (null != getOrElse[SvStatus]) getOrElse[SvStatus].keyBy (_.id).join (equipment.keyBy (_.SvStatus)).map (_._2._1).distinct else spark.sparkContext.emptyRDD[SvStatus]

            // get other elements related to the equipment
            val voltages = getOrElse[BaseVoltage].keyBy (_.id).join (equipment.keyBy (_.BaseVoltage)).map (_._2._1)
                .union (getOrElse[BaseVoltage].keyBy (_.id).join (ends.keyBy (_.TransformerEnd.BaseVoltage)).map (_._2._1)).distinct
            val containers = getOrElse[EquipmentContainer].keyBy (_.id).join (equipment.keyBy (_.Equipment.EquipmentContainer)).map (_._2._1).distinct
            val infos = if (null != getOrElse[AssetInfo]) getOrElse[AssetInfo].keyBy (_.id).join (equipment.keyBy (_.Equipment.PowerSystemResource.AssetDatasheet)).map (_._2._1).distinct else spark.sparkContext.emptyRDD[AssetInfo]
            val locations = if (null != getOrElse[Location]) getOrElse[Location].keyBy (_.id).join (equipment.keyBy (_.Equipment.PowerSystemResource.Location)).map (_._2._1)
                .union ( getOrElse[Location].keyBy (_.id).join (containers.keyBy (_.ConnectivityNodeContainer.PowerSystemResource.Location)).map (_._2._1)).distinct else spark.sparkContext.emptyRDD[Location]
            val coordinates = if (null != getOrElse[CoordinateSystem]) getOrElse[CoordinateSystem].keyBy (_.id).join (locations.keyBy (_.CoordinateSystem)).map (_._2._1).distinct else spark.sparkContext.emptyRDD[CoordinateSystem]
            val points = if (null != getOrElse[PositionPoint]) getOrElse[PositionPoint].keyBy (_.Location).join (locations.keyBy (_.id)).map (_._2._1) else spark.sparkContext.emptyRDD[PositionPoint]
            val psrtypes = if (null != getOrElse[PSRType]) getOrElse[PSRType].keyBy (_.id).join (equipment.keyBy (_.Equipment.PowerSystemResource.PSRType)).map (_._2._1)
                .union (getOrElse[PSRType].keyBy (_.id).join (containers.keyBy (_.ConnectivityNodeContainer.PowerSystemResource.PSRType)).map (_._2._1)).distinct else spark.sparkContext.emptyRDD[PSRType]
            val streets = if (null != getOrElse[StreetAddress]) getOrElse[StreetAddress].keyBy (_.id).join (locations.keyBy (_.mainAddress)).map (_._2._1).distinct else spark.sparkContext.emptyRDD[StreetAddress]
            val towns = if (null != getOrElse[TownDetail]) getOrElse[TownDetail].keyBy (_.id).join (streets.keyBy (_.townDetail)).map (_._2._1).distinct else spark.sparkContext.emptyRDD[TownDetail]
            val attributes = if (null != getOrElse[UserAttribute]) getOrElse[UserAttribute].keyBy (_.name).join (equipment.keyBy (_.id)).map (_._2._1) else spark.sparkContext.emptyRDD[UserAttribute]
            val strings = if (null != getOrElse[StringQuantity]) getOrElse[StringQuantity].keyBy (_.id).join (attributes.keyBy (_.value)).map (_._2._1) else spark.sparkContext.emptyRDD[StringQuantity]

            // get implementation specific related elements

            // ServiceLocations
            val specific = if (null != getOrElse[UserAttribute])
            {
                val mst_has_s = getOrElse[StringQuantity].keyBy (_.value).join (equipment.keyBy (_.id)).map (_._2._1)
                val mst_has = getOrElse[UserAttribute].keyBy (_.value).join (mst_has_s.keyBy (_.id)).map (_._2._1)
                val mst = getOrElse[ServiceLocation].keyBy (_.id).join (mst_has.keyBy (_.name)).map (_._2._1)
                val mst_nam = getOrElse[Name].keyBy (_.IdentifiedObject).join (mst.keyBy (_.id)).map (_._2._1)
                val name_type = getOrElse[NameType].keyBy (_.id).join (mst_nam.keyBy (_.NameType)).map (_._2._1).distinct
                val name_auth = getOrElse[NameTypeAuthority].keyBy (_.id).join (name_type.keyBy (_.NameTypeAuthority)).map (_._2._1).distinct
                val mst_addr = getOrElse[StreetAddress].keyBy (_.id).join (mst.keyBy (_.WorkLocation.Location.secondaryAddress)).map (_._2._1)
                val mst_town = getOrElse[TownDetail].keyBy (_.id).join (mst_addr.keyBy (_.townDetail)).map (_._2._1)
                val mst_point = getOrElse[PositionPoint].keyBy (_.Location).join (mst.keyBy (_.id)).map (_._2._1)
                val mst_street = if (null != getOrElse[StreetDetail])
                    getOrElse[StreetDetail].keyBy (_.id).join (mst_addr.keyBy (_.streetDetail)).map (_._2._1)
                else
                    spark.sparkContext.emptyRDD[StreetDetail]
                val mst_status = if (null != getOrElse[Status])
                    getOrElse[Status].keyBy (_.id).join (mst_addr.keyBy (_.status)).map (_._2._1)
                else
                    spark.sparkContext.emptyRDD[Status]

                // SolarGeneratingUnit
                val eea_s = getOrElse[StringQuantity].keyBy (_.value).join (mst.keyBy (_.id)).map (_._2._1)
                val eea_a = getOrElse[UserAttribute].keyBy (_.value).join (eea_s.keyBy (_.id)).map (_._2._1)
                val eea = getOrElse[SolarGeneratingUnit].keyBy (_.id).join (eea_a.keyBy (_.name)).map (_._2._1)
                val eea_n = getOrElse[Name].keyBy (_.IdentifiedObject).join (eea.keyBy (_.id)).map (_._2._1)
                val eea_l = getOrElse[Location].keyBy (_.id).join (eea.keyBy (_.GeneratingUnit.Equipment.PowerSystemResource.Location)).map (_._2._1)
                val eea_p = getOrElse[PositionPoint].keyBy (_.Location).join (eea_l.keyBy (_.id)).map (_._2._1)

                // get assets
                val eq: RDD[Equipment] = equipment.map (_.Equipment).union (eea.map (_.GeneratingUnit.Equipment))
                val assets = if (null != getOrElse[Asset])
                    getOrElse[Asset].flatMap ((asset: Asset) ⇒ { val psr = asset.PowerSystemResources; if (null == psr) List() else psr.map (y => (y, asset))}).join (eq.keyBy (_.PowerSystemResource.id)).map (_._2._1)
                else
                    spark.sparkContext.emptyRDD[Asset]
                val lifecycles = if (null != getOrElse[LifecycleDate])
                    getOrElse[LifecycleDate].keyBy (_.id).join (assets.keyBy (_.lifecycle)).map (_._2._1)
                else
                    spark.sparkContext.emptyRDD[LifecycleDate]
                val ownership: RDD[Ownership] = if (null != getOrElse[Ownership])
                    getOrElse[Ownership].keyBy (_.Asset).join (assets.keyBy (_.id)).map (_._2._1)
                else
                    spark.sparkContext.emptyRDD[Ownership]
                val owners = if (null != getOrElse[AssetOwner])
                    getOrElse[AssetOwner].keyBy (_.id).join (ownership.keyBy (_.AssetOwner)).map (_._2._1).distinct
                else
                    spark.sparkContext.emptyRDD[AssetOwner]

                mst_has_s.map (x => (x.id, x.id))
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
            }
            else
                spark.sparkContext.emptyRDD[(String, String)]

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
                .union (specific)

            // get the elements
            val elements = getOrElse[Element]("Elements").keyBy (_.id).join (ids).map (_._2._1)
            export (elements, filename, island, "/tmp/" + island + ".rdf")
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
        val elements = getOrElse[Element]("Elements")
        export (elements, filename, about)
    }

    /**
     * Export every topological island.
     * @param directory The name of the directory to write the CIM files.
     * @return the number of islands processed
     */
    def exportAllIslands (directory: String = "simulation/"): Int =
    {
        val dir = if (directory.endsWith ("/")) directory else directory + "/"
        val allislands = getOrElse[TopologicalIsland].map (_.id).collect
        val islands = allislands.map (island ⇒ { exportIsland (island, dir + island + ".rdf"); 1})
        islands.sum
    }
}

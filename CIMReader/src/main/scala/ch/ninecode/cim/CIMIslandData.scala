package ch.ninecode.cim

import org.apache.spark.graphx.VertexId

/**
 * Vertex data for island topological processing.
 *
 * @param node the minimum (hash code) of equivalent ConnectivityNode (a single topological node)
 * @param island_label a user friendly label for the island
 * @param island the minimum (hash code) of all connected ConnectivityNode (single topological island)
 */
case class CIMIslandData (
    node: VertexId,
    island_label: String,
    island: VertexId = Long.MaxValue) extends Serializable



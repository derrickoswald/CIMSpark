package ch.ninecode.cim

import org.apache.spark.graphx.VertexId

/**
 * Vertex data for topological processing.
 *
 * @param island       the minimum (hash code) of all connected ConnectivityNode (single topological island)
 * @param island_label a user friendly label for the island
 * @param node         the minimum (hash code) of equivalent ConnectivityNode (a single topological node)
 * @param node_label   a user friendly label for the node
 * @param voltage      the nominal voltage of the node
 * @param container    the node container
 */
case class CIMVertexData (
    island: VertexId = Long.MaxValue,
    island_label: String = "",
    node: VertexId = Long.MaxValue,
    node_label: String = "",
    voltage: String = null,
    container: String = null)
{
    /**
     * Generate an appropriate name for the topological node based on the node label.
     *
     * @return The best guess as to what the topological node should be called.
     */
    def name: String =
    {
        if (node_label.endsWith("_node_fuse"))
            s"${node_label.substring(0, node_label.length - "_node_fuse".length)}_fuse_topo"
        else
            if (node_label.endsWith("_fuse_node"))
                s"${node_label.substring(0, node_label.length - "_fuse_node".length)}_fuse_topo"
            else
                if (node_label.endsWith("_node"))
                    s"${node_label.substring(0, node_label.length - "_node".length)}_topo"
                else
                    s"${node_label}_topo"
    }
}

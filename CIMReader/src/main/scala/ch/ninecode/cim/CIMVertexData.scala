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
    var island: VertexId = Long.MaxValue,
    var island_label: String = "",
    var node: VertexId = Long.MaxValue,
    var node_label: String = "",
    var voltage: String = null,
    var container: String = null)
{
    /**
     * Generate an appropriate name for the topological node based on the node label.
     *
     * @return The best guess as to what the topological node should be called.
     */
    def name: String =
    {
        if (node_label.endsWith ("_node_fuse"))
            node_label.substring (0, node_label.length - "_node_fuse".length) + "_fuse_topo"
        else
            if (node_label.endsWith ("_fuse_node"))
                node_label.substring (0, node_label.length - "_fuse_node".length) + "_fuse_topo"
            else
                if (node_label.endsWith ("_node"))
                    node_label.substring (0, node_label.length - "_node".length) + "_topo"
                else
                    node_label + "_topo"
    }
}

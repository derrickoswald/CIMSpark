package ch.ninecode.cim

import org.apache.spark.graphx.VertexId

/**
 * Smaller version of CIMVertexData for identifyNodes().
 * @param node the minimum (hash code) of equivalent ConnectivityNode (a single topological node)
 * @param node_label a user friendly label for the node
 * @param voltage the nominal voltage of the node
 */
case class CIMVD (
    node: VertexId = Long.MaxValue,
    node_label: String = "",
    voltage: String = null)
{
    override def toString: String = s"$node_label:$voltage"
}
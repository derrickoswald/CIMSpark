package ch.ninecode.cim

/**
 * Get a list of classes suitable for Kryo registration.
 */
object CIMClasses
{
    /**
     * The list of classes that can be persisted in RDD.
     */
    lazy val list: Array[Class[_]] =
    {
        val chim = new CHIM("") // ensure registration has occurred
        Array.concat(
            Array(classOf[ch.ninecode.model.Element], classOf[ch.ninecode.model.BasicElement], classOf[ch.ninecode.model.Unknown]), // low level classes
            chim.classes.map(_.subsetter.runtime_class).toArray, // CIM model case classes
            Array(classOf[CIMEdgeData], classOf[CIMVertexData], classOf[CIMVD], classOf[CIMIslandData], classOf[CIMTopologyOptions]), // topological classes
            Array(classOf[PreEdge], classOf[Extremum], classOf[PostEdge]) // edge related classes
        )
    }
}
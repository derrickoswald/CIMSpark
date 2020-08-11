package ch.ninecode.cim

/**
 * Edge data for topological processing.
 *
 * @param id_cn_1     the connectivity node of terminal 0
 * @param id_cn_2     the connectivity node of terminal 1 (or N in the case of multi-terminal devices)
 * @param id_equ      the [[ch.ninecode.model.ConductingEquipment]] object associated with the terminals
 * @param voltage     the nominal voltage of the edge
 * @param isZero      <code>true</code> if there is no electrical difference between the terminals, i.e. a closed switch,
 *                    which means the terminals are the same topological node
 * @param isConnected <code>true</code> if there is a connection between the terminals, i.e. a cable,
 *                    which means the terminals are the same topological island
 */
case class CIMEdgeData (
    id_cn_1: String,
    id_cn_2: String,
    id_equ: String,
    voltage: String,
    isZero: Boolean,
    isConnected: Boolean)

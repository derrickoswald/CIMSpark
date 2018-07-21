package ch.ninecode.cim

trait State

case class ForceTrue () extends State
case class ForceFalse () extends State
case class Unforced () extends State

/**
 * Topological processing options.
 *
 * This class determines some of the behaviour of the CIMNetworkTopologyProcessor.
 * These options are passed to the processor constructor and cannot be altered dynamically.
 *
 * @param force_retain_switches Allows override of the behaviour when the processor encounters a Switch
 * or a Switch derived class (e.g. Breaker) except for Fuse. The default behaviour of <code>Unforced<c/ode>
 * will use the value of the <code>retained</code> attribute to identify an island boundary
 * only if the attribute is present in the CIM file and the value is <code>true</code>.
 * When set to <code>ForceTrue</code> the behaviour is equivalent to having a <code>retained</code>
 * attribute with value <code>true</code> for every instance.
 * When set to <code>ForecFalse</code> the behaviour is equivalent to having a <code>retained</code>
 * attribute with value <code>false</code> for every instance.
 * @param force_retain_fuses Allows override of the behaviour when a Fuse is encountered.
 * The same effect as for Switch objects using <code>force_retain_switches</code> but for Fuse objects.
 * @param default_switch_closed_state Allows changing the behaviour when the processor encounters a Switch
 * that has neither an <code>open</code> attribute, nor  <code>normalOpen</code> attribute.
 * The default behaviour of <code>ForceTrue<c/ode> is the same as if <code>open</code> and <code>normalOpen</code>
 * both specify <code>false</code>.
 */
case class CIMTopologyOptions
(
    force_retain_switches: State = Unforced (),
    force_retain_fuses: State = Unforced (),
    default_switch_closed_state: State = ForceTrue ()
)
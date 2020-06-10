package ch.ninecode.cim

import scala.language.existentials

/**
 * Container for CIM class information.
 *
 * @param name the name of the class without any package prefix, i.e. the original CIM class name
 * @param parseable the registration and subsetting object for this concrete class
 * @param subsetter the subsetter for this concrete class
 * @param relations the relationships of this concrete class
 */
case class CIMClassInfo (
    name: String,
    parseable: CIMParseable[Product],
    subsetter: CIMSubsetter[_ <: Product],
    relations: List[CIMRelationship])


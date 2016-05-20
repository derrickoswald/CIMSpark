package ch.ninecode.model

import org.apache.spark.sql.Row

import java.lang.NumberFormatException
import java.util.regex.Pattern
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStreamReader
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.HashMap
import scala.collection.mutable.HashSet

import ch.ninecode.Context

trait Parser
{
    /**
     * Abstract parse function.
     * To be overridden in each implemented class.
     */
    def parse (context: Context): Element

    def element (name: String) = (Pattern.compile ("""<cim:""" + name + """>([\s\S]*?)<\/cim:""" + name + """>"""), 1)
    def attribute (name: String) = (Pattern.compile ("""<cim:""" + name + """\s+rdf:resource\s*?=\s*?("|')([\s\S]*?)\1\s*?\/>"""), 2)

    /**
     * Parse one XML element from a string.
     * @param pattern the regular expression pattern to look for
     * @param index the number of the capture group to extract from within the pattern
     * @param context the context for the substring in the XML and
     * line number and position context for reporting in case of an error
     * @return the matched group from the regular expression
     */
    def parse_element (pattern: Tuple2[Pattern, Int])(context: Context): String =
    {
        var ret:String = null
        val matcher = pattern._1.matcher (context.xml)
        if (matcher.find ())
        {
            ret = matcher.group (pattern._2)
            if (context.DEBUG)
                context.coverage += Tuple2 (matcher.start (), matcher.end ())
        }

        return (ret)
    }

    /**
     * Parse one attribute from an XML string.
     * @param pattern the regular expression pattern to look for
     * @param index the number of the capture group to extract from within the pattern
     * @param context the context for the substring in the XML and
     * line number and position context for reporting in case of an error
     * @return the attribute value (with leading # stripped off)
     */
    def parse_attribute (pattern: Tuple2[Pattern, Int])(context: Context): String =
    {
        var ret = parse_element (pattern)(context)
        if ((null != ret) && ret.startsWith ("#")) // remove '#'
            ret = ret.substring (1)

        return (ret)
    }

    def toBoolean (string: String, context: Context): Boolean =
    {
        var ret = false

        if ((null != string) && ("" != string))
            try
            {
                ret = string.toBoolean
            }
            catch
            {
                case nfe: IllegalArgumentException ⇒ throw new Exception ("unparsable boolean (" + string + ") found while parsing at line " + context.line_number ())
            }

        return (ret);


    }

    def toInteger (string: String, context: Context): Integer =
    {
        var ret = 0

        if ((null != string) && ("" != string))
            try
            {
                ret = string.toInt
            }
            catch
            {
                case nfe: NumberFormatException ⇒ throw new Exception ("unparsable integer (" + string + ")found while parsing at line " + context.line_number ())
            }

        return (ret);
    }

    def toDouble (string: String, context: Context): Double =
    {
        var ret = 0.0

        if ((null != string) && ("" != string))
            try
            {
                ret = string.toDouble
            }
            catch
            {
                case nfe: NumberFormatException ⇒ throw new Exception ("unparsable double (" + string + ")found while parsing at line " + context.line_number ())
            }

        return (ret);
    }
}

/**
 * Top level element.
 */
class Element
(
    val sup: Element = null,
    val id: String = null
)
extends
    Row
with
    Serializable
with
    Cloneable
{
    def key: String = { if (null == sup) id else sup.key }
    def copy (): Row = { return (this.clone ().asInstanceOf[Element]); }
    override def get (i: Int): Any =
    {
        if (0 == i)
            sup
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    def length: Int = 2
}

object Element
extends
    Parser
{
    /**
     * Parse an element.
     * Simply extracts the id
     */
    val mRID = parse_element ((Pattern.compile ("""rdf:ID=("|')([\s\S]*?)\1>?"""), 2))_
    override def parse (context: Context): Element =
    {
        return (
            new Element
            (
                null,
                mRID (context)
            )
        )
    }

}

/**
 * Unknown element
 * Default parsed element, when no other more specific class applies
 */
case class Unknown (
    override val sup: Element,
    guts: String,
    line: Int,
    start: Long,
    end: Long
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[Unknown]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Unknown
extends
    Parser
{
    def parse (context: Context): Unknown =
    {
        return (
            Unknown
            (
                Element.parse (context),
                context.xml,
                context.line_number (),
                context.start,
                context.end
            )
        )
    }
}

case class UserAttribute (
    override val sup: Element,
    name: String,
    sequenceNumber: Integer,
    val PropertySpecification: String,
    val RatingSpecification: String,
    val Transaction: String,
    val value: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[UserAttribute]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object UserAttribute
extends
    Parser
{
    val name = parse_element (element ("""UserAttribute.name"""))_
    val sequenceNumber = parse_element (element ("""UserAttribute.sequenceNumber"""))_
    val PropertySpecification = parse_attribute (attribute ("""UserAttribute.PropertySpecification"""))_
    val RatingSpecification = parse_attribute (attribute ("""UserAttribute.RatingSpecification"""))_
    val Transaction = parse_attribute (attribute ("""UserAttribute.Transaction"""))_
    val value = parse_element (element ("""UserAttribute.value"""))_
    def parse (context: Context): UserAttribute =
    {
        return (
            UserAttribute
            (
                Element.parse (context),
                name (context),
                toInteger (sequenceNumber (context), context),
                PropertySpecification (context),
                RatingSpecification (context),
                Transaction (context),
                value (context)
            )
        )
    }
}

case class NameTypeAuthority (
    override val sup: Element,
    description: String,
    name: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[NameTypeAuthority]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object NameTypeAuthority
extends
    Parser
{
    val description = parse_element (element ("""NameTypeAuthority.description"""))_
    val name = parse_element (element ("""NameTypeAuthority.name"""))_
    def parse (context: Context): NameTypeAuthority =
    {
        return (
            NameTypeAuthority
            (
                Element.parse (context),
                description (context),
                name (context)
            )
        )
    }
}

case class NameType (
    override val sup: Element,
    description: String,
    name: String,
    NameTypeAuthority: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[NameType]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object NameType
extends
    Parser
{
    val description = parse_element (element ("""NameType.description"""))_
    val name = parse_element (element ("""NameType.name"""))_
    val NameTypeAuthority = parse_attribute (attribute ("""NameType.NameTypeAuthority"""))_
    def parse (context: Context): NameType =
    {
        return (
            NameType
            (
                Element.parse (context),
                description (context),
                name (context),
                NameTypeAuthority (context)
            )
        )
    }
}

case class StateVariable (
    override val sup: Element
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[StateVariable]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object StateVariable
extends
    Parser
{
    def parse (context: Context): StateVariable =
    {
        return (
            StateVariable
            (
                Element.parse (context)
            )
        )
    }
}

case class SvStatus (
    override val sup: Element,
    val inService: Boolean,
    val ConductingEquipment: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[SvStatus]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SvStatus
extends
    Parser
{
    def parse (context: Context): SvStatus =
    {
        val inService = parse_element (element ("""SvStatus.inService"""))_
        val ConductingEquipment = parse_attribute (attribute ("""SvStatus.ConductingEquipment"""))_
        return (
            SvStatus
            (
                StateVariable.parse (context),
                toBoolean (inService (context), context),
                ConductingEquipment (context)
            )
        )
    }
}

/**
 * Top level CIM object.
 */
case class IdentifiedObject
(
    override val sup: Element,
    val aliasName: String,
    val description: String,
    val mRID: String,
    val name: String
)
extends
    Element (sup)
{
    override def key: String = { if (null == sup) mRID else sup.key }
    override def copy (): Row = { return (this.clone ().asInstanceOf[IdentifiedObject]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object IdentifiedObject
extends
    Parser
{
    val aliasName = parse_element (element ("""IdentifiedObject.aliasName"""))_
    val description = parse_element (element ("""IdentifiedObject.description"""))_
    val name = parse_element (element ("""IdentifiedObject.name"""))_

    def parse (context: Context): IdentifiedObject =
    {
        val element = Element.parse (context)
        return (
            IdentifiedObject (
                element,
                aliasName (context),
                description (context),
                element.id,
                name (context)
            )
        )
    }
}

case class PSRType
(
    override val sup: Element
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[PSRType]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PSRType
extends
    Parser
{
    def parse (context: Context): PSRType =
    {
        return (
            PSRType
            (
                IdentifiedObject.parse (context)
            )
        )
    }
}

case class Name
(
    override val sup: Element,
    val name: String,
    val IdentifiedObj: String,
    val NameType: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[Name]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Name
extends
    Parser
{
    def parse (context: Context): Name =
    {
        val name = parse_element (element ("""Name.name"""))_
        val IdentifiedObj = parse_attribute (attribute ("""Name.IdentifiedObject"""))_
        val NameType = parse_attribute (attribute ("""Name.NameType"""))_
        return (
            Name
            (
                IdentifiedObject.parse (context),
                name (context),
                IdentifiedObj (context),
                NameType (context)
            )
        )
    }
}

case class CoordinateSystem
(
    override val sup: Element,
    val crsUrn: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[CoordinateSystem]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CoordinateSystem
extends
    Parser
{
    val crsUrn = parse_element (element ("""CoordinateSystem.crsUrn"""))_
    def parse (context: Context): CoordinateSystem =
    {
        return (
            CoordinateSystem
            (
                IdentifiedObject.parse (context),
                crsUrn (context)
            )
        )
    }
}

case class BaseVoltage
(
    override val sup: Element,
    val nominalVoltage: Double
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[BaseVoltage]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BaseVoltage
extends
    Parser
{
    val nominalVoltage = parse_element (element ("""BaseVoltage.nominalVoltage"""))_

    def parse (context: Context): BaseVoltage =
    {
        return (
            BaseVoltage
            (
                IdentifiedObject.parse (context),
                toDouble (nominalVoltage (context), context)
            )
        )
    }
}

case class ConnectivityNode
(
    override val sup: Element,
    val ConnectivityNodeContainer: String,
    val TopologicalNode: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[ConnectivityNode]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ConnectivityNode
extends
    Parser
{
    val ConnectivityNodeContainer = parse_attribute (attribute ("""ConnectivityNode.ConnectivityNodeContainer"""))_
    val TopologicalNode = parse_attribute (attribute ("""ConnectivityNode.TopologicalNode"""))_

    def parse (context: Context): ConnectivityNode =
    {
        return (
            ConnectivityNode
            (
                IdentifiedObject.parse (context),
                ConnectivityNodeContainer (context),
                TopologicalNode (context)
            )
        )
    }
}

case class ACDCTerminal
(
    override val sup: Element,
    val connected: Boolean,
    val sequenceNumber: Integer,
    val BusNameMarker: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[ACDCTerminal]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ACDCTerminal
extends
    Parser
{
    val connected = parse_attribute (attribute ("""ACDCTerminal.connected"""))_
    val sequenceNumber = parse_element (element ("""ACDCTerminal.sequenceNumber"""))_
    val BusNameMarker = parse_attribute (attribute ("""ACDCTerminal.BusNameMarker"""))_
    def parse (context: Context): ACDCTerminal =
    {
        return (
            ACDCTerminal
            (
                IdentifiedObject.parse (context),
                toBoolean (connected (context), context),
                toInteger (sequenceNumber (context), context),
                BusNameMarker (context)
            )
        )
    }
}

case class Terminal
(
    override val sup: Element,
    val phases: String,
    val Bushing: String,
    val ConductingEquipment: String,
    val ConnectivityNode: String,
    val SvPowerFlow: String,
    val TopologicalNode: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[Terminal]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Terminal
extends
    Parser
{
    val phases = parse_attribute (attribute ("""Terminal.phases"""))_
    val Bushing = parse_attribute (attribute ("""Terminal.Bushing"""))_
    val ConductingEquipment = parse_attribute (attribute ("""Terminal.ConductingEquipment"""))_
    val ConnectivityNode = parse_attribute (attribute ("""Terminal.ConnectivityNode"""))_
    val SvPowerFlow = parse_attribute (attribute ("""Terminal.SvPowerFlow"""))_
    val TopologicalNode = parse_attribute (attribute ("""Terminal.TopologicalNode"""))_
    def parse (context: Context): Terminal =
    {
        return (
            Terminal
            (
                ACDCTerminal.parse (context),
                phases (context),
                Bushing (context),
                ConductingEquipment (context),
                ConnectivityNode (context),
                SvPowerFlow (context),
                TopologicalNode (context)
            )
        )
    }
}

case class PowerSystemResource
(
    override val sup: Element,
    val AssetDataSheet: String,
    val Location: String,
    val PSRType: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[PowerSystemResource]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PowerSystemResource
extends
    Parser
{
    val AssetDataSheet = parse_attribute (attribute ("""PowerSystemResource.AssetDataSheet"""))_
    // ToDo: make this an attribute
    val Location = parse_element (element ("""PowerSystemResource.Location"""))_
    val PSRType = parse_attribute (attribute ("""PowerSystemResource.PSRType"""))_
    def parse (context: Context): PowerSystemResource =
    {
        return (
            PowerSystemResource
            (
                IdentifiedObject.parse (context),
                AssetDataSheet (context),
                Location (context),
                PSRType (context)
            )
        )
    }
}

case class ConnectivityNodeContainer
(
    override val sup: Element
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[ConnectivityNodeContainer]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ConnectivityNodeContainer
extends
    Parser
{
    def parse (context: Context): ConnectivityNodeContainer =
    {
        return (
            ConnectivityNodeContainer
            (
                PowerSystemResource.parse (context)
            )
        )
    }
}

case class EquipmentContainer
(
    override val sup: Element
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[EquipmentContainer]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EquipmentContainer
extends
    Parser
{
    def parse (context: Context): EquipmentContainer =
    {
        return (
            EquipmentContainer
            (
                ConnectivityNodeContainer.parse (context)
            )
        )
    }
}

case class Line
(
    override val sup: Element,
    val Region: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[Line]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Line
extends
    Parser
{
    val Region = parse_attribute (attribute ("""Line.Region"""))_
    def parse (context: Context): Line =
    {
        return (
            Line
            (
                ConnectivityNodeContainer.parse (context),
                Region (context)
            )
        )
    }
}

case class Substation
(
    override val sup: Element,
    val Region: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[Substation]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Substation
extends
    Parser
{
    val Region = parse_attribute (attribute ("""Substation.Region"""))_
    def parse (context: Context): Substation =
    {
        return (
            Substation
            (
                ConnectivityNodeContainer.parse (context),
                Region (context)
            )
        )
    }
}

case class VoltageLevel
(
    override val sup: Element,
    val highVoltageLimit: Double,
    val lowVoltageLimit: Double,
    val BaseVoltage: String,
    val Substation: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[VoltageLevel]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object VoltageLevel
extends
    Parser
{
    val highVoltageLimit = parse_element (element ("""VoltageLevel.highVoltageLimit"""))_
    val lowVoltageLimit = parse_element (element ("""VoltageLevel.lowVoltageLimit"""))_
    val BaseVoltage = parse_attribute (attribute ("""VoltageLevel.BaseVoltage"""))_
    val Substation = parse_attribute (attribute ("""VoltageLevel.Substation"""))_
    def parse (context: Context): VoltageLevel =
    {
        return (
            VoltageLevel
            (
                EquipmentContainer.parse (context),
                toDouble (highVoltageLimit (context), context),
                toDouble (lowVoltageLimit (context), context),
                BaseVoltage (context),
                Substation (context)
            )
        )
    }
}

case class Bay
(
    override val sup: Element,
    val bayEnergyMeasFlag: Boolean,
    val bayPowerMeasFlag: Boolean,
    val Substation: String,
    val VoltageLevel: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[Bay]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Bay
extends
    Parser
{
    val bayEnergyMeasFlag = parse_element (element ("""Bay.bayEnergyMeasFlag"""))_
    val bayPowerMeasFlag = parse_element (element ("""Bay.bayPowerMeasFlag"""))_
    val Substation = parse_attribute (attribute ("""Bay.Substation"""))_
    val VoltageLevel = parse_attribute (attribute ("""Bay.VoltageLevel"""))_
    def parse (context: Context): Bay =
    {
        return (
            Bay
            (
                EquipmentContainer.parse (context),
                toBoolean (bayEnergyMeasFlag (context), context),
                toBoolean (bayPowerMeasFlag (context), context),
                Substation (context),
                VoltageLevel (context)
            )
        )
    }
}

case class Equipment
(
    override val sup: Element,
    val aggregate: Boolean,
    val normallyInService: Boolean,
    val EquipmentContainer: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[Equipment]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Equipment
extends
    Parser
{
    val aggregate = parse_element (element ("""Equipment.aggregate"""))_
    val normallyInService = parse_element (element ("""Equipment.normallyInService"""))_
    val EquipmentContainer = parse_attribute (attribute ("""Equipment.EquipmentContainer"""))_
    def parse (context: Context): Equipment =
    {
        return (
            Equipment
            (
                PowerSystemResource.parse (context),
                toBoolean (aggregate (context), context),
                toBoolean (normallyInService (context), context),
                EquipmentContainer (context)
            )
        )
    }
}

case class ConductingEquipment
(
    override val sup: Element,
    val BaseVoltage: String,
    val GroundingAction: String,
    val JumpingAction: String,
    val SvStatus: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[ConductingEquipment]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ConductingEquipment
extends
    Parser
{
    val BaseVoltage = parse_attribute (attribute ("""ConductingEquipment.BaseVoltage"""))_
    val GroundingAction = parse_attribute (attribute ("""ConductingEquipment.GroundingAction"""))_
    val JumpingAction = parse_attribute (attribute ("""ConductingEquipment.JumpingAction"""))_
    val SvStatus = parse_attribute (attribute ("""ConductingEquipment.SvStatus"""))_
    def parse (context: Context): ConductingEquipment =
    {
        return (
            ConductingEquipment
            (
                Equipment.parse (context),
                BaseVoltage (context),
                GroundingAction (context),
                JumpingAction (context),
                SvStatus (context)
            )
        )
    }
}

case class Connector
(
    override val sup: Element
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[Connector]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Connector
extends
    Parser
{
    def parse (context: Context): Connector =
    {
        return (
            Connector
            (
                ConductingEquipment.parse (context)
            )
        )
    }
}

case class Junction
(
    override val sup: Element
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[Junction]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Junction
extends
    Parser
{
    def parse (context: Context): Junction =
    {
        return (
            Junction
            (
                Connector.parse (context)
            )
        )
    }
}

case class EnergyConsumer
(
    override val sup: Element,
    val customerCount: Integer,
    val grounded: Boolean,
    val p: Double,
    val pfixed: Double,
    val pfixedPct: Double,
    val phaseConnection: String,
    val q: Double,
    val qfixed: Double,
    val qfixedPct: Double,
    val LoadDynamics: String,
    val LoadResponse: String,
    val PowerCutZone: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[EnergyConsumer]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EnergyConsumer
extends
    Parser
{
    val customerCount = parse_element (element ("""EnergyConsumer.customerCount"""))_
    val grounded = parse_element (element ("""EnergyConsumer.grounded"""))_
    val p = parse_element (element ("""EnergyConsumer.p"""))_
    val pfixed = parse_element (element ("""EnergyConsumer.pfixed"""))_
    val pfixedPct = parse_element (element ("""EnergyConsumer.pfixedPct"""))_
    val phaseConnection = parse_attribute (attribute ("""EnergyConsumer.phaseConnection"""))_
    val q = parse_element (element ("""EnergyConsumer.q"""))_
    val qfixed = parse_element (element ("""EnergyConsumer.qfixed"""))_
    val qfixedPct = parse_element (element ("""EnergyConsumer.qfixedPct"""))_
    val LoadDynamics = parse_attribute (attribute ("""EnergyConsumer.LoadDynamics"""))_
    val LoadResponse = parse_attribute (attribute ("""EnergyConsumer.LoadResponse"""))_
    val PowerCutZone = parse_attribute (attribute ("""EnergyConsumer.PowerCutZone"""))_
    def parse (context: Context): EnergyConsumer =
    {
        return (
            EnergyConsumer
            (
                ConductingEquipment.parse (context),
                toInteger (customerCount (context), context),
                toBoolean (grounded (context), context),
                toDouble (p (context), context),
                toDouble (pfixed (context), context),
                toDouble (pfixedPct (context), context),
                phaseConnection (context),
                toDouble (q (context), context),
                toDouble (qfixed (context), context),
                toDouble (qfixedPct (context), context),
                LoadDynamics (context),
                LoadResponse (context),
                PowerCutZone (context)
            )
        )
    }
}

case class Conductor
(
    override val sup: Element,
    val len: Double
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[Conductor]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Conductor
extends
    Parser
{
    val len = parse_element (element ("""Conductor.length"""))_
    def parse (context: Context): Conductor =
    {
        return (
            Conductor
            (
                ConductingEquipment.parse (context),
                toDouble (len (context), context)
            )
        )
    }
}

case class ACLineSegment
(
    override val sup: Element,
    val b0ch: Double,
    val bch: Double,
    val g0ch: Double,
    val gch: Double,
    val r0: Double,
    val r: Double,
    val shortCircuitEndTemperature: Double,
    val x0: Double,
    val x: Double,
    val LineGroundingAction: String,
    val LineJumpingAction: String,
    val PerLengthImpedance: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[ACLineSegment]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ACLineSegment
extends
    Parser
{
    val b0ch = parse_element (element ("""ACLineSegment.b0ch"""))_
    val bch = parse_element (element ("""ACLineSegment.bch"""))_
    val g0ch = parse_element (element ("""ACLineSegment.g0ch"""))_
    val gch = parse_element (element ("""ACLineSegment.gch"""))_
    val r0 = parse_element (element ("""ACLineSegment.r0"""))_
    val r = parse_element (element ("""ACLineSegment.r"""))_
    val shortCircuitEndTemperature = parse_element (element ("""ACLineSegment.shortCircuitEndTemperature"""))_
    val x0 = parse_element (element ("""ACLineSegment.x0"""))_
    val x = parse_element (element ("""ACLineSegment.x"""))_
    val LineGroundingAction = parse_attribute (attribute ("""ACLineSegment.LineGroundingAction"""))_
    val LineJumpingAction = parse_attribute (attribute ("""ACLineSegment.LineJumpingAction"""))_
    val PerLengthImpedance = parse_attribute (attribute ("""ACLineSegment.PerLengthImpedance"""))_
    def parse (context: Context): ACLineSegment =
    {
        return (
            ACLineSegment
            (
                Conductor.parse (context),
                toDouble (b0ch (context), context),
                toDouble (bch (context), context),
                toDouble (g0ch (context), context),
                toDouble (gch (context), context),
                toDouble (r0 (context), context),
                toDouble (r (context), context),
                toDouble (shortCircuitEndTemperature (context), context),
                toDouble (x0 (context), context),
                toDouble (x (context), context),
                LineGroundingAction (context),
                LineJumpingAction (context),
                PerLengthImpedance (context)
            )
        )
    }
}

case class BusbarSection
(
    override val sup: Element,
    val ipMax: Double
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[BusbarSection]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BusbarSection
extends
    Parser
{
    val ipMax = parse_element (element ("""BusbarSection.ipMax"""))_
    def parse (context: Context): BusbarSection =
    {
        return (
            BusbarSection
            (
                Connector.parse (context),
                toDouble (ipMax (context), context)
            )
        )
    }
}

case class Switch
(
    override val sup: Element,
    val normalOpen: Boolean,
    val open: Boolean,
    // ToDo: should be Double
    val ratedCurrent: String,
    val retained: Boolean,
    val switchOnCount: Integer,
    // ToDo: Date handlien
    //val switchOnDate: Date
    val CompositeSwitch: String,
    val Outage: String,
    val SwitchAction: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[Switch]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Switch
extends
    Parser
{
    val normalOpen = parse_element (element ("""Switch.normalOpen"""))_
    val open = parse_element (element ("""Switch.open"""))_
    val ratedCurrent = parse_element (element ("""Switch.ratedCurrent"""))_
    val retained = parse_element (element ("""Switch.retained"""))_
    val switchOnCount = parse_element (element ("""Switch.switchOnCount"""))_
    val CompositeSwitch = parse_attribute (attribute ("""Switch.CompositeSwitch"""))_
    val Outage = parse_attribute (attribute ("""Switch.Outage"""))_
    val SwitchAction = parse_attribute (attribute ("""Switch.SwitchAction"""))_
    def parse (context: Context): Switch =
    {
        return (
            Switch
            (
                ConductingEquipment.parse (context),
                toBoolean (normalOpen (context), context),
                toBoolean (open (context), context),
                ratedCurrent (context),
                toBoolean (retained (context), context),
                toInteger (switchOnCount (context), context),
                CompositeSwitch (context),
                Outage (context),
                SwitchAction (context)
            )
        )
    }
}

case class Fuse
(
    override val sup: Element
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[Fuse]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Fuse
extends
    Parser
{
    def parse (context: Context): Fuse =
    {
        return (
            Fuse
            (
                Switch.parse (context)
            )
        )
    }
}

case class Disconnector
(
    override val sup: Element
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[Disconnector]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Disconnector
extends
    Parser
{
    def parse (context: Context): Disconnector =
    {
        return (
            Disconnector
            (
                Switch.parse (context)
            )
        )
    }
}

case class GeneratingUnit
(
    override val sup: Element
    // ToDo: many, many attributes
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[GeneratingUnit]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object GeneratingUnit
extends
    Parser
{
    def parse (context: Context): GeneratingUnit =
    {
        return (
            GeneratingUnit
            (
                Equipment.parse (context)
            )
        )
    }
}

case class SolarGeneratingUnit
(
    override val sup: Element
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[SolarGeneratingUnit]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SolarGeneratingUnit
extends
    Parser
{
    //val x = parse_element (element ("""SolarGeneratingUnit."""))_
    //val y = parse_attribute (attribute ("""SolarGeneratingUnit."""))_
    def parse (context: Context): SolarGeneratingUnit =
    {
        return (
            SolarGeneratingUnit
            (
                GeneratingUnit.parse (context)
            )
        )
    }
}

case class TransformerTank
(
    override val sup: Element,
    PowerTransformer: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[TransformerTank]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransformerTank
extends
    Parser
{
    val PowerTransformer = parse_attribute (attribute ("""TransformerTank.PowerTransformer"""))_
    def parse (context: Context): TransformerTank =
    {
        return (
            TransformerTank
            (
                Equipment.parse (context),
                PowerTransformer (context)
            )
        )
    }
}

case class TransformerEnd
(
    override val sup: Element,
    val bmagSat: Double,
    val endNumber: Integer,
    val grounded: Boolean,
    val magBaseU: Double,
    val magSatFlux: Double,
    val rground: Double,
    val xground: Double,
    val BaseVoltage: String,
    val CoreAdmittance: String,
    val FromMeshImpedance: String,
    val FromWindingInsulations: String,
    val PhaseTapChanger: String,
    val RatioTapChanger: String,
    val StarImpedance: String,
    val Terminal: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[TransformerEnd]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransformerEnd
extends
    Parser
{
    val bmagSat = parse_element (element ("""TransformerEnd.bmagSat"""))_
    val endNumber = parse_element (element ("""TransformerEnd.endNumber"""))_
    val grounded = parse_element (element ("""TransformerEnd.grounded"""))_
    val magBaseU = parse_element (element ("""TransformerEnd.magBaseU"""))_
    val magSatFlux = parse_element (element ("""TransformerEnd.magSatFlux"""))_
    val rground = parse_element (element ("""TransformerEnd.rground"""))_
    val xground = parse_element (element ("""TransformerEnd.xground"""))_
    val BaseVoltage = parse_element (element ("""TransformerEnd.BaseVoltage"""))_
    val CoreAdmittance = parse_element (element ("""TransformerEnd.CoreAdmittance"""))_
    val FromMeshImpedance = parse_element (element ("""TransformerEnd.FromMeshImpedance"""))_
    val FromWindingInsulations = parse_element (element ("""TransformerEnd.FromWindingInsulations"""))_
    val PhaseTapChanger = parse_element (element ("""TransformerEnd.PhaseTapChanger"""))_
    val RatioTapChanger = parse_element (element ("""TransformerEnd.RatioTapChanger"""))_
    val StarImpedance = parse_element (element ("""TransformerEnd.StarImpedance"""))_
    val Terminal = parse_element (element ("""TransformerEnd.Terminal"""))_
    def parse (context: Context): TransformerEnd =
    {
        return (
            TransformerEnd
            (
                IdentifiedObject.parse (context),
                toDouble (bmagSat (context), context),
                toInteger (endNumber (context), context),
                toBoolean (grounded (context), context),
                toDouble (magBaseU (context), context),
                toDouble (magSatFlux (context), context),
                toDouble (rground (context), context),
                toDouble (xground (context), context),
                BaseVoltage (context),
                CoreAdmittance (context),
                FromMeshImpedance (context),
                FromWindingInsulations (context),
                PhaseTapChanger (context),
                RatioTapChanger (context),
                StarImpedance (context),
                Terminal (context)
            )
        )
    }
}

case class PowerTransformerEnd
(
    override val sup: Element,
    val b0: Double,
    val b: Double,
    val connectionKind: String,
    val g0: Double,
    val g: Double,
    val phaseAngleClock: Integer,
    val r0: Double,
    val r: Double,
    val ratedS: Double,
    val ratedU: Double,
    val x0: Double,
    val x: Double,
    val PowerTransformer: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[PowerTransformer]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PowerTransformerEnd
extends
    Parser
{
    val b0 = parse_element (element ("""PowerTransformerEnd.b0"""))_
    val b = parse_element (element ("""PowerTransformerEnd.b"""))_
    val connectionKind = parse_attribute (attribute ("""PowerTransformerEnd.connectionKind"""))_
    val g0 = parse_element (element ("""PowerTransformerEnd.g0"""))_
    val g = parse_element (element ("""PowerTransformerEnd.g"""))_
    val phaseAngleClock = parse_element (element ("""PowerTransformerEnd.phaseAngleClock"""))_
    val r0 = parse_element (element ("""PowerTransformerEnd.r0"""))_
    val r = parse_element (element ("""PowerTransformerEnd.r"""))_
    val ratedS = parse_element (element ("""PowerTransformerEnd.ratedS"""))_
    val ratedU = parse_element (element ("""PowerTransformerEnd.ratedU"""))_
    val x0 = parse_element (element ("""PowerTransformerEnd.x0"""))_
    val x = parse_element (element ("""PowerTransformerEnd.x"""))_
    val PowerTransformer = parse_attribute (attribute ("""PowerTransformerEnd.PowerTransformer"""))_
    def parse (context: Context): PowerTransformerEnd =
    {
        return (
            PowerTransformerEnd
            (
                TransformerEnd.parse (context),
                toDouble (b0 (context), context),
                toDouble (b (context), context),
                connectionKind (context),
                toDouble (g0 (context), context),
                toDouble (g (context), context),
                toInteger (phaseAngleClock (context), context),
                toDouble (r0 (context), context),
                toDouble (r (context), context),
                toDouble (ratedS (context), context),
                toDouble (ratedU (context), context),
                toDouble (x0 (context), context),
                toDouble (x (context), context),
                PowerTransformer (context)
            )
        )
    }
}

case class TransformerTankEnd
(
    override val sup: Element,
    val phases: String,
    val TransformerTank: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[TransformerTankEnd]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TransformerTankEnd
extends
    Parser
{
    val phases = parse_element (element ("""TransformerTankEnd.phases"""))_
    val TransformerTank = parse_attribute (attribute ("""TransformerTankEnd.TransformerTank"""))_
    def parse (context: Context): TransformerTankEnd =
    {
        return (
            TransformerTankEnd
            (
                Equipment.parse (context),
                phases (context),
                TransformerTank (context)
            )
        )
    }
}


case class PowerTransformer
(
    override val sup: Element,
    val beforeShCircuitHighestOperatingCurrent: Double,
    val beforeShCircuitHighestOperatingVoltage: Double,
    val beforeShortCircuitAnglePf: Double,
    val highSideMinOperatingU: Double,
    val isPartOfGeneratorUnit: Boolean,
    val operationalValuesConsidered: Boolean,
    val vectorGroup: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[PowerTransformer]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PowerTransformer
extends
    Parser
{
    val beforeShCircuitHighestOperatingCurrent = parse_element (element ("""PowerTransformer.beforeShCircuitHighestOperatingCurrent"""))_
    val beforeShCircuitHighestOperatingVoltage = parse_element (element ("""PowerTransformer.beforeShCircuitHighestOperatingVoltage"""))_
    val beforeShortCircuitAnglePf = parse_element (element ("""PowerTransformer.beforeShortCircuitAnglePf"""))_
    val highSideMinOperatingU = parse_element (element ("""PowerTransformer.highSideMinOperatingU"""))_
    val isPartOfGeneratorUnit = parse_element (element ("""PowerTransformer.isPartOfGeneratorUnit"""))_
    val operationalValuesConsidered = parse_element (element ("""PowerTransformer.operationalValuesConsidered"""))_
    val vectorGroup = parse_element (element ("""PowerTransformer.vectorGroup"""))_
    def parse (context: Context): PowerTransformer =
    {
        return (
            PowerTransformer
            (
                ConductingEquipment.parse (context),
                toDouble (beforeShCircuitHighestOperatingCurrent (context), context),
                toDouble (beforeShCircuitHighestOperatingVoltage (context), context),
                toDouble (beforeShortCircuitAnglePf (context), context),
                toDouble (highSideMinOperatingU (context), context),
                toBoolean (isPartOfGeneratorUnit (context), context),
                toBoolean (operationalValuesConsidered (context), context),
                vectorGroup (context)
            )
        )
    }
}

case class Location
(
    override val sup: Element,
    val direction: String,
    val geoInfoReference: String,
    val typ: String,
    val CoordinateSystem: String,
    val electronicAddress: String,
    val mainAddress: String,
    val phone1: String,
    val phone2: String,
    val secondaryAddress: String,
    val status: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[Location]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Location
extends
    Parser
{
    val direction = parse_element (element ("""Location.direction"""))_
    val geoInfoReference = parse_element (element ("""Location.geoInfoReference"""))_
    val typ = parse_element (element ("""Location.type"""))_
    // ToD: fix this; should be attribute:
    val CoordinateSystem = parse_element (element ("""Location.CoordinateSystem"""))_
    val electronicAddress = parse_attribute (attribute ("""Location.electronicAddress"""))_
    val mainAddress = parse_attribute (attribute ("""Location.mainAddress"""))_
    val phone1 = parse_attribute (attribute ("""Location.phone1"""))_
    val phone2 = parse_attribute (attribute ("""Location.phone2"""))_
    val secondaryAddress = parse_attribute (attribute ("""Location.secondaryAddress"""))_
    val status = parse_attribute (attribute ("""Location.status"""))_
    def parse (context: Context): Location =
    {
        return (
            Location
            (
                IdentifiedObject.parse (context),
                direction (context),
                geoInfoReference (context),
                typ (context),
                CoordinateSystem (context),
                electronicAddress (context),
                mainAddress (context),
                phone1 (context),
                phone2 (context),
                secondaryAddress (context),
                status (context)
            )
        )
    }
}

case class PositionPoint (
    override val sup: Element,
    sequenceNumber: Int,
    xPosition: String,
    yPosition: String,
    zPosition: String,
    Location: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[PositionPoint]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PositionPoint
extends
    Parser
{
    val sequenceNumber = parse_element (element ("""PositionPoint.sequenceNumber"""))_
    val xPosition = parse_element (element ("""PositionPoint.xPosition"""))_
    val yPosition = parse_element (element ("""PositionPoint.yPosition"""))_
    val zPosition = parse_element (element ("""PositionPoint.zPosition"""))_
    // ToDo: fix this; should be attribute
    val Location = parse_element (element ("""PositionPoint.Location"""))_
    def parse (context: Context): PositionPoint =
    {
        return (
            PositionPoint
            (
                Element.parse (context),
                toInteger (sequenceNumber (context), context),
                xPosition (context),
                yPosition (context),
                zPosition (context),
                Location (context)
            )
        )
    }
}

case class WorkLocation
(
    override val sup: Element,
    val OneCallRequest: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[WorkLocation]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WorkLocation
extends
    Parser
{
    val OneCallRequest = parse_element (element ("""WorkLocation.OneCallRequest"""))_
    def parse (context: Context): WorkLocation =
    {
        return (
            WorkLocation
            (
                Location.parse (context),
                OneCallRequest (context)
            )
        )
    }
}

case class ServiceLocation
(
    override val sup: Element,
    val accessMethod: String,
    val needsInspection: Boolean,
    val siteAccessProblem: String
)
extends
    Element (sup)
{
    override def copy (): Row = { return (this.clone ().asInstanceOf[ServiceLocation]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ServiceLocation
extends
    Parser
{
    val accessMethod = parse_element (element ("""ServiceLocation.accessMethod"""))_
    val needsInspection = parse_element (element ("""ServiceLocation.needsInspection"""))_
    val siteAccessProblem = parse_element (element ("""ServiceLocation.siteAccessProblem"""))_
    def parse (context: Context): ServiceLocation =
    {
        return (
            ServiceLocation
            (
                Location.parse (context),
                accessMethod (context),
                toBoolean (needsInspection (context), context),
                siteAccessProblem (context)
            )
        )
    }
}

/**
 * Common Hierarchical Information Model
 * CIM classes for parsing RDF files.
 */
class CHIM (var xml:String, var start: Long = 0L, var end: Long = 0L)
{
    if (end == 0L)
        end = start + xml.length ()
    val matcher = CHIM.rddex.matcher (xml)
    val context = new Context (xml, start, start, ArrayBuffer (0L))
    context.index_string (xml, context.start)

    var value: Element = null;

    def progress (): Float =
    {
        (context.end - context.start).asInstanceOf[Float] / xml.length ().asInstanceOf[Float]
    }

    def parse_one (): Boolean =
    {
        var ret = false
        var found = false
        if (context.end < end)
            while (!found && matcher.find ())
            {
                val name = matcher.group (1)
                // heuristic (along with the while and the 'not a dot' in rddex regular expression)
                // that allows jumping into the middle of a large file:
                // top level RDF elements do not have a period in their name
                if (!name.contains ('.'))
                {
                    context.xml = matcher.group (2)
                    val element = name match
                    {
                        case "cim:UserAttribute" ⇒ UserAttribute.parse (context)
                        case "cim:NameTypeAuthority" ⇒ NameTypeAuthority.parse (context)
                        case "cim:NameType" ⇒ NameType.parse (context)
                        case "cim:StateVariable" ⇒ StateVariable.parse (context)
                        case "cim:SvStatus" ⇒ SvStatus.parse (context)
                        case "cim:IdentifiedObject" ⇒ IdentifiedObject.parse (context)
                        case "cim:PSRType" ⇒ PSRType.parse (context)
                        case "cim:Name" ⇒ Name.parse (context)
                        case "cim:CoordinateSystem" ⇒ CoordinateSystem.parse (context)
                        case "cim:BaseVoltage" ⇒ BaseVoltage.parse (context)
                        case "cim:ConnectivityNode" ⇒ ConnectivityNode.parse (context)
                        case "cim:ACDCTerminal" ⇒ ACDCTerminal.parse (context)
                        case "cim:Terminal" ⇒ Terminal.parse (context)
                        case "cim:PowerSystemResource" ⇒ PowerSystemResource.parse (context)
                        case "cim:ConnectivityNodeContainer" ⇒ ConnectivityNodeContainer.parse (context)
                        case "cim:EquipmentContainer" ⇒ EquipmentContainer.parse (context)
                        case "cim:Line" ⇒ Line.parse (context)
                        case "cim:Substation" ⇒ Substation.parse (context)
                        case "cim:VoltageLevel" ⇒ VoltageLevel.parse (context)
                        case "cim:Bay" ⇒ Bay.parse (context)
                        case "cim:Equipment" ⇒ Equipment.parse (context)
                        case "cim:ConductingEquipment" ⇒ ConductingEquipment.parse (context)
                        case "cim:Connector" ⇒ Connector.parse (context)
                        case "cim:Junction" ⇒ Junction.parse (context)
                        case "cim:EnergyConsumer" ⇒ EnergyConsumer.parse (context)
                        case "cim:Conductor" ⇒ Conductor.parse (context)
                        case "cim:ACLineSegment" ⇒ ACLineSegment.parse (context)
                        case "cim:BusbarSection" ⇒ BusbarSection.parse (context)
                        case "cim:Switch" ⇒ Switch.parse (context)
                        case "cim:Fuse" ⇒ Fuse.parse (context)
                        case "cim:Disconnector" ⇒ Disconnector.parse (context)
                        case "cim:GeneratingUnit" ⇒ GeneratingUnit.parse (context)
                        case "cim:SolarGeneratingUnit" ⇒ SolarGeneratingUnit.parse (context)
                        case "cim:TransformerTank" ⇒ TransformerTank.parse (context)
                        case "cim:TransformerEnd" ⇒ TransformerEnd.parse (context)
                        case "cim:PowerTransformerEnd" ⇒ PowerTransformerEnd.parse (context)
                        case "cim:TransformerTankEnd" ⇒ TransformerTankEnd.parse (context)
                        case "cim:PowerTransformer" ⇒ PowerTransformer.parse (context)
                        case "cim:Location" ⇒ Location.parse (context)
                        case "cim:PositionPoint" ⇒ PositionPoint.parse (context)
                        case "cim:WorkLocation" ⇒ WorkLocation.parse (context)
                        case "cim:ServiceLocation" ⇒ ServiceLocation.parse (context)

                        case _ ⇒
                        {
                            if ((context.DEBUG) && (context.errors.size < context.MAXERRORS))
                                context.errors += "Unknown element \"" + name + "\" at line " + context.line_number ()
                            Unknown.parse (context)
                        }
                    }
                    value = element

                    // return success unless there was unrecognized text before the match
                    // that wasn't at the start of the xml
                    ret = (context.end == (matcher.start () + context.start)) || (context.end == context.start)
                    // or there is non-whitespace not covered
//                    if (context.DEBUG)
//                        ret &= context.covered ()

                    // set up for next parse
                    context.end = matcher.end () + context.start
                    context.coverage.clear ()
                    found = true
                }
            }

        return (ret)
    }

    def parse (): HashMap[String, Element] =
    {
        val ret = HashMap[String, Element] ()
        while (parse_one ())
            ret.put (value.key, value)

        return (ret)
    }
}

object CHIM
{
    val CHUNK = 1024*1024*128
    val OVERREAD = 2048 // should be large enough that no RDF element is bigger than this
    val rddex = Pattern.compile ("""\s*<(cim:[^>\.\s]+)([>\s][\s\S]*?)<\/\1>\s*""") // important to consume leading and trailing whitespace

    def read (filename: String, offset: Long, size: Long = CHUNK, overread: Long = OVERREAD): String =
    {
        var ret: String = null

        val file = new File (filename)
        if (file.exists ()) // avoid FileNotFoundException
        {
            val fis = new FileInputStream (file)
            val isr = new InputStreamReader (fis, "UTF8")
            val skipped = isr.skip (offset)
            if (offset == skipped)
            {
                val buf = new Array[Char] (CHUNK)
                val sint: Int = if (size > Int.MaxValue) Int.MaxValue else size.asInstanceOf[Int]
                val sb = new StringBuilder (sint)
                var count:Long = 0
                var stop = false
                do
                {
                    val max = size + overread - count
                    val actual = isr.read (buf, 0, if (max > CHUNK) CHUNK else max.asInstanceOf[Int])
                    if (0 < actual)
                    {
                        sb.appendAll (buf, 0, actual)
                        count += actual
                    }
                    else
                        stop = true
                }
                while (!stop && (count < size + overread))
                isr.close ()
                ret = sb.toString ()
            }
            else
                println ("CIM XML input file cannot be skipped to offset " + offset + ", actual " + skipped)
        }
        else
            println ("CIM XML input file '" + filename + "' not found")

        return (ret)
    }

    /**
     * Main program for testing purposes.
     */
    def main (args: Array[String])
    {
        if (args.size > 0)
        {
            val filename = args (0)
            val fis = new FileInputStream (filename)
            val size = fis.available ()
            fis.close ();

            val result = new HashMap[String, Element]
            var offset = 0L
            var reading = 0.0
            var parsing = 0.0
            while (offset < size)
            {
                val start = System.nanoTime
                var xml = read (filename, offset)
                offset += CHUNK
                val before = System.nanoTime
                reading += (before - start) / 1000

                val parser = new CHIM (xml)
                xml = null
                val map = parser.parse ()
                //result ++= map

                val after = System.nanoTime
                parsing += (after - before) / 1000
                print (".")

                for (error <- parser.context.errors)
                    println (error)
            }
            println ()

            println ("reading %g seconds".format (reading / 1e6))
            println ("parsing %g seconds".format (parsing / 1e6))
            println (result.size + " identified elements parsed")
            val subset = result.filter (_._2.getClass() == classOf[Unknown])
            println (subset.size + " unknown elements")
        }
        else
            println ("CIM XML input file not specified")
    }
}

package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.Context

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


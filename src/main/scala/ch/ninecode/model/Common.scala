package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.Context

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
    Parseable[CoordinateSystem]
with
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
    Parseable[Location]
with
    Parser
{
    val direction = parse_element (element ("""Location.direction"""))_
    val geoInfoReference = parse_element (element ("""Location.geoInfoReference"""))_
    val typ = parse_element (element ("""Location.type"""))_
    val CoordinateSystem = parse_attribute (attribute ("""Location.CoordinateSystem"""))_
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
    Parseable[PositionPoint]
with
    Parser
{
    val sequenceNumber = parse_element (element ("""PositionPoint.sequenceNumber"""))_
    val xPosition = parse_element (element ("""PositionPoint.xPosition"""))_
    val yPosition = parse_element (element ("""PositionPoint.yPosition"""))_
    val zPosition = parse_element (element ("""PositionPoint.zPosition"""))_
    val Location = parse_attribute (attribute ("""PositionPoint.Location"""))_
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
    Parseable[UserAttribute]
with
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

object Common
{
    def register: Unit =
    {
        CoordinateSystem.register
        Location.register
        PositionPoint.register
        UserAttribute.register
    }
}

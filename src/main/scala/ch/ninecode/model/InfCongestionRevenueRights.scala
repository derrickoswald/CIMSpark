package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context


/**
 * Financial Transmission Rights (FTR) regarding transmission capacity at a flowgate.
 * @param sup Reference to the superclass object.
 * @param action Buy, Sell
 * @param baseEnergy Quantity, typically MWs - Seller owns all rights being offered, MWs over time on same Point of Receipt, Point of Delivery, or Resource.
 * @param ftrType Type of rights being offered (product) allowed to be auctioned (option, obligation).
 * @param optimized Fixed (covers re-configuration, grandfathering) or Optimized (up for sale/purchase
 * @param EnergyPriceCurve
 * @param Flowgate
 * @param Pnodes
 * @param _class Peak, Off-peak, 24-hour
 */
case class FTR
(override val sup: Agreement,
val action: String,
val baseEnergy: Double,
val ftrType: String,
val optimized: String,
val EnergyPriceCurve: String,
val Flowgate: String,
val Pnodes: List[String],
val _class: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, null, null, null, null, List(), null) }
    def Agreement: Agreement = sup.asInstanceOf[Agreement]
    override def copy (): Row = { return (clone ().asInstanceOf[FTR]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FTR
extends
    Parseable[FTR]
{
    val sup = Agreement.parse _
    val action = parse_element (element ("""FTR.action"""))_
    val baseEnergy = parse_element (element ("""FTR.baseEnergy"""))_
    val ftrType = parse_element (element ("""FTR.ftrType"""))_
    val optimized = parse_element (element ("""FTR.optimized"""))_
    val EnergyPriceCurve = parse_attribute (attribute ("""FTR.EnergyPriceCurve"""))_
    val Flowgate = parse_attribute (attribute ("""FTR.Flowgate"""))_
    val Pnodes = parse_attributes (attribute ("""FTR.Pnodes"""))_
    val _class = parse_element (element ("""FTR.class"""))_
    def parse (context: Context): FTR =
    {
        FTR(
            sup (context),
            action (context),
            toDouble (baseEnergy (context), context),
            ftrType (context),
            optimized (context),
            EnergyPriceCurve (context),
            Flowgate (context),
            Pnodes (context),
            _class (context)
        )
    }
}

/**
 * A type of limit that indicates if it is enforced and, through association, the organisation responsible for setting the limit.
 * @param sup Reference to the superclass object.
 * @param enforced True if limit is enforced.
 * @param Flowgate
 * @param MktMeasurement
 * @param MktOrganisation
 */
case class ViolationLimit
(override val sup: Limit,
val enforced: Boolean,
val Flowgate: String,
val MktMeasurement: String,
val MktOrganisation: List[String]
)
extends
    Element
{
    def this () = { this (null, false, null, null, List()) }
    def Limit: Limit = sup.asInstanceOf[Limit]
    override def copy (): Row = { return (clone ().asInstanceOf[ViolationLimit]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ViolationLimit
extends
    Parseable[ViolationLimit]
{
    val sup = Limit.parse _
    val enforced = parse_element (element ("""ViolationLimit.enforced"""))_
    val Flowgate = parse_attribute (attribute ("""ViolationLimit.Flowgate"""))_
    val MktMeasurement = parse_attribute (attribute ("""ViolationLimit.MktMeasurement"""))_
    val MktOrganisation = parse_attributes (attribute ("""ViolationLimit.MktOrganisation"""))_
    def parse (context: Context): ViolationLimit =
    {
        ViolationLimit(
            sup (context),
            toBoolean (enforced (context), context),
            Flowgate (context),
            MktMeasurement (context),
            MktOrganisation (context)
        )
    }
}

object _InfCongestionRevenueRights
{
    def register: Unit =
    {
        FTR.register
        ViolationLimit.register
    }
}
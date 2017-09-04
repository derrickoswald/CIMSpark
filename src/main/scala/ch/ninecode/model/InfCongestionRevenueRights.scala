package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * Financial Transmission Rights (FTR) regarding transmission capacity at a flowgate.
 *
 * @param sup [[ch.ninecode.model.Agreement Agreement]] Reference to the superclass object.
 * @param action Buy, Sell
 * @param baseEnergy Quantity, typically MWs - Seller owns all rights being offered, MWs over time on same Point of Receipt, Point of Delivery, or Resource.
 * @param ftrType Type of rights being offered (product) allowed to be auctioned (option, obligation).
 * @param optimized Fixed (covers re-configuration, grandfathering) or Optimized (up for sale/purchase
 * @param EnergyPriceCurve [[ch.ninecode.model.EnergyPriceCurve EnergyPriceCurve]] <em>undocumented</em>
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param Pnodes <em>undocumented</em>
 * @param _class Peak, Off-peak, 24-hour
 * @group InfCongestionRevenueRights
 * @groupname InfCongestionRevenueRights Package InfCongestionRevenueRights
 */
case class FTR
(
    override val sup: Agreement,
    action: String,
    baseEnergy: Double,
    ftrType: String,
    optimized: String,
    EnergyPriceCurve: String,
    Flowgate: String,
    Pnodes: List[String],
    _class: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, null, null, null, null, List(), null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Agreement: Agreement = sup.asInstanceOf[Agreement]
    override def copy (): Row = { clone ().asInstanceOf[FTR] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        (if (null != action) "\t\t<cim:FTR.action>" + action + "</cim:FTR.action>\n" else "") +
        "\t\t<cim:FTR.baseEnergy>" + baseEnergy + "</cim:FTR.baseEnergy>\n" +
        (if (null != ftrType) "\t\t<cim:FTR.ftrType>" + ftrType + "</cim:FTR.ftrType>\n" else "") +
        (if (null != optimized) "\t\t<cim:FTR.optimized>" + optimized + "</cim:FTR.optimized>\n" else "") +
        (if (null != EnergyPriceCurve) "\t\t<cim:FTR.EnergyPriceCurve rdf:resource=\"#" + EnergyPriceCurve + "\"/>\n" else "") +
        (if (null != Flowgate) "\t\t<cim:FTR.Flowgate rdf:resource=\"#" + Flowgate + "\"/>\n" else "") +
        (if (null != Pnodes) Pnodes.map (x => "\t\t<cim:FTR.Pnodes rdf:resource=\"#" + x + "\"/>\n").mkString else "") +
        (if (null != _class) "\t\t<cim:FTR.class>" + _class + "</cim:FTR.class>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:FTR rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FTR>"
    }
}

object FTR
extends
    Parseable[FTR]
{
    val action = parse_element (element ("""FTR.action"""))
    val baseEnergy = parse_element (element ("""FTR.baseEnergy"""))
    val ftrType = parse_element (element ("""FTR.ftrType"""))
    val optimized = parse_element (element ("""FTR.optimized"""))
    val EnergyPriceCurve = parse_attribute (attribute ("""FTR.EnergyPriceCurve"""))
    val Flowgate = parse_attribute (attribute ("""FTR.Flowgate"""))
    val Pnodes = parse_attributes (attribute ("""FTR.Pnodes"""))
    val _class = parse_element (element ("""FTR.class"""))
    def parse (context: Context): FTR =
    {
        FTR(
            Agreement.parse (context),
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
 *
 * @param sup [[ch.ninecode.model.Limit Limit]] Reference to the superclass object.
 * @param enforced True if limit is enforced.
 * @param Flowgate [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param MktMeasurement [[ch.ninecode.model.MktMeasurement MktMeasurement]] <em>undocumented</em>
 * @param MktOrganisation [[ch.ninecode.model.MktOrganisation MktOrganisation]] <em>undocumented</em>
 * @group InfCongestionRevenueRights
 * @groupname InfCongestionRevenueRights Package InfCongestionRevenueRights
 */
case class ViolationLimit
(
    override val sup: Limit,
    enforced: Boolean,
    Flowgate: String,
    MktMeasurement: String,
    MktOrganisation: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, false, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Limit: Limit = sup.asInstanceOf[Limit]
    override def copy (): Row = { clone ().asInstanceOf[ViolationLimit] }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        sup.export_fields +
        "\t\t<cim:ViolationLimit.enforced>" + enforced + "</cim:ViolationLimit.enforced>\n" +
        (if (null != Flowgate) "\t\t<cim:ViolationLimit.Flowgate rdf:resource=\"#" + Flowgate + "\"/>\n" else "") +
        (if (null != MktMeasurement) "\t\t<cim:ViolationLimit.MktMeasurement rdf:resource=\"#" + MktMeasurement + "\"/>\n" else "") +
        (if (null != MktOrganisation) MktOrganisation.map (x => "\t\t<cim:ViolationLimit.MktOrganisation rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:ViolationLimit rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ViolationLimit>"
    }
}

object ViolationLimit
extends
    Parseable[ViolationLimit]
{
    val enforced = parse_element (element ("""ViolationLimit.enforced"""))
    val Flowgate = parse_attribute (attribute ("""ViolationLimit.Flowgate"""))
    val MktMeasurement = parse_attribute (attribute ("""ViolationLimit.MktMeasurement"""))
    val MktOrganisation = parse_attributes (attribute ("""ViolationLimit.MktOrganisation"""))
    def parse (context: Context): ViolationLimit =
    {
        ViolationLimit(
            Limit.parse (context),
            toBoolean (enforced (context), context),
            Flowgate (context),
            MktMeasurement (context),
            MktOrganisation (context)
        )
    }
}

private[ninecode] object _InfCongestionRevenueRights
{
    def register: List[ClassInfo] =
    {
        List (
            FTR.register,
            ViolationLimit.register
        )
    }
}
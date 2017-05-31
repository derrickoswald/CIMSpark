package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context


/**
 * Requirements for minimum amount of reserve and/or regulation to be supplied by a set of qualified resources.
 * @param sup Reference to the superclass object.
 * @param MarketProduct Market product associated with reserve requirement must be a reserve or regulation product.
 * @param ReserveReqCurve
 * @param SensitivityPriceCurve
 */
case class ReserveReq
(
    override val sup: ResourceGroupReq,
    val MarketProduct: String,
    val ReserveReqCurve: String,
    val SensitivityPriceCurve: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def ResourceGroupReq: ResourceGroupReq = sup.asInstanceOf[ResourceGroupReq]
    override def copy (): Row = { return (clone ().asInstanceOf[ReserveReq]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ReserveReq
extends
    Parseable[ReserveReq]
{
    val sup = ResourceGroupReq.parse _
    val MarketProduct = parse_attribute (attribute ("""ReserveReq.MarketProduct"""))
    val ReserveReqCurve = parse_attribute (attribute ("""ReserveReq.ReserveReqCurve"""))
    val SensitivityPriceCurve = parse_attribute (attribute ("""ReserveReq.SensitivityPriceCurve"""))
    def parse (context: Context): ReserveReq =
    {
        ReserveReq(
            sup (context),
            MarketProduct (context),
            ReserveReqCurve (context),
            SensitivityPriceCurve (context)
        )
    }
}

/**
 * A curve relating  reserve requirement versus time, showing the values of a specific reserve requirement for each unit of the period covered.
 * The  curve can be based on "absolute" time or on "normalized' time.
 * @param sup Reference to the superclass object.
 * @param ReserveReq
 */
case class ReserveReqCurve
(
    override val sup: Curve,
    val ReserveReq: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[ReserveReqCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ReserveReqCurve
extends
    Parseable[ReserveReqCurve]
{
    val sup = Curve.parse _
    val ReserveReq = parse_attribute (attribute ("""ReserveReqCurve.ReserveReq"""))
    def parse (context: Context): ReserveReqCurve =
    {
        ReserveReqCurve(
            sup (context),
            ReserveReq (context)
        )
    }
}

/**
 * A logical grouping of resources that are used to model location of types of requirements for ancillary services such as spinning reserve zones, regulation zones, etc.
 * @param sup Reference to the superclass object.
 * @param status Status of this group.
 * @param typ Type of this group.
 */
case class ResourceGroup
(
    override val sup: IdentifiedObject,
    val status: String,
    val typ: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ResourceGroup]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ResourceGroup
extends
    Parseable[ResourceGroup]
{
    val sup = IdentifiedObject.parse _
    val status = parse_attribute (attribute ("""ResourceGroup.status"""))
    val typ = parse_element (element ("""ResourceGroup.type"""))
    def parse (context: Context): ResourceGroup =
    {
        ResourceGroup(
            sup (context),
            status (context),
            typ (context)
        )
    }
}

/**
 * Ancillary service requirements for a market.
 * @param sup Reference to the superclass object.
 * @param RTOs
 * @param ResourceGroup
 */
case class ResourceGroupReq
(
    override val sup: IdentifiedObject,
    val RTOs: List[String],
    val ResourceGroup: String
)
extends
    Element
{
    def this () = { this (null, List(), null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[ResourceGroupReq]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ResourceGroupReq
extends
    Parseable[ResourceGroupReq]
{
    val sup = IdentifiedObject.parse _
    val RTOs = parse_attributes (attribute ("""ResourceGroupReq.RTOs"""))
    val ResourceGroup = parse_attribute (attribute ("""ResourceGroupReq.ResourceGroup"""))
    def parse (context: Context): ResourceGroupReq =
    {
        ResourceGroupReq(
            sup (context),
            RTOs (context),
            ResourceGroup (context)
        )
    }
}

/**
 * Optionally, this curve expresses elasticity of the associated requirement.
 * For example, used to reduce requirements when clearing price exceeds reasonable values when the supply quantity becomes scarce. For example, a single point value of $1000/MW for a spinning reserve will cause a reduction in the required spinning reserve.
 * @param sup Reference to the superclass object.
 * @param ReserveReq
 */
case class SensitivityPriceCurve
(
    override val sup: Curve,
    val ReserveReq: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Curve: Curve = sup.asInstanceOf[Curve]
    override def copy (): Row = { return (clone ().asInstanceOf[SensitivityPriceCurve]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SensitivityPriceCurve
extends
    Parseable[SensitivityPriceCurve]
{
    val sup = Curve.parse _
    val ReserveReq = parse_attribute (attribute ("""SensitivityPriceCurve.ReserveReq"""))
    def parse (context: Context): SensitivityPriceCurve =
    {
        SensitivityPriceCurve(
            sup (context),
            ReserveReq (context)
        )
    }
}

object _InfExternalInputs
{
    def register: Unit =
    {
        ReserveReq.register
        ReserveReqCurve.register
        ResourceGroup.register
        ResourceGroupReq.register
        SensitivityPriceCurve.register
    }
}
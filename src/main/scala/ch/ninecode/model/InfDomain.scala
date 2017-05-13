package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context


case class ADSInstructionTypeCommitment
(

    override val sup: BasicElement,

    val SHUT_DOWN: String,

    val START_UP: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ADSInstructionTypeCommitment]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ADSInstructionTypeCommitment
extends
    Parseable[ADSInstructionTypeCommitment]
{
    val sup = BasicElement.parse _
    val SHUT_DOWN = parse_attribute (attribute ("""ADSInstructionTypeCommitment.SHUT_DOWN"""))_
    val START_UP = parse_attribute (attribute ("""ADSInstructionTypeCommitment.START_UP"""))_
    def parse (context: Context): ADSInstructionTypeCommitment =
    {
        ADSInstructionTypeCommitment(
            sup (context),
            SHUT_DOWN (context),
            START_UP (context)
        )
    }
}

/**
 * MIN_CONSTRAINT
MAX_CONSTRAINT
 * FIXED_CONSTRAINT
 */
case class ADSInstructionTypeOOS
(

    override val sup: BasicElement,

    val FIXED_CONSTRAINT: String,

    val MAX_CONSTRAINT: String,

    val MIN_CONSTRAINT: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ADSInstructionTypeOOS]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ADSInstructionTypeOOS
extends
    Parseable[ADSInstructionTypeOOS]
{
    val sup = BasicElement.parse _
    val FIXED_CONSTRAINT = parse_attribute (attribute ("""ADSInstructionTypeOOS.FIXED_CONSTRAINT"""))_
    val MAX_CONSTRAINT = parse_attribute (attribute ("""ADSInstructionTypeOOS.MAX_CONSTRAINT"""))_
    val MIN_CONSTRAINT = parse_attribute (attribute ("""ADSInstructionTypeOOS.MIN_CONSTRAINT"""))_
    def parse (context: Context): ADSInstructionTypeOOS =
    {
        ADSInstructionTypeOOS(
            sup (context),
            FIXED_CONSTRAINT (context),
            MAX_CONSTRAINT (context),
            MIN_CONSTRAINT (context)
        )
    }
}

/**
 * BASELI NE
 * NEGOTIATED
 */
case class AdderType
(

    override val sup: BasicElement,

    val BASELINE: String,

    val NEGOTIATED: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AdderType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AdderType
extends
    Parseable[AdderType]
{
    val sup = BasicElement.parse _
    val BASELINE = parse_attribute (attribute ("""AdderType.BASELINE"""))_
    val NEGOTIATED = parse_attribute (attribute ("""AdderType.NEGOTIATED"""))_
    def parse (context: Context): AdderType =
    {
        AdderType(
            sup (context),
            BASELINE (context),
            NEGOTIATED (context)
        )
    }
}

case class AlarmDisplayType
(

    override val sup: BasicElement,

    val Appear: String,

    val Disappear: String,

    val Fleeting: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AlarmDisplayType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AlarmDisplayType
extends
    Parseable[AlarmDisplayType]
{
    val sup = BasicElement.parse _
    val Appear = parse_attribute (attribute ("""AlarmDisplayType.Appear"""))_
    val Disappear = parse_attribute (attribute ("""AlarmDisplayType.Disappear"""))_
    val Fleeting = parse_attribute (attribute ("""AlarmDisplayType.Fleeting"""))_
    def parse (context: Context): AlarmDisplayType =
    {
        AlarmDisplayType(
            sup (context),
            Appear (context),
            Disappear (context),
            Fleeting (context)
        )
    }
}

case class AllocationEnergyTypeCode
(

    override val sup: BasicElement,

    val ACNG: String,

    val BS: String,

    val DAPE: String,

    val DASE: String,

    val ESRT: String,

    val ESYS: String,

    val ETC: String,

    val HASE: String,

    val LMPM: String,

    val MINL: String,

    val MLE: String,

    val MSSLFE: String,

    val OE: String,

    val OTHER: String,

    val OVGN: String,

    val PE: String,

    val RCNG: String,

    val RE: String,

    val RED: String,

    val RMRD: String,

    val RMRH: String,

    val RMRR: String,

    val RMRS: String,

    val RMRT: String,

    val RSYS: String,

    val RTSSE: String,

    val SDWN: String,

    val SE: String,

    val SLIC: String,

    val SRE: String,

    val STRT: String,

    val SUMR: String,

    val TCNG: String,

    val TEST: String,

    val TOR: String,

    val VS: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AllocationEnergyTypeCode]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AllocationEnergyTypeCode
extends
    Parseable[AllocationEnergyTypeCode]
{
    val sup = BasicElement.parse _
    val ACNG = parse_attribute (attribute ("""AllocationEnergyTypeCode.ACNG"""))_
    val BS = parse_attribute (attribute ("""AllocationEnergyTypeCode.BS"""))_
    val DAPE = parse_attribute (attribute ("""AllocationEnergyTypeCode.DAPE"""))_
    val DASE = parse_attribute (attribute ("""AllocationEnergyTypeCode.DASE"""))_
    val ESRT = parse_attribute (attribute ("""AllocationEnergyTypeCode.ESRT"""))_
    val ESYS = parse_attribute (attribute ("""AllocationEnergyTypeCode.ESYS"""))_
    val ETC = parse_attribute (attribute ("""AllocationEnergyTypeCode.ETC"""))_
    val HASE = parse_attribute (attribute ("""AllocationEnergyTypeCode.HASE"""))_
    val LMPM = parse_attribute (attribute ("""AllocationEnergyTypeCode.LMPM"""))_
    val MINL = parse_attribute (attribute ("""AllocationEnergyTypeCode.MINL"""))_
    val MLE = parse_attribute (attribute ("""AllocationEnergyTypeCode.MLE"""))_
    val MSSLFE = parse_attribute (attribute ("""AllocationEnergyTypeCode.MSSLFE"""))_
    val OE = parse_attribute (attribute ("""AllocationEnergyTypeCode.OE"""))_
    val OTHER = parse_attribute (attribute ("""AllocationEnergyTypeCode.OTHER"""))_
    val OVGN = parse_attribute (attribute ("""AllocationEnergyTypeCode.OVGN"""))_
    val PE = parse_attribute (attribute ("""AllocationEnergyTypeCode.PE"""))_
    val RCNG = parse_attribute (attribute ("""AllocationEnergyTypeCode.RCNG"""))_
    val RE = parse_attribute (attribute ("""AllocationEnergyTypeCode.RE"""))_
    val RED = parse_attribute (attribute ("""AllocationEnergyTypeCode.RED"""))_
    val RMRD = parse_attribute (attribute ("""AllocationEnergyTypeCode.RMRD"""))_
    val RMRH = parse_attribute (attribute ("""AllocationEnergyTypeCode.RMRH"""))_
    val RMRR = parse_attribute (attribute ("""AllocationEnergyTypeCode.RMRR"""))_
    val RMRS = parse_attribute (attribute ("""AllocationEnergyTypeCode.RMRS"""))_
    val RMRT = parse_attribute (attribute ("""AllocationEnergyTypeCode.RMRT"""))_
    val RSYS = parse_attribute (attribute ("""AllocationEnergyTypeCode.RSYS"""))_
    val RTSSE = parse_attribute (attribute ("""AllocationEnergyTypeCode.RTSSE"""))_
    val SDWN = parse_attribute (attribute ("""AllocationEnergyTypeCode.SDWN"""))_
    val SE = parse_attribute (attribute ("""AllocationEnergyTypeCode.SE"""))_
    val SLIC = parse_attribute (attribute ("""AllocationEnergyTypeCode.SLIC"""))_
    val SRE = parse_attribute (attribute ("""AllocationEnergyTypeCode.SRE"""))_
    val STRT = parse_attribute (attribute ("""AllocationEnergyTypeCode.STRT"""))_
    val SUMR = parse_attribute (attribute ("""AllocationEnergyTypeCode.SUMR"""))_
    val TCNG = parse_attribute (attribute ("""AllocationEnergyTypeCode.TCNG"""))_
    val TEST = parse_attribute (attribute ("""AllocationEnergyTypeCode.TEST"""))_
    val TOR = parse_attribute (attribute ("""AllocationEnergyTypeCode.TOR"""))_
    val VS = parse_attribute (attribute ("""AllocationEnergyTypeCode.VS"""))_
    def parse (context: Context): AllocationEnergyTypeCode =
    {
        AllocationEnergyTypeCode(
            sup (context),
            ACNG (context),
            BS (context),
            DAPE (context),
            DASE (context),
            ESRT (context),
            ESYS (context),
            ETC (context),
            HASE (context),
            LMPM (context),
            MINL (context),
            MLE (context),
            MSSLFE (context),
            OE (context),
            OTHER (context),
            OVGN (context),
            PE (context),
            RCNG (context),
            RE (context),
            RED (context),
            RMRD (context),
            RMRH (context),
            RMRR (context),
            RMRS (context),
            RMRT (context),
            RSYS (context),
            RTSSE (context),
            SDWN (context),
            SE (context),
            SLIC (context),
            SRE (context),
            STRT (context),
            SUMR (context),
            TCNG (context),
            TEST (context),
            TOR (context),
            VS (context)
        )
    }
}

/**
 * ancillary serivce types
 */
case class AncillaryCommodityType
(

    override val sup: BasicElement,

    /**
     * non spinning reserve
     */
    val NONSPIN: String,

    /**
     * regulation down
     */
    val REGDN: String,

    /**
     * regulation up
     */
    val REGUP: String,

    /**
     * spinning reserve
     */
    val SPIN: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AncillaryCommodityType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AncillaryCommodityType
extends
    Parseable[AncillaryCommodityType]
{
    val sup = BasicElement.parse _
    val NONSPIN = parse_attribute (attribute ("""AncillaryCommodityType.NONSPIN"""))_
    val REGDN = parse_attribute (attribute ("""AncillaryCommodityType.REGDN"""))_
    val REGUP = parse_attribute (attribute ("""AncillaryCommodityType.REGUP"""))_
    val SPIN = parse_attribute (attribute ("""AncillaryCommodityType.SPIN"""))_
    def parse (context: Context): AncillaryCommodityType =
    {
        AncillaryCommodityType(
            sup (context),
            NONSPIN (context),
            REGDN (context),
            REGUP (context),
            SPIN (context)
        )
    }
}

case class BidPriceCapType
(

    override val sup: BasicElement,

    val AS: String,

    val ENERGY: String,

    val RUC: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[BidPriceCapType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BidPriceCapType
extends
    Parseable[BidPriceCapType]
{
    val sup = BasicElement.parse _
    val AS = parse_attribute (attribute ("""BidPriceCapType.AS"""))_
    val ENERGY = parse_attribute (attribute ("""BidPriceCapType.ENERGY"""))_
    val RUC = parse_attribute (attribute ("""BidPriceCapType.RUC"""))_
    def parse (context: Context): BidPriceCapType =
    {
        BidPriceCapType(
            sup (context),
            AS (context),
            ENERGY (context),
            RUC (context)
        )
    }
}

/**
 * Status indication for bids

CV - Conditionally Valid Bid
CM - Conditionally Modified Bid
V - Valid Bid
M - Modified Bid
RJ - Rejected Bid
I - Invalid Bid
CX - Cancelled Bid
O - Obsolete Bid
CL - Clean Bid
 * RP - Replicated Bid
 */
case class BidStatusType
(

    override val sup: BasicElement,

    /**
     * Clean
     */
    val CL: String,

    val CM: String,

    val CV: String,

    val CX: String,

    val I: String,

    val M: String,

    val O: String,

    val RJ: String,

    /**
     * Replicated
     */
    val RP: String,

    val V: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[BidStatusType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BidStatusType
extends
    Parseable[BidStatusType]
{
    val sup = BasicElement.parse _
    val CL = parse_attribute (attribute ("""BidStatusType.CL"""))_
    val CM = parse_attribute (attribute ("""BidStatusType.CM"""))_
    val CV = parse_attribute (attribute ("""BidStatusType.CV"""))_
    val CX = parse_attribute (attribute ("""BidStatusType.CX"""))_
    val I = parse_attribute (attribute ("""BidStatusType.I"""))_
    val M = parse_attribute (attribute ("""BidStatusType.M"""))_
    val O = parse_attribute (attribute ("""BidStatusType.O"""))_
    val RJ = parse_attribute (attribute ("""BidStatusType.RJ"""))_
    val RP = parse_attribute (attribute ("""BidStatusType.RP"""))_
    val V = parse_attribute (attribute ("""BidStatusType.V"""))_
    def parse (context: Context): BidStatusType =
    {
        BidStatusType(
            sup (context),
            CL (context),
            CM (context),
            CV (context),
            CX (context),
            I (context),
            M (context),
            O (context),
            RJ (context),
            RP (context),
            V (context)
        )
    }
}

case class CleanTradeProductType
(

    override val sup: BasicElement,

    /**
     * Energy Trades at Aggregated Pricing Nodes
     */
    val APN: String,

    /**
     * Converted Physical Energy Trade
     */
    val CPT: String,

    /**
     * Non-Spinning Reserve Trade
     */
    val NRT: String,

    /**
     * Physical Energy Tra
     */
    val PHY: String,

    /**
     * Regulation Down Trade
     */
    val RDT: String,

    /**
     * Regulation Up Trade
     */
    val RUT: String,

    /**
     * Spinning Reserve Trade
     */
    val SRT: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[CleanTradeProductType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CleanTradeProductType
extends
    Parseable[CleanTradeProductType]
{
    val sup = BasicElement.parse _
    val APN = parse_attribute (attribute ("""CleanTradeProductType.APN"""))_
    val CPT = parse_attribute (attribute ("""CleanTradeProductType.CPT"""))_
    val NRT = parse_attribute (attribute ("""CleanTradeProductType.NRT"""))_
    val PHY = parse_attribute (attribute ("""CleanTradeProductType.PHY"""))_
    val RDT = parse_attribute (attribute ("""CleanTradeProductType.RDT"""))_
    val RUT = parse_attribute (attribute ("""CleanTradeProductType.RUT"""))_
    val SRT = parse_attribute (attribute ("""CleanTradeProductType.SRT"""))_
    def parse (context: Context): CleanTradeProductType =
    {
        CleanTradeProductType(
            sup (context),
            APN (context),
            CPT (context),
            NRT (context),
            PHY (context),
            RDT (context),
            RUT (context),
            SRT (context)
        )
    }
}

/**
 * ACTIVE
 * INACTIVE
 */
case class CurrentStatusSC
(

    override val sup: BasicElement,

    val ACTIVE: String,

    val INACTIVE: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[CurrentStatusSC]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CurrentStatusSC
extends
    Parseable[CurrentStatusSC]
{
    val sup = BasicElement.parse _
    val ACTIVE = parse_attribute (attribute ("""CurrentStatusSC.ACTIVE"""))_
    val INACTIVE = parse_attribute (attribute ("""CurrentStatusSC.INACTIVE"""))_
    def parse (context: Context): CurrentStatusSC =
    {
        CurrentStatusSC(
            sup (context),
            ACTIVE (context),
            INACTIVE (context)
        )
    }
}

case class DAMMarketType
(

    override val sup: BasicElement,

    val DAM: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[DAMMarketType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DAMMarketType
extends
    Parseable[DAMMarketType]
{
    val sup = BasicElement.parse _
    val DAM = parse_attribute (attribute ("""DAMMarketType.DAM"""))_
    def parse (context: Context): DAMMarketType =
    {
        DAMMarketType(
            sup (context),
            DAM (context)
        )
    }
}

case class DispatchAcceptStatus
(

    override val sup: BasicElement,

    val ACCEPT: String,

    val CANNOT: String,

    val DECLINE: String,

    val NON_RESPONSE: String,

    val OK: String,

    val PARTIAL: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[DispatchAcceptStatus]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DispatchAcceptStatus
extends
    Parseable[DispatchAcceptStatus]
{
    val sup = BasicElement.parse _
    val ACCEPT = parse_attribute (attribute ("""DispatchAcceptStatus.ACCEPT"""))_
    val CANNOT = parse_attribute (attribute ("""DispatchAcceptStatus.CANNOT"""))_
    val DECLINE = parse_attribute (attribute ("""DispatchAcceptStatus.DECLINE"""))_
    val NON_RESPONSE = parse_attribute (attribute ("""DispatchAcceptStatus.NON_RESPONSE"""))_
    val OK = parse_attribute (attribute ("""DispatchAcceptStatus.OK"""))_
    val PARTIAL = parse_attribute (attribute ("""DispatchAcceptStatus.PARTIAL"""))_
    def parse (context: Context): DispatchAcceptStatus =
    {
        DispatchAcceptStatus(
            sup (context),
            ACCEPT (context),
            CANNOT (context),
            DECLINE (context),
            NON_RESPONSE (context),
            OK (context),
            PARTIAL (context)
        )
    }
}

case class DispatchTransactionType
(

    override val sup: BasicElement,

    val Purchase: String,

    val Sale: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[DispatchTransactionType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DispatchTransactionType
extends
    Parseable[DispatchTransactionType]
{
    val sup = BasicElement.parse _
    val Purchase = parse_attribute (attribute ("""DispatchTransactionType.Purchase"""))_
    val Sale = parse_attribute (attribute ("""DispatchTransactionType.Sale"""))_
    def parse (context: Context): DispatchTransactionType =
    {
        DispatchTransactionType(
            sup (context),
            Purchase (context),
            Sale (context)
        )
    }
}

/**
 * Valid Enumerations:
1) DASE Day Ahead Scheduled Energy; 
2) DSSE Day Ahead Incremental Self Schedule Energy; 
3) DABE Day Ahead Incremental Energy Bid Awarded Energy; 
4) OE Optimal Energy; 
5) HASE Hour ahead pre-dispatched schedule energy; 
6) SRE Standard Ramping Energy; 
7) RED Ramping Energy Deviation; 
8) EDE Exceptional Dispatch energy; 
9) RMRE RMR Energy; 
10) MSSLFE MSSLF Energy; 
11) RE Residual Energy; 
12) MLE Minimum Load Energy; 
13) SE SLIC Energy; 
14) RTSSE Real time self scheduled energy; 
15) DMLE Day ahead minimum load energy; 
16) PE Pumping Energy; 
17) TEE Total Expected Energy;
 * 18) DAPE - Day-Ahead Pumping Energy;
 */
case class EnergyTypeCode
(

    override val sup: BasicElement,

    val DABE: String,

    val DAPE: String,

    val DASE: String,

    val DMLE: String,

    val DSSE: String,

    val EDE: String,

    val HASE: String,

    val MLE: String,

    val MSSLFE: String,

    val OE: String,

    val PE: String,

    val RE: String,

    val RED: String,

    val RMRE: String,

    val RTSSE: String,

    val SE: String,

    val SRE: String,

    val TEE: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[EnergyTypeCode]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EnergyTypeCode
extends
    Parseable[EnergyTypeCode]
{
    val sup = BasicElement.parse _
    val DABE = parse_attribute (attribute ("""EnergyTypeCode.DABE"""))_
    val DAPE = parse_attribute (attribute ("""EnergyTypeCode.DAPE"""))_
    val DASE = parse_attribute (attribute ("""EnergyTypeCode.DASE"""))_
    val DMLE = parse_attribute (attribute ("""EnergyTypeCode.DMLE"""))_
    val DSSE = parse_attribute (attribute ("""EnergyTypeCode.DSSE"""))_
    val EDE = parse_attribute (attribute ("""EnergyTypeCode.EDE"""))_
    val HASE = parse_attribute (attribute ("""EnergyTypeCode.HASE"""))_
    val MLE = parse_attribute (attribute ("""EnergyTypeCode.MLE"""))_
    val MSSLFE = parse_attribute (attribute ("""EnergyTypeCode.MSSLFE"""))_
    val OE = parse_attribute (attribute ("""EnergyTypeCode.OE"""))_
    val PE = parse_attribute (attribute ("""EnergyTypeCode.PE"""))_
    val RE = parse_attribute (attribute ("""EnergyTypeCode.RE"""))_
    val RED = parse_attribute (attribute ("""EnergyTypeCode.RED"""))_
    val RMRE = parse_attribute (attribute ("""EnergyTypeCode.RMRE"""))_
    val RTSSE = parse_attribute (attribute ("""EnergyTypeCode.RTSSE"""))_
    val SE = parse_attribute (attribute ("""EnergyTypeCode.SE"""))_
    val SRE = parse_attribute (attribute ("""EnergyTypeCode.SRE"""))_
    val TEE = parse_attribute (attribute ("""EnergyTypeCode.TEE"""))_
    def parse (context: Context): EnergyTypeCode =
    {
        EnergyTypeCode(
            sup (context),
            DABE (context),
            DAPE (context),
            DASE (context),
            DMLE (context),
            DSSE (context),
            EDE (context),
            HASE (context),
            MLE (context),
            MSSLFE (context),
            OE (context),
            PE (context),
            RE (context),
            RED (context),
            RMRE (context),
            RTSSE (context),
            SE (context),
            SRE (context),
            TEE (context)
        )
    }
}

case class JobFlagType
(

    override val sup: BasicElement,

    val CREATED: String,

    val DELETED: String,

    val MODIFIED: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[JobFlagType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object JobFlagType
extends
    Parseable[JobFlagType]
{
    val sup = BasicElement.parse _
    val CREATED = parse_attribute (attribute ("""JobFlagType.CREATED"""))_
    val DELETED = parse_attribute (attribute ("""JobFlagType.DELETED"""))_
    val MODIFIED = parse_attribute (attribute ("""JobFlagType.MODIFIED"""))_
    def parse (context: Context): JobFlagType =
    {
        JobFlagType(
            sup (context),
            CREATED (context),
            DELETED (context),
            MODIFIED (context)
        )
    }
}

case class JobScheduleType
(

    override val sup: BasicElement,

    val CRITICAL: String,

    val NONCRITICAL: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[JobScheduleType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object JobScheduleType
extends
    Parseable[JobScheduleType]
{
    val sup = BasicElement.parse _
    val CRITICAL = parse_attribute (attribute ("""JobScheduleType.CRITICAL"""))_
    val NONCRITICAL = parse_attribute (attribute ("""JobScheduleType.NONCRITICAL"""))_
    def parse (context: Context): JobScheduleType =
    {
        JobScheduleType(
            sup (context),
            CRITICAL (context),
            NONCRITICAL (context)
        )
    }
}

case class JobStartEndType
(

    override val sup: BasicElement,

    val END: String,

    val NA: String,

    val START: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[JobStartEndType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object JobStartEndType
extends
    Parseable[JobStartEndType]
{
    val sup = BasicElement.parse _
    val END = parse_attribute (attribute ("""JobStartEndType.END"""))_
    val NA = parse_attribute (attribute ("""JobStartEndType.NA"""))_
    val START = parse_attribute (attribute ("""JobStartEndType.START"""))_
    def parse (context: Context): JobStartEndType =
    {
        JobStartEndType(
            sup (context),
            END (context),
            NA (context),
            START (context)
        )
    }
}

case class LFCResourceType
(

    override val sup: BasicElement,

    val GEN: String,

    val PUMP: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[LFCResourceType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LFCResourceType
extends
    Parseable[LFCResourceType]
{
    val sup = BasicElement.parse _
    val GEN = parse_attribute (attribute ("""LFCResourceType.GEN"""))_
    val PUMP = parse_attribute (attribute ("""LFCResourceType.PUMP"""))_
    def parse (context: Context): LFCResourceType =
    {
        LFCResourceType(
            sup (context),
            GEN (context),
            PUMP (context)
        )
    }
}

case class LoadFollowingCapacityType
(

    override val sup: BasicElement,

    val DOWN: String,

    val UP: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[LoadFollowingCapacityType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LoadFollowingCapacityType
extends
    Parseable[LoadFollowingCapacityType]
{
    val sup = BasicElement.parse _
    val DOWN = parse_attribute (attribute ("""LoadFollowingCapacityType.DOWN"""))_
    val UP = parse_attribute (attribute ("""LoadFollowingCapacityType.UP"""))_
    def parse (context: Context): LoadFollowingCapacityType =
    {
        LoadFollowingCapacityType(
            sup (context),
            DOWN (context),
            UP (context)
        )
    }
}

/**
 * ADD - add
DEL - delete
 * CHG - change
 */
case class MQSDELType
(

    override val sup: BasicElement,

    val ADD: String,

    val CHG: String,

    val DEL: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MQSDELType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MQSDELType
extends
    Parseable[MQSDELType]
{
    val sup = BasicElement.parse _
    val ADD = parse_attribute (attribute ("""MQSDELType.ADD"""))_
    val CHG = parse_attribute (attribute ("""MQSDELType.CHG"""))_
    val DEL = parse_attribute (attribute ("""MQSDELType.DEL"""))_
    def parse (context: Context): MQSDELType =
    {
        MQSDELType(
            sup (context),
            ADD (context),
            CHG (context),
            DEL (context)
        )
    }
}

/**
 * RU - Regulation Up
RD - Regulation Down
SR - Spin Reserve
NR - Nonspin Reserve
 * AS - Upward Ancillary Service
 */
case class MarketProductTypeAsReq
(

    override val sup: BasicElement,

    val AS: String,

    /**
     * non spinning reserve
     */
    val NR: String,

    /**
     * regulation down
     */
    val RD: String,

    /**
     * regulation up
     */
    val RU: String,

    /**
     * spinning reserve
     */
    val SR: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketProductTypeAsReq]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketProductTypeAsReq
extends
    Parseable[MarketProductTypeAsReq]
{
    val sup = BasicElement.parse _
    val AS = parse_attribute (attribute ("""MarketProductTypeAsReq.AS"""))_
    val NR = parse_attribute (attribute ("""MarketProductTypeAsReq.NR"""))_
    val RD = parse_attribute (attribute ("""MarketProductTypeAsReq.RD"""))_
    val RU = parse_attribute (attribute ("""MarketProductTypeAsReq.RU"""))_
    val SR = parse_attribute (attribute ("""MarketProductTypeAsReq.SR"""))_
    def parse (context: Context): MarketProductTypeAsReq =
    {
        MarketProductTypeAsReq(
            sup (context),
            AS (context),
            NR (context),
            RD (context),
            RU (context),
            SR (context)
        )
    }
}

case class MarketScheduleServices
(

    override val sup: BasicElement,

    val retrieveDefaultBidCurves: String,

    val retrieveMPMResults: String,

    val retrieveMarketAwards: String,

    val retrieveSchedulePrices: String,

    val retrieveStartUpShutDownInstructions: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketScheduleServices]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketScheduleServices
extends
    Parseable[MarketScheduleServices]
{
    val sup = BasicElement.parse _
    val retrieveDefaultBidCurves = parse_attribute (attribute ("""MarketScheduleServices.retrieveDefaultBidCurves"""))_
    val retrieveMPMResults = parse_attribute (attribute ("""MarketScheduleServices.retrieveMPMResults"""))_
    val retrieveMarketAwards = parse_attribute (attribute ("""MarketScheduleServices.retrieveMarketAwards"""))_
    val retrieveSchedulePrices = parse_attribute (attribute ("""MarketScheduleServices.retrieveSchedulePrices"""))_
    val retrieveStartUpShutDownInstructions = parse_attribute (attribute ("""MarketScheduleServices.retrieveStartUpShutDownInstructions"""))_
    def parse (context: Context): MarketScheduleServices =
    {
        MarketScheduleServices(
            sup (context),
            retrieveDefaultBidCurves (context),
            retrieveMPMResults (context),
            retrieveMarketAwards (context),
            retrieveSchedulePrices (context),
            retrieveStartUpShutDownInstructions (context)
        )
    }
}

/**
 * Description of market statement
 */
case class MarketStatementDescription
(

    override val sup: BasicElement,

    val DAILY_INITIAL_CREDIT: String,

    val DAILY_INITIAL_MARKET: String,

    val DAILY_RECALC_MARKET: String,

    val MONTHLY_INITIAL_MARKET: String,

    val MONTHLY_RECALC_MARKET: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketStatementDescription]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketStatementDescription
extends
    Parseable[MarketStatementDescription]
{
    val sup = BasicElement.parse _
    val DAILY_INITIAL_CREDIT = parse_attribute (attribute ("""MarketStatementDescription.DAILY_INITIAL_CREDIT"""))_
    val DAILY_INITIAL_MARKET = parse_attribute (attribute ("""MarketStatementDescription.DAILY_INITIAL_MARKET"""))_
    val DAILY_RECALC_MARKET = parse_attribute (attribute ("""MarketStatementDescription.DAILY_RECALC_MARKET"""))_
    val MONTHLY_INITIAL_MARKET = parse_attribute (attribute ("""MarketStatementDescription.MONTHLY_INITIAL_MARKET"""))_
    val MONTHLY_RECALC_MARKET = parse_attribute (attribute ("""MarketStatementDescription.MONTHLY_RECALC_MARKET"""))_
    def parse (context: Context): MarketStatementDescription =
    {
        MarketStatementDescription(
            sup (context),
            DAILY_INITIAL_CREDIT (context),
            DAILY_INITIAL_MARKET (context),
            DAILY_RECALC_MARKET (context),
            MONTHLY_INITIAL_MARKET (context),
            MONTHLY_RECALC_MARKET (context)
        )
    }
}

/**
 * market statement document status
 */
case class MarketStatementDocStatus
(

    override val sup: BasicElement,

    val APPROVED: String,

    val CANCELLED: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketStatementDocStatus]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketStatementDocStatus
extends
    Parseable[MarketStatementDocStatus]
{
    val sup = BasicElement.parse _
    val APPROVED = parse_attribute (attribute ("""MarketStatementDocStatus.APPROVED"""))_
    val CANCELLED = parse_attribute (attribute ("""MarketStatementDocStatus.CANCELLED"""))_
    def parse (context: Context): MarketStatementDocStatus =
    {
        MarketStatementDocStatus(
            sup (context),
            APPROVED (context),
            CANCELLED (context)
        )
    }
}

/**
 * market statement document type
 */
case class MarketStatementDocType
(

    override val sup: BasicElement,

    val CREDIT: String,

    val MARKET_INITIAL: String,

    val MARKET_RECALC: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketStatementDocType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketStatementDocType
extends
    Parseable[MarketStatementDocType]
{
    val sup = BasicElement.parse _
    val CREDIT = parse_attribute (attribute ("""MarketStatementDocType.CREDIT"""))_
    val MARKET_INITIAL = parse_attribute (attribute ("""MarketStatementDocType.MARKET_INITIAL"""))_
    val MARKET_RECALC = parse_attribute (attribute ("""MarketStatementDocType.MARKET_RECALC"""))_
    def parse (context: Context): MarketStatementDocType =
    {
        MarketStatementDocType(
            sup (context),
            CREDIT (context),
            MARKET_INITIAL (context),
            MARKET_RECALC (context)
        )
    }
}

/**
 * market statement line item alias name
 */
case class MarketStatementLineItemAliasName
(

    override val sup: BasicElement,

    val CHARGE_CODE_INTERVAL_DETAIL: String,

    val CHARGE_CODE_INTERVAL_TOTAL: String,

    val CHARGE_CODE_SUMMARY: String,

    val CHARGE_GROUP: String,

    val PARENT_CHARGE_GROUP: String,

    val TRADE_DATE: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketStatementLineItemAliasName]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketStatementLineItemAliasName
extends
    Parseable[MarketStatementLineItemAliasName]
{
    val sup = BasicElement.parse _
    val CHARGE_CODE_INTERVAL_DETAIL = parse_attribute (attribute ("""MarketStatementLineItemAliasName.CHARGE_CODE_INTERVAL_DETAIL"""))_
    val CHARGE_CODE_INTERVAL_TOTAL = parse_attribute (attribute ("""MarketStatementLineItemAliasName.CHARGE_CODE_INTERVAL_TOTAL"""))_
    val CHARGE_CODE_SUMMARY = parse_attribute (attribute ("""MarketStatementLineItemAliasName.CHARGE_CODE_SUMMARY"""))_
    val CHARGE_GROUP = parse_attribute (attribute ("""MarketStatementLineItemAliasName.CHARGE_GROUP"""))_
    val PARENT_CHARGE_GROUP = parse_attribute (attribute ("""MarketStatementLineItemAliasName.PARENT_CHARGE_GROUP"""))_
    val TRADE_DATE = parse_attribute (attribute ("""MarketStatementLineItemAliasName.TRADE_DATE"""))_
    def parse (context: Context): MarketStatementLineItemAliasName =
    {
        MarketStatementLineItemAliasName(
            sup (context),
            CHARGE_CODE_INTERVAL_DETAIL (context),
            CHARGE_CODE_INTERVAL_TOTAL (context),
            CHARGE_CODE_SUMMARY (context),
            CHARGE_GROUP (context),
            PARENT_CHARGE_GROUP (context),
            TRADE_DATE (context)
        )
    }
}

/**
 * Path Flow - PF
Path Inflow Limit - PIL
Path Inflow Available Limit - PIAL 
Path Inflow Armed Limit - PIML
Path Outflow Limit - POL
Path Outflow Available Limit - POAL 
Path Outflow Armed Limit - OARL
Generation Output - GO 
Generation Max Operating Limit - GMOL 
Generation Min Operating Limit - GNOL 
Generation Regulation - GR 
Generation Status - GS 
Pump Production - PP 
System Load - SL 
System ACE - ACE
 * System INADV - INADV
 */
case class MeasurementTypeEMS
(

    override val sup: BasicElement,

    val ACE: String,

    val GMOL: String,

    val GNOL: String,

    val GO: String,

    val GR: String,

    val GS: String,

    val INADV: String,

    val OARL: String,

    val PF: String,

    val PIAL: String,

    val PIL: String,

    val PIML: String,

    val POAL: String,

    val POL: String,

    val PP: String,

    val SL: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MeasurementTypeEMS]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MeasurementTypeEMS
extends
    Parseable[MeasurementTypeEMS]
{
    val sup = BasicElement.parse _
    val ACE = parse_attribute (attribute ("""MeasurementTypeEMS.ACE"""))_
    val GMOL = parse_attribute (attribute ("""MeasurementTypeEMS.GMOL"""))_
    val GNOL = parse_attribute (attribute ("""MeasurementTypeEMS.GNOL"""))_
    val GO = parse_attribute (attribute ("""MeasurementTypeEMS.GO"""))_
    val GR = parse_attribute (attribute ("""MeasurementTypeEMS.GR"""))_
    val GS = parse_attribute (attribute ("""MeasurementTypeEMS.GS"""))_
    val INADV = parse_attribute (attribute ("""MeasurementTypeEMS.INADV"""))_
    val OARL = parse_attribute (attribute ("""MeasurementTypeEMS.OARL"""))_
    val PF = parse_attribute (attribute ("""MeasurementTypeEMS.PF"""))_
    val PIAL = parse_attribute (attribute ("""MeasurementTypeEMS.PIAL"""))_
    val PIL = parse_attribute (attribute ("""MeasurementTypeEMS.PIL"""))_
    val PIML = parse_attribute (attribute ("""MeasurementTypeEMS.PIML"""))_
    val POAL = parse_attribute (attribute ("""MeasurementTypeEMS.POAL"""))_
    val POL = parse_attribute (attribute ("""MeasurementTypeEMS.POL"""))_
    val PP = parse_attribute (attribute ("""MeasurementTypeEMS.PP"""))_
    val SL = parse_attribute (attribute ("""MeasurementTypeEMS.SL"""))_
    def parse (context: Context): MeasurementTypeEMS =
    {
        MeasurementTypeEMS(
            sup (context),
            ACE (context),
            GMOL (context),
            GNOL (context),
            GO (context),
            GR (context),
            GS (context),
            INADV (context),
            OARL (context),
            PF (context),
            PIAL (context),
            PIL (context),
            PIML (context),
            POAL (context),
            POL (context),
            PP (context),
            SL (context)
        )
    }
}

case class MktSubClassType
(

    override val sup: BasicElement,

    val Branch_Group_Derates: String,

    val Day_Ahead_Final_Market_Info: String,

    val Day_Ahead_Forecast_Information: String,

    val Day_Ahead_Interim_Market_Info: String,

    val Day_Ahead_RMR: String,

    val Forecasted_UDC_Direct_Access_Load: String,

    val Hour_Ahead_Market_Info: String,

    val Hourly_Expost_Market_Info: String,

    val Public_Bid_Data: String,

    val TTC_ATC_Forecast_Information: String,

    val TTC_ATC_Hourly_Forecast: String,

    val Ten_Min_Expost_Market_Info: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MktSubClassType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktSubClassType
extends
    Parseable[MktSubClassType]
{
    val sup = BasicElement.parse _
    val Branch_Group_Derates = parse_attribute (attribute ("""MktSubClassType.Branch_Group_Derates"""))_
    val Day_Ahead_Final_Market_Info = parse_attribute (attribute ("""MktSubClassType.Day_Ahead_Final_Market_Info"""))_
    val Day_Ahead_Forecast_Information = parse_attribute (attribute ("""MktSubClassType.Day_Ahead_Forecast_Information"""))_
    val Day_Ahead_Interim_Market_Info = parse_attribute (attribute ("""MktSubClassType.Day_Ahead_Interim_Market_Info"""))_
    val Day_Ahead_RMR = parse_attribute (attribute ("""MktSubClassType.Day_Ahead_RMR"""))_
    val Forecasted_UDC_Direct_Access_Load = parse_attribute (attribute ("""MktSubClassType.Forecasted_UDC_Direct_Access_Load"""))_
    val Hour_Ahead_Market_Info = parse_attribute (attribute ("""MktSubClassType.Hour_Ahead_Market_Info"""))_
    val Hourly_Expost_Market_Info = parse_attribute (attribute ("""MktSubClassType.Hourly_Expost_Market_Info"""))_
    val Public_Bid_Data = parse_attribute (attribute ("""MktSubClassType.Public_Bid_Data"""))_
    val TTC_ATC_Forecast_Information = parse_attribute (attribute ("""MktSubClassType.TTC/ATC_Forecast_Information"""))_
    val TTC_ATC_Hourly_Forecast = parse_attribute (attribute ("""MktSubClassType.TTC/ATC_Hourly_Forecast"""))_
    val Ten_Min_Expost_Market_Info = parse_attribute (attribute ("""MktSubClassType.Ten_Min_Expost_Market_Info"""))_
    def parse (context: Context): MktSubClassType =
    {
        MktSubClassType(
            sup (context),
            Branch_Group_Derates (context),
            Day_Ahead_Final_Market_Info (context),
            Day_Ahead_Forecast_Information (context),
            Day_Ahead_Interim_Market_Info (context),
            Day_Ahead_RMR (context),
            Forecasted_UDC_Direct_Access_Load (context),
            Hour_Ahead_Market_Info (context),
            Hourly_Expost_Market_Info (context),
            Public_Bid_Data (context),
            TTC_ATC_Forecast_Information (context),
            TTC_ATC_Hourly_Forecast (context),
            Ten_Min_Expost_Market_Info (context)
        )
    }
}

case class OASISBidReportType
(

    override val sup: BasicElement,

    val BIDS_PUBLIC: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[OASISBidReportType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OASISBidReportType
extends
    Parseable[OASISBidReportType]
{
    val sup = BasicElement.parse _
    val BIDS_PUBLIC = parse_attribute (attribute ("""OASISBidReportType.BIDS_PUBLIC"""))_
    def parse (context: Context): OASISBidReportType =
    {
        OASISBidReportType(
            sup (context),
            BIDS_PUBLIC (context)
        )
    }
}

case class OASISDataItems
(

    override val sup: BasicElement,

    val AS_CLEAR_ASMP_IFM: String,

    val AS_CLEAR_ASMP_RTM: String,

    val AS_CLEAR_COST_IFM: String,

    val AS_CLEAR_COST_RTM: String,

    val AS_CLEAR_MW_IFM: String,

    val AS_CLEAR_MW_RTM: String,

    val AS_GEN_TOTAL_MW_IFM: String,

    val AS_GEN_TOTAL_MW_RTM: String,

    val AS_IMP_TOTAL_MW_IFM: String,

    val AS_IMP_TOTAL_MW_RTM: String,

    val AS_LOAD_TOTAL_MW_IFM: String,

    val AS_LOAD_TOTAL_MW_RTM: String,

    val AS_REGION_REQ_MAX: String,

    val AS_REGION_REQ_MIN: String,

    val AS_REGION_value: String,

    val AS_SELF_MW_IFM: String,

    val AS_SELF_MW_RTM: String,

    val AS_TOTAL_MW: String,

    val AS_TOTAL_MW_IFM: String,

    val AS_TOTAL_MW_RTM: String,

    val AS_TYPE: String,

    val AS_USER_RATE: String,

    val CA_value: String,

    val CMMT_MINLOAD_MLC: String,

    val CMMT_MINLOAD_MW: String,

    val CMMT_RA_MLC: String,

    val CMMT_RA_MW: String,

    val CMMT_RA_START_COST: String,

    val CMMT_RA_UNITS: String,

    val CMMT_TOTAL_MW: String,

    val CMMT_TOTAL_START_COST: String,

    val CMMT_TOTAL_UNITS: String,

    val CRR_CAT: String,

    val CRR_MARKET_value: String,

    val CRR_MW: String,

    val CRR_NSR: String,

    val CRR_OPTION: String,

    val CRR_OWNER: String,

    val CRR_SEGMENT: String,

    val CRR_TERM: String,

    val CRR_TOU: String,

    val CRR_TYPE: String,

    val ENE_EA_DA: String,

    val ENE_EA_EXCEPT: String,

    val ENE_EA_HASP: String,

    val ENE_EA_MLE: String,

    val ENE_EA_MSSLF: String,

    val ENE_EA_OPTIMAL: String,

    val ENE_EA_RAMP_DEV: String,

    val ENE_EA_RAMP_STD: String,

    val ENE_EA_RESIDUAL: String,

    val ENE_EA_RMR: String,

    val ENE_EA_SELF: String,

    val ENE_EA_SLIC: String,

    val ENE_EXP_CLEAR_HASP: String,

    val ENE_EXP_CLEAR_IFM: String,

    val ENE_EXP_CLEAR_RTM: String,

    val ENE_GEN_CLEAR_HASP: String,

    val ENE_GEN_CLEAR_IFM: String,

    val ENE_GEN_CLEAR_RTM: String,

    val ENE_IMP_CLEAR_HASP: String,

    val ENE_IMP_CLEAR_IFM: String,

    val ENE_IMP_CLEAR_RTM: String,

    val ENE_LOAD_ACTUAL: String,

    val ENE_LOAD_CLEAR_HASP: String,

    val ENE_LOAD_CLEAR_IFM: String,

    val ENE_LOAD_CLEAR_RTM: String,

    val ENE_LOAD_FCST: String,

    val ENE_PEAK_HOUR: String,

    val ENE_PEAK_LOAD: String,

    val FUEL_REGION_value: String,

    val INVT_DATETIME: String,

    val LOAD_ACTUAL: String,

    val LOAD_CLEAR_RTM: String,

    val LOSS_TOTAL_COST_HASP: String,

    val LOSS_TOTAL_COST_RTM: String,

    val LOSS_TOTAL_MW_HASP: String,

    val LOSS_TOTAL_MW_RTM: String,

    val MPM_FLAG: String,

    val OP_RSRV_TOTAL: String,

    val PRC_NG: String,

    val PRC_SHADOW: String,

    val RATING_ATC: String,

    val RMR_DETER_DAM: String,

    val RMR_DETER_HASP: String,

    val RMR_DISPATCH_DAM: String,

    val RMR_DISPATCH_HASP: String,

    val RMR_TOTAL: String,

    val RMR_TOTAL_AVAIL: String,

    val RUC_GEN_CLEAR_RUC: String,

    val RUC_IMP_CLEAR_RUC: String,

    val RUC_LOAD_CLEAR_RUC: String,

    val RUC_ZONE_value: String,

    val TAC_AREA_value: String,

    val TINTRFCE_value: String,

    val TRNS_AS_IMPORT: String,

    val TRNS_ENE_IMPORT: String,

    val TRNS_EQUIP_value: String,

    val TRNS_RATING_CBM: String,

    val TRNS_RATING_DIRECTION: String,

    val TRNS_RATING_OTC: String,

    val TRNS_RATING_OTC_DERATE: String,

    val TRNS_RATING_TTC: String,

    val TRNS_TI_value: String,

    val TRNS_TR_ENTMTS: String,

    val TRNS_TR_USEAGE: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[OASISDataItems]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OASISDataItems
extends
    Parseable[OASISDataItems]
{
    val sup = BasicElement.parse _
    val AS_CLEAR_ASMP_IFM = parse_attribute (attribute ("""OASISDataItems.AS_CLEAR_ASMP_IFM"""))_
    val AS_CLEAR_ASMP_RTM = parse_attribute (attribute ("""OASISDataItems.AS_CLEAR_ASMP_RTM"""))_
    val AS_CLEAR_COST_IFM = parse_attribute (attribute ("""OASISDataItems.AS_CLEAR_COST_IFM"""))_
    val AS_CLEAR_COST_RTM = parse_attribute (attribute ("""OASISDataItems.AS_CLEAR_COST_RTM"""))_
    val AS_CLEAR_MW_IFM = parse_attribute (attribute ("""OASISDataItems.AS_CLEAR_MW_IFM"""))_
    val AS_CLEAR_MW_RTM = parse_attribute (attribute ("""OASISDataItems.AS_CLEAR_MW_RTM"""))_
    val AS_GEN_TOTAL_MW_IFM = parse_attribute (attribute ("""OASISDataItems.AS_GEN_TOTAL_MW_IFM"""))_
    val AS_GEN_TOTAL_MW_RTM = parse_attribute (attribute ("""OASISDataItems.AS_GEN_TOTAL_MW_RTM"""))_
    val AS_IMP_TOTAL_MW_IFM = parse_attribute (attribute ("""OASISDataItems.AS_IMP_TOTAL_MW_IFM"""))_
    val AS_IMP_TOTAL_MW_RTM = parse_attribute (attribute ("""OASISDataItems.AS_IMP_TOTAL_MW_RTM"""))_
    val AS_LOAD_TOTAL_MW_IFM = parse_attribute (attribute ("""OASISDataItems.AS_LOAD_TOTAL_MW_IFM"""))_
    val AS_LOAD_TOTAL_MW_RTM = parse_attribute (attribute ("""OASISDataItems.AS_LOAD_TOTAL_MW_RTM"""))_
    val AS_REGION_REQ_MAX = parse_attribute (attribute ("""OASISDataItems.AS_REGION_REQ_MAX"""))_
    val AS_REGION_REQ_MIN = parse_attribute (attribute ("""OASISDataItems.AS_REGION_REQ_MIN"""))_
    val AS_REGION_value = parse_attribute (attribute ("""OASISDataItems.AS_REGION_value"""))_
    val AS_SELF_MW_IFM = parse_attribute (attribute ("""OASISDataItems.AS_SELF_MW_IFM"""))_
    val AS_SELF_MW_RTM = parse_attribute (attribute ("""OASISDataItems.AS_SELF_MW_RTM"""))_
    val AS_TOTAL_MW = parse_attribute (attribute ("""OASISDataItems.AS_TOTAL_MW"""))_
    val AS_TOTAL_MW_IFM = parse_attribute (attribute ("""OASISDataItems.AS_TOTAL_MW_IFM"""))_
    val AS_TOTAL_MW_RTM = parse_attribute (attribute ("""OASISDataItems.AS_TOTAL_MW_RTM"""))_
    val AS_TYPE = parse_attribute (attribute ("""OASISDataItems.AS_TYPE"""))_
    val AS_USER_RATE = parse_attribute (attribute ("""OASISDataItems.AS_USER_RATE"""))_
    val CA_value = parse_attribute (attribute ("""OASISDataItems.CA_value"""))_
    val CMMT_MINLOAD_MLC = parse_attribute (attribute ("""OASISDataItems.CMMT_MINLOAD_MLC"""))_
    val CMMT_MINLOAD_MW = parse_attribute (attribute ("""OASISDataItems.CMMT_MINLOAD_MW"""))_
    val CMMT_RA_MLC = parse_attribute (attribute ("""OASISDataItems.CMMT_RA_MLC"""))_
    val CMMT_RA_MW = parse_attribute (attribute ("""OASISDataItems.CMMT_RA_MW"""))_
    val CMMT_RA_START_COST = parse_attribute (attribute ("""OASISDataItems.CMMT_RA_START_COST"""))_
    val CMMT_RA_UNITS = parse_attribute (attribute ("""OASISDataItems.CMMT_RA_UNITS"""))_
    val CMMT_TOTAL_MW = parse_attribute (attribute ("""OASISDataItems.CMMT_TOTAL_MW"""))_
    val CMMT_TOTAL_START_COST = parse_attribute (attribute ("""OASISDataItems.CMMT_TOTAL_START_COST"""))_
    val CMMT_TOTAL_UNITS = parse_attribute (attribute ("""OASISDataItems.CMMT_TOTAL_UNITS"""))_
    val CRR_CAT = parse_attribute (attribute ("""OASISDataItems.CRR_CAT"""))_
    val CRR_MARKET_value = parse_attribute (attribute ("""OASISDataItems.CRR_MARKET_value"""))_
    val CRR_MW = parse_attribute (attribute ("""OASISDataItems.CRR_MW"""))_
    val CRR_NSR = parse_attribute (attribute ("""OASISDataItems.CRR_NSR"""))_
    val CRR_OPTION = parse_attribute (attribute ("""OASISDataItems.CRR_OPTION"""))_
    val CRR_OWNER = parse_attribute (attribute ("""OASISDataItems.CRR_OWNER"""))_
    val CRR_SEGMENT = parse_attribute (attribute ("""OASISDataItems.CRR_SEGMENT"""))_
    val CRR_TERM = parse_attribute (attribute ("""OASISDataItems.CRR_TERM"""))_
    val CRR_TOU = parse_attribute (attribute ("""OASISDataItems.CRR_TOU"""))_
    val CRR_TYPE = parse_attribute (attribute ("""OASISDataItems.CRR_TYPE"""))_
    val ENE_EA_DA = parse_attribute (attribute ("""OASISDataItems.ENE_EA_DA"""))_
    val ENE_EA_EXCEPT = parse_attribute (attribute ("""OASISDataItems.ENE_EA_EXCEPT"""))_
    val ENE_EA_HASP = parse_attribute (attribute ("""OASISDataItems.ENE_EA_HASP"""))_
    val ENE_EA_MLE = parse_attribute (attribute ("""OASISDataItems.ENE_EA_MLE"""))_
    val ENE_EA_MSSLF = parse_attribute (attribute ("""OASISDataItems.ENE_EA_MSSLF"""))_
    val ENE_EA_OPTIMAL = parse_attribute (attribute ("""OASISDataItems.ENE_EA_OPTIMAL"""))_
    val ENE_EA_RAMP_DEV = parse_attribute (attribute ("""OASISDataItems.ENE_EA_RAMP_DEV"""))_
    val ENE_EA_RAMP_STD = parse_attribute (attribute ("""OASISDataItems.ENE_EA_RAMP_STD"""))_
    val ENE_EA_RESIDUAL = parse_attribute (attribute ("""OASISDataItems.ENE_EA_RESIDUAL"""))_
    val ENE_EA_RMR = parse_attribute (attribute ("""OASISDataItems.ENE_EA_RMR"""))_
    val ENE_EA_SELF = parse_attribute (attribute ("""OASISDataItems.ENE_EA_SELF"""))_
    val ENE_EA_SLIC = parse_attribute (attribute ("""OASISDataItems.ENE_EA_SLIC"""))_
    val ENE_EXP_CLEAR_HASP = parse_attribute (attribute ("""OASISDataItems.ENE_EXP_CLEAR_HASP"""))_
    val ENE_EXP_CLEAR_IFM = parse_attribute (attribute ("""OASISDataItems.ENE_EXP_CLEAR_IFM"""))_
    val ENE_EXP_CLEAR_RTM = parse_attribute (attribute ("""OASISDataItems.ENE_EXP_CLEAR_RTM"""))_
    val ENE_GEN_CLEAR_HASP = parse_attribute (attribute ("""OASISDataItems.ENE_GEN_CLEAR_HASP"""))_
    val ENE_GEN_CLEAR_IFM = parse_attribute (attribute ("""OASISDataItems.ENE_GEN_CLEAR_IFM"""))_
    val ENE_GEN_CLEAR_RTM = parse_attribute (attribute ("""OASISDataItems.ENE_GEN_CLEAR_RTM"""))_
    val ENE_IMP_CLEAR_HASP = parse_attribute (attribute ("""OASISDataItems.ENE_IMP_CLEAR_HASP"""))_
    val ENE_IMP_CLEAR_IFM = parse_attribute (attribute ("""OASISDataItems.ENE_IMP_CLEAR_IFM"""))_
    val ENE_IMP_CLEAR_RTM = parse_attribute (attribute ("""OASISDataItems.ENE_IMP_CLEAR_RTM"""))_
    val ENE_LOAD_ACTUAL = parse_attribute (attribute ("""OASISDataItems.ENE_LOAD_ACTUAL"""))_
    val ENE_LOAD_CLEAR_HASP = parse_attribute (attribute ("""OASISDataItems.ENE_LOAD_CLEAR_HASP"""))_
    val ENE_LOAD_CLEAR_IFM = parse_attribute (attribute ("""OASISDataItems.ENE_LOAD_CLEAR_IFM"""))_
    val ENE_LOAD_CLEAR_RTM = parse_attribute (attribute ("""OASISDataItems.ENE_LOAD_CLEAR_RTM"""))_
    val ENE_LOAD_FCST = parse_attribute (attribute ("""OASISDataItems.ENE_LOAD_FCST"""))_
    val ENE_PEAK_HOUR = parse_attribute (attribute ("""OASISDataItems.ENE_PEAK_HOUR"""))_
    val ENE_PEAK_LOAD = parse_attribute (attribute ("""OASISDataItems.ENE_PEAK_LOAD"""))_
    val FUEL_REGION_value = parse_attribute (attribute ("""OASISDataItems.FUEL_REGION_value"""))_
    val INVT_DATETIME = parse_attribute (attribute ("""OASISDataItems.INVT_DATETIME"""))_
    val LOAD_ACTUAL = parse_attribute (attribute ("""OASISDataItems.LOAD_ACTUAL"""))_
    val LOAD_CLEAR_RTM = parse_attribute (attribute ("""OASISDataItems.LOAD_CLEAR_RTM"""))_
    val LOSS_TOTAL_COST_HASP = parse_attribute (attribute ("""OASISDataItems.LOSS_TOTAL_COST_HASP"""))_
    val LOSS_TOTAL_COST_RTM = parse_attribute (attribute ("""OASISDataItems.LOSS_TOTAL_COST_RTM"""))_
    val LOSS_TOTAL_MW_HASP = parse_attribute (attribute ("""OASISDataItems.LOSS_TOTAL_MW_HASP"""))_
    val LOSS_TOTAL_MW_RTM = parse_attribute (attribute ("""OASISDataItems.LOSS_TOTAL_MW_RTM"""))_
    val MPM_FLAG = parse_attribute (attribute ("""OASISDataItems.MPM_FLAG"""))_
    val OP_RSRV_TOTAL = parse_attribute (attribute ("""OASISDataItems.OP_RSRV_TOTAL"""))_
    val PRC_NG = parse_attribute (attribute ("""OASISDataItems.PRC_NG"""))_
    val PRC_SHADOW = parse_attribute (attribute ("""OASISDataItems.PRC_SHADOW"""))_
    val RATING_ATC = parse_attribute (attribute ("""OASISDataItems.RATING_ATC"""))_
    val RMR_DETER_DAM = parse_attribute (attribute ("""OASISDataItems.RMR_DETER_DAM"""))_
    val RMR_DETER_HASP = parse_attribute (attribute ("""OASISDataItems.RMR_DETER_HASP"""))_
    val RMR_DISPATCH_DAM = parse_attribute (attribute ("""OASISDataItems.RMR_DISPATCH_DAM"""))_
    val RMR_DISPATCH_HASP = parse_attribute (attribute ("""OASISDataItems.RMR_DISPATCH_HASP"""))_
    val RMR_TOTAL = parse_attribute (attribute ("""OASISDataItems.RMR_TOTAL"""))_
    val RMR_TOTAL_AVAIL = parse_attribute (attribute ("""OASISDataItems.RMR_TOTAL_AVAIL"""))_
    val RUC_GEN_CLEAR_RUC = parse_attribute (attribute ("""OASISDataItems.RUC_GEN_CLEAR_RUC"""))_
    val RUC_IMP_CLEAR_RUC = parse_attribute (attribute ("""OASISDataItems.RUC_IMP_CLEAR_RUC"""))_
    val RUC_LOAD_CLEAR_RUC = parse_attribute (attribute ("""OASISDataItems.RUC_LOAD_CLEAR_RUC"""))_
    val RUC_ZONE_value = parse_attribute (attribute ("""OASISDataItems.RUC_ZONE_value"""))_
    val TAC_AREA_value = parse_attribute (attribute ("""OASISDataItems.TAC_AREA_value"""))_
    val TINTRFCE_value = parse_attribute (attribute ("""OASISDataItems.TINTRFCE_value"""))_
    val TRNS_AS_IMPORT = parse_attribute (attribute ("""OASISDataItems.TRNS_AS_IMPORT"""))_
    val TRNS_ENE_IMPORT = parse_attribute (attribute ("""OASISDataItems.TRNS_ENE_IMPORT"""))_
    val TRNS_EQUIP_value = parse_attribute (attribute ("""OASISDataItems.TRNS_EQUIP_value"""))_
    val TRNS_RATING_CBM = parse_attribute (attribute ("""OASISDataItems.TRNS_RATING_CBM"""))_
    val TRNS_RATING_DIRECTION = parse_attribute (attribute ("""OASISDataItems.TRNS_RATING_DIRECTION"""))_
    val TRNS_RATING_OTC = parse_attribute (attribute ("""OASISDataItems.TRNS_RATING_OTC"""))_
    val TRNS_RATING_OTC_DERATE = parse_attribute (attribute ("""OASISDataItems.TRNS_RATING_OTC_DERATE"""))_
    val TRNS_RATING_TTC = parse_attribute (attribute ("""OASISDataItems.TRNS_RATING_TTC"""))_
    val TRNS_TI_value = parse_attribute (attribute ("""OASISDataItems.TRNS_TI_value"""))_
    val TRNS_TR_ENTMTS = parse_attribute (attribute ("""OASISDataItems.TRNS_TR_ENTMTS"""))_
    val TRNS_TR_USEAGE = parse_attribute (attribute ("""OASISDataItems.TRNS_TR_USEAGE"""))_
    def parse (context: Context): OASISDataItems =
    {
        OASISDataItems(
            sup (context),
            AS_CLEAR_ASMP_IFM (context),
            AS_CLEAR_ASMP_RTM (context),
            AS_CLEAR_COST_IFM (context),
            AS_CLEAR_COST_RTM (context),
            AS_CLEAR_MW_IFM (context),
            AS_CLEAR_MW_RTM (context),
            AS_GEN_TOTAL_MW_IFM (context),
            AS_GEN_TOTAL_MW_RTM (context),
            AS_IMP_TOTAL_MW_IFM (context),
            AS_IMP_TOTAL_MW_RTM (context),
            AS_LOAD_TOTAL_MW_IFM (context),
            AS_LOAD_TOTAL_MW_RTM (context),
            AS_REGION_REQ_MAX (context),
            AS_REGION_REQ_MIN (context),
            AS_REGION_value (context),
            AS_SELF_MW_IFM (context),
            AS_SELF_MW_RTM (context),
            AS_TOTAL_MW (context),
            AS_TOTAL_MW_IFM (context),
            AS_TOTAL_MW_RTM (context),
            AS_TYPE (context),
            AS_USER_RATE (context),
            CA_value (context),
            CMMT_MINLOAD_MLC (context),
            CMMT_MINLOAD_MW (context),
            CMMT_RA_MLC (context),
            CMMT_RA_MW (context),
            CMMT_RA_START_COST (context),
            CMMT_RA_UNITS (context),
            CMMT_TOTAL_MW (context),
            CMMT_TOTAL_START_COST (context),
            CMMT_TOTAL_UNITS (context),
            CRR_CAT (context),
            CRR_MARKET_value (context),
            CRR_MW (context),
            CRR_NSR (context),
            CRR_OPTION (context),
            CRR_OWNER (context),
            CRR_SEGMENT (context),
            CRR_TERM (context),
            CRR_TOU (context),
            CRR_TYPE (context),
            ENE_EA_DA (context),
            ENE_EA_EXCEPT (context),
            ENE_EA_HASP (context),
            ENE_EA_MLE (context),
            ENE_EA_MSSLF (context),
            ENE_EA_OPTIMAL (context),
            ENE_EA_RAMP_DEV (context),
            ENE_EA_RAMP_STD (context),
            ENE_EA_RESIDUAL (context),
            ENE_EA_RMR (context),
            ENE_EA_SELF (context),
            ENE_EA_SLIC (context),
            ENE_EXP_CLEAR_HASP (context),
            ENE_EXP_CLEAR_IFM (context),
            ENE_EXP_CLEAR_RTM (context),
            ENE_GEN_CLEAR_HASP (context),
            ENE_GEN_CLEAR_IFM (context),
            ENE_GEN_CLEAR_RTM (context),
            ENE_IMP_CLEAR_HASP (context),
            ENE_IMP_CLEAR_IFM (context),
            ENE_IMP_CLEAR_RTM (context),
            ENE_LOAD_ACTUAL (context),
            ENE_LOAD_CLEAR_HASP (context),
            ENE_LOAD_CLEAR_IFM (context),
            ENE_LOAD_CLEAR_RTM (context),
            ENE_LOAD_FCST (context),
            ENE_PEAK_HOUR (context),
            ENE_PEAK_LOAD (context),
            FUEL_REGION_value (context),
            INVT_DATETIME (context),
            LOAD_ACTUAL (context),
            LOAD_CLEAR_RTM (context),
            LOSS_TOTAL_COST_HASP (context),
            LOSS_TOTAL_COST_RTM (context),
            LOSS_TOTAL_MW_HASP (context),
            LOSS_TOTAL_MW_RTM (context),
            MPM_FLAG (context),
            OP_RSRV_TOTAL (context),
            PRC_NG (context),
            PRC_SHADOW (context),
            RATING_ATC (context),
            RMR_DETER_DAM (context),
            RMR_DETER_HASP (context),
            RMR_DISPATCH_DAM (context),
            RMR_DISPATCH_HASP (context),
            RMR_TOTAL (context),
            RMR_TOTAL_AVAIL (context),
            RUC_GEN_CLEAR_RUC (context),
            RUC_IMP_CLEAR_RUC (context),
            RUC_LOAD_CLEAR_RUC (context),
            RUC_ZONE_value (context),
            TAC_AREA_value (context),
            TINTRFCE_value (context),
            TRNS_AS_IMPORT (context),
            TRNS_ENE_IMPORT (context),
            TRNS_EQUIP_value (context),
            TRNS_RATING_CBM (context),
            TRNS_RATING_DIRECTION (context),
            TRNS_RATING_OTC (context),
            TRNS_RATING_OTC_DERATE (context),
            TRNS_RATING_TTC (context),
            TRNS_TI_value (context),
            TRNS_TR_ENTMTS (context),
            TRNS_TR_USEAGE (context)
        )
    }
}

case class OASISErrCode
(

    override val sup: BasicElement,

    val _1000: String,

    val _1001: String,

    val _1002: String,

    val _1003: String,

    val _1004: String,

    val _1005: String,

    val _1006: String,

    val _1007: String,

    val _1008: String,

    val _1009: String,

    val _1010: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[OASISErrCode]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OASISErrCode
extends
    Parseable[OASISErrCode]
{
    val sup = BasicElement.parse _
    val _1000 = parse_attribute (attribute ("""OASISErrCode.1000"""))_
    val _1001 = parse_attribute (attribute ("""OASISErrCode.1001"""))_
    val _1002 = parse_attribute (attribute ("""OASISErrCode.1002"""))_
    val _1003 = parse_attribute (attribute ("""OASISErrCode.1003"""))_
    val _1004 = parse_attribute (attribute ("""OASISErrCode.1004"""))_
    val _1005 = parse_attribute (attribute ("""OASISErrCode.1005"""))_
    val _1006 = parse_attribute (attribute ("""OASISErrCode.1006"""))_
    val _1007 = parse_attribute (attribute ("""OASISErrCode.1007"""))_
    val _1008 = parse_attribute (attribute ("""OASISErrCode.1008"""))_
    val _1009 = parse_attribute (attribute ("""OASISErrCode.1009"""))_
    val _1010 = parse_attribute (attribute ("""OASISErrCode.1010"""))_
    def parse (context: Context): OASISErrCode =
    {
        OASISErrCode(
            sup (context),
            _1000 (context),
            _1001 (context),
            _1002 (context),
            _1003 (context),
            _1004 (context),
            _1005 (context),
            _1006 (context),
            _1007 (context),
            _1008 (context),
            _1009 (context),
            _1010 (context)
        )
    }
}

case class OASISErrDescription
(

    override val sup: BasicElement,

    val Data_can_be_requested_for_period_of_31_days_only: String,

    val Exceptions_in_reading_and_writing_of_XML_files: String,

    val Invalid_date_format__please_use_valid_date_format: String,

    val No_data_returned_for_the_specified_selection: String,

    val Out_of_memory_exception: String,

    val Report_name_does_not_exit__please_use_valid_report_name: String,

    val Required_file_does_not_exist: String,

    val System_Error: String,

    val Timed_out_waiting_for_query_response: String,

    val Validation_exception_during_transformation_of_XML: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[OASISErrDescription]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OASISErrDescription
extends
    Parseable[OASISErrDescription]
{
    val sup = BasicElement.parse _
    val Data_can_be_requested_for_period_of_31_days_only = parse_attribute (attribute ("""OASISErrDescription.Data can be requested for period of 31 days only"""))_
    val Exceptions_in_reading_and_writing_of_XML_files = parse_attribute (attribute ("""OASISErrDescription.Exceptions in reading and writing of XML files"""))_
    val Invalid_date_format__please_use_valid_date_format = parse_attribute (attribute ("""OASISErrDescription.Invalid date format, please use valid date format"""))_
    val No_data_returned_for_the_specified_selection = parse_attribute (attribute ("""OASISErrDescription.No data returned for the specified selection"""))_
    val Out_of_memory_exception = parse_attribute (attribute ("""OASISErrDescription.Out of memory exception"""))_
    val Report_name_does_not_exit__please_use_valid_report_name = parse_attribute (attribute ("""OASISErrDescription.Report name does not exit, please use valid report name"""))_
    val Required_file_does_not_exist = parse_attribute (attribute ("""OASISErrDescription.Required file does not exist"""))_
    val System_Error = parse_attribute (attribute ("""OASISErrDescription.System Error"""))_
    val Timed_out_waiting_for_query_response = parse_attribute (attribute ("""OASISErrDescription.Timed out waiting for query response"""))_
    val Validation_exception_during_transformation_of_XML = parse_attribute (attribute ("""OASISErrDescription.Validation exception during transformation of XML"""))_
    def parse (context: Context): OASISErrDescription =
    {
        OASISErrDescription(
            sup (context),
            Data_can_be_requested_for_period_of_31_days_only (context),
            Exceptions_in_reading_and_writing_of_XML_files (context),
            Invalid_date_format__please_use_valid_date_format (context),
            No_data_returned_for_the_specified_selection (context),
            Out_of_memory_exception (context),
            Report_name_does_not_exit__please_use_valid_report_name (context),
            Required_file_does_not_exist (context),
            System_Error (context),
            Timed_out_waiting_for_query_response (context),
            Validation_exception_during_transformation_of_XML (context)
        )
    }
}

case class OASISIntervalType
(

    override val sup: BasicElement,

    val BEGINNING: String,

    val ENDING: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[OASISIntervalType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OASISIntervalType
extends
    Parseable[OASISIntervalType]
{
    val sup = BasicElement.parse _
    val BEGINNING = parse_attribute (attribute ("""OASISIntervalType.BEGINNING"""))_
    val ENDING = parse_attribute (attribute ("""OASISIntervalType.ENDING"""))_
    def parse (context: Context): OASISIntervalType =
    {
        OASISIntervalType(
            sup (context),
            BEGINNING (context),
            ENDING (context)
        )
    }
}

case class OASISMarketType
(

    override val sup: BasicElement,

    val All: String,

    val HASP: String,

    val IFM: String,

    val N_A: String,

    val RTM: String,

    val RUC: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[OASISMarketType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OASISMarketType
extends
    Parseable[OASISMarketType]
{
    val sup = BasicElement.parse _
    val All = parse_attribute (attribute ("""OASISMarketType.All"""))_
    val HASP = parse_attribute (attribute ("""OASISMarketType.HASP"""))_
    val IFM = parse_attribute (attribute ("""OASISMarketType.IFM"""))_
    val N_A = parse_attribute (attribute ("""OASISMarketType.N/A"""))_
    val RTM = parse_attribute (attribute ("""OASISMarketType.RTM"""))_
    val RUC = parse_attribute (attribute ("""OASISMarketType.RUC"""))_
    def parse (context: Context): OASISMarketType =
    {
        OASISMarketType(
            sup (context),
            All (context),
            HASP (context),
            IFM (context),
            N_A (context),
            RTM (context),
            RUC (context)
        )
    }
}

case class OASISMasterType
(

    override val sup: BasicElement,

    val ATL_APNODE: String,

    val ATL_AS_REGION: String,

    val ATL_AS_REGION_MAP: String,

    val ATL_HUB: String,

    val ATL_LAP: String,

    val ATL_LDF: String,

    val ATL_PNODE: String,

    val ATL_PNODE_MAP: String,

    val ATL_PUB: String,

    val ATL_PUB_SCHED: String,

    val ATL_RESOURCE: String,

    val ATL_RUC_ZONE: String,

    val ATL_RUC_ZONE_MAP: String,

    val ATL_STAT: String,

    val ATL_TAC_AREA: String,

    val ATL_TAC_AREA_MAP: String,

    val ATL_TI: String,

    val ATL_TIEPOINT: String,

    val ATL_XREF: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[OASISMasterType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OASISMasterType
extends
    Parseable[OASISMasterType]
{
    val sup = BasicElement.parse _
    val ATL_APNODE = parse_attribute (attribute ("""OASISMasterType.ATL_APNODE"""))_
    val ATL_AS_REGION = parse_attribute (attribute ("""OASISMasterType.ATL_AS_REGION"""))_
    val ATL_AS_REGION_MAP = parse_attribute (attribute ("""OASISMasterType.ATL_AS_REGION_MAP"""))_
    val ATL_HUB = parse_attribute (attribute ("""OASISMasterType.ATL_HUB"""))_
    val ATL_LAP = parse_attribute (attribute ("""OASISMasterType.ATL_LAP"""))_
    val ATL_LDF = parse_attribute (attribute ("""OASISMasterType.ATL_LDF"""))_
    val ATL_PNODE = parse_attribute (attribute ("""OASISMasterType.ATL_PNODE"""))_
    val ATL_PNODE_MAP = parse_attribute (attribute ("""OASISMasterType.ATL_PNODE_MAP"""))_
    val ATL_PUB = parse_attribute (attribute ("""OASISMasterType.ATL_PUB"""))_
    val ATL_PUB_SCHED = parse_attribute (attribute ("""OASISMasterType.ATL_PUB_SCHED"""))_
    val ATL_RESOURCE = parse_attribute (attribute ("""OASISMasterType.ATL_RESOURCE"""))_
    val ATL_RUC_ZONE = parse_attribute (attribute ("""OASISMasterType.ATL_RUC_ZONE"""))_
    val ATL_RUC_ZONE_MAP = parse_attribute (attribute ("""OASISMasterType.ATL_RUC_ZONE_MAP"""))_
    val ATL_STAT = parse_attribute (attribute ("""OASISMasterType.ATL_STAT"""))_
    val ATL_TAC_AREA = parse_attribute (attribute ("""OASISMasterType.ATL_TAC_AREA"""))_
    val ATL_TAC_AREA_MAP = parse_attribute (attribute ("""OASISMasterType.ATL_TAC_AREA_MAP"""))_
    val ATL_TI = parse_attribute (attribute ("""OASISMasterType.ATL_TI"""))_
    val ATL_TIEPOINT = parse_attribute (attribute ("""OASISMasterType.ATL_TIEPOINT"""))_
    val ATL_XREF = parse_attribute (attribute ("""OASISMasterType.ATL_XREF"""))_
    def parse (context: Context): OASISMasterType =
    {
        OASISMasterType(
            sup (context),
            ATL_APNODE (context),
            ATL_AS_REGION (context),
            ATL_AS_REGION_MAP (context),
            ATL_HUB (context),
            ATL_LAP (context),
            ATL_LDF (context),
            ATL_PNODE (context),
            ATL_PNODE_MAP (context),
            ATL_PUB (context),
            ATL_PUB_SCHED (context),
            ATL_RESOURCE (context),
            ATL_RUC_ZONE (context),
            ATL_RUC_ZONE_MAP (context),
            ATL_STAT (context),
            ATL_TAC_AREA (context),
            ATL_TAC_AREA_MAP (context),
            ATL_TI (context),
            ATL_TIEPOINT (context),
            ATL_XREF (context)
        )
    }
}

case class OASISMeasType
(

    override val sup: BasicElement,

    val percent: String,

    val FACTOR: String,

    val FLAG: String,

    val INTEGER: String,

    val MW: String,

    val MWh: String,

    val US$: String,

    val US$_MW: String,

    val US$_MWh: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[OASISMeasType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OASISMeasType
extends
    Parseable[OASISMeasType]
{
    val sup = BasicElement.parse _
    val percent = parse_attribute (attribute ("""OASISMeasType.%"""))_
    val FACTOR = parse_attribute (attribute ("""OASISMeasType.FACTOR"""))_
    val FLAG = parse_attribute (attribute ("""OASISMeasType.FLAG"""))_
    val INTEGER = parse_attribute (attribute ("""OASISMeasType.INTEGER"""))_
    val MW = parse_attribute (attribute ("""OASISMeasType.MW"""))_
    val MWh = parse_attribute (attribute ("""OASISMeasType.MWh"""))_
    val US$ = parse_attribute (attribute ("""OASISMeasType.US$"""))_
    val US$_MW = parse_attribute (attribute ("""OASISMeasType.US$/MW"""))_
    val US$_MWh = parse_attribute (attribute ("""OASISMeasType.US$/MWh"""))_
    def parse (context: Context): OASISMeasType =
    {
        OASISMeasType(
            sup (context),
            percent (context),
            FACTOR (context),
            FLAG (context),
            INTEGER (context),
            MW (context),
            MWh (context),
            US$ (context),
            US$_MW (context),
            US$_MWh (context)
        )
    }
}

case class OASISReportType
(

    override val sup: BasicElement,

    val AS_DA_RESULT: String,

    val AS_OP_RSRV: String,

    val AS_REQ: String,

    val AS_RTM_RESULT: String,

    val BIDS_PUBLIC: String,

    val CMMT_RA_MLC: String,

    val CMMT_RMR: String,

    val CRR_CLEARING: String,

    val CRR_INVENTORY: String,

    val ENE_EA: String,

    val ENE_HASP: String,

    val ENE_IFM: String,

    val ENE_MPM: String,

    val ENE_RTM: String,

    val ENE_RUC: String,

    val LOSS_DA_HASP: String,

    val LOSS_RTM: String,

    val PRC_AS: String,

    val PRC_CNSTR: String,

    val PRC_FUEL: String,

    val PRC_HRLY_LMP: String,

    val PRC_INTVL_LMP: String,

    val SLD_FCST: String,

    val SLD_FCST_PEAK: String,

    val SLD_MKTS: String,

    val TRNS_ATC: String,

    val TRNS_OUTAGE: String,

    val TRNS_USAGE: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[OASISReportType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OASISReportType
extends
    Parseable[OASISReportType]
{
    val sup = BasicElement.parse _
    val AS_DA_RESULT = parse_attribute (attribute ("""OASISReportType.AS_DA_RESULT"""))_
    val AS_OP_RSRV = parse_attribute (attribute ("""OASISReportType.AS_OP_RSRV"""))_
    val AS_REQ = parse_attribute (attribute ("""OASISReportType.AS_REQ"""))_
    val AS_RTM_RESULT = parse_attribute (attribute ("""OASISReportType.AS_RTM_RESULT"""))_
    val BIDS_PUBLIC = parse_attribute (attribute ("""OASISReportType.BIDS_PUBLIC"""))_
    val CMMT_RA_MLC = parse_attribute (attribute ("""OASISReportType.CMMT_RA_MLC"""))_
    val CMMT_RMR = parse_attribute (attribute ("""OASISReportType.CMMT_RMR"""))_
    val CRR_CLEARING = parse_attribute (attribute ("""OASISReportType.CRR_CLEARING"""))_
    val CRR_INVENTORY = parse_attribute (attribute ("""OASISReportType.CRR_INVENTORY"""))_
    val ENE_EA = parse_attribute (attribute ("""OASISReportType.ENE_EA"""))_
    val ENE_HASP = parse_attribute (attribute ("""OASISReportType.ENE_HASP"""))_
    val ENE_IFM = parse_attribute (attribute ("""OASISReportType.ENE_IFM"""))_
    val ENE_MPM = parse_attribute (attribute ("""OASISReportType.ENE_MPM"""))_
    val ENE_RTM = parse_attribute (attribute ("""OASISReportType.ENE_RTM"""))_
    val ENE_RUC = parse_attribute (attribute ("""OASISReportType.ENE_RUC"""))_
    val LOSS_DA_HASP = parse_attribute (attribute ("""OASISReportType.LOSS_DA_HASP"""))_
    val LOSS_RTM = parse_attribute (attribute ("""OASISReportType.LOSS_RTM"""))_
    val PRC_AS = parse_attribute (attribute ("""OASISReportType.PRC_AS"""))_
    val PRC_CNSTR = parse_attribute (attribute ("""OASISReportType.PRC_CNSTR"""))_
    val PRC_FUEL = parse_attribute (attribute ("""OASISReportType.PRC_FUEL"""))_
    val PRC_HRLY_LMP = parse_attribute (attribute ("""OASISReportType.PRC_HRLY_LMP"""))_
    val PRC_INTVL_LMP = parse_attribute (attribute ("""OASISReportType.PRC_INTVL_LMP"""))_
    val SLD_FCST = parse_attribute (attribute ("""OASISReportType.SLD_FCST"""))_
    val SLD_FCST_PEAK = parse_attribute (attribute ("""OASISReportType.SLD_FCST_PEAK"""))_
    val SLD_MKTS = parse_attribute (attribute ("""OASISReportType.SLD_MKTS"""))_
    val TRNS_ATC = parse_attribute (attribute ("""OASISReportType.TRNS_ATC"""))_
    val TRNS_OUTAGE = parse_attribute (attribute ("""OASISReportType.TRNS_OUTAGE"""))_
    val TRNS_USAGE = parse_attribute (attribute ("""OASISReportType.TRNS_USAGE"""))_
    def parse (context: Context): OASISReportType =
    {
        OASISReportType(
            sup (context),
            AS_DA_RESULT (context),
            AS_OP_RSRV (context),
            AS_REQ (context),
            AS_RTM_RESULT (context),
            BIDS_PUBLIC (context),
            CMMT_RA_MLC (context),
            CMMT_RMR (context),
            CRR_CLEARING (context),
            CRR_INVENTORY (context),
            ENE_EA (context),
            ENE_HASP (context),
            ENE_IFM (context),
            ENE_MPM (context),
            ENE_RTM (context),
            ENE_RUC (context),
            LOSS_DA_HASP (context),
            LOSS_RTM (context),
            PRC_AS (context),
            PRC_CNSTR (context),
            PRC_FUEL (context),
            PRC_HRLY_LMP (context),
            PRC_INTVL_LMP (context),
            SLD_FCST (context),
            SLD_FCST_PEAK (context),
            SLD_MKTS (context),
            TRNS_ATC (context),
            TRNS_OUTAGE (context),
            TRNS_USAGE (context)
        )
    }
}

case class OASISStatusType
(

    override val sup: BasicElement,

    val Data_Transfer_Procedure_Initiated: String,

    val Data_Transfer_Succesful: String,

    val Forced_Termination: String,

    val Obsolete: String,

    val Push_Failed: String,

    val Valid: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[OASISStatusType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OASISStatusType
extends
    Parseable[OASISStatusType]
{
    val sup = BasicElement.parse _
    val Data_Transfer_Procedure_Initiated = parse_attribute (attribute ("""OASISStatusType.Data_Transfer_Procedure_Initiated"""))_
    val Data_Transfer_Succesful = parse_attribute (attribute ("""OASISStatusType.Data_Transfer_Succesful"""))_
    val Forced_Termination = parse_attribute (attribute ("""OASISStatusType.Forced_Termination"""))_
    val Obsolete = parse_attribute (attribute ("""OASISStatusType.Obsolete"""))_
    val Push_Failed = parse_attribute (attribute ("""OASISStatusType.Push_Failed"""))_
    val Valid = parse_attribute (attribute ("""OASISStatusType.Valid"""))_
    def parse (context: Context): OASISStatusType =
    {
        OASISStatusType(
            sup (context),
            Data_Transfer_Procedure_Initiated (context),
            Data_Transfer_Succesful (context),
            Forced_Termination (context),
            Obsolete (context),
            Push_Failed (context),
            Valid (context)
        )
    }
}

/**
 * organization code
 */
case class OrganisationCode
(

    override val sup: BasicElement,

    val BILL_TO: String,

    val PAY_TO: String,

    val PROVIDED_BY: String,

    val SOLD_TO: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[OrganisationCode]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OrganisationCode
extends
    Parseable[OrganisationCode]
{
    val sup = BasicElement.parse _
    val BILL_TO = parse_attribute (attribute ("""OrganisationCode.BILL_TO"""))_
    val PAY_TO = parse_attribute (attribute ("""OrganisationCode.PAY_TO"""))_
    val PROVIDED_BY = parse_attribute (attribute ("""OrganisationCode.PROVIDED_BY"""))_
    val SOLD_TO = parse_attribute (attribute ("""OrganisationCode.SOLD_TO"""))_
    def parse (context: Context): OrganisationCode =
    {
        OrganisationCode(
            sup (context),
            BILL_TO (context),
            PAY_TO (context),
            PROVIDED_BY (context),
            SOLD_TO (context)
        )
    }
}

/**
 * organization type
 */
case class OrganisationType
(

    override val sup: BasicElement,

    val CUSTOMER: String,

    val RTO: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[OrganisationType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OrganisationType
extends
    Parseable[OrganisationType]
{
    val sup = BasicElement.parse _
    val CUSTOMER = parse_attribute (attribute ("""OrganisationType.CUSTOMER"""))_
    val RTO = parse_attribute (attribute ("""OrganisationType.RTO"""))_
    def parse (context: Context): OrganisationType =
    {
        OrganisationType(
            sup (context),
            CUSTOMER (context),
            RTO (context)
        )
    }
}

/**
 * Y - indicates a resource is capable of setting the Markte Clearing Price 
S - indicates the resource must submit bids for energy at $ 0
 * N - indicates the resource does not have to submit bids for energy at $ 0
 */
case class PriceSetFlag
(

    override val sup: BasicElement,

    val N: String,

    val S: String,

    val Y: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[PriceSetFlag]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PriceSetFlag
extends
    Parseable[PriceSetFlag]
{
    val sup = BasicElement.parse _
    val N = parse_attribute (attribute ("""PriceSetFlag.N"""))_
    val S = parse_attribute (attribute ("""PriceSetFlag.S"""))_
    val Y = parse_attribute (attribute ("""PriceSetFlag.Y"""))_
    def parse (context: Context): PriceSetFlag =
    {
        PriceSetFlag(
            sup (context),
            N (context),
            S (context),
            Y (context)
        )
    }
}

/**
 * MP
 * ISO
 */
case class RequestorRmrTest
(

    override val sup: BasicElement,

    val ISO: String,

    val MP: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[RequestorRmrTest]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RequestorRmrTest
extends
    Parseable[RequestorRmrTest]
{
    val sup = BasicElement.parse _
    val ISO = parse_attribute (attribute ("""RequestorRmrTest.ISO"""))_
    val MP = parse_attribute (attribute ("""RequestorRmrTest.MP"""))_
    def parse (context: Context): RequestorRmrTest =
    {
        RequestorRmrTest(
            sup (context),
            ISO (context),
            MP (context)
        )
    }
}

case class ResourceCertificationCategory
(

    override val sup: BasicElement,

    val DAM: String,

    /**
     * Generic
     */
    val GT: String,

    val RC: String,

    val RTM: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ResourceCertificationCategory]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ResourceCertificationCategory
extends
    Parseable[ResourceCertificationCategory]
{
    val sup = BasicElement.parse _
    val DAM = parse_attribute (attribute ("""ResourceCertificationCategory.DAM"""))_
    val GT = parse_attribute (attribute ("""ResourceCertificationCategory.GT"""))_
    val RC = parse_attribute (attribute ("""ResourceCertificationCategory.RC"""))_
    val RTM = parse_attribute (attribute ("""ResourceCertificationCategory.RTM"""))_
    def parse (context: Context): ResourceCertificationCategory =
    {
        ResourceCertificationCategory(
            sup (context),
            DAM (context),
            GT (context),
            RC (context),
            RTM (context)
        )
    }
}

case class ResourceCertificationType
(

    override val sup: BasicElement,

    /**
     * Generic Type
     */
    val GT: String,

    /**
     * Intermittent Resource
     */
    val IR: String,

    /**
     * Generic
    Regulation
    Spinning
    Non-spinning
     * Intermittent Resource
     */
    val NR: String,

    /**
     * Regulating
     */
    val RG: String,

    /**
     * Spinning Reserve
     */
    val SR: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ResourceCertificationType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ResourceCertificationType
extends
    Parseable[ResourceCertificationType]
{
    val sup = BasicElement.parse _
    val GT = parse_attribute (attribute ("""ResourceCertificationType.GT"""))_
    val IR = parse_attribute (attribute ("""ResourceCertificationType.IR"""))_
    val NR = parse_attribute (attribute ("""ResourceCertificationType.NR"""))_
    val RG = parse_attribute (attribute ("""ResourceCertificationType.RG"""))_
    val SR = parse_attribute (attribute ("""ResourceCertificationType.SR"""))_
    def parse (context: Context): ResourceCertificationType =
    {
        ResourceCertificationType(
            sup (context),
            GT (context),
            IR (context),
            NR (context),
            RG (context),
            SR (context)
        )
    }
}

case class SchedClassType
(

    override val sup: BasicElement,

    val F: String,

    val P: String,

    val R: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[SchedClassType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SchedClassType
extends
    Parseable[SchedClassType]
{
    val sup = BasicElement.parse _
    val F = parse_attribute (attribute ("""SchedClassType.F"""))_
    val P = parse_attribute (attribute ("""SchedClassType.P"""))_
    val R = parse_attribute (attribute ("""SchedClassType.R"""))_
    def parse (context: Context): SchedClassType =
    {
        SchedClassType(
            sup (context),
            F (context),
            P (context),
            R (context)
        )
    }
}

case class SegmentCurveType
(

    override val sup: BasicElement,

    val CONSULTATIVE: String,

    val COST: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[SegmentCurveType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SegmentCurveType
extends
    Parseable[SegmentCurveType]
{
    val sup = BasicElement.parse _
    val CONSULTATIVE = parse_attribute (attribute ("""SegmentCurveType.CONSULTATIVE"""))_
    val COST = parse_attribute (attribute ("""SegmentCurveType.COST"""))_
    def parse (context: Context): SegmentCurveType =
    {
        SegmentCurveType(
            sup (context),
            CONSULTATIVE (context),
            COST (context)
        )
    }
}

case class SelfSchedTypeCleanBid
(

    override val sup: BasicElement,

    val BAS: String,

    val ETC: String,

    val IFM: String,

    val LOF: String,

    val LPT: String,

    val PT: String,

    /**
     * RA Obligations
     */
    val RA: String,

    val RMT: String,

    /**
     * Self-Provision
     */
    val SP: String,

    val TOR: String,

    val WHL: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[SelfSchedTypeCleanBid]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SelfSchedTypeCleanBid
extends
    Parseable[SelfSchedTypeCleanBid]
{
    val sup = BasicElement.parse _
    val BAS = parse_attribute (attribute ("""SelfSchedTypeCleanBid.BAS"""))_
    val ETC = parse_attribute (attribute ("""SelfSchedTypeCleanBid.ETC"""))_
    val IFM = parse_attribute (attribute ("""SelfSchedTypeCleanBid.IFM"""))_
    val LOF = parse_attribute (attribute ("""SelfSchedTypeCleanBid.LOF"""))_
    val LPT = parse_attribute (attribute ("""SelfSchedTypeCleanBid.LPT"""))_
    val PT = parse_attribute (attribute ("""SelfSchedTypeCleanBid.PT"""))_
    val RA = parse_attribute (attribute ("""SelfSchedTypeCleanBid.RA"""))_
    val RMT = parse_attribute (attribute ("""SelfSchedTypeCleanBid.RMT"""))_
    val SP = parse_attribute (attribute ("""SelfSchedTypeCleanBid.SP"""))_
    val TOR = parse_attribute (attribute ("""SelfSchedTypeCleanBid.TOR"""))_
    val WHL = parse_attribute (attribute ("""SelfSchedTypeCleanBid.WHL"""))_
    def parse (context: Context): SelfSchedTypeCleanBid =
    {
        SelfSchedTypeCleanBid(
            sup (context),
            BAS (context),
            ETC (context),
            IFM (context),
            LOF (context),
            LPT (context),
            PT (context),
            RA (context),
            RMT (context),
            SP (context),
            TOR (context),
            WHL (context)
        )
    }
}

case class SelfSchedTypeRawBid
(

    override val sup: BasicElement,

    val BAS: String,

    val ETC: String,

    val LOF: String,

    val LPT: String,

    val PT: String,

    /**
     * RA Obligations
     */
    val RA: String,

    val RMT: String,

    /**
     * Self-Provision
     */
    val SP: String,

    val TOR: String,

    val WHL: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[SelfSchedTypeRawBid]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SelfSchedTypeRawBid
extends
    Parseable[SelfSchedTypeRawBid]
{
    val sup = BasicElement.parse _
    val BAS = parse_attribute (attribute ("""SelfSchedTypeRawBid.BAS"""))_
    val ETC = parse_attribute (attribute ("""SelfSchedTypeRawBid.ETC"""))_
    val LOF = parse_attribute (attribute ("""SelfSchedTypeRawBid.LOF"""))_
    val LPT = parse_attribute (attribute ("""SelfSchedTypeRawBid.LPT"""))_
    val PT = parse_attribute (attribute ("""SelfSchedTypeRawBid.PT"""))_
    val RA = parse_attribute (attribute ("""SelfSchedTypeRawBid.RA"""))_
    val RMT = parse_attribute (attribute ("""SelfSchedTypeRawBid.RMT"""))_
    val SP = parse_attribute (attribute ("""SelfSchedTypeRawBid.SP"""))_
    val TOR = parse_attribute (attribute ("""SelfSchedTypeRawBid.TOR"""))_
    val WHL = parse_attribute (attribute ("""SelfSchedTypeRawBid.WHL"""))_
    def parse (context: Context): SelfSchedTypeRawBid =
    {
        SelfSchedTypeRawBid(
            sup (context),
            BAS (context),
            ETC (context),
            LOF (context),
            LPT (context),
            PT (context),
            RA (context),
            RMT (context),
            SP (context),
            TOR (context),
            WHL (context)
        )
    }
}

/**
 * self schedule types

PT
ETC
TOR
RMR
RMT
RGMR
ORFC
 * SP
 */
case class SelfScheduleType
(

    override val sup: BasicElement,

    /**
     * Base Schedule
     */
    val BAS: String,

    val ETC: String,

    val IFM: String,

    /**
     * Lay-off schedule
     */
    val LOF: String,

    val ORFC: String,

    val PT: String,

    val PUMP_ETC: String,

    val PUMP_TOR: String,

    /**
     * RA Obligations
     */
    val RA: String,

    val RGMR: String,

    val RMR: String,

    val RMT: String,

    val RUC: String,

    /**
     * Self-Provision
     */
    val SP: String,

    val TOR: String,

    val WHL: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[SelfScheduleType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SelfScheduleType
extends
    Parseable[SelfScheduleType]
{
    val sup = BasicElement.parse _
    val BAS = parse_attribute (attribute ("""SelfScheduleType.BAS"""))_
    val ETC = parse_attribute (attribute ("""SelfScheduleType.ETC"""))_
    val IFM = parse_attribute (attribute ("""SelfScheduleType.IFM"""))_
    val LOF = parse_attribute (attribute ("""SelfScheduleType.LOF"""))_
    val ORFC = parse_attribute (attribute ("""SelfScheduleType.ORFC"""))_
    val PT = parse_attribute (attribute ("""SelfScheduleType.PT"""))_
    val PUMP_ETC = parse_attribute (attribute ("""SelfScheduleType.PUMP_ETC"""))_
    val PUMP_TOR = parse_attribute (attribute ("""SelfScheduleType.PUMP_TOR"""))_
    val RA = parse_attribute (attribute ("""SelfScheduleType.RA"""))_
    val RGMR = parse_attribute (attribute ("""SelfScheduleType.RGMR"""))_
    val RMR = parse_attribute (attribute ("""SelfScheduleType.RMR"""))_
    val RMT = parse_attribute (attribute ("""SelfScheduleType.RMT"""))_
    val RUC = parse_attribute (attribute ("""SelfScheduleType.RUC"""))_
    val SP = parse_attribute (attribute ("""SelfScheduleType.SP"""))_
    val TOR = parse_attribute (attribute ("""SelfScheduleType.TOR"""))_
    val WHL = parse_attribute (attribute ("""SelfScheduleType.WHL"""))_
    def parse (context: Context): SelfScheduleType =
    {
        SelfScheduleType(
            sup (context),
            BAS (context),
            ETC (context),
            IFM (context),
            LOF (context),
            ORFC (context),
            PT (context),
            PUMP_ETC (context),
            PUMP_TOR (context),
            RA (context),
            RGMR (context),
            RMR (context),
            RMT (context),
            RUC (context),
            SP (context),
            TOR (context),
            WHL (context)
        )
    }
}

/**
 * Self Schedule Types applicable to Mitigated Bid
 */
case class SelfScheduleTypeMB
(

    override val sup: BasicElement,

    val RMR: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[SelfScheduleTypeMB]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SelfScheduleTypeMB
extends
    Parseable[SelfScheduleTypeMB]
{
    val sup = BasicElement.parse _
    val RMR = parse_attribute (attribute ("""SelfScheduleTypeMB.RMR"""))_
    def parse (context: Context): SelfScheduleTypeMB =
    {
        SelfScheduleTypeMB(
            sup (context),
            RMR (context)
        )
    }
}

case class SourceSinkFlag
(

    override val sup: BasicElement,

    val CSNK: String,

    val CSRC: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[SourceSinkFlag]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SourceSinkFlag
extends
    Parseable[SourceSinkFlag]
{
    val sup = BasicElement.parse _
    val CSNK = parse_attribute (attribute ("""SourceSinkFlag.CSNK"""))_
    val CSRC = parse_attribute (attribute ("""SourceSinkFlag.CSRC"""))_
    def parse (context: Context): SourceSinkFlag =
    {
        SourceSinkFlag(
            sup (context),
            CSNK (context),
            CSRC (context)
        )
    }
}

case class SourceSinkType
(

    override val sup: BasicElement,

    val Neither: String,

    val Sink: String,

    val Source: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[SourceSinkType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SourceSinkType
extends
    Parseable[SourceSinkType]
{
    val sup = BasicElement.parse _
    val Neither = parse_attribute (attribute ("""SourceSinkType.Neither"""))_
    val Sink = parse_attribute (attribute ("""SourceSinkType.Sink"""))_
    val Source = parse_attribute (attribute ("""SourceSinkType.Source"""))_
    def parse (context: Context): SourceSinkType =
    {
        SourceSinkType(
            sup (context),
            Neither (context),
            Sink (context),
            Source (context)
        )
    }
}

case class SpinningEventNameType
(

    override val sup: BasicElement,

    val EASTERN: String,

    val PJM: String,

    val RFC_SR: String,

    val SOUTH_S: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[SpinningEventNameType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SpinningEventNameType
extends
    Parseable[SpinningEventNameType]
{
    val sup = BasicElement.parse _
    val EASTERN = parse_attribute (attribute ("""SpinningEventNameType.EASTERN"""))_
    val PJM = parse_attribute (attribute ("""SpinningEventNameType.PJM"""))_
    val RFC_SR = parse_attribute (attribute ("""SpinningEventNameType.RFC-SR"""))_
    val SOUTH_S = parse_attribute (attribute ("""SpinningEventNameType.SOUTH-S"""))_
    def parse (context: Context): SpinningEventNameType =
    {
        SpinningEventNameType(
            sup (context),
            EASTERN (context),
            PJM (context),
            RFC_SR (context),
            SOUTH_S (context)
        )
    }
}

case class SpinningEventType
(

    override val sup: BasicElement,

    val AA: String,

    val CA: String,

    val RZ: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[SpinningEventType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SpinningEventType
extends
    Parseable[SpinningEventType]
{
    val sup = BasicElement.parse _
    val AA = parse_attribute (attribute ("""SpinningEventType.AA"""))_
    val CA = parse_attribute (attribute ("""SpinningEventType.CA"""))_
    val RZ = parse_attribute (attribute ("""SpinningEventType.RZ"""))_
    def parse (context: Context): SpinningEventType =
    {
        SpinningEventType(
            sup (context),
            AA (context),
            CA (context),
            RZ (context)
        )
    }
}

case class SystemType
(

    override val sup: BasicElement,

    val OASIS: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[SystemType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SystemType
extends
    Parseable[SystemType]
{
    val sup = BasicElement.parse _
    val OASIS = parse_attribute (attribute ("""SystemType.OASIS"""))_
    def parse (context: Context): SystemType =
    {
        SystemType(
            sup (context),
            OASIS (context)
        )
    }
}

case class TimeZoneType
(

    override val sup: BasicElement,

    val PPT: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TimeZoneType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TimeZoneType
extends
    Parseable[TimeZoneType]
{
    val sup = BasicElement.parse _
    val PPT = parse_attribute (attribute ("""TimeZoneType.PPT"""))_
    def parse (context: Context): TimeZoneType =
    {
        TimeZoneType(
            sup (context),
            PPT (context)
        )
    }
}

case class TradeProductType
(

    override val sup: BasicElement,

    /**
     * Energy Trades at Aggregated Pricing Nodes
     */
    val APN: String,

    /**
     * Capacity type trade
     */
    val CAP: String,

    /**
     * Non-Spinning Reserve Trade
     */
    val NRT: String,

    /**
     * Physical Energy Tra
     */
    val PHY: String,

    /**
     * Regulation Down Trade
     */
    val RDT: String,

    /**
     * Regulation Up Trade
     */
    val RUT: String,

    /**
     * Spinning Reserve Trade
     */
    val SRT: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TradeProductType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TradeProductType
extends
    Parseable[TradeProductType]
{
    val sup = BasicElement.parse _
    val APN = parse_attribute (attribute ("""TradeProductType.APN"""))_
    val CAP = parse_attribute (attribute ("""TradeProductType.CAP"""))_
    val NRT = parse_attribute (attribute ("""TradeProductType.NRT"""))_
    val PHY = parse_attribute (attribute ("""TradeProductType.PHY"""))_
    val RDT = parse_attribute (attribute ("""TradeProductType.RDT"""))_
    val RUT = parse_attribute (attribute ("""TradeProductType.RUT"""))_
    val SRT = parse_attribute (attribute ("""TradeProductType.SRT"""))_
    def parse (context: Context): TradeProductType =
    {
        TradeProductType(
            sup (context),
            APN (context),
            CAP (context),
            NRT (context),
            PHY (context),
            RDT (context),
            RUT (context),
            SRT (context)
        )
    }
}

/**
 * RJ - Rejected Trade
I - Invalid Trade
V - Valid Trade
M - Modified Trade
CV - Conditionally Valid Trade
CM - Conditionally Modified Trade
CI - Conditionally Invalid Trade
CX - Cancelled Trade
O - Obsolete Trade
MT - Matched Trade
 * U - Unmatched Trade
 */
case class TradeStatusType
(

    override val sup: BasicElement,

    val CI: String,

    val CM: String,

    val CV: String,

    val CX: String,

    val I: String,

    val M: String,

    val MT: String,

    val O: String,

    val RJ: String,

    val U: String,

    val V: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TradeStatusType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TradeStatusType
extends
    Parseable[TradeStatusType]
{
    val sup = BasicElement.parse _
    val CI = parse_attribute (attribute ("""TradeStatusType.CI"""))_
    val CM = parse_attribute (attribute ("""TradeStatusType.CM"""))_
    val CV = parse_attribute (attribute ("""TradeStatusType.CV"""))_
    val CX = parse_attribute (attribute ("""TradeStatusType.CX"""))_
    val I = parse_attribute (attribute ("""TradeStatusType.I"""))_
    val M = parse_attribute (attribute ("""TradeStatusType.M"""))_
    val MT = parse_attribute (attribute ("""TradeStatusType.MT"""))_
    val O = parse_attribute (attribute ("""TradeStatusType.O"""))_
    val RJ = parse_attribute (attribute ("""TradeStatusType.RJ"""))_
    val U = parse_attribute (attribute ("""TradeStatusType.U"""))_
    val V = parse_attribute (attribute ("""TradeStatusType.V"""))_
    def parse (context: Context): TradeStatusType =
    {
        TradeStatusType(
            sup (context),
            CI (context),
            CM (context),
            CV (context),
            CX (context),
            I (context),
            M (context),
            MT (context),
            O (context),
            RJ (context),
            U (context),
            V (context)
        )
    }
}

case class UOMType
(

    override val sup: BasicElement,

    val percent: String,

    val $_lb: String,

    val $_mmBTU: String,

    val FACTOR: String,

    val FLAG: String,

    val INTEGER: String,

    val MW: String,

    val MWh: String,

    val US$: String,

    val US$_MW: String,

    val US$_MWh: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[UOMType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object UOMType
extends
    Parseable[UOMType]
{
    val sup = BasicElement.parse _
    val percent = parse_attribute (attribute ("""UOMType.%"""))_
    val $_lb = parse_attribute (attribute ("""UOMType.$/lb"""))_
    val $_mmBTU = parse_attribute (attribute ("""UOMType.$/mmBTU"""))_
    val FACTOR = parse_attribute (attribute ("""UOMType.FACTOR"""))_
    val FLAG = parse_attribute (attribute ("""UOMType.FLAG"""))_
    val INTEGER = parse_attribute (attribute ("""UOMType.INTEGER"""))_
    val MW = parse_attribute (attribute ("""UOMType.MW"""))_
    val MWh = parse_attribute (attribute ("""UOMType.MWh"""))_
    val US$ = parse_attribute (attribute ("""UOMType.US$"""))_
    val US$_MW = parse_attribute (attribute ("""UOMType.US$/MW"""))_
    val US$_MWh = parse_attribute (attribute ("""UOMType.US$/MWh"""))_
    def parse (context: Context): UOMType =
    {
        UOMType(
            sup (context),
            percent (context),
            $_lb (context),
            $_mmBTU (context),
            FACTOR (context),
            FLAG (context),
            INTEGER (context),
            MW (context),
            MWh (context),
            US$ (context),
            US$_MW (context),
            US$_MWh (context)
        )
    }
}

/**
 * MW
 * FLAG
 */
case class UnitTypeEMS
(

    override val sup: BasicElement,

    val FLAG: String,

    val MW: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[UnitTypeEMS]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object UnitTypeEMS
extends
    Parseable[UnitTypeEMS]
{
    val sup = BasicElement.parse _
    val FLAG = parse_attribute (attribute ("""UnitTypeEMS.FLAG"""))_
    val MW = parse_attribute (attribute ("""UnitTypeEMS.MW"""))_
    def parse (context: Context): UnitTypeEMS =
    {
        UnitTypeEMS(
            sup (context),
            FLAG (context),
            MW (context)
        )
    }
}

/**
 * zone type
 */
case class ZoneType
(

    override val sup: BasicElement,

    /**
     * ancillary service region
     */
    val ASREGION: String,

    /**
     * designated congestion area
     */
    val DCA: String,

    /**
     * load zone
     */
    val LOADZONE: String,

    /**
     * RUC zone
     */
    val RUCZONE: String,

    /**
     * trading hub
     */
    val TRADINGHUB: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ZoneType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ZoneType
extends
    Parseable[ZoneType]
{
    val sup = BasicElement.parse _
    val ASREGION = parse_attribute (attribute ("""ZoneType.ASREGION"""))_
    val DCA = parse_attribute (attribute ("""ZoneType.DCA"""))_
    val LOADZONE = parse_attribute (attribute ("""ZoneType.LOADZONE"""))_
    val RUCZONE = parse_attribute (attribute ("""ZoneType.RUCZONE"""))_
    val TRADINGHUB = parse_attribute (attribute ("""ZoneType.TRADINGHUB"""))_
    def parse (context: Context): ZoneType =
    {
        ZoneType(
            sup (context),
            ASREGION (context),
            DCA (context),
            LOADZONE (context),
            RUCZONE (context),
            TRADINGHUB (context)
        )
    }
}

/**
 * S - Scheduling
 * P - Pricing
 */
case class runTypeCAISO
(

    override val sup: BasicElement,

    val P: String,

    val S: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[runTypeCAISO]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object runTypeCAISO
extends
    Parseable[runTypeCAISO]
{
    val sup = BasicElement.parse _
    val P = parse_attribute (attribute ("""runTypeCAISO.P"""))_
    val S = parse_attribute (attribute ("""runTypeCAISO.S"""))_
    def parse (context: Context): runTypeCAISO =
    {
        runTypeCAISO(
            sup (context),
            P (context),
            S (context)
        )
    }
}

object _InfDomain
{
    def register: Unit =
    {
        ADSInstructionTypeCommitment.register
        ADSInstructionTypeOOS.register
        AdderType.register
        AlarmDisplayType.register
        AllocationEnergyTypeCode.register
        AncillaryCommodityType.register
        BidPriceCapType.register
        BidStatusType.register
        CleanTradeProductType.register
        CurrentStatusSC.register
        DAMMarketType.register
        DispatchAcceptStatus.register
        DispatchTransactionType.register
        EnergyTypeCode.register
        JobFlagType.register
        JobScheduleType.register
        JobStartEndType.register
        LFCResourceType.register
        LoadFollowingCapacityType.register
        MQSDELType.register
        MarketProductTypeAsReq.register
        MarketScheduleServices.register
        MarketStatementDescription.register
        MarketStatementDocStatus.register
        MarketStatementDocType.register
        MarketStatementLineItemAliasName.register
        MeasurementTypeEMS.register
        MktSubClassType.register
        OASISBidReportType.register
        OASISDataItems.register
        OASISErrCode.register
        OASISErrDescription.register
        OASISIntervalType.register
        OASISMarketType.register
        OASISMasterType.register
        OASISMeasType.register
        OASISReportType.register
        OASISStatusType.register
        OrganisationCode.register
        OrganisationType.register
        PriceSetFlag.register
        RequestorRmrTest.register
        ResourceCertificationCategory.register
        ResourceCertificationType.register
        SchedClassType.register
        SegmentCurveType.register
        SelfSchedTypeCleanBid.register
        SelfSchedTypeRawBid.register
        SelfScheduleType.register
        SelfScheduleTypeMB.register
        SourceSinkFlag.register
        SourceSinkType.register
        SpinningEventNameType.register
        SpinningEventType.register
        SystemType.register
        TimeZoneType.register
        TradeProductType.register
        TradeStatusType.register
        UOMType.register
        UnitTypeEMS.register
        ZoneType.register
        runTypeCAISO.register
    }
}
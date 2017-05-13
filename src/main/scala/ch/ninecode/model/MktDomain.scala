package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * The MktDomain package is a data dictionary of quantities and units that define datatypes for attributes (properties) that may be used by any class in any other package within MarketOperations.
 */

/**
 * Action type associated with an ActionRequest against a ParticipantInterfaces::Trade.
 */
case class ActionType
(

    override val sup: BasicElement,

    /**
     * Cancel a trade.
     */
    val CANCEL: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ActionType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ActionType
extends
    Parseable[ActionType]
{
    val sup = BasicElement.parse _
    val CANCEL = parse_attribute (attribute ("""ActionType.CANCEL"""))_
    def parse (context: Context): ActionType =
    {
        ActionType(
            sup (context),
            CANCEL (context)
        )
    }
}

/**
 * Limit type specified for AnalogLimits.
 */
case class AnalogLimitType
(

    override val sup: BasicElement,

    /**
     * Branch Long Term Limit
     */
    val BranchLongTerm: String,

    /**
     * Branch Medium Term Limit
     */
    val BranchMediumTerm: String,

    /**
     * Branch Short Term Limit
     */
    val BranchShortTerm: String,

    /**
     * Voltage High Limit
     */
    val VoltageHigh: String,

    /**
     * Voltage Low Limit
     */
    val VoltageLow: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AnalogLimitType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AnalogLimitType
extends
    Parseable[AnalogLimitType]
{
    val sup = BasicElement.parse _
    val BranchLongTerm = parse_attribute (attribute ("""AnalogLimitType.BranchLongTerm"""))_
    val BranchMediumTerm = parse_attribute (attribute ("""AnalogLimitType.BranchMediumTerm"""))_
    val BranchShortTerm = parse_attribute (attribute ("""AnalogLimitType.BranchShortTerm"""))_
    val VoltageHigh = parse_attribute (attribute ("""AnalogLimitType.VoltageHigh"""))_
    val VoltageLow = parse_attribute (attribute ("""AnalogLimitType.VoltageLow"""))_
    def parse (context: Context): AnalogLimitType =
    {
        AnalogLimitType(
            sup (context),
            BranchLongTerm (context),
            BranchMediumTerm (context),
            BranchShortTerm (context),
            VoltageHigh (context),
            VoltageLow (context)
        )
    }
}

/**
 * Aggregated Nodes Types for example:
<ul>
	<li>SYS - System Zone/Region; </li>
</ul>
<ul>
	<li>RUC - RUC Zone; </li>
</ul>
<ul>
	<li>LFZ - Load Forecast Zone; </li>
</ul>
<ul>
	<li>REG - Market Energy/Ancillary Service Region; </li>
</ul>
<ul>
	<li>AGR - Aggregate Generation Resource; </li>
</ul>
<ul>
	<li>POD - Point of Delivery; </li>
</ul>
<ul>
	<li>ALR - Aggregate Load Resource; </li>
</ul>
<ul>
	<li>LTAC - Load TransmissionAccessCharge (TAC) Group;</li>
</ul>
<ul>
	<li>ACA - Adjacent Control Area</li>
</ul>
<ul>
	<li>ASR - Aggregated System Resource</li>
</ul>
<ul>
	<li>ECA - Embedded Control Area</li>
 * </ul>
 */
case class AnodeType
(

    override val sup: BasicElement,

    /**
     * Adjacent Control Area
     */
    val ACA: String,

    /**
     * Aggregate Generation Resource;
     */
    val AGR: String,

    /**
     * Aggregate Load Resource;
     */
    val ALR: String,

    /**
     * Aggregated System Resource
     */
    val ASR: String,

    /**
     * Embedded Control Area
     */
    val ECA: String,

    /**
     * Load Forecast Zone
     */
    val LFZ: String,

    /**
     * Load TransmissionAccessCharge (TAC) Group;
     */
    val LTAC: String,

    /**
     * Point of Delivery;
     */
    val POD: String,

    /**
     * Market Energy/Ancillary Service Region;
     */
    val REG: String,

    /**
     * RUC Zone
     */
    val RUC: String,

    /**
     * System Zone/Region;
     */
    val SYS: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AnodeType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AnodeType
extends
    Parseable[AnodeType]
{
    val sup = BasicElement.parse _
    val ACA = parse_attribute (attribute ("""AnodeType.ACA"""))_
    val AGR = parse_attribute (attribute ("""AnodeType.AGR"""))_
    val ALR = parse_attribute (attribute ("""AnodeType.ALR"""))_
    val ASR = parse_attribute (attribute ("""AnodeType.ASR"""))_
    val ECA = parse_attribute (attribute ("""AnodeType.ECA"""))_
    val LFZ = parse_attribute (attribute ("""AnodeType.LFZ"""))_
    val LTAC = parse_attribute (attribute ("""AnodeType.LTAC"""))_
    val POD = parse_attribute (attribute ("""AnodeType.POD"""))_
    val REG = parse_attribute (attribute ("""AnodeType.REG"""))_
    val RUC = parse_attribute (attribute ("""AnodeType.RUC"""))_
    val SYS = parse_attribute (attribute ("""AnodeType.SYS"""))_
    def parse (context: Context): AnodeType =
    {
        AnodeType(
            sup (context),
            ACA (context),
            AGR (context),
            ALR (context),
            ASR (context),
            ECA (context),
            LFZ (context),
            LTAC (context),
            POD (context),
            REG (context),
            RUC (context),
            SYS (context)
        )
    }
}

/**
 * Aggregate Node Types for example:
AG -  Aggregated Generation
CPZ -  Custom Price Zone
DPZ -  Default Price Zone
LAP - Load Aggregation Point
TH -  Trading  Hub
SYS - System Zone
CA - Control Area

GA - generic aggregation
EHV - 500 kV
GH - generic hub
ZN - zone
INT - Interface
 * BUS - Bus
 */
case class ApnodeType
(

    override val sup: BasicElement,

    /**
     * Aggregated Generation
     */
    val AG: String,

    /**
     * Bus
     */
    val BUS: String,

    /**
     * Control Area
     */
    val CA: String,

    /**
     * Custom Price Zone
     */
    val CPZ: String,

    /**
     * Designated Congestion Area
     */
    val DCA: String,

    /**
     * Default Price Zone
     */
    val DPZ: String,

    /**
     * 500 kV - Extra High Voltage aggregate price nodes
     */
    val EHV: String,

    /**
     * generic aggregation
     */
    val GA: String,

    /**
     * generic hub
     */
    val GH: String,

    /**
     * Interface
     */
    val INT: String,

    /**
     * System Zone
     */
    val SYS: String,

    /**
     * Trading  Hub
     */
    val TH: String,

    /**
     * Zone
     */
    val ZN: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ApnodeType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ApnodeType
extends
    Parseable[ApnodeType]
{
    val sup = BasicElement.parse _
    val AG = parse_attribute (attribute ("""ApnodeType.AG"""))_
    val BUS = parse_attribute (attribute ("""ApnodeType.BUS"""))_
    val CA = parse_attribute (attribute ("""ApnodeType.CA"""))_
    val CPZ = parse_attribute (attribute ("""ApnodeType.CPZ"""))_
    val DCA = parse_attribute (attribute ("""ApnodeType.DCA"""))_
    val DPZ = parse_attribute (attribute ("""ApnodeType.DPZ"""))_
    val EHV = parse_attribute (attribute ("""ApnodeType.EHV"""))_
    val GA = parse_attribute (attribute ("""ApnodeType.GA"""))_
    val GH = parse_attribute (attribute ("""ApnodeType.GH"""))_
    val INT = parse_attribute (attribute ("""ApnodeType.INT"""))_
    val SYS = parse_attribute (attribute ("""ApnodeType.SYS"""))_
    val TH = parse_attribute (attribute ("""ApnodeType.TH"""))_
    val ZN = parse_attribute (attribute ("""ApnodeType.ZN"""))_
    def parse (context: Context): ApnodeType =
    {
        ApnodeType(
            sup (context),
            AG (context),
            BUS (context),
            CA (context),
            CPZ (context),
            DCA (context),
            DPZ (context),
            EHV (context),
            GA (context),
            GH (context),
            INT (context),
            SYS (context),
            TH (context),
            ZN (context)
        )
    }
}

/**
 * Area's present control mode
 */
case class AreaControlMode
(

    override val sup: BasicElement,

    /**
     * CF = Constant Frequency
     */
    val CF: String,

    /**
     * Constant Tie-Line
     */
    val CTL: String,

    /**
     * Off control
     */
    val OFF: String,

    /**
     * Tie-Line Bias
     */
    val TLB: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AreaControlMode]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AreaControlMode
extends
    Parseable[AreaControlMode]
{
    val sup = BasicElement.parse _
    val CF = parse_attribute (attribute ("""AreaControlMode.CF"""))_
    val CTL = parse_attribute (attribute ("""AreaControlMode.CTL"""))_
    val OFF = parse_attribute (attribute ("""AreaControlMode.OFF"""))_
    val TLB = parse_attribute (attribute ("""AreaControlMode.TLB"""))_
    def parse (context: Context): AreaControlMode =
    {
        AreaControlMode(
            sup (context),
            CF (context),
            CTL (context),
            OFF (context),
            TLB (context)
        )
    }
}

/**
 * Commitment instruction types.
 */
case class AutomaticDispInstTypeCommitment
(

    override val sup: BasicElement,

    /**
     * Shut down instruction type
     */
    val SHUT_DOWN: String,

    /**
     * Start up instruction type
     */
    val START_UP: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AutomaticDispInstTypeCommitment]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AutomaticDispInstTypeCommitment
extends
    Parseable[AutomaticDispInstTypeCommitment]
{
    val sup = BasicElement.parse _
    val SHUT_DOWN = parse_attribute (attribute ("""AutomaticDispInstTypeCommitment.SHUT_DOWN"""))_
    val START_UP = parse_attribute (attribute ("""AutomaticDispInstTypeCommitment.START_UP"""))_
    def parse (context: Context): AutomaticDispInstTypeCommitment =
    {
        AutomaticDispInstTypeCommitment(
            sup (context),
            SHUT_DOWN (context),
            START_UP (context)
        )
    }
}

/**
 * Automatic Dispatch mode
 */
case class AutomaticDispatchMode
(

    override val sup: BasicElement,

    /**
     * Contingnency occurance, redispatch of contingency reserves
     */
    val CONTINGENCY: String,

    val INTERVAL: String,

    /**
     * Operator override
     */
    val MANUAL: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[AutomaticDispatchMode]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object AutomaticDispatchMode
extends
    Parseable[AutomaticDispatchMode]
{
    val sup = BasicElement.parse _
    val CONTINGENCY = parse_attribute (attribute ("""AutomaticDispatchMode.CONTINGENCY"""))_
    val INTERVAL = parse_attribute (attribute ("""AutomaticDispatchMode.INTERVAL"""))_
    val MANUAL = parse_attribute (attribute ("""AutomaticDispatchMode.MANUAL"""))_
    def parse (context: Context): AutomaticDispatchMode =
    {
        AutomaticDispatchMode(
            sup (context),
            CONTINGENCY (context),
            INTERVAL (context),
            MANUAL (context)
        )
    }
}

/**
 * The basis used to calculate the bid price curve for an energy default bid.
 */
case class BidCalculationBasis
(

    override val sup: BasicElement,

    /**
     * Based on unit generation characteristics and a cost of fuel.
     */
    val COST_BASED: String,

    /**
     * Based on prices paid at particular pricing location.
     */
    val LMP_BASED: String,

    /**
     * An amount negotiated with the designated Independent Entity.
     */
    val NEGOTIATED: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[BidCalculationBasis]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BidCalculationBasis
extends
    Parseable[BidCalculationBasis]
{
    val sup = BasicElement.parse _
    val COST_BASED = parse_attribute (attribute ("""BidCalculationBasis.COST_BASED"""))_
    val LMP_BASED = parse_attribute (attribute ("""BidCalculationBasis.LMP_BASED"""))_
    val NEGOTIATED = parse_attribute (attribute ("""BidCalculationBasis.NEGOTIATED"""))_
    def parse (context: Context): BidCalculationBasis =
    {
        BidCalculationBasis(
            sup (context),
            COST_BASED (context),
            LMP_BASED (context),
            NEGOTIATED (context)
        )
    }
}

/**
 * For example:
'S' - Mitigated by SMPM because of "misconduct"
'L; - Mitigated by LMPM because of "misconduct"
'R' - Modified by LMPM because of RMR rules
'M' - Mitigated because of "misconduct" both by SMPM and LMPM
'B' - Mitigated because of "misconduct" both by SMPM and modified by LMLM because of RMR rules
 * 'O' - original
 */
case class BidMitigationStatus
(

    override val sup: BasicElement,

    val B: String,

    val L: String,

    val M: String,

    val O: String,

    val R: String,

    val S: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[BidMitigationStatus]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BidMitigationStatus
extends
    Parseable[BidMitigationStatus]
{
    val sup = BasicElement.parse _
    val B = parse_attribute (attribute ("""BidMitigationStatus.B"""))_
    val L = parse_attribute (attribute ("""BidMitigationStatus.L"""))_
    val M = parse_attribute (attribute ("""BidMitigationStatus.M"""))_
    val O = parse_attribute (attribute ("""BidMitigationStatus.O"""))_
    val R = parse_attribute (attribute ("""BidMitigationStatus.R"""))_
    val S = parse_attribute (attribute ("""BidMitigationStatus.S"""))_
    def parse (context: Context): BidMitigationStatus =
    {
        BidMitigationStatus(
            sup (context),
            B (context),
            L (context),
            M (context),
            O (context),
            R (context),
            S (context)
        )
    }
}

/**
 * For example:
Initial
 * Final
 */
case class BidMitigationType
(

    override val sup: BasicElement,

    val F: String,

    val I: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[BidMitigationType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BidMitigationType
extends
    Parseable[BidMitigationType]
{
    val sup = BasicElement.parse _
    val F = parse_attribute (attribute ("""BidMitigationType.F"""))_
    val I = parse_attribute (attribute ("""BidMitigationType.I"""))_
    def parse (context: Context): BidMitigationType =
    {
        BidMitigationType(
            sup (context),
            F (context),
            I (context)
        )
    }
}

/**
 * For example:
DEFAULT_ENERGY_BID
DEFAULT_STARTUP_BID
 * DEFAULT_MINIMUM_LOAD_BID
 */
case class BidType
(

    override val sup: BasicElement,

    val DEFAULT_ENERGY_BID: String,

    val DEFAULT_MINIMUM_LOAD_BID: String,

    val DEFAULT_STARTUP_BID: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[BidType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BidType
extends
    Parseable[BidType]
{
    val sup = BasicElement.parse _
    val DEFAULT_ENERGY_BID = parse_attribute (attribute ("""BidType.DEFAULT_ENERGY_BID"""))_
    val DEFAULT_MINIMUM_LOAD_BID = parse_attribute (attribute ("""BidType.DEFAULT_MINIMUM_LOAD_BID"""))_
    val DEFAULT_STARTUP_BID = parse_attribute (attribute ("""BidType.DEFAULT_STARTUP_BID"""))_
    def parse (context: Context): BidType =
    {
        BidType(
            sup (context),
            DEFAULT_ENERGY_BID (context),
            DEFAULT_MINIMUM_LOAD_BID (context),
            DEFAULT_STARTUP_BID (context)
        )
    }
}

/**
 * Bid self schedule type has two types as the required output of requirements and qualified pre-dispatch.
 */
case class BidTypeRMR
(

    override val sup: BasicElement,

    /**
     * Output of requirements bid self schedule type.
     */
    val QUALIFIED_PREDISPATCH: String,

    /**
     * Qualified pre-dispatch bid self schedule type.
     */
    val REQUIREMENTS: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[BidTypeRMR]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BidTypeRMR
extends
    Parseable[BidTypeRMR]
{
    val sup = BasicElement.parse _
    val QUALIFIED_PREDISPATCH = parse_attribute (attribute ("""BidTypeRMR.QUALIFIED_PREDISPATCH"""))_
    val REQUIREMENTS = parse_attribute (attribute ("""BidTypeRMR.REQUIREMENTS"""))_
    def parse (context: Context): BidTypeRMR =
    {
        BidTypeRMR(
            sup (context),
            QUALIFIED_PREDISPATCH (context),
            REQUIREMENTS (context)
        )
    }
}

/**
 * Congestion Revenue Rights category types
 */
case class CRRCategoryType
(

    override val sup: BasicElement,

    /**
     * Network Service
     */
    val NSR: String,

    /**
     * Point to Point
     */
    val PTP: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[CRRCategoryType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CRRCategoryType
extends
    Parseable[CRRCategoryType]
{
    val sup = BasicElement.parse _
    val NSR = parse_attribute (attribute ("""CRRCategoryType.NSR"""))_
    val PTP = parse_attribute (attribute ("""CRRCategoryType.PTP"""))_
    def parse (context: Context): CRRCategoryType =
    {
        CRRCategoryType(
            sup (context),
            NSR (context),
            PTP (context)
        )
    }
}

/**
 * Congestion Revenue Right hedge type
 */
case class CRRHedgeType
(

    override val sup: BasicElement,

    val OBLIGATION: String,

    val OPTION: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[CRRHedgeType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CRRHedgeType
extends
    Parseable[CRRHedgeType]
{
    val sup = BasicElement.parse _
    val OBLIGATION = parse_attribute (attribute ("""CRRHedgeType.OBLIGATION"""))_
    val OPTION = parse_attribute (attribute ("""CRRHedgeType.OPTION"""))_
    def parse (context: Context): CRRHedgeType =
    {
        CRRHedgeType(
            sup (context),
            OBLIGATION (context),
            OPTION (context)
        )
    }
}

/**
 * Role types an organisation can play with respect to a congestion revenue right.
 */
case class CRRRoleType
(

    override val sup: BasicElement,

    val BUYER: String,

    val OWNER: String,

    val SELLER: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[CRRRoleType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CRRRoleType
extends
    Parseable[CRRRoleType]
{
    val sup = BasicElement.parse _
    val BUYER = parse_attribute (attribute ("""CRRRoleType.BUYER"""))_
    val OWNER = parse_attribute (attribute ("""CRRRoleType.OWNER"""))_
    val SELLER = parse_attribute (attribute ("""CRRRoleType.SELLER"""))_
    def parse (context: Context): CRRRoleType =
    {
        CRRRoleType(
            sup (context),
            BUYER (context),
            OWNER (context),
            SELLER (context)
        )
    }
}

/**
 * Type of the CRR, from the possible type definitions in the CRR System (e.g. 'LSE', 'ETC').
 */
case class CRRSegmentType
(

    override val sup: BasicElement,

    val AUC: String,

    val CAP: String,

    val CF: String,

    /**
     * Converted rights.
     */
    val CVR: String,

    /**
     * Existing Transmission Contract.
     */
    val ETC: String,

    /**
     * Load Serving Entity.
     */
    val LSE: String,

    /**
     * Merchant transmission.
     */
    val MT: String,

    /**
     * Transmission Ownership Rights.
     */
    val TOR: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[CRRSegmentType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CRRSegmentType
extends
    Parseable[CRRSegmentType]
{
    val sup = BasicElement.parse _
    val AUC = parse_attribute (attribute ("""CRRSegmentType.AUC"""))_
    val CAP = parse_attribute (attribute ("""CRRSegmentType.CAP"""))_
    val CF = parse_attribute (attribute ("""CRRSegmentType.CF"""))_
    val CVR = parse_attribute (attribute ("""CRRSegmentType.CVR"""))_
    val ETC = parse_attribute (attribute ("""CRRSegmentType.ETC"""))_
    val LSE = parse_attribute (attribute ("""CRRSegmentType.LSE"""))_
    val MT = parse_attribute (attribute ("""CRRSegmentType.MT"""))_
    val TOR = parse_attribute (attribute ("""CRRSegmentType.TOR"""))_
    def parse (context: Context): CRRSegmentType =
    {
        CRRSegmentType(
            sup (context),
            AUC (context),
            CAP (context),
            CF (context),
            CVR (context),
            ETC (context),
            LSE (context),
            MT (context),
            TOR (context)
        )
    }
}

/**
 * To indicate a check out type such as adjusted capacity or dispatch capacity
 */
case class CheckOutType
(

    override val sup: BasicElement,

    val AFTER_THE_FACT: String,

    val PRE_HOUR: String,

    val PRE_SCHEDULE: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[CheckOutType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CheckOutType
extends
    Parseable[CheckOutType]
{
    val sup = BasicElement.parse _
    val AFTER_THE_FACT = parse_attribute (attribute ("""CheckOutType.AFTER_THE_FACT"""))_
    val PRE_HOUR = parse_attribute (attribute ("""CheckOutType.PRE_HOUR"""))_
    val PRE_SCHEDULE = parse_attribute (attribute ("""CheckOutType.PRE_SCHEDULE"""))_
    def parse (context: Context): CheckOutType =
    {
        CheckOutType(
            sup (context),
            AFTER_THE_FACT (context),
            PRE_HOUR (context),
            PRE_SCHEDULE (context)
        )
    }
}

/**
 * For example:
SELF - Self commitment
ISO - New commitment for this market period
 * UC - Existing commitment that was a hold over from a previous market.
 */
case class CommitmentType
(

    override val sup: BasicElement,

    val ISO: String,

    val SELF: String,

    val UC: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[CommitmentType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CommitmentType
extends
    Parseable[CommitmentType]
{
    val sup = BasicElement.parse _
    val ISO = parse_attribute (attribute ("""CommitmentType.ISO"""))_
    val SELF = parse_attribute (attribute ("""CommitmentType.SELF"""))_
    val UC = parse_attribute (attribute ("""CommitmentType.UC"""))_
    def parse (context: Context): CommitmentType =
    {
        CommitmentType(
            sup (context),
            ISO (context),
            SELF (context),
            UC (context)
        )
    }
}

/**
 * Binding constraint results limit type, For example:
MAXIMUM
 * MINIMUM
 */
case class ConstraintLimitType
(

    override val sup: BasicElement,

    val MAXIMUM: String,

    val MINIMUM: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ConstraintLimitType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ConstraintLimitType
extends
    Parseable[ConstraintLimitType]
{
    val sup = BasicElement.parse _
    val MAXIMUM = parse_attribute (attribute ("""ConstraintLimitType.MAXIMUM"""))_
    val MINIMUM = parse_attribute (attribute ("""ConstraintLimitType.MINIMUM"""))_
    def parse (context: Context): ConstraintLimitType =
    {
        ConstraintLimitType(
            sup (context),
            MAXIMUM (context),
            MINIMUM (context)
        )
    }
}

/**
 * Constraint Ramp type
 */
case class ConstraintRampType
(

    override val sup: BasicElement,

    val FAST: String,

    val SLOW: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ConstraintRampType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ConstraintRampType
extends
    Parseable[ConstraintRampType]
{
    val sup = BasicElement.parse _
    val FAST = parse_attribute (attribute ("""ConstraintRampType.FAST"""))_
    val SLOW = parse_attribute (attribute ("""ConstraintRampType.SLOW"""))_
    def parse (context: Context): ConstraintRampType =
    {
        ConstraintRampType(
            sup (context),
            FAST (context),
            SLOW (context)
        )
    }
}

/**
 * Transmission Contract Type, For example:
O - Other 
TE - Transmission Export 
TI - Transmission Import 
ETC - Existing Transmission Contract 
RMT - RMT Contract 
TOR - Transmission Ownership Right  
RMR - Reliability Must Run Contract
 * CVR - Converted contract.
 */
case class ContractType
(

    override val sup: BasicElement,

    /**
     * CVR - Converted contract.
     */
    val CVR: String,

    /**
     * ETC - Existing Transmission Contract
     */
    val ETC: String,

    /**
     * O - Other
     */
    val O: String,

    /**
     * RMR - Reliability Must Run Contract
     */
    val RMR: String,

    /**
     * RMT - RMT Contract
     */
    val RMT: String,

    /**
     * TE - Transmission Export
     */
    val TE: String,

    /**
     * TI - Transmission Import
     */
    val TI: String,

    /**
     * TOR - Transmission Ownership Right
     */
    val TOR: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ContractType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ContractType
extends
    Parseable[ContractType]
{
    val sup = BasicElement.parse _
    val CVR = parse_attribute (attribute ("""ContractType.CVR"""))_
    val ETC = parse_attribute (attribute ("""ContractType.ETC"""))_
    val O = parse_attribute (attribute ("""ContractType.O"""))_
    val RMR = parse_attribute (attribute ("""ContractType.RMR"""))_
    val RMT = parse_attribute (attribute ("""ContractType.RMT"""))_
    val TE = parse_attribute (attribute ("""ContractType.TE"""))_
    val TI = parse_attribute (attribute ("""ContractType.TI"""))_
    val TOR = parse_attribute (attribute ("""ContractType.TOR"""))_
    def parse (context: Context): ContractType =
    {
        ContractType(
            sup (context),
            CVR (context),
            ETC (context),
            O (context),
            RMR (context),
            RMT (context),
            TE (context),
            TI (context),
            TOR (context)
        )
    }
}

/**
 * For example:
Bid Cost
Proxy Cost
 * Registered Cost
 */
case class CostBasis
(

    override val sup: BasicElement,

    val BIDC: String,

    val PRXC: String,

    val REGC: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[CostBasis]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CostBasis
extends
    Parseable[CostBasis]
{
    val sup = BasicElement.parse _
    val BIDC = parse_attribute (attribute ("""CostBasis.BIDC"""))_
    val PRXC = parse_attribute (attribute ("""CostBasis.PRXC"""))_
    val REGC = parse_attribute (attribute ("""CostBasis.REGC"""))_
    def parse (context: Context): CostBasis =
    {
        CostBasis(
            sup (context),
            BIDC (context),
            PRXC (context),
            REGC (context)
        )
    }
}

/**
 * For example:
NON_RESPONSE
ACCEPT
DECLINE
 * PARTIAL.
 */
case class DispatchResponseType
(

    override val sup: BasicElement,

    val ACCEPT: String,

    val DECLINE: String,

    val NON_RESPONSE: String,

    val PARTIAL: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[DispatchResponseType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DispatchResponseType
extends
    Parseable[DispatchResponseType]
{
    val sup = BasicElement.parse _
    val ACCEPT = parse_attribute (attribute ("""DispatchResponseType.ACCEPT"""))_
    val DECLINE = parse_attribute (attribute ("""DispatchResponseType.DECLINE"""))_
    val NON_RESPONSE = parse_attribute (attribute ("""DispatchResponseType.NON_RESPONSE"""))_
    val PARTIAL = parse_attribute (attribute ("""DispatchResponseType.PARTIAL"""))_
    def parse (context: Context): DispatchResponseType =
    {
        DispatchResponseType(
            sup (context),
            ACCEPT (context),
            DECLINE (context),
            NON_RESPONSE (context),
            PARTIAL (context)
        )
    }
}

/**
 * For example:
WHOLESALE
RETAIL
 * BOTH
 */
case class EnergyPriceIndexType
(

    override val sup: BasicElement,

    val BOTH: String,

    val RETAIL: String,

    val WHOLESALE: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[EnergyPriceIndexType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EnergyPriceIndexType
extends
    Parseable[EnergyPriceIndexType]
{
    val sup = BasicElement.parse _
    val BOTH = parse_attribute (attribute ("""EnergyPriceIndexType.BOTH"""))_
    val RETAIL = parse_attribute (attribute ("""EnergyPriceIndexType.RETAIL"""))_
    val WHOLESALE = parse_attribute (attribute ("""EnergyPriceIndexType.WHOLESALE"""))_
    def parse (context: Context): EnergyPriceIndexType =
    {
        EnergyPriceIndexType(
            sup (context),
            BOTH (context),
            RETAIL (context),
            WHOLESALE (context)
        )
    }
}

/**
 * Energy product type
 */
case class EnergyProductType
(

    override val sup: BasicElement,

    /**
     * Dynamic
     */
    val DYN: String,

    /**
     * Firm
     */
    val FIRM: String,

    /**
     * Non Firm
     */
    val NFRM: String,

    /**
     * Wheeling
     */
    val WHL: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[EnergyProductType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EnergyProductType
extends
    Parseable[EnergyProductType]
{
    val sup = BasicElement.parse _
    val DYN = parse_attribute (attribute ("""EnergyProductType.DYN"""))_
    val FIRM = parse_attribute (attribute ("""EnergyProductType.FIRM"""))_
    val NFRM = parse_attribute (attribute ("""EnergyProductType.NFRM"""))_
    val WHL = parse_attribute (attribute ("""EnergyProductType.WHL"""))_
    def parse (context: Context): EnergyProductType =
    {
        EnergyProductType(
            sup (context),
            DYN (context),
            FIRM (context),
            NFRM (context),
            WHL (context)
        )
    }
}

/**
 * Defines the state of a transaction.
 */
case class EnergyTransactionType
(

    override val sup: BasicElement,

    /**
     * Approve
     */
    val approve: String,

    /**
     * Deny
     */
    val deny: String,

    /**
     * Study
     */
    val study: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[EnergyTransactionType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EnergyTransactionType
extends
    Parseable[EnergyTransactionType]
{
    val sup = BasicElement.parse _
    val approve = parse_attribute (attribute ("""EnergyTransactionType.approve"""))_
    val deny = parse_attribute (attribute ("""EnergyTransactionType.deny"""))_
    val study = parse_attribute (attribute ("""EnergyTransactionType.study"""))_
    def parse (context: Context): EnergyTransactionType =
    {
        EnergyTransactionType(
            sup (context),
            approve (context),
            deny (context),
            study (context)
        )
    }
}

/**
 * Status of equipment
 */
case class EquipmentStatusType
(

    override val sup: BasicElement,

    /**
     * Equipment is in.
     */
    val In: String,

    /**
     * Equipment is out.
     */
    val Out: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[EquipmentStatusType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object EquipmentStatusType
extends
    Parseable[EquipmentStatusType]
{
    val sup = BasicElement.parse _
    val In = parse_attribute (attribute ("""EquipmentStatusType.In"""))_
    val Out = parse_attribute (attribute ("""EquipmentStatusType.Out"""))_
    def parse (context: Context): EquipmentStatusType =
    {
        EquipmentStatusType(
            sup (context),
            In (context),
            Out (context)
        )
    }
}

/**
 * Execution types of Market Runs
 */
case class ExecutionType
(

    override val sup: BasicElement,

    /**
     * Day Ahead
     */
    val DA: String,

    /**
     * Real TIme Hour Ahead Execution
     */
    val HASP: String,

    /**
     * Real Time Dispatch
     */
    val RTD: String,

    /**
     * Real Time Pre-dispatch
     */
    val RTPD: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ExecutionType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ExecutionType
extends
    Parseable[ExecutionType]
{
    val sup = BasicElement.parse _
    val DA = parse_attribute (attribute ("""ExecutionType.DA"""))_
    val HASP = parse_attribute (attribute ("""ExecutionType.HASP"""))_
    val RTD = parse_attribute (attribute ("""ExecutionType.RTD"""))_
    val RTPD = parse_attribute (attribute ("""ExecutionType.RTPD"""))_
    def parse (context: Context): ExecutionType =
    {
        ExecutionType(
            sup (context),
            DA (context),
            HASP (context),
            RTD (context),
            RTPD (context)
        )
    }
}

/**
 * Indicates whether the unit is RMR and it's condition type, for example:
N' - not an RMR unit
'1' - RMR Condition 1 unit
 * '2' - RMR Condition 2 unit
 */
case class FlagTypeRMR
(

    override val sup: BasicElement,

    /**
     * 'N' - not an RMR unit
     */
    val N: String,

    /**
     * '1' - RMR Condition 1 unit
     */
    val _1: String,

    /**
     * '2' - RMR Condition 2 unit
     */
    val _2: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[FlagTypeRMR]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FlagTypeRMR
extends
    Parseable[FlagTypeRMR]
{
    val sup = BasicElement.parse _
    val N = parse_attribute (attribute ("""FlagTypeRMR.N"""))_
    val _1 = parse_attribute (attribute ("""FlagTypeRMR.1"""))_
    val _2 = parse_attribute (attribute ("""FlagTypeRMR.2"""))_
    def parse (context: Context): FlagTypeRMR =
    {
        FlagTypeRMR(
            sup (context),
            N (context),
            _1 (context),
            _2 (context)
        )
    }
}

/**
 * Specifies the direction of energy flow in the flowgate.
 */
case class FlowDirectionType
(

    override val sup: BasicElement,

    /**
     * Forward direction.
     */
    val Forward: String,

    /**
     * Reverse direction.
     */
    val Reverse: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[FlowDirectionType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FlowDirectionType
extends
    Parseable[FlowDirectionType]
{
    val sup = BasicElement.parse _
    val Forward = parse_attribute (attribute ("""FlowDirectionType.Forward"""))_
    val Reverse = parse_attribute (attribute ("""FlowDirectionType.Reverse"""))_
    def parse (context: Context): FlowDirectionType =
    {
        FlowDirectionType(
            sup (context),
            Forward (context),
            Reverse (context)
        )
    }
}

/**
 * For example:
Bio Gas (Landfill, Sewage, Digester, etc.)
Biomass
Coal
DIST
Natural Gas
Geothermal
HRCV
None
Nuclear
Oil
Other
Solar
Waste to Energy
Water
 * Wind
 */
case class FuelSource
(

    override val sup: BasicElement,

    /**
     * Bio Gas (Landfill, Sewage, Digester, etc.)
     */
    val BGAS: String,

    /**
     * Biomass
     */
    val BIOM: String,

    /**
     * Coal
     */
    val COAL: String,

    val DIST: String,

    val GAS: String,

    /**
     * GeoThermal
     */
    val GEOT: String,

    val HRCV: String,

    /**
     * Natural Gas
     */
    val NG: String,

    /**
     * Non-Natural Gas
     */
    val NNG: String,

    val NONE: String,

    /**
     * Nuclear
     */
    val NUCL: String,

    val OIL: String,

    /**
     * Other
     */
    val OTHR: String,

    /**
     * Solar
     */
    val SOLR: String,

    /**
     * Waste to Energy
     */
    val WAST: String,

    /**
     * Water
     */
    val WATR: String,

    /**
     * Wind
     */
    val WIND: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[FuelSource]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object FuelSource
extends
    Parseable[FuelSource]
{
    val sup = BasicElement.parse _
    val BGAS = parse_attribute (attribute ("""FuelSource.BGAS"""))_
    val BIOM = parse_attribute (attribute ("""FuelSource.BIOM"""))_
    val COAL = parse_attribute (attribute ("""FuelSource.COAL"""))_
    val DIST = parse_attribute (attribute ("""FuelSource.DIST"""))_
    val GAS = parse_attribute (attribute ("""FuelSource.GAS"""))_
    val GEOT = parse_attribute (attribute ("""FuelSource.GEOT"""))_
    val HRCV = parse_attribute (attribute ("""FuelSource.HRCV"""))_
    val NG = parse_attribute (attribute ("""FuelSource.NG"""))_
    val NNG = parse_attribute (attribute ("""FuelSource.NNG"""))_
    val NONE = parse_attribute (attribute ("""FuelSource.NONE"""))_
    val NUCL = parse_attribute (attribute ("""FuelSource.NUCL"""))_
    val OIL = parse_attribute (attribute ("""FuelSource.OIL"""))_
    val OTHR = parse_attribute (attribute ("""FuelSource.OTHR"""))_
    val SOLR = parse_attribute (attribute ("""FuelSource.SOLR"""))_
    val WAST = parse_attribute (attribute ("""FuelSource.WAST"""))_
    val WATR = parse_attribute (attribute ("""FuelSource.WATR"""))_
    val WIND = parse_attribute (attribute ("""FuelSource.WIND"""))_
    def parse (context: Context): FuelSource =
    {
        FuelSource(
            sup (context),
            BGAS (context),
            BIOM (context),
            COAL (context),
            DIST (context),
            GAS (context),
            GEOT (context),
            HRCV (context),
            NG (context),
            NNG (context),
            NONE (context),
            NUCL (context),
            OIL (context),
            OTHR (context),
            SOLR (context),
            WAST (context),
            WATR (context),
            WIND (context)
        )
    }
}

/**
 * Direction of an intertie.
 */
case class InterTieDirection
(

    override val sup: BasicElement,

    /**
     * Export.
     */
    val E: String,

    /**
     * Import.
     */
    val I: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[InterTieDirection]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object InterTieDirection
extends
    Parseable[InterTieDirection]
{
    val sup = BasicElement.parse _
    val E = parse_attribute (attribute ("""InterTieDirection.E"""))_
    val I = parse_attribute (attribute ("""InterTieDirection.I"""))_
    def parse (context: Context): InterTieDirection =
    {
        InterTieDirection(
            sup (context),
            E (context),
            I (context)
        )
    }
}

/**
 * Load forecast zone types.
 */
case class LoadForecastType
(

    override val sup: BasicElement,

    /**
     * Load forecast zone.
     */
    val LFZ: String,

    /**
     * Metered sub system zone.
     */
    val LZMS: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[LoadForecastType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object LoadForecastType
extends
    Parseable[LoadForecastType]
{
    val sup = BasicElement.parse _
    val LFZ = parse_attribute (attribute ("""LoadForecastType.LFZ"""))_
    val LZMS = parse_attribute (attribute ("""LoadForecastType.LZMS"""))_
    def parse (context: Context): LoadForecastType =
    {
        LoadForecastType(
            sup (context),
            LFZ (context),
            LZMS (context)
        )
    }
}

/**
 * Market power mitigation test identifier type, for example:

1 ? Global Price Test
2 ? Global Conduct Test
3 ? Global Impact Test
4 ? Local Price Test
5 ? Local Conduct Test
 * 6 ? Local Impact Test
 */
case class MPMTestIdentifierType
(

    override val sup: BasicElement,

    /**
     * 1 - Global Price Test.
     */
    val _1: String,

    /**
     * 2 - Global Conduct Test.
     */
    val _2: String,

    /**
     * 3 - Global Impact Test.
     */
    val _3: String,

    /**
     * 4 - Local Price Test.
     */
    val _4: String,

    /**
     * 5 - Local Conduct Test.
     */
    val _5: String,

    /**
     * 6 - Local Impact Test.
     */
    val _6: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MPMTestIdentifierType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MPMTestIdentifierType
extends
    Parseable[MPMTestIdentifierType]
{
    val sup = BasicElement.parse _
    val _1 = parse_attribute (attribute ("""MPMTestIdentifierType.1"""))_
    val _2 = parse_attribute (attribute ("""MPMTestIdentifierType.2"""))_
    val _3 = parse_attribute (attribute ("""MPMTestIdentifierType.3"""))_
    val _4 = parse_attribute (attribute ("""MPMTestIdentifierType.4"""))_
    val _5 = parse_attribute (attribute ("""MPMTestIdentifierType.5"""))_
    val _6 = parse_attribute (attribute ("""MPMTestIdentifierType.6"""))_
    def parse (context: Context): MPMTestIdentifierType =
    {
        MPMTestIdentifierType(
            sup (context),
            _1 (context),
            _2 (context),
            _3 (context),
            _4 (context),
            _5 (context),
            _6 (context)
        )
    }
}

/**
 * Market power mitigation test method type.
 * Tests with the normal (default) thresholds or tests with the alternate thresholds.
 */
case class MPMTestMethodType
(

    override val sup: BasicElement,

    /**
     * Alternate.
     */
    val ALTERNATE: String,

    /**
     * Normal.
     */
    val NORMAL: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MPMTestMethodType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MPMTestMethodType
extends
    Parseable[MPMTestMethodType]
{
    val sup = BasicElement.parse _
    val ALTERNATE = parse_attribute (attribute ("""MPMTestMethodType.ALTERNATE"""))_
    val NORMAL = parse_attribute (attribute ("""MPMTestMethodType.NORMAL"""))_
    def parse (context: Context): MPMTestMethodType =
    {
        MPMTestMethodType(
            sup (context),
            ALTERNATE (context),
            NORMAL (context)
        )
    }
}

/**
 * For example:
Passed
Failed
Disabled
 * Skipped
 */
case class MPMTestOutcome
(

    override val sup: BasicElement,

    /**
     * Disabled
     */
    val D: String,

    /**
     * Failed
     */
    val F: String,

    /**
     * Passed
     */
    val P: String,

    /**
     * Skipped
     */
    val S: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MPMTestOutcome]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MPMTestOutcome
extends
    Parseable[MPMTestOutcome]
{
    val sup = BasicElement.parse _
    val D = parse_attribute (attribute ("""MPMTestOutcome.D"""))_
    val F = parse_attribute (attribute ("""MPMTestOutcome.F"""))_
    val P = parse_attribute (attribute ("""MPMTestOutcome.P"""))_
    val S = parse_attribute (attribute ("""MPMTestOutcome.S"""))_
    def parse (context: Context): MPMTestOutcome =
    {
        MPMTestOutcome(
            sup (context),
            D (context),
            F (context),
            P (context),
            S (context)
        )
    }
}

/**
 * For example:
ADD - add
 * CHG - change
 */
case class MQSCHGType
(

    override val sup: BasicElement,

    val ADD: String,

    val CHG: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MQSCHGType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MQSCHGType
extends
    Parseable[MQSCHGType]
{
    val sup = BasicElement.parse _
    val ADD = parse_attribute (attribute ("""MQSCHGType.ADD"""))_
    val CHG = parse_attribute (attribute ("""MQSCHGType.CHG"""))_
    def parse (context: Context): MQSCHGType =
    {
        MQSCHGType(
            sup (context),
            ADD (context),
            CHG (context)
        )
    }
}

/**
 * Valid values, for example: 
INS - Instruction from RTM
 * ACT - Actual instruction after the fact
 */
case class MQSInstructionSource
(

    override val sup: BasicElement,

    val ACT: String,

    val INS: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MQSInstructionSource]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MQSInstructionSource
extends
    Parseable[MQSInstructionSource]
{
    val sup = BasicElement.parse _
    val ACT = parse_attribute (attribute ("""MQSInstructionSource.ACT"""))_
    val INS = parse_attribute (attribute ("""MQSInstructionSource.INS"""))_
    def parse (context: Context): MQSInstructionSource =
    {
        MQSInstructionSource(
            sup (context),
            ACT (context),
            INS (context)
        )
    }
}

/**
 * Market product self schedule bid types.
 */
case class MarketProductSelfSchedType
(

    override val sup: BasicElement,

    /**
     * Existing Transmission Contract.
     */
    val ETC: String,

    /**
     * Low price taker.
     */
    val LPT: String,

    /**
     * Price taker.
     */
    val PT: String,

    /**
     * Resource adequacy.
     */
    val RA: String,

    /**
     * Regulatory must run.
     */
    val RGMR: String,

    /**
     * Reliability Must Run.
     */
    val RMR: String,

    /**
     * Reliability must take.
     */
    val RMT: String,

    /**
     * Self provision.
     */
    val SP: String,

    /**
     * Transmission Ownership Right.
     */
    val TOR: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketProductSelfSchedType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketProductSelfSchedType
extends
    Parseable[MarketProductSelfSchedType]
{
    val sup = BasicElement.parse _
    val ETC = parse_attribute (attribute ("""MarketProductSelfSchedType.ETC"""))_
    val LPT = parse_attribute (attribute ("""MarketProductSelfSchedType.LPT"""))_
    val PT = parse_attribute (attribute ("""MarketProductSelfSchedType.PT"""))_
    val RA = parse_attribute (attribute ("""MarketProductSelfSchedType.RA"""))_
    val RGMR = parse_attribute (attribute ("""MarketProductSelfSchedType.RGMR"""))_
    val RMR = parse_attribute (attribute ("""MarketProductSelfSchedType.RMR"""))_
    val RMT = parse_attribute (attribute ("""MarketProductSelfSchedType.RMT"""))_
    val SP = parse_attribute (attribute ("""MarketProductSelfSchedType.SP"""))_
    val TOR = parse_attribute (attribute ("""MarketProductSelfSchedType.TOR"""))_
    def parse (context: Context): MarketProductSelfSchedType =
    {
        MarketProductSelfSchedType(
            sup (context),
            ETC (context),
            LPT (context),
            PT (context),
            RA (context),
            RGMR (context),
            RMR (context),
            RMT (context),
            SP (context),
            TOR (context)
        )
    }
}

/**
 * For example:
 * Energy, Reg Up, Reg Down, Spin Reserve, Nonspin Reserve, RUC, Load Folloing Up, and Load Following Down.
 */
case class MarketProductType
(

    override val sup: BasicElement,

    /**
     * energy type
     */
    val EN: String,

    /**
     * Load following down
     */
    val LFD: String,

    /**
     * Load following up
     */
    val LFU: String,

    /**
     * non spinning reserve
     */
    val NR: String,

    /**
     * Residual Unit Commitment
     */
    val RC: String,

    /**
     * regulation down
     */
    val RD: String,

    /**
     * Regulation
     */
    val REG: String,

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
    def this () = { this (null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketProductType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketProductType
extends
    Parseable[MarketProductType]
{
    val sup = BasicElement.parse _
    val EN = parse_attribute (attribute ("""MarketProductType.EN"""))_
    val LFD = parse_attribute (attribute ("""MarketProductType.LFD"""))_
    val LFU = parse_attribute (attribute ("""MarketProductType.LFU"""))_
    val NR = parse_attribute (attribute ("""MarketProductType.NR"""))_
    val RC = parse_attribute (attribute ("""MarketProductType.RC"""))_
    val RD = parse_attribute (attribute ("""MarketProductType.RD"""))_
    val REG = parse_attribute (attribute ("""MarketProductType.REG"""))_
    val RU = parse_attribute (attribute ("""MarketProductType.RU"""))_
    val SR = parse_attribute (attribute ("""MarketProductType.SR"""))_
    def parse (context: Context): MarketProductType =
    {
        MarketProductType(
            sup (context),
            EN (context),
            LFD (context),
            LFU (context),
            NR (context),
            RC (context),
            RD (context),
            REG (context),
            RU (context),
            SR (context)
        )
    }
}

/**
 * Maket type.
 */
case class MarketType
(

    override val sup: BasicElement,

    /**
     * Day ahead market.
     */
    val DAM: String,

    /**
     * Hour Ahead Market.
     */
    val HAM: String,

    /**
     * Real time market.
     */
    val RTM: String,

    /**
     * Residual Unit Commitment.
     */
    val RUC: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MarketType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MarketType
extends
    Parseable[MarketType]
{
    val sup = BasicElement.parse _
    val DAM = parse_attribute (attribute ("""MarketType.DAM"""))_
    val HAM = parse_attribute (attribute ("""MarketType.HAM"""))_
    val RTM = parse_attribute (attribute ("""MarketType.RTM"""))_
    val RUC = parse_attribute (attribute ("""MarketType.RUC"""))_
    def parse (context: Context): MarketType =
    {
        MarketType(
            sup (context),
            DAM (context),
            HAM (context),
            RTM (context),
            RUC (context)
        )
    }
}

/**
 * Kind of Market account.
 */
case class MktAccountKind
(

    override val sup: BasicElement,

    val estimate: String,

    val normal: String,

    val reversal: String,

    val statistical: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MktAccountKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktAccountKind
extends
    Parseable[MktAccountKind]
{
    val sup = BasicElement.parse _
    val estimate = parse_attribute (attribute ("""MktAccountKind.estimate"""))_
    val normal = parse_attribute (attribute ("""MktAccountKind.normal"""))_
    val reversal = parse_attribute (attribute ("""MktAccountKind.reversal"""))_
    val statistical = parse_attribute (attribute ("""MktAccountKind.statistical"""))_
    def parse (context: Context): MktAccountKind =
    {
        MktAccountKind(
            sup (context),
            estimate (context),
            normal (context),
            reversal (context),
            statistical (context)
        )
    }
}

/**
 * Kind of bill media.
 */
case class MktBillMediaKind
(

    override val sup: BasicElement,

    val electronic: String,

    val other: String,

    val paper: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MktBillMediaKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktBillMediaKind
extends
    Parseable[MktBillMediaKind]
{
    val sup = BasicElement.parse _
    val electronic = parse_attribute (attribute ("""MktBillMediaKind.electronic"""))_
    val other = parse_attribute (attribute ("""MktBillMediaKind.other"""))_
    val paper = parse_attribute (attribute ("""MktBillMediaKind.paper"""))_
    def parse (context: Context): MktBillMediaKind =
    {
        MktBillMediaKind(
            sup (context),
            electronic (context),
            other (context),
            paper (context)
        )
    }
}

/**
 * Kind of invoice line item.
 */
case class MktInvoiceLineItemKind
(

    override val sup: BasicElement,

    val initial: String,

    val other: String,

    val recalculation: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[MktInvoiceLineItemKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MktInvoiceLineItemKind
extends
    Parseable[MktInvoiceLineItemKind]
{
    val sup = BasicElement.parse _
    val initial = parse_attribute (attribute ("""MktInvoiceLineItemKind.initial"""))_
    val other = parse_attribute (attribute ("""MktInvoiceLineItemKind.other"""))_
    val recalculation = parse_attribute (attribute ("""MktInvoiceLineItemKind.recalculation"""))_
    def parse (context: Context): MktInvoiceLineItemKind =
    {
        MktInvoiceLineItemKind(
            sup (context),
            initial (context),
            other (context),
            recalculation (context)
        )
    }
}

/**
 * ON
 * OFF
 */
case class OnOff
(

    override val sup: BasicElement,

    val OFF: String,

    val ON: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[OnOff]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OnOff
extends
    Parseable[OnOff]
{
    val sup = BasicElement.parse _
    val OFF = parse_attribute (attribute ("""OnOff.OFF"""))_
    val ON = parse_attribute (attribute ("""OnOff.ON"""))_
    def parse (context: Context): OnOff =
    {
        OnOff(
            sup (context),
            OFF (context),
            ON (context)
        )
    }
}

/**
 * For example:
'Y' - Participates in both LMPM and SMPM
'N' - Not included in LMP price measures
'S' - Participates in SMPM price measures
 * 'L' - Participates in LMPM price measures
 */
case class ParticipationCategoryMPM
(

    override val sup: BasicElement,

    val L: String,

    val N: String,

    val S: String,

    val Y: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ParticipationCategoryMPM]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ParticipationCategoryMPM
extends
    Parseable[ParticipationCategoryMPM]
{
    val sup = BasicElement.parse _
    val L = parse_attribute (attribute ("""ParticipationCategoryMPM.L"""))_
    val N = parse_attribute (attribute ("""ParticipationCategoryMPM.N"""))_
    val S = parse_attribute (attribute ("""ParticipationCategoryMPM.S"""))_
    val Y = parse_attribute (attribute ("""ParticipationCategoryMPM.Y"""))_
    def parse (context: Context): ParticipationCategoryMPM =
    {
        ParticipationCategoryMPM(
            sup (context),
            L (context),
            N (context),
            S (context),
            Y (context)
        )
    }
}

/**
 * Defines the individual passes that produce results per execution type/market type
 */
case class PassIndicatorType
(

    override val sup: BasicElement,

    /**
     * Day Ahead
     */
    val DA: String,

    /**
     * Hour Ahead Security Constrained Unit Commitment
     */
    val HA_SCUC: String,

    /**
     * Market Power Mitigation Pass 1
     */
    val MPM_1: String,

    /**
     * Market Power Mitigation Pass 2
     */
    val MPM_2: String,

    /**
     * Market Power Mitigation Pass 3
     */
    val MPM_3: String,

    /**
     * Market Power Mitigation Pass 4
     */
    val MPM_4: String,

    /**
     * Real Time Economic Dispatch
     */
    val RTED: String,

    /**
     * Real Time Pre Dispatch
     */
    val RTPD: String,

    /**
     * Residual Unit Commitment
     */
    val RUC: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[PassIndicatorType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PassIndicatorType
extends
    Parseable[PassIndicatorType]
{
    val sup = BasicElement.parse _
    val DA = parse_attribute (attribute ("""PassIndicatorType.DA"""))_
    val HA_SCUC = parse_attribute (attribute ("""PassIndicatorType.HA-SCUC"""))_
    val MPM_1 = parse_attribute (attribute ("""PassIndicatorType.MPM-1"""))_
    val MPM_2 = parse_attribute (attribute ("""PassIndicatorType.MPM-2"""))_
    val MPM_3 = parse_attribute (attribute ("""PassIndicatorType.MPM-3"""))_
    val MPM_4 = parse_attribute (attribute ("""PassIndicatorType.MPM-4"""))_
    val RTED = parse_attribute (attribute ("""PassIndicatorType.RTED"""))_
    val RTPD = parse_attribute (attribute ("""PassIndicatorType.RTPD"""))_
    val RUC = parse_attribute (attribute ("""PassIndicatorType.RUC"""))_
    def parse (context: Context): PassIndicatorType =
    {
        PassIndicatorType(
            sup (context),
            DA (context),
            HA_SCUC (context),
            MPM_1 (context),
            MPM_2 (context),
            MPM_3 (context),
            MPM_4 (context),
            RTED (context),
            RTPD (context),
            RUC (context)
        )
    }
}

/**
 * MPM Purpose Flag, for example:

Nature of threshold data:
'M' - Mitigation threshold
 * 'R' - Reporting threshold
 */
case class PurposeFlagType
(

    override val sup: BasicElement,

    val M: String,

    val R: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[PurposeFlagType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object PurposeFlagType
extends
    Parseable[PurposeFlagType]
{
    val sup = BasicElement.parse _
    val M = parse_attribute (attribute ("""PurposeFlagType.M"""))_
    val R = parse_attribute (attribute ("""PurposeFlagType.R"""))_
    def parse (context: Context): PurposeFlagType =
    {
        PurposeFlagType(
            sup (context),
            M (context),
            R (context)
        )
    }
}

/**
 * For example:
0 - Fixed ramp rate independent of rate function unit MW output
1 - Static ramp rates as a function of unit MW output only
 * 2 - Dynamic ramp rates as a function of unit MW output and ramping time
 */
case class RampCurveType
(

    override val sup: BasicElement,

    /**
     * Fixed ramp rate independent of rate function unit MW output
     */
    val _0: String,

    /**
     * Static ramp rates as a function of unit MW output only
     */
    val _1: String,

    /**
     * Dynamic ramp rates as a function of unit MW output and ramping time
     */
    val _2: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[RampCurveType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RampCurveType
extends
    Parseable[RampCurveType]
{
    val sup = BasicElement.parse _
    val _0 = parse_attribute (attribute ("""RampCurveType.0"""))_
    val _1 = parse_attribute (attribute ("""RampCurveType.1"""))_
    val _2 = parse_attribute (attribute ("""RampCurveType.2"""))_
    def parse (context: Context): RampCurveType =
    {
        RampCurveType(
            sup (context),
            _0 (context),
            _1 (context),
            _2 (context)
        )
    }
}

/**
 * For example:
0: ignore ramping limits, 
1: 20-minute ramping rule,
 * 2: 60-minute ramping rule
 */
case class RampModeType
(

    override val sup: BasicElement,

    /**
     * Ignore ramping limits
     */
    val _0: String,

    /**
     * 20-minute ramping rule,
     */
    val _1: String,

    /**
     * 60-minute ramping rule
     */
    val _2: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[RampModeType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RampModeType
extends
    Parseable[RampModeType]
{
    val sup = BasicElement.parse _
    val _0 = parse_attribute (attribute ("""RampModeType.0"""))_
    val _1 = parse_attribute (attribute ("""RampModeType.1"""))_
    val _2 = parse_attribute (attribute ("""RampModeType.2"""))_
    def parse (context: Context): RampModeType =
    {
        RampModeType(
            sup (context),
            _0 (context),
            _1 (context),
            _2 (context)
        )
    }
}

/**
 * Ramp rate condition
 */
case class RampRateCondition
(

    override val sup: BasicElement,

    val BEST: String,

    /**
     * not applicable
     */
    val NA: String,

    val NORMAL: String,

    val WORST: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[RampRateCondition]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RampRateCondition
extends
    Parseable[RampRateCondition]
{
    val sup = BasicElement.parse _
    val BEST = parse_attribute (attribute ("""RampRateCondition.BEST"""))_
    val NA = parse_attribute (attribute ("""RampRateCondition.NA"""))_
    val NORMAL = parse_attribute (attribute ("""RampRateCondition.NORMAL"""))_
    val WORST = parse_attribute (attribute ("""RampRateCondition.WORST"""))_
    def parse (context: Context): RampRateCondition =
    {
        RampRateCondition(
            sup (context),
            BEST (context),
            NA (context),
            NORMAL (context),
            WORST (context)
        )
    }
}

/**
 * Ramp rate curve type.
 */
case class RampRateType
(

    override val sup: BasicElement,

    /**
     * Intertie ramp rate.
     */
    val INTERTIE: String,

    /**
     * Load drop ramp rate.
     */
    val LD_DROP: String,

    /**
     * Load pick up rate.
     */
    val LD_PICKUP: String,

    /**
     * Operational ramp rate.
     */
    val OP: String,

    /**
     * Operating reserve ramp rate.
     */
    val OP_RES: String,

    /**
     * Regulating ramp rate.
     */
    val REG: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[RampRateType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object RampRateType
extends
    Parseable[RampRateType]
{
    val sup = BasicElement.parse _
    val INTERTIE = parse_attribute (attribute ("""RampRateType.INTERTIE"""))_
    val LD_DROP = parse_attribute (attribute ("""RampRateType.LD_DROP"""))_
    val LD_PICKUP = parse_attribute (attribute ("""RampRateType.LD_PICKUP"""))_
    val OP = parse_attribute (attribute ("""RampRateType.OP"""))_
    val OP_RES = parse_attribute (attribute ("""RampRateType.OP_RES"""))_
    val REG = parse_attribute (attribute ("""RampRateType.REG"""))_
    def parse (context: Context): RampRateType =
    {
        RampRateType(
            sup (context),
            INTERTIE (context),
            LD_DROP (context),
            LD_PICKUP (context),
            OP (context),
            OP_RES (context),
            REG (context)
        )
    }
}

/**
 * For example:
 * Operating Reserve, Regulation, Contingency
 */
case class ReserveRequirementType
(

    override val sup: BasicElement,

    /**
     * Contingency
     */
    val CONT: String,

    /**
     * Operating Reserve
     */
    val OPRSV: String,

    /**
     * Regulation
     */
    val REG: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ReserveRequirementType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ReserveRequirementType
extends
    Parseable[ReserveRequirementType]
{
    val sup = BasicElement.parse _
    val CONT = parse_attribute (attribute ("""ReserveRequirementType.CONT"""))_
    val OPRSV = parse_attribute (attribute ("""ReserveRequirementType.OPRSV"""))_
    val REG = parse_attribute (attribute ("""ReserveRequirementType.REG"""))_
    def parse (context: Context): ReserveRequirementType =
    {
        ReserveRequirementType(
            sup (context),
            CONT (context),
            OPRSV (context),
            REG (context)
        )
    }
}

/**
 * Types used for resource AS qualifications
 */
case class ResourceAncillaryServiceType
(

    override val sup: BasicElement,

    /**
     * Black start
     */
    val BLACKSTART: String,

    /**
     * Demand Side Reponse
     */
    val DSR: String,

    /**
     * Non Spinning Reserve
     */
    val NONSPIN: String,

    /**
     * Intermittant resource
     */
    val PIRP: String,

    /**
     * Regulation Down
     */
    val REGDN: String,

    /**
     * Regulation Up
     */
    val REGUP: String,

    /**
     * Reliability Must Run
     */
    val RMR: String,

    /**
     * Spinning Reserve
     */
    val RRSPIN: String,

    /**
     * Reliability unit commitment
     */
    val RUC: String,

    val SYNCCOND: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ResourceAncillaryServiceType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ResourceAncillaryServiceType
extends
    Parseable[ResourceAncillaryServiceType]
{
    val sup = BasicElement.parse _
    val BLACKSTART = parse_attribute (attribute ("""ResourceAncillaryServiceType.BLACKSTART"""))_
    val DSR = parse_attribute (attribute ("""ResourceAncillaryServiceType.DSR"""))_
    val NONSPIN = parse_attribute (attribute ("""ResourceAncillaryServiceType.NONSPIN"""))_
    val PIRP = parse_attribute (attribute ("""ResourceAncillaryServiceType.PIRP"""))_
    val REGDN = parse_attribute (attribute ("""ResourceAncillaryServiceType.REGDN"""))_
    val REGUP = parse_attribute (attribute ("""ResourceAncillaryServiceType.REGUP"""))_
    val RMR = parse_attribute (attribute ("""ResourceAncillaryServiceType.RMR"""))_
    val RRSPIN = parse_attribute (attribute ("""ResourceAncillaryServiceType.RRSPIN"""))_
    val RUC = parse_attribute (attribute ("""ResourceAncillaryServiceType.RUC"""))_
    val SYNCCOND = parse_attribute (attribute ("""ResourceAncillaryServiceType.SYNCCOND"""))_
    def parse (context: Context): ResourceAncillaryServiceType =
    {
        ResourceAncillaryServiceType(
            sup (context),
            BLACKSTART (context),
            DSR (context),
            NONSPIN (context),
            PIRP (context),
            REGDN (context),
            REGUP (context),
            RMR (context),
            RRSPIN (context),
            RUC (context),
            SYNCCOND (context)
        )
    }
}

/**
 * For example:
Asset Owner Sink designator for use by CRR
Asset Owner Source designator for use by CRR
Reliability Must Run  
Scheduling Coordinator
 * Load Serving Entity
 */
case class ResourceAssnType
(

    override val sup: BasicElement,

    val CSNK: String,

    val CSRC: String,

    val LSE: String,

    val RMR: String,

    val SC: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ResourceAssnType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ResourceAssnType
extends
    Parseable[ResourceAssnType]
{
    val sup = BasicElement.parse _
    val CSNK = parse_attribute (attribute ("""ResourceAssnType.CSNK"""))_
    val CSRC = parse_attribute (attribute ("""ResourceAssnType.CSRC"""))_
    val LSE = parse_attribute (attribute ("""ResourceAssnType.LSE"""))_
    val RMR = parse_attribute (attribute ("""ResourceAssnType.RMR"""))_
    val SC = parse_attribute (attribute ("""ResourceAssnType.SC"""))_
    def parse (context: Context): ResourceAssnType =
    {
        ResourceAssnType(
            sup (context),
            CSNK (context),
            CSRC (context),
            LSE (context),
            RMR (context),
            SC (context)
        )
    }
}

/**
 * Resource capacity type.
 */
case class ResourceCapacityType
(

    override val sup: BasicElement,

    /**
     * Flexible Offer.
     */
    val FO: String,

    /**
     * Must Offer.
     */
    val MO: String,

    /**
     * Non spinning reserve.
     */
    val NR: String,

    /**
     * Resource Adequacy.
     */
    val RA: String,

    /**
     * Regulation Down.
     */
    val RD: String,

    /**
     * Reliability Must Run.
     */
    val RMR: String,

    /**
     * Regulation Up.
     */
    val RU: String,

    /**
     * Spinning reserve.
     */
    val SR: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ResourceCapacityType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ResourceCapacityType
extends
    Parseable[ResourceCapacityType]
{
    val sup = BasicElement.parse _
    val FO = parse_attribute (attribute ("""ResourceCapacityType.FO"""))_
    val MO = parse_attribute (attribute ("""ResourceCapacityType.MO"""))_
    val NR = parse_attribute (attribute ("""ResourceCapacityType.NR"""))_
    val RA = parse_attribute (attribute ("""ResourceCapacityType.RA"""))_
    val RD = parse_attribute (attribute ("""ResourceCapacityType.RD"""))_
    val RMR = parse_attribute (attribute ("""ResourceCapacityType.RMR"""))_
    val RU = parse_attribute (attribute ("""ResourceCapacityType.RU"""))_
    val SR = parse_attribute (attribute ("""ResourceCapacityType.SR"""))_
    def parse (context: Context): ResourceCapacityType =
    {
        ResourceCapacityType(
            sup (context),
            FO (context),
            MO (context),
            NR (context),
            RA (context),
            RD (context),
            RMR (context),
            RU (context),
            SR (context)
        )
    }
}

/**
 * Locational AS Flags indicating whether the Upper or Lower Bound limit of the AS regional procurment is binding
 */
case class ResourceLimitIndicator
(

    override val sup: BasicElement,

    val LOWER: String,

    val UPPER: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ResourceLimitIndicator]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ResourceLimitIndicator
extends
    Parseable[ResourceLimitIndicator]
{
    val sup = BasicElement.parse _
    val LOWER = parse_attribute (attribute ("""ResourceLimitIndicator.LOWER"""))_
    val UPPER = parse_attribute (attribute ("""ResourceLimitIndicator.UPPER"""))_
    def parse (context: Context): ResourceLimitIndicator =
    {
        ResourceLimitIndicator(
            sup (context),
            LOWER (context),
            UPPER (context)
        )
    }
}

/**
 * Types of resource registration status, for example:

Active
Mothballed
Planned
 * Decommissioned
 */
case class ResourceRegistrationStatus
(

    override val sup: BasicElement,

    /**
     * Resource registration is active
     */
    val Active: String,

    /**
     * Resource registration status is decommissioned
     */
    val Decommissioned: String,

    /**
     * Resource registration has been suspended
     */
    val Mothballed: String,

    /**
     * Registration status is in the planning stage
     */
    val Planned: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ResourceRegistrationStatus]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ResourceRegistrationStatus
extends
    Parseable[ResourceRegistrationStatus]
{
    val sup = BasicElement.parse _
    val Active = parse_attribute (attribute ("""ResourceRegistrationStatus.Active"""))_
    val Decommissioned = parse_attribute (attribute ("""ResourceRegistrationStatus.Decommissioned"""))_
    val Mothballed = parse_attribute (attribute ("""ResourceRegistrationStatus.Mothballed"""))_
    val Planned = parse_attribute (attribute ("""ResourceRegistrationStatus.Planned"""))_
    def parse (context: Context): ResourceRegistrationStatus =
    {
        ResourceRegistrationStatus(
            sup (context),
            Active (context),
            Decommissioned (context),
            Mothballed (context),
            Planned (context)
        )
    }
}

/**
 * Market results binding constraint types.
 */
case class ResultsConstraintType
(

    override val sup: BasicElement,

    /**
     * Actual.
     */
    val Actual: String,

    /**
     * Contingency.
     */
    val Contingency: String,

    /**
     * Flowgate actual base case
     */
    val FG_act: String,

    /**
     * Interface.
     */
    val Interface: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[ResultsConstraintType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ResultsConstraintType
extends
    Parseable[ResultsConstraintType]
{
    val sup = BasicElement.parse _
    val Actual = parse_attribute (attribute ("""ResultsConstraintType.Actual"""))_
    val Contingency = parse_attribute (attribute ("""ResultsConstraintType.Contingency"""))_
    val FG_act = parse_attribute (attribute ("""ResultsConstraintType.FG_act"""))_
    val Interface = parse_attribute (attribute ("""ResultsConstraintType.Interface"""))_
    def parse (context: Context): ResultsConstraintType =
    {
        ResultsConstraintType(
            sup (context),
            Actual (context),
            Contingency (context),
            FG_act (context),
            Interface (context)
        )
    }
}

/**
 * Indication of which type of self schedule is being referenced.
 */
case class SelfSchedReferenceType
(

    override val sup: BasicElement,

    /**
     * Existing transmission contract.
     */
    val ETC: String,

    /**
     * Transmission ownership right.
     */
    val TOR: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[SelfSchedReferenceType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SelfSchedReferenceType
extends
    Parseable[SelfSchedReferenceType]
{
    val sup = BasicElement.parse _
    val ETC = parse_attribute (attribute ("""SelfSchedReferenceType.ETC"""))_
    val TOR = parse_attribute (attribute ("""SelfSchedReferenceType.TOR"""))_
    def parse (context: Context): SelfSchedReferenceType =
    {
        SelfSchedReferenceType(
            sup (context),
            ETC (context),
            TOR (context)
        )
    }
}

/**
 * Self schedule breakdown type.
 */
case class SelfScheduleBreakdownType
(

    override val sup: BasicElement,

    /**
     * Existing transmission contract.
     */
    val ETC: String,

    /**
     * Low price taker.
     */
    val LPT: String,

    /**
     * Transmission ownership right.
     */
    val TOR: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[SelfScheduleBreakdownType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SelfScheduleBreakdownType
extends
    Parseable[SelfScheduleBreakdownType]
{
    val sup = BasicElement.parse _
    val ETC = parse_attribute (attribute ("""SelfScheduleBreakdownType.ETC"""))_
    val LPT = parse_attribute (attribute ("""SelfScheduleBreakdownType.LPT"""))_
    val TOR = parse_attribute (attribute ("""SelfScheduleBreakdownType.TOR"""))_
    def parse (context: Context): SelfScheduleBreakdownType =
    {
        SelfScheduleBreakdownType(
            sup (context),
            ETC (context),
            LPT (context),
            TOR (context)
        )
    }
}

/**
 * Circuit Breaker Status (closed or open) of the circuit breaker.
 */
case class SwitchStatusType
(

    override val sup: BasicElement,

    /**
     * Closed status.
     */
    val Closed: String,

    /**
     * Open status.
     */
    val Open: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[SwitchStatusType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object SwitchStatusType
extends
    Parseable[SwitchStatusType]
{
    val sup = BasicElement.parse _
    val Closed = parse_attribute (attribute ("""SwitchStatusType.Closed"""))_
    val Open = parse_attribute (attribute ("""SwitchStatusType.Open"""))_
    def parse (context: Context): SwitchStatusType =
    {
        SwitchStatusType(
            sup (context),
            Closed (context),
            Open (context)
        )
    }
}

/**
 * Transmission Contract Right type -for example:
 * individual or chain of contract rights
 */
case class TRType
(

    override val sup: BasicElement,

    /**
     * TR chain
     */
    val CHAIN: String,

    /**
     * Individual TR
     */
    val INDIVIDUAL: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TRType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TRType
extends
    Parseable[TRType]
{
    val sup = BasicElement.parse _
    val CHAIN = parse_attribute (attribute ("""TRType.CHAIN"""))_
    val INDIVIDUAL = parse_attribute (attribute ("""TRType.INDIVIDUAL"""))_
    def parse (context: Context): TRType =
    {
        TRType(
            sup (context),
            CHAIN (context),
            INDIVIDUAL (context)
        )
    }
}

/**
 * Time of Use used by a CRR definition for specifying the time the CRR spans.
 * ON - CRR spans the on peak hours of the day, OFF - CRR spans the off peak hours of the day, 24HR - CRR spans the entire day.
 */
case class TimeOfUse
(

    override val sup: BasicElement,

    /**
     * Time of use spans only the off peak hours of the day.
     */
    val OFF: String,

    /**
     * Time of use spans only the on peak hours of the day.
     */
    val ON: String,

    /**
     * Time of use spans the entire day, 24 hours.
     */
    val _24HR: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TimeOfUse]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TimeOfUse
extends
    Parseable[TimeOfUse]
{
    val sup = BasicElement.parse _
    val OFF = parse_attribute (attribute ("""TimeOfUse.OFF"""))_
    val ON = parse_attribute (attribute ("""TimeOfUse.ON"""))_
    val _24HR = parse_attribute (attribute ("""TimeOfUse.24HR"""))_
    def parse (context: Context): TimeOfUse =
    {
        TimeOfUse(
            sup (context),
            OFF (context),
            ON (context),
            _24HR (context)
        )
    }
}

/**
 * Trade type.
 */
case class TradeType
(

    override val sup: BasicElement,

    /**
     * Ancillary Services Trade.
     */
    val AST: String,

    /**
     * InterSC Trade.
     */
    val IST: String,

    /**
     * Unit Commitment Trade.
     */
    val UCT: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[TradeType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TradeType
extends
    Parseable[TradeType]
{
    val sup = BasicElement.parse _
    val AST = parse_attribute (attribute ("""TradeType.AST"""))_
    val IST = parse_attribute (attribute ("""TradeType.IST"""))_
    val UCT = parse_attribute (attribute ("""TradeType.UCT"""))_
    def parse (context: Context): TradeType =
    {
        TradeType(
            sup (context),
            AST (context),
            IST (context),
            UCT (context)
        )
    }
}

/**
 * Combined Cycle
Gas Turbine
Hydro Turbine
Other
Photovoltaic
Hydro Pump-Turbine
Reciprocating Engine
Steam Turbine
Synchronous Condenser
 * Wind Turbine
 */
case class UnitType
(

    override val sup: BasicElement,

    /**
     * Combined Cycle
     */
    val CCYC: String,

    /**
     * Gas Turbine
     */
    val GTUR: String,

    /**
     * Hydro Turbine
     */
    val HYDR: String,

    /**
     * Other
     */
    val OTHR: String,

    /**
     * Photovoltaic
     */
    val PHOT: String,

    /**
     * Hydro Pump-Turbine
     */
    val PTUR: String,

    /**
     * Reciprocating Engine
     */
    val RECP: String,

    /**
     * Steam Turbine
     */
    val STUR: String,

    /**
     * Synchronous Condenser
     */
    val SYNC: String,

    /**
     * Wind Turbine
     */
    val WIND: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[UnitType]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object UnitType
extends
    Parseable[UnitType]
{
    val sup = BasicElement.parse _
    val CCYC = parse_attribute (attribute ("""UnitType.CCYC"""))_
    val GTUR = parse_attribute (attribute ("""UnitType.GTUR"""))_
    val HYDR = parse_attribute (attribute ("""UnitType.HYDR"""))_
    val OTHR = parse_attribute (attribute ("""UnitType.OTHR"""))_
    val PHOT = parse_attribute (attribute ("""UnitType.PHOT"""))_
    val PTUR = parse_attribute (attribute ("""UnitType.PTUR"""))_
    val RECP = parse_attribute (attribute ("""UnitType.RECP"""))_
    val STUR = parse_attribute (attribute ("""UnitType.STUR"""))_
    val SYNC = parse_attribute (attribute ("""UnitType.SYNC"""))_
    val WIND = parse_attribute (attribute ("""UnitType.WIND"""))_
    def parse (context: Context): UnitType =
    {
        UnitType(
            sup (context),
            CCYC (context),
            GTUR (context),
            HYDR (context),
            OTHR (context),
            PHOT (context),
            PTUR (context),
            RECP (context),
            STUR (context),
            SYNC (context),
            WIND (context)
        )
    }
}

/**
 * Used as a flag set to Yes or No.
 */
case class YesNo
(

    override val sup: BasicElement,

    val NO: String,

    val YES: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[YesNo]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object YesNo
extends
    Parseable[YesNo]
{
    val sup = BasicElement.parse _
    val NO = parse_attribute (attribute ("""YesNo.NO"""))_
    val YES = parse_attribute (attribute ("""YesNo.YES"""))_
    def parse (context: Context): YesNo =
    {
        YesNo(
            sup (context),
            NO (context),
            YES (context)
        )
    }
}

object _MktDomain
{
    def register: Unit =
    {
        ActionType.register
        AnalogLimitType.register
        AnodeType.register
        ApnodeType.register
        AreaControlMode.register
        AutomaticDispInstTypeCommitment.register
        AutomaticDispatchMode.register
        BidCalculationBasis.register
        BidMitigationStatus.register
        BidMitigationType.register
        BidType.register
        BidTypeRMR.register
        CRRCategoryType.register
        CRRHedgeType.register
        CRRRoleType.register
        CRRSegmentType.register
        CheckOutType.register
        CommitmentType.register
        ConstraintLimitType.register
        ConstraintRampType.register
        ContractType.register
        CostBasis.register
        DispatchResponseType.register
        EnergyPriceIndexType.register
        EnergyProductType.register
        EnergyTransactionType.register
        EquipmentStatusType.register
        ExecutionType.register
        FlagTypeRMR.register
        FlowDirectionType.register
        FuelSource.register
        InterTieDirection.register
        LoadForecastType.register
        MPMTestIdentifierType.register
        MPMTestMethodType.register
        MPMTestOutcome.register
        MQSCHGType.register
        MQSInstructionSource.register
        MarketProductSelfSchedType.register
        MarketProductType.register
        MarketType.register
        MktAccountKind.register
        MktBillMediaKind.register
        MktInvoiceLineItemKind.register
        OnOff.register
        ParticipationCategoryMPM.register
        PassIndicatorType.register
        PurposeFlagType.register
        RampCurveType.register
        RampModeType.register
        RampRateCondition.register
        RampRateType.register
        ReserveRequirementType.register
        ResourceAncillaryServiceType.register
        ResourceAssnType.register
        ResourceCapacityType.register
        ResourceLimitIndicator.register
        ResourceRegistrationStatus.register
        ResultsConstraintType.register
        SelfSchedReferenceType.register
        SelfScheduleBreakdownType.register
        SwitchStatusType.register
        TRType.register
        TimeOfUse.register
        TradeType.register
        UnitType.register
        YesNo.register
    }
}
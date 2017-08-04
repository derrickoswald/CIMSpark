package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * The MktDomain package is a data dictionary of quantities and units that define datatypes for attributes (properties) that may be used by any class in any other package within MarketOperations.
 */

/**
 * Action type associated with an ActionRequest against a ParticipantInterfaces::Trade.
 * @param sup Reference to the superclass object.
 * @param CANCEL Cancel a trade.
 */
case class ActionType
(
    override val sup: BasicElement,
    CANCEL: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ActionType] }
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
        (if (null != CANCEL) "\t\t<cim:ActionType.CANCEL rdf:resource=\"#" + CANCEL + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ActionType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ActionType>\n"
    }
}

object ActionType
extends
    Parseable[ActionType]
{
    val CANCEL: (Context) => String = parse_attribute (attribute ("""ActionType.CANCEL"""))
    def parse (context: Context): ActionType =
    {
        ActionType(
            BasicElement.parse (context),
            CANCEL (context)
        )
    }
}

/**
 * Limit type specified for AnalogLimits.
 * @param sup Reference to the superclass object.
 * @param BranchLongTerm Branch Long Term Limit
 * @param BranchMediumTerm Branch Medium Term Limit
 * @param BranchShortTerm Branch Short Term Limit
 * @param VoltageHigh Voltage High Limit
 * @param VoltageLow Voltage Low Limit
 */
case class AnalogLimitType
(
    override val sup: BasicElement,
    BranchLongTerm: String,
    BranchMediumTerm: String,
    BranchShortTerm: String,
    VoltageHigh: String,
    VoltageLow: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AnalogLimitType] }
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
        (if (null != BranchLongTerm) "\t\t<cim:AnalogLimitType.BranchLongTerm rdf:resource=\"#" + BranchLongTerm + "\"/>\n" else "") +
        (if (null != BranchMediumTerm) "\t\t<cim:AnalogLimitType.BranchMediumTerm rdf:resource=\"#" + BranchMediumTerm + "\"/>\n" else "") +
        (if (null != BranchShortTerm) "\t\t<cim:AnalogLimitType.BranchShortTerm rdf:resource=\"#" + BranchShortTerm + "\"/>\n" else "") +
        (if (null != VoltageHigh) "\t\t<cim:AnalogLimitType.VoltageHigh rdf:resource=\"#" + VoltageHigh + "\"/>\n" else "") +
        (if (null != VoltageLow) "\t\t<cim:AnalogLimitType.VoltageLow rdf:resource=\"#" + VoltageLow + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AnalogLimitType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AnalogLimitType>\n"
    }
}

object AnalogLimitType
extends
    Parseable[AnalogLimitType]
{
    val BranchLongTerm: (Context) => String = parse_attribute (attribute ("""AnalogLimitType.BranchLongTerm"""))
    val BranchMediumTerm: (Context) => String = parse_attribute (attribute ("""AnalogLimitType.BranchMediumTerm"""))
    val BranchShortTerm: (Context) => String = parse_attribute (attribute ("""AnalogLimitType.BranchShortTerm"""))
    val VoltageHigh: (Context) => String = parse_attribute (attribute ("""AnalogLimitType.VoltageHigh"""))
    val VoltageLow: (Context) => String = parse_attribute (attribute ("""AnalogLimitType.VoltageLow"""))
    def parse (context: Context): AnalogLimitType =
    {
        AnalogLimitType(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param ACA Adjacent Control Area
 * @param AGR Aggregate Generation Resource;
 * @param ALR Aggregate Load Resource;
 * @param ASR Aggregated System Resource
 * @param ECA Embedded Control Area
 * @param LFZ Load Forecast Zone
 * @param LTAC Load TransmissionAccessCharge (TAC) Group;
 * @param POD Point of Delivery;
 * @param REG Market Energy/Ancillary Service Region;
 * @param RUC RUC Zone
 * @param SYS System Zone/Region;
 */
case class AnodeType
(
    override val sup: BasicElement,
    ACA: String,
    AGR: String,
    ALR: String,
    ASR: String,
    ECA: String,
    LFZ: String,
    LTAC: String,
    POD: String,
    REG: String,
    RUC: String,
    SYS: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AnodeType] }
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
        (if (null != ACA) "\t\t<cim:AnodeType.ACA rdf:resource=\"#" + ACA + "\"/>\n" else "") +
        (if (null != AGR) "\t\t<cim:AnodeType.AGR rdf:resource=\"#" + AGR + "\"/>\n" else "") +
        (if (null != ALR) "\t\t<cim:AnodeType.ALR rdf:resource=\"#" + ALR + "\"/>\n" else "") +
        (if (null != ASR) "\t\t<cim:AnodeType.ASR rdf:resource=\"#" + ASR + "\"/>\n" else "") +
        (if (null != ECA) "\t\t<cim:AnodeType.ECA rdf:resource=\"#" + ECA + "\"/>\n" else "") +
        (if (null != LFZ) "\t\t<cim:AnodeType.LFZ rdf:resource=\"#" + LFZ + "\"/>\n" else "") +
        (if (null != LTAC) "\t\t<cim:AnodeType.LTAC rdf:resource=\"#" + LTAC + "\"/>\n" else "") +
        (if (null != POD) "\t\t<cim:AnodeType.POD rdf:resource=\"#" + POD + "\"/>\n" else "") +
        (if (null != REG) "\t\t<cim:AnodeType.REG rdf:resource=\"#" + REG + "\"/>\n" else "") +
        (if (null != RUC) "\t\t<cim:AnodeType.RUC rdf:resource=\"#" + RUC + "\"/>\n" else "") +
        (if (null != SYS) "\t\t<cim:AnodeType.SYS rdf:resource=\"#" + SYS + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AnodeType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AnodeType>\n"
    }
}

object AnodeType
extends
    Parseable[AnodeType]
{
    val ACA: (Context) => String = parse_attribute (attribute ("""AnodeType.ACA"""))
    val AGR: (Context) => String = parse_attribute (attribute ("""AnodeType.AGR"""))
    val ALR: (Context) => String = parse_attribute (attribute ("""AnodeType.ALR"""))
    val ASR: (Context) => String = parse_attribute (attribute ("""AnodeType.ASR"""))
    val ECA: (Context) => String = parse_attribute (attribute ("""AnodeType.ECA"""))
    val LFZ: (Context) => String = parse_attribute (attribute ("""AnodeType.LFZ"""))
    val LTAC: (Context) => String = parse_attribute (attribute ("""AnodeType.LTAC"""))
    val POD: (Context) => String = parse_attribute (attribute ("""AnodeType.POD"""))
    val REG: (Context) => String = parse_attribute (attribute ("""AnodeType.REG"""))
    val RUC: (Context) => String = parse_attribute (attribute ("""AnodeType.RUC"""))
    val SYS: (Context) => String = parse_attribute (attribute ("""AnodeType.SYS"""))
    def parse (context: Context): AnodeType =
    {
        AnodeType(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param AG Aggregated Generation
 * @param BUS Bus
 * @param CA Control Area
 * @param CPZ Custom Price Zone
 * @param DCA Designated Congestion Area
 * @param DPZ Default Price Zone
 * @param EHV 500 kV - Extra High Voltage aggregate price nodes
 * @param GA generic aggregation
 * @param GH generic hub
 * @param INT Interface
 * @param SYS System Zone
 * @param TH Trading  Hub
 * @param ZN Zone
 */
case class ApnodeType
(
    override val sup: BasicElement,
    AG: String,
    BUS: String,
    CA: String,
    CPZ: String,
    DCA: String,
    DPZ: String,
    EHV: String,
    GA: String,
    GH: String,
    INT: String,
    SYS: String,
    TH: String,
    ZN: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ApnodeType] }
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
        (if (null != AG) "\t\t<cim:ApnodeType.AG rdf:resource=\"#" + AG + "\"/>\n" else "") +
        (if (null != BUS) "\t\t<cim:ApnodeType.BUS rdf:resource=\"#" + BUS + "\"/>\n" else "") +
        (if (null != CA) "\t\t<cim:ApnodeType.CA rdf:resource=\"#" + CA + "\"/>\n" else "") +
        (if (null != CPZ) "\t\t<cim:ApnodeType.CPZ rdf:resource=\"#" + CPZ + "\"/>\n" else "") +
        (if (null != DCA) "\t\t<cim:ApnodeType.DCA rdf:resource=\"#" + DCA + "\"/>\n" else "") +
        (if (null != DPZ) "\t\t<cim:ApnodeType.DPZ rdf:resource=\"#" + DPZ + "\"/>\n" else "") +
        (if (null != EHV) "\t\t<cim:ApnodeType.EHV rdf:resource=\"#" + EHV + "\"/>\n" else "") +
        (if (null != GA) "\t\t<cim:ApnodeType.GA rdf:resource=\"#" + GA + "\"/>\n" else "") +
        (if (null != GH) "\t\t<cim:ApnodeType.GH rdf:resource=\"#" + GH + "\"/>\n" else "") +
        (if (null != INT) "\t\t<cim:ApnodeType.INT rdf:resource=\"#" + INT + "\"/>\n" else "") +
        (if (null != SYS) "\t\t<cim:ApnodeType.SYS rdf:resource=\"#" + SYS + "\"/>\n" else "") +
        (if (null != TH) "\t\t<cim:ApnodeType.TH rdf:resource=\"#" + TH + "\"/>\n" else "") +
        (if (null != ZN) "\t\t<cim:ApnodeType.ZN rdf:resource=\"#" + ZN + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ApnodeType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ApnodeType>\n"
    }
}

object ApnodeType
extends
    Parseable[ApnodeType]
{
    val AG: (Context) => String = parse_attribute (attribute ("""ApnodeType.AG"""))
    val BUS: (Context) => String = parse_attribute (attribute ("""ApnodeType.BUS"""))
    val CA: (Context) => String = parse_attribute (attribute ("""ApnodeType.CA"""))
    val CPZ: (Context) => String = parse_attribute (attribute ("""ApnodeType.CPZ"""))
    val DCA: (Context) => String = parse_attribute (attribute ("""ApnodeType.DCA"""))
    val DPZ: (Context) => String = parse_attribute (attribute ("""ApnodeType.DPZ"""))
    val EHV: (Context) => String = parse_attribute (attribute ("""ApnodeType.EHV"""))
    val GA: (Context) => String = parse_attribute (attribute ("""ApnodeType.GA"""))
    val GH: (Context) => String = parse_attribute (attribute ("""ApnodeType.GH"""))
    val INT: (Context) => String = parse_attribute (attribute ("""ApnodeType.INT"""))
    val SYS: (Context) => String = parse_attribute (attribute ("""ApnodeType.SYS"""))
    val TH: (Context) => String = parse_attribute (attribute ("""ApnodeType.TH"""))
    val ZN: (Context) => String = parse_attribute (attribute ("""ApnodeType.ZN"""))
    def parse (context: Context): ApnodeType =
    {
        ApnodeType(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param CF CF = Constant Frequency
 * @param CTL Constant Tie-Line
 * @param OFF Off control
 * @param TLB Tie-Line Bias
 */
case class AreaControlMode
(
    override val sup: BasicElement,
    CF: String,
    CTL: String,
    OFF: String,
    TLB: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AreaControlMode] }
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
        (if (null != CF) "\t\t<cim:AreaControlMode.CF rdf:resource=\"#" + CF + "\"/>\n" else "") +
        (if (null != CTL) "\t\t<cim:AreaControlMode.CTL rdf:resource=\"#" + CTL + "\"/>\n" else "") +
        (if (null != OFF) "\t\t<cim:AreaControlMode.OFF rdf:resource=\"#" + OFF + "\"/>\n" else "") +
        (if (null != TLB) "\t\t<cim:AreaControlMode.TLB rdf:resource=\"#" + TLB + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AreaControlMode rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AreaControlMode>\n"
    }
}

object AreaControlMode
extends
    Parseable[AreaControlMode]
{
    val CF: (Context) => String = parse_attribute (attribute ("""AreaControlMode.CF"""))
    val CTL: (Context) => String = parse_attribute (attribute ("""AreaControlMode.CTL"""))
    val OFF: (Context) => String = parse_attribute (attribute ("""AreaControlMode.OFF"""))
    val TLB: (Context) => String = parse_attribute (attribute ("""AreaControlMode.TLB"""))
    def parse (context: Context): AreaControlMode =
    {
        AreaControlMode(
            BasicElement.parse (context),
            CF (context),
            CTL (context),
            OFF (context),
            TLB (context)
        )
    }
}

/**
 * Commitment instruction types.
 * @param sup Reference to the superclass object.
 * @param SHUT_DOWN Shut down instruction type
 * @param START_UP Start up instruction type
 */
case class AutomaticDispInstTypeCommitment
(
    override val sup: BasicElement,
    SHUT_DOWN: String,
    START_UP: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AutomaticDispInstTypeCommitment] }
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
        (if (null != SHUT_DOWN) "\t\t<cim:AutomaticDispInstTypeCommitment.SHUT_DOWN rdf:resource=\"#" + SHUT_DOWN + "\"/>\n" else "") +
        (if (null != START_UP) "\t\t<cim:AutomaticDispInstTypeCommitment.START_UP rdf:resource=\"#" + START_UP + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AutomaticDispInstTypeCommitment rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AutomaticDispInstTypeCommitment>\n"
    }
}

object AutomaticDispInstTypeCommitment
extends
    Parseable[AutomaticDispInstTypeCommitment]
{
    val SHUT_DOWN: (Context) => String = parse_attribute (attribute ("""AutomaticDispInstTypeCommitment.SHUT_DOWN"""))
    val START_UP: (Context) => String = parse_attribute (attribute ("""AutomaticDispInstTypeCommitment.START_UP"""))
    def parse (context: Context): AutomaticDispInstTypeCommitment =
    {
        AutomaticDispInstTypeCommitment(
            BasicElement.parse (context),
            SHUT_DOWN (context),
            START_UP (context)
        )
    }
}

/**
 * Automatic Dispatch mode
 * @param sup Reference to the superclass object.
 * @param CONTINGENCY Contingnency occurance, redispatch of contingency reserves
 * @param INTERVAL <em>undocumented</em>
 * @param MANUAL Operator override
 */
case class AutomaticDispatchMode
(
    override val sup: BasicElement,
    CONTINGENCY: String,
    INTERVAL: String,
    MANUAL: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[AutomaticDispatchMode] }
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
        (if (null != CONTINGENCY) "\t\t<cim:AutomaticDispatchMode.CONTINGENCY rdf:resource=\"#" + CONTINGENCY + "\"/>\n" else "") +
        (if (null != INTERVAL) "\t\t<cim:AutomaticDispatchMode.INTERVAL rdf:resource=\"#" + INTERVAL + "\"/>\n" else "") +
        (if (null != MANUAL) "\t\t<cim:AutomaticDispatchMode.MANUAL rdf:resource=\"#" + MANUAL + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:AutomaticDispatchMode rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:AutomaticDispatchMode>\n"
    }
}

object AutomaticDispatchMode
extends
    Parseable[AutomaticDispatchMode]
{
    val CONTINGENCY: (Context) => String = parse_attribute (attribute ("""AutomaticDispatchMode.CONTINGENCY"""))
    val INTERVAL: (Context) => String = parse_attribute (attribute ("""AutomaticDispatchMode.INTERVAL"""))
    val MANUAL: (Context) => String = parse_attribute (attribute ("""AutomaticDispatchMode.MANUAL"""))
    def parse (context: Context): AutomaticDispatchMode =
    {
        AutomaticDispatchMode(
            BasicElement.parse (context),
            CONTINGENCY (context),
            INTERVAL (context),
            MANUAL (context)
        )
    }
}

/**
 * The basis used to calculate the bid price curve for an energy default bid.
 * @param sup Reference to the superclass object.
 * @param COST_BASED Based on unit generation characteristics and a cost of fuel.
 * @param LMP_BASED Based on prices paid at particular pricing location.
 * @param NEGOTIATED An amount negotiated with the designated Independent Entity.
 */
case class BidCalculationBasis
(
    override val sup: BasicElement,
    COST_BASED: String,
    LMP_BASED: String,
    NEGOTIATED: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[BidCalculationBasis] }
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
        (if (null != COST_BASED) "\t\t<cim:BidCalculationBasis.COST_BASED rdf:resource=\"#" + COST_BASED + "\"/>\n" else "") +
        (if (null != LMP_BASED) "\t\t<cim:BidCalculationBasis.LMP_BASED rdf:resource=\"#" + LMP_BASED + "\"/>\n" else "") +
        (if (null != NEGOTIATED) "\t\t<cim:BidCalculationBasis.NEGOTIATED rdf:resource=\"#" + NEGOTIATED + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:BidCalculationBasis rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BidCalculationBasis>\n"
    }
}

object BidCalculationBasis
extends
    Parseable[BidCalculationBasis]
{
    val COST_BASED: (Context) => String = parse_attribute (attribute ("""BidCalculationBasis.COST_BASED"""))
    val LMP_BASED: (Context) => String = parse_attribute (attribute ("""BidCalculationBasis.LMP_BASED"""))
    val NEGOTIATED: (Context) => String = parse_attribute (attribute ("""BidCalculationBasis.NEGOTIATED"""))
    def parse (context: Context): BidCalculationBasis =
    {
        BidCalculationBasis(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param B <em>undocumented</em>
 * @param L <em>undocumented</em>
 * @param M <em>undocumented</em>
 * @param O <em>undocumented</em>
 * @param R <em>undocumented</em>
 * @param S <em>undocumented</em>
 */
case class BidMitigationStatus
(
    override val sup: BasicElement,
    B: String,
    L: String,
    M: String,
    O: String,
    R: String,
    S: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[BidMitigationStatus] }
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
        (if (null != B) "\t\t<cim:BidMitigationStatus.B rdf:resource=\"#" + B + "\"/>\n" else "") +
        (if (null != L) "\t\t<cim:BidMitigationStatus.L rdf:resource=\"#" + L + "\"/>\n" else "") +
        (if (null != M) "\t\t<cim:BidMitigationStatus.M rdf:resource=\"#" + M + "\"/>\n" else "") +
        (if (null != O) "\t\t<cim:BidMitigationStatus.O rdf:resource=\"#" + O + "\"/>\n" else "") +
        (if (null != R) "\t\t<cim:BidMitigationStatus.R rdf:resource=\"#" + R + "\"/>\n" else "") +
        (if (null != S) "\t\t<cim:BidMitigationStatus.S rdf:resource=\"#" + S + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:BidMitigationStatus rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BidMitigationStatus>\n"
    }
}

object BidMitigationStatus
extends
    Parseable[BidMitigationStatus]
{
    val B: (Context) => String = parse_attribute (attribute ("""BidMitigationStatus.B"""))
    val L: (Context) => String = parse_attribute (attribute ("""BidMitigationStatus.L"""))
    val M: (Context) => String = parse_attribute (attribute ("""BidMitigationStatus.M"""))
    val O: (Context) => String = parse_attribute (attribute ("""BidMitigationStatus.O"""))
    val R: (Context) => String = parse_attribute (attribute ("""BidMitigationStatus.R"""))
    val S: (Context) => String = parse_attribute (attribute ("""BidMitigationStatus.S"""))
    def parse (context: Context): BidMitigationStatus =
    {
        BidMitigationStatus(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param F <em>undocumented</em>
 * @param I <em>undocumented</em>
 */
case class BidMitigationType
(
    override val sup: BasicElement,
    F: String,
    I: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[BidMitigationType] }
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
        (if (null != F) "\t\t<cim:BidMitigationType.F rdf:resource=\"#" + F + "\"/>\n" else "") +
        (if (null != I) "\t\t<cim:BidMitigationType.I rdf:resource=\"#" + I + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:BidMitigationType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BidMitigationType>\n"
    }
}

object BidMitigationType
extends
    Parseable[BidMitigationType]
{
    val F: (Context) => String = parse_attribute (attribute ("""BidMitigationType.F"""))
    val I: (Context) => String = parse_attribute (attribute ("""BidMitigationType.I"""))
    def parse (context: Context): BidMitigationType =
    {
        BidMitigationType(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param DEFAULT_ENERGY_BID <em>undocumented</em>
 * @param DEFAULT_MINIMUM_LOAD_BID <em>undocumented</em>
 * @param DEFAULT_STARTUP_BID <em>undocumented</em>
 */
case class BidType
(
    override val sup: BasicElement,
    DEFAULT_ENERGY_BID: String,
    DEFAULT_MINIMUM_LOAD_BID: String,
    DEFAULT_STARTUP_BID: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[BidType] }
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
        (if (null != DEFAULT_ENERGY_BID) "\t\t<cim:BidType.DEFAULT_ENERGY_BID rdf:resource=\"#" + DEFAULT_ENERGY_BID + "\"/>\n" else "") +
        (if (null != DEFAULT_MINIMUM_LOAD_BID) "\t\t<cim:BidType.DEFAULT_MINIMUM_LOAD_BID rdf:resource=\"#" + DEFAULT_MINIMUM_LOAD_BID + "\"/>\n" else "") +
        (if (null != DEFAULT_STARTUP_BID) "\t\t<cim:BidType.DEFAULT_STARTUP_BID rdf:resource=\"#" + DEFAULT_STARTUP_BID + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:BidType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BidType>\n"
    }
}

object BidType
extends
    Parseable[BidType]
{
    val DEFAULT_ENERGY_BID: (Context) => String = parse_attribute (attribute ("""BidType.DEFAULT_ENERGY_BID"""))
    val DEFAULT_MINIMUM_LOAD_BID: (Context) => String = parse_attribute (attribute ("""BidType.DEFAULT_MINIMUM_LOAD_BID"""))
    val DEFAULT_STARTUP_BID: (Context) => String = parse_attribute (attribute ("""BidType.DEFAULT_STARTUP_BID"""))
    def parse (context: Context): BidType =
    {
        BidType(
            BasicElement.parse (context),
            DEFAULT_ENERGY_BID (context),
            DEFAULT_MINIMUM_LOAD_BID (context),
            DEFAULT_STARTUP_BID (context)
        )
    }
}

/**
 * Bid self schedule type has two types as the required output of requirements and qualified pre-dispatch.
 * @param sup Reference to the superclass object.
 * @param QUALIFIED_PREDISPATCH Output of requirements bid self schedule type.
 * @param REQUIREMENTS Qualified pre-dispatch bid self schedule type.
 */
case class BidTypeRMR
(
    override val sup: BasicElement,
    QUALIFIED_PREDISPATCH: String,
    REQUIREMENTS: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[BidTypeRMR] }
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
        (if (null != QUALIFIED_PREDISPATCH) "\t\t<cim:BidTypeRMR.QUALIFIED_PREDISPATCH rdf:resource=\"#" + QUALIFIED_PREDISPATCH + "\"/>\n" else "") +
        (if (null != REQUIREMENTS) "\t\t<cim:BidTypeRMR.REQUIREMENTS rdf:resource=\"#" + REQUIREMENTS + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:BidTypeRMR rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:BidTypeRMR>\n"
    }
}

object BidTypeRMR
extends
    Parseable[BidTypeRMR]
{
    val QUALIFIED_PREDISPATCH: (Context) => String = parse_attribute (attribute ("""BidTypeRMR.QUALIFIED_PREDISPATCH"""))
    val REQUIREMENTS: (Context) => String = parse_attribute (attribute ("""BidTypeRMR.REQUIREMENTS"""))
    def parse (context: Context): BidTypeRMR =
    {
        BidTypeRMR(
            BasicElement.parse (context),
            QUALIFIED_PREDISPATCH (context),
            REQUIREMENTS (context)
        )
    }
}

/**
 * Congestion Revenue Rights category types
 * @param sup Reference to the superclass object.
 * @param NSR Network Service
 * @param PTP Point to Point
 */
case class CRRCategoryType
(
    override val sup: BasicElement,
    NSR: String,
    PTP: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[CRRCategoryType] }
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
        (if (null != NSR) "\t\t<cim:CRRCategoryType.NSR rdf:resource=\"#" + NSR + "\"/>\n" else "") +
        (if (null != PTP) "\t\t<cim:CRRCategoryType.PTP rdf:resource=\"#" + PTP + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CRRCategoryType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CRRCategoryType>\n"
    }
}

object CRRCategoryType
extends
    Parseable[CRRCategoryType]
{
    val NSR: (Context) => String = parse_attribute (attribute ("""CRRCategoryType.NSR"""))
    val PTP: (Context) => String = parse_attribute (attribute ("""CRRCategoryType.PTP"""))
    def parse (context: Context): CRRCategoryType =
    {
        CRRCategoryType(
            BasicElement.parse (context),
            NSR (context),
            PTP (context)
        )
    }
}

/**
 * Congestion Revenue Right hedge type
 * @param sup Reference to the superclass object.
 * @param OBLIGATION <em>undocumented</em>
 * @param OPTION <em>undocumented</em>
 */
case class CRRHedgeType
(
    override val sup: BasicElement,
    OBLIGATION: String,
    OPTION: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[CRRHedgeType] }
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
        (if (null != OBLIGATION) "\t\t<cim:CRRHedgeType.OBLIGATION rdf:resource=\"#" + OBLIGATION + "\"/>\n" else "") +
        (if (null != OPTION) "\t\t<cim:CRRHedgeType.OPTION rdf:resource=\"#" + OPTION + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CRRHedgeType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CRRHedgeType>\n"
    }
}

object CRRHedgeType
extends
    Parseable[CRRHedgeType]
{
    val OBLIGATION: (Context) => String = parse_attribute (attribute ("""CRRHedgeType.OBLIGATION"""))
    val OPTION: (Context) => String = parse_attribute (attribute ("""CRRHedgeType.OPTION"""))
    def parse (context: Context): CRRHedgeType =
    {
        CRRHedgeType(
            BasicElement.parse (context),
            OBLIGATION (context),
            OPTION (context)
        )
    }
}

/**
 * Role types an organisation can play with respect to a congestion revenue right.
 * @param sup Reference to the superclass object.
 * @param BUYER <em>undocumented</em>
 * @param OWNER <em>undocumented</em>
 * @param SELLER <em>undocumented</em>
 */
case class CRRRoleType
(
    override val sup: BasicElement,
    BUYER: String,
    OWNER: String,
    SELLER: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[CRRRoleType] }
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
        (if (null != BUYER) "\t\t<cim:CRRRoleType.BUYER rdf:resource=\"#" + BUYER + "\"/>\n" else "") +
        (if (null != OWNER) "\t\t<cim:CRRRoleType.OWNER rdf:resource=\"#" + OWNER + "\"/>\n" else "") +
        (if (null != SELLER) "\t\t<cim:CRRRoleType.SELLER rdf:resource=\"#" + SELLER + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CRRRoleType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CRRRoleType>\n"
    }
}

object CRRRoleType
extends
    Parseable[CRRRoleType]
{
    val BUYER: (Context) => String = parse_attribute (attribute ("""CRRRoleType.BUYER"""))
    val OWNER: (Context) => String = parse_attribute (attribute ("""CRRRoleType.OWNER"""))
    val SELLER: (Context) => String = parse_attribute (attribute ("""CRRRoleType.SELLER"""))
    def parse (context: Context): CRRRoleType =
    {
        CRRRoleType(
            BasicElement.parse (context),
            BUYER (context),
            OWNER (context),
            SELLER (context)
        )
    }
}

/**
 * Type of the CRR, from the possible type definitions in the CRR System (e.g. 'LSE', 'ETC').
 * @param sup Reference to the superclass object.
 * @param AUC <em>undocumented</em>
 * @param CAP <em>undocumented</em>
 * @param CF <em>undocumented</em>
 * @param CVR Converted rights.
 * @param ETC Existing Transmission Contract.
 * @param LSE Load Serving Entity.
 * @param MT Merchant transmission.
 * @param TOR Transmission Ownership Rights.
 */
case class CRRSegmentType
(
    override val sup: BasicElement,
    AUC: String,
    CAP: String,
    CF: String,
    CVR: String,
    ETC: String,
    LSE: String,
    MT: String,
    TOR: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[CRRSegmentType] }
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
        (if (null != AUC) "\t\t<cim:CRRSegmentType.AUC rdf:resource=\"#" + AUC + "\"/>\n" else "") +
        (if (null != CAP) "\t\t<cim:CRRSegmentType.CAP rdf:resource=\"#" + CAP + "\"/>\n" else "") +
        (if (null != CF) "\t\t<cim:CRRSegmentType.CF rdf:resource=\"#" + CF + "\"/>\n" else "") +
        (if (null != CVR) "\t\t<cim:CRRSegmentType.CVR rdf:resource=\"#" + CVR + "\"/>\n" else "") +
        (if (null != ETC) "\t\t<cim:CRRSegmentType.ETC rdf:resource=\"#" + ETC + "\"/>\n" else "") +
        (if (null != LSE) "\t\t<cim:CRRSegmentType.LSE rdf:resource=\"#" + LSE + "\"/>\n" else "") +
        (if (null != MT) "\t\t<cim:CRRSegmentType.MT rdf:resource=\"#" + MT + "\"/>\n" else "") +
        (if (null != TOR) "\t\t<cim:CRRSegmentType.TOR rdf:resource=\"#" + TOR + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CRRSegmentType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CRRSegmentType>\n"
    }
}

object CRRSegmentType
extends
    Parseable[CRRSegmentType]
{
    val AUC: (Context) => String = parse_attribute (attribute ("""CRRSegmentType.AUC"""))
    val CAP: (Context) => String = parse_attribute (attribute ("""CRRSegmentType.CAP"""))
    val CF: (Context) => String = parse_attribute (attribute ("""CRRSegmentType.CF"""))
    val CVR: (Context) => String = parse_attribute (attribute ("""CRRSegmentType.CVR"""))
    val ETC: (Context) => String = parse_attribute (attribute ("""CRRSegmentType.ETC"""))
    val LSE: (Context) => String = parse_attribute (attribute ("""CRRSegmentType.LSE"""))
    val MT: (Context) => String = parse_attribute (attribute ("""CRRSegmentType.MT"""))
    val TOR: (Context) => String = parse_attribute (attribute ("""CRRSegmentType.TOR"""))
    def parse (context: Context): CRRSegmentType =
    {
        CRRSegmentType(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param AFTER_THE_FACT <em>undocumented</em>
 * @param PRE_HOUR <em>undocumented</em>
 * @param PRE_SCHEDULE <em>undocumented</em>
 */
case class CheckOutType
(
    override val sup: BasicElement,
    AFTER_THE_FACT: String,
    PRE_HOUR: String,
    PRE_SCHEDULE: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[CheckOutType] }
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
        (if (null != AFTER_THE_FACT) "\t\t<cim:CheckOutType.AFTER_THE_FACT rdf:resource=\"#" + AFTER_THE_FACT + "\"/>\n" else "") +
        (if (null != PRE_HOUR) "\t\t<cim:CheckOutType.PRE_HOUR rdf:resource=\"#" + PRE_HOUR + "\"/>\n" else "") +
        (if (null != PRE_SCHEDULE) "\t\t<cim:CheckOutType.PRE_SCHEDULE rdf:resource=\"#" + PRE_SCHEDULE + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CheckOutType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CheckOutType>\n"
    }
}

object CheckOutType
extends
    Parseable[CheckOutType]
{
    val AFTER_THE_FACT: (Context) => String = parse_attribute (attribute ("""CheckOutType.AFTER_THE_FACT"""))
    val PRE_HOUR: (Context) => String = parse_attribute (attribute ("""CheckOutType.PRE_HOUR"""))
    val PRE_SCHEDULE: (Context) => String = parse_attribute (attribute ("""CheckOutType.PRE_SCHEDULE"""))
    def parse (context: Context): CheckOutType =
    {
        CheckOutType(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param ISO <em>undocumented</em>
 * @param SELF <em>undocumented</em>
 * @param UC <em>undocumented</em>
 */
case class CommitmentType
(
    override val sup: BasicElement,
    ISO: String,
    SELF: String,
    UC: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[CommitmentType] }
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
        (if (null != ISO) "\t\t<cim:CommitmentType.ISO rdf:resource=\"#" + ISO + "\"/>\n" else "") +
        (if (null != SELF) "\t\t<cim:CommitmentType.SELF rdf:resource=\"#" + SELF + "\"/>\n" else "") +
        (if (null != UC) "\t\t<cim:CommitmentType.UC rdf:resource=\"#" + UC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CommitmentType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CommitmentType>\n"
    }
}

object CommitmentType
extends
    Parseable[CommitmentType]
{
    val ISO: (Context) => String = parse_attribute (attribute ("""CommitmentType.ISO"""))
    val SELF: (Context) => String = parse_attribute (attribute ("""CommitmentType.SELF"""))
    val UC: (Context) => String = parse_attribute (attribute ("""CommitmentType.UC"""))
    def parse (context: Context): CommitmentType =
    {
        CommitmentType(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param MAXIMUM <em>undocumented</em>
 * @param MINIMUM <em>undocumented</em>
 */
case class ConstraintLimitType
(
    override val sup: BasicElement,
    MAXIMUM: String,
    MINIMUM: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ConstraintLimitType] }
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
        (if (null != MAXIMUM) "\t\t<cim:ConstraintLimitType.MAXIMUM rdf:resource=\"#" + MAXIMUM + "\"/>\n" else "") +
        (if (null != MINIMUM) "\t\t<cim:ConstraintLimitType.MINIMUM rdf:resource=\"#" + MINIMUM + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ConstraintLimitType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ConstraintLimitType>\n"
    }
}

object ConstraintLimitType
extends
    Parseable[ConstraintLimitType]
{
    val MAXIMUM: (Context) => String = parse_attribute (attribute ("""ConstraintLimitType.MAXIMUM"""))
    val MINIMUM: (Context) => String = parse_attribute (attribute ("""ConstraintLimitType.MINIMUM"""))
    def parse (context: Context): ConstraintLimitType =
    {
        ConstraintLimitType(
            BasicElement.parse (context),
            MAXIMUM (context),
            MINIMUM (context)
        )
    }
}

/**
 * Constraint Ramp type
 * @param sup Reference to the superclass object.
 * @param FAST <em>undocumented</em>
 * @param SLOW <em>undocumented</em>
 */
case class ConstraintRampType
(
    override val sup: BasicElement,
    FAST: String,
    SLOW: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ConstraintRampType] }
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
        (if (null != FAST) "\t\t<cim:ConstraintRampType.FAST rdf:resource=\"#" + FAST + "\"/>\n" else "") +
        (if (null != SLOW) "\t\t<cim:ConstraintRampType.SLOW rdf:resource=\"#" + SLOW + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ConstraintRampType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ConstraintRampType>\n"
    }
}

object ConstraintRampType
extends
    Parseable[ConstraintRampType]
{
    val FAST: (Context) => String = parse_attribute (attribute ("""ConstraintRampType.FAST"""))
    val SLOW: (Context) => String = parse_attribute (attribute ("""ConstraintRampType.SLOW"""))
    def parse (context: Context): ConstraintRampType =
    {
        ConstraintRampType(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param CVR CVR - Converted contract.
 * @param ETC ETC - Existing Transmission Contract
 * @param O O - Other
 * @param RMR RMR - Reliability Must Run Contract
 * @param RMT RMT - RMT Contract
 * @param TE TE - Transmission Export
 * @param TI TI - Transmission Import
 * @param TOR TOR - Transmission Ownership Right
 */
case class ContractType
(
    override val sup: BasicElement,
    CVR: String,
    ETC: String,
    O: String,
    RMR: String,
    RMT: String,
    TE: String,
    TI: String,
    TOR: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ContractType] }
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
        (if (null != CVR) "\t\t<cim:ContractType.CVR rdf:resource=\"#" + CVR + "\"/>\n" else "") +
        (if (null != ETC) "\t\t<cim:ContractType.ETC rdf:resource=\"#" + ETC + "\"/>\n" else "") +
        (if (null != O) "\t\t<cim:ContractType.O rdf:resource=\"#" + O + "\"/>\n" else "") +
        (if (null != RMR) "\t\t<cim:ContractType.RMR rdf:resource=\"#" + RMR + "\"/>\n" else "") +
        (if (null != RMT) "\t\t<cim:ContractType.RMT rdf:resource=\"#" + RMT + "\"/>\n" else "") +
        (if (null != TE) "\t\t<cim:ContractType.TE rdf:resource=\"#" + TE + "\"/>\n" else "") +
        (if (null != TI) "\t\t<cim:ContractType.TI rdf:resource=\"#" + TI + "\"/>\n" else "") +
        (if (null != TOR) "\t\t<cim:ContractType.TOR rdf:resource=\"#" + TOR + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ContractType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ContractType>\n"
    }
}

object ContractType
extends
    Parseable[ContractType]
{
    val CVR: (Context) => String = parse_attribute (attribute ("""ContractType.CVR"""))
    val ETC: (Context) => String = parse_attribute (attribute ("""ContractType.ETC"""))
    val O: (Context) => String = parse_attribute (attribute ("""ContractType.O"""))
    val RMR: (Context) => String = parse_attribute (attribute ("""ContractType.RMR"""))
    val RMT: (Context) => String = parse_attribute (attribute ("""ContractType.RMT"""))
    val TE: (Context) => String = parse_attribute (attribute ("""ContractType.TE"""))
    val TI: (Context) => String = parse_attribute (attribute ("""ContractType.TI"""))
    val TOR: (Context) => String = parse_attribute (attribute ("""ContractType.TOR"""))
    def parse (context: Context): ContractType =
    {
        ContractType(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param BIDC <em>undocumented</em>
 * @param PRXC <em>undocumented</em>
 * @param REGC <em>undocumented</em>
 */
case class CostBasis
(
    override val sup: BasicElement,
    BIDC: String,
    PRXC: String,
    REGC: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[CostBasis] }
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
        (if (null != BIDC) "\t\t<cim:CostBasis.BIDC rdf:resource=\"#" + BIDC + "\"/>\n" else "") +
        (if (null != PRXC) "\t\t<cim:CostBasis.PRXC rdf:resource=\"#" + PRXC + "\"/>\n" else "") +
        (if (null != REGC) "\t\t<cim:CostBasis.REGC rdf:resource=\"#" + REGC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:CostBasis rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:CostBasis>\n"
    }
}

object CostBasis
extends
    Parseable[CostBasis]
{
    val BIDC: (Context) => String = parse_attribute (attribute ("""CostBasis.BIDC"""))
    val PRXC: (Context) => String = parse_attribute (attribute ("""CostBasis.PRXC"""))
    val REGC: (Context) => String = parse_attribute (attribute ("""CostBasis.REGC"""))
    def parse (context: Context): CostBasis =
    {
        CostBasis(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param ACCEPT <em>undocumented</em>
 * @param DECLINE <em>undocumented</em>
 * @param NON_RESPONSE <em>undocumented</em>
 * @param PARTIAL <em>undocumented</em>
 */
case class DispatchResponseType
(
    override val sup: BasicElement,
    ACCEPT: String,
    DECLINE: String,
    NON_RESPONSE: String,
    PARTIAL: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[DispatchResponseType] }
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
        (if (null != ACCEPT) "\t\t<cim:DispatchResponseType.ACCEPT rdf:resource=\"#" + ACCEPT + "\"/>\n" else "") +
        (if (null != DECLINE) "\t\t<cim:DispatchResponseType.DECLINE rdf:resource=\"#" + DECLINE + "\"/>\n" else "") +
        (if (null != NON_RESPONSE) "\t\t<cim:DispatchResponseType.NON_RESPONSE rdf:resource=\"#" + NON_RESPONSE + "\"/>\n" else "") +
        (if (null != PARTIAL) "\t\t<cim:DispatchResponseType.PARTIAL rdf:resource=\"#" + PARTIAL + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:DispatchResponseType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DispatchResponseType>\n"
    }
}

object DispatchResponseType
extends
    Parseable[DispatchResponseType]
{
    val ACCEPT: (Context) => String = parse_attribute (attribute ("""DispatchResponseType.ACCEPT"""))
    val DECLINE: (Context) => String = parse_attribute (attribute ("""DispatchResponseType.DECLINE"""))
    val NON_RESPONSE: (Context) => String = parse_attribute (attribute ("""DispatchResponseType.NON_RESPONSE"""))
    val PARTIAL: (Context) => String = parse_attribute (attribute ("""DispatchResponseType.PARTIAL"""))
    def parse (context: Context): DispatchResponseType =
    {
        DispatchResponseType(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param BOTH <em>undocumented</em>
 * @param RETAIL <em>undocumented</em>
 * @param WHOLESALE <em>undocumented</em>
 */
case class EnergyPriceIndexType
(
    override val sup: BasicElement,
    BOTH: String,
    RETAIL: String,
    WHOLESALE: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[EnergyPriceIndexType] }
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
        (if (null != BOTH) "\t\t<cim:EnergyPriceIndexType.BOTH rdf:resource=\"#" + BOTH + "\"/>\n" else "") +
        (if (null != RETAIL) "\t\t<cim:EnergyPriceIndexType.RETAIL rdf:resource=\"#" + RETAIL + "\"/>\n" else "") +
        (if (null != WHOLESALE) "\t\t<cim:EnergyPriceIndexType.WHOLESALE rdf:resource=\"#" + WHOLESALE + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EnergyPriceIndexType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EnergyPriceIndexType>\n"
    }
}

object EnergyPriceIndexType
extends
    Parseable[EnergyPriceIndexType]
{
    val BOTH: (Context) => String = parse_attribute (attribute ("""EnergyPriceIndexType.BOTH"""))
    val RETAIL: (Context) => String = parse_attribute (attribute ("""EnergyPriceIndexType.RETAIL"""))
    val WHOLESALE: (Context) => String = parse_attribute (attribute ("""EnergyPriceIndexType.WHOLESALE"""))
    def parse (context: Context): EnergyPriceIndexType =
    {
        EnergyPriceIndexType(
            BasicElement.parse (context),
            BOTH (context),
            RETAIL (context),
            WHOLESALE (context)
        )
    }
}

/**
 * Energy product type
 * @param sup Reference to the superclass object.
 * @param DYN Dynamic
 * @param FIRM Firm
 * @param NFRM Non Firm
 * @param WHL Wheeling
 */
case class EnergyProductType
(
    override val sup: BasicElement,
    DYN: String,
    FIRM: String,
    NFRM: String,
    WHL: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[EnergyProductType] }
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
        (if (null != DYN) "\t\t<cim:EnergyProductType.DYN rdf:resource=\"#" + DYN + "\"/>\n" else "") +
        (if (null != FIRM) "\t\t<cim:EnergyProductType.FIRM rdf:resource=\"#" + FIRM + "\"/>\n" else "") +
        (if (null != NFRM) "\t\t<cim:EnergyProductType.NFRM rdf:resource=\"#" + NFRM + "\"/>\n" else "") +
        (if (null != WHL) "\t\t<cim:EnergyProductType.WHL rdf:resource=\"#" + WHL + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EnergyProductType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EnergyProductType>\n"
    }
}

object EnergyProductType
extends
    Parseable[EnergyProductType]
{
    val DYN: (Context) => String = parse_attribute (attribute ("""EnergyProductType.DYN"""))
    val FIRM: (Context) => String = parse_attribute (attribute ("""EnergyProductType.FIRM"""))
    val NFRM: (Context) => String = parse_attribute (attribute ("""EnergyProductType.NFRM"""))
    val WHL: (Context) => String = parse_attribute (attribute ("""EnergyProductType.WHL"""))
    def parse (context: Context): EnergyProductType =
    {
        EnergyProductType(
            BasicElement.parse (context),
            DYN (context),
            FIRM (context),
            NFRM (context),
            WHL (context)
        )
    }
}

/**
 * Defines the state of a transaction.
 * @param sup Reference to the superclass object.
 * @param approve Approve
 * @param deny Deny
 * @param study Study
 */
case class EnergyTransactionType
(
    override val sup: BasicElement,
    approve: String,
    deny: String,
    study: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[EnergyTransactionType] }
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
        (if (null != approve) "\t\t<cim:EnergyTransactionType.approve rdf:resource=\"#" + approve + "\"/>\n" else "") +
        (if (null != deny) "\t\t<cim:EnergyTransactionType.deny rdf:resource=\"#" + deny + "\"/>\n" else "") +
        (if (null != study) "\t\t<cim:EnergyTransactionType.study rdf:resource=\"#" + study + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EnergyTransactionType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EnergyTransactionType>\n"
    }
}

object EnergyTransactionType
extends
    Parseable[EnergyTransactionType]
{
    val approve: (Context) => String = parse_attribute (attribute ("""EnergyTransactionType.approve"""))
    val deny: (Context) => String = parse_attribute (attribute ("""EnergyTransactionType.deny"""))
    val study: (Context) => String = parse_attribute (attribute ("""EnergyTransactionType.study"""))
    def parse (context: Context): EnergyTransactionType =
    {
        EnergyTransactionType(
            BasicElement.parse (context),
            approve (context),
            deny (context),
            study (context)
        )
    }
}

/**
 * Status of equipment
 * @param sup Reference to the superclass object.
 * @param In Equipment is in.
 * @param Out Equipment is out.
 */
case class EquipmentStatusType
(
    override val sup: BasicElement,
    In: String,
    Out: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[EquipmentStatusType] }
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
        (if (null != In) "\t\t<cim:EquipmentStatusType.In rdf:resource=\"#" + In + "\"/>\n" else "") +
        (if (null != Out) "\t\t<cim:EquipmentStatusType.Out rdf:resource=\"#" + Out + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:EquipmentStatusType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:EquipmentStatusType>\n"
    }
}

object EquipmentStatusType
extends
    Parseable[EquipmentStatusType]
{
    val In: (Context) => String = parse_attribute (attribute ("""EquipmentStatusType.In"""))
    val Out: (Context) => String = parse_attribute (attribute ("""EquipmentStatusType.Out"""))
    def parse (context: Context): EquipmentStatusType =
    {
        EquipmentStatusType(
            BasicElement.parse (context),
            In (context),
            Out (context)
        )
    }
}

/**
 * Execution types of Market Runs
 * @param sup Reference to the superclass object.
 * @param DA Day Ahead
 * @param HASP Real TIme Hour Ahead Execution
 * @param RTD Real Time Dispatch
 * @param RTPD Real Time Pre-dispatch
 */
case class ExecutionType
(
    override val sup: BasicElement,
    DA: String,
    HASP: String,
    RTD: String,
    RTPD: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ExecutionType] }
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
        (if (null != DA) "\t\t<cim:ExecutionType.DA rdf:resource=\"#" + DA + "\"/>\n" else "") +
        (if (null != HASP) "\t\t<cim:ExecutionType.HASP rdf:resource=\"#" + HASP + "\"/>\n" else "") +
        (if (null != RTD) "\t\t<cim:ExecutionType.RTD rdf:resource=\"#" + RTD + "\"/>\n" else "") +
        (if (null != RTPD) "\t\t<cim:ExecutionType.RTPD rdf:resource=\"#" + RTPD + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ExecutionType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ExecutionType>\n"
    }
}

object ExecutionType
extends
    Parseable[ExecutionType]
{
    val DA: (Context) => String = parse_attribute (attribute ("""ExecutionType.DA"""))
    val HASP: (Context) => String = parse_attribute (attribute ("""ExecutionType.HASP"""))
    val RTD: (Context) => String = parse_attribute (attribute ("""ExecutionType.RTD"""))
    val RTPD: (Context) => String = parse_attribute (attribute ("""ExecutionType.RTPD"""))
    def parse (context: Context): ExecutionType =
    {
        ExecutionType(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param N 'N' - not an RMR unit
 * @param _1 '1' - RMR Condition 1 unit
 * @param _2 '2' - RMR Condition 2 unit
 */
case class FlagTypeRMR
(
    override val sup: BasicElement,
    N: String,
    _1: String,
    _2: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[FlagTypeRMR] }
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
        (if (null != N) "\t\t<cim:FlagTypeRMR.N rdf:resource=\"#" + N + "\"/>\n" else "") +
        (if (null != _1) "\t\t<cim:FlagTypeRMR.1 rdf:resource=\"#" + _1 + "\"/>\n" else "") +
        (if (null != _2) "\t\t<cim:FlagTypeRMR.2 rdf:resource=\"#" + _2 + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:FlagTypeRMR rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FlagTypeRMR>\n"
    }
}

object FlagTypeRMR
extends
    Parseable[FlagTypeRMR]
{
    val N: (Context) => String = parse_attribute (attribute ("""FlagTypeRMR.N"""))
    val _1: (Context) => String = parse_attribute (attribute ("""FlagTypeRMR.1"""))
    val _2: (Context) => String = parse_attribute (attribute ("""FlagTypeRMR.2"""))
    def parse (context: Context): FlagTypeRMR =
    {
        FlagTypeRMR(
            BasicElement.parse (context),
            N (context),
            _1 (context),
            _2 (context)
        )
    }
}

/**
 * Specifies the direction of energy flow in the flowgate.
 * @param sup Reference to the superclass object.
 * @param Forward Forward direction.
 * @param Reverse Reverse direction.
 */
case class FlowDirectionType
(
    override val sup: BasicElement,
    Forward: String,
    Reverse: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[FlowDirectionType] }
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
        (if (null != Forward) "\t\t<cim:FlowDirectionType.Forward rdf:resource=\"#" + Forward + "\"/>\n" else "") +
        (if (null != Reverse) "\t\t<cim:FlowDirectionType.Reverse rdf:resource=\"#" + Reverse + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:FlowDirectionType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FlowDirectionType>\n"
    }
}

object FlowDirectionType
extends
    Parseable[FlowDirectionType]
{
    val Forward: (Context) => String = parse_attribute (attribute ("""FlowDirectionType.Forward"""))
    val Reverse: (Context) => String = parse_attribute (attribute ("""FlowDirectionType.Reverse"""))
    def parse (context: Context): FlowDirectionType =
    {
        FlowDirectionType(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param BGAS Bio Gas (Landfill, Sewage, Digester, etc.)
 * @param BIOM Biomass
 * @param COAL Coal
 * @param DIST <em>undocumented</em>
 * @param GAS <em>undocumented</em>
 * @param GEOT GeoThermal
 * @param HRCV <em>undocumented</em>
 * @param NG Natural Gas
 * @param NNG Non-Natural Gas
 * @param NONE <em>undocumented</em>
 * @param NUCL Nuclear
 * @param OIL <em>undocumented</em>
 * @param OTHR Other
 * @param SOLR Solar
 * @param WAST Waste to Energy
 * @param WATR Water
 * @param WIND Wind
 */
case class FuelSource
(
    override val sup: BasicElement,
    BGAS: String,
    BIOM: String,
    COAL: String,
    DIST: String,
    GAS: String,
    GEOT: String,
    HRCV: String,
    NG: String,
    NNG: String,
    NONE: String,
    NUCL: String,
    OIL: String,
    OTHR: String,
    SOLR: String,
    WAST: String,
    WATR: String,
    WIND: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[FuelSource] }
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
        (if (null != BGAS) "\t\t<cim:FuelSource.BGAS rdf:resource=\"#" + BGAS + "\"/>\n" else "") +
        (if (null != BIOM) "\t\t<cim:FuelSource.BIOM rdf:resource=\"#" + BIOM + "\"/>\n" else "") +
        (if (null != COAL) "\t\t<cim:FuelSource.COAL rdf:resource=\"#" + COAL + "\"/>\n" else "") +
        (if (null != DIST) "\t\t<cim:FuelSource.DIST rdf:resource=\"#" + DIST + "\"/>\n" else "") +
        (if (null != GAS) "\t\t<cim:FuelSource.GAS rdf:resource=\"#" + GAS + "\"/>\n" else "") +
        (if (null != GEOT) "\t\t<cim:FuelSource.GEOT rdf:resource=\"#" + GEOT + "\"/>\n" else "") +
        (if (null != HRCV) "\t\t<cim:FuelSource.HRCV rdf:resource=\"#" + HRCV + "\"/>\n" else "") +
        (if (null != NG) "\t\t<cim:FuelSource.NG rdf:resource=\"#" + NG + "\"/>\n" else "") +
        (if (null != NNG) "\t\t<cim:FuelSource.NNG rdf:resource=\"#" + NNG + "\"/>\n" else "") +
        (if (null != NONE) "\t\t<cim:FuelSource.NONE rdf:resource=\"#" + NONE + "\"/>\n" else "") +
        (if (null != NUCL) "\t\t<cim:FuelSource.NUCL rdf:resource=\"#" + NUCL + "\"/>\n" else "") +
        (if (null != OIL) "\t\t<cim:FuelSource.OIL rdf:resource=\"#" + OIL + "\"/>\n" else "") +
        (if (null != OTHR) "\t\t<cim:FuelSource.OTHR rdf:resource=\"#" + OTHR + "\"/>\n" else "") +
        (if (null != SOLR) "\t\t<cim:FuelSource.SOLR rdf:resource=\"#" + SOLR + "\"/>\n" else "") +
        (if (null != WAST) "\t\t<cim:FuelSource.WAST rdf:resource=\"#" + WAST + "\"/>\n" else "") +
        (if (null != WATR) "\t\t<cim:FuelSource.WATR rdf:resource=\"#" + WATR + "\"/>\n" else "") +
        (if (null != WIND) "\t\t<cim:FuelSource.WIND rdf:resource=\"#" + WIND + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:FuelSource rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:FuelSource>\n"
    }
}

object FuelSource
extends
    Parseable[FuelSource]
{
    val BGAS: (Context) => String = parse_attribute (attribute ("""FuelSource.BGAS"""))
    val BIOM: (Context) => String = parse_attribute (attribute ("""FuelSource.BIOM"""))
    val COAL: (Context) => String = parse_attribute (attribute ("""FuelSource.COAL"""))
    val DIST: (Context) => String = parse_attribute (attribute ("""FuelSource.DIST"""))
    val GAS: (Context) => String = parse_attribute (attribute ("""FuelSource.GAS"""))
    val GEOT: (Context) => String = parse_attribute (attribute ("""FuelSource.GEOT"""))
    val HRCV: (Context) => String = parse_attribute (attribute ("""FuelSource.HRCV"""))
    val NG: (Context) => String = parse_attribute (attribute ("""FuelSource.NG"""))
    val NNG: (Context) => String = parse_attribute (attribute ("""FuelSource.NNG"""))
    val NONE: (Context) => String = parse_attribute (attribute ("""FuelSource.NONE"""))
    val NUCL: (Context) => String = parse_attribute (attribute ("""FuelSource.NUCL"""))
    val OIL: (Context) => String = parse_attribute (attribute ("""FuelSource.OIL"""))
    val OTHR: (Context) => String = parse_attribute (attribute ("""FuelSource.OTHR"""))
    val SOLR: (Context) => String = parse_attribute (attribute ("""FuelSource.SOLR"""))
    val WAST: (Context) => String = parse_attribute (attribute ("""FuelSource.WAST"""))
    val WATR: (Context) => String = parse_attribute (attribute ("""FuelSource.WATR"""))
    val WIND: (Context) => String = parse_attribute (attribute ("""FuelSource.WIND"""))
    def parse (context: Context): FuelSource =
    {
        FuelSource(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param E Export.
 * @param I Import.
 */
case class InterTieDirection
(
    override val sup: BasicElement,
    E: String,
    I: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[InterTieDirection] }
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
        (if (null != E) "\t\t<cim:InterTieDirection.E rdf:resource=\"#" + E + "\"/>\n" else "") +
        (if (null != I) "\t\t<cim:InterTieDirection.I rdf:resource=\"#" + I + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:InterTieDirection rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:InterTieDirection>\n"
    }
}

object InterTieDirection
extends
    Parseable[InterTieDirection]
{
    val E: (Context) => String = parse_attribute (attribute ("""InterTieDirection.E"""))
    val I: (Context) => String = parse_attribute (attribute ("""InterTieDirection.I"""))
    def parse (context: Context): InterTieDirection =
    {
        InterTieDirection(
            BasicElement.parse (context),
            E (context),
            I (context)
        )
    }
}

/**
 * Load forecast zone types.
 * @param sup Reference to the superclass object.
 * @param LFZ Load forecast zone.
 * @param LZMS Metered sub system zone.
 */
case class LoadForecastType
(
    override val sup: BasicElement,
    LFZ: String,
    LZMS: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[LoadForecastType] }
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
        (if (null != LFZ) "\t\t<cim:LoadForecastType.LFZ rdf:resource=\"#" + LFZ + "\"/>\n" else "") +
        (if (null != LZMS) "\t\t<cim:LoadForecastType.LZMS rdf:resource=\"#" + LZMS + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:LoadForecastType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:LoadForecastType>\n"
    }
}

object LoadForecastType
extends
    Parseable[LoadForecastType]
{
    val LFZ: (Context) => String = parse_attribute (attribute ("""LoadForecastType.LFZ"""))
    val LZMS: (Context) => String = parse_attribute (attribute ("""LoadForecastType.LZMS"""))
    def parse (context: Context): LoadForecastType =
    {
        LoadForecastType(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param _1 1 - Global Price Test.
 * @param _2 2 - Global Conduct Test.
 * @param _3 3 - Global Impact Test.
 * @param _4 4 - Local Price Test.
 * @param _5 5 - Local Conduct Test.
 * @param _6 6 - Local Impact Test.
 */
case class MPMTestIdentifierType
(
    override val sup: BasicElement,
    _1: String,
    _2: String,
    _3: String,
    _4: String,
    _5: String,
    _6: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MPMTestIdentifierType] }
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
        (if (null != _1) "\t\t<cim:MPMTestIdentifierType.1 rdf:resource=\"#" + _1 + "\"/>\n" else "") +
        (if (null != _2) "\t\t<cim:MPMTestIdentifierType.2 rdf:resource=\"#" + _2 + "\"/>\n" else "") +
        (if (null != _3) "\t\t<cim:MPMTestIdentifierType.3 rdf:resource=\"#" + _3 + "\"/>\n" else "") +
        (if (null != _4) "\t\t<cim:MPMTestIdentifierType.4 rdf:resource=\"#" + _4 + "\"/>\n" else "") +
        (if (null != _5) "\t\t<cim:MPMTestIdentifierType.5 rdf:resource=\"#" + _5 + "\"/>\n" else "") +
        (if (null != _6) "\t\t<cim:MPMTestIdentifierType.6 rdf:resource=\"#" + _6 + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MPMTestIdentifierType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MPMTestIdentifierType>\n"
    }
}

object MPMTestIdentifierType
extends
    Parseable[MPMTestIdentifierType]
{
    val _1: (Context) => String = parse_attribute (attribute ("""MPMTestIdentifierType.1"""))
    val _2: (Context) => String = parse_attribute (attribute ("""MPMTestIdentifierType.2"""))
    val _3: (Context) => String = parse_attribute (attribute ("""MPMTestIdentifierType.3"""))
    val _4: (Context) => String = parse_attribute (attribute ("""MPMTestIdentifierType.4"""))
    val _5: (Context) => String = parse_attribute (attribute ("""MPMTestIdentifierType.5"""))
    val _6: (Context) => String = parse_attribute (attribute ("""MPMTestIdentifierType.6"""))
    def parse (context: Context): MPMTestIdentifierType =
    {
        MPMTestIdentifierType(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param ALTERNATE Alternate.
 * @param NORMAL Normal.
 */
case class MPMTestMethodType
(
    override val sup: BasicElement,
    ALTERNATE: String,
    NORMAL: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MPMTestMethodType] }
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
        (if (null != ALTERNATE) "\t\t<cim:MPMTestMethodType.ALTERNATE rdf:resource=\"#" + ALTERNATE + "\"/>\n" else "") +
        (if (null != NORMAL) "\t\t<cim:MPMTestMethodType.NORMAL rdf:resource=\"#" + NORMAL + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MPMTestMethodType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MPMTestMethodType>\n"
    }
}

object MPMTestMethodType
extends
    Parseable[MPMTestMethodType]
{
    val ALTERNATE: (Context) => String = parse_attribute (attribute ("""MPMTestMethodType.ALTERNATE"""))
    val NORMAL: (Context) => String = parse_attribute (attribute ("""MPMTestMethodType.NORMAL"""))
    def parse (context: Context): MPMTestMethodType =
    {
        MPMTestMethodType(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param D Disabled
 * @param F Failed
 * @param P Passed
 * @param S Skipped
 */
case class MPMTestOutcome
(
    override val sup: BasicElement,
    D: String,
    F: String,
    P: String,
    S: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MPMTestOutcome] }
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
        (if (null != D) "\t\t<cim:MPMTestOutcome.D rdf:resource=\"#" + D + "\"/>\n" else "") +
        (if (null != F) "\t\t<cim:MPMTestOutcome.F rdf:resource=\"#" + F + "\"/>\n" else "") +
        (if (null != P) "\t\t<cim:MPMTestOutcome.P rdf:resource=\"#" + P + "\"/>\n" else "") +
        (if (null != S) "\t\t<cim:MPMTestOutcome.S rdf:resource=\"#" + S + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MPMTestOutcome rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MPMTestOutcome>\n"
    }
}

object MPMTestOutcome
extends
    Parseable[MPMTestOutcome]
{
    val D: (Context) => String = parse_attribute (attribute ("""MPMTestOutcome.D"""))
    val F: (Context) => String = parse_attribute (attribute ("""MPMTestOutcome.F"""))
    val P: (Context) => String = parse_attribute (attribute ("""MPMTestOutcome.P"""))
    val S: (Context) => String = parse_attribute (attribute ("""MPMTestOutcome.S"""))
    def parse (context: Context): MPMTestOutcome =
    {
        MPMTestOutcome(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param ADD <em>undocumented</em>
 * @param CHG <em>undocumented</em>
 */
case class MQSCHGType
(
    override val sup: BasicElement,
    ADD: String,
    CHG: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MQSCHGType] }
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
        (if (null != ADD) "\t\t<cim:MQSCHGType.ADD rdf:resource=\"#" + ADD + "\"/>\n" else "") +
        (if (null != CHG) "\t\t<cim:MQSCHGType.CHG rdf:resource=\"#" + CHG + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MQSCHGType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MQSCHGType>\n"
    }
}

object MQSCHGType
extends
    Parseable[MQSCHGType]
{
    val ADD: (Context) => String = parse_attribute (attribute ("""MQSCHGType.ADD"""))
    val CHG: (Context) => String = parse_attribute (attribute ("""MQSCHGType.CHG"""))
    def parse (context: Context): MQSCHGType =
    {
        MQSCHGType(
            BasicElement.parse (context),
            ADD (context),
            CHG (context)
        )
    }
}

/**
 * Valid values, for example: 
INS - Instruction from RTM
 * ACT - Actual instruction after the fact
 * @param sup Reference to the superclass object.
 * @param ACT <em>undocumented</em>
 * @param INS <em>undocumented</em>
 */
case class MQSInstructionSource
(
    override val sup: BasicElement,
    ACT: String,
    INS: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MQSInstructionSource] }
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
        (if (null != ACT) "\t\t<cim:MQSInstructionSource.ACT rdf:resource=\"#" + ACT + "\"/>\n" else "") +
        (if (null != INS) "\t\t<cim:MQSInstructionSource.INS rdf:resource=\"#" + INS + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MQSInstructionSource rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MQSInstructionSource>\n"
    }
}

object MQSInstructionSource
extends
    Parseable[MQSInstructionSource]
{
    val ACT: (Context) => String = parse_attribute (attribute ("""MQSInstructionSource.ACT"""))
    val INS: (Context) => String = parse_attribute (attribute ("""MQSInstructionSource.INS"""))
    def parse (context: Context): MQSInstructionSource =
    {
        MQSInstructionSource(
            BasicElement.parse (context),
            ACT (context),
            INS (context)
        )
    }
}

/**
 * Market product self schedule bid types.
 * @param sup Reference to the superclass object.
 * @param ETC Existing Transmission Contract.
 * @param LPT Low price taker.
 * @param PT Price taker.
 * @param RA Resource adequacy.
 * @param RGMR Regulatory must run.
 * @param RMR Reliability Must Run.
 * @param RMT Reliability must take.
 * @param SP Self provision.
 * @param TOR Transmission Ownership Right.
 */
case class MarketProductSelfSchedType
(
    override val sup: BasicElement,
    ETC: String,
    LPT: String,
    PT: String,
    RA: String,
    RGMR: String,
    RMR: String,
    RMT: String,
    SP: String,
    TOR: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MarketProductSelfSchedType] }
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
        (if (null != ETC) "\t\t<cim:MarketProductSelfSchedType.ETC rdf:resource=\"#" + ETC + "\"/>\n" else "") +
        (if (null != LPT) "\t\t<cim:MarketProductSelfSchedType.LPT rdf:resource=\"#" + LPT + "\"/>\n" else "") +
        (if (null != PT) "\t\t<cim:MarketProductSelfSchedType.PT rdf:resource=\"#" + PT + "\"/>\n" else "") +
        (if (null != RA) "\t\t<cim:MarketProductSelfSchedType.RA rdf:resource=\"#" + RA + "\"/>\n" else "") +
        (if (null != RGMR) "\t\t<cim:MarketProductSelfSchedType.RGMR rdf:resource=\"#" + RGMR + "\"/>\n" else "") +
        (if (null != RMR) "\t\t<cim:MarketProductSelfSchedType.RMR rdf:resource=\"#" + RMR + "\"/>\n" else "") +
        (if (null != RMT) "\t\t<cim:MarketProductSelfSchedType.RMT rdf:resource=\"#" + RMT + "\"/>\n" else "") +
        (if (null != SP) "\t\t<cim:MarketProductSelfSchedType.SP rdf:resource=\"#" + SP + "\"/>\n" else "") +
        (if (null != TOR) "\t\t<cim:MarketProductSelfSchedType.TOR rdf:resource=\"#" + TOR + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MarketProductSelfSchedType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketProductSelfSchedType>\n"
    }
}

object MarketProductSelfSchedType
extends
    Parseable[MarketProductSelfSchedType]
{
    val ETC: (Context) => String = parse_attribute (attribute ("""MarketProductSelfSchedType.ETC"""))
    val LPT: (Context) => String = parse_attribute (attribute ("""MarketProductSelfSchedType.LPT"""))
    val PT: (Context) => String = parse_attribute (attribute ("""MarketProductSelfSchedType.PT"""))
    val RA: (Context) => String = parse_attribute (attribute ("""MarketProductSelfSchedType.RA"""))
    val RGMR: (Context) => String = parse_attribute (attribute ("""MarketProductSelfSchedType.RGMR"""))
    val RMR: (Context) => String = parse_attribute (attribute ("""MarketProductSelfSchedType.RMR"""))
    val RMT: (Context) => String = parse_attribute (attribute ("""MarketProductSelfSchedType.RMT"""))
    val SP: (Context) => String = parse_attribute (attribute ("""MarketProductSelfSchedType.SP"""))
    val TOR: (Context) => String = parse_attribute (attribute ("""MarketProductSelfSchedType.TOR"""))
    def parse (context: Context): MarketProductSelfSchedType =
    {
        MarketProductSelfSchedType(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param EN energy type
 * @param LFD Load following down
 * @param LFU Load following up
 * @param NR non spinning reserve
 * @param RC Residual Unit Commitment
 * @param RD regulation down
 * @param REG Regulation
 * @param RU regulation up
 * @param SR spinning reserve
 */
case class MarketProductType
(
    override val sup: BasicElement,
    EN: String,
    LFD: String,
    LFU: String,
    NR: String,
    RC: String,
    RD: String,
    REG: String,
    RU: String,
    SR: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MarketProductType] }
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
        (if (null != EN) "\t\t<cim:MarketProductType.EN rdf:resource=\"#" + EN + "\"/>\n" else "") +
        (if (null != LFD) "\t\t<cim:MarketProductType.LFD rdf:resource=\"#" + LFD + "\"/>\n" else "") +
        (if (null != LFU) "\t\t<cim:MarketProductType.LFU rdf:resource=\"#" + LFU + "\"/>\n" else "") +
        (if (null != NR) "\t\t<cim:MarketProductType.NR rdf:resource=\"#" + NR + "\"/>\n" else "") +
        (if (null != RC) "\t\t<cim:MarketProductType.RC rdf:resource=\"#" + RC + "\"/>\n" else "") +
        (if (null != RD) "\t\t<cim:MarketProductType.RD rdf:resource=\"#" + RD + "\"/>\n" else "") +
        (if (null != REG) "\t\t<cim:MarketProductType.REG rdf:resource=\"#" + REG + "\"/>\n" else "") +
        (if (null != RU) "\t\t<cim:MarketProductType.RU rdf:resource=\"#" + RU + "\"/>\n" else "") +
        (if (null != SR) "\t\t<cim:MarketProductType.SR rdf:resource=\"#" + SR + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MarketProductType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketProductType>\n"
    }
}

object MarketProductType
extends
    Parseable[MarketProductType]
{
    val EN: (Context) => String = parse_attribute (attribute ("""MarketProductType.EN"""))
    val LFD: (Context) => String = parse_attribute (attribute ("""MarketProductType.LFD"""))
    val LFU: (Context) => String = parse_attribute (attribute ("""MarketProductType.LFU"""))
    val NR: (Context) => String = parse_attribute (attribute ("""MarketProductType.NR"""))
    val RC: (Context) => String = parse_attribute (attribute ("""MarketProductType.RC"""))
    val RD: (Context) => String = parse_attribute (attribute ("""MarketProductType.RD"""))
    val REG: (Context) => String = parse_attribute (attribute ("""MarketProductType.REG"""))
    val RU: (Context) => String = parse_attribute (attribute ("""MarketProductType.RU"""))
    val SR: (Context) => String = parse_attribute (attribute ("""MarketProductType.SR"""))
    def parse (context: Context): MarketProductType =
    {
        MarketProductType(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param DAM Day ahead market.
 * @param HAM Hour Ahead Market.
 * @param RTM Real time market.
 * @param RUC Residual Unit Commitment.
 */
case class MarketType
(
    override val sup: BasicElement,
    DAM: String,
    HAM: String,
    RTM: String,
    RUC: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MarketType] }
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
        (if (null != DAM) "\t\t<cim:MarketType.DAM rdf:resource=\"#" + DAM + "\"/>\n" else "") +
        (if (null != HAM) "\t\t<cim:MarketType.HAM rdf:resource=\"#" + HAM + "\"/>\n" else "") +
        (if (null != RTM) "\t\t<cim:MarketType.RTM rdf:resource=\"#" + RTM + "\"/>\n" else "") +
        (if (null != RUC) "\t\t<cim:MarketType.RUC rdf:resource=\"#" + RUC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MarketType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MarketType>\n"
    }
}

object MarketType
extends
    Parseable[MarketType]
{
    val DAM: (Context) => String = parse_attribute (attribute ("""MarketType.DAM"""))
    val HAM: (Context) => String = parse_attribute (attribute ("""MarketType.HAM"""))
    val RTM: (Context) => String = parse_attribute (attribute ("""MarketType.RTM"""))
    val RUC: (Context) => String = parse_attribute (attribute ("""MarketType.RUC"""))
    def parse (context: Context): MarketType =
    {
        MarketType(
            BasicElement.parse (context),
            DAM (context),
            HAM (context),
            RTM (context),
            RUC (context)
        )
    }
}

/**
 * Kind of Market account.
 * @param sup Reference to the superclass object.
 * @param estimate <em>undocumented</em>
 * @param normal <em>undocumented</em>
 * @param reversal <em>undocumented</em>
 * @param statistical <em>undocumented</em>
 */
case class MktAccountKind
(
    override val sup: BasicElement,
    estimate: String,
    normal: String,
    reversal: String,
    statistical: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MktAccountKind] }
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
        (if (null != estimate) "\t\t<cim:MktAccountKind.estimate rdf:resource=\"#" + estimate + "\"/>\n" else "") +
        (if (null != normal) "\t\t<cim:MktAccountKind.normal rdf:resource=\"#" + normal + "\"/>\n" else "") +
        (if (null != reversal) "\t\t<cim:MktAccountKind.reversal rdf:resource=\"#" + reversal + "\"/>\n" else "") +
        (if (null != statistical) "\t\t<cim:MktAccountKind.statistical rdf:resource=\"#" + statistical + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MktAccountKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MktAccountKind>\n"
    }
}

object MktAccountKind
extends
    Parseable[MktAccountKind]
{
    val estimate: (Context) => String = parse_attribute (attribute ("""MktAccountKind.estimate"""))
    val normal: (Context) => String = parse_attribute (attribute ("""MktAccountKind.normal"""))
    val reversal: (Context) => String = parse_attribute (attribute ("""MktAccountKind.reversal"""))
    val statistical: (Context) => String = parse_attribute (attribute ("""MktAccountKind.statistical"""))
    def parse (context: Context): MktAccountKind =
    {
        MktAccountKind(
            BasicElement.parse (context),
            estimate (context),
            normal (context),
            reversal (context),
            statistical (context)
        )
    }
}

/**
 * Kind of bill media.
 * @param sup Reference to the superclass object.
 * @param electronic <em>undocumented</em>
 * @param other <em>undocumented</em>
 * @param paper <em>undocumented</em>
 */
case class MktBillMediaKind
(
    override val sup: BasicElement,
    electronic: String,
    other: String,
    paper: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MktBillMediaKind] }
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
        (if (null != electronic) "\t\t<cim:MktBillMediaKind.electronic rdf:resource=\"#" + electronic + "\"/>\n" else "") +
        (if (null != other) "\t\t<cim:MktBillMediaKind.other rdf:resource=\"#" + other + "\"/>\n" else "") +
        (if (null != paper) "\t\t<cim:MktBillMediaKind.paper rdf:resource=\"#" + paper + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MktBillMediaKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MktBillMediaKind>\n"
    }
}

object MktBillMediaKind
extends
    Parseable[MktBillMediaKind]
{
    val electronic: (Context) => String = parse_attribute (attribute ("""MktBillMediaKind.electronic"""))
    val other: (Context) => String = parse_attribute (attribute ("""MktBillMediaKind.other"""))
    val paper: (Context) => String = parse_attribute (attribute ("""MktBillMediaKind.paper"""))
    def parse (context: Context): MktBillMediaKind =
    {
        MktBillMediaKind(
            BasicElement.parse (context),
            electronic (context),
            other (context),
            paper (context)
        )
    }
}

/**
 * Kind of invoice line item.
 * @param sup Reference to the superclass object.
 * @param initial <em>undocumented</em>
 * @param other <em>undocumented</em>
 * @param recalculation <em>undocumented</em>
 */
case class MktInvoiceLineItemKind
(
    override val sup: BasicElement,
    initial: String,
    other: String,
    recalculation: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[MktInvoiceLineItemKind] }
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
        (if (null != initial) "\t\t<cim:MktInvoiceLineItemKind.initial rdf:resource=\"#" + initial + "\"/>\n" else "") +
        (if (null != other) "\t\t<cim:MktInvoiceLineItemKind.other rdf:resource=\"#" + other + "\"/>\n" else "") +
        (if (null != recalculation) "\t\t<cim:MktInvoiceLineItemKind.recalculation rdf:resource=\"#" + recalculation + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:MktInvoiceLineItemKind rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:MktInvoiceLineItemKind>\n"
    }
}

object MktInvoiceLineItemKind
extends
    Parseable[MktInvoiceLineItemKind]
{
    val initial: (Context) => String = parse_attribute (attribute ("""MktInvoiceLineItemKind.initial"""))
    val other: (Context) => String = parse_attribute (attribute ("""MktInvoiceLineItemKind.other"""))
    val recalculation: (Context) => String = parse_attribute (attribute ("""MktInvoiceLineItemKind.recalculation"""))
    def parse (context: Context): MktInvoiceLineItemKind =
    {
        MktInvoiceLineItemKind(
            BasicElement.parse (context),
            initial (context),
            other (context),
            recalculation (context)
        )
    }
}

/**
 * ON
 * OFF
 * @param sup Reference to the superclass object.
 * @param OFF <em>undocumented</em>
 * @param ON <em>undocumented</em>
 */
case class OnOff
(
    override val sup: BasicElement,
    OFF: String,
    ON: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[OnOff] }
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
        (if (null != OFF) "\t\t<cim:OnOff.OFF rdf:resource=\"#" + OFF + "\"/>\n" else "") +
        (if (null != ON) "\t\t<cim:OnOff.ON rdf:resource=\"#" + ON + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:OnOff rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:OnOff>\n"
    }
}

object OnOff
extends
    Parseable[OnOff]
{
    val OFF: (Context) => String = parse_attribute (attribute ("""OnOff.OFF"""))
    val ON: (Context) => String = parse_attribute (attribute ("""OnOff.ON"""))
    def parse (context: Context): OnOff =
    {
        OnOff(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param L <em>undocumented</em>
 * @param N <em>undocumented</em>
 * @param S <em>undocumented</em>
 * @param Y <em>undocumented</em>
 */
case class ParticipationCategoryMPM
(
    override val sup: BasicElement,
    L: String,
    N: String,
    S: String,
    Y: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ParticipationCategoryMPM] }
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
        (if (null != L) "\t\t<cim:ParticipationCategoryMPM.L rdf:resource=\"#" + L + "\"/>\n" else "") +
        (if (null != N) "\t\t<cim:ParticipationCategoryMPM.N rdf:resource=\"#" + N + "\"/>\n" else "") +
        (if (null != S) "\t\t<cim:ParticipationCategoryMPM.S rdf:resource=\"#" + S + "\"/>\n" else "") +
        (if (null != Y) "\t\t<cim:ParticipationCategoryMPM.Y rdf:resource=\"#" + Y + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ParticipationCategoryMPM rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ParticipationCategoryMPM>\n"
    }
}

object ParticipationCategoryMPM
extends
    Parseable[ParticipationCategoryMPM]
{
    val L: (Context) => String = parse_attribute (attribute ("""ParticipationCategoryMPM.L"""))
    val N: (Context) => String = parse_attribute (attribute ("""ParticipationCategoryMPM.N"""))
    val S: (Context) => String = parse_attribute (attribute ("""ParticipationCategoryMPM.S"""))
    val Y: (Context) => String = parse_attribute (attribute ("""ParticipationCategoryMPM.Y"""))
    def parse (context: Context): ParticipationCategoryMPM =
    {
        ParticipationCategoryMPM(
            BasicElement.parse (context),
            L (context),
            N (context),
            S (context),
            Y (context)
        )
    }
}

/**
 * Defines the individual passes that produce results per execution type/market type
 * @param sup Reference to the superclass object.
 * @param DA Day Ahead
 * @param HA_SCUC Hour Ahead Security Constrained Unit Commitment
 * @param MPM_1 Market Power Mitigation Pass 1
 * @param MPM_2 Market Power Mitigation Pass 2
 * @param MPM_3 Market Power Mitigation Pass 3
 * @param MPM_4 Market Power Mitigation Pass 4
 * @param RTED Real Time Economic Dispatch
 * @param RTPD Real Time Pre Dispatch
 * @param RUC Residual Unit Commitment
 */
case class PassIndicatorType
(
    override val sup: BasicElement,
    DA: String,
    HA_SCUC: String,
    MPM_1: String,
    MPM_2: String,
    MPM_3: String,
    MPM_4: String,
    RTED: String,
    RTPD: String,
    RUC: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[PassIndicatorType] }
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
        (if (null != DA) "\t\t<cim:PassIndicatorType.DA rdf:resource=\"#" + DA + "\"/>\n" else "") +
        (if (null != HA_SCUC) "\t\t<cim:PassIndicatorType.HA-SCUC rdf:resource=\"#" + HA_SCUC + "\"/>\n" else "") +
        (if (null != MPM_1) "\t\t<cim:PassIndicatorType.MPM-1 rdf:resource=\"#" + MPM_1 + "\"/>\n" else "") +
        (if (null != MPM_2) "\t\t<cim:PassIndicatorType.MPM-2 rdf:resource=\"#" + MPM_2 + "\"/>\n" else "") +
        (if (null != MPM_3) "\t\t<cim:PassIndicatorType.MPM-3 rdf:resource=\"#" + MPM_3 + "\"/>\n" else "") +
        (if (null != MPM_4) "\t\t<cim:PassIndicatorType.MPM-4 rdf:resource=\"#" + MPM_4 + "\"/>\n" else "") +
        (if (null != RTED) "\t\t<cim:PassIndicatorType.RTED rdf:resource=\"#" + RTED + "\"/>\n" else "") +
        (if (null != RTPD) "\t\t<cim:PassIndicatorType.RTPD rdf:resource=\"#" + RTPD + "\"/>\n" else "") +
        (if (null != RUC) "\t\t<cim:PassIndicatorType.RUC rdf:resource=\"#" + RUC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PassIndicatorType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PassIndicatorType>\n"
    }
}

object PassIndicatorType
extends
    Parseable[PassIndicatorType]
{
    val DA: (Context) => String = parse_attribute (attribute ("""PassIndicatorType.DA"""))
    val HA_SCUC: (Context) => String = parse_attribute (attribute ("""PassIndicatorType.HA-SCUC"""))
    val MPM_1: (Context) => String = parse_attribute (attribute ("""PassIndicatorType.MPM-1"""))
    val MPM_2: (Context) => String = parse_attribute (attribute ("""PassIndicatorType.MPM-2"""))
    val MPM_3: (Context) => String = parse_attribute (attribute ("""PassIndicatorType.MPM-3"""))
    val MPM_4: (Context) => String = parse_attribute (attribute ("""PassIndicatorType.MPM-4"""))
    val RTED: (Context) => String = parse_attribute (attribute ("""PassIndicatorType.RTED"""))
    val RTPD: (Context) => String = parse_attribute (attribute ("""PassIndicatorType.RTPD"""))
    val RUC: (Context) => String = parse_attribute (attribute ("""PassIndicatorType.RUC"""))
    def parse (context: Context): PassIndicatorType =
    {
        PassIndicatorType(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param M <em>undocumented</em>
 * @param R <em>undocumented</em>
 */
case class PurposeFlagType
(
    override val sup: BasicElement,
    M: String,
    R: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[PurposeFlagType] }
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
        (if (null != M) "\t\t<cim:PurposeFlagType.M rdf:resource=\"#" + M + "\"/>\n" else "") +
        (if (null != R) "\t\t<cim:PurposeFlagType.R rdf:resource=\"#" + R + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:PurposeFlagType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:PurposeFlagType>\n"
    }
}

object PurposeFlagType
extends
    Parseable[PurposeFlagType]
{
    val M: (Context) => String = parse_attribute (attribute ("""PurposeFlagType.M"""))
    val R: (Context) => String = parse_attribute (attribute ("""PurposeFlagType.R"""))
    def parse (context: Context): PurposeFlagType =
    {
        PurposeFlagType(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param _0 Fixed ramp rate independent of rate function unit MW output
 * @param _1 Static ramp rates as a function of unit MW output only
 * @param _2 Dynamic ramp rates as a function of unit MW output and ramping time
 */
case class RampCurveType
(
    override val sup: BasicElement,
    _0: String,
    _1: String,
    _2: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[RampCurveType] }
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
        (if (null != _0) "\t\t<cim:RampCurveType.0 rdf:resource=\"#" + _0 + "\"/>\n" else "") +
        (if (null != _1) "\t\t<cim:RampCurveType.1 rdf:resource=\"#" + _1 + "\"/>\n" else "") +
        (if (null != _2) "\t\t<cim:RampCurveType.2 rdf:resource=\"#" + _2 + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RampCurveType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RampCurveType>\n"
    }
}

object RampCurveType
extends
    Parseable[RampCurveType]
{
    val _0: (Context) => String = parse_attribute (attribute ("""RampCurveType.0"""))
    val _1: (Context) => String = parse_attribute (attribute ("""RampCurveType.1"""))
    val _2: (Context) => String = parse_attribute (attribute ("""RampCurveType.2"""))
    def parse (context: Context): RampCurveType =
    {
        RampCurveType(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param _0 Ignore ramping limits
 * @param _1 20-minute ramping rule,
 * @param _2 60-minute ramping rule
 */
case class RampModeType
(
    override val sup: BasicElement,
    _0: String,
    _1: String,
    _2: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[RampModeType] }
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
        (if (null != _0) "\t\t<cim:RampModeType.0 rdf:resource=\"#" + _0 + "\"/>\n" else "") +
        (if (null != _1) "\t\t<cim:RampModeType.1 rdf:resource=\"#" + _1 + "\"/>\n" else "") +
        (if (null != _2) "\t\t<cim:RampModeType.2 rdf:resource=\"#" + _2 + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RampModeType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RampModeType>\n"
    }
}

object RampModeType
extends
    Parseable[RampModeType]
{
    val _0: (Context) => String = parse_attribute (attribute ("""RampModeType.0"""))
    val _1: (Context) => String = parse_attribute (attribute ("""RampModeType.1"""))
    val _2: (Context) => String = parse_attribute (attribute ("""RampModeType.2"""))
    def parse (context: Context): RampModeType =
    {
        RampModeType(
            BasicElement.parse (context),
            _0 (context),
            _1 (context),
            _2 (context)
        )
    }
}

/**
 * Ramp rate condition
 * @param sup Reference to the superclass object.
 * @param BEST <em>undocumented</em>
 * @param NA not applicable
 * @param NORMAL <em>undocumented</em>
 * @param WORST <em>undocumented</em>
 */
case class RampRateCondition
(
    override val sup: BasicElement,
    BEST: String,
    NA: String,
    NORMAL: String,
    WORST: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[RampRateCondition] }
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
        (if (null != BEST) "\t\t<cim:RampRateCondition.BEST rdf:resource=\"#" + BEST + "\"/>\n" else "") +
        (if (null != NA) "\t\t<cim:RampRateCondition.NA rdf:resource=\"#" + NA + "\"/>\n" else "") +
        (if (null != NORMAL) "\t\t<cim:RampRateCondition.NORMAL rdf:resource=\"#" + NORMAL + "\"/>\n" else "") +
        (if (null != WORST) "\t\t<cim:RampRateCondition.WORST rdf:resource=\"#" + WORST + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RampRateCondition rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RampRateCondition>\n"
    }
}

object RampRateCondition
extends
    Parseable[RampRateCondition]
{
    val BEST: (Context) => String = parse_attribute (attribute ("""RampRateCondition.BEST"""))
    val NA: (Context) => String = parse_attribute (attribute ("""RampRateCondition.NA"""))
    val NORMAL: (Context) => String = parse_attribute (attribute ("""RampRateCondition.NORMAL"""))
    val WORST: (Context) => String = parse_attribute (attribute ("""RampRateCondition.WORST"""))
    def parse (context: Context): RampRateCondition =
    {
        RampRateCondition(
            BasicElement.parse (context),
            BEST (context),
            NA (context),
            NORMAL (context),
            WORST (context)
        )
    }
}

/**
 * Ramp rate curve type.
 * @param sup Reference to the superclass object.
 * @param INTERTIE Intertie ramp rate.
 * @param LD_DROP Load drop ramp rate.
 * @param LD_PICKUP Load pick up rate.
 * @param OP Operational ramp rate.
 * @param OP_RES Operating reserve ramp rate.
 * @param REG Regulating ramp rate.
 */
case class RampRateType
(
    override val sup: BasicElement,
    INTERTIE: String,
    LD_DROP: String,
    LD_PICKUP: String,
    OP: String,
    OP_RES: String,
    REG: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[RampRateType] }
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
        (if (null != INTERTIE) "\t\t<cim:RampRateType.INTERTIE rdf:resource=\"#" + INTERTIE + "\"/>\n" else "") +
        (if (null != LD_DROP) "\t\t<cim:RampRateType.LD_DROP rdf:resource=\"#" + LD_DROP + "\"/>\n" else "") +
        (if (null != LD_PICKUP) "\t\t<cim:RampRateType.LD_PICKUP rdf:resource=\"#" + LD_PICKUP + "\"/>\n" else "") +
        (if (null != OP) "\t\t<cim:RampRateType.OP rdf:resource=\"#" + OP + "\"/>\n" else "") +
        (if (null != OP_RES) "\t\t<cim:RampRateType.OP_RES rdf:resource=\"#" + OP_RES + "\"/>\n" else "") +
        (if (null != REG) "\t\t<cim:RampRateType.REG rdf:resource=\"#" + REG + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:RampRateType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:RampRateType>\n"
    }
}

object RampRateType
extends
    Parseable[RampRateType]
{
    val INTERTIE: (Context) => String = parse_attribute (attribute ("""RampRateType.INTERTIE"""))
    val LD_DROP: (Context) => String = parse_attribute (attribute ("""RampRateType.LD_DROP"""))
    val LD_PICKUP: (Context) => String = parse_attribute (attribute ("""RampRateType.LD_PICKUP"""))
    val OP: (Context) => String = parse_attribute (attribute ("""RampRateType.OP"""))
    val OP_RES: (Context) => String = parse_attribute (attribute ("""RampRateType.OP_RES"""))
    val REG: (Context) => String = parse_attribute (attribute ("""RampRateType.REG"""))
    def parse (context: Context): RampRateType =
    {
        RampRateType(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param CONT Contingency
 * @param OPRSV Operating Reserve
 * @param REG Regulation
 */
case class ReserveRequirementType
(
    override val sup: BasicElement,
    CONT: String,
    OPRSV: String,
    REG: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ReserveRequirementType] }
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
        (if (null != CONT) "\t\t<cim:ReserveRequirementType.CONT rdf:resource=\"#" + CONT + "\"/>\n" else "") +
        (if (null != OPRSV) "\t\t<cim:ReserveRequirementType.OPRSV rdf:resource=\"#" + OPRSV + "\"/>\n" else "") +
        (if (null != REG) "\t\t<cim:ReserveRequirementType.REG rdf:resource=\"#" + REG + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ReserveRequirementType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ReserveRequirementType>\n"
    }
}

object ReserveRequirementType
extends
    Parseable[ReserveRequirementType]
{
    val CONT: (Context) => String = parse_attribute (attribute ("""ReserveRequirementType.CONT"""))
    val OPRSV: (Context) => String = parse_attribute (attribute ("""ReserveRequirementType.OPRSV"""))
    val REG: (Context) => String = parse_attribute (attribute ("""ReserveRequirementType.REG"""))
    def parse (context: Context): ReserveRequirementType =
    {
        ReserveRequirementType(
            BasicElement.parse (context),
            CONT (context),
            OPRSV (context),
            REG (context)
        )
    }
}

/**
 * Types used for resource AS qualifications
 * @param sup Reference to the superclass object.
 * @param BLACKSTART Black start
 * @param DSR Demand Side Reponse
 * @param NONSPIN Non Spinning Reserve
 * @param PIRP Intermittant resource
 * @param REGDN Regulation Down
 * @param REGUP Regulation Up
 * @param RMR Reliability Must Run
 * @param RRSPIN Spinning Reserve
 * @param RUC Reliability unit commitment
 * @param SYNCCOND <em>undocumented</em>
 */
case class ResourceAncillaryServiceType
(
    override val sup: BasicElement,
    BLACKSTART: String,
    DSR: String,
    NONSPIN: String,
    PIRP: String,
    REGDN: String,
    REGUP: String,
    RMR: String,
    RRSPIN: String,
    RUC: String,
    SYNCCOND: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ResourceAncillaryServiceType] }
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
        (if (null != BLACKSTART) "\t\t<cim:ResourceAncillaryServiceType.BLACKSTART rdf:resource=\"#" + BLACKSTART + "\"/>\n" else "") +
        (if (null != DSR) "\t\t<cim:ResourceAncillaryServiceType.DSR rdf:resource=\"#" + DSR + "\"/>\n" else "") +
        (if (null != NONSPIN) "\t\t<cim:ResourceAncillaryServiceType.NONSPIN rdf:resource=\"#" + NONSPIN + "\"/>\n" else "") +
        (if (null != PIRP) "\t\t<cim:ResourceAncillaryServiceType.PIRP rdf:resource=\"#" + PIRP + "\"/>\n" else "") +
        (if (null != REGDN) "\t\t<cim:ResourceAncillaryServiceType.REGDN rdf:resource=\"#" + REGDN + "\"/>\n" else "") +
        (if (null != REGUP) "\t\t<cim:ResourceAncillaryServiceType.REGUP rdf:resource=\"#" + REGUP + "\"/>\n" else "") +
        (if (null != RMR) "\t\t<cim:ResourceAncillaryServiceType.RMR rdf:resource=\"#" + RMR + "\"/>\n" else "") +
        (if (null != RRSPIN) "\t\t<cim:ResourceAncillaryServiceType.RRSPIN rdf:resource=\"#" + RRSPIN + "\"/>\n" else "") +
        (if (null != RUC) "\t\t<cim:ResourceAncillaryServiceType.RUC rdf:resource=\"#" + RUC + "\"/>\n" else "") +
        (if (null != SYNCCOND) "\t\t<cim:ResourceAncillaryServiceType.SYNCCOND rdf:resource=\"#" + SYNCCOND + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ResourceAncillaryServiceType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ResourceAncillaryServiceType>\n"
    }
}

object ResourceAncillaryServiceType
extends
    Parseable[ResourceAncillaryServiceType]
{
    val BLACKSTART: (Context) => String = parse_attribute (attribute ("""ResourceAncillaryServiceType.BLACKSTART"""))
    val DSR: (Context) => String = parse_attribute (attribute ("""ResourceAncillaryServiceType.DSR"""))
    val NONSPIN: (Context) => String = parse_attribute (attribute ("""ResourceAncillaryServiceType.NONSPIN"""))
    val PIRP: (Context) => String = parse_attribute (attribute ("""ResourceAncillaryServiceType.PIRP"""))
    val REGDN: (Context) => String = parse_attribute (attribute ("""ResourceAncillaryServiceType.REGDN"""))
    val REGUP: (Context) => String = parse_attribute (attribute ("""ResourceAncillaryServiceType.REGUP"""))
    val RMR: (Context) => String = parse_attribute (attribute ("""ResourceAncillaryServiceType.RMR"""))
    val RRSPIN: (Context) => String = parse_attribute (attribute ("""ResourceAncillaryServiceType.RRSPIN"""))
    val RUC: (Context) => String = parse_attribute (attribute ("""ResourceAncillaryServiceType.RUC"""))
    val SYNCCOND: (Context) => String = parse_attribute (attribute ("""ResourceAncillaryServiceType.SYNCCOND"""))
    def parse (context: Context): ResourceAncillaryServiceType =
    {
        ResourceAncillaryServiceType(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param CSNK <em>undocumented</em>
 * @param CSRC <em>undocumented</em>
 * @param LSE <em>undocumented</em>
 * @param RMR <em>undocumented</em>
 * @param SC <em>undocumented</em>
 */
case class ResourceAssnType
(
    override val sup: BasicElement,
    CSNK: String,
    CSRC: String,
    LSE: String,
    RMR: String,
    SC: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ResourceAssnType] }
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
        (if (null != CSNK) "\t\t<cim:ResourceAssnType.CSNK rdf:resource=\"#" + CSNK + "\"/>\n" else "") +
        (if (null != CSRC) "\t\t<cim:ResourceAssnType.CSRC rdf:resource=\"#" + CSRC + "\"/>\n" else "") +
        (if (null != LSE) "\t\t<cim:ResourceAssnType.LSE rdf:resource=\"#" + LSE + "\"/>\n" else "") +
        (if (null != RMR) "\t\t<cim:ResourceAssnType.RMR rdf:resource=\"#" + RMR + "\"/>\n" else "") +
        (if (null != SC) "\t\t<cim:ResourceAssnType.SC rdf:resource=\"#" + SC + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ResourceAssnType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ResourceAssnType>\n"
    }
}

object ResourceAssnType
extends
    Parseable[ResourceAssnType]
{
    val CSNK: (Context) => String = parse_attribute (attribute ("""ResourceAssnType.CSNK"""))
    val CSRC: (Context) => String = parse_attribute (attribute ("""ResourceAssnType.CSRC"""))
    val LSE: (Context) => String = parse_attribute (attribute ("""ResourceAssnType.LSE"""))
    val RMR: (Context) => String = parse_attribute (attribute ("""ResourceAssnType.RMR"""))
    val SC: (Context) => String = parse_attribute (attribute ("""ResourceAssnType.SC"""))
    def parse (context: Context): ResourceAssnType =
    {
        ResourceAssnType(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param FO Flexible Offer.
 * @param MO Must Offer.
 * @param NR Non spinning reserve.
 * @param RA Resource Adequacy.
 * @param RD Regulation Down.
 * @param RMR Reliability Must Run.
 * @param RU Regulation Up.
 * @param SR Spinning reserve.
 */
case class ResourceCapacityType
(
    override val sup: BasicElement,
    FO: String,
    MO: String,
    NR: String,
    RA: String,
    RD: String,
    RMR: String,
    RU: String,
    SR: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ResourceCapacityType] }
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
        (if (null != FO) "\t\t<cim:ResourceCapacityType.FO rdf:resource=\"#" + FO + "\"/>\n" else "") +
        (if (null != MO) "\t\t<cim:ResourceCapacityType.MO rdf:resource=\"#" + MO + "\"/>\n" else "") +
        (if (null != NR) "\t\t<cim:ResourceCapacityType.NR rdf:resource=\"#" + NR + "\"/>\n" else "") +
        (if (null != RA) "\t\t<cim:ResourceCapacityType.RA rdf:resource=\"#" + RA + "\"/>\n" else "") +
        (if (null != RD) "\t\t<cim:ResourceCapacityType.RD rdf:resource=\"#" + RD + "\"/>\n" else "") +
        (if (null != RMR) "\t\t<cim:ResourceCapacityType.RMR rdf:resource=\"#" + RMR + "\"/>\n" else "") +
        (if (null != RU) "\t\t<cim:ResourceCapacityType.RU rdf:resource=\"#" + RU + "\"/>\n" else "") +
        (if (null != SR) "\t\t<cim:ResourceCapacityType.SR rdf:resource=\"#" + SR + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ResourceCapacityType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ResourceCapacityType>\n"
    }
}

object ResourceCapacityType
extends
    Parseable[ResourceCapacityType]
{
    val FO: (Context) => String = parse_attribute (attribute ("""ResourceCapacityType.FO"""))
    val MO: (Context) => String = parse_attribute (attribute ("""ResourceCapacityType.MO"""))
    val NR: (Context) => String = parse_attribute (attribute ("""ResourceCapacityType.NR"""))
    val RA: (Context) => String = parse_attribute (attribute ("""ResourceCapacityType.RA"""))
    val RD: (Context) => String = parse_attribute (attribute ("""ResourceCapacityType.RD"""))
    val RMR: (Context) => String = parse_attribute (attribute ("""ResourceCapacityType.RMR"""))
    val RU: (Context) => String = parse_attribute (attribute ("""ResourceCapacityType.RU"""))
    val SR: (Context) => String = parse_attribute (attribute ("""ResourceCapacityType.SR"""))
    def parse (context: Context): ResourceCapacityType =
    {
        ResourceCapacityType(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param LOWER <em>undocumented</em>
 * @param UPPER <em>undocumented</em>
 */
case class ResourceLimitIndicator
(
    override val sup: BasicElement,
    LOWER: String,
    UPPER: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ResourceLimitIndicator] }
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
        (if (null != LOWER) "\t\t<cim:ResourceLimitIndicator.LOWER rdf:resource=\"#" + LOWER + "\"/>\n" else "") +
        (if (null != UPPER) "\t\t<cim:ResourceLimitIndicator.UPPER rdf:resource=\"#" + UPPER + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ResourceLimitIndicator rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ResourceLimitIndicator>\n"
    }
}

object ResourceLimitIndicator
extends
    Parseable[ResourceLimitIndicator]
{
    val LOWER: (Context) => String = parse_attribute (attribute ("""ResourceLimitIndicator.LOWER"""))
    val UPPER: (Context) => String = parse_attribute (attribute ("""ResourceLimitIndicator.UPPER"""))
    def parse (context: Context): ResourceLimitIndicator =
    {
        ResourceLimitIndicator(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param Active Resource registration is active
 * @param Decommissioned Resource registration status is decommissioned
 * @param Mothballed Resource registration has been suspended
 * @param Planned Registration status is in the planning stage
 */
case class ResourceRegistrationStatus
(
    override val sup: BasicElement,
    Active: String,
    Decommissioned: String,
    Mothballed: String,
    Planned: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ResourceRegistrationStatus] }
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
        (if (null != Active) "\t\t<cim:ResourceRegistrationStatus.Active rdf:resource=\"#" + Active + "\"/>\n" else "") +
        (if (null != Decommissioned) "\t\t<cim:ResourceRegistrationStatus.Decommissioned rdf:resource=\"#" + Decommissioned + "\"/>\n" else "") +
        (if (null != Mothballed) "\t\t<cim:ResourceRegistrationStatus.Mothballed rdf:resource=\"#" + Mothballed + "\"/>\n" else "") +
        (if (null != Planned) "\t\t<cim:ResourceRegistrationStatus.Planned rdf:resource=\"#" + Planned + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ResourceRegistrationStatus rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ResourceRegistrationStatus>\n"
    }
}

object ResourceRegistrationStatus
extends
    Parseable[ResourceRegistrationStatus]
{
    val Active: (Context) => String = parse_attribute (attribute ("""ResourceRegistrationStatus.Active"""))
    val Decommissioned: (Context) => String = parse_attribute (attribute ("""ResourceRegistrationStatus.Decommissioned"""))
    val Mothballed: (Context) => String = parse_attribute (attribute ("""ResourceRegistrationStatus.Mothballed"""))
    val Planned: (Context) => String = parse_attribute (attribute ("""ResourceRegistrationStatus.Planned"""))
    def parse (context: Context): ResourceRegistrationStatus =
    {
        ResourceRegistrationStatus(
            BasicElement.parse (context),
            Active (context),
            Decommissioned (context),
            Mothballed (context),
            Planned (context)
        )
    }
}

/**
 * Market results binding constraint types.
 * @param sup Reference to the superclass object.
 * @param Actual Actual.
 * @param Contingency Contingency.
 * @param FG_act Flowgate actual base case
 * @param Interface Interface.
 */
case class ResultsConstraintType
(
    override val sup: BasicElement,
    Actual: String,
    Contingency: String,
    FG_act: String,
    Interface: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[ResultsConstraintType] }
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
        (if (null != Actual) "\t\t<cim:ResultsConstraintType.Actual rdf:resource=\"#" + Actual + "\"/>\n" else "") +
        (if (null != Contingency) "\t\t<cim:ResultsConstraintType.Contingency rdf:resource=\"#" + Contingency + "\"/>\n" else "") +
        (if (null != FG_act) "\t\t<cim:ResultsConstraintType.FG_act rdf:resource=\"#" + FG_act + "\"/>\n" else "") +
        (if (null != Interface) "\t\t<cim:ResultsConstraintType.Interface rdf:resource=\"#" + Interface + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:ResultsConstraintType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:ResultsConstraintType>\n"
    }
}

object ResultsConstraintType
extends
    Parseable[ResultsConstraintType]
{
    val Actual: (Context) => String = parse_attribute (attribute ("""ResultsConstraintType.Actual"""))
    val Contingency: (Context) => String = parse_attribute (attribute ("""ResultsConstraintType.Contingency"""))
    val FG_act: (Context) => String = parse_attribute (attribute ("""ResultsConstraintType.FG_act"""))
    val Interface: (Context) => String = parse_attribute (attribute ("""ResultsConstraintType.Interface"""))
    def parse (context: Context): ResultsConstraintType =
    {
        ResultsConstraintType(
            BasicElement.parse (context),
            Actual (context),
            Contingency (context),
            FG_act (context),
            Interface (context)
        )
    }
}

/**
 * Indication of which type of self schedule is being referenced.
 * @param sup Reference to the superclass object.
 * @param ETC Existing transmission contract.
 * @param TOR Transmission ownership right.
 */
case class SelfSchedReferenceType
(
    override val sup: BasicElement,
    ETC: String,
    TOR: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[SelfSchedReferenceType] }
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
        (if (null != ETC) "\t\t<cim:SelfSchedReferenceType.ETC rdf:resource=\"#" + ETC + "\"/>\n" else "") +
        (if (null != TOR) "\t\t<cim:SelfSchedReferenceType.TOR rdf:resource=\"#" + TOR + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SelfSchedReferenceType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SelfSchedReferenceType>\n"
    }
}

object SelfSchedReferenceType
extends
    Parseable[SelfSchedReferenceType]
{
    val ETC: (Context) => String = parse_attribute (attribute ("""SelfSchedReferenceType.ETC"""))
    val TOR: (Context) => String = parse_attribute (attribute ("""SelfSchedReferenceType.TOR"""))
    def parse (context: Context): SelfSchedReferenceType =
    {
        SelfSchedReferenceType(
            BasicElement.parse (context),
            ETC (context),
            TOR (context)
        )
    }
}

/**
 * Self schedule breakdown type.
 * @param sup Reference to the superclass object.
 * @param ETC Existing transmission contract.
 * @param LPT Low price taker.
 * @param TOR Transmission ownership right.
 */
case class SelfScheduleBreakdownType
(
    override val sup: BasicElement,
    ETC: String,
    LPT: String,
    TOR: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[SelfScheduleBreakdownType] }
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
        (if (null != ETC) "\t\t<cim:SelfScheduleBreakdownType.ETC rdf:resource=\"#" + ETC + "\"/>\n" else "") +
        (if (null != LPT) "\t\t<cim:SelfScheduleBreakdownType.LPT rdf:resource=\"#" + LPT + "\"/>\n" else "") +
        (if (null != TOR) "\t\t<cim:SelfScheduleBreakdownType.TOR rdf:resource=\"#" + TOR + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SelfScheduleBreakdownType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SelfScheduleBreakdownType>\n"
    }
}

object SelfScheduleBreakdownType
extends
    Parseable[SelfScheduleBreakdownType]
{
    val ETC: (Context) => String = parse_attribute (attribute ("""SelfScheduleBreakdownType.ETC"""))
    val LPT: (Context) => String = parse_attribute (attribute ("""SelfScheduleBreakdownType.LPT"""))
    val TOR: (Context) => String = parse_attribute (attribute ("""SelfScheduleBreakdownType.TOR"""))
    def parse (context: Context): SelfScheduleBreakdownType =
    {
        SelfScheduleBreakdownType(
            BasicElement.parse (context),
            ETC (context),
            LPT (context),
            TOR (context)
        )
    }
}

/**
 * Circuit Breaker Status (closed or open) of the circuit breaker.
 * @param sup Reference to the superclass object.
 * @param Closed Closed status.
 * @param Open Open status.
 */
case class SwitchStatusType
(
    override val sup: BasicElement,
    Closed: String,
    Open: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[SwitchStatusType] }
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
        (if (null != Closed) "\t\t<cim:SwitchStatusType.Closed rdf:resource=\"#" + Closed + "\"/>\n" else "") +
        (if (null != Open) "\t\t<cim:SwitchStatusType.Open rdf:resource=\"#" + Open + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:SwitchStatusType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:SwitchStatusType>\n"
    }
}

object SwitchStatusType
extends
    Parseable[SwitchStatusType]
{
    val Closed: (Context) => String = parse_attribute (attribute ("""SwitchStatusType.Closed"""))
    val Open: (Context) => String = parse_attribute (attribute ("""SwitchStatusType.Open"""))
    def parse (context: Context): SwitchStatusType =
    {
        SwitchStatusType(
            BasicElement.parse (context),
            Closed (context),
            Open (context)
        )
    }
}

/**
 * Transmission Contract Right type -for example:
 * individual or chain of contract rights
 * @param sup Reference to the superclass object.
 * @param CHAIN TR chain
 * @param INDIVIDUAL Individual TR
 */
case class TRType
(
    override val sup: BasicElement,
    CHAIN: String,
    INDIVIDUAL: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TRType] }
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
        (if (null != CHAIN) "\t\t<cim:TRType.CHAIN rdf:resource=\"#" + CHAIN + "\"/>\n" else "") +
        (if (null != INDIVIDUAL) "\t\t<cim:TRType.INDIVIDUAL rdf:resource=\"#" + INDIVIDUAL + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TRType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TRType>\n"
    }
}

object TRType
extends
    Parseable[TRType]
{
    val CHAIN: (Context) => String = parse_attribute (attribute ("""TRType.CHAIN"""))
    val INDIVIDUAL: (Context) => String = parse_attribute (attribute ("""TRType.INDIVIDUAL"""))
    def parse (context: Context): TRType =
    {
        TRType(
            BasicElement.parse (context),
            CHAIN (context),
            INDIVIDUAL (context)
        )
    }
}

/**
 * Time of Use used by a CRR definition for specifying the time the CRR spans.
 * ON - CRR spans the on peak hours of the day, OFF - CRR spans the off peak hours of the day, 24HR - CRR spans the entire day.
 * @param sup Reference to the superclass object.
 * @param OFF Time of use spans only the off peak hours of the day.
 * @param ON Time of use spans only the on peak hours of the day.
 * @param _24HR Time of use spans the entire day, 24 hours.
 */
case class TimeOfUse
(
    override val sup: BasicElement,
    OFF: String,
    ON: String,
    _24HR: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TimeOfUse] }
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
        (if (null != OFF) "\t\t<cim:TimeOfUse.OFF rdf:resource=\"#" + OFF + "\"/>\n" else "") +
        (if (null != ON) "\t\t<cim:TimeOfUse.ON rdf:resource=\"#" + ON + "\"/>\n" else "") +
        (if (null != _24HR) "\t\t<cim:TimeOfUse.24HR rdf:resource=\"#" + _24HR + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TimeOfUse rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TimeOfUse>\n"
    }
}

object TimeOfUse
extends
    Parseable[TimeOfUse]
{
    val OFF: (Context) => String = parse_attribute (attribute ("""TimeOfUse.OFF"""))
    val ON: (Context) => String = parse_attribute (attribute ("""TimeOfUse.ON"""))
    val _24HR: (Context) => String = parse_attribute (attribute ("""TimeOfUse.24HR"""))
    def parse (context: Context): TimeOfUse =
    {
        TimeOfUse(
            BasicElement.parse (context),
            OFF (context),
            ON (context),
            _24HR (context)
        )
    }
}

/**
 * Trade type.
 * @param sup Reference to the superclass object.
 * @param AST Ancillary Services Trade.
 * @param IST InterSC Trade.
 * @param UCT Unit Commitment Trade.
 */
case class TradeType
(
    override val sup: BasicElement,
    AST: String,
    IST: String,
    UCT: String
)
extends
    Element
{
    def this () = { this (null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[TradeType] }
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
        (if (null != AST) "\t\t<cim:TradeType.AST rdf:resource=\"#" + AST + "\"/>\n" else "") +
        (if (null != IST) "\t\t<cim:TradeType.IST rdf:resource=\"#" + IST + "\"/>\n" else "") +
        (if (null != UCT) "\t\t<cim:TradeType.UCT rdf:resource=\"#" + UCT + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TradeType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TradeType>\n"
    }
}

object TradeType
extends
    Parseable[TradeType]
{
    val AST: (Context) => String = parse_attribute (attribute ("""TradeType.AST"""))
    val IST: (Context) => String = parse_attribute (attribute ("""TradeType.IST"""))
    val UCT: (Context) => String = parse_attribute (attribute ("""TradeType.UCT"""))
    def parse (context: Context): TradeType =
    {
        TradeType(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param CCYC Combined Cycle
 * @param GTUR Gas Turbine
 * @param HYDR Hydro Turbine
 * @param OTHR Other
 * @param PHOT Photovoltaic
 * @param PTUR Hydro Pump-Turbine
 * @param RECP Reciprocating Engine
 * @param STUR Steam Turbine
 * @param SYNC Synchronous Condenser
 * @param WIND Wind Turbine
 */
case class UnitType
(
    override val sup: BasicElement,
    CCYC: String,
    GTUR: String,
    HYDR: String,
    OTHR: String,
    PHOT: String,
    PTUR: String,
    RECP: String,
    STUR: String,
    SYNC: String,
    WIND: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null, null, null, null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[UnitType] }
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
        (if (null != CCYC) "\t\t<cim:UnitType.CCYC rdf:resource=\"#" + CCYC + "\"/>\n" else "") +
        (if (null != GTUR) "\t\t<cim:UnitType.GTUR rdf:resource=\"#" + GTUR + "\"/>\n" else "") +
        (if (null != HYDR) "\t\t<cim:UnitType.HYDR rdf:resource=\"#" + HYDR + "\"/>\n" else "") +
        (if (null != OTHR) "\t\t<cim:UnitType.OTHR rdf:resource=\"#" + OTHR + "\"/>\n" else "") +
        (if (null != PHOT) "\t\t<cim:UnitType.PHOT rdf:resource=\"#" + PHOT + "\"/>\n" else "") +
        (if (null != PTUR) "\t\t<cim:UnitType.PTUR rdf:resource=\"#" + PTUR + "\"/>\n" else "") +
        (if (null != RECP) "\t\t<cim:UnitType.RECP rdf:resource=\"#" + RECP + "\"/>\n" else "") +
        (if (null != STUR) "\t\t<cim:UnitType.STUR rdf:resource=\"#" + STUR + "\"/>\n" else "") +
        (if (null != SYNC) "\t\t<cim:UnitType.SYNC rdf:resource=\"#" + SYNC + "\"/>\n" else "") +
        (if (null != WIND) "\t\t<cim:UnitType.WIND rdf:resource=\"#" + WIND + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:UnitType rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:UnitType>\n"
    }
}

object UnitType
extends
    Parseable[UnitType]
{
    val CCYC: (Context) => String = parse_attribute (attribute ("""UnitType.CCYC"""))
    val GTUR: (Context) => String = parse_attribute (attribute ("""UnitType.GTUR"""))
    val HYDR: (Context) => String = parse_attribute (attribute ("""UnitType.HYDR"""))
    val OTHR: (Context) => String = parse_attribute (attribute ("""UnitType.OTHR"""))
    val PHOT: (Context) => String = parse_attribute (attribute ("""UnitType.PHOT"""))
    val PTUR: (Context) => String = parse_attribute (attribute ("""UnitType.PTUR"""))
    val RECP: (Context) => String = parse_attribute (attribute ("""UnitType.RECP"""))
    val STUR: (Context) => String = parse_attribute (attribute ("""UnitType.STUR"""))
    val SYNC: (Context) => String = parse_attribute (attribute ("""UnitType.SYNC"""))
    val WIND: (Context) => String = parse_attribute (attribute ("""UnitType.WIND"""))
    def parse (context: Context): UnitType =
    {
        UnitType(
            BasicElement.parse (context),
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
 * @param sup Reference to the superclass object.
 * @param NO <em>undocumented</em>
 * @param YES <em>undocumented</em>
 */
case class YesNo
(
    override val sup: BasicElement,
    NO: String,
    YES: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[YesNo] }
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
        (if (null != NO) "\t\t<cim:YesNo.NO rdf:resource=\"#" + NO + "\"/>\n" else "") +
        (if (null != YES) "\t\t<cim:YesNo.YES rdf:resource=\"#" + YES + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:YesNo rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:YesNo>\n"
    }
}

object YesNo
extends
    Parseable[YesNo]
{
    val NO: (Context) => String = parse_attribute (attribute ("""YesNo.NO"""))
    val YES: (Context) => String = parse_attribute (attribute ("""YesNo.YES"""))
    def parse (context: Context): YesNo =
    {
        YesNo(
            BasicElement.parse (context),
            NO (context),
            YES (context)
        )
    }
}

private[ninecode] object _MktDomain
{
    def register: List[ClassInfo] =
    {
        List (
            ActionType.register,
            AnalogLimitType.register,
            AnodeType.register,
            ApnodeType.register,
            AreaControlMode.register,
            AutomaticDispInstTypeCommitment.register,
            AutomaticDispatchMode.register,
            BidCalculationBasis.register,
            BidMitigationStatus.register,
            BidMitigationType.register,
            BidType.register,
            BidTypeRMR.register,
            CRRCategoryType.register,
            CRRHedgeType.register,
            CRRRoleType.register,
            CRRSegmentType.register,
            CheckOutType.register,
            CommitmentType.register,
            ConstraintLimitType.register,
            ConstraintRampType.register,
            ContractType.register,
            CostBasis.register,
            DispatchResponseType.register,
            EnergyPriceIndexType.register,
            EnergyProductType.register,
            EnergyTransactionType.register,
            EquipmentStatusType.register,
            ExecutionType.register,
            FlagTypeRMR.register,
            FlowDirectionType.register,
            FuelSource.register,
            InterTieDirection.register,
            LoadForecastType.register,
            MPMTestIdentifierType.register,
            MPMTestMethodType.register,
            MPMTestOutcome.register,
            MQSCHGType.register,
            MQSInstructionSource.register,
            MarketProductSelfSchedType.register,
            MarketProductType.register,
            MarketType.register,
            MktAccountKind.register,
            MktBillMediaKind.register,
            MktInvoiceLineItemKind.register,
            OnOff.register,
            ParticipationCategoryMPM.register,
            PassIndicatorType.register,
            PurposeFlagType.register,
            RampCurveType.register,
            RampModeType.register,
            RampRateCondition.register,
            RampRateType.register,
            ReserveRequirementType.register,
            ResourceAncillaryServiceType.register,
            ResourceAssnType.register,
            ResourceCapacityType.register,
            ResourceLimitIndicator.register,
            ResourceRegistrationStatus.register,
            ResultsConstraintType.register,
            SelfSchedReferenceType.register,
            SelfScheduleBreakdownType.register,
            SwitchStatusType.register,
            TRType.register,
            TimeOfUse.register,
            TradeType.register,
            UnitType.register,
            YesNo.register
        )
    }
}
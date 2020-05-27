package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * BilateralExchangeActor describes an actor that provides ICCP data, consumes ICCP data or both.
 *
 * The ICCP data provider lists the data it makes available to an ICCP data consumer.  This data is described by ProvidedBilateralPoints. The relation between an ICCP data provider and a consumer is established by a BilateralExchangeAgreement.  It is up to the ICCP data consumer to select what ProvidedBilateralPoints to use.  The selection made is not described in this information model.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param CommunicationLink [[ch.ninecode.model.CommunicationLink CommunicationLink]] Communication addressing for a Bilateral Table used by a ICCP data provider or consumer.
 * @param ConsumerBilateralExchange [[ch.ninecode.model.BilateralExchangeAgreement BilateralExchangeAgreement]] Agreement to information subscriber.
 * @param ProvidedBilateralIOPoint [[ch.ninecode.model.ProvidedBilateralPoint ProvidedBilateralPoint]] ICCP information in a Bilateral table that will be exposed to a remote peer.
 * @param ProviderBilateralExchange [[ch.ninecode.model.BilateralExchangeAgreement BilateralExchangeAgreement]] Agreement to information provider.
 * @group ICCPConfiguration
 * @groupname ICCPConfiguration Package ICCPConfiguration
 * @groupdesc ICCPConfiguration This package models configuration of ICCP required for bilateral exchanges.
 */
final case class BilateralExchangeActor
(
    IdentifiedObject: IdentifiedObject = null,
    CommunicationLink: List[String] = null,
    ConsumerBilateralExchange: List[String] = null,
    ProvidedBilateralIOPoint: List[String] = null,
    ProviderBilateralExchange: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = BilateralExchangeActor.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (BilateralExchangeActor.fields (position), x))
        emitattrs (0, CommunicationLink)
        emitattrs (1, ConsumerBilateralExchange)
        emitattrs (2, ProvidedBilateralIOPoint)
        emitattrs (3, ProviderBilateralExchange)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BilateralExchangeActor rdf:ID=\"%s\">\n%s\t</cim:BilateralExchangeActor>".format (id, export_fields)
    }
}

object BilateralExchangeActor
extends
    Parseable[BilateralExchangeActor]
{
    override val fields: Array[String] = Array[String] (
        "CommunicationLink",
        "ConsumerBilateralExchange",
        "ProvidedBilateralIOPoint",
        "ProviderBilateralExchange"
    )
    override val relations: List[Relationship] = List (
        Relationship ("CommunicationLink", "CommunicationLink", "0..n", "0..1"),
        Relationship ("ConsumerBilateralExchange", "BilateralExchangeAgreement", "0..*", "0..1"),
        Relationship ("ProvidedBilateralIOPoint", "ProvidedBilateralPoint", "0..*", "1"),
        Relationship ("ProviderBilateralExchange", "BilateralExchangeAgreement", "0..*", "1")
    )
    val CommunicationLink: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val ConsumerBilateralExchange: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val ProvidedBilateralIOPoint: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val ProviderBilateralExchange: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): BilateralExchangeActor =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = BilateralExchangeActor (
            IdentifiedObject.parse (context),
            masks (CommunicationLink (), 0),
            masks (ConsumerBilateralExchange (), 1),
            masks (ProvidedBilateralIOPoint (), 2),
            masks (ProviderBilateralExchange (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This is the representation of the information exchange agreement between peers.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Consumer [[ch.ninecode.model.BilateralExchangeActor BilateralExchangeActor]] Subscriber of information from a remote peer.
 * @param Provider [[ch.ninecode.model.BilateralExchangeActor BilateralExchangeActor]] Provider of information to a remote peer.
 * @group ICCPConfiguration
 * @groupname ICCPConfiguration Package ICCPConfiguration
 * @groupdesc ICCPConfiguration This package models configuration of ICCP required for bilateral exchanges.
 */
final case class BilateralExchangeAgreement
(
    IdentifiedObject: IdentifiedObject = null,
    Consumer: String = null,
    Provider: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = BilateralExchangeAgreement.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (BilateralExchangeAgreement.fields (position), value)
        emitattr (0, Consumer)
        emitattr (1, Provider)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:BilateralExchangeAgreement rdf:ID=\"%s\">\n%s\t</cim:BilateralExchangeAgreement>".format (id, export_fields)
    }
}

object BilateralExchangeAgreement
extends
    Parseable[BilateralExchangeAgreement]
{
    override val fields: Array[String] = Array[String] (
        "Consumer",
        "Provider"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Consumer", "BilateralExchangeActor", "0..1", "0..*"),
        Relationship ("Provider", "BilateralExchangeActor", "1", "0..*")
    )
    val Consumer: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Provider: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): BilateralExchangeAgreement =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = BilateralExchangeAgreement (
            IdentifiedObject.parse (context),
            mask (Consumer (), 0),
            mask (Provider (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This class represents the TASE.2 Information Message Object.
 *
 * The IdentifiedObject.name attribute must be non-null.  The value of the attribute shall be used as the TASE.2 Information Reference, as specified by 60870-6-503.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param localReference The Local Reference attribute specifies a value agreed upon between sender and receiver of the Information Message.
 *        It further identifies the Information Message.
 * @param scope Indicates if the Point is global scoped (e.g.
 *        VCC) or accessible only to the Bilateral table peer (e.g. ICC).
 * @param TASE2BilateralTable [[ch.ninecode.model.TASE2BilateralTable TASE2BilateralTable]] Bilateral table agreement that includes the informational message.
 * @group ICCPConfiguration
 * @groupname ICCPConfiguration Package ICCPConfiguration
 * @groupdesc ICCPConfiguration This package models configuration of ICCP required for bilateral exchanges.
 */
final case class ICCPInformationMessage
(
    IdentifiedObject: IdentifiedObject = null,
    localReference: String = null,
    scope: String = null,
    TASE2BilateralTable: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ICCPInformationMessage.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ICCPInformationMessage.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ICCPInformationMessage.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ICCPInformationMessage.fields (position), x))
        emitelem (0, localReference)
        emitattr (1, scope)
        emitattrs (2, TASE2BilateralTable)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ICCPInformationMessage rdf:ID=\"%s\">\n%s\t</cim:ICCPInformationMessage>".format (id, export_fields)
    }
}

object ICCPInformationMessage
extends
    Parseable[ICCPInformationMessage]
{
    override val fields: Array[String] = Array[String] (
        "localReference",
        "scope",
        "TASE2BilateralTable"
    )
    override val relations: List[Relationship] = List (
        Relationship ("TASE2BilateralTable", "TASE2BilateralTable", "0..*", "0..*")
    )
    val localReference: Fielder = parse_element (element (cls, fields(0)))
    val scope: Fielder = parse_attribute (attribute (cls, fields(1)))
    val TASE2BilateralTable: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): ICCPInformationMessage =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ICCPInformationMessage (
            IdentifiedObject.parse (context),
            mask (localReference (), 0),
            mask (scope (), 1),
            masks (TASE2BilateralTable (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The IdentifiedObject.name attribute must have a value.
 *
 * The name attribute shall be used as the DataValue name used for the exchange.
 *
 * @param ProvidedBilateralPoint [[ch.ninecode.model.ProvidedBilateralPoint ProvidedBilateralPoint]] Reference to the superclass object.
 * @param accessPriviledge Provides information regarding the access privileges allowed to the ICCP Point.
 * @param pointQuality Specifies the type of ICCP quality that will be conveyed as part of the ICCP Point.
 * @param pointType Indicates the ICCP Point type that is to be conveyed.
 *        A CIM AccumlatorValue  shall be mapped to an ICCP real.
 *        A CIM AnalogValue shall be mapped to an ICCP real.
 *        A CIM DiscreteValue shall be mapped to either an ICCP real, state, stateSupplemental, or either protection event type.
 *        A CIM StringMeasurementValue does not have a standardized mapping.
 * @param scope Indicates if the Point is global scoped (e.g.
 *        VCC) or accessible only to the Bilateral table peer (e.g. ICC).
 * @group ICCPConfiguration
 * @groupname ICCPConfiguration Package ICCPConfiguration
 * @groupdesc ICCPConfiguration This package models configuration of ICCP required for bilateral exchanges.
 */
final case class ICCPProvidedPoint
(
    ProvidedBilateralPoint: ProvidedBilateralPoint = null,
    accessPriviledge: String = null,
    pointQuality: String = null,
    pointType: String = null,
    scope: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: ProvidedBilateralPoint = ProvidedBilateralPoint

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ICCPProvidedPoint.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ICCPProvidedPoint.fields (position), value)
        emitattr (0, accessPriviledge)
        emitattr (1, pointQuality)
        emitattr (2, pointType)
        emitattr (3, scope)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ICCPProvidedPoint rdf:ID=\"%s\">\n%s\t</cim:ICCPProvidedPoint>".format (id, export_fields)
    }
}

object ICCPProvidedPoint
extends
    Parseable[ICCPProvidedPoint]
{
    override val fields: Array[String] = Array[String] (
        "accessPriviledge",
        "pointQuality",
        "pointType",
        "scope"
    )
    val accessPriviledge: Fielder = parse_attribute (attribute (cls, fields(0)))
    val pointQuality: Fielder = parse_attribute (attribute (cls, fields(1)))
    val pointType: Fielder = parse_attribute (attribute (cls, fields(2)))
    val scope: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): ICCPProvidedPoint =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ICCPProvidedPoint (
            ProvidedBilateralPoint.parse (context),
            mask (accessPriviledge (), 0),
            mask (pointQuality (), 1),
            mask (pointType (), 2),
            mask (scope (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Indicates that the ICCP information is global in nature and normally is available to all authorized peers.
 *
 * @param BilateralExchangeActor [[ch.ninecode.model.BilateralExchangeActor BilateralExchangeActor]] Reference to the superclass object.
 * @group ICCPConfiguration
 * @groupname ICCPConfiguration Package ICCPConfiguration
 * @groupdesc ICCPConfiguration This package models configuration of ICCP required for bilateral exchanges.
 */
final case class ICCPVCC
(
    BilateralExchangeActor: BilateralExchangeActor = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: BilateralExchangeActor = BilateralExchangeActor

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:ICCPVCC rdf:ID=\"%s\">\n%s\t</cim:ICCPVCC>".format (id, export_fields)
    }
}

object ICCPVCC
extends
    Parseable[ICCPVCC]
{

    def parse (context: Context): ICCPVCC =
    {
        val ret = ICCPVCC (
            BilateralExchangeActor.parse (context)
        )
        ret
    }
}

/**
 * This contains the information that a particular actor exposes for a particular agreed upon ICCP Bilateral Table.
 *
 * @param BilateralExchangeActor [[ch.ninecode.model.BilateralExchangeActor BilateralExchangeActor]] Reference to the superclass object.
 * @param applicationSecurityRequirement Specifies the expected security mechanism, per IEC 62351-4, to be utilized.
 * @param calling Used to indicate if the Provider is responsible for initiating the TASE.2 connection.
 *        If the value is TRUE, the provider is responsible for establishing the association.  If the value is FALSE, the peer provider of the Bilateral Table will need to establish the association.
 * @param clientAndServer If True the value indicates that the entity represented by the bilateral table is capable of issuing requests and responding to request (e.g. bidirectional support of ICCP requests).
 *        If False, this indicates that a calling entity (e.g. calling = True) will not be able to respond to ICCP requests.  If False, and calling=False, this indicates that the entity will only respond to ICCP requests and not issue ICCP requests.
 * @param minimumUpdateInterval Specifies the fastest update interval that can be provided for integrity information and Transfer Set creation.
 *        The value is in seconds.
 * @param nameOfLocalICC Specifies the ICC scope name that the remote can use to access the information in the Bilateral Table if the information is not VCC scoped.
 *        This value may not be null.
 * @param supportForBlock1 Per IEC 60870-6-702:  If true indicates support for basic services.
 *        Must always be true.
 * @param supportForBlock2 Per IEC 60870-6-702:  If true indicates support for extended conditions.
 * @param supportForBlock3 Per IEC 60870-6-702:  If true indicates support for blocked transfers.
 * @param supportForBlock4 Per IEC 60870-6-702:  If true indicates support for information messages.
 * @param supportForBlock5 Per IEC 60870-6-702:  If true indicates support for device control.
 * @param supportForDepriciatedBlock8 Per IEC 60870-6-702:  If true indicates support for accounts.
 *        The use of this block was deprecated in Edition 3.
 * @param transportSecurityRequirement If true, then transport level security as specified by IEC 62351-6 is required.
 * @group ICCPConfiguration
 * @groupname ICCPConfiguration Package ICCPConfiguration
 * @groupdesc ICCPConfiguration This package models configuration of ICCP required for bilateral exchanges.
 */
final case class ICCPVirtualControlCentre
(
    BilateralExchangeActor: BilateralExchangeActor = null,
    applicationSecurityRequirement: String = null,
    calling: Boolean = false,
    clientAndServer: Boolean = false,
    minimumUpdateInterval: Int = 0,
    nameOfLocalICC: String = null,
    supportForBlock1: Boolean = false,
    supportForBlock2: Boolean = false,
    supportForBlock3: Boolean = false,
    supportForBlock4: Boolean = false,
    supportForBlock5: Boolean = false,
    supportForDepriciatedBlock8: Boolean = false,
    transportSecurityRequirement: Boolean = false
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: BilateralExchangeActor = BilateralExchangeActor

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ICCPVirtualControlCentre.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ICCPVirtualControlCentre.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ICCPVirtualControlCentre.fields (position), value)
        emitattr (0, applicationSecurityRequirement)
        emitelem (1, calling)
        emitelem (2, clientAndServer)
        emitelem (3, minimumUpdateInterval)
        emitelem (4, nameOfLocalICC)
        emitelem (5, supportForBlock1)
        emitelem (6, supportForBlock2)
        emitelem (7, supportForBlock3)
        emitelem (8, supportForBlock4)
        emitelem (9, supportForBlock5)
        emitelem (10, supportForDepriciatedBlock8)
        emitelem (11, transportSecurityRequirement)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ICCPVirtualControlCentre rdf:ID=\"%s\">\n%s\t</cim:ICCPVirtualControlCentre>".format (id, export_fields)
    }
}

object ICCPVirtualControlCentre
extends
    Parseable[ICCPVirtualControlCentre]
{
    override val fields: Array[String] = Array[String] (
        "applicationSecurityRequirement",
        "calling",
        "clientAndServer",
        "minimumUpdateInterval",
        "nameOfLocalICC",
        "supportForBlock1",
        "supportForBlock2",
        "supportForBlock3",
        "supportForBlock4",
        "supportForBlock5",
        "supportForDepriciatedBlock8",
        "transportSecurityRequirement"
    )
    val applicationSecurityRequirement: Fielder = parse_attribute (attribute (cls, fields(0)))
    val calling: Fielder = parse_element (element (cls, fields(1)))
    val clientAndServer: Fielder = parse_element (element (cls, fields(2)))
    val minimumUpdateInterval: Fielder = parse_element (element (cls, fields(3)))
    val nameOfLocalICC: Fielder = parse_element (element (cls, fields(4)))
    val supportForBlock1: Fielder = parse_element (element (cls, fields(5)))
    val supportForBlock2: Fielder = parse_element (element (cls, fields(6)))
    val supportForBlock3: Fielder = parse_element (element (cls, fields(7)))
    val supportForBlock4: Fielder = parse_element (element (cls, fields(8)))
    val supportForBlock5: Fielder = parse_element (element (cls, fields(9)))
    val supportForDepriciatedBlock8: Fielder = parse_element (element (cls, fields(10)))
    val transportSecurityRequirement: Fielder = parse_element (element (cls, fields(11)))

    def parse (context: Context): ICCPVirtualControlCentre =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ICCPVirtualControlCentre (
            BilateralExchangeActor.parse (context),
            mask (applicationSecurityRequirement (), 0),
            toBoolean (mask (calling (), 1)),
            toBoolean (mask (clientAndServer (), 2)),
            toInteger (mask (minimumUpdateInterval (), 3)),
            mask (nameOfLocalICC (), 4),
            toBoolean (mask (supportForBlock1 (), 5)),
            toBoolean (mask (supportForBlock2 (), 6)),
            toBoolean (mask (supportForBlock3 (), 7)),
            toBoolean (mask (supportForBlock4 (), 8)),
            toBoolean (mask (supportForBlock5 (), 9)),
            toBoolean (mask (supportForDepriciatedBlock8 (), 10)),
            toBoolean (mask (transportSecurityRequirement (), 11))
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Indicates the point source for an IO Point.
 *
 * @param MeasurementValueSource [[ch.ninecode.model.MeasurementValueSource MeasurementValueSource]] Reference to the superclass object.
 * @param IOPoint [[ch.ninecode.model.IOPoint IOPoint]] ICCP point for a local measurement value source.
 * @group ICCPConfiguration
 * @groupname ICCPConfiguration Package ICCPConfiguration
 * @groupdesc ICCPConfiguration This package models configuration of ICCP required for bilateral exchanges.
 */
final case class IOPointSource
(
    MeasurementValueSource: MeasurementValueSource = null,
    IOPoint: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: MeasurementValueSource = MeasurementValueSource

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = IOPointSource.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (IOPointSource.fields (position), x))
        emitattrs (0, IOPoint)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:IOPointSource rdf:ID=\"%s\">\n%s\t</cim:IOPointSource>".format (id, export_fields)
    }
}

object IOPointSource
extends
    Parseable[IOPointSource]
{
    override val fields: Array[String] = Array[String] (
        "IOPoint"
    )
    override val relations: List[Relationship] = List (
        Relationship ("IOPoint", "IOPoint", "0..*", "0..1")
    )
    val IOPoint: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): IOPointSource =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = IOPointSource (
            MeasurementValueSource.parse (context),
            masks (IOPoint (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Internet Protocol Access Point – used to represent an addressing structure is based upon an Internet Protocol (IP) address.
 *
 * @param CommunicationLink [[ch.ninecode.model.CommunicationLink CommunicationLink]] Reference to the superclass object.
 * @param address Is the dotted decimal IP Address resolve the IP address.
 *        The format is controlled by the value of the addressType.
 * @param addressType IP address type.
 * @param gateway Is the dotted decimal IPAddress of the first hop router.
 *        Format is controlled by the addressType.
 * @param subnet This is the IP subnet mask which controls the local vs non-local routing.
 * @group ICCPConfiguration
 * @groupname ICCPConfiguration Package ICCPConfiguration
 * @groupdesc ICCPConfiguration This package models configuration of ICCP required for bilateral exchanges.
 */
final case class IPAccessPoint
(
    CommunicationLink: CommunicationLink = null,
    address: String = null,
    addressType: String = null,
    gateway: String = null,
    subnet: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: CommunicationLink = CommunicationLink

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = IPAccessPoint.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (IPAccessPoint.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (IPAccessPoint.fields (position), value)
        emitelem (0, address)
        emitattr (1, addressType)
        emitelem (2, gateway)
        emitelem (3, subnet)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:IPAccessPoint rdf:ID=\"%s\">\n%s\t</cim:IPAccessPoint>".format (id, export_fields)
    }
}

object IPAccessPoint
extends
    Parseable[IPAccessPoint]
{
    override val fields: Array[String] = Array[String] (
        "address",
        "addressType",
        "gateway",
        "subnet"
    )
    val address: Fielder = parse_element (element (cls, fields(0)))
    val addressType: Fielder = parse_attribute (attribute (cls, fields(1)))
    val gateway: Fielder = parse_element (element (cls, fields(2)))
    val subnet: Fielder = parse_element (element (cls, fields(3)))

    def parse (context: Context): IPAccessPoint =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = IPAccessPoint (
            CommunicationLink.parse (context),
            mask (address (), 0),
            mask (addressType (), 1),
            mask (gateway (), 2),
            mask (subnet (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Is a set of configure addressing information that is required since ICCP utilizes addressing other than a TCP port.
 *
 * @param TCPAccessPoint [[ch.ninecode.model.TCPAccessPoint TCPAccessPoint]] Reference to the superclass object.
 * @param aeInvoke Is part of the Application Entity addressing as specified by ISO Addressing.
 * @param aeQual Is the AE qualifier and represents further application level addressing information.
 * @param apInvoke Is a further application level OSI addressing parameter.
 * @param apTitle Is a sequence of integer strings separated by ".".
 *        The value, in conjunction with other application addressing attributes (e.g. other APs) are used to select a specific application (e.g. the ICCP application entity) per the OSI reference model.  The sequence, and its values, represent a namespace whose values are governed by ISO/IEC 7498-3.
 * @param osiPsel Is the addressing selector for OSI presentation addressing.
 * @param osiSsel Is the OSI session layer addressing information.
 * @param osiTsel Is the OSI Transport Layer addressing information.
 * @param UpperLayerPublicX509Certificate [[ch.ninecode.model.PublicX509Certificate PublicX509Certificate]] Certificate to be bound for use for Application layer mutual authentication.
 * @group ICCPConfiguration
 * @groupname ICCPConfiguration Package ICCPConfiguration
 * @groupdesc ICCPConfiguration This package models configuration of ICCP required for bilateral exchanges.
 */
final case class ISOUpperLayer
(
    TCPAccessPoint: TCPAccessPoint = null,
    aeInvoke: Int = 0,
    aeQual: Int = 0,
    apInvoke: Int = 0,
    apTitle: String = null,
    osiPsel: String = null,
    osiSsel: String = null,
    osiTsel: String = null,
    UpperLayerPublicX509Certificate: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: TCPAccessPoint = TCPAccessPoint

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ISOUpperLayer.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ISOUpperLayer.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (ISOUpperLayer.fields (position), x))
        emitelem (0, aeInvoke)
        emitelem (1, aeQual)
        emitelem (2, apInvoke)
        emitelem (3, apTitle)
        emitelem (4, osiPsel)
        emitelem (5, osiSsel)
        emitelem (6, osiTsel)
        emitattrs (7, UpperLayerPublicX509Certificate)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ISOUpperLayer rdf:ID=\"%s\">\n%s\t</cim:ISOUpperLayer>".format (id, export_fields)
    }
}

object ISOUpperLayer
extends
    Parseable[ISOUpperLayer]
{
    override val fields: Array[String] = Array[String] (
        "aeInvoke",
        "aeQual",
        "apInvoke",
        "apTitle",
        "osiPsel",
        "osiSsel",
        "osiTsel",
        "UpperLayerPublicX509Certificate"
    )
    override val relations: List[Relationship] = List (
        Relationship ("UpperLayerPublicX509Certificate", "PublicX509Certificate", "0..*", "0..1")
    )
    val aeInvoke: Fielder = parse_element (element (cls, fields(0)))
    val aeQual: Fielder = parse_element (element (cls, fields(1)))
    val apInvoke: Fielder = parse_element (element (cls, fields(2)))
    val apTitle: Fielder = parse_element (element (cls, fields(3)))
    val osiPsel: Fielder = parse_element (element (cls, fields(4)))
    val osiSsel: Fielder = parse_element (element (cls, fields(5)))
    val osiTsel: Fielder = parse_element (element (cls, fields(6)))
    val UpperLayerPublicX509Certificate: FielderMultiple = parse_attributes (attribute (cls, fields(7)))

    def parse (context: Context): ISOUpperLayer =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ISOUpperLayer (
            TCPAccessPoint.parse (context),
            toInteger (mask (aeInvoke (), 0)),
            toInteger (mask (aeQual (), 1)),
            toInteger (mask (apInvoke (), 2)),
            mask (apTitle (), 3),
            mask (osiPsel (), 4),
            mask (osiSsel (), 5),
            mask (osiTsel (), 6),
            masks (UpperLayerPublicX509Certificate (), 7)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Allows declaration of ICCP points to be provided through a Bilateral Table agreement.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param BilateralExchangeActor [[ch.ninecode.model.BilateralExchangeActor BilateralExchangeActor]] Remote peer that will receive ICCP information in a Bilateral table.
 * @param IOPoint [[ch.ninecode.model.IOPoint IOPoint]] Measurement or control for the bilateral ICCP point.
 * @group ICCPConfiguration
 * @groupname ICCPConfiguration Package ICCPConfiguration
 * @groupdesc ICCPConfiguration This package models configuration of ICCP required for bilateral exchanges.
 */
final case class ProvidedBilateralPoint
(
    IdentifiedObject: IdentifiedObject = null,
    BilateralExchangeActor: String = null,
    IOPoint: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ProvidedBilateralPoint.cls
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ProvidedBilateralPoint.fields (position), value)
        emitattr (0, BilateralExchangeActor)
        emitattr (1, IOPoint)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ProvidedBilateralPoint rdf:ID=\"%s\">\n%s\t</cim:ProvidedBilateralPoint>".format (id, export_fields)
    }
}

object ProvidedBilateralPoint
extends
    Parseable[ProvidedBilateralPoint]
{
    override val fields: Array[String] = Array[String] (
        "BilateralExchangeActor",
        "IOPoint"
    )
    override val relations: List[Relationship] = List (
        Relationship ("BilateralExchangeActor", "BilateralExchangeActor", "1", "0..*"),
        Relationship ("IOPoint", "IOPoint", "0..1", "0..*")
    )
    val BilateralExchangeActor: Fielder = parse_attribute (attribute (cls, fields(0)))
    val IOPoint: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: Context): ProvidedBilateralPoint =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ProvidedBilateralPoint (
            IdentifiedObject.parse (context),
            mask (BilateralExchangeActor (), 0),
            mask (IOPoint (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Used to convey information that will allow matching in order to determine which certificate to use.
 *
 * Actual certificates are exchanged externally to the CIM exchange.
 *
 * @param Element Reference to the superclass object.
 * @param issuerName Represents the CA that issued the certificate.
 *        Defined to be per X.509.
 * @param serialNumber Is the serial number of the certificate per X.509 definition.
 * @param ISOUpperLayer [[ch.ninecode.model.ISOUpperLayer ISOUpperLayer]] Application layer used with the certificate for mutual authentication.
 * @param TCPAccessPoint [[ch.ninecode.model.TCPAccessPoint TCPAccessPoint]] The association allows a certificate to be bound for use by TLS.
 * @group ICCPConfiguration
 * @groupname ICCPConfiguration Package ICCPConfiguration
 * @groupdesc ICCPConfiguration This package models configuration of ICCP required for bilateral exchanges.
 */
final case class PublicX509Certificate
(
    Element: BasicElement = null,
    issuerName: String = null,
    serialNumber: String = null,
    ISOUpperLayer: String = null,
    TCPAccessPoint: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = PublicX509Certificate.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PublicX509Certificate.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (PublicX509Certificate.fields (position), value)
        emitelem (0, issuerName)
        emitelem (1, serialNumber)
        emitattr (2, ISOUpperLayer)
        emitattr (3, TCPAccessPoint)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PublicX509Certificate rdf:ID=\"%s\">\n%s\t</cim:PublicX509Certificate>".format (id, export_fields)
    }
}

object PublicX509Certificate
extends
    Parseable[PublicX509Certificate]
{
    override val fields: Array[String] = Array[String] (
        "issuerName",
        "serialNumber",
        "ISOUpperLayer",
        "TCPAccessPoint"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ISOUpperLayer", "ISOUpperLayer", "0..1", "0..*"),
        Relationship ("TCPAccessPoint", "TCPAccessPoint", "0..1", "0..*")
    )
    val issuerName: Fielder = parse_element (element (cls, fields(0)))
    val serialNumber: Fielder = parse_element (element (cls, fields(1)))
    val ISOUpperLayer: Fielder = parse_attribute (attribute (cls, fields(2)))
    val TCPAccessPoint: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: Context): PublicX509Certificate =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PublicX509Certificate (
            BasicElement.parse (context),
            mask (issuerName (), 0),
            mask (serialNumber (), 1),
            mask (ISOUpperLayer (), 2),
            mask (TCPAccessPoint (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This class describe the sending (providing) side in a bilateral ICCP data exchange.
 *
 * Hence the ICCP bilateral (table) descriptions are created by exchanging ICCP Provider data between the parties.
 *
 * @param BilateralExchangeAgreement [[ch.ninecode.model.BilateralExchangeAgreement BilateralExchangeAgreement]] Reference to the superclass object.
 * @param bilateralTableID Specifies the version of the Bilateral Table configuration that is being exchanged.
 * @param bilateralTableVersion The Version attribute identifies a unique version of the Bilateral Table.
 *        If any changes are made to a Bilateral Table, then a new unique value for this attribute shall be generated.
 * @param tase2version Specifies the version of the TASE.2 that is needed to access the Bilateral Table information via TASE.2.
 *        In order for a link to be established, both sides must have the same value.
 * @param ICCPInformationMessage [[ch.ninecode.model.ICCPInformationMessage ICCPInformationMessage]] Informational message to be included in a Bilateral Table agreement.
 * @group ICCPConfiguration
 * @groupname ICCPConfiguration Package ICCPConfiguration
 * @groupdesc ICCPConfiguration This package models configuration of ICCP required for bilateral exchanges.
 */
final case class TASE2BilateralTable
(
    BilateralExchangeAgreement: BilateralExchangeAgreement = null,
    bilateralTableID: String = null,
    bilateralTableVersion: String = null,
    tase2version: String = null,
    ICCPInformationMessage: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: BilateralExchangeAgreement = BilateralExchangeAgreement

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TASE2BilateralTable.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TASE2BilateralTable.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TASE2BilateralTable.fields (position), x))
        emitelem (0, bilateralTableID)
        emitelem (1, bilateralTableVersion)
        emitelem (2, tase2version)
        emitattrs (3, ICCPInformationMessage)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TASE2BilateralTable rdf:ID=\"%s\">\n%s\t</cim:TASE2BilateralTable>".format (id, export_fields)
    }
}

object TASE2BilateralTable
extends
    Parseable[TASE2BilateralTable]
{
    override val fields: Array[String] = Array[String] (
        "bilateralTableID",
        "bilateralTableVersion",
        "tase2version",
        "ICCPInformationMessage"
    )
    override val relations: List[Relationship] = List (
        Relationship ("ICCPInformationMessage", "ICCPInformationMessage", "0..*", "0..*")
    )
    val bilateralTableID: Fielder = parse_element (element (cls, fields(0)))
    val bilateralTableVersion: Fielder = parse_element (element (cls, fields(1)))
    val tase2version: Fielder = parse_element (element (cls, fields(2)))
    val ICCPInformationMessage: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: Context): TASE2BilateralTable =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TASE2BilateralTable (
            BilateralExchangeAgreement.parse (context),
            mask (bilateralTableID (), 0),
            mask (bilateralTableVersion (), 1),
            mask (tase2version (), 2),
            masks (ICCPInformationMessage (), 3)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * Allows addressing and behavioural information regarding the use of TCP by ICCP links.
 *
 * @param IPAccessPoint [[ch.ninecode.model.IPAccessPoint IPAccessPoint]] Reference to the superclass object.
 * @param keepAliveTime Indicates the default interval at which TCP will check if the TCP connection is still valid.
 * @param port This value is only needed to be specified for called nodes (e.g. those that respond to a TCP.
 *        Open request).
 *        
 *        This value specifies the TCP port to be used. Well known and "registered" ports are preferred and can be found at:
 *        http://www.iana.org/assignments/service-names-port-numbers/service-names-port-numbers.xhtml
 *        
 *        For IEC 60870-6 TASE.2 (e.g. ICCP) and IEC 61850, the value used shall be 102 for non-TLS protected exchanges. The value shall be 3782 for TLS transported ICCP and 61850 exchanges.
 * @param PublicX509Certificate [[ch.ninecode.model.PublicX509Certificate PublicX509Certificate]] Is the Public Certificate used for mutual authentication between peers.
 * @group ICCPConfiguration
 * @groupname ICCPConfiguration Package ICCPConfiguration
 * @groupdesc ICCPConfiguration This package models configuration of ICCP required for bilateral exchanges.
 */
final case class TCPAccessPoint
(
    IPAccessPoint: IPAccessPoint = null,
    keepAliveTime: Int = 0,
    port: Int = 0,
    PublicX509Certificate: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IPAccessPoint = IPAccessPoint

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TCPAccessPoint.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TCPAccessPoint.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (TCPAccessPoint.fields (position), x))
        emitelem (0, keepAliveTime)
        emitelem (1, port)
        emitattrs (2, PublicX509Certificate)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TCPAccessPoint rdf:ID=\"%s\">\n%s\t</cim:TCPAccessPoint>".format (id, export_fields)
    }
}

object TCPAccessPoint
extends
    Parseable[TCPAccessPoint]
{
    override val fields: Array[String] = Array[String] (
        "keepAliveTime",
        "port",
        "PublicX509Certificate"
    )
    override val relations: List[Relationship] = List (
        Relationship ("PublicX509Certificate", "PublicX509Certificate", "0..*", "0..1")
    )
    val keepAliveTime: Fielder = parse_element (element (cls, fields(0)))
    val port: Fielder = parse_element (element (cls, fields(1)))
    val PublicX509Certificate: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: Context): TCPAccessPoint =
    {
        implicit val ctx: Context = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TCPAccessPoint (
            IPAccessPoint.parse (context),
            toInteger (mask (keepAliveTime (), 0)),
            toInteger (mask (port (), 1)),
            masks (PublicX509Certificate (), 2)
        )
        ret.bitfields = bitfields
        ret
    }
}

private[ninecode] object _ICCPConfiguration
{
    def register: List[ClassInfo] =
    {
        List (
            BilateralExchangeActor.register,
            BilateralExchangeAgreement.register,
            ICCPInformationMessage.register,
            ICCPProvidedPoint.register,
            ICCPVCC.register,
            ICCPVirtualControlCentre.register,
            IOPointSource.register,
            IPAccessPoint.register,
            ISOUpperLayer.register,
            ProvidedBilateralPoint.register,
            PublicX509Certificate.register,
            TASE2BilateralTable.register,
            TCPAccessPoint.register
        )
    }
}
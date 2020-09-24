package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.Serializer
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship
import ch.ninecode.cim.CIMSerializer

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
        "\t<cim:BilateralExchangeActor rdf:%s=\"%s\">\n%s\t</cim:BilateralExchangeActor>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object BilateralExchangeActor
extends
    CIMParseable[BilateralExchangeActor]
{
    override val fields: Array[String] = Array[String] (
        "CommunicationLink",
        "ConsumerBilateralExchange",
        "ProvidedBilateralIOPoint",
        "ProviderBilateralExchange"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("CommunicationLink", "CommunicationLink", "0..n", "0..1"),
        CIMRelationship ("ConsumerBilateralExchange", "BilateralExchangeAgreement", "0..*", "0..1"),
        CIMRelationship ("ProvidedBilateralIOPoint", "ProvidedBilateralPoint", "0..*", "1"),
        CIMRelationship ("ProviderBilateralExchange", "BilateralExchangeAgreement", "0..*", "1")
    )
    val CommunicationLink: FielderMultiple = parse_attributes (attribute (cls, fields(0)))
    val ConsumerBilateralExchange: FielderMultiple = parse_attributes (attribute (cls, fields(1)))
    val ProvidedBilateralIOPoint: FielderMultiple = parse_attributes (attribute (cls, fields(2)))
    val ProviderBilateralExchange: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: CIMContext): BilateralExchangeActor =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[BilateralExchangeActor] = BilateralExchangeActorSerializer
}

object BilateralExchangeActorSerializer extends CIMSerializer[BilateralExchangeActor]
{
    def write (kryo: Kryo, output: Output, obj: BilateralExchangeActor): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.CommunicationLink, output),
            () => writeList (obj.ConsumerBilateralExchange, output),
            () => writeList (obj.ProvidedBilateralIOPoint, output),
            () => writeList (obj.ProviderBilateralExchange, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[BilateralExchangeActor]): BilateralExchangeActor =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = BilateralExchangeActor (
            parent,
            if (isSet (0)) readList (input) else null,
            if (isSet (1)) readList (input) else null,
            if (isSet (2)) readList (input) else null,
            if (isSet (3)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
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
        "\t<cim:BilateralExchangeAgreement rdf:%s=\"%s\">\n%s\t</cim:BilateralExchangeAgreement>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object BilateralExchangeAgreement
extends
    CIMParseable[BilateralExchangeAgreement]
{
    override val fields: Array[String] = Array[String] (
        "Consumer",
        "Provider"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Consumer", "BilateralExchangeActor", "0..1", "0..*"),
        CIMRelationship ("Provider", "BilateralExchangeActor", "1", "0..*")
    )
    val Consumer: Fielder = parse_attribute (attribute (cls, fields(0)))
    val Provider: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): BilateralExchangeAgreement =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = BilateralExchangeAgreement (
            IdentifiedObject.parse (context),
            mask (Consumer (), 0),
            mask (Provider (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[BilateralExchangeAgreement] = BilateralExchangeAgreementSerializer
}

object BilateralExchangeAgreementSerializer extends CIMSerializer[BilateralExchangeAgreement]
{
    def write (kryo: Kryo, output: Output, obj: BilateralExchangeAgreement): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.Consumer),
            () => output.writeString (obj.Provider)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[BilateralExchangeAgreement]): BilateralExchangeAgreement =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = BilateralExchangeAgreement (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
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
        "\t<cim:ICCPInformationMessage rdf:%s=\"%s\">\n%s\t</cim:ICCPInformationMessage>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object ICCPInformationMessage
extends
    CIMParseable[ICCPInformationMessage]
{
    override val fields: Array[String] = Array[String] (
        "localReference",
        "scope",
        "TASE2BilateralTable"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("TASE2BilateralTable", "TASE2BilateralTable", "0..*", "0..*")
    )
    val localReference: Fielder = parse_element (element (cls, fields(0)))
    val scope: Fielder = parse_attribute (attribute (cls, fields(1)))
    val TASE2BilateralTable: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: CIMContext): ICCPInformationMessage =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[ICCPInformationMessage] = ICCPInformationMessageSerializer
}

object ICCPInformationMessageSerializer extends CIMSerializer[ICCPInformationMessage]
{
    def write (kryo: Kryo, output: Output, obj: ICCPInformationMessage): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.localReference),
            () => output.writeString (obj.scope),
            () => writeList (obj.TASE2BilateralTable, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ICCPInformationMessage]): ICCPInformationMessage =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ICCPInformationMessage (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
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
        "\t<cim:ICCPProvidedPoint rdf:%s=\"%s\">\n%s\t</cim:ICCPProvidedPoint>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object ICCPProvidedPoint
extends
    CIMParseable[ICCPProvidedPoint]
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

    def parse (context: CIMContext): ICCPProvidedPoint =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[ICCPProvidedPoint] = ICCPProvidedPointSerializer
}

object ICCPProvidedPointSerializer extends CIMSerializer[ICCPProvidedPoint]
{
    def write (kryo: Kryo, output: Output, obj: ICCPProvidedPoint): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.accessPriviledge),
            () => output.writeString (obj.pointQuality),
            () => output.writeString (obj.pointType),
            () => output.writeString (obj.scope)
        )
        ProvidedBilateralPointSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ICCPProvidedPoint]): ICCPProvidedPoint =
    {
        val parent = ProvidedBilateralPointSerializer.read (kryo, input, classOf[ProvidedBilateralPoint])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ICCPProvidedPoint (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
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
        "\t<cim:ICCPVCC rdf:%s=\"%s\">\n%s\t</cim:ICCPVCC>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object ICCPVCC
extends
    CIMParseable[ICCPVCC]
{

    def parse (context: CIMContext): ICCPVCC =
    {
        val ret = ICCPVCC (
            BilateralExchangeActor.parse (context)
        )
        ret
    }

    def serializer: Serializer[ICCPVCC] = ICCPVCCSerializer
}

object ICCPVCCSerializer extends CIMSerializer[ICCPVCC]
{
    def write (kryo: Kryo, output: Output, obj: ICCPVCC): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (

        )
        BilateralExchangeActorSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ICCPVCC]): ICCPVCC =
    {
        val parent = BilateralExchangeActorSerializer.read (kryo, input, classOf[BilateralExchangeActor])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ICCPVCC (
            parent
        )
        obj.bitfields = bitfields
        obj
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
        "\t<cim:ICCPVirtualControlCentre rdf:%s=\"%s\">\n%s\t</cim:ICCPVirtualControlCentre>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object ICCPVirtualControlCentre
extends
    CIMParseable[ICCPVirtualControlCentre]
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

    def parse (context: CIMContext): ICCPVirtualControlCentre =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[ICCPVirtualControlCentre] = ICCPVirtualControlCentreSerializer
}

object ICCPVirtualControlCentreSerializer extends CIMSerializer[ICCPVirtualControlCentre]
{
    def write (kryo: Kryo, output: Output, obj: ICCPVirtualControlCentre): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.applicationSecurityRequirement),
            () => output.writeBoolean (obj.calling),
            () => output.writeBoolean (obj.clientAndServer),
            () => output.writeInt (obj.minimumUpdateInterval),
            () => output.writeString (obj.nameOfLocalICC),
            () => output.writeBoolean (obj.supportForBlock1),
            () => output.writeBoolean (obj.supportForBlock2),
            () => output.writeBoolean (obj.supportForBlock3),
            () => output.writeBoolean (obj.supportForBlock4),
            () => output.writeBoolean (obj.supportForBlock5),
            () => output.writeBoolean (obj.supportForDepriciatedBlock8),
            () => output.writeBoolean (obj.transportSecurityRequirement)
        )
        BilateralExchangeActorSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ICCPVirtualControlCentre]): ICCPVirtualControlCentre =
    {
        val parent = BilateralExchangeActorSerializer.read (kryo, input, classOf[BilateralExchangeActor])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ICCPVirtualControlCentre (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readBoolean else false,
            if (isSet (2)) input.readBoolean else false,
            if (isSet (3)) input.readInt else 0,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readBoolean else false,
            if (isSet (6)) input.readBoolean else false,
            if (isSet (7)) input.readBoolean else false,
            if (isSet (8)) input.readBoolean else false,
            if (isSet (9)) input.readBoolean else false,
            if (isSet (10)) input.readBoolean else false,
            if (isSet (11)) input.readBoolean else false
        )
        obj.bitfields = bitfields
        obj
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
        "\t<cim:IOPointSource rdf:%s=\"%s\">\n%s\t</cim:IOPointSource>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object IOPointSource
extends
    CIMParseable[IOPointSource]
{
    override val fields: Array[String] = Array[String] (
        "IOPoint"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("IOPoint", "IOPoint", "0..*", "0..1")
    )
    val IOPoint: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): IOPointSource =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = IOPointSource (
            MeasurementValueSource.parse (context),
            masks (IOPoint (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[IOPointSource] = IOPointSourceSerializer
}

object IOPointSourceSerializer extends CIMSerializer[IOPointSource]
{
    def write (kryo: Kryo, output: Output, obj: IOPointSource): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.IOPoint, output)
        )
        MeasurementValueSourceSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[IOPointSource]): IOPointSource =
    {
        val parent = MeasurementValueSourceSerializer.read (kryo, input, classOf[MeasurementValueSource])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = IOPointSource (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
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
        "\t<cim:IPAccessPoint rdf:%s=\"%s\">\n%s\t</cim:IPAccessPoint>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object IPAccessPoint
extends
    CIMParseable[IPAccessPoint]
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

    def parse (context: CIMContext): IPAccessPoint =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[IPAccessPoint] = IPAccessPointSerializer
}

object IPAccessPointSerializer extends CIMSerializer[IPAccessPoint]
{
    def write (kryo: Kryo, output: Output, obj: IPAccessPoint): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.address),
            () => output.writeString (obj.addressType),
            () => output.writeString (obj.gateway),
            () => output.writeString (obj.subnet)
        )
        CommunicationLinkSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[IPAccessPoint]): IPAccessPoint =
    {
        val parent = CommunicationLinkSerializer.read (kryo, input, classOf[CommunicationLink])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = IPAccessPoint (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
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
        "\t<cim:ISOUpperLayer rdf:%s=\"%s\">\n%s\t</cim:ISOUpperLayer>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object ISOUpperLayer
extends
    CIMParseable[ISOUpperLayer]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("UpperLayerPublicX509Certificate", "PublicX509Certificate", "0..*", "0..1")
    )
    val aeInvoke: Fielder = parse_element (element (cls, fields(0)))
    val aeQual: Fielder = parse_element (element (cls, fields(1)))
    val apInvoke: Fielder = parse_element (element (cls, fields(2)))
    val apTitle: Fielder = parse_element (element (cls, fields(3)))
    val osiPsel: Fielder = parse_element (element (cls, fields(4)))
    val osiSsel: Fielder = parse_element (element (cls, fields(5)))
    val osiTsel: Fielder = parse_element (element (cls, fields(6)))
    val UpperLayerPublicX509Certificate: FielderMultiple = parse_attributes (attribute (cls, fields(7)))

    def parse (context: CIMContext): ISOUpperLayer =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[ISOUpperLayer] = ISOUpperLayerSerializer
}

object ISOUpperLayerSerializer extends CIMSerializer[ISOUpperLayer]
{
    def write (kryo: Kryo, output: Output, obj: ISOUpperLayer): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeInt (obj.aeInvoke),
            () => output.writeInt (obj.aeQual),
            () => output.writeInt (obj.apInvoke),
            () => output.writeString (obj.apTitle),
            () => output.writeString (obj.osiPsel),
            () => output.writeString (obj.osiSsel),
            () => output.writeString (obj.osiTsel),
            () => writeList (obj.UpperLayerPublicX509Certificate, output)
        )
        TCPAccessPointSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ISOUpperLayer]): ISOUpperLayer =
    {
        val parent = TCPAccessPointSerializer.read (kryo, input, classOf[TCPAccessPoint])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ISOUpperLayer (
            parent,
            if (isSet (0)) input.readInt else 0,
            if (isSet (1)) input.readInt else 0,
            if (isSet (2)) input.readInt else 0,
            if (isSet (3)) input.readString else null,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) input.readString else null,
            if (isSet (7)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
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
        "\t<cim:ProvidedBilateralPoint rdf:%s=\"%s\">\n%s\t</cim:ProvidedBilateralPoint>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object ProvidedBilateralPoint
extends
    CIMParseable[ProvidedBilateralPoint]
{
    override val fields: Array[String] = Array[String] (
        "BilateralExchangeActor",
        "IOPoint"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("BilateralExchangeActor", "BilateralExchangeActor", "1", "0..*"),
        CIMRelationship ("IOPoint", "IOPoint", "0..1", "0..*")
    )
    val BilateralExchangeActor: Fielder = parse_attribute (attribute (cls, fields(0)))
    val IOPoint: Fielder = parse_attribute (attribute (cls, fields(1)))

    def parse (context: CIMContext): ProvidedBilateralPoint =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ProvidedBilateralPoint (
            IdentifiedObject.parse (context),
            mask (BilateralExchangeActor (), 0),
            mask (IOPoint (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ProvidedBilateralPoint] = ProvidedBilateralPointSerializer
}

object ProvidedBilateralPointSerializer extends CIMSerializer[ProvidedBilateralPoint]
{
    def write (kryo: Kryo, output: Output, obj: ProvidedBilateralPoint): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.BilateralExchangeActor),
            () => output.writeString (obj.IOPoint)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ProvidedBilateralPoint]): ProvidedBilateralPoint =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = ProvidedBilateralPoint (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
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
        "\t<cim:PublicX509Certificate rdf:%s=\"%s\">\n%s\t</cim:PublicX509Certificate>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object PublicX509Certificate
extends
    CIMParseable[PublicX509Certificate]
{
    override val fields: Array[String] = Array[String] (
        "issuerName",
        "serialNumber",
        "ISOUpperLayer",
        "TCPAccessPoint"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ISOUpperLayer", "ISOUpperLayer", "0..1", "0..*"),
        CIMRelationship ("TCPAccessPoint", "TCPAccessPoint", "0..1", "0..*")
    )
    val issuerName: Fielder = parse_element (element (cls, fields(0)))
    val serialNumber: Fielder = parse_element (element (cls, fields(1)))
    val ISOUpperLayer: Fielder = parse_attribute (attribute (cls, fields(2)))
    val TCPAccessPoint: Fielder = parse_attribute (attribute (cls, fields(3)))

    def parse (context: CIMContext): PublicX509Certificate =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[PublicX509Certificate] = PublicX509CertificateSerializer
}

object PublicX509CertificateSerializer extends CIMSerializer[PublicX509Certificate]
{
    def write (kryo: Kryo, output: Output, obj: PublicX509Certificate): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.issuerName),
            () => output.writeString (obj.serialNumber),
            () => output.writeString (obj.ISOUpperLayer),
            () => output.writeString (obj.TCPAccessPoint)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PublicX509Certificate]): PublicX509Certificate =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PublicX509Certificate (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
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
        "\t<cim:TASE2BilateralTable rdf:%s=\"%s\">\n%s\t</cim:TASE2BilateralTable>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object TASE2BilateralTable
extends
    CIMParseable[TASE2BilateralTable]
{
    override val fields: Array[String] = Array[String] (
        "bilateralTableID",
        "bilateralTableVersion",
        "tase2version",
        "ICCPInformationMessage"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("ICCPInformationMessage", "ICCPInformationMessage", "0..*", "0..*")
    )
    val bilateralTableID: Fielder = parse_element (element (cls, fields(0)))
    val bilateralTableVersion: Fielder = parse_element (element (cls, fields(1)))
    val tase2version: Fielder = parse_element (element (cls, fields(2)))
    val ICCPInformationMessage: FielderMultiple = parse_attributes (attribute (cls, fields(3)))

    def parse (context: CIMContext): TASE2BilateralTable =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[TASE2BilateralTable] = TASE2BilateralTableSerializer
}

object TASE2BilateralTableSerializer extends CIMSerializer[TASE2BilateralTable]
{
    def write (kryo: Kryo, output: Output, obj: TASE2BilateralTable): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.bilateralTableID),
            () => output.writeString (obj.bilateralTableVersion),
            () => output.writeString (obj.tase2version),
            () => writeList (obj.ICCPInformationMessage, output)
        )
        BilateralExchangeAgreementSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TASE2BilateralTable]): TASE2BilateralTable =
    {
        val parent = BilateralExchangeAgreementSerializer.read (kryo, input, classOf[BilateralExchangeAgreement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TASE2BilateralTable (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null,
            if (isSet (2)) input.readString else null,
            if (isSet (3)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
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
        "\t<cim:TCPAccessPoint rdf:%s=\"%s\">\n%s\t</cim:TCPAccessPoint>".format (if (about) "about" else "ID", id, export_fields)
    }
}

object TCPAccessPoint
extends
    CIMParseable[TCPAccessPoint]
{
    override val fields: Array[String] = Array[String] (
        "keepAliveTime",
        "port",
        "PublicX509Certificate"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("PublicX509Certificate", "PublicX509Certificate", "0..*", "0..1")
    )
    val keepAliveTime: Fielder = parse_element (element (cls, fields(0)))
    val port: Fielder = parse_element (element (cls, fields(1)))
    val PublicX509Certificate: FielderMultiple = parse_attributes (attribute (cls, fields(2)))

    def parse (context: CIMContext): TCPAccessPoint =
    {
        implicit val ctx: CIMContext = context
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

    def serializer: Serializer[TCPAccessPoint] = TCPAccessPointSerializer
}

object TCPAccessPointSerializer extends CIMSerializer[TCPAccessPoint]
{
    def write (kryo: Kryo, output: Output, obj: TCPAccessPoint): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeInt (obj.keepAliveTime),
            () => output.writeInt (obj.port),
            () => writeList (obj.PublicX509Certificate, output)
        )
        IPAccessPointSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TCPAccessPoint]): TCPAccessPoint =
    {
        val parent = IPAccessPointSerializer.read (kryo, input, classOf[IPAccessPoint])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TCPAccessPoint (
            parent,
            if (isSet (0)) input.readInt else 0,
            if (isSet (1)) input.readInt else 0,
            if (isSet (2)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _ICCPConfiguration
{
    def register: List[CIMClassInfo] =
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
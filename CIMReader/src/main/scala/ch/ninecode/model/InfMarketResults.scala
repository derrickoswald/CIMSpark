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
 * Model of market clearing related to results at the inter-ties.
 *
 * Identifies interval
 *
 * @param MarketFactors   [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param InterTieResults [[ch.ninecode.model.InterTieResults InterTieResults]] <em>undocumented</em>
 * @group InfMarketResults
 * @groupname InfMarketResults Package InfMarketResults
 */
final case class InterTieClearing
(
    MarketFactors: MarketFactors = null,
    InterTieResults: List[String] = null
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
    override def sup: MarketFactors = MarketFactors

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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = InterTieClearing.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(InterTieClearing.fields(position), x))

        emitattrs(0, InterTieResults)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:InterTieClearing rdf:%s=\"%s\">\n%s\t</cim:InterTieClearing>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object InterTieClearing
    extends
        CIMParseable[InterTieClearing]
{
    override val fields: Array[String] = Array[String](
        "InterTieResults"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("InterTieResults", "InterTieResults", "0..*", "0..1")
    )
    val InterTieResults: FielderMultiple = parse_attributes(attribute(cls, fields(0)))

    def parse (context: CIMContext): InterTieClearing =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = InterTieClearing(
            MarketFactors.parse(context),
            masks(InterTieResults(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[InterTieClearing] = InterTieClearingSerializer
}

object InterTieClearingSerializer extends CIMSerializer[InterTieClearing]
{
    def write (kryo: Kryo, output: Output, obj: InterTieClearing): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => writeList(obj.InterTieResults, output)
        )
        MarketFactorsSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[InterTieClearing]): InterTieClearing =
    {
        val parent = MarketFactorsSerializer.read(kryo, input, classOf[MarketFactors])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = InterTieClearing(
            parent,
            if (isSet(0)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Provides the tie point specific output from the market applications.
 *
 * Currently, this is defined as the loop flow compensation MW value.
 *
 * @param Element          Reference to the superclass object.
 * @param baseMW           Net Actual MW Flow
 * @param clearedValue     Net Dispatched MW
 * @param Flowgate         [[ch.ninecode.model.Flowgate Flowgate]] <em>undocumented</em>
 * @param InterTieClearing [[ch.ninecode.model.InterTieClearing InterTieClearing]] <em>undocumented</em>
 * @group InfMarketResults
 * @groupname InfMarketResults Package InfMarketResults
 */
final case class InterTieResults
(
    Element: BasicElement = null,
    baseMW: Double = 0.0,
    clearedValue: Double = 0.0,
    Flowgate: String = null,
    InterTieClearing: String = null
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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = InterTieResults.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(InterTieResults.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(InterTieResults.fields(position), value)

        emitelem(0, baseMW)
        emitelem(1, clearedValue)
        emitattr(2, Flowgate)
        emitattr(3, InterTieClearing)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:InterTieResults rdf:%s=\"%s\">\n%s\t</cim:InterTieResults>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object InterTieResults
    extends
        CIMParseable[InterTieResults]
{
    override val fields: Array[String] = Array[String](
        "baseMW",
        "clearedValue",
        "Flowgate",
        "InterTieClearing"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("Flowgate", "Flowgate", "1", "1..*"),
        CIMRelationship("InterTieClearing", "InterTieClearing", "0..1", "0..*")
    )
    val baseMW: Fielder = parse_element(element(cls, fields(0)))
    val clearedValue: Fielder = parse_element(element(cls, fields(1)))
    val Flowgate: Fielder = parse_attribute(attribute(cls, fields(2)))
    val InterTieClearing: Fielder = parse_attribute(attribute(cls, fields(3)))

    def parse (context: CIMContext): InterTieResults =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = InterTieResults(
            BasicElement.parse(context),
            toDouble(mask(baseMW(), 0)),
            toDouble(mask(clearedValue(), 1)),
            mask(Flowgate(), 2),
            mask(InterTieClearing(), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[InterTieResults] = InterTieResultsSerializer
}

object InterTieResultsSerializer extends CIMSerializer[InterTieResults]
{
    def write (kryo: Kryo, output: Output, obj: InterTieResults): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.baseMW),
            () => output.writeDouble(obj.clearedValue),
            () => output.writeString(obj.Flowgate),
            () => output.writeString(obj.InterTieClearing)
        )
        BasicElementSerializer.write(kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[InterTieResults]): InterTieResults =
    {
        val parent = BasicElementSerializer.read(kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = InterTieResults(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readString else null,
            if (isSet(3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Market case clearing results are posted for a given settlement period.
 *
 * @param MarketFactors         [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param caseType              Settlement period:
 *                              'DA - Bid-in'
 *                              'DA - Reliability'
 *                              'DA - Amp1'
 *                              'DA - Amp2'
 *                              'RT - Ex-Ante'
 *                              'RT - Ex-Post'
 *                              'RT - Amp1'
 *                              'RT - Amp2'
 * @param modifiedDate          Last time and date clearing results were manually modified.
 * @param postedDate            Bid clearing results posted time and date.
 * @param MarketProductClearing [[ch.ninecode.model.AncillaryServiceClearing AncillaryServiceClearing]] <em>undocumented</em>
 * @group InfMarketResults
 * @groupname InfMarketResults Package InfMarketResults
 */
final case class MarketCaseClearing
(
    MarketFactors: MarketFactors = null,
    caseType: String = null,
    modifiedDate: String = null,
    postedDate: String = null,
    MarketProductClearing: List[String] = null
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
    override def sup: MarketFactors = MarketFactors

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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = MarketCaseClearing.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(MarketCaseClearing.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(MarketCaseClearing.fields(position), x))

        emitelem(0, caseType)
        emitelem(1, modifiedDate)
        emitelem(2, postedDate)
        emitattrs(3, MarketProductClearing)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:MarketCaseClearing rdf:%s=\"%s\">\n%s\t</cim:MarketCaseClearing>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object MarketCaseClearing
    extends
        CIMParseable[MarketCaseClearing]
{
    override val fields: Array[String] = Array[String](
        "caseType",
        "modifiedDate",
        "postedDate",
        "MarketProductClearing"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("MarketProductClearing", "AncillaryServiceClearing", "0..*", "0..1")
    )
    val caseType: Fielder = parse_element(element(cls, fields(0)))
    val modifiedDate: Fielder = parse_element(element(cls, fields(1)))
    val postedDate: Fielder = parse_element(element(cls, fields(2)))
    val MarketProductClearing: FielderMultiple = parse_attributes(attribute(cls, fields(3)))

    def parse (context: CIMContext): MarketCaseClearing =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = MarketCaseClearing(
            MarketFactors.parse(context),
            mask(caseType(), 0),
            mask(modifiedDate(), 1),
            mask(postedDate(), 2),
            masks(MarketProductClearing(), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[MarketCaseClearing] = MarketCaseClearingSerializer
}

object MarketCaseClearingSerializer extends CIMSerializer[MarketCaseClearing]
{
    def write (kryo: Kryo, output: Output, obj: MarketCaseClearing): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.caseType),
            () => output.writeString(obj.modifiedDate),
            () => output.writeString(obj.postedDate),
            () => writeList(obj.MarketProductClearing, output)
        )
        MarketFactorsSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[MarketCaseClearing]): MarketCaseClearing =
    {
        val parent = MarketFactorsSerializer.read(kryo, input, classOf[MarketFactors])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = MarketCaseClearing(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null,
            if (isSet(2)) input.readString else null,
            if (isSet(3)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Binding security constrained clearing results posted for a given settlement period.
 *
 * @param MarketFactors [[ch.ninecode.model.MarketFactors MarketFactors]] Reference to the superclass object.
 * @param mwFlow        Optimal MW flow
 * @param mwLimit       Binding MW limit.
 * @param shadowPrice   Security constraint shadow price.
 * @group InfMarketResults
 * @groupname InfMarketResults Package InfMarketResults
 */
final case class SecurityConstraintsClearing
(
    MarketFactors: MarketFactors = null,
    mwFlow: Double = 0.0,
    mwLimit: Double = 0.0,
    shadowPrice: Double = 0.0
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
    override def sup: MarketFactors = MarketFactors

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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = SecurityConstraintsClearing.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(SecurityConstraintsClearing.fields(position), value)

        emitelem(0, mwFlow)
        emitelem(1, mwLimit)
        emitelem(2, shadowPrice)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:SecurityConstraintsClearing rdf:%s=\"%s\">\n%s\t</cim:SecurityConstraintsClearing>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object SecurityConstraintsClearing
    extends
        CIMParseable[SecurityConstraintsClearing]
{
    override val fields: Array[String] = Array[String](
        "mwFlow",
        "mwLimit",
        "shadowPrice"
    )
    val mwFlow: Fielder = parse_element(element(cls, fields(0)))
    val mwLimit: Fielder = parse_element(element(cls, fields(1)))
    val shadowPrice: Fielder = parse_element(element(cls, fields(2)))

    def parse (context: CIMContext): SecurityConstraintsClearing =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = SecurityConstraintsClearing(
            MarketFactors.parse(context),
            toDouble(mask(mwFlow(), 0)),
            toDouble(mask(mwLimit(), 1)),
            toDouble(mask(shadowPrice(), 2))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[SecurityConstraintsClearing] = SecurityConstraintsClearingSerializer
}

object SecurityConstraintsClearingSerializer extends CIMSerializer[SecurityConstraintsClearing]
{
    def write (kryo: Kryo, output: Output, obj: SecurityConstraintsClearing): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.mwFlow),
            () => output.writeDouble(obj.mwLimit),
            () => output.writeDouble(obj.shadowPrice)
        )
        MarketFactorsSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[SecurityConstraintsClearing]): SecurityConstraintsClearing =
    {
        val parent = MarketFactorsSerializer.read(kryo, input, classOf[MarketFactors])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = SecurityConstraintsClearing(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _InfMarketResults
{
    def register: List[CIMClassInfo] =
    {
        List(
            InterTieClearing.register,
            InterTieResults.register,
            MarketCaseClearing.register,
            SecurityConstraintsClearing.register
        )
    }
}
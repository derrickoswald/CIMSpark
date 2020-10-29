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
 * A unit with valves for three phases, together with unit control equipment, essential protective and switching devices, DC storage capacitors, phase reactors and auxiliaries, if any, used for conversion.
 *
 * @param ConductingEquipment [[ch.ninecode.model.ConductingEquipment ConductingEquipment]] Reference to the superclass object.
 * @param baseS               Base apparent power of the converter pole.
 *                            The attribute shall be a positive value.
 * @param idc                 Converter DC current, also called Id.
 *                            It is converter’s state variable, result from power flow.
 * @param idleLoss            Active power loss in pole at no power transfer.
 *                            It is converter’s configuration data used in power flow. The attribute shall be a positive value.
 * @param maxP                Maximum active power limit.
 *                            The value is overwritten by values of VsCapabilityCurve, if present.
 * @param maxUdc              The maximum voltage on the DC side at which the converter should operate.
 *                            It is converter’s configuration data used in power flow. The attribute shall be a positive value.
 * @param minP                Minimum active power limit.
 *                            The value is overwritten by values of VsCapabilityCurve, if present.
 * @param minUdc              The minimum voltage on the DC side at which the converter should operate.
 *                            It is converter’s configuration data used in power flow. The attribute shall be a positive value.
 * @param numberOfValves      Number of valves in the converter.
 *                            Used in loss calculations.
 * @param p                   Active power at the point of common coupling.
 *                            Load sign convention is used, i.e. positive sign means flow out from a node.
 *                            Starting value for a steady state solution in the case a simplified power flow model is used.
 * @param poleLossP           The active power loss at a DC Pole
 *                            &equals; idleLoss + switchingLoss*|Idc| + resitiveLoss*Idc<sup>2</sup>.
 *                            For lossless operation Pdc=Pac.
 *                            For rectifier operation with losses Pdc=Pac-lossP.
 *                            For inverter operation with losses Pdc=Pac+lossP.
 *                            It is converter’s state variable used in power flow. The attribute shall be a positive value.
 * @param q                   Reactive power at the point of common coupling.
 *                            Load sign convention is used, i.e. positive sign means flow out from a node.
 *                            Starting value for a steady state solution in the case a simplified power flow model is used.
 * @param ratedUdc            Rated converter DC voltage, also called UdN.
 *                            The attribute shall be a positive value. It is converter’s configuration data used in power flow. For instance a bipolar HVDC link with value  200 kV has a 400kV difference between the dc lines.
 * @param resistiveLoss       It is converter’s configuration data used in power flow.
 *                            Refer to poleLossP. The attribute shall be a positive value.
 * @param switchingLoss       Switching losses, relative to the base apparent power 'baseS'.
 *                            Refer to poleLossP. The attribute shall be a positive value.
 * @param targetPpcc          Real power injection target in AC grid, at point of common coupling.
 *                            Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param targetUdc           Target value for DC voltage magnitude.
 *                            The attribute shall be a positive value.
 * @param uc                  Line-to-line converter voltage, the voltage at the AC side of the valve.
 *                            It is converter’s state variable, result from power flow. The attribute shall be a positive value.
 * @param udc                 Converter voltage at the DC side, also called Ud.
 *                            It is converter’s state variable, result from power flow. The attribute shall be a positive value.
 * @param valveU0             Valve threshold voltage, also called Uvalve.
 *                            Forward voltage drop when the valve is conducting. Used in loss calculations, i.e. the switchLoss depend on numberOfValves * valveU0.
 * @param DCTerminals         [[ch.ninecode.model.ACDCConverterDCTerminal ACDCConverterDCTerminal]] A DC converter have DC converter terminals.
 *                            A converter has two DC converter terminals.
 * @param PccTerminal         [[ch.ninecode.model.Terminal Terminal]] Point of common coupling terminal for this converter DC side.
 *                            It is typically the terminal on the power transformer (or switch) closest to the AC network.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class ACDCConverter
(
    ConductingEquipment: ConductingEquipment = null,
    baseS: Double = 0.0,
    idc: Double = 0.0,
    idleLoss: Double = 0.0,
    maxP: Double = 0.0,
    maxUdc: Double = 0.0,
    minP: Double = 0.0,
    minUdc: Double = 0.0,
    numberOfValves: Int = 0,
    p: Double = 0.0,
    poleLossP: Double = 0.0,
    q: Double = 0.0,
    ratedUdc: Double = 0.0,
    resistiveLoss: Double = 0.0,
    switchingLoss: Double = 0.0,
    targetPpcc: Double = 0.0,
    targetUdc: Double = 0.0,
    uc: Double = 0.0,
    udc: Double = 0.0,
    valveU0: Double = 0.0,
    DCTerminals: List[String] = null,
    PccTerminal: String = null
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
    override def sup: ConductingEquipment = ConductingEquipment

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
        implicit val clz: String = ACDCConverter.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(ACDCConverter.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(ACDCConverter.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(ACDCConverter.fields(position), x))

        emitelem(0, baseS)
        emitelem(1, idc)
        emitelem(2, idleLoss)
        emitelem(3, maxP)
        emitelem(4, maxUdc)
        emitelem(5, minP)
        emitelem(6, minUdc)
        emitelem(7, numberOfValves)
        emitelem(8, p)
        emitelem(9, poleLossP)
        emitelem(10, q)
        emitelem(11, ratedUdc)
        emitelem(12, resistiveLoss)
        emitelem(13, switchingLoss)
        emitelem(14, targetPpcc)
        emitelem(15, targetUdc)
        emitelem(16, uc)
        emitelem(17, udc)
        emitelem(18, valveU0)
        emitattrs(19, DCTerminals)
        emitattr(20, PccTerminal)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ACDCConverter rdf:%s=\"%s\">\n%s\t</cim:ACDCConverter>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ACDCConverter
    extends
        CIMParseable[ACDCConverter]
{
    override val fields: Array[String] = Array[String](
        "baseS",
        "idc",
        "idleLoss",
        "maxP",
        "maxUdc",
        "minP",
        "minUdc",
        "numberOfValves",
        "p",
        "poleLossP",
        "q",
        "ratedUdc",
        "resistiveLoss",
        "switchingLoss",
        "targetPpcc",
        "targetUdc",
        "uc",
        "udc",
        "valveU0",
        "DCTerminals",
        "PccTerminal"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("DCTerminals", "ACDCConverterDCTerminal", "0..*", "1"),
        CIMRelationship("PccTerminal", "Terminal", "0..1", "0..*")
    )
    val baseS: Fielder = parse_element(element(cls, fields(0)))
    val idc: Fielder = parse_element(element(cls, fields(1)))
    val idleLoss: Fielder = parse_element(element(cls, fields(2)))
    val maxP: Fielder = parse_element(element(cls, fields(3)))
    val maxUdc: Fielder = parse_element(element(cls, fields(4)))
    val minP: Fielder = parse_element(element(cls, fields(5)))
    val minUdc: Fielder = parse_element(element(cls, fields(6)))
    val numberOfValves: Fielder = parse_element(element(cls, fields(7)))
    val p: Fielder = parse_element(element(cls, fields(8)))
    val poleLossP: Fielder = parse_element(element(cls, fields(9)))
    val q: Fielder = parse_element(element(cls, fields(10)))
    val ratedUdc: Fielder = parse_element(element(cls, fields(11)))
    val resistiveLoss: Fielder = parse_element(element(cls, fields(12)))
    val switchingLoss: Fielder = parse_element(element(cls, fields(13)))
    val targetPpcc: Fielder = parse_element(element(cls, fields(14)))
    val targetUdc: Fielder = parse_element(element(cls, fields(15)))
    val uc: Fielder = parse_element(element(cls, fields(16)))
    val udc: Fielder = parse_element(element(cls, fields(17)))
    val valveU0: Fielder = parse_element(element(cls, fields(18)))
    val DCTerminals: FielderMultiple = parse_attributes(attribute(cls, fields(19)))
    val PccTerminal: Fielder = parse_attribute(attribute(cls, fields(20)))

    def parse (context: CIMContext): ACDCConverter =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ACDCConverter(
            ConductingEquipment.parse(context),
            toDouble(mask(baseS(), 0)),
            toDouble(mask(idc(), 1)),
            toDouble(mask(idleLoss(), 2)),
            toDouble(mask(maxP(), 3)),
            toDouble(mask(maxUdc(), 4)),
            toDouble(mask(minP(), 5)),
            toDouble(mask(minUdc(), 6)),
            toInteger(mask(numberOfValves(), 7)),
            toDouble(mask(p(), 8)),
            toDouble(mask(poleLossP(), 9)),
            toDouble(mask(q(), 10)),
            toDouble(mask(ratedUdc(), 11)),
            toDouble(mask(resistiveLoss(), 12)),
            toDouble(mask(switchingLoss(), 13)),
            toDouble(mask(targetPpcc(), 14)),
            toDouble(mask(targetUdc(), 15)),
            toDouble(mask(uc(), 16)),
            toDouble(mask(udc(), 17)),
            toDouble(mask(valveU0(), 18)),
            masks(DCTerminals(), 19),
            mask(PccTerminal(), 20)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ACDCConverter] = ACDCConverterSerializer
}

object ACDCConverterSerializer extends CIMSerializer[ACDCConverter]
{
    def write (kryo: Kryo, output: Output, obj: ACDCConverter): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.baseS),
            () => output.writeDouble(obj.idc),
            () => output.writeDouble(obj.idleLoss),
            () => output.writeDouble(obj.maxP),
            () => output.writeDouble(obj.maxUdc),
            () => output.writeDouble(obj.minP),
            () => output.writeDouble(obj.minUdc),
            () => output.writeInt(obj.numberOfValves),
            () => output.writeDouble(obj.p),
            () => output.writeDouble(obj.poleLossP),
            () => output.writeDouble(obj.q),
            () => output.writeDouble(obj.ratedUdc),
            () => output.writeDouble(obj.resistiveLoss),
            () => output.writeDouble(obj.switchingLoss),
            () => output.writeDouble(obj.targetPpcc),
            () => output.writeDouble(obj.targetUdc),
            () => output.writeDouble(obj.uc),
            () => output.writeDouble(obj.udc),
            () => output.writeDouble(obj.valveU0),
            () => writeList(obj.DCTerminals, output),
            () => output.writeString(obj.PccTerminal)
        )
        ConductingEquipmentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ACDCConverter]): ACDCConverter =
    {
        val parent = ConductingEquipmentSerializer.read(kryo, input, classOf[ConductingEquipment])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ACDCConverter(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readDouble else 0.0,
            if (isSet(4)) input.readDouble else 0.0,
            if (isSet(5)) input.readDouble else 0.0,
            if (isSet(6)) input.readDouble else 0.0,
            if (isSet(7)) input.readInt else 0,
            if (isSet(8)) input.readDouble else 0.0,
            if (isSet(9)) input.readDouble else 0.0,
            if (isSet(10)) input.readDouble else 0.0,
            if (isSet(11)) input.readDouble else 0.0,
            if (isSet(12)) input.readDouble else 0.0,
            if (isSet(13)) input.readDouble else 0.0,
            if (isSet(14)) input.readDouble else 0.0,
            if (isSet(15)) input.readDouble else 0.0,
            if (isSet(16)) input.readDouble else 0.0,
            if (isSet(17)) input.readDouble else 0.0,
            if (isSet(18)) input.readDouble else 0.0,
            if (isSet(19)) readList(input) else null,
            if (isSet(20)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A DC electrical connection point at the AC/DC converter.
 *
 * The AC/DC converter is electrically connected also to the AC side. The AC connection is inherited from the AC conducting equipment in the same way as any other AC equipment. The AC/DC converter DC terminal is separate from generic DC terminal to restrict the connection with the AC side to AC/DC converter and so that no other DC conducting equipment can be connected to the AC side.
 *
 * @param DCBaseTerminal        [[ch.ninecode.model.DCBaseTerminal DCBaseTerminal]] Reference to the superclass object.
 * @param polarity              Represents the normal network polarity condition.
 *                              Depending on the converter configuration the value shall be set as follows:
 *        - For a monopole with two converter terminals use DCPolarityKind “positive” and “negative”.
 *        - For a bi-pole or symmetric monopole with three converter terminals use DCPolarityKind “positive”, “middle” and “negative”.
 * @param DCConductingEquipment [[ch.ninecode.model.ACDCConverter ACDCConverter]] A DC converter terminal belong to an DC converter.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class ACDCConverterDCTerminal
(
    DCBaseTerminal: DCBaseTerminal = null,
    polarity: String = null,
    DCConductingEquipment: String = null
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
    override def sup: DCBaseTerminal = DCBaseTerminal

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
        implicit val clz: String = ACDCConverterDCTerminal.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(ACDCConverterDCTerminal.fields(position), value)

        emitattr(0, polarity)
        emitattr(1, DCConductingEquipment)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:ACDCConverterDCTerminal rdf:%s=\"%s\">\n%s\t</cim:ACDCConverterDCTerminal>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object ACDCConverterDCTerminal
    extends
        CIMParseable[ACDCConverterDCTerminal]
{
    override val fields: Array[String] = Array[String](
        "polarity",
        "DCConductingEquipment"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("DCConductingEquipment", "ACDCConverter", "1", "0..*")
    )
    val polarity: Fielder = parse_attribute(attribute(cls, fields(0)))
    val DCConductingEquipment: Fielder = parse_attribute(attribute(cls, fields(1)))

    def parse (context: CIMContext): ACDCConverterDCTerminal =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = ACDCConverterDCTerminal(
            DCBaseTerminal.parse(context),
            mask(polarity(), 0),
            mask(DCConductingEquipment(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[ACDCConverterDCTerminal] = ACDCConverterDCTerminalSerializer
}

object ACDCConverterDCTerminalSerializer extends CIMSerializer[ACDCConverterDCTerminal]
{
    def write (kryo: Kryo, output: Output, obj: ACDCConverterDCTerminal): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.polarity),
            () => output.writeString(obj.DCConductingEquipment)
        )
        DCBaseTerminalSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[ACDCConverterDCTerminal]): ACDCConverterDCTerminal =
    {
        val parent = DCBaseTerminalSerializer.read(kryo, input, classOf[DCBaseTerminal])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = ACDCConverterDCTerminal(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * DC side of the current source converter (CSC).
 *
 * The firing angle controls the dc voltage at the converter, both for rectifier and inverter. The difference between the dc voltages of the rectifier and inverter determines the dc current. The extinction angle is used to limit the dc voltage at the inverter, if needed, and is not used in active power control. The firing angle, transformer tap position and number of connected filters are the primary means to control a current source dc line. Higher level controls are built on top, e.g. dc voltage, dc current and active power. From a steady state perspective it is sufficient to specify the wanted active power transfer (ACDCConverter.targetPpcc) and the control functions will set the dc voltage, dc current, firing angle, transformer tap position and number of connected filters to meet this. Therefore attributes targetAlpha and targetGamma are not applicable in this case.
 * The reactive power consumed by the converter is a function of the firing angle, transformer tap position and number of connected filter, which can be approximated with half of the active power. The losses is a function of the dc voltage and dc current.
 * The attributes minAlpha and maxAlpha define the range of firing angles for rectifier operation between which no discrete tap changer action takes place. The range is typically 10-18 degrees.
 * The attributes minGamma and maxGamma define the range of extinction angles for inverter operation between which no discrete tap changer action takes place. The range is typically 17-20 degrees.
 *
 * @param ACDCConverter [[ch.ninecode.model.ACDCConverter ACDCConverter]] Reference to the superclass object.
 * @param alpha         Firing angle that determines the dc voltage at the converter dc terminal.
 *                      Typical value between 10 degrees and 18 degrees for a rectifier. It is converter’s state variable, result from power flow. The attribute shall be a positive value.
 * @param gamma         Extinction angle.
 *                      It is used to limit the dc voltage at the inverter if needed. Typical value between 17 degrees and 20 degrees for an inverter. It is converter’s state variable, result from power flow. The attribute shall be a positive value.
 * @param maxAlpha      Maximum firing angle.
 *                      It is converter’s configuration data used in power flow. The attribute shall be a positive value.
 * @param maxGamma      Maximum extinction angle.
 *                      It is converter’s configuration data used in power flow. The attribute shall be a positive value.
 * @param maxIdc        The maximum direct current (Id) on the DC side at which the converter should operate.
 *                      It is converter’s configuration data use in power flow. The attribute shall be a positive value.
 * @param minAlpha      Minimum firing angle.
 *                      It is converter’s configuration data used in power flow. The attribute shall be a positive value.
 * @param minGamma      Minimum extinction angle.
 *                      It is converter’s configuration data used in power flow. The attribute shall be a positive value.
 * @param minIdc        The minimum direct current (Id) on the DC side at which the converter should operate.
 *                      It is converter’s configuration data used in power flow. The attribute shall be a positive value.
 * @param operatingMode Indicates whether the DC pole is operating as an inverter or as a rectifier.
 *                      It is converter’s control variable used in power flow.
 * @param pPccControl   Kind of active power control.
 * @param ratedIdc      Rated converter DC current, also called IdN.
 *                      The attribute shall be a positive value. It is converter’s configuration data used in power flow.
 * @param targetAlpha   Target firing angle.
 *                      It is converter’s control variable used in power flow. It is only applicable for rectifier if continuous tap changer control is used. Allowed values are within the range minAlpha&lt;=targetAlpha&lt;=maxAlpha. The attribute shall be a positive value.
 * @param targetGamma   Target extinction angle.
 *                      It is converter’s control variable used in power flow. It is only applicable for inverter if continuous tap changer control is used. Allowed values are within the range minGamma&lt;=targetGamma&lt;=maxGamma. The attribute shall be a positive value.
 * @param targetIdc     DC current target value.
 *                      It is converter’s control variable used in power flow. The attribute shall be a positive value.
 * @param CSCDynamics   [[ch.ninecode.model.CSCDynamics CSCDynamics]] Current source converter dynamics model used to describe dynamic behaviour of this converter.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class CsConverter
(
    ACDCConverter: ACDCConverter = null,
    alpha: Double = 0.0,
    gamma: Double = 0.0,
    maxAlpha: Double = 0.0,
    maxGamma: Double = 0.0,
    maxIdc: Double = 0.0,
    minAlpha: Double = 0.0,
    minGamma: Double = 0.0,
    minIdc: Double = 0.0,
    operatingMode: String = null,
    pPccControl: String = null,
    ratedIdc: Double = 0.0,
    targetAlpha: Double = 0.0,
    targetGamma: Double = 0.0,
    targetIdc: Double = 0.0,
    CSCDynamics: String = null
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
    override def sup: ACDCConverter = ACDCConverter

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
        implicit val clz: String = CsConverter.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(CsConverter.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(CsConverter.fields(position), value)

        emitelem(0, alpha)
        emitelem(1, gamma)
        emitelem(2, maxAlpha)
        emitelem(3, maxGamma)
        emitelem(4, maxIdc)
        emitelem(5, minAlpha)
        emitelem(6, minGamma)
        emitelem(7, minIdc)
        emitattr(8, operatingMode)
        emitattr(9, pPccControl)
        emitelem(10, ratedIdc)
        emitelem(11, targetAlpha)
        emitelem(12, targetGamma)
        emitelem(13, targetIdc)
        emitattr(14, CSCDynamics)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:CsConverter rdf:%s=\"%s\">\n%s\t</cim:CsConverter>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object CsConverter
    extends
        CIMParseable[CsConverter]
{
    override val fields: Array[String] = Array[String](
        "alpha",
        "gamma",
        "maxAlpha",
        "maxGamma",
        "maxIdc",
        "minAlpha",
        "minGamma",
        "minIdc",
        "operatingMode",
        "pPccControl",
        "ratedIdc",
        "targetAlpha",
        "targetGamma",
        "targetIdc",
        "CSCDynamics"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("CSCDynamics", "CSCDynamics", "0..1", "1")
    )
    val alpha: Fielder = parse_element(element(cls, fields(0)))
    val gamma: Fielder = parse_element(element(cls, fields(1)))
    val maxAlpha: Fielder = parse_element(element(cls, fields(2)))
    val maxGamma: Fielder = parse_element(element(cls, fields(3)))
    val maxIdc: Fielder = parse_element(element(cls, fields(4)))
    val minAlpha: Fielder = parse_element(element(cls, fields(5)))
    val minGamma: Fielder = parse_element(element(cls, fields(6)))
    val minIdc: Fielder = parse_element(element(cls, fields(7)))
    val operatingMode: Fielder = parse_attribute(attribute(cls, fields(8)))
    val pPccControl: Fielder = parse_attribute(attribute(cls, fields(9)))
    val ratedIdc: Fielder = parse_element(element(cls, fields(10)))
    val targetAlpha: Fielder = parse_element(element(cls, fields(11)))
    val targetGamma: Fielder = parse_element(element(cls, fields(12)))
    val targetIdc: Fielder = parse_element(element(cls, fields(13)))
    val CSCDynamics: Fielder = parse_attribute(attribute(cls, fields(14)))

    def parse (context: CIMContext): CsConverter =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = CsConverter(
            ACDCConverter.parse(context),
            toDouble(mask(alpha(), 0)),
            toDouble(mask(gamma(), 1)),
            toDouble(mask(maxAlpha(), 2)),
            toDouble(mask(maxGamma(), 3)),
            toDouble(mask(maxIdc(), 4)),
            toDouble(mask(minAlpha(), 5)),
            toDouble(mask(minGamma(), 6)),
            toDouble(mask(minIdc(), 7)),
            mask(operatingMode(), 8),
            mask(pPccControl(), 9),
            toDouble(mask(ratedIdc(), 10)),
            toDouble(mask(targetAlpha(), 11)),
            toDouble(mask(targetGamma(), 12)),
            toDouble(mask(targetIdc(), 13)),
            mask(CSCDynamics(), 14)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[CsConverter] = CsConverterSerializer
}

object CsConverterSerializer extends CIMSerializer[CsConverter]
{
    def write (kryo: Kryo, output: Output, obj: CsConverter): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.alpha),
            () => output.writeDouble(obj.gamma),
            () => output.writeDouble(obj.maxAlpha),
            () => output.writeDouble(obj.maxGamma),
            () => output.writeDouble(obj.maxIdc),
            () => output.writeDouble(obj.minAlpha),
            () => output.writeDouble(obj.minGamma),
            () => output.writeDouble(obj.minIdc),
            () => output.writeString(obj.operatingMode),
            () => output.writeString(obj.pPccControl),
            () => output.writeDouble(obj.ratedIdc),
            () => output.writeDouble(obj.targetAlpha),
            () => output.writeDouble(obj.targetGamma),
            () => output.writeDouble(obj.targetIdc),
            () => output.writeString(obj.CSCDynamics)
        )
        ACDCConverterSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[CsConverter]): CsConverter =
    {
        val parent = ACDCConverterSerializer.read(kryo, input, classOf[ACDCConverter])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = CsConverter(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readDouble else 0.0,
            if (isSet(4)) input.readDouble else 0.0,
            if (isSet(5)) input.readDouble else 0.0,
            if (isSet(6)) input.readDouble else 0.0,
            if (isSet(7)) input.readDouble else 0.0,
            if (isSet(8)) input.readString else null,
            if (isSet(9)) input.readString else null,
            if (isSet(10)) input.readDouble else 0.0,
            if (isSet(11)) input.readDouble else 0.0,
            if (isSet(12)) input.readDouble else 0.0,
            if (isSet(13)) input.readDouble else 0.0,
            if (isSet(14)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An electrical connection point at a piece of DC conducting equipment.
 *
 * DC terminals are connected at one physical DC node that may have multiple DC terminals connected. A DC node is similar to an AC connectivity node. The model requires that DC connections are distinct from AC connections.
 *
 * @param ACDCTerminal      [[ch.ninecode.model.ACDCTerminal ACDCTerminal]] Reference to the superclass object.
 * @param DCNode            [[ch.ninecode.model.DCNode DCNode]] The DC connectivity node to which this DC base terminal connects with zero impedance.
 * @param DCTopologicalNode [[ch.ninecode.model.DCTopologicalNode DCTopologicalNode]] See association end Terminal.
 *                          TopologicalNode.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCBaseTerminal
(
    ACDCTerminal: ACDCTerminal = null,
    DCNode: String = null,
    DCTopologicalNode: String = null
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
    override def sup: ACDCTerminal = ACDCTerminal

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
        implicit val clz: String = DCBaseTerminal.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(DCBaseTerminal.fields(position), value)

        emitattr(0, DCNode)
        emitattr(1, DCTopologicalNode)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DCBaseTerminal rdf:%s=\"%s\">\n%s\t</cim:DCBaseTerminal>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DCBaseTerminal
    extends
        CIMParseable[DCBaseTerminal]
{
    override val fields: Array[String] = Array[String](
        "DCNode",
        "DCTopologicalNode"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("DCNode", "DCNode", "0..1", "0..*"),
        CIMRelationship("DCTopologicalNode", "DCTopologicalNode", "0..1", "0..*")
    )
    val DCNode: Fielder = parse_attribute(attribute(cls, fields(0)))
    val DCTopologicalNode: Fielder = parse_attribute(attribute(cls, fields(1)))

    def parse (context: CIMContext): DCBaseTerminal =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DCBaseTerminal(
            ACDCTerminal.parse(context),
            mask(DCNode(), 0),
            mask(DCTopologicalNode(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DCBaseTerminal] = DCBaseTerminalSerializer
}

object DCBaseTerminalSerializer extends CIMSerializer[DCBaseTerminal]
{
    def write (kryo: Kryo, output: Output, obj: DCBaseTerminal): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.DCNode),
            () => output.writeString(obj.DCTopologicalNode)
        )
        ACDCTerminalSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DCBaseTerminal]): DCBaseTerminal =
    {
        val parent = ACDCTerminalSerializer.read(kryo, input, classOf[ACDCTerminal])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DCBaseTerminal(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A breaker within a DC system.
 *
 * @param DCSwitch [[ch.ninecode.model.DCSwitch DCSwitch]] Reference to the superclass object.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCBreaker
(
    DCSwitch: DCSwitch = null
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
    override def sup: DCSwitch = DCSwitch

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
        sup.export_fields
    }

    override def export: String =
    {
        "\t<cim:DCBreaker rdf:%s=\"%s\">\n%s\t</cim:DCBreaker>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DCBreaker
    extends
        CIMParseable[DCBreaker]
{

    def parse (context: CIMContext): DCBreaker =
    {
        val ret = DCBreaker(
            DCSwitch.parse(context)
        )
        ret
    }

    def serializer: Serializer[DCBreaker] = DCBreakerSerializer
}

object DCBreakerSerializer extends CIMSerializer[DCBreaker]
{
    def write (kryo: Kryo, output: Output, obj: DCBreaker): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(

        )
        DCSwitchSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DCBreaker]): DCBreaker =
    {
        val parent = DCSwitchSerializer.read(kryo, input, classOf[DCSwitch])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DCBreaker(
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A busbar within a DC system.
 *
 * @param DCConductingEquipment [[ch.ninecode.model.DCConductingEquipment DCConductingEquipment]] Reference to the superclass object.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCBusbar
(
    DCConductingEquipment: DCConductingEquipment = null
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
    override def sup: DCConductingEquipment = DCConductingEquipment

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
        sup.export_fields
    }

    override def export: String =
    {
        "\t<cim:DCBusbar rdf:%s=\"%s\">\n%s\t</cim:DCBusbar>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DCBusbar
    extends
        CIMParseable[DCBusbar]
{

    def parse (context: CIMContext): DCBusbar =
    {
        val ret = DCBusbar(
            DCConductingEquipment.parse(context)
        )
        ret
    }

    def serializer: Serializer[DCBusbar] = DCBusbarSerializer
}

object DCBusbarSerializer extends CIMSerializer[DCBusbar]
{
    def write (kryo: Kryo, output: Output, obj: DCBusbar): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(

        )
        DCConductingEquipmentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DCBusbar]): DCBusbar =
    {
        val parent = DCConductingEquipmentSerializer.read(kryo, input, classOf[DCConductingEquipment])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DCBusbar(
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Low resistance equipment used in the internal DC circuit to balance voltages.
 *
 * It has typically positive and negative pole terminals and a ground.
 *
 * @param DCConductingEquipment [[ch.ninecode.model.DCConductingEquipment DCConductingEquipment]] Reference to the superclass object.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCChopper
(
    DCConductingEquipment: DCConductingEquipment = null
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
    override def sup: DCConductingEquipment = DCConductingEquipment

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
        sup.export_fields
    }

    override def export: String =
    {
        "\t<cim:DCChopper rdf:%s=\"%s\">\n%s\t</cim:DCChopper>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DCChopper
    extends
        CIMParseable[DCChopper]
{

    def parse (context: CIMContext): DCChopper =
    {
        val ret = DCChopper(
            DCConductingEquipment.parse(context)
        )
        ret
    }

    def serializer: Serializer[DCChopper] = DCChopperSerializer
}

object DCChopperSerializer extends CIMSerializer[DCChopper]
{
    def write (kryo: Kryo, output: Output, obj: DCChopper): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(

        )
        DCConductingEquipmentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DCChopper]): DCChopper =
    {
        val parent = DCConductingEquipmentSerializer.read(kryo, input, classOf[DCConductingEquipment])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DCChopper(
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The parts of the DC power system that are designed to carry current or that are conductively connected through DC terminals.
 *
 * @param Equipment                  [[ch.ninecode.model.Equipment Equipment]] Reference to the superclass object.
 * @param ratedUdc                   Rated DC device voltage.
 *                                   The attribute shall be a positive value. It is configuration data used in power flow.
 * @param DCTerminals                [[ch.ninecode.model.DCTerminal DCTerminal]] A DC conducting equipment has DC terminals.
 * @param ProtectiveActionAdjustment [[ch.ninecode.model.ProtectiveActionAdjustment ProtectiveActionAdjustment]] <em>undocumented</em>
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCConductingEquipment
(
    Equipment: Equipment = null,
    ratedUdc: Double = 0.0,
    DCTerminals: List[String] = null,
    ProtectiveActionAdjustment: List[String] = null
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
    override def sup: Equipment = Equipment

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
        implicit val clz: String = DCConductingEquipment.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(DCConductingEquipment.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(DCConductingEquipment.fields(position), x))

        emitelem(0, ratedUdc)
        emitattrs(1, DCTerminals)
        emitattrs(2, ProtectiveActionAdjustment)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DCConductingEquipment rdf:%s=\"%s\">\n%s\t</cim:DCConductingEquipment>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DCConductingEquipment
    extends
        CIMParseable[DCConductingEquipment]
{
    override val fields: Array[String] = Array[String](
        "ratedUdc",
        "DCTerminals",
        "ProtectiveActionAdjustment"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("DCTerminals", "DCTerminal", "0..*", "1"),
        CIMRelationship("ProtectiveActionAdjustment", "ProtectiveActionAdjustment", "0..*", "1")
    )
    val ratedUdc: Fielder = parse_element(element(cls, fields(0)))
    val DCTerminals: FielderMultiple = parse_attributes(attribute(cls, fields(1)))
    val ProtectiveActionAdjustment: FielderMultiple = parse_attributes(attribute(cls, fields(2)))

    def parse (context: CIMContext): DCConductingEquipment =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DCConductingEquipment(
            Equipment.parse(context),
            toDouble(mask(ratedUdc(), 0)),
            masks(DCTerminals(), 1),
            masks(ProtectiveActionAdjustment(), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DCConductingEquipment] = DCConductingEquipmentSerializer
}

object DCConductingEquipmentSerializer extends CIMSerializer[DCConductingEquipment]
{
    def write (kryo: Kryo, output: Output, obj: DCConductingEquipment): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.ratedUdc),
            () => writeList(obj.DCTerminals, output),
            () => writeList(obj.ProtectiveActionAdjustment, output)
        )
        EquipmentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DCConductingEquipment]): DCConductingEquipment =
    {
        val parent = EquipmentSerializer.read(kryo, input, classOf[Equipment])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DCConductingEquipment(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) readList(input) else null,
            if (isSet(2)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Indivisible operative unit comprising all equipment between the point of common coupling on the AC side and the point of common coupling – DC side, essentially one or more converters, together with one or more converter transformers, converter control equipment, essential protective and switching devices and auxiliaries, if any, used for conversion.
 *
 * @param DCEquipmentContainer [[ch.ninecode.model.DCEquipmentContainer DCEquipmentContainer]] Reference to the superclass object.
 * @param operationMode        The operating mode of an HVDC bipole (bipolar, monopolar metallic return, etc).
 * @param Substation           [[ch.ninecode.model.Substation Substation]] The containing substation of the DC converter unit.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCConverterUnit
(
    DCEquipmentContainer: DCEquipmentContainer = null,
    operationMode: String = null,
    Substation: String = null
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
    override def sup: DCEquipmentContainer = DCEquipmentContainer

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
        implicit val clz: String = DCConverterUnit.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(DCConverterUnit.fields(position), value)

        emitattr(0, operationMode)
        emitattr(1, Substation)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DCConverterUnit rdf:%s=\"%s\">\n%s\t</cim:DCConverterUnit>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DCConverterUnit
    extends
        CIMParseable[DCConverterUnit]
{
    override val fields: Array[String] = Array[String](
        "operationMode",
        "Substation"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("Substation", "Substation", "0..1", "0..*")
    )
    val operationMode: Fielder = parse_attribute(attribute(cls, fields(0)))
    val Substation: Fielder = parse_attribute(attribute(cls, fields(1)))

    def parse (context: CIMContext): DCConverterUnit =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DCConverterUnit(
            DCEquipmentContainer.parse(context),
            mask(operationMode(), 0),
            mask(Substation(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DCConverterUnit] = DCConverterUnitSerializer
}

object DCConverterUnitSerializer extends CIMSerializer[DCConverterUnit]
{
    def write (kryo: Kryo, output: Output, obj: DCConverterUnit): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.operationMode),
            () => output.writeString(obj.Substation)
        )
        DCEquipmentContainerSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DCConverterUnit]): DCConverterUnit =
    {
        val parent = DCEquipmentContainerSerializer.read(kryo, input, classOf[DCEquipmentContainer])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DCConverterUnit(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A disconnector within a DC system.
 *
 * @param DCSwitch [[ch.ninecode.model.DCSwitch DCSwitch]] Reference to the superclass object.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCDisconnector
(
    DCSwitch: DCSwitch = null
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
    override def sup: DCSwitch = DCSwitch

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
        sup.export_fields
    }

    override def export: String =
    {
        "\t<cim:DCDisconnector rdf:%s=\"%s\">\n%s\t</cim:DCDisconnector>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DCDisconnector
    extends
        CIMParseable[DCDisconnector]
{

    def parse (context: CIMContext): DCDisconnector =
    {
        val ret = DCDisconnector(
            DCSwitch.parse(context)
        )
        ret
    }

    def serializer: Serializer[DCDisconnector] = DCDisconnectorSerializer
}

object DCDisconnectorSerializer extends CIMSerializer[DCDisconnector]
{
    def write (kryo: Kryo, output: Output, obj: DCDisconnector): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(

        )
        DCSwitchSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DCDisconnector]): DCDisconnector =
    {
        val parent = DCSwitchSerializer.read(kryo, input, classOf[DCSwitch])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DCDisconnector(
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A modelling construct to provide a root class for containment of DC as well as AC equipment.
 *
 * The class differ from the EquipmentContaner for AC in that it may also contain DCNode-s. Hence it can contain both AC and DC equipment.
 *
 * @param EquipmentContainer [[ch.ninecode.model.EquipmentContainer EquipmentContainer]] Reference to the superclass object.
 * @param DCNodes            [[ch.ninecode.model.DCNode DCNode]] The DC nodes contained in the DC equipment container.
 * @param DCTopologicalNode  [[ch.ninecode.model.DCTopologicalNode DCTopologicalNode]] The topological nodes which belong to this connectivity node container.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCEquipmentContainer
(
    EquipmentContainer: EquipmentContainer = null,
    DCNodes: List[String] = null,
    DCTopologicalNode: List[String] = null
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
    override def sup: EquipmentContainer = EquipmentContainer

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
        implicit val clz: String = DCEquipmentContainer.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(DCEquipmentContainer.fields(position), x))

        emitattrs(0, DCNodes)
        emitattrs(1, DCTopologicalNode)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DCEquipmentContainer rdf:%s=\"%s\">\n%s\t</cim:DCEquipmentContainer>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DCEquipmentContainer
    extends
        CIMParseable[DCEquipmentContainer]
{
    override val fields: Array[String] = Array[String](
        "DCNodes",
        "DCTopologicalNode"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("DCNodes", "DCNode", "0..*", "1"),
        CIMRelationship("DCTopologicalNode", "DCTopologicalNode", "0..*", "0..1")
    )
    val DCNodes: FielderMultiple = parse_attributes(attribute(cls, fields(0)))
    val DCTopologicalNode: FielderMultiple = parse_attributes(attribute(cls, fields(1)))

    def parse (context: CIMContext): DCEquipmentContainer =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DCEquipmentContainer(
            EquipmentContainer.parse(context),
            masks(DCNodes(), 0),
            masks(DCTopologicalNode(), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DCEquipmentContainer] = DCEquipmentContainerSerializer
}

object DCEquipmentContainerSerializer extends CIMSerializer[DCEquipmentContainer]
{
    def write (kryo: Kryo, output: Output, obj: DCEquipmentContainer): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => writeList(obj.DCNodes, output),
            () => writeList(obj.DCTopologicalNode, output)
        )
        EquipmentContainerSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DCEquipmentContainer]): DCEquipmentContainer =
    {
        val parent = EquipmentContainerSerializer.read(kryo, input, classOf[EquipmentContainer])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DCEquipmentContainer(
            parent,
            if (isSet(0)) readList(input) else null,
            if (isSet(1)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A ground within a DC system.
 *
 * @param DCConductingEquipment [[ch.ninecode.model.DCConductingEquipment DCConductingEquipment]] Reference to the superclass object.
 * @param inductance            Inductance to ground.
 * @param r                     Resistance to ground.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCGround
(
    DCConductingEquipment: DCConductingEquipment = null,
    inductance: Double = 0.0,
    r: Double = 0.0
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
    override def sup: DCConductingEquipment = DCConductingEquipment

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
        implicit val clz: String = DCGround.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(DCGround.fields(position), value)

        emitelem(0, inductance)
        emitelem(1, r)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DCGround rdf:%s=\"%s\">\n%s\t</cim:DCGround>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DCGround
    extends
        CIMParseable[DCGround]
{
    override val fields: Array[String] = Array[String](
        "inductance",
        "r"
    )
    val inductance: Fielder = parse_element(element(cls, fields(0)))
    val r: Fielder = parse_element(element(cls, fields(1)))

    def parse (context: CIMContext): DCGround =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DCGround(
            DCConductingEquipment.parse(context),
            toDouble(mask(inductance(), 0)),
            toDouble(mask(r(), 1))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DCGround] = DCGroundSerializer
}

object DCGroundSerializer extends CIMSerializer[DCGround]
{
    def write (kryo: Kryo, output: Output, obj: DCGround): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.inductance),
            () => output.writeDouble(obj.r)
        )
        DCConductingEquipmentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DCGround]): DCGround =
    {
        val parent = DCConductingEquipmentSerializer.read(kryo, input, classOf[DCConductingEquipment])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DCGround(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Overhead lines and/or cables connecting two or more HVDC substations.
 *
 * @param DCEquipmentContainer [[ch.ninecode.model.DCEquipmentContainer DCEquipmentContainer]] Reference to the superclass object.
 * @param Region               [[ch.ninecode.model.SubGeographicalRegion SubGeographicalRegion]] The SubGeographicalRegion containing the DC line.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCLine
(
    DCEquipmentContainer: DCEquipmentContainer = null,
    Region: String = null
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
    override def sup: DCEquipmentContainer = DCEquipmentContainer

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
        implicit val clz: String = DCLine.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(DCLine.fields(position), value)

        emitattr(0, Region)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DCLine rdf:%s=\"%s\">\n%s\t</cim:DCLine>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DCLine
    extends
        CIMParseable[DCLine]
{
    override val fields: Array[String] = Array[String](
        "Region"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("Region", "SubGeographicalRegion", "0..1", "0..*")
    )
    val Region: Fielder = parse_attribute(attribute(cls, fields(0)))

    def parse (context: CIMContext): DCLine =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DCLine(
            DCEquipmentContainer.parse(context),
            mask(Region(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DCLine] = DCLineSerializer
}

object DCLineSerializer extends CIMSerializer[DCLine]
{
    def write (kryo: Kryo, output: Output, obj: DCLine): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.Region)
        )
        DCEquipmentContainerSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DCLine]): DCLine =
    {
        val parent = DCEquipmentContainerSerializer.read(kryo, input, classOf[DCEquipmentContainer])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DCLine(
            parent,
            if (isSet(0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A wire or combination of wires not insulated from one another, with consistent electrical characteristics, used to carry direct current between points in the DC region of the power system.
 *
 * @param DCConductingEquipment [[ch.ninecode.model.DCConductingEquipment DCConductingEquipment]] Reference to the superclass object.
 * @param capacitance           Capacitance of the DC line segment.
 *                              Significant for cables only.
 * @param inductance            Inductance of the DC line segment.
 *                              Negligible compared with DCSeriesDevice used for smoothing.
 * @param len                   Segment length for calculating line section capabilities.
 * @param resistance            Resistance of the DC line segment.
 * @param PerLengthParameter    [[ch.ninecode.model.PerLengthDCLineParameter PerLengthDCLineParameter]] Set of per-length parameters for this line segment.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCLineSegment
(
    DCConductingEquipment: DCConductingEquipment = null,
    capacitance: Double = 0.0,
    inductance: Double = 0.0,
    len: Double = 0.0,
    resistance: Double = 0.0,
    PerLengthParameter: String = null
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
    override def sup: DCConductingEquipment = DCConductingEquipment

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
        implicit val clz: String = DCLineSegment.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(DCLineSegment.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(DCLineSegment.fields(position), value)

        emitelem(0, capacitance)
        emitelem(1, inductance)
        emitelem(2, len)
        emitelem(3, resistance)
        emitattr(4, PerLengthParameter)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DCLineSegment rdf:%s=\"%s\">\n%s\t</cim:DCLineSegment>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DCLineSegment
    extends
        CIMParseable[DCLineSegment]
{
    override val fields: Array[String] = Array[String](
        "capacitance",
        "inductance",
        "length",
        "resistance",
        "PerLengthParameter"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("PerLengthParameter", "PerLengthDCLineParameter", "0..1", "0..*")
    )
    val capacitance: Fielder = parse_element(element(cls, fields(0)))
    val inductance: Fielder = parse_element(element(cls, fields(1)))
    val len: Fielder = parse_element(element(cls, fields(2)))
    val resistance: Fielder = parse_element(element(cls, fields(3)))
    val PerLengthParameter: Fielder = parse_attribute(attribute(cls, fields(4)))

    def parse (context: CIMContext): DCLineSegment =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DCLineSegment(
            DCConductingEquipment.parse(context),
            toDouble(mask(capacitance(), 0)),
            toDouble(mask(inductance(), 1)),
            toDouble(mask(len(), 2)),
            toDouble(mask(resistance(), 3)),
            mask(PerLengthParameter(), 4)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DCLineSegment] = DCLineSegmentSerializer
}

object DCLineSegmentSerializer extends CIMSerializer[DCLineSegment]
{
    def write (kryo: Kryo, output: Output, obj: DCLineSegment): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.capacitance),
            () => output.writeDouble(obj.inductance),
            () => output.writeDouble(obj.len),
            () => output.writeDouble(obj.resistance),
            () => output.writeString(obj.PerLengthParameter)
        )
        DCConductingEquipmentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DCLineSegment]): DCLineSegment =
    {
        val parent = DCConductingEquipmentSerializer.read(kryo, input, classOf[DCConductingEquipment])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DCLineSegment(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readDouble else 0.0,
            if (isSet(4)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * DC nodes are points where terminals of DC conducting equipment are connected together with zero impedance.
 *
 * @param IdentifiedObject     [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param DCEquipmentContainer [[ch.ninecode.model.DCEquipmentContainer DCEquipmentContainer]] The DC container for the DC nodes.
 * @param DCTerminals          [[ch.ninecode.model.DCBaseTerminal DCBaseTerminal]] DC base terminals interconnected with zero impedance at a this DC connectivity node.
 * @param DCTopologicalNode    [[ch.ninecode.model.DCTopologicalNode DCTopologicalNode]] The DC topological node to which this DC connectivity node is assigned.
 *                             May depend on the current state of switches in the network.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCNode
(
    IdentifiedObject: IdentifiedObject = null,
    DCEquipmentContainer: String = null,
    DCTerminals: List[String] = null,
    DCTopologicalNode: String = null
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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = DCNode.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(DCNode.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(DCNode.fields(position), x))

        emitattr(0, DCEquipmentContainer)
        emitattrs(1, DCTerminals)
        emitattr(2, DCTopologicalNode)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DCNode rdf:%s=\"%s\">\n%s\t</cim:DCNode>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DCNode
    extends
        CIMParseable[DCNode]
{
    override val fields: Array[String] = Array[String](
        "DCEquipmentContainer",
        "DCTerminals",
        "DCTopologicalNode"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("DCEquipmentContainer", "DCEquipmentContainer", "1", "0..*"),
        CIMRelationship("DCTerminals", "DCBaseTerminal", "0..*", "0..1"),
        CIMRelationship("DCTopologicalNode", "DCTopologicalNode", "0..1", "0..*")
    )
    val DCEquipmentContainer: Fielder = parse_attribute(attribute(cls, fields(0)))
    val DCTerminals: FielderMultiple = parse_attributes(attribute(cls, fields(1)))
    val DCTopologicalNode: Fielder = parse_attribute(attribute(cls, fields(2)))

    def parse (context: CIMContext): DCNode =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DCNode(
            IdentifiedObject.parse(context),
            mask(DCEquipmentContainer(), 0),
            masks(DCTerminals(), 1),
            mask(DCTopologicalNode(), 2)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DCNode] = DCNodeSerializer
}

object DCNodeSerializer extends CIMSerializer[DCNode]
{
    def write (kryo: Kryo, output: Output, obj: DCNode): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.DCEquipmentContainer),
            () => writeList(obj.DCTerminals, output),
            () => output.writeString(obj.DCTopologicalNode)
        )
        IdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DCNode]): DCNode =
    {
        val parent = IdentifiedObjectSerializer.read(kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DCNode(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) readList(input) else null,
            if (isSet(2)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A series device within the DC system, typically a reactor used for filtering or smoothing.
 *
 * Needed for transient and short circuit studies.
 *
 * @param DCConductingEquipment [[ch.ninecode.model.DCConductingEquipment DCConductingEquipment]] Reference to the superclass object.
 * @param inductance            Inductance of the device.
 * @param resistance            Resistance of the DC device.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCSeriesDevice
(
    DCConductingEquipment: DCConductingEquipment = null,
    inductance: Double = 0.0,
    resistance: Double = 0.0
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
    override def sup: DCConductingEquipment = DCConductingEquipment

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
        implicit val clz: String = DCSeriesDevice.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(DCSeriesDevice.fields(position), value)

        emitelem(0, inductance)
        emitelem(1, resistance)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DCSeriesDevice rdf:%s=\"%s\">\n%s\t</cim:DCSeriesDevice>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DCSeriesDevice
    extends
        CIMParseable[DCSeriesDevice]
{
    override val fields: Array[String] = Array[String](
        "inductance",
        "resistance"
    )
    val inductance: Fielder = parse_element(element(cls, fields(0)))
    val resistance: Fielder = parse_element(element(cls, fields(1)))

    def parse (context: CIMContext): DCSeriesDevice =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DCSeriesDevice(
            DCConductingEquipment.parse(context),
            toDouble(mask(inductance(), 0)),
            toDouble(mask(resistance(), 1))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DCSeriesDevice] = DCSeriesDeviceSerializer
}

object DCSeriesDeviceSerializer extends CIMSerializer[DCSeriesDevice]
{
    def write (kryo: Kryo, output: Output, obj: DCSeriesDevice): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.inductance),
            () => output.writeDouble(obj.resistance)
        )
        DCConductingEquipmentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DCSeriesDevice]): DCSeriesDevice =
    {
        val parent = DCConductingEquipmentSerializer.read(kryo, input, classOf[DCConductingEquipment])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DCSeriesDevice(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A shunt device within the DC system, typically used for filtering.
 *
 * Needed for transient and short circuit studies.
 *
 * @param DCConductingEquipment [[ch.ninecode.model.DCConductingEquipment DCConductingEquipment]] Reference to the superclass object.
 * @param capacitance           Capacitance of the DC shunt.
 * @param resistance            Resistance of the DC device.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCShunt
(
    DCConductingEquipment: DCConductingEquipment = null,
    capacitance: Double = 0.0,
    resistance: Double = 0.0
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
    override def sup: DCConductingEquipment = DCConductingEquipment

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
        implicit val clz: String = DCShunt.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(DCShunt.fields(position), value)

        emitelem(0, capacitance)
        emitelem(1, resistance)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DCShunt rdf:%s=\"%s\">\n%s\t</cim:DCShunt>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DCShunt
    extends
        CIMParseable[DCShunt]
{
    override val fields: Array[String] = Array[String](
        "capacitance",
        "resistance"
    )
    val capacitance: Fielder = parse_element(element(cls, fields(0)))
    val resistance: Fielder = parse_element(element(cls, fields(1)))

    def parse (context: CIMContext): DCShunt =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DCShunt(
            DCConductingEquipment.parse(context),
            toDouble(mask(capacitance(), 0)),
            toDouble(mask(resistance(), 1))
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DCShunt] = DCShuntSerializer
}

object DCShuntSerializer extends CIMSerializer[DCShunt]
{
    def write (kryo: Kryo, output: Output, obj: DCShunt): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.capacitance),
            () => output.writeDouble(obj.resistance)
        )
        DCConductingEquipmentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DCShunt]): DCShunt =
    {
        val parent = DCConductingEquipmentSerializer.read(kryo, input, classOf[DCConductingEquipment])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DCShunt(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A switch within the DC system.
 *
 * @param DCConductingEquipment [[ch.ninecode.model.DCConductingEquipment DCConductingEquipment]] Reference to the superclass object.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCSwitch
(
    DCConductingEquipment: DCConductingEquipment = null
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
    override def sup: DCConductingEquipment = DCConductingEquipment

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
        sup.export_fields
    }

    override def export: String =
    {
        "\t<cim:DCSwitch rdf:%s=\"%s\">\n%s\t</cim:DCSwitch>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DCSwitch
    extends
        CIMParseable[DCSwitch]
{

    def parse (context: CIMContext): DCSwitch =
    {
        val ret = DCSwitch(
            DCConductingEquipment.parse(context)
        )
        ret
    }

    def serializer: Serializer[DCSwitch] = DCSwitchSerializer
}

object DCSwitchSerializer extends CIMSerializer[DCSwitch]
{
    def write (kryo: Kryo, output: Output, obj: DCSwitch): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(

        )
        DCConductingEquipmentSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DCSwitch]): DCSwitch =
    {
        val parent = DCConductingEquipmentSerializer.read(kryo, input, classOf[DCConductingEquipment])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DCSwitch(
            parent
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An electrical connection point to generic DC conducting equipment.
 *
 * @param DCBaseTerminal        [[ch.ninecode.model.DCBaseTerminal DCBaseTerminal]] Reference to the superclass object.
 * @param DCConductingEquipment [[ch.ninecode.model.DCConductingEquipment DCConductingEquipment]] An DC  terminal belong to a DC conducting equipment.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCTerminal
(
    DCBaseTerminal: DCBaseTerminal = null,
    DCConductingEquipment: String = null
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
    override def sup: DCBaseTerminal = DCBaseTerminal

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
        implicit val clz: String = DCTerminal.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(DCTerminal.fields(position), value)

        emitattr(0, DCConductingEquipment)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DCTerminal rdf:%s=\"%s\">\n%s\t</cim:DCTerminal>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DCTerminal
    extends
        CIMParseable[DCTerminal]
{
    override val fields: Array[String] = Array[String](
        "DCConductingEquipment"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("DCConductingEquipment", "DCConductingEquipment", "1", "0..*")
    )
    val DCConductingEquipment: Fielder = parse_attribute(attribute(cls, fields(0)))

    def parse (context: CIMContext): DCTerminal =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DCTerminal(
            DCBaseTerminal.parse(context),
            mask(DCConductingEquipment(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DCTerminal] = DCTerminalSerializer
}

object DCTerminalSerializer extends CIMSerializer[DCTerminal]
{
    def write (kryo: Kryo, output: Output, obj: DCTerminal): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.DCConductingEquipment)
        )
        DCBaseTerminalSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DCTerminal]): DCTerminal =
    {
        val parent = DCBaseTerminalSerializer.read(kryo, input, classOf[DCBaseTerminal])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DCTerminal(
            parent,
            if (isSet(0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An electrically connected subset of the network.
 *
 * DC topological islands can change as the current network state changes, e.g. due to:
 * - disconnect switches or breakers changing state in a SCADA/EMS.
 * - manual creation, change or deletion of topological nodes in a planning tool.
 * Only energised TopologicalNode-s shall be part of the topological island.
 *
 * @param IdentifiedObject   [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param DCTopologicalNodes [[ch.ninecode.model.DCTopologicalNode DCTopologicalNode]] The DC topological nodes in a DC topological island.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCTopologicalIsland
(
    IdentifiedObject: IdentifiedObject = null,
    DCTopologicalNodes: List[String] = null
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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = DCTopologicalIsland.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(DCTopologicalIsland.fields(position), x))

        emitattrs(0, DCTopologicalNodes)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DCTopologicalIsland rdf:%s=\"%s\">\n%s\t</cim:DCTopologicalIsland>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DCTopologicalIsland
    extends
        CIMParseable[DCTopologicalIsland]
{
    override val fields: Array[String] = Array[String](
        "DCTopologicalNodes"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("DCTopologicalNodes", "DCTopologicalNode", "1..*", "0..1")
    )
    val DCTopologicalNodes: FielderMultiple = parse_attributes(attribute(cls, fields(0)))

    def parse (context: CIMContext): DCTopologicalIsland =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DCTopologicalIsland(
            IdentifiedObject.parse(context),
            masks(DCTopologicalNodes(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DCTopologicalIsland] = DCTopologicalIslandSerializer
}

object DCTopologicalIslandSerializer extends CIMSerializer[DCTopologicalIsland]
{
    def write (kryo: Kryo, output: Output, obj: DCTopologicalIsland): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => writeList(obj.DCTopologicalNodes, output)
        )
        IdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DCTopologicalIsland]): DCTopologicalIsland =
    {
        val parent = IdentifiedObjectSerializer.read(kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DCTopologicalIsland(
            parent,
            if (isSet(0)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * DC bus.
 *
 * @param IdentifiedObject     [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param DCEquipmentContainer [[ch.ninecode.model.DCEquipmentContainer DCEquipmentContainer]] The connectivity node container to which the topological node belongs.
 * @param DCNodes              [[ch.ninecode.model.DCNode DCNode]] The DC connectivity nodes combined together to form this DC topological node.
 *                             May depend on the current state of switches in the network.
 * @param DCTerminals          [[ch.ninecode.model.DCBaseTerminal DCBaseTerminal]] See association end TopologicalNode.
 *                             Terminal.
 * @param DCTopologicalIsland  [[ch.ninecode.model.DCTopologicalIsland DCTopologicalIsland]] A DC topological node belongs to a DC topological island.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class DCTopologicalNode
(
    IdentifiedObject: IdentifiedObject = null,
    DCEquipmentContainer: String = null,
    DCNodes: List[String] = null,
    DCTerminals: List[String] = null,
    DCTopologicalIsland: String = null
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
    override def copy (): Row =
    {
        clone().asInstanceOf[Row]
    }

    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder(sup.export_fields)
        implicit val clz: String = DCTopologicalNode.cls

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(DCTopologicalNode.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(DCTopologicalNode.fields(position), x))

        emitattr(0, DCEquipmentContainer)
        emitattrs(1, DCNodes)
        emitattrs(2, DCTerminals)
        emitattr(3, DCTopologicalIsland)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:DCTopologicalNode rdf:%s=\"%s\">\n%s\t</cim:DCTopologicalNode>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object DCTopologicalNode
    extends
        CIMParseable[DCTopologicalNode]
{
    override val fields: Array[String] = Array[String](
        "DCEquipmentContainer",
        "DCNodes",
        "DCTerminals",
        "DCTopologicalIsland"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("DCEquipmentContainer", "DCEquipmentContainer", "0..1", "0..*"),
        CIMRelationship("DCNodes", "DCNode", "0..*", "0..1"),
        CIMRelationship("DCTerminals", "DCBaseTerminal", "0..*", "0..1"),
        CIMRelationship("DCTopologicalIsland", "DCTopologicalIsland", "0..1", "1..*")
    )
    val DCEquipmentContainer: Fielder = parse_attribute(attribute(cls, fields(0)))
    val DCNodes: FielderMultiple = parse_attributes(attribute(cls, fields(1)))
    val DCTerminals: FielderMultiple = parse_attributes(attribute(cls, fields(2)))
    val DCTopologicalIsland: Fielder = parse_attribute(attribute(cls, fields(3)))

    def parse (context: CIMContext): DCTopologicalNode =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DCTopologicalNode(
            IdentifiedObject.parse(context),
            mask(DCEquipmentContainer(), 0),
            masks(DCNodes(), 1),
            masks(DCTerminals(), 2),
            mask(DCTopologicalIsland(), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DCTopologicalNode] = DCTopologicalNodeSerializer
}

object DCTopologicalNodeSerializer extends CIMSerializer[DCTopologicalNode]
{
    def write (kryo: Kryo, output: Output, obj: DCTopologicalNode): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeString(obj.DCEquipmentContainer),
            () => writeList(obj.DCNodes, output),
            () => writeList(obj.DCTerminals, output),
            () => output.writeString(obj.DCTopologicalIsland)
        )
        IdentifiedObjectSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DCTopologicalNode]): DCTopologicalNode =
    {
        val parent = IdentifiedObjectSerializer.read(kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = DCTopologicalNode(
            parent,
            if (isSet(0)) input.readString else null,
            if (isSet(1)) readList(input) else null,
            if (isSet(2)) readList(input) else null,
            if (isSet(3)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Common type for per-length electrical catalogues describing DC line parameters.
 *
 * @param PerLengthLineParameter [[ch.ninecode.model.PerLengthLineParameter PerLengthLineParameter]] Reference to the superclass object.
 * @param capacitance            Capacitance per unit of length of the DC line segment; significant for cables only.
 * @param inductance             Inductance per unit of length of the DC line segment.
 * @param resistance             Resistance per length of the DC line segment.
 * @param DCLineSegments         [[ch.ninecode.model.DCLineSegment DCLineSegment]] All line segments described by this set of per-length parameters.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class PerLengthDCLineParameter
(
    PerLengthLineParameter: PerLengthLineParameter = null,
    capacitance: Double = 0.0,
    inductance: Double = 0.0,
    resistance: Double = 0.0,
    DCLineSegments: List[String] = null
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
    override def sup: PerLengthLineParameter = PerLengthLineParameter

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
        implicit val clz: String = PerLengthDCLineParameter.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(PerLengthDCLineParameter.fields(position), value)

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(PerLengthDCLineParameter.fields(position), x))

        emitelem(0, capacitance)
        emitelem(1, inductance)
        emitelem(2, resistance)
        emitattrs(3, DCLineSegments)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:PerLengthDCLineParameter rdf:%s=\"%s\">\n%s\t</cim:PerLengthDCLineParameter>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object PerLengthDCLineParameter
    extends
        CIMParseable[PerLengthDCLineParameter]
{
    override val fields: Array[String] = Array[String](
        "capacitance",
        "inductance",
        "resistance",
        "DCLineSegments"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("DCLineSegments", "DCLineSegment", "0..*", "0..1")
    )
    val capacitance: Fielder = parse_element(element(cls, fields(0)))
    val inductance: Fielder = parse_element(element(cls, fields(1)))
    val resistance: Fielder = parse_element(element(cls, fields(2)))
    val DCLineSegments: FielderMultiple = parse_attributes(attribute(cls, fields(3)))

    def parse (context: CIMContext): PerLengthDCLineParameter =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PerLengthDCLineParameter(
            PerLengthLineParameter.parse(context),
            toDouble(mask(capacitance(), 0)),
            toDouble(mask(inductance(), 1)),
            toDouble(mask(resistance(), 2)),
            masks(DCLineSegments(), 3)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[PerLengthDCLineParameter] = PerLengthDCLineParameterSerializer
}

object PerLengthDCLineParameterSerializer extends CIMSerializer[PerLengthDCLineParameter]
{
    def write (kryo: Kryo, output: Output, obj: PerLengthDCLineParameter): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.capacitance),
            () => output.writeDouble(obj.inductance),
            () => output.writeDouble(obj.resistance),
            () => writeList(obj.DCLineSegments, output)
        )
        PerLengthLineParameterSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PerLengthDCLineParameter]): PerLengthDCLineParameter =
    {
        val parent = PerLengthLineParameterSerializer.read(kryo, input, classOf[PerLengthLineParameter])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = PerLengthDCLineParameter(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The P-Q capability curve for a voltage source converter, with P on X-axis and Qmin and Qmax on Y1-axis and Y2-axis.
 *
 * @param Curve              [[ch.ninecode.model.Curve Curve]] Reference to the superclass object.
 * @param VsConverterDCSides [[ch.ninecode.model.VsConverter VsConverter]] All converters with this capability curve.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class VsCapabilityCurve
(
    Curve: Curve = null,
    VsConverterDCSides: List[String] = null
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
    override def sup: Curve = Curve

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
        implicit val clz: String = VsCapabilityCurve.cls

        def emitattrs (position: Int, value: List[String]): Unit = if (mask(position) && (null != value)) value.foreach(x => emit_attribute(VsCapabilityCurve.fields(position), x))

        emitattrs(0, VsConverterDCSides)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:VsCapabilityCurve rdf:%s=\"%s\">\n%s\t</cim:VsCapabilityCurve>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object VsCapabilityCurve
    extends
        CIMParseable[VsCapabilityCurve]
{
    override val fields: Array[String] = Array[String](
        "VsConverterDCSides"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("VsConverterDCSides", "VsConverter", "0..*", "0..1")
    )
    val VsConverterDCSides: FielderMultiple = parse_attributes(attribute(cls, fields(0)))

    def parse (context: CIMContext): VsCapabilityCurve =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = VsCapabilityCurve(
            Curve.parse(context),
            masks(VsConverterDCSides(), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[VsCapabilityCurve] = VsCapabilityCurveSerializer
}

object VsCapabilityCurveSerializer extends CIMSerializer[VsCapabilityCurve]
{
    def write (kryo: Kryo, output: Output, obj: VsCapabilityCurve): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => writeList(obj.VsConverterDCSides, output)
        )
        CurveSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[VsCapabilityCurve]): VsCapabilityCurve =
    {
        val parent = CurveSerializer.read(kryo, input, classOf[Curve])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = VsCapabilityCurve(
            parent,
            if (isSet(0)) readList(input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * DC side of the voltage source converter (VSC).
 *
 * @param ACDCConverter        [[ch.ninecode.model.ACDCConverter ACDCConverter]] Reference to the superclass object.
 * @param delta                Angle between VsConverter.uv and ACDCConverter.uc.
 *                             It is converter’s state variable used in power flow. The attribute shall be a positive value or zero.
 * @param droop                Droop constant.
 *                             The pu value is obtained as D [kV/MW] x Sb / Ubdc. The attribute shall be a positive value.
 * @param droopCompensation    Compensation constant.
 *                             Used to compensate for voltage drop when controlling voltage at a distant bus. The attribute shall be a positive value.
 * @param maxModulationIndex   The maximum quotient between the AC converter voltage (Uc) and DC voltage (Ud).
 *                             A factor typically less than 1. It is converter’s configuration data used in power flow.
 * @param maxValveCurrent      The maximum current through a valve.
 *                             It is converter’s configuration data.
 * @param pPccControl          Kind of control of real power and/or DC voltage.
 * @param qPccControl          Kind of reactive power control.
 * @param qShare               Reactive power sharing factor among parallel converters on Uac control.
 *                             The attribute shall be a positive value or zero.
 * @param targetPWMfactor      Magnitude of pulse-modulation factor.
 *                             The attribute shall be a positive value.
 * @param targetPhasePcc       Phase target at AC side, at point of common coupling.
 *                             The attribute shall be a positive value.
 * @param targetPowerFactorPcc Power factor target at the AC side, at point of common coupling.
 *                             The attribute shall be a positive value.
 * @param targetQpcc           Reactive power injection target in AC grid, at point of common coupling.
 *                             Load sign convention is used, i.e. positive sign means flow out from a node.
 * @param targetUpcc           Voltage target in AC grid, at point of common coupling.
 *                             The attribute shall be a positive value.
 * @param uv                   Line-to-line voltage on the valve side of the converter transformer.
 *                             It is converter’s state variable, result from power flow. The attribute shall be a positive value.
 * @param CapabilityCurve      [[ch.ninecode.model.VsCapabilityCurve VsCapabilityCurve]] Capability curve of this converter.
 * @param VSCDynamics          [[ch.ninecode.model.VSCDynamics VSCDynamics]] Voltage source converter dynamics model used to describe dynamic behaviour of this converter.
 * @group DC
 * @groupname DC Package DC
 * @groupdesc DC This package contains model for direct current equipment and controls.
 */
final case class VsConverter
(
    ACDCConverter: ACDCConverter = null,
    delta: Double = 0.0,
    droop: Double = 0.0,
    droopCompensation: Double = 0.0,
    maxModulationIndex: Double = 0.0,
    maxValveCurrent: Double = 0.0,
    pPccControl: String = null,
    qPccControl: String = null,
    qShare: Double = 0.0,
    targetPWMfactor: Double = 0.0,
    targetPhasePcc: Double = 0.0,
    targetPowerFactorPcc: Double = 0.0,
    targetQpcc: Double = 0.0,
    targetUpcc: Double = 0.0,
    uv: Double = 0.0,
    CapabilityCurve: String = null,
    VSCDynamics: String = null
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
    override def sup: ACDCConverter = ACDCConverter

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
        implicit val clz: String = VsConverter.cls

        def emitelem (position: Int, value: Any): Unit = if (mask(position)) emit_element(VsConverter.fields(position), value)

        def emitattr (position: Int, value: Any): Unit = if (mask(position)) emit_attribute(VsConverter.fields(position), value)

        emitelem(0, delta)
        emitelem(1, droop)
        emitelem(2, droopCompensation)
        emitelem(3, maxModulationIndex)
        emitelem(4, maxValveCurrent)
        emitattr(5, pPccControl)
        emitattr(6, qPccControl)
        emitelem(7, qShare)
        emitelem(8, targetPWMfactor)
        emitelem(9, targetPhasePcc)
        emitelem(10, targetPowerFactorPcc)
        emitelem(11, targetQpcc)
        emitelem(12, targetUpcc)
        emitelem(13, uv)
        emitattr(14, CapabilityCurve)
        emitattr(15, VSCDynamics)
        s.toString
    }

    override def export: String =
    {
        "\t<cim:VsConverter rdf:%s=\"%s\">\n%s\t</cim:VsConverter>".format(if (about) "about" else "ID", id, export_fields)
    }
}

object VsConverter
    extends
        CIMParseable[VsConverter]
{
    override val fields: Array[String] = Array[String](
        "delta",
        "droop",
        "droopCompensation",
        "maxModulationIndex",
        "maxValveCurrent",
        "pPccControl",
        "qPccControl",
        "qShare",
        "targetPWMfactor",
        "targetPhasePcc",
        "targetPowerFactorPcc",
        "targetQpcc",
        "targetUpcc",
        "uv",
        "CapabilityCurve",
        "VSCDynamics"
    )
    override val relations: List[CIMRelationship] = List(
        CIMRelationship("CapabilityCurve", "VsCapabilityCurve", "0..1", "0..*"),
        CIMRelationship("VSCDynamics", "VSCDynamics", "0..1", "1")
    )
    val delta: Fielder = parse_element(element(cls, fields(0)))
    val droop: Fielder = parse_element(element(cls, fields(1)))
    val droopCompensation: Fielder = parse_element(element(cls, fields(2)))
    val maxModulationIndex: Fielder = parse_element(element(cls, fields(3)))
    val maxValveCurrent: Fielder = parse_element(element(cls, fields(4)))
    val pPccControl: Fielder = parse_attribute(attribute(cls, fields(5)))
    val qPccControl: Fielder = parse_attribute(attribute(cls, fields(6)))
    val qShare: Fielder = parse_element(element(cls, fields(7)))
    val targetPWMfactor: Fielder = parse_element(element(cls, fields(8)))
    val targetPhasePcc: Fielder = parse_element(element(cls, fields(9)))
    val targetPowerFactorPcc: Fielder = parse_element(element(cls, fields(10)))
    val targetQpcc: Fielder = parse_element(element(cls, fields(11)))
    val targetUpcc: Fielder = parse_element(element(cls, fields(12)))
    val uv: Fielder = parse_element(element(cls, fields(13)))
    val CapabilityCurve: Fielder = parse_attribute(attribute(cls, fields(14)))
    val VSCDynamics: Fielder = parse_attribute(attribute(cls, fields(15)))

    def parse (context: CIMContext): VsConverter =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = VsConverter(
            ACDCConverter.parse(context),
            toDouble(mask(delta(), 0)),
            toDouble(mask(droop(), 1)),
            toDouble(mask(droopCompensation(), 2)),
            toDouble(mask(maxModulationIndex(), 3)),
            toDouble(mask(maxValveCurrent(), 4)),
            mask(pPccControl(), 5),
            mask(qPccControl(), 6),
            toDouble(mask(qShare(), 7)),
            toDouble(mask(targetPWMfactor(), 8)),
            toDouble(mask(targetPhasePcc(), 9)),
            toDouble(mask(targetPowerFactorPcc(), 10)),
            toDouble(mask(targetQpcc(), 11)),
            toDouble(mask(targetUpcc(), 12)),
            toDouble(mask(uv(), 13)),
            mask(CapabilityCurve(), 14),
            mask(VSCDynamics(), 15)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[VsConverter] = VsConverterSerializer
}

object VsConverterSerializer extends CIMSerializer[VsConverter]
{
    def write (kryo: Kryo, output: Output, obj: VsConverter): Unit =
    {
        val toSerialize: Array[() => Unit] = Array(
            () => output.writeDouble(obj.delta),
            () => output.writeDouble(obj.droop),
            () => output.writeDouble(obj.droopCompensation),
            () => output.writeDouble(obj.maxModulationIndex),
            () => output.writeDouble(obj.maxValveCurrent),
            () => output.writeString(obj.pPccControl),
            () => output.writeString(obj.qPccControl),
            () => output.writeDouble(obj.qShare),
            () => output.writeDouble(obj.targetPWMfactor),
            () => output.writeDouble(obj.targetPhasePcc),
            () => output.writeDouble(obj.targetPowerFactorPcc),
            () => output.writeDouble(obj.targetQpcc),
            () => output.writeDouble(obj.targetUpcc),
            () => output.writeDouble(obj.uv),
            () => output.writeString(obj.CapabilityCurve),
            () => output.writeString(obj.VSCDynamics)
        )
        ACDCConverterSerializer.write(kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields(output)
        writeFields(toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[VsConverter]): VsConverter =
    {
        val parent = ACDCConverterSerializer.read(kryo, input, classOf[ACDCConverter])
        implicit val bitfields: Array[Int] = readBitfields(input)
        val obj = VsConverter(
            parent,
            if (isSet(0)) input.readDouble else 0.0,
            if (isSet(1)) input.readDouble else 0.0,
            if (isSet(2)) input.readDouble else 0.0,
            if (isSet(3)) input.readDouble else 0.0,
            if (isSet(4)) input.readDouble else 0.0,
            if (isSet(5)) input.readString else null,
            if (isSet(6)) input.readString else null,
            if (isSet(7)) input.readDouble else 0.0,
            if (isSet(8)) input.readDouble else 0.0,
            if (isSet(9)) input.readDouble else 0.0,
            if (isSet(10)) input.readDouble else 0.0,
            if (isSet(11)) input.readDouble else 0.0,
            if (isSet(12)) input.readDouble else 0.0,
            if (isSet(13)) input.readDouble else 0.0,
            if (isSet(14)) input.readString else null,
            if (isSet(15)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _DC
{
    def register: List[CIMClassInfo] =
    {
        List(
            ACDCConverter.register,
            ACDCConverterDCTerminal.register,
            CsConverter.register,
            DCBaseTerminal.register,
            DCBreaker.register,
            DCBusbar.register,
            DCChopper.register,
            DCConductingEquipment.register,
            DCConverterUnit.register,
            DCDisconnector.register,
            DCEquipmentContainer.register,
            DCGround.register,
            DCLine.register,
            DCLineSegment.register,
            DCNode.register,
            DCSeriesDevice.register,
            DCShunt.register,
            DCSwitch.register,
            DCTerminal.register,
            DCTopologicalIsland.register,
            DCTopologicalNode.register,
            PerLengthDCLineParameter.register,
            VsCapabilityCurve.register,
            VsConverter.register
        )
    }
}
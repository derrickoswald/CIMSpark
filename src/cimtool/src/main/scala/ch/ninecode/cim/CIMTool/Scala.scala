package ch.ninecode.cim.CIMTool

import scala.collection.mutable.Set
import scala.collection.mutable.SortedSet

case class Scala (parser: ModelParser, pkg: Package)
{
    val parses: Iterable[(String, String)] =
    {
        val ret = Set[(String, String)]()

        for (cls <- parser.classes.filter (_._2.pkg == pkg))
            ret.add (("cim:" + cls._2.name, "parse_" + cls._2.name.replace ("-", "_")))

        ret
    }

    def valid_class_name (s: String): String =
    {
        val name = s match
        {
            // ToDo: all keywords
            case "type" => "typ"
            case "val" => "_val"
            case "class" => "_class"
            case "%" => "percent"
            case "length" => "len"
            case "" => "attr" // ToDo: WTF?
            case _ => 
                val identifier = (if (s.charAt (0).isDigit) "_" else "") +
                s.replace (" ", "_").replace ("-", "_").replace ("""/""", """_""").replace (""".""", """_""").replace (""",""", """_""")
                if (identifier.endsWith ("_")) identifier + "1" else identifier
        }
        if (name == "Unit")
            "Unit_"
        else
            name
    }

    def valid_attribute_name (attribute: Attribute): String =
    {
        val s = attribute.name
        val name = s match
        {
            // ToDo: all keywords
            case "type" => "typ"
            case "val" => "_val"
            case "class" => "_class"
            case "%" => "percent"
            case "length" => "len"
            case "size" => "size1"
            case "lock" => "lock1"
            case "" => "attr" // ToDo: WTF?
            case _ => 
                val identifier = (if (s.charAt (0).isDigit) "_" else "") +
                s.replace (" ", "_").replace ("-", "_").replace ("""/""", """_""").replace (""".""", """_""").replace (""",""", """_""").replace (""":""", """_""").replace ("""(""", """_""").replace (""")""", """_""")
                if (identifier.endsWith ("_")) identifier + "1" else identifier
        }
        val stupid_name =
            if (name == attribute.cls.name)
                name + "_attr"
            else if ((attribute.cls.sup != null) && (name == attribute.cls.sup.name))
                name + "_attr"
            else
                name
        stupid_name
    }

    def valid_role_name (role: Role): String =
    {
        val s = role.name
        val name = s match
        {
            // ToDo: all keywords
            case "type" => "typ"
            case "val" => "_val"
            case "class" => "_class"
            case "%" => "percent"
            case "length" => "len"
            case "" => "attr" // ToDo: WTF?
            case _ => 
                val identifier = (if (s.charAt (0).isDigit) "_" else "") +
                s.replace (" ", "_").replace ("-", "_").replace ("""/""", """_""").replace (""".""", """_""").replace (""",""", """_""")
                if (identifier.endsWith ("_")) identifier + "1" else identifier
        }
        val stupid_name =
            if (name == role.src.name)
                name + "_attr"
            else if ((role.src.sup != null) && (name == role.src.sup.name))
                name + "_attr"
            else
                name
        stupid_name
    }

    val register: String =
    {
        "_" + valid_class_name (pkg.name)
    }

    def details (attribute: Attribute): Member =
    {
        val name = attribute.name
        val variable = valid_attribute_name (attribute)
        val comment = attribute.notes
        parser.domains.find (_.name == attribute.typ) match
        {
            case Some (dom) =>
                dom.name match
                {
                    case "Time" => Member (name, variable, false, comment, false, false, "String", "null", "")
                    case "Integer" => Member (name, variable, false, comment, false, false, "Int", "0", "toInteger")
                    case "Float" => Member (name, variable, false, comment, false, false, "Double", "0.0", "toDouble")
                    case "Decimal" => Member (name, variable, false, comment, false, false, "Double", "0.0", "toDouble")
                    case "Boolean" => Member (name, variable, false, comment, false, false, "Boolean", "false", "toBoolean")
                    case "Date" => Member (name, variable, false, comment, false, false, "String", "null", "")
                    case "Duration" => Member (name, variable, false, comment, false, false, "String", "null", "")
                    case "String" => Member (name, variable, false, comment, false, false, "String", "null", "")
                    case "DateTime" => Member (name, variable, false, comment, false, false, "String", "null", "")
                    case "MonthDay" => Member (name, variable, false, comment, false, false, "String", "null", "")
                    case _ =>
                        dom.value match
                            {
                                case "Time" => Member (name, variable, false, comment, false, false, "String", "null", "")
                                case "Integer" => Member (name, variable, false, comment, false, false, "Int", "0", "toInteger")
                                case "Float" => Member (name, variable, false, comment, false, false, "Double", "0.0", "toDouble")
                                case "Decimal" => Member (name, variable, false, comment, false, false, "Double", "0.0", "toDouble")
                                case "Boolean" => Member (name, variable, false, comment, false, false, "Boolean", "false", "toBoolean")
                                case "Date" => Member (name, variable, false, comment, false, false, "String", "null", "")
                                case "Duration" => Member (name, variable, false, comment, false, false, "String", "null", "")
                                case "String" => Member (name, variable, false, comment, false, false, "String", "null", "")
                                case "DateTime" => Member (name, variable, false, comment, false, false, "String", "null", "")
                                case "MonthDay" => Member (name, variable, false, comment, false, false, "String", "null", "")
                                case _ =>
                                    if (dom.stereotype == "enumeration")
                                        Member (name, variable, false, comment, true, false, "String", "null", "")
                                    else
                                        Member (name, variable, false, comment, false, false, "String", "null", "")
                            }
                }
            case None => Member (name, variable, false, comment, true, false, "String", "null", "")
        }
    }

    def details (role: Role): Member =
    {
        val name = role.name
        val variable = valid_role_name (role)
        val comment = role.note
        if (role.upper == 1)
            Member (name, variable, false, comment, true, false, "String", "null", "")
        else
            Member (name, variable, false, comment, true, true, "List[String]", "List()", "")
    }

//val valid_classes = """ACLineSegment
//ACLineSegmentPhase
//AsynchronousMachine
//Breaker
//BusbarSection
//Clamp
//CompositeSwitch
//Conductor
//Connector
//Cut
//Disconnector
//EarthFaultCompensator
//EnergyConsumer
//EnergyConsumerPhase
//EnergySource
//ExternalNetworkInjection
//FrequencyConverter
//Fuse
//Ground
//GroundDisconnector
//GroundingImpedance
//Jumper
//Junction
//Line
//LinearShuntCompensator
//LinearShuntCompensatorPhase
//LoadBreakSwitch
//MutualCoupling
//NonLinearShuntCompensator
//NonLinearShuntCompensatorPhase
//NonlinearShuntCompensatorPhasePoint
//NonlinearShuntCompensatorPoint
//PerLengthImpedance
//PerLengthLineParameter
//PerLengthPhaseImpedance
//PerLengthSequenceImpedance
//PetersenCoil
//PhaseImpedanceData
//PhaseTapChanger
//PhaseTapChangerAsymmetrical
//PhaseTapChangerLinear
//PhaseTapChangerNonLinear
//PhaseTapChangerSymmetrical
//PhaseTapChangerTable
//PhaseTapChangerTablePoint
//PhaseTapChangerTabular
//Plant
//PowerTransformer
//PowerTransformerEnd
//ProtectedSwitch
//RatioTapChanger
//RatioTapChangerTable
//RatioTapChangerTablePoint
//ReactiveCapabilityCurve
//Recloser
//RegulatingCondEq
//RegulatingControl
//RegulationSchedule
//RotatingMachine
//Sectionaliser
//SeriesCompensator
//ShuntCompensator
//ShuntCompensatorPhase
//StaticVarCompensator
//Switch
//SwitchPhase
//SwitchSchedule
//SynchronousMachine
//TapChanger
//TapChangerControl
//TapChangerTablePoint
//TapSchedule
//TransformerCoreAdmittance
//TransformerEnd
//TransformerMeshImpedance
//TransformerStarImpedance
//TransformerTank
//TransformerTankEnd
//VoltageControlZone
//Diagram
//DiagramObject
//DiagramObjectGluePoint
//DiagramObjectPoint
//DiagramObjectStyle
//DiagramStyle
//TextDiagramObject
//VisibilityLayer
//StringQuantity
//SeasonDayTypeSchedule
//GeneratingUnit
//SolarGeneratingUnit
//BusNameMarker
//DCTopologicalNode
//TopologicalIsland
//TopologicalNode
//AssetPropertyCurve
//Bushing
//BushingInsulationPF
//Cabinet
//CoolingPowerRating
//DimensionsInfo
//DuctBank
//FACTSDevice
//Facility
//FailureEvent
//FinancialInfo
//GenericAssetModelOrMaterial
//Joint
//Medium
//Pole
//Reconditioning
//ReliabilityInfo
//Specification
//Streetlight
//Structure
//StructureSupport
//Tower
//TransformerObservation
//UndergroundStructure
//WindingInsulation
//ActivityRecord
//Agreement
//Appointment
//ConfigurationEvent
//CoordinateSystem
//Crew
//CrewMember
//CrewType
//Document
//ElectronicAddress
//Hazard
//Location
//OperationPersonRole
//Operator
//Organisation
//OrganisationRole
//Ownership
//Person
//PersonRole
//PositionPoint
//PostalAddress
//Priority
//ScheduledEvent
//ScheduledEventData
//Status
//StreetAddress
//StreetDetail
//TelephoneNumber
//TimePoint
//TimeSchedule
//TownDetail
//UserAttribute
//BaseReading
//Channel
//ComFunction
//ComModule
//ControlledAppliance
//DemandResponseProgram
//EndDevice
//EndDeviceAction
//EndDeviceCapability
//EndDeviceControl
//EndDeviceControlType
//EndDeviceEvent
//EndDeviceEventDetail
//EndDeviceEventType
//EndDeviceFunction
//EndDeviceGroup
//EndDeviceInfo
//EndDeviceTiming
//IntervalBlock
//IntervalReading
//Meter
//MeterMultiplier
//MeterReading
//MeterServiceWork
//MetrologyRequirement
//PanDemandResponse
//PanDisplay
//PanPricing
//PanPricingDetail
//PendingCalculation
//RationalNumber
//Reading
//ReadingInterharmonic
//ReadingQuality
//ReadingQualityType
//ReadingType
//Register
//ServiceMultiplier
//SimpleEndDeviceFunction
//UsagePoint
//UsagePointGroup
//UsagePointLocation
//CurrentRelay
//ProtectionEquipment
//Accumulator
//AccumulatorLimit
//AccumulatorLimitSet
//AccumulatorReset
//AccumulatorValue
//Analog
//AnalogControl
//AnalogLimit
//AnalogLimitSet
//AnalogValue
//Command
//Control
//Discrete
//DiscreteCommand
//DiscreteValue
//Limit
//LimitSet
//Measurement
//MeasurementValue
//MeasurementValueQuality
//MeasurementValueSource
//Quality61850
//RaiseLowerCommand
//SetPoint
//StringMeasurement
//StringMeasurementValue
//ValueAliasSet
//ValueToAlias
//Customer
//CustomerAccount
//CustomerAgreement
//PricingStructure
//ServiceCategory
//ServiceLocation
//Tariff
//BasicElement
//Unknown(
//ACDCTerminal
//BaseFrequency
//BasePower
//BaseVoltage
//BasicIntervalSchedule
//Bay
//ConductingEquipment
//ConnectivityNode
//ConnectivityNodeContainer
//Curve
//CurveData
//Equipment
//EquipmentContainer
//GeographicalRegion
//IdentifiedObject
//IrregularIntervalSchedule
//IrregularTimePoint
//Name
//NameType
//NameTypeAuthority
//OperatingParticipant
//OperatingShare
//PSRType
//PowerSystemResource
//RegularIntervalSchedule
//RegularTimePoint
//ReportingGroup
//ReportingSuperGroup
//SubGeographicalRegion
//Substation
//Terminal
//VoltageLevel
//BusbarSectionInfo
//CableInfo
//ConcentricNeutralCableInfo
//NoLoadTest
//OpenCircuitTest
//OverheadWireInfo
//PowerTransformerInfo
//ShortCircuitTest
//ShuntCompensatorInfo
//SwitchInfo
//TapChangerInfo
//TapeShieldCableInfo
//TransformerEndInfo
//TransformerTankInfo
//TransformerTest
//WireInfo
//WirePosition
//WireSpacingInfo
//MktSwitch
//StateVariable
//SvStatus
//BaseWork
//Work
//WorkLocation
//ConnectDisconnectFunction
//RemoteConnectDisconnectInfo
//AcceptanceTest
//Asset
//AssetContainer
//AssetFunction
//AssetInfo
//AssetLocationHazard
//AssetModel
//AssetOrganisationRole
//AssetOwner
//AssetUser
//ComMedia
//LifecycleDate
//Maintainer
//Manufacturer
//Procedure
//ProcedureDataSet
//ProductAssetModel
//Seal""".split ("\n")

    def asText (): String =
    {
        val classes = parser.classes.filter (x => x._2.pkg == pkg)

        implicit val ordering = new Ordering[(String, Int)]
        {
           def compare (a: (String, Int), b: (String, Int)) = a._1.compareTo (b._1)
        }
        val case_classes = SortedSet[(String,Int)]()
        for (cls <- classes)
            // special handling for Domain
            if ((pkg.name != "Domain") || (cls._2.stereotype == "Compound"))
                case_classes.add ((valid_class_name (cls._2.name), cls._1))

        val p = new StringBuilder ()
        for (c <- case_classes)
        {
            val cls = classes (c._2)
            val name = valid_class_name (cls.name)
            val identified_object = name == "IdentifiedObject" // special handling for IdentifiedObject.mRID
            def myattribute (attribute: Attribute): Boolean = attribute.name != "" // ToDo: why empty names?
            def myrole (role: Role): Boolean =
            {
                def many_to_many: Boolean = ((role.card == "0..*") && (role.mate.card == "0..*") && role.sideA)
                role.src == cls && ((role.upper == 1) || many_to_many)
            }
            implicit val ordering = new Ordering[Member]
            {
               def compare (a: Member, b: Member) =
                   if (a.name == "sup")
                       -1
                   else if (b.name == "sup")
                       1
                   else
                       if (a.variable.charAt (0).isLower)
                           if (b.variable.charAt (0).isLower)
                               a.variable.compareTo (b.variable)
                           else
                               -1
                       else
                           if (b.variable.charAt (0).isLower)
                               1
                           else
                               a.variable.compareTo (b.variable)
            }
            val sup = Member ("sup", "sup", true, "Reference to the superclass object.", false, false, if (null != cls.sup) cls.sup.name else "BasicElement", "null", "")
            val members =
                (SortedSet[Member] (sup) ++
                    parser.attributes.getOrElse (c._2, List[Attribute]()).filter (myattribute).map (details).toSet
                    .union (parser.roles.filter (myrole).map (details)))

            val s = new StringBuilder ()
            if (null != cls.note)
                s.append (JavaDoc (cls.note, 0, members).asText ())
            s.append ("case class ")
            s.append (name)
            s.append ("""
                |(
                |""".stripMargin)
            val initializers = new StringBuilder ()
            for (product <- members)
            {
                if (initializers.length > 0)
                {
                    initializers.append (", ")
                    s.append (""",
                    |""".stripMargin)
                }
                initializers.append (product.initializer)
                s.append ("""    """)
                if (product.overrid) s.append ("""override """)
                s.append ("""val """)
                s.append (product.variable)
                s.append (""": """)
                s.append (product.datatype)
            }

            s.append ("""
            |)
            |extends
            |    Element
            |{
            |    def this () = { this (""".stripMargin)
            s.append (initializers.toString)
            s.append (""") }
            |    def """.stripMargin)
            if (null != cls.sup)
            {
                s.append (cls.sup.name)
                s.append (""": """)
                s.append (cls.sup.name)
                s.append (""" = sup.asInstanceOf[""")
                s.append (cls.sup.name)
            }
            else
                s.append ("""Element: Element = sup.asInstanceOf[Element""")
            s.append ("""]
            |    override def copy (): Row = { return (clone ().asInstanceOf[""".stripMargin)
            s.append (name)
            s.append ("""]) }
            |    override def get (i: Int): Object =
            |    {
            |        if (i < productArity)
            |            productElement (i).asInstanceOf[AnyRef]
            |        else
            |            throw new IllegalArgumentException ("invalid property index " + i)
            |    }
            |    override def length: Int = productArity
            |}
            |
            |object """.stripMargin)
            s.append (name)
            s.append ("""
            |extends
            |    Parseable[""".stripMargin)
            s.append (name)
            s.append ("""]
            |{
            |""".stripMargin)
            for (product <- members)
            {
                if (product.name != "sup")
                {
                    s.append ("""    val """.stripMargin)
                    s.append (product.variable)
                    if (product.reference)
                        if (product.multiple)
                            s.append (""" = parse_attributes (attribute ("""")
                        else
                            s.append (""" = parse_attribute (attribute ("""")
                    else
                        s.append (""" = parse_element (element ("""")
                    s.append ("""""""")
                    s.append (name)
                    s.append (""".""")
                    s.append (product.name)
                    s.append ("""""""")
                    s.append (""""))
                    |""".stripMargin)
                }
            }

            s.append ("""    def parse (context: Context): """)
            s.append (name)
            s.append (""" =
            |    {
            |        """.stripMargin)
            if (identified_object)
            {
                s.append ("""val base = """)
                s.append (sup.datatype)
                s.append (""".parse (context)
                |        """.stripMargin)
            }
            s.append (name)
            s.append ("""(""")
            for (product <- members)
            {
                if (product.name != "sup") s.append (""",""")
                s.append ("""
                |            """.stripMargin)
                if (identified_object)
                {
                    if (product.name == "sup")
                    {
                        s.append ("base")
                    }
                    else if (product.name == "mRID")
                    {
                        s.append ("base.id")
                    }
                    else
                    {
                        if (product.function != "")
                        {
                            s.append (product.function)
                            s.append (""" (""")
                        }
                        s.append (product.variable)
                        s.append (""" (context)""")
                        if (product.function != "")
                            s.append (""", context)""")
                    }
                }
                else
                {
                    if (product.function != "")
                    {
                        s.append (product.function)
                        s.append (""" (""")
                    }
                    if (product.name == "sup")
                    {
                        s.append (product.datatype)
                        s.append (""".parse""")
                    }
                    else
                        s.append (product.variable)
                    s.append (""" (context)""")
                    if (product.function != "")
                        s.append (""", context)""")
                }
            }

            s.append ("""
            |        )
            |    }
            |}
            |
            |""".stripMargin)

            p.append (s)
        }

        if (case_classes.size > 0)
        {
            val v = new StringBuilder ()
            val r = scala.collection.mutable.SortedSet[String]()

            v.append ("""package ch.ninecode.model
            |
            |import org.apache.spark.sql.Row
            |
            |import ch.ninecode.cim.Context
            |import ch.ninecode.cim.Parseable
            |
            |""".stripMargin)
            v.append (JavaDoc (pkg.notes, 0).asText ())
            v.append ("""
                |""".stripMargin)
            v.append (p.toString)

            v.append ("""object """)
            v.append (register)
            v.append ("""
                |{
                |    def register: Unit =
                |    {
                |""".stripMargin)
            for (cl <- case_classes)
            {
                v.append ("""        """)
                v.append (cl._1)
                v.append (""".register
                |""".stripMargin)
            }
            v.append ("""    }
            |}""".stripMargin)

            v.toString
        }
        else
            ""
    }
}
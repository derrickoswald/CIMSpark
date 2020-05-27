package ch.ninecode

/**
 * ==Overview==
 * Provides Common Information Model (CIM) classes for electrical, topological, asset, spatial
 * and other categories of objects that are germane to electric network operations.
 *
 * Some examples are shown in the following image:
 *
 * <img src="https://cdn.jsdelivr.net/gh/derrickoswald/CIMSparkPresentation@master/img/information.svg" width="700">
 *
 * These classes are the types of, and objects contained in, the RDD that are created by the CIMReader,
 * e.g. RDD[Switch].
 *
 * Classes are nested according to the hierarchical package structure found in CIM.
 *
 * Each class has the reference to its parent class, available as the <code>sup</code> method,
 * and also as a typed reference of the same name as the parent class.
 *
 * This is illustrated in the following image, where the object with id TE1932 (a Switch) is found in
 * RDD[Switch] and all RDD for which the relation 'a Switch "Is A" <em>X</em>' holds,
 * e.g. RDD[ConductingEquipment]:
 *
 * <img src="https://cdn.jsdelivr.net/gh/derrickoswald/CIMSparkPresentation@master/img/nested.svg" width="700">
 *
 * The packages and their descriptions are itemized below.
 *
 * A short summary of all classes is found below that.
 * The classes can be ordered by package (Grouped) or alphabetically.
 * The classes are also listed in the panel on the left for easy reference.
 *
 * ===AlternateModels===
 *
 * ===AssetInfo===
 * This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses.
 *
 * They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 *
 *
 * ===AssetMeas===
 *
 * ===Assets===
 * This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 *
 *
 * ===AsynchronousMachineDynamics===
 * An asynchronous machine model represents a (induction) generator or motor with no external connection to the rotor windings, e.g. a squirrel-cage induction machine.
 *
 * The interconnection with the electrical network equations can differ among simulation tools.  The program only needs to know the terminal to which this asynchronous machine is connected in order to establish the correct interconnection.  The interconnection with the motor’s equipment could also differ due to input and output signals required by standard models.
 * The asynchronous machine model is used to model wind generators type 1 and type 2.  For these, normal practice is to include the rotor flux transients and neglect the stator flux transients.
 *
 *
 * ===AuxiliaryEquipment===
 * Contains equipment which is not normal conducting equipment such as sensors, fault locators, and surge protectors.
 *
 * These devices do not define power carrying topological connections as conducting equipment, but are associated to terminals of other conducting equipment.
 *
 *
 * ===CSC===
 *
 * ===Common===
 * This package contains the information classes that support distribution management in general.
 *
 *
 * ===CongestionRevenueRights===
 * Congestion rent is a major, highly volatile charge currently faced by many participants in the LMP-based electrical energy markets.
 *
 * For this reason, the ISOs offer congestion revenue rights (CRR), also known as financial transmission rights or transmission congestion contracts. These are financial instruments that allow market participants to hedge against congestion charges when they schedule their generation, load and bilateral energy transactions.
 *
 *
 * ===Contingency===
 * Contingencies to be studied.
 *
 *
 * ===ControlArea===
 * The ControlArea package models area specifications which can be used for a variety of purposes.
 *
 * The package as a whole models potentially overlapping control area specifications for the purpose of actual generation control, load forecast area load capture, or powerflow based analysis.
 *
 *
 * ===Core===
 * Contains the core PowerSystemResource and ConductingEquipment entities shared by all applications plus common collections of those entities.
 *
 * Not all applications require all the Core entities.  This package does not depend on any other package except the Domain package, but most of the other packages have associations and generalizations that depend on it.
 *
 *
 * ===Customers===
 * This package contains the core information classes that support customer billing applications.
 *
 *
 * ===DC===
 * This package contains model for direct current equipment and controls.
 *
 *
 * ===DER===
 *
 * ===DiagramLayout===
 * This package describes diagram layout.
 *
 * This describes how objects are arranged in a coordinate system rather than how they are rendered.
 *
 *
 * ===DiscontinuousExcitationControlDynamics===
 * In certain system configurations, continuous excitation control with terminal voltage and power system stabilizing regulator input signals does not ensure that the potential of the excitation system for improving system stability is fully exploited.
 *
 * For these situations, discontinuous excitation control signals can be employed to enhance stability following large transient disturbances.
 * <font color="#0f0f0f">For additional information please refer to IEEE 421.5-2005, 12.</font>
 *
 *
 * ===Domain===
 * The domain package defines primitive datatypes that are used by classes in other packages.
 *
 * Stereotypes are used to describe the datatypes. The following stereotypes are defined:
 * &lt;&lt;enumeration&gt;&gt; A list of permissible constant values.
 * &lt;&lt;Primitive&gt;&gt; The most basic data types used to compose all other data types.
 * &lt;&lt;CIMDatatype&gt;&gt; A datatype that contains a value attribute, an optional unit of measure and a unit multiplier. The unit and multiplier may be specified as a static variable initialized to the allowed value.
 * &lt;&lt;Compound&gt;&gt; A composite of Primitive, enumeration, CIMDatatype or other Compound classes, as long as the Compound classes do not recurse.
 * For all datatypes both positive and negative values are allowed unless stated otherwise for a particular datatype.
 *
 *
 * ===EnergyArea===
 *
 * ===EnvDomain===
 *
 * ===Environmental===
 *
 * ===Equivalents===
 * The equivalents package models equivalent networks.
 *
 *
 * ===ExcitationSystemDynamics===
 * The excitation system model provides the field voltage (<i>Efd</i>) for a synchronous machine model.
 *
 * It is linked to a specific generator (synchronous machine).
 * The representation of all limits used by the models (not including IEEE standard models) shall comply with the representation defined in the Annex E of the IEEE 421.5-2005, unless specified differently in the documentation of the model.
 * The parameters are different for each excitation system model; the same parameter name can have different meaning in different models.
 *
 *
 * ===ExternalInputs===
 * Inputs to the market system from external sources.
 *
 *
 * ===Faults===
 * The package describes faults that may happen to conducting equipment, e.g. tree falling on a power line.
 *
 *
 * ===Feeder===
 *
 * ===GenerationTrainingSimulation===
 * The GenerationTrainingSimululation package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 *
 *
 * ===GenericDataSet===
 * Contains classes used for generic dataset modelling.
 *
 *
 * ===HVDCDynamics===
 * High voltage direct current (HVDC) models.
 *
 *
 * ===ICCPConfiguration===
 * This package models configuration of ICCP required for bilateral exchanges.
 *
 *
 * ===IEC61968===
 * The IEC 61968 subpackages of the CIM are developed, standardized and maintained by IEC TC57 Working Group 14: interfaces for distribution management (WG14).
 *
 * Currently, normative parts of the model support the needs of information exchange defined in IEC 61968-3, IEC 61968-4, IEC 61968-9 and in IEC 61968-13.
 *
 *
 * ===IEC61970===
 * Top package for IEC 61970.
 *
 *
 * ===IEC62325===
 * The IEC 62325 subpackages of the CIM are developed, standardized and maintained by the IEC TC57.
 *
 *
 * ===InfAssetInfo===
 *
 * ===InfAssets===
 * The package is used to define asset-level models for objects.
 *
 * Assets may be comprised of other assets and may have relationships to other assets. Assets also have owners and values. Assets may also have a relationship to a PowerSystemResource in the Wires model.
 *
 * TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 * "Assets are the basic units which define a physical infrastructure. PowerSystemResources are logical objects meaningful to operations which are constructed from one or more Assets, although PowerSystemResources are not required to specifiy their component Assets.
 * The Asset package is comprosed of several packages. The key concepts of an Asset are as follows:
 * <ul>
 * <li>Assets can have names, through inheritance to the Naming package</li>
 * <li>Assets are physical entities which have a lifecycle</li>
 * <li>One or more assets can be associated to create a PowerSystemResource</li>
 * <li>Assets can be grouped (aggregated) with other Assets</li>
 * <li>Assets are typically either 'point' or 'linear' assets, which relate to physical geometry</li>
 * <li>Assets have a close relationship to Work as a consequence of their lifecycle</li>
 * </ul>
 * The following sections describe the packages in the Assets package.
 * The AssetBasics package defines the relationship between Asset and other classes, such as Organization, PowerSystemResource and Document.
 * Point assets are those assets whose physical location can be described in terms of a single coordinate, such as a pole or a switch.
 * Linear assets are those assets whose physical location is best described in terms of a line, plyline or polygon.
 * Asset work triggers are used to determine when inspection and/or maintenance are required for assets".
 *
 *
 * ===InfAvailabilityPlans===
 * Contains the planned schedules for equipment availability, primarily intended for future studies.
 *
 *
 * ===InfCommon===
 * This package contains functions common for distribution management.
 *
 *
 * ===InfCongestionRevenueRights===
 *
 * ===InfCustomers===
 * The package is used to define detailed customer models.
 *
 *
 * ===InfDomain===
 *
 * ===InfERPSupport===
 * The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG).
 *
 * It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 * If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeld "Erp..." should be associated with the appropriate classes of that standard. In fact, definitions of "Erp..." classes are based on OAG Nouns to facilitate this process.
 *
 * TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 * "The Enterprise Resource Planning (ERP) Support Package contains portions of the model defined by ERP standards like those proposed by the Open Applications Group (OAG). This package is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 * If a model other that the OAG standard is used as a basis for ERP integration, the utility classes labeled "Erp..." should be associated with the appropriate classes of that standard".
 *
 *
 * ===InfEnergyScheduling===
 * This package provides the capability to schedule and account for transactions for the exchange of electric power between companies.
 *
 * It includes transations for megawatts which are generated, consumed, lost, passed through, sold and purchased. These classes are used by Accounting and Billing for Energy, Generation Capacity, Transmission, and Ancillary Services.
 *
 *
 * ===InfExternalInputs===
 *
 * ===InfFinancial===
 * This package is responsible for Settlement and Billing.
 *
 * These classes represent the legal entities who participate in formal or informal agreements.
 *
 *
 * ===InfHVDCDynamics===
 *
 * ===InfLocations===
 *
 * ===InfMarketOpCommon===
 *
 * ===InfMarketOperations===
 *
 * ===InfMarketResults===
 *
 * ===InfOperationalLimits===
 * The description of computed or dynamic limits.
 *
 * These classes would likely go into the OperationalLimits package.
 *
 *
 * ===InfParticipantInterfaces===
 *
 * ===InfReferenceData===
 *
 * ===InfReservation===
 *
 * ===InfSIPS===
 * System Integrity Protection Schemes (SIPS) (IEC terminology).
 *
 * Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS).
 *
 *
 * ===InfTypeAsset===
 *
 * ===InfWiresExt===
 *
 * ===InfWork===
 * The package covers all types of work, including inspection, maintenance, repair, restoration, and construction.
 *
 * It covers the full life cycle including request, initiate, track and record work. Standardized designs (compatible units) are used where possible.
 *
 * TODO: The following has been copied from a very old version of draft Part 11, so the references are wrong, but we store the knowledge here to reuse later:
 * "The Work package is used to define classes related to work. There are several different aspects of work.
 * The Work Initiation (Work, Project, Request).
 * The Work Design package is used for managing designs (CompatibleUnit, Design, DesignLocation, WorkTask).
 * The Work Schedule package is used for the scheduling and coordination of work (AccessPermit, MaterialItem, OneCallRequest, Regulation).
 * The Work Closing package is used for tracking costs of work (CostType, LaborItem, WorkCostDetail, VehicleItem).
 * The Work Standards package is used for the definition of compatible units (CULaborItem, CUVehicleItem, CUGroup).
 * This package is used for inspection and maintenance (InspectionDataSet, Procedure).
 * The WorkService package defines Appointment class".
 *
 *
 * ===LoadControl===
 * This package is an extension of the Metering package and contains the information classes that support specialised applications such as demand-side management using load control equipment.
 *
 * These classes are generally associated with the point where a service is delivered to the customer.
 *
 *
 * ===LoadDynamics===
 * Dynamic load models are used to represent the dynamic real and reactive load behaviour of a load from the static power flow model.
 *
 * Dynamic load models can be defined as applying either to a single load (energy consumer) or to a group of energy consumers.
 * Large industrial motors or groups of similar motors can be represented by a synchronous machine model (SynchronousMachineDynamics) or an asynchronous machine model (AsynchronousMachineDynamics), which are usually represented as generators with negative active power output in the static (power flow) data.
 *
 *
 * ===LoadModel===
 * This package is responsible for modelling the energy consumers and the system load as curves and associated curve data.
 *
 * Special circumstances that may affect the load, such as seasons and day types, are also included here.
 *
 * This information is used by Load Forecasting and Load Management.
 *
 *
 * ===MarketCommon===
 * This package contains the common objects shared by MarketManagement, MarketOperations and Environmental packages.
 *
 *
 * ===MarketManagement===
 * This package contains all core CIM Market Extensions required for market management systems.
 *
 *
 * ===MarketOpCommon===
 * This package contains the common objects shared by MarketOperations packages.
 *
 *
 * ===MarketPlan===
 * Market plan definitions for planned markets, planned market events, actual market runs, actual market events.
 *
 *
 * ===MarketQualitySystem===
 * Post-market accounting, calculation and meter data corrections to reduce invoicing errors and disputes.
 *
 * Reduces manual validation, verification and correction of transactional data that could affect market settlements. Republishing of market results with affected data corrected.
 *
 *
 * ===MarketResults===
 * Results from the execution of a market.
 *
 *
 * ===Meas===
 * Contains entities that describe dynamic measurement data exchanged between applications.
 *
 *
 * ===MechanicalLoadDynamics===
 * A mechanical load represents the variation in a motor's shaft torque or power as a function of shaft speed.
 *
 *
 * ===Metering===
 * This package contains the core information classes that support end device applications with specialized classes for metering and premises area network devices, and remote reading functions.
 *
 * These classes are generally associated with the point where a service is delivered to the customer.
 *
 *
 * ===ModelOperations===
 *
 * ===NetworkModelFrames===
 *
 * ===NetworkModelProjects===
 * Defining meta-data for a change set in the functional Power System model.
 *
 *
 * ===OperationalLimits===
 * This package models a specification of limits associated with equipment and other operational entities.
 *
 *
 * ===Operations===
 * This package contains the core information classes that support operations and outage management applications.
 *
 *
 * ===OverexcitationLimiterDynamics===
 * Overexcitation limiters (OELs) are also referred to as <i>maximum excitation limiters </i>and <i>field current limiters. </i>The possibility of voltage collapse in stressed power systems increases the importance of modelling these limiters in studies of system conditions that cause machines to operate at high levels of excitation for a sustained period, such as voltage collapse or system-islanding.
 *
 * Such events typically occur over a long time frame compared with transient or small-signal stability simulations.
 *
 *
 * ===PFVArControllerType1Dynamics===
 * <font color="#0f0f0f">Excitation systems for synchronous machines are sometimes supplied with an optional means of automatically adjusting generator output reactive power (VAr) or power factor (PF) to a user-specified value.
 *
 * This can be accomplished with either a reactive power or power factor controller or regulator.  A reactive power or power factor controller is defined as a PF/VAr controller in IEEE 421.1 as “a control function that acts through the reference adjuster to modify the voltage regulator set point to maintain the synchronous machine steady-state power factor or reactive power at a predetermined value.” </font>
 * <font color="#0f0f0f">For additional information please refer to IEEE 421.5-2005, 11.</font>
 *
 *
 * ===PFVArControllerType2Dynamics===
 * <font color="#0f0f0f">A var/pf regulator is defined as “a synchronous machine regulator that functions to maintain the power factor or reactive component of power at a predetermined value.”  </font>
 * <font color="#0f0f0f">For additional information please refer to IEEE 421.5-2005, 11.</font>
 * <font color="#0f0f0f">
 *
 * </font>
 *
 *
 * ===PackageDependencies===
 * This package shows all the root level subpackage dependencies of the combined CIM model.
 *
 *
 * ===ParticipantInterfaces===
 * Market participant interfaces for bids and trades.
 *
 *
 * ===PaymentMetering===
 * This package is an extension of the Metering package and contains the information classes that support specialised applications such as prepayment metering.
 *
 * These classes are generally associated with the collection and control of revenue from the customer for a delivered service.
 *
 *
 * ===PowerSystemStabilizerDynamics===
 * The power system stabilizer (PSS) model provides an input (<i>Vs</i>) to the excitation system model to improve damping of system oscillations.
 *
 * A variety of input signals can be used depending on the particular design.
 *
 *
 * ===Production===
 * The production package is responsible for classes which describe various kinds of generators.
 *
 * These classes also provide production costing information which is used to economically allocate demand among committed units and calculate reserve quantities.
 *
 *
 * ===Protection===
 * An extension to the Core and Wires packages that models information for protection equipment such as relays.
 *
 * These entities are used within training simulators and distribution network fault location applications.
 *
 *
 * ===ReferenceData===
 * Market static reference data.
 *
 *
 * ===SCADA===
 * Contains entities to model information used by Supervisory Control and Data Acquisition (SCADA) applications.
 *
 * Supervisory control supports operator control of equipment, such as opening or closing a breaker. Data acquisition gathers telemetered data from various sources.  The subtypes of the Telemetry entity deliberately match the UCA and IEC 61850 definitions.
 * This package also supports alarm presentation but it is not expected to be used by other applications.
 *
 *
 * ===StandardInterconnections===
 * This subclause describes the standard interconnections for various types of equipment.
 *
 * These interconnections are understood by the application programs and can be identified based on the presence of one of the key classes with a relationship to the static power flow model: SynchronousMachineDynamics, AsynchronousMachineDynamics, EnergyConsumerDynamics or WindTurbineType3or4Dynamics.
 * The relationships between classes expressed in the interconnection diagrams are intended to support dynamic behaviour described by either standard models or user-defined models.
 * In the interconnection diagrams, boxes which are black in colour represent function blocks whose functionality can be provided by one of many standard models or by a user-defined model. Blue boxes represent specific standard models.  A dashed box means that the function block or specific standard model is optional.
 *
 *
 * ===StandardModels===
 * This subclause contains standard dynamic model specifications grouped into packages by standard function block (type of equipment being modelled).
 *
 * In the CIM, standard dynamic models are expressed by means of a class named with the standard model name and attributes reflecting each of the parameters necessary to describe the behaviour of an instance of the standard model.
 *
 *
 * ===StateVariables===
 * State variables for analysis solutions such as powerflow.
 *
 *
 * ===StaticVarCompensatorDynamics===
 * Static var compensator (SVC) models.
 *
 *
 * ===SynchronousMachineDynamics===
 * For conventional power generating units (e.g., thermal, hydro, combustion turbine), a synchronous machine model represents the electrical characteristics of the generator and the mechanical characteristics of the turbine-generator rotational inertia.
 *
 * Large industrial motors or groups of similar motors can be represented by individual motor models which are represented as generators with negative active power in the static (power flow) data.
 * The interconnection with the electrical network equations can differ among simulation tools.  The tool only needs to know the synchronous machine to establish the correct interconnection.  The interconnection with the motor’s equipment could also differ due to input and output signals required by standard models.
 *
 *
 * ===Topology===
 * An extension to the Core Package that, in association with the Terminal class, models Connectivity, that is the physical definition of how equipment is connected together.
 *
 * In addition it models Topology, that is the logical definition of how equipment is connected via closed switches. The Topology definition is independent of the other electrical characteristics.
 *
 *
 * ===TurbineGovernorDynamics===
 * The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (<i>Pm</i>) or torque (<i>Tm</i>) for the generator model.
 *
 * Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, and GovSteamIEEE1) are documented in IEEE Transactions, not in IEEE standards. For that reason, diagrams are supplied for those models.
 * A 2012 IEEE report, <i><u>Dynamic Models for Turbine-Governors in Power System Studies</u></i>, provides updated information on a variety of models including IEEE, vendor and reliability authority models.  Fully incorporating the results of that report into the CIM dynamics model is a future effort.
 *
 *
 * ===TurbineLoadControllerDynamics===
 * A turbine load controller acts to maintain turbine power at a set value by continuous adjustment of the turbine governor speed-load reference.
 *
 *
 * ===UnderexcitationLimiterDynamics===
 * Underexcitation limiters (UELs) act to boost excitation.
 *
 * The UEL typically senses either a combination of voltage and current of the synchronous machine or a combination of real and reactive power. Some UELs utilize a temperature or pressure recalibration feature, in which the UEL characteristic is shifted depending upon the generator cooling gas temperature or pressure.
 *
 *
 * ===UserDefinedModels===
 * This subclause contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.
 * <u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.
 *
 * Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
 * <u>Explicitly defined models</u> describe dynamic behaviour in detail in terms of control blocks and their input and output signals.  Note that the classes to support explicitly defined modelling are not currently defined - it is future work intended to also be supported by the family of xxxUserDefined classes.
 * Both types of user-defined models use the family of xxxUserDefined classes, which allow a user-defined model to be used:
 * - as the model for an individual standard function block (such as a turbine-governor or power system stabilizer) in a standard interconnection model whose other function blocks could be either standard or user-defined.  For an illustration of this form of usage for a proprietary model, see the ExampleFunctionBlockProprietaryModel diagram in subclause 5.5.
 * - as the complete representation of a dynamic behaviour model (for an entire synchronous machine, for example) where standard function blocks and standard interconnections are not used at all. For an illustration of this form of usage for a proprietary model, see the ExampleCompleteProprietaryModel diagram in subclause 5.5.
 *
 *
 * ===VSC===
 *
 * ===VoltageAdjusterDynamics===
 * <font color="#0f0f0f">A voltage adjuster is a reference adjuster that uses inputs from a reactive power or power factor controller to modify the voltage regulator set point to maintain the synchronous machine steady-state power factor or reactive power at a predetermined value. </font>
 *
 * <font color="#0f0f0f">For additional information please refer to IEEE 421.5-2005, 11.</font>
 *
 *
 * ===VoltageCompensatorDynamics===
 * <font color="#0f0f0f">Synchronous machine terminal voltage transducer and current compensator models</font> adjust the terminal voltage feedback to the excitation system by adding a quantity that is proportional to the terminal current of the generator.
 *
 * It is linked to a specific generator (synchronous machine).
 * <font color="#0f0f0f">Several types of compensation are available on most excitation systems. Synchronous machine active and reactive current compensation are the most common. Either reactive droop compensation and/or line-drop compensation can be used, simulating an impedance drop and effectively regulating at some point other than the terminals of the machine. The impedance or range of adjustment and type of compensation should be specified for different types. </font>
 * <font color="#0f0f0f">Care shall be taken to ensure that a consistent PU system is utilized for the compensator parameters and the synchronous machine current base.</font>
 * <font color="#0f0f0f">For further information see IEEE 421.5-2005, 4.</font>
 *
 *
 * <font color="#0f0f0f">
 * </font>
 *
 *
 * ===WindDynamics===
 * Wind turbines are generally divided into four types, which are currently significant in power systems.
 *
 * The four types have the following characteristics:
 * - type 1: wind turbine with directly grid connected asynchronous generator with fixed rotor resistance (typically squirrel cage);
 * - type 2: wind turbine with directly grid connected asynchronous generator with variable rotor resistance;
 * - type 3: wind turbines with doubly-fed asynchronous generators (directly connected stator and rotor connected through power converter);
 * - type 4: wind turbines connected to the grid through a full size power converter.
 * Models included in this package are according to IEC 61400-27-1:2015.
 *
 *
 * ===Wires===
 * An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks.
 *
 * This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 *
 *
 * ===Work===
 * This package contains the core information classes that support work management and network extension planning applications.
 *
 *
 * ===unused===
 */
package object model
{
}

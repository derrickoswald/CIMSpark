package ch.ninecode

/**
 * ==Overview==
 * Provides Common Information Model (CIM) classes for electrical, topological, asset, spatial
 * and other categories of objects that are germane to electric network operations.
 *
 * Some examples are shown in the following image:
 *
 * <img src="https://rawgit.com/derrickoswald/CIMSparkPresentation/master/img/information.svg" width="700">
 *
 * These classes are the types of, and objects contained in, the RDD that are created by the CIMReader,
 * e.g. RDD[Switch].
 *
 * Classes are nested according to the hierarchical package structure found in CIM.
 *
 * Each class has the reference to its parent class, available as the generic <code>sup</code> field,
 * and also as a typed reference of the same name as the parent class.
 *
 * This is illustrated in the following image, where the object with id TE1932 (a Switch) is found in
 * RDD[Switch] and all RDD for which the relation 'a Switch "Is A" <em>X</em>' holds,
 * e.g. RDD[ConductingEquipment]:
 *
 * <img src="https://rawgit.com/derrickoswald/CIMSparkPresentation/master/img/nested.svg" width="700">
 *
 * The packages and their descriptions are itemized below.
 *
 * A short summary of all classes is found below that.
 * The classes can be ordered by package (Grouped) or alphabetically.
 * The classes are alos listed in the panel on the left for easy reference.
 *
 * ===AssetInfo===
 * This package is an extension of Assets package and contains the core information classes that support asset management and different network and work planning applications with specialized AssetInfo subclasses.
 *
 * They hold attributes that can be referenced by not only Asset-s or AssetModel-s but also by ConductingEquipment-s.
 *
 *
 * ===Assets===
 * This package contains the core information classes that support asset management applications that deal with the physical and lifecycle aspects of various network resources (as opposed to power system resource models defined in IEC61970::Wires package, which support network applications).
 *
 *
 * ===AsynchronousMachineDynamics===
 * An asynchronous machine model represents a (induction) generator or motor with no external connection to the rotor windings, e.g., squirrel-cage induction machine.
 *
 * The interconnection with the electrical network equations may differ among simulation tools.  The program only needs to know the terminal to which this asynchronous machine is connected in order to establish the correct interconnection.  The interconnection with motor�s equipment could also differ due to input and output signals required by standard models.
 *
 *
 * ===AuxiliaryEquipment===
 * Contains equipment which is not normal conducting equipment such as sensors, fault locators, and surge protectors.
 *
 * These devices do not define power carrying topological connections as conducting equipment, but are associated to terminals of other conducting equipment.
 *
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
 * ===DiagramLayout===
 * This package describes diagram layout.
 *
 * This describes how objects are arranged in a coordianate system rather than how they are rendered.
 *
 *
 * ===DiscontinuousExcitationControlDynamics===
 * <font colour="#0f0f0f">In some particular system configurations, continuous excitation control with terminal voltage and power system stabilizing regulator input signals does not ensure that the potential of the excitation system for improving system stability is fully exploited.
 *
 * For these situations, discontinuous excitation control signals may be employed to enhance stability following large transient disturbances.</font>
 *
 *
 * ===Domain===
 * The domain package define primitive datatypes that are used by classes in other packages.
 *
 * Stereotypes are used to describe the datatypes. The following stereotypes are defined:
 *
 *
 * ===Equivalents===
 * The equivalents package models equivalent networks.
 *
 *
 * ===ExcitationSystemDynamics===
 * The excitation system model provides the field voltage (Efd) for a synchronous machine model.
 *
 * It is linked to a specific generator (synchronous machine). The data parameters are different for each excitation system model; the same parameter name may have different meaning in different models.
 *
 *
 * ===ExternalInputs===
 * Inputs to the market system from external sources.
 *
 *
 * ===Faults===
 * The package describe faults that may happen to conducting equipment, e.g. tree falling on a power line.
 *
 *
 * ===GenerationTrainingSimulation===
 * The Generation Dynamics package contains prime movers, such as turbines and boilers, which are needed for simulation and educational purposes.
 *
 *
 * ===ICCP===

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
 * The IEC 62325 subpackages of the CIM are developed, standardized and maintained by IEC TC57 Working Group 16.
 *
 *
 * ===InfAssetInfo===

 *
 * ===InfAssets===
 * The package is used to define asset-level models for objects.
 *
 * Assets may be comprised of other assets and may have relationships to other assets. Assets also have owners and values. Assets may also have a relationship to a PowerSystemResource in the Wires model.
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
 * ===InfERPSupport===
 * The package contains portions of the model defined byEnterprise Resource Planning (ERP) standards like those proposed by the Open Applications Group (OAG).
 *
 * It is provided to facilitate integration among electric utility applications (CIM) and enterprise resource planning (ERP) applications (as defined by OAG). Rather than inventing new CIM classes that accomplish similar functionality as in existing ERP models, the preferred approach is to use and extend ERP classes as appropriate in other packages.
 *
 *
 * ===InfEnergyScheduling===
 * This package provides the capability to schedule and account for transactions for the exchange of electric power between companies.
 *
 * It includes transations for megawatts which are generated, consumed, lost, passed through, sold and purchased. These classes are used by Accounting and Billing for Energy, Generation Capacity, Transmission, and Ancillary Services.
 *
 *
 * ===InfEnergySource===

 *
 * ===InfExternalInputs===

 *
 * ===InfFinancial===
 * This package is responsible for Settlement and Billing.
 *
 * These classes represent the legal entities who participate in formal or informal agreements.
 *
 *
 * ===InfLocations===

 *
 * ===InfMarketOperations===

 *
 * ===InfMarketResults===

 *
 * ===InfNewAssets===

 *
 * ===InfOperationalLimits===
 * The description of computed or dynamic limits.
 *
 * These classes would likely go into the OperationalLimits package.
 *
 *
 * ===InfParticipantInterfaces===

 *
 * ===InfReservation===

 *
 * ===InfSIPS===
 * System Integrity Protection Schemes (SIPS) (IEC terminology).
 *
 * Other names used are: Remedial Action Schemes (RAS) or System Protection Schemes (SPS)
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
 *
 *
 * ===LoadModel===
 * This package is responsible for modeling the energy consumers and the system load as curves and associated curve data.
 *
 * Special circumstances that may affect the load, such as seasons and daytypes, are also included here.
 *
 *
 * ===MarketCommon===
 * This package contains the common objects shared by both MarketManagement and MarketOperations packages.
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
 * ===ModelAuthority===
 * The package describes meta data for partitioning  power system models into non overlapping subsets of objects managed by a model authority.
 *
 *
 * ===ModelDescription===
 * The package describes meta data for the exchange of power system model data.
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
 * <font color="#0f0f0f">Excitation systems for synchronous machines are sometimes supplied with an optional means of automatically adjusting generator output reactive power (VAr) or power factor (PF) to a user-specified value This can be accomplished with either a reactive power or power factor controller or regulator.
 *
 * A reactive power or power factor controller is defined as a PF/VAr controller in IEEE Std 421.1 as �A control function that acts through the reference adjuster to modify the voltage regulator set point to maintain the synchronous machine steady-state power factor or reactive power at a predetermined value.� </font>
 *
 *
 * ===PFVArControllerType2Dynamics===
 * <font color="#0f0f0f">A var/pf regulator is defined as �A synchronous machine regulator that functions to maintain the power factor or reactive component of power at a predetermined value.�  </font>
 * <font color="#0f0f0f">
 * </font><font color="#0f0f0f">For additional information please refer to IEEE Standard 421.5-2005, Section 11.</font>
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
 * ===PowerSystemProject===
 * The package describes how power system model data is managed and evolve over time in projects.
 *
 *
 * ===PowerSystemStabilizerDynamics===
 * The power system stabilizer (PSS) model provides an input (Vs) to the excitation system model to improve damping of system oscillations.
 *
 * A variety of input signals may be used depending on the particular design.
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
 *
 *
 * ===StandardInterconnections===
 * This section describes the standard interconnections for various types of equipment.
 *
 * These interconnections are understood by the application programs and can be identified based on the presence of one of the key classes with a relationship to the static power flow model: SynchronousMachineDynamics, AsynchronousMachineDynamics, EnergyConsumerDynamics or WindTurbineType3or4Dynamics.
 *
 *
 * ===StandardModels===
 * This section contains standard dynamic model specifications grouped into packages by standard function block (type of equipment being modelled).
 *
 * In the CIM, standard dynamic models are expressed by means of a class named with the standard model name and attributes reflecting each of the parameters necessary to describe the behaviour of an instance of the standard model.
 *
 *
 * ===StateVariables===
 * State variables for analysis solutions such as powerflow.
 *
 *
 * ===SynchronousMachineDynamics===
 * For conventional power generating units (e.g., thermal, hydro, combustion turbine), a synchronous machine model represents the electrical characteristics of the generator and the mechanical characteristics of the turbine-generator rotational inertia.
 *
 * Large industrial motors or groups of similar motors may be represented by individual motor models which are represented as <b>generators with negative active power</b> in the static (power flow) data.
 *
 *
 * ===Topology===
 * An extension to the Core Package that in association with the Terminal class models Connectivity, that is the physical definition of how equipment is connected together.
 *
 * In addition it models Topology, that is the logical definition of how equipment is connected via closed switches. The Topology definition is independent of the other electrical characteristics.
 *
 *
 * ===TurbineGovernorDynamics===
 * The turbine-governor model is linked to one or two synchronous generators and determines the shaft mechanical power (Pm) or torque (Tm) for the generator model.
 *
 * Unlike IEEE standard models for other function blocks, the three IEEE turbine-governor standard models (GovHydroIEEE0, GovHydroIEEE2, GovSteamIEEE1) are documented in IEEE Transactions not in IEEE standards. For that reason, diagrams are supplied for those models.
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
 * This section contains user-defined dynamic model classes to support the exchange of both proprietary and explicitly defined user-defined models.
 * <u>
 * </u><u>Proprietary models</u> represent behaviour which, while not defined by a standard model class, is mutually understood by the sending and receiving applications based on the name passed in the .name attribute of the appropriate xxxUserDefined class.
 *
 * Proprietary model parameters are passed as general attributes using as many instances of the ProprietaryParameterDynamics class as there are parameters.
 *
 *
 * ===VoltageAdjusterDynamics===
 * <font color="#0f0f0f">A voltage adjuster is a reference adjuster that uses inputs from a reactive power or power factor controller to modify the voltage regulator set point to maintain the synchronous machine steady-state power factor or reactive power at a predetermined value. </font>
 *
 * <font color="#0f0f0f">For additional information please refer to IEEE Standard 421.5-2005, Section 11.</font>
 *
 *
 * ===VoltageCompensatorDynamics===
 * <font color="#0f0f0f">Synchronous machine terminal voltage transducer and current compensator models</font> adjust the terminal voltage feedback to the excitation system by adding a quantity that is proportional to the terminal current of the generator.
 *
 * It is linked to a specific generator (synchronous machine).
 *
 *
 * ===WindDynamics===
 * Wind turbines are generally divided into 4 types, which are currently significant in power systems.
 *
 * The 4 types have the following characteristics:
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
 */
package object model
{
}

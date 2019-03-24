CIM Model
======

CIMUG
-----

The definitive public source of CIM model information is available from the [CIM users group](http://cimug.ucaiug.org/default.aspx) web site. Access is free by filling in the form, when for example you click on the link for [Current Official CIM Model Releases](http://cimug.ucaiug.org/Current%20Official%20CIM%20Model%20Releases/Forms/Custom%20All%20Documents.aspx). Full individual membership is US$350.

There you will find a download link for [iec61970cim16v29a_iec61968cim12v08_iec62325cim03v01a](http://cimug.ucaiug.org/Current%20Official%20CIM%20Model%20Releases/iec61970cim16v29a_iec61968cim12v08_iec62325cim03v01a.zip). Within this ZIP archive are two primary documents, the iec61970cim16v29a_iec61968cim12v08_iec62325cim03v01a.eap - the UML model in Enterprise Architect format - and IEC61968-11-ed3-r13-uml16v26a-12v08-tool01v10-beta.docx - the human readable explanation.

A more high level overview of CIM is found in the [CIM Primer](http://www.epri.com/abstracts/Pages/ProductAbstract.aspx?ProductId=000000003002006001) - highly recommended for a first deep dive.

CIMTool
-----

If you don't have access to [Enterprise Architect from Sparx Systems, US$135](http://www.sparxsystems.com/), you can use the open source [CIMTool](http://wiki.cimtool.org/index.html).
The installation and use instructions are quite good. You may need to use the slightly older 26a CIM model [iec61970cim16v26a_iec61968cim12v08_iec62325cim03v01a](http://cimug.ucaiug.org/Current%20Official%20CIM%20Model%20Releases/iec61970cim16v26a_iec61968cim12v08_iec62325cim03v01a.zip) because of parsing issues with the new model.

When you've successfully created a project, you should see something similar to that shown below:

![CIMTool](https://cdn.jsdelivr.net/gh/derrickoswald/CIMSpark@master/img/CIMTool.png "CIMTool Screen Capture")

Scala Code
-----

At the top of the right hand panel of the CIMTool you will see a search icon - the single most valuable feature - from where you can find a particular class. Navigate in the tree by double-clicking.

Attributes of the class are of four flavors:

- value attributes (rectangular icon)
- outgoing reference attributes (right arrow)
- incoming reference attributes (left arrow)
- (m:n) relations (horizontal lines)

Subclasses and the superclass have open arrow icons.

Comparing the image with the [ACLineSegment class in Wires.scala](https://github.com/derrickoswald/CIMSpark/blob/master/src/main/scala/ch/ninecode/model/Wires.scala) you will see a high degree of similarity. Where possible, the names of attributes in the Scala code are the same as the names in the UML diagram. Discrepancies occur where Scala reserved words and other software related issues arise (e.g. attribute length must be changed to len in the Scala code due to a superclass member method).

```Scala
/**
 * A wire or combination of wires, with consistent electrical characteristics, building a single electrical system, used to carry alternating current between points in the power system.
 *
 * For symmetrical, transposed 3ph lines, it is sufficient to use  attributes of the line segment, which describe impedances and admittances for the entire length of the segment.  Additionally impedances can be computed by using length and associated per length impedances.
 *
 * @param sup [[ch.ninecode.model.Conductor Conductor]] Reference to the superclass object.
 * @param b0ch Zero sequence shunt (charging) susceptance, uniformly distributed, of the entire line section.
 * @param bch Positive sequence shunt (charging) susceptance, uniformly distributed, of the entire line section.
 *        This value represents the full charging over the full length of the line.
 * @param g0ch Zero sequence shunt (charging) conductance, uniformly distributed, of the entire line section.
 * @param gch Positive sequence shunt (charging) conductance, uniformly distributed, of the entire line section.
 * @param r Positive sequence series resistance of the entire line section.
 * @param r0 Zero sequence series resistance of the entire line section.
 * @param shortCircuitEndTemperature Maximum permitted temperature at the end of SC for the calculation of minimum short-circuit currents.
 *        Used for short circuit data exchange according to IEC 60909
 * @param x Positive sequence series reactance of the entire line section.
 * @param x0 Zero sequence series reactance of the entire line section.
 * @param LineGroundingAction [[ch.ninecode.model.GroundAction GroundAction]] Ground action involving clamp usage (for the case when the ground is applied along the line segment instead of at its terminals).
 * @param LineJumpingAction [[ch.ninecode.model.JumperAction JumperAction]] Jumper action involving clamp usage (for the case when the jumper is applied along the line segment instead of at its terminals).
 * @param PerLengthImpedance [[ch.ninecode.model.PerLengthImpedance PerLengthImpedance]] Per-length impedance of this line segment.
 * @group Wires
 * @groupname Wires Package Wires
 * @groupdesc Wires An extension to the Core and Topology package that models information on the electrical characteristics of Transmission and Distribution networks. This package is used by network applications such as State Estimation, Load Flow and Optimal Power Flow.
 */
case class ACLineSegment
(
    override val sup: Conductor,
    b0ch: Double,
    bch: Double,
    g0ch: Double,
    gch: Double,
    r: Double,
    r0: Double,
    shortCircuitEndTemperature: Double,
    x: Double,
    x0: Double,
    LineGroundingAction: String,
    LineJumpingAction: String,
    PerLengthImpedance: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def Conductor: Conductor = sup.asInstanceOf[Conductor]
    override def copy (): Row = { clone ().asInstanceOf[ACLineSegment] }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = ACLineSegment.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (ACLineSegment.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (ACLineSegment.fields (position), value)
        emitelem (0, b0ch)
        emitelem (1, bch)
        emitelem (2, g0ch)
        emitelem (3, gch)
        emitelem (4, r)
        emitelem (5, r0)
        emitelem (6, shortCircuitEndTemperature)
        emitelem (7, x)
        emitelem (8, x0)
        emitattr (9, LineGroundingAction)
        emitattr (10, LineJumpingAction)
        emitattr (11, PerLengthImpedance)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:ACLineSegment rdf:ID=\"%s\">\n%s\t</cim:ACLineSegment>".format (id, export_fields)
    }
}

object ACLineSegment
extends
    Parseable[ACLineSegment]
{
    val fields: Array[String] = Array[String] (
        "b0ch",
        "bch",
        "g0ch",
        "gch",
        "r",
        "r0",
        "shortCircuitEndTemperature",
        "x",
        "x0",
        "LineGroundingAction",
        "LineJumpingAction",
        "PerLengthImpedance"
    )
    val b0ch: Fielder = parse_element (element (cls, fields(0)))
    val bch: Fielder = parse_element (element (cls, fields(1)))
    val g0ch: Fielder = parse_element (element (cls, fields(2)))
    val gch: Fielder = parse_element (element (cls, fields(3)))
    val r: Fielder = parse_element (element (cls, fields(4)))
    val r0: Fielder = parse_element (element (cls, fields(5)))
    val shortCircuitEndTemperature: Fielder = parse_element (element (cls, fields(6)))
    val x: Fielder = parse_element (element (cls, fields(7)))
    val x0: Fielder = parse_element (element (cls, fields(8)))
    val LineGroundingAction: Fielder = parse_attribute (attribute (cls, fields(9)))
    val LineJumpingAction: Fielder = parse_attribute (attribute (cls, fields(10)))
    val PerLengthImpedance: Fielder = parse_attribute (attribute (cls, fields(11)))

    def parse (context: Context): ACLineSegment =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = ACLineSegment (
            Conductor.parse (context),
            toDouble (mask (b0ch (), 0)),
            toDouble (mask (bch (), 1)),
            toDouble (mask (g0ch (), 2)),
            toDouble (mask (gch (), 3)),
            toDouble (mask (r (), 4)),
            toDouble (mask (r0 (), 5)),
            toDouble (mask (shortCircuitEndTemperature (), 6)),
            toDouble (mask (x (), 7)),
            toDouble (mask (x0 (), 8)),
            mask (LineGroundingAction (), 9),
            mask (LineJumpingAction (), 10),
            mask (PerLengthImpedance (), 11)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("LineGroundingAction", "GroundAction", false),
        Relationship ("LineJumpingAction", "JumperAction", false),
        Relationship ("PerLengthImpedance", "PerLengthImpedance", false)
    )
}
```

Hierarchy
-----

Just as in the CIM model, CIMReader model classes are hierarchical.

At the bottom of the screen shot you can see that the superclass of ACLineSegment is Conductor. This is mimicked in the Scala code by the sup member of type Conductor. Note that this does not use the class hierarchy of Scala directly for two reasons:

1. CIM classes are exposed as database tables and SQL is not hierarchical
2. Scala case classes are used (to support Spark DataFrames) and, for technical reasons, case classes must be the leaf nodes of a Scala class hierarchy

In CIMReader, the root class of all CIM model classes is Element, which has only two members, the id and a sup member which is null. 

![Hierarchical Class Nesting](https://cdn.jsdelivr.net/gh/derrickoswald/CIMSpark@master/img/Hierarchical.svg "Hierarchical Nesting Diagram")

The sup member of each higher level class is aliased with a method of the correct name, so given an ACLineSegment object obj in Scala, the base class is accessible via obj.sup or obj.Conductor. The latter is preferred because the code reads better. This feature is not available in SQL queries, where sup must be used.

The id member is the value of the Master Resource Identifier (MRID), which is also the mRID member of the IdentifiedObject superclass, from which most classes in the CIM model derive.

When the CIM model RDD are constructed, each sub-object is also added to the base class RDDs. So for example, an object of type ACLineSegment can be accessed in the RDD for ACLineSegment, Conductor, ConductingEquipment, Equipment, PowerSystemResource, IdentifiedObject and Element - as each of those types respectively (RDD[ACLineSegment], RDD[Conductor], RDD[ConductingEquipment], RDD[Equipment], RDD[PowerSystemResource], RDD[IdentifiedObject] and RDD[Element]).

Names of classes have been preserved also in the names of the RDD containing the objects - that is if you are seeking an object of type ACLineSegment it is in the named and cached RDD "ACLineSegment" of type RDD[ACLineSegment]. In the example below, a particular ACLineSegment with the MRID "KLE1234" is extracted: 

```Scala
val lines = session.sparkContext.getPersistentRDDs.filter(_._2.name == "ACLineSegment").head._2.asInstanceOf[RDD[ACLineSegment]]
val line = lines.filter(_.id == "KLE1234").head
```

The Element RDD contains full CIMReader model objects, not just Element objects. That is, if you know the members of a filter operation are of a specific type, you can cast to that type:

```Scala
val elements: RDD[Element] = ...
val lines: RDD[ACLineSegment] = elements.filter(_.id.startsWith ("KLE")).asInstanceOf[RDD[ACLineSegment]]
```

A safer way to move from a base class to a superclass is to join with the superclass by id:
```Scala
val equipment: RDD[Equipment] = ...
val lines: RDD[ACLineSegment] = ...
val some_lines: RDD[ACLineSegment] = equipment.keyBy(_.id).join (lines.keyBy (_.id)).values.map (_._2)
```

One can also get the class name, e.g. ch.ninecode.model.ACLineSegment, from objects in RDD[Element] using theObject.getClass.getName in order to perform specific actions on different class types.



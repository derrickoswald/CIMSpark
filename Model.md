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

![CIMTool](https://rawgit.com/derrickoswald/CIMReader/master/img/CIMTool.png "CIMTool Screen Capture")

Scala Code
-----

At the top of the right hand panel of the CIMTool you will see a search icon - the single most valuable feature - from where you can find a particular class. Navigate in the tree by double-clicking.

Attributes of the class are of four flavors:

- value attributes (rectangular icon)
- outgoing reference attributes (right arrow)
- incoming reference attributes (left arrow)
- (m:n) relations (horizontal lines)

Subclasses and the superclass have open arrow icons.

Comparing the image with the [ACLineSegment class in Wires.scala](https://github.com/derrickoswald/CIMReader/blob/master/src/main/scala/ch/ninecode/model/Wires.scala) you will see a high degree of similarity. Where possible, the names of attributes in the Scala code are the same as the names in the UML diagram. Discrepancies occur where Scala reserved words and other software related issues arise (e.g. attribute length must be changed to len in the Scala code due to a superclass member method).

```Scala
case class ACLineSegment
(
    override val sup: Conductor,
    val b0ch: Double,
    val bch: Double,
    val g0ch: Double,
    val gch: Double,
    val r0: Double,
    val r: Double,
    val shortCircuitEndTemperature: Double,
    val x0: Double,
    val x: Double,
    val LineGroundingAction: String,
    val LineJumpingAction: String,
    val PerLengthImpedance: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, null, null, null) }
    def Conductor: Conductor = sup.asInstanceOf[Conductor]
    override def copy (): Row = { return (clone ().asInstanceOf[ACLineSegment]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ACLineSegment
extends
    Parseable[ACLineSegment]
{
    val b0ch = parse_element (element ("""ACLineSegment.b0ch"""))_
    val bch = parse_element (element ("""ACLineSegment.bch"""))_
    val g0ch = parse_element (element ("""ACLineSegment.g0ch"""))_
    val gch = parse_element (element ("""ACLineSegment.gch"""))_
    val r0 = parse_element (element ("""ACLineSegment.r0"""))_
    val r = parse_element (element ("""ACLineSegment.r"""))_
    val shortCircuitEndTemperature = parse_element (element ("""ACLineSegment.shortCircuitEndTemperature"""))_
    val x0 = parse_element (element ("""ACLineSegment.x0"""))_
    val x = parse_element (element ("""ACLineSegment.x"""))_
    val LineGroundingAction = parse_attribute (attribute ("""ACLineSegment.LineGroundingAction"""))_
    val LineJumpingAction = parse_attribute (attribute ("""ACLineSegment.LineJumpingAction"""))_
    val PerLengthImpedance = parse_attribute (attribute ("""ACLineSegment.PerLengthImpedance"""))_
    def parse (context: Context): ACLineSegment =
    {
        return (
            ACLineSegment
            (
                Conductor.parse (context),
                toDouble (b0ch (context), context),
                toDouble (bch (context), context),
                toDouble (g0ch (context), context),
                toDouble (gch (context), context),
                toDouble (r0 (context), context),
                toDouble (r (context), context),
                toDouble (shortCircuitEndTemperature (context), context),
                toDouble (x0 (context), context),
                toDouble (x (context), context),
                LineGroundingAction (context),
                LineJumpingAction (context),
                PerLengthImpedance (context)
            )
        )
    }
}
```

Hierarchy
-----

Just as in the CIM model, CIMReader model classes are hierarchical.

At the bottom of the screen shot you can see that the superclass of ACLineSegment is Conductor. This is mimicked in the Scala code by the sup member of type Conductor. Note that this does not use the class hierarchy of Scala directly for two reasons:

1. CIM classes are exposed as database tables and SQL is not hierarchical
2. Scala case classes are used (to support Spark DataFrames) and, for technical reasons, case classes must be the leaf nodes of a Scala class hierarchy

In CIMReader, the root class of all CIM model classes is Element, which has only two members, the id and a sup member which is null. 

![Hierarchical Class Nesting](https://rawgit.com/derrickoswald/CIMReader/master/img/Heirarchical.svg "Heirarchical Nesting Diagram")

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



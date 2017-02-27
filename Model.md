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

![CIMTool](https://rawgit.com/derrickoswald/CIMScala/master/img/CIMTool.png "CIMTool Screen Capture")

Scala Code
-----

At the top of the right hand panel of the CIMTool you will see a search icon - the single most valuable feature - from where you can find a particular class. Navigate in the tree by double-clicking.

Attributes of the class are of four flavors:

- value attributes (rectangular icon)
- outgoing reference attributes (right arrow)
- incoming reference attributes (left arrow)
- (m:n) relations (horizontal lines)

Subclasses and the superclass have open arrow icons.

Comparing the image with the [ACLineSegment class in Wires.scala](https://github.com/derrickoswald/CIMScala/blob/master/src/main/scala/ch/ninecode/model/Wires.scala) you will see a high degree of similarity. Where possible, the names of attributes in the Scala code are the same as the names in the UML diagram. Discrepancies occur where Scala reserved words and other software related issues arise (i.e. attrbute length must be changed to len in the scala code due to a superclass member method). 

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
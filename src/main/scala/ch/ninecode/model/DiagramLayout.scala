package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.Context

/*
 * Package: DiagramLayout
 */

case class Diagram
(
    override val sup: IdentifiedObject,
    val orientation: String,
    val x1InitialView: Double,
    val x2InitialView: Double,
    val y1InitialView: Double,
    val y2InitialView: Double,
    val DiagramStyle: String
)
extends
    Element
{
    def this () = { this (null, null, 0.0, 0.0, 0.0, 0.0, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[Diagram]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Diagram
extends
    Parseable[Diagram]
{
    val orientation = parse_attribute (attribute ("""Diagram.orientation"""))_
    val x1InitialView = parse_element (element ("""Diagram.x1InitialView"""))_
    val x2InitialView = parse_element (element ("""Diagram.x2InitialView"""))_
    val y1InitialView = parse_element (element ("""Diagram.y1InitialView"""))_
    val y2InitialView = parse_element (element ("""Diagram.y2InitialView"""))_
    val DiagramStyle = parse_attribute (attribute ("""Diagram.DiagramStyle"""))_
    def parse (context: Context): Diagram =
    {
        return (
            Diagram
            (
                IdentifiedObject.parse (context),
                orientation (context),
                toDouble (x1InitialView (context), context),
                toDouble (x2InitialView (context), context),
                toDouble (y1InitialView (context), context),
                toDouble (y2InitialView (context), context),
                DiagramStyle (context)
            )
        )
    }
}

case class DiagramObject
(
    override val sup: IdentifiedObject,
    val drawingOrder: Int,
    val isPolygon: Boolean,
    val offsetX: Double,
    val offsetY: Double,
    val rotation: Double,
    val Diagram: String,
    val DiagramObjectStyle: String,
    val _IdentifiedObject: String  // IdentifiedObject not allowed here
)
extends
    Element
{
    def this () = { this (null, 0, false, 0.0, 0.0, 0.0, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[DiagramObject]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DiagramObject
extends
    Parseable[DiagramObject]
{
    val drawingOrder = parse_element (element ("""DiagramObject.drawingOrder"""))_
    val isPolygon = parse_element (element ("""DiagramObject.isPolygon"""))_
    val offsetX = parse_element (element ("""DiagramObject.offsetX"""))_
    val offsetY = parse_element (element ("""DiagramObject.offsetY"""))_
    val rotation = parse_element (element ("""DiagramObject.rotation"""))_
    val Diagram = parse_attribute (attribute ("""DiagramObject.Diagram"""))_
    val DiagramObjectStyle = parse_attribute (attribute ("""DiagramObject.DiagramObjectStyle"""))_
    val _IdentifiedObject = parse_attribute (attribute ("""DiagramObject._IdentifiedObject"""))_
    def parse (context: Context): DiagramObject =
    {
        return (
            DiagramObject
            (
                IdentifiedObject.parse (context),
                toInteger (drawingOrder (context), context),
                toBoolean (isPolygon (context), context),
                toDouble (offsetX (context), context),
                toDouble (offsetY (context), context),
                toDouble (rotation (context), context),
                Diagram (context),
                DiagramObjectStyle (context),
                _IdentifiedObject (context)
            )
        )
    }
}

case class DiagramObjectGluePoint
(
    override val sup: Element
)
extends
    Element
{
    def this () = { this (null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[DiagramObjectGluePoint]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DiagramObjectGluePoint
extends
    Parseable[DiagramObjectGluePoint]
{
    def parse (context: Context): DiagramObjectGluePoint =
    {
        return (
            DiagramObjectGluePoint
            (
                BasicElement.parse (context)
            )
        )
    }
}

case class DiagramObjectPoint
(
    override val sup: Element,
    val sequenceNumber: Int,
    val xPosition: Double,
    val yPosition: Double,
    val zPosition: Double,
    val DiagramObject: String,
    val DiagramObjectGluePoint: String
)
extends
    Element
{
    def this () = { this (null, 0, 0.0, 0.0, 0.0, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[DiagramObjectPoint]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DiagramObjectPoint
extends
    Parseable[DiagramObjectPoint]
{
    val sequenceNumber = parse_element (element ("""DiagramObjectPoint.sequenceNumber"""))_
    val xPosition = parse_element (element ("""DiagramObjectPoint.xPosition"""))_
    val yPosition = parse_element (element ("""DiagramObjectPoint.yPosition"""))_
    val zPosition = parse_element (element ("""DiagramObjectPoint.zPosition"""))_
    val DiagramObject = parse_attribute (attribute ("""DiagramObjectPoint.DiagramObject"""))_
    val DiagramObjectGluePoint = parse_attribute (attribute ("""DiagramObjectPoint.DiagramObjectGluePoint"""))_
    def parse (context: Context): DiagramObjectPoint =
    {
        return (
            DiagramObjectPoint
            (
                BasicElement.parse (context),
                toInteger (sequenceNumber (context), context),
                toDouble (xPosition (context), context),
                toDouble (yPosition (context), context),
                toDouble (zPosition (context), context),
                DiagramObject (context),
                DiagramObjectGluePoint (context)
            )
        )
    }
}

case class DiagramObjectStyle
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[DiagramObjectStyle]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DiagramObjectStyle
extends
    Parseable[DiagramObjectStyle]
{
    def parse (context: Context): DiagramObjectStyle =
    {
        return (
            DiagramObjectStyle
            (
                IdentifiedObject.parse (context)
            )
        )
    }
}

case class DiagramStyle
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[DiagramStyle]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DiagramStyle
extends
    Parseable[DiagramStyle]
{
    def parse (context: Context): DiagramStyle =
    {
        return (
            DiagramStyle
            (
                IdentifiedObject.parse (context)
            )
        )
    }
}

case class TextDiagramObject
(
    override val sup: DiagramObject,
    val text: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def DiagramObject: DiagramObject = sup.asInstanceOf[DiagramObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TextDiagramObject]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TextDiagramObject
extends
    Parseable[TextDiagramObject]
{
    val text = parse_element (element ("""TextDiagramObject.text"""))_
    def parse (context: Context): TextDiagramObject =
    {
        return (
            TextDiagramObject
            (
                DiagramObject.parse (context),
                text (context)
            )
        )
    }
}

case class VisibilityLayer
(
    override val sup: IdentifiedObject,
    val drawingOrder: Int
)
extends
    Element
{
    def this () = { this (null, 0) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[VisibilityLayer]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object VisibilityLayer
extends
    Parseable[VisibilityLayer]
{
    val drawingOrder = parse_element (element ("""VisibilityLayer.drawingOrder"""))_
    def parse (context: Context): VisibilityLayer =
    {
        return (
            VisibilityLayer
            (
                IdentifiedObject.parse (context),
                toInteger (drawingOrder (context), context)
            )
        )
    }
}

object DiagramLayout
{
    def register: Unit =
    {
          Diagram.register
          DiagramObject.register
          DiagramObjectGluePoint.register
          DiagramObjectPoint.register
          DiagramObjectStyle.register
          DiagramStyle.register
          TextDiagramObject.register
          VisibilityLayer.register
    }
}
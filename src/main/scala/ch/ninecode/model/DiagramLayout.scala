package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context

/**
 * This package describes diagram layout.
 * This describes how objects are arranged in a coordianate system rather than how they are rendered.
 */

/**
 * The diagram being exchanged.
 * The coordinate system is a standard Cartesian coordinate system and the orientation attribute defines the orientation.
 * @param sup Reference to the superclass object.
 * @param orientation Coordinate system orientation of the diagram.
 * @param x1InitialView X coordinate of the first corner of the initial view.
 * @param x2InitialView X coordinate of the second corner of the initial view.
 * @param y1InitialView Y coordinate of the first corner of the initial view.
 * @param y2InitialView Y coordinate of the second corner of the initial view.
 * @param DiagramStyle A Diagram may have a DiagramStyle.
 */
case class Diagram
(override val sup: IdentifiedObject,
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
    override def copy (): Row = { return (clone ().asInstanceOf[Diagram]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Diagram
extends
    Parseable[Diagram]
{
    val sup = IdentifiedObject.parse _
    val orientation = parse_attribute (attribute ("""Diagram.orientation"""))_
    val x1InitialView = parse_element (element ("""Diagram.x1InitialView"""))_
    val x2InitialView = parse_element (element ("""Diagram.x2InitialView"""))_
    val y1InitialView = parse_element (element ("""Diagram.y1InitialView"""))_
    val y2InitialView = parse_element (element ("""Diagram.y2InitialView"""))_
    val DiagramStyle = parse_attribute (attribute ("""Diagram.DiagramStyle"""))_
    def parse (context: Context): Diagram =
    {
        Diagram(
            sup (context),
            orientation (context),
            toDouble (x1InitialView (context), context),
            toDouble (x2InitialView (context), context),
            toDouble (y1InitialView (context), context),
            toDouble (y2InitialView (context), context),
            DiagramStyle (context)
        )
    }
}

/**
 * An object that defines one or more points in a given space.
 * This object can be associated with anything that specializes IdentifiedObject. For single line diagrams such objects typically include such items as analog values, breakers, disconnectors, power transformers, and transmission lines.
 * @param sup Reference to the superclass object.
 * @param drawingOrder The drawing order of this element.
 *        The higher the number, the later the element is drawn in sequence. This is used to ensure that elements that overlap are rendered in the correct order.
 * @param isPolygon Defines whether or not the diagram objects points define the boundaries of a polygon or the routing of a polyline.
 *        If this value is true then a receiving application should consider the first and last points to be connected.
 * @param offsetX The offset in the X direction.
 *        This is used for defining the offset from centre for rendering an icon (the default is that a single point specifies the centre of the icon).
 * @param offsetY The offset in the Y direction.
 *        This is used for defining the offset from centre for rendering an icon (the default is that a single point specifies the centre of the icon).
 * @param rotation Sets the angle of rotation of the diagram object.
 *        Zero degrees is pointing to the top of the diagram.  Rotation is clockwise.
 * @param Diagram A diagram object is part of a diagram.
 * @param DiagramObjectStyle A diagram object has a style associated that provides a reference for the style used in the originating system.
 * @param IdentifiedObject_attr The domain object to which this diagram object is associated.
 * @param VisibilityLayers A diagram object can be part of multiple visibility layers.
 */
case class DiagramObject
(override val sup: IdentifiedObject,
val drawingOrder: Int,
val isPolygon: Boolean,
val offsetX: Double,
val offsetY: Double,
val rotation: Double,
val Diagram: String,
val DiagramObjectStyle: String,
val IdentifiedObject_attr: String,
val VisibilityLayers: List[String]
)
extends
    Element
{
    def this () = { this (null, 0, false, 0.0, 0.0, 0.0, null, null, null, List()) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[DiagramObject]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DiagramObject
extends
    Parseable[DiagramObject]
{
    val sup = IdentifiedObject.parse _
    val drawingOrder = parse_element (element ("""DiagramObject.drawingOrder"""))_
    val isPolygon = parse_element (element ("""DiagramObject.isPolygon"""))_
    val offsetX = parse_element (element ("""DiagramObject.offsetX"""))_
    val offsetY = parse_element (element ("""DiagramObject.offsetY"""))_
    val rotation = parse_element (element ("""DiagramObject.rotation"""))_
    val Diagram = parse_attribute (attribute ("""DiagramObject.Diagram"""))_
    val DiagramObjectStyle = parse_attribute (attribute ("""DiagramObject.DiagramObjectStyle"""))_
    val IdentifiedObject_attr = parse_attribute (attribute ("""DiagramObject.IdentifiedObject"""))_
    val VisibilityLayers = parse_attributes (attribute ("""DiagramObject.VisibilityLayers"""))_
    def parse (context: Context): DiagramObject =
    {
        DiagramObject(
            sup (context),
            toInteger (drawingOrder (context), context),
            toBoolean (isPolygon (context), context),
            toDouble (offsetX (context), context),
            toDouble (offsetY (context), context),
            toDouble (rotation (context), context),
            Diagram (context),
            DiagramObjectStyle (context),
            IdentifiedObject_attr (context),
            VisibilityLayers (context)
        )
    }
}

/**
 * This is used for grouping diagram object points from different diagram objects that are considered to be glued together in a diagram even if they are not at the exact same coordinates.
 * @param sup Reference to the superclass object.
 */
case class DiagramObjectGluePoint
(override val sup: BasicElement
)
extends
    Element
{
    def this () = { this (null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[DiagramObjectGluePoint]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DiagramObjectGluePoint
extends
    Parseable[DiagramObjectGluePoint]
{
    val sup = BasicElement.parse _
    def parse (context: Context): DiagramObjectGluePoint =
    {
        DiagramObjectGluePoint(
            sup (context)
        )
    }
}

/**
 * A point in a given space defined by 3 coordinates and associated to a diagram object.
 * The coordinates may be positive or negative as the origin does not have to be in the corner of a diagram.
 * @param sup Reference to the superclass object.
 * @param sequenceNumber The sequence position of the point, used for defining the order of points for diagram objects acting as a polyline or polygon with more than one point.
 * @param xPosition The X coordinate of this point.
 * @param yPosition The Y coordinate of this point.
 * @param zPosition The Z coordinate of this point.
 * @param DiagramObject The diagram object with which the points are associated.
 * @param DiagramObjectGluePoint The 'glue' point to which this point is associated.
 */
case class DiagramObjectPoint
(override val sup: BasicElement,
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
    override def copy (): Row = { return (clone ().asInstanceOf[DiagramObjectPoint]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DiagramObjectPoint
extends
    Parseable[DiagramObjectPoint]
{
    val sup = BasicElement.parse _
    val sequenceNumber = parse_element (element ("""DiagramObjectPoint.sequenceNumber"""))_
    val xPosition = parse_element (element ("""DiagramObjectPoint.xPosition"""))_
    val yPosition = parse_element (element ("""DiagramObjectPoint.yPosition"""))_
    val zPosition = parse_element (element ("""DiagramObjectPoint.zPosition"""))_
    val DiagramObject = parse_attribute (attribute ("""DiagramObjectPoint.DiagramObject"""))_
    val DiagramObjectGluePoint = parse_attribute (attribute ("""DiagramObjectPoint.DiagramObjectGluePoint"""))_
    def parse (context: Context): DiagramObjectPoint =
    {
        DiagramObjectPoint(
            sup (context),
            toInteger (sequenceNumber (context), context),
            toDouble (xPosition (context), context),
            toDouble (yPosition (context), context),
            toDouble (zPosition (context), context),
            DiagramObject (context),
            DiagramObjectGluePoint (context)
        )
    }
}

/**
 * A reference to a style used by the originating system for a diagram object.
 * A diagram object style describes information such as line thickness, shape such as circle or rectangle etc, and color.
 * @param sup Reference to the superclass object.
 */
case class DiagramObjectStyle
(override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[DiagramObjectStyle]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DiagramObjectStyle
extends
    Parseable[DiagramObjectStyle]
{
    val sup = IdentifiedObject.parse _
    def parse (context: Context): DiagramObjectStyle =
    {
        DiagramObjectStyle(
            sup (context)
        )
    }
}

/**
 * The diagram style refer to a style used by the originating system for a diagram.
 * A diagram style describes information such as schematic, geographic, bus-branch etc.
 * @param sup Reference to the superclass object.
 */
case class DiagramStyle
(override val sup: IdentifiedObject
)
extends
    Element
{
    def this () = { this (null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[DiagramStyle]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object DiagramStyle
extends
    Parseable[DiagramStyle]
{
    val sup = IdentifiedObject.parse _
    def parse (context: Context): DiagramStyle =
    {
        DiagramStyle(
            sup (context)
        )
    }
}

/**
 * The orientation of the coordinate system with respect to top, left, and the coordinate number system.
 * @param sup Reference to the superclass object.
 * @param negative For 2D diagrams, a negative orientation gives the left-hand orientation (favoured by computer graphics displays) with X values increasing from left to right and Y values increasing from top to bottom.
 *        This is also known as a left hand orientation.
 * @param positive For 2D diagrams, a positive orientation will result in X values increasing from left to right and Y values increasing from bottom to top.
 *        This is also known as a right hand orientation.
 */
case class OrientationKind
(override val sup: BasicElement,
val negative: String,
val positive: String
)
extends
    Element
{
    def this () = { this (null, null, null) }
    def Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { return (clone ().asInstanceOf[OrientationKind]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object OrientationKind
extends
    Parseable[OrientationKind]
{
    val sup = BasicElement.parse _
    val negative = parse_attribute (attribute ("""OrientationKind.negative"""))_
    val positive = parse_attribute (attribute ("""OrientationKind.positive"""))_
    def parse (context: Context): OrientationKind =
    {
        OrientationKind(
            sup (context),
            negative (context),
            positive (context)
        )
    }
}

/**
 * A diagram object for placing free-text or text derived from an associated domain object.
 * @param sup Reference to the superclass object.
 * @param text The text that is displayed by this text diagram object.
 */
case class TextDiagramObject
(override val sup: DiagramObject,
val text: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def DiagramObject: DiagramObject = sup.asInstanceOf[DiagramObject]
    override def copy (): Row = { return (clone ().asInstanceOf[TextDiagramObject]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object TextDiagramObject
extends
    Parseable[TextDiagramObject]
{
    val sup = DiagramObject.parse _
    val text = parse_element (element ("""TextDiagramObject.text"""))_
    def parse (context: Context): TextDiagramObject =
    {
        TextDiagramObject(
            sup (context),
            text (context)
        )
    }
}

/**
 * Layers are typically used for grouping diagram objects according to themes and scales.
 * Themes are used to display or hide certain information (e.g., lakes, borders), while scales are used for hiding or displaying information depending on the current zoom level (hide text when it is too small to be read, or when it exceeds the screen size). This is also called de-cluttering.
 * @param sup Reference to the superclass object.
 * @param drawingOrder The drawing order for this layer.
 *        The higher the number, the later the layer and the objects within it are rendered.
 */
case class VisibilityLayer
(override val sup: IdentifiedObject,
val drawingOrder: Int
)
extends
    Element
{
    def this () = { this (null, 0) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[VisibilityLayer]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object VisibilityLayer
extends
    Parseable[VisibilityLayer]
{
    val sup = IdentifiedObject.parse _
    val drawingOrder = parse_element (element ("""VisibilityLayer.drawingOrder"""))_
    def parse (context: Context): VisibilityLayer =
    {
        VisibilityLayer(
            sup (context),
            toInteger (drawingOrder (context), context)
        )
    }
}

object _DiagramLayout
{
    def register: Unit =
    {
        Diagram.register
        DiagramObject.register
        DiagramObjectGluePoint.register
        DiagramObjectPoint.register
        DiagramObjectStyle.register
        DiagramStyle.register
        OrientationKind.register
        TextDiagramObject.register
        VisibilityLayer.register
    }
}
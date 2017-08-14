package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/**
 * The diagram being exchanged.
 * The coordinate system is a standard Cartesian coordinate system and the orientation attribute defines the orientation.
 *
 * @param sup Reference to the superclass object.
 * @param orientation Coordinate system orientation of the diagram.
 * @param x1InitialView X coordinate of the first corner of the initial view.
 * @param x2InitialView X coordinate of the second corner of the initial view.
 * @param y1InitialView Y coordinate of the first corner of the initial view.
 * @param y2InitialView Y coordinate of the second corner of the initial view.
 * @param DiagramStyle A Diagram may have a DiagramStyle.
 * @group DiagramLayout
 * @groupname DiagramLayout Package DiagramLayout
 * @groupdesc DiagramLayout This package describes diagram layout. This describes how objects are arranged in a coordianate system rather than how they are rendered.
 */
case class Diagram
(
    override val sup: IdentifiedObject,
    orientation: String,
    x1InitialView: Double,
    x2InitialView: Double,
    y1InitialView: Double,
    y2InitialView: Double,
    DiagramStyle: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, 0.0, 0.0, 0.0, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[Diagram] }
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
        sup.export_fields +
        (if (null != orientation) "\t\t<cim:Diagram.orientation rdf:resource=\"#" + orientation + "\"/>\n" else "") +
        "\t\t<cim:Diagram.x1InitialView>" + x1InitialView + "</cim:Diagram.x1InitialView>\n" +
        "\t\t<cim:Diagram.x2InitialView>" + x2InitialView + "</cim:Diagram.x2InitialView>\n" +
        "\t\t<cim:Diagram.y1InitialView>" + y1InitialView + "</cim:Diagram.y1InitialView>\n" +
        "\t\t<cim:Diagram.y2InitialView>" + y2InitialView + "</cim:Diagram.y2InitialView>\n" +
        (if (null != DiagramStyle) "\t\t<cim:Diagram.DiagramStyle rdf:resource=\"#" + DiagramStyle + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:Diagram rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:Diagram>"
    }
}

object Diagram
extends
    Parseable[Diagram]
{
    val orientation = parse_attribute (attribute ("""Diagram.orientation"""))
    val x1InitialView = parse_element (element ("""Diagram.x1InitialView"""))
    val x2InitialView = parse_element (element ("""Diagram.x2InitialView"""))
    val y1InitialView = parse_element (element ("""Diagram.y1InitialView"""))
    val y2InitialView = parse_element (element ("""Diagram.y2InitialView"""))
    val DiagramStyle = parse_attribute (attribute ("""Diagram.DiagramStyle"""))
    def parse (context: Context): Diagram =
    {
        Diagram(
            IdentifiedObject.parse (context),
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
 *
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
 * @group DiagramLayout
 * @groupname DiagramLayout Package DiagramLayout
 * @groupdesc DiagramLayout This package describes diagram layout. This describes how objects are arranged in a coordianate system rather than how they are rendered.
 */
case class DiagramObject
(
    override val sup: IdentifiedObject,
    drawingOrder: Int,
    isPolygon: Boolean,
    offsetX: Double,
    offsetY: Double,
    rotation: Double,
    Diagram: String,
    DiagramObjectStyle: String,
    IdentifiedObject_attr: String,
    VisibilityLayers: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, false, 0.0, 0.0, 0.0, null, null, null, List()) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[DiagramObject] }
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
        sup.export_fields +
        "\t\t<cim:DiagramObject.drawingOrder>" + drawingOrder + "</cim:DiagramObject.drawingOrder>\n" +
        "\t\t<cim:DiagramObject.isPolygon>" + isPolygon + "</cim:DiagramObject.isPolygon>\n" +
        "\t\t<cim:DiagramObject.offsetX>" + offsetX + "</cim:DiagramObject.offsetX>\n" +
        "\t\t<cim:DiagramObject.offsetY>" + offsetY + "</cim:DiagramObject.offsetY>\n" +
        "\t\t<cim:DiagramObject.rotation>" + rotation + "</cim:DiagramObject.rotation>\n" +
        (if (null != Diagram) "\t\t<cim:DiagramObject.Diagram rdf:resource=\"#" + Diagram + "\"/>\n" else "") +
        (if (null != DiagramObjectStyle) "\t\t<cim:DiagramObject.DiagramObjectStyle rdf:resource=\"#" + DiagramObjectStyle + "\"/>\n" else "") +
        (if (null != IdentifiedObject_attr) "\t\t<cim:DiagramObject.IdentifiedObject rdf:resource=\"#" + IdentifiedObject_attr + "\"/>\n" else "") +
        (if (null != VisibilityLayers) VisibilityLayers.map (x => "\t\t<cim:DiagramObject.VisibilityLayers rdf:resource=\"#" + x + "\"/>\n").mkString else "")
    }
    override def export: String =
    {
        "\t<cim:DiagramObject rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DiagramObject>"
    }
}

object DiagramObject
extends
    Parseable[DiagramObject]
{
    val drawingOrder = parse_element (element ("""DiagramObject.drawingOrder"""))
    val isPolygon = parse_element (element ("""DiagramObject.isPolygon"""))
    val offsetX = parse_element (element ("""DiagramObject.offsetX"""))
    val offsetY = parse_element (element ("""DiagramObject.offsetY"""))
    val rotation = parse_element (element ("""DiagramObject.rotation"""))
    val Diagram = parse_attribute (attribute ("""DiagramObject.Diagram"""))
    val DiagramObjectStyle = parse_attribute (attribute ("""DiagramObject.DiagramObjectStyle"""))
    val IdentifiedObject_attr = parse_attribute (attribute ("""DiagramObject.IdentifiedObject"""))
    val VisibilityLayers = parse_attributes (attribute ("""DiagramObject.VisibilityLayers"""))
    def parse (context: Context): DiagramObject =
    {
        DiagramObject(
            IdentifiedObject.parse (context),
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
 *
 * @param sup Reference to the superclass object.
 * @group DiagramLayout
 * @groupname DiagramLayout Package DiagramLayout
 * @groupdesc DiagramLayout This package describes diagram layout. This describes how objects are arranged in a coordianate system rather than how they are rendered.
 */
case class DiagramObjectGluePoint
(
    override val sup: BasicElement
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[DiagramObjectGluePoint] }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:DiagramObjectGluePoint rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DiagramObjectGluePoint>"
    }
}

object DiagramObjectGluePoint
extends
    Parseable[DiagramObjectGluePoint]
{
    def parse (context: Context): DiagramObjectGluePoint =
    {
        DiagramObjectGluePoint(
            BasicElement.parse (context)
        )
    }
}

/**
 * A point in a given space defined by 3 coordinates and associated to a diagram object.
 * The coordinates may be positive or negative as the origin does not have to be in the corner of a diagram.
 *
 * @param sup Reference to the superclass object.
 * @param sequenceNumber The sequence position of the point, used for defining the order of points for diagram objects acting as a polyline or polygon with more than one point.
 * @param xPosition The X coordinate of this point.
 * @param yPosition The Y coordinate of this point.
 * @param zPosition The Z coordinate of this point.
 * @param DiagramObject The diagram object with which the points are associated.
 * @param DiagramObjectGluePoint The 'glue' point to which this point is associated.
 * @group DiagramLayout
 * @groupname DiagramLayout Package DiagramLayout
 * @groupdesc DiagramLayout This package describes diagram layout. This describes how objects are arranged in a coordianate system rather than how they are rendered.
 */
case class DiagramObjectPoint
(
    override val sup: BasicElement,
    sequenceNumber: Int,
    xPosition: Double,
    yPosition: Double,
    zPosition: Double,
    DiagramObject: String,
    DiagramObjectGluePoint: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, 0.0, 0.0, 0.0, null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def  Element: Element = sup.asInstanceOf[Element]
    override def copy (): Row = { clone ().asInstanceOf[DiagramObjectPoint] }
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
        sup.export_fields +
        "\t\t<cim:DiagramObjectPoint.sequenceNumber>" + sequenceNumber + "</cim:DiagramObjectPoint.sequenceNumber>\n" +
        "\t\t<cim:DiagramObjectPoint.xPosition>" + xPosition + "</cim:DiagramObjectPoint.xPosition>\n" +
        "\t\t<cim:DiagramObjectPoint.yPosition>" + yPosition + "</cim:DiagramObjectPoint.yPosition>\n" +
        "\t\t<cim:DiagramObjectPoint.zPosition>" + zPosition + "</cim:DiagramObjectPoint.zPosition>\n" +
        (if (null != DiagramObject) "\t\t<cim:DiagramObjectPoint.DiagramObject rdf:resource=\"#" + DiagramObject + "\"/>\n" else "") +
        (if (null != DiagramObjectGluePoint) "\t\t<cim:DiagramObjectPoint.DiagramObjectGluePoint rdf:resource=\"#" + DiagramObjectGluePoint + "\"/>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:DiagramObjectPoint rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DiagramObjectPoint>"
    }
}

object DiagramObjectPoint
extends
    Parseable[DiagramObjectPoint]
{
    val sequenceNumber = parse_element (element ("""DiagramObjectPoint.sequenceNumber"""))
    val xPosition = parse_element (element ("""DiagramObjectPoint.xPosition"""))
    val yPosition = parse_element (element ("""DiagramObjectPoint.yPosition"""))
    val zPosition = parse_element (element ("""DiagramObjectPoint.zPosition"""))
    val DiagramObject = parse_attribute (attribute ("""DiagramObjectPoint.DiagramObject"""))
    val DiagramObjectGluePoint = parse_attribute (attribute ("""DiagramObjectPoint.DiagramObjectGluePoint"""))
    def parse (context: Context): DiagramObjectPoint =
    {
        DiagramObjectPoint(
            BasicElement.parse (context),
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
 *
 * @param sup Reference to the superclass object.
 * @group DiagramLayout
 * @groupname DiagramLayout Package DiagramLayout
 * @groupdesc DiagramLayout This package describes diagram layout. This describes how objects are arranged in a coordianate system rather than how they are rendered.
 */
case class DiagramObjectStyle
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[DiagramObjectStyle] }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:DiagramObjectStyle rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DiagramObjectStyle>"
    }
}

object DiagramObjectStyle
extends
    Parseable[DiagramObjectStyle]
{
    def parse (context: Context): DiagramObjectStyle =
    {
        DiagramObjectStyle(
            IdentifiedObject.parse (context)
        )
    }
}

/**
 * The diagram style refer to a style used by the originating system for a diagram.
 * A diagram style describes information such as schematic, geographic, bus-branch etc.
 *
 * @param sup Reference to the superclass object.
 * @group DiagramLayout
 * @groupname DiagramLayout Package DiagramLayout
 * @groupdesc DiagramLayout This package describes diagram layout. This describes how objects are arranged in a coordianate system rather than how they are rendered.
 */
case class DiagramStyle
(
    override val sup: IdentifiedObject
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[DiagramStyle] }
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
        sup.export_fields +
        ""
    }
    override def export: String =
    {
        "\t<cim:DiagramStyle rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:DiagramStyle>"
    }
}

object DiagramStyle
extends
    Parseable[DiagramStyle]
{
    def parse (context: Context): DiagramStyle =
    {
        DiagramStyle(
            IdentifiedObject.parse (context)
        )
    }
}

/**
 * A diagram object for placing free-text or text derived from an associated domain object.
 *
 * @param sup Reference to the superclass object.
 * @param text The text that is displayed by this text diagram object.
 * @group DiagramLayout
 * @groupname DiagramLayout Package DiagramLayout
 * @groupdesc DiagramLayout This package describes diagram layout. This describes how objects are arranged in a coordianate system rather than how they are rendered.
 */
case class TextDiagramObject
(
    override val sup: DiagramObject,
    text: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def DiagramObject: DiagramObject = sup.asInstanceOf[DiagramObject]
    override def copy (): Row = { clone ().asInstanceOf[TextDiagramObject] }
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
        sup.export_fields +
        (if (null != text) "\t\t<cim:TextDiagramObject.text>" + text + "</cim:TextDiagramObject.text>\n" else "")
    }
    override def export: String =
    {
        "\t<cim:TextDiagramObject rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:TextDiagramObject>"
    }
}

object TextDiagramObject
extends
    Parseable[TextDiagramObject]
{
    val text = parse_element (element ("""TextDiagramObject.text"""))
    def parse (context: Context): TextDiagramObject =
    {
        TextDiagramObject(
            DiagramObject.parse (context),
            text (context)
        )
    }
}

/**
 * Layers are typically used for grouping diagram objects according to themes and scales.
 * Themes are used to display or hide certain information (e.g., lakes, borders), while scales are used for hiding or displaying information depending on the current zoom level (hide text when it is too small to be read, or when it exceeds the screen size). This is also called de-cluttering.
 *
 * @param sup Reference to the superclass object.
 * @param drawingOrder The drawing order for this layer.
 *        The higher the number, the later the layer and the objects within it are rendered.
 * @group DiagramLayout
 * @groupname DiagramLayout Package DiagramLayout
 * @groupdesc DiagramLayout This package describes diagram layout. This describes how objects are arranged in a coordianate system rather than how they are rendered.
 */
case class VisibilityLayer
(
    override val sup: IdentifiedObject,
    drawingOrder: Int
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0) }
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { clone ().asInstanceOf[VisibilityLayer] }
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
        sup.export_fields +
        "\t\t<cim:VisibilityLayer.drawingOrder>" + drawingOrder + "</cim:VisibilityLayer.drawingOrder>\n"
    }
    override def export: String =
    {
        "\t<cim:VisibilityLayer rdf:ID=\"" + id + "\">\n" +
        export_fields +
        "\t</cim:VisibilityLayer>"
    }
}

object VisibilityLayer
extends
    Parseable[VisibilityLayer]
{
    val drawingOrder = parse_element (element ("""VisibilityLayer.drawingOrder"""))
    def parse (context: Context): VisibilityLayer =
    {
        VisibilityLayer(
            IdentifiedObject.parse (context),
            toInteger (drawingOrder (context), context)
        )
    }
}

private[ninecode] object _DiagramLayout
{
    def register: List[ClassInfo] =
    {
        List (
            Diagram.register,
            DiagramObject.register,
            DiagramObjectGluePoint.register,
            DiagramObjectPoint.register,
            DiagramObjectStyle.register,
            DiagramStyle.register,
            TextDiagramObject.register,
            VisibilityLayer.register
        )
    }
}
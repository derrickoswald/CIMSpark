package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.ClassInfo
import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable
import ch.ninecode.cim.Relationship

/**
 * The diagram being exchanged.
 *
 * The coordinate system is a standard Cartesian coordinate system and the orientation attribute defines the orientation.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param orientation Coordinate system orientation of the diagram.
 * @param x1InitialView X coordinate of the first corner of the initial view.
 * @param x2InitialView X coordinate of the second corner of the initial view.
 * @param y1InitialView Y coordinate of the first corner of the initial view.
 * @param y2InitialView Y coordinate of the second corner of the initial view.
 * @param DiagramStyle [[ch.ninecode.model.DiagramStyle DiagramStyle]] A Diagram may have a DiagramStyle.
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Diagram.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Diagram.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Diagram.fields (position), value)
        emitattr (0, orientation)
        emitelem (1, x1InitialView)
        emitelem (2, x2InitialView)
        emitelem (3, y1InitialView)
        emitelem (4, y2InitialView)
        emitattr (5, DiagramStyle)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:Diagram rdf:ID=\"%s\">\n%s\t</cim:Diagram>".format (id, export_fields)
    }
}

object Diagram
extends
    Parseable[Diagram]
{
    val fields: Array[String] = Array[String] (
        "orientation",
        "x1InitialView",
        "x2InitialView",
        "y1InitialView",
        "y2InitialView",
        "DiagramStyle"
    )
    val orientation: Fielder = parse_attribute (attribute (cls, fields(0)))
    val x1InitialView: Fielder = parse_element (element (cls, fields(1)))
    val x2InitialView: Fielder = parse_element (element (cls, fields(2)))
    val y1InitialView: Fielder = parse_element (element (cls, fields(3)))
    val y2InitialView: Fielder = parse_element (element (cls, fields(4)))
    val DiagramStyle: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): Diagram =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = Diagram (
            IdentifiedObject.parse (context),
            mask (orientation (), 0),
            toDouble (mask (x1InitialView (), 1)),
            toDouble (mask (x2InitialView (), 2)),
            toDouble (mask (y1InitialView (), 3)),
            toDouble (mask (y2InitialView (), 4)),
            mask (DiagramStyle (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("DiagramStyle", "DiagramStyle", false)
    )
}

/**
 * An object that defines one or more points in a given space.
 *
 * This object can be associated with anything that specializes IdentifiedObject. For single line diagrams such objects typically include such items as analog values, breakers, disconnectors, power transformers, and transmission lines.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
 * @param Diagram [[ch.ninecode.model.Diagram Diagram]] A diagram object is part of a diagram.
 * @param DiagramObjectStyle [[ch.ninecode.model.DiagramObjectStyle DiagramObjectStyle]] A diagram object has a style associated that provides a reference for the style used in the originating system.
 * @param IdentifiedObject_attr [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] The domain object to which this diagram object is associated.
 * @param VisibilityLayers [[ch.ninecode.model.VisibilityLayer VisibilityLayer]] A diagram object can be part of multiple visibility layers.
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DiagramObject.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DiagramObject.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DiagramObject.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (DiagramObject.fields (position), x))
        emitelem (0, drawingOrder)
        emitelem (1, isPolygon)
        emitelem (2, offsetX)
        emitelem (3, offsetY)
        emitelem (4, rotation)
        emitattr (5, Diagram)
        emitattr (6, DiagramObjectStyle)
        emitattr (7, IdentifiedObject_attr)
        emitattrs (8, VisibilityLayers)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DiagramObject rdf:ID=\"%s\">\n%s\t</cim:DiagramObject>".format (id, export_fields)
    }
}

object DiagramObject
extends
    Parseable[DiagramObject]
{
    val fields: Array[String] = Array[String] (
        "drawingOrder",
        "isPolygon",
        "offsetX",
        "offsetY",
        "rotation",
        "Diagram",
        "DiagramObjectStyle",
        "IdentifiedObject",
        "VisibilityLayers"
    )
    val drawingOrder: Fielder = parse_element (element (cls, fields(0)))
    val isPolygon: Fielder = parse_element (element (cls, fields(1)))
    val offsetX: Fielder = parse_element (element (cls, fields(2)))
    val offsetY: Fielder = parse_element (element (cls, fields(3)))
    val rotation: Fielder = parse_element (element (cls, fields(4)))
    val Diagram: Fielder = parse_attribute (attribute (cls, fields(5)))
    val DiagramObjectStyle: Fielder = parse_attribute (attribute (cls, fields(6)))
    val IdentifiedObject_attr: Fielder = parse_attribute (attribute (cls, fields(7)))
    val VisibilityLayers: FielderMultiple = parse_attributes (attribute (cls, fields(8)))

    def parse (context: Context): DiagramObject =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DiagramObject (
            IdentifiedObject.parse (context),
            toInteger (mask (drawingOrder (), 0)),
            toBoolean (mask (isPolygon (), 1)),
            toDouble (mask (offsetX (), 2)),
            toDouble (mask (offsetY (), 3)),
            toDouble (mask (rotation (), 4)),
            mask (Diagram (), 5),
            mask (DiagramObjectStyle (), 6),
            mask (IdentifiedObject_attr (), 7),
            masks (VisibilityLayers (), 8)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("Diagram", "Diagram", false),
        Relationship ("DiagramObjectStyle", "DiagramObjectStyle", false),
        Relationship ("IdentifiedObject_attr", "IdentifiedObject", false),
        Relationship ("VisibilityLayers", "VisibilityLayer", true)
    )
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:DiagramObjectGluePoint rdf:ID=\"%s\">\n%s\t</cim:DiagramObjectGluePoint>".format (id, export_fields)
    }
}

object DiagramObjectGluePoint
extends
    Parseable[DiagramObjectGluePoint]
{

    def parse (context: Context): DiagramObjectGluePoint =
    {
        implicit val ctx: Context = context
        val ret = DiagramObjectGluePoint (
            BasicElement.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * A point in a given space defined by 3 coordinates and associated to a diagram object.
 *
 * The coordinates may be positive or negative as the origin does not have to be in the corner of a diagram.
 *
 * @param sup Reference to the superclass object.
 * @param sequenceNumber The sequence position of the point, used for defining the order of points for diagram objects acting as a polyline or polygon with more than one point.
 * @param xPosition The X coordinate of this point.
 * @param yPosition The Y coordinate of this point.
 * @param zPosition The Z coordinate of this point.
 * @param DiagramObject [[ch.ninecode.model.DiagramObject DiagramObject]] The diagram object with which the points are associated.
 * @param DiagramObjectGluePoint [[ch.ninecode.model.DiagramObjectGluePoint DiagramObjectGluePoint]] The 'glue' point to which this point is associated.
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DiagramObjectPoint.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DiagramObjectPoint.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DiagramObjectPoint.fields (position), value)
        emitelem (0, sequenceNumber)
        emitelem (1, xPosition)
        emitelem (2, yPosition)
        emitelem (3, zPosition)
        emitattr (4, DiagramObject)
        emitattr (5, DiagramObjectGluePoint)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:DiagramObjectPoint rdf:ID=\"%s\">\n%s\t</cim:DiagramObjectPoint>".format (id, export_fields)
    }
}

object DiagramObjectPoint
extends
    Parseable[DiagramObjectPoint]
{
    val fields: Array[String] = Array[String] (
        "sequenceNumber",
        "xPosition",
        "yPosition",
        "zPosition",
        "DiagramObject",
        "DiagramObjectGluePoint"
    )
    val sequenceNumber: Fielder = parse_element (element (cls, fields(0)))
    val xPosition: Fielder = parse_element (element (cls, fields(1)))
    val yPosition: Fielder = parse_element (element (cls, fields(2)))
    val zPosition: Fielder = parse_element (element (cls, fields(3)))
    val DiagramObject: Fielder = parse_attribute (attribute (cls, fields(4)))
    val DiagramObjectGluePoint: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: Context): DiagramObjectPoint =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DiagramObjectPoint (
            BasicElement.parse (context),
            toInteger (mask (sequenceNumber (), 0)),
            toDouble (mask (xPosition (), 1)),
            toDouble (mask (yPosition (), 2)),
            toDouble (mask (zPosition (), 3)),
            mask (DiagramObject (), 4),
            mask (DiagramObjectGluePoint (), 5)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("DiagramObject", "DiagramObject", false),
        Relationship ("DiagramObjectGluePoint", "DiagramObjectGluePoint", false)
    )
}

/**
 * A reference to a style used by the originating system for a diagram object.
 *
 * A diagram object style describes information such as line thickness, shape such as circle or rectangle etc, and color.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:DiagramObjectStyle rdf:ID=\"%s\">\n%s\t</cim:DiagramObjectStyle>".format (id, export_fields)
    }
}

object DiagramObjectStyle
extends
    Parseable[DiagramObjectStyle]
{

    def parse (context: Context): DiagramObjectStyle =
    {
        implicit val ctx: Context = context
        val ret = DiagramObjectStyle (
            IdentifiedObject.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * The diagram style refer to a style used by the originating system for a diagram.
 *
 * A diagram style describes information such as schematic, geographic, bus-branch etc.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
        sup.export_fields
    }
    override def export: String =
    {
        "\t<cim:DiagramStyle rdf:ID=\"%s\">\n%s\t</cim:DiagramStyle>".format (id, export_fields)
    }
}

object DiagramStyle
extends
    Parseable[DiagramStyle]
{

    def parse (context: Context): DiagramStyle =
    {
        implicit val ctx: Context = context
        val ret = DiagramStyle (
            IdentifiedObject.parse (context)
        )
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * A diagram object for placing free-text or text derived from an associated domain object.
 *
 * @param sup [[ch.ninecode.model.DiagramObject DiagramObject]] Reference to the superclass object.
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = TextDiagramObject.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (TextDiagramObject.fields (position), value)
        emitelem (0, text)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:TextDiagramObject rdf:ID=\"%s\">\n%s\t</cim:TextDiagramObject>".format (id, export_fields)
    }
}

object TextDiagramObject
extends
    Parseable[TextDiagramObject]
{
    val fields: Array[String] = Array[String] (
        "text"
    )
    val text: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: Context): TextDiagramObject =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = TextDiagramObject (
            DiagramObject.parse (context),
            mask (text (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (

    )
}

/**
 * Layers are typically used for grouping diagram objects according to themes and scales.
 *
 * Themes are used to display or hide certain information (e.g., lakes, borders), while scales are used for hiding or displaying information depending on the current zoom level (hide text when it is too small to be read, or when it exceeds the screen size). This is also called de-cluttering.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param drawingOrder The drawing order for this layer.
 *        The higher the number, the later the layer and the objects within it are rendered.
 * @param VisibleObjects [[ch.ninecode.model.DiagramObject DiagramObject]] A visibility layer can contain one or more diagram objects.
 * @group DiagramLayout
 * @groupname DiagramLayout Package DiagramLayout
 * @groupdesc DiagramLayout This package describes diagram layout. This describes how objects are arranged in a coordianate system rather than how they are rendered.
 */
case class VisibilityLayer
(
    override val sup: IdentifiedObject,
    drawingOrder: Int,
    VisibleObjects: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, 0, List()) }
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
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = VisibilityLayer.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (VisibilityLayer.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position)) value.foreach (x ⇒ emit_attribute (VisibilityLayer.fields (position), x))
        emitelem (0, drawingOrder)
        emitattrs (1, VisibleObjects)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:VisibilityLayer rdf:ID=\"%s\">\n%s\t</cim:VisibilityLayer>".format (id, export_fields)
    }
}

object VisibilityLayer
extends
    Parseable[VisibilityLayer]
{
    val fields: Array[String] = Array[String] (
        "drawingOrder",
        "VisibleObjects"
    )
    val drawingOrder: Fielder = parse_element (element (cls, fields(0)))
    val VisibleObjects: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: Context): VisibilityLayer =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = VisibilityLayer (
            IdentifiedObject.parse (context),
            toInteger (mask (drawingOrder (), 0)),
            masks (VisibleObjects (), 1)
        )
        ret.bitfields = bitfields
        ret
    }
    val relations: List[Relationship] = List (
        Relationship ("VisibleObjects", "DiagramObject", true)
    )
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
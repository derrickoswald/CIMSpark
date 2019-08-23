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
 * @param DiagramElements [[ch.ninecode.model.DiagramObject DiagramObject]] A diagram is made up of multiple diagram objects.
 * @param DiagramStyle [[ch.ninecode.model.DiagramStyle DiagramStyle]] A Diagram may have a DiagramStyle.
 * @group DiagramLayout
 * @groupname DiagramLayout Package DiagramLayout
 * @groupdesc DiagramLayout This package describes diagram layout. This describes how objects are arranged in a coordinate system rather than how they are rendered.
 */
final case class Diagram
(
    override val sup: IdentifiedObject,
    orientation: String,
    x1InitialView: Double,
    x2InitialView: Double,
    y1InitialView: Double,
    y2InitialView: Double,
    DiagramElements: List[String],
    DiagramStyle: String
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, null, 0.0, 0.0, 0.0, 0.0, List(), null) }
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
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = Diagram.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (Diagram.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (Diagram.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (Diagram.fields (position), x))
        emitattr (0, orientation)
        emitelem (1, x1InitialView)
        emitelem (2, x2InitialView)
        emitelem (3, y1InitialView)
        emitelem (4, y2InitialView)
        emitattrs (5, DiagramElements)
        emitattr (6, DiagramStyle)
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
    override val fields: Array[String] = Array[String] (
        "orientation",
        "x1InitialView",
        "x2InitialView",
        "y1InitialView",
        "y2InitialView",
        "DiagramElements",
        "DiagramStyle"
    )
    override val relations: List[Relationship] = List (
        Relationship ("DiagramElements", "DiagramObject", "0..*", "0..1"),
        Relationship ("DiagramStyle", "DiagramStyle", "0..1", "0..*")
    )
    val orientation: Fielder = parse_attribute (attribute (cls, fields(0)))
    val x1InitialView: Fielder = parse_element (element (cls, fields(1)))
    val x2InitialView: Fielder = parse_element (element (cls, fields(2)))
    val y1InitialView: Fielder = parse_element (element (cls, fields(3)))
    val y2InitialView: Fielder = parse_element (element (cls, fields(4)))
    val DiagramElements: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val DiagramStyle: Fielder = parse_attribute (attribute (cls, fields(6)))

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
            masks (DiagramElements (), 5),
            mask (DiagramStyle (), 6)
        )
        ret.bitfields = bitfields
        ret
    }
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
 *        
 *        The offset is in per-unit with 0 indicating there is no offset from the horizontal centre of the icon.  -0.5 indicates it is offset by 50% to the left and 0.5 indicates an offset of 50% to the right.
 * @param offsetY The offset in the Y direction.
 *        This is used for defining the offset from centre for rendering an icon (the default is that a single point specifies the centre of the icon).
 *        
 *        The offset is in per-unit with 0 indicating there is no offset from the vertical centre of the icon.  The offset direction is dependent on the orientation of the diagram, with -0.5 and 0.5 indicating an offset of +/- 50% on the vertical axis.
 * @param rotation Sets the angle of rotation of the diagram object.
 *        Zero degrees is pointing to the top of the diagram.  Rotation is clockwise.  DiagramObject.rotation=0 has the following meaning: The connection point of an element which has one terminal is pointing to the top side of the diagram. The connection point "From side" of an element which has more than one terminal is pointing to the top side of the diagram.
 *        DiagramObject.rotation=90 has the following meaning: The connection point of an element which has one terminal is pointing to the right hand side of the diagram. The connection point "From side" of an element which has more than one terminal is pointing to the right hand side of the diagram.
 * @param Diagram [[ch.ninecode.model.Diagram Diagram]] A diagram object is part of a diagram.
 * @param DiagramObjectPoints [[ch.ninecode.model.DiagramObjectPoint DiagramObjectPoint]] A diagram object can have 0 or more points to reflect its layout position, routing (for polylines) or boundary (for polygons).
 * @param DiagramObjectStyle [[ch.ninecode.model.DiagramObjectStyle DiagramObjectStyle]] A diagram object has a style associated that provides a reference for the style used in the originating system.
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] The domain object to which this diagram object is associated.
 * @param VisibilityLayers [[ch.ninecode.model.VisibilityLayer VisibilityLayer]] A diagram object can be part of multiple visibility layers.
 * @group DiagramLayout
 * @groupname DiagramLayout Package DiagramLayout
 * @groupdesc DiagramLayout This package describes diagram layout. This describes how objects are arranged in a coordinate system rather than how they are rendered.
 */
final case class DiagramObject
(
    override val sup: IdentifiedObject,
    drawingOrder: Int,
    isPolygon: Boolean,
    offsetX: Double,
    offsetY: Double,
    rotation: Double,
    Diagram: String,
    DiagramObjectPoints: List[String],
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
    def this () = { this (null, 0, false, 0.0, 0.0, 0.0, null, List(), null, null, List()) }
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
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DiagramObject.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (DiagramObject.fields (position), value)
        def emitattr (position: Int, value: Any): Unit = if (mask (position)) emit_attribute (DiagramObject.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (DiagramObject.fields (position), x))
        emitelem (0, drawingOrder)
        emitelem (1, isPolygon)
        emitelem (2, offsetX)
        emitelem (3, offsetY)
        emitelem (4, rotation)
        emitattr (5, Diagram)
        emitattrs (6, DiagramObjectPoints)
        emitattr (7, DiagramObjectStyle)
        emitattr (8, IdentifiedObject_attr)
        emitattrs (9, VisibilityLayers)
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
    override val fields: Array[String] = Array[String] (
        "drawingOrder",
        "isPolygon",
        "offsetX",
        "offsetY",
        "rotation",
        "Diagram",
        "DiagramObjectPoints",
        "DiagramObjectStyle",
        "IdentifiedObject",
        "VisibilityLayers"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Diagram", "Diagram", "0..1", "0..*"),
        Relationship ("DiagramObjectPoints", "DiagramObjectPoint", "0..*", "1"),
        Relationship ("DiagramObjectStyle", "DiagramObjectStyle", "0..1", "0..*"),
        Relationship ("IdentifiedObject_attr", "IdentifiedObject", "0..1", "0..*"),
        Relationship ("VisibilityLayers", "VisibilityLayer", "0..*", "0..*")
    )
    val drawingOrder: Fielder = parse_element (element (cls, fields(0)))
    val isPolygon: Fielder = parse_element (element (cls, fields(1)))
    val offsetX: Fielder = parse_element (element (cls, fields(2)))
    val offsetY: Fielder = parse_element (element (cls, fields(3)))
    val rotation: Fielder = parse_element (element (cls, fields(4)))
    val Diagram: Fielder = parse_attribute (attribute (cls, fields(5)))
    val DiagramObjectPoints: FielderMultiple = parse_attributes (attribute (cls, fields(6)))
    val DiagramObjectStyle: Fielder = parse_attribute (attribute (cls, fields(7)))
    val IdentifiedObject_attr: Fielder = parse_attribute (attribute (cls, fields(8)))
    val VisibilityLayers: FielderMultiple = parse_attributes (attribute (cls, fields(9)))

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
            masks (DiagramObjectPoints (), 6),
            mask (DiagramObjectStyle (), 7),
            mask (IdentifiedObject_attr (), 8),
            masks (VisibilityLayers (), 9)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * This is used for grouping diagram object points from different diagram objects that are considered to be glued together in a diagram even if they are not at the exact same coordinates.
 *
 * @param sup Reference to the superclass object.
 * @param DiagramObjectPoints [[ch.ninecode.model.DiagramObjectPoint DiagramObjectPoint]] A diagram object glue point is associated with 2 or more object points that are considered to be 'glued' together.
 * @group DiagramLayout
 * @groupname DiagramLayout Package DiagramLayout
 * @groupdesc DiagramLayout This package describes diagram layout. This describes how objects are arranged in a coordinate system rather than how they are rendered.
 */
final case class DiagramObjectGluePoint
(
    override val sup: BasicElement,
    DiagramObjectPoints: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List()) }
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
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DiagramObjectGluePoint.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (DiagramObjectGluePoint.fields (position), x))
        emitattrs (0, DiagramObjectPoints)
        s.toString
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
    override val fields: Array[String] = Array[String] (
        "DiagramObjectPoints"
    )
    override val relations: List[Relationship] = List (
        Relationship ("DiagramObjectPoints", "DiagramObjectPoint", "2..*", "0..1")
    )
    val DiagramObjectPoints: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): DiagramObjectGluePoint =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DiagramObjectGluePoint (
            BasicElement.parse (context),
            masks (DiagramObjectPoints (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
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
 * @groupdesc DiagramLayout This package describes diagram layout. This describes how objects are arranged in a coordinate system rather than how they are rendered.
 */
final case class DiagramObjectPoint
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
            throw new IllegalArgumentException (s"invalid property index ${i}")
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
    override val fields: Array[String] = Array[String] (
        "sequenceNumber",
        "xPosition",
        "yPosition",
        "zPosition",
        "DiagramObject",
        "DiagramObjectGluePoint"
    )
    override val relations: List[Relationship] = List (
        Relationship ("DiagramObject", "DiagramObject", "1", "0..*"),
        Relationship ("DiagramObjectGluePoint", "DiagramObjectGluePoint", "0..1", "2..*")
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
}

/**
 * A reference to a style used by the originating system for a diagram object.
 *
 * A diagram object style describes information such as line thickness, shape such as circle or rectangle etc, and colour.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param StyledObjects [[ch.ninecode.model.DiagramObject DiagramObject]] A style can be assigned to multiple diagram objects.
 * @group DiagramLayout
 * @groupname DiagramLayout Package DiagramLayout
 * @groupdesc DiagramLayout This package describes diagram layout. This describes how objects are arranged in a coordinate system rather than how they are rendered.
 */
final case class DiagramObjectStyle
(
    override val sup: IdentifiedObject,
    StyledObjects: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List()) }
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
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DiagramObjectStyle.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (DiagramObjectStyle.fields (position), x))
        emitattrs (0, StyledObjects)
        s.toString
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
    override val fields: Array[String] = Array[String] (
        "StyledObjects"
    )
    override val relations: List[Relationship] = List (
        Relationship ("StyledObjects", "DiagramObject", "0..*", "0..1")
    )
    val StyledObjects: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): DiagramObjectStyle =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DiagramObjectStyle (
            IdentifiedObject.parse (context),
            masks (StyledObjects (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * The diagram style refers to a style used by the originating system for a diagram.
 *
 * A diagram style describes information such as schematic, geographic, etc.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Diagram [[ch.ninecode.model.Diagram Diagram]] A DiagramStyle can be used by many Diagrams.
 * @group DiagramLayout
 * @groupname DiagramLayout Package DiagramLayout
 * @groupdesc DiagramLayout This package describes diagram layout. This describes how objects are arranged in a coordinate system rather than how they are rendered.
 */
final case class DiagramStyle
(
    override val sup: IdentifiedObject,
    Diagram: List[String]
)
extends
    Element
{
    /**
     * Zero args constructor.
     */
    def this () = { this (null, List()) }
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
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = DiagramStyle.cls
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (DiagramStyle.fields (position), x))
        emitattrs (0, Diagram)
        s.toString
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
    override val fields: Array[String] = Array[String] (
        "Diagram"
    )
    override val relations: List[Relationship] = List (
        Relationship ("Diagram", "Diagram", "0..*", "0..1")
    )
    val Diagram: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: Context): DiagramStyle =
    {
        implicit val ctx: Context = context
        implicit var bitfields: Array[Int] = Array(0)
        val ret = DiagramStyle (
            IdentifiedObject.parse (context),
            masks (Diagram (), 0)
        )
        ret.bitfields = bitfields
        ret
    }
}

/**
 * A diagram object for placing free-text or text derived from an associated domain object.
 *
 * @param sup [[ch.ninecode.model.DiagramObject DiagramObject]] Reference to the superclass object.
 * @param text The text that is displayed by this text diagram object.
 * @group DiagramLayout
 * @groupname DiagramLayout Package DiagramLayout
 * @groupdesc DiagramLayout This package describes diagram layout. This describes how objects are arranged in a coordinate system rather than how they are rendered.
 */
final case class TextDiagramObject
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
            throw new IllegalArgumentException (s"invalid property index ${i}")
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
    override val fields: Array[String] = Array[String] (
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
}

/**
 * Layers are typically used for grouping diagram objects according to themes and scales.
 *
 * Themes are used to display or hide certain information (e.g., lakes, borders), while scales are used for hiding or displaying information depending on the current zoom level (hide text when it is too small to be read, or when it exceeds the screen size). This is also called de-cluttering.
 * 
 * CIM based graphics exchange will support an m:n relationship between diagram objects and layers. It will be the task of the importing system to convert an m:n case into an appropriate 1:n representation if the importing system does not support m:n.
 *
 * @param sup [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param drawingOrder The drawing order for this layer.
 *        The higher the number, the later the layer and the objects within it are rendered.
 * @param VisibleObjects [[ch.ninecode.model.DiagramObject DiagramObject]] A visibility layer can contain one or more diagram objects.
 * @group DiagramLayout
 * @groupname DiagramLayout Package DiagramLayout
 * @groupdesc DiagramLayout This package describes diagram layout. This describes how objects are arranged in a coordinate system rather than how they are rendered.
 */
final case class VisibilityLayer
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
            throw new IllegalArgumentException (s"invalid property index ${i}")
    }
    override def length: Int = productArity
    override def export_fields: String =
    {
        implicit val s: StringBuilder = new StringBuilder (sup.export_fields)
        implicit val clz: String = VisibilityLayer.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (VisibilityLayer.fields (position), value)
        def emitattrs (position: Int, value: List[String]): Unit = if (mask (position) && (null != value)) value.foreach (x => emit_attribute (VisibilityLayer.fields (position), x))
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
    override val fields: Array[String] = Array[String] (
        "drawingOrder",
        "VisibleObjects"
    )
    override val relations: List[Relationship] = List (
        Relationship ("VisibleObjects", "DiagramObject", "0..*", "0..*")
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
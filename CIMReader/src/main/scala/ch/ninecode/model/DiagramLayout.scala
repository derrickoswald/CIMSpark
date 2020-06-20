package ch.ninecode.model

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.Serializer
import com.esotericsoftware.kryo.io.Input
import com.esotericsoftware.kryo.io.Output
import org.apache.spark.sql.Row

import ch.ninecode.cim.CIMClassInfo
import ch.ninecode.cim.CIMContext
import ch.ninecode.cim.CIMParseable
import ch.ninecode.cim.CIMRelationship
import ch.ninecode.cim.CIMSerializer

/**
 * The diagram being exchanged.
 *
 * The coordinate system is a standard Cartesian coordinate system and the orientation attribute defines the orientation. The initial view related attributes can be used to specify an initial view with the x,y coordinates of the diagonal points.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param orientation Coordinate system orientation of the diagram.
 *        A positive orientation gives standard “right-hand” orientation, with negative orientation indicating a “left-hand” orientation. For 2D diagrams, a positive orientation will result in X values increasing from left to right and Y values increasing from bottom to top. A negative orientation gives the “left-hand” orientation (favoured by computer graphics displays) with X values increasing from left to right and Y values increasing from top to bottom.
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
    IdentifiedObject: IdentifiedObject = null,
    orientation: String = null,
    x1InitialView: Double = 0.0,
    x2InitialView: Double = 0.0,
    y1InitialView: Double = 0.0,
    y2InitialView: Double = 0.0,
    DiagramElements: List[String] = null,
    DiagramStyle: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[Diagram]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("DiagramElements", "DiagramObject", "0..*", "0..1"),
        CIMRelationship ("DiagramStyle", "DiagramStyle", "0..1", "0..*")
    )
    val orientation: Fielder = parse_attribute (attribute (cls, fields(0)))
    val x1InitialView: Fielder = parse_element (element (cls, fields(1)))
    val x2InitialView: Fielder = parse_element (element (cls, fields(2)))
    val y1InitialView: Fielder = parse_element (element (cls, fields(3)))
    val y2InitialView: Fielder = parse_element (element (cls, fields(4)))
    val DiagramElements: FielderMultiple = parse_attributes (attribute (cls, fields(5)))
    val DiagramStyle: Fielder = parse_attribute (attribute (cls, fields(6)))

    def parse (context: CIMContext): Diagram =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[Diagram] = DiagramSerializer
}

object DiagramSerializer extends CIMSerializer[Diagram]
{
    def write (kryo: Kryo, output: Output, obj: Diagram): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.orientation),
            () => output.writeDouble (obj.x1InitialView),
            () => output.writeDouble (obj.x2InitialView),
            () => output.writeDouble (obj.y1InitialView),
            () => output.writeDouble (obj.y2InitialView),
            () => writeList (obj.DiagramElements, output),
            () => output.writeString (obj.DiagramStyle)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[Diagram]): Diagram =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = Diagram (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) readList (input) else null,
            if (isSet (6)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * An object that defines one or more points in a given space.
 *
 * This object can be associated with anything that specializes IdentifiedObject. For single line diagrams such objects typically include such items as analog values, breakers, disconnectors, power transformers, and transmission lines.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
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
 * @param IdentifiedObject_attr [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] The domain object to which this diagram object is associated.
 * @param VisibilityLayers [[ch.ninecode.model.VisibilityLayer VisibilityLayer]] A diagram object can be part of multiple visibility layers.
 * @group DiagramLayout
 * @groupname DiagramLayout Package DiagramLayout
 * @groupdesc DiagramLayout This package describes diagram layout. This describes how objects are arranged in a coordinate system rather than how they are rendered.
 */
final case class DiagramObject
(
    IdentifiedObject: IdentifiedObject = null,
    drawingOrder: Int = 0,
    isPolygon: Boolean = false,
    offsetX: Double = 0.0,
    offsetY: Double = 0.0,
    rotation: Double = 0.0,
    Diagram: String = null,
    DiagramObjectPoints: List[String] = null,
    DiagramObjectStyle: String = null,
    IdentifiedObject_attr: String = null,
    VisibilityLayers: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[DiagramObject]
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
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Diagram", "Diagram", "0..1", "0..*"),
        CIMRelationship ("DiagramObjectPoints", "DiagramObjectPoint", "0..*", "1"),
        CIMRelationship ("DiagramObjectStyle", "DiagramObjectStyle", "0..1", "0..*"),
        CIMRelationship ("IdentifiedObject_attr", "IdentifiedObject", "0..1", "0..*"),
        CIMRelationship ("VisibilityLayers", "VisibilityLayer", "0..*", "0..*")
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

    def parse (context: CIMContext): DiagramObject =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[DiagramObject] = DiagramObjectSerializer
}

object DiagramObjectSerializer extends CIMSerializer[DiagramObject]
{
    def write (kryo: Kryo, output: Output, obj: DiagramObject): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeInt (obj.drawingOrder),
            () => output.writeBoolean (obj.isPolygon),
            () => output.writeDouble (obj.offsetX),
            () => output.writeDouble (obj.offsetY),
            () => output.writeDouble (obj.rotation),
            () => output.writeString (obj.Diagram),
            () => writeList (obj.DiagramObjectPoints, output),
            () => output.writeString (obj.DiagramObjectStyle),
            () => output.writeString (obj.IdentifiedObject_attr),
            () => writeList (obj.VisibilityLayers, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DiagramObject]): DiagramObject =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = DiagramObject (
            parent,
            if (isSet (0)) input.readInt else 0,
            if (isSet (1)) input.readBoolean else false,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readDouble else 0.0,
            if (isSet (5)) input.readString else null,
            if (isSet (6)) readList (input) else null,
            if (isSet (7)) input.readString else null,
            if (isSet (8)) input.readString else null,
            if (isSet (9)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * This is used for grouping diagram object points from different diagram objects that are considered to be glued together in a diagram even if they are not at the exact same coordinates.
 *
 * @param Element Reference to the superclass object.
 * @param DiagramObjectPoints [[ch.ninecode.model.DiagramObjectPoint DiagramObjectPoint]] A diagram object glue point is associated with 2 or more object points that are considered to be 'glued' together.
 * @group DiagramLayout
 * @groupname DiagramLayout Package DiagramLayout
 * @groupdesc DiagramLayout This package describes diagram layout. This describes how objects are arranged in a coordinate system rather than how they are rendered.
 */
final case class DiagramObjectGluePoint
(
    Element: BasicElement = null,
    DiagramObjectPoints: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[DiagramObjectGluePoint]
{
    override val fields: Array[String] = Array[String] (
        "DiagramObjectPoints"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("DiagramObjectPoints", "DiagramObjectPoint", "2..*", "0..1")
    )
    val DiagramObjectPoints: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): DiagramObjectGluePoint =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DiagramObjectGluePoint (
            BasicElement.parse (context),
            masks (DiagramObjectPoints (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DiagramObjectGluePoint] = DiagramObjectGluePointSerializer
}

object DiagramObjectGluePointSerializer extends CIMSerializer[DiagramObjectGluePoint]
{
    def write (kryo: Kryo, output: Output, obj: DiagramObjectGluePoint): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.DiagramObjectPoints, output)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DiagramObjectGluePoint]): DiagramObjectGluePoint =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = DiagramObjectGluePoint (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A point in a given space defined by 3 coordinates and associated to a diagram object.
 *
 * The coordinates may be positive or negative as the origin does not have to be in the corner of a diagram.
 *
 * @param Element Reference to the superclass object.
 * @param sequenceNumber The sequence position of the point, used for defining the order of points for diagram objects acting as a polyline or polygon with more than one point.
 *        The attribute shall be a positive value.
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
    Element: BasicElement = null,
    sequenceNumber: Int = 0,
    xPosition: Double = 0.0,
    yPosition: Double = 0.0,
    zPosition: Double = 0.0,
    DiagramObject: String = null,
    DiagramObjectGluePoint: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: Element = Element

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[DiagramObjectPoint]
{
    override val fields: Array[String] = Array[String] (
        "sequenceNumber",
        "xPosition",
        "yPosition",
        "zPosition",
        "DiagramObject",
        "DiagramObjectGluePoint"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("DiagramObject", "DiagramObject", "1", "0..*"),
        CIMRelationship ("DiagramObjectGluePoint", "DiagramObjectGluePoint", "0..1", "2..*")
    )
    val sequenceNumber: Fielder = parse_element (element (cls, fields(0)))
    val xPosition: Fielder = parse_element (element (cls, fields(1)))
    val yPosition: Fielder = parse_element (element (cls, fields(2)))
    val zPosition: Fielder = parse_element (element (cls, fields(3)))
    val DiagramObject: Fielder = parse_attribute (attribute (cls, fields(4)))
    val DiagramObjectGluePoint: Fielder = parse_attribute (attribute (cls, fields(5)))

    def parse (context: CIMContext): DiagramObjectPoint =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
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

    def serializer: Serializer[DiagramObjectPoint] = DiagramObjectPointSerializer
}

object DiagramObjectPointSerializer extends CIMSerializer[DiagramObjectPoint]
{
    def write (kryo: Kryo, output: Output, obj: DiagramObjectPoint): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeInt (obj.sequenceNumber),
            () => output.writeDouble (obj.xPosition),
            () => output.writeDouble (obj.yPosition),
            () => output.writeDouble (obj.zPosition),
            () => output.writeString (obj.DiagramObject),
            () => output.writeString (obj.DiagramObjectGluePoint)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DiagramObjectPoint]): DiagramObjectPoint =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = DiagramObjectPoint (
            parent,
            if (isSet (0)) input.readInt else 0,
            if (isSet (1)) input.readDouble else 0.0,
            if (isSet (2)) input.readDouble else 0.0,
            if (isSet (3)) input.readDouble else 0.0,
            if (isSet (4)) input.readString else null,
            if (isSet (5)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A reference to a style used by the originating system for a diagram object.
 *
 * A diagram object style describes information such as line thickness, shape such as circle or rectangle etc, and colour.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param StyledObjects [[ch.ninecode.model.DiagramObject DiagramObject]] A style can be assigned to multiple diagram objects.
 * @group DiagramLayout
 * @groupname DiagramLayout Package DiagramLayout
 * @groupdesc DiagramLayout This package describes diagram layout. This describes how objects are arranged in a coordinate system rather than how they are rendered.
 */
final case class DiagramObjectStyle
(
    IdentifiedObject: IdentifiedObject = null,
    StyledObjects: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[DiagramObjectStyle]
{
    override val fields: Array[String] = Array[String] (
        "StyledObjects"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("StyledObjects", "DiagramObject", "0..*", "0..1")
    )
    val StyledObjects: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): DiagramObjectStyle =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DiagramObjectStyle (
            IdentifiedObject.parse (context),
            masks (StyledObjects (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DiagramObjectStyle] = DiagramObjectStyleSerializer
}

object DiagramObjectStyleSerializer extends CIMSerializer[DiagramObjectStyle]
{
    def write (kryo: Kryo, output: Output, obj: DiagramObjectStyle): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.StyledObjects, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DiagramObjectStyle]): DiagramObjectStyle =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = DiagramObjectStyle (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * The diagram style refers to a style used by the originating system for a diagram.
 *
 * A diagram style describes information such as schematic, geographic, etc.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param Diagram [[ch.ninecode.model.Diagram Diagram]] A DiagramStyle can be used by many Diagrams.
 * @group DiagramLayout
 * @groupname DiagramLayout Package DiagramLayout
 * @groupdesc DiagramLayout This package describes diagram layout. This describes how objects are arranged in a coordinate system rather than how they are rendered.
 */
final case class DiagramStyle
(
    IdentifiedObject: IdentifiedObject = null,
    Diagram: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[DiagramStyle]
{
    override val fields: Array[String] = Array[String] (
        "Diagram"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("Diagram", "Diagram", "0..*", "0..1")
    )
    val Diagram: FielderMultiple = parse_attributes (attribute (cls, fields(0)))

    def parse (context: CIMContext): DiagramStyle =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = DiagramStyle (
            IdentifiedObject.parse (context),
            masks (Diagram (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[DiagramStyle] = DiagramStyleSerializer
}

object DiagramStyleSerializer extends CIMSerializer[DiagramStyle]
{
    def write (kryo: Kryo, output: Output, obj: DiagramStyle): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => writeList (obj.Diagram, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[DiagramStyle]): DiagramStyle =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = DiagramStyle (
            parent,
            if (isSet (0)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * A diagram object for placing free-text or text derived from an associated domain object.
 *
 * @param DiagramObject [[ch.ninecode.model.DiagramObject DiagramObject]] Reference to the superclass object.
 * @param text The text that is displayed by this text diagram object.
 * @group DiagramLayout
 * @groupname DiagramLayout Package DiagramLayout
 * @groupdesc DiagramLayout This package describes diagram layout. This describes how objects are arranged in a coordinate system rather than how they are rendered.
 */
final case class TextDiagramObject
(
    DiagramObject: DiagramObject = null,
    text: String = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: DiagramObject = DiagramObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[TextDiagramObject]
{
    override val fields: Array[String] = Array[String] (
        "text"
    )
    val text: Fielder = parse_element (element (cls, fields(0)))

    def parse (context: CIMContext): TextDiagramObject =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = TextDiagramObject (
            DiagramObject.parse (context),
            mask (text (), 0)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[TextDiagramObject] = TextDiagramObjectSerializer
}

object TextDiagramObjectSerializer extends CIMSerializer[TextDiagramObject]
{
    def write (kryo: Kryo, output: Output, obj: TextDiagramObject): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.text)
        )
        DiagramObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[TextDiagramObject]): TextDiagramObject =
    {
        val parent = DiagramObjectSerializer.read (kryo, input, classOf[DiagramObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = TextDiagramObject (
            parent,
            if (isSet (0)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

/**
 * Layers are typically used for grouping diagram objects according to themes and scales.
 *
 * Themes are used to display or hide certain information (e.g., lakes, borders), while scales are used for hiding or displaying information depending on the current zoom level (hide text when it is too small to be read, or when it exceeds the screen size). This is also called de-cluttering.
 * CIM based graphics exchange supports an m:n relationship between diagram objects and layers. The importing system shall convert an m:n case into an appropriate 1:n representation if the importing system does not support m:n.
 *
 * @param IdentifiedObject [[ch.ninecode.model.IdentifiedObject IdentifiedObject]] Reference to the superclass object.
 * @param drawingOrder The drawing order for this layer.
 *        The higher the number, the later the layer and the objects within it are rendered.
 * @param VisibleObjects [[ch.ninecode.model.DiagramObject DiagramObject]] A visibility layer can contain one or more diagram objects.
 * @group DiagramLayout
 * @groupname DiagramLayout Package DiagramLayout
 * @groupdesc DiagramLayout This package describes diagram layout. This describes how objects are arranged in a coordinate system rather than how they are rendered.
 */
final case class VisibilityLayer
(
    IdentifiedObject: IdentifiedObject = null,
    drawingOrder: Int = 0,
    VisibleObjects: List[String] = null
)
extends
    Element
{
    /**
     * Return the superclass object.
     *
     * @return The typed superclass nested object.
     * @group Hierarchy
     * @groupname Hierarchy Class Hierarchy Related
     * @groupdesc Hierarchy Members related to the nested hierarchy of CIM classes.
     */
    override def sup: IdentifiedObject = IdentifiedObject

    //
    // Row overrides
    //

    /**
     * Return a copy of this object as a Row.
     *
     * Creates a clone of this object for use in Row manipulations.
     *
     * @return The copy of the object.
     * @group Row
     * @groupname Row SQL Row Implementation
     * @groupdesc Row Members related to implementing the SQL Row interface
     */
    override def copy (): Row = { clone ().asInstanceOf[Row] }

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
    CIMParseable[VisibilityLayer]
{
    override val fields: Array[String] = Array[String] (
        "drawingOrder",
        "VisibleObjects"
    )
    override val relations: List[CIMRelationship] = List (
        CIMRelationship ("VisibleObjects", "DiagramObject", "0..*", "0..*")
    )
    val drawingOrder: Fielder = parse_element (element (cls, fields(0)))
    val VisibleObjects: FielderMultiple = parse_attributes (attribute (cls, fields(1)))

    def parse (context: CIMContext): VisibilityLayer =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = VisibilityLayer (
            IdentifiedObject.parse (context),
            toInteger (mask (drawingOrder (), 0)),
            masks (VisibleObjects (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[VisibilityLayer] = VisibilityLayerSerializer
}

object VisibilityLayerSerializer extends CIMSerializer[VisibilityLayer]
{
    def write (kryo: Kryo, output: Output, obj: VisibilityLayer): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeInt (obj.drawingOrder),
            () => writeList (obj.VisibleObjects, output)
        )
        IdentifiedObjectSerializer.write (kryo, output, obj.sup)
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[VisibilityLayer]): VisibilityLayer =
    {
        val parent = IdentifiedObjectSerializer.read (kryo, input, classOf[IdentifiedObject])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = VisibilityLayer (
            parent,
            if (isSet (0)) input.readInt else 0,
            if (isSet (1)) readList (input) else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _DiagramLayout
{
    def register: List[CIMClassInfo] =
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
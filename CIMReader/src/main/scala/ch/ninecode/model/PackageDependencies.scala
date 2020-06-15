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
 * The version of dependencies description among top level subpackages of the combined CIM model.
 *
 * This is not the same as the combined packages version.
 *
 * @param Element Reference to the superclass object.
 * @param date Date of last change to the main package dependencies in format YYYY-MM-DD.
 *        This is updated when the version attribute is updated.
 * @param version The version of the main subpackages of the combined CIM model.
 *        The format is simply an integer.  The version (and date) initial values should be updated any time the dependencies in the model change and require an actual change to the diagrams within this package.
 * @group PackageDependencies
 * @groupname PackageDependencies Package PackageDependencies
 * @groupdesc PackageDependencies This package shows all the root level subpackage dependencies of the combined CIM model.
 */
final case class PackageDependenciesCIMVersion
(
    Element: BasicElement = null,
    date: String = null,
    version: String = null
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
        implicit val clz: String = PackageDependenciesCIMVersion.cls
        def emitelem (position: Int, value: Any): Unit = if (mask (position)) emit_element (PackageDependenciesCIMVersion.fields (position), value)
        emitelem (0, date)
        emitelem (1, version)
        s.toString
    }
    override def export: String =
    {
        "\t<cim:PackageDependenciesCIMVersion rdf:ID=\"%s\">\n%s\t</cim:PackageDependenciesCIMVersion>".format (id, export_fields)
    }
}

object PackageDependenciesCIMVersion
extends
    CIMParseable[PackageDependenciesCIMVersion]
{
    override val fields: Array[String] = Array[String] (
        "date",
        "version"
    )
    val date: Fielder = parse_element (element (cls, fields(0)))
    val version: Fielder = parse_element (element (cls, fields(1)))

    def parse (context: CIMContext): PackageDependenciesCIMVersion =
    {
        implicit val ctx: CIMContext = context
        implicit val bitfields: Array[Int] = Array(0)
        val ret = PackageDependenciesCIMVersion (
            BasicElement.parse (context),
            mask (date (), 0),
            mask (version (), 1)
        )
        ret.bitfields = bitfields
        ret
    }

    def serializer: Serializer[PackageDependenciesCIMVersion] = PackageDependenciesCIMVersionSerializer
}

object PackageDependenciesCIMVersionSerializer extends CIMSerializer[PackageDependenciesCIMVersion]
{
    def write (kryo: Kryo, output: Output, obj: PackageDependenciesCIMVersion): Unit =
    {
        val toSerialize: Array[() => Unit] = Array (
            () => output.writeString (obj.date),
            () => output.writeString (obj.version)
        )
        BasicElementSerializer.write (kryo, output, obj.sup.asInstanceOf[BasicElement])
        implicit val bitfields: Array[Int] = obj.bitfields
        writeBitfields (output)
        writeFields (toSerialize)
    }

    def read (kryo: Kryo, input: Input, cls: Class[PackageDependenciesCIMVersion]): PackageDependenciesCIMVersion =
    {
        val parent = BasicElementSerializer.read (kryo, input, classOf[BasicElement])
        implicit val bitfields: Array[Int] = readBitfields (input)
        val obj = PackageDependenciesCIMVersion (
            parent,
            if (isSet (0)) input.readString else null,
            if (isSet (1)) input.readString else null
        )
        obj.bitfields = bitfields
        obj
    }
}

private[ninecode] object _PackageDependencies
{
    def register: List[CIMClassInfo] =
    {
        List (
            PackageDependenciesCIMVersion.register
        )
    }
}
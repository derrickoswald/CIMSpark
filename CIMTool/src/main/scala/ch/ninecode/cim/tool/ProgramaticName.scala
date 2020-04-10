package ch.ninecode.cim.tool

trait ProgramaticName
{
    def name: String

    def prefix (s: String): String = if (s.charAt (0).isDigit) "_" else ""

    def substitute (s: String): String = s.replace (" ", "_").replace ("-", "_").replace ("/", "_").replace (".", "_").replace (",", "_")

    lazy val valid_class_name: String =
    {
        val identifier = s"${prefix (name)}${substitute (name)}"
        name match
        {
            // ToDo: all keywords
            case "type" => "`type`"
            case "val" => "`val`"
            case "class" => "`class`"
            case "%" => "percent"
            case "length" => "len"
            case "size" => "size1"
            case "lock" => "lock1"
            case "switch" => "`switch`"
            case "char" => "`char`"
            case "default" => "`default`"
            case "native" => "`native`"
            case "Boolean" => "`Boolean`"
            case "String" => "`String`"
            case "Unit" => "Unit_"
            case "" => "unknown" // ToDo: WTF?
            case _ =>
                if (identifier.endsWith ("_")) s"${identifier}1" else identifier
        }
    }

    lazy val valid_attribute_name: String =
    {
        val identifier = s"${prefix (name)}${substitute (name)}"
        name match
        {
            // ToDo: all keywords
            case "type" => "`type`"
            case "val" => "`val`"
            case "class" => "`class`"
            case "%" => "percent"
            case "length" => "len"
            case "size" => "size1"
            case "lock" => "lock1"
            case "switch" => "`switch`"
            case "char" => "`char`"
            case "default" => "`default`"
            case "native" => "`native`"
            case "" => "unknown" // ToDo: WTF?
            case _ =>
                if (identifier.endsWith ("_")) s"${identifier}1" else identifier
        }
    }
}

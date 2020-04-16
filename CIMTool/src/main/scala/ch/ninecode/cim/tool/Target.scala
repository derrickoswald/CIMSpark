package ch.ninecode.cim.tool
{
    import scopt.Read

    import org.slf4j.LoggerFactory

    /**
     * Base class for target languages.
     *
     * @param name the name of the target language as specified on the command line
     */
    sealed abstract class Target (val name: String)
    {
        def generator (parser: ModelParser, options: CIMToolOptions): CodeGenerator
    }

    /**
     * Target the Scala language.
     */
    case object ScalaLanguage       extends Target ("Scala")
    {
        def generator (parser: ModelParser, options: CIMToolOptions): CodeGenerator = Scala (parser, options)
    }

    /**
     * Target the JavaScript language.
     */
    case object JavaScriptLanguage  extends Target ("JavaScript")
    {
        def generator (parser: ModelParser, options: CIMToolOptions): CodeGenerator = JavaScript (parser, options)
    }

    /**
     * Reader for --target option.
     */
    class TargetReader extends Read[Target]
    {
        val generators: List[Target] = List[Target] (ScalaLanguage, JavaScriptLanguage)
        def arity: Int = 1
        def reads: String => Target = (s: String) => generators.find (_.name == s).getOrElse (
            {
                val fallback = ScalaLanguage
                val log = LoggerFactory.getLogger (getClass)
                log.error (s"""unrecognized target "$s", using ${fallback.name} as a fallback""")
                fallback
            }
        )
        def languages: List[String] = generators.map (_.name)
    }
}
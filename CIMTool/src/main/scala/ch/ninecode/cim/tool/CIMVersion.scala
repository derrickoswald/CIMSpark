package ch.ninecode.cim.tool
{
    import scopt.Read

    import org.slf4j.Logger
    import org.slf4j.LoggerFactory

    sealed abstract class CIMVersion (
        val name: String,
        val file: String
    )

    case object cim14  extends CIMVersion ("CIM14",  "iec61970cim14v15_iec61968cim10v31_combined.eap" )
    case object cim15  extends CIMVersion ("CIM15",  "iec61970cim15v33_iec61968cim11v13_iec62325cim01v07.eap" )
    case object cim16  extends CIMVersion ("CIM16",  "iec61970cim16v29a_iec61968cim12v08_iec62325cim03v01a.eap" )
    case object ENTSOE extends CIMVersion ("ENTSOE", "ENTSOE_CGMES_v2.4.15_7Aug2014.eap" )
    case object cim100 extends CIMVersion ("CIM100", "iec61970cim17v34_iec61968cim13v12_iec62325cim03v17a.eap" )

    class CIMVersionReader extends Read[CIMVersion]
    {
        val CIMVersions: List[CIMVersion] = List (cim14, cim15, cim16, ENTSOE, cim100)
        def arity = 1
        def reads: String => CIMVersion = (s: String) => CIMVersions.find (_.name == s).getOrElse (
            {
                val fallback = cim100
                val log: Logger = LoggerFactory.getLogger (getClass)
                log.error ("""unrecognized CIM version "%s", using %s as a fallback""".format (s, fallback.name))
                fallback
            }
        )
        def versions: List[String] = CIMVersions.map (_.name)
    }
}
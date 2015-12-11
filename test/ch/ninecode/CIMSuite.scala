package ch.ninecode

import org.scalatest.FunSuite


import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

class CIMSuite extends FunSuite
{
    test ("Basic")
    {
        val xml = "yadda yadda <cim:PSRType rdf:ID=\"PSRType_Substation\">\n<cim:IdentifiedObject.name>Substation</cim:IdentifiedObject.name>\n</cim:PSRType> foo bar"
        val parser = new CIM ()
        val result = parser.parse (xml)
        println (result.PowerSystemResources)
        assert (result.PowerSystemResources.size === 1)
    }
}

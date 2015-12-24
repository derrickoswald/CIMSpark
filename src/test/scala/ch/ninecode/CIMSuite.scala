package ch.ninecode

import scala.xml._

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

class CIMSuite extends FunSuite
{
  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/2.2.4/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */
    test ("Basic")
    {
        val xml = "yadda yadda <cim:PSRType rdf:ID=\"PSRType_Substation\">\n<cim:IdentifiedObject.name>Substation</cim:IdentifiedObject.name>\n</cim:PSRType> foo bar"
        val parser = new CIM ()
        val result = parser.parse (xml)
        assert (result.PowerSystemResources.size === 1)
    }

    test ("Forward Reference")
    {
        // Note: scala really hates processing instructions:
        // <?xml version="1.0" encoding="UTF-8" standalone="no"?>
        val xml =
            <rdf:RDF xmlns:dm="http://iec.ch/2002/schema/CIM_difference_model#" xmlns:cim="http://iec.ch/TC57/2010/CIM-schema-cim15#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
                <cim:ConnectivityNode rdf:ID="_pin_1555190">
                    <cim:IdentifiedObject.name>PIN16</cim:IdentifiedObject.name>
                    <cim:ConnectivityNode.ConnectivityNodeContainer rdf:resource="_subnetwork_183839"/>
                </cim:ConnectivityNode>
                <cim:Line rdf:ID="_subnetwork_183839">
                    <cim:IdentifiedObject.name>ABG2682|FLT22|FLU74|FLU75|HAS997|PIN16</cim:IdentifiedObject.name>
                </cim:Line>
            </rdf:RDF>;
        val parser = new CIM ()
        val result = parser.parse (xml.toString ())
        assert (result.Containers.size === 1)
        val container = result.Containers apply "_subnetwork_183839"
        assert (container.contents.size === 1)
        assert (container.contents.contains ("_pin_1555190"))
    }


    test ("Voltage")
    {
        val xml =
            <rdf:RDF xmlns:dm="http://iec.ch/2002/schema/CIM_difference_model#" xmlns:cim="http://iec.ch/TC57/2010/CIM-schema-cim15#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
                <cim:BaseVoltage rdf:ID="BaseVoltage_0.400000000000">
                        <cim:IdentifiedObject.name>400.000 V</cim:IdentifiedObject.name>
                        <cim:BaseVoltage.nominalVoltage>0.400000000000</cim:BaseVoltage.nominalVoltage>
                </cim:BaseVoltage>
            </rdf:RDF>;
        val parser = new CIM ()
        val result = parser.parse (xml.toString ())
        assert (result.Voltages.size === 1)
        val voltage = result.Voltages apply "BaseVoltage_0.400000000000"
        assert (voltage.voltage === 400)
    }

    test ("Illegal Voltage")
    {
        val xml =
            <rdf:RDF xmlns:dm="http://iec.ch/2002/schema/CIM_difference_model#" xmlns:cim="http://iec.ch/TC57/2010/CIM-schema-cim15#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
                <cim:BaseVoltage rdf:ID="BaseVoltage_0.400000000000">
                        <cim:IdentifiedObject.name>400.000 V</cim:IdentifiedObject.name>
                        <cim:BaseVoltage.nominalVoltage>x.400000000000</cim:BaseVoltage.nominalVoltage>
                </cim:BaseVoltage>
            </rdf:RDF>;
        val parser = new CIM ()
        intercept[Exception]
        {
            val result = parser.parse (xml.toString ())
            fail ("invalid voltage accepted")
        }
    }

    test ("Coordinate System")
    {
        val xml =
            <rdf:RDF xmlns:dm="http://iec.ch/2002/schema/CIM_difference_model#" xmlns:cim="http://iec.ch/TC57/2010/CIM-schema-cim15#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
                <cim:CoordinateSystem rdf:ID="wgs_84">
                    <cim:IdentifiedObject.name>WGS 84</cim:IdentifiedObject.name>
                    <cim:crsUrn>EPSG::4326</cim:crsUrn>
                </cim:CoordinateSystem>
            </rdf:RDF>;
        val parser = new CIM ()
        val result = parser.parse (xml.toString ())
        assert (result.PowerSystemResources.size === 1)
        val cs = result.PowerSystemResources apply "wgs_84"
        assert (cs.isInstanceOf[CoordinateSystem])
        val cs2 = cs.asInstanceOf[CoordinateSystem]
        assert (cs2.urn === "EPSG::4326")
    }

}

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
        val parser = new CIM (xml.toString ())
        val map = parser.parse ()
        assert (map.size === 1)
    }

    test ("Voltage")
    {
        // Note: scala really hates processing instructions:
        // <?xml version="1.0" encoding="UTF-8" standalone="no"?>
        val xml =
            <rdf:RDF xmlns:dm="http://iec.ch/2002/schema/CIM_difference_model#" xmlns:cim="http://iec.ch/TC57/2010/CIM-schema-cim15#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
                <cim:BaseVoltage rdf:ID="BaseVoltage_0.400000000000">
                        <cim:IdentifiedObject.name>400.000 V</cim:IdentifiedObject.name>
                        <cim:BaseVoltage.nominalVoltage>0.400000000000</cim:BaseVoltage.nominalVoltage>
                </cim:BaseVoltage>
            </rdf:RDF>;
        val parser = new CIM (xml.toString ())
        val map = parser.parse ()
        val voltage = map.apply ("BaseVoltage_0.400000000000").asInstanceOf[Voltage]
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
        val parser = new CIM (xml.toString ())
        intercept[Exception]
        {
            val map = parser.parse ()
            fail ("invalid voltage accepted")
        }
    }

    test ("Coordinate System")
    {
        val xml =
            <rdf:RDF xmlns:dm="http://iec.ch/2002/schema/CIM_difference_model#" xmlns:cim="http://iec.ch/TC57/2010/CIM-schema-cim15#" xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
                <cim:CoordinateSystem rdf:ID="wgs_84">
                    <cim:IdentifiedObject.name>WGS 84</cim:IdentifiedObject.name>
                    <cim:CoordinateSystem.crsUrn>EPSG::4326</cim:CoordinateSystem.crsUrn>
                </cim:CoordinateSystem>
            </rdf:RDF>;
        val parser = new CIM (xml.toString ())
        val map = parser.parse ()
        assert (map.size === 1)
        val cs = map apply "wgs_84"
        assert (cs.isInstanceOf[CoordinateSystem])
        val cs2 = cs.asInstanceOf[CoordinateSystem]
        assert (cs2.urn === "EPSG::4326")
    }

    test ("Read Partial")
    {
        val xml = CIM.read ("data/dump_ews.xml", 33554432, 1024 * 1024, 0) // exactly a megabyte
        val parser = new CIM (xml)
        val map = parser.parse ()
        assert (map.size != 0) // 2735
        assert (map.filter (_.getClass() == classOf[Unknown]).size == 0)
    }
}

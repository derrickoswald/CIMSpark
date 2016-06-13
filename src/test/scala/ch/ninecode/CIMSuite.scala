package ch.ninecode

import scala.xml._

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

import ch.ninecode.model._

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
        val parser = new CHIM (xml.toString ())
        val map = parser.parse ()
        assert (map.size === 1)
    }

    def subclass (x: Element, parser: Parseable[Element with Product]): Element =
    {
        var ret = x

        while ((null != ret) && (ret.getClass () != parser.runtime_class))
            ret = ret.sup

        return (ret)
    }

    test ("Classes")
    {
        val xml = "yadda yadda <cim:PSRType rdf:ID=\"PSRType_Substation\">\n<cim:IdentifiedObject.name>Substation</cim:IdentifiedObject.name>\n</cim:PSRType> foo bar"
        val parser = new CHIM (xml.toString ())
        val map = parser.parse ()
        val element = map.getOrElse ("PSRType_Substation", null)
        assert (element != null)
        CHIM.apply_to_all_classes (
            (name: String, parser: Parseable[Element with Product]) =>
            {
                val cls = subclass (element, parser)
                if (null != cls)
                {
                    markup ("class " + cls.toString ())
                    markup (parser.runtime_class.toString () + " boolean " + (element.getClass () == parser.runtime_class))
                }
            }
        )
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
        val parser = new CHIM (xml.toString ())
        val map = parser.parse ()
        val voltage = map.apply ("BaseVoltage_0.400000000000").asInstanceOf[BaseVoltage]
        assert (voltage.nominalVoltage.toDouble === 0.40)
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
        val parser = new CHIM (xml.toString ())
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
        val parser = new CHIM (xml.toString ())
        val map = parser.parse ()
        assert (map.size === 1)
        val cs = map apply "wgs_84"
        assert (cs.isInstanceOf[CoordinateSystem])
        val cs2 = cs.asInstanceOf[CoordinateSystem]
        assert (cs2.crsUrn === "EPSG::4326")
    }
}

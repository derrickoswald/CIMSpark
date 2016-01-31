package ch.ninecode

import scala.util.Random
import scala.xml.XML

import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.PrintWriter

object FakeCIM
{
    def main (args: Array[String])
    {
        val filename = args(0)
        val offset = 0
        val fis = new FileInputStream (filename)
        var size = fis.available () - offset
        fis.close ();
        println ("file size: %d bytes".format (size))
        val xml = CIM.read (filename, offset, size)
        val fos = new FileOutputStream (filename + ".fake")
        val pw = new PrintWriter (fos)
        pw.println ("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>")
        pw.println ("<rdf:RDF xmlns:dm=\"http://iec.ch/2002/schema/CIM_difference_model#\" xmlns:cim=\"http://iec.ch/TC57/2010/CIM-schema-cim15#\" xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\">");

        val parser = new CIM (xml)
        val map = parser.parse ()
        val pf: PartialFunction[(String, Element), (String, Consumer)] =
        {
            case x: (String, Any) if x._2.getClass () == classOf[Consumer] => (x._1, x._2.asInstanceOf[Consumer])
        }
        val consumers = map collect pf
        var rand = new Random ()
        consumers map
        {
            case (_id, Consumer (properties, id, name, location, container, typ, voltage, phase)) =>
                val number = rand.nextInt (Int.MaxValue)
                val ao = "_ao_" + { number }
                val service =
    <cim:ServiceLocation rdf:ID={ao}>
        <cim:IdentifiedObject.name>{ name }</cim:IdentifiedObject.name>
        <cim:ServiceLocation.device>{ _id }</cim:ServiceLocation.device>
    </cim:ServiceLocation>;
                pw.println ("    " + service.toString ())
                val count = rand.nextInt (4) + 1 // one to four customers per HAK
                for (i <- 1 to count)
                {
                    val id = "_customer_" + rand.nextInt (Int.MaxValue)
                    val nam = name + "_" + i
                    val lang = if (rand.nextBoolean ()) "de_CH" else if (rand.nextBoolean ()) "fr_CH" else "it_CH"
                    val customer =
    <cim:Customer rdf:ID={id}>
        <cim:IdentifiedObject.name>{ nam }</cim:IdentifiedObject.name>
        <cim:Customer.kind rdf:resource="http://iec.ch/TC57/2010/CIM-schema-cim15#CustomerKind.residential"/>
        <cim:Customer.locale>{ lang }</cim:Customer.locale>
        <cim:Customer.service>{ ao }</cim:Customer.service>
    </cim:Customer>;
                    pw.println ("    " + customer.toString ())
                }
        }
        pw.println ("</rdf:RDF>")
        pw.flush ()
        pw.close ()
    }
}

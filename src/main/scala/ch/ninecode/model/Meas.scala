package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.Context

/*
 * Package: Meas
 */

case class MeasurementValue
(
    override val sup: IdentifiedObject,
    val sensorAccuracy: Double,
    val timeStamp: String,
    val ErpPerson: String,
    val measurementValueSource: String,
    val RemoteSource: String
)
extends
    Element
{
    def this () = { this (null, 0.0, null, null, null, null) }
    def IdentifiedObject: IdentifiedObject = sup.asInstanceOf[IdentifiedObject]
    override def copy (): Row = { return (clone ().asInstanceOf[MeasurementValue]); }
    override def get (i: Int): Any =
    {
        if (i < productArity)
            productElement (i)
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object MeasurementValue
extends
    Parseable[MeasurementValue]
{
    val sensorAccuracy = parse_element (element ("""MeasurementValue.sensorAccuracy"""))_
    val timeStamp = parse_element (element ("""MeasurementValue.timeStamp"""))_
    val ErpPerson = parse_attribute (attribute ("""MeasurementValue.ErpPerson"""))_
    val measurementValueSource = parse_attribute (attribute ("""MeasurementValue.measurementValueSource"""))_
    val RemoteSource = parse_attribute (attribute ("""MeasurementValue.RemoteSource"""))_
    def parse (context: Context): MeasurementValue =
    {
        return (
            MeasurementValue
            (
                IdentifiedObject.parse (context),
                toDouble (sensorAccuracy (context), context),
                timeStamp (context),
                ErpPerson (context),
                measurementValueSource (context),
                RemoteSource (context)
            )
        )
    }
}

object Meas
{
    def register: Unit =
    {
        MeasurementValue.register
    }
}

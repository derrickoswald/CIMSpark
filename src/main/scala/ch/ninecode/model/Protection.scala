package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/*
 * Package: Protection
 */

case class CurrentRelay
(
    override val sup: ProtectionEquipment,
    val currentLimit1: Double,
    val currentLimit2: Double,
    val currentLimit3: Double,
    val inverseTimeFlag: Boolean,
    val timeDelay1: Double,
    val timeDelay2: Double,
    val timeDelay3: Double
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, 0.0, false, 0.0, 0.0, 0.0) }
    def ProtectionEquipment: ProtectionEquipment = sup.asInstanceOf[ProtectionEquipment]
    override def copy (): Row = { return (clone ().asInstanceOf[CurrentRelay]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object CurrentRelay
extends
    Parseable[CurrentRelay]
{
    val currentLimit1 = parse_element (element ("""CurrentRelay.currentLimit1"""))
    val currentLimit2 = parse_element (element ("""CurrentRelay.currentLimit2"""))
    val currentLimit3 = parse_element (element ("""CurrentRelay.currentLimit3"""))
    val inverseTimeFlag = parse_element (element ("""CurrentRelay.inverseTimeFlag"""))
    val timeDelay1 = parse_element (element ("""CurrentRelay.timeDelay1"""))
    val timeDelay2 = parse_element (element ("""CurrentRelay.timeDelay2"""))
    val timeDelay3 = parse_element (element ("""CurrentRelay.timeDelay2"""))
    def parse (context: Context): CurrentRelay =
    {
        return (
            CurrentRelay
            (
                ProtectionEquipment.parse (context),
                toDouble (currentLimit1 (context), context),
                toDouble (currentLimit2 (context), context),
                toDouble (currentLimit3 (context), context),
                toBoolean (inverseTimeFlag (context), context),
                toDouble (timeDelay1 (context), context),
                toDouble (timeDelay2 (context), context),
                toDouble (timeDelay3 (context), context)
            )
        )
    }
}

case class ProtectionEquipment
(
    override val sup: Equipment,
    val highLimit: Double,
    val lowLimit: Double,
    val powerDirectionFlag: Boolean,
    val relayDelayTime: Double,
    val unitMultiplier: String,
    val unitSymbol: String
)
extends
    Element
{
    def this () = { this (null, 0.0, 0.0, false, 0.0, null, null) }
    def Equipment: Equipment = sup.asInstanceOf[Equipment]
    override def copy (): Row = { return (clone ().asInstanceOf[ProtectionEquipment]) }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object ProtectionEquipment
extends
    Parseable[ProtectionEquipment]
{
    val highLimit = parse_element (element ("""ProtectionEquipment.highLimit"""))
    val lowLimit = parse_element (element ("""ProtectionEquipment.lowLimit"""))
    val powerDirectionFlag = parse_element (element ("""ProtectionEquipment.powerDirectionFlag"""))
    val relayDelayTime = parse_element (element ("""ProtectionEquipment.relayDelayTime"""))
    val unitMultiplier = parse_element (element ("""ProtectionEquipment.unitMultiplier"""))
    val unitSymbol = parse_element (element ("""ProtectionEquipment.unitSymbol"""))
    def parse (context: Context): ProtectionEquipment =
    {
        return (
            ProtectionEquipment
            (
                Equipment.parse (context),
                toDouble (highLimit (context), context),
                toDouble (lowLimit (context), context),
                toBoolean (powerDirectionFlag (context), context),
                toDouble (relayDelayTime (context), context),
                unitMultiplier (context),
                unitSymbol (context)
            )
        )
    }
}

object _Protection
{
    def register: Unit =
    {
        CurrentRelay.register
        ProtectionEquipment.register
    }
}

package ch.ninecode.cim

import ch.ninecode.model.Asset
import ch.ninecode.model.BasicElement
import ch.ninecode.model.IdentifiedObject
import ch.ninecode.model.RegisteredGenerator

import org.scalatest.funsuite.AnyFunSuite

class CHIMSuite extends AnyFunSuite
{
    test("Basic")
    {
        val element = BasicElement(
            null,
            mRID = "HAS73464"
        )
        element.bitfields = BasicElement.fieldsToBitfields("mRID")
        assert(element.bitfields === Array(Integer.parseInt("1", 2)))
    }

    test("oneInt")
    {
        val obj = IdentifiedObject(
            null,
            aliasName = "myAlias",
            description = "a simple class",
            mRID = "_56f68023-8658-4735-b4d6-0fb71e93fce7",
            name = "myname"
        )
        obj.bitfields = IdentifiedObject.fieldsToBitfields("aliasName", "description", "mRID", "name")
        assert(obj.bitfields === Array(Integer.parseInt("1111", 2)))
    }

    test("twoInt")
    {

        val obj = Asset(
            null,
            Location = "myLocation"
        )
        obj.bitfields = Asset.fieldsToBitfields("Location")
        assert(obj.bitfields === Array(0, Integer.parseInt("10", 2)))
    }

    test("threeInt")
    {

        val obj = RegisteredGenerator(
            null,
            RegulatingLimit = "someLimit"
        )
        obj.bitfields = RegisteredGenerator.fieldsToBitfields("RegulatingLimit")
        assert(obj.bitfields === Array(0, 0, Integer.parseInt("10000", 2)))
    }
}
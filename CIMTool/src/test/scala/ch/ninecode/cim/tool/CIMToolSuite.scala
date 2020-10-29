package ch.ninecode.cim.tool

import org.scalatest.funsuite.AnyFunSuite

import ch.ninecode.cim.tool.CIMTool.main

class CIMToolSuite extends AnyFunSuite
{
    test("Help")
    {
        main(Array("--unittest", "--help"))
    }

    test("Version")
    {
        main(Array("--unittest", "--version"))
    }

    test("CIM100 Scala")
    {
        main(Array("--unittest", "--log", "INFO", "--cim", "CIM100", "--target", "Scala", "--directory", "cim100/scala"))
    }

    test("CIM100 JavaScript")
    {
        main(Array("--unittest", "--log", "INFO", "--cim", "CIM100", "--target", "JavaScript", "--directory", "cim100/javascript"))
    }
}

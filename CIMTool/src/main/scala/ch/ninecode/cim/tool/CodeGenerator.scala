package ch.ninecode.cim.tool

import java.io.File

/**
 * Interface for code generation.
 */
trait CodeGenerator
{
    /**
     * Make directories.
     *
     * @param directory the directory path to create
     */
    def mkdir (directory: String): Unit =
    {
        val dir = new File (directory)
        if (!dir.exists)
        {
            val _ = dir.mkdir
        }
    }

    /**
     * Generate code.
     */
    def generate (): Unit
}

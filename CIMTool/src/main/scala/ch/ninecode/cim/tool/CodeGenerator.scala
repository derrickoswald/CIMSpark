package ch.ninecode.cim.tool

import java.io.File
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths

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
        val dir = new File(directory)
        if (!dir.exists)
        {
            val _ = dir.mkdirs
        }
    }

    def save (filename: String, text: String): Unit =
    {
        val file = Paths.get(filename)
        mkdir(file.getParent.toString)
        val _ = Files.write(file, text.getBytes(StandardCharsets.UTF_8))
    }

    /**
     * Generate code.
     */
    def generate (): Unit
}

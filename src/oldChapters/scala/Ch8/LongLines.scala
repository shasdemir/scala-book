package Ch8
import scala.io.Source

object LongLines {

    def processFile(fileName: String, width: Int): Unit = {

        def processLine(line: String): Unit = {
            if (line.trim.length > width)
                println(fileName + ": " + line.trim)
        }

        val source = Source.fromFile(fileName)
        for (line <- source.getLines())
            processLine(line)
    }
}
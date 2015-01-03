package Ch9

object main {
    import java.io.{File, PrintWriter}

    def withPrintWriter(file: File)(op: PrintWriter => Unit): Unit = {
        val writer = new PrintWriter(file)
        try {
            op(writer)
        } finally {
            writer.close()
        }
    }


    val file = new File("date.txt")
    withPrintWriter(file) {
        writer => writer.println(new java.util.Date)
        // _.println(new java.util.Date)
    }
}

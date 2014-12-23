import ChecksumAccumulator.calculate

object Summer {
    def main(args: Array[String]): Unit = {
        for (arg <- args)
            println(arg + ": " + calculate(arg))
    }
}
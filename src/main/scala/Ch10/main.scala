package Ch10

object Main {
    def main(args: Array[String]): Unit = {
        val ae = new ArrayElement(Array("hello", "world"))
        println(ae.width)

        val e: Element = new ArrayElement(Array("hello"))
    }
}

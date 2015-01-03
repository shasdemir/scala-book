package Ch10

import Element.elem

abstract class Element {
    def contents: Array[String]

    def height: Int = contents.length

    def width: Int = if (height == 0) 0 else contents(0).length

    def above(that: Element): Element =
        elem(this.contents ++ that.contents)  // that has to be the same width of this

    def beside(that: Element): Element = {
        elem(
            for ((line1, line2) <- this.contents zip that.contents) yield line1 + line2
        )
    }

    override def toString = contents mkString "\n"
}


object Element {

    private class ArrayElement(val contents: Array[String]) extends Element {

        require {  // every string element must be the same size
            val lengthSet = Set(
                    for (line <- contents)
                    yield line.length
                )

            lengthSet.size == 1
        }

        require {
            val headLength = contents.head.length
            contents.toList.forall(_.length == headLength)
        }
    }

    class LineElement(s: String) extends Element {
        val contents = Array(s)
        override def height = 1
        override def width = s.length
    }

    class UniformElement(
            ch: Char,
            override val width: Int,
            override val height: Int
            ) extends Element {
        private val line = ch.toString * width
        def contents = Array.fill(height)(line)
    }

    def elem(contents: Array[String]): Element =
        new ArrayElement(contents)

    def elem(chr: Char, width: Int, height: Int): Element =
        new UniformElement(chr, width, height)

    def elem(line: String): Element =
        new LineElement(line)
}
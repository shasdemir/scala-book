package Ch10
import Element.elem


abstract class Element {
    def contents: Array[String]

    def height: Int = contents.length

    def width: Int = if (height == 0) 0 else contents(0).length

    def above(that: Element): Element = {
        val this1 = this widen that.width
        val that1 = that widen this.width
        elem(this1.contents ++ that1.contents) // that has to be the same width of this
    }

    def beside(that: Element): Element = {
        val this1 = this heighten that.height
        val that1 = that heighten this.height
        elem(
            for ((line1, line2) <- this1.contents zip that1.contents) yield line1 + line2
        )
    }

    def widen(w: Int): Element =
        if (w <= width)
            this
        else {
            val left = elem(' ', (w - width) / 2, height)
            val right = elem(' ', w - width - left.width, height)
            left beside this beside right
        } ensuring(w <= _.width)

    def heighten(h: Int): Element =
        if (h <= height)
            this
        else {
            val top = elem(' ', width, (h - height) / 2)
            val bot = elem(' ', width, h - height - top.height)
            top above this above bot
        }

    override def toString = contents mkString "\n"
}


object Element {

    private class ArrayElement(val contents: Array[String]) extends Element {

        require {
            val optionEqual = contents.headOption.map { head =>
                contents.forall(_.length == head.length)
            }
            optionEqual.getOrElse(false)
        }

        require {  // check the same thing
            contents.length == 0 || {
                val headLength = contents.head.length
                contents.forall(_.length == headLength)
            }
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

    def elem(chr: Char, width: Int, height: Int): Element = {
        require (width > 0 && height > 0)
        new UniformElement(chr, width, height)
    }

    def elem(line: String): Element =
        new LineElement(line)
}
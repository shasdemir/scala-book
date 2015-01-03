package Ch10

abstract class Element {
    def contents: Array[String]
    def height: Int = contents.length
    def width: Int = if (height == 0) 0 else contents(0).length
}


class ArrayElement(val contents: Array[String]) extends Element {

    require {  // every string element must be the same size
        val lengthSet = Set(
            for (line <- contents)
            yield line.length
        )

        lengthSet.size == 1
    }
}


class LineElement(s: String) extends ArrayElement(Array(s)) {
    override def height = 1
    override def width = s.length
}
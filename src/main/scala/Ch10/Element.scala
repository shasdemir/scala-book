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
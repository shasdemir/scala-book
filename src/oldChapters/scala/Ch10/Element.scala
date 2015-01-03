package Ch10

abstract class Element {
    def contents: Array[String]
    def height: Int = contents.length
    def width: Int = if (height == 0) 0 else contents(0).length
}


class ArrayElement(conts: Array[String]) extends Element {

    require {
        val lengthSet = Set(
        for (line <- conts)
            yield line.length
        )

        lengthSet.size == 1
    }

    def contents = conts
}
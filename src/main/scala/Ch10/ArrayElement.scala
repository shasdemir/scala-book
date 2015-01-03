package Ch10

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
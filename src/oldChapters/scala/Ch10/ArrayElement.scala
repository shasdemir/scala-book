package Ch10

import Ch10.Element

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
package Ch14

import Ch10.Element.elem
import org.scalatest.FunSuite

/**
 * Created by sukruhasdemir on 10/01/15.
 */
class ElementSuite extends FunSuite {

    test("elem result should have the same width as passed.") {  // name of the test
        val ele = elem('x', 2, 3)
        assertResult(2) {
            ele.width
        }
    }

//    intercept[IllegalArgumentException] {
//        elem('x', -2, 3)  // fails
//    }
}

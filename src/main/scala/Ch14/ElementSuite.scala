package Ch14

import org.scalatest.FunSuite
import Ch10.Element.elem

/**
 * Created by sukruhasdemir on 10/01/15.
 */
class ElementSuite extends FunSuite {

    test("elem result should have the same width as passed.") {  // name of the test
        val ele = elem('x', 2, 3)
        assertResult(3) {
            ele.width
        }
    }
}

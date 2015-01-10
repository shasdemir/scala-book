package Ch14

import Ch10.Element.elem
import org.scalatest.FunSuite
import org.scalatest.junit.JUnit3Suite

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

    intercept[IllegalArgumentException] {
        elem('x', -2, 3)  // fails
    }
}


//class ElementSuite2 extends JUnit3Suite {
//
//    def testUniformElement(): Unit = {
//        val ele = elem('x', 2, 3)
//        assert(ele.width === 2)
//        assertResult(3) {ele.height}
//        intercept[IllegalArgumentException] {
//            elem('x', -2, 3)
//        }
//    }
//}
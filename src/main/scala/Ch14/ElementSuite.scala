package Ch14

import org.scalatest.Suite
import Ch10.Element.elem

/**
 * Created by sukruhasdemir on 10/01/15.
 */
class ElementSuite extends Suite {
    def testUniformElement(): Unit = {
        val ele = elem('x', 2, 3)
        assert(ele.width == 2)
    }
}

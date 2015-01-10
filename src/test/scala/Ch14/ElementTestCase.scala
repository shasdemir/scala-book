package Ch14

import Ch10.Element.elem
import junit.framework.TestCase
import org.junit.Assert.{assertEquals, fail} //import junit.framework.Assert.fail

/**
 * Created by sukruhasdemir on 10/01/15.
 */
class ElementTestCase extends TestCase {

    def testUniformElement(): Unit = {
        val ele = elem('x', 2, 3)
        assertEquals(2, ele.width)
        assertEquals(3, ele.height)
        try {
            elem('x', -2, 3)
            fail()
        } catch {
            case e: IllegalArgumentException => // expected
        }
    }
}

package Ch12
import scala.collection.mutable.ArrayBuffer

/**
 * Created by sukruhasdemir on 08/01/15.
 */
abstract class IntQueue {
    def get(): Int
    def put(x: Int)
}


class BasicIntQueue extends IntQueue {
    private val buf = new ArrayBuffer[Int]
    def get() = buf.remove(0)
    def put(x: Int) { buf += x }
}
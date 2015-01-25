package Ch19

/**
 * Created by sukruhasdemir on 24/01/15.
 */
class SlowAppendQueue[T](elems: List[T]) {  // not efficient
    def head = elems.head
    def tail = new SlowAppendQueue(elems.tail)
    def enqueue(x: T) = new SlowAppendQueue(elems ::: List(x))
}


class SlowHeadQueue[T](smele: List[T]) {  // not efficient, smele is elems reversed
    def head = smele.last
    def tail = new SlowHeadQueue(smele.init)
    def enqueue(x: T) = new SlowHeadQueue(x :: smele)
}


class FunctionalQueue[+T](private val leading: List[T], private val trailing: List[T]) {
    private def mirror =
        if (leading.isEmpty)
            new FunctionalQueue(trailing.reverse, Nil)
        else
            this

    def head = mirror.leading.head

    def tail = {
        val q = mirror
        new FunctionalQueue(q.leading.tail, q.trailing)
    }

    def enqueue[U >: T](x: U) = new FunctionalQueue[U](leading, x :: trailing)

    //def this(elems: T*) = this(elems.toList, Nil)
}


object FunctionalQueue {
    // constructs a queue with initial elements 'xs'
    def apply[T](xs: T*) = new FunctionalQueue[T](xs.toList, Nil)
}
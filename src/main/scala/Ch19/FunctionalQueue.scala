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


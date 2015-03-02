package Ch22.Sscala

/**
 * Created by sukruhasdemir on 02/03/15.
 */
case object SNil extends SList[Nothing] {
    override def isEmpty = true

    def head: Nothing = throw new NoSuchElementException("head of an empty list")

    def tail: List[Nothing] = throw new NoSuchElementException("tail of an empty list")
}

package Ch22.Sscala

/**
 * Created by sukruhasdemir on 01/03/15.
 * This package contains an implementation of List class.
 */

abstract class List[+T] {
    def isEmpty: Boolean
    def head: T
    def tail: List[T]
}


case object Nil extends List[Nothing] {
    override def isEmpty = true

    def head: Nothing = throw new NoSuchElementException("head of an empty list")

    def tail: List[Nothing] = throw new NoSuchElementException("tail of an empty list")
}


final case class ::[T](head: T, tail: List[T]) extends List[T] {
    override def isEmpty: Boolean = false
}
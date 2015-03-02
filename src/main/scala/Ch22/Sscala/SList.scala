package Ch22.Sscala

/**
 * Created by sukruhasdemir on 01/03/15.
 * This package contains an implementation of List class, prepended by the letter S. (for example: SList, S::, etc.)
 */

abstract class SList[+T] {
    def isEmpty: Boolean
    def head: T
    def tail: SList[T]
}

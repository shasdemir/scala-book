package Ch22
package sscala

/**
 * Created by sukruhasdemir on 01/03/15.
 * This package contains an implementation of List class, prepended by the letter s. (for example: sList, s::, etc.)
 */

abstract class sList[+T] {
    def isEmpty: Boolean
    def head: T
    def tail: sList[T]
}

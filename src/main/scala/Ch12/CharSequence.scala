package Ch12

/**
 * Created by sukruhasdemir on 07/01/15.
 */
trait CharSequence {
    def charAt(index: Int): Char
    def length: Int
    def subSequence(start: Int, end: Int): CharSequence
    def toString: String
}
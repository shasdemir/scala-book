package Ch20

/**
 * Created by sukruhasdemir on 28/01/15.
 */
trait RationalTrait {
    val numerArg: Int
    val denomArg: Int

    require(denomArg != 0)

    private val g = gcd(numerArg, denomArg)

    val numer = numerArg / g
    val denom = denomArg / g

    private def gcd(a: Int, b: Int): Int =
        if (b == 0) a else gcd(b, a % b)

    override def toString = numer + "/" + denom
}


object TwoThirds extends {
    val numerArg = 2
    val denomArg = 3
} with RationalTrait
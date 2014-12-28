/**
 * Created by sukruhasdemir on 28/12/14.
 */
class Rational(n: Int, d: Int) {
    require (d != 0)
    val numer = n
    val denom = d
    override def toString = numer + "/" + denom

    def add(that: Rational): Rational =
        new Rational(
            numer * that.denom + that.numer * denom,
            denom * that.denom
        )

    def lessThan(that: Rational) =
        this.numer * that.denom < that.numer * this.denom

    def max(that: Rational) =
        if (lessThan(that)) that else this
}


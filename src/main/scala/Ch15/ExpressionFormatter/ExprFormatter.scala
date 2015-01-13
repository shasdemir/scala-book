package Ch15.ExpressionFormatter

import Ch15._
import Ch10.Element.elem

/**
 * Created by sukruhasdemir on 13/01/15.
 */
class ExprFormatter {

    // contains operators in groups of increasing precedence
    private val opGroups =
        Array(
            Set("|", "||"),
            Set("&", "&&"),
            Set("^"),
            Set("==", "!="),
            Set("<", "<=", ">", ">="),
            Set("+", "-"),
            Set("*", "%")
        )

    // a ,apping from operators to their precedence
    private val precedence = {
        val assocs =
            for {
                i <- 0 until opGroups.length
                op <- opGroups(i)
            } yield op -> i
        assocs.toMap
    }

    private val unaryPrecedence = opGroups.length
    private val fractionPrecedence = -1
}

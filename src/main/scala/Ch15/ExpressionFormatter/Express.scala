package Ch15.ExpressionFormatter

import Ch15._

/**
 * Created by sukruhasdemir on 13/01/15.
 */
object Express extends App {
    val f = ExprFormatter

    val e1 = BinOp("*", BinOp("/", Number(1), Number(2)),
                        BinOp("+", Var("x"), Number(1)))
    val e2 = BinOp("+", BinOp("/", Var("x"), Number(2)),
                        BinOp("/", Number(1.5), Var("x")))
    val e3 = BinOp("/", e1, e2)

    def show(e: Expr) = println(f.format(e) + "\n\n")

    for (e <- Array(e1, e2, e3)) show(e)
}

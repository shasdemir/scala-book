package Ch15

/**
 * Created by sukruhasdemir on 12/01/15.
 */
abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, leftArg: Expr, rightArg: Expr) extends Expr

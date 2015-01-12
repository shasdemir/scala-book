package Ch15

/**
 * Created by sukruhasdemir on 12/01/15.
 */
abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, leftArg: Expr, rightArg: Expr) extends Expr


object Simplifier {
    def simplifyTop(expr: Expr): Expr = expr match {
        case UnOp("-", UnOp("-", e)) => e  // Double negative
        case BinOp("+", e, Number(0)) => e  // Adding zero
        case BinOp("*", e, Number(1)) => e  // Multiplying by one
        case _ => expr
    }
}


object Describer {
    def describe(x: Any):String = x match {
        case 5 => "five"
        case true => "truth"
        case "hello" => "hi!"
        case Nil => "the empty list"
        case _ => "something else"
    }
}
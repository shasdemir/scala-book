package Ch15

/**
 * Created by sukruhasdemir on 12/01/15.
 */
object MatchDemos {
    def describe(x: Any):String = x match {
        case 5 => "five"
        case true => "truth"
        case "hello" => "hi!"
        case Nil => "the empty list"
        case _ => "something else"
    }

    def tupleDemo(expr: Any) = expr match {
        case (a, b, c) => println("matched " + a + b + c)
        case _ =>
    }

    def generalSize(x: Any) = x match {
        case s: String => s.length
        case m: Map[_, _] => m.size
        case _ => -1
    }

    def isIntIntMap(x: Any) = x match {
        case m: Map[Int, Int] => true
        case _ => false
    }

    def isStringArray(x: Any) = x match {
        case ary: Array[String] => "yes"
        case _ => "no"
    }

    val withDefault: Option[Int] => Int = {
        case Some(x) => x
        case None => 0
    }
}

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

//    def isIntIntMap(x: Any) = x match {  // warning due to type erasure
//        case m: Map[Int, Int] => true
//        case _ => false
//    }

    def isStringArray(x: Any) = x match {
        case ary: Array[String] => "yes"
        case _ => "no"
    }

    def show(x: Option[String]) = x match {
        case Some(s) => s
        case None => "?"
    }

    val withDefault: Option[Int] => Int = {
        case Some(x) => x
        case None => 0
    }

    def withDefault2: Option[Int] => Int = {
        case Some(x) => x
        case None => 0
    }

    def withDefault3(x: Option[Int]): Int = x match {
        case Some(c) => c
        case None => 0
    }

    def demoNew() = {
        def withDefault5(inputFunc: Option[Int] => Int): String = {
            inputFunc.toString()
        }
        // this compiles without declaring the type of match function literal, because withDefault5 has expects a
        // certain type
        println(
            withDefault5({
                case Some(x) => x
                case None => 0
        })
        )
    }

    val second: PartialFunction[List[Int], Int] = {
        case x :: y :: _ => y
    }
}

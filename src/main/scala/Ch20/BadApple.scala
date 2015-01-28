package Ch20

/**
 * Created by sukruhasdemir on 28/01/15.
 */

abstract class Fruit {
    val v: String
    def m: String
    var r: String
}


abstract class Apple extends Fruit {
    val v: String
    val m: String
}


//abstract class BadApple extends Fruit {
//    def v: String  // ERROR
//    def m: String
//}


abstract class QuestionOrange extends Fruit {
    var m: String
    def r: String
}

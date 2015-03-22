package Ch23

/**
 * Created by sukruhasdemir on 22/03/15.
 */
object ForExprSandbox {
    def main(args: Array[String]): Unit = {
        println("it works!")
    }

    case class Person(name: String, isMale: Boolean, children: Person*)

    val lara = Person("Lara", false)
    val bob = Person("Bob", true)
    val julie = Person("Julie", false, lara, bob)

    val persons = List(lara, bob, julie)
}

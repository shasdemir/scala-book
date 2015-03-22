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

    // find pairs of all mothers and their children - how I would do it w/o looking at the code in the book
    def isMother(sim: Person): Boolean = !sim.isMale && sim.children.nonEmpty

    def makeChildrenPairs(sim: Person) = sim.children.map((child: Person) => (sim.name, child.name))

    val pairs = persons.filter(isMother).flatMap(makeChildrenPairs)
}

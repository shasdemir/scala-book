package Ch13
package bobsdelights

/**
 * Created by sukruhasdemir on 10/01/15.
 */
abstract class Fruit (
    val name: String,
    val color: String
)


object Fruits {
    object Apple extends Fruit("apple", "red")
    object Orange extends Fruit("orange", "orange")
    object Pear extends Fruit("pear", "yellowish")
    val menu = List(Apple, Orange, Pear)
}
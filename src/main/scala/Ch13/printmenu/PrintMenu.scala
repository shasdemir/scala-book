package Ch13.printmenu
import Ch13.bobsdelights.Fruits
import Ch13.bobsdelights.showFruit

/**
 * Created by sukruhasdemir on 10/01/15.
 */
object PrintMenu {
    def main(args: Array[String]): Unit = {
        for (fruit <- Fruits.menu)
            showFruit(fruit)
    }
}

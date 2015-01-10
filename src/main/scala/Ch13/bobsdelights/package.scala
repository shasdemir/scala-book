package Ch13

/**
 * Created by sukruhasdemir on 10/01/15.
 */
package object bobsdelights {
    def showFruit(fruit: Fruit): Unit = {
        import fruit._
        println(name + "is are " + color)
    }
}

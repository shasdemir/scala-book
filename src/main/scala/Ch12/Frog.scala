package Ch12

/**
 * Created by sukruhasdemir on 06/01/15.
 */
class Frog extends Philosophical {
    override def toString = "green"
    override def philosophize(): Unit = {
        println("It ain't easy being " + toString + "!")
    }
}

package Ch20

/**
 * Created by sukruhasdemir on 30/01/15.
 */
object Color extends Enumeration {
    val Red, Green, Blue = Value
}

object Direction extends Enumeration {
    val North, East, South, West = Value
}


object Turns {
    // import Direction._

    def turnRight(dir: Direction.Value): Direction.Value = {
        Direction(dir.id + 1)
    }

    def makeSomeTurns(): Unit = {
        println("If you turn to right from North, you will face: ")  // East
        println(turnRight(Direction.North))
        println()
        println("If you turn to right from South, you will face: ")  // West
        println(turnRight(Direction.South))
    }
}
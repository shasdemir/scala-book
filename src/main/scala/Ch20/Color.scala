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
    import Direction._

    val dirToNums = Map(North -> 1, East -> 2, South -> 3, West -> 4)
    val numsToDir = dirToNums.map(tup => tup._2 -> tup._1)

    def turnRight(dir: Value): Value = {
        numsToDir(dirToNums(dir) + 1)
    }

    def makeSomeTurns(): Unit = {
        println("If you turn to right from North, you will face: ")
        println(turnRight(North))
        println()
        println("If you turn to right from South, you will face: ")
        println(turnRight(South))
        println()
    }
}
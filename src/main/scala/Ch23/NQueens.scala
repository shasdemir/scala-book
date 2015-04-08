package Ch23

/**
 * Created by sukruhasdemir on 08/04/15.
 */
class NQueens {
    def main(args: List[String]): List[(Int, Int)] = {
        val boardSize = args.head.toInt  // number of queens to place = size of the board

        // given all solutions that place k - 1 queens on the first k - 1 rows (and boardSize columns) place the kth
        // queen
        def partialSolutions(k: Int): List[List[(Int, Int)]] = {
            if (k == 0)
                List(List())
            else {
                val previousPlacements = partialSolutions(k - 1)

                for {
                    partials <- previousPlacements
                    column <- 1 to boardSize
                    if isSafe(column, partials)
                } yield (k, column) :: partials
            }
        }

        // for a given partial solution, can we safely place the next queen at the given column, one row below the last?
        def isSafe(column: Int, previousPlacements: List[(Int, Int)]): Boolean = {
            def check(q1: (Int, Int), q2: (Int, Int)): Boolean = {  // check if two queens check each other
                val sameRowOrColumn = (q1._1 == q2._1) || (q1._2 == q2._2)

                val sameDiagonal = (q2._2 - q1._2).abs == (q2._1 - q1._1).abs

                sameRowOrColumn || sameDiagonal
            }

            val candidateRow = previousPlacements.head._1 + 1

            previousPlacements.forall(old => !check(old, (candidateRow, column)))
        }

        partialSolutions(boardSize).head
    }
}

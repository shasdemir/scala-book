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

        // for a given partial solution, can we safely place the next queen at the given row, column?
        def isSafe(row: Int, previousPlacements: List[(Int, Int)]): Boolean = {
            def check(q1: (Int, Int), q2: (Int, Int)): Boolean = {  // check if two queens check each other
                
            }
        }

        partialSolutions(boardSize).head
    }
}

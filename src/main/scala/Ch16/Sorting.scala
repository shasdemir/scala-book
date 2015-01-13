package Ch16

/**
 * Created by sukruhasdemir on 14/01/15.
 */
object Sorting {
    def insertionSort(xList: List[Int]): List[Int] =
        if (xList.isEmpty) Nil
        else insert(xList.head, insertionSort(xList.tail))

    private def insert(x: Int, xList: List[Int]): List[Int] =
        if (xList.isEmpty || x <= xList.head) x :: xList
        else xList.head :: insert(x, xList.tail)
}

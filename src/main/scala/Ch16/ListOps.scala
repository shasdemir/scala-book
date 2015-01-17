package Ch16

/**
 * Created by sukruhasdemir on 14/01/15.
 */
object Sorting {
    def insertionSort(xList: List[Int]): List[Int] = {

        def insert(x: Int, xList: List[Int]): List[Int] =
            if (xList.isEmpty || x <= xList.head) x :: xList
            else xList.head :: insert(x, xList.tail)

        if (xList.isEmpty) Nil
        else insert(xList.head, insertionSort(xList.tail))
    }
 
    def mergeSort[T](lessThan: (T, T) => Boolean)(xs: List[T]): List[T] = {

        def merge(xs: List[T], ys: List[T]): List[T] =
            (xs, ys) match {
                case (Nil, _) => ys
                case (_, Nil) => xs
                case (x :: xs1, y :: ys1) =>
                    if (lessThan(x, y)) x :: merge(xs1, ys)
                    else y :: merge(xs, ys1)
            }

        val slicePos = xs.length / 2
        if (slicePos == 0) xs
        else {
            val (left, right) = xs splitAt slicePos
            merge(mergeSort(lessThan)(left), mergeSort(lessThan)(right))
        }
    }

    val intSort = mergeSort((x: Int, y: Int) => x < y) _
    val reverseIntSort = mergeSort((x: Int, y: Int) => x > y) _
}


object ListOps {
    def append[T](left: List[T], right: List[T]): List[T] = left match {
        case Nil => right
        case lFirst :: lRest =>  lFirst :: append(lRest, right)
    }

    def reverse[T](xs: List[T]): List[T] = xs match {
        case Nil => Nil
        case x :: ys => reverse(ys) ::: List(x)
    }

    def sum(xs: List[Int]): Int = (0 /: xs)(_ + _)

    def product(xs: List[Int]): Int = (1 /: xs) (_ * _)

    def flattenLeft[T](xs: List[List[T]]): List[T] =
        (List[T]() /: xs) (_ ::: _)  // this is inefficient, use flattenRight instead

    def flattenRight[T](xs: List[List[T]]): List[T] =
        (xs :\ List[T]()) (_ ::: _)

    def reverseLeft[T](xs: List[T]) =
        (List[T]() /: xs) {(ys, y) => y :: ys}
}
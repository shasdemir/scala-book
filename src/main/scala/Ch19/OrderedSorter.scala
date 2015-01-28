package Ch19

/**
 * Created by sukruhasdemir on 28/01/15.
 */
object OrderedSorter {
    def orderedMergeSort[T <: Ordered[T]](xs: List[T]): List[T] = {  // cannot use with Ints...
        def merge(xs: List[T], ys: List[T]): List[T] =
            (xs, ys) match {
                case (Nil, _) => ys
                case (_, Nil) => xs
                case (x :: xs1, y :: ys1) =>
                    if (x < y) x :: merge(xs1, ys)
                    else y :: merge(xs, ys1)
            }
        val n = xs.length / 2
        if (n == 0) xs
        else {
            val (ys, zs) = xs splitAt n
            merge(orderedMergeSort(ys), orderedMergeSort(zs))
        }
    }

    def main(args: Array[String]): Unit = {
        val people = List(
            new Person("Larry", "Wall"),
            new Person("Anders", "Hejlsberg"),
            new Person("Guido", "van Rossum"),
            new Person("Alan", "Kay"),
            new Person("Yukihiro", "Matsumoto")
        )

        val sortedPerople = orderedMergeSort(people)
        println(sortedPerople)
    }
}

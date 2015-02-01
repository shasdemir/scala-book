package Ch21

/**
 * Created by sukruhasdemir on 01/02/15.
 */
object MaxList {

    def maxListUpBound[T](elements: List[T])(implicit orderer: T => Ordered[T]): T =
        elements match {
            case List() => throw new IllegalArgumentException("empty list!")
            case List(x) => x
            case first :: rest =>
                val maxRest = maxListUpBound(rest)
                if (first > maxRest) first else maxRest
        }
}

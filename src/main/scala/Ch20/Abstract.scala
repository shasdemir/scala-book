package Ch20

/**
 * Created by sukruhasdemir on 28/01/15.
 */
trait Abstract {
    type T
    def transform(x: T): T
    val initial: T
    var current: T
}

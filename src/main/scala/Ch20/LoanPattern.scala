package Ch20

/**
 * Created by sukruhasdemir on 30/01/15.
 */

// no base type is specified, so AnyRef is used
object LoanPattern {
    def using[T <: { def close(): Unit }, S](obj: T)(operation: T => S) = {
        val result = operation(obj)
        obj.close()
        result
    }
}

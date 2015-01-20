package Ch18

/**
 * Created by sukruhasdemir on 20/01/15.
 */
class Keyed {
    def computeKey: Int = 42  // takes millions of years to compute
}


class MemoKeyed extends Keyed {
    private var keyCache: Option[Int] = None
    override def computeKey: Int = {
        if (!keyCache.isDefined) keyCache = Some(super.computeKey)
        keyCache.get
    }
}
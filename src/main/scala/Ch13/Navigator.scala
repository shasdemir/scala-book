package Ch13
package bobsrockets

/**
 * Created by sukruhasdemir on 10/01/15.
 */
package navigation {
    private[bobsrockets] class Navigator {
        protected[navigation] def useStarChart() {}
        class LegOfJourney {
            private[Navigator] val distance = 100
        }
        private[this] var speed = 200
    }
}


package launch {
    import navigation._
    object Vehicle {
        private[launch] val guide = new Navigator
    }
}
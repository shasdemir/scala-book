package Ch18.CircuitSimulation

import Ch18._

/**
 * Created by sukruhasdemir on 23/01/15.
 */
class BasicCircuitSimulation extends Simulation {

    def InverterDelay: Int  // constant
    def AndGateDelay: Int
    def OrGateDelay: Int

    class Wire {

        private var sigVal = false
        private var actions: List[Action] = List()

        def getSignal = sigVal
        def setSignal(s: Boolean) =
            if (s != sigVal) {
                sigVal = s
                actions foreach (_ ())
            }

        def addAction(a: Action) = {
            actions = a :: actions
            a()
        }
    }
}

package Ch18.CircuitSimulation

/**
 * Created by sukruhasdemir on 23/01/15.
 */
abstract class BasicCircuitSimulation extends Simulation {

    def InverterDelay: Int  // constants
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

    def inverter(input: Wire, output: Wire) = {
        def invertAction(): Unit = {
            val inputSig = input.getSignal
            afterDelay(InverterDelay) {
                output setSignal !inputSig
            }
        }
        input addAction invertAction
    }

    def andGate(a1: Wire, a2: Wire, output: Wire) = {
        def andAction() = {
            val a1Sig = a1.getSignal
            val a2Sig = a2.getSignal
            afterDelay(AndGateDelay) {
                output setSignal (a1Sig & a2Sig)
            }
        }
        a1 addAction andAction
        a2 addAction andAction
    }

    def orGate(a1: Wire, a2: Wire, output: Wire) = {
        def orAction() = {
            val a1Sig = a1.getSignal
            val a2Sig = a2.getSignal
            afterDelay(OrGateDelay) {
                output setSignal (a1Sig & a2Sig)
            }
        }
        a1 addAction orAction
        a2 addAction orAction
    }

    def probe (name: String, wire: Wire): Unit = {
        def probeAction(): Unit = {
            println(name + " " + currentTime + " new-value = " + wire.getSignal)
        }
        wire addAction probeAction
    }
}

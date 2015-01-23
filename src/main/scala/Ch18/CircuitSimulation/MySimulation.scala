package Ch18.CircuitSimulation

/**
 * Created by sukruhasdemir on 24/01/15.
 */
object MySimulation extends CircuitSimulation {
    def InverterDelay = 1
    def AndGateDelay = 3
    def OrGateDelay = 5

    val input1, input2, sum, carry = new Wire

    probe("sum", sum)
    probe("carry", carry)

    halfAdder(input1, input2, sum, carry)

    def main(args: Array[String]): Unit = {
        input1 setSignal true
        run()

        input2 setSignal true
        run()
    }
}

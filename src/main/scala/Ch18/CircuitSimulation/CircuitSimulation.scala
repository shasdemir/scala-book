package Ch18.CircuitSimulation

/**
 * Created by sukruhasdemir on 24/01/15.
 */
abstract class CircuitSimulation extends BasicCircuitSimulation {  // A library of user-defined circuits

    def halfAdder(a: Wire, b: Wire, s: Wire, c: Wire): Unit = {
        val d, e = new Wire
        orGate(a, b, d)
        andGate(a, b, c)
        inverter(c, e)
        andGate(d, e, s)
    }

    def fullAdder(a: Wire, b: Wire, cin: Wire, sum: Wire, cout: Wire): Unit = {
        val s, c1, c2 = new Wire
        halfAdder(a, cin, s, c1)
        halfAdder(b, s, sum, c2)
        orGate(c1, c2, cout)
    }
}

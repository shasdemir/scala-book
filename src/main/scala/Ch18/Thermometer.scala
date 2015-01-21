package Ch18

/**
 * Created by sukruhasdemir on 21/01/15.
 */
class Thermometer {
    var celsius: Float = _

    def fahrenheit = celsius * 9 / 5 + 32
    def fahrenheit_= (f: Float): Unit = {
        celsius = (f - 32) * 5 / 9
    }
    override def toString = fahrenheit + "F/" + celsius + "C"
}

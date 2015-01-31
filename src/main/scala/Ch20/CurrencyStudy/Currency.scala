package Ch20.CurrencyStudy

/**
 * Created by sukruhasdemir on 31/01/15.
 */

abstract class CurrencyZone {
    type Currency <: AbstractCurrency
    def make(x: Long): Currency

    abstract class AbstractCurrency {
        val amount: Long
        def designation: String

        override def toString = amount + " " + designation

        def + (that: Currency): Currency = make(this.amount + that.amount)
        def * (x: Double): Currency = make((this.amount * x).toLong)
    }
}


object US extends CurrencyZone {
    type Currency = Dollar
    def make(x: Long) = new Dollar { val amount = x }

    abstract class Dollar extends AbstractCurrency {
        def designation = "USD"
    }
}




// -------------------------------------------------------- below is my own attempt at this, above is from the book
abstract class SCurrency {
    val amount: Long
    val threeLetterName: String
    type Designation <: SCurrency
    def make(amount: Long): Designation

    override def toString = amount+ " " + threeLetterName

    def + (that: Designation) = make(amount + that.amount)
    def * (x: Double) = make((amount * x).toLong)
}


class EuroAmount(val amount: Long) extends SCurrency {
    val threeLetterName = "EUR"
    type Designation = EuroAmount

    def make(amount: Long) = new EuroAmount(amount)
}


class USDAmount(val amount: Long) extends SCurrency {
    val threeLetterName = "USD"
    type Designation = USDAmount

    def make(amount: Long) = new USDAmount(amount)
}
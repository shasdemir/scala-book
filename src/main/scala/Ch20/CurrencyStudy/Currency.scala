package Ch20.CurrencyStudy

/**
 * Created by sukruhasdemir on 31/01/15.
 */

abstract class CurrencyZone {
    type Currency <: AbstractCurrency
    def make(x: Long): Currency
    val CurrencyUnit: Currency

    abstract class AbstractCurrency {
        val amount: Long
        def designation: String

        def from(other: CurrencyZone#AbstractCurrency): Currency =
            make(math.round(
            other.amount.toDouble * Converter.exchangeRate(other.designation)(this.designation)))

        private def decimals(n: Long): Int = if (n == 1) 0 else 1 + decimals(n / 10)
        override def toString =
            ((amount.toDouble / CurrencyUnit.amount.toDouble)
                    formatted ("%." + decimals(CurrencyUnit.amount) + "f") + " " + designation)

        def + (that: Currency): Currency = make(this.amount + that.amount)
        def * (x: Double): Currency = make((this.amount * x).toLong)
    }
}


object US extends CurrencyZone {  // all this is just to prevent currency amounts (Dollar, etc) from making more of
    // themselves?
    abstract class Dollar extends AbstractCurrency {
        def designation = "USD"
    }
    type Currency = Dollar
    def make(x: Long) = new Dollar { val amount = x }

    val Cent = make(1)
    val Dollar = make(100)  // why give the same name to two members of an object?
    val CurrencyUnit = Dollar
}


object Europe extends CurrencyZone {
    abstract class Euro extends AbstractCurrency {
        def designation = "EUR"
    }

    type Currency = Euro
    def make(cents: Long) = new Euro { val amount = cents }

    val Cent = make(1)
    val Euro = make(100)
    val CurrencyUnit = Euro
}


object Japan extends CurrencyZone {
    abstract class Yen extends AbstractCurrency {
        def designation = "JPY"
    }

    type Currency = Yen
    def make(yen: Long) = new Yen { val amount = yen }

    val Yen = make(1)
    val CurrencyUnit = Yen
}


object Converter {
    var exchangeRate = Map(
        "USD" -> Map("USD" -> 1.0   , "EUR" -> 0.7596,
            "JPY" -> 1.211 , "CHF" -> 1.223),
        "EUR" -> Map("USD" -> 1.316 , "EUR" -> 1.0   ,
            "JPY" -> 1.594 , "CHF" -> 1.623),
        "JPY" -> Map("USD" -> 0.8257, "EUR" -> 0.6272,
            "JPY" -> 1.0   , "CHF" -> 1.018),
        "CHF" -> Map("USD" -> 0.8108, "EUR" -> 0.6160,
            "JPY" -> 0.982 , "CHF" -> 1.0  )
    ) }

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


// -------------------------------------------------------- another attempt
trait TCurrency {
    val amount: Long
    val threeLetterName: String

    type Designation <: TCurrency  // we need Designation type, because if + took TCurrency, different currency amounts
    // could be summed

    def make(amount: Long): Designation

    override def toString = amount+ " " + threeLetterName

    def + (that: Designation) = make(amount + that.amount)
    def * (x: Double) = make((amount * x).toLong)
}

class TEuroAmount(val amount: Long) extends TCurrency {
    val threeLetterName = "EUR"
    type Designation = TEuroAmount
    def make(amount: Long) = new TEuroAmount(amount)
}


class TDollarAmount(val amount: Long) extends TCurrency {
    val threeLetterName = "USD"
    type Designation = TDollarAmount
    def make(amount: Long) = new TDollarAmount(amount)
}
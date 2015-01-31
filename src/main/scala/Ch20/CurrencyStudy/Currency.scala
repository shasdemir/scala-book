package Ch20.CurrencyStudy

/**
 * Created by sukruhasdemir on 31/01/15.
 */
abstract class Currency {  // faulty design
    val amount: Long
    def designation: String

    override def toString = amount + " " + designation

    def + (that: Currency): Currency
    def * (x: Double): Currency
}






abstract class SCurrency {
    val amount: Long
    val threeLetterName: String
    type Designation <: SCurrency

    override def toString = amount+ " " + threeLetterName

    def + (that: Designation) = new Designation(amount + that.amount)
    def * (x: Double) = new Designation((amount * x).toLong)
}


class EuroAmount(val amount: Long) extends SCurrency {
    val threeLetterName = "EUR"
    type Designation = EuroAmount
}


class USDAmount(val amount: Long) extends SCurrency {
    val threeLetterName = "USD"
    type Designation = USDAmount
}
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




class CurrencyDesignation
class EuroDesignation extends CurrencyDesignation
class USDDesignation extends CurrencyDesignation

abstract class SCurrency {
    val amount: Long
    def designation: String

    override def toString = amount+ " " + designation

    def + (that: SCurrency): SCurrency
    def * (x: Double): SCurrency
}


class EuroAmount(val amount: Long) extends SCurrency {
    val designation = "Euro"

    def + (that: EuroAmount): EuroAmount = new EuroAmount(amount + that.amount)

    def * (x: Double): EuroAmount = new EuroAmount((amount * x).toLong)
}


class USDAmount(val amount: Long) extends SCurrency {
    val designation = "USD"

    def + (that: USDAmount): USDAmount = new USDAmount(amount + that.amount)

    def * (x: Double): USDAmount = new USDAmount((amount * x).toLong)
}
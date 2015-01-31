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

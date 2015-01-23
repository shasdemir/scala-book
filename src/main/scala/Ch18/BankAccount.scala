package Ch18

/**
 * Created by sukruhasdemir on 20/01/15.
 */
class BankAccount {
    private var bal: Int = 0

    def balance = bal

    def deposit(amount: Int): Unit = {
        require (amount > 0)
        bal += amount
    }

    def withdraw(amount: Int): Boolean =
        if (amount > bal) false
        else {
            bal -= amount
            true
        }
}

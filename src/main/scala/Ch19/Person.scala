package Ch19

/**
 * Created by sukruhasdemir on 28/01/15.
 */
class Person(val firstName: String, val lastName: String) extends Ordered[Person] {

    def compare(that: Person) = {
        val lastNameComparison = lastName.compareToIgnoreCase(that.lastName)

        if (lastNameComparison != 0)
            lastNameComparison
        else
            firstName.compareToIgnoreCase(that.firstName)
    }

    override def toString = firstName + " " + lastName
}

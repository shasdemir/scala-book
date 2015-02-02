package Ch21

/**
 * Created by sukruhasdemir on 01/02/15.
 */

class PreferredPrompt(val preference: String)
class PreferredDrink(val preference: String)


object Greeter {
    def greet(name: String)(implicit prompt: PreferredPrompt, drink: PreferredDrink): Unit = {
        println("Welcome, " + name + ". The system is ready.")
        println("But while you work, ")
        println("why not enjoy a cup of " + drink.preference + "?")
        println(prompt.preference)
    }
}


object JoesPrefs {
    implicit val prompt = new PreferredPrompt("Yes, master> ")
    implicit val drink = new PreferredDrink("tea")
}
package Ch21

/**
 * Created by sukruhasdemir on 01/02/15.
 */

class PreferredPrompt(val preference: String)


object Greeter {
    def greet(name: String)(implicit prompt: PreferredPrompt): Unit = {
        println("Welcome, " + name + ". The system is ready.")
        println(prompt.preference)
    }
}


object JoesPrefs {
    implicit val prompt = new PreferredPrompt("Yes, master> ")
}
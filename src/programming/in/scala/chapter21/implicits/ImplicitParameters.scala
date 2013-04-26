package programming.in.scala.chapter21.implicits

class PreferredPrompt(val preferences: String)
class PreferredDrink(val preference: String)

object Greeter {
  def greet(name: String)(implicit prompt: PreferredPrompt) {
    println(" Welcome, " + name + ". The system is ready.");
    println(prompt.preferences)
  }
}

object Greeter2ListOfImplicits {
  /**
   * Notice the list of implicit parameters in the method signature
   */
  def greet(name: String)(implicit prompt: PreferredPrompt, drink: PreferredDrink) {
    println(" Welcome, " + name + ". The system is ready.");
    println("But while you work, ")
    println("Why not enjoy a cup of " + drink.preference + "?")
    println(prompt.preferences)
  }
}

object JoesPrefs {
  implicit val prompt = new PreferredPrompt("Yes, master>")
  // Notice that the name of the implicit parameter doesn't have to match the 
  // method's argument name
  implicit val somethigToDring = new PreferredDrink("tea")
}

object ImplicitParameters {

  def main(args: Array[String]) {

    //    Greeter.greet("Helen") // Won't compile since the "prompt" implicit parameter is not defined 
    Greeter.greet("Helen")(new PreferredPrompt("relax>"))

    // Notice that we can import something in the middle of the function.
    import JoesPrefs._
    // Without the above import we would have to call greet providing the value for the implicit parameter
    Greeter.greet("Joe")

    // One can invoke the method with implicit parameters explicitly
    Greeter2ListOfImplicits.greet("Helen")(new PreferredPrompt("relax>"), new PreferredDrink("Cola"))
    // Onr implicitly
    Greeter2ListOfImplicits.greet("Joe")

  }
}
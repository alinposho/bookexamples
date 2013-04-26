package programming.in.scala.chapter21.implicits

// These two types have been created explicitly to aid in the implicit paramters
// matching. Extract from the book
/*
	One thing to note about the previous examples is that we didn’t use
String as the type of prompt or drink, even though ultimately it was a
String that each of them provided through their preference fields. Be-
cause the compiler selects implicit parameters by matching types of parame-
ters against types of values in scope, implicit parameters usually have “rare”
or “special” enough types that accidental matches are unlikely. For example,
the types PreferredPrompt and PreferredDrink in Listing 21.1 were de-
fined solely to serve as implicit parameter types. As a result, it is unlikely
that implicit variables of these types will be in scope if they aren’t intended
to be used as implicit parameters to Greeter.greet.
 */
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
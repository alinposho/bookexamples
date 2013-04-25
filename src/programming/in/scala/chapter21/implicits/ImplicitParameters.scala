package programming.in.scala.chapter21.implicits

class PreferredPrompt(val preferences: String)

object Greeter {
  def greet(name: String)(implicit prompt: PreferredPrompt) {
    println(" Welcome, " + name + ". The system is ready.");
    println(prompt.preferences)
  }
}

object JoesPrefs {
  implicit val prompt = new PreferredPrompt("Yes, master>")
}

object ImplicitParameters {

  def main(args: Array[String]) {
    
//    Greeter.greet("Helen") // Won't compile since the "prompt" implicit parameter is not defined 
    Greeter.greet("Helen")(new PreferredPrompt("relax>"))
    
    // Notice that we can import something in the middle of the function.
    import JoesPrefs._
    // Without the above import we would have to call greet providing the value for the implicit parameter
    Greeter.greet("Joe")
  }
}
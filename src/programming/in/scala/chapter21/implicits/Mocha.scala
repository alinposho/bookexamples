package programming.in.scala.chapter21.implicits

// Compile this program with "scalac -Xprint:typer Mocha.scala" and see what happens behind the courtains.
object Mocha extends Application {
  
  class PreferredDrink(val preference: String)
  
  implicit val pref = new PreferredDrink("mocha")
 
  def enjoy(name: String)(implicit drink: PreferredDrink) {
    print("Welcome, " + name)
    print(". Enjoy a ")
    print(drink.preference)
    println("!")
  }
  
  enjoy("reader")
}
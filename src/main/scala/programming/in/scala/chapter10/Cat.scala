package programming.in.scala.chapter10

class Cat {
  val dangerous = false
}

// Interesting enough one can define a private field in the class constructor
class Tiger(
  override val dangerous: Boolean,
  private var age: Int,
  private val clawLength: Int) extends Cat
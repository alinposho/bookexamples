package programming.in.scala.chapter15.caseclasses

object CaseClassExample {
	// Notice that as of Scala 2.8 we can have default values for case class parameters
	case class Smth(firstName: String, lastName: String, married: Boolean = false)
	
	def main(args: Array[String]): Unit = {
	  val johnDoe = Smth("John", "Doe")
	  println("johnDoe = " + johnDoe)
	  val janeDoe = johnDoe.copy(firstName = "Jane", married = true)
	  println("janeDoe = " + janeDoe)
	}
}
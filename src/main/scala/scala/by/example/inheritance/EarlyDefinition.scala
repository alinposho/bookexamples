package scala.by.example.inheritance

object EarlyDefinition {

}

trait Greeting {
  val name: String
  val msg = "How are you, " + name
}

// This will not compile despite what the Scala Reference Guide mentions in section "5.1.6 Early Definitions"
//class C extends { val name = "Bob" } with Greeting {
//  println(msg)
//}
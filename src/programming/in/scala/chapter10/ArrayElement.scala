package programming.in.scala.chapter10

// Notice that the contents parameter overrides the contents method from the superclass 
class ArrayElement(val contents: Array[String]) extends Element {
  override def toString = "contents = " + (contents mkString " ") 
}

object Main extends App {
  val elem: Element = new ArrayElement(Array("Hello", "World!"))
  println("elem " + elem)
}
package chapter10

class ArrayElement(conts: Array[String]) extends Element {
  def contents: Array[String] = conts
  
  override def toString = "contents = " + (contents mkString " ") 
}

object Main extends App {
  val elem: Element = new ArrayElement(Array("Hello", "World!"))
  println("elem " + elem)
}
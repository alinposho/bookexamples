package scalapuzzlers

object PickAnInt extends App {
  class A {
    type X // X <: Any
    var x: X = _
  }
  class B extends A {
    type X = Int
  }
  val b = new B
  println(b.x)
  println(b.x: Int)
  val bX = b.x
  println(bX)
}
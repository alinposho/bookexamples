package scalapuzzlers

object InformationOverload extends App {
  class X
  val x = new X
  val y = x: x.type

  object Overload {
    def foo(arg: Any) = 1
    def foo(arg: x.type) = 2
  }

  println(Overload.foo(x))
  println(Overload.foo(y: y.type))
  println(Overload.foo(y))
  println(y.getClass())
}
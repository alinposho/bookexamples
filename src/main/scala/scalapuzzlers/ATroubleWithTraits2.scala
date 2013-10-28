package scalapuzzlers

trait A2 {
  val foo: Int
  val bar = 10
  println("In A: foo: " + foo + ", bar: " + bar)
}

class BB2 extends A2 {
  val foo: Int = 25
  println("In B: foo: " + foo + ", bar: " + bar)
}

class C2 extends BB2 {
  override val bar = 99
  println("In C: foo: " + foo + ", bar: " + bar)
}

object ATroubleWithTraits2 {
  def main(args: Array[String]): Unit = {
    new C2
  }
}

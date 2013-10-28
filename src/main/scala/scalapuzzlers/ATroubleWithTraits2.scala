package scalapuzzlers

trait AA {
  val foo: Int
  val bar = 10
  println("In A: foo: " + foo + ", bar: " + bar)
}

class BB extends AA {
  val foo: Int = 25
  println("In B: foo: " + foo + ", bar: " + bar)
}

class CC extends BB {
  override val bar = 99
  println("In C: foo: " + foo + ", bar: " + bar)
}

object ATroubleWithTraits2 {
  def main(args: Array[String]): Unit = {
    new CC
  }
}

package scalapuzzlers

object OneBoundTwoToGo extends App {
  def invert(v3: Int)(v2: Int = 2, v1: Int = 1) {
    println(v1 + ", " + v2 + ", " + v3);
  }
  def invert3 = invert(3) _

  //  invert3(v1 = 2) // This will not compile since the invert3 variable definition is an instance of Function2
  invert3(v1 = 2, v2 = 1)
}
package scalapuzzlers

object ImplicitlySurprising extends App {
  def getFunction = {
    def sum(x: Int)(y: Int)(implicit z: Int) = x + y + z
    implicit val z1 = 2
    sum(1) _
  }

  val f = getFunction
  implicit val z2 = 3
  //  f(2)(3) // This will not compile since it tries to bind the value 3 to the implicit function parameter z  
  println(f(2))
}
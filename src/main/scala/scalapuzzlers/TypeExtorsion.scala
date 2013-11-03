package scalapuzzlers

object TypeExtorsion extends App {
  // cap it at ... wait for it ... ten!
  val (x, y) = (List(1, 3, 5), List(2, 4, 6)).zipped find (_._1 > 10) getOrElse (10)
  Console println s"Found $x"

}
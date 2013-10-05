package scala.by.example.variance.annotations

object ArrayVariance {
  // The is the n-th example that arrays are non-variant in Scala
  val x = new Array[String](1)                    //> x  : Array[String] = Array(null)
 // val y: Array[Any] = x // This will not compile since arrays are non-variant

}
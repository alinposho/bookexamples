package programming.in.scala.chapter19.typed.method

import scala.collection.immutable.LinearSeq

trait Super {
  def computeSmth[T <: AnyVal](): List[T]
}

// The following class will not compile - Evidently, I need to learn more about typed parameters 
//class Implementation extends Super {
//  var list = List(1, 2, 3)
//  def computeSmth[Int](): List[Int] = list 
//}

// But this will work...
trait SuperWithType {
  type U <: LinearSeq[Int]
  def computeSmthElse(): List[U]
}

class ImplementationUsingType extends SuperWithType {
  type U = List[Int]
  def computeSmthElse(): List[List[Int]] = List(List(1, 2, 3))
}


// But this will work...
trait SuperWithTypeSimplified {
  type U <: AnyVal
  def computeSmthElse(): List[U]
}

class ImplementationUsingTypeSimplified extends SuperWithTypeSimplified {
  type U = Int
  def computeSmthElse(): List[Int] = List(1, 2, 3)
}


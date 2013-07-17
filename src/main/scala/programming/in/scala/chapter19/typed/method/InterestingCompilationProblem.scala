package programming.in.scala.chapter19.typed.method

trait Super {
  def computeSmth[T <: Traversable[Int]](): List[T]  
}

// The following class will not compile - Evidently, I need to learn more about typed parameters 
//class Implementation extends Super {
//  def computeSmth[List[Int]](): List[List[Int]] = List(List(1, 2, 3))
//}
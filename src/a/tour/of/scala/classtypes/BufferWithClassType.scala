package a.tour.of.scala.classtypes

abstract class Buffer[+T] {
  val element: T // abstract value definition
}

abstract class SeqBuffer[U, +T <: Seq[U]] extends Buffer[T] {
  def length = element.length
}

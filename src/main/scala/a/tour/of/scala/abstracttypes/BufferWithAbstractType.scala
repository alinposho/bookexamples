package a.tour.of.scala.abstracttypes

abstract class Buffer {
  type T // type definition - T can be of any type
  val element: T // abstract value definition
}

abstract class SeqBuffer extends Buffer {
  type U
  type T <: Seq[U]
  def length = element.length
}

abstract class IntSeqBuffer extends SeqBuffer {
  type U = Int
}

class ConcreteIntSeqBuffer extends IntSeqBuffer {
  type T = List[U]
  val element = List(10, 199, 456)
}

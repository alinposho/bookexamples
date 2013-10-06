package scala.by.example.variance.annotations

trait MyStack[+A] {
	def push[B >: A](value: B): MyStack[B] = new NonEmptyStack(value, this)
	def pop: A
	def isEmpty: Boolean
}

object EmptyStack extends MyStack[Nothing] {
  def pop = throw new UnsupportedOperationException("Empty Stack")
  def isEmpty = true
  override def toString = "<empty>"
}

class NonEmptyStack[+A](value: A, next: MyStack[A]) extends MyStack[A] {
  def pop = value
  def isEmpty = false
  override def toString = value + " -> " + next.toString()
}
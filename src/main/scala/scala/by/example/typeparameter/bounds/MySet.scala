package scala.by.example.typeparameter.bounds

trait MySet[A <: Ordered[A]] {
  def incl(x: A): MySet[A]
  def contains(x: A): Boolean
}

class EmptySet[A <: Ordered[A]] extends MySet[A] {
  def incl(x: A): MySet[A] = new NonEmptySet(x, new EmptySet[A], new EmptySet[A])
  def contains(x: A): Boolean = false
}

class NonEmptySet[A <: Ordered[A]](elem: A, left: MySet[A], right: MySet[A]) extends MySet[A] {
  def contains(x: A): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  def incl(x: A): MySet[A] =
    if (x < elem) new NonEmptySet(elem, left incl x, right)
    else if (x > elem) new NonEmptySet(elem, left, right incl x)
    else this
}
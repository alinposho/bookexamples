package scala.by.example.typeparameter.viewbounds

//trait MySet[A <% Ordered[A]] { This will not compile, at least not with Scala 2.10.2 since traits cannot have view bounds 
// due to the implementation challenges of having them for traits.

abstract class MySet[A <% Ordered[A]] {
  def incl(x: A): MySet[A]
  def contains(x: A): Boolean
}

class EmptySet[A <% Ordered[A]] extends MySet[A] {
  def incl(x: A): MySet[A] = new NonEmptySet(x, new EmptySet[A], new EmptySet[A])
  def contains(x: A): Boolean = false
}

class NonEmptySet[A <% Ordered[A]](elem: A, left: MySet[A], right: MySet[A]) extends MySet[A] {
  def contains(x: A): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  def incl(x: A): MySet[A] =
    if (x < elem) new NonEmptySet(elem, left incl x, right)
    else if (x > elem) new NonEmptySet(elem, left, right incl x)
    else this
}

case class Num(value: Double) extends Ordered[Num] {
  def compare(that: Num): Int = {
    if (this.value < that.value) -1
    else if (this.value > that.value) 1
    else 0
  }
}
package programming.in.scala.chapter21.implicits

object ImplicitViewBound extends App {
  def maxListViewBound[T <% Ordered[T]](elements: List[T]): T =
    elements match {
      case List() =>
        throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxListViewBound(rest) // (orderer) is implicit
        if (x > maxRest) x // orderer(x) is implicit
        else maxRest
    } //> maxListViewBound: [T](elements: List[T])(implicit evidence$1: T => Ordered[

  println("""Max of List("one", "two", "three") is: """ + 
      maxListViewBound(List("one", "two", "three"))) //> res1: String = two
}
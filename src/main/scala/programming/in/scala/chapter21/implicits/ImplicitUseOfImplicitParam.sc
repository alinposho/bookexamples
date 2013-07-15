package programming.in.scala.chapter21.implicits

object ImplicitUseOfImplicitParam {
  // In this function, notice that even the call to orderer(x) is implicitly
  // added by the compiler
  def maxList[T](elements: List[T])(implicit orderer: T => Ordered[T]): T =
    elements match {
      case List() =>
        throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxList(rest) // (orderer) is implicit
        if (x > maxRest) x // orderer(x) is implicit
        else maxRest
    }                                             //> maxList: [T](elements: List[T])(implicit orderer: T => Ordered[T])T

  maxList(List(6732, 67, 32, 89, 90))             //> res0: Int = 6732

  // Notice that there is no mention of the implicit parameter Ordered[T] except for
  // T <% Ordered[T] which says "I can use any T, so long
  // as T can be treated as an Ordered[T]"
  def maxListViewBound[T <% Ordered[T]](elements: List[T]): T =
    elements match {
      case List() =>
        throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxListViewBound(rest) // (orderer) is implicit
        if (x > maxRest) x // orderer(x) is implicit
        else maxRest
    }                                             //> maxListViewBound: [T](elements: List[T])(implicit evidence$1: T => Ordered[
                                                  //| T])T
    
  maxListViewBound(List("one", "two", "three"))   //> res1: String = two
  
  
}
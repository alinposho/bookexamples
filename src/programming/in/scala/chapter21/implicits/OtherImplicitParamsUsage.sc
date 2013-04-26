package programming.in.scala.chapter21.implicits

object OtherImplicitParamsUsage {

  /**
   * Determines the maximum element from the list and returns it.
   */
  def maxListUpBound[T <: Ordered[T]](elements: List[T]): T =
    elements match {
      case List() =>
        throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxListUpBound(rest)
        if (x > maxRest) x
        else maxRest
    }                                             //> maxListUpBound: [T <: Ordered[T]](elements: List[T])T

  val intList = List(12, 4, 5, 78, 4, 9, 7)       //> intList  : List[Int] = List(12, 4, 5, 78, 4, 9, 7)
  // This won't compile since intList is of type List[Int] and Int is not a
  // subtype of Ordered[T]
  //maxListUpBound(intList)

  /**
   * Determines the maximum element from the list but uses an implicit parameter
   * to provide additional information about the type metioned explicitly in the
   * parameter list, in this case, the T parameter.
   */
  def maxListImpParm[T](elements: List[T])(implicit orderer: T => Ordered[T]): T =
    elements match {
      case List() =>
        throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxListImpParm(rest)(orderer)
        if (orderer(x) > maxRest) x
        else maxRest
    }                                             //> maxListImpParm: [T](elements: List[T])(implicit orderer: T => Ordered[T])T

  // We now notice that our function is able to compute the maximum element from
  // a list of ints.
  maxListImpParm(intList)                         //> res0: Int = 78
  
  maxListImpParm(List(1.5, 5.2, 10.7, 3.14159))   //> res1: Double = 10.7
  
  maxListImpParm(List("one", "two", "three"))     //> res2: String = two
  
}
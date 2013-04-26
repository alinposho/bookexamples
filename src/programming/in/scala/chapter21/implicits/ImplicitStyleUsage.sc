package programming.in.scala.chapter21.implicits

object ImplicitStyleUsage {

	def equal(x: Int, y: Int): Boolean = x == y
                                                  //> equal: (x: Int, y: Int)Boolean
	
	implicit val orderer = equal _            //> orderer  : (Int, Int) => Boolean = <function2>

  // Poor style implicit parameter definition. The implicit function doesn't offer
  // much detail regarding its required use & implementation.
  def maxListPoorStyle[T](elements: List[T])(implicit orderer: (T, T) => Boolean): T = {
    elements match {
      case List() =>
        throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxListPoorStyle(rest)(orderer)
        if (orderer(x, maxRest)) x
        else maxRest
    }
  }                                               //> maxListPoorStyle: [T](elements: List[T])(implicit orderer: (T, T) => Boolean
                                                  //| )T
	// One can actually provide equals as an implicit value instead of a comparisson
	// function
  maxListPoorStyle(List(1, 2, 3, 4, 5))           //> res0: Int = 5

}
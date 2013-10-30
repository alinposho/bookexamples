package scalapuzzlers

object PatternMatching {

	val t = 10 match {
      case y11 @ y22 => (y11, y22)
      }                                           //> t  : (Int, Int) = (10,10)
      // ROughly equaltes to
      val t1 = (10, 10)                           //> t1  : (Int, Int) = (10,10)

}
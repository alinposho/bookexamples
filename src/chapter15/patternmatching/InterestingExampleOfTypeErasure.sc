package chapter15.patternmatching

object InterestingExampleOfTypeErasure {

	def isIntIntMap(x: Any) = x match {
		case m: Map[Int, Int] => true
		case _ => false
	}                                         //> isIntIntMap: (x: Any)Boolean
	
	isIntIntMap(Map(1 -> 4))                  //> res0: Boolean = true

	// Strangely enough the expressions bellow also return true
	isIntIntMap(Map("a" -> "abcd"))           //> res1: Boolean = true
	isIntIntMap(Map(1 -> "jahsgdhgs"))        //> res2: Boolean = true

}
package programming.in.scala.examples

object IsInMap {

	def isInMap(k: String, v: String, map: Map[String, String]) = {
		map.get(k) == v // This will always return false since the return type of Map.get
										// is an Option[T] and obviously String != Option[String]
	}                                         //> isInMap: (k: String, v: String, map: Map[String,String])Boolean
	
	// This will return false
	isInMap("1", "one", Map("1"->"one", "2"->"two"))
                                                  //> res0: Boolean = false


}
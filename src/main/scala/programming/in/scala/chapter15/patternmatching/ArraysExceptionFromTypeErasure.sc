package chapter15.patternmatching

object ArraysExceptionFromTypeErasure {

  def isStringArray(x: Any) = x match {
    case a: Array[String] => "yes"
    case _ => "no"
  }                                               //> isStringArray: (x: Any)java.lang.String

  isStringArray(Array("323", "dsds"))             //> res0: java.lang.String = yes

  // Naturally returns "no"
  isStringArray(Array(1, 2, 3))                   //> res1: java.lang.String = no

  // This one will also return "no" since we're dealing with an array of Objects/Anys
  isStringArray(Array("323", 123))                //> res2: java.lang.String = no
  
  val array = Array("323", 123)                   //> array  : Array[Any] = Array(323, 123)
  

}
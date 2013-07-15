package chapter15.partiallyappliedfunctions

object withDefault {

  def withDefault: Option[Int] => Int = {
    case Some(x) => x
    case None => 0
  }                                               //> withDefault: => Option[Int] => Int

  withDefault(Some(10))                           //> res0: Int = 10
  withDefault(None)                               //> res1: Int = 0

  // An interesting example of a partially applied function that accept pretty much everything
  def caseFunction: PartialFunction[Any, Int] = {
    case x: Int => x
    case l: List[Any] => l.size
  }                                               //> caseFunction: => PartialFunction[Any,Int]

  caseFunction(10)                                //> res2: Int = 10
  caseFunction(List("String", 100, 13.4d))        //> res3: Int = 3

	// This will raise a MatchException since we didn't include a case statement
	// for string arguments
	//caseFunction("String")
}
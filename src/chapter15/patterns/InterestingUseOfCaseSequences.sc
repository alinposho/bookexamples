package chapter15.patterns

object InterestingUseOfCaseSequences {

	// Bellow we created a parially defined function
	val withDefault: Option[Int] => Int = {
		case s: Some[Int] => s.get
		case None => 0
	}                                         //> withDefault  : Option[Int] => Int = <function1>
	
	withDefault(Some(100))                    //> res0: Int = 100
	withDefault(None)                         //> res1: Int = 0
	
	withDefault.getClass()                    //> res2: java.lang.Class[?0] = class chapter15.patterns.InterestingUseOfCaseSeq
                                                  //| uences$$anonfun$main$1$$anonfun$1
	
	
	// Won't compile
	//withDefault(Some("ssss"))

	// Now for a more verbose example of case sequence usage
	val withDefaultMatch: Option[String] => String = _ match {
		case s: Some[String] => s.get
		case None => "EMPTY!"
	}                                         //> withDefaultMatch  : Option[String] => String = <function1>
	
	withDefaultMatch(Some("my String"))       //> res3: String = my String

}
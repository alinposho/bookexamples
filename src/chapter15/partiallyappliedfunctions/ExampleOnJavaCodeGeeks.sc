package chapter15.partiallyappliedfunctions

object ExampleOnJavaCodeGeeks {

  def add5Partial: PartialFunction[Int, Int] = {
    case d if (d > 0) && (d < 7) => 5 + d
  }                                               //> add5Partial: => PartialFunction[Int,Int]

  add5Partial(5)                                  //> res0: Int = 10
  // This will raise an exception since we didn't define a return value for d >= 7
  //add5Partial(100)

  add5Partial.isDefinedAt(4)                      //> res1: Boolean = true
  add5Partial.isDefinedAt(100)                    //> res2: Boolean = false

  val add4Partial: PartialFunction[Int, Int] = {
    case d if (d > 7) && (d <= 100) => d + 4;
  }                                               //> add4Partial  : PartialFunction[Int,Int] = <function1>

	val addPartial = add5Partial orElse add4Partial
                                                  //> addPartial  : PartialFunction[Int,Int] = <function1>
	
	addPartial(70)                            //> res3: Int = 74
	// Works even with 100
	addPartial(100)                           //> res4: Int = 104

}
package chapter15.partiallyappliedfunctions

object ExampleOnJavaCodeGeeks {

	println("The code is from this article: http://www.javacodegeeks.com/2013/01/scala-do-you-partially-understand-this.html?utm_source=feedburner&utm_medium=feed&utm_campaign=Feed%3A+JavaCodeGeeks+%28Java+Code+Geeks%29")
                                                  //> The code is from this article: http://www.javacodegeeks.com/2013/01/scala-do
                                                  //| -you-partially-understand-this.html?utm_source=feedburner&utm_medium=feed&ut
                                                  //| m_campaign=Feed%3A+JavaCodeGeeks+%28Java+Code+Geeks%29
	// Partial functions
	def minus(a: Int, b: Int) = "answer=" + (a-b)
                                                  //> minus: (a: Int, b: Int)java.lang.String
	
	def minus50 = minus(_: Int, 50)           //> minus50: => Int => java.lang.String
	minus50 (57)                              //> res0: java.lang.String = answer=7
	// Or one can define the partial function like this
	def minus5 = (x: Int) => minus(x, 5)      //> minus5: => Int => java.lang.String
	minus5(4)                                 //> res1: java.lang.String = answer=-1
	
	// Even more explicit
	def minus4(x: Int) = minus50(x)           //> minus4: (x: Int)java.lang.String
	minus4(4)                                 //> res2: java.lang.String = answer=-46
                 
	// Partially applied functions

  def add5Partial: PartialFunction[Int, Int] = {
    case d if (d > 0) && (d < 7) => 5 + d
  }                                               //> add5Partial: => PartialFunction[Int,Int]

  add5Partial(5)                                  //> res3: Int = 10
  // This will raise an exception since we didn't define a return value for d >= 7
  //add5Partial(100)

  add5Partial.isDefinedAt(4)                      //> res4: Boolean = true
  add5Partial.isDefinedAt(100)                    //> res5: Boolean = false

  val add4Partial: PartialFunction[Int, Int] = {
    case d if (d > 7) && (d <= 100) => d + 4;
  }                                               //> add4Partial  : PartialFunction[Int,Int] = <function1>

	val addPartial = add5Partial orElse add4Partial
                                                  //> addPartial  : PartialFunction[Int,Int] = <function1>
	
	addPartial(70)                            //> res6: Int = 74
	// Works even with 100
	addPartial(100)                           //> res7: Int = 104
}
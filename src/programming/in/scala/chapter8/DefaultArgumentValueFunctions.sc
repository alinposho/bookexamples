package chapter8

object DefaultArgumentValueFunctions {

  def printTime(out: java.io.PrintStream = Console.out) =
    out.println("time = " + System.currentTimeMillis())
                                                  //> printTime: (out: java.io.PrintStream)Unit
  // Notice that by default this function prints to the standard output
  printTime()                                     //> time = 1367669995969
  // But it can also print to the console error
  printTime(Console.err)                          //> time = 1367669995969
  
  def printTwo(one: String = "One", two: String) = println(s"One=$one, Two=$two")
                                                  //> printTwo: (one: String, two: String)Unit
// This will not compile althought the first argument of the function has a
// default value assigned to it.
//	printTwo("2")
	
	printTwo("One", "2")                      //> One=One, Two=2
	
	def printTime2(out: java.io.PrintStream = Console.out, divisor: Int = 1) = {
		out.println("time = " + System.currentTimeMillis()/divisor)
	}                                         //> printTime2: (out: java.io.PrintStream, divisor: Int)Unit

	// Both parameters left to their default values
	printTime2()                              //> time = 1367669995974
	// As in the example bellow - printTwo function - this won't work.
 	//printTime2(3)
 	// But this will
 	printTime2(divisor = 1000)                //> time = 1367669995
 	// This will work OK without naming the parameter explicitly since it's the
 	// first parameter in the method's signature.
 	printTime2(Console.err)                   //> time = 1367669995975
}
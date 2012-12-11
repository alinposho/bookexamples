package chapter8

object DefaultArgumentValueFunctions {

  def printTime(out: java.io.PrintStream = Console.out) =
    out.println("time = " + System.currentTimeMillis())
                                                  //> printTime: (out: java.io.PrintStream)Unit
  // Notice that by default this function prints to the standard output
  printTime()                                     //> time = 1355198636851
  // But it can also print to the console error
  printTime(Console.err)                          //> time = 1355198636851

}
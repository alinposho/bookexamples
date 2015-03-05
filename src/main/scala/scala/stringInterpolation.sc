package scala

object stringInterpolation {
  def someFunction(): String = {
    println("This is a side effect function")
    "blah"
  }                                               //> someFunction: ()String

  // Notice that the strin interpolation evaluates only at runtime
  val res = if (false) s"res=$someFunction()" else "false"
                                                  //> res  : String = false
  
  val interpolation = s"intepolation result = $someFunction()"
                                                  //> This is a side effect function
                                                  //| interpolation  : String = intepolation result = blah()

}
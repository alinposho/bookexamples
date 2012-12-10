package chapter8

object PartiallyAppliedFunctions {

  // Some crazy sintax?
  def sum = (_: Int) + (_: Int) + (_: Int)        //> sum: => (Int, Int, Int) => Int

  // The above function definition is equivalent to
  // def sum(x: Int, y: Int, z: Int): Int = x + y + z

  sum(1, 2, 3)                                    //> res0: Int = 6

  // Now define a patially aplied function a
  val a = sum _                                   //> a  : () => (Int, Int, Int) => Int = <function0>
  // This will not work since sum is defined using _ (underscores)
  //a(3,4,5)
  // This is what happens behind the scenes
  //a.apply(1,2,3)

  // Properly defined function
  def sum2(x: Int, y: Int, z: Int): Int = x + y + z
                                                  //> sum2: (x: Int, y: Int, z: Int)Int
  val b = sum2 _                                  //> b  : (Int, Int, Int) => Int = <function3>
  b(4, 5, 6)                                      //> res1: Int = 15

}
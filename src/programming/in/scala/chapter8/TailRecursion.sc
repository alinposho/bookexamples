package chapter8

object TailRecursion {

  // This function is not tail recursive
  def boom(x: Int): Int =
    if (x == 0) throw new Exception("boom!")
    else boom(x - 1) + 1                          //> boom: (x: Int)Int

  //boom(3)

  // But this one is tail recursive
  def bang(x: Int): Int =
    if (x == 0) throw new Exception("bang!")
    else bang(x - 1)                              //> bang: (x: Int)Int
  // And this can be noticed from the stack trace
  //bang(5)
}
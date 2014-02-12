package scala.in.depth.chapter11.patterns.in.functional.programming

object currying {

  def add(x: Int, y: Int, z: Int) = x + y + z     //> add: (x: Int, y: Int, z: Int)Int
  val x = add _                                   //> x  : (Int, Int, Int) => Int = <function3>
  
  x.curried                                       //> res0: Int => (Int => (Int => Int)) = <function1>
  
  x.curried (1) (2) (3)                           //> res1: Int = 6
  

}
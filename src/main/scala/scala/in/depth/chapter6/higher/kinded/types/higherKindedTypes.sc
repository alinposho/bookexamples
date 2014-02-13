package scala.in.depth.chapter6.higher.kinded.types

object higherKindedTypes {

  // Callback[Int] is a higher kinded type
  type Callback[Int] = Function[Int, Unit]

  val x: Callback[Int] = y => println(y + 2)      //> x  : Int => Unit = <function1>
  x(2)                                            //> 4

  def foo[M[_]](f: M[Int]) = f                    //> foo: [M[_]](f: M[Int])M[Int]
	
	val y = foo(x)                            //> y  : Int => Unit = <function1>
	y(3)                                      //> 5
	
	// This will not compile since Function1 takes two type parameters
	// val z = foo[Function1](x)
}
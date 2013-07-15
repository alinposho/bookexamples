package programming.in.scala.chapter21.implicits

import chapter6.Rational

object ConvertingTheReceiver {

	implicit def intoToRational(x: Int) = {
		new Rational(x, 1)
	}                                         //> intoToRational: (x: Int)chapter6.Rational

	val half = Rational(1, 2)                 //> half  : chapter6.Rational = 1/2

	// This won't work since the 1 literal doesn't have a + defined which takes Rational parameters
	// Unless the intToRational(x: Int) function is in scope.
	1 + half                                  //> res0: chapter6.Rational = 3/2


	23 * half                                 //> res1: chapter6.Rational = 23/2
	
	2 * half                                  //> res2: chapter6.Rational = 1
}
package scala.by.example.fixed.point

object FixedPointExamples {

  import Math._

  val tolerance = 0.0001                          //> tolerance  : Double = 1.0E-4
  def isCloseEnough(x: Double, y: Double) = abs((x - y) / x) < tolerance
                                                  //> isCloseEnough: (x: Double, y: Double)Boolean
  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }                                               //> fixedPoint: (f: Double => Double)(firstGuess: Double)Double
  
  // Square root implementation using Newton's approximation AKA fixed point functions
  def sqrt(x: Double) = fixedPoint(y => (y + x/y) / 2)(1.0)
                                                  //> sqrt: (x: Double)Double
  sqrt(4)                                         //> res0: Double = 2.000000000000002
  sqrt(1)                                         //> res1: Double = 1.0
  sqrt(2)                                         //> res2: Double = 1.4142135623746899
	sqrt(10000)                               //> res3: Double = 100.00000025490743
	
	def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2
                                                  //> averageDamp: (f: Double => Double)(x: Double)Double
	// Square root implementation using Newton's approximation with a generic average dampener function
	def sqrt2(x: Double) = fixedPoint(averageDamp(y => x / y))(1.0)
                                                  //> sqrt2: (x: Double)Double
	sqrt2(4)                                  //> res4: Double = 2.000000000000002
	sqrt2(99)                                 //> res5: Double = 9.949874371188393
	
	// Cube root implementation using Newton's approximation AKA fixed point functions
	def cuberoot(x: Double) = fixedPoint(averageDamp(y => x / (y * y)))(1.0)
                                                  //> cuberoot: (x: Double)Double
	
	cuberoot(27)                              //> res6: Double = 3.0000885780097266
	cuberoot(1000)                            //> res7: Double = 9.999674382364848
}
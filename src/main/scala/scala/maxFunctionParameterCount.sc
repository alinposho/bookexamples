
// This will actually be a method defintion
def f(a1: Int, a2: Long, a3: String, a4: Double,
      a5: Int, a6: Long, a7: String, a8: Double,
      a9: Int, a10: Long, a11: String, a12: Double,
      a13: Int, a14: Long, a15: String, a16: Double,
      a17: Int, a18: Long, a19: String, a20: Double,
      a21: Int, a22: Long, a23: String, a24: Double,
      a25: Int, a26: Long, a27: String, a28: Double
       ) = 1

// While this will be a function definition that is restricted to
// 22 parameters in Scala 2.10, so it won't compile
//val fct: (Int, Int, Int, Int,
//  Int, Int, Int, Int,
//  Int, Int, Int, Int,
//  Int, Int, Int, Int,
//  Int, Int, Int, Int) => Int = f

// This will not compile either since you are turning a
// method into a function
//val g = f _

def m1(a: Int) = a + 3


// The following two assignments are equivalent
val g1: Int => Int = m1

val g2 = m1 _

g1.toString
g1 andThen g2

// The following will not compile since m1 is a method not a function
//method.toString()

// Each time a method is referenced as a function, like for
// out two values, Scala creates a new instance of the
// Functionx trait. That is the reason why g1 != g2
g1 == g2


// Notice that methods can be parametrised but functions cannot
// unless you define a class
def m2[T](x:T) = x.toString.substring(0,4)

m2(123456)

// the following will not compile
//val f3: [T](x: T) => x.toString.substring(0,4)

val f4 = m2 _

f4(1234567)




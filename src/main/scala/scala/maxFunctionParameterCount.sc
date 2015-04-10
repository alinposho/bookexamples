
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
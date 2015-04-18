
// Define a functions tha curries a 2 argument function

// Iteration 1
def curry[A, B, C](f: (A, B) => C): A => B => C = {
  def ab(a: A): B => C = {
    def bc(b: B): C = {
      f(a, b)
    }
    bc
  }
  ab
}

val sum = (a: Int, b: Int) => a + b

val csum = curry(sum)

val add1 = csum(1)

add1(5)

add1(10)

csum(10)(15)

sum(10, 15)

sum.curried



// Iteration 2
def curry2[A, B, C](f: (A, B) => C): A => B => C =
  (a: A) => (b: B) => f(a, b)



val csum2 = curry2(sum)

csum2(19)(-20)



def uncurry[A,B,C](f: A => B => C): (A, B) => C =
  (a: A, b: B) => f(a)(b)

val sum = (a: Int, b: Int) => a + b

sum(1, 2)

val csum = sum.curried

csum(2)(3)

val ucsum = uncurry(csum)

ucsum(2, 3)


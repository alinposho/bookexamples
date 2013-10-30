package scalapuzzlers

object ArghArrgh {
  def main(args: Array[String]): Unit = {
    def square[T: Numeric](n: T) = implicitly[Numeric[T]].times(n, n)

    def twiceA[T](f: T => T, a: T) = f(f(a))
    def twiceB[T](f: T => T)(a: T) = f(f(a))
    def twiceC[T](a: T, f: T => T) = f(f(a))
    def twiceD[T](a: T)(f: T => T) = f(f(a))

    // The first three will not compile since the type for the square function is not known at compile type
//    twiceA(square, 2)
//    twiceB(square)(2)
//    twiceC(2, square)
    println(twiceD(2)(square))
  }
}
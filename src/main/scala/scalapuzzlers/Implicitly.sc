package scalapuzzlers

object Implicitly {
  // The "implicitly" keyword will find the implicit parameter in scope and retrieve it, otherwise, it will throw a
  // compilation err
  implicitly[Ordering[Int]]                       //> res0: Ordering[Int] = scala.math.Ordering$Int$@a52ded2

	// This will not compile since there is no implicit value defined of type Int
	// implicitly[Int]
	
	implicit val x = 10                       //> x  : Int = 10
	// But thhis will succeed since we have just defined an implicit Int value
	implicitly[Int]                           //> res1: Int = 10
}
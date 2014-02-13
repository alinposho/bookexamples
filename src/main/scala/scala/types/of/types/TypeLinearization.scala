package scala.types.of.types

trait A { def common = "A" }

trait B extends A { override def common = super.common + "B" }
trait C extends A { override def common = super.common + "C" }

class D1 extends B with C
class D2 extends C with B

object TypeLinearization extends App {
	println(new D1().common)
	println(new D2().common)
}
package scalapuzzlers

object ACaseOfEquality extends App {
  val c1 = new C()
  val c2 = new C()
  val cc1 = CC()
  val cc2 = CC()

  println(c1 == c2)
  println(c1.## == c2.##)
  println(cc1 == cc2)
  println(cc1.## == cc2.##)
}

trait OverridesEquals {
  override def equals(x: Any) = super.equals(x)
}

class C extends OverridesEquals
case class CC() extends OverridesEquals
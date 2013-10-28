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
// Compiling this file with "scalac -print ACaseOfEquality" will show that the CC case class does not have a 
// "nice" "equals(...)" method generated since, according to the SLS the case classes get a generated equals only
// if the superclass does not define one. In our case, the OverrideEquals trait defines equals
case class CC() extends OverridesEquals 
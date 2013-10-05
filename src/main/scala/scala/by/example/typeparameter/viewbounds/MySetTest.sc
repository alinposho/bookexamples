package scala.by.example.typeparameter.bounds

object MySetTest {

  val set = new EmptySet[Num]
  val nonEmpty = set.incl(Num(199.0))

  val s = new EmptySet[Num].incl(Num(1.0)).incl(Num(2.0))
  s.contains(Num(1.5))

}
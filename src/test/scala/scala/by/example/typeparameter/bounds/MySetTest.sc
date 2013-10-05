package scala.by.example.typeparameter.bounds

object MySetTest {

  case class Num(value: Double) extends Ordered[Num] {
    def compare(that: Num): Int = {
      if (this.value < that.value) -1
      else if (this.value > that.value) 1
      else 0
    }
  }

  val set = new EmptySet[Num]                     //> set  : scala.by.example.typeparameter.bounds.EmptySet[scala.by.example.typep
                                                  //| arameter.bounds.MySetTest.Num] = scala.by.example.typeparameter.bounds.Empty
                                                  //| Set@733e6a71
  val nonEmpty = set.incl(Num(199.0))             //> nonEmpty  : scala.by.example.typeparameter.bounds.MySet[scala.by.example.typ
                                                  //| eparameter.bounds.MySetTest.Num] = scala.by.example.typeparameter.bounds.Non
                                                  //| EmptySet@1ccfa5c1

  val s = new EmptySet[Num].incl(Num(1.0)).incl(Num(2.0))
                                                  //> s  : scala.by.example.typeparameter.bounds.MySet[scala.by.example.typeparame
                                                  //| ter.bounds.MySetTest.Num] = scala.by.example.typeparameter.bounds.NonEmptySe
                                                  //| t@48b30ae
  s.contains(Num(1.5))                            //> res0: Boolean = false
  
  //val set1 = new EmptySet[java.io.File] // This will not compile since java.io.File does not conform to type bounds

}
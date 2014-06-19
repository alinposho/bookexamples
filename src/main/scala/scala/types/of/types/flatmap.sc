package scala.types.of.types

object flatmap {
  List(8, 9).find(_ == 9) map (println(_))        //> 9
                                                  //| res0: Option[Unit] = Some(())
  List(8, 9).headOption                           //> res1: Option[Int] = Some(8)

  val a = Array(1, 2, 3)                          //> a  : Array[Int] = Array(1, 2, 3)
  a.apply(1)                                      //> res2: Int = 2

  a.lift(4).filter(_ == 1)                        //> res3: Option[Int] = None

  List(4, 5, 6).sorted                            //> res4: List[Int] = List(4, 5, 6)
  
  import MyObj._
  
  val d = 4.5                                     //> d  : Double = 4.5
  d.myBlah()                                      //> res5: Double = 7.5
  
  5.0.myBlah()                                    //> res6: Double = 8.0
  
  Blah(1) == Blah(1)                              //> res7: Boolean = true
  
  val Blah(value) = Blah(1)                       //> value  : Int = 1
  value                                           //> res8: Int = 1
}

case class Blah(i: Int)

object MyObj {
  implicit class MyDouble(d: Double) {
  
  	def myBlah() = d + 3.0
  }
}
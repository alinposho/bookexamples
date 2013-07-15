package chapter6

object rationals {
  val r = new Rational(5, 3)                      //> r  : chapter6.Rational = 5/3
  
  val r2 = new Rational(100, 0)                   //> java.lang.IllegalArgumentException: requirement failed
                                                  //| 	at scala.Predef$.require(Predef.scala:202)
                                                  //| 	at chapter6.Rational.<init>(chapter6.rationals.scala:11)
                                                  //| 	at chapter6.rationals$$anonfun$main$1.apply$mcV$sp(chapter6.rationals.sc
                                                  //| ala:6)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at chapter6.rationals$.main(chapter6.rationals.scala:3)
                                                  //| 	at chapter6.rationals.main(chapter6.rationals.scala)
}

class Rational(num: Int, denom: Int) {
  //assert(denom != 0, "Denom cannot be 0!")
  require(denom != 0)
  // println("Created num= " + num + " denom= " + denom)
  override def toString = num + "/" + denom
}
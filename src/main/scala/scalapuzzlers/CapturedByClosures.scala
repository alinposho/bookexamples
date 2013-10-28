package scalapuzzlers

object CapturedByClosures extends App {

  val values = Seq(100, 110, 120)
  val funcs1 = collection.mutable.Buffer[() => Int]()
  val funcs2 = collection.mutable.Buffer[() => Int]()
  var j = 0
  for (i <- 0 until values.length) {
    funcs1 += (() => values(i))
    funcs2 += (() => values(j))
    j += 1
  }

  funcs1.foreach { f1 => println(f1()) }
  funcs2.foreach { f2 => println(f2()) } // This will throw an IndexOutOfBoundsException since the closed value j
  // is 3 when this list of functions get executed.
}
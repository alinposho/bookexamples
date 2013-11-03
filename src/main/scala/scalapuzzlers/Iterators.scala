package scalapuzzlers

object Iterators extends App {
  val t = "this is a test"
  val rx = " ".r
  val m = rx.findAllIn(t)
  println(m)
  println(m.end)
  println(rx.findAllIn(t).end)
}
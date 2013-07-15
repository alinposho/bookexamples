package a.tour.of.scala.typebounds

trait Similar {
  def isSimilar(x: Any): Boolean
}
case class MyInt(x: Int) extends Similar {
  def isSimilar(m: Any): Boolean = m.isInstanceOf[MyInt] && m.asInstanceOf[MyInt].x == x
}
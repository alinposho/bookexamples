package chapter14.assertions

//import chapter10.puttingitalltogether._
import Element.elem

object Ensuring {

}

abstract class Element {
  def contents: Array[String]

  def height: Int = contents.length
  def width: Int = if (height == 0) 0 else contents(0).length

  def widen(w: Int): Element = {
    if (w <= width) this
    else {
      val left = elem(' ', (w - width) / 2, height)
      val right = elem(' ', w - width - left.width, height)
      //left beside this beside right
      this
    }
  //}.ensuring(w <= _.width) // the short version of ensuring
  }.ensuring((elem: Element) => w <= elem.width)
  

}

object Element {
  private class ArrayElement(
    val contents: Array[String]) extends Element
  private class LineElement(s: String) extends Element {
    val contents = Array(s)
    override def width = s.length
    override def height = 1
  }
  private class UniformElement(
    ch: Char,
    override val width: Int,
    override val height: Int) extends Element {
    private val line = ch.toString * width
    def contents = Array.fill(height)(line)
  }

  def elem(contents: Array[String]): Element = new ArrayElement(contents)
  def elem(ch: Char, width: Int, height: Int): Element = new UniformElement(ch, width, height)
  def elem(line: String): Element = new LineElement(line)
}
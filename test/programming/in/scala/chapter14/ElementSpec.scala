package programming.in.scala.chapter14

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import programming.in.scala.chapter10.puttingitalltogether.Element.elem
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ElementSpec extends FlatSpec with ShouldMatchers {

  "A UniformElement" should 
    "have a width equal to the passed value" in {
      val ele = elem('x', 2, 3)
      ele.width should be(2)
    }

  it should "have a height equal to the passed value" in {
    val ele = elem('x', 2, 3)
    ele.height should be(3)
  }
  
  it should "throw an IAE if passed a negative width" in {
    evaluating {
      elem('x', 2, 3)
    } should produce[IllegalArgumentException]
  }
  
}
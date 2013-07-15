package programming.in.scala.chapter14

import programming.in.scala.chapter10.puttingitalltogether.Element.elem
import org.scalatest.junit.JUnit3Suite

class ElementSuite extends JUnit3Suite {
  
  def testUniformElement() {
    val ele = elem('x', 2, 3)
    assert(ele.width === 2)
    assert(ele.height === 3)
    intercept[IllegalArgumentException] {
      elem('x', -2, 3)
    }
  }

}
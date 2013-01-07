package chapter14.tests

import chapter10.puttingitalltogether.Element.elem
import org.scalatest.junit.JUnit3Suite
import com.sun.xml.internal.messaging.saaj.util.TeeInputStream

class ElementSuite extends JUnit3Suite {
  
  def testUniformElement() {
    val ele = elem('x', 2, 3)
    assert(ele.width === 2)
    expect(3) {ele.height}
    intercept[IllegalArgumentException] {
      elem('x', -2, 3)
    }
  }

}
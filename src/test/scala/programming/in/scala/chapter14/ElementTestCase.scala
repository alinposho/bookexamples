package programming.in.scala.chapter14

import programming.in.scala.chapter10.puttingitalltogether.Element.elem
import junit.framework.Assert.assertEquals
import junit.framework.Assert.fail
import junit.framework.TestCase

class ElementTestCase extends TestCase {

  def testUniformElement() {
    val ele = elem('x', 2, 3)
    assertEquals(2, ele.width)
    assertEquals(3, ele.height)
    try {
      elem('x', -2, 3)
      fail()
    } catch {
      case e: IllegalArgumentException => // expected
    }
  }

}
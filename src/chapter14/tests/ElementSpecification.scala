package chapter14.tests

import chapter10.puttingitalltogether.Element.elem
import org.specs2.Specification
import org.specs2.matcher.ShouldMatchers
import org.scalatest.matchers.ShouldMatchers


object ElementSpecification extends Specification {
  
  "A UnitoformElement" should {
    "have a width equal to the passed value" in {
      val ele = elem('x', 2, 3)
      ele.width must be_==(2)
    }
  }
  
}
package scala.by.example.typeparameter.viewbounds

import org.junit.runner.RunWith
import org.scalatest.BeforeAndAfterAll
import org.scalatest.WordSpec
import org.scalatest.matchers.MustMatchers
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MySetTest extends WordSpec
  with MustMatchers
  with BeforeAndAfterAll {

  implicit def doubleToOrderedNum(value: Double) = Num(value)

  "MySet.incl" should {
    "work with Double instances since we have an implicit conversion method" in {
      val value: Double = 4.5

      val set = new EmptySet[Num].incl(value)

      assert(set.contains(value) === true)
    }
  }
}
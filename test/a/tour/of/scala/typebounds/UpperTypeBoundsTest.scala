package a.tour.of.scala.typebounds

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

@RunWith(classOf[JUnitRunner])
class UpperTypeBoundsTest extends FunSuite {

  def findSimilar[T <: Similar](e: T, xs: List[T]): Boolean = {
    if (xs.isEmpty) {
      false
    } else {
      if (xs.head == e) true
      else
        findSimilar(e, xs.tail)
    }
  }

  test("findSimilar function should accept subtypes of Similar") {
    val searchedElement = MyInt(199)
    val list = List(MyInt(1), MyInt(5), searchedElement, MyInt(-9091))

    assert(true === findSimilar(searchedElement, list))
  }
}
package programming.in.scala.chapter16.lists

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TakeOperatorTest extends FunSuite {

  test("take should return the expected number of elements from the beginning of the list") {
    val list = List(1, 2, 3, 4, 5, 5, 6, 8)

    val takeResult = list take 3

    assert(takeResult === List(1, 2, 3))
  }

  test("take should return the whole list") {
    val list = List(1, 2, 3, 4, 5, 5, 6, 8)

    val takeResult = list take (list.size + 1)

    assert(takeResult === list)
  }
  
  
}
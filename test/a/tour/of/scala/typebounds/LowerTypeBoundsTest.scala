package a.tour.of.scala.typebounds

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSuite

@RunWith(classOf[JUnitRunner])
class LowerTypeBoundsTest extends FunSuite {

  test("Should create a ListNode of paramenter type Null") {

    val empty: ListNode[Null] = ListNode(null, null)
    val stillEmpty = empty.prepend(null)

    assert(stillEmpty.isInstanceOf[ListNode[Null]])
  }

  test("Should change the result list when prepending a supertype") {
    val empty: ListNode[Null] = ListNode(null, null)
    val someString = "some String"

    val stringList: ListNode[String] = empty.prepend(someString)

    assert(someString === stringList.head)
  }

  test("Should create a ListNode[Any] when prepending two unrelated types") {
    val empty: ListNode[Null] = ListNode(null, null)
    val stringList: ListNode[String] = empty.prepend("some String")
    val someInt = 19898
    val anyList: ListNode[Any] = stringList.prepend(someInt)

    assert(someInt === anyList.head)
  }

}
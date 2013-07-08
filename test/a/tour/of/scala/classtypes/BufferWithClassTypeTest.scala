package a.tour.of.scala.classtypes

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class BufferWithClassTypeTest extends FunSuite {

  test("Should show how to use class paramenters in Buffer") {
    val stringValue = "someString"

    val stringBuffer = new Buffer[String] {
      val element = stringValue
    }

    assert(stringValue === stringBuffer.element)
  }

  test("Should show a more involved example of how to use class type parameters") {
    val listOfInts = List(10, 199, 456)
    
    val newIntListBuffer = new SeqBuffer[Int, List[Int]] {
      val element = listOfInts
    }

    assert(3 === newIntListBuffer.length)
    assert(newIntListBuffer.element.isInstanceOf[List[Int]])
  }

}
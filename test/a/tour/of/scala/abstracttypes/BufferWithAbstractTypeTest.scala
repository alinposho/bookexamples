package a.tour.of.scala.abstracttypes

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

@RunWith(classOf[JUnitRunner])
class BufferWithAbstractTypeTest extends FunSuite {

  test("An example of how to use type definition in a class") {
    val listOfInts = List(10, 199, 456)
    val newIntListBuffer = new IntSeqBuffer {
      type T = List[U]
      val element = listOfInts
    }

    assert(3 === newIntListBuffer.length)
    assert(newIntListBuffer.element.isInstanceOf[List[Int]])
  }

  test("Should show that abstract type T can be of any type in the Buffer class") {
    val stringValue = "someString"

    val stringBuffer = new Buffer {
      type T = String
      val element = stringValue
    }

    assert(stringValue === stringBuffer.element)
    assert(stringBuffer.element.isInstanceOf[String])
  }
  
}
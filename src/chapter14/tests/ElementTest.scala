package chapter14.tests

import chapter10.puttingitalltogether._
import chapter10.puttingitalltogether.Element._
import org.junit.runner.RunWith
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

@RunWith(classOf[JUnitRunner])
class ElementTest extends FunSuite {

  test("interesting test") {
    val errorMessage = intercept[IllegalArgumentException] {
      elem('x', 2, 3)
    }.getMessage()
    
    println("Error message: " + errorMessage);
  }

}
package programming.in.scala.chapter14

import programming.in.scala.chapter10.puttingitalltogether._
import programming.in.scala.chapter10.puttingitalltogether.Element._
import org.junit.runner.RunWith
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ElementTest extends FunSuite {

  test("interesting test") {
    val errorMessage = intercept[IllegalArgumentException] {
      elem('x', -2, 3)
    }.getMessage()
    
    println("Error message: " + errorMessage);
  }

}
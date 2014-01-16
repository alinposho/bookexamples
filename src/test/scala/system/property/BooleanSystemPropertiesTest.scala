package system.property

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class BooleanSystemPropertiesTest extends FunSuite {
	
  test("Boolean.getBoolean() should return false for a non existing property") {
    assert(false === java.lang.Boolean.getBoolean("non existing system property"))
  } 
  
}
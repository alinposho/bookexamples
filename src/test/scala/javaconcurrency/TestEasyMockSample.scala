package javaconcurrency

import org.scalatest.junit.JUnitSuite
import org.junit.Test
import org.scalatest.mock.EasyMockSugar

class TestEasyMockSample extends JUnitSuite with EasyMockSugar {
  
  @Test
  def test(): Unit = {
    val v = mock[JavaBlah]
    val subclass = mock[JavaBlahSubclass]
    
    val value = new java.util.ArrayList[Object]() 
    expecting(subclass.getList().andReturn(value))
    // The following line will not compile
    // expecting(v.getList().andReturn(value))
    
  }

}
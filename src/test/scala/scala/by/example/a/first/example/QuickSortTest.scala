package scala.by.example.a.first.example

import org.junit.runner.RunWith
import akka.testkit.ImplicitSender
import org.scalatest.BeforeAndAfterAll
import org.scalatest.matchers.MustMatchers
import org.scalatest.WordSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class QuickSortTest extends WordSpec
					  with MustMatchers
					  with BeforeAndAfterAll {
	
  import QuickSort._
  
  "QuickSort" should {
    "sort an array of random elements" in {
      val randomArray = Array(9, 1, -4, 4, 5, -8)
      
      sort(randomArray);
      
      assert(isSorted(randomArray.toList) === true)
    }
  }
  
  def isSorted(list: List[Int]): Boolean = {
    list match {
      case Nil => true
      case x::Nil => true
      case x::y::xs => 
        if(x > y) false
        else 
          isSorted(y::xs)
    }
  }
  
}
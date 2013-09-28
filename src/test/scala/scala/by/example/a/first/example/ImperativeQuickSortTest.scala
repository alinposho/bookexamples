package scala.by.example.a.first.example

import org.junit.runner.RunWith
import akka.testkit.ImplicitSender
import org.scalatest.BeforeAndAfterAll
import org.scalatest.matchers.MustMatchers
import org.scalatest.WordSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ImperativeQuickSortTest extends WordSpec
  with MustMatchers
  with BeforeAndAfterAll {

  import ImperativeQuickSort._

  "QuickSort" should {

    "put all the elements of the initial array in the result" in {
      val randomArray = Array(9, 1, -4, 7)

      sort(randomArray);
      
      assert(randomArray === Array(-4, 1, 7, 9))
    }

    "sort an array of elements in ascending order" in {
      val randomArray = Array(9, 1, -4, 4, 5, -8)

      sort(randomArray);

      assert(isSorted(randomArray.toList) === true, "The array is not sorted")
    }

    "not raise an exception for an array of one element" in {
      sort(Array(1))
    }

    "raise an IndexOutOfBoundsException for an empty array" in {
      intercept[IndexOutOfBoundsException] {
        sort(Array[Int]())
      }
    }
  }

  def isSorted(list: List[Int]): Boolean = {
    list match {
      case Nil => true
      case x :: Nil => true
      case x :: y :: xs =>
        if (x > y) false
        else
          isSorted(y :: xs)
    }
  }

}
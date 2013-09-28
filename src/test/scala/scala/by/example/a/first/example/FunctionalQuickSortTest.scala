package scala.by.example.a.first.example

import org.junit.runner.RunWith
import org.scalatest.BeforeAndAfterAll
import org.scalatest.WordSpec
import org.scalatest.matchers.MustMatchers
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class FunctionalQuickSortTest extends WordSpec
  with MustMatchers
  with BeforeAndAfterAll {

  import FunctionalQuickSort._

  "QuickSort" should {
    "not change the input array" in {
      val randomArray = Array(9, 1, -4, 4, 5, -8)

      val result = sort(randomArray);

      assert(result != randomArray)
    }

    "sort an array of random elements" in {
      val randomArray = Array(9, 1, -4, 4, 5, -8)

      val result = sort(randomArray);

      assert(result === Array(-8, -4, 1, 4, 5, 9))
    }

    "not raise an exception for an array of one element" in {
      sort(Array(1))
    }

    "not raise an exception for an empty array" in {
      sort(Array[Int]())
    }
  }

}
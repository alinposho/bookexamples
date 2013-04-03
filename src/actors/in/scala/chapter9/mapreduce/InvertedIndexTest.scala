package actors.in.scala.chapter9.mapreduce

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import scala.actors.Future

@RunWith(classOf[JUnitRunner])
class InvertedIndexTest extends FunSuite {

  test("InvertedInxed with empty input should not raise exception") {
    InvertedIndex.start
    val result = InvertedIndex !! InvertedIndexInput(List()) 
    assert(result().isInstanceOf[List[Any]])
  }
  
}
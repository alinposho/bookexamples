package actors.in.scala.chapter9.mapreduce

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import scala.actors.Future

@RunWith(classOf[JUnitRunner])
class InvertedIndexTest extends FunSuite {

  test("InvertedInxed with two elements in the input list") {
    // Prepare
    InvertedIndex.start
    val input = List(("file1", List("word1", "word1", "word3")),
      ("file2", List("word4", "word2", "word3")))

    // Exercise
    val result = InvertedIndex !! InvertedIndexInput(input)

    // Verify
    result() match {
      case wordFilesMap: Map[String, List[String]] =>
        val expectedResult = Map("word1" -> List("file1"), "word2" -> List("file2"), "word3" -> List("file1", "file2"),
          "word4" -> List("file2"))

        assert(expectedResult === wordFilesMap)
    }
  }

  test("InvertedInxed with one element list as input") {
    // Prepare
    InvertedIndex.start
    val input = List(("file", List("word1", "word1", "word3")))

    // Exercise
    val result = InvertedIndex !! InvertedIndexInput(input)

    // Verify
    result() match {
      case wordFilesMap: Map[String, List[String]] =>
        val expectedResult = Map("word1" -> List("file"), "word3" -> List("file"))

        assert(expectedResult === wordFilesMap)
    }
  }

  test("InvertedInxed with empty input should not raise exception") {
    InvertedIndex.start
    val result = InvertedIndex !! InvertedIndexInput(List())
    assert(result().isInstanceOf[List[Any]])
  }

}
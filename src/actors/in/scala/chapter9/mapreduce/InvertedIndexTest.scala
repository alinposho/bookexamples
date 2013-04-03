package actors.in.scala.chapter9.mapreduce

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import scala.actors.Future
import scala.actors.Actor.actor

@RunWith(classOf[JUnitRunner])
class InvertedIndexTest extends FunSuite {

  test("InvertedInxed with empty input should not raise exception") {
    // Prepare
    val invertedIndex = createAndStartMasterActor()
    // Exercise
    val result = invertedIndex !! InvertedIndexInput(List())
    // Verify
    result match {
      case result: Map[String, List[String]] => assert(result.isEmpty)
    }
  }

  test("InvertedInxed with two elements in the input list") {

    // Prepare
    val input = List(("file1", List("word1", "word1", "word3")),
      ("file2", List("word4", "word2", "word3")))
    val expectedResult = Map("word1" -> List("file1"), "word2" -> List("file2"), "word3" -> List("file1", "file2"),
      "word4" -> List("file2"))

    // Execute and Verify
    runTestWith(input, expectedResult)
  }

  test("InvertedInxed with one element list as input") {
    // Prepare
    val input = List(("file", List("word1", "word1", "word3")))
    val expectedResult = Map("word1" -> List("file"), "word3" -> List("file"))

    // Execute and Verify
    runTestWith(input, expectedResult)
  }

  private def runTestWith(input: List[(String, List[String])], expectedResult: Map[String, List[String]]) {
    // Prepare
    val invertedIndex = createAndStartMasterActor

    // Exercise
    val result = invertedIndex !! InvertedIndexInput(input)

    // Verify
    result() match {
      case wordFilesMapping: Map[String, List[String]] => {
        assert(expectedResult.size === wordFilesMapping.size)
        
        for((word, files) <- wordFilesMapping) {
          assert(expectedResult(word).size === files.size)
          files.foreach(assert(expectedResult(word).contains(_)))
        }
      }
    }
  }

  private def createAndStartMasterActor(): InvertedIndex = {
    val invertedIndex = new InvertedIndex()
    invertedIndex.start
    invertedIndex
  }

}
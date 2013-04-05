package actors.in.scala.chapter9.mapreduce.generic

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import scala.actors.Future
import scala.actors.Actor.actor
import actors.in.scala.chapter9.mapreduce.common.InvertedIndexInput

@RunWith(classOf[JUnitRunner])
class InvertedIndexGenericTest extends FunSuite {

  test("InvertedInxed with empty input should not raise exception") {
    // Prepare
    val invertedIndex = createAndStartMasterActor()
    // Exercise
    val result = invertedIndex !! InvertedIndexInput(List())
    // Verify
    result() match {
      case emptyMap: Map[_, _] => assert(emptyMap.isEmpty)
    }
  }

  test("InvertedInxed with one element list as input") {
    // Prepare
    val input = List(("file", List("word1", "word1", "word3")))
    val expectedResult = Map("word1" -> List("file"), "word3" -> List("file"))

    // Execute and Verify
    runTestWith(input, expectedResult)
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

  private def runTestWith(input: List[(String, List[String])], expectedResult: Map[String, List[String]]) {
    // Prepare
    val invertedIndex = createAndStartMasterActor
    // Exercise
    val result = invertedIndex !! InvertedIndexInput(input)
    // Verify
    result() match {
      case wordFilesMapping: Map[_, _] => {
        assert(expectedResult.size === wordFilesMapping.size)
        assertWordToFilesAssociationMatchIgnoringOrdering(expectedResult, wordFilesMapping)
      }
    }
  }

  private def createAndStartMasterActor(): InvertedIndexGeneric = {
    val invertedIndex = new InvertedIndexGeneric()
    invertedIndex.start
    invertedIndex
  }
  
  private def assertWordToFilesAssociationMatchIgnoringOrdering(expectedResult: Map[String,List[String]], wordFilesMapping: Map[_,_]): Unit = {
    for ((word, files) <- wordFilesMapping) {
      val wordAsString = word.asInstanceOf[String]
      val listOfFiles = files.asInstanceOf[List[String]]
      assert(expectedResult(wordAsString).size === listOfFiles.size)
      assert(expectedResult(wordAsString).forall(listOfFiles.contains(_)),
        files + "!=" + expectedResult(wordAsString))
    }
  }

}
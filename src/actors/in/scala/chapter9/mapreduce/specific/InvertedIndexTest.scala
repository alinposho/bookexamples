package actors.in.scala.chapter9.mapreduce.specific

import scala.actors.Actor
import org.junit.runner.RunWith
import actors.in.scala.chapter9.mapreduce.common.tests.AbstractInvertedIndexTest
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class InvertedIndexTest extends AbstractInvertedIndexTest {

  protected override def createAndStartMasterActor(): Actor = {
    val invertedIndex = new InvertedIndex()
    invertedIndex.start
    invertedIndex
  }

}
package actors.in.scala.chapter9.mapreduce.mapper.fault.tolerant

import actors.in.scala.chapter9.mapreduce.common.tests.AbstractInvertedIndexTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import scala.actors.Actor

@RunWith(classOf[JUnitRunner])
class InvertedIndexParallelReduceTest extends AbstractInvertedIndexTest {

  protected override def createAndStartMasterActor(): Actor = {
    val invertedIndex = new InvertedIndexFaultTolerant()
    invertedIndex.start
    invertedIndex
  }

}
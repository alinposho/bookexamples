package actors.in.scala.chapter9.mapreduce.parallel.reduce

import scala.actors.Actor
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import actors.in.scala.chapter9.mapreduce.common.AbstractInvertedIndexTest
import actors.in.scala.chapter9.mapreduce.generic.InvertedIndexGeneric

@RunWith(classOf[JUnitRunner])
class InvertedIndexParallelReduceTest extends AbstractInvertedIndexTest {

  protected override def createAndStartMasterActor(): Actor = {
    val invertedIndex = new InvertedIndexGeneric()
    invertedIndex.setMapReduceStrategy(new ParallelReduce(invertedIndex))
    invertedIndex.start
    invertedIndex
  }
}
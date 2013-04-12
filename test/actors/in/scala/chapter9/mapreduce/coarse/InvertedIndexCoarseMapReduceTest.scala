package actors.in.scala.chapter9.mapreduce.coarse

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import actors.in.scala.chapter9.mapreduce.common.AbstractInvertedIndexTest
import actors.in.scala.chapter9.mapreduce.generic.InvertedIndexGeneric
import scala.actors.Actor
import actors.in.scala.chapter9.mapreduce.parallel.reduce.ParallelReduce

@RunWith(classOf[JUnitRunner])
class InvertedIndexCoarseMapReduceTest extends AbstractInvertedIndexTest {

  protected override def createAndStartMasterActor(): Actor = {
    val invertedIndex = new InvertedIndexGeneric()
    invertedIndex.setMapReduceStrategy(new CoarseMapReduce(invertedIndex, 2, 2))
    invertedIndex.start
    invertedIndex
  }  
  
}
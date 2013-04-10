package actors.in.scala.chapter9.mapreduce.mapper.fault.tolerant

import actors.in.scala.chapter9.mapreduce.common.tests.AbstractInvertedIndexTest
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import scala.actors.Actor
import actors.in.scala.chapter9.mapreduce.generic.InvertedIndexGeneric

@RunWith(classOf[JUnitRunner])
class InvertedIndexCrashingMapperMapReduceTest extends AbstractInvertedIndexTest {

  protected override def createAndStartMasterActor(): Actor = {
    val invertedIndex = new InvertedIndexGeneric()
    invertedIndex.setMapReduceStrategy(new CrashingMapperMapReduce(invertedIndex))
    invertedIndex.start
    invertedIndex
  }

}
package actors.in.scala.chapter9.mapreduce.mapper.fault.tolerant

import actors.in.scala.chapter9.mapreduce.generic.InvertedIndexGeneric

class InvertedIndexFaultTolerant extends InvertedIndexGeneric{
  override val mapReduceStrategy = new MapReduceFaultTolerant(this)
}
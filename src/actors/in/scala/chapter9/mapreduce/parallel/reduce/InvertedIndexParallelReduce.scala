package actors.in.scala.chapter9.mapreduce.parallel.reduce

import actors.in.scala.chapter9.mapreduce.generic.InvertedIndexGeneric

class InvertedIndexParallelReduce extends InvertedIndexGeneric {
  override val mapReduceStrategy = new ParallelReduce(this)
}
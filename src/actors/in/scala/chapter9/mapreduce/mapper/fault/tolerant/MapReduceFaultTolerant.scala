package actors.in.scala.chapter9.mapreduce.mapper.fault.tolerant

import scala.actors.Actor
import scala.actors.Actor._
import actors.in.scala.chapter9.mapreduce.parallel.reduce.ParallelReduce
import scala.actors.Exit
import scala.actors.AbstractActor

class MapReduceFaultTolerant[K, V](master: Actor) extends ParallelReduce(master) {

  override def mapReduceBasic[K, V, K2, V2](input: List[(K, V)],
    mapping: (K, V) => List[(K2, V2)],
    reducing: (K2, List[V2]) => List[V2]): Map[K2, List[V2]] = {
    
    self.trapExit = true
    val mappers = runMappingOnWorkerActors(input, mapping)
    val intermediateResults = collectIntermediateResults[K, V, K2, V2](mappers)
    val dict = groupIntermediatesByKeys(intermediateResults)
    reduce(reducing, dict)
  }
  
  protected def collectIntermediateResults[K, V, K2, V2](workers: Map[AbstractActor, (K, V)],
       mapping: (K, V) => List[(K2, V2)]): List[(K2, V2)] = {
    var intermediateResults = List[(K2, V2)]()
    var nLeft = workers.size

    while (nLeft > 0) {
      receive {
        case Intermediate(list) => intermediateResults = list.asInstanceOf[List[(K2, V2)]] ++ intermediateResults
        case Exit(from, 'normal) => nLeft -= 1
        case Exit(from, reason) =>
          val (key, value) = workers(from)
          spawnMapper(key, value, mapping)
      }
    }
    intermediateResults
  }

}
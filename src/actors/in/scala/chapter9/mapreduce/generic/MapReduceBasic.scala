package actors.in.scala.chapter9.mapreduce.generic

import scala.actors.Actor
import scala.actors.Actor._

class MapReduceBasic(master: Actor) {

  def mapReduceBasic[K, V, K2, V2](input: List[(K, V)],
    mapping: (K, V) => List[(K2, V2)],
    reducing: (K2, List[V2]) => List[V2]): Map[K2, List[V2]] = {

    val workers = runMappingOnWorkerActor(input, mapping)
    val intermediateResults = collectIntermediateResults[K2, V2](workers)
    val dict = groupIntermediatesByKeys(intermediateResults)
    reduce(reducing, dict)
  }

  case class Intermediate[K2, V2](list: List[(K2, V2)])
  
  def runMappingOnWorkerActor[K, V, K2, V2](input: List[(K, V)], mapping: (K, V) => List[(K2, V2)]): List[Actor] = {
    val workers = for ((key, value) <- input) yield {
      actor {
        master ! Intermediate(mapping(key, value))
      }
    }
    workers
  }

  private def collectIntermediateResults[K2, V2](workers: List[Actor]): List[(K2, V2)] = {
    var intermediateResults = List[(K2, V2)]()
    for (worker <- workers) {
      receive {
        case Intermediate(list) => intermediateResults = list.asInstanceOf[List[(K2, V2)]] ++ intermediateResults
      }
    }
    intermediateResults
  }

  private def groupIntermediatesByKeys[K2, V2](intermediateResults: List[(K2, V2)]): scala.collection.immutable.Map[K2, List[V2]] = {
    var dict = Map[K2, List[V2]]() withDefault (k => List())
    for ((key, value) <- intermediateResults)
      dict += (key -> (value :: dict(key)))
    dict
  }

  private def reduce[K2, V2](reducing: (K2, List[V2]) => List[V2], dict: Map[K2, List[V2]]): Map[K2, List[V2]] = {
    var result = Map[K2, List[V2]]()
    for ((key, value) <- dict)
      result += (key -> reducing(key, value))
    result
  }

}

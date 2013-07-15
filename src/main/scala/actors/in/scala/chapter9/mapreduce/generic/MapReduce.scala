package actors.in.scala.chapter9.mapreduce.generic

import scala.actors.Actor
import scala.actors.Actor._
import scala.actors.AbstractActor

class MapReduce(master: Actor) {

  def mapReduce[K, V, K2, V2](input: List[(K, V)], 
		  							mapping: (K, V) => List[(K2, V2)], 
		  							reducing: (K2, List[V2]) => List[V2]): Map[K2, List[V2]] = {

    val mappers = runMappingOnWorkerActors(input, mapping)
    val intermediateResults = collectIntermediateResults[K, V, K2, V2](mappers)
    val dict = groupIntermediatesByKeys(intermediateResults)
    reduce(reducing, dict)
  }

  case class Intermediate[K2, V2](list: List[(K2, V2)])

  protected def runMappingOnWorkerActors[K, V, K2, V2](input: List[(K, V)], mapping: (K, V) => List[(K2, V2)]): Map[AbstractActor, (K, V)] = {
    val mappers = for ((key, value) <- input) yield {
      spawnMapper(key, value, mapping)
    }
    mappers.toMap
  }

  protected def spawnMapper[K, V, K2, V2](key: K, value: V, mapping: (K, V) => List[(K2, V2)]): (Actor, (K, V)) = {
    // Using "link" instead of "actor" assures that the child actors are linked to the master
    // otherwise, the master will not receive termination messages from child actors
    val mapper = link {
      master ! Intermediate(mapping(key, value))
    }
    (mapper, (key, value))
  }

  protected def collectIntermediateResults[K, V, K2, V2](workers: Map[AbstractActor, (K, V)]): List[(K2, V2)] = {
    var intermediateResults = List[(K2, V2)]()
    for (worker <- workers) {
      receive {
        case Intermediate(list) => intermediateResults = list.asInstanceOf[List[(K2, V2)]] ++ intermediateResults
      }
    }
    intermediateResults
  }

  protected def groupIntermediatesByKeys[K2, V2](intermediateResults: List[(K2, V2)]): Map[K2, List[V2]] = {
    var dict = Map[K2, List[V2]]() withDefault (k => List())
    for ((key, value) <- intermediateResults)
      dict += (key -> (value :: dict(key)))
    dict
  }

  protected def reduce[K2, V2](reducing: (K2, List[V2]) => List[V2], dict: Map[K2, List[V2]]): Map[K2, List[V2]] = {
    var result = Map[K2, List[V2]]()
    for ((key, value) <- dict)
      result += (key -> reducing(key, value))
    result
  }

}

package actors.in.scala.chapter9.mapreduce.coarse

import scala.actors.AbstractActor
import scala.actors.Actor
import scala.actors.Actor.actor
import scala.actors.Actor.link
import scala.actors.Actor.receive
import scala.actors.Actor.self
import scala.actors.Exit

import actors.in.scala.chapter9.mapreduce.parallel.reduce.ParallelReduce
import actors.in.scala.chapter9.mapreduce.parallel.reduce.Reduced

class CoarseMapReduce(master: Actor, val numOfMappers: Int, val numOfReducers: Int)
  extends ParallelReduce(master) {

  override def mapReduce[K, V, K2, V2](input: List[(K, V)],
		  								mapping: (K, V) => List[(K2, V2)],
		  								reducing: (K2, List[V2]) => List[V2]): Map[K2, List[V2]] = {
    self.trapExit = true
    val mappers = runCoarseMappingOnWorkerActors(input, mapping)
    val intermediateResults = collectIntermediateResults[K, V, K2, V2](mappers, mapping)
    val dict = groupIntermediatesByKeys(intermediateResults)
    reduce(reducing, dict)
  }

  private def runCoarseMappingOnWorkerActors[K, V, K2, V2](input: List[(K, V)],
    mapping: (K, V) => List[(K2, V2)]): Map[AbstractActor, List[(K, V)]] = {
    val groupCount = computeGroupCount(input.size, numOfMappers)
    val mappers = for (group <- input.grouped(groupCount)) yield {
      spawnMapper(group, mapping)
    }
    mappers.toMap
  }

  private def computeGroupCount(inputLength: Int, elementsPerGroup: Int): Int = {
    if (inputLength / elementsPerGroup > 0) {
      inputLength / elementsPerGroup
    } else {
      1
    }
  }

  private def spawnMapper[K, V, K2, V2](group: List[(K, V)], mapping: (K, V) => List[(K2, V2)]): (Actor, List[(K, V)]) = {
    val mapper = link {
      for ((key, value) <- group)
        master ! Intermediate(mapping(key, value))
    }
    (mapper, group)
  }

  private def collectIntermediateResults[K, V, K2, V2](workers: Map[AbstractActor, List[(K, V)]],
    mapping: (K, V) => List[(K2, V2)]): List[(K2, V2)] = {
    var intermediateResults = List[(K2, V2)]()
    var nLeft = workers.size

    while (nLeft > 0) {
      receive {
        case Intermediate(list) => intermediateResults = list.asInstanceOf[List[(K2, V2)]] ++ intermediateResults
        case Exit(from, 'normal) => nLeft -= 1
        case Exit(from, reason) =>
          val group = workers(from)
          println("Mapper for group " + group + " crashed!");
          println("Restarting mapper.");
          spawnMapper(group, mapping)
      }
    }
    intermediateResults
  }

  private def createAndRunReducers[K2, V2](reducing: (K2, List[V2]) => List[V2], dict: Map[K2, List[V2]]): Iterable[Actor] = {
    val groupCount = computeGroupCount(dict.size, numOfMappers)
    val reducers = for (group <- dict.grouped(groupCount)) yield {
      val reducer = actor {
        for ((key, values) <- dict) yield {
          master ! Reduced(key, reducing(key, values))
        }
      }
      reducer
    }
    reducers.toIterable
  }

}
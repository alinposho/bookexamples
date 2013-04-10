package actors.in.scala.chapter9.mapreduce.parallel.reduce

import actors.in.scala.chapter9.mapreduce.generic.MapReduce
import scala.actors.Actor
import scala.actors.Actor.actor
import scala.actors.Actor.receive

class ParallelReduce(master: Actor) extends MapReduce(master) {

  protected override def reduce[K2, V2](reducing: (K2, List[V2]) => List[V2], dict: Map[K2, List[V2]]): Map[K2, List[V2]] = {

    val reducers = createAndRunReducers(reducing, dict)
    val result:Map[K2, List[V2]] = assembleReduceResult(reducers)
    result
  }

  private def createAndRunReducers[K2, V2](reducing: (K2, List[V2]) => List[V2], dict: Map[K2, List[V2]]): Iterable[Actor] = {
    val reducers = for ((key, values) <- dict) yield {
      actor {
        master ! Reduced(key, reducing(key, values))
      }
    }
    reducers
  }
  
  private def assembleReduceResult[K2, V2](reducers: Iterable[Actor]): Map[K2,List[V2]] = {
    var result = Map[K2, List[V2]]()
    for (reducer <- reducers) {
      receive {
        case Reduced(key,values: List[_]) => 
          val keyCast = key.asInstanceOf[K2] 
          val valuesCast = values.asInstanceOf[List[V2]]
          result += (keyCast-> valuesCast)
      }
    }
    result
  }
}

case class Reduced[K2, V2](key: K2, values: List[V2])
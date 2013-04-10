package actors.in.scala.chapter9.mapreduce.mapper.fault.tolerant

import scala.actors.Actor
import scala.actors.Actor._
import actors.in.scala.chapter9.mapreduce.parallel.reduce.ParallelReduce
import scala.actors.Exit
import scala.actors.AbstractActor

class CrashingMapperMapReduce[K, V](master: Actor) extends FaultTolerantMapReduce(master) {

  var counter = 0;

  protected override def spawnMapper[K, V, K2, V2](key: K, value: V, mapping: (K, V) => List[(K2, V2)]): (Actor, (K, V)) = {
    val mapper = actor {
      counter += 1
      if (counter % 2 == 0) {
        println("Mapper for key " + key + " value " + value + " will crash!");
        throw new Exception("Error!")
      } else {
        master ! Intermediate(mapping(key, value))
      }
    }
    (mapper, (key, value))
  }

}
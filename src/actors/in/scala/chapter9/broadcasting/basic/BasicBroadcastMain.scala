package actors.in.scala.chapter9.broadcasting.basic

import scala.actors.Actor
import actors.in.scala.chapter9.broadcasting.common.Broadcast

object BasicBroadcastMain {

  def main(args: Array[String]) {
    val a1 = new MyActor;
    a1.start()
    val a2 = new MyActor;
    a2.start()
    val a3 = new MyActor;
    a3.start()
    val a4 = new MyActor;
    a4.start()

    val actors: Set[Actor] = Set(a1, a2, a3, a4)
    // We need to wait for the message to arrive at the destination and for the response, otherwise, the actors will 
    // not have enough time to do their work and nothing will be printed at the output.
    a1 !? Broadcast("Hello!", actors)

    a1.isBroken = true
    a1 !? Broadcast("Hello again!", Set(a1, a2, a3, a4)) 

    stopActors(actors)
  }

  private def stopActors(actors: Set[scala.actors.Actor]): Unit = {
    for (a <- actors) {
      a ! 'stop
    }
  }

}
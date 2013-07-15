package actors.in.scala.chapter5

import scala.actors.Actor
import scala.actors.Actor._

object ChaningActors {

  def buildActorChain(size: Int, next: Actor): Actor = {
    val a = actor {
      react {
        case 'Die =>
          val from = sender
          if (next != null) {
            next ! 'Die
            react {
              case 'Ack => from ! 'Ack
            }
          } else from ! 'Ack
      }
    }
    if (size > 0) buildActorChain(size - 1, a)
    else a
  }

  def main(args: Array[String]) {

    val firstActor = buildActorChain(2, null);

    // Sending the 'Die message to the actor chain - This will terminate all actors
    // since they are not waiting in an infinite while loop.
    firstActor !? 'Die match {
      case 'Ack => println("Killed the actors from the chain!")
    }

    // This will cause the program to run indefinitely. Why is that? Well, there are no actors 
    // to sent a response message back, and the main thread is waiting for a response since we 
    // used !?
    /*firstActor !? 'Die match {
      case 'Ack => println("Killed the last actor in the chain!")
    }*/
  }

}
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

    // Sending the 'Die message to the actor chain
    firstActor !? 'Die match {
      case 'Ack => println("Killed the last actor in the chain!")
    }
  }

}
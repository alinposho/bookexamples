package actors.in.scala.chapter5

import scala.actors.Actor
import scala.actors.Actor._

object LoopWhileEventBasedActorChaining {

  def buildChain(size: Int, next: Actor, lives: Int): Actor = {
    val a = actor {
      var n = lives
      loopWhile(n > 0) {
        n -=
          1
        react {
          case 'Die =>
            val from = sender
            if (next != null) {
              next ! 'Die
              react { case 'Ack => from ! 'Ack }
            } else from ! 'Ack
        }
      }
    }
    if (size > 0) buildChain(size - 1,
      a, lives)
    else a
  }

  def main(args: Array[String]) {
    val numActors = 3
    val start = System.currentTimeMillis
    val firstActor = buildChain(numActors, null, 2)

    firstActor ! 'Die
    receive {
      case 'Ack =>
        val end = System.currentTimeMillis
        println("Took " + (end - start)
          + " ms")
    }

    println("The actor chain is still waiting for another 'Die message");

    // Commenting this line will cause the program to loop indefinitely waiting 
    // for the actor chain to terminate
    firstActor !? 'Die

    println("Program exit!")
  }
}
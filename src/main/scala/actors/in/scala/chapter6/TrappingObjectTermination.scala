package actors.in.scala.chapter6

import scala.actors.Actor._
import scala.actors.Exit
import scala.actors.UncaughtException

object TrappingObjectTermination {

  def main(args: Array[String]) {

    val a = actor {
      react {
        case 'start =>
          // Changing this variable will cause the actor to end normally
          val somethingBadHappened = true
          if (somethingBadHappened)
            throw new Exception("Error!")
          println("Nothing bad happened")
      }
    }

    val b = actor {
      self.trapExit = true
      self.link(a)

      a ! 'start

      react {
        case Exit(from, UncaughtException(_, _, _, _, cause)) if from == a =>
          println("Actor a terminated with exception because of " + cause)

        case Exit(from, reason) if from == a =>
          println("Actor a terminated because of " + reason)
      }
    }

  }

}
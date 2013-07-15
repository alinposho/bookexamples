package actors.in.scala.chapter6

import scala.actors.Actor._
import scala.actors.Actor
import scala.actors.Exit

object RestartingCrashedActors {

  def keepAlive(patient: Actor): Nothing = {
    react {
      case Exit(from, reason) if from == patient =>
        if (reason != 'normal) {
          link(patient)
          patient.restart()
          keepAlive(patient)
        }
    }
  }

  def main(args: Array[String]) {
    
    val crasher = actor {
      println("I'm (re) born")
      var cnt = 0
      loop {
        cnt += 1
        react {
          case 'request =>
            println("I try to service a request")
            if (cnt % 2 == 0) {
              println("sometimes I crash...")
              throw new Exception
            }
          case 'stop =>
            println("I'm exiting")
            exit()
        }
      }
    }
    
    val client = actor {
      react {
        case 'start =>
          for (_ <- 1 to 6) { crasher ! 'request }
          crasher ! 'stop
      }
    }
    
    actor {
      self.trapExit = true
      link(crasher)
      client ! 'start
      keepAlive(crasher)
    }
  }
}
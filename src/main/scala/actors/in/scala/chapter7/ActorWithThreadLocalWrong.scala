package actors.in.scala.chapter7

import scala.actors.Actor.actor
import scala.actors.Actor.react
import scala.actors.Actor.sender

/**
 * Executing this program a number of times will cause it to print "John Doe"
 * then "john" for a limited number of times.
 */
object ActorWithThreadLocalWrong extends App {

  val tname = new ThreadLocal[String] {
    override protected def initialValue() = "john"
  }

  val joeActor = actor {
    react {
      case 'YourName =>
        tname set "John Doe"
        sender ! tname.get
        react {
          case 'YourName =>
            sender ! tname.get
        }
    }
  }
  
  actor {
    println("your name " + (joeActor !? 'YourName))
    println("your name " + (joeActor !? 'YourName))
  }

}
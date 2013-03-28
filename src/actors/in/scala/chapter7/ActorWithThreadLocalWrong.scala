package actors.in.scala.chapter7

import scala.actors.Actor.actor
import scala.actors.Actor.react
import scala.actors.Actor.sender

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
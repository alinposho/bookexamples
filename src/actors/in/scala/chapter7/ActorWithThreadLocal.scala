package actors.in.scala.chapter7

import scala.actors.Actor
import scala.actors.Actor.actor
import scala.actors.SchedulerAdapter

object ActorWithThreadLocal extends Actor {

  val tname = new ThreadLocal[String] {
    override def initialValue() = "john"
  }

  var name = "Initial"

  override val scheduler = new SchedulerAdapter {
    def execute(codeBlock: => Unit) = {
      tname set name
      codeBlock
      name = tname.get
    }
  }

  override def act() {
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

}

object Main {
  def main(args: Array[String]) {

    val joeActor = ActorWithThreadLocal
    joeActor.start

    actor {
      println("your name " + (joeActor !? 'YourName))
      println("your name " + (joeActor !? 'YourName))
    }
  }
}
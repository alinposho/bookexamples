package actors.in.scala.chapter10.akka

import akka.actor.{ Actor, ActorRef }
import Actor._
import scala.concurrent.Channel

class ChainActor(next: Option[ActorRef]) extends Actor {

  private var from: ActorRef = null

  override def receive = {
    case 'Die =>
      println(this + " received 'Die from " + sender)
      from = sender
      if (next.isEmpty) {
        from ! 'Ack
      } else {
        println(this + " sending 'Die to " + next.get)
        next.get ! 'Die
      }
    case 'Ack =>
      println(this + " received 'Ack from " + sender)
      from ! 'Ack
  }

}
package actors.in.scala.chapter10.akka

import akka.actor.{ Actor, ActorRef }
import Actor._
import scala.concurrent.Channel

class ChainActor(next: Option[ActorRef]) extends Actor {

  private var from: ActorRef = null

  override def receive = {
    case 'Die =>
      if (next.isEmpty) {
        from = sender
        from ! 'Ack
        exit
      } else {
        next.get ! 'Die
      }
    case 'Ack =>
      from ! 'Ack
      exit()
  }

}
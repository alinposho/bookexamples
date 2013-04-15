package actors.in.scala.chapter9.broadcasting

import scala.actors.Actor

abstract class BroadcastActor extends Actor {

  @volatile var isBroken = false
  private var canRun = true;
  private var counter = 0L

  protected def broadcast(message: BSend) = {
    if (!isBroken) {
      for (recipient <- message.recipients) {
        recipient ! BDeliver(message.data)
      }
      reply()
    } else if (canRun) {
      canRun = false
      for (recipient <- message.recipients.take(2)) {
        recipient ! BDeliver(message.data)
      }
      println("Error at " + this)
      reply()
    }
  }

  
  protected def reaction: PartialFunction[Any, Unit] = {
    case Broadcast(msg, recipients) => 
      counter += 1 
      broadcast(BSend(msg, recipients, counter))
    case 'stop => 
      exit()
  }
  
  def act() = loopWhile(canRun) { react(reaction) }
}

case class BSend(data: Any, recipients: Set[Actor], timestamp: Long)
case class BDeliver(data: Any)
case class Broadcast(msg: Any, recipients: Set[Actor])
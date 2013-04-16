package actors.in.scala.chapter9.broadcasting.reliable

import actors.in.scala.chapter9.broadcasting.common.BroadcastActor
import actors.in.scala.chapter9.broadcasting.common.BSend
import actors.in.scala.chapter9.broadcasting.common.BDeliver

class ReliableBroadcastActor extends BroadcastActor {

  var delivered = Set[BSend]()

  override def reaction = super.reaction orElse {
    case msg @ BSend(data, _, _) =>
      if (!delivered.contains(msg)) {
        delivered += msg
        broadcast(msg)
        this ! BDeliver(data)
      }
  }

  override def broadcast(msg: BSend) = {
    if (!isBroken) {
      for (recipient <- msg.recipients) recipient ! msg
    } else if (canRun) {
      for (a <- msg.recipients.take(2)) a ! msg
      println("error at " + this)
    }
    reply()
  }
}
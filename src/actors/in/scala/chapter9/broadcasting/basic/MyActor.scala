package actors.in.scala.chapter9.broadcasting.basic

import actors.in.scala.chapter9.broadcasting.common.BroadcastActor

import actors.in.scala.chapter9.broadcasting.common.BDeliver

class MyActor extends BroadcastActor {
  override def reaction = super.reaction orElse {
    case BDeliver(data) =>
      println("Received broadcast message: " +
        data + " at " + this)
  }
}
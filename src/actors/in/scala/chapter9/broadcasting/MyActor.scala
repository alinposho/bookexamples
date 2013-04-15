package actors.in.scala.chapter9.broadcasting

class MyActor extends BroadcastActor {
  override def reaction = super.reaction orElse {
    case BDeliver(data) =>
      println("Received broadcast message: " +
        data + " at " + this)
  }
}
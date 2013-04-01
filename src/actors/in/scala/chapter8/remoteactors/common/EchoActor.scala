package actors.in.scala.chapter8.remoteactors.common

import scala.actors.Actor
import scala.actors.remote.RemoteActor.{ register, alive}
import scala.actors.scheduler.DaemonScheduler

class EchoActor extends Actor {
  
  override val scheduler = DaemonScheduler

  override def act() {

    alive(Constants.ECHO_ACTOR_PORT)
    register(Constants.ECHO_ACTOR_NAME, this)

    loop {
      react {
        case any =>
          println("Received " + any + ". Echoing it back.")
          reply("Echo " + any)
      }
    }
  }

}
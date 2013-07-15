package actors.in.scala.chapter8.remoteactors.common

import scala.actors.Actor
import scala.actors.remote.RemoteActor.{ register, alive}
import scala.actors.scheduler.DaemonScheduler

class EchoActor extends Actor {
  
  // Making sure that this actor won't keen the application running when 
  // everything else is attempting to shutdown
  override val scheduler = DaemonScheduler

  override def act() {

    alive(Constants.ECHO_ACTOR_PORT)
    register(Constants.ECHO_ACTOR_NAME, this)

    loop {
      react {
        case Stop => 
          println("Received shutdown request!")
          reply()
          exit()
        case any =>
          println("Received " + any + ". Echoing it back.")
          reply("Echo " + any)
      }
    }
  }

}
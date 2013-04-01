package actors.in.scala.chapter8.remoteactors.common

import scala.actors.Actor
import scala.actors.remote.RemoteActor.{register, alive}

class EchoActor extends Actor {
  
  override def act() {
	  
    alive(Constants.PORT)
    register('echo, this)
    
    
    loop {
      react {
        case any =>
          println("Received " + any + ". Echoing it back.")
          reply("Echo" + any)
      }
    }    
  }

}
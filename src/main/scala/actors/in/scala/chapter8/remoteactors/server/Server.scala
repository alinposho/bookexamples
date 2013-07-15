package actors.in.scala.chapter8.remoteactors.server

import scala.actors.Actor
import scala.actors.AbstractActor
import scala.actors.remote.RemoteActor.{ alive, register, classLoader }
import actors.in.scala.chapter8.remoteactors.common.Start
import actors.in.scala.chapter8.remoteactors.common.Stop
import actors.in.scala.chapter8.remoteactors.common.Constants
import scala.actors.remote.RemoteActor

class Server extends Actor {

  override def act() {
    println("Registering server.")
    alive(Constants.SERVER_PORT)
    register(Constants.SERVER_NAME, this)

    println("Server up and running.")
    
    var createdActors = List[Actor]()

    loop {
      react {
        case Start(clazz) => {
          println("Received request to create an " + clazz + " actor instance.")
          createdActors = createAndStartNewActor(clazz) :: createdActors
          println(clazz + " actor instance created.")
          reply()
        }
        case Stop =>
          println("Remote server started " + createdActors.size +
            " actors. Preparing to shutdown")
          shutdownCreatedRunningActors(createdActors)  
          reply()
          exit()
          println("This message shouldn't get printed. Server should have been shut down by now.")
        case any => println("Received message: " + any);
      }
    }

  }
  
  private def shutdownCreatedRunningActors(createdActors: List[Actor]) {
    for(actor <- createdActors; if actor.getState != Actor.State.Terminated) {
      actor ! Stop
    }
  }  

  private def createAndStartNewActor(clazz: Class[_ <: scala.actors.Actor]): scala.actors.Actor = {
    val newActor = clazz.newInstance()
    newActor.start
    newActor
  }

}
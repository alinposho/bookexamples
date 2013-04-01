package actors.in.scala.chapter8.remoteactors.server

import scala.actors.Actor
import scala.actors.remote.RemoteActor.{ alive, register, classLoader }
import actors.in.scala.chapter8.remoteactors.common.Start
import actors.in.scala.chapter8.remoteactors.common.Stop
import actors.in.scala.chapter8.remoteactors.common.Constants
import scala.actors.remote.RemoteActor

class Server extends Actor {

  private var numOfActorsStarted = 0

  override def act() {
    println("Registering server.");
    alive(Constants.SERVER_PORT)
    register(Constants.SERVER_NAME, this)

    println("Server up and running.");

    loop {
      react {
        case Start(clazz) => {
          println("Received request to create an " + clazz + " actor instance.");
          createAndStartNewActor(clazz)
          println(clazz + " actor instance created.");
          numOfActorsStarted += 1
          reply()
        }
        case Stop =>
          println("Remote server started " + numOfActorsStarted +
            " actors. Preparing to shutdown")
          reply()
          exit()
          println("Server should have been shut down by now.")
          System.exit(0)
        case any => println("Received message: " + any);
      }
    }

  }

  private def createAndStartNewActor(clazz: Class[_ <: scala.actors.Actor]): scala.actors.Actor = {
    val newActor = clazz.newInstance()
    newActor.start
  }

}
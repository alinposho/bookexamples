package actors.in.scala.chapter8.remoteactors.client

import scala.actors.remote.RemoteActor.{ select, classLoader }
import scala.actors.remote.Node
import actors.in.scala.chapter8.remoteactors.common.{ Start, Stop, EchoActor, Constants }

object ClientForRemoteActors {

  val SERVER_ADDRESS = "localhost"

  def main(args: Array[String]) {

    println("Starting client");
    
    val server = getReferenceToServer()
    instructServerToCreateEchoActor(server)
    val echo = getReferenceToRemoteEchoActor()
    val resp = sendMessageToRemoteActor(echo, "hello")
    shutdownServer(server)
  }

  private def getReferenceToServer(): scala.actors.AbstractActor = {

    println("Attempting to connect to the remote server actor.");
    val server = select(Node(SERVER_ADDRESS, Constants.SERVER_PORT), Constants.SERVER_NAME)
    println("Connection to the remote server actor established.");
    server
  }

  private def instructServerToCreateEchoActor(server: scala.actors.AbstractActor): Unit = {

    println("Attempting to create a remote EchoActor instance");
    server !? Start(classOf[EchoActor])
    println("EchoActor instance created by remote server");
  }

  private def getReferenceToRemoteEchoActor(): scala.actors.AbstractActor = {

    println("Attempting to connect to the remote echo service");
    val echo = select(Node(SERVER_ADDRESS, Constants.ECHO_ACTOR_PORT), Constants.ECHO_ACTOR_NAME)
    echo
  }

  private def sendMessageToRemoteActor(echo: scala.actors.AbstractActor, message: String): Any = {

    println("Sending \"" + message + "\" message to remote actor");
    val resp = echo !? message
    println("Remote start client received \"" + resp + "\"")
    resp
  }
  
  private def shutdownServer(server: scala.actors.AbstractActor): Unit = {

    println("Sending shutdown request to server.");
    server !? Stop
    println("Server was shutdown.");
  }

}
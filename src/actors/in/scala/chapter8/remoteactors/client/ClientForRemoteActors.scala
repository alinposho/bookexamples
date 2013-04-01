package actors.in.scala.chapter8.remoteactors.client

import scala.actors.remote.RemoteActor.select
import scala.actors.remote.Node
import actors.in.scala.chapter8.remoteactors.common.{ Start, Stop, EchoActor, Constants }

object ClientForRemoteActors {

  def main(args: Array[String]) {

    println("Starting client");

    println("Attempting to connect to the remote server actor.");
    val server = select(Node("localhost", Constants.PORT), 'server)
    println("Connection to the remote server actor established.");

    println("Attempting to create a remote EchoActor instance");
    server !? Start(classOf[EchoActor])
    println("EchoActor instance created by remote server");

    println("Sending a request to the remote EchoActor");
    val echo = select(Node("localhost", Constants.PORT), 'echo)
    val resp = echo !? "hello"

    println("remote start client received " + resp)

    server !? Stop
  }

}
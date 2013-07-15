package actors.in.scala.chapter8.remoteactors.server

import scala.actors.remote.RemoteActor
import actors.in.scala.chapter8.remoteactors.common.Start

object ServerMain {

  def main(args: Array[String]) {

    RemoteActor.classLoader = Start.getClass().getClassLoader()// hack!
    
    val server = new Server
    server.start()
  }

}
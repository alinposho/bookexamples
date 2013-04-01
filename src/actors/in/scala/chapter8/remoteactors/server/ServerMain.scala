package actors.in.scala.chapter8.remoteactors.server

object ServerMain {
  
  def main(args: Array[String]) {

    val server = new Server
    server.start()
  }

}
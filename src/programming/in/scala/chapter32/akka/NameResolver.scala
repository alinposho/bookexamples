package programming.in.scala.chapter32.akka

import scala.actors._
import scala.actors.Actor._

object NameResolver extends Actor {

  import java.net.{ InetAddress, UnknownHostException }

  def act() {
    react {
      case (name: String, actor: Actor) =>
        actor ! getIp(name)
        act()
      case "EXIT" =>
        println("Name resolver exiting.")
      // quit
      case msg =>
        println("Unhandled message: " + msg)
        act()
    }
  }

  def getIp(name: String): Option[InetAddress] = {
    try {
      Some(InetAddress.getByName(name))
    } catch {
      case _: UnknownHostException => None
    }
  }

  def main(args: Array[String]) {
    
    println("Start of the program");
    
    NameResolver.start()

    NameResolver ! ("www.scala-lang.org", self)
    self.receiveWithin(1000) { case x => println("received: " + x) }

    NameResolver ! ("wwwwww.scala-lang.org", self)
    self.receiveWithin(1000) { case x => println("received: " + x) }
    
    NameResolver ! ("EXIT")
    
    println("End of the program");
  }

}
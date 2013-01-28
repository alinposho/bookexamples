package chapter32.akka

import scala.actors.Actor
import scala.actors.Actor._
import java.net.{ InetAddress, UnknownHostException }

case class LookupIP(name: String, respondTo: Actor)
case class LookupResult(
  name: String,
  address: Option[InetAddress])

object NameResolver2 extends Actor {
  
  def act() {
    loop {
      react {
        case LookupIP(name, actor) =>
          actor ! LookupResult(name, getIp(name))
        case "EXIT!" => exit()
      }
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

    NameResolver2.start()

    NameResolver2 ! LookupIP("www.scala-lang.org", self)
    self.receiveWithin(1000) { case x => println("received: " + x) }

    NameResolver2 ! LookupIP("wwwwww.scala-lang.org", self)
    self.receiveWithin(1000) { case x => println("received: " + x) }

    NameResolver2 ! ("EXIT")

    println("End of the program");
  }

}
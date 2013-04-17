package actors.in.scala.chapter10.akka

import akka.actor.{ Actor, ActorRef }
import akka.actor.ActorSystem
import akka.actor.Props
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext
import scala.actors.threadpool.ThreadPoolExecutor

object ChainActorMain {
  
  implicit val ec = ExecutionContext.global
  
  private val system = ActorSystem("MySystem")

  def buildChain(size: Int, next: Option[ActorRef]): ActorRef = {
    val a = system.actorOf(Props(new ChainActor(next)), "myactor" + size)
    if (size > 1) buildChain(size - 1, Some(a))
    else a
  }

  def main(args: Array[String]) {
    val firstActorRef = buildChain(4, null)

    implicit val timeout = Timeout(5 seconds)
    val future = firstActorRef ? 'Die
    future.collect {
      case 'Ack => println("All actor have been killed!")
    }
  }

}
package actors.in.scala.chapter10.akka

import akka.actor.{ Actor, ActorRef }
import akka.actor.ActorSystem
import akka.actor.Props
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext
import scala.actors.threadpool.ThreadPoolExecutor
import java.util.concurrent.Executors
import scala.concurrent.Await

class MasterActor(noOfChildActors: Int) extends Actor {

  private val pool = Executors.newCachedThreadPool()
  implicit val ec = ExecutionContext.fromExecutorService(pool)

  private val system = ActorSystem("MySystem")
  private val first = buildChain(noOfChildActors, None)

  private var from: ActorRef = null;
  
  override def receive = {
    case 'Start => {
      from = sender
      println("Sending 'Die message to the first actor in the chain.")
      first ! 'Die
    }
    case 'Ack =>
      println(this + " received 'Ack from " + sender)
      println("OK, all actors died.")
      from ! 'Ack
  }

  def buildChain(size: Int, next: Option[ActorRef]): ActorRef = {
    val a = system.actorOf(Props(new ChainActor(next)), "myactor" + size)
    if (size > 1) buildChain(size - 1, Some(a))
    else a
  }

}

object ActorChainMain {

  import ExecutionContext.Implicits.global

  def main(args: Array[String]) {

    val system = ActorSystem("MySystem")
    val masterActor = system.actorOf(Props(new MasterActor(5)), "MasterActor");

    implicit val timeout = Timeout(5 seconds)

    // This doesn't work
//    val future = masterActor ? 'Start
//    future onSuccess {
//      case 'Ack =>
//        println("All actor have been killed!")
//    }

    val future = ask(masterActor, 'Start)

    val result = Await.result(future, 10 seconds)
    result match {
      case 'Ack => println("All actor have been killed!")
      case _ => println("Something went terribly wrong!");
    }

    // For some reason actors do not shutdown gracefully
    exit()
  }
}
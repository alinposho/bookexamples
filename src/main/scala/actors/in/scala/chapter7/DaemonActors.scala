package actors.in.scala.chapter7

import scala.actors.Actor
import scala.actors.scheduler.DaemonScheduler

object DaemonActors {
  
  class MyDaemon extends Actor {
    override val scheduler = DaemonScheduler

    override def act {
      loop {
        react {
          case num: Int => 
            println("Received number " + num + " from " + sender);
            reply(num + 1)
        }
      }
    }
  }
  
  def main(args: Array[String]) {
	  val daemon = new MyDaemon()
	  daemon.start
	  
	  println("Daemon returned: " + (daemon !? 41))
	  
	  println("The main thread will now exit taking the daemon with it :D")
  }
}
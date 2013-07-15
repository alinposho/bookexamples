package programming.in.scala.chapter32.akka

import scala.actors._

object SeriousActor extends Actor {
  
  override def act() {
    for (i <- 1 to 5) {
      println("To be or not to be.")
      Thread.sleep(1000)
    }
  }

  def main(args: Array[String]) {
    SeriousActor.start
    SillyActor.start
  }
}
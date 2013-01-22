package chapter32.akka

import scala.actors._

object SillyActor extends Actor with App {
  override def act = {
    for (i <- 1 to 5) {
      println("I'm acting!")
      Thread.sleep(1000)

      println("I slept for at least one second.");
    }
  }

  SillyActor.start
}

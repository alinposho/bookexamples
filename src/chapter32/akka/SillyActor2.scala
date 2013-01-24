package chapter32.akka

import scala.actors.Actor._

object SillyActor2 {

  def main(args: Array[String]) {

    val sillyActor2 = actor {
      def emoteLater() {
        val mainActor = self
        actor {
          Thread.sleep(1000)
          mainActor ! "Emote"
        }
      }

      var emoted = 0
      emoteLater()
      loop {
        react {
          case "Emote" =>
            println("I'm acting!")
            emoted += 1
            if (emoted < 5)
              emoteLater()
            else {
              println("Preparing to exit... Bye! :)")
              exit()
            }
          case msg =>
            println("Received: " + msg)
        }
      }
    }
    // end of sillyActor2's definition

    sillyActor2 ! "Hello!"

    sillyActor2 ! "Emote"
    sillyActor2 ! "Hello after Emote :D"

  }

}
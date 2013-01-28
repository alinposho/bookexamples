package chapter32.akka

import scala.actors.Actor._

object SillyActorExample {

  // Another way of creating an actor is through the use of the Actor.actor method, just that
  // the result is not what you'd expect since we are using the worksheet.
  val seriousActor2 = actor {
    for (i <- 1 to 5)
      println("That is the question.")
    Thread.sleep(1000)
  }                                               //> That is the question.
                                                  //| That is the question.
                                                  //| That is the question.
                                                  //| That is the question.
                                                  //| That is the question.
                                                  //| seriousActor2  : scala.actors.Actor = scala.actors.Actor$$anon$1@5cc75d38|
}
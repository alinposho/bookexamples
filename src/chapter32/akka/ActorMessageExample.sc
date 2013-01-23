package chapter32.akka

import scala.actors.Actor._

object ActorMessageExample {

  var receivedValue = 0                           //> receivedValue  : Int = 0

  val intActor = actor {
    receive {
      case x: Int => {
        println("Got an Int: " + x)
        receivedValue = x
      }
    }
  }                                               //> intActor  : scala.actors.Actor = scala.actors.Actor$$anon$1@24c31811

  intActor ! 56
  
  receivedValue                                   //> res0: Int = 0

}
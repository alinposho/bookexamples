package actors.in.scala.chapter6

import scala.actors.Actor

object ActorThatRaisesException extends Actor {

  override def act() {
    react {
      case 'hello =>
        throw new Exception("Error!")
    }
  }
  override def exceptionHandler = {
    case e: Exception =>
      println(e.getMessage())
  }
  
  def main(args: Array[String]) {
    val actor = ActorThatRaisesException
    actor.start
    
    actor ! 'hello
  }

}
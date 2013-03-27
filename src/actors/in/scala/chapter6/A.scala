package actors.in.scala.chapter6

import scala.actors.Actor

object A extends Actor {

  override def act(): Unit = {
    var lastMsg: Option[Symbol] = None;
    loopWhile(lastMsg.isEmpty || lastMsg.get != 'stop) {

      val partial: PartialFunction[Any, Unit] = {
        case 'hello => throw new Exception("Error!")
        case any: Symbol =>
          println("your message: " + any)
          lastMsg = Some(any)
          sender ! 'ack
      }

      react(partial)
    }
  }

  override def exceptionHandler() = {
    case e => println(e.getMessage())
  }
  
  private def printActorStateAfter(message: Symbol, actor: Actor) {
    println("Actor state after sending " + message + " message is: " + actor.getState)
  }

  def main(args: Array[String]): Unit = {
    A.start

    A ! 'hello
    printActorStateAfter('hello, A);

    // Notice that the actor didn't terminate execution after an exception has been
    // raised.
    A !? 'some_message
    printActorStateAfter('some_message, A);

    A !? 'stop match {
      case 'ack => println("The actor received the message from the main function");
    }
    printActorStateAfter('stop, A);
    
  }

}
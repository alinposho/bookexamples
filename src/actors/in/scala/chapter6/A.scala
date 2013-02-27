package actors.in.scala.chapter6

import scala.actors.Actor

object A extends Actor {

  override def act(): Unit = {
    var lastMsg: Option[Symbol] = None;
    loopWhile(lastMsg.isEmpty || lastMsg.get != 'stop) {
      react {
        case 'hello => throw new Exception("Error!")
        case any: Symbol => 
          println("your message: " + any)
          lastMsg = Some(any)
      }
    }
  }
  
  override def exceptionHandler() = {
    case e => println(e.getMessage())
  }
  
  def main(args: Array[String]): Unit = {
    A.start
    
    A ! 'hello

    // Notice that the actor didn't terminate execution after an exception has been
    // raised.
    A ! 'some_message
    
    A ! 'stop
  } 
  
}
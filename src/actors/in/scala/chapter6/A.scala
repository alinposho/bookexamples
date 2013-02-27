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
      }
      
      react(partial)
    }
  }
  
  override def exceptionHandler() = {
    case e => println(e.getMessage())
  }
  
  def main(args: Array[String]): Unit = {
    A.start
    
    A ! 'hello
    println(A.getState)

    // Notice that the actor didn't terminate execution after an exception has been
    // raised.
    A ! 'some_message
    println(A.getState)
    
    A ! 'stop
    println(A.getState)
  } 
  
}
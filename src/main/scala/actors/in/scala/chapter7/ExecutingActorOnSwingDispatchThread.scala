package actors.in.scala.chapter7

import scala.actors.Actor
import scala.actors.SchedulerAdapter

object ExecutingActorOnSwingDispatchThread {

  class SwingActor extends Actor {
    
    override val scheduler = new SchedulerAdapter {
      override def execute(codeBlock: => Unit): Unit = {
        java.awt.EventQueue.invokeLater(
        	new Runnable(){
        	  def run() = codeBlock
        	}
        )
      }
    }
    
    override def act() {
      println("Actor that runs on the Swing event dispatch thread!")
    }
  }
  
  def main(args: Array[String]) {
	  val swingActor = new SwingActor()
	  swingActor.start()
  }

}
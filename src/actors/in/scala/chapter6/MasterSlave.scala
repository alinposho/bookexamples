package actors.in.scala.chapter6

import scala.actors.Actor

object Master extends Actor {

  override def act() {

    Slave ! 'work

    react {
      case 'done =>
        println("Master will terminate with an exception!")
        throw new Exception("Master crashed!")
    }
  }

  def main(args: Array[String]) {

    Slave.start

    println(Slave.getState)
    
    Master.start
    
    Thread.sleep(1000)
    
    println("Slave's state: " + Slave.getState)
    println("Master's state: " + Master.getState)

  }

}

object Slave extends Actor {

  override def act() {

    link(Master)
    loop {
      react {
        case 'work =>
          println("Work done!")
          reply('done)
      }
    }
  }

}

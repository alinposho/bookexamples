package scala.by.example.imperative.control.structures

object RepeatLoop {
  
  class EC(command: => Unit) {
    def until(cond: => Boolean):Unit = {
      if(cond) ()
      else {
        command
        until(cond)
      }
    }
  }
  
  def repeatLoop(command: => Unit) = new EC(command)
  
  def main(args: Array[String]):Unit = {
    
    var i = 0;
    
    repeatLoop{
      println(s"i = ${i}")
      i += 1
    } until (i == 10)
  }

}
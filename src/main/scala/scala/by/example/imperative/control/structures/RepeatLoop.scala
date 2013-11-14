package scala.by.example.imperative.control.structures

object RepeatLoop {

  class EC(command: => Unit) {
    def until(cond: => Boolean): Unit = {
      if (cond) ()
      else {
        command
        until(cond)
      }
    }
  }

  def repeat(command: => Unit) = new { // This is equivalent to new AnyRef{def until ...}
    def until(cond: => Boolean): Unit = {
      if (cond) ()
      else {
        command
        until(cond)
      }
    }
  }

  def repeatLoop(command: => Unit) = new EC(command)

  def main(args: Array[String]): Unit = {

    var i = 0

    println("The output of repeatLoop")
    repeatLoop {
      println(s"i = ${i}")
      i += 1
    } until (i == 10)

    println("The output of repeat")
    i = 0
    repeat {
      println(s"i = ${i}")
      i += 1
    } until (i == 10)
  }

}
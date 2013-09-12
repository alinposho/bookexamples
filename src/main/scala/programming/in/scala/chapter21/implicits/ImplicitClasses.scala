package programming.in.scala.chapter21.implicits

object ImplicitClasses {

  implicit class IntWithTimes(x: Int) {
    def times[A](f: => A): Unit = {
      def loop(current: Int): Unit =
        if (current > 0) {
          f
          loop(current - 1)
        }
      loop(x)
    }
  }
  
  def main(args: Array[String]):Unit = {
    // This will print "HI" five times. Nice.
    5 times println("HI")
  }
  
}


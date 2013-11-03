package scalapuzzlers

object ReturnToMe extends App {

  def value: Int = {
    def one(x: Int): Int = { return x; 1 }
    val two = (x: Int) => { return x; 2 } // This return statement will apply to the value function!
    1 + one(2) + two(3)
  }

  println(value)
}
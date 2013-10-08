package ducktyping

object BigDuck {
  def quack(value: String) = {
    value.toUpperCase
  }
}

object SmallDuck {
  def quack(value: String) = {
    value.toLowerCase
  }
}

object IamNotReallyADuck {
  def quack(value: String) = {
    "prrrrrp"
  }
}

object NoQuaker {

}

object Quacker {

  def quacker(duck: { def quack(value: String): String }) {
    println(duck.quack("Quack"))
  }

  def main(args: Array[String]): Unit = {
    quacker(BigDuck)
    quacker(SmallDuck)
    quacker(IamNotReallyADuck)

    val x = new AnyRef {
      def quack(value: String) = {
        "No type needed " + value
      }
    }
    quacker(x)

    // quacker(NoQuaker) // This will not compile since the NoQuacker object does not define a method 
    // that conforms to the quacker requirements, i.e. a quack method
  }
}

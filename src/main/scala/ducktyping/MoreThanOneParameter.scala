package ducktyping

object BigDuckQuacker {
  def quack(value: String) = {
    value.toUpperCase
  }

  def walk(): String = {
    "Big Duck walking"
  }
}

object MoreThanOneParameter {
  def quacker(duck: { def quack(value: String): String; def walk(): String }) {
    println(duck.quack("Quack"))
    println(duck.walk())
  }

  def main(args: Array[String]): Unit = {
    quacker(BigDuckQuacker)
  }
}
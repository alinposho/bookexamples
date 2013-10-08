package ducktyping

/**
 * This is an example of Scala Structural Typing also called Duck Typing by some. I found this code here:
 * http://java.dzone.com/articles/duck-typing-scala-structural
 */


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
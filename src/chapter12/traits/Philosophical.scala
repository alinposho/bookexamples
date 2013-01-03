package chapter12.traits

trait Philosophical {
  def philosophize() {
    println("I consume memory therefore, I am!")
  }
}

class Frog extends Philosophical {
  override def toString = "green"
}
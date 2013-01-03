package chapter12.traits

trait Philosophical {
  def philosophize() {
    println("I consume memory therefore, I am!")
  }
}

class Animal
trait HasLegs

class Frog extends Animal with Philosophical with HasLegs{
  override def toString = "green"
}

// This won't compile because of the use of with instead of extends
//class Frog with Philosophical {
//}

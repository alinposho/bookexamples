package scala.by.example.inheritance

object TraitExtendingClass extends App {
	
}

// class SubClass extends SubTrait { }// Will ask for SuperType contructor parameters
//class SubClass(val name: String) extends SubTrait { }// This will not work either 

trait SubTrait extends SuperClass{
  override def smth: Unit = {
    println("SubTrait")
  }
}

class SuperClass(val name: String) {
  def smth: Unit = {
    println("SuperClass: " + name)
  }
}
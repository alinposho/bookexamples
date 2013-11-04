package scala.by.example.inheritance

object TraitExtendingClass extends App {
	SubObject.smth
	
	new SubClass("Called from main").smth
}

// object SubObject extends SubClass { // This will not work, of course, since name is not defined
object SubObject extends SubClass("SubObject") {
  override def smth: Unit = {
    println("SubObject")
  }
}

// class SubClass extends SubTrait { }// Will ask for SuperType contructor parameters
//class SubClass(val name: String) extends SubTrait { }// This will not work ei
class SubClass(name: String) extends SuperClass(name) with SubTrait {
  override def smth: Unit = {
    println("SubClass")
  }
}

trait SubTrait extends SuperClass {
  override def smth: Unit = {
    println("SubTrait")
  }
}

class SuperClass(val name: String) {
  def smth: Unit = {
    println("SuperClass: " + name)
  }
}
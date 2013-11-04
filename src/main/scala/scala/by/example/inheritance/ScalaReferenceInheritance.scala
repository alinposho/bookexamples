package scala.by.example.inheritance

object ScalaReferenceInheritance extends App {
	O
}

class Base extends Object {println("Base")}
trait Mixin extends Base {println("Mixin")}
object O extends Mixin {println("O")} // This get expanded to 
									//	object O extends Base with Mixin
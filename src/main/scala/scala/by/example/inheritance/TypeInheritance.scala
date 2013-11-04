package scala.by.example.inheritance

object TypeInheritance {

}

trait Root { type T <: Root }
trait A extends Root { type T <: A }
trait B extends Root { type T <: B }
// trait C extends A with B // This will not compile since the inherited "type T <: A" is not met
//trait C extends A with B { type T <: A } // This will not meet the type definition in B 
trait C extends A with B { type T <: C } // This will meet all type definitions from A, B and Root

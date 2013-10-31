package scala.by.example

class Outer {
  class Inner()
}


object TypeNesting extends App {
   val o1 = new Outer
   val o2 = new Outer
   val i1 = new o1.Inner
   var i2 = new o2.Inner
   
   println(i1 == i2)
   println(i1.getClass() == i2.getClass())
   
   // This will not compile since the type of i2 is bound to the instance of o2 and i1's type is bound to o1
   // i2 = i1
}
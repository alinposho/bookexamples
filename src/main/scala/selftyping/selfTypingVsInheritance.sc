trait Foo {
  def smth: String = "foo"
}


trait FooSelf {
  this: Foo =>

  // The following line will not compile since SelfFoo is using self typing
  //  def smth: String = super.smth + "self"
  // But this works
  def smth: String = "fooself"
}

trait FooInheritance extends Foo {
  override def smth: String = super.smth + " inheritance"
}

class FooSelfImpl extends FooSelf with Foo {
  // We had to declare the override otherwise the compile would complain
  override def smth: String = super.smth + " impl"

  def result: String = super.smth
}

val v = new FooSelfImpl()
// Notice that the actual method called in the one from Foo
v.result
// But here we get the method defined in FooSelfImpl
v.smth


class FooInheritanceImpl extends FooInheritance

new FooInheritanceImpl().smth


// Self type sample code from  http://programmers.stackexchange.com/questions/219038/what-is-the-difference-between-self-types-and-trait-inheritance-in-scala
trait A1 {
  self: B =>

  def doit {
    println(bar)
  }
}

trait A2 extends B {
  def doit {
    println(bar)
  }
}

trait B {
  def bar = "default bar"
}

trait BX extends B {
  override def bar = "bar bx"
}

trait BY extends B {
  override def bar = "bar by"
}

// object Thing1 extends A1  // FAIL: does not conform to A1 self-type
object Thing1 extends A1 with B
object Thing2 extends A2
object Thing1X extends A1 with BX
object Thing1Y extends A1 with BY
object Thing2X extends A2 with BX
object Thing2Y extends A2 with BY

Thing1.doit // default bar
Thing2.doit // default bar
Thing1X.doit // bar bx
Thing1Y.doit // bar by
Thing2X.doit // bar bx
Thing2Y.doit // bar by
// up-cast
val a1: A1 = Thing1Y
val a2: A2 = Thing2Y
// println(a1.bar)    // FAIL: not visible
println(a2.bar) // bar bx
// println(a2.bary)   // FAIL: not visible
//println(Thing2Y.bary) // 42

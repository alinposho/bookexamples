trait Foo {
  def foo()
}

trait M extends Foo {
  abstract override def foo() {println("M"); super.foo()}
}

class FooImpl1 extends Foo {
  override def foo() {println("Impl")}
}

class FooImpl2 extends FooImpl1 with M

val x = new FooImpl2
x.foo()
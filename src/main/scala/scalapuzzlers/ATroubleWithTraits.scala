package scalapuzzlers

trait A {
  val foo: Int
  val bar = 10
  println("In A: foo: " + foo + ", bar: " + bar)
}

class B1 extends A {
  val foo = 25
  println("In B1: foo: " + foo + ", bar: " + bar)
}

class B2(val foo: Int = 25) extends A {
  println("In B2: foo: " + foo + ", bar: " + bar)
}

//class B3 extends A {
//  
//  val foo: Int
//  // def this(val foo: Int = 25) { // This will not compile
//  def this(foo: Int = 25) { // This will not compile either since foo is not defined
//    this()
//    println("In B3: foo: " + foo + ", bar: " + bar)
//  }
//}

object ATroubleWithTraits {
  def main(args: Array[String]): Unit = {
    new B1
    new B2
  }
}

/*
 * Compile this file using the following command and you will notice how the constructor argument for class b2 sets
 * foo before everything else gets invoked "scalac -print ATroubleWithTraits". This is the output of B1 and B2 compilation
 class B1 extends Object with scalapuzzlers.A {
    <stable> <accessor> def bar(): Int = B1.this.bar;
    private[this] val bar: Int = _;
    <accessor> def scalapuzzlers$A$_setter_|_=(x$1: Int): Unit = B1.this.bar = x$1;
    private[this] val foo: Int = _;
    <stable> <accessor> def foo(): Int = B1.this.foo;
    def <init>(): scalapuzzlers.B1 = {
      B1.super.<init>();
      scalapuzzlers.A$class./*A$class*/$init$(B1.this);
      B1.this.foo = 25;
      scala.this.Predef.println("In B1: foo: ".+(scala.Int.box(B1.this.foo())).+(", bar: ").+(scala.Int.box(B1.this.bar())));
      ()
    }
  };
  class B2 extends Object with scalapuzzlers.A {
    <stable> <accessor> def bar(): Int = B2.this.bar;
    private[this] val bar: Int = _;
    <accessor> def scalapuzzlers$A$_setter_|_=(x$1: Int): Unit = B2.this.bar = x$1;
    <paramaccessor> private[this] val foo: Int = _;
    <stable> <accessor> <paramaccessor> def foo(): Int = B2.this.foo;
    def <init>(foo: Int): scalapuzzlers.B2 = {
      B2.this.foo = foo;
      B2.super.<init>();
      scalapuzzlers.A$class./*A$class*/$init$(B2.this);
      scala.this.Predef.println("In B2: foo: ".+(scala.Int.box(foo)).+(", bar: ").+(scala.Int.box(B2.this.bar())));
      ()
    }
  }; 
 */

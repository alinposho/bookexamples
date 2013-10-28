package scalapuzzlers

object Lives {
  class Private {
    // The method bellow will not compile since class C1 although public, it does not have a public constructor
    // and, unlike in Java, outer classes cannot access private members of inner classes.
    //def foo1: Any = new Private.C1
    def foo2: Any = new Private.C2
  }

  object Private {
    class C1 private {}
    private class C2 {}
  }
}
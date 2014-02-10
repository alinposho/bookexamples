package scala.in.depth.chapter5.implicits.resolution.test

object Test {
  def main(args: Array[String]): Unit = {
    testSamePackage()
    testWildcardImport()
    testExplicitImport()
    testInlineDefinition()
  }

  def testSamePackage(): Unit = {
    println(x)
  }

  object Wildcard {
    def x = "Wildcard Import x"
  }

  def testWildcardImport(): Unit = {
    import Wildcard._
    println(x)
  }

  object Explicit {
    def x = "Explicit Import x"
  }

  def testExplicitImport(): Unit = {
    import Explicit.x
    import Wildcard._
    println(x)
  }

  def testInlineDefinition(): Unit = {
    val x = "Inline definition"
    import Explicit.x
    import Wildcard._
    println(x)
  }

  def scalaSpec(): Unit = {
    val x = 1;
    {
      import Explicit.x;
      // This will not compile since the x reference is ambiguous
//      x
    }
  }

}
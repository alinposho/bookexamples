package scalapuzzlers

/**
 * This puzzler's page: http://scalapuzzlers.com/#pzzlr-016
 */
object SelfSeeSelf {

  // This will work though
  val s1: String = s1
  val s2: String = s2 + s2

  def main(args: Array[String]): Unit = {

    // This will not compile as is, but it will work when copy pasted in the REPL
    //  val s1: String = s1
    //  val s2: String = s2 + s2

    println(s2.length) // This will actually print 8
    println(s1.length) // This will raise a NullPointerException
  }
}
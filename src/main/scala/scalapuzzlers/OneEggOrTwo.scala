package scalapuzzlers

/**
 * The source of this puzzlers is here: http://scalapuzzlers.com/#pzzlr-017
 */
object OneEggOrTwo {

  class C
  def main(args: Array[String]) {
    val x1, x2 = new C
    val y1 @ y2 = new C
    
    println(x1 == x2)
    println(y1 == y2)
  }

}
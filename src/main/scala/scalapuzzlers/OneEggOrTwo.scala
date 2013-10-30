package scalapuzzlers

/**
 * The source of this puzzlers is here: http://scalapuzzlers.com/#pzzlr-017
 */
object OneEggOrTwo {

  class C
  def main(args: Array[String]) {
    val x1, x2 = new C // This gets translated into two different initializations
    val y1 @ y2 = new C // This gets translated into
    
    val t = new C match {
      case y11 @ y12 => (y11, y12)
    }
    
    println(x1 == x2)
    println(y1 == y2)
  }

}
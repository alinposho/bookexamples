package programming.scala

object functionValuesAndClosures {

  def p(x: Int): Boolean = x % 2 == 0
  
  (1 to 10 toSeq) filter p
  
}


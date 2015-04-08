package scala

package object problems99 {
  def extract(vct: Vector[Char]): Vector[Char] = {
    val res = vct.foldLeft(Vector.empty[Char]) { 
      case (v, ')') =>
        val i = v lastIndexOf ('(') 
        v.take(i) 
      case (v, e) => v :+ e 
    }
    res filter (_ isLetter) 
  }
}
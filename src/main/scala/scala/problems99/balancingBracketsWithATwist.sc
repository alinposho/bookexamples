package scala.problems99

object balancingBracketsWithATwist {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  "(ab)c".toSeq.toVector.span(_ == '(')           //> res0: (scala.collection.immutable.Vector[Char], scala.collection.immutable.V
                                                  //| ector[Char]) = (Vector((),Vector(a, b, ), c))
  
  "(ab(c(d))e".toSeq.toVector.span(_ == '(')      //> res1: (scala.collection.immutable.Vector[Char], scala.collection.immutable.V
                                                  //| ector[Char]) = (Vector((),Vector(a, b, (, c, (, d, ), ), e))

  "(ab)c".toSeq.toVector.dropRight(1)             //> res2: scala.collection.immutable.Vector[Char] = Vector((, a, b, ))

  val v = "a(b)c".toCharArray().toSeq             //> v  : Seq[Char] = WrappedArray(a, (, b, ), c)

  // Execution time O(n^2)
  def extract(vct: Vector[Char]): Vector[Char] = {
    val res = vct.foldLeft(Vector.empty[Char]) { // O(n)
      case (v, e) =>
        if (e == ')') {
        	val i = v lastIndexOf('(') // O(n)
          v.take(i) // O(n)
        } else {
          v :+ e // O(log32n)
        }
    }
    res filter (_ isLetter) // O(n)
  }                                               //> extract: (vct: Vector[Char])Vector[Char]
  

  extract("(ab)".toSeq.toVector) == Vector()      //> res3: Boolean = true

  extract("(ab".toSeq.toVector) == Vector('a', 'b')
                                                  //> res4: Boolean = true

  extract("(ab)c".toSeq.toVector) == Vector('c')  //> res5: Boolean = true

  extract("(ab(c(d))e".toSeq.toVector)            //> res6: Vector[Char] = Vector(a, b, e)

}
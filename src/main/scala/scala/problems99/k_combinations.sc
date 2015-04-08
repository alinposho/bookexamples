package scala.problems99

object k_combinations {
  //
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def kcombinations(k: Int, st: Set[Int]): Set[Set[Int]] = {
    if (k <= 0) Set(Set[Int]())
    else {
      val res = for (s <- st; subst <- kcombinations(k - 1, st); val nsubst = subst + s; if (nsubst.size == k)) yield nsubst
      res.toSet
    }
  }                                               //> kcombinations: (k: Int, st: Set[Int])Set[Set[Int]]
  
  val v = kcombinations(3, (1 to 7).toSet)        //> v  : Set[Set[Int]] = Set(Set(7, 6, 1), Set(3, 1, 5), Set(2, 6, 5), Set(7, 1,
                                                  //|  5), Set(4, 7, 2), Set(4, 2, 6), Set(4, 1, 5), Set(7, 2, 1), Set(4, 7, 6), S
                                                  //| et(2, 6, 1), Set(2, 1, 5), Set(4, 3, 5), Set(3, 7, 1), Set(4, 3, 7), Set(4, 
                                                  //| 6, 5), Set(3, 7, 6), Set(3, 6, 5), Set(4, 3, 6), Set(4, 7, 5), Set(4, 2, 1),
                                                  //|  Set(3, 2, 6), Set(4, 7, 1), Set(3, 2, 1), Set(4, 6, 1), Set(3, 7, 5), Set(3
                                                  //| , 2, 5), Set(6, 1, 5), Set(7, 2, 5), Set(3, 6, 1), Set(7, 6, 5), Set(4, 2, 5
                                                  //| ), Set(7, 2, 6), Set(4, 3, 2), Set(3, 7, 2), Set(4, 3, 1))
  
}
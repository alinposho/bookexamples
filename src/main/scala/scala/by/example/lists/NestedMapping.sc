package scala.by.example.lists

object NestedMapping {

  // The following three combination of list higher order function applications produce the same output
  List.range(1, 5).map(i => List.range(1, i).map(x => (i, x))).flatMap(x => x)
                                                  //> res0: List[(Int, Int)] = List((2,1), (3,1), (3,2), (4,1), (4,2), (4,3))
  List.range(1, 5).map(i => List.range(1, i).map(x => (i, x))).foldRight(List[(Int, Int)]())(_ ::: _)
                                                  //> res1: List[(Int, Int)] = List((2,1), (3,1), (3,2), (4,1), (4,2), (4,3))
  List.range(1, 5).flatMap(i => List.range(1, i).map(x => (i, x)))
                                                  //> res2: List[(Int, Int)] = List((2,1), (3,1), (3,2), (4,1), (4,2), (4,3))

  // Prime pairs
  import Prime._
  def primePairs(n: Int) = (1 to n).flatMap(i => (1 to i).map(j => (i, j))).
  																 filter{ case (i, j) => isPrime(i + j)}
                                                  //> primePairs: (n: Int)scala.collection.immutable.IndexedSeq[(Int, Int)]
  primePairs(7)                                   //> res3: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,1), (2,1
                                                  //| ), (3,2), (4,1), (4,3), (5,2), (6,1), (6,5), (7,4), (7,6))
}
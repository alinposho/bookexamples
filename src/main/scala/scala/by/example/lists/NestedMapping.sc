package scala.by.example.lists

object NestedMapping {

// The following three combination of list higher order function applications produce the same output
  List.range(1, 5).map(i => List.range(1, i).map(x => (i, x))).flatMap(x => x)
                                                  //> res0: List[(Int, Int)] = List((2,1), (3,1), (3,2), (4,1), (4,2), (4,3))
  List.range(1, 5).map(i => List.range(1, i).map(x => (i, x))).foldRight(List[(Int, Int)]())(_ ::: _)
                                                  //> res1: List[(Int, Int)] = List((2,1), (3,1), (3,2), (4,1), (4,2), (4,3))
  List.range(1, 5).flatMap(i => List.range(1, i).map(x => (i, x)))
                                                  //> res2: List[(Int, Int)] = List((2,1), (3,1), (3,2), (4,1), (4,2), (4,3))

}
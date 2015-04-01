package scala.problems99

object problems3 {
  // Partition function
  
  def partition[A](l: Seq[A], step: Int): Iterable[Seq[A]] = {
  	l.zipWithIndex.groupBy{case (e,index) => index / step}.values.map(l => l.map{case (e, _) => e})
  }                                               //> partition: [A](l: Seq[A], step: Int)Iterable[Seq[A]]
  
  val l = (1 to 10).toList                        //> l  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  
  val intermediate = l.zipWithIndex.groupBy{case (e,index) => index % 3} values
                                                  //> intermediate  : Iterable[List[(Int, Int)]] = MapLike(List((3,2), (6,5), (9,8
                                                  //| )), List((2,1), (5,4), (8,7)), List((1,0), (4,3), (7,6), (10,9)))
  
  (l.zipWithIndex.groupBy{case (e,index) => index % 3})
                                                  //> res0: scala.collection.immutable.Map[Int,List[(Int, Int)]] = Map(2 -> List((
                                                  //| 3,2), (6,5), (9,8)), 1 -> List((2,1), (5,4), (8,7)), 0 -> List((1,0), (4,3),
                                                  //|  (7,6), (10,9)))
  
  intermediate.map (l => l.map{case (e, _) => e}) //> res1: Iterable[List[Int]] = List(List(3, 6, 9), List(2, 5, 8), List(1, 4, 7,
                                                  //|  10))
                                                  
	l.zipWithIndex.groupBy{case (e,index) => index / 2}.values.map(l => l.map{case (e, _) => e})
                                                  //> res2: Iterable[List[Int]] = List(List(1, 2), List(3, 4), List(5, 6), List(7,
                                                  //|  8), List(9, 10))
                                                  
	partition(l, 4)                           //> res3: Iterable[Seq[Int]] = List(List(9, 10), List(5, 6, 7, 8), List(1, 2, 3,
                                                  //|  4))
                                                  
	l.grouped(4).toList                       //> res4: List[List[Int]] = List(List(1, 2, 3, 4), List(5, 6, 7, 8), List(9, 10)
                                                  //| )
}
package scala.problems99

object problems {
  //P01
  val l = 1 to 10                                 //> l  : scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5, 6, 7, 
                                                  //| 8, 9, 10)
  l.drop(l.size - 1).head                         //> res0: Int = 10
  l.last                                          //> res1: Int = 10
  
  //P02
  
  l.reverse.tail.head                             //> res2: Int = 9
  l.drop(l.size - 2).head                         //> res3: Int = 9
 	l.dropRight(1).last                       //> res4: Int = 9
  
  
  //P03
  l(1)                                            //> res5: Int = 2
  l.drop(2).head                                  //> res6: Int = 3
  
  // P04
  l.size                                          //> res7: Int = 10
	l.foldLeft(0)((count, _) => count + 1)    //> res8: Int = 10


  // P05
  l.foldLeft(List.empty[Int])((xs, x) => x :: xs) //> res9: List[Int] = List(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
  l.foldRight(List.empty[Int])((x, xs) => xs :+ x)//> res10: List[Int] = List(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
  
  // P06
  l.reverse == l                                  //> res11: Boolean = false
  
  val p = List(1, 2, 3, 2, 1)                     //> p  : List[Int] = List(1, 2, 3, 2, 1)
  p.reverse == p                                  //> res12: Boolean = true
  
  // P07
  val xs = List(List(1, 1), 2, List(3, List(5, 8)))
                                                  //> xs  : List[Any] = List(List(1, 1), 2, List(3, List(5, 8)))
  
  List(List(1, 2), List(3), List(4, 5, 6)).flatten//> res13: List[Int] = List(1, 2, 3, 4, 5, 6)
  
  

}
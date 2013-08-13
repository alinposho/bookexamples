package chapter16.lists

object HigherOrderListFunctions {

  List.range(1, 5) flatMap (
    i => List.range(1, i) map (j => (i, j)))      //> res0: List[(Int, Int)] = List((2,1), (3,1), (3,2), (4,1), (4,2), (4,3))


	  List.range(1, 5) map (
    i => List.range(1, i) map (j => (i, j)))      //> res1: List[List[(Int, Int)]] = List(List(), List((2,1)), List((3,1), (3,2)),
                                                  //|  List((4,1), (4,2), (4,3)))
    
    
    val xs = List.range(-5, 12)                   //> xs  : List[Int] = List(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                                                  //|  11)
    val p = ((x: Int) => x > 0)                   //> p  : Int => Boolean = <function1>
    
    xs span p equals (xs takeWhile p, xs dropWhile p)
                                                  //> res2: Boolean = true
                                                  
    (0 /: xs)(_ + _)                              //> res3: Int = 51
    xs.foldLeft(0)(_ + _)                         //> res4: Int = 51
    
    (xs :\ 0)(_ + _)                              //> res5: Int = 51
    xs.foldRight(0)(_ + _)                        //> res6: Int = 51
}
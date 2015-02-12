package scala.problems99

object problems2 {

  // P08
  val xs = List(List(1, 1), 2, List(3, List(5, 8)))
                                                  //> xs  : List[Any] = List(List(1, 1), 2, List(3, List(5, 8)))
  def flatten(ls: List[Any]): List[Any] = ls flatMap {
    case ms: List[_] => flatten(ms)
    case e => List(e)
  }                                               //> flatten: (ls: List[Any])List[Any]

  flatten(xs)                                     //> res0: List[Any] = List(1, 1, 2, 3, 5, 8)

  // xs.foldLeft(List.empty[Any])((l, r) => l ::: flatten(r))

  def flatten2(xs: List[Any]): List[Any] = {
    xs match {
      case Nil => Nil
      case first :: tail => if (first.isInstanceOf[List[Any]]) flatten2(first.asInstanceOf[List[Any]]) ::: flatten2(tail)
      else first :: flatten2(tail)
    }
  }                                               //> flatten2: (xs: List[Any])List[Any]

  flatten2(xs)                                    //> res1: List[Any] = List(1, 1, 2, 3, 5, 8)

  // P09
  //List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e).takeWhile()

  def pack[A](xs: List[A]): List[List[A]] = {
    if(xs.isEmpty)
    	Nil
    else {
     val (x, rest) = xs.span(_ == xs.head)
     x :: pack(rest)
    }
  }                                               //> pack: [A](xs: List[A])List[List[A]]

  val res = pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
                                                  //> res  : List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c
                                                  //| ), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
  
  res map (_.size) zip (res map (_.head))         //> res2: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,
                                                  //| 'e))
                                                  
  res map (x => (x.size, x.head))                 //> res3: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4
                                                  //| ,'e))
  

  //List('a, 'a, 'a, 'a, 'b, 'c, 'c).groupBy(identity)
  val lst = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
                                                  //> lst  : List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 
                                                  //| 'e, 'e)
  
  lst.span(_ == lst.head)                         //> res4: (List[Symbol], List[Symbol]) = (List('a, 'a, 'a, 'a),List('b, 'c, 'c,
                                                  //|  'a, 'a, 'd, 'e, 'e, 'e, 'e))
                                                  
                                                  
  (lst.takeWhile(_ == lst.head), lst.dropWhile(_ == lst.head))
                                                  //> res5: (List[Symbol], List[Symbol]) = (List('a, 'a, 'a, 'a),List('b, 'c, 'c,
                                                  //|  'a, 'a, 'd, 'e, 'e, 'e, 'e))
  
}
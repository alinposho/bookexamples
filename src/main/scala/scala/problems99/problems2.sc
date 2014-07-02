package scala.problems99

object problems2 {
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
}
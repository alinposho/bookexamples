package chapter16.lists

object InsertionSortUsingPatternMatching {

  def isort(xs: List[Int]): List[Int] = {
    xs match {
      case x :: xs => insert(x, isort(xs))
      case Nil => Nil
    }
  }                                               //> isort: (xs: List[Int])List[Int]

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if (x <= y) x :: xs
    else y :: insert(x, ys)
  }                                               //> insert: (x: Int, xs: List[Int])List[Int]
  
  isort(List(188, -199, 56, 87, 14, 9, 199999, -76767))
                                                  //> res0: List[Int] = List(-76767, -199, 9, 14, 56, 87, 188, 199999)

}
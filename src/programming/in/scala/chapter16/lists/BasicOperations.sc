package chapter16.lists

object BasicOperations {

  def isort(xs: List[Int]): List[Int] =
    if (xs.isEmpty) Nil
    else insert(xs.head, isort(xs.tail))          //> isort: (xs: List[Int])List[Int]
  def insert(x: Int, xs: List[Int]): List[Int] =
    if (xs.isEmpty || x <= xs.head) x :: xs
    else xs.head :: insert(x, xs.tail)            //> insert: (x: Int, xs: List[Int])List[Int]
    
 val list = List(1, 10, -9, 5)                    //> list  : List[Int] = List(1, 10, -9, 5)
 
 isort(list)                                      //> res0: List[Int] = List(-9, 1, 5, 10)

}
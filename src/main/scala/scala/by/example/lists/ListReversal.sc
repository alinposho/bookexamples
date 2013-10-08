package scala.by.example.lists

object ListReversal {

  def reverse[A](xs: List[A]): List[A] = xs.foldLeft(List[A]())((xs, x) => x :: xs)
                                                  //> reverse: [A](xs: List[A])List[A]

  val l = List.range(0, 10)                       //> l  : List[Int] = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
  reverse(l)                                      //> res0: List[Int] = List(9, 8, 7, 6, 5, 4, 3, 2, 1, 0)

// This will not reverse the list
  def unreverse2[A](xs: List[A]): List[A] = (xs foldRight(List[A]()))(_ :: _)
                                                  //> unreverse2: [A](xs: List[A])List[A]

  unreverse2(l)                                   //> res1: List[Int] = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
}
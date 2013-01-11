package chapter16.lists

import lists._

object MergeSortExamples {

  msort((x: Int, y: Int) => x < y)(List(5, 8, 1, 5, 3, 2))
                                                  //> res0: List[Int] = List(1, 2, 3, 5, 5, 8)

	// Use partially defined functions and currying to define Int list
	// sorting functions
	def intSort = msort((x: Int, y: Int) => x < y) _
                                                  //> intSort: => List[Int] => List[Int]
	def reverseIntSort = msort((x: Int, y: Int) => x > y) _
                                                  //> reverseIntSort: => List[Int] => List[Int]
	
	val list = List(9, 11, 7, 5, 4, 8, 3, 12, 1)
                                                  //> list  : List[Int] = List(9, 11, 7, 5, 4, 8, 3, 12, 1)
	intSort(list)                             //> res1: List[Int] = List(1, 3, 4, 5, 7, 8, 9, 11, 12)
	reverseIntSort(list)                      //> res2: List[Int] = List(12, 11, 9, 8, 7, 5, 4, 3, 1)
	
	
}
package chapter16.lists

import lists._

object MergeSortExamples {

	
 msort((x: Int, y: Int) => x < y)(List(5, 8, 1, 5, 3, 2))
                                                  //> res0: List[Int] = List(1, 2, 3, 5, 5, 8)

}
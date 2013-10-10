package scala.by.example.forcomprehension

object PrimePairs {

  import scala.by.example.lists.Prime._

  // Redo the Prime Pairs example from the lists package with for compreshension
  def primePairs(n: Int) =
    for {
      i <- List.range(1, n)
      j <- List.range(1, i)
      if isPrime(i + j)
    } yield (i, j)                                //> primePairs: (n: Int)List[(Int, Int)]

	primePairs(7)                             //> res0: List[(Int, Int)] = List((2,1), (3,2), (4,1), (4,3), (5,2), (6,1), (6,5
                                                  //| ))
}
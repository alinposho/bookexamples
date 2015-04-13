import java.util.concurrent.TimeUnit

import introduction.to.algorithms.Quicksort._
import util._

val array = Array(7, 8, 1, 3, 5, 10, -1, 0, -100, 9999)
time(quicksort(array))
//for(_ <- 1 to 10) {
//  time(quicksort(array))
//}

val generator = new scala.util.Random()
var randomArray = new Array[Int](10000)
randomArray = randomArray map (_ => generator.nextInt)
val sortedArray = quicksort(randomArray)
for(_ <- 1 to 5) {
  time(quicksort(randomArray))(timeUnit = TimeUnit.MILLISECONDS)
}

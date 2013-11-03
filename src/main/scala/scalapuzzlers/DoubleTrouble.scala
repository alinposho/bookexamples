package scalapuzzlers

object DoubleTrouble extends App {
  def printSorted(a: Array[Double]) {
    util.Sorting.stableSort(a)
    println(a.mkString(" "))
  }

  printSorted(Array(1.0, Double.NaN, 1.1))
  printSorted(Array(1.1, Double.NaN, 1.0))
}
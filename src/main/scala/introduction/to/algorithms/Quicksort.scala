package introduction.to.algorithms

import scala.math.Ordering

object Quicksort {

  def quicksort[A](a: Array[A])(implicit ord: Ordering[A]): Array[A] = {
    def quicksort(a: Array[A], p: Int, r: Int)(implicit ord: Ordering[A]): Unit = {
      if (p < r) {
        val q = partition(a, p, r)
        quicksort(a, p, q - 1)
        quicksort(a, q, r)
      }
    }

    def partition(a: Array[A], p: Int, r: Int)(implicit ord: Ordering[A]): Int = {
      val x = a(r)
      var i = p - 1
      //replace with a while loop to improve performance
      for (j <- p to r - 1) {
        if (ord.compare(a(j), x) <= 0) {
          i += 1
          exchange(a, i, j)
        }
      }
      exchange(a, i + 1, r)

      i + 1
    }

    def exchange(a: Array[A], i: Int, j: Int) = {
      val tmp = a(i)
      a(i) = a(j)
      a(j) = tmp
    }

    quicksort(a, 0, a.length - 1)

    a
  }

}

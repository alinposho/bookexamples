package scala.by.example.a.first.example

object QuickSort {
  def sort(xs: Array[Int]): Unit = {
    def swap(i: Int, j: Int) {
      val t = xs(i)
      xs(i) = xs(j)
      xs(j) = t
    }

    def sort(left: Int, right: Int): Unit = {
      var pivot = xs((right + left) / 2)
      var i = left
      var j = right
      while (i <= j) {
        while (xs(i) < pivot) i += 1
        while (xs(j) > pivot) j -= 1
        
        if(i <= j) {
          swap(i, j)
          i += 1
          j -= 1
        }
        if(left < j) sort(left, j)
        if(i < right) sort(i, right)
      }
    }
    
    sort(0, xs.length - 1)
  }
}
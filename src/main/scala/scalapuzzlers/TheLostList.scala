package scalapuzzlers

object TheLostList {
	def sumSizes(collection: Iterable[TraversableOnce[_]]): Int = collection.map(_.size).sum
	
	def main(args: Array[String]): Unit = {
	  println(sumSizes(List(Set(1, 2), List(3, 4))))
	  println(sumSizes(Set(List(1, 2), Set(3, 4)))) // Will print 2 since the size of the subset's elements, i.e. 2
	  // gets added twice to the set, but a set cannot contain duplicates, therefore, before the "sum" operation
	  // gets invoked, the set will contain only one element, and that element is the number 2.
	}
}
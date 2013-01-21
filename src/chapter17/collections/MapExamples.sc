package chapter17.collections

import scala.collection.mutable;
import scala.collection.immutable._;

object MapExamples {
  def countWords(text: String) = {
    val counts = mutable.Map.empty[String, Int]
    for (rawWord <- text.split("[ ,!.]+")) {
      val word = rawWord.toLowerCase
      val oldCount =
        if (counts.contains(word)) counts(word)
        else 0
      counts += (word -> (oldCount + 1))
    }
    counts
  }                                               //> countWords: (text: String)scala.collection.mutable.Map[String,Int]

  countWords("See Spot run! Run, Spot. Run!")     //> res0: scala.collection.mutable.Map[String,Int] = Map(spot -> 2, see -> 1, ru
                                                  //| n -> 3)
  List("iii" -> 3, "v" -> 5)                      //> res1: List[(java.lang.String, Int)] = List((iii,3), (v,5))

  // Notice how the entries in the map are ordered by key values
  var tm = TreeMap(3 -> 'x', 1 -> 'x', 4 -> 'x')  //> tm  : scala.collection.immutable.TreeMap[Int,Char] = Map(1 -> x, 3 -> x, 4 -
                                                  //| > x)
  // And adding a new entris maintains the ordering
  tm += (2 -> 'x')
  tm                                              //> res2: scala.collection.immutable.TreeMap[Int,Char] = Map(1 -> x, 2 -> x, 3 -
                                                  //| > x, 4 -> x)
}
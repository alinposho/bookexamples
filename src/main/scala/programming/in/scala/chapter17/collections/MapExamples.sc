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
  List("iii" -> 3, "v" -> 5)                      //> res1: List[(String, Int)] = List((iii,3), (v,5))

  // Notice how the entries in the map are ordered by key values
  var tm = TreeMap(3 -> 'x', 1 -> 'x', 4 -> 'x')  //> tm  : scala.collection.immutable.TreeMap[Int,Char] = Map(1 -> x, 3 -> x, 4 -
                                                  //| > x)
  // And adding a new entris maintains the ordering
  tm += (2 -> 'x')
  tm                                              //> res2: scala.collection.immutable.TreeMap[Int,Char] = Map(1 -> x, 2 -> x, 3 -
                                                  //| > x, 4 -> x)

  // Converting mutable - immutable maps
  val muta = mutable.Map("i" -> 1, "ii" -> 2)     //> muta  : scala.collection.mutable.Map[String,Int] = Map(ii -> 2, i -> 1)
  val immu = Map.empty ++ muta                    //> immu  : scala.collection.immutable.Map[String,Int] = Map(ii -> 2, i -> 1)

  var m = Map(1 -> 3)                             //> m  : scala.collection.immutable.Map[Int,Int] = Map(1 -> 3)
  m += (1 -> 4)
  m                                               //> res3: scala.collection.immutable.Map[Int,Int] = Map(1 -> 4)

  m = Map(1 -> 3, 2 -> 3, 4 -> 4, 5 -> 5, 6 -> 5)
  val res = m.foldLeft(Map.empty[Int, List[Int]]) {
    case (z, (key, value)) => if (z.isDefinedAt(value)) z + (value -> (key :: z(value))) else z + (value -> List(key))
  }                                               //> res  : scala.collection.immutable.Map[Int,List[Int]] = Map(5 -> List(6, 5),
                                                  //|  3 -> List(2, 1), 4 -> List(4))

  m groupBy (_._2) map { case (key, map) => key -> map.keys.toList.sortWith(_ > _) }
                                                  //> res4: scala.collection.immutable.Map[Int,List[Int]] = Map(5 -> List(6, 5), 
                                                  //| 4 -> List(4), 3 -> List(2, 1))

}
package chapter17.collections

import scala.collection.immutable._;
import scala.collection.mutable;

object SetExamples {

	val treeSet = TreeSet("blue", "green", "red", "yellow")
                                                  //> treeSet  : scala.collection.immutable.TreeSet[java.lang.String] = TreeSet(bl
                                                  //| ue, green, red, yellow)
	val mutaSet = mutable.Set.empty ++= treeSet
                                                  //> mutaSet  : scala.collection.mutable.Set[java.lang.String] = Set(yellow, gree
                                                  //| n, blue, red)
	val immutaSet = Set.empty ++ mutaSet      //> immutaSet  : scala.collection.immutable.Set[java.lang.String] = Set(yellow, 
                                                  //| green, blue, red)


}
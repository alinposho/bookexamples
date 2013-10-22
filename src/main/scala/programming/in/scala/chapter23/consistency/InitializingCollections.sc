package programming.in.scala.chapter23.consistency

import java.awt.Color
import scala.collection.mutable.Buffer
import scala.collection.mutable.LinearSeq
import scala.collection.SortedSet

object InitializingCollections {

  Traversable(1, 2, 3) // Interesting this uses a list behind the scenes
                                                  //> res0: Traversable[Int] = List(1, 2, 3)
  Iterable("x", "y", "z") // Interesting this uses a list behind the scenes
                                                  //> res1: Iterable[String] = List(x, y, z)
  Map("x" -> 24, "y" -> 25, "z" -> 26)            //> res2: scala.collection.immutable.Map[String,Int] = Map(x -> 24, y -> 25, z -
                                                  //| > 26)
  Set(Color.RED, Color.GRAY, Color.BLUE)          //> res3: scala.collection.immutable.Set[java.awt.Color] = Set(java.awt.Color[r=
                                                  //| 255,g=0,b=0], java.awt.Color[r=128,g=128,b=128], java.awt.Color[r=0,g=0,b=25
                                                  //| 5])
  SortedSet("hello", "world")                     //> res4: scala.collection.SortedSet[String] = TreeSet(hello, world)
  Buffer("x", "y", "z")                           //> res5: scala.collection.mutable.Buffer[String] = ArrayBuffer(x, y, z)
  IndexedSeq(1.0, 2.0)                            //> res6: IndexedSeq[Double] = Vector(1.0, 2.0)
  LinearSeq("a", "b", "c")                        //> res7: scala.collection.mutable.LinearSeq[String] = MutableList(a, b, c)

}
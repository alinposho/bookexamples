package chapter3

import scala.collection.immutable.HashSet

object sets {

  // val jetSet = Set("Boeing", "Airbus") // Can't be used with the += operator
  var jetSet = Set("Boeing", "Airbus")            //> jetSet  : scala.collection.immutable.Set[java.lang.String] = Set(Boeing, Air
                                                  //| bus)
  jetSet += "Lear"
  println(jetSet.contains("Cessna"))              //> false

  val hashSet = HashSet("Tomatoes", "Chilies")    //> hashSet  : scala.collection.immutable.HashSet[java.lang.String] = Set(Chilie
                                                  //| s, Tomatoes)
  println(hashSet + "Coriander")                  //> Set(Chilies, Tomatoes, Coriander)

}
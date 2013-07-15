import scala.collection.mutable.HashMap

object lists {

  val oneTwo = List(1, 2)                         //> oneTwo  : List[Int] = List(1, 2)
  val threeFour = List(3, 4)                      //> threeFour  : List[Int] = List(3, 4)
  val oneToFour = oneTwo ::: threeFour            //> oneToFour  : List[Int] = List(1, 2, 3, 4)

  println(oneTwo + " and " + threeFour +
    " were not mutated.")                         //> List(1, 2) and List(3, 4) were not mutated.
  println("Thus, " + oneToFour + " is a new list!")
                                                  //> Thus, List(1, 2, 3, 4) is a new list!

  val treasureMap = HashMap[Int, String]()        //> treasureMap  : scala.collection.mutable.HashMap[Int,String] = Map()
  treasureMap += (1 -> "Go to island.")           //> res0: lists.treasureMap.type = Map(1 -> Go to island.)
  treasureMap += (2 -> "Find big X on ground.")   //> res1: lists.treasureMap.type = Map(1 -> Go to island., 2 -> Find big X on gr
                                                  //| ound.)
  treasureMap += (3 -> "Dig.")                    //> res2: lists.treasureMap.type = Map(3 -> Dig., 1 -> Go to island., 2 -> Find 
                                                  //| big X on ground.)
  println(treasureMap(2))                         //> Find big X on ground.
  
  
  //val romanNumeral =

}
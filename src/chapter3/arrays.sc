package chapter3

object arrays {

  val greetStrings = new Array[String](3)         //> greetStrings  : Array[String] = Array(null, null, null)
  greetStrings(0) = "Hello"
  greetStrings(1) = ", "
  greetStrings(2) = "world!"

  greetStrings mkString ""                        //> res0: String = Hello, world!
  println(greetStrings mkString "")               //> Hello, world!

  val string = for (i <- 0 to 2) yield greetStrings(i)
                                                  //> string  : scala.collection.immutable.IndexedSeq[String] = Vector(Hello, ", "
                                                  //| , world!)

  val numNames = Array("zero", "one", "two")      //> numNames  : Array[java.lang.String] = Array(zero, one, two)

  val list = List(1, 2, 3)                        //> list  : List[Int] = List(1, 2, 3)

  val oneTwo = List(1, 2)                         //> oneTwo  : List[Int] = List(1, 2)
  val threeFour = List(3, 4)                      //> threeFour  : List[Int] = List(3, 4)
  val oneTwoThreeFour = oneTwo ::: threeFour      //> oneTwoThreeFour  : List[Int] = List(1, 2, 3, 4)
  oneTwo ++ threeFour                             //> res1: List[Int] = List(1, 2, 3, 4)

	val pair = (1, "two")                     //> pair  : (Int, java.lang.String) = (1,two)
	pair._1                                   //> res2: Int = 1
	pair._2                                   //> res3: java.lang.String = two

}
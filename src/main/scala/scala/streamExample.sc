package scala

object streamExample {

  val xwffHeader = "1.1.1.1"                      //> xwffHeader  : String = 1.1.1.1

  val arrayThatContainsHeader: (List[Array[String]] => Boolean) = (logs: List[Array[String]]) => {
    logs exists { (array: Array[String]) =>
      array contains (xwffHeader)
    }
  }                                               //> arrayThatContainsHeader  : List[Array[String]] => Boolean = <function1>

  Array("127.0.0.1", xwffHeader) contains (xwffHeader)
                                                  //> res0: Boolean = true

  val stream = List(
    List(Array("127.0.0.1", "1.1.1.0"),
      Array("127.0.0.1", "1.1.1.1"),
      Array("127.0.0.1", "1.1.1.2"))).toStream    //> stream  : scala.collection.immutable.Stream[List[Array[String]]] = Stream(Li
                                                  //| st([Ljava.lang.String;@5ed6d53c, [Ljava.lang.String;@28294944, [Ljava.lang.S
                                                  //| tring;@2e8923f5), ?)
                                                  
  def fibs: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map { n => n._1 + n._2 }
                                                  //> fibs: => Stream[BigInt]
  
  val f1 = fibs take(5) toList                    //> f1  : List[BigInt] = List(0, 1, 1, 2, 3)

  stream exists (arrayThatContainsHeader)         //> res1: Boolean = true
  
  
  var set = Set(1, 2, 3)                          //> set  : scala.collection.immutable.Set[Int] = Set(1, 2, 3)
  set --= Set(1, 2)
  set                                             //> res2: scala.collection.immutable.Set[Int] = Set(3)
}
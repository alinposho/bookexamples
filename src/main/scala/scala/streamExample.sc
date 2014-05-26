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
                                                  //| st([Ljava.lang.String;@72af7b86, [Ljava.lang.String;@70ec46ff, [Ljava.lang.S
                                                  //| tring;@28294944), ?)
                                                  
  def fibs: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map { n => n._1 + n._2 }
                                                  //> fibs: => Stream[BigInt]
  
  val f1 = fibs take(5) toList                    //> f1  : List[BigInt] = List(0, 1, 1, 2, 3)

  stream exists (arrayThatContainsHeader)         //> res1: Boolean = true
}
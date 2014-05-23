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
                                                  //| st([Ljava.lang.String;@35f310c8, [Ljava.lang.String;@4d09341, [Ljava.lang.St
                                                  //| ring;@197392df), ?)

  stream exists (arrayThatContainsHeader)         //> res1: Boolean = true
}
package chapter17.collections

import scala.collection.mutable.ArrayBuffer

object ArrayExamples {

  val array = Array[String]()                     //> array  : Array[String] = Array()
  array + "String"                                //> res0: java.lang.String = [Ljava.lang.String;@320b507aString

  // Notice that in Scala Array and ArrayBuffer define both a size and a length method.
  array.size                                      //> res1: Int = 0
  array.length                                    //> res2: Int = 0

  val arrayBuf = ArrayBuffer[Int]()               //> arrayBuf  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer()
  arrayBuf += 19                                  //> res3: chapter17.collections.ArrayExamples.arrayBuf.type = ArrayBuffer(19)

  arrayBuf.size                                   //> res4: Int = 1
  arrayBuf.length                                 //> res5: Int = 1

}
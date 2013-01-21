package chapter17.collections

import scala.collection.mutable.ArrayBuffer

object ArrayExamples {

	val array = Array[String]()               //> array  : Array[String] = Array()
	array + "String"                          //> res0: java.lang.String = [Ljava.lang.String;@6d9ebfd1String

	val arrayBuf = ArrayBuffer[Int]()         //> arrayBuf  : scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer()
	arrayBuf += 19                            //> res1: chapter17.collections.ArrayExamples.arrayBuf.type = ArrayBuffer(19)

}
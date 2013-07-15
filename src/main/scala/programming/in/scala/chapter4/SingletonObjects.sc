package chapter4

import scala.collection.mutable.Map

object SingletonObjects {
	val singletonObject = SingletonObj        //> singletonObject  : chapter4.SingletonObj.type = 
	singletonObject.calculate("What an interesting computation!")
                                                  //> res0: Int = 32
 
 singletonObject                                  //> res1: chapter4.SingletonObj.type = (What an interesting computation! -> 32) 
                                                  //| 
 
 singletonObject.calculate("trace")               //> res2: Int = 5
 
 singletonObject                                  //> res3: chapter4.SingletonObj.type = (trace -> 5) (What an interesting computa
                                                  //| tion! -> 32) 
}

object SingletonObj {
  private val cache = Map[String, Int]()
  def calculate(s: String): Int =
    if (cache.contains(s))
      cache(s)
    else {
      val cs = s.length // Mindblowing computation here :P
      cache += (s -> cs)
      cs
    }
  override def toString = (cache foldRight "") ((n,acc) => "(" + n._1 + " -> " + n._2 + ")" + " " + acc)
}

// Won't compile since traits and objects may not have parameters
//object NonCompiling(val a: Int){
//
//	sum(p: Int) =  NonCompiling(a + p)
//}
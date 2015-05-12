package scala

import scala.concurrent._
import scala.concurrent.duration._
import ExecutionContext.Implicits.global
import scala.collection.mutable

object futuresSamples {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def all[T](fs: List[Future[T]]): Future[List[T]] = {
    fs.foldLeft(Future.successful(mutable.ListBuffer.empty[T])) {
      (fr, fa) => for (a <- fa; r <- fr) yield r += a
    } map { _.toList }
  }                                               //> all: [T](fs: List[scala.concurrent.Future[T]])scala.concurrent.Future[List[T
                                                  //| ]]
       
  val fs = 1 to 10 map (x => Future{ Thread.sleep(1000 - x * 100); println("x=" + x); x}) toList
                                                  //> fs  : List[scala.concurrent.Future[Int]] = List(scala.concurrent.impl.Promis
                                                  //| e$DefaultPromise@3dd4520b, scala.concurrent.impl.Promise$DefaultPromise@5ae6
                                                  //| 3ade, scala.concurrent.impl.Promise$DefaultPromise@610694f1, scala.concurren
                                                  //| t.impl.Promise$DefaultPromise@43814d18, scala.concurrent.impl.Promise$Defaul
                                                  //| tPromise@5c5a1b69, scala.concurrent.impl.Promise$DefaultPromise@3701eaf6, sc
                                                  //| ala.concurrent.impl.Promise$DefaultPromise@627551fb, scala.concurrent.impl.P
                                                  //| romise$DefaultPromise@2b552920, scala.concurrent.impl.Promise$DefaultPromise
                                                  //| @2758fe70, scala.concurrent.impl.Promise$DefaultPromise@1f36e637)
  
  val res = all(fs)                               //> res  : scala.concurrent.Future[List[Int]] = scala.concurrent.impl.Promise$De
                                                  //| faultPromise@22a67b4
  
  Await.result(res, 3.seconds)                    //> x=8
                                                  //| x=7
                                                  //| x=10
                                                  //| x=9
                                                  //| x=6
                                                  //| x=5
                                                  //| x=4
                                                  //| x=3
                                                  //| x=2
                                                  //| x=1
                                                  //| res0: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                                                  
	Await.result(Future.sequence(fs), 3.seconds)
                                                  //> res1: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
}
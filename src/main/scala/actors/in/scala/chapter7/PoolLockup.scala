package actors.in.scala.chapter7

import scala.actors.Actor._
import java.util.concurrent.CountDownLatch

object PoolLockup {
  def main(args: Array[String]) {

    val numCores = Runtime.getRuntime().availableProcessors()
    println("available cores: " + numCores)
    
    val latch = new CountDownLatch(1)
    for (i <- 1 to (numCores * 2)) actor {
      latch.await()
      println("actor " + i + " done")
    }
    
    // This is where the program will get stuck since there aren't any available
    // threads to run this actor on
    actor { latch.countDown() }
  }
}
package scala

import java.util.concurrent._
import java.util.concurrent.atomic._

object javaUtilConcurrentCollections {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val queue = new LinkedBlockingQueue[Int](5)     //> queue  : java.util.concurrent.LinkedBlockingQueue[Int] = []

  queue.remainingCapacity()                       //> res0: Int = 5
  
  for(i <- 1 to 10) {
  	queue.offer(i)
  }
  
  queue                                           //> res1: java.util.concurrent.LinkedBlockingQueue[Int] = [1, 2, 3, 4, 5]

  val callback = new MockCallback("blah")         //> callback  : MockCallback = <function1>
  
  callback.executions                             //> res2: Int = 0
  callback.executing                              //> res3: Boolean = false
  
  callback.continue()
  
  callback.executions                             //> res4: Int = 0
  callback.executing                              //> res5: Boolean = false
  

}

class MockCallback(val name: String) extends (Any => Unit) {

  private var executingAtomic = new AtomicBoolean(false)
  def executing: Boolean = executingAtomic.get()

  private var startSignal = new CountDownLatch(1);
  def continue() = startSignal.countDown()

  private val executionsAtomic: AtomicInteger = new AtomicInteger(0)
  def executions: Int = executionsAtomic.get()

  override def apply(msg: Any): Unit = {
    executingAtomic.set(true)

    if (startSignal.await(10, TimeUnit.SECONDS) == false) {
      error("Countdown latch timed out")
    }
    executionsAtomic.incrementAndGet()
    executingAtomic.set(false)
  }
}
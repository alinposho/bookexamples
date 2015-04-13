import java.util.concurrent.TimeUnit

package object util {

  def time[R](block: => R)(implicit timeUnit: TimeUnit = TimeUnit.NANOSECONDS): R = {
    val t0 = System.nanoTime()
    val result = block    // call-by-name
    val t1 = System.nanoTime()
    println("Elapsed time: " + timeUnit.convert(t1 - t0, TimeUnit.NANOSECONDS) + " " + timeUnit)
    result
  }

}

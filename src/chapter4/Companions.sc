package chapter4

import scala.collection.mutable.Map

object Companions {

	ChecksumAccumulator.calculate("Every value is an objet!")
                                                  //> res0: Int = -136

	val c = ChecksumAccumulator               //> c  : chapter4.ChecksumAccumulator.type = chapter4.ChecksumAccumulator$@77900
                                                  //| 5c4
	c.calculate("What an interesting computation")
                                                  //> res1: Int = -34


}

class ChecksumAccumulator {
  private var sum = 0
  def add(b: Byte): Unit = sum += b
  def checksum(): Int = ~(sum & 0xFF) + 1
}

object ChecksumAccumulator {
  private val cache = Map[String, Int]()
  def calculate(s: String): Int =
    if (cache.contains(s))
      cache(s)
    else {
      val acc = new ChecksumAccumulator
      for (c <- s)
        acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s -> cs)
      cs
    }
}
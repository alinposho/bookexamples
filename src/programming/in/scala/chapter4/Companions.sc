package chapter4

import scala.collection.mutable.Map

object Companions {

  ChecksumAccumulator.calculate("Every value is an objet!")
                                                  //> res0: Int = -136

  val c = ChecksumAccumulator                     //> c  : chapter4.ChecksumAccumulator.type = Every value is an objet! -> -136
  c.calculate("What an interesting computation")  //> res1: Int = -34
  c                                               //> res2: chapter4.ChecksumAccumulator.type = What an interesting computation ->
                                                  //|  -34, Every value is an objet! -> -136

}
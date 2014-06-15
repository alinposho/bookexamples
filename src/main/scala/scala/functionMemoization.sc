package scala

import scala.collection._

object functionMemoization {

  def computeKeyId(tenant: String): String = tenant + " keyId"
                                                  //> computeKeyId: (tenant: String)String

  lazy val keyIdFoTenant: mutable.Map[String, Any] =
    (new mutable.LinkedHashMap[String, Any]() with mutable.SynchronizedMap[String, Any]).withDefault { tenant =>
      val keyId = computeKeyId(tenant) // replace with function that computes keyId
      keyIdFoTenant.put(tenant, keyId)
      keyId
    }                                             //> keyIdFoTenant: => scala.collection.mutable.Map[String,Any]

  keyIdFoTenant("tenant1")                        //> res0: Any = tenant1 keyId
  keyIdFoTenant                                   //> res1: scala.collection.mutable.Map[String,Any] = Map(tenant1 -> tenant1 keyI
                                                  //| d)
  keyIdFoTenant("tenant1")                        //> res2: Any = tenant1 keyId

  val res = List(1, 2, 3) zip List("a", "b")      //> res  : List[(Int, String)] = List((1,a), (2,b))
  val (numbers, strings) = res.unzip              //> numbers  : List[Int] = List(1, 2)
                                                  //| strings  : List[String] = List(a, b)
  numbers.zipWithIndex                            //> res3: List[(Int, Int)] = List((1,0), (2,1))

}
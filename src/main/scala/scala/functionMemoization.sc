package scala

import scala.collection._

object functionMemoization {

	def computeKeyId(tenant: String): String = tenant + " keyId"
                                                  //> computeKeyId: (tenant: String)String

 lazy val keyIdFoTenant: mutable.Map[String, Any] =
 		(new mutable.LinkedHashMap[String, Any]()
 				 with mutable.SynchronizedMap[String, Any]).withDefault { tenant =>
    val keyId = computeKeyId(tenant) // replace with function that computes keyId
    keyIdFoTenant.put(tenant, keyId)
    keyId
  }                                               //> keyIdFoTenant: => scala.collection.mutable.Map[String,Any]
  
  keyIdFoTenant("tenant1")                        //> res0: Any = tenant1 keyId
  keyIdFoTenant                                   //> res1: scala.collection.mutable.Map[String,Any] = Map(tenant1 -> tenant1 keyI
                                                  //| d)
  keyIdFoTenant("tenant1")                        //> res2: Any = tenant1 keyId
  
                                                  
                                                  
}
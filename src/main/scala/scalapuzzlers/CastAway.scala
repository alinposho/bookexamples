package scalapuzzlers

object CastAway extends App {
  import scala.collection.JavaConverters._
  def fromJava: java.util.Map[String, java.lang.Integer] = {
    val map = new java.util.HashMap[String, java.lang.Integer]()
    map.put("key", null)
    map
  }

  // watch out here...Integer is not Int!
  val map = fromJava.asScala.asInstanceOf[scala.collection.Map[String, Int]]
  println(map("key") == null)
  println(map("key") == 0)
}
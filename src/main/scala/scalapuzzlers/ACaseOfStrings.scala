package scalapuzzlers

object ACaseOfStrings {
  
  def main(args: Array[String]): Unit = {
    
    val objectFromJava: Object = "string"
    val stringFromJava: String = null
    
    def printLengthOfString(a: AnyRef): Unit = a match { 
      case s: String => println("String of length " + s.length)
      case _ => println("Not a string")
    }
    
    printLengthOfString(objectFromJava)
    printLengthOfString(stringFromJava)

  }
  
}
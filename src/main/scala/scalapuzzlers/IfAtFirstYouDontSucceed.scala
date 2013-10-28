package scalapuzzlers

object IfAtFirstYouDontSucceed extends App {

  var x = 0;
  lazy val y = 1/x
  
  try{
    println(y)
  } catch {
    case _:Throwable => // This branch will get taken 
      x = 1 // x will be set to 1
      println(y) // y will evaluate to 1/1=1
  }

}
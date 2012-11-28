package chapter7

object InfiniteWhileLoop extends App{
  
  println("Write somthing to inlustrate the usage of the infinite while loop:")

  var line = ""
  while ((line = readLine()) != "") // This doesn’t work!
    println("Read: " + line)
  
}
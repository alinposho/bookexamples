package chapter7

import scala.util.control.Breaks._
import java.io._

object BreakExample extends App {

  val in = new BufferedReader(new InputStreamReader(System.in))
  breakable { // This is actually a function call
    while (true) {
      println("? ")
      if (in.readLine() == "") break // In this case break is a function call! 
    }
  }

}
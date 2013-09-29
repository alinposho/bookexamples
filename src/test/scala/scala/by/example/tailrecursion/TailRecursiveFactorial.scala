package scala.by.example.tailrecursion

import scala.annotation.tailrec

object TailRecursiveFactorial {

  def factorial(n: Int): Int = {
    @tailrec
    def factorial(n: Int, acc: Int): Int = {
      if(n <= 1) acc
      else {
        factorial(n - 1, n * acc)
      }
    }
    factorial(n, 1)
  }
  
  def main(args: Array[String]): Unit = {
    println("4! = " + factorial(4));
    println("10! = " + factorial(10));
  }
}
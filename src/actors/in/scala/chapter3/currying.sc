package actors.in.scala.chapter3

import scala.tools.nsc.io.Socket
import java.io._
import scala.io._

object currying {

  def withSocket[T](socket: Socket)(f: Socket => T): T = {
    try {
      f(socket)
    } finally {
      socket.close()
    }
  }                                               //> withSocket: [T](socket: scala.tools.nsc.io.Socket)(f: scala.tools.nsc.io.Soc
                                                  //| ket => T)T

  // Now a sample ofhow to use a socket
  //  val socket: Socket
  //  withSocket(socket) {
  //    s => // Read from the socket, socket is available ass
  //  }

  // A more generic example
  def withResource[A <: { def close(): Unit }, B](param: A)(f: A => B): B = {
    try {
      f(param)
    } finally {
      param.close()
    }
  }                                               //> withResource: [A <: AnyRef{def close(): Unit}, B](param: A)(f: A => B)B

  val console = new PrintWriter(new File("console.txt"))
                                                  //> console  : java.io.PrintWriter = java.io.PrintWriter@13b2f057

  withResource(console) {
    console => console.println("This is an interesting message :P")
  }
  
  Source.fromFile("console.txt").getLines         //> res0: Iterator[String] = non-empty iterator

}
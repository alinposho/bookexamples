package chapter9.controlabstractions

import java.io._

object WithPrintWriter {

  def withPrintWriter(file: File)(op: PrintWriter => Unit) {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }                                               //> withPrintWriter: (file: java.io.File)(op: java.io.PrintWriter => Unit)Unit

  val file = new File("date.txt")                 //> file  : java.io.File = date.txt
  withPrintWriter(file) {
    writer => writer.println(new java.util.Date)
  }

}
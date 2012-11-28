package chapter8

import scala.io.Source

object LongLinesLocalFunction {

  def processFile(filename: String, width: Int) {

    def processLine(filename: String, line: String, width: Int) {
      if (line.length() > width) {
        println(filename + ": " + line)
      }
    }

    val source = Source.fromFile(filename)
    for (line <- source.getLines)
      processLine(filename, line, width)
  }

}
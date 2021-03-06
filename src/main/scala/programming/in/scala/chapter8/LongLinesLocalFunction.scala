package chapter8

import scala.io.Source

object LongLinesLocalFunction {

  def processFile(filename: String, width: Int) {

    def processLine(line: String) {
      if (line.length() > width) {
        println(filename + ": " + line)
      }
    }

    val source = Source.fromFile(filename)
    for (line <- source.getLines)
      processLine(line)
  }

}
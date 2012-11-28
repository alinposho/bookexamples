package chapter8

import scala.io.Source

object LongLines {

  def processFile(filename: String, width: Int) {
	  val source = Source.fromFile(filename)
	  for(line <- source.getLines)
	    processLine(filename, line, width)
  }
  
  private def processLine(filename: String, line: String, width: Int) {
    if(line.length() > width) {
      println(filename + ": " + line)
    }
  }

}
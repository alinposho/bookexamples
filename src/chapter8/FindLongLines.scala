package chapter8

object FindLongLines {
	def main(args: Array[String]){
	  val width = args(0).toInt
	  for(arg <- args drop 1)
	    LongLinesLocalFunction.processFile(arg, width)
//	    LongLines.processFile(arg, width)
	}
}

// This is the command that can be used in the terminal to run the application:
// scala -cp . chapter8.FindLongLines 5 ../src/chapter8/FindLongLines.scala ../src/chapter8/LongLines.scala

// Running the same application from Eclipse requires providing these args:
// 5 ./src/chapter8/FindLongLines.scala


import scala.io.Source

def widthOfLength(s: String) = s.length.toString.length
def longestLine(lines: List[String]) = lines reduceLeft ((a, b) => if (a.length > b.length) a else b)

if (args.length > 0) {
  val lines = Source.fromFile(args(0)).getLines().toList
  val maxWidth = longestLine(lines)
  for (line <- lines) {
    val numSpaces = maxWidth - widthOfLength (line)
    val padding = " " * numSpaces
    println(padding + line.length + " | " + line)
  }
} else
  Console.err.println("Please enter filename")


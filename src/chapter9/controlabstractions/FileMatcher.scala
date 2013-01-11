package chapter9.controlabstractions

object FileMatcher {
  private def filesHere = (new java.io.File(".")).listFiles

  private def filesMatching(matcher: String => Boolean) =
    for (
      file <- filesHere;
      if matcher(file.getName)
    ) yield file

    
    def filesEnding(query: String) =
      filesMatching(_.endsWith(query))
// The function is equivalent to  
//  def filesEnding(query: String) =
//    filesMatching((fileName: String) => fileName.endsWith(query))
    
  def filesContaining(query: String) =
    filesMatching(_.contains(query))

  def filesRegex(query: String) =
    filesMatching(_.matches(query))

  def main(args: Array[String]) {
    println("Files containing scala: " + (FileMatcher.filesContaining("scala") map (_.getName())));
  }
}
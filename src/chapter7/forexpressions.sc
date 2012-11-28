package chapter7

object forexpressions {

  val filesHere = new java.io.File(".").listFiles()
                                                  //> filesHere  : Array[java.io.File] = Array(.\.eclipseproduct, .\artifacts.xml, 
                                                  //| .\configuration, .\eclipse .ini_backup, .\eclipse.exe, .\eclipse.ini, .\eclip
                                                  //| sec.exe, .\epl-v10.html, .\features, .\notice.html, .\p2, .\plugins, .\readme
                                                  //| , .\Scala IDE.lnk)

  def fileLines(file: java.io.File) =
    scala.io.Source.fromFile(file).getLines().toList
                                                  //> fileLines: (file: java.io.File)List[String]

  def grep(pattern: String): Array[String] = {
    val result =
      for (
        file <- filesHere if file.getName.endsWith(".exe");
        line <- fileLines(file) if line.trim.matches(pattern)
      ) yield file + ": " + line.trim
      result
  }                                               //> grep: (pattern: String)Array[String]

  //grep(".*gcd.*") // Returns nothing
  //grep(".*eclipse*")

}
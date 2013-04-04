package actors.in.scala.chapter9.mapreduce

object InvertedIndexMain {

  def main(args: Array[String]) {
    val invertedIndex = new InvertedIndex()
    invertedIndex.start
    val input = List(("file1", List("word1, word1, word3")), ("file2", List("word4", "word1", "word5", "word2")))

    val result = invertedIndex !! InvertedIndexInput(input)

    result() match {
      case list: Map[_, _] =>
        println(list)
      case any =>
        println("The result did not match the expected result type")
        println(any);
    }
  }

}
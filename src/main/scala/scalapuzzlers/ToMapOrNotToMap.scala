package scalapuzzlers

object ToMapOrNotToMap extends App {
  import collection.immutable.SortedSet
  val numerals: SortedSet[RomanNumeral] = SortedSet(RomanNumeral(1000, "M"), RomanNumeral(100, "C"), RomanNumeral(1, "I"), RomanNumeral(10, "X"))

  println("1 10 100 1000 in Roman numerals:")
  numerals.foreach { numeral => print(numeral.representation + " ") }
  println()
  numerals.map(_.representation).foreach { representation => print(representation + " ") }
}

case class RomanNumeral(value: Int, representation: String) extends Ordered[RomanNumeral] {
  override def compare(numeral: RomanNumeral) = this.value - numeral.value
}

def filter(xs: List[Int], p: Int => Boolean): List[Int] =
  if (xs.isEmpty) xs
  else if (p(xs.head)) xs.head :: filter(xs.tail, p)
  else filter(xs.tail, p)
def modN(n: Int)(x: Int) = ((x % n) == 0)

val nums= (1 to 8).toList
nums.filter(modN(2))

val cities = Map("Atlanta" -> "GA", "New York" -> "New York",
  "Chicago" -> "IL", "San Francsico " -> "CA", "Dallas" -> "TX")

cities map { case (k, v) => println(k + " -> " + v) }

// The following will raise an exception since the function passed to map is not defined for Strings
//List(1, 3, 5, "seven") map { case i: Int => i + 1 }

List(1, 3, 5, "seven") collect { case i: Int => i + 1 }

val answerUnits = new PartialFunction[Int, Int] {
  def apply(d: Int) = 42 / d
  def isDefinedAt(d: Int) = d != 0
}

answerUnits.isDefinedAt(42)
answerUnits.isDefinedAt(0)

def pAnswerUnits: PartialFunction[Int, Int] = { case d: Int if d != 0 => 42 / d }

pAnswerUnits(1)
// The following will raise an error.
//pAnswerUnits(0)

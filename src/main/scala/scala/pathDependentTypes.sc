// More details about this example of using path-dependent types in Scala
// http://stackoverflow.com/questions/2693067/what-is-meant-by-scalas-path-dependent-types
case class Board(length: Int, height: Int) {
  case class Coordinate(x: Int, y: Int) {
    require(0 <= x && x < length && 0 <= y && y < height)
  }
  val occupied = scala.collection.mutable.Set[Coordinate]()
}

val b1 = Board(20, 20)
val b2 = Board(30, 30)
val c1 = b1.Coordinate(15, 15)
val c2 = b2.Coordinate(25, 25)
b1.occupied += c1
b2.occupied += c2
// Next line doesn't compile
//b1.occupied += c2


// But this does compile because the Coordinate type is dependent
// on the b1.type not the b1 variable itself.
val b3: b1.type = b1
val c3 = b3.Coordinate(10, 10)
b1.occupied += c3


val b4 = b1
val c4 = b4.Coordinate(9, 9)
// This will not compile either since b4.Coordinate is not referring to the
// same type as b1.Coordinate
// b1.occupied += c4


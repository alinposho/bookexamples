package chapter13.visibilityandcompanionobjects

// The lists package object is defined in chapter16.lists package
import lists._

object PackageObjectTest {
  println("Testing the import of package object definition from another package")
                                                  //> Testing the import of package object definition from another package
  
  // Using msort from the list package object in chapter16.lists package
  msort((x: Int, y: Int) => x < y)(List(87382, -1888, 8787, 7, 4, 5, 3, 1))
                                                  //> res0: List[Int] = List(-1888, 1, 3, 4, 5, 7, 8787, 87382)
  
  
}
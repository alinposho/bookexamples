package programming.in.scala.chapter21.implicits

object ConversionToAnExpectedType {
	
	implicit def doubleToIn(x: Double) = x.toInt
                                                  //> doubleToIn: (x: Double)Int

	// This won't work without an implicit conversion method define above
	val i: Int = 3.5                          //> i  : Int = 3
	
	// Behind the scenes the above code becomes
	val newInt: Int = doubleToIn(3.5)         //> newInt  : Int = 3

}
package scalapuzzlers

/**
 *  This is a clear example of how match works and that
 */
object UpstairsDownstairs {

	var IJ: (Int, Int) = (3, 4)               //> IJ  : (Int, Int) = (3,4)
	// var (I, J): (Int, Int) = (3, 4) // This will not compile since the Scala compiler
	// will try to match the I and J constants against (3, 4). I suspect that the code
	// gets translated into this:
	/*
	var (x, y) = (3, 4) match {
	case (I, J) => (I, J)
	}
	*/
	
	//val 2 = 3 // This will raise a MatchError exception

}
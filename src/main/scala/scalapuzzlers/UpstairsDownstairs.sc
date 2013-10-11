package scalapuzzlers

/**
 *  This is a clear example of how match works and that
 */
object UpstairsDownstairs {

  var IJ: (Int, Int) = (3, 4)                     //> IJ  : (Int, Int) = (3,4)
  // var (I, J): (Int, Int) = (3, 4) // This will not compile since the Scala compiler
  // will try to match the I and J constants against (3, 4). I suspect that the code
  // gets translated into this:
  /*
	var (x, y) = (3, 4) match {
	case (I, J) => (I, J)
	}
	*/

  // But this will work
  var (i, j): (Int, Int) = (3, 4)                 //> i  : Int = 3
                                                  //| j  : Int = 4

  (3, 4) match {
    case (i, j) => println(i, j)
  }                                               //> (3,4)

  //val 2 = 3 // This will raise a MatchError exception

}
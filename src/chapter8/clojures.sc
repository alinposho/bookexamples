package chapter8

object clojures {

	// The code bellow won't compile since more is not bound
	//def closure(x: Int): Int = x + more
	
	// However this code will
	var more = 10;                            //> more  : Int = 10
	
	val addMore = (x: Int) => x + more        //> addMore  : Int => Int = <function1>
	
	addMore(1)                                //> res0: Int = 11

	// Some weird logic below
	more = 99999
	
	addMore(1)                                //> res1: Int = 100000





}
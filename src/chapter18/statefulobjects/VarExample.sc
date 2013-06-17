package chapter18.stafulobjects

object VarExample {
  val t = new Time()                              //> t  : chapter18.stafulobjects.Time = chapter18.stafulobjects.Time@5d1f1d6

	// Notice the generated setter method
	t.hour_=(100)
	// And the getter method that was automatically generated
	t.hour                                    //> res0: Int = 100
	
	// Notice that one can also use the setter - or is it the actual field - to set
	// the value
	t.hour = 50
	t.hour                                    //> res1: Int = 50
	// OR
	t.hour = (99)
	t.hour                                    //> res2: Int = 99
	
	t.minute                                  //> res3: Int = 0
}

class Time {
  var hour = 12
  val minute = 0
}
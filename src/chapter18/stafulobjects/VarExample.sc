package chapter18.stafulobjects

object VarExample {
  val t = new Time()                              //> t  : chapter18.stafulobjects.Time = chapter18.stafulobjects.Time@699c8551

	// Notice the generated setter method
	t.hour_=(100)
	t.hour                                    //> res0: Int = 100
	
	// Notice that one can also use the setter - or is it the actual field - to set
	// the value
	t.hour = 50
	t.hour                                    //> res1: Int = 50
	// OR
	t.hour = (99)
	t.hour                                    //> res2: Int = 99
}

class Time {
  var hour = 12
  var minute = 0
}
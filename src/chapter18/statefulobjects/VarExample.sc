package chapter18.stafulobjects

object VarExample {
  val t = new Time()                              //> t  : chapter18.stafulobjects.Time = chapter18.stafulobjects.Time@2d8c93dc

  // Notice the generated setter method
  t.hour_=(100)
  // And the getter method that was automatically generated
  t.hour                                          //> res0: Int = 100

  // Notice that one can also use the setter - or is it the actual field - to set
  // the value
  t.hour = 50
  t.hour                                          //> res1: Int = 50
  // OR
  t.hour = (99)
  t.hour                                          //> res2: Int = 99

  t.minute                                        //> res3: Int = 0

  val weirdClass = new PrivateGetterSetter        //> weirdClass  : chapter18.stafulobjects.PrivateGetterSetter = chapter18.staful
                                                  //| objects.PrivateGetterSetter@7709c5c

  // This will not compile
  // weirdClass.value
  // weirdClass.value = 100
}

class Time {
  var hour = 12
  val minute = 0
}

class PrivateGetterSetter {
  private var value = 1200;

// This will not compile since the getter is already defined for "value" however, it is private
//  def value_=(v: Int) {
//    value = v
//  }
}
package scala.by.example.variance.annotations

object MyStackExample {

	val stack = EmptyStack.push(678)          //> stack  : scala.by.example.variance.annotations.MyStack[Int] = 678 -> <empty>
                                                  //| 
	// This will produce a stack of AnyVal
	stack.push(873.9)                         //> res0: scala.by.example.variance.annotations.MyStack[AnyVal] = 873.9 -> 678 -
                                                  //| > <empty>

}
package chapter3

object FunctionalStyle {

	def formatArgs(args: Array[String]) = args mkString "\n"
                                                  //> formatArgs: (args: Array[String])String
	
	formatArgs(Array("alin", "mada", "hello", "world"));
                                                  //> res0: String = alin
                                                  //| mada
                                                  //| hello
                                                  //| world








}
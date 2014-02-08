package scala.in.depth.chapter2.the.core.rules

import java.io.File

object useNoneInsteadOfNull {

	// This is interesting since it will return None
	val none = Option(null)                   //> none  : Option[Null] = None
	
	def getTemporaryDirectory(tmpArg: Option[String]): Option[File] = tmpArg map (name =>
		new File(name)) filter(_.isDirectory())
                                                  //> getTemporaryDirectory: (tmpArg: Option[String])Option[java.io.File]
                                                  
  getTemporaryDirectory(Option("blah"))           //> res0: Option[java.io.File] = None
  getTemporaryDirectory(Option("/tmp"))           //> res1: Option[java.io.File] = Some(/tmp)
  // What about a file that is not a directory
  getTemporaryDirectory(Option("/tmp/.google-talk-plugin-alinposho.lock"))
                                                  //> res2: Option[java.io.File] = None

}
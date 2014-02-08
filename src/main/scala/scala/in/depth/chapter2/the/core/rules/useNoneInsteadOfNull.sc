package scala.in.depth.chapter2.the.core.rules

import java.io.File

object useNoneInsteadOfNull {

  // This is interesting since it will return None
  val none = Option(null)                         //> none  : Option[Null] = None

  def getTemporaryDirectory(tmpArg: Option[String]): Option[File] = tmpArg map (name =>
    new File(name)) filter (_.isDirectory())      //> getTemporaryDirectory: (tmpArg: Option[String])Option[java.io.File]

  getTemporaryDirectory(Option("blah"))           //> res0: Option[java.io.File] = None
  getTemporaryDirectory(Option("/tmp"))           //> res1: Option[java.io.File] = Some(/tmp)
  // What about a file that is not a directory
  getTemporaryDirectory(Option("/tmp/.google-talk-plugin-alinposho.lock"))
                                                  //> res2: Option[java.io.File] = None

  // I use Connection instead of the DriverManager.getConnectio(...) method because I do not want stupid Exceptions in the code
  case class Connection(url: String, user: String, password: String)
  def getConnection(url: String, user: String, password: String) = Connection(url, user, password)
                                                  //> getConnection: (url: String, user: String, password: String)scala.in.depth.c
                                                  //| hapter2.the.core.rules.useNoneInsteadOfNull.Connection
  def createConnection(url: Option[String], user: Option[String], password: Option[String]) = {
    for {
      u <- url
      us <- user
      p <- password
    } yield getConnection(u, us, p)
  }                                               //> createConnection: (url: Option[String], user: Option[String], password: Opt
                                                  //| ion[String])Option[scala.in.depth.chapter2.the.core.rules.useNoneInsteadOfN
                                                  //| ull.Connection]

  createConnection(Option("url"), Option("user"), Option("password"))
                                                  //> res3: Option[scala.in.depth.chapter2.the.core.rules.useNoneInsteadOfNull.Co
                                                  //| nnection] = Some(Connection(url,user,password))
  // Defining a function that can lift any other 3 arg funciton to use Option
  def lift3[A, B, C, D](f: (A, B, C) => D)(oa: Option[A], ob: Option[B], oc: Option[C]) = {
    for {
      a <- oa
      b <- ob
      c <- oc
    } yield f(a, b, c)
  }                                               //> lift3: [A, B, C, D](f: (A, B, C) => D)(oa: Option[A], ob: Option[B], oc: Op
                                                  //| tion[C])Option[D]
	lift3(getConnection)(Option("url"), Option("user"), Option("password"))
                                                  //> res4: Option[scala.in.depth.chapter2.the.core.rules.useNoneInsteadOfNull.Co
                                                  //| nnection] = Some(Connection(url,user,password))
	
	def getConnLifted = lift3(getConnection) _//> getConnLifted: => (Option[String], Option[String], Option[String]) => Optio
                                                  //| n[scala.in.depth.chapter2.the.core.rules.useNoneInsteadOfNull.Connection]
  getConnLifted(Option("url"), Option("user"), Option("password"))
                                                  //> res5: Option[scala.in.depth.chapter2.the.core.rules.useNoneInsteadOfNull.Co
                                                  //| nnection] = Some(Connection(url,user,password))
 // Option equals and hashCode depends on the content
 class A
 
 val o1 = Some(new A)                             //> o1  : Some[scala.in.depth.chapter2.the.core.rules.useNoneInsteadOfNull.A] =
                                                  //|  Some(scala.in.depth.chapter2.the.core.rules.useNoneInsteadOfNull$$anonfun$
                                                  //| main$1$A$1@6f36b859)
 val o2 = Some(new A)                             //> o2  : Some[scala.in.depth.chapter2.the.core.rules.useNoneInsteadOfNull.A] =
                                                  //|  Some(scala.in.depth.chapter2.the.core.rules.useNoneInsteadOfNull$$anonfun$
                                                  //| main$1$A$1@71811419)
 
 o1 == o2                                         //> res6: Boolean = false
 
 Some("String") == Some("String")                 //> res7: Boolean = true
                     
}
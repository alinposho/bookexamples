package scala.by.example.regexp

object SimpleRegexpTest {
  val intMatch = """(\d+)\s+(\d+)""".r            //> intMatch  : scala.util.matching.Regex = (\d+)\s+(\d+)

  intMatch findFirstIn ("   8787487588    382783 78273    ")
                                                  //> res0: Option[String] = Some(8787487588    382783)

  val message = "   8787487588    382783 78273    "
                                                  //> message  : String = "   8787487588    382783 78273    "
  val intMatch(noPages, noProcessed) = intMatch.findFirstIn(message).get
                                                  //> noPages  : String = 8787487588
                                                  //| noProcessed  : String = 382783

  intMatch.findAllIn("  6734 98 767 898 ").toList //> res1: List[String] = List(6734 98, 767 898)

  val text = "\\}".r                              //> text  : scala.util.matching.Regex = \}
  
  intMatch.findFirstIn("kjkf } ksjks")            //> res2: Option[String] = None
  
  "sadas { asdjhajk: ksjdksjd} sdasd".split("\\{([^}]*.?)\\}")
                                                  //> res3: Array[String] = Array("sadas ", " sdasd")
  
  
  
}
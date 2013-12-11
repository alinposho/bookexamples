package scala.by.example.regexp

object SimpleTest {
	 val intMatch = """(\d+)\s+(\d+)""".r     //> intMatch  : scala.util.matching.Regex = (\d+)\s+(\d+)
	 
	 intMatch findFirstIn("8787487588    382783 78273")
                                                  //> res0: Option[String] = Some(8787487588    382783)


}
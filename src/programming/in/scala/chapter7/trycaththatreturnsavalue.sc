package chapter7

import java.net.URL
import java.net.MalformedURLException

object trycaththatreturnsavalue {

  def urlFor(path: String): URL = {
    try {
      new URL(path)
    } catch {
      case e: MalformedURLException =>
        new URL("http://www.scala-lang.org")
    }
  }                                               //> urlFor: (path: String)java.net.URL

	//MalformedURLException catch clause returns a default URL
	urlFor("kjdsk")                           //> res0: java.net.URL = http://www.scala-lang.org
	
	// While a well formatted string is turned into an URL
	urlFor("http://www.google.com")           //> res1: java.net.URL = http://www.google.com

}
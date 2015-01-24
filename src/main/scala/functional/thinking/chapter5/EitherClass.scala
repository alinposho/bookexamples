package functional.thinking.chapter5

import java.net.URL

import scala.io.Source
import scala.util.control.NonFatal

object EitherClass extends App {
  type Error = Throwable
  type Success = String

  def call(url: String): Either[Error, Success] = {
    try {
      val response = Source.fromURL(url).getLines().mkString("\n")
      Right(response)
    } catch {
      case NonFatal(e) => Left(e)
    }
  }

  call("http://google.com") match {
    case Left(msg) => println(msg)
    case Right(content) => println(content)
  }

}

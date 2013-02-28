package actors.in.scala.chapter6

import scala.actors.Actor.link
import scala.actors.Actor.loopWhile
import scala.actors.Actor.react
import scala.actors.Actor.reply
import scala.actors.Actor.self
import scala.actors.Exit
import scala.actors.UncaughtException

object FuturesAndReactingToTerminationMessages {

  case class ImageData(data: String)
  case class ImageInfo(imageName: String, imageData: String) {

    def downloadImage(): ImageData = {
      println("Downloaded image data: " + imageData)
      ImageData(imageData)
    }
  }
  case class Download(imageInfo: ImageInfo)

  def scanForImageInfo(url: String): List[ImageInfo] = {
    println("Scanning for immages at " + url)
    val result = for (i <- 1 to 6) yield {
      ImageInfo("Image" + i + "from url " + url, "Image data " + i + "from url " + url)
    }

    result.toList
  }

  def renderImage(data: ImageData) {
    println("Rendering image data: " + data)
  }

  def renderImages(url: String) {
    val imageInfos = scanForImageInfo(url)
    self.trapExit = true

    println("Creating futures to load image data")
    val dataFutures = for (info <- imageInfos) yield {
      val loader = link {
        react {
          case Download(info) =>
            throw new Exception("no connection")
            reply(info.downloadImage())
        }: Unit
      }
      loader !! Download(info)
    }

    var i = 0
    loopWhile(i < imageInfos.size) {
      i += 1
      dataFutures(i - 1).inputChannel.react {
        case data @ ImageData(_) =>
          renderImage(data)
        case Exit(from, UncaughtException(_, Some(Download(info)), _, _, cause)) =>
          println("Couldn't download image " + info + " because of " + cause)
      }
    }
    println("OK, all images rendered.") 
  }

  def main(args: Array[String]) {
    renderImages("alin.com")
  }

}
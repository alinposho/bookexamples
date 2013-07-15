package actors.in.scala.chapter9.mapreduce.generic

import scala.actors.Actor
import scala.actors.scheduler.DaemonScheduler
import actors.in.scala.chapter9.mapreduce.common.InvertedIndexInput
import actors.in.scala.chapter9.mapreduce.common.InvertedIndexInput

class InvertedIndexGeneric extends Actor {

  case class Intermediate(list: List[(String, String)])

  override def scheduler = DaemonScheduler
  private var mapReduceStrategy = new MapReduce(this)
  
  def setMapReduceStrategy(mapReduceStrategy: MapReduce) {
    this.mapReduceStrategy = mapReduceStrategy
  }
  
  override def act() {
    react {
      case InvertedIndexInput(input) =>
        val result = mapReduceStrategy.mapReduce[String, List[String], String, String](input, mapping, reduceIndex)
        sender ! result
        exit()
      case any =>
        println("Unknown message! The actor will terminate")
        reply()
    }
  }

  private def mapping(file: String, words: List[String]): List[(String, String)] = {
    val wordFileList = for (word <- words) yield {
      (word, file)
    }
    wordFileList
  }

  def reduceIndex(key: String, files: List[String]) =
    files.distinct

}


package actors.in.scala.chapter9.mapreduce.generic

import scala.actors.Actor.self
import scala.actors.Actor.actor
import scala.actors.Actor.receive
import java.io.File
import scala.actors.Actor
import scala.actors.scheduler.DaemonScheduler

class InvertedIndexGeneric extends Actor {

  override def scheduler = DaemonScheduler

  override def act() {
    react {
      case InvertedIndexInput(input) =>
        val mapReduceStrategy = new MapReduceBasic(this)
        val result = mapReduceStrategy.mapReduceBasic[String, List[String], String, String](input, mapping, reduceIndex)
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

case class InvertedIndexInput(list: List[(String, List[String])])
case class Intermediate(list: List[(String, String)])




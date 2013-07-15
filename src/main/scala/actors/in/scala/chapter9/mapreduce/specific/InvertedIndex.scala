package actors.in.scala.chapter9.mapreduce.specific

import scala.actors.Actor.self
import scala.actors.Actor.actor
import scala.actors.Actor
import scala.actors.scheduler.DaemonScheduler
import actors.in.scala.chapter9.mapreduce.common.InvertedIndexInput

class InvertedIndex extends Actor {

  case class Intermediate(list: List[(String, String)])
  
  override def scheduler = DaemonScheduler
  
  override def act() {
    react {
      case InvertedIndexInput(input) =>
        val result = invertedIndex(input)
        sender ! result
        exit()
      case any =>
        println("Unknown message! The actor will terminate")
        reply()
    }
  }

  private def invertedIndex(input: List[(String, List[String])]) = {
    if (input.isEmpty) Map()
    else {
      val master = self

      map(input, master)
      val intermediates = collectIntermediateResults(input)
      val result = reduce(intermediates)
      result
    }
  }

  private def map(input: List[(String, List[String])], master: Actor): List[Actor] = {
    for ((file, words) <- input) yield {
      actor {
        master ! Intermediate(mapIndex(file, words))
      }
    }
  }
  
  private def mapIndex(key: String, values: List[String]): List[(String, String)] = {
    for (value <- values) yield (value, key)
  }

  private def collectIntermediateResults(input: List[(String, List[String])]): List[(String, String)] = {

    var intermediates = List[(String, String)]()
    for (_ <- 1 to input.length)
      receive {
        case Intermediate(list) => intermediates = list ++ intermediates
      }
    intermediates
  }
  
  private def reduce(intermediates: List[(String, String)]): Map[String,List[String]] = {
    
    val dict = groupValuesByKeys(intermediates)
    val result = removeDuplicateValues(dict)
    result
  }
  
  private def groupValuesByKeys(intermediates: List[(String, String)]): Map[String,List[String]] = {

    var dict = Map[String, List[String]]() withDefault (k => List())
    for ((word, file) <- intermediates)
      dict += (word -> (file :: dict(word)))
    dict
  }
  
  private def removeDuplicateValues(dict: Map[String,List[String]]): Map[String,List[String]] = {
    var result = Map[String, List[String]]()
    for ((word, files) <- dict)
      result += (word -> files.distinct)
    result
  }

}


package actors.in.scala.chapter9.mapreduce

import scala.actors.Actor.self
import scala.actors.Actor.actor
import scala.actors.Actor.receive
import java.io.File
import scala.actors.Actor

object InvertedIndex extends Actor {
  
  override def act() {
    react{
      case InvertedIndexInput(input) => 
        val result = invertedIndex(input)
        reply(result)
      case any => 
        println("Unknown message! The actor will terminate")
        reply()
    }
  }

  def invertedIndex(input: List[(String, List[String])]) = {
    val master = self
    val workers = map(input, master)
    
    val intermediates = collectIntermediateResults(input)
    
    var dict = Map[String, List[String]]() withDefault (k => List())
    for ((word, file) <- intermediates)
      dict += (word -> (file :: dict(word)))
    var result = Map[String, List[String]]()
    for ((word, files) <- dict)
      result += (word -> files.distinct)
    result
  }

  private def map(input: List[(String, List[String])], master: Actor): List[Actor] = {

    for ((file, words) <- input) yield {
      actor {
        val wordsAndFiles = for (word <- words) yield (word, file)
        master ! Intermediate(wordsAndFiles)
      }
    }

  }
  
  private def collectIntermediateResults(input: List[(String, List[String])]): List[(String, String)] = {

    var intermediates = List[(String, String)]()
    for (_ <- 1 to input.length)
      receive {
        case Intermediate(list) => intermediates :::= list
      }
    intermediates
  }

}

case class InvertedIndexInput(list: List[(String, List[String])]) 
case class Intermediate(list: List[(String, String)])




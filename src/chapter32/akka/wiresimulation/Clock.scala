package chapter32.akka.wiresimulation

import scala.actors._
import scala.actors.Actor._
import sun.reflect.generics.reflectiveObjects.NotImplementedException

class Clock extends Actor {

  private var running = false
  private var currentTime = 0
  private var agenda: List[WorkItem] = List()
  private var allSimulants = List[Actor]()
  private var busySimulants: Set[Actor] = Set.empty
  
  def add(sim: Simulant) {
    allSimulants = sim :: allSimulants
  }

  def act() {
    loop {
      if (running && busySimulants.isEmpty) {
        advance()
      } else {
        reactToOneMessage()
      }

    }
  }

  def advance() {
    if (agenda.isEmpty && currentTime > 0) {
      println("** Agenda empty. Clock exiting at time " + currentTime + ".")
      self ! Stop
      return
    }

    currentTime += 1

    println("Advancing to time " + currentTime)
    processCurrentEvents()
    for (sim <- allSimulants)
      sim ! Ping(currentTime)
    busySimulants = Set.empty ++ allSimulants
  }

  private def processCurrentEvents() {
    val todoNow = agenda.takeWhile(_.time <= currentTime)
    agenda = agenda.drop(todoNow.length)
    for (WorkItem(time, msg, target) <- todoNow) {
      assert(time == currentTime)
      target ! msg
    }
  }

  def reactToOneMessage() {}

}
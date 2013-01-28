package chapter32.akka.wiresimulation

import scala.actors._

case class WorkItem (time: Int, msg: Any, target: Actor)

case class AfterDelay(delay: Int, msg: Any, target: Actor)

case object Start
case object Stop

case class Ping (currentTime: Int)
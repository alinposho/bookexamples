package chapter32.akka.wiresimulation

import scala.actors.Actor

case class Ping(time: Int)
case class Pong(time: Int, from: Actor)
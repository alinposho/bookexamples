package actors.in.scala.chapter8.remoteactors.common

import scala.actors.Actor

case class Start(clazz: Class[_ <: Actor])
case object Stop


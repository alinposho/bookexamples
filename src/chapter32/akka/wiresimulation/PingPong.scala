package chapter32.akka.wiresimulation


case class Ping(time: Int)
case class Pong(time: Int, from: Simulant)
package programming.in.scala.chapter13.visibilityandcompanionobjects

class Rocket {
  import Rocket.fuel

  private def canGoHome = fuel > 20
}

object Rocket {
  private def fuel = 10

  def chooseStrategy(rocket: Rocket) {
    if (rocket.canGoHome)
      goHome()
    else
      pickAStar()
  }
  def goHome() { println("Rocket going home"); }
  def pickAStar() { println("Picking a star"); }
  
}
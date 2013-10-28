package scalapuzzlers

object InitYouInitMe extends App {
  // See the explanation here for why this always prints 2 for the first run: http://scalapuzzlers.com/#pzzlr-010
  print(if (math.random > 0.5) XY.X.value else XY.Y.value)
}

object XY {
  object X {
    val value: Int = Y.value + 1
  }
  object Y {
    val value: Int = X.value + 1
  }
}
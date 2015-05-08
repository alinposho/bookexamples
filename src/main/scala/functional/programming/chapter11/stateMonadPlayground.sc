

import functional.programming.chapter11._
import functional.programming.chapter11.State
val rng = Simple(42)
val (random, nextRng) = rng.nextInt
nextRng.nextInt
val s = State[RNG, Int](s => s.nextInt)
s.run(Simple(42))

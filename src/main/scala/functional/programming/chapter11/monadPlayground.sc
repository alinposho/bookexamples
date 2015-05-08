import functional.programming.chapter11._

import Monad._

val hello: Option[String] = Option("Hello Scala")
val res = optionMonad.flatMap(hello)(s => Option(s.length))

optionMonad.unit("ignored") map ( _ + "blah")

None map ("blah")


val lma = 1 to 3 map (Option(_)) toList

for {
  fa <- lma
  a <- fa
} yield a

optionMonad.sequence(lma)

optionMonad.traverse(1 to 5 toList)(Option.apply _)

// List monad samples

val xs = listMonad.unit("blah")
listMonad.map(xs)(_.size)

listMonad.flatMap(xs)(_.map(_.toUpper).toList)

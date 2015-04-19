val a = Option("blah")

None getOrElse "default"

val oe = None.orElse(Some("default"))

// lifting a function

def lift[A, B](f: A => B): Option[A] => Option[B] = _ map f

val sum = (a: Int, b: Int) => a + b

val liftedAbs = lift(math.abs)

liftedAbs(None)

liftedAbs(Option(3))



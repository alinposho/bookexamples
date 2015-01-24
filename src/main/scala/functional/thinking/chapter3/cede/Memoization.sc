
def memoize[A, B](f: A => B) = new (A => B) {
  val cache = scala.collection.mutable.Map[A, B]()

  def apply(x: A): B = cache.getOrElseUpdate(x, f(x))
}

def hash(name: String): String = {
  name.map(c => (((c.toByte - 65 + 13) % 56) + 65).toChar).toString()
}

hash("hello")

def nameHash = memoize(hash)

nameHash("hello")

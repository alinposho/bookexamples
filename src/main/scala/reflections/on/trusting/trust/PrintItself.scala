package reflections.on.trusting.trust

object PrintItself extends App {
  val s = "package reflections.on.trusting.trust  object PrintItself extends App {  val s = \"%s\"  print(s, s)  }"
  printf(s, s)
}
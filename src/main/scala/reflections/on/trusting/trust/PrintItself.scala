package reflections.on.trusting.trust

object PrintItself extends App {
  lazy val s = "package reflections.on.trusting.trust\n\nobject PrintItself extends App {\n  val s = \"%s\"\n    print(s, s)\n}"
  printf(s, s)
}
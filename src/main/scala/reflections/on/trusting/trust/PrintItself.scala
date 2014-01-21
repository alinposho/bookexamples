package reflections.on.trusting.trust

object PrintItself extends App {
  val s = """package reflections.on.trusting.trust

object PrintItself extends App {
  val s = ""\"%s""\"
  printf(s.replace("\\", ""), s)
}
    """
  printf(s.replace("", ""), s)
}
    
package selftyping

trait Selftype {
  blah => // This is similar to saying: blah: Selftype =>

  def smth(): Unit = {
    println("smth")
  }

  def smthElse(): Unit = {
    blah.smth()
  }
}

object SelfTypeWithoutType extends App {
  val selftype = new Selftype {}
  
  selftype.smthElse

}
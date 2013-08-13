package real.world.scala.dependency.injection.no.di

object TestUserRepository {
  def main(args: Array[String]) {
    val us = new UserService(new UserRepository)
    val user = us.authenticate("alin", "password")
    println(s"User returned by the authentication method $user")
  }
}


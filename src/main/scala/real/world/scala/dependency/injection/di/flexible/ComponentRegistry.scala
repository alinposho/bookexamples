package real.world.scala.dependency.injection.di.flexible

import real.world.scala.dependency.injection.no.di.UserRepository
import real.world.scala.dependency.injection.no.di.UserService

object ComponentRegistry extends UserServiceComponent with UserRepositoryComponent {
  val userRepository = new UserRepository
  val userService = new UserService(userRepository)

  def main(args: Array[String]): Unit = {
    userService.authenticate("alin", "pass")
  }
}
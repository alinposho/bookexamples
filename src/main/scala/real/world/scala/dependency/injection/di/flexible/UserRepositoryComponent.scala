package real.world.scala.dependency.injection.di.flexible

import real.world.scala.dependency.injection.no.di.UserRepository

trait UserRepositoryComponent {

  val userRepository: UserRepository
}
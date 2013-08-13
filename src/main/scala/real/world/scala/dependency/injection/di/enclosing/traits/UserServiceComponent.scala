package real.world.scala.dependency.injection.di.enclosing.traits

import real.world.scala.dependency.injection.common.User

trait UserServiceComponent { this: UserRepositoryComponent =>

  val userService = new UserService
  
  class UserService {
    def authenticate(username: String, password: String): User = 
      userRepository.authenticate(new User(username, password))

    def create(username: String, password: String) =
      userRepository.create(new User(username, password))

    def delete(user: User) = userRepository.delete(user)
  }
}
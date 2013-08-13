package real.world.scala.dependency.injection.di.enclosing.traits

import real.world.scala.dependency.injection.common.User

trait UserRepositoryComponent {

  val userRepository = new UserRepository
  
  class UserRepository {
    def authenticate(user: User): User = {
      println("Authenticating user: " + user)
      user
    }
    def create(user: User) = println("Creating user: " + user);
    def delete(user: User) = println("Deleting user: " + user);
  }
}
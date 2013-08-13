package real.world.scala.dependency.injection

class UserService(userRepository: UserRepository) {
  def authenticate(username: String, password: String): User = 
    userRepository.authenticate(new User(username, password))  

  def create(username: String, password: String) = 
    userRepository.create(new User(username, password))

  def delete(user: User) = userRepository.delete(user)
}

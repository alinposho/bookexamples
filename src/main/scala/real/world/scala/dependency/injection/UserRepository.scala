package real.world.scala.dependency.injection
	
class UserRepository {
	def authenticate(user: User): User = {
	  println("Authenticating user: " + user)
	  user
	}
	
	def create(user: User) = println("Creating user: " + user);
	def delete(user: User) = println("Deleting user: " + user);
}
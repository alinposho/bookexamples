package real.world.scala.dependency.injection.precog

import real.world.scala.dependency.injection.common.User

trait StorageComponent {
  def storeUser(user: User)
  def retrieveUser(id: Int): Option[User]
}

trait MySQLStorageComponent extends StorageComponent {
  override def storeUser(user: User) { println("Storing user: " + user) }
  override def retrieveUser(id: Int): Option[User] = Option(User("username", "password"))
}

trait AuthComponent extends StorageComponent {
  def authenticate(id: Int, password: String): Boolean = {
    retrieveUser(id) map { _.password == password } getOrElse false
  }
}

object TheCakePattern extends App {
	val sqlStorage = new MySQLStorageComponent {}
	sqlStorage.storeUser(User("Alin", "pass"))
	
	println(sqlStorage.retrieveUser(8789))
	
	val authComponent = new AuthComponent with MySQLStorageComponent {}
	println("Authenticating user with password \"password\": " + authComponent.authenticate(345, "password"));
}
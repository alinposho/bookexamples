package real.world.scala.dependency.injection.precog.withtypeabstraction

object TheCakePattern extends App {
  val service = new RESTService
  service.doSmth()
}

class RESTService extends MySQLStorageComponent with GravatarComponent {
  type Config = ConfigObj

  override def config = new ConfigObj()

  class ConfigObj extends MySQLConfig with GravatarConfig {
    val mysqlHost = "localhost"
    val mysqlPort = 3336

    val token = "1234cafebabe"
  }

  def doSmth(): Unit = {
    storeUser(User(1989, "somePass".getBytes().toVector))

    val user = retrieveUser(1989)

    println("User avatar URL " + avatarURL(user.get))
  }
}

trait StorageComponent {
  type User <: UserLike

  def storeUser(user: User)
  def retrieveUser(id: Int): Option[User]

  trait UserLike {
    def id: Int
    def hash: Vector[Byte]
  }
}

trait ConfigComponent {
  type Config
  def config: Config
}

trait MySQLStorageComponent extends StorageComponent with ConfigComponent {
  type Config <: MySQLConfig

  override def storeUser(user: User) { println("Storing user: " + user) }
  override def retrieveUser(id: Int): Option[User] = Option(User(id, "password".getBytes().toVector))

  case class User(id: Int, hash: Vector[Byte]) extends UserLike {
    override def toString(): String = {
      val password = new String(hash.toArray)
      "User(" + id + ", " + password + ")" 
    }

  }

  trait MySQLConfig {
    def mysqlHost: String
    def mysqlPort: Int
  }
}

trait GravatarComponent extends StorageComponent {
  type Config <: GravatarConfig

  def avatarURL(user: User): String = {
    println(s"Retrieving Avatart URL for user ${user}")
    s"http://www.avatar.com/${user.id}"
  }

  trait GravatarConfig {
    def token: String
  }
}

/*
 * This class will not compile because there is an illegal cyclic reference in the definition of config.
class RESTService extends MySQLStorageComponent with GravatarComponent {
   type Config = config.type

  override object config extends MySQLConfig with GravatarConfig {
    val mysqlHost = "localhost"
    val mysqlPort = 3336

    val token = "1234cafebabe"
  }
}
  * 
  */

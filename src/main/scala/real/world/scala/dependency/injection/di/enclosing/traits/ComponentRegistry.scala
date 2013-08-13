package real.world.scala.dependency.injection.di.enclosing.traits

import real.world.scala.dependency.injection.common.User

object ComponentRegistry extends UserServiceComponent with UserRepositoryComponent 

object DITest {
  
  def main(args: Array[String]) {
	  import ComponentRegistry._
	  // Notice that we can access the userService instance directly
	  userService.authenticate("alin", "somepass")
	  // But we can also access the userRepository instance
	  userRepository.authenticate(new User("florin", "nirolfpass"))
  }
}



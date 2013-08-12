package actors.in.scala.chapter4.chatwindow

object Main {

  def main(args: Array[String]) {

    // Starting the chatroom
    val chatRoom = new ChatRoom
    chatRoom.start

    val user1 = User("user1")

    //    chatRoom ! Subscribe(user1)
    // Sending a synchronous message
    chatRoom !? Subscribe(user1) match {
      case response: String => println("Received: " + response)
    }

    // An example of Scala's Future usage
    val future = chatRoom !! Subscribe(User("user2"))
    println(future()) //This is where we block waiting for the future's result 

    chatRoom !? UserPost(user1, Post("message from user1")) match {
      case Post(msg) =>
        println("received post message: " + msg + " from " + user1)
    }

    // TO be more explicit about what's the deal with match
    /*
   val response = chatRoom !? UserPost(user1, Post("message from user1"));
    response match {
      case Post(msg) =>
        println("received post message: " + msg + " from " + user1)
    }
     */

    // Doesn't work    
    //    System.exit(1000)
  }

}
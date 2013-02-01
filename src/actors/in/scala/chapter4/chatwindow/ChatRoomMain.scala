package actors.in.scala.chapter4.chatwindow

object Main {

  def main(args: Array[String]) {

    // Starting the chatroom
    val chatRoom = new ChatRoom
    chatRoom.start

    val user1 = User("user1")

    chatRoom ! Subscribe(user1)
  }

}
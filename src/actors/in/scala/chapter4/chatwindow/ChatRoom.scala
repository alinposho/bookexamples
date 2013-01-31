package actors.in.scala.chapter4.chatwindow

import scala.actors.Actor

class ChatRoom extends Actor {
  
  def act() {
    loop {
      receive {
        case Subscribe(user) => // handle user subscription
        case Unsubscribe(user) => // handle unsubscription
        case UserPost(user, msg) => // handle post
      }
    }
    
  }
  
  def main(args: Array[String]) {
    
    // Starting the chatroom
    val chatRoom = new ChatRoom
    chatRoom.start
  }

}
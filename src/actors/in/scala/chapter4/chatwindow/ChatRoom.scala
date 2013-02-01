package actors.in.scala.chapter4.chatwindow

import scala.actors.Actor
import scala.actors.Actor.actor
import scala.actors.Actor.self

class ChatRoom extends Actor {

  var session = Map.empty[User, Actor]

  def act() {
    loop {
      receive {
        case Subscribe(user) =>
          println("received a subsscribe message from user: " + user);
          val sessionUser =
            actor {
        	  while (true) {
        	    self.receive {
        	      case Post(msg) => // send message to sender
        	    }
        	  }
            }
          session += (user -> sessionUser)
        case Unsubscribe(user) => // handle unsubscription
        case UserPost(user, msg) => // handle post
      }
    }

  }

}
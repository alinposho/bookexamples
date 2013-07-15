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
          println("received a subscribe message from user: " + user);
          // Each actor has access to the sender of a message by calling the sender method
          val subscriber = sender
          val sessionUser =
            actor {
              while (true) {
                self.receive {
                  case Post(msg) =>
                    println("received post message: " + msg + " from " + this.sender)
                    subscriber ! Post(msg)
                }
              }
            }
          session += (user -> sessionUser)
          reply("Subscribed " + user)

        case Unsubscribe(user) => // handle unsubscription
        case UserPost(user, msg) =>
          println("session = " + session);
          for (key <- session.keys; if key != user) {
            session(key) ! msg
          }
      }
    }

  }

}
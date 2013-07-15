package actors.in.scala.chapter4.chatwindow

case class User(name: String)
case class Subscribe(user: User)
case class Unsubscribe(user: User)
case class Post(msg: String)
case class UserPost(user: User, post: Post)
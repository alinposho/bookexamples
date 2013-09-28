package scala.by.example.actors.and.messages

import java.util.Date

import akka.actor.ActorRef

abstract class AuctionMessage

case class Offer(bid: Int) extends AuctionMessage
case class Inquire(client: ActorRef) extends AuctionMessage

abstract class AuctionReply
case class Status(asked: Int, maxBidder: ActorRef) extends AuctionReply
case object BestOffer extends AuctionReply
case class BeatenOffer(maxBid: Int) extends AuctionReply
case class AuctionConcluded(seller: ActorRef, client: ActorRef) extends AuctionReply
case object AuctionFailed extends AuctionReply
case object AuctionOver extends AuctionReply

case object EndAuction
package scala.by.example.actors.and.messages

import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.ActorSystem
import akka.actor.Props
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

class Auction(seller: ActorRef, minBid: Int) extends Actor {
  import Auction._
  
  var maxBid = minBid - bidIncrement
  var maxBidder: ActorRef = this.context.system.deadLetters

  def receive = expectBindsOrEnquiries

  def expectBindsOrEnquiries: Receive = {
    case Offer(bid) =>
      val client = sender
      if (bid >= maxBid + bidIncrement) {
        maxBidder ! BeatenOffer(bid)
        maxBidder = client
        maxBid = bid
        client ! BestOffer
      } else {
        client ! BeatenOffer(bid)
      }
    case Inquire(client) =>
      client ! Status(maxBid, maxBidder)
    case EndAuction =>
      if (maxBid >= minBid) {
        val reply = AuctionConcluded(seller, maxBidder)
        seller ! reply
        maxBidder ! reply
      } else {
        seller ! AuctionFailed
      }
      context.become(auctionConcluded)
  }

  def auctionConcluded: Receive = {
    case Inquire(client) =>
      client ! AuctionConcluded(seller: ActorRef, maxBidder: ActorRef)
  }
}

object Auction {

  val bidIncrement = 10;
  
  import Seller._
  import Bidder._

  def main(args: Array[String]) {
    val system = ActorSystem("AuctionActorSystem")

    val seller = system.actorOf(Props[Seller], "Seller")

    val auctionHouse = system.actorOf(Props(classOf[Auction], seller, minSellingPrice), "AuctionHouse")
    val bidder = system.actorOf(Props(classOf[Bidder], auctionHouse), "Bidder")
    
    bidder ! StartBidding
    auctionHouse ! Offer(minSellingPrice + 5)

    auctionHouse ! EndAuction

    system.scheduler.scheduleOnce(5 seconds) {
      system.shutdown
    }
  }
}
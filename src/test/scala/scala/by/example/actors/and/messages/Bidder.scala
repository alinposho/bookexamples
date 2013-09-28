package scala.by.example.actors.and.messages

import akka.actor.ActorLogging
import akka.actor.Actor
import akka.actor.ActorRef
import com.sun.xml.internal.txw2.Content

object Bidder {
  case object StartBidding
}

class Bidder(auctionHouse: ActorRef) extends Actor with ActorLogging {

  import Seller._
  import Auction._
  import Bidder._

  def receive = waitForStart

  def waitForStart: Receive = {
    case StartBidding =>
      auctionHouse ! Offer(minSellingPrice + bidIncrement * 2)
      context.become(waitForBidResponse)
  }
  def waitForBidResponse: Receive = {
    case BestOffer =>
      log.info(s"Wohoo we have the best offer for the item!")
    case BeatenOffer(bid) =>
      log.info(s"Unfortunately this offer ${bid} is better than ours. :(")
    case AuctionConcluded(seller, maxBidder) =>
      log.info(s"Wohoo, we have bought the item from ${seller}!")
  }
}
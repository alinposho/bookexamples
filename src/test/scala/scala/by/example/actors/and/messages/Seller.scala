package scala.by.example.actors.and.messages

import akka.actor.Actor
import akka.actor.ActorLogging

object Seller {
  val minSellingPrice = 1777
}

class Seller extends Actor with ActorLogging {

  import Seller._

  def receive = {
    case AuctionConcluded(maxBid, maxBidder) =>
      log.info(s"Sold the item to ${maxBidder}.")
    case AuctionFailed =>
      log.info(s"It would seem that the item is not worth {$minSellingPrice}")
  }
}
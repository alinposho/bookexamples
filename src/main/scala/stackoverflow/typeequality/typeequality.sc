package stackoverflow.typeequality

object typeequality {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
}

class Root {

  def typed[T](t: => T) {}
}

trait BooleanCompute extends Root {

  trait BOOL {
    type OUT <: BOOL

    type SELECT[TrueAction <: Action, FalseAction <: Action, Action] <: Action
  }

  case class TRUE() extends BOOL {
    type OUT = TRUE

    type SELECT[TrueAction <: Action, FalseAction <: Action, Action] = TrueAction
  }

  case class FALSE() extends BOOL {
    type OUT = FALSE

    type SELECT[TrueAction <: Action, FalseAction <: Action, Action] = FalseAction
  }

}
object BooleanCompute extends BooleanCompute

import BooleanCompute._

case class Equality[A]() {
  def check(x: A)(implicit t: TRUE) = t

  def check[B](x: B)(implicit f: FALSE) = f
}

object Equality {
  def witness[T] = null.asInstanceOf[T]

  implicit val t: TRUE = null
  implicit val f: FALSE = null
}

trait EQ[A, B] extends {

  import Equality._

  type OUT = out.type
  val out = Equality[A]() check witness[B]

  val test1 = Equality[List[Boolean]] check witness[List[Boolean]]
  implicitly[test1.OUT =:= TRUE]
  // Does not compile since tt is True
  //implicitly[test1.t =:= FALSE]

  val test2 = Equality[Nothing] check witness[AnyRef]
  // Does not compile since ft is False
  // implicitly[test2.t =:= TRUE]
  implicitly[test2.OUT =:= FALSE]
}

object HList extends Root {

  type :+:[H, T <: HList] = HCons[H, T]
  val :+: = HCons

  sealed trait HList {
    self: HList =>

    type SELECT[ConsAction <: Action, NilAction <: Action, Action] <: Action

    type Remove[A] <: HList
  }

  final case class HCons[Head, Tail <: HList](head: Head, tail: Tail) extends HList {
    self: HList =>

    type SELECT[ConsAction <: Action, NilAction <: Action, Action] = ConsAction

    type Remove[A] = SELECT[EQ[Head, A]#OUT#SELECT[Tail#Remove[A], Head :+: Tail#Remove[A], HList], HNil, HList]

    def :+:[T](v: T) = HCons(v, this)
  }

  sealed case class HNil() extends HList {
    type SELECT[ConsAction <: Action, NilAction <: Action, Action] = NilAction

    type Remove[A] = HNil

    def :+:[T](v: T) = HCons(v, this)
  }

}

object yo extends App {

  import HList._

  case class AA()
  case class BB()
  case class CC()
  case class DD()

  type YO = AA :+: BB :+: CC :+: HNil
  type YoRemoved = AA :+: CC :+: HNil
  val a = AA() :+: CC() :+: HNil()

  typed[YoRemoved](a)
  //typed[YO#Remove[BB]](a)
}
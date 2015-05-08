package functional.programming.chapter11


case class State[S, A](run: S => (A, S)) {

  def map[B](f: A => B): State[S, B] = {
    State { s =>
      val (a, s1) = run(s)
      (f(a), s1)
    }
  }

  def flatMap[B](f: A => State[S, B]): State[S, B] = {
    State { s =>
      val (a, s1) = run(s)
      f(a).run(s1)
    }
  }

  def get: State[S, S] = State(s => (s, s))

}


object State {
  type IntState[A] = State[Int, A]
}

import State.IntState

object IntStateMonad extends Monad[IntState] {
  def unit[A](a: => A): IntState[A] = State(s => (a, s))
  def flatMap[A,B](st: IntState[A])(f: A => IntState[B]): IntState[B] = st flatMap f
}
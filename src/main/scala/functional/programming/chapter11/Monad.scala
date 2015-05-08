package functional.programming.chapter11

trait Monad[F[_]] extends Functor[F] {
  def unit[A](a: => A): F[A]

  def flatMap[A, B](ma: F[A])(f: A => F[B]): F[B]

  def map[A, B](ma: F[A])(f: A => B): F[B] = flatMap(ma)(a => unit(f(a)))

  def map2[A, B, C](ma: F[A], mb: F[B])(f: (A, B) => C): F[C] = flatMap(ma)(a => map(mb)(b => f(a, b)))

  def sequence[A](lma: List[F[A]]): F[List[A]] = {
    val fEmptyList: F[List[A]] = unit(List.empty[A])
    lma.foldRight(fEmptyList){
      case (fa, fseq) => flatMap(fa)((a: A) => map(fseq)(seq => a :: seq))
    }
  }

  def traverse[A, B](la: List[A])(f: A => F[B]): F[List[B]] = {
    sequence(la map f)
  }
}


object Monad {
  val optionMonad = new Monad[Option] {
    def unit[A](a: => A): Option[A] = Option(a)

    def flatMap[A, B](ma: Option[A])(f: A => Option[B]): Option[B] =
      ma flatMap f
  }
}


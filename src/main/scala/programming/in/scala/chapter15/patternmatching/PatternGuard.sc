package chapter15.patternmatching

import chapter15.caseclasses._

object PatternGuard {

  // Notice the if in the first case statement
  def simplifyAdd(e: Expr) = e match {
    case BinOp("+", x, y) if x == y =>
      BinOp("*", x, Number(2))
    case _ => e
  }                                               //> simplifyAdd: (e: chapter15.caseclasses.Expr)chapter15.caseclasses.Expr
  
  val expr = BinOp("+", Number(3), Number(3))     //> expr  : chapter15.caseclasses.BinOp = BinOp(+,Number(3.0),Number(3.0))
  simplifyAdd(expr)                               //> res0: chapter15.caseclasses.Expr = BinOp(*,Number(3.0),Number(2.0))

}
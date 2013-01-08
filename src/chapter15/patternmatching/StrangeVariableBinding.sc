package chapter15.patternmatching

import chapter15.caseclasses._

object StrangeVariableBinding {

  def exprMatch(expr: Expr) =
    expr match {
      case UnOp("abs", e @ UnOp("abs", _)) => e
      case _ =>
    }                                             //> exprMatch: (expr: chapter15.caseclasses.Expr)Any

	val expr = UnOp("abs", UnOp("abs", BinOp("+", Number(1), Number(2))))
                                                  //> expr  : chapter15.caseclasses.UnOp = UnOp(abs,UnOp(abs,BinOp(+,Number(1.0),N
                                                  //| umber(2.0))))
	
	exprMatch(expr)                           //> res0: Any = UnOp(abs,BinOp(+,Number(1.0),Number(2.0)))

}
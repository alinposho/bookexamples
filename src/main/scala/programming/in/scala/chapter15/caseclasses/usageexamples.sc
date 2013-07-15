package chapter15.caseclasses

object usageexamples {

  val v = Var("x")                                //> v  : chapter15.caseclasses.Var = Var(x)
  val op = BinOp("+", Number(1), v)               //> op  : chapter15.caseclasses.BinOp = BinOp(+,Number(1.0),Var(x))

  op.right == Var("x")                            //> res0: Boolean = true

  // An example of how to copy the contents of a case class
  op.copy()                                       //> res1: chapter15.caseclasses.BinOp = BinOp(+,Number(1.0),Var(x))

  // An example of how to copy only parts of an existing
  // case class
  op.copy(operator = "-")                         //> res2: chapter15.caseclasses.BinOp = BinOp(-,Number(1.0),Var(x))

  def simplifyTop(expr: Expr) = expr match {
    case UnOp("-", UnOp("-", e)) => e // Double negation
    case BinOp("+", e, Number(0)) => e // Adding zero
    case BinOp("*", e, Number(1)) => e // Multiplying by one
    case _ => expr
  }                                               //> simplifyTop: (expr: chapter15.caseclasses.Expr)chapter15.caseclasses.Expr

  simplifyTop(UnOp("-", UnOp("-", Var("x"))))     //> res3: chapter15.caseclasses.Expr = Var(x)

 // No exception is raised when the expression cannot be
 // simplified
  simplifyTop(op)                                 //> res4: chapter15.caseclasses.Expr = BinOp(+,Number(1.0),Var(x))
}
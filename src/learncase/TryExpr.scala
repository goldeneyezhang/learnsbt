package learncase

object TryExpr {
  def main(args: Array[String]): Unit = {
    val v = Var("x")
    val op = BinOp("+", Number(1), v)
    println(op)
    println(op.right == Var("x"))
  }

  def simplifyTop(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e)) => e //双重取负
    case BinOp("+", e, Number(0)) => e //加0
    case BinOp("*", e, Number(1)) => e //乘1
    case _ => expr //啊
  }
}

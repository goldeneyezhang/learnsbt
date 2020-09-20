package learncase

object TryExpr {
  def main(args: Array[String]): Unit = {
    val v = Var("x")
    val op = BinOp("+", Number(1), v)
    println(op)
    println(op.right == Var("x"))
    //Option类型
    val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")
    println(capitals get "France")
    println(capitals get "North Pole")
  }

  def simplifyTop(expr: Expr1): Expr1 = expr match {
    case UnOp("-", UnOp("-", e)) => e //双重取负
    case BinOp("+", e, Number(0)) => e //加0
    case BinOp("*", e, Number(1)) => e //乘1
    case _ => expr //啊
  }

  def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => "?"
  }
}

package learncase

import ele.Element

sealed abstract class Expr

case class Var(name: String) extends Expr;

case class Number(num: Double) extends Expr;

case class UnOp(operator)

class ExprFormatter {
  //包含优先级递增的操作符分组
  private val opGroups =
    Array(
      Set("|", "||"),
      Set("&", "&&"),
      Set("^"),
      Set("==", "!="),
      Set("<", "<=", ">", ">="),
      Set("+", "-"),
      Set("*", "%")
    )
  //从操作符到对应优先级的映射关系
  private val precedence = {
    val assocs =
      for {
        i <- 0 until opGroups.length
        op <- opGroups(i)
      } yield op -> i
    assocs.toMap
  }

  private val unaryPrecedence = opGroups.length
  private val fractionPrecedence = -1

  private def format(e: Expr, enclPrec: Int): Element =

}

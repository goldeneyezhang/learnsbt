object App2 {
  def main(args: Array[String]): Unit = {
    var n = 3+3
    println(n)
    var m = 5 * 5
    println(m)
    var t = 123456789 * 9
    println(t)
    var a = 987654321L * 123456789L
    println(a)

    //7.9 用函数式编程的方式创建乘法表
    println(multiTable())
  }
  //以序列形式返回一行
  def makeRowSeq(row: Int) =
    for(col <- 1 to 10) yield {
      val prod = (row * col).toString()
      val padding = " " * (4 - prod.length)
      padding + prod
    }
  //以字符串形式返回一行
  def makeRow(row: Int) = makeRowSeq(row).mkString

  //以每行占一个文本行的字符串的形式返回表格
  def multiTable() = {
    //字符串的序列
    val tableSeq = for(row <- 1 to 10)
      yield makeRow(row)
    tableSeq.mkString("\n")
  }
}

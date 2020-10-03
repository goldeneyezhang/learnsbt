object App4 {
  def main(args: Array[String]): Unit = {
    val fruit = List("apples", "oranges", "pears")
    val nums = List(1, 2, 3, 4)
    val diag3 = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
    val empty = List()
    //模式匹配
    val List(a, b, c) = fruit
  }

  def isort(xs: List[Int]): List[Int] =
    if (xs.isEmpty) Nil
    else insert(xs.head, xs.tail)

  def insert(x: Int, xs: List[Int]): List[Int] =
    if (xs.isEmpty || x <= xs.head) x :: xs
    else xs.head :: insert(x, xs.tail)

  def isort2(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case x :: xs1 => insert2(x, isort2(xs1))
  }

  def insert2(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if (x <= y) x :: xs
    else y :: insert2(x, ys)
  }

}

object App4 {
  def main(args: Array[String]): Unit = {
    val fruit = List("apples", "oranges", "pears")
    val nums = List(1, 2, 3, 4)
    val diag3 = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
    val empty = List()
    //模式匹配
    val List(a, b, c) = fruit
    System.out.println(diag3.flatten)
    System.out.println(isort2(List(5, 6, 3, 8, 20, 2)))
    System.out.println(fruit zip diag3)
    System.out.println(msort((x: Int, y: Int) => x < y)(List(5, 7, 1, 3)))
    val intSort = msort((x: Int, y: Int) => x < y) _
    val reverseIntSort = msort((x: Int, y: Int) => x > y) _
    val mixedInts = List(4, 1, 9, 0, 5, 8, 3, 6, 2, 7)
    println(intSort(mixedInts))
    println(reverseIntSort(mixedInts))
    println(List(1, 2, 3) map (_ + 1))
    val words = List("the", "quick", "brown", "fox")
    println(words map (_.length))
    println(words map (_.toList.reverse.mkString))
    println(words flatMap (_.toList))
    println(List.range(1, 5) flatMap (i => List.range(1, i) map (j => (i, j))))
    for (i <- List.range(1, 5); j <- List.range(1, i)) yield (i, j)
    var sum = 0
    List(1, 2, 3, 4, 5) foreach (sum += _)
    println(sum)
  }

  /**
   * 插入排序
   *
   * @param xs
   * @return
   */
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

  /**
   *
   * @param less
   * @param xs
   * @tparam T
   * @return
   */
  def msort[T](less: (T, T) => Boolean)
              (xs: List[T]): List[T] = {
    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (less(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }

    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (ys, zs) = xs splitAt n
      merge(msort(less)(ys), msort(less)(zs))
    }
  }
}

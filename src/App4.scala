import scala.collection.immutable.{TreeMap, TreeSet}

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
    println(words.zip(mixedInts))
    println((List(10, 20), List(3, 4, 5)).zipped.map(_ * _))
    val nums1 = List(1) :: List(2)
    println(nums1)
    println(List(1, 2, 3) ::: List(4, 5))
    //统计不同单词的个数
    val text = "See spot run.run,Spot.Run!"
    val wordsArray = text.split("[ !,.]+")
    val words2 = scala.collection.mutable.Set.empty[String]
    for (word <- wordsArray)
      words2 += word.toLowerCase()
    println(words2)
    println(countWords(text))
    val ts = TreeSet(9, 3, 1, 8, 0, 2, 7, 4, 6, 5)
    val cs = TreeSet('f', 'u', 'n')
    val tm = TreeMap(3 -> 'x', 1 -> 'x', 4 -> 'x')
    val longest = longestWord("The quick brown fox".split(" "))
    println(longest)
  }

  def longestWord(words: Array[String]) = {
    var word = words(0)
    var idx = 0
    for (i <- 1 until words.length) {
      if (words(i).length > word.length) {
        word = words(i)
        idx = i
      }
      (word, idx)
    }
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

  def countWords(text: String) = {
    val counts = scala.collection.mutable.Map.empty[String, Int]
    for (rawWord <- text.split("[ ,!.]+")) {
      val word = rawWord.toLowerCase()
      val oldCount =
        if (counts.contains(word)) counts(word)
        else 0
      counts += (word -> (oldCount + 1))
    }
    counts
  }
}

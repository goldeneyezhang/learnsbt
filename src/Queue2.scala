class Queue2[+T] private(
                          private[this] var leading: List[T],
                          private[this] var trailing: List[T]) {
  private def mirror() =
    if (leading.isEmpty) {
      while (!trailing.isEmpty) {
        leading = trailing.head :: leading
        trailing = trailing.tail
      }
    }

  def head: T = {
    mirror()
    leading.head
  }

  def tail: Queue2[T] = {
    mirror()
    new Queue2(leading.tail, trailing)
  }

  def enqueue[U >: T](x: U) =
    new Queue2[U](leading, x :: trailing)

  override def toString: String = {
    for (q <- leading) {
      println(q)
    }
    println("-------")
    for (q <- trailing) {
      println(q)
    }
    super.toString
  }

}

object Queue2 extends App {
  var q1 = List[String]("book1", "book2")
  var q2 = List[String]("book3", "book4")

  var queue2: Queue2[String] = new Queue2[String](q1, q2)
  val q5 = queue2.enqueue("book5")
  val q6 = q5.enqueue("book6")
  val q7 = q6.enqueue("book7")
  println(q7)
}

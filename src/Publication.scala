class Publication(val title: String) {

}

class Book(title: String) extends Publication(title)

object Library {
  val books: Set[Book] =
    Set(
      new Book("Programming in Scala"),
      new Book("Walden")
    )

  //函数的结果类型是协变的,函数的入参是逆变的
  def printBookList(info: Book => AnyRef) = {
    for (book <- books) println(info(book))
  }
}

object Customer extends App {

  def getTitle(p: Publication): String = p.title

  Library.printBookList(getTitle)
}


object App6 extends App {
  for(x <- List(1,2);y <- List("one","two"))
    yield(x,y)
  val xs = List(1,2,3,4,5)
  val git = xs grouped 3
  println(git.next())
  println(git.next())
  val sit = xs sliding 3
  println(sit.next())
  println(sit.next())
}

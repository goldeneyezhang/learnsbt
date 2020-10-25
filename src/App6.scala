import collection.immutable.BitSet

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
  //流
  val str = 1#::2#::3#::Stream.Empty
  println(str)
  println(str.toList)
  //向量
  val vec = scala.collection.immutable.Vector.empty
  val vec2 = vec :+ 1 :+2
  val vec3 = 100 +: vec2
  println(vec3)

  val bits = BitSet(1,2,3)
  println(bits map(_*2))
  println(bits map(_.toFloat))
}

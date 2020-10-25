package rna

object RNAApp extends App {
  val xs = List(A,G,T,A)
  val rn1 = RNA1.fromSeq(xs)
  println(rn1)
  println(rn1.length)
  println(rn1.last)
  println(rn1.take(3))
}

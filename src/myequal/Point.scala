package myequal

import scala.collection.mutable

class Point(val x: Int, val y: Int) {
  override def hashCode(): Int = (x, y).##

  //自生类型
  override def equals(other: Any): Boolean = other match {
    case that: Point => this.x == that.x && this.y == that.y
    case _ => false
  }
}

object Point extends App {
  val p1, p2 = new Point(1, 2)
  val p3 = new Point(2, 3)
  println(p1 equals (p2))
  println(p2 equals (p3))

  val coll = mutable.HashSet(p1)
  println(coll contains (p2))
}
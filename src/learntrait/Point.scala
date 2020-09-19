package learntrait

class Point(val x: Int, val y: Int) {

}


trait Rectangular {
  def topLeft: Point

  def bottomRight: Point

  def left = topLeft.x

  def right = bottomRight.x

  def width = right - left
}

abstract class Component extends Rectangular {

}
// 此处丰富瘦接口
class Rectangle(val topLeft: Point, val bottomRight: Point) extends Rectangular {

}

class Rational(val n: Int, val d: Int) extends Ordered[Rational] {
  override def compare(that: Rational): Int =
    (this.n * that.d) - (that.n * this.d)
}
object Test {
  def main(args: Array[String]): Unit = {
    val rect = new Rectangle(new Point(1, 1), new Point(10, 10))
    println(rect.right)
    println(rect.left)
    println(rect.width)
    val half = new Rational(1, 2)
    val third = new Rational(1, 3)
    println(half < third)
    println(half > third)
  }
}

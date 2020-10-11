

object Imp extends App {
  implicit def doubleToInt(x: Double) = x.toInt

  val i: Int = 3.5

  val oneHalf = new Rational(1, 2)

  implicit def intToRational(x: Int) = new Rational(x, 1)

  println(1 + oneHalf)

  implicit class RectangleMaker(width: Int) {
    def x(height: Int) = Rectangle(width, height)
  }

  val myRectangle = 3 x 4

}

case class Rectangle(width: Int, height: Int)


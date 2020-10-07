trait Abstract {
  type T

  def transform(x: T): T

  val initial: T
  var current: T
}

class Concrete extends Abstract {
  type T = String

  def transform(x: String) = x + x

  override val initial: String = "hi"
  override var current: String = initial
}

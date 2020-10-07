abstract class Fruit {
  val v: String //v表示方法值
  def m: String //m表示方法
}

abstract class Apple extends Fruit {
  val v: String
  val m: String //用val重写（覆盖）def是OK的
}

abstract class BadApple extends Fruit {
  //def v: String // 错误，不用def重写（覆盖）val
  def m: String
}

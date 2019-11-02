class Rational(n: Int, d: Int) {
  println("Created " + n + "/" + d)
  //前置条件
  require(d !=0)
  val numer : Int = n
  val denom : Int = d
  //辅助构造函数
  def this(n: Int) = this(n,1)
  //重写
  override def toString = n + "/" + d

  def add(that: Rational): Rational =
    new Rational(that.denom * numer + that.numer * denom, denom * that.denom)
}

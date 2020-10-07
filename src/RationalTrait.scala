trait RationalTrait {
  val numerArg: Int
  val denomArg: Int
  require(denomArg != 0)
  private val g = gcd(numerArg, denomArg)
  val numer = numerArg / g
  val denom = denomArg / g

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  override def toString: String = numer + "/" + denom
}

object twoThirds extends {
  val numerArg = 2
  val denomArg = 3
} with RationalTrait

class RationalClass(n: Int, d: Int) extends {
  val numerArg = n
  val denomArg = d
} with RationalTrait {
  def +(that: RationalClass) = new RationalClass(
    numer * that.denom + that.numer * denom,
    denom * that.denom
  )
}

object RationalTraitObject extends App {
  val x = 2
  new {
    override val numerArg: Int = 1 * x
    override val denomArg: Int = 2 * x
  }
    with RationalTrait
}

trait LazyRationalTrait {
  val numerArg: Int
  val denomArg: Int
  lazy val numer = numerArg / g
  lazy val denom = denomArg / g

  override def toString: String = numer + "/" + denom

  private lazy val g = {
    require(denomArg != 0)
    gcd(numerArg, denomArg)
  }

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}

object LazyRationalTraitObject extends App {
  val x = 2
  val l = new LazyRationalTrait {
    override val numerArg: Int = 1 * x
    override val denomArg: Int = 2 * x
  }
  println(l)
}
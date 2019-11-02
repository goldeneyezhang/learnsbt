object App {
  def main(args: Array[String]) {
    //字面量
    val hex = 0x5
    println(hex)
    val hex2 = 0x00FF
    println(hex2);
    val magic = 0xcafebabe
    println(magic)
    val dec1 = 31
    val dec2 = 255
    val dec3 = 20
    val prog = 0xCAFEBABEL
    val tower = 35L
    val of = 31l
    println("""Welcome to Ultamix 3000.Type "Help" for help.""")
    println(
      """|Welcome to Ultamix 3000.
         |Type "Help" for help.""".stripMargin)
    //字符串插值
    val name = "reader"
    println(s"Hello, $name!")
    //raw字符串插值
    println(raw"No\\\\escape!")
    //f字符串插值
    println(f"${math.Pi}%.5f")

    //Rational
    val oneHalf = new Rational(1,2)
    println(oneHalf)
    val twoThirds = new Rational(2,3)
    oneHalf add twoThirds
  }
}

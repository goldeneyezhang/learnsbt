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

    val num1 = new Rational(66,42)
    println(num1)

    val num2 = num1 * twoThirds;
    println(num2)

    val num3 = num1 * 7
    println(num3)

    //7。5
    var filesHere = (new java.io.File(".")).listFiles()
    for (file <- filesHere)
      println(file)

    //8.6 部分应用的函数
    val a = sum _
    println(a(1, 2, 3))
    val b = sum(1, _: Int, 3)
    println(b(2))

    //8.7 闭包
    val someNumbers = List(-11, -10, -5, 0, 5, 10)
    var sum1 = 0
    someNumbers.foreach(sum1 += _)
    println(sum1)
  }

  def sum(a: Int, b: Int, c: Int) = a + b + c


}

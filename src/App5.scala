object App5 {
  def main(args: Array[String]): Unit = {
    val account = new BankAccount()
    account deposit 100
    println(account withdraw 80)
    println(account withdraw 80)
    val t = new Thermometer
    t.celsius = 100
    println(t)
  }
}

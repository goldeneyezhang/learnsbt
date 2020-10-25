package extractor

object Domain {
  //注入方法
  def apply(parts:String*): String =
    parts.reverse.mkString(".")

  //提取方法
   def unapplySeq(whole: String):Option[Seq[String]] =
    Some(whole.split("\\.").reverse)

  def isTomInDot(s:String):Boolean = s match {
    case Email("tom",Domain("com",_*)) => true
    case _ => false
  }
}

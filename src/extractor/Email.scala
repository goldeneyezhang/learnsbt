package extractor

object Email {
// 注入方法
  def apply(user:String,domain:String) = user + "@" + domain
  // 提取方法
  def unapply(str:String):Option[(String,String)] = {
    val parts = str split "@"
    if (parts.length == 2) Some(parts(0),parts(1)) else None
  }
}

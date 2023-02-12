package sandbox.忘れそうな構文.抽出子

object EMail {
  def apply(user: String, domain: String): String = user + "@" + domain

  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if (parts.length == 2) Some(parts(0), parts(1)) else None
  }
}

// unapplyがないVer
object EMail2 {
  def apply(user: String, domain: String): String = user + "@" + domain
}

// パターンマッチしたときに値を束縛しないやつ(bool返すだけ)
object UpperCase {
  def unapply(str: String): Boolean = str.toUpperCase == str
}

object Domain {
  def apply(parts: String*): String = parts.reverse.mkString(".")

  // 戻り値がタプルだと要素数が固定されていやなときはunapplySeqを使う
  def unapplySeq(whole: String): Option[Seq[String]] =
    Some(whole.split("\\.").reverse)
}
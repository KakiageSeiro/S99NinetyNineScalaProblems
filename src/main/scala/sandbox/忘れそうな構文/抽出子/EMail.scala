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

// ユーザー定義型を返せる抽出子
object TrueEmailAddressUser {
  class FullNameUser(val user: String) {
    // パターンマッチが成功したかどうかをBooleanで表すisEmpty
    // Emptyの条件(このクラスにマッチしない条件)を書くことに注意
    def isEmpty: Boolean = !user.contains(".") // .で区切りがあったらフルネームということにする
    // 分解後の値を指定するget
    def get: String = user
  }

  // ユーザー定義型を返すよ
  def unapply(target: String): FullNameUser = new FullNameUser(target)
}

object TrueEmailAddressUser2 {
  class FullNameUser(val user: String) {
    def isEmpty: Boolean = !user.contains(".")
    def get: FullNameUser = this

    // ここは任意の名前(firstNameとかにしたかった)にできないので注意
    def _1: String = user.split("\\.")(0)
    def _2: String = user.split("\\.")(1)
  }

  def unapply(target: String): FullNameUser = new FullNameUser(target)
}

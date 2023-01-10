package sandbox.忘れそうな構文

object 九九でyield理解 {

  // 九九の段をSepでもらったのでそれを一行のStringにする
  def makeRow(九九の右辺: Int): String = {
    // 九九の段を作る
    // たとえば引数に1をもらったら["1","2","3"...]みたいなのを空白を入れて返す
    def makeRowSeq(): Seq[String] =
      for (九九の左辺 <- 1 to 10) yield {
        // ↓で外側の関数の引数である"九九の右辺"を使っている
        // このように、ローカル関数では外側の関数のパラメータを使うことができる
        val 計算結果 = (九九の右辺 * 九九の左辺).toString
        val padding = " " * (4 - 計算結果.length)
        padding + 計算結果
      }

    makeRowSeq().mkString
  }

  def multiTable(): String = {
    val tableSeq = // 九九の段リスト
      for (九九の右辺 <- 1 to 10)
        yield makeRow(九九の右辺)

    tableSeq.mkString("\n")
  }
}
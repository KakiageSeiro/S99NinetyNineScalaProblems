package S99NinetyNineScalaProblems

import scala.annotation.tailrec

object P01 {
  def last(list: List[Int]): Int = {
    list.last
  }

  // 解答
  // The standard functional approach is to recurse down the list until we hit
  // the end.  Scala's pattern matching makes this easy.
  // 標準的な関数型アプローチは，リストの末尾に到達するまで再帰的に処理を行うことです．
  // 末尾に当たるまでリストを再帰することです。 Scalaのパターンマッチを使えば、これは簡単です。
  @tailrec // 再起になってないときにコンパイルエラーにしてくれる。末尾最適化も検知してくれそう。
  def lastRecursive[A](ls: List[A]): A = ls match {
    case h :: Nil  => h // 終了条件。要素が無い場合を表す
    case _ :: tail => lastRecursive(tail) // 再起呼び出し。上記以外を表す。_はオルタナティブといい、その他すべてを補足する
    case _         => throw new NoSuchElementException // 上にマッチしない場合はどんなケース？_を使った時点でこちらには来ないのでは？
  }
}
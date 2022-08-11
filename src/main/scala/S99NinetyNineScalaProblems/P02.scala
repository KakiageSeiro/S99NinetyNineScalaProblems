package S99NinetyNineScalaProblems

import java.lang.System.console

// 最後から2番目の要素を取得する
object P02 {
  def penultimate(list: List[Int]): Int = {
    // 最初のn個の要素からなるリストを求め、その最後の要素を取得
    // list.take(list.length - 1).last

    // 指定した要素を取得(0始まり)
    list(list.length - 2)
  }
}
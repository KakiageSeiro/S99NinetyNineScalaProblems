package S99NinetyNineScalaProblems

// 最後から2番目の要素を取得する
object P02 {
  def penultimate(list: List[Int]): Int = {
    list.take(list.length - 2).last
  }
}
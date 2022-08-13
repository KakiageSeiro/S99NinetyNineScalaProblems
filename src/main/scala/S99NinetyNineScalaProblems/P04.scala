package S99NinetyNineScalaProblems

// 要素数を取得する
object P04 {
  def length(list: List[Int]): Int = {
    list.length
  }

  def tatamikomi(list: List[Int]): Int = {
    list.fold(0)((x, y) => x + 1)
  }
}
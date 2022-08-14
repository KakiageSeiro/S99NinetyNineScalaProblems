package S99NinetyNineScalaProblems

// 連続した要素を削除
object P15 {
  def duplicateN(count: Int, list: List[Any]): List[Any] = {
    list.flatMap(e => List.fill(count)(e)) // fillは指定回数要素を増やす
  }
}
package S99NinetyNineScalaProblems

object P15 {
  def duplicateN(count: Int, list: List[Any]): List[Any] = {
    list.flatMap(e => List.fill(count)(e)) // fillは指定回数要素を増やす
  }
}
package S99NinetyNineScalaProblems

// 連続した要素を削除
object P08 {
  def compress(list: List[Any]): List[Any] = {
    list.foldLeft(List[Any]()){(l, r) =>
      if (l.nonEmpty && l.last == r) l
      else l :+ r
    }
  }
}
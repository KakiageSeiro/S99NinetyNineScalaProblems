package S99NinetyNineScalaProblems

// 要素数で昇順ソート
object P28 {
  def lsort[A](list: List[List[A]]): List[List[A]] = {
    list.sorted(Ordering.by[List[A], Int](_.length))
  }
}
package S99NinetyNineScalaProblems

// リスト反転
object P05 {
  def reverse(list: List[Int]): List[Int] = {
    list.reverse
  }

  // 解答。小さいことをうまくやろう。ができてる
  def reverseFunctional[A](ls: List[A]): List[A] =
    ls.foldLeft(List[A]()) { (r, h) => h :: r }

}